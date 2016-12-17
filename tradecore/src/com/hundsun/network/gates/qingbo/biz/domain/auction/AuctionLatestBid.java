/*     */ package com.hundsun.network.gates.qingbo.biz.domain.auction;
/*     */ 
/*     */ import com.hundsun.network.gates.qingbo.biz.domain.BaseDomain;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class AuctionLatestBid extends BaseDomain
/*     */ {
/*     */   private static final long serialVersionUID = -4337013767078475037L;
/*     */   private Long id;
/*     */   private String projectCode;
/*     */   private String bidderTrademark;
/*     */   private Long latestBid;
/*     */   private Long priceDirection;
/*     */   private String isPriority;
/*     */   private Date latestBidTime;
/*     */   private Date nextBidEndtime;
/*     */   private Long bidLimitedPeriod;
/*     */   private String latestStatus;
/*     */   private String beforeStatus;
/*     */   private Long bidRate;
/*     */   private String lastBidTrademark;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */   private String operator;
/*     */   private Long nextBidInterval;
/*     */ 
/*     */   public Long getId()
/*     */   {
/* 129 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/* 133 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getProjectCode()
/*     */   {
/* 140 */     return this.projectCode;
/*     */   }
/*     */ 
/*     */   public void setProjectCode(String projectCode)
/*     */   {
/* 147 */     this.projectCode = projectCode;
/*     */   }
/*     */ 
/*     */   public String getBidderTrademark()
/*     */   {
/* 154 */     return this.bidderTrademark;
/*     */   }
/*     */ 
/*     */   public void setBidderTrademark(String bidderTrademark)
/*     */   {
/* 161 */     this.bidderTrademark = bidderTrademark;
/*     */   }
/*     */ 
/*     */   public Long getLatestBid()
/*     */   {
/* 168 */     return this.latestBid;
/*     */   }
/*     */ 
/*     */   public void setLatestBid(Long latestBid)
/*     */   {
/* 175 */     this.latestBid = latestBid;
/*     */   }
/*     */ 
/*     */   public String getIsPriority()
/*     */   {
/* 184 */     return this.isPriority;
/*     */   }
/*     */ 
/*     */   public void setIsPriority(String isPriority)
/*     */   {
/* 193 */     this.isPriority = isPriority;
/*     */   }
/*     */ 
/*     */   public Date getLatestBidTime()
/*     */   {
/* 200 */     return this.latestBidTime;
/*     */   }
/*     */ 
/*     */   public void setLatestBidTime(Date latestBidTime)
/*     */   {
/* 207 */     this.latestBidTime = latestBidTime;
/*     */   }
/*     */ 
/*     */   public Date getNextBidEndtime()
/*     */   {
/* 216 */     return this.nextBidEndtime;
/*     */   }
/*     */ 
/*     */   public void setNextBidEndtime(Date nextBidEndtime)
/*     */   {
/* 225 */     this.nextBidEndtime = nextBidEndtime;
/*     */   }
/*     */ 
/*     */   public String getLatestStatus()
/*     */   {
/* 260 */     return this.latestStatus;
/*     */   }
/*     */ 
/*     */   public void setLatestStatus(String latestStatus)
/*     */   {
/* 295 */     this.latestStatus = latestStatus;
/*     */   }
/*     */ 
/*     */   public String getBeforeStatus() {
/* 299 */     return this.beforeStatus;
/*     */   }
/*     */ 
/*     */   public void setBeforeStatus(String beforeStatus) {
/* 303 */     this.beforeStatus = beforeStatus;
/*     */   }
/*     */ 
/*     */   public Long getBidRate()
/*     */   {
/* 310 */     return this.bidRate;
/*     */   }
/*     */ 
/*     */   public void setBidRate(Long bidRate)
/*     */   {
/* 317 */     this.bidRate = bidRate;
/*     */   }
/*     */ 
/*     */   public String getLastBidTrademark()
/*     */   {
/* 324 */     return this.lastBidTrademark;
/*     */   }
/*     */ 
/*     */   public void setLastBidTrademark(String lastBidTrademark)
/*     */   {
/* 331 */     this.lastBidTrademark = lastBidTrademark;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate()
/*     */   {
/* 338 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate)
/*     */   {
/* 345 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify()
/*     */   {
/* 352 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify)
/*     */   {
/* 359 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getOperator()
/*     */   {
/* 366 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator)
/*     */   {
/* 373 */     this.operator = operator;
/*     */   }
/*     */ 
/*     */   public Long getPriceDirection() {
/* 377 */     return this.priceDirection;
/*     */   }
/*     */ 
/*     */   public void setPriceDirection(Long priceDirection) {
/* 381 */     this.priceDirection = priceDirection;
/*     */   }
/*     */ 
/*     */   public Long getBidLimitedPeriod() {
/* 385 */     return this.bidLimitedPeriod;
/*     */   }
/*     */ 
/*     */   public void setBidLimitedPeriod(Long bidLimitedPeriod) {
/* 389 */     this.bidLimitedPeriod = bidLimitedPeriod;
/*     */   }
/*     */ 
/*     */   public Long getNextBidInterval() {
/* 393 */     return this.nextBidInterval;
/*     */   }
/*     */ 
/*     */   public void setNextBidInterval(Long nextBidInterval) {
/* 397 */     this.nextBidInterval = nextBidInterval;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionLatestBid
 * JD-Core Version:    0.6.0
 */