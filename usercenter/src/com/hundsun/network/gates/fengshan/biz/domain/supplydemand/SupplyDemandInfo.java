/*     */ package com.hundsun.network.gates.fengshan.biz.domain.supplydemand;
/*     */ 
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.BaseDomain;
/*     */ import com.hundsun.network.gates.fengshan.biz.enums.EnumDeliveryType;
/*     */ import com.hundsun.network.gates.fengshan.biz.enums.EnumYesNo;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumInfoStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumInfoType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumInvoice;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumMeasureUnit;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumValuationUnit;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class SupplyDemandInfo extends BaseDomain
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private long id;
/*     */   private String title;
/*     */   private String projectTypeCode;
/*     */   private String projectTypeCodeDesc;
/*     */   private String breadStandardId;
/*     */   private String breadStandard;
/*     */   private String infoType;
/*     */   private Long quantity;
/*     */   private String measureUnit;
/*     */   private Long price;
/*     */   private String priceDesc;
/*     */   private String amount;
/*     */   private String valuationUnit;
/*     */   private String retail;
/*     */   private String deliveryType;
/*     */   private Date deliveryDate;
/*     */   private String deliveryPlace;
/*     */   private String invoice;
/*     */   private Date effectiveEndDate;
/*     */   private String province;
/*     */   private String city;
/*     */   private String area;
/*     */   private String address;
/*     */   private String linkMan;
/*     */   private String zipCode;
/*     */   private String phone;
/*     */   private String storehouse;
/*     */   private String picturePath;
/*     */   private String picturePath1;
/*     */   private String picturePath2;
/*     */   private String picturePath3;
/*     */   private String picturePath4;
/*  70 */   private String tempPath = "tempPath";
/*  71 */   private String tempPath1 = "tempPath1";
/*  72 */   private String tempPath2 = "tempPath2";
/*  73 */   private String tempPath3 = "tempPath3";
/*  74 */   private String tempPath4 = "tempPath4";
/*     */   private String status;
/*     */   private String remark;
/*     */   private String operator;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */   private Date effectiveStartDate;
/*     */   private String projectCode;
/*     */   private String publisherAccount;
/*     */ 
/*     */   public long getId()
/*     */   {
/*  84 */     return this.id;
/*     */   }
/*     */   public void setId(long id) {
/*  87 */     this.id = id;
/*     */   }
/*     */   public String getTitle() {
/*  90 */     return this.title;
/*     */   }
/*     */   public void setTitle(String title) {
/*  93 */     this.title = title;
/*     */   }
/*     */   public String getProjectTypeCode() {
/*  96 */     return this.projectTypeCode;
/*     */   }
/*     */   public void setProjectTypeCode(String projectTypeCode) {
/*  99 */     this.projectTypeCode = projectTypeCode;
/*     */   }
/*     */   public String getBreadStandardId() {
/* 102 */     return this.breadStandardId;
/*     */   }
/*     */   public void setBreadStandardId(String breadStandardId) {
/* 105 */     this.breadStandardId = breadStandardId;
/*     */   }
/*     */   public String getInfoType() {
/* 108 */     return this.infoType;
/*     */   }
/*     */   public void setInfoType(String infoType) {
/* 111 */     this.infoType = infoType;
/*     */   }
/*     */   public Long getQuantity() {
/* 114 */     return this.quantity;
/*     */   }
/*     */   public void setQuantity(Long quantity) {
/* 117 */     this.quantity = quantity;
/*     */   }
/*     */   public String getMeasureUnit() {
/* 120 */     return this.measureUnit;
/*     */   }
/*     */   public void setMeasureUnit(String measureUnit) {
/* 123 */     this.measureUnit = measureUnit;
/*     */   }
/*     */   public Long getPrice() {
/* 126 */     return this.price;
/*     */   }
/*     */   public void setPrice(Long price) {
/* 129 */     this.price = price;
/*     */   }
/*     */   public String getValuationUnit() {
/* 132 */     return this.valuationUnit;
/*     */   }
/*     */   public void setValuationUnit(String valuationUnit) {
/* 135 */     this.valuationUnit = valuationUnit;
/*     */   }
/*     */   public String getDeliveryType() {
/* 138 */     return this.deliveryType;
/*     */   }
/*     */   public void setDeliveryType(String deliveryType) {
/* 141 */     this.deliveryType = deliveryType;
/*     */   }
/*     */   public Date getDeliveryDate() {
/* 144 */     return this.deliveryDate;
/*     */   }
/*     */   public void setDeliveryDate(Date deliveryDate) {
/* 147 */     this.deliveryDate = deliveryDate;
/*     */   }
/*     */   public String getDeliveryPlace() {
/* 150 */     return this.deliveryPlace;
/*     */   }
/*     */   public void setDeliveryPlace(String deliveryPlace) {
/* 153 */     this.deliveryPlace = deliveryPlace;
/*     */   }
/*     */   public Date getEffectiveEndDate() {
/* 156 */     return this.effectiveEndDate;
/*     */   }
/*     */   public void setEffectiveEndDate(Date effectiveEndDate) {
/* 159 */     this.effectiveEndDate = effectiveEndDate;
/*     */   }
/*     */   public String getCity() {
/* 162 */     return this.city;
/*     */   }
/*     */   public void setCity(String city) {
/* 165 */     this.city = city;
/*     */   }
/*     */   public String getArea() {
/* 168 */     return this.area;
/*     */   }
/*     */   public void setArea(String area) {
/* 171 */     this.area = area;
/*     */   }
/*     */   public String getAddress() {
/* 174 */     return this.address;
/*     */   }
/*     */   public void setAddress(String address) {
/* 177 */     this.address = address;
/*     */   }
/*     */   public String getLinkMan() {
/* 180 */     return this.linkMan;
/*     */   }
/*     */   public void setLinkMan(String linkMan) {
/* 183 */     this.linkMan = linkMan;
/*     */   }
/*     */   public String getZipCode() {
/* 186 */     return this.zipCode;
/*     */   }
/*     */   public void setZipCode(String zipCode) {
/* 189 */     this.zipCode = zipCode;
/*     */   }
/*     */   public String getPhone() {
/* 192 */     return this.phone;
/*     */   }
/*     */   public void setPhone(String phone) {
/* 195 */     this.phone = phone;
/*     */   }
/*     */   public String getStorehouse() {
/* 198 */     return this.storehouse;
/*     */   }
/*     */   public void setStorehouse(String storehouse) {
/* 201 */     this.storehouse = storehouse;
/*     */   }
/*     */   public String getPicturePath() {
/* 204 */     return this.picturePath;
/*     */   }
/*     */   public void setPicturePath(String picturePath) {
/* 207 */     this.picturePath = picturePath;
/*     */   }
/*     */   public String getPicturePath1() {
/* 210 */     return this.picturePath1;
/*     */   }
/*     */   public void setPicturePath1(String picturePath1) {
/* 213 */     this.picturePath1 = picturePath1;
/*     */   }
/*     */   public String getPicturePath2() {
/* 216 */     return this.picturePath2;
/*     */   }
/*     */   public void setPicturePath2(String picturePath2) {
/* 219 */     this.picturePath2 = picturePath2;
/*     */   }
/*     */   public String getPicturePath3() {
/* 222 */     return this.picturePath3;
/*     */   }
/*     */   public void setPicturePath3(String picturePath3) {
/* 225 */     this.picturePath3 = picturePath3;
/*     */   }
/*     */   public String getPicturePath4() {
/* 228 */     return this.picturePath4;
/*     */   }
/*     */   public void setPicturePath4(String picturePath4) {
/* 231 */     this.picturePath4 = picturePath4;
/*     */   }
/*     */   public String getTempPath() {
/* 234 */     return this.tempPath;
/*     */   }
/*     */   public void setTempPath(String tempPath) {
/* 237 */     this.tempPath = tempPath;
/*     */   }
/*     */   public String getTempPath1() {
/* 240 */     return this.tempPath1;
/*     */   }
/*     */   public void setTempPath1(String tempPath1) {
/* 243 */     this.tempPath1 = tempPath1;
/*     */   }
/*     */   public String getTempPath2() {
/* 246 */     return this.tempPath2;
/*     */   }
/*     */   public void setTempPath2(String tempPath2) {
/* 249 */     this.tempPath2 = tempPath2;
/*     */   }
/*     */   public String getTempPath3() {
/* 252 */     return this.tempPath3;
/*     */   }
/*     */   public void setTempPath3(String tempPath3) {
/* 255 */     this.tempPath3 = tempPath3;
/*     */   }
/*     */   public String getTempPath4() {
/* 258 */     return this.tempPath4;
/*     */   }
/*     */   public void setTempPath4(String tempPath4) {
/* 261 */     this.tempPath4 = tempPath4;
/*     */   }
/*     */   public String getStatus() {
/* 264 */     return this.status;
/*     */   }
/*     */   public void setStatus(String status) {
/* 267 */     this.status = status;
/*     */   }
/*     */   public String getRemark() {
/* 270 */     return this.remark;
/*     */   }
/*     */   public void setRemark(String remark) {
/* 273 */     this.remark = remark;
/*     */   }
/*     */   public String getOperator() {
/* 276 */     return this.operator;
/*     */   }
/*     */   public void setOperator(String operator) {
/* 279 */     this.operator = operator;
/*     */   }
/*     */   public Date getGmtCreate() {
/* 282 */     return this.gmtCreate;
/*     */   }
/*     */   public void setGmtCreate(Date gmtCreate) {
/* 285 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */   public Date getGmtModify() {
/* 288 */     return this.gmtModify;
/*     */   }
/*     */   public void setGmtModify(Date gmtModify) {
/* 291 */     this.gmtModify = gmtModify;
/*     */   }
/*     */   public Date getEffectiveStartDate() {
/* 294 */     return this.effectiveStartDate;
/*     */   }
/*     */   public void setEffectiveStartDate(Date effectiveStartDate) {
/* 297 */     this.effectiveStartDate = effectiveStartDate;
/*     */   }
/*     */   public String getProjectCode() {
/* 300 */     return this.projectCode;
/*     */   }
/*     */   public void setProjectCode(String projectCode) {
/* 303 */     this.projectCode = projectCode;
/*     */   }
/*     */   public String getPublisherAccount() {
/* 306 */     return this.publisherAccount;
/*     */   }
/*     */   public void setPublisherAccount(String publisherAccount) {
/* 309 */     this.publisherAccount = publisherAccount;
/*     */   }
/*     */   public String getProvince() {
/* 312 */     return this.province;
/*     */   }
/*     */   public void setProvince(String province) {
/* 315 */     this.province = province;
/*     */   }
/*     */   public String getRetail() {
/* 318 */     return this.retail;
/*     */   }
/*     */   public void setRetail(String retail) {
/* 321 */     this.retail = retail;
/*     */   }
/*     */   public String getInvoice() {
/* 324 */     return this.invoice;
/*     */   }
/*     */   public void setInvoice(String invoice) {
/* 327 */     this.invoice = invoice;
/*     */   }
/*     */   public String getProjectTypeCodeDesc() {
/* 330 */     return this.projectTypeCodeDesc;
/*     */   }
/*     */   public void setProjectTypeCodeDesc(String projectTypeCodeDesc) {
/* 333 */     this.projectTypeCodeDesc = projectTypeCodeDesc;
/*     */   }
/*     */   public String getBreadStandard() {
/* 336 */     return this.breadStandard;
/*     */   }
/*     */   public void setBreadStandard(String breadStandard) {
/* 339 */     this.breadStandard = breadStandard;
/*     */   }
/*     */   public String getPriceDesc() {
/* 342 */     return this.priceDesc;
/*     */   }
/*     */   public void setPriceDesc(String priceDesc) {
/* 345 */     this.priceDesc = priceDesc;
/*     */   }
/*     */   public String getStatusDesc() {
/* 348 */     EnumInfoStatus statusEnum = EnumInfoStatus.indexByValue(this.status);
/* 349 */     if (statusEnum == null) {
/* 350 */       return this.status;
/*     */     }
/* 352 */     return statusEnum.getName();
/*     */   }
/*     */   public String getInfoTypeDesc() {
/* 355 */     EnumInfoType infoEnum = EnumInfoType.indexByValue(this.infoType);
/* 356 */     if (infoEnum == null) {
/* 357 */       return this.infoType;
/*     */     }
/* 359 */     return infoEnum.getName();
/*     */   }
/*     */   public String getMeasureUnitDesc() {
/* 362 */     EnumMeasureUnit measureUnitEnum = EnumMeasureUnit.indexByValue(this.measureUnit);
/* 363 */     if (measureUnitEnum == null) {
/* 364 */       return this.measureUnit;
/*     */     }
/* 366 */     return measureUnitEnum.getName();
/*     */   }
/*     */   public String getValuationUnitDesc() {
/* 369 */     EnumValuationUnit valuationUnitEnum = EnumValuationUnit.indexByValue(this.valuationUnit);
/* 370 */     if (valuationUnitEnum == null) {
/* 371 */       return this.valuationUnit;
/*     */     }
/* 373 */     return valuationUnitEnum.getName();
/*     */   }
/*     */   public String getInvoiceDesc() {
/* 376 */     String invoiceStr = "";
/* 377 */     if ((this.invoice != null) && (!this.invoice.equals(""))) {
/* 378 */       String[] invoices = this.invoice.trim().split(",");
/* 379 */       for (String invoiceType : invoices) {
/* 380 */         EnumInvoice invoiceTypeEnum = EnumInvoice.indexByValue(invoiceType);
/* 381 */         if (invoiceTypeEnum == null)
/* 382 */           invoiceStr = invoiceStr + invoiceType + ",";
/*     */         else {
/* 384 */           invoiceStr = invoiceStr + invoiceTypeEnum.getName() + ",";
/*     */         }
/*     */       }
/* 387 */       if (invoiceStr.lastIndexOf(",") == invoiceStr.length() - 1) {
/* 388 */         invoiceStr = invoiceStr.substring(0, invoiceStr.length() - 1);
/*     */       }
/*     */     }
/* 391 */     return invoiceStr;
/*     */   }
/*     */   public String getRetailDesc() {
/* 394 */     EnumYesNo enumYesNoEnum = EnumYesNo.indexByValue(this.retail);
/* 395 */     if (enumYesNoEnum == null) {
/* 396 */       return this.retail;
/*     */     }
/* 398 */     return enumYesNoEnum.getName();
/*     */   }
/*     */ 
/*     */   public String getDeliveryTypeDesc() {
/* 402 */     String deliveryStr = "";
/* 403 */     if ((this.deliveryType != null) && (!this.deliveryType.equals(""))) {
/* 404 */       String[] deliverys = this.deliveryType.trim().split(",");
/* 405 */       for (String delivery : deliverys) {
/* 406 */         EnumDeliveryType deliveryTypeEnum = EnumDeliveryType.indexByValue(delivery);
/* 407 */         if (deliveryTypeEnum == null)
/* 408 */           deliveryStr = deliveryStr + delivery + ",";
/*     */         else {
/* 410 */           deliveryStr = deliveryStr + deliveryTypeEnum.getName() + ",";
/*     */         }
/*     */       }
/* 413 */       if (deliveryStr.lastIndexOf(",") == deliveryStr.length() - 1) {
/* 414 */         deliveryStr = deliveryStr.substring(0, deliveryStr.length() - 1);
/*     */       }
/*     */     }
/* 417 */     return deliveryStr;
/*     */   }
/*     */   public String getAmount() {
/* 420 */     return this.amount;
/*     */   }
/*     */   public void setAmount(String amount) {
/* 423 */     this.amount = amount;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.domain.supplydemand.SupplyDemandInfo
 * JD-Core Version:    0.6.0
 */