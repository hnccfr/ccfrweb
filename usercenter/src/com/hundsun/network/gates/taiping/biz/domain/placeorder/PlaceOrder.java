/*     */ package com.hundsun.network.gates.taiping.biz.domain.placeorder;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumDeliveryType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumMeasureUnit;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumPaymentType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradingType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumValuationUnit;
/*     */ import com.hundsun.network.gates.taiping.biz.domain.BaseDomain;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
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
/* 101 */     return this.projectName;
/*     */   }
/*     */ 
/*     */   public void setProjectName(String projectName) {
/* 105 */     this.projectName = projectName;
/*     */   }
/*     */ 
/*     */   public String getProjectCode() {
/* 109 */     return this.projectCode;
/*     */   }
/*     */ 
/*     */   public void setProjectCode(String projectCode) {
/* 113 */     this.projectCode = projectCode;
/*     */   }
/*     */ 
/*     */   public Long getUserId()
/*     */   {
/* 120 */     return this.userId;
/*     */   }
/*     */ 
/*     */   public void setUserId(Long userId)
/*     */   {
/* 127 */     this.userId = userId;
/*     */   }
/*     */ 
/*     */   public String getUserAccount()
/*     */   {
/* 134 */     return this.userAccount;
/*     */   }
/*     */ 
/*     */   public void setUserAccount(String userAccount)
/*     */   {
/* 141 */     this.userAccount = userAccount;
/*     */   }
/*     */ 
/*     */   public String getMeasureUnit()
/*     */   {
/* 148 */     if (StringUtil.isEmpty(this.measureUnit))
/* 149 */       this.measureUnit = EnumMeasureUnit.QUANTITY_G.getName();
/* 150 */     return this.measureUnit;
/*     */   }
/*     */ 
/*     */   public void setMeasureUnit(String measureUnit)
/*     */   {
/* 157 */     this.measureUnit = measureUnit;
/*     */   }
/*     */ 
/*     */   public Long getQuantity()
/*     */   {
/* 164 */     return this.quantity;
/*     */   }
/*     */ 
/*     */   public void setQuantity(Long quantity)
/*     */   {
/* 171 */     this.quantity = quantity;
/*     */   }
/*     */ 
/*     */   public String getValuationUnit()
/*     */   {
/* 178 */     if (StringUtil.isEmpty(this.valuationUnit))
/* 179 */       this.valuationUnit = EnumValuationUnit.YUAN.getName();
/* 180 */     return this.valuationUnit;
/*     */   }
/*     */ 
/*     */   public void setValuationUnit(String valuationUnit)
/*     */   {
/* 187 */     this.valuationUnit = valuationUnit;
/*     */   }
/*     */ 
/*     */   public Long getListingPrice()
/*     */   {
/* 194 */     return this.listingPrice;
/*     */   }
/*     */ 
/*     */   public void setListingPrice(Long listingPrice)
/*     */   {
/* 201 */     if (this.valuationUnit.equals(EnumValuationUnit.indexByValue(this.valuationUnit)))
/* 202 */       this.listingPrice = listingPrice;
/*     */   }
/*     */ 
/*     */   public String getTradingType()
/*     */   {
/* 209 */     return this.tradingType;
/*     */   }
/*     */ 
/*     */   public void setTradingType(String tradingType)
/*     */   {
/* 216 */     this.tradingType = tradingType;
/*     */   }
/*     */ 
/*     */   public Date getDeliveryDate()
/*     */   {
/* 223 */     return this.deliveryDate;
/*     */   }
/*     */ 
/*     */   public void setDeliveryDate(Date deliveryDate)
/*     */   {
/* 230 */     this.deliveryDate = deliveryDate;
/*     */   }
/*     */ 
/*     */   public String getDeliveryPlace()
/*     */   {
/* 237 */     return this.deliveryPlace;
/*     */   }
/*     */ 
/*     */   public void setDeliveryPlace(String deliveryPlace)
/*     */   {
/* 244 */     this.deliveryPlace = deliveryPlace;
/*     */   }
/*     */ 
/*     */   public String getDeliveryType()
/*     */   {
/* 251 */     return this.deliveryType;
/*     */   }
/*     */ 
/*     */   public void setDeliveryType(String deliveryType)
/*     */   {
/* 258 */     this.deliveryType = deliveryType;
/*     */   }
/*     */ 
/*     */   public String getPaymentType()
/*     */   {
/* 265 */     return this.paymentType;
/*     */   }
/*     */ 
/*     */   public void setPaymentType(String paymentType)
/*     */   {
/* 272 */     this.paymentType = paymentType;
/*     */   }
/*     */ 
/*     */   public String getInvoice()
/*     */   {
/* 279 */     return this.invoice;
/*     */   }
/*     */ 
/*     */   public void setInvoice(String invoice)
/*     */   {
/* 286 */     this.invoice = invoice;
/*     */   }
/*     */ 
/*     */   public String getTradingTypeDesc() {
/* 290 */     EnumTradingType tradingTypeEnum = EnumTradingType.indexByValue(this.tradingType);
/* 291 */     if (null == tradingTypeEnum) {
/* 292 */       return this.tradingType;
/*     */     }
/* 294 */     return tradingTypeEnum.getName();
/*     */   }
/*     */ 
/*     */   public String getPaymentTypeDesc() {
/* 298 */     EnumPaymentType paymentTypeEnum = EnumPaymentType.indexByValue(this.paymentType);
/* 299 */     if (null == paymentTypeEnum) {
/* 300 */       return this.paymentType;
/*     */     }
/* 302 */     return paymentTypeEnum.getName();
/*     */   }
/*     */ 
/*     */   public String getMeasureUnitDesc() {
/* 306 */     EnumMeasureUnit measureUnitEnum = EnumMeasureUnit.indexByValue(this.measureUnit);
/* 307 */     if (null == measureUnitEnum) {
/* 308 */       return this.measureUnit;
/*     */     }
/* 310 */     return measureUnitEnum.getName();
/*     */   }
/*     */ 
/*     */   public String getDeliveryTypeDesc() {
/* 314 */     EnumDeliveryType deliveryTypeEnum = EnumDeliveryType.indexByValue(this.deliveryType);
/* 315 */     if (null == deliveryTypeEnum) {
/* 316 */       return this.deliveryType;
/*     */     }
/* 318 */     return deliveryTypeEnum.getName();
/*     */   }
/*     */ 
/*     */   public String getValuationUnitDesc() {
/* 322 */     EnumValuationUnit valuationUnitEnum = EnumValuationUnit.indexByValue(this.valuationUnit);
/* 323 */     if (null == valuationUnitEnum) {
/* 324 */       return this.valuationUnit;
/*     */     }
/* 326 */     return valuationUnitEnum.getName();
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.taiping.biz.domain.placeorder.PlaceOrder
 * JD-Core Version:    0.6.0
 */