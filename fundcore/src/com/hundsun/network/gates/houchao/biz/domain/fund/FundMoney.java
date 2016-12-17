/*     */ package com.hundsun.network.gates.houchao.biz.domain.fund;
/*     */ 
/*     */ import com.hundsun.network.gates.houchao.biz.domain.BaseDomain;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class FundMoney extends BaseDomain
/*     */ {
/*     */   private static final long serialVersionUID = -7234199134224166880L;
/*     */   private Long Id;
/*     */   private String fundAccount;
/*     */   private String moneyType;
/*     */   private Long amount;
/*     */   private Long beginAmount;
/*     */   private Long freezeTotal;
/*     */   private Long incomeTotal;
/*     */   private Long payoutTotal;
/*     */   private String fotbidFlag;
/*     */   private Long fotbidAmount;
/*     */   private Date gmtCreate;
/*     */   private String createId;
/*     */   private Date gmtModify;
/*     */   private String modifyId;
/*     */   private String memo;
/*     */   private Long postAmount;
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  87 */     return this.Id;
/*     */   }
/*     */ 
/*     */   public void setId(Long Id) {
/*  91 */     this.Id = Id;
/*     */   }
/*     */ 
/*     */   public String getFundAccount() {
/*  95 */     return this.fundAccount;
/*     */   }
/*     */ 
/*     */   public void setFundAccount(String fundAccount) {
/*  99 */     this.fundAccount = fundAccount;
/*     */   }
/*     */ 
/*     */   public String getMoneyType() {
/* 103 */     return this.moneyType;
/*     */   }
/*     */ 
/*     */   public void setMoneyType(String moneyType) {
/* 107 */     this.moneyType = moneyType;
/*     */   }
/*     */ 
/*     */   public Long getAmount() {
/* 111 */     return this.amount;
/*     */   }
/*     */ 
/*     */   public void setAmount(Long amount) {
/* 115 */     this.amount = amount;
/*     */   }
/*     */ 
/*     */   public Long getBeginAmount() {
/* 119 */     return this.beginAmount;
/*     */   }
/*     */ 
/*     */   public void setBeginAmount(Long beginAmount) {
/* 123 */     this.beginAmount = beginAmount;
/*     */   }
/*     */ 
/*     */   public Long getFreezeTotal() {
/* 127 */     return this.freezeTotal;
/*     */   }
/*     */ 
/*     */   public void setFreezeTotal(Long freezeTotal) {
/* 131 */     this.freezeTotal = freezeTotal;
/*     */   }
/*     */ 
/*     */   public Long getIncomeTotal() {
/* 135 */     return this.incomeTotal;
/*     */   }
/*     */ 
/*     */   public void setIncomeTotal(Long incomeTotal) {
/* 139 */     this.incomeTotal = incomeTotal;
/*     */   }
/*     */ 
/*     */   public Long getPayoutTotal() {
/* 143 */     return this.payoutTotal;
/*     */   }
/*     */ 
/*     */   public void setPayoutTotal(Long payoutTotal) {
/* 147 */     this.payoutTotal = payoutTotal;
/*     */   }
/*     */ 
/*     */   public static long getSerialversionuid() {
/* 151 */     return -7234199134224166880L;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate() {
/* 155 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate) {
/* 159 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public String getCreateId() {
/* 163 */     return this.createId;
/*     */   }
/*     */ 
/*     */   public void setCreateId(String createId) {
/* 167 */     this.createId = createId;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify() {
/* 171 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify) {
/* 175 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getModifyId() {
/* 179 */     return this.modifyId;
/*     */   }
/*     */ 
/*     */   public void setModifyId(String modifyId) {
/* 183 */     this.modifyId = modifyId;
/*     */   }
/*     */ 
/*     */   public String getMemo() {
/* 187 */     return this.memo;
/*     */   }
/*     */ 
/*     */   public void setMemo(String memo) {
/* 191 */     this.memo = memo;
/*     */   }
/*     */ 
/*     */   public String getFotbidFlag() {
/* 195 */     return this.fotbidFlag;
/*     */   }
/*     */ 
/*     */   public void setFotbidFlag(String fotbidFlag) {
/* 199 */     this.fotbidFlag = fotbidFlag;
/*     */   }
/*     */ 
/*     */   public Long getFotbidAmount() {
/* 203 */     return this.fotbidAmount;
/*     */   }
/*     */ 
/*     */   public void setFotbidAmount(Long fotbidAmount) {
/* 207 */     this.fotbidAmount = fotbidAmount;
/*     */   }
/*     */ 
/*     */   public Long getPostAmount() {
/* 211 */     return this.postAmount;
/*     */   }
/*     */ 
/*     */   public void setPostAmount(Long postAmount) {
/* 215 */     this.postAmount = postAmount;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\houchao\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.houchao.biz.domain.fund.FundMoney
 * JD-Core Version:    0.6.0
 */