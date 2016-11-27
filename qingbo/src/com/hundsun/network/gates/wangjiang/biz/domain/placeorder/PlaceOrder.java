/*     */ package com.hundsun.network.gates.wangjiang.biz.domain.placeorder;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumDeliveryType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumMeasureUnit;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumPaymentType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradingType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumValuationUnit;
/*     */ import com.hundsun.network.gates.wangjiang.biz.domain.BaseDomain;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class PlaceOrder extends BaseDomain
/*     */ {
/*     */   private static final long serialVersionUID = -5969487052890908314L;
/*     */   private String projectName;
/*     */   private String projectCode;
/*     */   private Long userId;
/*     */   private String userAccount;
/*     */   private String measureUnit;
/*     */   private Long quantity;
/*     */   private String valuationUnit;
/*     */   private Long listingPrice;
/*     */   private String tradingType;
/*     */   private Date deliveryDate;
/*     */   private String deliveryPlace;
/*     */   private String deliveryType;
/*     */   private String paymentType;
/*     */   private String invoice;
/*     */ 
/*     */   public String getProjectName()
/*     */   {
/* 100 */     return this.projectName;
/*     */   }
/*     */ 
/*     */   public void setProjectName(String projectName) {
/* 104 */     this.projectName = projectName;
/*     */   }
/*     */ 
/*     */   public String getProjectCode() {
/* 108 */     return this.projectCode;
/*     */   }
/*     */ 
/*     */   public void setProjectCode(String projectCode) {
/* 112 */     this.projectCode = projectCode;
/*     */   }
/*     */ 
/*     */   public Long getUserId()
/*     */   {
/* 119 */     return this.userId;
/*     */   }
/*     */ 
/*     */   public void setUserId(Long userId)
/*     */   {
/* 126 */     this.userId = userId;
/*     */   }
/*     */ 
/*     */   public String getUserAccount()
/*     */   {
/* 133 */     return this.userAccount;
/*     */   }
/*     */ 
/*     */   public void setUserAccount(String userAccount)
/*     */   {
/* 140 */     this.userAccount = userAccount;
/*     */   }
/*     */ 
/*     */   public String getMeasureUnit()
/*     */   {
/* 147 */     return this.measureUnit;
/*     */   }
/*     */ 
/*     */   public void setMeasureUnit(String measureUnit)
/*     */   {
/* 154 */     this.measureUnit = measureUnit;
/*     */   }
/*     */ 
/*     */   public Long getQuantity()
/*     */   {
/* 161 */     return this.quantity;
/*     */   }
/*     */ 
/*     */   public void setQuantity(Long quantity)
/*     */   {
/* 168 */     this.quantity = quantity;
/*     */   }
/*     */ 
/*     */   public String getValuationUnit()
/*     */   {
/* 175 */     return this.valuationUnit;
/*     */   }
/*     */ 
/*     */   public void setValuationUnit(String valuationUnit)
/*     */   {
/* 182 */     this.valuationUnit = valuationUnit;
/*     */   }
/*     */ 
/*     */   public Long getListingPrice()
/*     */   {
/* 189 */     return this.listingPrice;
/*     */   }
/*     */ 
/*     */   public void setListingPrice(Long listingPrice)
/*     */   {
/* 196 */     this.listingPrice = listingPrice;
/*     */   }
/*     */ 
/*     */   public String getTradingType()
/*     */   {
/* 203 */     return this.tradingType;
/*     */   }
/*     */ 
/*     */   public void setTradingType(String tradingType)
/*     */   {
/* 210 */     this.tradingType = tradingType;
/*     */   }
/*     */ 
/*     */   public Date getDeliveryDate()
/*     */   {
/* 217 */     return this.deliveryDate;
/*     */   }
/*     */ 
/*     */   public void setDeliveryDate(Date deliveryDate)
/*     */   {
/* 224 */     this.deliveryDate = deliveryDate;
/*     */   }
/*     */ 
/*     */   public String getDeliveryPlace()
/*     */   {
/* 231 */     return this.deliveryPlace;
/*     */   }
/*     */ 
/*     */   public void setDeliveryPlace(String deliveryPlace)
/*     */   {
/* 238 */     this.deliveryPlace = deliveryPlace;
/*     */   }
/*     */ 
/*     */   public String getDeliveryType()
/*     */   {
/* 245 */     return this.deliveryType;
/*     */   }
/*     */ 
/*     */   public void setDeliveryType(String deliveryType)
/*     */   {
/* 252 */     this.deliveryType = deliveryType;
/*     */   }
/*     */ 
/*     */   public String getPaymentType()
/*     */   {
/* 259 */     return this.paymentType;
/*     */   }
/*     */ 
/*     */   public void setPaymentType(String paymentType)
/*     */   {
/* 266 */     this.paymentType = paymentType;
/*     */   }
/*     */ 
/*     */   public String getInvoice()
/*     */   {
/* 273 */     return this.invoice;
/*     */   }
/*     */ 
/*     */   public void setInvoice(String invoice)
/*     */   {
/* 280 */     this.invoice = invoice;
/*     */   }
/*     */ 
/*     */   public String getTradingTypeDesc() {
/* 284 */     EnumTradingType tradingTypeEnum = EnumTradingType.indexByValue(this.tradingType);
/* 285 */     if (null == tradingTypeEnum) {
/* 286 */       return this.tradingType;
/*     */     }
/* 288 */     return tradingTypeEnum.getName();
/*     */   }
/*     */ 
/*     */   public String getPaymentTypeDesc() {
/* 292 */     EnumPaymentType paymentTypeEnum = EnumPaymentType.indexByValue(this.paymentType);
/* 293 */     if (null == paymentTypeEnum) {
/* 294 */       return this.paymentType;
/*     */     }
/* 296 */     return paymentTypeEnum.getName();
/*     */   }
/*     */ 
/*     */   public String getMeasureUnitDesc() {
/* 300 */     EnumMeasureUnit measureUnitEnum = EnumMeasureUnit.indexByValue(this.measureUnit);
/* 301 */     if (null == measureUnitEnum) {
/* 302 */       return this.measureUnit;
/*     */     }
/* 304 */     return measureUnitEnum.getName();
/*     */   }
/*     */ 
/*     */   public String getDeliveryTypeDesc() {
/* 308 */     EnumDeliveryType deliveryTypeEnum = EnumDeliveryType.indexByValue(this.deliveryType);
/* 309 */     if (null == deliveryTypeEnum) {
/* 310 */       return this.deliveryType;
/*     */     }
/* 312 */     return deliveryTypeEnum.getName();
/*     */   }
/*     */ 
/*     */   public String getValuationUnitDesc() {
/* 316 */     EnumValuationUnit valuationUnitEnum = EnumValuationUnit.indexByValue(this.valuationUnit);
/* 317 */     if (null == valuationUnitEnum) {
/* 318 */       return this.valuationUnit;
/*     */     }
/* 320 */     return valuationUnitEnum.getName();
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wangjiang.biz.domain.placeorder.PlaceOrder
 * JD-Core Version:    0.6.0
 */