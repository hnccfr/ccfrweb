/*    */ package com.hundsun.network.gates.fengshan.biz.domain.query;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public class TradeOrderMoneyQuery
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 5445063719959900100L;
/*    */   private String orderNo;
/*    */   private String userAccount;
/*    */ 
/*    */   public String getOrderNo()
/*    */   {
/* 11 */     return this.orderNo;
/*    */   }
/*    */   public void setOrderNo(String orderNo) {
/* 14 */     this.orderNo = orderNo;
/*    */   }
/*    */   public String getUserAccount() {
/* 17 */     return this.userAccount;
/*    */   }
/*    */   public void setUserAccount(String userAccount) {
/* 20 */     this.userAccount = userAccount;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.domain.query.TradeOrderMoneyQuery
 * JD-Core Version:    0.6.0
 */