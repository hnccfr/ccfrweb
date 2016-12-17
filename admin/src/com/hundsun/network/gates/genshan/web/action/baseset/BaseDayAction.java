/*     */ package com.hundsun.network.gates.genshan.web.action.baseset;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.domain.baseset.BaseDay;
/*     */ import com.hundsun.network.gates.genshan.biz.service.baseset.BaseDayService;
/*     */ import com.hundsun.network.gates.genshan.common.UserAgent;
/*     */ import com.hundsun.network.gates.genshan.security.AdminAccess;
/*     */ import com.hundsun.network.gates.genshan.web.action.BaseAction;
/*     */ import com.hundsun.network.gates.luosi.common.utils.DateUtil;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumBaseDayResultErrors;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.BaseDayServiceResult;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.text.ParseException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.Collections;
/*     */ import java.util.Date;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.commons.lang.math.NumberUtils;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ 
/*     */ @Controller
/*     */ public class BaseDayAction extends BaseAction
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private BaseDayService baseDayService;
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.SYS_R_BASEDAY_LIST})
/*     */   @RequestMapping({"/baseset/baseday/list"})
/*     */   public String list(HttpServletRequest request, ModelMap model)
/*     */   {
/*  49 */     int year = 0;
/*  50 */     String yearStr = request.getParameter("year");
/*  51 */     if ((StringUtil.isBlank(yearStr)) || (Integer.parseInt(yearStr) == Calendar.getInstance().get(1)))
/*     */     {
/*  53 */       Calendar cal = Calendar.getInstance();
/*  54 */       year = cal.get(1);
/*  55 */       model.addAttribute("hasPrevious", Boolean.valueOf(false));
/*     */     } else {
/*  57 */       year = Integer.parseInt(yearStr);
/*  58 */       model.addAttribute("hasPrevious", Boolean.valueOf(true));
/*     */     }
/*  60 */     BaseDayServiceResult tradeDayInfo = this.baseDayService.getTradeDay();
/*  61 */     if ((null == tradeDayInfo) || (!tradeDayInfo.correct()))
/*     */     {
/*  63 */       if (EnumBaseDayResultErrors.CURRENT_TRADE_DAY_NULL.getValue() == tradeDayInfo.getErrorNO().intValue())
/*     */       {
/*  65 */         model.addAttribute("message", EnumBaseDayResultErrors.CURRENT_TRADE_DAY_NULL.getInfo());
/*  66 */         return "/baseset/baseday/init";
/*     */       }
/*  68 */       model.addAttribute("url", "/baseset/baseday/list");
/*  69 */       return error(model, "admin.base.baseday.error.select.curretnTradeDayInfo", new String[0]);
/*     */     }
/*     */ 
/*  72 */     BaseDay entity = new BaseDay();
/*  73 */     entity.setYear(Integer.valueOf(year));
/*  74 */     List<BaseDay> list = this.baseDayService.getBaseDay(entity);
/*  75 */     StringBuffer dates = new StringBuffer();
/*  76 */     for (BaseDay day : list) {
/*  77 */       dates.append(day.getDayStr()).append(",");
/*     */     }
/*  79 */     model.addAttribute("dates", dates.toString());
/*  80 */     model.addAttribute("year", Integer.valueOf(year));
/*  81 */     model.addAttribute("tradeDayInfo", tradeDayInfo);
/*  82 */     return "/baseset/baseday/list";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.SYS_U_BASEDAY_UPDATE})
/*     */   @RequestMapping({"/baseset/baseday/edit"})
/*     */   public String edit(HttpServletRequest request, UserAgent userAgent, ModelMap model)
/*     */   {
/*  93 */     String datesStr = request.getParameter("dates");
/*  94 */     String year = request.getParameter("year");
/*  95 */     if ((StringUtil.isBlank(year)) || (!NumberUtils.isDigits(year))) {
/*  96 */       return error(model, "admin.base.baseday.param.error", new String[0]);
/*     */     }
/*  98 */     List list = new ArrayList();
/*  99 */     Date nextTD = null;
/*     */ 
/* 101 */     if (StringUtil.isNotBlank(datesStr)) {
/* 102 */       String[] dates = datesStr.split(",");
/*     */ 
/* 104 */       BaseDayServiceResult tradeDayInfo = this.baseDayService.getTradeDay();
/* 105 */       if ((null == tradeDayInfo) || (!tradeDayInfo.correct()))
/*     */       {
/* 107 */         model.addAttribute("url", "/baseset/baseday/list");
/* 108 */         return error(model, "admin.base.baseday.error.select.curretnTradeDayInfo", new String[0]);
/*     */       }
/* 110 */       Date lastTradeDay = tradeDayInfo.getLastTradeDay();
/* 111 */       Date curretnTradeDay = tradeDayInfo.getCurrentTradeDay();
/* 112 */       Date nextTradeDay = tradeDayInfo.getNextTradeDay();
/* 113 */       nextTD = tradeDayInfo.getNextTradeDay();
/*     */ 
/* 115 */       Calendar cal = Calendar.getInstance();
/* 116 */       cal.setTime(nextTradeDay);
/* 117 */       int currentYear = cal.get(1);
/* 118 */       boolean isCurrentYear = false;
/*     */ 
/* 120 */       if (Integer.parseInt(year) == currentYear) {
/* 121 */         isCurrentYear = true;
/*     */       }
/* 123 */       boolean isCancel = true;
/* 124 */       boolean isCurrentCancel = true;
/* 125 */       for (int i = 0; i < dates.length; i++) {
/* 126 */         if (StringUtil.isBlank(dates[i]))
/*     */           continue;
/* 128 */         Long timeMills = Long.valueOf(Long.parseLong(dates[i]));
/* 129 */         cal.setTimeInMillis(timeMills.longValue());
/* 130 */         Date date = cal.getTime();
/* 131 */         if ((date.before(nextTradeDay)) && (!date.equals(curretnTradeDay)) && (!date.equals(lastTradeDay)))
/*     */         {
/* 133 */           model.addAttribute("url", "/baseset/baseday/list");
/* 134 */           return error(model, "admin.base.baseday.edit.nextTradeDayBefore", new String[0]);
/*     */         }
/* 136 */         if (date.equals(curretnTradeDay)) {
/* 137 */           isCurrentCancel = false;
/*     */         }
/* 140 */         else if (date.equals(nextTradeDay)) {
/* 141 */           isCancel = false;
/*     */         }
/*     */         else
/* 144 */           list.add(cal.getTime());
/*     */       }
/* 146 */       if ((isCancel) && (isCurrentYear)) {
/* 147 */         model.addAttribute("url", "/baseset/baseday/list");
/* 148 */         return error(model, "admin.base.baseday.edit.nextTradeDay", new String[0]);
/*     */       }
/* 150 */       Calendar today = Calendar.getInstance();
/* 151 */       today.set(today.get(1), today.get(2), today.get(5), 0, 0, 0);
/*     */ 
/* 153 */       today.set(14, 0);
/* 154 */       boolean isSameYear = false;
/* 155 */       Calendar cal2 = Calendar.getInstance();
/* 156 */       cal2.setTime(curretnTradeDay);
/* 157 */       if (cal2.get(1) == Integer.parseInt(year))
/* 158 */         isSameYear = true;
/* 159 */       if ((isCurrentCancel) && (!today.getTime().equals(curretnTradeDay)) && (isSameYear)) {
/* 160 */         model.addAttribute("url", "/baseset/baseday/list");
/* 161 */         return error(model, "admin.base.baseday.edit.curretnTradeDay", new String[0]);
/*     */       }
/*     */     }
/*     */ 
/* 165 */     HashSet h = new HashSet(list);
/* 166 */     list.clear();
/* 167 */     list.addAll(h);
/* 168 */     Collections.sort(list);
/* 169 */     this.baseDayService.addBaseDay(list, Integer.parseInt(year), nextTD, userAgent.getUserAccount());
/* 170 */     model.addAttribute("url", "/baseset/baseday/list");
/* 171 */     model.addAttribute("urlParas", "year=" + year);
/* 172 */     return success(model, "admin.base.baseday.edit.success", new String[0]);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.SYS_U_BASEDAY_UPDATE})
/*     */   @RequestMapping({"/baseset/baseday/add_work_day"})
/*     */   public String addWorkDay(HttpServletRequest request, UserAgent userAgent, ModelMap model)
/*     */   {
/* 184 */     String startDateStr = request.getParameter("startDate");
/* 185 */     if (StringUtil.isBlank(startDateStr)) {
/* 186 */       return error(model, "admin.base.baseday.addworkday.param.error", new String[0]);
/*     */     }
/* 188 */     Date startDate = null;
/*     */     try {
/* 190 */       startDate = DateUtil.convertStringToDate(startDateStr);
/*     */     } catch (ParseException e) {
/* 192 */       e.printStackTrace();
/* 193 */       if (this.log.isErrorEnabled()) {
/* 194 */         this.log.error("", e);
/*     */       }
/* 196 */       return error(model, "admin.base.baseday.param.error", new String[0]);
/*     */     }
/* 198 */     BaseDayServiceResult result = this.baseDayService.addWorkDay(startDate, userAgent.getUserAccount());
/* 199 */     if (!result.correct()) {
/* 200 */       model.addAttribute("message", result.getErrorInfo());
/* 201 */       return "error";
/*     */     }
/*     */ 
/* 205 */     Calendar cal = Calendar.getInstance();
/* 206 */     cal.setTime(startDate);
/* 207 */     model.addAttribute("url", "/baseset/baseday/list");
/* 208 */     model.addAttribute("urlParas", "year=" + cal.get(1));
/* 209 */     return success(model, "admin.base.baseday.addworkday.success", new String[0]);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.SYS_C_BASEDAY_INIT})
/*     */   @RequestMapping(value={"/baseset/baseday/init"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String init(UserAgent userAgent, ModelMap model)
/*     */   {
/* 220 */     BaseDayServiceResult result = this.baseDayService.initTradeDay(userAgent.getUserAccount());
/* 221 */     if (!result.correct())
/* 222 */       model.addAttribute("message", "fail");
/*     */     else {
/* 224 */       model.addAttribute("message", "success");
/*     */     }
/* 226 */     return "/baseset/baseday/init";
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.action.baseset.BaseDayAction
 * JD-Core Version:    0.6.0
 */