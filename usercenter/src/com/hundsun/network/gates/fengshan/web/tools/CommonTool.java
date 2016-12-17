/*    */ package com.hundsun.network.gates.fengshan.web.tools;
/*    */ 
/*    */ import com.hundsun.network.melody.common.util.Money;
/*    */ 
/*    */ public class CommonTool
/*    */ {
/*    */   public static String getWebDate(String date)
/*    */   {
/* 18 */     if ((date == null) || (date.length() != 8)) {
/* 19 */       return date;
/*    */     }
/* 21 */     StringBuilder value = new StringBuilder();
/* 22 */     value.append(date.substring(0, 4)).append("-").append(date.substring(4, 6)).append("-").append(date.substring(6, 8));
/*    */ 
/* 24 */     return value.toString();
/*    */   }
/*    */ 
/*    */   public static String getWebDate(Integer date)
/*    */   {
/* 33 */     return getWebDate(date.toString());
/*    */   }
/*    */ 
/*    */   public static String getMoneyDesc(Long money)
/*    */   {
/* 42 */     if (money == null) {
/* 43 */       return "0.00";
/*    */     }
/* 45 */     Money costPriceM = new Money();
/* 46 */     costPriceM.setCent(money.longValue());
/* 47 */     return costPriceM.toString();
/*    */   }
/*    */ 
/*    */   public static String getAbsMoneyDesc(Long money)
/*    */   {
/* 56 */     if (money == null) {
/* 57 */       return "0.00";
/*    */     }
/* 59 */     Money costPriceM = new Money();
/* 60 */     costPriceM.setCent(Math.abs(money.longValue()));
/* 61 */     return costPriceM.toString();
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.web.tools.CommonTool
 * JD-Core Version:    0.6.0
 */