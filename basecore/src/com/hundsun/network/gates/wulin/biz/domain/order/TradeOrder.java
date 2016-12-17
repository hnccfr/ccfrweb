/*     */ package com.hundsun.network.gates.wulin.biz.domain.order;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeOrderStatus;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class TradeOrder
/*     */ {
/*     */   private Long id;
/*     */   private String orderNo;
/*     */   private String tradingType;
/*     */   private Long bidPrice;
/*     */   private String valuationUnit;
/*     */   private Long quantity;
/*     */   private String measureUnit;
/*     */   private Long orderAmount;
/*     */   private String hasSellerConfirm;
/*     */   private String hasBuyerConfirm;
/*     */   private Long sellerDepositAmount;
/*     */   private Long buyerDepositAmount;
/*     */   private String deliveryType;
/*     */   private String paymentType;
/*     */   private String hasPay;
/*     */   private String sellerAccount;
/*     */   private String buyerAccount;
/*     */   private Date expectTime;
/*     */   private Date endDatePay;
/*     */   private Date endDateGoods;
/*     */   private Date endDateBill;
/*     */   private Date endDateSendGoods;
/*     */   private Date endDateConfirm;
/*     */   private String hasSellerRank;
/*     */   private String hasBuyerRank;
/*     */   private String hasInvoice;
/*     */   private String wishOrderNum;
/*     */   private String projectCode;
/*     */   private String projectName;
/*     */   private String status;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */   private String creator;
/*     */   private String operator;
/*     */   private Date gmtFinished;
/*     */   private Long substationId;
/*     */ 
/*     */   public Long getId()
/*     */   {
/* 205 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/* 209 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getOrderNo()
/*     */   {
/* 216 */     return this.orderNo;
/*     */   }
/*     */ 
/*     */   public void setOrderNo(String orderNo)
/*     */   {
/* 223 */     this.orderNo = orderNo;
/*     */   }
/*     */ 
/*     */   public String getTradingType()
/*     */   {
/* 230 */     return this.tradingType;
/*     */   }
/*     */ 
/*     */   public void setTradingType(String tradingType)
/*     */   {
/* 237 */     this.tradingType = tradingType;
/*     */   }
/*     */ 
/*     */   public Long getBidPrice()
/*     */   {
/* 244 */     return this.bidPrice;
/*     */   }
/*     */ 
/*     */   public void setBidPrice(Long bidPrice)
/*     */   {
/* 251 */     this.bidPrice = bidPrice;
/*     */   }
/*     */ 
/*     */   public String getValuationUnit()
/*     */   {
/* 260 */     return this.valuationUnit;
/*     */   }
/*     */ 
/*     */   public void setValuationUnit(String valuationUnit)
/*     */   {
/* 269 */     this.valuationUnit = valuationUnit;
/*     */   }
/*     */ 
/*     */   public Long getQuantity()
/*     */   {
/* 276 */     return this.quantity;
/*     */   }
/*     */ 
/*     */   public void setQuantity(Long quantity)
/*     */   {
/* 283 */     this.quantity = quantity;
/*     */   }
/*     */ 
/*     */   public String getMeasureUnit()
/*     */   {
/* 290 */     return this.measureUnit;
/*     */   }
/*     */ 
/*     */   public void setMeasureUnit(String measureUnit)
/*     */   {
/* 297 */     this.measureUnit = measureUnit;
/*     */   }
/*     */ 
/*     */   public Long getOrderAmount()
/*     */   {
/* 304 */     return this.orderAmount;
/*     */   }
/*     */ 
/*     */   public void setOrderAmount(Long orderAmount)
/*     */   {
/* 311 */     this.orderAmount = orderAmount;
/*     */   }
/*     */ 
/*     */   public String getHasSellerConfirm()
/*     */   {
/* 318 */     return this.hasSellerConfirm;
/*     */   }
/*     */ 
/*     */   public void setHasSellerConfirm(String hasSellerConfirm)
/*     */   {
/* 325 */     this.hasSellerConfirm = hasSellerConfirm;
/*     */   }
/*     */ 
/*     */   public String getHasBuyerConfirm()
/*     */   {
/* 332 */     return this.hasBuyerConfirm;
/*     */   }
/*     */ 
/*     */   public void setHasBuyerConfirm(String hasBuyerConfirm)
/*     */   {
/* 339 */     this.hasBuyerConfirm = hasBuyerConfirm;
/*     */   }
/*     */ 
/*     */   public Long getSellerDepositAmount()
/*     */   {
/* 346 */     return this.sellerDepositAmount;
/*     */   }
/*     */ 
/*     */   public void setSellerDepositAmount(Long sellerDepositAmount)
/*     */   {
/* 353 */     this.sellerDepositAmount = sellerDepositAmount;
/*     */   }
/*     */ 
/*     */   public Long getBuyerDepositAmount()
/*     */   {
/* 360 */     return this.buyerDepositAmount;
/*     */   }
/*     */ 
/*     */   public void setBuyerDepositAmount(Long buyerDepositAmount)
/*     */   {
/* 367 */     this.buyerDepositAmount = buyerDepositAmount;
/*     */   }
/*     */ 
/*     */   public String getDeliveryType()
/*     */   {
/* 374 */     return this.deliveryType;
/*     */   }
/*     */ 
/*     */   public void setDeliveryType(String deliveryType)
/*     */   {
/* 381 */     this.deliveryType = deliveryType;
/*     */   }
/*     */ 
/*     */   public String getPaymentType()
/*     */   {
/* 388 */     return this.paymentType;
/*     */   }
/*     */ 
/*     */   public void setPaymentType(String paymentType)
/*     */   {
/* 395 */     this.paymentType = paymentType;
/*     */   }
/*     */ 
/*     */   public String getHasPay()
/*     */   {
/* 402 */     return this.hasPay;
/*     */   }
/*     */ 
/*     */   public void setHasPay(String hasPay)
/*     */   {
/* 409 */     this.hasPay = hasPay;
/*     */   }
/*     */ 
/*     */   public String getSellerAccount()
/*     */   {
/* 416 */     return this.sellerAccount;
/*     */   }
/*     */ 
/*     */   public void setSellerAccount(String sellerAccount)
/*     */   {
/* 423 */     this.sellerAccount = sellerAccount;
/*     */   }
/*     */ 
/*     */   public String getBuyerAccount()
/*     */   {
/* 430 */     return this.buyerAccount;
/*     */   }
/*     */ 
/*     */   public void setBuyerAccount(String buyerAccount)
/*     */   {
/* 437 */     this.buyerAccount = buyerAccount;
/*     */   }
/*     */ 
/*     */   public Date getExpectTime()
/*     */   {
/* 444 */     return this.expectTime;
/*     */   }
/*     */ 
/*     */   public void setExpectTime(Date expectTime)
/*     */   {
/* 451 */     this.expectTime = expectTime;
/*     */   }
/*     */ 
/*     */   public Date getEndDatePay()
/*     */   {
/* 458 */     return this.endDatePay;
/*     */   }
/*     */ 
/*     */   public void setEndDatePay(Date endDatePay)
/*     */   {
/* 465 */     this.endDatePay = endDatePay;
/*     */   }
/*     */ 
/*     */   public Date getEndDateGoods()
/*     */   {
/* 472 */     return this.endDateGoods;
/*     */   }
/*     */ 
/*     */   public void setEndDateGoods(Date endDateGoods)
/*     */   {
/* 479 */     this.endDateGoods = endDateGoods;
/*     */   }
/*     */ 
/*     */   public Date getEndDateBill()
/*     */   {
/* 486 */     return this.endDateBill;
/*     */   }
/*     */ 
/*     */   public void setEndDateBill(Date endDateBill)
/*     */   {
/* 493 */     this.endDateBill = endDateBill;
/*     */   }
/*     */ 
/*     */   public String getHasSellerRank()
/*     */   {
/* 500 */     return this.hasSellerRank;
/*     */   }
/*     */ 
/*     */   public void setHasSellerRank(String hasSellerRank)
/*     */   {
/* 507 */     this.hasSellerRank = hasSellerRank;
/*     */   }
/*     */ 
/*     */   public String getHasBuyerRank()
/*     */   {
/* 514 */     return this.hasBuyerRank;
/*     */   }
/*     */ 
/*     */   public void setHasBuyerRank(String hasBuyerRank)
/*     */   {
/* 521 */     this.hasBuyerRank = hasBuyerRank;
/*     */   }
/*     */ 
/*     */   public String getHasInvoice()
/*     */   {
/* 528 */     return this.hasInvoice;
/*     */   }
/*     */ 
/*     */   public void setHasInvoice(String hasInvoice)
/*     */   {
/* 535 */     this.hasInvoice = hasInvoice;
/*     */   }
/*     */ 
/*     */   public String getWishOrderNum()
/*     */   {
/* 542 */     return this.wishOrderNum;
/*     */   }
/*     */ 
/*     */   public void setWishOrderNum(String wishOrderNum)
/*     */   {
/* 549 */     this.wishOrderNum = wishOrderNum;
/*     */   }
/*     */ 
/*     */   public String getProjectCode()
/*     */   {
/* 556 */     return this.projectCode;
/*     */   }
/*     */ 
/*     */   public void setProjectCode(String projectCode)
/*     */   {
/* 563 */     this.projectCode = projectCode;
/*     */   }
/*     */ 
/*     */   public String getProjectName()
/*     */   {
/* 570 */     return this.projectName;
/*     */   }
/*     */ 
/*     */   public void setProjectName(String projectName)
/*     */   {
/* 577 */     this.projectName = projectName;
/*     */   }
/*     */ 
/*     */   public String getStatus()
/*     */   {
/* 600 */     return this.status;
/*     */   }
/*     */ 
/*     */   public void setStatus(String status)
/*     */   {
/* 623 */     this.status = status;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate()
/*     */   {
/* 630 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate)
/*     */   {
/* 637 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify()
/*     */   {
/* 644 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify)
/*     */   {
/* 651 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getCreator()
/*     */   {
/* 658 */     return this.creator;
/*     */   }
/*     */ 
/*     */   public void setCreator(String creator)
/*     */   {
/* 665 */     this.creator = creator;
/*     */   }
/*     */ 
/*     */   public String getOperator()
/*     */   {
/* 672 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator)
/*     */   {
/* 679 */     this.operator = operator;
/*     */   }
/*     */ 
/*     */   public String getStatusDesc()
/*     */   {
/* 686 */     EnumTradeOrderStatus orderStatus = EnumTradeOrderStatus.indexByValue(this.status);
/* 687 */     if (null == orderStatus) {
/* 688 */       return this.status;
/*     */     }
/* 690 */     return orderStatus.getName();
/*     */   }
/*     */ 
/*     */   public boolean isBuyerOrder(String userAccount)
/*     */   {
/* 699 */     if (null != userAccount) {
/* 700 */       return userAccount.equals(this.buyerAccount);
/*     */     }
/* 702 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean isSellerOrder(String userAccount)
/*     */   {
/* 711 */     if (null != userAccount) {
/* 712 */       return userAccount.equals(this.sellerAccount);
/*     */     }
/* 714 */     return false;
/*     */   }
/*     */ 
/*     */   public Date getEndDateSendGoods() {
/* 718 */     return this.endDateSendGoods;
/*     */   }
/*     */ 
/*     */   public void setEndDateSendGoods(Date endDateSendGoods) {
/* 722 */     this.endDateSendGoods = endDateSendGoods;
/*     */   }
/*     */ 
/*     */   public Date getGmtFinished() {
/* 726 */     return this.gmtFinished;
/*     */   }
/*     */ 
/*     */   public void setGmtFinished(Date gmtFinished) {
/* 730 */     this.gmtFinished = gmtFinished;
/*     */   }
/*     */ 
/*     */   public Date getEndDateConfirm() {
/* 734 */     return this.endDateConfirm;
/*     */   }
/*     */ 
/*     */   public void setEndDateConfirm(Date endDateConfirm) {
/* 738 */     this.endDateConfirm = endDateConfirm;
/*     */   }
/*     */ 
/*     */   public Long getSubstationId() {
/* 742 */     return this.substationId;
/*     */   }
/*     */ 
/*     */   public void setSubstationId(Long substationId) {
/* 746 */     this.substationId = substationId;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.domain.order.TradeOrder
 * JD-Core Version:    0.6.0
 */