/*     */ package com.hundsun.network.gates.genshan.biz.domain.query;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.domain.supplydemand.SupplyDemandInfo;
/*     */ import com.hundsun.network.gates.luosi.common.page.Pagination;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class SupplyDemandInfoQuery extends Pagination<SupplyDemandInfo>
/*     */ {
/*     */   private static final long serialVersionUID = -6343772754962024860L;
/*     */   private Long id;
/*     */   private String title;
/*     */   private String infoType;
/*     */   private String code;
/*     */   private String publisherAccount;
/*     */   private String status;
/*     */   private Date startTime;
/*     */   private Date endTime;
/*     */   private Long price;
/*     */   private String storeHouse;
/*     */   private String listingType;
/*     */   private Date gmtCreateFrom;
/*     */   private Date gmtCreateTo;
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  31 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/*  35 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getTitle() {
/*  39 */     return this.title;
/*     */   }
/*     */ 
/*     */   public void setTitle(String title) {
/*  43 */     this.title = title;
/*     */   }
/*     */ 
/*     */   public String getListingType() {
/*  47 */     return this.listingType;
/*     */   }
/*     */ 
/*     */   public void setListingType(String listingType) {
/*  51 */     this.listingType = listingType;
/*     */   }
/*     */ 
/*     */   public String getCode() {
/*  55 */     return this.code;
/*     */   }
/*     */ 
/*     */   public void setCode(String code) {
/*  59 */     this.code = code;
/*     */   }
/*     */ 
/*     */   public String getPublisherAccount()
/*     */   {
/*  64 */     return this.publisherAccount;
/*     */   }
/*     */ 
/*     */   public void setPublisherAccount(String publisherAccount) {
/*  68 */     this.publisherAccount = publisherAccount;
/*     */   }
/*     */ 
/*     */   public String getStatus() {
/*  72 */     return this.status;
/*     */   }
/*     */ 
/*     */   public void setStatus(String status) {
/*  76 */     this.status = status;
/*     */   }
/*     */ 
/*     */   public Date getStartTime() {
/*  80 */     return this.startTime;
/*     */   }
/*     */ 
/*     */   public void setStartTime(Date startTime) {
/*  84 */     this.startTime = startTime;
/*     */   }
/*     */ 
/*     */   public Date getEndTime() {
/*  88 */     return this.endTime;
/*     */   }
/*     */ 
/*     */   public void setEndTime(Date endTime) {
/*  92 */     this.endTime = endTime;
/*     */   }
/*     */ 
/*     */   public Long getPrice() {
/*  96 */     return this.price;
/*     */   }
/*     */ 
/*     */   public void setPrice(Long price) {
/* 100 */     this.price = price;
/*     */   }
/*     */ 
/*     */   public String getStorage() {
/* 104 */     return this.storeHouse;
/*     */   }
/*     */ 
/*     */   public void setStorage(String storeHouse) {
/* 108 */     this.storeHouse = storeHouse;
/*     */   }
/*     */ 
/*     */   public String getInfoType() {
/* 112 */     return this.infoType;
/*     */   }
/*     */ 
/*     */   public void setInfoTyoe(String infoType) {
/* 116 */     this.infoType = infoType;
/*     */   }
/*     */ 
/*     */   public String getStoreHouse()
/*     */   {
/* 121 */     return this.storeHouse;
/*     */   }
/*     */ 
/*     */   public void setStoreHouse(String storeHouse) {
/* 125 */     this.storeHouse = storeHouse;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreateFrom() {
/* 129 */     return this.gmtCreateFrom;
/*     */   }
/*     */ 
/*     */   public void setGmtCreateFrom(Date gmtCreateFrom) {
/* 133 */     this.gmtCreateFrom = gmtCreateFrom;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreateTo() {
/* 137 */     return this.gmtCreateTo;
/*     */   }
/*     */ 
/*     */   public void setGmtCreateTo(Date gmtCreateTo) {
/* 141 */     this.gmtCreateTo = gmtCreateTo;
/*     */   }
/*     */ 
/*     */   public void setInfoType(String infoType) {
/* 145 */     this.infoType = infoType;
/*     */   }
/*     */ 
/*     */   public String toString() {
/* 149 */     return "[id:" + this.id + "][title:" + this.title + "][infoType:" + this.infoType + "][code:" + this.code + "][publisherAccount:" + this.publisherAccount + "][status:" + this.status + "][startTime:" + this.startTime + "][endTime:" + this.endTime + "][price:" + this.price + "][storeHouse:" + this.storeHouse + "][infoType:" + this.infoType + "]";
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.query.SupplyDemandInfoQuery
 * JD-Core Version:    0.6.0
 */