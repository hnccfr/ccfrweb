/*     */ package com.hundsun.network.gates.wulin.biz.domain.trade;
/*     */ 
/*     */ import com.hundsun.network.gates.wulin.biz.domain.BaseDomain;
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
/*     */   private String specialSign;
/*     */   private Long deposit;
/*     */   private String zipCode;
/*     */   private String storehouse;
/*     */ 
/*     */   public Long getId()
/*     */   {
/* 208 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/* 212 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate()
/*     */   {
/* 219 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate)
/*     */   {
/* 226 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify() {
/* 230 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify) {
/* 234 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getProjectName()
/*     */   {
/* 241 */     return this.projectName;
/*     */   }
/*     */ 
/*     */   public void setProjectName(String projectName)
/*     */   {
/* 248 */     this.projectName = projectName;
/*     */   }
/*     */ 
/*     */   public String getProjectCode() {
/* 252 */     return this.projectCode;
/*     */   }
/*     */ 
/*     */   public void setProjectCode(String projectCode) {
/* 256 */     this.projectCode = projectCode;
/*     */   }
/*     */ 
/*     */   public String getTradeDictor()
/*     */   {
/* 269 */     return this.tradeDictor;
/*     */   }
/*     */ 
/*     */   public void setTradeDictor(String tradeDictor)
/*     */   {
/* 282 */     this.tradeDictor = tradeDictor;
/*     */   }
/*     */ 
/*     */   public String getUserAccount()
/*     */   {
/* 289 */     return this.userAccount;
/*     */   }
/*     */ 
/*     */   public void setUserAccount(String userAccount)
/*     */   {
/* 296 */     this.userAccount = userAccount;
/*     */   }
/*     */ 
/*     */   public Long getBidPrice()
/*     */   {
/* 303 */     return this.bidPrice;
/*     */   }
/*     */ 
/*     */   public void setBidPrice(Long bidPrice)
/*     */   {
/* 310 */     this.bidPrice = bidPrice;
/*     */   }
/*     */ 
/*     */   public String getValuationUnit()
/*     */   {
/* 319 */     return this.valuationUnit;
/*     */   }
/*     */ 
/*     */   public void setValuationUnit(String valuationUnit)
/*     */   {
/* 328 */     this.valuationUnit = valuationUnit;
/*     */   }
/*     */ 
/*     */   public Long getQuantity()
/*     */   {
/* 335 */     return this.quantity;
/*     */   }
/*     */ 
/*     */   public void setQuantity(Long quantity)
/*     */   {
/* 342 */     this.quantity = quantity;
/*     */   }
/*     */ 
/*     */   public String getMeasureUnit()
/*     */   {
/* 349 */     return this.measureUnit;
/*     */   }
/*     */ 
/*     */   public void setMeasureUnit(String measureUnit)
/*     */   {
/* 356 */     this.measureUnit = measureUnit;
/*     */   }
/*     */ 
/*     */   public Long getTotalPay()
/*     */   {
/* 363 */     return this.totalPay;
/*     */   }
/*     */ 
/*     */   public void setTotalPay(Long totalPay)
/*     */   {
/* 370 */     this.totalPay = totalPay;
/*     */   }
/*     */ 
/*     */   public String getStatus()
/*     */   {
/* 383 */     return this.status;
/*     */   }
/*     */ 
/*     */   public void setStatus(String status)
/*     */   {
/* 396 */     this.status = status;
/*     */   }
/*     */ 
/*     */   public String getTradeType()
/*     */   {
/* 411 */     return this.tradeType;
/*     */   }
/*     */ 
/*     */   public void setTradeType(String tradeType)
/*     */   {
/* 426 */     this.tradeType = tradeType;
/*     */   }
/*     */ 
/*     */   public String getPaymentType()
/*     */   {
/* 439 */     return this.paymentType;
/*     */   }
/*     */ 
/*     */   public void setPaymentType(String paymentType)
/*     */   {
/* 452 */     this.paymentType = paymentType;
/*     */   }
/*     */ 
/*     */   public Date getExpectTime()
/*     */   {
/* 459 */     return this.expectTime;
/*     */   }
/*     */ 
/*     */   public void setExpectTime(Date expectTime)
/*     */   {
/* 466 */     this.expectTime = expectTime;
/*     */   }
/*     */ 
/*     */   public String getIsInvoice()
/*     */   {
/* 477 */     return this.isInvoice;
/*     */   }
/*     */ 
/*     */   public void setIsInvoice(String isInvoice)
/*     */   {
/* 488 */     this.isInvoice = isInvoice;
/*     */   }
/*     */ 
/*     */   public String getDeal()
/*     */   {
/* 495 */     return this.deal;
/*     */   }
/*     */ 
/*     */   public void setDeal(String deal)
/*     */   {
/* 502 */     this.deal = deal;
/*     */   }
/*     */ 
/*     */   public String getDeliveryType()
/*     */   {
/* 513 */     return this.deliveryType;
/*     */   }
/*     */ 
/*     */   public void setDeliveryType(String deliveryType)
/*     */   {
/* 524 */     this.deliveryType = deliveryType;
/*     */   }
/*     */ 
/*     */   public String getLinkMan()
/*     */   {
/* 531 */     return this.linkMan;
/*     */   }
/*     */ 
/*     */   public void setLinkMan(String linkMan)
/*     */   {
/* 538 */     this.linkMan = linkMan;
/*     */   }
/*     */ 
/*     */   public String getProvince()
/*     */   {
/* 548 */     return this.province;
/*     */   }
/*     */ 
/*     */   public void setProvince(String province)
/*     */   {
/* 557 */     this.province = province;
/*     */   }
/*     */ 
/*     */   public String getCity()
/*     */   {
/* 564 */     return this.city;
/*     */   }
/*     */ 
/*     */   public void setCity(String city)
/*     */   {
/* 571 */     this.city = city;
/*     */   }
/*     */ 
/*     */   public String getArea()
/*     */   {
/* 578 */     return this.area;
/*     */   }
/*     */ 
/*     */   public void setArea(String area)
/*     */   {
/* 585 */     this.area = area;
/*     */   }
/*     */ 
/*     */   public String getTrademark()
/*     */   {
/* 593 */     return this.trademark;
/*     */   }
/*     */ 
/*     */   public void setTrademark(String trademark)
/*     */   {
/* 600 */     this.trademark = trademark;
/*     */   }
/*     */ 
/*     */   public String getComments()
/*     */   {
/* 607 */     return this.comments;
/*     */   }
/*     */ 
/*     */   public void setComments(String comments)
/*     */   {
/* 614 */     this.comments = comments;
/*     */   }
/*     */ 
/*     */   public String getSpecialSign()
/*     */   {
/* 623 */     return this.specialSign;
/*     */   }
/*     */ 
/*     */   public void setSpecialSign(String specialSign)
/*     */   {
/* 632 */     this.specialSign = specialSign;
/*     */   }
/*     */ 
/*     */   public Long getDeposit()
/*     */   {
/* 639 */     return this.deposit;
/*     */   }
/*     */ 
/*     */   public void setDeposit(Long deposit)
/*     */   {
/* 646 */     this.deposit = deposit;
/*     */   }
/*     */ 
/*     */   public void setZipCode(String zipCode) {
/* 650 */     this.zipCode = zipCode;
/*     */   }
/*     */ 
/*     */   public String getZipCode() {
/* 654 */     return this.zipCode;
/*     */   }
/*     */ 
/*     */   public void setAddress(String address) {
/* 658 */     this.address = address;
/*     */   }
/*     */ 
/*     */   public String getAddress() {
/* 662 */     return this.address;
/*     */   }
/*     */ 
/*     */   public void setWishOrderNum(String wishOrderNum)
/*     */   {
/* 667 */     this.wishOrderNum = wishOrderNum;
/*     */   }
/*     */ 
/*     */   public String getWishOrderNum() {
/* 671 */     return this.wishOrderNum;
/*     */   }
/*     */ 
/*     */   public void setPhone(String phone) {
/* 675 */     this.phone = phone;
/*     */   }
/*     */ 
/*     */   public String getPhone() {
/* 679 */     return this.phone;
/*     */   }
/*     */ 
/*     */   public void setStorehouse(String storehouse) {
/* 683 */     this.storehouse = storehouse;
/*     */   }
/*     */ 
/*     */   public String getStorehouse() {
/* 687 */     return this.storehouse;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.domain.trade.TradeWishOrder
 * JD-Core Version:    0.6.0
 */