/*     */ package com.hundsun.network.gates.genshan.biz.domain.auction;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.domain.BaseDomain;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class AuctionBidder extends BaseDomain
/*     */ {
/*     */   private static final long serialVersionUID = -7854036193514188183L;
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
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  71 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/*  75 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getProjectCode()
/*     */   {
/*  82 */     return this.projectCode;
/*     */   }
/*     */ 
/*     */   public void setProjectCode(String projectCode)
/*     */   {
/*  89 */     this.projectCode = projectCode;
/*     */   }
/*     */ 
/*     */   public String getBidderAccount()
/*     */   {
/*  96 */     return this.bidderAccount;
/*     */   }
/*     */ 
/*     */   public void setBidderAccount(String bidderAccount)
/*     */   {
/* 103 */     this.bidderAccount = bidderAccount;
/*     */   }
/*     */ 
/*     */   public String getIsPriority()
/*     */   {
/* 112 */     return this.isPriority;
/*     */   }
/*     */ 
/*     */   public void setIsPriority(String isPriority)
/*     */   {
/* 121 */     this.isPriority = isPriority;
/*     */   }
/*     */ 
/*     */   public String getBidderTrademark()
/*     */   {
/* 128 */     return this.bidderTrademark;
/*     */   }
/*     */ 
/*     */   public void setBidderTrademark(String bidderTrademark)
/*     */   {
/* 135 */     this.bidderTrademark = bidderTrademark;
/*     */   }
/*     */ 
/*     */   public String getBrokerAccount()
/*     */   {
/* 142 */     return this.brokerAccount;
/*     */   }
/*     */ 
/*     */   public void setBrokerAccount(String brokerAccount)
/*     */   {
/* 149 */     this.brokerAccount = brokerAccount;
/*     */   }
/*     */ 
/*     */   public String getBidStatus()
/*     */   {
/* 158 */     return this.bidStatus;
/*     */   }
/*     */ 
/*     */   public void setBidStatus(String bidStatus)
/*     */   {
/* 167 */     this.bidStatus = bidStatus;
/*     */   }
/*     */ 
/*     */   public String getServiceCode()
/*     */   {
/* 174 */     return this.serviceCode;
/*     */   }
/*     */ 
/*     */   public void setServiceCode(String serviceCode)
/*     */   {
/* 181 */     this.serviceCode = serviceCode;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate()
/*     */   {
/* 188 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate)
/*     */   {
/* 195 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify()
/*     */   {
/* 202 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify)
/*     */   {
/* 209 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getOperator()
/*     */   {
/* 216 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator)
/*     */   {
/* 223 */     this.operator = operator;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.auction.AuctionBidder
 * JD-Core Version:    0.6.0
 */