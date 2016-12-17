/*    */ package com.hundsun.network.gates.fengshan.biz.enums;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public enum UserRoleEnum
/*    */ {
/* 16 */   COMMON("common", "普通会员"), 
/* 17 */   MIDDLE("middle", "中级会员"), 
/* 18 */   HIGH("high", "高级会员");
/*    */ 
/*    */   private String value;
/*    */   private String name;
/*    */   private static Map<String, UserRoleEnum> pool;
/*    */ 
/*    */   public static UserRoleEnum indexByValue(String value)
/*    */   {
/* 44 */     return (UserRoleEnum)pool.get(value);
/*    */   }
/*    */ 
/*    */   private UserRoleEnum(String value, String name) {
/* 48 */     this.value = value;
/* 49 */     this.name = name;
/*    */   }
/*    */   public String getValue() {
/* 52 */     return this.value;
/*    */   }
/*    */ 
/*    */   public void setValue(String value) {
/* 56 */     this.value = value;
/*    */   }
/*    */ 
/*    */   public String getName() {
/* 60 */     return this.name;
/*    */   }
/*    */ 
/*    */   public void setName(String name) {
/* 64 */     this.name = name;
/*    */   }
/*    */ 
/*    */   static
/*    */   {
/* 31 */     pool = new HashMap();
/*    */ 
/* 33 */     for (UserRoleEnum et : values())
/* 34 */       pool.put(et.value, et);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.enums.UserRoleEnum
 * JD-Core Version:    0.6.0
 */