/*    */ package com.hundsun.eclp.enums;
/*    */ 
/*    */ public enum EnumLoginLogStatus
/*    */ {
/*  5 */   SUCCESS((short)1, "成功"), 
/*  6 */   FAILURE((short)2, "失败");
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
/*    */   private EnumLoginLogStatus(short code, String desc) {
/* 29 */     this.code = code;
/* 30 */     this.desc = desc;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.enums.EnumLoginLogStatus
 * JD-Core Version:    0.6.0
 */