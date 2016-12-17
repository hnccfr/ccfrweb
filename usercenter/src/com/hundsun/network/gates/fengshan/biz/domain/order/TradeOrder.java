/*     */ package com.hundsun.network.gates.fengshan.biz.domain.order;
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
/*     */ 
/*     */   public Long getId()
/*     */   {
/* 196 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/* 200 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getOrderNo()
/*     */   {
/* 207 */     return this.orderNo;
/*     */   }
/*     */ 
/*     */   public void setOrderNo(String orderNo)
/*     */   {
/* 214 */     this.orderNo = orderNo;
/*     */   }
/*     */ 
/*     */   public String getTradingType()
/*     */   {
/* 221 */     return this.tradingType;
/*     */   }
/*     */ 
/*     */   public void setTradingType(String tradingType)
/*     */   {
/* 228 */     this.tradingType = tradingType;
/*     */   }
/*     */ 
/*     */   public Long getBidPrice()
/*     */   {
/* 235 */     return this.bidPrice;
/*     */   }
/*     */ 
/*     */   public void setBidPrice(Long bidPrice)
/*     */   {
/* 242 */     this.bidPrice = bidPrice;
/*     */   }
/*     */ 
/*     */   public String getValuationUnit()
/*     */   {
/* 251 */     return this.valuationUnit;
/*     */   }
/*     */ 
/*     */   public void setValuationUnit(String valuationUnit)
/*     */   {
/* 260 */     this.valuationUnit = valuationUnit;
/*     */   }
/*     */ 
/*     */   public Long getQuantity()
/*     */   {
/* 267 */     return this.quantity;
/*     */   }
/*     */ 
/*     */   public void setQuantity(Long quantity)
/*     */   {
/* 274 */     this.quantity = quantity;
/*     */   }
/*     */ 
/*     */   public String getMeasureUnit()
/*     */   {
/* 281 */     return this.measureUnit;
/*     */   }
/*     */ 
/*     */   public void setMeasureUnit(String measureUnit)
/*     */   {
/* 288 */     this.measureUnit = measureUnit;
/*     */   }
/*     */ 
/*     */   public Long getOrderAmount()
/*     */   {
/* 295 */     return this.orderAmount;
/*     */   }
/*     */ 
/*     */   public void setOrderAmount(Long orderAmount)
/*     */   {
/* 302 */     this.orderAmount = orderAmount;
/*     */   }
/*     */ 
/*     */   public String getHasSellerConfirm()
/*     */   {
/* 309 */     return this.hasSellerConfirm;
/*     */   }
/*     */ 
/*     */   public void setHasSellerConfirm(String hasSellerConfirm)
/*     */   {
/* 316 */     this.hasSellerConfirm = hasSellerConfirm;
/*     */   }
/*     */ 
/*     */   public String getHasBuyerConfirm()
/*     */   {
/* 323 */     return this.hasBuyerConfirm;
/*     */   }
/*     */ 
/*     */   public void setHasBuyerConfirm(String hasBuyerConfirm)
/*     */   {
/* 330 */     this.hasBuyerConfirm = hasBuyerConfirm;
/*     */   }
/*     */ 
/*     */   public Long getSellerDepositAmount()
/*     */   {
/* 337 */     return this.sellerDepositAmount;
/*     */   }
/*     */ 
/*     */   public void setSellerDepositAmount(Long sellerDepositAmount)
/*     */   {
/* 344 */     this.sellerDepositAmount = sellerDepositAmount;
/*     */   }
/*     */ 
/*     */   public Long getBuyerDepositAmount()
/*     */   {
/* 351 */     return this.buyerDepositAmount;
/*     */   }
/*     */ 
/*     */   public void setBuyerDepositAmount(Long buyerDepositAmount)
/*     */   {
/* 358 */     this.buyerDepositAmount = buyerDepositAmount;
/*     */   }
/*     */ 
/*     */   public String getDeliveryType()
/*     */   {
/* 365 */     return this.deliveryType;
/*     */   }
/*     */ 
/*     */   public void setDeliveryType(String deliveryType)
/*     */   {
/* 372 */     this.deliveryType = deliveryType;
/*     */   }
/*     */ 
/*     */   public String getPaymentType()
/*     */   {
/* 379 */     return this.paymentType;
/*     */   }
/*     */ 
/*     */   public void setPaymentType(String paymentType)
/*     */   {
/* 386 */     this.paymentType = paymentType;
/*     */   }
/*     */ 
/*     */   public String getHasPay()
/*     */   {
/* 393 */     return this.hasPay;
/*     */   }
/*     */ 
/*     */   public void setHasPay(String hasPay)
/*     */   {
/* 400 */     this.hasPay = hasPay;
/*     */   }
/*     */ 
/*     */   public String getSellerAccount()
/*     */   {
/* 407 */     return this.sellerAccount;
/*     */   }
/*     */ 
/*     */   public void setSellerAccount(String sellerAccount)
/*     */   {
/* 414 */     this.sellerAccount = sellerAccount;
/*     */   }
/*     */ 
/*     */   public String getBuyerAccount()
/*     */   {
/* 421 */     return this.buyerAccount;
/*     */   }
/*     */ 
/*     */   public void setBuyerAccount(String buyerAccount)
/*     */   {
/* 428 */     this.buyerAccount = buyerAccount;
/*     */   }
/*     */ 
/*     */   public Date getExpectTime()
/*     */   {
/* 435 */     return this.expectTime;
/*     */   }
/*     */ 
/*     */   public void setExpectTime(Date expectTime)
/*     */   {
/* 442 */     this.expectTime = expectTime;
/*     */   }
/*     */ 
/*     */   public Date getEndDatePay()
/*     */   {
/* 449 */     return this.endDatePay;
/*     */   }
/*     */ 
/*     */   public void setEndDatePay(Date endDatePay)
/*     */   {
/* 456 */     this.endDatePay = endDatePay;
/*     */   }
/*     */ 
/*     */   public Date getEndDateGoods()
/*     */   {
/* 463 */     return this.endDateGoods;
/*     */   }
/*     */ 
/*     */   public void setEndDateGoods(Date endDateGoods)
/*     */   {
/* 470 */     this.endDateGoods = endDateGoods;
/*     */   }
/*     */ 
/*     */   public Date getEndDateBill()
/*     */   {
/* 477 */     return this.endDateBill;
/*     */   }
/*     */ 
/*     */   public void setEndDateBill(Date endDateBill)
/*     */   {
/* 484 */     this.endDateBill = endDateBill;
/*     */   }
/*     */ 
/*     */   public String getHasSellerRank()
/*     */   {
/* 491 */     return this.hasSellerRank;
/*     */   }
/*     */ 
/*     */   public void setHasSellerRank(String hasSellerRank)
/*     */   {
/* 498 */     this.hasSellerRank = hasSellerRank;
/*     */   }
/*     */ 
/*     */   public String getHasBuyerRank()
/*     */   {
/* 505 */     return this.hasBuyerRank;
/*     */   }
/*     */ 
/*     */   public void setHasBuyerRank(String hasBuyerRank)
/*     */   {
/* 512 */     this.hasBuyerRank = hasBuyerRank;
/*     */   }
/*     */ 
/*     */   public String getHasInvoice()
/*     */   {
/* 519 */     return this.hasInvoice;
/*     */   }
/*     */ 
/*     */   public void setHasInvoice(String hasInvoice)
/*     */   {
/* 526 */     this.hasInvoice = hasInvoice;
/*     */   }
/*     */ 
/*     */   public String getWishOrderNum()
/*     */   {
/* 533 */     return this.wishOrderNum;
/*     */   }
/*     */ 
/*     */   public void setWishOrderNum(String wishOrderNum)
/*     */   {
/* 540 */     this.wishOrderNum = wishOrderNum;
/*     */   }
/*     */ 
/*     */   public String getProjectCode()
/*     */   {
/* 547 */     return this.projectCode;
/*     */   }
/*     */ 
/*     */   public void setProjectCode(String projectCode)
/*     */   {
/* 554 */     this.projectCode = projectCode;
/*     */   }
/*     */ 
/*     */   public String getProjectName()
/*     */   {
/* 561 */     return this.projectName;
/*     */   }
/*     */ 
/*     */   public void setProjectName(String projectName)
/*     */   {
/* 568 */     this.projectName = projectName;
/*     */   }
/*     */ 
/*     */   public String getStatus()
/*     */   {
/* 591 */     return this.status;
/*     */   }
/*     */ 
/*     */   public void setStatus(String status)
/*     */   {
/* 614 */     this.status = status;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate()
/*     */   {
/* 621 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate)
/*     */   {
/* 628 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify()
/*     */   {
/* 635 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify)
/*     */   {
/* 642 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getCreator()
/*     */   {
/* 649 */     return this.creator;
/*     */   }
/*     */ 
/*     */   public void setCreator(String creator)
/*     */   {
/* 656 */     this.creator = creator;
/*     */   }
/*     */ 
/*     */   public String getOperator()
/*     */   {
/* 663 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator)
/*     */   {
/* 670 */     this.operator = operator;
/*     */   }
/*     */ 
/*     */   public String getTradingTypeDesc()
/*     */   {
/* 678 */     EnumTradingType type = EnumTradingType.indexByValue(this.tradingType);
/* 679 */     if (null == type) {
/* 680 */       return this.tradingType;
/*     */     }
/* 682 */     return type.getName();
/*     */   }
/*     */ 
/*     */   public String getOrderAmountDesc()
/*     */   {
/* 690 */     return CommonUtils.getValuationUnitDesc(this.orderAmount, this.valuationUnit);
/*     */   }
/*     */ 
/*     */   public String getBidPriceDesc()
/*     */   {
/* 698 */     return CommonUtils.getValuationUnitDesc(this.bidPrice, this.valuationUnit);
/*     */   }
/*     */ 
/*     */   public String getStatusDesc()
/*     */   {
/* 705 */     EnumTradeOrderStatus orderStatus = EnumTradeOrderStatus.indexByValue(this.status);
/* 706 */     if (null == orderStatus) {
/* 707 */       return this.status;
/*     */     }
/* 709 */     if (orderStatus == EnumTradeOrderStatus.WAIT_PAYCONFIRM) {
/* 710 */       if (EnumActiveStatus.Yes.getValue().equals(this.hasBuyerConfirm))
/* 711 */         return "等待卖家确认";
/* 712 */       if (EnumActiveStatus.Yes.getValue().equals(this.hasSellerConfirm)) {
/* 713 */         return "等待买家确认";
/*     */       }
/* 715 */       return "等待双方确认";
/*     */     }
/*     */ 
/* 718 */     return orderStatus.getName();
/*     */   }
/*     */ 
/*     */   public boolean isBuyerOrder(String userAccount)
/*     */   {
/* 727 */     if (null != userAccount) {
/* 728 */       return userAccount.equals(this.buyerAccount);
/*     */     }
/* 730 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean isSellerOrder(String userAccount)
/*     */   {
/* 739 */     if (null != userAccount) {
/* 740 */       return userAccount.equals(this.sellerAccount);
/*     */     }
/* 742 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean isCouldConfirm(String userAccount)
/*     */   {
/* 751 */     if (EnumTradeOrderStatus.WAIT_PAYCONFIRM.getValue().equals(this.status)) {
/* 752 */       if (isBuyerOrder(userAccount)) {
/* 753 */         if (EnumActiveStatus.No.getValue().equals(this.hasBuyerConfirm))
/* 754 */           return true;
/*     */       }
/* 756 */       else if ((isSellerOrder(userAccount)) && 
/* 757 */         (EnumActiveStatus.No.getValue().equals(this.hasSellerConfirm))) {
/* 758 */         return true;
/*     */       }
/*     */     }
/*     */ 
/* 762 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean isCouldCheckGoods(String userAccount)
/*     */   {
/* 773 */     return (EnumTradeOrderStatus.WAIT_CHECKGOODS.getValue().equals(this.status)) && 
/* 772 */       (isBuyerOrder(userAccount));
/*     */   }
/*     */ 
/*     */   public Date getEndDateSendGoods()
/*     */   {
/* 780 */     return this.endDateSendGoods;
/*     */   }
/*     */ 
/*     */   public void setEndDateSendGoods(Date endDateSendGoods) {
/* 784 */     this.endDateSendGoods = endDateSendGoods;
/*     */   }
/*     */ 
/*     */   public String getComplainAble()
/*     */   {
/* 792 */     if ((this.status.equals(EnumTradeOrderStatus.FINISHED.getValue())) || (this.status.equals(EnumTradeOrderStatus.COLSE.getValue())) || (this.status.equals(EnumTradeOrderStatus.CANCEL.getValue())))
/*     */     {
/* 795 */       return "no";
/*     */     }
/* 797 */     return "yes";
/*     */   }
/*     */ 
/*     */   public String getMeasureUnitDesc()
/*     */   {
/* 802 */     EnumMeasureUnit unit = EnumMeasureUnit.indexByValue(this.measureUnit);
/* 803 */     if (null == unit) {
/* 804 */       return this.measureUnit;
/*     */     }
/* 806 */     return unit.getName();
/*     */   }
/*     */ 
/*     */   public Date getEndDateConfirm() {
/* 810 */     return this.endDateConfirm;
/*     */   }
/*     */ 
/*     */   public void setEndDateConfirm(Date endDateConfirm) {
/* 814 */     this.endDateConfirm = endDateConfirm;
/*     */   }
/*     */ 
/*     */   public boolean isWaitOpt()
/*     */   {
/* 827 */     return (EnumTradeOrderStatus.WAIT_CHECKGOODS.getValue().equals(getStatus())) || (EnumTradeOrderStatus.WAIT_CHECKTICKET.getValue().equals(getStatus())) || (EnumTradeOrderStatus.WAIT_PAYCONFIRM.getValue().equals(getStatus())) || (EnumTradeOrderStatus.WAIT_PAYGOODS.getValue().equals(getStatus())) || (EnumTradeOrderStatus.WAIT_SENDGOODS.getValue().equals(getStatus()));
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.domain.order.TradeOrder
 * JD-Core Version:    0.6.0
 */