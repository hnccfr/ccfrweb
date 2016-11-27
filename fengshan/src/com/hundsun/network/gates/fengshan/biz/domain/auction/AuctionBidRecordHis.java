/*     */ package com.hundsun.network.gates.fengshan.biz.domain.auction;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumOperatorType;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class AuctionBidRecordHis
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
/*  74 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/*  78 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getBidderAccount()
/*     */   {
/*  85 */     return this.bidderAccount;
/*     */   }
/*     */ 
/*     */   public void setBidderAccount(String bidderAccount)
/*     */   {
/*  92 */     this.bidderAccount = bidderAccount;
/*     */   }
/*     */ 
/*     */   public String getBidderTrademark()
/*     */   {
/*  99 */     return this.bidderTrademark;
/*     */   }
/*     */ 
/*     */   public void setBidderTrademark(String bidderTrademark)
/*     */   {
/* 106 */     this.bidderTrademark = bidderTrademark;
/*     */   }
/*     */ 
/*     */   public String getProjectCode()
/*     */   {
/* 113 */     return this.projectCode;
/*     */   }
/*     */ 
/*     */   public void setProjectCode(String projectCode)
/*     */   {
/* 120 */     this.projectCode = projectCode;
/*     */   }
/*     */ 
/*     */   public Long getPrice()
/*     */   {
/* 127 */     return this.price;
/*     */   }
/*     */ 
/*     */   public void setPrice(Long price)
/*     */   {
/* 134 */     this.price = price;
/*     */   }
/*     */ 
/*     */   public String getBidOperatorAccount()
/*     */   {
/* 141 */     return this.bidOperatorAccount;
/*     */   }
/*     */ 
/*     */   public void setBidOperatorAccount(String bidOperatorAccount)
/*     */   {
/* 148 */     this.bidOperatorAccount = bidOperatorAccount;
/*     */   }
/*     */ 
/*     */   public String getUsePriority()
/*     */   {
/* 157 */     return this.usePriority;
/*     */   }
/*     */ 
/*     */   public void setUsePriority(String usePriority)
/*     */   {
/* 166 */     this.usePriority = usePriority;
/*     */   }
/*     */ 
/*     */   public String getIp()
/*     */   {
/* 173 */     return this.ip;
/*     */   }
/*     */ 
/*     */   public void setIp(String ip)
/*     */   {
/* 180 */     this.ip = ip;
/*     */   }
/*     */ 
/*     */   public String getStatus()
/*     */   {
/* 193 */     return this.status;
/*     */   }
/*     */ 
/*     */   public void setStatus(String status)
/*     */   {
/* 206 */     this.status = status;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate()
/*     */   {
/* 213 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate)
/*     */   {
/* 220 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify()
/*     */   {
/* 227 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify)
/*     */   {
/* 234 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getOperator()
/*     */   {
/* 241 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator)
/*     */   {
/* 248 */     this.operator = operator;
/*     */   }
/*     */ 
/*     */   public String getOperatorDesc() {
/* 252 */     EnumOperatorType typeEnum = EnumOperatorType.indexByValue(this.operator);
/* 253 */     if (null == typeEnum) {
/* 254 */       return this.operator;
/*     */     }
/* 256 */     return typeEnum.getName();
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.domain.auction.AuctionBidRecordHis
 * JD-Core Version:    0.6.0
 */