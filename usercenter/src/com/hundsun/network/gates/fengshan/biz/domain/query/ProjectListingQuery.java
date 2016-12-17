/*     */ package com.hundsun.network.gates.fengshan.biz.domain.query;
/*     */ 
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectListing;
/*     */ import com.hundsun.network.gates.luosi.common.page.Pagination;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class ProjectListingQuery extends Pagination<ProjectListing>
/*     */ {
/*     */   private static final long serialVersionUID = -6343772754962024860L;
/*     */   private Long id;
/*     */   private String title;
/*     */   private String listingType;
/*     */   private String code;
/*     */   private String userAccount;
/*     */   private String status;
/*     */   private Date listingStartTimeFrom;
/*     */   private Date listingStartTimeTo;
/*     */   private Date listingEndTimeFrom;
/*     */   private Date listingEndTimeTo;
/*     */   private String sysTimeFlag;
/*     */   private String tradingType;
/*     */   private Long listingPrice;
/*     */   private Date deliveryDate;
/*     */   private String breedStandard;
/*     */   private String storehouse;
/*     */   private String projectTypeName;
/*     */   private String projectTypeCode;
/*     */   private String projectRootTypeCode;
/*     */   private Date deliveryTimeFrom;
/*     */   private Date deliveryTimeTo;
/*     */   private String auctioneerAccount;
/*     */   private String auctioneerAccountKey;
/*     */   private String haveAuctioneerKey;
/*     */   private String applyStartTimeKey;
/*     */   private String reviewerAccount;
/*     */   private String reviewerAccountKey;
/*     */   private String reviewStatus;
/*     */   private String[] tradingTypeArr;
/*     */ 
/*     */   public String getCode()
/*     */   {
/* 152 */     return this.code;
/*     */   }
/*     */ 
/*     */   public void setCode(String code) {
/* 156 */     this.code = code;
/*     */   }
/*     */ 
/*     */   public String getUserAccount() {
/* 160 */     return this.userAccount;
/*     */   }
/*     */ 
/*     */   public void setUserAccount(String userAccount) {
/* 164 */     this.userAccount = userAccount;
/*     */   }
/*     */ 
/*     */   public String getStatus() {
/* 168 */     return this.status;
/*     */   }
/*     */ 
/*     */   public void setStatus(String status) {
/* 172 */     this.status = status;
/*     */   }
/*     */ 
/*     */   public Date getListingStartTimeFrom() {
/* 176 */     return this.listingStartTimeFrom;
/*     */   }
/*     */ 
/*     */   public void setListingStartTimeFrom(Date listingStartTimeFrom) {
/* 180 */     this.listingStartTimeFrom = listingStartTimeFrom;
/*     */   }
/*     */ 
/*     */   public Date getListingStartTimeTo() {
/* 184 */     return this.listingStartTimeTo;
/*     */   }
/*     */ 
/*     */   public void setListingStartTimeTo(Date listingStartTimeTo) {
/* 188 */     this.listingStartTimeTo = listingStartTimeTo;
/*     */   }
/*     */ 
/*     */   public void setTitle(String title) {
/* 192 */     this.title = title;
/*     */   }
/*     */ 
/*     */   public String getTitle() {
/* 196 */     return this.title;
/*     */   }
/*     */ 
/*     */   public void setListingEndTimeTo(Date listingEndTimeTo) {
/* 200 */     this.listingEndTimeTo = listingEndTimeTo;
/*     */   }
/*     */ 
/*     */   public Date getListingEndTimeTo() {
/* 204 */     return this.listingEndTimeTo;
/*     */   }
/*     */ 
/*     */   public void setListingEndTimeFrom(Date listingEndTimeFrom) {
/* 208 */     this.listingEndTimeFrom = listingEndTimeFrom;
/*     */   }
/*     */ 
/*     */   public Date getListingEndTimeFrom() {
/* 212 */     return this.listingEndTimeFrom;
/*     */   }
/*     */ 
/*     */   public void setListingType(String listingType) {
/* 216 */     this.listingType = listingType;
/*     */   }
/*     */ 
/*     */   public String getListingType() {
/* 220 */     return this.listingType;
/*     */   }
/*     */ 
/*     */   public void setSysTimeFlag(String sysTimeFlag) {
/* 224 */     this.sysTimeFlag = sysTimeFlag;
/*     */   }
/*     */ 
/*     */   public String getSysTimeFlag() {
/* 228 */     return this.sysTimeFlag;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/* 232 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public Long getId() {
/* 236 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setDeliveryDate(Date deliveryDate) {
/* 240 */     this.deliveryDate = deliveryDate;
/*     */   }
/*     */ 
/*     */   public Date getDeliveryDate() {
/* 244 */     return this.deliveryDate;
/*     */   }
/*     */ 
/*     */   public void setTradingType(String tradingType) {
/* 248 */     this.tradingType = tradingType;
/*     */   }
/*     */ 
/*     */   public String getTradingType() {
/* 252 */     return this.tradingType;
/*     */   }
/*     */ 
/*     */   public void setListingPrice(Long listingPrice) {
/* 256 */     this.listingPrice = listingPrice;
/*     */   }
/*     */ 
/*     */   public Long getListingPrice() {
/* 260 */     return this.listingPrice;
/*     */   }
/*     */ 
/*     */   public void setBreedStandard(String breedStandard) {
/* 264 */     this.breedStandard = breedStandard;
/*     */   }
/*     */ 
/*     */   public String getBreedStandard() {
/* 268 */     return this.breedStandard;
/*     */   }
/*     */ 
/*     */   public void setStorehouse(String storehouse) {
/* 272 */     this.storehouse = storehouse;
/*     */   }
/*     */ 
/*     */   public String getStorehouse() {
/* 276 */     return this.storehouse;
/*     */   }
/*     */ 
/*     */   public void setProjectTypeName(String projectTypeName) {
/* 280 */     this.projectTypeName = projectTypeName;
/*     */   }
/*     */ 
/*     */   public String getProjectTypeName() {
/* 284 */     return this.projectTypeName;
/*     */   }
/*     */ 
/*     */   public void setProjectTypeCode(String projectTypeCode) {
/* 288 */     this.projectTypeCode = projectTypeCode;
/*     */   }
/*     */ 
/*     */   public String getProjectTypeCode() {
/* 292 */     return this.projectTypeCode;
/*     */   }
/*     */ 
/*     */   public String getProjectRootTypeCode() {
/* 296 */     return this.projectRootTypeCode;
/*     */   }
/*     */ 
/*     */   public void setProjectRootTypeCode(String projectRootTypeCode) {
/* 300 */     this.projectRootTypeCode = projectRootTypeCode;
/*     */   }
/*     */ 
/*     */   public Date getDeliveryTimeFrom() {
/* 304 */     return this.deliveryTimeFrom;
/*     */   }
/*     */ 
/*     */   public void setDeliveryTimeFrom(Date deliveryTimeFrom) {
/* 308 */     this.deliveryTimeFrom = deliveryTimeFrom;
/*     */   }
/*     */ 
/*     */   public Date getDeliveryTimeTo() {
/* 312 */     return this.deliveryTimeTo;
/*     */   }
/*     */ 
/*     */   public void setDeliveryTimeTo(Date deliveryTimeTo) {
/* 316 */     this.deliveryTimeTo = deliveryTimeTo;
/*     */   }
/*     */ 
/*     */   public String getAuctioneerAccount() {
/* 320 */     return this.auctioneerAccount;
/*     */   }
/*     */ 
/*     */   public void setAuctioneerAccount(String auctioneerAccount) {
/* 324 */     this.auctioneerAccount = auctioneerAccount;
/*     */   }
/*     */ 
/*     */   public String getAuctioneerAccountKey() {
/* 328 */     return this.auctioneerAccountKey;
/*     */   }
/*     */ 
/*     */   public void setAuctioneerAccountKey(String auctioneerAccountKey) {
/* 332 */     this.auctioneerAccountKey = auctioneerAccountKey;
/*     */   }
/*     */ 
/*     */   public String getHaveAuctioneerKey() {
/* 336 */     return this.haveAuctioneerKey;
/*     */   }
/*     */ 
/*     */   public void setHaveAuctioneerKey(String haveAuctioneerKey) {
/* 340 */     this.haveAuctioneerKey = haveAuctioneerKey;
/*     */   }
/*     */ 
/*     */   public String getApplyStartTimeKey() {
/* 344 */     return this.applyStartTimeKey;
/*     */   }
/*     */ 
/*     */   public void setApplyStartTimeKey(String applyStartTimeKey) {
/* 348 */     this.applyStartTimeKey = applyStartTimeKey;
/*     */   }
/*     */ 
/*     */   public String getReviewerAccount() {
/* 352 */     return this.reviewerAccount;
/*     */   }
/*     */ 
/*     */   public void setReviewerAccount(String reviewerAccount) {
/* 356 */     this.reviewerAccount = reviewerAccount;
/*     */   }
/*     */ 
/*     */   public String getReviewerAccountKey() {
/* 360 */     return this.reviewerAccountKey;
/*     */   }
/*     */ 
/*     */   public void setReviewerAccountKey(String reviewerAccountKey) {
/* 364 */     this.reviewerAccountKey = reviewerAccountKey;
/*     */   }
/*     */ 
/*     */   public String getReviewStatus() {
/* 368 */     return this.reviewStatus;
/*     */   }
/*     */ 
/*     */   public void setReviewStatus(String reviewStatus) {
/* 372 */     this.reviewStatus = reviewStatus;
/*     */   }
/*     */ 
/*     */   public String[] getTradingTypeArr() {
/* 376 */     return this.tradingTypeArr;
/*     */   }
/*     */ 
/*     */   public void setTradingTypeArr(String[] tradingTypeArr) {
/* 380 */     this.tradingTypeArr = tradingTypeArr;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.domain.query.ProjectListingQuery
 * JD-Core Version:    0.6.0
 */