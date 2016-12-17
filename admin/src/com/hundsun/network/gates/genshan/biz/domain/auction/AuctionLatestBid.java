/*     */ package com.hundsun.network.gates.genshan.biz.domain.auction;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.domain.BaseDomain;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class AuctionLatestBid extends BaseDomain
/*     */ {
/*     */   private static final long serialVersionUID = 8431060564905904222L;
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
/*     */ 
/*     */   public Long getId()
/*     */   {
/* 109 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/* 113 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getProjectCode()
/*     */   {
/* 120 */     return this.projectCode;
/*     */   }
/*     */ 
/*     */   public void setProjectCode(String projectCode)
/*     */   {
/* 127 */     this.projectCode = projectCode;
/*     */   }
/*     */ 
/*     */   public String getBidderTrademark()
/*     */   {
/* 134 */     return this.bidderTrademark;
/*     */   }
/*     */ 
/*     */   public void setBidderTrademark(String bidderTrademark)
/*     */   {
/* 141 */     this.bidderTrademark = bidderTrademark;
/*     */   }
/*     */ 
/*     */   public Long getLatestBid()
/*     */   {
/* 148 */     return this.latestBid;
/*     */   }
/*     */ 
/*     */   public void setLatestBid(Long latestBid)
/*     */   {
/* 155 */     this.latestBid = latestBid;
/*     */   }
/*     */ 
/*     */   public String getIsPriority()
/*     */   {
/* 164 */     return this.isPriority;
/*     */   }
/*     */ 
/*     */   public void setIsPriority(String isPriority)
/*     */   {
/* 173 */     this.isPriority = isPriority;
/*     */   }
/*     */ 
/*     */   public Date getLatestBidTime()
/*     */   {
/* 180 */     return this.latestBidTime;
/*     */   }
/*     */ 
/*     */   public void setLatestBidTime(Date latestBidTime)
/*     */   {
/* 187 */     this.latestBidTime = latestBidTime;
/*     */   }
/*     */ 
/*     */   public Date getNextBidEndtime()
/*     */   {
/* 196 */     return this.nextBidEndtime;
/*     */   }
/*     */ 
/*     */   public void setNextBidEndtime(Date nextBidEndtime)
/*     */   {
/* 205 */     this.nextBidEndtime = nextBidEndtime;
/*     */   }
/*     */ 
/*     */   public String getLatestStatus()
/*     */   {
/* 240 */     return this.latestStatus;
/*     */   }
/*     */ 
/*     */   public void setLatestStatus(String latestStatus)
/*     */   {
/* 275 */     this.latestStatus = latestStatus;
/*     */   }
/*     */ 
/*     */   public Long getBidRate()
/*     */   {
/* 282 */     return this.bidRate;
/*     */   }
/*     */ 
/*     */   public void setBidRate(Long bidRate)
/*     */   {
/* 289 */     this.bidRate = bidRate;
/*     */   }
/*     */ 
/*     */   public String getLastBidTrademark()
/*     */   {
/* 296 */     return this.lastBidTrademark;
/*     */   }
/*     */ 
/*     */   public void setLastBidTrademark(String lastBidTrademark)
/*     */   {
/* 303 */     this.lastBidTrademark = lastBidTrademark;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate()
/*     */   {
/* 310 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate)
/*     */   {
/* 317 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify()
/*     */   {
/* 324 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify)
/*     */   {
/* 331 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getOperator()
/*     */   {
/* 338 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator)
/*     */   {
/* 345 */     this.operator = operator;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.auction.AuctionLatestBid
 * JD-Core Version:    0.6.0
 */