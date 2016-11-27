/*     */ package com.hundsun.network.gates.genshan.biz.domain.query;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.page.Pagination;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class ProjectListingQuery<ProjectListing> extends Pagination<ProjectListing>
/*     */ {
/*     */   private static final long serialVersionUID = -2256557429935374174L;
/*     */   private String title;
/*     */   private String code;
/*     */   private String userAccount;
/*     */   private String listingType;
/*     */   private String status;
/*     */   private Date listingStartTimeL;
/*     */   private Date listingStartTimeR;
/*     */   private Date listingEndTimeL;
/*     */   private Date listingEndTimeR;
/*     */   private boolean codeExist;
/*     */   private Long substationId;
/*     */ 
/*     */   public boolean isCodeExist()
/*     */   {
/*  74 */     return this.codeExist;
/*     */   }
/*     */ 
/*     */   public void setCodeExist(boolean codeExist) {
/*  78 */     this.codeExist = codeExist;
/*     */   }
/*     */ 
/*     */   public String getTitle() {
/*  82 */     return this.title;
/*     */   }
/*     */ 
/*     */   public void setTitle(String title) {
/*  86 */     this.title = title;
/*     */   }
/*     */ 
/*     */   public String getCode() {
/*  90 */     return this.code;
/*     */   }
/*     */ 
/*     */   public void setCode(String code) {
/*  94 */     this.code = code;
/*     */   }
/*     */ 
/*     */   public String getUserAccount() {
/*  98 */     return this.userAccount;
/*     */   }
/*     */ 
/*     */   public void setUserAccount(String userAccount) {
/* 102 */     this.userAccount = userAccount;
/*     */   }
/*     */ 
/*     */   public String getStatus() {
/* 106 */     return this.status;
/*     */   }
/*     */ 
/*     */   public void setStatus(String status) {
/* 110 */     this.status = status;
/*     */   }
/*     */ 
/*     */   public Date getListingStartTimeL() {
/* 114 */     return this.listingStartTimeL;
/*     */   }
/*     */ 
/*     */   public void setListingStartTimeL(Date listingStartTimeL) {
/* 118 */     this.listingStartTimeL = listingStartTimeL;
/*     */   }
/*     */ 
/*     */   public Date getListingStartTimeR() {
/* 122 */     return this.listingStartTimeR;
/*     */   }
/*     */ 
/*     */   public void setListingStartTimeR(Date listingStartTimeR) {
/* 126 */     this.listingStartTimeR = listingStartTimeR;
/*     */   }
/*     */ 
/*     */   public Date getListingEndTimeL() {
/* 130 */     return this.listingEndTimeL;
/*     */   }
/*     */ 
/*     */   public void setListingEndTimeL(Date listingEndTimeL) {
/* 134 */     this.listingEndTimeL = listingEndTimeL;
/*     */   }
/*     */ 
/*     */   public Date getListingEndTimeR() {
/* 138 */     return this.listingEndTimeR;
/*     */   }
/*     */ 
/*     */   public void setListingEndTimeR(Date listingEndTimeR) {
/* 142 */     this.listingEndTimeR = listingEndTimeR;
/*     */   }
/*     */ 
/*     */   public String getListingType() {
/* 146 */     return this.listingType;
/*     */   }
/*     */ 
/*     */   public void setListingType(String listingType) {
/* 150 */     this.listingType = listingType;
/*     */   }
/*     */ 
/*     */   public void trim()
/*     */   {
/* 155 */     if (this.title != null) setTitle(this.title.trim());
/* 156 */     if (this.code != null) setCode(this.code.trim());
/* 157 */     if (this.userAccount != null) setUserAccount(this.userAccount.trim()); 
/*     */   }
/*     */ 
/*     */   public Long getSubstationId()
/*     */   {
/* 161 */     return this.substationId;
/*     */   }
/*     */ 
/*     */   public void setSubstationId(Long substationId) {
/* 165 */     this.substationId = substationId;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.query.ProjectListingQuery
 * JD-Core Version:    0.6.0
 */