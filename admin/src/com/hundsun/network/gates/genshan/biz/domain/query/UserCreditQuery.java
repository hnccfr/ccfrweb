/*    */ package com.hundsun.network.gates.genshan.biz.domain.query;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.domain.baseset.UserCredit;
/*    */ import com.hundsun.network.gates.luosi.common.page.Pagination;
/*    */ 
/*    */ public class UserCreditQuery extends Pagination<UserCredit>
/*    */ {
/*    */   private static final long serialVersionUID = 8037625893489824297L;
/*    */   private String userAccount;
/*    */ 
/*    */   public String getUserAccount()
/*    */   {
/* 15 */     return this.userAccount;
/*    */   }
/*    */ 
/*    */   public void setUserAccount(String userAccount) {
/* 19 */     this.userAccount = userAccount;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.query.UserCreditQuery
 * JD-Core Version:    0.6.0
 */