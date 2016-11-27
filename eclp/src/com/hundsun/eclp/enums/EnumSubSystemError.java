/*    */ package com.hundsun.eclp.enums;
/*    */ 
/*    */ public enum EnumSubSystemError
/*    */ {
/*  8 */   SUB_SYSTEM_NAME_EXIST(1, "子系统代码已存在"), 
/*  9 */   SUB_SYSTEM_FULL_NAME_EXIST(2, "子系统名称已存在"), 
/* 10 */   SUB_SYSTEM_NAME_EMPTY(3, "子系统代码不能为空"), 
/* 11 */   SUB_SYSTEM_FULL_NAME_EMPTY(4, "子系统名称不能为空"), 
/* 12 */   SUB_SYSTEM_NAME_INVALID(5, "子系统代码不能有中文,必须为字母和数字"), 
/* 13 */   SUB_SYSTEM_HAS_CHILD_AUTH(6, "该子系统下有子权限,不能修改'进入方式'");
/*    */ 
/*    */   private int code;
/*    */   private String errorMessage;
/*    */ 
/* 20 */   public int getCode() { return this.code; }
/*    */ 
/*    */   public void setCode(int code)
/*    */   {
/* 24 */     this.code = code;
/*    */   }
/*    */ 
/*    */   public String getErrorMessage() {
/* 28 */     return this.errorMessage;
/*    */   }
/*    */ 
/*    */   public void setErrorMessage(String errorMessage) {
/* 32 */     this.errorMessage = errorMessage;
/*    */   }
/*    */ 
/*    */   private EnumSubSystemError(int code, String errorMessage) {
/* 36 */     this.code = code;
/* 37 */     this.errorMessage = errorMessage;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.enums.EnumSubSystemError
 * JD-Core Version:    0.6.0
 */