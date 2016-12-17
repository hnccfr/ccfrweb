/*    */ package com.hundsun.network.gates.wulin.biz.service.pojo.baseset;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumBaseDayResultErrors;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.result.BaseDayServiceResult;
/*    */ import com.hundsun.network.gates.wulin.biz.dao.baseset.BaseDayDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.baseset.BaseDay;
/*    */ import com.hundsun.network.gates.wulin.biz.service.BaseService;
/*    */ import com.hundsun.network.gates.wulin.biz.service.baseset.BaseDayService;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("baseService")
/*    */ public class BaseDayServiceImpl extends BaseService
/*    */   implements BaseDayService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private BaseDayDAO baseDayDAO;
/*    */ 
/*    */   public BaseDay getCurrentBaseDay()
/*    */   {
/* 24 */     return this.baseDayDAO.getCurrentBaseDay();
/*    */   }
/*    */ 
/*    */   public BaseDay getNextBaseDay()
/*    */   {
/* 29 */     Map paramMap = new HashMap();
/* 30 */     paramMap.put("daySum", Long.valueOf(1L));
/* 31 */     return this.baseDayDAO.getNextBaseDay(paramMap);
/*    */   }
/*    */ 
/*    */   public BaseDay getNextBaseDay(Long daySum)
/*    */   {
/* 36 */     Map paramMap = new HashMap();
/* 37 */     paramMap.put("daySum", daySum);
/* 38 */     return this.baseDayDAO.getNextBaseDay(paramMap);
/*    */   }
/*    */ 
/*    */   public BaseDay getPrevBaseDay(Long daySum)
/*    */   {
/* 43 */     Map paramMap = new HashMap();
/* 44 */     paramMap.put("daySum", daySum);
/* 45 */     return this.baseDayDAO.getPrevBaseDay(paramMap);
/*    */   }
/*    */ 
/*    */   public BaseDay getPrevBaseDay()
/*    */   {
/* 50 */     Map paramMap = new HashMap();
/* 51 */     paramMap.put("daySum", Long.valueOf(1L));
/* 52 */     return this.baseDayDAO.getPrevBaseDay(paramMap);
/*    */   }
/*    */ 
/*    */   public BaseDayServiceResult selectBaseTradeDay()
/*    */   {
/* 57 */     BaseDayServiceResult result = new BaseDayServiceResult();
/* 58 */     BaseDay currentDay = getCurrentBaseDay();
/* 59 */     if (null == currentDay) {
/* 60 */       result.setErrorNOInfo(Integer.valueOf(EnumBaseDayResultErrors.CURRENT_TRADE_DAY_NULL.getValue()), EnumBaseDayResultErrors.CURRENT_TRADE_DAY_NULL.getInfo());
/*    */ 
/* 62 */       return result;
/*    */     }
/* 64 */     result.setCurrentTradeDay(currentDay.getDay());
/* 65 */     BaseDay prevDay = getPrevBaseDay();
/* 66 */     if (null != prevDay) {
/* 67 */       result.setLastTradeDay(prevDay.getDay());
/*    */     }
/* 69 */     BaseDay nextDay = getNextBaseDay();
/* 70 */     if (null == nextDay) {
/* 71 */       result.setErrorNOInfo(Integer.valueOf(EnumBaseDayResultErrors.NEXT_TRADE_DAY_NULL.getValue()), EnumBaseDayResultErrors.NEXT_TRADE_DAY_NULL.getInfo());
/*    */ 
/* 73 */       return result;
/*    */     }
/* 75 */     result.setNextTradeDay(nextDay.getDay());
/* 76 */     return result;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.pojo.baseset.BaseDayServiceImpl
 * JD-Core Version:    0.6.0
 */