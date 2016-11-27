/*     */ package com.hundsun.network.gates.genshan.biz.domain.supplydemand;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.domain.BaseDomain;
/*     */ import com.hundsun.network.gates.genshan.biz.enums.EnumInfoStatus;
/*     */ import com.hundsun.network.gates.genshan.biz.enums.EnumInfoType;
/*     */ import com.hundsun.network.gates.genshan.biz.enums.EnumYesNo;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumDeliveryType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumInvoice;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumMeasureUnit;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumValuationUnit;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class SupplyDemandInfo extends BaseDomain
/*     */ {
/*     */   private static final long serialVersionUID = -3848485716634319653L;
/*     */   private Long id;
/*     */   private String title;
/*     */   private String code;
/*     */   private String breadStandardId;
/*     */   private String infoType;
/*     */   private Long quantity;
/*     */   private String measureUnit;
/*     */   private Long price;
/*     */   private String valuationUnit;
/*     */   private String retail;
/*     */   private String deliveryType;
/*     */   private Date deliveryDate;
/*     */   private String deliveryPlace;
/*     */   private String invoice;
/*     */   private Date endTime;
/*     */   private String province;
/*     */   private String city;
/*     */   private String area;
/*     */   private String address;
/*     */   private String linkMan;
/*     */   private String zipCode;
/*     */   private String phone;
/*     */   private String storeHouse;
/*     */   private String picturePath;
/*     */   private String picturePath1;
/*     */   private String picturePath2;
/*     */   private String picturePath3;
/*     */   private String picturePath4;
/*     */   private String status;
/*     */   private String description;
/*     */   private String operator;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */   private String projectCode;
/*     */   private String effectiveStartDate;
/*     */   private String publisherAccount;
/*     */   private String projectTypeCodeDesc;
/*     */   private String breadStandard;
/*     */   private String priceDesc;
/*     */   private String amount;
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  80 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/*  84 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getTitle() {
/*  88 */     return this.title;
/*     */   }
/*     */ 
/*     */   public void setTitle(String title) {
/*  92 */     this.title = title;
/*     */   }
/*     */ 
/*     */   public String getCode() {
/*  96 */     return this.code;
/*     */   }
/*     */ 
/*     */   public void setCode(String code) {
/* 100 */     this.code = code;
/*     */   }
/*     */ 
/*     */   public String getInfoType() {
/* 104 */     return this.infoType;
/*     */   }
/*     */ 
/*     */   public void setInfoType(String infoType) {
/* 108 */     this.infoType = infoType;
/*     */   }
/*     */ 
/*     */   public Long getQuantity() {
/* 112 */     return this.quantity;
/*     */   }
/*     */ 
/*     */   public void setQuantity(Long quantity) {
/* 116 */     this.quantity = quantity;
/*     */   }
/*     */ 
/*     */   public String getMeasureUnit() {
/* 120 */     return this.measureUnit;
/*     */   }
/*     */ 
/*     */   public void setMeasureUnit(String measureUnit) {
/* 124 */     this.measureUnit = measureUnit;
/*     */   }
/*     */ 
/*     */   public Long getPrice() {
/* 128 */     return this.price;
/*     */   }
/*     */ 
/*     */   public void setPrice(Long price) {
/* 132 */     this.price = price;
/*     */   }
/*     */ 
/*     */   public String getValuationUnit() {
/* 136 */     return this.valuationUnit;
/*     */   }
/*     */ 
/*     */   public void setValuationUnit(String valuationUnit) {
/* 140 */     this.valuationUnit = valuationUnit;
/*     */   }
/*     */ 
/*     */   public String getDeliveryType() {
/* 144 */     return this.deliveryType;
/*     */   }
/*     */ 
/*     */   public void setDeliveryType(String deliveryType) {
/* 148 */     this.deliveryType = deliveryType;
/*     */   }
/*     */ 
/*     */   public Date getDeliveryDate() {
/* 152 */     return this.deliveryDate;
/*     */   }
/*     */ 
/*     */   public void setDeliveryDate(Date deliveryDate) {
/* 156 */     this.deliveryDate = deliveryDate;
/*     */   }
/*     */ 
/*     */   public String getRetail() {
/* 160 */     return this.retail;
/*     */   }
/*     */ 
/*     */   public void setRetail(String retail) {
/* 164 */     this.retail = retail;
/*     */   }
/*     */ 
/*     */   public String getInvoice() {
/* 168 */     return this.invoice;
/*     */   }
/*     */ 
/*     */   public void setInvoice(String invoice) {
/* 172 */     this.invoice = invoice;
/*     */   }
/*     */ 
/*     */   public Date getEndTime() {
/* 176 */     return this.endTime;
/*     */   }
/*     */ 
/*     */   public void setEndTime(Date endTime) {
/* 180 */     this.endTime = endTime;
/*     */   }
/*     */ 
/*     */   public String getProvince() {
/* 184 */     return this.province;
/*     */   }
/*     */ 
/*     */   public void setProvince(String province) {
/* 188 */     this.province = province;
/*     */   }
/*     */ 
/*     */   public String getCity() {
/* 192 */     return this.city;
/*     */   }
/*     */ 
/*     */   public void setCity(String city) {
/* 196 */     this.city = city;
/*     */   }
/*     */ 
/*     */   public String getArea() {
/* 200 */     return this.area;
/*     */   }
/*     */ 
/*     */   public void setArea(String area) {
/* 204 */     this.area = area;
/*     */   }
/*     */ 
/*     */   public String getAddress() {
/* 208 */     return this.address;
/*     */   }
/*     */ 
/*     */   public void setAddress(String address) {
/* 212 */     this.address = address;
/*     */   }
/*     */ 
/*     */   public String getLinkMan() {
/* 216 */     return this.linkMan;
/*     */   }
/*     */ 
/*     */   public void setLinkMan(String linkMan) {
/* 220 */     this.linkMan = linkMan;
/*     */   }
/*     */ 
/*     */   public String getPhone() {
/* 224 */     return this.phone;
/*     */   }
/*     */ 
/*     */   public void setPhone(String phone) {
/* 228 */     this.phone = phone;
/*     */   }
/*     */ 
/*     */   public String getStoreHouse() {
/* 232 */     return this.storeHouse;
/*     */   }
/*     */ 
/*     */   public void setStoreHouse(String storeHouse) {
/* 236 */     this.storeHouse = storeHouse;
/*     */   }
/*     */ 
/*     */   public String getPicturePath() {
/* 240 */     return this.picturePath;
/*     */   }
/*     */ 
/*     */   public void setPicturePath(String picturePath) {
/* 244 */     this.picturePath = picturePath;
/*     */   }
/*     */ 
/*     */   public String getPicturePath1() {
/* 248 */     return this.picturePath1;
/*     */   }
/*     */ 
/*     */   public void setPicturePath1(String picturePath1) {
/* 252 */     this.picturePath1 = picturePath1;
/*     */   }
/*     */ 
/*     */   public String getPicturePath2() {
/* 256 */     return this.picturePath2;
/*     */   }
/*     */ 
/*     */   public void setPicturePath2(String picturePath2) {
/* 260 */     this.picturePath2 = picturePath2;
/*     */   }
/*     */ 
/*     */   public String getPicturePath3() {
/* 264 */     return this.picturePath3;
/*     */   }
/*     */ 
/*     */   public void setPicturePath3(String picturePath3) {
/* 268 */     this.picturePath3 = picturePath3;
/*     */   }
/*     */ 
/*     */   public String getPicturePath4() {
/* 272 */     return this.picturePath4;
/*     */   }
/*     */ 
/*     */   public void setPicturePath4(String picturePath4) {
/* 276 */     this.picturePath4 = picturePath4;
/*     */   }
/*     */ 
/*     */   public String getStatus() {
/* 280 */     return this.status;
/*     */   }
/*     */ 
/*     */   public void setStatus(String status) {
/* 284 */     this.status = status;
/*     */   }
/*     */ 
/*     */   public String getDescription() {
/* 288 */     return this.description;
/*     */   }
/*     */ 
/*     */   public void setDescription(String description) {
/* 292 */     this.description = description;
/*     */   }
/*     */ 
/*     */   public String getDeliveryPlace() {
/* 296 */     return this.deliveryPlace;
/*     */   }
/*     */ 
/*     */   public void setDeliveryPlace(String deliveryPlace) {
/* 300 */     this.deliveryPlace = deliveryPlace;
/*     */   }
/*     */ 
/*     */   public String getZipCode() {
/* 304 */     return this.zipCode;
/*     */   }
/*     */ 
/*     */   public void setZipCode(String zipCode) {
/* 308 */     this.zipCode = zipCode;
/*     */   }
/*     */ 
/*     */   public String getOperator() {
/* 312 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator) {
/* 316 */     this.operator = operator;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate() {
/* 320 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate) {
/* 324 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify() {
/* 328 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify) {
/* 332 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getBreadStandardId() {
/* 336 */     return this.breadStandardId;
/*     */   }
/*     */ 
/*     */   public void setBreadStandardId(String breadStandardId) {
/* 340 */     this.breadStandardId = breadStandardId;
/*     */   }
/*     */ 
/*     */   public String getProjectCode() {
/* 344 */     return this.projectCode;
/*     */   }
/*     */ 
/*     */   public void setProjectCode(String projectCode) {
/* 348 */     this.projectCode = projectCode;
/*     */   }
/*     */ 
/*     */   public String getEffectiveStartDate() {
/* 352 */     return this.effectiveStartDate;
/*     */   }
/*     */ 
/*     */   public void setEffectiveStartDate(String effectiveStartDate) {
/* 356 */     this.effectiveStartDate = effectiveStartDate;
/*     */   }
/*     */ 
/*     */   public String getPublisherAccount() {
/* 360 */     return this.publisherAccount;
/*     */   }
/*     */ 
/*     */   public void setPublisherAccount(String publisherAccount) {
/* 364 */     this.publisherAccount = publisherAccount;
/*     */   }
/*     */ 
/*     */   public String getSupplyStatusDesc()
/*     */   {
/* 376 */     EnumInfoStatus enumInfoStatus = EnumInfoStatus.indexByValue(this.status);
/* 377 */     if (enumInfoStatus == null) {
/* 378 */       return this.status;
/*     */     }
/* 380 */     return enumInfoStatus.getName();
/*     */   }
/*     */ 
/*     */   public String getSupplyTypeDesc()
/*     */   {
/* 392 */     EnumInfoType enumInfoType = EnumInfoType.indexByValue(this.infoType);
/* 393 */     if (enumInfoType == null) {
/* 394 */       return this.infoType;
/*     */     }
/* 396 */     return enumInfoType.getName();
/*     */   }
/*     */ 
/*     */   public String getProjectTypeCodeDesc() {
/* 400 */     return this.projectTypeCodeDesc;
/*     */   }
/*     */ 
/*     */   public void setProjectTypeCodeDesc(String projectTypeCodeDesc) {
/* 404 */     this.projectTypeCodeDesc = projectTypeCodeDesc;
/*     */   }
/*     */ 
/*     */   public String getBreadStandard() {
/* 408 */     return this.breadStandard;
/*     */   }
/*     */ 
/*     */   public void setBreadStandard(String breadStandard) {
/* 412 */     this.breadStandard = breadStandard;
/*     */   }
/*     */ 
/*     */   public String getPriceDesc() {
/* 416 */     return this.priceDesc;
/*     */   }
/*     */ 
/*     */   public void setPriceDesc(String priceDesc) {
/* 420 */     this.priceDesc = priceDesc;
/*     */   }
/*     */   public String getDeliveryTypeDesc() {
/* 423 */     String deliveryStr = "";
/* 424 */     if ((this.deliveryType != null) && (!this.deliveryType.equals(""))) {
/* 425 */       String[] invoices = this.deliveryType.trim().split(",");
/* 426 */       for (String delivery : invoices) {
/* 427 */         EnumDeliveryType deliveryTypeEnum = EnumDeliveryType.indexByValue(delivery);
/* 428 */         if (deliveryTypeEnum == null)
/* 429 */           deliveryStr = deliveryStr + delivery + ",";
/*     */         else {
/* 431 */           deliveryStr = deliveryStr + deliveryTypeEnum.getName() + ",";
/*     */         }
/*     */       }
/* 434 */       if (deliveryStr.lastIndexOf(",") == deliveryStr.length() - 1) {
/* 435 */         deliveryStr = deliveryStr.substring(0, deliveryStr.length() - 1);
/*     */       }
/*     */     }
/* 438 */     return deliveryStr;
/*     */   }
/*     */   public String getMeasureUnitDesc() {
/* 441 */     EnumMeasureUnit measureUnitEnum = EnumMeasureUnit.indexByValue(this.measureUnit);
/* 442 */     if (measureUnitEnum == null) {
/* 443 */       return this.measureUnit;
/*     */     }
/* 445 */     return measureUnitEnum.getName();
/*     */   }
/*     */   public String getValuationUnitDesc() {
/* 448 */     EnumValuationUnit valuationUnitEnum = EnumValuationUnit.indexByValue(this.valuationUnit);
/* 449 */     if (valuationUnitEnum == null) {
/* 450 */       return this.valuationUnit;
/*     */     }
/* 452 */     return valuationUnitEnum.getName();
/*     */   }
/*     */   public String getInvoiceDesc() {
/* 455 */     String invoiceStr = "";
/* 456 */     if ((this.invoice != null) && (!this.invoice.equals(""))) {
/* 457 */       String[] invoices = this.invoice.trim().split(",");
/* 458 */       for (String invoiceType : invoices) {
/* 459 */         EnumInvoice invoiceTypeEnum = EnumInvoice.indexByValue(invoiceType);
/* 460 */         if (invoiceTypeEnum == null)
/* 461 */           invoiceStr = invoiceStr + invoiceType + ",";
/*     */         else {
/* 463 */           invoiceStr = invoiceStr + invoiceTypeEnum.getName() + ",";
/*     */         }
/*     */       }
/* 466 */       if (invoiceStr.lastIndexOf(",") == invoiceStr.length() - 1) {
/* 467 */         invoiceStr = invoiceStr.substring(0, invoiceStr.length() - 1);
/*     */       }
/*     */     }
/* 470 */     return invoiceStr;
/*     */   }
/*     */   public String getRetailDesc() {
/* 473 */     EnumYesNo enumYesNoEnum = EnumYesNo.indexByValue(this.retail);
/* 474 */     if (enumYesNoEnum == null) {
/* 475 */       return this.retail;
/*     */     }
/* 477 */     return enumYesNoEnum.getName();
/*     */   }
/*     */ 
/*     */   public String getAmount() {
/* 481 */     return this.amount;
/*     */   }
/*     */ 
/*     */   public void setAmount(String amount) {
/* 485 */     this.amount = amount;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.supplydemand.SupplyDemandInfo
 * JD-Core Version:    0.6.0
 */