/*     */ package com.hundsun.network.gates.genshan.biz.service.baseset.pojo;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.dao.baseset.BaseDayDAO;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.baseset.BaseDay;
/*     */ import com.hundsun.network.gates.genshan.biz.service.BaseService;
/*     */ import com.hundsun.network.gates.genshan.biz.service.baseset.BaseDayService;
/*     */ import com.hundsun.network.gates.genshan.common.DateUtil;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumBaseDayResultErrors;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.BaseDayServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteSystemBaseService;
/*     */ import java.text.ParseException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ @Service("baseDayService")
/*     */ public class BaseDayServiceImpl extends BaseService
/*     */   implements BaseDayService
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private BaseDayDAO baseDayDAO;
/*     */ 
/*     */   @Autowired
/*     */   private RemoteSystemBaseService remoteSystemBaseService;
/*     */ 
/*     */   public List<BaseDay> getBaseDay(BaseDay entity)
/*     */   {
/*  32 */     if (entity == null) {
/*  33 */       return new ArrayList();
/*     */     }
/*  35 */     return this.baseDayDAO.getBaseDay(entity);
/*     */   }
/*     */ 
/*     */   public void addBaseDay(List<Date> list, int nowYear, Date nextTradeDay, String operator) {
/*  39 */     BaseDay param = new BaseDay();
/*  40 */     param.setYear(Integer.valueOf(nowYear));
/*  41 */     param.setDay(nextTradeDay);
/*  42 */     this.baseDayDAO.removeBaseDayByYear(param);
/*  43 */     Calendar cal = Calendar.getInstance();
/*  44 */     for (Date day : list)
/*     */     {
/*  46 */       cal.setTime(day);
/*  47 */       BaseDay baseDay = new BaseDay();
/*  48 */       baseDay.setDay(day);
/*  49 */       baseDay.setMonth(Integer.valueOf(cal.get(2) + 1));
/*  50 */       baseDay.setYear(Integer.valueOf(nowYear));
/*  51 */       baseDay.setOperator(operator);
/*  52 */       this.baseDayDAO.addBaseDay(baseDay);
/*     */     }
/*     */   }
/*     */ 
/*     */   public BaseDayServiceResult addWorkDay(Date startDate, String operator)
/*     */   {
/*  58 */     BaseDayServiceResult result = new BaseDayServiceResult();
/*  59 */     Calendar cal = Calendar.getInstance();
/*  60 */     cal.setTime(startDate);
/*  61 */     int year = cal.get(1);
/*     */     try
/*     */     {
/*  64 */       result = this.remoteSystemBaseService.selectBaseTradeDay();
/*     */     } catch (Exception e) {
/*  66 */       e.printStackTrace();
/*  67 */       if (this.log.isErrorEnabled()) {
/*  68 */         this.log.error("", e);
/*     */       }
/*  70 */       result.setErrorNO(Integer.valueOf(EnumBaseDayResultErrors.SERVER_ERROR.getValue()));
/*  71 */       result.setErrorInfo(EnumBaseDayResultErrors.SERVER_ERROR.getInfo());
/*  72 */       return result;
/*     */     }
/*     */ 
/*  75 */     Date nextTradeDay = result.getNextTradeDay();
/*  76 */     if (null == nextTradeDay) {
/*  77 */       result.setErrorNO(Integer.valueOf(EnumBaseDayResultErrors.NEXT_TRADE_DAY_NULL.getValue()));
/*  78 */       result.setErrorInfo(EnumBaseDayResultErrors.NEXT_TRADE_DAY_NULL.getInfo());
/*  79 */       return result;
/*     */     }
/*     */ 
/*  82 */     Calendar cal2 = Calendar.getInstance();
/*  83 */     cal2.setTime(nextTradeDay);
/*  84 */     int currentYear = cal2.get(1);
/*     */ 
/*  86 */     BaseDay param = new BaseDay();
/*  87 */     param.setYear(Integer.valueOf(year));
/*  88 */     if (year == currentYear) {
/*  89 */       param.setDay(nextTradeDay);
/*  90 */       cal.setTime(nextTradeDay);
/*  91 */       cal.add(5, 1);
/*     */     }
/*  93 */     this.baseDayDAO.removeBaseDayByYear(param);
/*     */ 
/*  95 */     while (cal.get(1) < year + 1) {
/*  96 */       if ((cal.get(7) != 7) && (cal.get(7) != 1)) {
/*  97 */         BaseDay entity = new BaseDay();
/*  98 */         entity.setDay(cal.getTime());
/*  99 */         entity.setMonth(Integer.valueOf(cal.get(2) + 1));
/* 100 */         entity.setYear(Integer.valueOf(cal.get(1)));
/* 101 */         entity.setOperator(operator);
/* 102 */         this.baseDayDAO.addBaseDay(entity);
/*     */       }
/* 104 */       cal.add(5, 1);
/*     */     }
/* 106 */     return result;
/*     */   }
/*     */ 
/*     */   public BaseDayServiceResult getTradeDay() {
/* 110 */     BaseDayServiceResult result = new BaseDayServiceResult();
/*     */     try {
/* 112 */       result = this.remoteSystemBaseService.selectBaseTradeDay();
/*     */     } catch (Exception e) {
/* 114 */       e.printStackTrace();
/* 115 */       if (this.log.isErrorEnabled()) {
/* 116 */         this.log.error("", e);
/*     */       }
/* 118 */       result.setErrorNO(Integer.valueOf(EnumBaseDayResultErrors.SERVER_ERROR.getValue()));
/* 119 */       result.setErrorInfo(EnumBaseDayResultErrors.SERVER_ERROR.getInfo());
/*     */     }
/* 121 */     return result;
/*     */   }
/*     */ 
/*     */   public BaseDayServiceResult initTradeDay(String operator) {
/* 125 */     BaseDayServiceResult result = new BaseDayServiceResult();
/* 126 */     List baseDayList = new ArrayList();
/*     */ 
/* 128 */     Date current = new Date();
/* 129 */     BaseDay currentTradeDa = new BaseDay();
/*     */     try {
/* 131 */       currentTradeDa.setDay(DateUtil.convertStringToDate(DateUtil.convertDateToString(current)));
/*     */     } catch (ParseException e1) {
/* 133 */       e1.printStackTrace();
/* 134 */       result.setErrorNO(Integer.valueOf(EnumBaseDayResultErrors.PARAMETER_ERROR.getValue()));
/* 135 */       result.setErrorInfo(EnumBaseDayResultErrors.PARAMETER_ERROR.getInfo());
/* 136 */       return result;
/*     */     }
/* 138 */     currentTradeDa.setYear(Integer.valueOf(DateUtil.getDateElement(current, "YYYY")));
/* 139 */     currentTradeDa.setMonth(Integer.valueOf(DateUtil.getDateElement(current, "MM")));
/* 140 */     currentTradeDa.setOperator(operator);
/* 141 */     baseDayList.add(currentTradeDa);
/*     */ 
/* 143 */     Date next = new Date(current.getTime() + 86400000L);
/* 144 */     BaseDay nextTradeDay = new BaseDay();
/*     */     try {
/* 146 */       nextTradeDay.setDay(DateUtil.convertStringToDate(DateUtil.convertDateToString(next)));
/*     */     } catch (ParseException e1) {
/* 148 */       e1.printStackTrace();
/* 149 */       result.setErrorNO(Integer.valueOf(EnumBaseDayResultErrors.PARAMETER_ERROR.getValue()));
/* 150 */       result.setErrorInfo(EnumBaseDayResultErrors.PARAMETER_ERROR.getInfo());
/* 151 */       return result;
/*     */     }
/* 153 */     nextTradeDay.setYear(Integer.valueOf(DateUtil.getDateElement(next, "YYYY")));
/* 154 */     nextTradeDay.setMonth(Integer.valueOf(DateUtil.getDateElement(next, "MM")));
/* 155 */     nextTradeDay.setOperator(operator);
/* 156 */     baseDayList.add(nextTradeDay);
/*     */ 
/* 158 */     Date last = new Date(current.getTime() - 86400000L);
/* 159 */     BaseDay lastTradeDa = new BaseDay();
/*     */     try {
/* 161 */       lastTradeDa.setDay(DateUtil.convertStringToDate(DateUtil.convertDateToString(last)));
/*     */     } catch (ParseException e1) {
/* 163 */       e1.printStackTrace();
/* 164 */       result.setErrorNO(Integer.valueOf(EnumBaseDayResultErrors.PARAMETER_ERROR.getValue()));
/* 165 */       result.setErrorInfo(EnumBaseDayResultErrors.PARAMETER_ERROR.getInfo());
/* 166 */       return result;
/*     */     }
/* 168 */     lastTradeDa.setYear(Integer.valueOf(DateUtil.getDateElement(last, "YYYY")));
/* 169 */     lastTradeDa.setMonth(Integer.valueOf(DateUtil.getDateElement(last, "MM")));
/* 170 */     lastTradeDa.setOperator(operator);
/* 171 */     baseDayList.add(lastTradeDa);
/*     */     try
/*     */     {
/* 174 */       this.baseDayDAO.addBaseDay(baseDayList);
/*     */     } catch (Exception e) {
/* 176 */       e.printStackTrace();
/* 177 */       if (this.log.isErrorEnabled()) {
/* 178 */         this.log.error("", e);
/*     */       }
/* 180 */       result.setErrorNO(Integer.valueOf(EnumBaseDayResultErrors.INTERNAL_ERROR.getValue()));
/* 181 */       result.setErrorInfo(EnumBaseDayResultErrors.INTERNAL_ERROR.getInfo());
/*     */     }
/* 183 */     return result;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.service.baseset.pojo.BaseDayServiceImpl
 * JD-Core Version:    0.6.0
 */