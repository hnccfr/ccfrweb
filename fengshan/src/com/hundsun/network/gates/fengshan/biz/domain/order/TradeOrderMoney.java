/*     */ package com.hundsun.network.gates.fengshan.biz.domain.order;
/*     */ 
/*     */ import java.util.Date;
/*     */ 
/*     */ public class TradeOrderMoney
/*     */ {
/*     */   private Long id;
/*     */   private String orderNo;
/*     */   private String userAccount;
/*     */   private String fundAccount;
/*     */   private Long tradeDeposit;
/*     */   private Long deliveryDeposit;
/*     */   private Long tradeServiceCharge;
/*     */   private Long goodsAmount;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */   private String operator;
/*     */   private Long penaltyAmount;
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  67 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/*  71 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getOrderNo() {
/*  75 */     return this.orderNo;
/*     */   }
/*     */ 
/*     */   public void setOrderNo(String orderNo) {
/*  79 */     this.orderNo = orderNo;
/*     */   }
/*     */ 
/*     */   public String getUserAccount() {
/*  83 */     return this.userAccount;
/*     */   }
/*     */ 
/*     */   public void setUserAccount(String userAccount) {
/*  87 */     this.userAccount = userAccount;
/*     */   }
/*     */ 
/*     */   public String getFundAccount() {
/*  91 */     return this.fundAccount;
/*     */   }
/*     */ 
/*     */   public void setFundAccount(String fundAccount) {
/*  95 */     this.fundAccount = fundAccount;
/*     */   }
/*     */ 
/*     */   public Long getTradeDeposit() {
/*  99 */     return this.tradeDeposit;
/*     */   }
/*     */ 
/*     */   public void setTradeDeposit(Long tradeDeposit) {
/* 103 */     this.tradeDeposit = tradeDeposit;
/*     */   }
/*     */ 
/*     */   public Long getDeliveryDeposit() {
/* 107 */     return this.deliveryDeposit;
/*     */   }
/*     */ 
/*     */   public void setDeliveryDeposit(Long deliveryDeposit) {
/* 111 */     this.deliveryDeposit = deliveryDeposit;
/*     */   }
/*     */ 
/*     */   public Long getTradeServiceCharge() {
/* 115 */     return this.tradeServiceCharge;
/*     */   }
/*     */ 
/*     */   public void setTradeServiceCharge(Long tradeServiceCharge) {
/* 119 */     this.tradeServiceCharge = tradeServiceCharge;
/*     */   }
/*     */ 
/*     */   public Long getGoodsAmount() {
/* 123 */     return this.goodsAmount;
/*     */   }
/*     */ 
/*     */   public void setGoodsAmount(Long goodsAmount) {
/* 127 */     this.goodsAmount = goodsAmount;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate() {
/* 131 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate) {
/* 135 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify() {
/* 139 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify) {
/* 143 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getOperator() {
/* 147 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator) {
/* 151 */     this.operator = operator;
/*     */   }
/*     */ 
/*     */   public Long getPenaltyAmount() {
/* 155 */     return this.penaltyAmount;
/*     */   }
/*     */ 
/*     */   public void setPenaltyAmount(Long penaltyAmount) {
/* 159 */     this.penaltyAmount = penaltyAmount;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.domain.order.TradeOrderMoney
 * JD-Core Version:    0.6.0
 */