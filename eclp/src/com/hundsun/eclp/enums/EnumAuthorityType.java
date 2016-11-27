package com.hundsun.eclp.enums;
/*    */ 
/*    */ public enum EnumAuthorityType
/*    */ {
/*  9 */   SYSTEM((short)1, "系统级"), 
/* 10 */   MENU_BAR((short)2, "菜单组"), 
/* 11 */   MENU((short)3, "菜单"), 
/* 12 */   OPERATION((short)4, "操作");
/*    */ 
/*    */   private short code;
/*    */   private String desc;
/*    */ 
/* 19 */   public short getCode() { return this.code; }
/*    */ 
/*    */   public void setCode(short code)
/*    */   {
/* 23 */     this.code = code;
/*    */   }
/*    */ 
/*    */   public String getDesc() {
/* 27 */     return this.desc;
/*    */   }
/*    */ 
/*    */   public void setDesc(String desc) {
/* 31 */     this.desc = desc;
/*    */   }
/*    */ 
/*    */   private EnumAuthorityType(short code, String desc) {
/* 35 */     this.code = code;
/* 36 */     this.desc = desc;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.enums.EnumAuthorityType
 * JD-Core Version:    0.6.0
 */