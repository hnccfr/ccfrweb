/*    */ package com.hundsun.network.gates.fengshan.biz.domain.query;
/*    */ 
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.auction.AuctionBidRecordHis;
/*    */ import com.hundsun.network.gates.luosi.common.page.Pagination;
/*    */ 
/*    */ public class AuctionBidRecordHisQuery extends Pagination<AuctionBidRecordHis>
/*    */ {
/*    */   private static final long serialVersionUID = 1655551594518177928L;
/*    */   private String projectCode;
/*    */   private String bidderAccount;
/*    */ 
/*    */   public String getProjectCode()
/*    */   {
/* 18 */     return this.projectCode;
/*    */   }
/*    */   public void setProjectCode(String projectCode) {
/* 21 */     this.projectCode = projectCode;
/*    */   }
/*    */   public String getBidderAccount() {
/* 24 */     return this.bidderAccount;
/*    */   }
/*    */   public void setBidderAccount(String bidderAccount) {
/* 27 */     this.bidderAccount = bidderAccount;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.domain.query.AuctionBidRecordHisQuery
 * JD-Core Version:    0.6.0
 */