/*    */ package com.hundsun.network.gates.genshan.biz.domain.fund.query;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.domain.fund.FundAccountLog;
/*    */ import com.hundsun.network.gates.luosi.common.page.Pagination;
/*    */ 
/*    */ public class FundAccountLogQuery extends Pagination<FundAccountLog>
/*    */ {
/*    */   private static final long serialVersionUID = -6084288339277797698L;
/*    */   private String tradeDate;
/*    */   private String FundAccount;
/*    */   private String userAccount;
/*    */   private String bizNo;
/*    */   private String startDate;
/*    */   private String endDate;
/*    */ 
/*    */   public String getTradeDate()
/*    */   {
/* 45 */     return this.tradeDate;
/*    */   }
/*    */ 
/*    */   public void setTradeDate(String tradeDate) {
/* 49 */     this.tradeDate = tradeDate;
/*    */   }
/*    */ 
/*    */   public String getFundAccount() {
/* 53 */     return this.FundAccount;
/*    */   }
/*    */ 
/*    */   public void setFundAccount(String fundAccount) {
/* 57 */     this.FundAccount = fundAccount;
/*    */   }
/*    */ 
/*    */   public String getBizNo() {
/* 61 */     return this.bizNo;
/*    */   }
/*    */ 
/*    */   public void setBizNo(String bizNo) {
/* 65 */     this.bizNo = bizNo;
/*    */   }
/*    */ 
/*    */   public String getUserAccount() {
/* 69 */     return this.userAccount;
/*    */   }
/*    */ 
/*    */   public void setUserAccount(String userAccount) {
/* 73 */     this.userAccount = userAccount;
/*    */   }
/*    */ 
/*    */   public String getStartDate() {
/* 77 */     return this.startDate;
/*    */   }
/*    */ 
/*    */   public void setStartDate(String startDate) {
/* 81 */     this.startDate = startDate;
/*    */   }
/*    */ 
/*    */   public String getEndDate() {
/* 85 */     return this.endDate;
/*    */   }
/*    */ 
/*    */   public void setEndDate(String endDate) {
/* 89 */     this.endDate = endDate;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.fund.query.FundAccountLogQuery
 * JD-Core Version:    0.6.0
 */