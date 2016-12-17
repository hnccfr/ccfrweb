/*     */ package com.hundsun.network.gates.fengshan.biz.domain.trade;
/*     */ 
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.BaseDomain;
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
/*     */ 
/*     */   public String getStorehouse()
/*     */   {
/* 229 */     return this.storehouse;
/*     */   }
/*     */ 
/*     */   public void setStorehouse(String storehouse) {
/* 233 */     this.storehouse = storehouse;
/*     */   }
/*     */ 
/*     */   public Long getId() {
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
/* 667 */     return this.deposit;
/*     */   }
/*     */ 
/*     */   public void setDeposit(Long deposit)
/*     */   {
/* 675 */     this.deposit = deposit;
/*     */   }
/*     */ 
/*     */   public void setProjectId(Long projectId) {
/* 679 */     this.projectId = projectId;
/*     */   }
/*     */ 
/*     */   public Long getProjectId() {
/* 683 */     return this.projectId;
/*     */   }
/*     */ 
/*     */   public String getMeasureUnitDesc() {
/* 687 */     EnumMeasureUnit measureUnitEnum = EnumMeasureUnit.indexByValue(this.measureUnit);
/* 688 */     if (null == measureUnitEnum) {
/* 689 */       return this.measureUnit;
/*     */     }
/* 691 */     return measureUnitEnum.getName();
/*     */   }
/*     */ 
/*     */   public String getValuationUnitDesc() {
/* 695 */     EnumValuationUnit valuationUnitEnum = EnumValuationUnit.indexByValue(this.valuationUnit);
/* 696 */     if (null == valuationUnitEnum) {
/* 697 */       return this.valuationUnit;
/*     */     }
/* 699 */     return valuationUnitEnum.getName();
/*     */   }
/*     */ 
/*     */   public String getTradeTypeDesc() {
/* 703 */     EnumTradingType tradingTypeEnum = EnumTradingType.indexByValue(this.tradeType);
/* 704 */     if (null == tradingTypeEnum) {
/* 705 */       return this.tradeType;
/*     */     }
/* 707 */     return tradingTypeEnum.getName();
/*     */   }
/*     */ 
/*     */   public String getPaymentTypeDesc() {
/* 711 */     EnumPaymentType paymentTypeEnum = EnumPaymentType.indexByValue(this.paymentType);
/* 712 */     if (null == paymentTypeEnum) {
/* 713 */       return this.paymentType;
/*     */     }
/* 715 */     return paymentTypeEnum.getName();
/*     */   }
/*     */ 
/*     */   public String getStatusDesc() {
/* 719 */     EnumTradeWishOrderStatus tradeWishOrderStatusEnum = EnumTradeWishOrderStatus.indexByValue(this.status);
/*     */ 
/* 721 */     if (null == tradeWishOrderStatusEnum) {
/* 722 */       return this.status;
/*     */     }
/* 724 */     return tradeWishOrderStatusEnum.getName();
/*     */   }
/*     */ 
/*     */   public String getDeliveryTypeDesc() {
/* 728 */     EnumDeliveryType deliveryTypeEnum = EnumDeliveryType.indexByValue(this.deliveryType);
/* 729 */     if (null == deliveryTypeEnum) {
/* 730 */       return this.deliveryType;
/*     */     }
/* 732 */     return deliveryTypeEnum.getName();
/*     */   }
/*     */ 
/*     */   public String getTradeDictorDesc() {
/* 736 */     EnumTradeDirect tradeDirectEnum = EnumTradeDirect.indexByValue(this.tradeDictor);
/* 737 */     if (null == tradeDirectEnum) {
/* 738 */       return this.tradeDictor;
/*     */     }
/* 740 */     return tradeDirectEnum.getName();
/*     */   }
/*     */ 
/*     */   public void setWishOrderNum(String wishOrderNum) {
/* 744 */     this.wishOrderNum = wishOrderNum;
/*     */   }
/*     */ 
/*     */   public String getWishOrderNum() {
/* 748 */     return this.wishOrderNum;
/*     */   }
/*     */ 
/*     */   public void setZipCode(String zipCode) {
/* 752 */     this.zipCode = zipCode;
/*     */   }
/*     */ 
/*     */   public String getZipCode() {
/* 756 */     return this.zipCode;
/*     */   }
/*     */ 
/*     */   public void setAddress(String address) {
/* 760 */     this.address = address;
/*     */   }
/*     */ 
/*     */   public String getAddress() {
/* 764 */     return this.address;
/*     */   }
/*     */ 
/*     */   public String getBidPriceDesc()
/*     */   {
/* 772 */     return CommonUtils.getValuationUnitDesc(this.bidPrice, this.valuationUnit);
/*     */   }
/*     */ 
/*     */   public String getTotalPayDesc()
/*     */   {
/* 780 */     return CommonUtils.getValuationUnitDesc(this.totalPay, this.valuationUnit);
/*     */   }
/*     */ 
/*     */   public void setPhone(String phone) {
/* 784 */     this.phone = phone;
/*     */   }
/*     */ 
/*     */   public String getPhone() {
/* 788 */     return this.phone;
/*     */   }
/*     */ 
/*     */   public String getInvoiceDesc() {
/* 792 */     EnumInvoice invoiceEnum = EnumInvoice.indexByValue(this.isInvoice);
/* 793 */     if (null == invoiceEnum) {
/* 794 */       return this.isInvoice;
/*     */     }
/* 796 */     return invoiceEnum.getName();
/*     */   }
/*     */ 
/*     */   public boolean isBidRecordHis() {
/* 800 */     if ((StringUtil.isNotEmpty(getProjectCode())) && (
/* 801 */       (EnumTradingType.MULIT_BID_ORDER.getValue().equals(getTradeType())) || (EnumTradingType.BID_ORDER.getValue().equals(getTradeType()))))
/*     */     {
/* 803 */       if ((EnumTradeWishOrderStatus.DONE.getValue().equals(getStatus())) || (EnumTradeWishOrderStatus.CANCEL.getValue().equals(getStatus())) || (EnumTradeWishOrderStatus.UNDONECANCEL.getValue().equals(getStatus())) || (EnumTradeWishOrderStatus.WDCANCEL.getValue().equals(getStatus())))
/*     */       {
/* 807 */         return true;
/*     */       }
/*     */     }
/*     */ 
/* 811 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean isWaitHall()
/*     */   {
/* 822 */     return (EnumTradeWishOrderStatus.TRADING.getValue().equals(getStatus())) && (
/* 820 */       (EnumTradingType.MULIT_BID_ORDER.getValue().equals(getTradeType())) || (EnumTradingType.BID_ORDER.getValue().equals(getTradeType())));
/*     */   }
/*     */ 
/*     */   public boolean isWaitOpt()
/*     */   {
/* 835 */     return (EnumTradeWishOrderStatus.AUDIT.getValue().equals(getStatus())) || (EnumTradeWishOrderStatus.CREATE.getValue().equals(getStatus())) || (isWaitHall());
/*     */   }
/*     */ 
/*     */   public Long getSubstationId()
/*     */   {
/* 841 */     return this.substationId;
/*     */   }
/*     */ 
/*     */   public void setSubstationId(Long substationId) {
/* 845 */     this.substationId = substationId;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.domain.trade.TradeWishOrder
 * JD-Core Version:    0.6.0
 */