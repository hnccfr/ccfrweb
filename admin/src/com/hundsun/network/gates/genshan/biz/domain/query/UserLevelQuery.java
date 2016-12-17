/*    */ package com.hundsun.network.gates.genshan.biz.domain.query;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.domain.baseset.UserLevel;
/*    */ import com.hundsun.network.gates.luosi.common.page.Pagination;
/*    */ 
/*    */ public class UserLevelQuery extends Pagination<UserLevel>
/*    */ {
/*    */   private static final long serialVersionUID = 1629709101825974280L;
/*    */   private String userAccount;
/*    */   private String memberLevel;
/*    */ 
/*    */   public String getUserAccount()
/*    */   {
/* 13 */     return this.userAccount;
/*    */   }
/*    */   public void setUserAccount(String userAccount) {
/* 16 */     this.userAccount = userAccount;
/*    */   }
/*    */   public String getMemberLevel() {
/* 19 */     return this.memberLevel;
/*    */   }
/*    */   public void setMemberLevel(String memberLevel) {
/* 22 */     this.memberLevel = memberLevel;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.query.UserLevelQuery
 * JD-Core Version:    0.6.0
 */