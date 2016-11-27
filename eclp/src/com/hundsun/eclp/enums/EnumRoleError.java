/*    */ package com.hundsun.eclp.enums;
/*    */ 
/*    */ public enum EnumRoleError
/*    */ {
/*  8 */   ROLE_CODE_EXIST(1, "角色代码已存在"), 
/*  9 */   ROLE_DISPLAY_NAME_EXIST(2, "角色名称已存在"), 
/* 10 */   ROLE_CODE_EMPTY(3, "角色代码不能为空"), 
/* 11 */   ROLE_DISPLAY_NAME_EMPTY(4, "角色名称不能为空"), 
/* 12 */   ROLE_CODE_INVALID(5, "角色代码必须为字母或数字或下划线的组合");
/*    */ 
/*    */   private int code;
/*    */   private String errorMessage;
/*    */ 
/* 19 */   public int getCode() { return this.code; }
/*    */ 
/*    */   public void setCode(int code)
/*    */   {
/* 23 */     this.code = code;
/*    */   }
/*    */ 
/*    */   public String getErrorMessage() {
/* 27 */     return this.errorMessage;
/*    */   }
/*    */ 
/*    */   public void setErrorMessage(String errorMessage) {
/* 31 */     this.errorMessage = errorMessage;
/*    */   }
/*    */ 
/*    */   private EnumRoleError(int code, String errorMessage) {
/* 35 */     this.code = code;
/* 36 */     this.errorMessage = errorMessage;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.enums.EnumRoleError
 * JD-Core Version:    0.6.0
 */