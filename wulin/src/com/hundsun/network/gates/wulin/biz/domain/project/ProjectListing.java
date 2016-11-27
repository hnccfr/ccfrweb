/*      */ package com.hundsun.network.gates.wulin.biz.domain.project;
/*      */ 
/*      */ import com.hundsun.network.gates.wulin.biz.domain.BaseDomain;
/*      */ import com.hundsun.network.gates.wulin.biz.enums.EnumProjectRetail;
/*      */ import com.hundsun.network.gates.wulin.biz.enums.EnumProjectStatus;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Date;
/*      */ import java.util.List;
/*      */ 
/*      */ public class ProjectListing extends BaseDomain
/*      */ {
/*      */   private static final long serialVersionUID = 636177566656799962L;
/*      */   private Long id;
/*      */   private String title;
/*      */   private String code;
/*      */   private Long userId;
/*      */   private String userAccount;
/*      */   private String fundAccount;
/*      */   private String listingType;
/*      */   private String measureUnit;
/*      */   private Long quantity;
/*      */   private String valuationUnit;
/*      */   private Long listingPrice;
/*      */   private Long multipleBase;
/*      */   private Long maxQuantity;
/*      */   private Long minQuantity;
/*      */   private String retail;
/*      */   private String projectTypeCode;
/*      */   private String breedStandard;
/*      */   private String tradingType;
/*      */   private Date deliveryDate;
/*      */   private String deliveryPlace;
/*      */   private String deliveryType;
/*      */   private String paymentType;
/*      */   private Date listingStartTime;
/*      */   private Date listingEndTime;
/*      */   private String invoice;
/*      */   private String status;
/*      */   private String processAuditNodes;
/*      */   private String auditNode;
/*      */   private String creator;
/*      */   private String creatorType;
/*      */   private String operator;
/*      */   private Date gmtCreate;
/*      */   private Date gmtModify;
/*      */   private Long deposit;
/*      */   private String province;
/*      */   private String city;
/*      */   private String area;
/*      */   private String address;
/*      */   private String linkMan;
/*      */   private String zipCode;
/*      */   private String phone;
/*      */   private String storehouse;
/*      */   private String picturePath;
/*      */   private String picturePath1;
/*      */   private String picturePath2;
/*      */   private String picturePath3;
/*      */   private String picturePath4;
/*      */   private Long breedStandardId;
/*      */   private String description;
/*      */   private String oldStatus;
/*      */   private String oldAuditNode;
/*  280 */   private List<ProjectMetas> tradeMetasList = new ArrayList();
/*      */   private String attachedFilePath;
/*      */   private Long substationId;
/*      */ 
/*      */   public String getPicturePath()
/*      */   {
/*  296 */     return this.picturePath;
/*      */   }
/*      */ 
/*      */   public void setPicturePath(String picturePath)
/*      */   {
/*  303 */     this.picturePath = picturePath;
/*      */   }
/*      */ 
/*      */   public String getPicturePath1()
/*      */   {
/*  310 */     return this.picturePath1;
/*      */   }
/*      */ 
/*      */   public void setPicturePath1(String picturePath1)
/*      */   {
/*  317 */     this.picturePath1 = picturePath1;
/*      */   }
/*      */ 
/*      */   public String getPicturePath2()
/*      */   {
/*  324 */     return this.picturePath2;
/*      */   }
/*      */ 
/*      */   public void setPicturePath2(String picturePath2)
/*      */   {
/*  331 */     this.picturePath2 = picturePath2;
/*      */   }
/*      */ 
/*      */   public String getPicturePath3()
/*      */   {
/*  338 */     return this.picturePath3;
/*      */   }
/*      */ 
/*      */   public void setPicturePath3(String picturePath3)
/*      */   {
/*  345 */     this.picturePath3 = picturePath3;
/*      */   }
/*      */ 
/*      */   public String getPicturePath4()
/*      */   {
/*  352 */     return this.picturePath4;
/*      */   }
/*      */ 
/*      */   public void setPicturePath4(String picturePath4)
/*      */   {
/*  359 */     this.picturePath4 = picturePath4;
/*      */   }
/*      */ 
/*      */   public Long getBreedStandardId()
/*      */   {
/*  366 */     return this.breedStandardId;
/*      */   }
/*      */ 
/*      */   public void setBreedStandardId(Long breedStandardId)
/*      */   {
/*  373 */     this.breedStandardId = breedStandardId;
/*      */   }
/*      */ 
/*      */   public String getDescription()
/*      */   {
/*  380 */     return this.description;
/*      */   }
/*      */ 
/*      */   public void setDescription(String description)
/*      */   {
/*  387 */     this.description = description;
/*      */   }
/*      */ 
/*      */   public String getStorehouse() {
/*  391 */     return this.storehouse;
/*      */   }
/*      */ 
/*      */   public void setStorehouse(String storehouse) {
/*  395 */     this.storehouse = storehouse;
/*      */   }
/*      */ 
/*      */   public String getProvince() {
/*  399 */     return this.province;
/*      */   }
/*      */ 
/*      */   public void setProvince(String province) {
/*  403 */     this.province = province;
/*      */   }
/*      */ 
/*      */   public String getCity() {
/*  407 */     return this.city;
/*      */   }
/*      */ 
/*      */   public void setCity(String city) {
/*  411 */     this.city = city;
/*      */   }
/*      */ 
/*      */   public String getArea() {
/*  415 */     return this.area;
/*      */   }
/*      */ 
/*      */   public void setArea(String area) {
/*  419 */     this.area = area;
/*      */   }
/*      */ 
/*      */   public String getAddress() {
/*  423 */     return this.address;
/*      */   }
/*      */ 
/*      */   public void setAddress(String address) {
/*  427 */     this.address = address;
/*      */   }
/*      */ 
/*      */   public String getLinkMan() {
/*  431 */     return this.linkMan;
/*      */   }
/*      */ 
/*      */   public void setLinkMan(String linkMan) {
/*  435 */     this.linkMan = linkMan;
/*      */   }
/*      */ 
/*      */   public String getZipCode() {
/*  439 */     return this.zipCode;
/*      */   }
/*      */ 
/*      */   public void setZipCode(String zipCode) {
/*  443 */     this.zipCode = zipCode;
/*      */   }
/*      */ 
/*      */   public String getPhone() {
/*  447 */     return this.phone;
/*      */   }
/*      */ 
/*      */   public void setPhone(String phone) {
/*  451 */     this.phone = phone;
/*      */   }
/*      */ 
/*      */   public Long getDeposit()
/*      */   {
/*  459 */     return this.deposit;
/*      */   }
/*      */ 
/*      */   public void setDeposit(Long deposit)
/*      */   {
/*  467 */     this.deposit = deposit;
/*      */   }
/*      */ 
/*      */   public Long getId() {
/*  471 */     return this.id;
/*      */   }
/*      */ 
/*      */   public void setId(Long id) {
/*  475 */     this.id = id;
/*      */   }
/*      */ 
/*      */   public String getTitle()
/*      */   {
/*  482 */     return this.title;
/*      */   }
/*      */ 
/*      */   public void setTitle(String title)
/*      */   {
/*  489 */     this.title = title;
/*      */   }
/*      */ 
/*      */   public String getCode()
/*      */   {
/*  496 */     return this.code;
/*      */   }
/*      */ 
/*      */   public void setCode(String code)
/*      */   {
/*  503 */     this.code = code;
/*      */   }
/*      */ 
/*      */   public Long getUserId()
/*      */   {
/*  510 */     return this.userId;
/*      */   }
/*      */ 
/*      */   public void setUserId(Long userId)
/*      */   {
/*  517 */     this.userId = userId;
/*      */   }
/*      */ 
/*      */   public String getUserAccount()
/*      */   {
/*  524 */     return this.userAccount;
/*      */   }
/*      */ 
/*      */   public void setUserAccount(String userAccount)
/*      */   {
/*  531 */     this.userAccount = userAccount;
/*      */   }
/*      */ 
/*      */   public String getListingType()
/*      */   {
/*  538 */     return this.listingType;
/*      */   }
/*      */ 
/*      */   public void setListingType(String listingType)
/*      */   {
/*  545 */     this.listingType = listingType;
/*      */   }
/*      */ 
/*      */   public String getMeasureUnit()
/*      */   {
/*  552 */     return this.measureUnit;
/*      */   }
/*      */ 
/*      */   public void setMeasureUnit(String measureUnit)
/*      */   {
/*  559 */     this.measureUnit = measureUnit;
/*      */   }
/*      */ 
/*      */   public Long getQuantity()
/*      */   {
/*  566 */     return this.quantity;
/*      */   }
/*      */ 
/*      */   public void setQuantity(Long quantity)
/*      */   {
/*  573 */     this.quantity = quantity;
/*      */   }
/*      */ 
/*      */   public String getValuationUnit()
/*      */   {
/*  580 */     return this.valuationUnit;
/*      */   }
/*      */ 
/*      */   public void setValuationUnit(String valuationUnit)
/*      */   {
/*  587 */     this.valuationUnit = valuationUnit;
/*      */   }
/*      */ 
/*      */   public Long getListingPrice()
/*      */   {
/*  594 */     return this.listingPrice;
/*      */   }
/*      */ 
/*      */   public void setListingPrice(Long listingPrice)
/*      */   {
/*  601 */     this.listingPrice = listingPrice;
/*      */   }
/*      */ 
/*      */   public Long getMultipleBase()
/*      */   {
/*  608 */     return this.multipleBase;
/*      */   }
/*      */ 
/*      */   public void setMultipleBase(Long multipleBase)
/*      */   {
/*  615 */     this.multipleBase = multipleBase;
/*      */   }
/*      */ 
/*      */   public Long getMaxQuantity()
/*      */   {
/*  624 */     return this.maxQuantity;
/*      */   }
/*      */ 
/*      */   public void setMaxQuantity(Long maxQuantity)
/*      */   {
/*  633 */     this.maxQuantity = maxQuantity;
/*      */   }
/*      */ 
/*      */   public Long getMinQuantity()
/*      */   {
/*  644 */     return this.minQuantity;
/*      */   }
/*      */ 
/*      */   public void setMinQuantity(Long minQuantity)
/*      */   {
/*  655 */     this.minQuantity = minQuantity;
/*      */   }
/*      */ 
/*      */   public String getRetail()
/*      */   {
/*  664 */     return this.retail;
/*      */   }
/*      */ 
/*      */   public void setRetail(String retail)
/*      */   {
/*  673 */     this.retail = retail;
/*      */   }
/*      */ 
/*      */   public String getRetailDesc()
/*      */   {
/*  680 */     return EnumProjectRetail.indexByValue(this.retail).getName();
/*      */   }
/*      */ 
/*      */   public String getProjectTypeCode()
/*      */   {
/*  687 */     return this.projectTypeCode;
/*      */   }
/*      */ 
/*      */   public void setProjectTypeCode(String projectTypeCode)
/*      */   {
/*  694 */     this.projectTypeCode = projectTypeCode;
/*      */   }
/*      */ 
/*      */   public String getBreedStandard()
/*      */   {
/*  701 */     return this.breedStandard;
/*      */   }
/*      */ 
/*      */   public void setBreedStandard(String breedStandard)
/*      */   {
/*  708 */     this.breedStandard = breedStandard;
/*      */   }
/*      */ 
/*      */   public String getTradingType()
/*      */   {
/*  715 */     return this.tradingType;
/*      */   }
/*      */ 
/*      */   public void setTradingType(String tradingType)
/*      */   {
/*  722 */     this.tradingType = tradingType;
/*      */   }
/*      */ 
/*      */   public Date getDeliveryDate()
/*      */   {
/*  729 */     return this.deliveryDate;
/*      */   }
/*      */ 
/*      */   public void setDeliveryDate(Date deliveryDate)
/*      */   {
/*  736 */     this.deliveryDate = deliveryDate;
/*      */   }
/*      */ 
/*      */   public String getDeliveryPlace()
/*      */   {
/*  743 */     return this.deliveryPlace;
/*      */   }
/*      */ 
/*      */   public void setDeliveryPlace(String deliveryPlace)
/*      */   {
/*  750 */     this.deliveryPlace = deliveryPlace;
/*      */   }
/*      */ 
/*      */   public String getDeliveryType()
/*      */   {
/*  757 */     return this.deliveryType;
/*      */   }
/*      */ 
/*      */   public void setDeliveryType(String deliveryType)
/*      */   {
/*  764 */     this.deliveryType = deliveryType;
/*      */   }
/*      */ 
/*      */   public String getPaymentType()
/*      */   {
/*  771 */     return this.paymentType;
/*      */   }
/*      */ 
/*      */   public void setPaymentType(String paymentType)
/*      */   {
/*  778 */     this.paymentType = paymentType;
/*      */   }
/*      */ 
/*      */   public Date getListingStartTime()
/*      */   {
/*  785 */     return this.listingStartTime;
/*      */   }
/*      */ 
/*      */   public void setListingStartTime(Date listingStartTime)
/*      */   {
/*  792 */     this.listingStartTime = listingStartTime;
/*      */   }
/*      */ 
/*      */   public Date getListingEndTime()
/*      */   {
/*  801 */     return this.listingEndTime;
/*      */   }
/*      */ 
/*      */   public void setListingEndTime(Date listingEndTime)
/*      */   {
/*  810 */     this.listingEndTime = listingEndTime;
/*      */   }
/*      */ 
/*      */   public String getInvoice()
/*      */   {
/*  817 */     return this.invoice;
/*      */   }
/*      */ 
/*      */   public void setInvoice(String invoice)
/*      */   {
/*  824 */     this.invoice = invoice;
/*      */   }
/*      */ 
/*      */   public String getStatus()
/*      */   {
/*  833 */     return this.status;
/*      */   }
/*      */ 
/*      */   public String getStatusDesc()
/*      */   {
/*  840 */     return EnumProjectStatus.indexByValue(this.status).getName();
/*      */   }
/*      */ 
/*      */   public boolean isAudit()
/*      */   {
/*  847 */     return EnumProjectStatus.AUDIT.equals(EnumProjectStatus.indexByValue(this.status));
/*      */   }
/*      */ 
/*      */   public boolean isEdit()
/*      */   {
/*  855 */     return (EnumProjectStatus.AUDIT.equals(EnumProjectStatus.indexByValue(this.status))) || (EnumProjectStatus.SUSPENSION.equals(EnumProjectStatus.indexByValue(this.status)));
/*      */   }
/*      */ 
/*      */   public boolean isTrade()
/*      */   {
/*  863 */     return EnumProjectStatus.TRADE.equals(EnumProjectStatus.indexByValue(this.status));
/*      */   }
/*      */ 
/*      */   public boolean isSuspension()
/*      */   {
/*  870 */     return EnumProjectStatus.SUSPENSION.equals(EnumProjectStatus.indexByValue(this.status));
/*      */   }
/*      */ 
/*      */   public void setStatus(String status)
/*      */   {
/*  879 */     this.status = status;
/*      */   }
/*      */ 
/*      */   public String getProcessAuditNodes()
/*      */   {
/*  888 */     return this.processAuditNodes;
/*      */   }
/*      */ 
/*      */   public void setProcessAuditNodes(String processAuditNodes)
/*      */   {
/*  897 */     this.processAuditNodes = processAuditNodes;
/*      */   }
/*      */ 
/*      */   public String getAuditNode()
/*      */   {
/*  904 */     return this.auditNode;
/*      */   }
/*      */ 
/*      */   public void setAuditNode(String auditNode)
/*      */   {
/*  911 */     this.auditNode = auditNode;
/*      */   }
/*      */ 
/*      */   public String getCreator()
/*      */   {
/*  918 */     return this.creator;
/*      */   }
/*      */ 
/*      */   public void setCreator(String creator)
/*      */   {
/*  925 */     this.creator = creator;
/*      */   }
/*      */ 
/*      */   public String getCreatorType()
/*      */   {
/*  932 */     return this.creatorType;
/*      */   }
/*      */ 
/*      */   public void setCreatorType(String creatorType)
/*      */   {
/*  939 */     this.creatorType = creatorType;
/*      */   }
/*      */ 
/*      */   public String getOperator()
/*      */   {
/*  946 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String operator)
/*      */   {
/*  953 */     this.operator = operator;
/*      */   }
/*      */ 
/*      */   public Date getGmtCreate() {
/*  957 */     return this.gmtCreate;
/*      */   }
/*      */ 
/*      */   public void setGmtCreate(Date gmtCreate) {
/*  961 */     this.gmtCreate = gmtCreate;
/*      */   }
/*      */ 
/*      */   public Date getGmtModify() {
/*  965 */     return this.gmtModify;
/*      */   }
/*      */ 
/*      */   public void setGmtModify(Date gmtModify) {
/*  969 */     this.gmtModify = gmtModify;
/*      */   }
/*      */ 
/*      */   public String getFundAccount() {
/*  973 */     return this.fundAccount;
/*      */   }
/*      */ 
/*      */   public void setFundAccount(String fundAccount) {
/*  977 */     this.fundAccount = fundAccount;
/*      */   }
/*      */ 
/*      */   public String getOldStatus() {
/*  981 */     return this.oldStatus;
/*      */   }
/*      */ 
/*      */   public void setOldStatus(String oldStatus) {
/*  985 */     this.oldStatus = oldStatus;
/*      */   }
/*      */ 
/*      */   public String getOldAuditNode() {
/*  989 */     return this.oldAuditNode;
/*      */   }
/*      */ 
/*      */   public void setOldAuditNode(String oldAuditNode) {
/*  993 */     this.oldAuditNode = oldAuditNode;
/*      */   }
/*      */ 
/*      */   public List<ProjectMetas> getTradeMetasList() {
/*  997 */     return this.tradeMetasList;
/*      */   }
/*      */ 
/*      */   public void setTradeMetasList(List<ProjectMetas> tradeMetasList) {
/* 1001 */     this.tradeMetasList = tradeMetasList;
/*      */   }
/*      */ 
/*      */   public void setAttachedFilePath(String attachedFilePath) {
/* 1005 */     this.attachedFilePath = attachedFilePath;
/*      */   }
/*      */ 
/*      */   public String getAttachedFilePath() {
/* 1009 */     return this.attachedFilePath;
/*      */   }
/*      */ 
/*      */   public Long getSubstationId() {
/* 1013 */     return this.substationId;
/*      */   }
/*      */ 
/*      */   public void setSubstationId(Long substationId) {
/* 1017 */     this.substationId = substationId;
/*      */   }
/*      */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.domain.project.ProjectListing
 * JD-Core Version:    0.6.0
 */