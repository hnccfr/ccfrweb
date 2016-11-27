/*    */ package com.hundsun.network.gates.genshan.biz.domain.query;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.domain.auction.AuctionBidRecordHis;
/*    */ import com.hundsun.network.gates.luosi.common.page.Pagination;
/*    */ 
/*    */ public class AuctionBidRecordHisQuery extends Pagination<AuctionBidRecordHis>
/*    */ {
/*    */   private static final long serialVersionUID = 3660803828426996820L;
/*    */   private String projectCode;
/*    */   private String bidderAccount;
/*    */ 
/*    */   public String getProjectCode()
/*    */   {
/* 19 */     return this.projectCode;
/*    */   }
/*    */   public void setProjectCode(String projectCode) {
/* 22 */     this.projectCode = projectCode;
/*    */   }
/*    */   public String getBidderAccount() {
/* 25 */     return this.bidderAccount;
/*    */   }
/*    */   public void setBidderAccount(String bidderAccount) {
/* 28 */     this.bidderAccount = bidderAccount;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.query.AuctionBidRecordHisQuery
 * JD-Core Version:    0.6.0
 */