/*     */ package com.hundsun.network.gates.wulin.biz.domain.auction;
/*     */ 
/*     */ import java.util.Date;
/*     */ 
/*     */ public class AuctionHall
/*     */ {
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
/*     */ 
/*     */   public Long getId()
/*     */   {
/* 157 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/* 161 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getProjectCode()
/*     */   {
/* 168 */     return this.projectCode;
/*     */   }
/*     */ 
/*     */   public void setProjectCode(String projectCode)
/*     */   {
/* 175 */     this.projectCode = projectCode;
/*     */   }
/*     */ 
/*     */   public String getHaveAuctioneer()
/*     */   {
/* 184 */     return this.haveAuctioneer;
/*     */   }
/*     */ 
/*     */   public void setHaveAuctioneer(String haveAuctioneer)
/*     */   {
/* 193 */     this.haveAuctioneer = haveAuctioneer;
/*     */   }
/*     */ 
/*     */   public String getAuctioneerAccount()
/*     */   {
/* 200 */     return this.auctioneerAccount;
/*     */   }
/*     */ 
/*     */   public void setAuctioneerAccount(String auctioneerAccount)
/*     */   {
/* 207 */     this.auctioneerAccount = auctioneerAccount;
/*     */   }
/*     */ 
/*     */   public Long getBidStartPrice()
/*     */   {
/* 216 */     return this.bidStartPrice;
/*     */   }
/*     */ 
/*     */   public void setBidStartPrice(Long bidStartPrice)
/*     */   {
/* 225 */     this.bidStartPrice = bidStartPrice;
/*     */   }
/*     */ 
/*     */   public Short getPriceDirection()
/*     */   {
/* 236 */     return this.priceDirection;
/*     */   }
/*     */ 
/*     */   public void setPriceDirection(Short priceDirection)
/*     */   {
/* 247 */     this.priceDirection = priceDirection;
/*     */   }
/*     */ 
/*     */   public String getSupportPriority()
/*     */   {
/* 258 */     return this.supportPriority;
/*     */   }
/*     */ 
/*     */   public void setSupportPriority(String supportPriority)
/*     */   {
/* 269 */     this.supportPriority = supportPriority;
/*     */   }
/*     */ 
/*     */   public Date getBidStartTime()
/*     */   {
/* 278 */     return this.bidStartTime;
/*     */   }
/*     */ 
/*     */   public void setBidStartTime(Date bidStartTime)
/*     */   {
/* 287 */     this.bidStartTime = bidStartTime;
/*     */   }
/*     */ 
/*     */   public Double getBidLimitedPeriod()
/*     */   {
/* 298 */     return this.bidLimitedPeriod;
/*     */   }
/*     */ 
/*     */   public void setBidLimitedPeriod(Double bidLimitedPeriod)
/*     */   {
/* 309 */     this.bidLimitedPeriod = bidLimitedPeriod;
/*     */   }
/*     */ 
/*     */   public Integer getFirstWaitTime()
/*     */   {
/* 316 */     return this.firstWaitTime;
/*     */   }
/*     */ 
/*     */   public void setFirstWaitTime(Integer firstWaitTime)
/*     */   {
/* 323 */     this.firstWaitTime = firstWaitTime;
/*     */   }
/*     */ 
/*     */   public String getAuctionType()
/*     */   {
/* 330 */     return this.auctionType;
/*     */   }
/*     */ 
/*     */   public void setAuctionType(String auctionType)
/*     */   {
/* 337 */     this.auctionType = auctionType;
/*     */   }
/*     */ 
/*     */   public Date getComFreeStarttime()
/*     */   {
/* 344 */     return this.comFreeStarttime;
/*     */   }
/*     */ 
/*     */   public void setComFreeStarttime(Date comFreeStarttime)
/*     */   {
/* 351 */     this.comFreeStarttime = comFreeStarttime;
/*     */   }
/*     */ 
/*     */   public Date getComFreeEndtime()
/*     */   {
/* 358 */     return this.comFreeEndtime;
/*     */   }
/*     */ 
/*     */   public void setComFreeEndtime(Date comFreeEndtime)
/*     */   {
/* 365 */     this.comFreeEndtime = comFreeEndtime;
/*     */   }
/*     */ 
/*     */   public String getValuationUnit()
/*     */   {
/* 372 */     return this.valuationUnit;
/*     */   }
/*     */ 
/*     */   public void setValuationUnit(String valuationUnit)
/*     */   {
/* 379 */     this.valuationUnit = valuationUnit;
/*     */   }
/*     */ 
/*     */   public Integer getPriorityNum()
/*     */   {
/* 386 */     return this.priorityNum;
/*     */   }
/*     */ 
/*     */   public void setPriorityNum(Integer priorityNum)
/*     */   {
/* 393 */     this.priorityNum = priorityNum;
/*     */   }
/*     */ 
/*     */   public String getHaveReservePrice()
/*     */   {
/* 404 */     return this.haveReservePrice;
/*     */   }
/*     */ 
/*     */   public void setHaveReservePrice(String haveReservePrice)
/*     */   {
/* 415 */     this.haveReservePrice = haveReservePrice;
/*     */   }
/*     */ 
/*     */   public Long getReservePrice()
/*     */   {
/* 430 */     return this.reservePrice;
/*     */   }
/*     */ 
/*     */   public void setReservePrice(Long reservePrice)
/*     */   {
/* 445 */     this.reservePrice = reservePrice;
/*     */   }
/*     */ 
/*     */   public String getAllowWatch()
/*     */   {
/* 456 */     return this.allowWatch;
/*     */   }
/*     */ 
/*     */   public void setAllowWatch(String allowWatch)
/*     */   {
/* 467 */     this.allowWatch = allowWatch;
/*     */   }
/*     */ 
/*     */   public String getWatchPassword()
/*     */   {
/* 478 */     return this.watchPassword;
/*     */   }
/*     */ 
/*     */   public void setWatchPassword(String watchPassword)
/*     */   {
/* 489 */     this.watchPassword = watchPassword;
/*     */   }
/*     */ 
/*     */   public Date getAuctionEndTime()
/*     */   {
/* 496 */     return this.auctionEndTime;
/*     */   }
/*     */ 
/*     */   public void setAuctionEndTime(Date auctionEndTime)
/*     */   {
/* 503 */     this.auctionEndTime = auctionEndTime;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreator()
/*     */   {
/* 510 */     return this.gmtCreator;
/*     */   }
/*     */ 
/*     */   public void setGmtCreator(Date gmtCreator)
/*     */   {
/* 517 */     this.gmtCreator = gmtCreator;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify()
/*     */   {
/* 524 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify)
/*     */   {
/* 531 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getOperator()
/*     */   {
/* 538 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator)
/*     */   {
/* 545 */     this.operator = operator;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.domain.auction.AuctionHall
 * JD-Core Version:    0.6.0
 */