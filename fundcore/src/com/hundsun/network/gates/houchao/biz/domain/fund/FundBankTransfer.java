/*     */ package com.hundsun.network.gates.houchao.biz.domain.fund;
/*     */ 
/*     */ import com.hundsun.network.gates.houchao.biz.domain.BaseDomain;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class FundBankTransfer extends BaseDomain
/*     */ {
/*     */   private Long Id;
/*     */   private String bankNo;
/*     */   private String moneyType;
/*     */   private String fundAccount;
/*     */   private String stockAccount;
/*     */   private String transDate;
/*     */   private Date bankDate;
/*     */   private String sourceFlag;
/*     */   private Integer transStatus;
/*     */   private String transType;
/*     */   private String bankAccount;
/*     */   private Long transAmount;
/*     */   private String bankBillNo;
/*     */   private String bankBatNo;
/*     */   private Integer repeatTimes;
/*     */   private String innerBillNo;
/*     */   private String bankErrorInfo;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */   private String bankErrorMsg;
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  96 */     return this.Id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/* 100 */     this.Id = id;
/*     */   }
/*     */ 
/*     */   public String getBankNo() {
/* 104 */     return this.bankNo;
/*     */   }
/*     */ 
/*     */   public void setBankNo(String bankNo) {
/* 108 */     this.bankNo = bankNo;
/*     */   }
/*     */ 
/*     */   public String getMoneyType() {
/* 112 */     return this.moneyType;
/*     */   }
/*     */ 
/*     */   public void setMoneyType(String moneyType) {
/* 116 */     this.moneyType = moneyType;
/*     */   }
/*     */ 
/*     */   public String getFundAccount() {
/* 120 */     return this.fundAccount;
/*     */   }
/*     */ 
/*     */   public void setFundAccount(String fundAccount) {
/* 124 */     this.fundAccount = fundAccount;
/*     */   }
/*     */ 
/*     */   public String getStockAccount() {
/* 128 */     return this.stockAccount;
/*     */   }
/*     */ 
/*     */   public void setStockAccount(String stockAccount) {
/* 132 */     this.stockAccount = stockAccount;
/*     */   }
/*     */ 
/*     */   public String getTransDate() {
/* 136 */     return this.transDate;
/*     */   }
/*     */ 
/*     */   public void setTransDate(String transDate) {
/* 140 */     this.transDate = transDate;
/*     */   }
/*     */ 
/*     */   public Date getBankDate() {
/* 144 */     return this.bankDate;
/*     */   }
/*     */ 
/*     */   public void setBankDate(Date bankDate) {
/* 148 */     this.bankDate = bankDate;
/*     */   }
/*     */ 
/*     */   public String getSourceFlag() {
/* 152 */     return this.sourceFlag;
/*     */   }
/*     */ 
/*     */   public void setSourceFlag(String sourceFlag) {
/* 156 */     this.sourceFlag = sourceFlag;
/*     */   }
/*     */ 
/*     */   public Integer getTransStatus() {
/* 160 */     return this.transStatus;
/*     */   }
/*     */ 
/*     */   public void setTransStatus(Integer transStatus) {
/* 164 */     this.transStatus = transStatus;
/*     */   }
/*     */ 
/*     */   public String getTransType() {
/* 168 */     return this.transType;
/*     */   }
/*     */ 
/*     */   public void setTransType(String transType) {
/* 172 */     this.transType = transType;
/*     */   }
/*     */ 
/*     */   public String getBankAccount() {
/* 176 */     return this.bankAccount;
/*     */   }
/*     */ 
/*     */   public void setBankAccount(String bankAccount) {
/* 180 */     this.bankAccount = bankAccount;
/*     */   }
/*     */ 
/*     */   public Long getTransAmount() {
/* 184 */     return this.transAmount;
/*     */   }
/*     */ 
/*     */   public void setTransAmount(Long transAmount) {
/* 188 */     this.transAmount = transAmount;
/*     */   }
/*     */ 
/*     */   public String getBankBillNo() {
/* 192 */     return this.bankBillNo;
/*     */   }
/*     */ 
/*     */   public void setBankBillNo(String bankBillNo) {
/* 196 */     this.bankBillNo = bankBillNo;
/*     */   }
/*     */ 
/*     */   public String getBankBatNo() {
/* 200 */     return this.bankBatNo;
/*     */   }
/*     */ 
/*     */   public void setBankBatNo(String bankBatNo) {
/* 204 */     this.bankBatNo = bankBatNo;
/*     */   }
/*     */ 
/*     */   public Integer getRepeatTimes() {
/* 208 */     return this.repeatTimes;
/*     */   }
/*     */ 
/*     */   public void setRepeatTimes(Integer repeatTimes) {
/* 212 */     this.repeatTimes = repeatTimes;
/*     */   }
/*     */ 
/*     */   public String getInnerBillNo() {
/* 216 */     return this.innerBillNo;
/*     */   }
/*     */ 
/*     */   public void setInnerBillNo(String innerBillNo) {
/* 220 */     this.innerBillNo = innerBillNo;
/*     */   }
/*     */ 
/*     */   public String getBankErrorInfo() {
/* 224 */     return this.bankErrorInfo;
/*     */   }
/*     */ 
/*     */   public void setBankErrorInfo(String bankErrorInfo) {
/* 228 */     this.bankErrorInfo = bankErrorInfo;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate() {
/* 232 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate) {
/* 236 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify() {
/* 240 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify) {
/* 244 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getBankErrorMsg() {
/* 248 */     return this.bankErrorMsg;
/*     */   }
/*     */ 
/*     */   public void setBankErrorMsg(String bankErrorMsg) {
/* 252 */     this.bankErrorMsg = bankErrorMsg;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\houchao\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.houchao.biz.domain.fund.FundBankTransfer
 * JD-Core Version:    0.6.0
 */