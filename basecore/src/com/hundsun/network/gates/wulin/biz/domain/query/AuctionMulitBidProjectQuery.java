/*     */ package com.hundsun.network.gates.wulin.biz.domain.query;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumActiveStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumMulitBidOrderProperty;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumProjectStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradingType;
/*     */ import com.hundsun.network.gates.luosi.common.page.Pagination;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.auction.AuctionMulitBidProject;
/*     */ import java.util.List;
/*     */ 
/*     */ public class AuctionMulitBidProjectQuery extends Pagination<AuctionMulitBidProject>
/*     */ {
/*     */   private static final long serialVersionUID = -5341124239492296289L;
/*     */   private String projectCode;
/*     */   private String reviewer;
/*     */   private EnumMulitBidOrderProperty reviewerKey;
/*     */   private EnumMulitBidOrderProperty bidStartTimeKey;
/*     */   private EnumTradingType tradingType;
/*     */   private List<EnumProjectStatus> projectStatus;
/*     */   private EnumActiveStatus reviewed;
/*     */ 
/*     */   public String getProjectCode()
/*     */   {
/*  53 */     return this.projectCode;
/*     */   }
/*     */ 
/*     */   public void setProjectCode(String projectCode) {
/*  57 */     this.projectCode = projectCode;
/*     */   }
/*     */ 
/*     */   public String getReviewer() {
/*  61 */     return this.reviewer;
/*     */   }
/*     */ 
/*     */   public void setReviewer(String reviewer) {
/*  65 */     this.reviewer = reviewer;
/*     */   }
/*     */ 
/*     */   public EnumMulitBidOrderProperty getReviewerKey() {
/*  69 */     return this.reviewerKey;
/*     */   }
/*     */ 
/*     */   public void setReviewerKey(EnumMulitBidOrderProperty reviewerKey) {
/*  73 */     this.reviewerKey = reviewerKey;
/*     */   }
/*     */ 
/*     */   public EnumTradingType getTradingType() {
/*  77 */     return this.tradingType;
/*     */   }
/*     */ 
/*     */   public void setTradingType(EnumTradingType tradingType) {
/*  81 */     this.tradingType = tradingType;
/*     */   }
/*     */ 
/*     */   public EnumMulitBidOrderProperty getBidStartTimeKey() {
/*  85 */     return this.bidStartTimeKey;
/*     */   }
/*     */ 
/*     */   public void setBidStartTimeKey(EnumMulitBidOrderProperty bidStartTimeKey) {
/*  89 */     this.bidStartTimeKey = bidStartTimeKey;
/*     */   }
/*     */ 
/*     */   public List<EnumProjectStatus> getProjectStatus() {
/*  93 */     return this.projectStatus;
/*     */   }
/*     */ 
/*     */   public void setProjectStatus(List<EnumProjectStatus> projectStatus) {
/*  97 */     this.projectStatus = projectStatus;
/*     */   }
/*     */ 
/*     */   public EnumActiveStatus getReviewed() {
/* 101 */     return this.reviewed;
/*     */   }
/*     */ 
/*     */   public void setReviewed(EnumActiveStatus reviewed) {
/* 105 */     this.reviewed = reviewed;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.domain.query.AuctionMulitBidProjectQuery
 * JD-Core Version:    0.6.0
 */