/*    */ package com.hundsun.network.gates.fengshan.biz.enums;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public enum EnumUserCategory
/*    */ {
/*  7 */   USER("USER", "普通用户"), 
/*  8 */   SERVICE("service", "服务中心"), 
/*  9 */   SYSTEM("system", "系统用户");
/*    */ 
/*    */   private String value;
/*    */   private String name;
/*    */   private static Map<String, EnumUserCategory> pool;
/*    */ 
/*    */   public static EnumUserCategory indexByValue(String value)
/*    */   {
/* 31 */     return (EnumUserCategory)pool.get(value);
/*    */   }
/*    */ 
/*    */   private EnumUserCategory(String value, String name) {
/* 35 */     this.value = value;
/* 36 */     this.name = name;
/*    */   }
/*    */ 
/*    */   public String getValue() {
/* 40 */     return this.value;
/*    */   }
/*    */ 
/*    */   public void setValue(String value) {
/* 44 */     this.value = value;
/*    */   }
/*    */ 
/*    */   public String getName() {
/* 48 */     return this.name;
/*    */   }
/*    */ 
/*    */   public void setName(String name) {
/* 52 */     this.name = name;
/*    */   }
/*    */ 
/*    */   static
/*    */   {
/* 18 */     pool = new HashMap();
/*    */ 
/* 20 */     for (EnumUserCategory et : values())
/* 21 */       pool.put(et.value, et);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.enums.EnumUserCategory
 * JD-Core Version:    0.6.0
 */