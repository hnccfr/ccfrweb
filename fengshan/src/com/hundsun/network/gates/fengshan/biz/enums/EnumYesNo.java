/*    */ package com.hundsun.network.gates.fengshan.biz.enums;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public enum EnumYesNo
/*    */ {
/* 13 */   Y("Y", "是"), N("N", "否");
/*    */ 
/*    */   private String value;
/*    */   private String name;
/*    */   private static Map<String, EnumYesNo> pool;
/*    */ 
/*    */   public static EnumYesNo indexByValue(String value)
/*    */   {
/* 35 */     return (EnumYesNo)pool.get(value);
/*    */   }
/*    */ 
/*    */   private EnumYesNo(String value, String name) {
/* 39 */     this.value = value;
/* 40 */     this.name = name;
/*    */   }
/*    */ 
/*    */   public String getValue() {
/* 44 */     return this.value;
/*    */   }
/*    */ 
/*    */   public String getName() {
/* 48 */     return this.name;
/*    */   }
/*    */ 
/*    */   static
/*    */   {
/* 22 */     pool = new HashMap();
/*    */ 
/* 24 */     for (EnumYesNo et : values())
/* 25 */       pool.put(et.value, et);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.enums.EnumYesNo
 * JD-Core Version:    0.6.0
 */