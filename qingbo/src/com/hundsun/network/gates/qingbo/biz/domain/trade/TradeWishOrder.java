/*     */ package com.hundsun.network.gates.qingbo.biz.domain.trade;
/*     */ 
/*     */ import com.hundsun.network.gates.qingbo.biz.domain.BaseDomain;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class TradeWishOrder extends BaseDomain
/*     */ {
/*     */   private static final long serialVersionUID = -7694051662881015635L;
/*     */   private Long id;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */   private String wishOrderNum;
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
/*     */   private String zipCode;
/*     */   private String specialSign;
/*     */   private Long deposit;
/*     */   private String fundAccount;
/*     */   private String storehouse;
/*     */   private Long substationId;
/*     */ 
/*     */   public Long getId()
/*     */   {
/* 215 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/* 219 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate()
/*     */   {
/* 226 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate)
/*     */   {
/* 233 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify() {
/* 237 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify) {
/* 241 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getWishOrderNum()
/*     */   {
/* 248 */     return this.wishOrderNum;
/*     */   }
/*     */ 
/*     */   public void setWishOrderNum(String wishOrderNum)
/*     */   {
/* 255 */     this.wishOrderNum = wishOrderNum;
/*     */   }
/*     */ 
/*     */   public String getProjectName()
/*     */   {
/* 262 */     return this.projectName;
/*     */   }
/*     */ 
/*     */   public void setProjectName(String projectName)
/*     */   {
/* 269 */     this.projectName = projectName;
/*     */   }
/*     */ 
/*     */   public String getProjectCode() {
/* 273 */     return this.projectCode;
/*     */   }
/*     */ 
/*     */   public void setProjectCode(String projectCode) {
/* 277 */     this.projectCode = projectCode;
/*     */   }
/*     */ 
/*     */   public String getTradeDictor()
/*     */   {
/* 290 */     return this.tradeDictor;
/*     */   }
/*     */ 
/*     */   public void setTradeDictor(String tradeDictor)
/*     */   {
/* 303 */     this.tradeDictor = tradeDictor;
/*     */   }
/*     */ 
/*     */   public String getUserAccount()
/*     */   {
/* 310 */     return this.userAccount;
/*     */   }
/*     */ 
/*     */   public void setUserAccount(String userAccount)
/*     */   {
/* 317 */     this.userAccount = userAccount;
/*     */   }
/*     */ 
/*     */   public Long getBidPrice()
/*     */   {
/* 324 */     return this.bidPrice;
/*     */   }
/*     */ 
/*     */   public void setBidPrice(Long bidPrice)
/*     */   {
/* 331 */     this.bidPrice = bidPrice;
/*     */   }
/*     */ 
/*     */   public String getValuationUnit()
/*     */   {
/* 340 */     return this.valuationUnit;
/*     */   }
/*     */ 
/*     */   public void setValuationUnit(String valuationUnit)
/*     */   {
/* 349 */     this.valuationUnit = valuationUnit;
/*     */   }
/*     */ 
/*     */   public Long getQuantity()
/*     */   {
/* 356 */     return this.quantity;
/*     */   }
/*     */ 
/*     */   public void setQuantity(Long quantity)
/*     */   {
/* 363 */     this.quantity = quantity;
/*     */   }
/*     */ 
/*     */   public String getMeasureUnit()
/*     */   {
/* 370 */     return this.measureUnit;
/*     */   }
/*     */ 
/*     */   public void setMeasureUnit(String measureUnit)
/*     */   {
/* 377 */     this.measureUnit = measureUnit;
/*     */   }
/*     */ 
/*     */   public Long getTotalPay()
/*     */   {
/* 384 */     return this.totalPay;
/*     */   }
/*     */ 
/*     */   public void setTotalPay(Long totalPay)
/*     */   {
/* 391 */     this.totalPay = totalPay;
/*     */   }
/*     */ 
/*     */   public String getStatus()
/*     */   {
/* 404 */     return this.status;
/*     */   }
/*     */ 
/*     */   public void setStatus(String status)
/*     */   {
/* 417 */     this.status = status;
/*     */   }
/*     */ 
/*     */   public String getTradeType()
/*     */   {
/* 432 */     return this.tradeType;
/*     */   }
/*     */ 
/*     */   public void setTradeType(String tradeType)
/*     */   {
/* 447 */     this.tradeType = tradeType;
/*     */   }
/*     */ 
/*     */   public String getPaymentType()
/*     */   {
/* 460 */     return this.paymentType;
/*     */   }
/*     */ 
/*     */   public void setPaymentType(String paymentType)
/*     */   {
/* 473 */     this.paymentType = paymentType;
/*     */   }
/*     */ 
/*     */   public Date getExpectTime()
/*     */   {
/* 480 */     return this.expectTime;
/*     */   }
/*     */ 
/*     */   public void setExpectTime(Date expectTime)
/*     */   {
/* 487 */     this.expectTime = expectTime;
/*     */   }
/*     */ 
/*     */   public String getIsInvoice()
/*     */   {
/* 498 */     return this.isInvoice;
/*     */   }
/*     */ 
/*     */   public void setIsInvoice(String isInvoice)
/*     */   {
/* 509 */     this.isInvoice = isInvoice;
/*     */   }
/*     */ 
/*     */   public String getDeal()
/*     */   {
/* 516 */     return this.deal;
/*     */   }
/*     */ 
/*     */   public void setDeal(String deal)
/*     */   {
/* 523 */     this.deal = deal;
/*     */   }
/*     */ 
/*     */   public String getDeliveryType()
/*     */   {
/* 534 */     return this.deliveryType;
/*     */   }
/*     */ 
/*     */   public void setDeliveryType(String deliveryType)
/*     */   {
/* 545 */     this.deliveryType = deliveryType;
/*     */   }
/*     */ 
/*     */   public String getLinkMan()
/*     */   {
/* 552 */     return this.linkMan;
/*     */   }
/*     */ 
/*     */   public void setLinkMan(String linkMan)
/*     */   {
/* 559 */     this.linkMan = linkMan;
/*     */   }
/*     */ 
/*     */   public String getPhone()
/*     */   {
/* 566 */     return this.phone;
/*     */   }
/*     */ 
/*     */   public void setPhone(String phone)
/*     */   {
/* 573 */     this.phone = phone;
/*     */   }
/*     */ 
/*     */   public String getProvince()
/*     */   {
/* 582 */     return this.province;
/*     */   }
/*     */ 
/*     */   public void setProvince(String province)
/*     */   {
/* 591 */     this.province = province;
/*     */   }
/*     */ 
/*     */   public String getCity()
/*     */   {
/* 598 */     return this.city;
/*     */   }
/*     */ 
/*     */   public void setCity(String city)
/*     */   {
/* 605 */     this.city = city;
/*     */   }
/*     */ 
/*     */   public String getArea()
/*     */   {
/* 612 */     return this.area;
/*     */   }
/*     */ 
/*     */   public void setArea(String area)
/*     */   {
/* 619 */     this.area = area;
/*     */   }
/*     */ 
/*     */   public String getAddress()
/*     */   {
/* 626 */     return this.address;
/*     */   }
/*     */ 
/*     */   public void setAddress(String address)
/*     */   {
/* 633 */     this.address = address;
/*     */   }
/*     */ 
/*     */   public String getTrademark()
/*     */   {
/* 640 */     return this.trademark;
/*     */   }
/*     */ 
/*     */   public void setTrademark(String trademark)
/*     */   {
/* 647 */     this.trademark = trademark;
/*     */   }
/*     */ 
/*     */   public String getComments()
/*     */   {
/* 654 */     return this.comments;
/*     */   }
/*     */ 
/*     */   public void setComments(String comments)
/*     */   {
/* 661 */     this.comments = comments;
/*     */   }
/*     */ 
/*     */   public String getSpecialSign()
/*     */   {
/* 670 */     return this.specialSign;
/*     */   }
/*     */ 
/*     */   public void setSpecialSign(String specialSign)
/*     */   {
/* 679 */     this.specialSign = specialSign;
/*     */   }
/*     */ 
/*     */   public Long getDeposit()
/*     */   {
/* 687 */     return this.deposit;
/*     */   }
/*     */ 
/*     */   public void setDeposit(Long deposit)
/*     */   {
/* 695 */     this.deposit = deposit;
/*     */   }
/*     */ 
/*     */   public String getZipCode() {
/* 699 */     return this.zipCode;
/*     */   }
/*     */ 
/*     */   public void setZipCode(String zipCode) {
/* 703 */     this.zipCode = zipCode;
/*     */   }
/*     */ 
/*     */   public String getFundAccount() {
/* 707 */     return this.fundAccount;
/*     */   }
/*     */ 
/*     */   public void setFundAccount(String fundAccount) {
/* 711 */     this.fundAccount = fundAccount;
/*     */   }
/*     */ 
/*     */   public void setStorehouse(String storehouse) {
/* 715 */     this.storehouse = storehouse;
/*     */   }
/*     */ 
/*     */   public String getStorehouse() {
/* 719 */     return this.storehouse;
/*     */   }
/*     */ 
/*     */   public Long getSubstationId() {
/* 723 */     return this.substationId;
/*     */   }
/*     */ 
/*     */   public void setSubstationId(Long substationId) {
/* 727 */     this.substationId = substationId;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.qingbo.biz.domain.trade.TradeWishOrder
 * JD-Core Version:    0.6.0
 */