/*     */ package com.hundsun.network.gates.qingbo.biz.domain.project;
/*     */ 
/*     */ import com.hundsun.network.gates.qingbo.biz.domain.BaseDomain;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class ProjectListing extends BaseDomain
/*     */ {
/*     */   private static final long serialVersionUID = -6085168646035359321L;
/*     */   private Long id;
/*     */   private String title;
/*     */   private String code;
/*     */   private Long userId;
/*     */   private String userAccount;
/*     */   private String fundAccount;
/*     */   private String listingType;
/*     */   private String measureUnit;
/*     */   private Long quantity;
/*     */   private String valuationUnit;
/*     */   private Long listingPrice;
/*     */   private Long multipleBase;
/*     */   private Long maxQuantity;
/*     */   private Long minQuantity;
/*     */   private String retail;
/*     */   private String projectTypeCode;
/*     */   private String breedStandard;
/*     */   private String tradingType;
/*     */   private Date deliveryDate;
/*     */   private String deliveryPlace;
/*     */   private String deliveryType;
/*     */   private String paymentType;
/*     */   private Date listingStartTime;
/*     */   private Date listingEndTime;
/*     */   private String invoice;
/*     */   private String status;
/*     */   private String processAuditNodes;
/*     */   private String auditNode;
/*     */   private String creator;
/*     */   private String creatorType;
/*     */   private String operator;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */   private Long deposit;
/*     */   private String province;
/*     */   private String city;
/*     */   private String area;
/*     */   private String address;
/*     */   private String zipCode;
/*     */   private String linkMan;
/*     */   private String phone;
/*     */   private String storehouse;
/*     */   private String picturePath;
/*     */   private String picturePath1;
/*     */   private String picturePath2;
/*     */   private String picturePath3;
/*     */   private String picturePath4;
/*     */   private Long breedStandardId;
/*     */   private String description;
/*     */   private Long substationId;
/*     */ 
/*     */   public String getPicturePath()
/*     */   {
/* 269 */     return this.picturePath;
/*     */   }
/*     */ 
/*     */   public void setPicturePath(String picturePath)
/*     */   {
/* 276 */     this.picturePath = picturePath;
/*     */   }
/*     */ 
/*     */   public String getPicturePath1()
/*     */   {
/* 283 */     return this.picturePath1;
/*     */   }
/*     */ 
/*     */   public void setPicturePath1(String picturePath1)
/*     */   {
/* 290 */     this.picturePath1 = picturePath1;
/*     */   }
/*     */ 
/*     */   public String getPicturePath2()
/*     */   {
/* 297 */     return this.picturePath2;
/*     */   }
/*     */ 
/*     */   public void setPicturePath2(String picturePath2)
/*     */   {
/* 304 */     this.picturePath2 = picturePath2;
/*     */   }
/*     */ 
/*     */   public String getPicturePath3()
/*     */   {
/* 311 */     return this.picturePath3;
/*     */   }
/*     */ 
/*     */   public void setPicturePath3(String picturePath3)
/*     */   {
/* 318 */     this.picturePath3 = picturePath3;
/*     */   }
/*     */ 
/*     */   public String getPicturePath4()
/*     */   {
/* 325 */     return this.picturePath4;
/*     */   }
/*     */ 
/*     */   public void setPicturePath4(String picturePath4)
/*     */   {
/* 332 */     this.picturePath4 = picturePath4;
/*     */   }
/*     */ 
/*     */   public Long getBreedStandardId()
/*     */   {
/* 339 */     return this.breedStandardId;
/*     */   }
/*     */ 
/*     */   public void setBreedStandardId(Long breedStandardId)
/*     */   {
/* 346 */     this.breedStandardId = breedStandardId;
/*     */   }
/*     */ 
/*     */   public String getDescription()
/*     */   {
/* 353 */     return this.description;
/*     */   }
/*     */ 
/*     */   public void setDescription(String description)
/*     */   {
/* 360 */     this.description = description;
/*     */   }
/*     */ 
/*     */   public String getStorehouse() {
/* 364 */     return this.storehouse;
/*     */   }
/*     */ 
/*     */   public void setStorehouse(String storehouse) {
/* 368 */     this.storehouse = storehouse;
/*     */   }
/*     */ 
/*     */   public String getProvince()
/*     */   {
/* 375 */     return this.province;
/*     */   }
/*     */ 
/*     */   public void setProvince(String province)
/*     */   {
/* 382 */     this.province = province;
/*     */   }
/*     */ 
/*     */   public String getCity()
/*     */   {
/* 389 */     return this.city;
/*     */   }
/*     */ 
/*     */   public void setCity(String city)
/*     */   {
/* 396 */     this.city = city;
/*     */   }
/*     */ 
/*     */   public String getArea()
/*     */   {
/* 403 */     return this.area;
/*     */   }
/*     */ 
/*     */   public void setArea(String area)
/*     */   {
/* 410 */     this.area = area;
/*     */   }
/*     */ 
/*     */   public String getAddress()
/*     */   {
/* 417 */     return this.address;
/*     */   }
/*     */ 
/*     */   public void setAddress(String address)
/*     */   {
/* 424 */     this.address = address;
/*     */   }
/*     */ 
/*     */   public String getZipCode()
/*     */   {
/* 431 */     return this.zipCode;
/*     */   }
/*     */ 
/*     */   public void setZipCode(String zipCode)
/*     */   {
/* 438 */     this.zipCode = zipCode;
/*     */   }
/*     */ 
/*     */   public String getLinkMan()
/*     */   {
/* 445 */     return this.linkMan;
/*     */   }
/*     */ 
/*     */   public void setLinkMan(String linkMan)
/*     */   {
/* 452 */     this.linkMan = linkMan;
/*     */   }
/*     */ 
/*     */   public String getPhone()
/*     */   {
/* 459 */     return this.phone;
/*     */   }
/*     */ 
/*     */   public void setPhone(String phone)
/*     */   {
/* 466 */     this.phone = phone;
/*     */   }
/*     */ 
/*     */   public Long getDeposit()
/*     */   {
/* 474 */     return this.deposit;
/*     */   }
/*     */ 
/*     */   public void setDeposit(Long deposit)
/*     */   {
/* 482 */     this.deposit = deposit;
/*     */   }
/*     */ 
/*     */   public Long getId() {
/* 486 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/* 490 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getTitle()
/*     */   {
/* 497 */     return this.title;
/*     */   }
/*     */ 
/*     */   public void setTitle(String title)
/*     */   {
/* 504 */     this.title = title;
/*     */   }
/*     */ 
/*     */   public String getCode()
/*     */   {
/* 511 */     return this.code;
/*     */   }
/*     */ 
/*     */   public void setCode(String code)
/*     */   {
/* 518 */     this.code = code;
/*     */   }
/*     */ 
/*     */   public Long getUserId()
/*     */   {
/* 525 */     return this.userId;
/*     */   }
/*     */ 
/*     */   public void setUserId(Long userId)
/*     */   {
/* 532 */     this.userId = userId;
/*     */   }
/*     */ 
/*     */   public String getUserAccount()
/*     */   {
/* 539 */     return this.userAccount;
/*     */   }
/*     */ 
/*     */   public void setUserAccount(String userAccount)
/*     */   {
/* 546 */     this.userAccount = userAccount;
/*     */   }
/*     */ 
/*     */   public String getListingType()
/*     */   {
/* 553 */     return this.listingType;
/*     */   }
/*     */ 
/*     */   public void setListingType(String listingType)
/*     */   {
/* 560 */     this.listingType = listingType;
/*     */   }
/*     */ 
/*     */   public String getMeasureUnit()
/*     */   {
/* 567 */     return this.measureUnit;
/*     */   }
/*     */ 
/*     */   public void setMeasureUnit(String measureUnit)
/*     */   {
/* 574 */     this.measureUnit = measureUnit;
/*     */   }
/*     */ 
/*     */   public Long getQuantity()
/*     */   {
/* 581 */     return this.quantity;
/*     */   }
/*     */ 
/*     */   public void setQuantity(Long quantity)
/*     */   {
/* 588 */     this.quantity = quantity;
/*     */   }
/*     */ 
/*     */   public String getValuationUnit()
/*     */   {
/* 595 */     return this.valuationUnit;
/*     */   }
/*     */ 
/*     */   public void setValuationUnit(String valuationUnit)
/*     */   {
/* 602 */     this.valuationUnit = valuationUnit;
/*     */   }
/*     */ 
/*     */   public Long getListingPrice()
/*     */   {
/* 609 */     return this.listingPrice;
/*     */   }
/*     */ 
/*     */   public void setListingPrice(Long listingPrice)
/*     */   {
/* 616 */     this.listingPrice = listingPrice;
/*     */   }
/*     */ 
/*     */   public Long getMultipleBase()
/*     */   {
/* 623 */     return this.multipleBase;
/*     */   }
/*     */ 
/*     */   public void setMultipleBase(Long multipleBase)
/*     */   {
/* 630 */     this.multipleBase = multipleBase;
/*     */   }
/*     */ 
/*     */   public Long getMaxQuantity()
/*     */   {
/* 639 */     return this.maxQuantity;
/*     */   }
/*     */ 
/*     */   public void setMaxQuantity(Long maxQuantity)
/*     */   {
/* 648 */     this.maxQuantity = maxQuantity;
/*     */   }
/*     */ 
/*     */   public Long getMinQuantity()
/*     */   {
/* 659 */     return this.minQuantity;
/*     */   }
/*     */ 
/*     */   public void setMinQuantity(Long minQuantity)
/*     */   {
/* 670 */     this.minQuantity = minQuantity;
/*     */   }
/*     */ 
/*     */   public String getRetail()
/*     */   {
/* 679 */     return this.retail;
/*     */   }
/*     */ 
/*     */   public void setRetail(String retail)
/*     */   {
/* 688 */     this.retail = retail;
/*     */   }
/*     */ 
/*     */   public String getProjectTypeCode()
/*     */   {
/* 695 */     return this.projectTypeCode;
/*     */   }
/*     */ 
/*     */   public void setProjectTypeCode(String projectTypeCode)
/*     */   {
/* 702 */     this.projectTypeCode = projectTypeCode;
/*     */   }
/*     */ 
/*     */   public String getBreedStandard()
/*     */   {
/* 709 */     return this.breedStandard;
/*     */   }
/*     */ 
/*     */   public void setBreedStandard(String breedStandard)
/*     */   {
/* 716 */     this.breedStandard = breedStandard;
/*     */   }
/*     */ 
/*     */   public String getTradingType()
/*     */   {
/* 723 */     return this.tradingType;
/*     */   }
/*     */ 
/*     */   public void setTradingType(String tradingType)
/*     */   {
/* 730 */     this.tradingType = tradingType;
/*     */   }
/*     */ 
/*     */   public Date getDeliveryDate()
/*     */   {
/* 737 */     return this.deliveryDate;
/*     */   }
/*     */ 
/*     */   public void setDeliveryDate(Date deliveryDate)
/*     */   {
/* 744 */     this.deliveryDate = deliveryDate;
/*     */   }
/*     */ 
/*     */   public String getDeliveryPlace()
/*     */   {
/* 751 */     return this.deliveryPlace;
/*     */   }
/*     */ 
/*     */   public void setDeliveryPlace(String deliveryPlace)
/*     */   {
/* 758 */     this.deliveryPlace = deliveryPlace;
/*     */   }
/*     */ 
/*     */   public String getDeliveryType()
/*     */   {
/* 765 */     return this.deliveryType;
/*     */   }
/*     */ 
/*     */   public void setDeliveryType(String deliveryType)
/*     */   {
/* 772 */     this.deliveryType = deliveryType;
/*     */   }
/*     */ 
/*     */   public String getPaymentType()
/*     */   {
/* 779 */     return this.paymentType;
/*     */   }
/*     */ 
/*     */   public void setPaymentType(String paymentType)
/*     */   {
/* 786 */     this.paymentType = paymentType;
/*     */   }
/*     */ 
/*     */   public Date getListingStartTime()
/*     */   {
/* 793 */     return this.listingStartTime;
/*     */   }
/*     */ 
/*     */   public void setListingStartTime(Date listingStartTime)
/*     */   {
/* 800 */     this.listingStartTime = listingStartTime;
/*     */   }
/*     */ 
/*     */   public Date getListingEndTime()
/*     */   {
/* 809 */     return this.listingEndTime;
/*     */   }
/*     */ 
/*     */   public void setListingEndTime(Date listingEndTime)
/*     */   {
/* 818 */     this.listingEndTime = listingEndTime;
/*     */   }
/*     */ 
/*     */   public String getInvoice()
/*     */   {
/* 825 */     return this.invoice;
/*     */   }
/*     */ 
/*     */   public void setInvoice(String invoice)
/*     */   {
/* 832 */     this.invoice = invoice;
/*     */   }
/*     */ 
/*     */   public String getStatus()
/*     */   {
/* 841 */     return this.status;
/*     */   }
/*     */ 
/*     */   public void setStatus(String status)
/*     */   {
/* 850 */     this.status = status;
/*     */   }
/*     */ 
/*     */   public String getProcessAuditNodes()
/*     */   {
/* 859 */     return this.processAuditNodes;
/*     */   }
/*     */ 
/*     */   public void setProcessAuditNodes(String processAuditNodes)
/*     */   {
/* 868 */     this.processAuditNodes = processAuditNodes;
/*     */   }
/*     */ 
/*     */   public String getAuditNode()
/*     */   {
/* 875 */     return this.auditNode;
/*     */   }
/*     */ 
/*     */   public void setAuditNode(String auditNode)
/*     */   {
/* 882 */     this.auditNode = auditNode;
/*     */   }
/*     */ 
/*     */   public String getCreator()
/*     */   {
/* 889 */     return this.creator;
/*     */   }
/*     */ 
/*     */   public void setCreator(String creator)
/*     */   {
/* 896 */     this.creator = creator;
/*     */   }
/*     */ 
/*     */   public String getCreatorType()
/*     */   {
/* 903 */     return this.creatorType;
/*     */   }
/*     */ 
/*     */   public void setCreatorType(String creatorType)
/*     */   {
/* 910 */     this.creatorType = creatorType;
/*     */   }
/*     */ 
/*     */   public String getOperator()
/*     */   {
/* 917 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator)
/*     */   {
/* 924 */     this.operator = operator;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate() {
/* 928 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate) {
/* 932 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify() {
/* 936 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify) {
/* 940 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getFundAccount() {
/* 944 */     return this.fundAccount;
/*     */   }
/*     */ 
/*     */   public void setFundAccount(String fundAccount) {
/* 948 */     this.fundAccount = fundAccount;
/*     */   }
/*     */ 
/*     */   public Long getSubstationId() {
/* 952 */     return this.substationId;
/*     */   }
/*     */ 
/*     */   public void setSubstationId(Long substationId) {
/* 956 */     this.substationId = substationId;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.qingbo.biz.domain.project.ProjectListing
 * JD-Core Version:    0.6.0
 */