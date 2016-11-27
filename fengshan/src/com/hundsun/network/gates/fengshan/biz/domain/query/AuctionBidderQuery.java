/*    */ package com.hundsun.network.gates.fengshan.biz.domain.query;
/*    */ 
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.auction.AuctionBidRecordHis;
/*    */ import com.hundsun.network.gates.luosi.common.enums.EnumValuationUnit;
/*    */ import com.hundsun.network.gates.luosi.common.page.Pagination;
/*    */ 
/*    */ public class AuctionBidderQuery extends Pagination<AuctionBidRecordHis>
/*    */ {
/*    */   private static final long serialVersionUID = -3033773758303846320L;
/*    */   private String projectCode;
/*    */   private String bidderAccount;
/*    */   private String valuationUnit;
/*    */ 
/*    */   public String getProjectCode()
/*    */   {
/* 24 */     return this.projectCode;
/*    */   }
/*    */   public void setProjectCode(String projectCode) {
/* 27 */     this.projectCode = projectCode;
/*    */   }
/*    */   public String getBidderAccount() {
/* 30 */     return this.bidderAccount;
/*    */   }
/*    */   public void setBidderAccount(String bidderAccount) {
/* 33 */     this.bidderAccount = bidderAccount;
/*    */   }
/*    */   public void setValuationUnit(String valuationUnit) {
/* 36 */     this.valuationUnit = valuationUnit;
/*    */   }
/*    */   public String getValuationUnit() {
/* 39 */     return this.valuationUnit;
/*    */   }
/*    */   public String getValuationUnitDesc() {
/* 42 */     EnumValuationUnit valuationUnitEnum = EnumValuationUnit.indexByValue(this.valuationUnit);
/* 43 */     if (null == valuationUnitEnum) {
/* 44 */       return this.valuationUnit;
/*    */     }
/* 46 */     return valuationUnitEnum.getName();
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.domain.query.AuctionBidderQuery
 * JD-Core Version:    0.6.0
 */