/*     */ package com.hundsun.network.gates.fengshan.biz.domain.auction;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumOperatorType;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class AuctionFreeBid
/*     */ {
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
/*  83 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/*  87 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getBidderAccount()
/*     */   {
/*  94 */     return this.bidderAccount;
/*     */   }
/*     */ 
/*     */   public void setBidderAccount(String bidderAccount)
/*     */   {
/* 101 */     this.bidderAccount = bidderAccount;
/*     */   }
/*     */ 
/*     */   public String getBidderTrademark()
/*     */   {
/* 108 */     return this.bidderTrademark;
/*     */   }
/*     */ 
/*     */   public void setBidderTrademark(String bidderTrademark)
/*     */   {
/* 115 */     this.bidderTrademark = bidderTrademark;
/*     */   }
/*     */ 
/*     */   public String getProjectCode()
/*     */   {
/* 122 */     return this.projectCode;
/*     */   }
/*     */ 
/*     */   public void setProjectCode(String projectCode)
/*     */   {
/* 129 */     this.projectCode = projectCode;
/*     */   }
/*     */ 
/*     */   public Long getPrice()
/*     */   {
/* 136 */     return this.price;
/*     */   }
/*     */ 
/*     */   public void setPrice(Long price)
/*     */   {
/* 143 */     this.price = price;
/*     */   }
/*     */ 
/*     */   public String getBidOperatorAccount()
/*     */   {
/* 150 */     return this.bidOperatorAccount;
/*     */   }
/*     */ 
/*     */   public void setBidOperatorAccount(String bidOperatorAccount)
/*     */   {
/* 157 */     this.bidOperatorAccount = bidOperatorAccount;
/*     */   }
/*     */ 
/*     */   public String getIp()
/*     */   {
/* 164 */     return this.ip;
/*     */   }
/*     */ 
/*     */   public void setIp(String ip)
/*     */   {
/* 171 */     this.ip = ip;
/*     */   }
/*     */ 
/*     */   public String getStatus()
/*     */   {
/* 184 */     return this.status;
/*     */   }
/*     */ 
/*     */   public void setStatus(String status)
/*     */   {
/* 197 */     this.status = status;
/*     */   }
/*     */ 
/*     */   public String getCheckStatus()
/*     */   {
/* 210 */     return this.checkStatus;
/*     */   }
/*     */ 
/*     */   public void setCheckStatus(String checkStatus)
/*     */   {
/* 223 */     this.checkStatus = checkStatus;
/*     */   }
/*     */ 
/*     */   public String getCheckRemark()
/*     */   {
/* 230 */     return this.checkRemark;
/*     */   }
/*     */ 
/*     */   public void setCheckRemark(String checkRemark)
/*     */   {
/* 237 */     this.checkRemark = checkRemark;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate()
/*     */   {
/* 244 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate)
/*     */   {
/* 251 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify()
/*     */   {
/* 258 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify)
/*     */   {
/* 265 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getOperator()
/*     */   {
/* 272 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator)
/*     */   {
/* 279 */     this.operator = operator;
/*     */   }
/*     */ 
/*     */   public String getOperatorDesc() {
/* 283 */     EnumOperatorType typeEnum = EnumOperatorType.indexByValue(this.operator);
/* 284 */     if (null == typeEnum) {
/* 285 */       return this.operator;
/*     */     }
/* 287 */     return typeEnum.getName();
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.domain.auction.AuctionFreeBid
 * JD-Core Version:    0.6.0
 */