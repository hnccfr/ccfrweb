/*     */ package com.hundsun.network.gates.genshan.biz.domain.query;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.domain.order.TradeOrder;
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
/*     */   private Long substationId;
/*     */ 
/*     */   public String getOrderNo()
/*     */   {
/*  74 */     return this.orderNo;
/*     */   }
/*     */ 
/*     */   public void setOrderNo(String orderNo) {
/*  78 */     this.orderNo = orderNo;
/*     */   }
/*     */ 
/*     */   public String getTradingType() {
/*  82 */     return this.tradingType;
/*     */   }
/*     */ 
/*     */   public void setTradingType(String tradingType) {
/*  86 */     this.tradingType = tradingType;
/*     */   }
/*     */ 
/*     */   public String getStatus() {
/*  90 */     return this.status;
/*     */   }
/*     */ 
/*     */   public void setStatus(String status) {
/*  94 */     this.status = status;
/*     */   }
/*     */ 
/*     */   public Date getStartDate() {
/*  98 */     return this.startDate;
/*     */   }
/*     */ 
/*     */   public void setStartDate(Date startDate) {
/* 102 */     this.startDate = startDate;
/*     */   }
/*     */ 
/*     */   public Date getEndDate() {
/* 106 */     return this.endDate;
/*     */   }
/*     */ 
/*     */   public void setEndDate(Date endDate) {
/* 110 */     this.endDate = endDate;
/*     */   }
/*     */ 
/*     */   public String getSellerAccount() {
/* 114 */     return this.sellerAccount;
/*     */   }
/*     */ 
/*     */   public void setSellerAccount(String sellerAccount) {
/* 118 */     this.sellerAccount = sellerAccount;
/*     */   }
/*     */ 
/*     */   public String getBuyerAccount() {
/* 122 */     return this.buyerAccount;
/*     */   }
/*     */ 
/*     */   public void setBuyerAccount(String buyerAccount) {
/* 126 */     this.buyerAccount = buyerAccount;
/*     */   }
/*     */ 
/*     */   public Long getSubstationId() {
/* 130 */     return this.substationId;
/*     */   }
/*     */ 
/*     */   public void setSubstationId(Long substationId) {
/* 134 */     this.substationId = substationId;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.query.TradeOrderQuery
 * JD-Core Version:    0.6.0
 */