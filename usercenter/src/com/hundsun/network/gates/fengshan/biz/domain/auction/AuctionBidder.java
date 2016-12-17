/*     */ package com.hundsun.network.gates.fengshan.biz.domain.auction;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumAuctionBidderBidStatus;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class AuctionBidder
/*     */ {
/*     */   private Long id;
/*     */   private String projectCode;
/*     */   private String bidderAccount;
/*     */   private String isPriority;
/*     */   private String bidderTrademark;
/*     */   private String brokerAccount;
/*     */   private String bidStatus;
/*     */   private String serviceCode;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */   private String operator;
/*     */   private Long lastBidPrice;
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  70 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/*  74 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getProjectCode()
/*     */   {
/*  81 */     return this.projectCode;
/*     */   }
/*     */ 
/*     */   public void setProjectCode(String projectCode)
/*     */   {
/*  88 */     this.projectCode = projectCode;
/*     */   }
/*     */ 
/*     */   public String getBidderAccount()
/*     */   {
/*  95 */     return this.bidderAccount;
/*     */   }
/*     */ 
/*     */   public void setBidderAccount(String bidderAccount)
/*     */   {
/* 102 */     this.bidderAccount = bidderAccount;
/*     */   }
/*     */ 
/*     */   public String getIsPriority()
/*     */   {
/* 111 */     return this.isPriority;
/*     */   }
/*     */ 
/*     */   public void setIsPriority(String isPriority)
/*     */   {
/* 120 */     this.isPriority = isPriority;
/*     */   }
/*     */ 
/*     */   public String getBidderTrademark()
/*     */   {
/* 127 */     return this.bidderTrademark;
/*     */   }
/*     */ 
/*     */   public void setBidderTrademark(String bidderTrademark)
/*     */   {
/* 134 */     this.bidderTrademark = bidderTrademark;
/*     */   }
/*     */ 
/*     */   public String getBrokerAccount()
/*     */   {
/* 141 */     return this.brokerAccount;
/*     */   }
/*     */ 
/*     */   public void setBrokerAccount(String brokerAccount)
/*     */   {
/* 148 */     this.brokerAccount = brokerAccount;
/*     */   }
/*     */ 
/*     */   public String getBidStatus()
/*     */   {
/* 157 */     return this.bidStatus;
/*     */   }
/*     */ 
/*     */   public void setBidStatus(String bidStatus)
/*     */   {
/* 166 */     this.bidStatus = bidStatus;
/*     */   }
/*     */ 
/*     */   public String getServiceCode()
/*     */   {
/* 173 */     return this.serviceCode;
/*     */   }
/*     */ 
/*     */   public void setServiceCode(String serviceCode)
/*     */   {
/* 180 */     this.serviceCode = serviceCode;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate()
/*     */   {
/* 187 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate)
/*     */   {
/* 194 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify()
/*     */   {
/* 201 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify)
/*     */   {
/* 208 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getOperator()
/*     */   {
/* 215 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator)
/*     */   {
/* 222 */     this.operator = operator;
/*     */   }
/*     */ 
/*     */   public void setLastBidPrice(Long lastBidPrice) {
/* 226 */     this.lastBidPrice = lastBidPrice;
/*     */   }
/*     */ 
/*     */   public Long getLastBidPrice() {
/* 230 */     return this.lastBidPrice;
/*     */   }
/*     */ 
/*     */   public String getBidStatusDesc() {
/* 234 */     EnumAuctionBidderBidStatus bidStatusEnum = EnumAuctionBidderBidStatus.indexByValue(this.bidStatus);
/* 235 */     if (null == bidStatusEnum) {
/* 236 */       return this.bidStatus;
/*     */     }
/* 238 */     return bidStatusEnum.getName();
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.domain.auction.AuctionBidder
 * JD-Core Version:    0.6.0
 */