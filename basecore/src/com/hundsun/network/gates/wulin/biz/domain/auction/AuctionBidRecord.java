/*     */ package com.hundsun.network.gates.wulin.biz.domain.auction;
/*     */ 
/*     */ import java.util.Date;
/*     */ 
/*     */ public class AuctionBidRecord
/*     */ {
/*     */   private Long id;
/*     */   private String bidderAccount;
/*     */   private String bidderTrademark;
/*     */   private String projectCode;
/*     */   private Long price;
/*     */   private String bidOperatorAccount;
/*     */   private String usePriority;
/*     */   private String ip;
/*     */   private String status;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */   private String operator;
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  72 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/*  76 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getBidderAccount()
/*     */   {
/*  83 */     return this.bidderAccount;
/*     */   }
/*     */ 
/*     */   public void setBidderAccount(String bidderAccount)
/*     */   {
/*  90 */     this.bidderAccount = bidderAccount;
/*     */   }
/*     */ 
/*     */   public String getBidderTrademark()
/*     */   {
/*  97 */     return this.bidderTrademark;
/*     */   }
/*     */ 
/*     */   public void setBidderTrademark(String bidderTrademark)
/*     */   {
/* 104 */     this.bidderTrademark = bidderTrademark;
/*     */   }
/*     */ 
/*     */   public String getProjectCode()
/*     */   {
/* 111 */     return this.projectCode;
/*     */   }
/*     */ 
/*     */   public void setProjectCode(String projectCode)
/*     */   {
/* 118 */     this.projectCode = projectCode;
/*     */   }
/*     */ 
/*     */   public Long getPrice()
/*     */   {
/* 125 */     return this.price;
/*     */   }
/*     */ 
/*     */   public void setPrice(Long price)
/*     */   {
/* 132 */     this.price = price;
/*     */   }
/*     */ 
/*     */   public String getBidOperatorAccount()
/*     */   {
/* 139 */     return this.bidOperatorAccount;
/*     */   }
/*     */ 
/*     */   public void setBidOperatorAccount(String bidOperatorAccount)
/*     */   {
/* 146 */     this.bidOperatorAccount = bidOperatorAccount;
/*     */   }
/*     */ 
/*     */   public String getUsePriority()
/*     */   {
/* 155 */     return this.usePriority;
/*     */   }
/*     */ 
/*     */   public void setUsePriority(String usePriority)
/*     */   {
/* 164 */     this.usePriority = usePriority;
/*     */   }
/*     */ 
/*     */   public String getIp()
/*     */   {
/* 171 */     return this.ip;
/*     */   }
/*     */ 
/*     */   public void setIp(String ip)
/*     */   {
/* 178 */     this.ip = ip;
/*     */   }
/*     */ 
/*     */   public String getStatus()
/*     */   {
/* 191 */     return this.status;
/*     */   }
/*     */ 
/*     */   public void setStatus(String status)
/*     */   {
/* 204 */     this.status = status;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate()
/*     */   {
/* 211 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate)
/*     */   {
/* 218 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify()
/*     */   {
/* 225 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify)
/*     */   {
/* 232 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getOperator()
/*     */   {
/* 239 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator)
/*     */   {
/* 246 */     this.operator = operator;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.domain.auction.AuctionBidRecord
 * JD-Core Version:    0.6.0
 */