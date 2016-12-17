/*     */ package com.hundsun.network.gates.genshan.biz.domain.order;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumActiveStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumMeasureUnit;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeOrderStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradingType;
/*     */ import com.hundsun.network.gates.luosi.common.utils.CommonUtils;
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
/*     */   private Long substationId;
/*     */ 
/*     */   public Long getId()
/*     */   {
/* 203 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/* 207 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getOrderNo()
/*     */   {
/* 214 */     return this.orderNo;
/*     */   }
/*     */ 
/*     */   public void setOrderNo(String orderNo)
/*     */   {
/* 221 */     this.orderNo = orderNo;
/*     */   }
/*     */ 
/*     */   public String getTradingType()
/*     */   {
/* 228 */     return this.tradingType;
/*     */   }
/*     */ 
/*     */   public void setTradingType(String tradingType)
/*     */   {
/* 235 */     this.tradingType = tradingType;
/*     */   }
/*     */ 
/*     */   public Long getBidPrice()
/*     */   {
/* 242 */     return this.bidPrice;
/*     */   }
/*     */ 
/*     */   public void setBidPrice(Long bidPrice)
/*     */   {
/* 249 */     this.bidPrice = bidPrice;
/*     */   }
/*     */ 
/*     */   public String getValuationUnit()
/*     */   {
/* 258 */     return this.valuationUnit;
/*     */   }
/*     */ 
/*     */   public void setValuationUnit(String valuationUnit)
/*     */   {
/* 267 */     this.valuationUnit = valuationUnit;
/*     */   }
/*     */ 
/*     */   public Long getQuantity()
/*     */   {
/* 274 */     return this.quantity;
/*     */   }
/*     */ 
/*     */   public void setQuantity(Long quantity)
/*     */   {
/* 281 */     this.quantity = quantity;
/*     */   }
/*     */ 
/*     */   public String getMeasureUnit()
/*     */   {
/* 288 */     return this.measureUnit;
/*     */   }
/*     */ 
/*     */   public void setMeasureUnit(String measureUnit)
/*     */   {
/* 295 */     this.measureUnit = measureUnit;
/*     */   }
/*     */ 
/*     */   public Long getOrderAmount()
/*     */   {
/* 302 */     return this.orderAmount;
/*     */   }
/*     */ 
/*     */   public void setOrderAmount(Long orderAmount)
/*     */   {
/* 309 */     this.orderAmount = orderAmount;
/*     */   }
/*     */ 
/*     */   public String getHasSellerConfirm()
/*     */   {
/* 316 */     return this.hasSellerConfirm;
/*     */   }
/*     */ 
/*     */   public void setHasSellerConfirm(String hasSellerConfirm)
/*     */   {
/* 323 */     this.hasSellerConfirm = hasSellerConfirm;
/*     */   }
/*     */ 
/*     */   public String getHasBuyerConfirm()
/*     */   {
/* 330 */     return this.hasBuyerConfirm;
/*     */   }
/*     */ 
/*     */   public void setHasBuyerConfirm(String hasBuyerConfirm)
/*     */   {
/* 337 */     this.hasBuyerConfirm = hasBuyerConfirm;
/*     */   }
/*     */ 
/*     */   public Long getSellerDepositAmount()
/*     */   {
/* 344 */     return this.sellerDepositAmount;
/*     */   }
/*     */ 
/*     */   public void setSellerDepositAmount(Long sellerDepositAmount)
/*     */   {
/* 351 */     this.sellerDepositAmount = sellerDepositAmount;
/*     */   }
/*     */ 
/*     */   public Long getBuyerDepositAmount()
/*     */   {
/* 358 */     return this.buyerDepositAmount;
/*     */   }
/*     */ 
/*     */   public void setBuyerDepositAmount(Long buyerDepositAmount)
/*     */   {
/* 365 */     this.buyerDepositAmount = buyerDepositAmount;
/*     */   }
/*     */ 
/*     */   public String getDeliveryType()
/*     */   {
/* 372 */     return this.deliveryType;
/*     */   }
/*     */ 
/*     */   public void setDeliveryType(String deliveryType)
/*     */   {
/* 379 */     this.deliveryType = deliveryType;
/*     */   }
/*     */ 
/*     */   public String getPaymentType()
/*     */   {
/* 386 */     return this.paymentType;
/*     */   }
/*     */ 
/*     */   public void setPaymentType(String paymentType)
/*     */   {
/* 393 */     this.paymentType = paymentType;
/*     */   }
/*     */ 
/*     */   public String getHasPay()
/*     */   {
/* 400 */     return this.hasPay;
/*     */   }
/*     */ 
/*     */   public void setHasPay(String hasPay)
/*     */   {
/* 407 */     this.hasPay = hasPay;
/*     */   }
/*     */ 
/*     */   public String getSellerAccount()
/*     */   {
/* 414 */     return this.sellerAccount;
/*     */   }
/*     */ 
/*     */   public void setSellerAccount(String sellerAccount)
/*     */   {
/* 421 */     this.sellerAccount = sellerAccount;
/*     */   }
/*     */ 
/*     */   public String getBuyerAccount()
/*     */   {
/* 428 */     return this.buyerAccount;
/*     */   }
/*     */ 
/*     */   public void setBuyerAccount(String buyerAccount)
/*     */   {
/* 435 */     this.buyerAccount = buyerAccount;
/*     */   }
/*     */ 
/*     */   public Date getExpectTime()
/*     */   {
/* 442 */     return this.expectTime;
/*     */   }
/*     */ 
/*     */   public void setExpectTime(Date expectTime)
/*     */   {
/* 449 */     this.expectTime = expectTime;
/*     */   }
/*     */ 
/*     */   public Date getEndDatePay()
/*     */   {
/* 456 */     return this.endDatePay;
/*     */   }
/*     */ 
/*     */   public void setEndDatePay(Date endDatePay)
/*     */   {
/* 463 */     this.endDatePay = endDatePay;
/*     */   }
/*     */ 
/*     */   public Date getEndDateGoods()
/*     */   {
/* 470 */     return this.endDateGoods;
/*     */   }
/*     */ 
/*     */   public void setEndDateGoods(Date endDateGoods)
/*     */   {
/* 477 */     this.endDateGoods = endDateGoods;
/*     */   }
/*     */ 
/*     */   public Date getEndDateBill()
/*     */   {
/* 484 */     return this.endDateBill;
/*     */   }
/*     */ 
/*     */   public void setEndDateBill(Date endDateBill)
/*     */   {
/* 491 */     this.endDateBill = endDateBill;
/*     */   }
/*     */ 
/*     */   public String getHasSellerRank()
/*     */   {
/* 498 */     return this.hasSellerRank;
/*     */   }
/*     */ 
/*     */   public void setHasSellerRank(String hasSellerRank)
/*     */   {
/* 505 */     this.hasSellerRank = hasSellerRank;
/*     */   }
/*     */ 
/*     */   public String getHasBuyerRank()
/*     */   {
/* 512 */     return this.hasBuyerRank;
/*     */   }
/*     */ 
/*     */   public void setHasBuyerRank(String hasBuyerRank)
/*     */   {
/* 519 */     this.hasBuyerRank = hasBuyerRank;
/*     */   }
/*     */ 
/*     */   public String getHasInvoice()
/*     */   {
/* 526 */     return this.hasInvoice;
/*     */   }
/*     */ 
/*     */   public void setHasInvoice(String hasInvoice)
/*     */   {
/* 533 */     this.hasInvoice = hasInvoice;
/*     */   }
/*     */ 
/*     */   public String getWishOrderNum()
/*     */   {
/* 540 */     return this.wishOrderNum;
/*     */   }
/*     */ 
/*     */   public void setWishOrderNum(String wishOrderNum)
/*     */   {
/* 547 */     this.wishOrderNum = wishOrderNum;
/*     */   }
/*     */ 
/*     */   public String getProjectCode()
/*     */   {
/* 554 */     return this.projectCode;
/*     */   }
/*     */ 
/*     */   public void setProjectCode(String projectCode)
/*     */   {
/* 561 */     this.projectCode = projectCode;
/*     */   }
/*     */ 
/*     */   public String getProjectName()
/*     */   {
/* 568 */     return this.projectName;
/*     */   }
/*     */ 
/*     */   public void setProjectName(String projectName)
/*     */   {
/* 575 */     this.projectName = projectName;
/*     */   }
/*     */ 
/*     */   public String getStatus()
/*     */   {
/* 598 */     return this.status;
/*     */   }
/*     */ 
/*     */   public void setStatus(String status)
/*     */   {
/* 621 */     this.status = status;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate()
/*     */   {
/* 628 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate)
/*     */   {
/* 635 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify()
/*     */   {
/* 642 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify)
/*     */   {
/* 649 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getCreator()
/*     */   {
/* 656 */     return this.creator;
/*     */   }
/*     */ 
/*     */   public void setCreator(String creator)
/*     */   {
/* 663 */     this.creator = creator;
/*     */   }
/*     */ 
/*     */   public String getOperator()
/*     */   {
/* 670 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator)
/*     */   {
/* 677 */     this.operator = operator;
/*     */   }
/*     */ 
/*     */   public String getTradingTypeDesc()
/*     */   {
/* 685 */     EnumTradingType type = EnumTradingType.indexByValue(this.tradingType);
/* 686 */     if (null == type) {
/* 687 */       return this.tradingType;
/*     */     }
/* 689 */     return type.getName();
/*     */   }
/*     */ 
/*     */   public String getOrderAmountDesc()
/*     */   {
/* 697 */     return CommonUtils.getValuationUnitDesc(this.orderAmount, this.valuationUnit);
/*     */   }
/*     */ 
/*     */   public String getStatusDesc()
/*     */   {
/* 704 */     EnumTradeOrderStatus orderStatus = EnumTradeOrderStatus.indexByValue(this.status);
/* 705 */     if (null == orderStatus) {
/* 706 */       return this.status;
/*     */     }
/* 708 */     return orderStatus.getName();
/*     */   }
/*     */ 
/*     */   public boolean isBuyerOrder(String userAccount)
/*     */   {
/* 717 */     if (null != userAccount) {
/* 718 */       return userAccount.equals(this.buyerAccount);
/*     */     }
/* 720 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean isSellerOrder(String userAccount)
/*     */   {
/* 729 */     if (null != userAccount) {
/* 730 */       return userAccount.equals(this.sellerAccount);
/*     */     }
/* 732 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean isCouldConfirm(String userAccount)
/*     */   {
/* 741 */     if (EnumTradeOrderStatus.WAIT_PAYCONFIRM.getValue().equals(this.status)) {
/* 742 */       if (isBuyerOrder(userAccount)) {
/* 743 */         if (EnumActiveStatus.No.getValue().equals(this.hasBuyerConfirm))
/* 744 */           return true;
/*     */       }
/* 746 */       else if ((isSellerOrder(userAccount)) && 
/* 747 */         (EnumActiveStatus.No.getValue().equals(this.hasSellerConfirm))) {
/* 748 */         return true;
/*     */       }
/*     */     }
/*     */ 
/* 752 */     return false;
/*     */   }
/*     */ 
/*     */   public String getMeasureUnitDesc() {
/* 756 */     EnumMeasureUnit unit = EnumMeasureUnit.indexByValue(this.measureUnit);
/* 757 */     if (null == unit) {
/* 758 */       return this.measureUnit;
/*     */     }
/* 760 */     return unit.getName();
/*     */   }
/*     */ 
/*     */   public Date getEndDateSendGoods() {
/* 764 */     return this.endDateSendGoods;
/*     */   }
/*     */ 
/*     */   public void setEndDateSendGoods(Date endDateSendGoods) {
/* 768 */     this.endDateSendGoods = endDateSendGoods;
/*     */   }
/*     */ 
/*     */   public Date getEndDateConfirm() {
/* 772 */     return this.endDateConfirm;
/*     */   }
/*     */ 
/*     */   public void setEndDateConfirm(Date endDateConfirm) {
/* 776 */     this.endDateConfirm = endDateConfirm;
/*     */   }
/*     */ 
/*     */   public Long getSubstationId() {
/* 780 */     return this.substationId;
/*     */   }
/*     */ 
/*     */   public void setSubstationId(Long substationId) {
/* 784 */     this.substationId = substationId;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.order.TradeOrder
 * JD-Core Version:    0.6.0
 */