/*     */ package com.hundsun.network.gates.genshan.biz.domain.trade;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.domain.BaseDomain;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumDeliveryType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumInvoice;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumMeasureUnit;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumPaymentType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeDirect;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeWishOrderStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradingType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumValuationUnit;
/*     */ import com.hundsun.network.gates.luosi.common.utils.CommonUtils;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class TradeWishOrder extends BaseDomain
/*     */ {
/*     */   private static final long serialVersionUID = -7694051662881015635L;
/*     */   private Long id;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */   private String wishOrderNum;
/*     */   private Long projectId;
/*     */   private String projectName;
/*     */   private String projectCode;
/*     */   private String tradeDictor;
/*     */   private String userAccount;
/*     */   private Long bidPrice;
/*     */   private String valuationUnit;
/*     */   private Long quantity;
/*     */   private String measureUnit;
/*     */   private Long totalPay;
/*     */   private String status;
/*     */   private String tradeType;
/*     */   private String paymentType;
/*     */   private Date expectTime;
/*     */   private String isInvoice;
/*     */   private String deal;
/*     */   private String deliveryType;
/*     */   private String linkMan;
/*     */   private String phone;
/*     */   private String province;
/*     */   private String city;
/*     */   private String area;
/*     */   private String address;
/*     */   private String trademark;
/*     */   private String comments;
/*     */   private String specialSign;
/*     */   private Long deposit;
/*     */   private String zipCode;
/*     */   private String storehouse;
/*     */   private Long substationId;
/*     */   private String fundAccount;
/*     */ 
/*     */   public Long getId()
/*     */   {
/* 237 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/* 241 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate()
/*     */   {
/* 248 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate)
/*     */   {
/* 255 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify() {
/* 259 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify) {
/* 263 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getProjectName()
/*     */   {
/* 270 */     return this.projectName;
/*     */   }
/*     */ 
/*     */   public void setProjectName(String projectName)
/*     */   {
/* 277 */     this.projectName = projectName;
/*     */   }
/*     */ 
/*     */   public String getProjectCode() {
/* 281 */     return this.projectCode;
/*     */   }
/*     */ 
/*     */   public void setProjectCode(String projectCode) {
/* 285 */     this.projectCode = projectCode;
/*     */   }
/*     */ 
/*     */   public String getTradeDictor()
/*     */   {
/* 298 */     return this.tradeDictor;
/*     */   }
/*     */ 
/*     */   public void setTradeDictor(String tradeDictor)
/*     */   {
/* 311 */     this.tradeDictor = tradeDictor;
/*     */   }
/*     */ 
/*     */   public String getUserAccount()
/*     */   {
/* 318 */     return this.userAccount;
/*     */   }
/*     */ 
/*     */   public void setUserAccount(String userAccount)
/*     */   {
/* 325 */     this.userAccount = userAccount;
/*     */   }
/*     */ 
/*     */   public Long getBidPrice()
/*     */   {
/* 332 */     return this.bidPrice;
/*     */   }
/*     */ 
/*     */   public void setBidPrice(Long bidPrice)
/*     */   {
/* 339 */     this.bidPrice = bidPrice;
/*     */   }
/*     */ 
/*     */   public String getValuationUnit()
/*     */   {
/* 348 */     return this.valuationUnit;
/*     */   }
/*     */ 
/*     */   public void setValuationUnit(String valuationUnit)
/*     */   {
/* 357 */     this.valuationUnit = valuationUnit;
/*     */   }
/*     */ 
/*     */   public Long getQuantity()
/*     */   {
/* 364 */     return this.quantity;
/*     */   }
/*     */ 
/*     */   public void setQuantity(Long quantity)
/*     */   {
/* 371 */     this.quantity = quantity;
/*     */   }
/*     */ 
/*     */   public String getMeasureUnit()
/*     */   {
/* 378 */     return this.measureUnit;
/*     */   }
/*     */ 
/*     */   public void setMeasureUnit(String measureUnit)
/*     */   {
/* 385 */     this.measureUnit = measureUnit;
/*     */   }
/*     */ 
/*     */   public Long getTotalPay()
/*     */   {
/* 392 */     return this.totalPay;
/*     */   }
/*     */ 
/*     */   public void setTotalPay(Long totalPay)
/*     */   {
/* 399 */     this.totalPay = totalPay;
/*     */   }
/*     */ 
/*     */   public String getStatus()
/*     */   {
/* 412 */     return this.status;
/*     */   }
/*     */ 
/*     */   public void setStatus(String status)
/*     */   {
/* 425 */     this.status = status;
/*     */   }
/*     */ 
/*     */   public String getTradeType()
/*     */   {
/* 440 */     return this.tradeType;
/*     */   }
/*     */ 
/*     */   public void setTradeType(String tradeType)
/*     */   {
/* 455 */     this.tradeType = tradeType;
/*     */   }
/*     */ 
/*     */   public String getPaymentType()
/*     */   {
/* 468 */     return this.paymentType;
/*     */   }
/*     */ 
/*     */   public void setPaymentType(String paymentType)
/*     */   {
/* 481 */     this.paymentType = paymentType;
/*     */   }
/*     */ 
/*     */   public Date getExpectTime()
/*     */   {
/* 488 */     return this.expectTime;
/*     */   }
/*     */ 
/*     */   public void setExpectTime(Date expectTime)
/*     */   {
/* 495 */     this.expectTime = expectTime;
/*     */   }
/*     */ 
/*     */   public String getIsInvoice()
/*     */   {
/* 506 */     return this.isInvoice;
/*     */   }
/*     */ 
/*     */   public void setIsInvoice(String isInvoice)
/*     */   {
/* 517 */     this.isInvoice = isInvoice;
/*     */   }
/*     */ 
/*     */   public String getDeal()
/*     */   {
/* 524 */     return this.deal;
/*     */   }
/*     */ 
/*     */   public void setDeal(String deal)
/*     */   {
/* 531 */     this.deal = deal;
/*     */   }
/*     */ 
/*     */   public String getDeliveryType()
/*     */   {
/* 542 */     return this.deliveryType;
/*     */   }
/*     */ 
/*     */   public void setDeliveryType(String deliveryType)
/*     */   {
/* 553 */     this.deliveryType = deliveryType;
/*     */   }
/*     */ 
/*     */   public String getLinkMan()
/*     */   {
/* 560 */     return this.linkMan;
/*     */   }
/*     */ 
/*     */   public void setLinkMan(String linkMan)
/*     */   {
/* 567 */     this.linkMan = linkMan;
/*     */   }
/*     */ 
/*     */   public String getProvince()
/*     */   {
/* 576 */     return this.province;
/*     */   }
/*     */ 
/*     */   public void setProvince(String province)
/*     */   {
/* 585 */     this.province = province;
/*     */   }
/*     */ 
/*     */   public String getCity()
/*     */   {
/* 592 */     return this.city;
/*     */   }
/*     */ 
/*     */   public void setCity(String city)
/*     */   {
/* 599 */     this.city = city;
/*     */   }
/*     */ 
/*     */   public String getArea()
/*     */   {
/* 606 */     return this.area;
/*     */   }
/*     */ 
/*     */   public void setArea(String area)
/*     */   {
/* 613 */     this.area = area;
/*     */   }
/*     */ 
/*     */   public String getTrademark()
/*     */   {
/* 620 */     return this.trademark;
/*     */   }
/*     */ 
/*     */   public void setTrademark(String trademark)
/*     */   {
/* 627 */     this.trademark = trademark;
/*     */   }
/*     */ 
/*     */   public String getComments()
/*     */   {
/* 634 */     return this.comments;
/*     */   }
/*     */ 
/*     */   public void setComments(String comments)
/*     */   {
/* 641 */     this.comments = comments;
/*     */   }
/*     */ 
/*     */   public String getSpecialSign()
/*     */   {
/* 650 */     return this.specialSign;
/*     */   }
/*     */ 
/*     */   public void setSpecialSign(String specialSign)
/*     */   {
/* 659 */     this.specialSign = specialSign;
/*     */   }
/*     */ 
/*     */   public Long getDeposit()
/*     */   {
/* 666 */     return this.deposit;
/*     */   }
/*     */ 
/*     */   public void setDeposit(Long deposit)
/*     */   {
/* 673 */     this.deposit = deposit;
/*     */   }
/*     */ 
/*     */   public void setProjectId(Long projectId) {
/* 677 */     this.projectId = projectId;
/*     */   }
/*     */ 
/*     */   public Long getProjectId() {
/* 681 */     return this.projectId;
/*     */   }
/*     */ 
/*     */   public String getMeasureUnitDesc() {
/* 685 */     EnumMeasureUnit measureUnitEnum = EnumMeasureUnit.indexByValue(this.measureUnit);
/* 686 */     if (null == measureUnitEnum) {
/* 687 */       return this.measureUnit;
/*     */     }
/* 689 */     return measureUnitEnum.getName();
/*     */   }
/*     */ 
/*     */   public String getValuationUnitDesc() {
/* 693 */     EnumValuationUnit valuationUnitEnum = EnumValuationUnit.indexByValue(this.valuationUnit);
/* 694 */     if (null == valuationUnitEnum) {
/* 695 */       return this.valuationUnit;
/*     */     }
/* 697 */     return valuationUnitEnum.getName();
/*     */   }
/*     */ 
/*     */   public String getTradeTypeDesc() {
/* 701 */     EnumTradingType tradingTypeEnum = EnumTradingType.indexByValue(this.tradeType);
/* 702 */     if (null == tradingTypeEnum) {
/* 703 */       return this.tradeType;
/*     */     }
/* 705 */     return tradingTypeEnum.getName();
/*     */   }
/*     */ 
/*     */   public String getPaymentTypeDesc() {
/* 709 */     EnumPaymentType paymentTypeEnum = EnumPaymentType.indexByValue(this.paymentType);
/* 710 */     if (null == paymentTypeEnum) {
/* 711 */       return this.paymentType;
/*     */     }
/* 713 */     return paymentTypeEnum.getName();
/*     */   }
/*     */ 
/*     */   public String getStatusDesc() {
/* 717 */     EnumTradeWishOrderStatus tradeWishOrderStatusEnum = EnumTradeWishOrderStatus.indexByValue(this.status);
/*     */ 
/* 719 */     if (null == tradeWishOrderStatusEnum) {
/* 720 */       return this.status;
/*     */     }
/* 722 */     return tradeWishOrderStatusEnum.getName();
/*     */   }
/*     */ 
/*     */   public String getDeliveryTypeDesc() {
/* 726 */     EnumDeliveryType deliveryTypeEnum = EnumDeliveryType.indexByValue(this.deliveryType);
/* 727 */     if (null == deliveryTypeEnum) {
/* 728 */       return this.deliveryType;
/*     */     }
/* 730 */     return deliveryTypeEnum.getName();
/*     */   }
/*     */ 
/*     */   public String getTradeDictorDesc() {
/* 734 */     EnumTradeDirect tradeDirectEnum = EnumTradeDirect.indexByValue(this.tradeDictor);
/* 735 */     if (null == tradeDirectEnum) {
/* 736 */       return this.tradeDictor;
/*     */     }
/* 738 */     return tradeDirectEnum.getName();
/*     */   }
/*     */ 
/*     */   public String getBidPriceDesc()
/*     */   {
/* 746 */     return CommonUtils.getValuationUnitDesc(this.bidPrice, this.valuationUnit);
/*     */   }
/*     */ 
/*     */   public String getTotalPayDesc()
/*     */   {
/* 754 */     return CommonUtils.getValuationUnitDesc(this.totalPay, this.valuationUnit);
/*     */   }
/*     */ 
/*     */   public void setAddress(String address) {
/* 758 */     this.address = address;
/*     */   }
/*     */ 
/*     */   public String getAddress() {
/* 762 */     return this.address;
/*     */   }
/*     */ 
/*     */   public void setZipCode(String zipCode) {
/* 766 */     this.zipCode = zipCode;
/*     */   }
/*     */ 
/*     */   public String getZipCode() {
/* 770 */     return this.zipCode;
/*     */   }
/*     */ 
/*     */   public void setWishOrderNum(String wishOrderNum) {
/* 774 */     this.wishOrderNum = wishOrderNum;
/*     */   }
/*     */ 
/*     */   public String getWishOrderNum() {
/* 778 */     return this.wishOrderNum;
/*     */   }
/*     */ 
/*     */   public void setPhone(String phone) {
/* 782 */     this.phone = phone;
/*     */   }
/*     */ 
/*     */   public String getPhone() {
/* 786 */     return this.phone;
/*     */   }
/*     */ 
/*     */   public String getInvoiceDesc() {
/* 790 */     EnumInvoice invoiceEnum = EnumInvoice.indexByValue(this.isInvoice);
/* 791 */     if (null == invoiceEnum) {
/* 792 */       return this.isInvoice;
/*     */     }
/* 794 */     return invoiceEnum.getName();
/*     */   }
/*     */ 
/*     */   public Boolean isShowBidOrderHis()
/*     */   {
/* 802 */     return Boolean.valueOf((StringUtil.isNotEmpty(this.projectCode)) && ((EnumTradingType.BID_ORDER.getValue().equals(this.tradeType)) || (EnumTradingType.MULIT_BID_ORDER.getValue().equals(this.tradeType))) && ((EnumTradeWishOrderStatus.DONE.getValue().equals(this.status)) || (EnumTradeWishOrderStatus.CANCEL.getValue().equals(this.status)) || (EnumTradeWishOrderStatus.UNDONECANCEL.getValue().equals(this.status)) || (EnumTradeWishOrderStatus.WDCANCEL.getValue().equals(this.status))));
/*     */   }
/*     */ 
/*     */   public void setStorehouse(String storehouse)
/*     */   {
/* 812 */     this.storehouse = storehouse;
/*     */   }
/*     */ 
/*     */   public String getStorehouse() {
/* 816 */     return this.storehouse;
/*     */   }
/*     */ 
/*     */   public Long getSubstationId() {
/* 820 */     return this.substationId;
/*     */   }
/*     */ 
/*     */   public void setSubstationId(Long substationId) {
/* 824 */     this.substationId = substationId;
/*     */   }
/*     */ 
/*     */   public String getFundAccount() {
/* 828 */     return this.fundAccount;
/*     */   }
/*     */ 
/*     */   public void setFundAccount(String fundAccount) {
/* 832 */     this.fundAccount = fundAccount;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.trade.TradeWishOrder
 * JD-Core Version:    0.6.0
 */