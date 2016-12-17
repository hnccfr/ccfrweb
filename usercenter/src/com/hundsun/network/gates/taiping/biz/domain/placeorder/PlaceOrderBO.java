/*     */ package com.hundsun.network.gates.taiping.biz.domain.placeorder;
/*     */ 
/*     */ import com.hundsun.network.gates.taiping.biz.domain.BaseDomain;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class PlaceOrderBO extends BaseDomain
/*     */ {
/*     */   private static final long serialVersionUID = -4749710879016960207L;
/*     */   private String projectCode;
/*     */   private Long userId;
/*     */   private String userAccount;
/*     */   private Long listingPrice;
/*     */   private Long quantity;
/*     */   private Long totalPay;
/*     */   private String tradingType;
/*     */   private Date deliveryDate;
/*     */   private String deliveryPlace;
/*     */   private String deliveryType;
/*     */   private String paymentType;
/*     */   private String invoice;
/*     */ 
/*     */   public String getProjectCode()
/*     */   {
/*  81 */     return this.projectCode;
/*     */   }
/*     */ 
/*     */   public void setProjectCode(String projectCode) {
/*  85 */     this.projectCode = projectCode;
/*     */   }
/*     */ 
/*     */   public Long getUserId() {
/*  89 */     return this.userId;
/*     */   }
/*     */ 
/*     */   public void setUserId(Long userId) {
/*  93 */     this.userId = userId;
/*     */   }
/*     */ 
/*     */   public String getUserAccount() {
/*  97 */     return this.userAccount;
/*     */   }
/*     */ 
/*     */   public void setUserAccount(String userAccount) {
/* 101 */     this.userAccount = userAccount;
/*     */   }
/*     */ 
/*     */   public Long getListingPrice() {
/* 105 */     return this.listingPrice;
/*     */   }
/*     */ 
/*     */   public void setListingPrice(Long listingPrice) {
/* 109 */     this.listingPrice = listingPrice;
/*     */   }
/*     */ 
/*     */   public Long getQuantity() {
/* 113 */     return this.quantity;
/*     */   }
/*     */ 
/*     */   public void setQuantity(Long quantity) {
/* 117 */     this.quantity = quantity;
/*     */   }
/*     */ 
/*     */   public Long getTotalPay() {
/* 121 */     return this.totalPay;
/*     */   }
/*     */ 
/*     */   public void setTotalPay(Long totalPay) {
/* 125 */     this.totalPay = totalPay;
/*     */   }
/*     */ 
/*     */   public String getTradingType() {
/* 129 */     return this.tradingType;
/*     */   }
/*     */ 
/*     */   public void setTradingType(String tradingType) {
/* 133 */     this.tradingType = tradingType;
/*     */   }
/*     */ 
/*     */   public Date getDeliveryDate() {
/* 137 */     return this.deliveryDate;
/*     */   }
/*     */ 
/*     */   public void setDeliveryDate(Date deliveryDate) {
/* 141 */     this.deliveryDate = deliveryDate;
/*     */   }
/*     */ 
/*     */   public String getDeliveryPlace() {
/* 145 */     return this.deliveryPlace;
/*     */   }
/*     */ 
/*     */   public void setDeliveryPlace(String deliveryPlace) {
/* 149 */     this.deliveryPlace = deliveryPlace;
/*     */   }
/*     */ 
/*     */   public String getDeliveryType() {
/* 153 */     return this.deliveryType;
/*     */   }
/*     */ 
/*     */   public void setDeliveryType(String deliveryType) {
/* 157 */     this.deliveryType = deliveryType;
/*     */   }
/*     */ 
/*     */   public String getPaymentType() {
/* 161 */     return this.paymentType;
/*     */   }
/*     */ 
/*     */   public void setPaymentType(String paymentType) {
/* 165 */     this.paymentType = paymentType;
/*     */   }
/*     */ 
/*     */   public String getInvoice() {
/* 169 */     return this.invoice;
/*     */   }
/*     */ 
/*     */   public void setInvoice(String invoice) {
/* 173 */     this.invoice = invoice;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.taiping.biz.domain.placeorder.PlaceOrderBO
 * JD-Core Version:    0.6.0
 */