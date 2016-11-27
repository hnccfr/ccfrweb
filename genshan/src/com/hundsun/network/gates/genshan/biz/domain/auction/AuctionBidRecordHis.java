/*     */ package com.hundsun.network.gates.genshan.biz.domain.auction;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.domain.BaseDomain;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class AuctionBidRecordHis extends BaseDomain
/*     */ {
/*     */   private static final long serialVersionUID = -4521008730128410927L;
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
/*  80 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/*  84 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getBidderAccount()
/*     */   {
/*  91 */     return this.bidderAccount;
/*     */   }
/*     */ 
/*     */   public void setBidderAccount(String bidderAccount)
/*     */   {
/*  98 */     this.bidderAccount = bidderAccount;
/*     */   }
/*     */ 
/*     */   public String getBidderTrademark()
/*     */   {
/* 105 */     return this.bidderTrademark;
/*     */   }
/*     */ 
/*     */   public void setBidderTrademark(String bidderTrademark)
/*     */   {
/* 112 */     this.bidderTrademark = bidderTrademark;
/*     */   }
/*     */ 
/*     */   public String getProjectCode()
/*     */   {
/* 119 */     return this.projectCode;
/*     */   }
/*     */ 
/*     */   public void setProjectCode(String projectCode)
/*     */   {
/* 126 */     this.projectCode = projectCode;
/*     */   }
/*     */ 
/*     */   public Long getPrice()
/*     */   {
/* 133 */     return this.price;
/*     */   }
/*     */ 
/*     */   public void setPrice(Long price)
/*     */   {
/* 140 */     this.price = price;
/*     */   }
/*     */ 
/*     */   public String getBidOperatorAccount()
/*     */   {
/* 147 */     return this.bidOperatorAccount;
/*     */   }
/*     */ 
/*     */   public void setBidOperatorAccount(String bidOperatorAccount)
/*     */   {
/* 154 */     this.bidOperatorAccount = bidOperatorAccount;
/*     */   }
/*     */ 
/*     */   public String getUsePriority()
/*     */   {
/* 163 */     return this.usePriority;
/*     */   }
/*     */ 
/*     */   public void setUsePriority(String usePriority)
/*     */   {
/* 172 */     this.usePriority = usePriority;
/*     */   }
/*     */ 
/*     */   public String getIp()
/*     */   {
/* 179 */     return this.ip;
/*     */   }
/*     */ 
/*     */   public void setIp(String ip)
/*     */   {
/* 186 */     this.ip = ip;
/*     */   }
/*     */ 
/*     */   public String getStatus()
/*     */   {
/* 199 */     return this.status;
/*     */   }
/*     */ 
/*     */   public void setStatus(String status)
/*     */   {
/* 212 */     this.status = status;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate()
/*     */   {
/* 219 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate)
/*     */   {
/* 226 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify()
/*     */   {
/* 233 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify)
/*     */   {
/* 240 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getOperator()
/*     */   {
/* 247 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator)
/*     */   {
/* 254 */     this.operator = operator;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.auction.AuctionBidRecordHis
 * JD-Core Version:    0.6.0
 */