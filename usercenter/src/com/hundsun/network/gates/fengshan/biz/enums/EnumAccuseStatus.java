/*    */ package com.hundsun.network.gates.fengshan.biz.enums;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public enum EnumAccuseStatus
/*    */ {
/*  8 */   AUDIT("A", "待审核"), 
/*  9 */   EFFECTIVE("E", "举报有效"), 
/* 10 */   INVALID("I", "举报无效"), 
/* 11 */   UNACCEPT("U", "未采纳");
/*    */ 
/*    */   private String value;
/*    */   private String name;
/*    */   private static Map<String, EnumAccuseStatus> pool;
/*    */ 
/*    */   public static EnumAccuseStatus indexByValue(String value)
/*    */   {
/* 34 */     return (EnumAccuseStatus)pool.get(value);
/*    */   }
/*    */ 
/*    */   private EnumAccuseStatus(String value, String name) {
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
/* 20 */     pool = new HashMap();
/*    */ 
/* 22 */     for (EnumAccuseStatus et : values())
/* 23 */       pool.put(et.value, et);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.enums.EnumAccuseStatus
 * JD-Core Version:    0.6.0
 */