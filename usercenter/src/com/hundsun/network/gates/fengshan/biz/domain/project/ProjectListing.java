/*      */ package com.hundsun.network.gates.fengshan.biz.domain.project;
/*      */ 
/*      */ import com.hundsun.network.gates.fengshan.biz.domain.BaseDomain;
/*      */ import com.hundsun.network.gates.luosi.biz.domain.TradeShowDTO;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumDeliveryType;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumInvoice;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumListingType;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumMeasureUnit;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumPaymentType;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumProjectStatus;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumTradingType;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumValuationUnit;
/*      */ import com.hundsun.network.gates.luosi.common.utils.CommonUtils;
/*      */ import com.hundsun.network.melody.common.util.StringUtil;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Date;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ 
/*      */ public class ProjectListing extends BaseDomain
/*      */ {
/*      */   private static final long serialVersionUID = 1325727249975523862L;
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
/*      */   private String listingPriceDesc;
/*      */   private String listingPriceShow;
/*      */   private Long multipleBase;
/*      */   private Long maxQuantity;
/*      */   private Long minQuantity;
/*      */   private String retail;
/*      */   private String projectTypeCode;
/*      */   private String projectTypeName;
/*      */   private String projectTypeCodeDesc;
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
/*      */   private List<AttriMeta> attriMeta;
/*      */   private List<AttriMeta> tradeMeta;
/*  228 */   private ProjectMetas[] metaValues = new ProjectMetas[0];
/*      */ 
/*  234 */   private TradeShowDTO[] tradeMetas = new TradeShowDTO[0];
/*      */   private List<ProjectStandard> projectStandardList;
/*      */   private String province;
/*      */   private String city;
/*      */   private String area;
/*      */   private String address;
/*      */   private String zipCode;
/*      */   private String linkMan;
/*      */   private String phone;
/*      */   private String storehouse;
/*      */   private String picturePath;
/*      */   private String picturePath1;
/*      */   private String picturePath2;
/*      */   private String picturePath3;
/*      */   private String picturePath4;
/*      */   private Long breedStandardId;
/*      */   private String description;
/*      */   private String attachedFilePath;
/*  313 */   private String tempPath = "tempPath";
/*  314 */   private String tempPath1 = "tempPath1";
/*  315 */   private String tempPath2 = "tempPath2";
/*  316 */   private String tempPath3 = "tempPath3";
/*  317 */   private String tempPath4 = "tempPath4";
/*      */   private Long substationId;
/*      */   private String forestryQuantityDes;
/*      */ 
/*      */   public String getPicturePath()
/*      */   {
/*  334 */     return this.picturePath;
/*      */   }
/*      */ 
/*      */   public void setPicturePath(String picturePath)
/*      */   {
/*  341 */     this.picturePath = picturePath;
/*      */   }
/*      */ 
/*      */   public String getPicturePath1()
/*      */   {
/*  348 */     return this.picturePath1;
/*      */   }
/*      */ 
/*      */   public void setPicturePath1(String picturePath1)
/*      */   {
/*  355 */     this.picturePath1 = picturePath1;
/*      */   }
/*      */ 
/*      */   public String getPicturePath2()
/*      */   {
/*  362 */     return this.picturePath2;
/*      */   }
/*      */ 
/*      */   public void setPicturePath2(String picturePath2)
/*      */   {
/*  369 */     this.picturePath2 = picturePath2;
/*      */   }
/*      */ 
/*      */   public String getPicturePath3()
/*      */   {
/*  376 */     return this.picturePath3;
/*      */   }
/*      */ 
/*      */   public void setPicturePath3(String picturePath3)
/*      */   {
/*  383 */     this.picturePath3 = picturePath3;
/*      */   }
/*      */ 
/*      */   public String getPicturePath4()
/*      */   {
/*  390 */     return this.picturePath4;
/*      */   }
/*      */ 
/*      */   public void setPicturePath4(String picturePath4)
/*      */   {
/*  397 */     this.picturePath4 = picturePath4;
/*      */   }
/*      */ 
/*      */   public Long getBreedStandardId()
/*      */   {
/*  404 */     return this.breedStandardId;
/*      */   }
/*      */ 
/*      */   public void setBreedStandardId(Long breedStandardId)
/*      */   {
/*  411 */     this.breedStandardId = breedStandardId;
/*      */   }
/*      */ 
/*      */   public String getDescription()
/*      */   {
/*  418 */     return this.description;
/*      */   }
/*      */ 
/*      */   public void setDescription(String description)
/*      */   {
/*  425 */     this.description = description;
/*      */   }
/*      */ 
/*      */   public String getProvince()
/*      */   {
/*  432 */     return this.province;
/*      */   }
/*      */ 
/*      */   public void setProvince(String province)
/*      */   {
/*  439 */     this.province = province;
/*      */   }
/*      */ 
/*      */   public String getCity()
/*      */   {
/*  446 */     return this.city;
/*      */   }
/*      */ 
/*      */   public void setCity(String city)
/*      */   {
/*  453 */     this.city = city;
/*      */   }
/*      */ 
/*      */   public String getArea()
/*      */   {
/*  460 */     return this.area;
/*      */   }
/*      */ 
/*      */   public void setArea(String area)
/*      */   {
/*  467 */     this.area = area;
/*      */   }
/*      */ 
/*      */   public String getAddress()
/*      */   {
/*  474 */     return this.address;
/*      */   }
/*      */ 
/*      */   public void setAddress(String address)
/*      */   {
/*  481 */     this.address = address;
/*      */   }
/*      */ 
/*      */   public String getZipCode()
/*      */   {
/*  488 */     return this.zipCode;
/*      */   }
/*      */ 
/*      */   public void setZipCode(String zipCode)
/*      */   {
/*  495 */     this.zipCode = zipCode;
/*      */   }
/*      */ 
/*      */   public String getLinkMan()
/*      */   {
/*  502 */     return this.linkMan;
/*      */   }
/*      */ 
/*      */   public void setLinkMan(String linkMan)
/*      */   {
/*  509 */     this.linkMan = linkMan;
/*      */   }
/*      */ 
/*      */   public String getPhone()
/*      */   {
/*  516 */     return this.phone;
/*      */   }
/*      */ 
/*      */   public void setPhone(String phone)
/*      */   {
/*  523 */     this.phone = phone;
/*      */   }
/*      */ 
/*      */   public Long getId()
/*      */   {
/*  530 */     return this.id;
/*      */   }
/*      */ 
/*      */   public void setId(Long id)
/*      */   {
/*  537 */     this.id = id;
/*      */   }
/*      */ 
/*      */   public String getTitle()
/*      */   {
/*  544 */     return this.title;
/*      */   }
/*      */ 
/*      */   public void setTitle(String title)
/*      */   {
/*  551 */     this.title = title;
/*      */   }
/*      */ 
/*      */   public String getCode()
/*      */   {
/*  558 */     return this.code;
/*      */   }
/*      */ 
/*      */   public void setCode(String code)
/*      */   {
/*  565 */     this.code = code;
/*      */   }
/*      */ 
/*      */   public Long getUserId()
/*      */   {
/*  572 */     return this.userId;
/*      */   }
/*      */ 
/*      */   public void setUserId(Long userId)
/*      */   {
/*  579 */     this.userId = userId;
/*      */   }
/*      */ 
/*      */   public String getUserAccount()
/*      */   {
/*  586 */     return this.userAccount;
/*      */   }
/*      */ 
/*      */   public void setUserAccount(String userAccount)
/*      */   {
/*  593 */     this.userAccount = userAccount;
/*      */   }
/*      */ 
/*      */   public String getListingType()
/*      */   {
/*  600 */     return this.listingType;
/*      */   }
/*      */ 
/*      */   public void setListingType(String listingType)
/*      */   {
/*  607 */     this.listingType = listingType;
/*      */   }
/*      */ 
/*      */   public String getMeasureUnit()
/*      */   {
/*  614 */     return this.measureUnit;
/*      */   }
/*      */ 
/*      */   public void setMeasureUnit(String measureUnit)
/*      */   {
/*  621 */     this.measureUnit = measureUnit;
/*      */   }
/*      */ 
/*      */   public Long getQuantity()
/*      */   {
/*  628 */     return this.quantity;
/*      */   }
/*      */ 
/*      */   public void setQuantity(Long quantity)
/*      */   {
/*  635 */     this.quantity = quantity;
/*      */   }
/*      */ 
/*      */   public String getValuationUnit()
/*      */   {
/*  642 */     return this.valuationUnit;
/*      */   }
/*      */ 
/*      */   public void setValuationUnit(String valuationUnit)
/*      */   {
/*  649 */     this.valuationUnit = valuationUnit;
/*      */   }
/*      */ 
/*      */   public Long getListingPrice()
/*      */   {
/*  656 */     return this.listingPrice;
/*      */   }
/*      */ 
/*      */   public void setListingPrice(Long listingPrice)
/*      */   {
/*  663 */     this.listingPrice = listingPrice;
/*      */   }
/*      */ 
/*      */   public Long getMultipleBase()
/*      */   {
/*  670 */     return this.multipleBase;
/*      */   }
/*      */ 
/*      */   public void setMultipleBase(Long multipleBase)
/*      */   {
/*  677 */     this.multipleBase = multipleBase;
/*      */   }
/*      */ 
/*      */   public Long getMaxQuantity()
/*      */   {
/*  686 */     return this.maxQuantity;
/*      */   }
/*      */ 
/*      */   public void setMaxQuantity(Long maxQuantity)
/*      */   {
/*  695 */     this.maxQuantity = maxQuantity;
/*      */   }
/*      */ 
/*      */   public Long getMinQuantity()
/*      */   {
/*  706 */     return this.minQuantity;
/*      */   }
/*      */ 
/*      */   public void setMinQuantity(Long minQuantity)
/*      */   {
/*  717 */     this.minQuantity = minQuantity;
/*      */   }
/*      */ 
/*      */   public String getRetail()
/*      */   {
/*  726 */     return this.retail;
/*      */   }
/*      */ 
/*      */   public void setRetail(String retail)
/*      */   {
/*  735 */     this.retail = retail;
/*      */   }
/*      */ 
/*      */   public String getProjectTypeCode()
/*      */   {
/*  742 */     return this.projectTypeCode;
/*      */   }
/*      */ 
/*      */   public void setProjectTypeCode(String projectTypeCode)
/*      */   {
/*  749 */     this.projectTypeCode = projectTypeCode;
/*      */   }
/*      */ 
/*      */   public String getBreedStandard()
/*      */   {
/*  756 */     return this.breedStandard;
/*      */   }
/*      */ 
/*      */   public void setBreedStandard(String breedStandard)
/*      */   {
/*  763 */     this.breedStandard = breedStandard;
/*      */   }
/*      */ 
/*      */   public String getTradingType()
/*      */   {
/*  770 */     return this.tradingType;
/*      */   }
/*      */ 
/*      */   public void setTradingType(String tradingType)
/*      */   {
/*  777 */     this.tradingType = tradingType;
/*      */   }
/*      */ 
/*      */   public Date getDeliveryDate()
/*      */   {
/*  784 */     return this.deliveryDate;
/*      */   }
/*      */ 
/*      */   public void setDeliveryDate(Date deliveryDate)
/*      */   {
/*  791 */     this.deliveryDate = deliveryDate;
/*      */   }
/*      */ 
/*      */   public String getDeliveryPlace()
/*      */   {
/*  798 */     return this.deliveryPlace;
/*      */   }
/*      */ 
/*      */   public void setDeliveryPlace(String deliveryPlace)
/*      */   {
/*  805 */     this.deliveryPlace = deliveryPlace;
/*      */   }
/*      */ 
/*      */   public String getDeliveryType()
/*      */   {
/*  812 */     return this.deliveryType;
/*      */   }
/*      */ 
/*      */   public void setDeliveryType(String deliveryType)
/*      */   {
/*  819 */     this.deliveryType = deliveryType;
/*      */   }
/*      */ 
/*      */   public String getPaymentType()
/*      */   {
/*  826 */     return this.paymentType;
/*      */   }
/*      */ 
/*      */   public void setPaymentType(String paymentType)
/*      */   {
/*  833 */     this.paymentType = paymentType;
/*      */   }
/*      */ 
/*      */   public Date getListingStartTime()
/*      */   {
/*  840 */     return this.listingStartTime;
/*      */   }
/*      */ 
/*      */   public void setListingStartTime(Date listingStartTime)
/*      */   {
/*  847 */     this.listingStartTime = listingStartTime;
/*      */   }
/*      */ 
/*      */   public Date getListingEndTime()
/*      */   {
/*  856 */     return this.listingEndTime;
/*      */   }
/*      */ 
/*      */   public void setListingEndTime(Date listingEndTime)
/*      */   {
/*  865 */     this.listingEndTime = listingEndTime;
/*      */   }
/*      */ 
/*      */   public String getInvoice()
/*      */   {
/*  872 */     return this.invoice;
/*      */   }
/*      */ 
/*      */   public void setInvoice(String invoice)
/*      */   {
/*  879 */     this.invoice = invoice;
/*      */   }
/*      */ 
/*      */   public String getStatus()
/*      */   {
/*  888 */     return this.status;
/*      */   }
/*      */ 
/*      */   public void setStatus(String status)
/*      */   {
/*  897 */     this.status = status;
/*      */   }
/*      */ 
/*      */   public String getProcessAuditNodes()
/*      */   {
/*  906 */     return this.processAuditNodes;
/*      */   }
/*      */ 
/*      */   public void setProcessAuditNodes(String processAuditNodes)
/*      */   {
/*  915 */     this.processAuditNodes = processAuditNodes;
/*      */   }
/*      */ 
/*      */   public String getAuditNode()
/*      */   {
/*  922 */     return this.auditNode;
/*      */   }
/*      */ 
/*      */   public void setAuditNode(String auditNode)
/*      */   {
/*  929 */     this.auditNode = auditNode;
/*      */   }
/*      */ 
/*      */   public String getCreator()
/*      */   {
/*  936 */     return this.creator;
/*      */   }
/*      */ 
/*      */   public void setCreator(String creator)
/*      */   {
/*  943 */     this.creator = creator;
/*      */   }
/*      */ 
/*      */   public String getCreatorType()
/*      */   {
/*  950 */     return this.creatorType;
/*      */   }
/*      */ 
/*      */   public void setCreatorType(String creatorType)
/*      */   {
/*  957 */     this.creatorType = creatorType;
/*      */   }
/*      */ 
/*      */   public String getOperator()
/*      */   {
/*  964 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String operator)
/*      */   {
/*  971 */     this.operator = operator;
/*      */   }
/*      */ 
/*      */   public Date getGmtCreate() {
/*  975 */     return this.gmtCreate;
/*      */   }
/*      */ 
/*      */   public void setGmtCreate(Date gmtCreate) {
/*  979 */     this.gmtCreate = gmtCreate;
/*      */   }
/*      */ 
/*      */   public Date getGmtModify() {
/*  983 */     return this.gmtModify;
/*      */   }
/*      */ 
/*      */   public void setGmtModify(Date gmtModify) {
/*  987 */     this.gmtModify = gmtModify;
/*      */   }
/*      */ 
/*      */   public void setAttriMeta(List<AttriMeta> attriMeta) {
/*  991 */     this.attriMeta = attriMeta;
/*      */   }
/*      */ 
/*      */   public List<AttriMeta> getAttriMeta() {
/*  995 */     return this.attriMeta;
/*      */   }
/*      */ 
/*      */   public List<AttriMeta> getTradeMeta() {
/*  999 */     return this.tradeMeta;
/*      */   }
/*      */ 
/*      */   public void setTradeMeta(List<AttriMeta> tradeMeta) {
/* 1003 */     this.tradeMeta = tradeMeta;
/*      */   }
/*      */ 
/*      */   public void setMetaValues(ProjectMetas[] metaValues) {
/* 1007 */     this.metaValues = metaValues;
/*      */   }
/*      */ 
/*      */   public ProjectMetas[] getMetaValues() {
/* 1011 */     return this.metaValues;
/*      */   }
/*      */ 
/*      */   public List<ProjectStandard> getProjectStandardList() {
/* 1015 */     return this.projectStandardList;
/*      */   }
/*      */ 
/*      */   public void setProjectStandardList(List<ProjectStandard> projectStandardList) {
/* 1019 */     this.projectStandardList = projectStandardList;
/*      */   }
/*      */ 
/*      */   public void setProjectTypeName(String projectTypeName) {
/* 1023 */     this.projectTypeName = projectTypeName;
/*      */   }
/*      */ 
/*      */   public String getProjectTypeName() {
/* 1027 */     return this.projectTypeName;
/*      */   }
/*      */ 
/*      */   public void setProjectTypeCodeDesc(String projectTypeCodeDesc) {
/* 1031 */     this.projectTypeCodeDesc = projectTypeCodeDesc;
/*      */   }
/*      */ 
/*      */   public String getProjectTypeCodeDesc() {
/* 1035 */     return this.projectTypeCodeDesc;
/*      */   }
/*      */ 
/*      */   public String getStatusDesc() {
/* 1039 */     EnumProjectStatus statusEnum = EnumProjectStatus.indexByValue(this.status);
/* 1040 */     if (statusEnum == null) {
/* 1041 */       return this.status;
/*      */     }
/* 1043 */     return statusEnum.getName();
/*      */   }
/*      */ 
/*      */   public String getListingTypeDesc() {
/* 1047 */     EnumListingType listingTypeEnum = EnumListingType.indexByValue(this.listingType);
/* 1048 */     if (listingTypeEnum == null) {
/* 1049 */       return this.listingType;
/*      */     }
/* 1051 */     return listingTypeEnum.getName();
/*      */   }
/*      */ 
/*      */   public String getTradingTypeDesc() {
/* 1055 */     EnumTradingType tradingTypeEnum = EnumTradingType.indexByValue(this.tradingType);
/* 1056 */     if (tradingTypeEnum == null) {
/* 1057 */       return this.tradingType;
/*      */     }
/* 1059 */     return tradingTypeEnum.getName();
/*      */   }
/*      */ 
/*      */   public String getPaymentTypeDesc() {
/* 1063 */     String paymentTypeStr = "";
/* 1064 */     if (this.paymentType != null) {
/* 1065 */       String[] paymentTypes = this.paymentType.trim().split(",");
/* 1066 */       for (String type : paymentTypes) {
/* 1067 */         EnumPaymentType paymentTypeEnum = EnumPaymentType.indexByValue(type);
/* 1068 */         if (paymentTypeEnum == null)
/* 1069 */           paymentTypeStr = paymentTypeStr + type + ",";
/*      */         else {
/* 1071 */           paymentTypeStr = paymentTypeStr + paymentTypeEnum.getName() + ",";
/*      */         }
/*      */       }
/* 1074 */       if (paymentTypeStr.lastIndexOf(",") == paymentTypeStr.length() - 1) {
/* 1075 */         paymentTypeStr = paymentTypeStr.substring(0, paymentTypeStr.length() - 1);
/*      */       }
/*      */     }
/* 1078 */     return paymentTypeStr;
/*      */   }
/*      */ 
/*      */   public String getMeasureUnitDesc() {
/* 1082 */     EnumMeasureUnit measureUnitEnum = EnumMeasureUnit.indexByValue(this.measureUnit);
/* 1083 */     if (measureUnitEnum == null) {
/* 1084 */       return this.measureUnit;
/*      */     }
/* 1086 */     return measureUnitEnum.getName();
/*      */   }
/*      */ 
/*      */   public String getDeliveryTypeDesc() {
/* 1090 */     String deliveryTypeStr = "";
/* 1091 */     if (this.deliveryType != null) {
/* 1092 */       String[] deliveryTypes = this.deliveryType.trim().split(",");
/* 1093 */       for (String type : deliveryTypes) {
/* 1094 */         EnumDeliveryType deliveryTypeEnum = EnumDeliveryType.indexByValue(type);
/* 1095 */         if (deliveryTypeEnum == null)
/* 1096 */           deliveryTypeStr = deliveryTypeStr + type + ",";
/*      */         else {
/* 1098 */           deliveryTypeStr = deliveryTypeStr + deliveryTypeEnum.getName() + ",";
/*      */         }
/*      */       }
/* 1101 */       if (deliveryTypeStr.lastIndexOf(",") == deliveryTypeStr.length() - 1) {
/* 1102 */         deliveryTypeStr = deliveryTypeStr.substring(0, deliveryTypeStr.length() - 1);
/*      */       }
/*      */     }
/* 1105 */     return deliveryTypeStr;
/*      */   }
/*      */ 
/*      */   public String getValuationUnitDesc() {
/* 1109 */     EnumValuationUnit valuationUnitEnum = EnumValuationUnit.indexByValue(this.valuationUnit);
/* 1110 */     if (valuationUnitEnum == null) {
/* 1111 */       return this.valuationUnit;
/*      */     }
/* 1113 */     return valuationUnitEnum.getName();
/*      */   }
/*      */ 
/*      */   public String getListingPriceDesc() {
/* 1117 */     return this.listingPriceDesc;
/*      */   }
/*      */ 
/*      */   public void setListingPriceDesc(String listingPriceDesc) {
/* 1121 */     this.listingPriceDesc = listingPriceDesc;
/*      */   }
/*      */ 
/*      */   public void setListingPriceShow(String listingPriceShow) {
/* 1125 */     this.listingPriceShow = listingPriceShow;
/*      */   }
/*      */ 
/*      */   public String getListingPriceShow() {
/* 1129 */     if ((this.listingPrice.longValue() > 0L) && (StringUtil.isNotEmpty(this.valuationUnit))) {
/* 1130 */       this.listingPriceShow = CommonUtils.getValuationUnit(this.listingPrice, this.valuationUnit);
/*      */     }
/*      */ 
/* 1135 */     return this.listingPriceShow;
/*      */   }
/*      */ 
/*      */   public Map<String, ProjectTypeAttri> getAttriMap() {
/* 1139 */     Map attriMap = new HashMap();
/* 1140 */     for (ProjectTypeAttri e : getAttriList()) {
/* 1141 */       attriMap.put(e.getKeyName(), e);
/*      */     }
/* 1143 */     return attriMap;
/*      */   }
/*      */ 
/*      */   public List<ProjectTypeAttri> getAttriList() {
/* 1147 */     List attris = new ArrayList();
/* 1148 */     for (AttriMeta e : this.attriMeta) {
/* 1149 */       attris.add(e.getAttr());
/*      */     }
/* 1151 */     return attris;
/*      */   }
/*      */ 
/*      */   public TradeShowDTO[] getTradeMetas() {
/* 1155 */     return this.tradeMetas;
/*      */   }
/*      */ 
/*      */   public void setTradeMetas(TradeShowDTO[] tradeMetas) {
/* 1159 */     this.tradeMetas = tradeMetas;
/*      */   }
/*      */ 
/*      */   public List<ProjectMetas> getMetaList() {
/* 1163 */     List metas = new ArrayList();
/* 1164 */     if ((this.attriMeta != null) && (this.attriMeta.size() > 0)) {
/* 1165 */       for (AttriMeta e : this.attriMeta)
/* 1166 */         metas.add(e.getMeta());
/*      */     }
/* 1168 */     return metas;
/*      */   }
/*      */ 
/*      */   public Long getDeposit() {
/* 1172 */     return this.deposit;
/*      */   }
/*      */ 
/*      */   public void setDeposit(Long deposit) {
/* 1176 */     this.deposit = deposit;
/*      */   }
/*      */ 
/*      */   public String getStorehouse() {
/* 1180 */     return this.storehouse;
/*      */   }
/*      */ 
/*      */   public void setStorehouse(String storehouse) {
/* 1184 */     this.storehouse = storehouse;
/*      */   }
/*      */ 
/*      */   public String getFundAccount() {
/* 1188 */     return this.fundAccount;
/*      */   }
/*      */ 
/*      */   public void setFundAccount(String fundAccount) {
/* 1192 */     this.fundAccount = fundAccount;
/*      */   }
/*      */ 
/*      */   public String getInvoiceDesc() {
/* 1196 */     String invoiceStr = "";
/* 1197 */     if ((this.invoice != null) && (!this.invoice.equals(""))) {
/* 1198 */       String[] invoices = this.invoice.trim().split(",");
/* 1199 */       for (String invoiceType : invoices) {
/* 1200 */         EnumInvoice invoiceTypeEnum = EnumInvoice.indexByValue(invoiceType);
/* 1201 */         if (invoiceTypeEnum == null)
/* 1202 */           invoiceStr = invoiceStr + invoiceType + ",";
/*      */         else {
/* 1204 */           invoiceStr = invoiceStr + invoiceTypeEnum.getName() + ",";
/*      */         }
/*      */       }
/* 1207 */       if (invoiceStr.lastIndexOf(",") == invoiceStr.length() - 1) {
/* 1208 */         invoiceStr = invoiceStr.substring(0, invoiceStr.length() - 1);
/*      */       }
/*      */     }
/* 1211 */     return invoiceStr;
/*      */   }
/*      */ 
/*      */   public String getDepositDesc() {
/* 1215 */     if ((this.status.equals(EnumProjectStatus.CREATE.getValue())) || 
/* 1216 */       (this.status.equals(EnumProjectStatus.FAIL.getValue())) || 
/* 1217 */       (this.status.equals(EnumProjectStatus.WITHDRAWAL.getValue())) || 
/* 1218 */       (this.status.equals(EnumProjectStatus.OVER.getValue()))) {
/* 1219 */       return "0";
/*      */     }
/*      */ 
/* 1222 */     Long deposit = Long.valueOf(this.deposit.longValue() * this.quantity.longValue());
/* 1223 */     return CommonUtils.getValuationUnitDesc(deposit, this.valuationUnit);
/*      */   }
/*      */ 
/*      */   public boolean isWaitOpt()
/*      */   {
/* 1232 */     return EnumProjectStatus.CREATE.getValue().equals(getStatus());
/*      */   }
/*      */ 
/*      */   public void setAttachedFilePath(String attachedFilePath)
/*      */   {
/* 1238 */     this.attachedFilePath = attachedFilePath;
/*      */   }
/*      */ 
/*      */   public String getAttachedFilePath() {
/* 1242 */     return this.attachedFilePath;
/*      */   }
/*      */ 
/*      */   public String getTempPath() {
/* 1246 */     return this.tempPath;
/*      */   }
/*      */ 
/*      */   public void setTempPath(String tempPath) {
/* 1250 */     this.tempPath = tempPath;
/*      */   }
/*      */ 
/*      */   public String getTempPath1() {
/* 1254 */     return this.tempPath1;
/*      */   }
/*      */ 
/*      */   public void setTempPath1(String tempPath1) {
/* 1258 */     this.tempPath1 = tempPath1;
/*      */   }
/*      */ 
/*      */   public String getTempPath2() {
/* 1262 */     return this.tempPath2;
/*      */   }
/*      */ 
/*      */   public void setTempPath2(String tempPath2) {
/* 1266 */     this.tempPath2 = tempPath2;
/*      */   }
/*      */ 
/*      */   public String getTempPath3() {
/* 1270 */     return this.tempPath3;
/*      */   }
/*      */ 
/*      */   public void setTempPath3(String tempPath3) {
/* 1274 */     this.tempPath3 = tempPath3;
/*      */   }
/*      */ 
/*      */   public String getTempPath4() {
/* 1278 */     return this.tempPath4;
/*      */   }
/*      */ 
/*      */   public void setTempPath4(String tempPath4) {
/* 1282 */     this.tempPath4 = tempPath4;
/*      */   }
/*      */ 
/*      */   public Long getSubstationId() {
/* 1286 */     return this.substationId;
/*      */   }
/*      */ 
/*      */   public void setSubstationId(Long substationId) {
/* 1290 */     this.substationId = substationId;
/*      */   }
/*      */ 
/*      */   public String getForestryQuantityDes() {
/* 1294 */     return this.forestryQuantityDes;
/*      */   }
/*      */ 
/*      */   public void setForestryQuantityDes(String forestryQuantityDes) {
/* 1298 */     this.forestryQuantityDes = forestryQuantityDes;
/*      */   }
/*      */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.domain.project.ProjectListing
 * JD-Core Version:    0.6.0
 */