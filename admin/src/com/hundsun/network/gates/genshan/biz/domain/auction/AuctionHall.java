/*     */ package com.hundsun.network.gates.genshan.biz.domain.auction;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.domain.BaseDomain;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class AuctionHall extends BaseDomain
/*     */ {
/*     */   private static final long serialVersionUID = 5896488636485255593L;
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
/* 165 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/* 169 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getProjectCode()
/*     */   {
/* 176 */     return this.projectCode;
/*     */   }
/*     */ 
/*     */   public void setProjectCode(String projectCode)
/*     */   {
/* 183 */     this.projectCode = projectCode;
/*     */   }
/*     */ 
/*     */   public String getHaveAuctioneer()
/*     */   {
/* 192 */     return this.haveAuctioneer;
/*     */   }
/*     */ 
/*     */   public void setHaveAuctioneer(String haveAuctioneer)
/*     */   {
/* 201 */     this.haveAuctioneer = haveAuctioneer;
/*     */   }
/*     */ 
/*     */   public String getAuctioneerAccount()
/*     */   {
/* 208 */     return this.auctioneerAccount;
/*     */   }
/*     */ 
/*     */   public void setAuctioneerAccount(String auctioneerAccount)
/*     */   {
/* 215 */     this.auctioneerAccount = auctioneerAccount;
/*     */   }
/*     */ 
/*     */   public Long getBidStartPrice()
/*     */   {
/* 224 */     return this.bidStartPrice;
/*     */   }
/*     */ 
/*     */   public void setBidStartPrice(Long bidStartPrice)
/*     */   {
/* 233 */     this.bidStartPrice = bidStartPrice;
/*     */   }
/*     */ 
/*     */   public Short getPriceDirection()
/*     */   {
/* 244 */     return this.priceDirection;
/*     */   }
/*     */ 
/*     */   public void setPriceDirection(Short priceDirection)
/*     */   {
/* 255 */     this.priceDirection = priceDirection;
/*     */   }
/*     */ 
/*     */   public String getSupportPriority()
/*     */   {
/* 266 */     return this.supportPriority;
/*     */   }
/*     */ 
/*     */   public void setSupportPriority(String supportPriority)
/*     */   {
/* 277 */     this.supportPriority = supportPriority;
/*     */   }
/*     */ 
/*     */   public Date getBidStartTime()
/*     */   {
/* 286 */     return this.bidStartTime;
/*     */   }
/*     */ 
/*     */   public void setBidStartTime(Date bidStartTime)
/*     */   {
/* 295 */     this.bidStartTime = bidStartTime;
/*     */   }
/*     */ 
/*     */   public Double getBidLimitedPeriod()
/*     */   {
/* 306 */     return this.bidLimitedPeriod;
/*     */   }
/*     */ 
/*     */   public void setBidLimitedPeriod(Double bidLimitedPeriod)
/*     */   {
/* 317 */     this.bidLimitedPeriod = bidLimitedPeriod;
/*     */   }
/*     */ 
/*     */   public Integer getFirstWaitTime()
/*     */   {
/* 324 */     return this.firstWaitTime;
/*     */   }
/*     */ 
/*     */   public void setFirstWaitTime(Integer firstWaitTime)
/*     */   {
/* 331 */     this.firstWaitTime = firstWaitTime;
/*     */   }
/*     */ 
/*     */   public String getAuctionType()
/*     */   {
/* 338 */     return this.auctionType;
/*     */   }
/*     */ 
/*     */   public void setAuctionType(String auctionType)
/*     */   {
/* 345 */     this.auctionType = auctionType;
/*     */   }
/*     */ 
/*     */   public Date getComFreeStarttime()
/*     */   {
/* 352 */     return this.comFreeStarttime;
/*     */   }
/*     */ 
/*     */   public void setComFreeStarttime(Date comFreeStarttime)
/*     */   {
/* 359 */     this.comFreeStarttime = comFreeStarttime;
/*     */   }
/*     */ 
/*     */   public Date getComFreeEndtime()
/*     */   {
/* 366 */     return this.comFreeEndtime;
/*     */   }
/*     */ 
/*     */   public void setComFreeEndtime(Date comFreeEndtime)
/*     */   {
/* 373 */     this.comFreeEndtime = comFreeEndtime;
/*     */   }
/*     */ 
/*     */   public String getValuationUnit()
/*     */   {
/* 380 */     return this.valuationUnit;
/*     */   }
/*     */ 
/*     */   public void setValuationUnit(String valuationUnit)
/*     */   {
/* 387 */     this.valuationUnit = valuationUnit;
/*     */   }
/*     */ 
/*     */   public Integer getPriorityNum()
/*     */   {
/* 394 */     return this.priorityNum;
/*     */   }
/*     */ 
/*     */   public void setPriorityNum(Integer priorityNum)
/*     */   {
/* 401 */     this.priorityNum = priorityNum;
/*     */   }
/*     */ 
/*     */   public String getHaveReservePrice()
/*     */   {
/* 412 */     return this.haveReservePrice;
/*     */   }
/*     */ 
/*     */   public void setHaveReservePrice(String haveReservePrice)
/*     */   {
/* 423 */     this.haveReservePrice = haveReservePrice;
/*     */   }
/*     */ 
/*     */   public Long getReservePrice()
/*     */   {
/* 438 */     return this.reservePrice;
/*     */   }
/*     */ 
/*     */   public void setReservePrice(Long reservePrice)
/*     */   {
/* 453 */     this.reservePrice = reservePrice;
/*     */   }
/*     */ 
/*     */   public String getAllowWatch()
/*     */   {
/* 464 */     return this.allowWatch;
/*     */   }
/*     */ 
/*     */   public void setAllowWatch(String allowWatch)
/*     */   {
/* 475 */     this.allowWatch = allowWatch;
/*     */   }
/*     */ 
/*     */   public String getWatchPassword()
/*     */   {
/* 486 */     return this.watchPassword;
/*     */   }
/*     */ 
/*     */   public void setWatchPassword(String watchPassword)
/*     */   {
/* 498 */     this.watchPassword = watchPassword;
/*     */   }
/*     */ 
/*     */   public Date getAuctionEndTime()
/*     */   {
/* 506 */     return this.auctionEndTime;
/*     */   }
/*     */ 
/*     */   public void setAuctionEndTime(Date auctionEndTime)
/*     */   {
/* 514 */     this.auctionEndTime = auctionEndTime;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreator()
/*     */   {
/* 521 */     return this.gmtCreator;
/*     */   }
/*     */ 
/*     */   public void setGmtCreator(Date gmtCreator)
/*     */   {
/* 528 */     this.gmtCreator = gmtCreator;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify()
/*     */   {
/* 535 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify)
/*     */   {
/* 542 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getOperator()
/*     */   {
/* 549 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator)
/*     */   {
/* 556 */     this.operator = operator;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.auction.AuctionHall
 * JD-Core Version:    0.6.0
 */