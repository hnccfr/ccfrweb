/*     */ package com.hundsun.network.gates.genshan.biz.domain.fund;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTransCode;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class FundAccountLog
/*     */ {
/*     */   private String tradeDate;
/*     */   private String userAccount;
/*     */   private String fundAccount;
/*     */   private String transCode;
/*     */   private Long transAmount;
/*     */   private Long postAmount;
/*     */   private String bizNo;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */ 
/*     */   public String getTradeDate()
/*     */   {
/*  59 */     return this.tradeDate;
/*     */   }
/*     */ 
/*     */   public void setTradeDate(String tradeDate) {
/*  63 */     this.tradeDate = tradeDate;
/*     */   }
/*     */ 
/*     */   public String getFundAccount() {
/*  67 */     return this.fundAccount;
/*     */   }
/*     */ 
/*     */   public void setFundAccount(String fundAccount) {
/*  71 */     this.fundAccount = fundAccount;
/*     */   }
/*     */ 
/*     */   public String getTransCode() {
/*  75 */     return this.transCode;
/*     */   }
/*     */ 
/*     */   public void setTransCode(String transCode) {
/*  79 */     this.transCode = transCode;
/*     */   }
/*     */ 
/*     */   public Long getTransAmount() {
/*  83 */     return this.transAmount;
/*     */   }
/*     */ 
/*     */   public void setTransAmount(Long transAmount) {
/*  87 */     this.transAmount = transAmount;
/*     */   }
/*     */ 
/*     */   public Long getPostAmount() {
/*  91 */     return this.postAmount;
/*     */   }
/*     */ 
/*     */   public void setPostAmount(Long postAmount) {
/*  95 */     this.postAmount = postAmount;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate() {
/*  99 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate) {
/* 103 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify() {
/* 107 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify) {
/* 111 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public EnumTransCode getEnumTransCode() {
/* 115 */     return EnumTransCode.getByCode(this.transCode);
/*     */   }
/*     */ 
/*     */   public String getBizNo() {
/* 119 */     return this.bizNo;
/*     */   }
/*     */ 
/*     */   public void setBizNo(String bizNo) {
/* 123 */     this.bizNo = bizNo;
/*     */   }
/*     */ 
/*     */   public String getUserAccount() {
/* 127 */     return this.userAccount;
/*     */   }
/*     */ 
/*     */   public void setUserAccount(String userAccount) {
/* 131 */     this.userAccount = userAccount;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.fund.FundAccountLog
 * JD-Core Version:    0.6.0
 */