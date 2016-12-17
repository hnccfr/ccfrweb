/*     */ package com.hundsun.network.gates.qingbo.biz.domain.auction;
/*     */ 
/*     */ import com.hundsun.network.gates.qingbo.biz.domain.BaseDomain;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class AuctionHall extends BaseDomain
/*     */ {
/*     */   private static final long serialVersionUID = -8333759415989144844L;
/*     */   private Long id;
/*     */   private String projectCode;
/*     */   private String haveAuctioneer;
/*     */   private String auctioneerAccount;
/*     */   private Long bidStartPrice;
/*     */   private Short priceDirection;
/*     */   private String supportPriority;
/*     */   private Date bidStartTime;
/*     */   private Double bidLimitedPeriod;
/*     */   private Integer firstWaitTime;
/*     */   private String auctionType;
/*     */   private Date comFreeStarttime;
/*     */   private Date comFreeEndtime;
/*     */   private String valuationUnit;
/*     */   private Integer priorityNum;
/*     */   private String haveReservePrice;
/*     */   private Long reservePrice;
/*     */   private String allowWatch;
/*     */   private String watchPassword;
/*     */   private Date auctionEndTime;
/*     */   private Date gmtCreator;
/*     */   private Date gmtModify;
/*     */   private String operator;
/*     */   private Long bidStartCountDownMilliSeconds;
/*     */ 
/*     */   public Long getId()
/*     */   {
/* 170 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/* 174 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getProjectCode()
/*     */   {
/* 181 */     return this.projectCode;
/*     */   }
/*     */ 
/*     */   public void setProjectCode(String projectCode)
/*     */   {
/* 188 */     this.projectCode = projectCode;
/*     */   }
/*     */ 
/*     */   public String getHaveAuctioneer()
/*     */   {
/* 197 */     return this.haveAuctioneer;
/*     */   }
/*     */ 
/*     */   public void setHaveAuctioneer(String haveAuctioneer)
/*     */   {
/* 206 */     this.haveAuctioneer = haveAuctioneer;
/*     */   }
/*     */ 
/*     */   public String getAuctioneerAccount()
/*     */   {
/* 213 */     return this.auctioneerAccount;
/*     */   }
/*     */ 
/*     */   public void setAuctioneerAccount(String auctioneerAccount)
/*     */   {
/* 220 */     this.auctioneerAccount = auctioneerAccount;
/*     */   }
/*     */ 
/*     */   public Long getBidStartPrice()
/*     */   {
/* 229 */     return this.bidStartPrice;
/*     */   }
/*     */ 
/*     */   public void setBidStartPrice(Long bidStartPrice)
/*     */   {
/* 238 */     this.bidStartPrice = bidStartPrice;
/*     */   }
/*     */ 
/*     */   public Short getPriceDirection()
/*     */   {
/* 249 */     return this.priceDirection;
/*     */   }
/*     */ 
/*     */   public void setPriceDirection(Short priceDirection)
/*     */   {
/* 260 */     this.priceDirection = priceDirection;
/*     */   }
/*     */ 
/*     */   public String getSupportPriority()
/*     */   {
/* 271 */     return this.supportPriority;
/*     */   }
/*     */ 
/*     */   public void setSupportPriority(String supportPriority)
/*     */   {
/* 282 */     this.supportPriority = supportPriority;
/*     */   }
/*     */ 
/*     */   public Date getBidStartTime()
/*     */   {
/* 291 */     return this.bidStartTime;
/*     */   }
/*     */ 
/*     */   public void setBidStartTime(Date bidStartTime)
/*     */   {
/* 300 */     this.bidStartTime = bidStartTime;
/*     */   }
/*     */ 
/*     */   public Double getBidLimitedPeriod()
/*     */   {
/* 311 */     return this.bidLimitedPeriod;
/*     */   }
/*     */ 
/*     */   public void setBidLimitedPeriod(Double bidLimitedPeriod)
/*     */   {
/* 322 */     this.bidLimitedPeriod = bidLimitedPeriod;
/*     */   }
/*     */ 
/*     */   public Integer getFirstWaitTime()
/*     */   {
/* 329 */     return this.firstWaitTime;
/*     */   }
/*     */ 
/*     */   public void setFirstWaitTime(Integer firstWaitTime)
/*     */   {
/* 336 */     this.firstWaitTime = firstWaitTime;
/*     */   }
/*     */ 
/*     */   public String getAuctionType()
/*     */   {
/* 343 */     return this.auctionType;
/*     */   }
/*     */ 
/*     */   public void setAuctionType(String auctionType)
/*     */   {
/* 350 */     this.auctionType = auctionType;
/*     */   }
/*     */ 
/*     */   public Date getComFreeStarttime()
/*     */   {
/* 357 */     return this.comFreeStarttime;
/*     */   }
/*     */ 
/*     */   public void setComFreeStarttime(Date comFreeStarttime)
/*     */   {
/* 364 */     this.comFreeStarttime = comFreeStarttime;
/*     */   }
/*     */ 
/*     */   public Date getComFreeEndtime()
/*     */   {
/* 371 */     return this.comFreeEndtime;
/*     */   }
/*     */ 
/*     */   public void setComFreeEndtime(Date comFreeEndtime)
/*     */   {
/* 378 */     this.comFreeEndtime = comFreeEndtime;
/*     */   }
/*     */ 
/*     */   public String getValuationUnit()
/*     */   {
/* 385 */     return this.valuationUnit;
/*     */   }
/*     */ 
/*     */   public void setValuationUnit(String valuationUnit)
/*     */   {
/* 392 */     this.valuationUnit = valuationUnit;
/*     */   }
/*     */ 
/*     */   public Integer getPriorityNum()
/*     */   {
/* 399 */     return this.priorityNum;
/*     */   }
/*     */ 
/*     */   public void setPriorityNum(Integer priorityNum)
/*     */   {
/* 406 */     this.priorityNum = priorityNum;
/*     */   }
/*     */ 
/*     */   public String getHaveReservePrice()
/*     */   {
/* 417 */     return this.haveReservePrice;
/*     */   }
/*     */ 
/*     */   public void setHaveReservePrice(String haveReservePrice)
/*     */   {
/* 428 */     this.haveReservePrice = haveReservePrice;
/*     */   }
/*     */ 
/*     */   public Long getReservePrice()
/*     */   {
/* 443 */     return this.reservePrice;
/*     */   }
/*     */ 
/*     */   public void setReservePrice(Long reservePrice)
/*     */   {
/* 458 */     this.reservePrice = reservePrice;
/*     */   }
/*     */ 
/*     */   public String getAllowWatch()
/*     */   {
/* 469 */     return this.allowWatch;
/*     */   }
/*     */ 
/*     */   public void setAllowWatch(String allowWatch)
/*     */   {
/* 480 */     this.allowWatch = allowWatch;
/*     */   }
/*     */ 
/*     */   public String getWatchPassword()
/*     */   {
/* 491 */     return this.watchPassword;
/*     */   }
/*     */ 
/*     */   public void setWatchPassword(String watchPassword)
/*     */   {
/* 503 */     this.watchPassword = watchPassword;
/*     */   }
/*     */ 
/*     */   public Date getAuctionEndTime()
/*     */   {
/* 511 */     return this.auctionEndTime;
/*     */   }
/*     */ 
/*     */   public void setAuctionEndTime(Date auctionEndTime)
/*     */   {
/* 519 */     this.auctionEndTime = auctionEndTime;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreator()
/*     */   {
/* 526 */     return this.gmtCreator;
/*     */   }
/*     */ 
/*     */   public void setGmtCreator(Date gmtCreator)
/*     */   {
/* 533 */     this.gmtCreator = gmtCreator;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify()
/*     */   {
/* 540 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify)
/*     */   {
/* 547 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getOperator()
/*     */   {
/* 554 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator)
/*     */   {
/* 561 */     this.operator = operator;
/*     */   }
/*     */ 
/*     */   public Long getBidStartCountDownMilliSeconds() {
/* 565 */     return this.bidStartCountDownMilliSeconds;
/*     */   }
/*     */ 
/*     */   public void setBidStartCountDownMilliSeconds(Long bidStartCountDownMilliSeconds) {
/* 569 */     this.bidStartCountDownMilliSeconds = bidStartCountDownMilliSeconds;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionHall
 * JD-Core Version:    0.6.0
 */