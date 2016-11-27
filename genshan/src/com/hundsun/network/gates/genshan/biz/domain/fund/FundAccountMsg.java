/*     */ package com.hundsun.network.gates.genshan.biz.domain.fund;
/*     */ 
/*     */ import java.util.Date;
/*     */ 
/*     */ public class FundAccountMsg
/*     */ {
/*     */   private static final long serialVersionUID = 8120418669446036117L;
/*     */   private String fundAccount;
/*     */   private String clientId;
/*     */   private String bankNo;
/*     */   private Date gmtOpend;
/*     */   private Date gmtClosed;
/*     */   private String status;
/*     */   private String moneyType;
/*     */   private Long amount;
/*     */   private Long beginAmount;
/*     */   private Long freezeTotal;
/*     */   private Long incomeTotal;
/*     */   private Long payoutTotal;
/*     */   private String fotbidFlag;
/*     */   private Long fotbidAmount;
/*     */   private Long useBanlance;
/*     */ 
/*     */   public String getFundAccount()
/*     */   {
/*  82 */     return this.fundAccount;
/*     */   }
/*     */ 
/*     */   public void setFundAccount(String fundAccount) {
/*  86 */     this.fundAccount = fundAccount;
/*     */   }
/*     */ 
/*     */   public String getClientId() {
/*  90 */     return this.clientId;
/*     */   }
/*     */ 
/*     */   public void setClientId(String clientId) {
/*  94 */     this.clientId = clientId;
/*     */   }
/*     */ 
/*     */   public String getBankNo() {
/*  98 */     return this.bankNo;
/*     */   }
/*     */ 
/*     */   public void setBankNo(String bankNo) {
/* 102 */     this.bankNo = bankNo;
/*     */   }
/*     */ 
/*     */   public Date getGmtOpend() {
/* 106 */     return this.gmtOpend;
/*     */   }
/*     */ 
/*     */   public void setGmtOpend(Date gmtOpend) {
/* 110 */     this.gmtOpend = gmtOpend;
/*     */   }
/*     */ 
/*     */   public Date getGmtClosed() {
/* 114 */     return this.gmtClosed;
/*     */   }
/*     */ 
/*     */   public void setGmtClosed(Date gmtClosed) {
/* 118 */     this.gmtClosed = gmtClosed;
/*     */   }
/*     */ 
/*     */   public String getStatus() {
/* 122 */     return this.status;
/*     */   }
/*     */ 
/*     */   public void setStatus(String status) {
/* 126 */     this.status = status;
/*     */   }
/*     */ 
/*     */   public String getMoneyType() {
/* 130 */     return this.moneyType;
/*     */   }
/*     */ 
/*     */   public void setMoneyType(String moneyType) {
/* 134 */     this.moneyType = moneyType;
/*     */   }
/*     */ 
/*     */   public Long getAmount() {
/* 138 */     return this.amount;
/*     */   }
/*     */ 
/*     */   public void setAmount(Long amount) {
/* 142 */     this.amount = amount;
/*     */   }
/*     */ 
/*     */   public Long getBeginAmount() {
/* 146 */     return this.beginAmount;
/*     */   }
/*     */ 
/*     */   public void setBeginAmount(Long beginAmount) {
/* 150 */     this.beginAmount = beginAmount;
/*     */   }
/*     */ 
/*     */   public Long getFreezeTotal() {
/* 154 */     return this.freezeTotal;
/*     */   }
/*     */ 
/*     */   public void setFreezeTotal(Long freezeTotal) {
/* 158 */     this.freezeTotal = freezeTotal;
/*     */   }
/*     */ 
/*     */   public Long getIncomeTotal() {
/* 162 */     return this.incomeTotal;
/*     */   }
/*     */ 
/*     */   public void setIncomeTotal(Long incomeTotal) {
/* 166 */     this.incomeTotal = incomeTotal;
/*     */   }
/*     */ 
/*     */   public Long getPayoutTotal() {
/* 170 */     return this.payoutTotal;
/*     */   }
/*     */ 
/*     */   public void setPayoutTotal(Long payoutTotal) {
/* 174 */     this.payoutTotal = payoutTotal;
/*     */   }
/*     */ 
/*     */   public String getFotbidFlag() {
/* 178 */     return this.fotbidFlag;
/*     */   }
/*     */ 
/*     */   public void setFotbidFlag(String fotbidFlag) {
/* 182 */     this.fotbidFlag = fotbidFlag;
/*     */   }
/*     */ 
/*     */   public Long getFotbidAmount() {
/* 186 */     return this.fotbidAmount;
/*     */   }
/*     */ 
/*     */   public void setFotbidAmount(Long fotbidAmount) {
/* 190 */     this.fotbidAmount = fotbidAmount;
/*     */   }
/*     */ 
/*     */   public Long getUseBanlance() {
/* 194 */     return Long.valueOf(getAmount().longValue() - getFreezeTotal().longValue());
/*     */   }
/*     */ 
/*     */   public void setUseBanlance(Long useBanlance) {
/* 198 */     this.useBanlance = useBanlance;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.fund.FundAccountMsg
 * JD-Core Version:    0.6.0
 */