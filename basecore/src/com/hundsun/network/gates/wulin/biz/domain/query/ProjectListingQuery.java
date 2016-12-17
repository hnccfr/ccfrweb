/*     */ package com.hundsun.network.gates.wulin.biz.domain.query;
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
/*     */   private String status;
/*     */   private Date listingStartTimeL;
/*     */   private Date listingStartTimeR;
/*     */   private Date listingEndTimeL;
/*     */   private Date listingEndTimeR;
/*     */   private String projectTypeCode;
/*     */   private String sysTimeFlag;
/*     */ 
/*     */   public String getTitle()
/*     */   {
/*  69 */     return this.title;
/*     */   }
/*     */ 
/*     */   public void setTitle(String title) {
/*  73 */     this.title = title;
/*     */   }
/*     */ 
/*     */   public String getCode() {
/*  77 */     return this.code;
/*     */   }
/*     */ 
/*     */   public void setCode(String code) {
/*  81 */     this.code = code;
/*     */   }
/*     */ 
/*     */   public String getUserAccount() {
/*  85 */     return this.userAccount;
/*     */   }
/*     */ 
/*     */   public void setUserAccount(String userAccount) {
/*  89 */     this.userAccount = userAccount;
/*     */   }
/*     */ 
/*     */   public String getStatus() {
/*  93 */     return this.status;
/*     */   }
/*     */ 
/*     */   public void setStatus(String status) {
/*  97 */     this.status = status;
/*     */   }
/*     */ 
/*     */   public Date getListingStartTimeL() {
/* 101 */     return this.listingStartTimeL;
/*     */   }
/*     */ 
/*     */   public void setListingStartTimeL(Date listingStartTimeL) {
/* 105 */     this.listingStartTimeL = listingStartTimeL;
/*     */   }
/*     */ 
/*     */   public Date getListingStartTimeR() {
/* 109 */     return this.listingStartTimeR;
/*     */   }
/*     */ 
/*     */   public void setListingStartTimeR(Date listingStartTimeR) {
/* 113 */     this.listingStartTimeR = listingStartTimeR;
/*     */   }
/*     */ 
/*     */   public Date getListingEndTimeL() {
/* 117 */     return this.listingEndTimeL;
/*     */   }
/*     */ 
/*     */   public void setListingEndTimeL(Date listingEndTimeL) {
/* 121 */     this.listingEndTimeL = listingEndTimeL;
/*     */   }
/*     */ 
/*     */   public Date getListingEndTimeR() {
/* 125 */     return this.listingEndTimeR;
/*     */   }
/*     */ 
/*     */   public void setListingEndTimeR(Date listingEndTimeR) {
/* 129 */     this.listingEndTimeR = listingEndTimeR;
/*     */   }
/*     */ 
/*     */   public String getProjectTypeCode() {
/* 133 */     return this.projectTypeCode;
/*     */   }
/*     */ 
/*     */   public void setProjectTypeCode(String projectTypeCode) {
/* 137 */     this.projectTypeCode = projectTypeCode;
/*     */   }
/*     */ 
/*     */   public String getSysTimeFlag() {
/* 141 */     return this.sysTimeFlag;
/*     */   }
/*     */ 
/*     */   public void setSysTimeFlag(String sysTimeFlag) {
/* 145 */     this.sysTimeFlag = sysTimeFlag;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.domain.query.ProjectListingQuery
 * JD-Core Version:    0.6.0
 */