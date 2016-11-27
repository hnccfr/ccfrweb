/*     */ package com.hundsun.network.gates.taiping.biz.domain.placeorder;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumMeasureUnit;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumValuationUnit;
/*     */ import com.hundsun.network.gates.taiping.biz.domain.BaseDomain;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class PlaceOrderInput extends BaseDomain
/*     */ {
/*     */   private static final long serialVersionUID = 9139075447309593031L;
/*     */   private String projectCode;
/*     */   private String projectName;
/*     */   private Long userId;
/*     */   private String userAccount;
/*     */   private String fundAccount;
/*     */   private String listingType;
/*     */   private String measureUnit;
/*     */   private String measureUnitDesc;
/*     */   private Long multipleBase;
/*     */   private Long maxQuantity;
/*     */   private Long minQuantity;
/*     */   private String retail;
/*     */   private String valuationUnit;
/*     */   private String valuationUnitDesc;
/*     */   private Long listingPrice;
/*     */   private Long quantity;
/*     */   private Long totalPay;
/*     */   private String tradingType;
/*     */   private Date deliveryDate;
/*     */   private String deliveryPlace;
/*     */   private String deliveryType;
/*     */   private String paymentType;
/*     */   private String invoice;
/*     */   private String comments;
/*     */   private String province;
/*     */   private String city;
/*     */   private String area;
/*     */   private String address;
/*     */   private String linkMan;
/*     */   private String zipCode;
/*     */   private String phone;
/*     */   private String userName;
/*     */   private String storehouse;
/*     */   private String picturePath;
/*     */   private String picturePath1;
/*     */   private String picturePath2;
/*     */   private String picturePath3;
/*     */   private String picturePath4;
/*     */   private Long breedStandardId;
/*     */   private String description;
/*     */   private String projectTypeCode;
/*     */ 
/*     */   public String getPicturePath()
/*     */   {
/* 211 */     return this.picturePath;
/*     */   }
/*     */ 
/*     */   public void setPicturePath(String picturePath)
/*     */   {
/* 218 */     this.picturePath = picturePath;
/*     */   }
/*     */ 
/*     */   public String getPicturePath1()
/*     */   {
/* 225 */     return this.picturePath1;
/*     */   }
/*     */ 
/*     */   public void setPicturePath1(String picturePath1)
/*     */   {
/* 232 */     this.picturePath1 = picturePath1;
/*     */   }
/*     */ 
/*     */   public String getPicturePath2()
/*     */   {
/* 239 */     return this.picturePath2;
/*     */   }
/*     */ 
/*     */   public void setPicturePath2(String picturePath2)
/*     */   {
/* 246 */     this.picturePath2 = picturePath2;
/*     */   }
/*     */ 
/*     */   public String getPicturePath3()
/*     */   {
/* 253 */     return this.picturePath3;
/*     */   }
/*     */ 
/*     */   public void setPicturePath3(String picturePath3)
/*     */   {
/* 260 */     this.picturePath3 = picturePath3;
/*     */   }
/*     */ 
/*     */   public String getPicturePath4()
/*     */   {
/* 267 */     return this.picturePath4;
/*     */   }
/*     */ 
/*     */   public void setPicturePath4(String picturePath4)
/*     */   {
/* 274 */     this.picturePath4 = picturePath4;
/*     */   }
/*     */ 
/*     */   public Long getBreedStandardId()
/*     */   {
/* 281 */     return this.breedStandardId;
/*     */   }
/*     */ 
/*     */   public void setBreedStandardId(Long breedStandardId)
/*     */   {
/* 288 */     this.breedStandardId = breedStandardId;
/*     */   }
/*     */ 
/*     */   public String getDescription()
/*     */   {
/* 295 */     return this.description;
/*     */   }
/*     */ 
/*     */   public void setDescription(String description)
/*     */   {
/* 302 */     this.description = description;
/*     */   }
/*     */ 
/*     */   public String getStorehouse() {
/* 306 */     return this.storehouse;
/*     */   }
/*     */ 
/*     */   public void setStorehouse(String storehouse) {
/* 310 */     this.storehouse = storehouse;
/*     */   }
/*     */ 
/*     */   public String getAddress() {
/* 314 */     return this.address;
/*     */   }
/*     */ 
/*     */   public void setAddress(String address) {
/* 318 */     this.address = address;
/*     */   }
/*     */ 
/*     */   public String getLinkMan() {
/* 322 */     return this.linkMan;
/*     */   }
/*     */ 
/*     */   public void setLinkMan(String linkMan) {
/* 326 */     this.linkMan = linkMan;
/*     */   }
/*     */ 
/*     */   public String getZipCode() {
/* 330 */     return this.zipCode;
/*     */   }
/*     */ 
/*     */   public void setZipCode(String zipCode) {
/* 334 */     this.zipCode = zipCode;
/*     */   }
/*     */ 
/*     */   public String getPhone() {
/* 338 */     return this.phone;
/*     */   }
/*     */ 
/*     */   public void setPhone(String phone) {
/* 342 */     this.phone = phone;
/*     */   }
/*     */ 
/*     */   public String getProjectCode()
/*     */   {
/* 351 */     return this.projectCode;
/*     */   }
/*     */ 
/*     */   public void setProjectCode(String projectCode) {
/* 355 */     this.projectCode = projectCode;
/*     */   }
/*     */ 
/*     */   public Long getUserId() {
/* 359 */     return this.userId;
/*     */   }
/*     */ 
/*     */   public void setUserId(Long userId) {
/* 363 */     this.userId = userId;
/*     */   }
/*     */ 
/*     */   public String getUserAccount() {
/* 367 */     return this.userAccount;
/*     */   }
/*     */ 
/*     */   public void setUserAccount(String userAccount) {
/* 371 */     this.userAccount = userAccount;
/*     */   }
/*     */ 
/*     */   public Long getListingPrice() {
/* 375 */     return this.listingPrice;
/*     */   }
/*     */ 
/*     */   public void setListingPrice(Long listingPrice)
/*     */   {
/* 383 */     this.listingPrice = listingPrice;
/*     */   }
/*     */ 
/*     */   public Long getQuantity() {
/* 387 */     return this.quantity;
/*     */   }
/*     */ 
/*     */   public void setQuantity(Long quantity) {
/* 391 */     this.quantity = quantity;
/*     */   }
/*     */ 
/*     */   public Long getTotalPay() {
/* 395 */     return this.totalPay;
/*     */   }
/*     */ 
/*     */   public void setTotalPay(Long totalPay) {
/* 399 */     this.totalPay = totalPay;
/*     */   }
/*     */ 
/*     */   public String getTradingType() {
/* 403 */     return this.tradingType;
/*     */   }
/*     */ 
/*     */   public void setTradingType(String tradingType) {
/* 407 */     this.tradingType = tradingType;
/*     */   }
/*     */ 
/*     */   public Date getDeliveryDate() {
/* 411 */     return this.deliveryDate;
/*     */   }
/*     */ 
/*     */   public void setDeliveryDate(Date deliveryDate) {
/* 415 */     this.deliveryDate = deliveryDate;
/*     */   }
/*     */ 
/*     */   public String getDeliveryPlace() {
/* 419 */     return this.deliveryPlace;
/*     */   }
/*     */ 
/*     */   public void setDeliveryPlace(String deliveryPlace) {
/* 423 */     this.deliveryPlace = deliveryPlace;
/*     */   }
/*     */ 
/*     */   public String getDeliveryType() {
/* 427 */     return this.deliveryType;
/*     */   }
/*     */ 
/*     */   public void setDeliveryType(String deliveryType) {
/* 431 */     this.deliveryType = deliveryType;
/*     */   }
/*     */ 
/*     */   public String getPaymentType() {
/* 435 */     return this.paymentType;
/*     */   }
/*     */ 
/*     */   public void setPaymentType(String paymentType) {
/* 439 */     this.paymentType = paymentType;
/*     */   }
/*     */ 
/*     */   public String getInvoice() {
/* 443 */     return this.invoice;
/*     */   }
/*     */ 
/*     */   public void setInvoice(String invoice) {
/* 447 */     this.invoice = invoice;
/*     */   }
/*     */ 
/*     */   public String getComments() {
/* 451 */     return this.comments;
/*     */   }
/*     */ 
/*     */   public void setComments(String comments) {
/* 455 */     this.comments = comments;
/*     */   }
/*     */ 
/*     */   public String getProvince() {
/* 459 */     return this.province;
/*     */   }
/*     */ 
/*     */   public void setProvince(String province) {
/* 463 */     this.province = province;
/*     */   }
/*     */ 
/*     */   public String getCity() {
/* 467 */     return this.city;
/*     */   }
/*     */ 
/*     */   public void setCity(String city) {
/* 471 */     this.city = city;
/*     */   }
/*     */ 
/*     */   public String getArea() {
/* 475 */     return this.area;
/*     */   }
/*     */ 
/*     */   public void setArea(String area) {
/* 479 */     this.area = area;
/*     */   }
/*     */ 
/*     */   public String getProjectName() {
/* 483 */     return this.projectName;
/*     */   }
/*     */ 
/*     */   public void setProjectName(String projectName) {
/* 487 */     this.projectName = projectName;
/*     */   }
/*     */ 
/*     */   public String getMeasureUnit() {
/* 491 */     return this.measureUnit;
/*     */   }
/*     */ 
/*     */   public void setMeasureUnit(String measureUnit) {
/* 495 */     this.measureUnit = measureUnit;
/* 496 */     this.measureUnitDesc = EnumMeasureUnit.indexByValue(measureUnit).getName();
/*     */   }
/*     */ 
/*     */   public String getMeasureUnitDesc() {
/* 500 */     return this.measureUnitDesc;
/*     */   }
/*     */ 
/*     */   public String getValuationUnit() {
/* 504 */     return this.valuationUnit;
/*     */   }
/*     */ 
/*     */   public void setValuationUnit(String valuationUnit) {
/* 508 */     this.valuationUnit = valuationUnit;
/* 509 */     this.valuationUnitDesc = EnumValuationUnit.indexByValue(valuationUnit).getName();
/*     */   }
/*     */ 
/*     */   public String getValuationUnitDesc() {
/* 513 */     return this.valuationUnitDesc;
/*     */   }
/*     */ 
/*     */   public String getFundAccount() {
/* 517 */     return this.fundAccount;
/*     */   }
/*     */ 
/*     */   public void setFundAccount(String fundAccount) {
/* 521 */     this.fundAccount = fundAccount;
/*     */   }
/*     */ 
/*     */   public String getListingType() {
/* 525 */     return this.listingType;
/*     */   }
/*     */ 
/*     */   public void setListingType(String listingType) {
/* 529 */     this.listingType = listingType;
/*     */   }
/*     */ 
/*     */   public String getUserName() {
/* 533 */     return this.userName;
/*     */   }
/*     */ 
/*     */   public void setUserName(String userName) {
/* 537 */     this.userName = userName;
/*     */   }
/*     */ 
/*     */   public String getProjectTypeCode() {
/* 541 */     return this.projectTypeCode;
/*     */   }
/*     */ 
/*     */   public void setProjectTypeCode(String projectTypeCode) {
/* 545 */     this.projectTypeCode = projectTypeCode;
/*     */   }
/*     */ 
/*     */   public Long getMultipleBase() {
/* 549 */     return this.multipleBase;
/*     */   }
/*     */ 
/*     */   public void setMultipleBase(Long multipleBase) {
/* 553 */     this.multipleBase = multipleBase;
/*     */   }
/*     */ 
/*     */   public Long getMaxQuantity() {
/* 557 */     return this.maxQuantity;
/*     */   }
/*     */ 
/*     */   public void setMaxQuantity(Long maxQuantity) {
/* 561 */     this.maxQuantity = maxQuantity;
/*     */   }
/*     */ 
/*     */   public Long getMinQuantity() {
/* 565 */     return this.minQuantity;
/*     */   }
/*     */ 
/*     */   public void setMinQuantity(Long minQuantity) {
/* 569 */     this.minQuantity = minQuantity;
/*     */   }
/*     */ 
/*     */   public String getRetail() {
/* 573 */     return this.retail;
/*     */   }
/*     */ 
/*     */   public void setRetail(String retail) {
/* 577 */     this.retail = retail;
/*     */   }
/*     */ 
/*     */   public String toString() {
/* 581 */     return "prijectName:" + getProjectName() + ";listingPrice:" + getListingPrice() + ";Quantity:" + getQuantity() + ";deliveryPlace:" + getDeliveryPlace() + ";linkMan:" + getLinkMan() + ";linkPhone:" + getPhone();
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.taiping.biz.domain.placeorder.PlaceOrderInput
 * JD-Core Version:    0.6.0
 */