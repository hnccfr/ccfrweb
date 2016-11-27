/*    */ package com.hundsun.eclp.enums;
/*    */ 
/*    */ public enum EnumUserInfoStatus
/*    */ {
/*  4 */   ENABLE((short)1, "启用"), 
/*  5 */   DISABLE((short)0, "禁用"), 
/*  6 */   DELETE((short)2, "删除");
/*    */ 
/*    */   private short code;
/*    */   private String desc;
/*    */ 
/* 13 */   public short getCode() { return this.code; }
/*    */ 
/*    */   public void setCode(short code)
/*    */   {
/* 17 */     this.code = code;
/*    */   }
/*    */ 
/*    */   public String getDesc() {
/* 21 */     return this.desc;
/*    */   }
/*    */ 
/*    */   public void setDesc(String desc) {
/* 25 */     this.desc = desc;
/*    */   }
/*    */ 
/*    */   private EnumUserInfoStatus(short code, String desc) {
/* 29 */     this.code = code;
/* 30 */     this.desc = desc;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.enums.EnumUserInfoStatus
 * JD-Core Version:    0.6.0
 */