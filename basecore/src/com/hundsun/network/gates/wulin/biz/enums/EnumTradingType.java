/*    */ package com.hundsun.network.gates.wulin.biz.enums;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public enum EnumTradingType
/*    */ {
/* 12 */   PLACE_ORDER("placeOrder", "下单交易"), 
/* 13 */   CHAT_PLACE_ORDER("chatPlaceOrder", "洽谈交易"), 
/* 14 */   BID_ORDER("bidOrder", "竞价交易");
/*    */ 
/*    */   private String value;
/*    */   private String name;
/*    */   private static Map<String, EnumTradingType> pool;
/*    */ 
/*    */   public static EnumTradingType indexByValue(String value)
/*    */   {
/* 36 */     return (EnumTradingType)pool.get(value);
/*    */   }
/*    */ 
/*    */   private EnumTradingType(String value, String name) {
/* 40 */     this.value = value;
/* 41 */     this.name = name;
/*    */   }
/*    */ 
/*    */   public String getValue() {
/* 45 */     return this.value;
/*    */   }
/*    */ 
/*    */   public String getName() {
/* 49 */     return this.name;
/*    */   }
/*    */ 
/*    */   static
/*    */   {
/* 23 */     pool = new HashMap();
/*    */ 
/* 25 */     for (EnumTradingType et : values())
/* 26 */       pool.put(et.value, et);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.enums.EnumTradingType
 * JD-Core Version:    0.6.0
 */