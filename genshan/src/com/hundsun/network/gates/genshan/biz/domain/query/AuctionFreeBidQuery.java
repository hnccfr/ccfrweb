/*    */ package com.hundsun.network.gates.genshan.biz.domain.query;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.domain.auction.AuctionBidRecordHis;
/*    */ import com.hundsun.network.gates.luosi.common.page.Pagination;
/*    */ 
/*    */ public class AuctionFreeBidQuery extends Pagination<AuctionBidRecordHis>
/*    */ {
/*    */   private static final long serialVersionUID = 4188486440019475673L;
/*    */   private String projectCode;
/*    */   private String bidderAccount;
/*    */   private String returnUrl;
/*    */   private String from;
/*    */ 
/*    */   public String getProjectCode()
/*    */   {
/* 26 */     return this.projectCode;
/*    */   }
/*    */   public void setProjectCode(String projectCode) {
/* 29 */     this.projectCode = projectCode;
/*    */   }
/*    */   public String getBidderAccount() {
/* 32 */     return this.bidderAccount;
/*    */   }
/*    */   public void setBidderAccount(String bidderAccount) {
/* 35 */     this.bidderAccount = bidderAccount;
/*    */   }
/*    */   public String getFrom() {
/* 38 */     return this.from;
/*    */   }
/*    */   public void setFrom(String from) {
/* 41 */     this.from = from;
/*    */   }
/*    */   public String getReturnUrl() {
/* 44 */     return this.returnUrl;
/*    */   }
/*    */   public void setReturnUrl(String returnUrl) {
/* 47 */     this.returnUrl = returnUrl;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.query.AuctionFreeBidQuery
 * JD-Core Version:    0.6.0
 */