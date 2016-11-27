/*     */ package com.hundsun.network.gates.fengshan.biz.domain.query;
/*     */ 
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.supplydemand.SupplyDemandInfo;
/*     */ import com.hundsun.network.gates.luosi.common.page.Pagination;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class SupplyDemandInfoQuery extends Pagination<SupplyDemandInfo>
/*     */ {
/*     */   private static final long serialVersionUID = -6343772754962024860L;
/*     */   private Long id;
/*     */   private String title;
/*     */   private String infoType;
/*     */   private String status;
/*     */   private Date effectiveStartDate;
/*     */   private Date effectiveEndDate;
/*     */   private Long price;
/*     */   private String storehouse;
/*     */   private String publisherAccount;
/*     */   private String projectCode;
/*     */   private String projectTypeCode;
/*     */   private String projectTypeName;
/*     */   private Date effectiveStartDateFrom;
/*     */   private Date effectiveStartDateTo;
/*     */   private Date effectiveEndDateFrom;
/*     */   private Date effectiveEndDateTo;
/*     */   private String sysTimeFlag;
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  40 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/*  44 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getTitle() {
/*  48 */     return this.title;
/*     */   }
/*     */ 
/*     */   public void setTitle(String title) {
/*  52 */     this.title = title;
/*     */   }
/*     */ 
/*     */   public String getStatus() {
/*  56 */     return this.status;
/*     */   }
/*     */ 
/*     */   public void setStatus(String status) {
/*  60 */     this.status = status;
/*     */   }
/*     */ 
/*     */   public Date getEffectiveStartDate() {
/*  64 */     return this.effectiveStartDate;
/*     */   }
/*     */ 
/*     */   public void setEffectiveStartDate(Date effectiveStartDate) {
/*  68 */     this.effectiveStartDate = effectiveStartDate;
/*     */   }
/*     */ 
/*     */   public Date getEffectiveEndDate() {
/*  72 */     return this.effectiveEndDate;
/*     */   }
/*     */ 
/*     */   public void setEffectiveEndDate(Date effectiveEndDate) {
/*  76 */     this.effectiveEndDate = effectiveEndDate;
/*     */   }
/*     */ 
/*     */   public Long getPrice() {
/*  80 */     return this.price;
/*     */   }
/*     */ 
/*     */   public void setPrice(Long price) {
/*  84 */     this.price = price;
/*     */   }
/*     */ 
/*     */   public String getStorehouse() {
/*  88 */     return this.storehouse;
/*     */   }
/*     */ 
/*     */   public void setStorehouse(String storehouse) {
/*  92 */     this.storehouse = storehouse;
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
/*     */   public String getPublisherAccount() {
/* 104 */     return this.publisherAccount;
/*     */   }
/*     */ 
/*     */   public void setPublisherAccount(String publisherAccount) {
/* 108 */     this.publisherAccount = publisherAccount;
/*     */   }
/*     */ 
/*     */   public String getProjectCode() {
/* 112 */     return this.projectCode;
/*     */   }
/*     */ 
/*     */   public void setProjectCode(String projectCode) {
/* 116 */     this.projectCode = projectCode;
/*     */   }
/*     */ 
/*     */   public void setSysTimeFlag(String sysTimeFlag) {
/* 120 */     this.sysTimeFlag = sysTimeFlag;
/*     */   }
/*     */ 
/*     */   public String getSysTimeFlag() {
/* 124 */     return this.sysTimeFlag;
/*     */   }
/*     */ 
/*     */   public String getProjectTypeCode() {
/* 128 */     return this.projectTypeCode;
/*     */   }
/*     */ 
/*     */   public void setProjectTypeCode(String projectTypeCode) {
/* 132 */     this.projectTypeCode = projectTypeCode;
/*     */   }
/*     */ 
/*     */   public String getProjectTypeName() {
/* 136 */     return this.projectTypeName;
/*     */   }
/*     */ 
/*     */   public void setProjectTypeName(String projectTypeName) {
/* 140 */     this.projectTypeName = projectTypeName;
/*     */   }
/*     */ 
/*     */   public Date getEffectiveStartDateFrom() {
/* 144 */     return this.effectiveStartDateFrom;
/*     */   }
/*     */ 
/*     */   public void setEffectiveStartDateFrom(Date effectiveStartDateFrom) {
/* 148 */     this.effectiveStartDateFrom = effectiveStartDateFrom;
/*     */   }
/*     */ 
/*     */   public Date getEffectiveStartDateTo() {
/* 152 */     return this.effectiveStartDateTo;
/*     */   }
/*     */ 
/*     */   public void setEffectiveStartDateTo(Date effectiveStartDateTo) {
/* 156 */     this.effectiveStartDateTo = effectiveStartDateTo;
/*     */   }
/*     */ 
/*     */   public Date getEffectiveEndDateFrom() {
/* 160 */     return this.effectiveEndDateFrom;
/*     */   }
/*     */ 
/*     */   public void setEffectiveEndDateFrom(Date effectiveEndDateFrom) {
/* 164 */     this.effectiveEndDateFrom = effectiveEndDateFrom;
/*     */   }
/*     */ 
/*     */   public Date getEffectiveEndDateTo() {
/* 168 */     return this.effectiveEndDateTo;
/*     */   }
/*     */ 
/*     */   public void setEffectiveEndDateTo(Date effectiveEndDateTo) {
/* 172 */     this.effectiveEndDateTo = effectiveEndDateTo;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.domain.query.SupplyDemandInfoQuery
 * JD-Core Version:    0.6.0
 */