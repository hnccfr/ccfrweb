/*    */ package com.hundsun.network.gates.genshan.biz.enums;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public enum UserTypeEnum
/*    */ {
/* 14 */   PERSONAL("P", "个人用户"), 
/* 15 */   ENTERPRISE("C", "企业用户");
/*    */ 
/*    */   private String value;
/*    */   private String name;
/*    */   private static Map<String, UserTypeEnum> pool;
/*    */ 
/*    */   public static UserTypeEnum indexByValue(String value)
/*    */   {
/* 41 */     return (UserTypeEnum)pool.get(value);
/*    */   }
/*    */ 
/*    */   private UserTypeEnum(String value, String name) {
/* 45 */     this.value = value;
/* 46 */     this.name = name;
/*    */   }
/*    */   public String getValue() {
/* 49 */     return this.value;
/*    */   }
/*    */ 
/*    */   public void setValue(String value) {
/* 53 */     this.value = value;
/*    */   }
/*    */ 
/*    */   public String getName() {
/* 57 */     return this.name;
/*    */   }
/*    */ 
/*    */   public void setName(String name) {
/* 61 */     this.name = name;
/*    */   }
/*    */ 
/*    */   static
/*    */   {
/* 28 */     pool = new HashMap();
/*    */ 
/* 30 */     for (UserTypeEnum et : values())
/* 31 */       pool.put(et.value, et);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.enums.UserTypeEnum
 * JD-Core Version:    0.6.0
 */