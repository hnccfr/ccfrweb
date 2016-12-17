/*    */ package com.hundsun.network.gates.houchao.biz.enums;
/*    */ 
/*    */ public enum EnumMiddleFundAccount
/*    */ {
/* 17 */   MIDDLE_GOODS_FUND_ACCOUNT("9999999999", "中间账户--货款"), 
/* 18 */   MIDDLE_FEE_FUND_ACCOUNT("8888888888", "中间账户-手续费");
/*    */ 
/*    */   private String code;
/*    */   private String description;
/*    */ 
/* 22 */   private EnumMiddleFundAccount(String code, String description) { this.code = code;
/* 23 */     this.description = description;
/*    */   }
/*    */ 
/*    */   public String getCode()
/*    */   {
/* 31 */     return this.code;
/*    */   }
/*    */ 
/*    */   public String getDescription() {
/* 35 */     return this.description;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\houchao\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.houchao.biz.enums.EnumMiddleFundAccount
 * JD-Core Version:    0.6.0
 */