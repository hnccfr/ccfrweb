/*    */ package com.hundsun.network.gates.genshan.biz.enums;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public enum UserStatusEnum
/*    */ {
/* 14 */   NOMAL("N", "正常"), 
/* 15 */   FORBIDDEN("F", "已禁用"), 
/* 16 */   NOACTIVED("O", "待邮箱激活"), 
/* 17 */   UNFUND("U", "待资金账户激活");
/*    */ 
/*    */   private String value;
/*    */   private String name;
/*    */   private static Map<String, UserStatusEnum> pool;
/*    */ 
/*    */   public static UserStatusEnum indexByValue(String value)
/*    */   {
/* 43 */     return (UserStatusEnum)pool.get(value);
/*    */   }
/*    */ 
/*    */   private UserStatusEnum(String value, String name) {
/* 47 */     this.value = value;
/* 48 */     this.name = name;
/*    */   }
/*    */   public String getValue() {
/* 51 */     return this.value;
/*    */   }
/*    */ 
/*    */   public void setValue(String value) {
/* 55 */     this.value = value;
/*    */   }
/*    */ 
/*    */   public String getName() {
/* 59 */     return this.name;
/*    */   }
/*    */ 
/*    */   public void setName(String name) {
/* 63 */     this.name = name;
/*    */   }
/*    */ 
/*    */   static
/*    */   {
/* 30 */     pool = new HashMap();
/*    */ 
/* 32 */     for (UserStatusEnum et : values())
/* 33 */       pool.put(et.value, et);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.enums.UserStatusEnum
 * JD-Core Version:    0.6.0
 */