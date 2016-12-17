/*    */ package com.hundsun.network.gates.genshan.biz.domain.fund.query;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.domain.fund.FundAccountLog;
/*    */ import com.hundsun.network.gates.luosi.common.page.Pagination;
/*    */ 
/*    */ public class FundAccountReportQuery extends Pagination<FundAccountLog>
/*    */ {
/*    */   private static final long serialVersionUID = -6084288339277797698L;
/*    */   private String tradeDate;
/*    */   private String fundAccount;
/*    */ 
/*    */   public String getTradeDate()
/*    */   {
/* 33 */     return this.tradeDate;
/*    */   }
/*    */ 
/*    */   public void setTradeDate(String tradeDate) {
/* 37 */     this.tradeDate = tradeDate;
/*    */   }
/*    */ 
/*    */   public String getFundAccount() {
/* 41 */     return this.fundAccount;
/*    */   }
/*    */ 
/*    */   public void setFundAccount(String fundAccount) {
/* 45 */     this.fundAccount = fundAccount;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.fund.query.FundAccountReportQuery
 * JD-Core Version:    0.6.0
 */