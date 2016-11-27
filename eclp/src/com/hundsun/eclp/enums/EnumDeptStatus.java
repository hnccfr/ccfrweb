/*    */ package com.hundsun.eclp.enums;
/*    */ 
/*    */ public enum EnumDeptStatus
/*    */ {
/*  5 */   USE((short)1, "启用"), 
/*  6 */   DISUSE((short)0, "禁用");
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
/*    */   private EnumDeptStatus(short code, String desc) {
/* 29 */     this.code = code;
/* 30 */     this.desc = desc;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.enums.EnumDeptStatus
 * JD-Core Version:    0.6.0
 */