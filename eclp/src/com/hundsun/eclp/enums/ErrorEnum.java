/*    */ package com.hundsun.eclp.enums;
/*    */ 
/*    */ public enum ErrorEnum
/*    */ {
/* 13 */   INCORRECT_CHECK_CODE_ERROR(301, "验证码不正确"), 
/* 14 */   INCORRECT_USERNAME_OR_PASSWORD_ERROR(302, "用户名或密码不正确"), 
/* 15 */   INCORRECT_CHECK_DEL_STATUS_ERROR(303, "用户已删除"), 
/* 16 */   INCORRECT_CHECK_DISUSE_STATUS_ERROR(304, "用户已禁用"), 
/* 17 */   INCORRECT_USERNAME_ERROR(305, "用户名不正确");
/*    */ 
/*    */   private int code;
/*    */   private String desc;
/*    */ 
/* 20 */   private ErrorEnum(int code, String desc) { this.code = code;
/* 21 */     this.desc = desc;
/*    */   }
/*    */ 
/*    */   public int getCode()
/*    */   {
/* 29 */     return this.code;
/*    */   }
/*    */ 
/*    */   public void setCode(int code) {
/* 33 */     this.code = code;
/*    */   }
/*    */ 
/*    */   public String getDesc() {
/* 37 */     return this.desc;
/*    */   }
/*    */ 
/*    */   public void setDesc(String desc) {
/* 41 */     this.desc = desc;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.enums.ErrorEnum
 * JD-Core Version:    0.6.0
 */