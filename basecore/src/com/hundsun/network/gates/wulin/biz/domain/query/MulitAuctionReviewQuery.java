/*    */ package com.hundsun.network.gates.wulin.biz.domain.query;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.enums.EnumBidCheckStatus;
/*    */ import com.hundsun.network.gates.luosi.common.enums.EnumBidPriceStatus;
/*    */ 
/*    */ public class MulitAuctionReviewQuery
/*    */ {
/*    */   private Long freeBidId;
/*    */   private String projectCode;
/*    */   private String bidderAccount;
/*    */   private EnumBidPriceStatus status;
/*    */   private EnumBidCheckStatus checkStatus;
/*    */ 
/*    */   public Long getFreeBidId()
/*    */   {
/* 34 */     return this.freeBidId;
/*    */   }
/*    */ 
/*    */   public void setFreeBidId(Long freeBidId) {
/* 38 */     this.freeBidId = freeBidId;
/*    */   }
/*    */ 
/*    */   public String getProjectCode() {
/* 42 */     return this.projectCode;
/*    */   }
/*    */ 
/*    */   public void setProjectCode(String projectCode) {
/* 46 */     this.projectCode = projectCode;
/*    */   }
/*    */ 
/*    */   public String getBidderAccount() {
/* 50 */     return this.bidderAccount;
/*    */   }
/*    */ 
/*    */   public void setBidderAccount(String bidderAccount) {
/* 54 */     this.bidderAccount = bidderAccount;
/*    */   }
/*    */ 
/*    */   public EnumBidPriceStatus getStatus() {
/* 58 */     return this.status;
/*    */   }
/*    */ 
/*    */   public void setStatus(EnumBidPriceStatus status) {
/* 62 */     this.status = status;
/*    */   }
/*    */ 
/*    */   public EnumBidCheckStatus getCheckStatus() {
/* 66 */     return this.checkStatus;
/*    */   }
/*    */ 
/*    */   public void setCheckStatus(EnumBidCheckStatus checkStatus) {
/* 70 */     this.checkStatus = checkStatus;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.domain.query.MulitAuctionReviewQuery
 * JD-Core Version:    0.6.0
 */