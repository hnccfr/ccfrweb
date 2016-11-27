/*     */ package com.hundsun.network.gates.wangjiang.biz.domain.auction;
/*     */ 
/*     */ import com.hundsun.network.gates.wangjiang.biz.domain.BaseDomain;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class AuctionLatestBid extends BaseDomain
/*     */ {
/*     */   private static final long serialVersionUID = -2797736261241977697L;
/*     */   private Long id;
/*     */   private String projectCode;
/*     */   private String bidderTrademark;
/*     */   private Long latestBid;
/*     */   private String isPriority;
/*     */   private Date latestBidTime;
/*     */   private Date nextBidEndtime;
/*     */   private String latestStatus;
/*     */   private Long bidRate;
/*     */   private String lastBidTrademark;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */   private String operator;
/*     */   private Long nextBidInterval;
/*     */ 
/*     */   public Long getId()
/*     */   {
/* 114 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/* 118 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getProjectCode()
/*     */   {
/* 125 */     return this.projectCode;
/*     */   }
/*     */ 
/*     */   public void setProjectCode(String projectCode)
/*     */   {
/* 132 */     this.projectCode = projectCode;
/*     */   }
/*     */ 
/*     */   public String getBidderTrademark()
/*     */   {
/* 139 */     return this.bidderTrademark;
/*     */   }
/*     */ 
/*     */   public void setBidderTrademark(String bidderTrademark)
/*     */   {
/* 146 */     this.bidderTrademark = bidderTrademark;
/*     */   }
/*     */ 
/*     */   public Long getLatestBid()
/*     */   {
/* 153 */     return this.latestBid;
/*     */   }
/*     */ 
/*     */   public void setLatestBid(Long latestBid)
/*     */   {
/* 160 */     this.latestBid = latestBid;
/*     */   }
/*     */ 
/*     */   public String getIsPriority()
/*     */   {
/* 169 */     return this.isPriority;
/*     */   }
/*     */ 
/*     */   public void setIsPriority(String isPriority)
/*     */   {
/* 178 */     this.isPriority = isPriority;
/*     */   }
/*     */ 
/*     */   public Date getLatestBidTime()
/*     */   {
/* 185 */     return this.latestBidTime;
/*     */   }
/*     */ 
/*     */   public void setLatestBidTime(Date latestBidTime)
/*     */   {
/* 192 */     this.latestBidTime = latestBidTime;
/*     */   }
/*     */ 
/*     */   public Date getNextBidEndtime()
/*     */   {
/* 201 */     return this.nextBidEndtime;
/*     */   }
/*     */ 
/*     */   public void setNextBidEndtime(Date nextBidEndtime)
/*     */   {
/* 210 */     this.nextBidEndtime = nextBidEndtime;
/*     */   }
/*     */ 
/*     */   public String getLatestStatus()
/*     */   {
/* 245 */     return this.latestStatus;
/*     */   }
/*     */ 
/*     */   public void setLatestStatus(String latestStatus)
/*     */   {
/* 280 */     this.latestStatus = latestStatus;
/*     */   }
/*     */ 
/*     */   public Long getBidRate()
/*     */   {
/* 287 */     return this.bidRate;
/*     */   }
/*     */ 
/*     */   public void setBidRate(Long bidRate)
/*     */   {
/* 294 */     this.bidRate = bidRate;
/*     */   }
/*     */ 
/*     */   public String getLastBidTrademark()
/*     */   {
/* 301 */     return this.lastBidTrademark;
/*     */   }
/*     */ 
/*     */   public void setLastBidTrademark(String lastBidTrademark)
/*     */   {
/* 308 */     this.lastBidTrademark = lastBidTrademark;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate()
/*     */   {
/* 315 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate)
/*     */   {
/* 322 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify()
/*     */   {
/* 329 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify)
/*     */   {
/* 336 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getOperator()
/*     */   {
/* 343 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator)
/*     */   {
/* 350 */     this.operator = operator;
/*     */   }
/*     */ 
/*     */   public Long getNextBidInterval() {
/* 354 */     return this.nextBidInterval;
/*     */   }
/*     */ 
/*     */   public void setNextBidInterval(Long nextBidInterval) {
/* 358 */     this.nextBidInterval = nextBidInterval;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wangjiang.biz.domain.auction.AuctionLatestBid
 * JD-Core Version:    0.6.0
 */