/*     */ package com.hundsun.network.gates.qingbo.biz.domain.auction;
/*     */ 
/*     */ import com.hundsun.network.gates.qingbo.biz.domain.BaseDomain;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class AuctionFreeBid extends BaseDomain
/*     */ {
/*     */   private static final long serialVersionUID = -5012125789409511764L;
/*     */   private Long id;
/*     */   private String bidderAccount;
/*     */   private String bidderTrademark;
/*     */   private String projectCode;
/*     */   private Long price;
/*     */   private String bidOperatorAccount;
/*     */   private String ip;
/*     */   private String status;
/*     */   private String checkStatus;
/*     */   private String checkRemark;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */   private String operator;
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  89 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/*  93 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getBidderAccount()
/*     */   {
/* 100 */     return this.bidderAccount;
/*     */   }
/*     */ 
/*     */   public void setBidderAccount(String bidderAccount)
/*     */   {
/* 107 */     this.bidderAccount = bidderAccount;
/*     */   }
/*     */ 
/*     */   public String getBidderTrademark()
/*     */   {
/* 114 */     return this.bidderTrademark;
/*     */   }
/*     */ 
/*     */   public void setBidderTrademark(String bidderTrademark)
/*     */   {
/* 121 */     this.bidderTrademark = bidderTrademark;
/*     */   }
/*     */ 
/*     */   public String getProjectCode()
/*     */   {
/* 128 */     return this.projectCode;
/*     */   }
/*     */ 
/*     */   public void setProjectCode(String projectCode)
/*     */   {
/* 135 */     this.projectCode = projectCode;
/*     */   }
/*     */ 
/*     */   public Long getPrice()
/*     */   {
/* 142 */     return this.price;
/*     */   }
/*     */ 
/*     */   public void setPrice(Long price)
/*     */   {
/* 149 */     this.price = price;
/*     */   }
/*     */ 
/*     */   public String getBidOperatorAccount()
/*     */   {
/* 156 */     return this.bidOperatorAccount;
/*     */   }
/*     */ 
/*     */   public void setBidOperatorAccount(String bidOperatorAccount)
/*     */   {
/* 163 */     this.bidOperatorAccount = bidOperatorAccount;
/*     */   }
/*     */ 
/*     */   public String getIp()
/*     */   {
/* 170 */     return this.ip;
/*     */   }
/*     */ 
/*     */   public void setIp(String ip)
/*     */   {
/* 177 */     this.ip = ip;
/*     */   }
/*     */ 
/*     */   public String getStatus()
/*     */   {
/* 190 */     return this.status;
/*     */   }
/*     */ 
/*     */   public void setStatus(String status)
/*     */   {
/* 203 */     this.status = status;
/*     */   }
/*     */ 
/*     */   public String getCheckStatus()
/*     */   {
/* 216 */     return this.checkStatus;
/*     */   }
/*     */ 
/*     */   public void setCheckStatus(String checkStatus)
/*     */   {
/* 229 */     this.checkStatus = checkStatus;
/*     */   }
/*     */ 
/*     */   public String getCheckRemark()
/*     */   {
/* 236 */     return this.checkRemark;
/*     */   }
/*     */ 
/*     */   public void setCheckRemark(String checkRemark)
/*     */   {
/* 243 */     this.checkRemark = checkRemark;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate()
/*     */   {
/* 250 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate)
/*     */   {
/* 257 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify()
/*     */   {
/* 264 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify)
/*     */   {
/* 271 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getOperator()
/*     */   {
/* 278 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator)
/*     */   {
/* 285 */     this.operator = operator;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionFreeBid
 * JD-Core Version:    0.6.0
 */