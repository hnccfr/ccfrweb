/*     */ package com.hundsun.network.gates.fengshan.biz.domain.query;
/*     */ 
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.supplydemand.SupplyDemandInfo;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumInfoStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumInfoType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumMeasureUnit;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumValuationUnit;
/*     */ import com.hundsun.network.gates.luosi.common.page.Pagination;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class SupplyDemandVisitorsQuery extends Pagination<SupplyDemandInfo>
/*     */ {
/*     */   private static final long serialVersionUID = -1297743879512614428L;
/*     */   private String projectCode;
/*     */   private String projectTypeCodeDesc;
/*     */   private String title;
/*     */   private String projectTypeCode;
/*     */   private long price;
/*     */   private long quantity;
/*     */   private String infoType;
/*     */   private Date effectiveStartDateFrom;
/*     */   private Date effectiveStartDateTo;
/*     */   private Date effectiveEndDateFrom;
/*     */   private Date effectiveEndDateTo;
/*     */   private String sysTimeFlag;
/*     */   private String status;
/*     */   private String measureUnit;
/*     */   private String valuationUnit;
/*     */ 
/*     */   public String getProjectCode()
/*     */   {
/*  88 */     return this.projectCode;
/*     */   }
/*     */ 
/*     */   public void setProjectCode(String projectCode) {
/*  92 */     this.projectCode = projectCode;
/*     */   }
/*     */ 
/*     */   public String getInfoType() {
/*  96 */     return this.infoType;
/*     */   }
/*     */ 
/*     */   public void setInfoType(String infoType) {
/* 100 */     this.infoType = infoType;
/*     */   }
/*     */ 
/*     */   public String getTitle() {
/* 104 */     return this.title;
/*     */   }
/*     */ 
/*     */   public void setTitle(String title) {
/* 108 */     this.title = title;
/*     */   }
/*     */ 
/*     */   public String getStatus() {
/* 112 */     return this.status;
/*     */   }
/*     */ 
/*     */   public void setStatus(String status) {
/* 116 */     this.status = status;
/*     */   }
/*     */ 
/*     */   public String getSysTimeFlag() {
/* 120 */     return this.sysTimeFlag;
/*     */   }
/*     */ 
/*     */   public void setSysTimeFlag(String sysTimeFlag) {
/* 124 */     this.sysTimeFlag = sysTimeFlag;
/*     */   }
/*     */ 
/*     */   public Date getEffectiveStartDateFrom() {
/* 128 */     return this.effectiveStartDateFrom;
/*     */   }
/*     */ 
/*     */   public void setEffectiveStartDateFrom(Date effectiveStartDateFrom) {
/* 132 */     this.effectiveStartDateFrom = effectiveStartDateFrom;
/*     */   }
/*     */ 
/*     */   public Date getEffectiveStartDateTo() {
/* 136 */     return this.effectiveStartDateTo;
/*     */   }
/*     */ 
/*     */   public void setEffectiveStartDateTo(Date effectiveStartDateTo) {
/* 140 */     this.effectiveStartDateTo = effectiveStartDateTo;
/*     */   }
/*     */ 
/*     */   public Date getEffectiveEndDateFrom() {
/* 144 */     return this.effectiveEndDateFrom;
/*     */   }
/*     */ 
/*     */   public void setEffectiveEndDateFrom(Date effectiveEndDateFrom) {
/* 148 */     this.effectiveEndDateFrom = effectiveEndDateFrom;
/*     */   }
/*     */ 
/*     */   public Date getEffectiveEndDateTo() {
/* 152 */     return this.effectiveEndDateTo;
/*     */   }
/*     */ 
/*     */   public void setEffectiveEndDateTo(Date effectiveEndDateTo) {
/* 156 */     this.effectiveEndDateTo = effectiveEndDateTo;
/*     */   }
/*     */ 
/*     */   public String getProjectTypeCode() {
/* 160 */     return this.projectTypeCode;
/*     */   }
/*     */ 
/*     */   public void setProjectTypeCode(String projectTypeCode) {
/* 164 */     this.projectTypeCode = projectTypeCode;
/*     */   }
/*     */ 
/*     */   public long getPrice() {
/* 168 */     return this.price;
/*     */   }
/*     */ 
/*     */   public void setPrice(long price) {
/* 172 */     this.price = price;
/*     */   }
/*     */ 
/*     */   public long getQuantity() {
/* 176 */     return this.quantity;
/*     */   }
/*     */ 
/*     */   public void setQuantity(long quantity) {
/* 180 */     this.quantity = quantity;
/*     */   }
/*     */   public String getStatusDesc() {
/* 183 */     EnumInfoStatus statusEnum = EnumInfoStatus.indexByValue(this.status);
/* 184 */     if (null == statusEnum) {
/* 185 */       return this.status;
/*     */     }
/* 187 */     return statusEnum.getName();
/*     */   }
/*     */   public String getInfoTypeDesc() {
/* 190 */     EnumInfoType infoEnum = EnumInfoType.indexByValue(this.infoType);
/* 191 */     if (null == infoEnum) {
/* 192 */       return this.infoType;
/*     */     }
/* 194 */     return infoEnum.getName();
/*     */   }
/*     */ 
/*     */   public String getProjectTypeCodeDesc() {
/* 198 */     return this.projectTypeCodeDesc;
/*     */   }
/*     */ 
/*     */   public void setProjectTypeCodeDesc(String projectTypeCodeDesc) {
/* 202 */     this.projectTypeCodeDesc = projectTypeCodeDesc;
/*     */   }
/*     */ 
/*     */   public String getMeasureUnit() {
/* 206 */     return this.measureUnit;
/*     */   }
/*     */ 
/*     */   public void setMeasureUnit(String measureUnit) {
/* 210 */     this.measureUnit = measureUnit;
/*     */   }
/*     */ 
/*     */   public String getValuationUnit() {
/* 214 */     return this.valuationUnit;
/*     */   }
/*     */ 
/*     */   public void setValuationUnit(String valuationUnit) {
/* 218 */     this.valuationUnit = valuationUnit;
/*     */   }
/*     */ 
/*     */   public String getMeasureUnitDesc() {
/* 222 */     EnumMeasureUnit measureUnitEnum = EnumMeasureUnit.indexByValue(this.measureUnit);
/* 223 */     if (null == measureUnitEnum) {
/* 224 */       return this.measureUnit;
/*     */     }
/* 226 */     return measureUnitEnum.getName();
/*     */   }
/*     */   public String getValuationUnitDesc() {
/* 229 */     EnumValuationUnit valuationUnitEnum = EnumValuationUnit.indexByValue(this.valuationUnit);
/* 230 */     if (null == valuationUnitEnum) {
/* 231 */       return this.valuationUnit;
/*     */     }
/* 233 */     return valuationUnitEnum.getName();
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.domain.query.SupplyDemandVisitorsQuery
 * JD-Core Version:    0.6.0
 */