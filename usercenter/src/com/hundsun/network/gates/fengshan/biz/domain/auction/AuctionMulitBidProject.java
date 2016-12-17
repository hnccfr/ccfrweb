/*     */ package com.hundsun.network.gates.fengshan.biz.domain.auction;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumActiveStatus;
/*     */ 
/*     */ public class AuctionMulitBidProject
/*     */ {
/*     */   private Long id;
/*     */   private String projectCode;
/*     */   private String projectTitle;
/*     */   private String projectTypeCode;
/*     */   private String projectTypeName;
/*     */   private String bidStartTime;
/*     */   private String tradingType;
/*     */   private String reviewer;
/*     */   private String projectStatus;
/*     */   private String activeTag;
/*     */ 
/*     */   public String getProjectCode()
/*     */   {
/*  62 */     return this.projectCode;
/*     */   }
/*     */ 
/*     */   public void setProjectCode(String projectCode) {
/*  66 */     this.projectCode = projectCode;
/*     */   }
/*     */ 
/*     */   public String getProjectTypeCode()
/*     */   {
/*  71 */     return this.projectTypeCode;
/*     */   }
/*     */ 
/*     */   public void setProjectTypeCode(String projectTypeCode) {
/*  75 */     this.projectTypeCode = projectTypeCode;
/*     */   }
/*     */ 
/*     */   public String getTradingType() {
/*  79 */     return this.tradingType;
/*     */   }
/*     */ 
/*     */   public void setTradingType(String tradingType) {
/*  83 */     this.tradingType = tradingType;
/*     */   }
/*     */ 
/*     */   public String getReviewer() {
/*  87 */     return this.reviewer;
/*     */   }
/*     */ 
/*     */   public void setReviewer(String reviewer) {
/*  91 */     this.reviewer = reviewer;
/*     */   }
/*     */ 
/*     */   public Long getId() {
/*  95 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/*  99 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getProjectTitle() {
/* 103 */     return this.projectTitle;
/*     */   }
/*     */ 
/*     */   public void setProjectTitle(String projectTitle) {
/* 107 */     this.projectTitle = projectTitle;
/*     */   }
/*     */ 
/*     */   public void setBidStartTime(String bidStartTime) {
/* 111 */     this.bidStartTime = bidStartTime;
/*     */   }
/*     */ 
/*     */   public String getBidStartTime() {
/* 115 */     return this.bidStartTime;
/*     */   }
/*     */ 
/*     */   public String getProjectStatus() {
/* 119 */     return this.projectStatus;
/*     */   }
/*     */ 
/*     */   public void setProjectStatus(String projectStatus) {
/* 123 */     this.projectStatus = projectStatus;
/*     */   }
/*     */ 
/*     */   public String getProjectTypeName() {
/* 127 */     return this.projectTypeName;
/*     */   }
/*     */ 
/*     */   public void setProjectTypeName(String projectTypeName) {
/* 131 */     this.projectTypeName = projectTypeName;
/*     */   }
/*     */ 
/*     */   public String getActiveTag() {
/* 135 */     return this.activeTag;
/*     */   }
/*     */ 
/*     */   public void setActiveTag(String activeTag) {
/* 139 */     this.activeTag = activeTag;
/*     */   }
/*     */ 
/*     */   public boolean isHallActive() {
/* 143 */     return EnumActiveStatus.Yes.getValue().equals(getActiveTag());
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.domain.auction.AuctionMulitBidProject
 * JD-Core Version:    0.6.0
 */