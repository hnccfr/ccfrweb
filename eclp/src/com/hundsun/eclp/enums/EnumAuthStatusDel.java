/*    */ package com.hundsun.eclp.enums;
/*    */ 
/*    */ public enum EnumAuthStatusDel
/*    */ {
/*  5 */   NORMAL("N", "未删除"), 
/*  6 */   DEL("Y", "已删除");
/*    */ 
/*    */   private String code;
/*    */   private String desc;
/*    */ 
/* 13 */   public String getCode() { return this.code; }
/*    */ 
/*    */   public void setCode(String code)
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
/*    */   private EnumAuthStatusDel(String code, String desc) {
/* 29 */     this.code = code;
/* 30 */     this.desc = desc;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.enums.EnumAuthStatusDel
 * JD-Core Version:    0.6.0
 */