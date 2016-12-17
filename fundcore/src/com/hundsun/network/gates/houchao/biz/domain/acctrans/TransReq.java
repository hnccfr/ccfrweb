/*     */ package com.hundsun.network.gates.houchao.biz.domain.acctrans;
/*     */ 
/*     */ import com.hundsun.network.gates.houchao.biz.domain.BaseDomain;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTransCode;
/*     */ 
/*     */ public class TransReq extends BaseDomain
/*     */ {
/*     */   private static final long serialVersionUID = 748543956838258011L;
/*     */   private String fundAccount;
/*     */   private EnumTransCode transCode;
/*     */   private Long amount;
/*     */   private String bizNo;
/*     */   private String transDate;
/*     */   private String bankNo;
/*     */   private String bankBranch;
/*     */   private String moneyType;
/*     */   private String operator;
/*     */   private String memo;
/*     */ 
/*     */   public String getFundAccount()
/*     */   {
/*  64 */     return this.fundAccount;
/*     */   }
/*     */ 
/*     */   public void setFundAccount(String fundAccount) {
/*  68 */     this.fundAccount = fundAccount;
/*     */   }
/*     */ 
/*     */   public String getBizNo() {
/*  72 */     return this.bizNo;
/*     */   }
/*     */ 
/*     */   public void setBizNo(String bizNo) {
/*  76 */     this.bizNo = bizNo;
/*     */   }
/*     */ 
/*     */   public String getTransDate() {
/*  80 */     return this.transDate;
/*     */   }
/*     */ 
/*     */   public void setTransDate(String transDate) {
/*  84 */     this.transDate = transDate;
/*     */   }
/*     */ 
/*     */   public String getMoneyType() {
/*  88 */     return this.moneyType;
/*     */   }
/*     */ 
/*     */   public void setMoneyType(String moneyType) {
/*  92 */     this.moneyType = moneyType;
/*     */   }
/*     */ 
/*     */   public String getMemo() {
/*  96 */     return this.memo;
/*     */   }
/*     */ 
/*     */   public void setMemo(String memo) {
/* 100 */     this.memo = memo;
/*     */   }
/*     */ 
/*     */   public EnumTransCode getTransCode() {
/* 104 */     return this.transCode;
/*     */   }
/*     */ 
/*     */   public void setTransCode(EnumTransCode transCode) {
/* 108 */     this.transCode = transCode;
/*     */   }
/*     */ 
/*     */   public Long getAmount() {
/* 112 */     return this.amount;
/*     */   }
/*     */ 
/*     */   public void setAmount(Long amount) {
/* 116 */     this.amount = amount;
/*     */   }
/*     */ 
/*     */   public String getBankNo() {
/* 120 */     return this.bankNo;
/*     */   }
/*     */ 
/*     */   public void setBankNo(String bankNo) {
/* 124 */     this.bankNo = bankNo;
/*     */   }
/*     */ 
/*     */   public String getOperator() {
/* 128 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator) {
/* 132 */     this.operator = operator;
/*     */   }
/*     */ 
/*     */   public String getBankBranch() {
/* 136 */     return this.bankBranch;
/*     */   }
/*     */ 
/*     */   public void setBankBranch(String bankBranch) {
/* 140 */     this.bankBranch = bankBranch;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\houchao\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.houchao.biz.domain.acctrans.TransReq
 * JD-Core Version:    0.6.0
 */