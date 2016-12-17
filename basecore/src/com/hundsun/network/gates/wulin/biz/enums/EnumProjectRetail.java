/*    */ package com.hundsun.network.gates.wulin.biz.enums;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public enum EnumProjectRetail
/*    */ {
/* 14 */   Y("Y", "零售"), 
/* 15 */   N("N", "整包销售");
/*    */ 
/*    */   private String value;
/*    */   private String name;
/*    */   private static Map<String, EnumProjectRetail> pool;
/*    */ 
/*    */   public static EnumProjectRetail indexByValue(String value)
/*    */   {
/* 38 */     return (EnumProjectRetail)pool.get(value);
/*    */   }
/*    */ 
/*    */   private EnumProjectRetail(String value, String name) {
/* 42 */     this.value = value;
/* 43 */     this.name = name;
/*    */   }
/*    */ 
/*    */   public String getValue() {
/* 47 */     return this.value;
/*    */   }
/*    */ 
/*    */   public String getName() {
/* 51 */     return this.name;
/*    */   }
/*    */ 
/*    */   static
/*    */   {
/* 25 */     pool = new HashMap();
/*    */ 
/* 27 */     for (EnumProjectRetail et : values())
/* 28 */       pool.put(et.value, et);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.enums.EnumProjectRetail
 * JD-Core Version:    0.6.0
 */