/*     */ package com.hundsun.network.gates.fengshan.biz.domain.query;
/*     */ 
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.auction.AuctionMulitBidProject;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumActiveStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumMulitBidOrderProperty;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumProjectStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradingType;
/*     */ import com.hundsun.network.gates.luosi.common.page.Pagination;
/*     */ import java.util.List;
/*     */ 
/*     */ public class AuctionMulitBidProjectQuery extends Pagination<AuctionMulitBidProject>
/*     */ {
/*     */   private static final long serialVersionUID = -3356550012861115638L;
/*     */   private String projectCode;
/*     */   private String reviewer;
/*     */   private EnumMulitBidOrderProperty reviewerKey;
/*     */   private EnumMulitBidOrderProperty bidStartTimeKey;
/*     */   private EnumTradingType tradingType;
/*     */   private List<EnumProjectStatus> projectStatus;
/*     */   private EnumActiveStatus reviewed;
/*     */   private String userAccount;
/*     */ 
/*     */   public String getProjectCode()
/*     */   {
/*  57 */     return this.projectCode;
/*     */   }
/*     */ 
/*     */   public void setProjectCode(String projectCode) {
/*  61 */     this.projectCode = projectCode;
/*     */   }
/*     */ 
/*     */   public String getReviewer() {
/*  65 */     return this.reviewer;
/*     */   }
/*     */ 
/*     */   public void setReviewer(String reviewer) {
/*  69 */     this.reviewer = reviewer;
/*     */   }
/*     */ 
/*     */   public EnumMulitBidOrderProperty getReviewerKey() {
/*  73 */     return this.reviewerKey;
/*     */   }
/*     */ 
/*     */   public void setReviewerKey(EnumMulitBidOrderProperty reviewerKey) {
/*  77 */     this.reviewerKey = reviewerKey;
/*     */   }
/*     */ 
/*     */   public EnumTradingType getTradingType() {
/*  81 */     return this.tradingType;
/*     */   }
/*     */ 
/*     */   public void setTradingType(EnumTradingType tradingType) {
/*  85 */     this.tradingType = tradingType;
/*     */   }
/*     */ 
/*     */   public EnumMulitBidOrderProperty getBidStartTimeKey() {
/*  89 */     return this.bidStartTimeKey;
/*     */   }
/*     */ 
/*     */   public void setBidStartTimeKey(EnumMulitBidOrderProperty bidStartTimeKey) {
/*  93 */     this.bidStartTimeKey = bidStartTimeKey;
/*     */   }
/*     */ 
/*     */   public List<EnumProjectStatus> getProjectStatus() {
/*  97 */     return this.projectStatus;
/*     */   }
/*     */ 
/*     */   public void setProjectStatus(List<EnumProjectStatus> projectStatus) {
/* 101 */     this.projectStatus = projectStatus;
/*     */   }
/*     */ 
/*     */   public EnumActiveStatus getReviewed() {
/* 105 */     return this.reviewed;
/*     */   }
/*     */ 
/*     */   public void setReviewed(EnumActiveStatus reviewed) {
/* 109 */     this.reviewed = reviewed;
/*     */   }
/*     */ 
/*     */   public String getUserAccount() {
/* 113 */     return this.userAccount;
/*     */   }
/*     */ 
/*     */   public void setUserAccount(String userAccount) {
/* 117 */     this.userAccount = userAccount;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.domain.query.AuctionMulitBidProjectQuery
 * JD-Core Version:    0.6.0
 */