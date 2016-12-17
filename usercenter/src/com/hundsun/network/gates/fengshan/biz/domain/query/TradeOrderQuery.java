/*     */ package com.hundsun.network.gates.fengshan.biz.domain.query;
/*     */ 
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.order.TradeOrder;
/*     */ import com.hundsun.network.gates.luosi.common.page.Pagination;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class TradeOrderQuery extends Pagination<TradeOrder>
/*     */ {
/*     */   private static final long serialVersionUID = -6960491939541676085L;
/*     */   private String orderNo;
/*     */   private String tradingType;
/*     */   private String status;
/*     */   private Date startDate;
/*     */   private Date endDate;
/*     */   private String sellerAccount;
/*     */   private String buyerAccount;
/*     */   private String hasSellerRank;
/*     */   private String hasBuyerRank;
/*     */   private Integer tradeOrderCount;
/*     */   private String projectTypeCode;
/*     */ 
/*     */   public String getOrderNo()
/*     */   {
/*  85 */     return this.orderNo;
/*     */   }
/*     */ 
/*     */   public void setOrderNo(String orderNo) {
/*  89 */     this.orderNo = orderNo;
/*     */   }
/*     */ 
/*     */   public String getTradingType() {
/*  93 */     return this.tradingType;
/*     */   }
/*     */ 
/*     */   public void setTradingType(String tradingType) {
/*  97 */     this.tradingType = tradingType;
/*     */   }
/*     */ 
/*     */   public String getStatus() {
/* 101 */     return this.status;
/*     */   }
/*     */ 
/*     */   public void setStatus(String status) {
/* 105 */     this.status = status;
/*     */   }
/*     */ 
/*     */   public Date getStartDate() {
/* 109 */     return this.startDate;
/*     */   }
/*     */ 
/*     */   public void setStartDate(Date startDate) {
/* 113 */     this.startDate = startDate;
/*     */   }
/*     */ 
/*     */   public Date getEndDate() {
/* 117 */     return this.endDate;
/*     */   }
/*     */ 
/*     */   public void setEndDate(Date endDate) {
/* 121 */     this.endDate = endDate;
/*     */   }
/*     */ 
/*     */   public String getSellerAccount() {
/* 125 */     return this.sellerAccount;
/*     */   }
/*     */ 
/*     */   public void setSellerAccount(String sellerAccount) {
/* 129 */     this.sellerAccount = sellerAccount;
/*     */   }
/*     */ 
/*     */   public String getBuyerAccount() {
/* 133 */     return this.buyerAccount;
/*     */   }
/*     */ 
/*     */   public void setBuyerAccount(String buyerAccount) {
/* 137 */     this.buyerAccount = buyerAccount;
/*     */   }
/*     */ 
/*     */   public Integer getTradeOrderCount() {
/* 141 */     return this.tradeOrderCount;
/*     */   }
/*     */ 
/*     */   public void setTradeOrderCount(Integer tradeOrderCount) {
/* 145 */     this.tradeOrderCount = tradeOrderCount;
/*     */   }
/*     */ 
/*     */   public String getProjectTypeCode() {
/* 149 */     return this.projectTypeCode;
/*     */   }
/*     */ 
/*     */   public void setProjectTypeCode(String projectTypeCode) {
/* 153 */     this.projectTypeCode = projectTypeCode;
/*     */   }
/*     */ 
/*     */   public String getHasSellerRank() {
/* 157 */     return this.hasSellerRank;
/*     */   }
/*     */ 
/*     */   public void setHasSellerRank(String hasSellerRank) {
/* 161 */     this.hasSellerRank = hasSellerRank;
/*     */   }
/*     */ 
/*     */   public String getHasBuyerRank() {
/* 165 */     return this.hasBuyerRank;
/*     */   }
/*     */ 
/*     */   public void setHasBuyerRank(String hasBuyerRank) {
/* 169 */     this.hasBuyerRank = hasBuyerRank;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.domain.query.TradeOrderQuery
 * JD-Core Version:    0.6.0
 */