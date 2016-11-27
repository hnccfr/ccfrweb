/*    */ package com.hundsun.network.gates.fengshan.biz.enums;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public enum EnumListingType
/*    */ {
/* 13 */   BUY("buy", "买牌"), SELL("sell", "卖牌");
/*    */ 
/*    */   private String value;
/*    */   private String name;
/*    */   private static Map<String, EnumListingType> pool;
/*    */ 
/*    */   public static EnumListingType indexByValue(String value)
/*    */   {
/* 34 */     return (EnumListingType)pool.get(value);
/*    */   }
/*    */ 
/*    */   private EnumListingType(String value, String name) {
/* 38 */     this.value = value;
/* 39 */     this.name = name;
/*    */   }
/*    */ 
/*    */   public String getValue() {
/* 43 */     return this.value;
/*    */   }
/*    */ 
/*    */   public String getName() {
/* 47 */     return this.name;
/*    */   }
/*    */ 
/*    */   static
/*    */   {
/* 21 */     pool = new HashMap();
/*    */ 
/* 23 */     for (EnumListingType et : values())
/* 24 */       pool.put(et.value, et);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.enums.EnumListingType
 * JD-Core Version:    0.6.0
 */