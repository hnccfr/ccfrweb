/*    */ package com.hundsun.eclp.enums;
/*    */ 
/*    */ public enum EnumAuthorityUrlPrefix
/*    */ {
/* 11 */   HTTP("http://", "http://"), 
/* 12 */   HTTPS("https://", "https://");
/*    */ 
/*    */   private String code;
/*    */   private String desc;
/*    */ 
/* 19 */   public String getCode() { return this.code; }
/*    */ 
/*    */   public void setCode(String code)
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
/*    */   private EnumAuthorityUrlPrefix(String code, String desc) {
/* 35 */     this.code = code;
/* 36 */     this.desc = desc;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.enums.EnumAuthorityUrlPrefix
 * JD-Core Version:    0.6.0
 */