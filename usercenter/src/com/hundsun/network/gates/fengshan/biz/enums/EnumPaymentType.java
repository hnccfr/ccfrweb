/*    */ package com.hundsun.network.gates.fengshan.biz.enums;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public enum EnumPaymentType
/*    */ {
/* 13 */   OnLine("OnLine", "线上付款"), OffLine("OffLine", "线下付款");
/*    */ 
/*    */   private String value;
/*    */   private String name;
/*    */   private static Map<String, EnumPaymentType> pool;
/*    */ 
/*    */   public static Map<String, String> toMap()
/*    */   {
/* 30 */     Map enumDataMap = new HashMap();
/* 31 */     for (EnumPaymentType type : values()) {
/* 32 */       enumDataMap.put(type.getValue(), type.getName());
/*    */     }
/* 34 */     return enumDataMap;
/*    */   }
/*    */ 
/*    */   public static EnumPaymentType indexByValue(String value)
/*    */   {
/* 43 */     return (EnumPaymentType)pool.get(value);
/*    */   }
/*    */ 
/*    */   private EnumPaymentType(String value, String name) {
/* 47 */     this.value = value;
/* 48 */     this.name = name;
/*    */   }
/*    */ 
/*    */   public String getValue() {
/* 52 */     return this.value;
/*    */   }
/*    */ 
/*    */   public String getName() {
/* 56 */     return this.name;
/*    */   }
/*    */ 
/*    */   static
/*    */   {
/* 22 */     pool = new HashMap();
/*    */ 
/* 24 */     for (EnumPaymentType et : values())
/* 25 */       pool.put(et.value, et);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.enums.EnumPaymentType
 * JD-Core Version:    0.6.0
 */