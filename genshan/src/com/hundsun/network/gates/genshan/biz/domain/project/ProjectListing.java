/*      */ package com.hundsun.network.gates.genshan.biz.domain.project;
/*      */ 
/*      */ import com.hundsun.network.gates.genshan.biz.domain.BaseDomain;
/*      */ import com.hundsun.network.gates.genshan.biz.domain.order.TradeOrder;
/*      */ import com.hundsun.network.gates.luosi.biz.domain.TradeShowDTO;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumDeliveryType;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumInvoice;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumListingType;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumMeasureUnit;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumOperatorType;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumPaymentType;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumProcessAuditNodes;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumProjectRetail;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumProjectStatus;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumTradingType;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumValuationUnit;
/*      */ import com.hundsun.network.gates.luosi.common.utils.CommonUtils;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Date;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ 
/*      */ public class ProjectListing extends BaseDomain
/*      */ {
/*      */   private static final long serialVersionUID = 4430798373604215671L;
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
/*      */   private Double listingPriceDesc;
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
/*      */   private ProjectMetas[] metaValues;
/*      */   private TradeShowDTO[] tradeMetas;
/*      */   private ProjectStandard standard;
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
/*  315 */   private String tempPath = "tempPath";
/*  316 */   private String tempPath1 = "tempPath1";
/*  317 */   private String tempPath2 = "tempPath2";
/*  318 */   private String tempPath3 = "tempPath3";
/*  319 */   private String tempPath4 = "tempPath4";
/*      */   private Long substationId;
/*      */   private List<TradeOrder> tradeOrderList;
/*      */ 
/*      */   public String getPicturePath()
/*      */   {
/*  335 */     return this.picturePath;
/*      */   }
/*      */ 
/*      */   public void setPicturePath(String picturePath)
/*      */   {
/*  342 */     this.picturePath = picturePath;
/*      */   }
/*      */ 
/*      */   public String getPicturePath1()
/*      */   {
/*  349 */     return this.picturePath1;
/*      */   }
/*      */ 
/*      */   public void setPicturePath1(String picturePath1)
/*      */   {
/*  356 */     this.picturePath1 = picturePath1;
/*      */   }
/*      */ 
/*      */   public String getPicturePath2()
/*      */   {
/*  363 */     return this.picturePath2;
/*      */   }
/*      */ 
/*      */   public void setPicturePath2(String picturePath2)
/*      */   {
/*  370 */     this.picturePath2 = picturePath2;
/*      */   }
/*      */ 
/*      */   public String getPicturePath3()
/*      */   {
/*  377 */     return this.picturePath3;
/*      */   }
/*      */ 
/*      */   public void setPicturePath3(String picturePath3)
/*      */   {
/*  384 */     this.picturePath3 = picturePath3;
/*      */   }
/*      */ 
/*      */   public String getPicturePath4()
/*      */   {
/*  391 */     return this.picturePath4;
/*      */   }
/*      */ 
/*      */   public void setPicturePath4(String picturePath4)
/*      */   {
/*  398 */     this.picturePath4 = picturePath4;
/*      */   }
/*      */ 
/*      */   public Long getBreedStandardId()
/*      */   {
/*  405 */     return this.breedStandardId;
/*      */   }
/*      */ 
/*      */   public void setBreedStandardId(Long breedStandardId)
/*      */   {
/*  412 */     this.breedStandardId = breedStandardId;
/*      */   }
/*      */ 
/*      */   public String getDescription()
/*      */   {
/*  419 */     return this.description;
/*      */   }
/*      */ 
/*      */   public void setDescription(String description)
/*      */   {
/*  426 */     this.description = description;
/*      */   }
/*      */ 
/*      */   public String getStorehouse() {
/*  430 */     return this.storehouse;
/*      */   }
/*      */ 
/*      */   public void setStorehouse(String storehouse) {
/*  434 */     this.storehouse = storehouse;
/*      */   }
/*      */ 
/*      */   public String getProvince()
/*      */   {
/*  441 */     return this.province;
/*      */   }
/*      */ 
/*      */   public void setProvince(String province)
/*      */   {
/*  448 */     this.province = province;
/*      */   }
/*      */ 
/*      */   public String getCity()
/*      */   {
/*  455 */     return this.city;
/*      */   }
/*      */ 
/*      */   public void setCity(String city)
/*      */   {
/*  462 */     this.city = city;
/*      */   }
/*      */ 
/*      */   public String getArea()
/*      */   {
/*  469 */     return this.area;
/*      */   }
/*      */ 
/*      */   public void setArea(String area)
/*      */   {
/*  476 */     this.area = area;
/*      */   }
/*      */ 
/*      */   public String getAddress()
/*      */   {
/*  483 */     return this.address;
/*      */   }
/*      */ 
/*      */   public void setAddress(String address)
/*      */   {
/*  490 */     this.address = address;
/*      */   }
/*      */ 
/*      */   public String getZipCode()
/*      */   {
/*  497 */     return this.zipCode;
/*      */   }
/*      */ 
/*      */   public void setZipCode(String zipCode)
/*      */   {
/*  504 */     this.zipCode = zipCode;
/*      */   }
/*      */ 
/*      */   public String getLinkMan()
/*      */   {
/*  511 */     return this.linkMan;
/*      */   }
/*      */ 
/*      */   public void setLinkMan(String linkMan)
/*      */   {
/*  518 */     this.linkMan = linkMan;
/*      */   }
/*      */ 
/*      */   public String getPhone()
/*      */   {
/*  525 */     return this.phone;
/*      */   }
/*      */ 
/*      */   public void setPhone(String phone)
/*      */   {
/*  532 */     this.phone = phone;
/*      */   }
/*      */ 
/*      */   public Long getDeposit()
/*      */   {
/*  540 */     return this.deposit;
/*      */   }
/*      */ 
/*      */   public void setDeposit(Long deposit)
/*      */   {
/*  548 */     this.deposit = deposit;
/*      */   }
/*      */ 
/*      */   public ProjectStandard getStandard() {
/*  552 */     return this.standard;
/*      */   }
/*      */ 
/*      */   public void setStandard(ProjectStandard standard) {
/*  556 */     this.standard = standard;
/*      */   }
/*      */ 
/*      */   public List<ProjectStandard> getProjectStandardList() {
/*  560 */     return this.projectStandardList;
/*      */   }
/*      */ 
/*      */   public void setProjectStandardList(List<ProjectStandard> projectStandardList) {
/*  564 */     this.projectStandardList = projectStandardList;
/*      */   }
/*      */ 
/*      */   public ProjectMetas[] getMetaValues() {
/*  568 */     return this.metaValues;
/*      */   }
/*      */ 
/*      */   public void setMetaValues(ProjectMetas[] metaValues) {
/*  572 */     this.metaValues = metaValues;
/*      */   }
/*      */ 
/*      */   public List<AttriMeta> getAttriMeta() {
/*  576 */     return this.attriMeta;
/*      */   }
/*      */ 
/*      */   public List<ProjectMetas> getMetaList() {
/*  580 */     List metas = new ArrayList();
/*  581 */     for (AttriMeta e : this.attriMeta) {
/*  582 */       metas.add(e.getMeta());
/*      */     }
/*  584 */     return metas;
/*      */   }
/*      */ 
/*      */   public Map<String, ProjectTypeAttri> getAttriMap() {
/*  588 */     Map attriMap = new HashMap();
/*  589 */     for (ProjectTypeAttri e : getAttriList()) {
/*  590 */       attriMap.put(e.getKeyName(), e);
/*      */     }
/*  592 */     return attriMap;
/*      */   }
/*      */ 
/*      */   public List<ProjectTypeAttri> getAttriList() {
/*  596 */     List attris = new ArrayList();
/*  597 */     for (AttriMeta e : this.attriMeta) {
/*  598 */       attris.add(e.getAttr());
/*      */     }
/*  600 */     return attris;
/*      */   }
/*      */ 
/*      */   public void setAttriMeta(List<AttriMeta> attriMeta) {
/*  604 */     this.attriMeta = attriMeta;
/*      */   }
/*      */ 
/*      */   public Long getId() {
/*  608 */     return this.id;
/*      */   }
/*      */ 
/*      */   public void setId(Long id) {
/*  612 */     this.id = id;
/*      */   }
/*      */ 
/*      */   public String getTitle()
/*      */   {
/*  619 */     return this.title;
/*      */   }
/*      */ 
/*      */   public void setTitle(String title)
/*      */   {
/*  626 */     this.title = title;
/*      */   }
/*      */ 
/*      */   public String getCode()
/*      */   {
/*  633 */     return this.code;
/*      */   }
/*      */ 
/*      */   public void setCode(String code)
/*      */   {
/*  640 */     this.code = code;
/*      */   }
/*      */ 
/*      */   public Long getUserId()
/*      */   {
/*  647 */     return this.userId;
/*      */   }
/*      */ 
/*      */   public void setUserId(Long userId)
/*      */   {
/*  654 */     this.userId = userId;
/*      */   }
/*      */ 
/*      */   public String getUserAccount()
/*      */   {
/*  661 */     return this.userAccount;
/*      */   }
/*      */ 
/*      */   public void setUserAccount(String userAccount)
/*      */   {
/*  668 */     this.userAccount = userAccount;
/*      */   }
/*      */ 
/*      */   public String getListingType()
/*      */   {
/*  675 */     return this.listingType;
/*      */   }
/*      */ 
/*      */   public String getListingTypeDesc()
/*      */   {
/*  682 */     EnumListingType aListingType = EnumListingType.indexByValue(this.listingType);
/*  683 */     return aListingType == null ? this.listingType : aListingType.getName();
/*      */   }
/*      */ 
/*      */   public void setListingType(String listingType)
/*      */   {
/*  690 */     this.listingType = listingType;
/*      */   }
/*      */ 
/*      */   public String getMeasureUnit()
/*      */   {
/*  697 */     return this.measureUnit;
/*      */   }
/*      */ 
/*      */   public String getMeasureUnitDesc()
/*      */   {
/*  704 */     EnumMeasureUnit aMeasureUnit = EnumMeasureUnit.indexByValue(this.measureUnit);
/*  705 */     return aMeasureUnit == null ? this.measureUnit : aMeasureUnit.getName();
/*      */   }
/*      */ 
/*      */   public void setMeasureUnit(String measureUnit)
/*      */   {
/*  712 */     this.measureUnit = measureUnit;
/*      */   }
/*      */ 
/*      */   public Long getQuantity()
/*      */   {
/*  719 */     return this.quantity;
/*      */   }
/*      */ 
/*      */   public void setQuantity(Long quantity)
/*      */   {
/*  726 */     this.quantity = quantity;
/*      */   }
/*      */ 
/*      */   public String getValuationUnit()
/*      */   {
/*  733 */     return this.valuationUnit;
/*      */   }
/*      */ 
/*      */   public String getValuationUnitDesc()
/*      */   {
/*  740 */     EnumValuationUnit aValuationUnit = EnumValuationUnit.indexByValue(this.valuationUnit);
/*  741 */     return aValuationUnit == null ? this.valuationUnit : aValuationUnit.getName();
/*      */   }
/*      */ 
/*      */   public void setValuationUnit(String valuationUnit)
/*      */   {
/*  748 */     this.valuationUnit = valuationUnit;
/*      */   }
/*      */ 
/*      */   public Long getListingPrice()
/*      */   {
/*  755 */     return this.listingPrice;
/*      */   }
/*      */ 
/*      */   public void setListingPrice(Long listingPrice)
/*      */   {
/*  762 */     this.listingPrice = listingPrice;
/*      */   }
/*      */ 
/*      */   public Double getListingPriceDesc()
/*      */   {
/*  769 */     return this.listingPriceDesc;
/*      */   }
/*      */ 
/*      */   public void setListingPriceDesc(Double listingPriceDesc)
/*      */   {
/*  776 */     this.listingPriceDesc = listingPriceDesc;
/*      */   }
/*      */ 
/*      */   public Long getMultipleBase()
/*      */   {
/*  783 */     return this.multipleBase;
/*      */   }
/*      */ 
/*      */   public void setMultipleBase(Long multipleBase)
/*      */   {
/*  790 */     this.multipleBase = multipleBase;
/*      */   }
/*      */ 
/*      */   public Long getMaxQuantity()
/*      */   {
/*  799 */     return this.maxQuantity;
/*      */   }
/*      */ 
/*      */   public void setMaxQuantity(Long maxQuantity)
/*      */   {
/*  808 */     this.maxQuantity = maxQuantity;
/*      */   }
/*      */ 
/*      */   public Long getMinQuantity()
/*      */   {
/*  819 */     return this.minQuantity;
/*      */   }
/*      */ 
/*      */   public void setMinQuantity(Long minQuantity)
/*      */   {
/*  830 */     this.minQuantity = minQuantity;
/*      */   }
/*      */ 
/*      */   public String getRetail()
/*      */   {
/*  839 */     return this.retail;
/*      */   }
/*      */ 
/*      */   public void setRetail(String retail)
/*      */   {
/*  848 */     this.retail = retail;
/*      */   }
/*      */ 
/*      */   public String getRetailDesc()
/*      */   {
/*  855 */     EnumProjectRetail aRetail = EnumProjectRetail.indexByValue(this.retail);
/*  856 */     return aRetail == null ? this.retail : aRetail.getName();
/*      */   }
/*      */ 
/*      */   public String getProjectTypeCode()
/*      */   {
/*  863 */     return this.projectTypeCode;
/*      */   }
/*      */ 
/*      */   public void setProjectTypeCode(String projectTypeCode)
/*      */   {
/*  870 */     this.projectTypeCode = projectTypeCode;
/*      */   }
/*      */ 
/*      */   public String getFundAccount() {
/*  874 */     return this.fundAccount;
/*      */   }
/*      */ 
/*      */   public void setFundAccount(String fundAccount) {
/*  878 */     this.fundAccount = fundAccount;
/*      */   }
/*      */ 
/*      */   public String getProjectTypeCodeDesc() {
/*  882 */     return this.projectTypeCodeDesc;
/*      */   }
/*      */ 
/*      */   public void setProjectTypeCodeDesc(String projectTypeCodeDesc) {
/*  886 */     this.projectTypeCodeDesc = projectTypeCodeDesc;
/*      */   }
/*      */ 
/*      */   public String getProjectTypeName()
/*      */   {
/*  893 */     return this.projectTypeName;
/*      */   }
/*      */ 
/*      */   public void setProjectTypeName(String projectTypeName)
/*      */   {
/*  900 */     this.projectTypeName = projectTypeName;
/*      */   }
/*      */ 
/*      */   public String getBreedStandard()
/*      */   {
/*  907 */     return this.breedStandard;
/*      */   }
/*      */ 
/*      */   public void setBreedStandard(String breedStandard)
/*      */   {
/*  914 */     this.breedStandard = breedStandard;
/*      */   }
/*      */ 
/*      */   public String getTradingType()
/*      */   {
/*  921 */     return this.tradingType;
/*      */   }
/*      */ 
/*      */   public String getTradingTypeDesc()
/*      */   {
/*  928 */     EnumTradingType aTradingType = EnumTradingType.indexByValue(this.tradingType);
/*  929 */     return aTradingType == null ? this.tradingType : aTradingType.getName();
/*      */   }
/*      */ 
/*      */   public void setTradingType(String tradingType)
/*      */   {
/*  936 */     this.tradingType = tradingType;
/*      */   }
/*      */ 
/*      */   public Date getDeliveryDate()
/*      */   {
/*  943 */     return this.deliveryDate;
/*      */   }
/*      */ 
/*      */   public void setDeliveryDate(Date deliveryDate)
/*      */   {
/*  950 */     this.deliveryDate = deliveryDate;
/*      */   }
/*      */ 
/*      */   public String getDeliveryPlace()
/*      */   {
/*  957 */     return this.deliveryPlace;
/*      */   }
/*      */ 
/*      */   public void setDeliveryPlace(String deliveryPlace)
/*      */   {
/*  964 */     this.deliveryPlace = deliveryPlace;
/*      */   }
/*      */ 
/*      */   public String getDeliveryType()
/*      */   {
/*  971 */     return this.deliveryType;
/*      */   }
/*      */ 
/*      */   public String getDeliveryTypeDesc()
/*      */   {
/*  978 */     String deliveryTypeStr = "";
/*  979 */     if (null != this.deliveryType) {
/*  980 */       String[] deliveryTypes = this.deliveryType.trim().split(",");
/*  981 */       for (String type : deliveryTypes) {
/*  982 */         EnumDeliveryType deliveryTypeEnum = EnumDeliveryType.indexByValue(type);
/*  983 */         if (null == deliveryTypeEnum)
/*  984 */           deliveryTypeStr = new StringBuilder().append(deliveryTypeStr).append(type).append(",").toString();
/*      */         else {
/*  986 */           deliveryTypeStr = new StringBuilder().append(deliveryTypeStr).append(deliveryTypeEnum.getName()).append(",").toString();
/*      */         }
/*      */       }
/*  989 */       if (deliveryTypeStr.lastIndexOf(",") == deliveryTypeStr.length() - 1) {
/*  990 */         deliveryTypeStr = deliveryTypeStr.substring(0, deliveryTypeStr.length() - 1);
/*      */       }
/*      */     }
/*  993 */     return deliveryTypeStr;
/*      */   }
/*      */ 
/*      */   public void setDeliveryType(String deliveryType)
/*      */   {
/* 1000 */     this.deliveryType = deliveryType;
/*      */   }
/*      */ 
/*      */   public String getPaymentType()
/*      */   {
/* 1007 */     return this.paymentType;
/*      */   }
/*      */ 
/*      */   public String getPaymentTypeDesc()
/*      */   {
/* 1014 */     String paymentTypeStr = "";
/* 1015 */     if (null != this.paymentType) {
/* 1016 */       String[] paymentTypes = this.paymentType.trim().split(",");
/* 1017 */       for (String type : paymentTypes) {
/* 1018 */         EnumPaymentType paymentTypeEnum = EnumPaymentType.indexByValue(type);
/* 1019 */         if (null == paymentTypeEnum)
/* 1020 */           paymentTypeStr = new StringBuilder().append(paymentTypeStr).append(type).append(",").toString();
/*      */         else {
/* 1022 */           paymentTypeStr = new StringBuilder().append(paymentTypeStr).append(paymentTypeEnum.getName()).append(",").toString();
/*      */         }
/*      */       }
/* 1025 */       if (paymentTypeStr.lastIndexOf(",") == paymentTypeStr.length() - 1) {
/* 1026 */         paymentTypeStr = paymentTypeStr.substring(0, paymentTypeStr.length() - 1);
/*      */       }
/*      */     }
/* 1029 */     return paymentTypeStr;
/*      */   }
/*      */ 
/*      */   public void setPaymentType(String paymentType)
/*      */   {
/* 1036 */     this.paymentType = paymentType;
/*      */   }
/*      */ 
/*      */   public Date getListingStartTime()
/*      */   {
/* 1043 */     return this.listingStartTime;
/*      */   }
/*      */ 
/*      */   public void setListingStartTime(Date listingStartTime)
/*      */   {
/* 1050 */     this.listingStartTime = listingStartTime;
/*      */   }
/*      */ 
/*      */   public Date getListingEndTime()
/*      */   {
/* 1059 */     return this.listingEndTime;
/*      */   }
/*      */ 
/*      */   public void setListingEndTime(Date listingEndTime)
/*      */   {
/* 1068 */     this.listingEndTime = listingEndTime;
/*      */   }
/*      */ 
/*      */   public String getInvoice()
/*      */   {
/* 1075 */     return this.invoice;
/*      */   }
/*      */ 
/*      */   public void setInvoice(String invoice)
/*      */   {
/* 1082 */     this.invoice = invoice;
/*      */   }
/*      */ 
/*      */   public String getInvoiceDesc()
/*      */   {
/* 1089 */     String invoiceStr = "";
/* 1090 */     if ((null != this.invoice) && (!this.invoice.equals(""))) {
/* 1091 */       String[] invoices = this.invoice.trim().split(",");
/* 1092 */       for (String invoiceType : invoices) {
/* 1093 */         EnumInvoice invoiceTypeEnum = EnumInvoice.indexByValue(invoiceType);
/* 1094 */         if (null == invoiceTypeEnum)
/* 1095 */           invoiceStr = new StringBuilder().append(invoiceStr).append(invoiceType).append(",").toString();
/*      */         else {
/* 1097 */           invoiceStr = new StringBuilder().append(invoiceStr).append(invoiceTypeEnum.getName()).append(",").toString();
/*      */         }
/*      */       }
/* 1100 */       if (invoiceStr.lastIndexOf(",") == invoiceStr.length() - 1) {
/* 1101 */         invoiceStr = invoiceStr.substring(0, invoiceStr.length() - 1);
/*      */       }
/*      */     }
/* 1104 */     return invoiceStr;
/*      */   }
/*      */ 
/*      */   public String getStatus()
/*      */   {
/* 1113 */     return this.status;
/*      */   }
/*      */ 
/*      */   public String getStatusDesc()
/*      */   {
/* 1120 */     EnumProjectStatus aProjectStatus = EnumProjectStatus.indexByValue(this.status);
/* 1121 */     String result = aProjectStatus == null ? this.status : aProjectStatus.getName();
/* 1122 */     if (EnumProjectStatus.AUDIT.equals(aProjectStatus)) {
/* 1123 */       result = new StringBuilder().append(result).append(EnumProcessAuditNodes.ADVANCE_AUDIT.getValue().equals(getAuditNode()) ? "(初审)" : "(复审)").toString();
/*      */     }
/*      */ 
/* 1126 */     return result;
/*      */   }
/*      */ 
/*      */   public boolean isAudit()
/*      */   {
/* 1133 */     return EnumProjectStatus.AUDIT.equals(EnumProjectStatus.indexByValue(this.status));
/*      */   }
/*      */ 
/*      */   public boolean isAdvanceAudit()
/*      */   {
/* 1140 */     return (EnumProjectStatus.AUDIT.equals(EnumProjectStatus.indexByValue(this.status))) && (EnumProcessAuditNodes.ADVANCE_AUDIT.getValue().equals(getAuditNode()));
/*      */   }
/*      */ 
/*      */   public boolean isEdit()
/*      */   {
/* 1149 */     return (EnumProjectStatus.AUDIT.equals(EnumProjectStatus.indexByValue(this.status))) || (EnumProjectStatus.SUSPENSION.equals(EnumProjectStatus.indexByValue(this.status)));
/*      */   }
/*      */ 
/*      */   public boolean isTrade()
/*      */   {
/* 1157 */     return EnumProjectStatus.TRADE.equals(EnumProjectStatus.indexByValue(this.status));
/*      */   }
/*      */ 
/*      */   public boolean isSuspension()
/*      */   {
/* 1164 */     return EnumProjectStatus.SUSPENSION.equals(EnumProjectStatus.indexByValue(this.status));
/*      */   }
/*      */ 
/*      */   public boolean isDisplayDeposit()
/*      */   {
/* 1171 */     EnumProjectStatus enumStatus = EnumProjectStatus.indexByValue(this.status);
/* 1172 */     return (EnumProjectStatus.TRADE.equals(enumStatus)) || (EnumProjectStatus.SUSPENSION.equals(enumStatus)) || (EnumProjectStatus.AUDIT.equals(enumStatus));
/*      */   }
/*      */ 
/*      */   public void setStatus(String status)
/*      */   {
/* 1183 */     this.status = status;
/*      */   }
/*      */ 
/*      */   public String getProcessAuditNodes()
/*      */   {
/* 1192 */     return this.processAuditNodes;
/*      */   }
/*      */ 
/*      */   public void setProcessAuditNodes(String processAuditNodes)
/*      */   {
/* 1201 */     this.processAuditNodes = processAuditNodes;
/*      */   }
/*      */ 
/*      */   public String getAuditNode()
/*      */   {
/* 1208 */     return this.auditNode;
/*      */   }
/*      */ 
/*      */   public void setAuditNode(String auditNode)
/*      */   {
/* 1215 */     this.auditNode = auditNode;
/*      */   }
/*      */ 
/*      */   public String getCreator()
/*      */   {
/* 1222 */     return this.creator;
/*      */   }
/*      */ 
/*      */   public void setCreator(String creator)
/*      */   {
/* 1229 */     this.creator = creator;
/*      */   }
/*      */ 
/*      */   public String getCreatorType()
/*      */   {
/* 1236 */     return this.creatorType;
/*      */   }
/*      */ 
/*      */   public String getCreatorTypeDesc()
/*      */   {
/* 1243 */     EnumOperatorType aOperatorType = EnumOperatorType.indexByValue(this.creatorType);
/* 1244 */     return aOperatorType == null ? this.creatorType : aOperatorType.getName();
/*      */   }
/*      */ 
/*      */   public void setCreatorType(String creatorType)
/*      */   {
/* 1251 */     this.creatorType = creatorType;
/*      */   }
/*      */ 
/*      */   public String getOperator()
/*      */   {
/* 1258 */     return this.operator;
/*      */   }
/*      */ 
/*      */   public void setOperator(String operator)
/*      */   {
/* 1265 */     this.operator = operator;
/*      */   }
/*      */ 
/*      */   public Date getGmtCreate() {
/* 1269 */     return this.gmtCreate;
/*      */   }
/*      */ 
/*      */   public void setGmtCreate(Date gmtCreate) {
/* 1273 */     this.gmtCreate = gmtCreate;
/*      */   }
/*      */ 
/*      */   public Date getGmtModify() {
/* 1277 */     return this.gmtModify;
/*      */   }
/*      */ 
/*      */   public void setGmtModify(Date gmtModify) {
/* 1281 */     this.gmtModify = gmtModify;
/*      */   }
/*      */ 
/*      */   public List<AttriMeta> getTradeMeta() {
/* 1285 */     return this.tradeMeta;
/*      */   }
/*      */ 
/*      */   public void setTradeMeta(List<AttriMeta> tradeMeta) {
/* 1289 */     this.tradeMeta = tradeMeta;
/*      */   }
/*      */ 
/*      */   public TradeShowDTO[] getTradeMetas() {
/* 1293 */     return this.tradeMetas;
/*      */   }
/*      */ 
/*      */   public void setTradeMetas(TradeShowDTO[] tradeMetas) {
/* 1297 */     this.tradeMetas = tradeMetas;
/*      */   }
/*      */ 
/*      */   public String getDepositDesc() {
/* 1301 */     if ((this.status.equals(EnumProjectStatus.CREATE.getValue())) || (this.status.equals(EnumProjectStatus.FAIL.getValue())) || (this.status.equals(EnumProjectStatus.WITHDRAWAL.getValue())) || (this.status.equals(EnumProjectStatus.OVER.getValue())))
/*      */     {
/* 1305 */       return "0";
/*      */     }
/*      */ 
/* 1308 */     Long deposit = Long.valueOf(this.deposit.longValue() * this.quantity.longValue());
/* 1309 */     return CommonUtils.getValuationUnitDesc(deposit, this.valuationUnit);
/*      */   }
/*      */ 
/*      */   public void setAttachedFilePath(String attachedFilePath) {
/* 1313 */     this.attachedFilePath = attachedFilePath;
/*      */   }
/*      */ 
/*      */   public String getAttachedFilePath() {
/* 1317 */     return this.attachedFilePath;
/*      */   }
/*      */ 
/*      */   public String getTempPath() {
/* 1321 */     return this.tempPath;
/*      */   }
/*      */ 
/*      */   public void setTempPath(String tempPath) {
/* 1325 */     this.tempPath = tempPath;
/*      */   }
/*      */ 
/*      */   public String getTempPath1() {
/* 1329 */     return this.tempPath1;
/*      */   }
/*      */ 
/*      */   public void setTempPath1(String tempPath1) {
/* 1333 */     this.tempPath1 = tempPath1;
/*      */   }
/*      */ 
/*      */   public String getTempPath2() {
/* 1337 */     return this.tempPath2;
/*      */   }
/*      */ 
/*      */   public void setTempPath2(String tempPath2) {
/* 1341 */     this.tempPath2 = tempPath2;
/*      */   }
/*      */ 
/*      */   public String getTempPath3() {
/* 1345 */     return this.tempPath3;
/*      */   }
/*      */ 
/*      */   public void setTempPath3(String tempPath3) {
/* 1349 */     this.tempPath3 = tempPath3;
/*      */   }
/*      */ 
/*      */   public String getTempPath4() {
/* 1353 */     return this.tempPath4;
/*      */   }
/*      */ 
/*      */   public void setTempPath4(String tempPath4) {
/* 1357 */     this.tempPath4 = tempPath4;
/*      */   }
/*      */ 
/*      */   public Long getSubstationId() {
/* 1361 */     return this.substationId;
/*      */   }
/*      */ 
/*      */   public void setSubstationId(Long substationId) {
/* 1365 */     this.substationId = substationId;
/*      */   }
/*      */ 
/*      */   public List<TradeOrder> getTradeOrderList() {
/* 1369 */     return this.tradeOrderList;
/*      */   }
/*      */ 
/*      */   public void setTradeOrderList(List<TradeOrder> tradeOrderList) {
/* 1373 */     this.tradeOrderList = tradeOrderList;
/*      */   }
/*      */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.project.ProjectListing
 * JD-Core Version:    0.6.0
 */