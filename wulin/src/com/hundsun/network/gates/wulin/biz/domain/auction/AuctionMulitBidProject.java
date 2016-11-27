/*     */ package com.hundsun.network.gates.wulin.biz.domain.auction;
/*     */ 
/*     */ public class AuctionMulitBidProject
/*     */ {
/*     */   private Long id;
/*     */   private String projectCode;
/*     */   private String projectTitle;
/*     */   private String projectTypeCode;
/*     */   private String bidStartTime;
/*     */   private String tradingType;
/*     */   private String reviewer;
/*     */   private String projectStatus;
/*     */ 
/*     */   public String getProjectCode()
/*     */   {
/*  51 */     return this.projectCode;
/*     */   }
/*     */ 
/*     */   public void setProjectCode(String projectCode) {
/*  55 */     this.projectCode = projectCode;
/*     */   }
/*     */ 
/*     */   public String getProjectTypeCode()
/*     */   {
/*  60 */     return this.projectTypeCode;
/*     */   }
/*     */ 
/*     */   public void setProjectTypeCode(String projectTypeCode) {
/*  64 */     this.projectTypeCode = projectTypeCode;
/*     */   }
/*     */ 
/*     */   public String getTradingType() {
/*  68 */     return this.tradingType;
/*     */   }
/*     */ 
/*     */   public void setTradingType(String tradingType) {
/*  72 */     this.tradingType = tradingType;
/*     */   }
/*     */ 
/*     */   public String getReviewer() {
/*  76 */     return this.reviewer;
/*     */   }
/*     */ 
/*     */   public void setReviewer(String reviewer) {
/*  80 */     this.reviewer = reviewer;
/*     */   }
/*     */ 
/*     */   public Long getId() {
/*  84 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/*  88 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getProjectTitle() {
/*  92 */     return this.projectTitle;
/*     */   }
/*     */ 
/*     */   public void setProjectTitle(String projectTitle) {
/*  96 */     this.projectTitle = projectTitle;
/*     */   }
/*     */ 
/*     */   public void setBidStartTime(String bidStartTime) {
/* 100 */     this.bidStartTime = bidStartTime;
/*     */   }
/*     */ 
/*     */   public String getBidStartTime() {
/* 104 */     return this.bidStartTime;
/*     */   }
/*     */ 
/*     */   public String getProjectStatus() {
/* 108 */     return this.projectStatus;
/*     */   }
/*     */ 
/*     */   public void setProjectStatus(String projectStatus) {
/* 112 */     this.projectStatus = projectStatus;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.domain.auction.AuctionMulitBidProject
 * JD-Core Version:    0.6.0
 */