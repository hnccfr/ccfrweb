/*    */ package com.hundsun.network.gates.fengshan.biz.enums;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public enum UserTypeEnum
/*    */ {
/*  7 */   PERSONAL("P", "个人用户"), ENTERPRISE("C", "企业用户");
/*    */ 
/*    */   private String value;
/*    */   private String name;
/*    */   private static Map<String, UserTypeEnum> pool;
/*    */ 
/*    */   public static UserTypeEnum indexByValue(String value)
/*    */   {
/* 29 */     return (UserTypeEnum)pool.get(value);
/*    */   }
/*    */ 
/*    */   private UserTypeEnum(String value, String name) {
/* 33 */     this.value = value;
/* 34 */     this.name = name;
/*    */   }
/*    */ 
/*    */   public String getValue() {
/* 38 */     return this.value;
/*    */   }
/*    */ 
/*    */   public void setValue(String value) {
/* 42 */     this.value = value;
/*    */   }
/*    */ 
/*    */   public String getName() {
/* 46 */     return this.name;
/*    */   }
/*    */ 
/*    */   public void setName(String name) {
/* 50 */     this.name = name;
/*    */   }
/*    */ 
/*    */   static
/*    */   {
/* 16 */     pool = new HashMap();
/*    */ 
/* 18 */     for (UserTypeEnum et : values())
/* 19 */       pool.put(et.value, et);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.enums.UserTypeEnum
 * JD-Core Version:    0.6.0
 */