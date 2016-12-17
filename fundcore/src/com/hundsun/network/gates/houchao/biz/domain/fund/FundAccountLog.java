/*     */ package com.hundsun.network.gates.houchao.biz.domain.fund;
/*     */ 
/*     */ import com.hundsun.network.gates.houchao.biz.domain.BaseDomain;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class FundAccountLog extends BaseDomain
/*     */ {
/*     */   private static final long serialVersionUID = -955239364803345451L;
/*     */   private Long id;
/*     */   private String transDate;
/*     */   private String fundAccount;
/*     */   private String transCode;
/*     */   private String subTransCode;
/*     */   private Long transAmount;
/*     */   private String bizNo;
/*     */   private String undoFlag;
/*     */   private String operator;
/*     */   private String branchNo;
/*     */   private Date gmtCreate;
/*     */   private String createId;
/*     */   private Date gmtModify;
/*     */   private String modifyId;
/*     */   private String memo;
/*     */   private Long postAmount;
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  84 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/*  88 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getTransDate() {
/*  92 */     return this.transDate;
/*     */   }
/*     */ 
/*     */   public void setTransDate(String transDate) {
/*  96 */     this.transDate = transDate;
/*     */   }
/*     */ 
/*     */   public String getFundAccount() {
/* 100 */     return this.fundAccount;
/*     */   }
/*     */ 
/*     */   public void setFundAccount(String fundAccount) {
/* 104 */     this.fundAccount = fundAccount;
/*     */   }
/*     */ 
/*     */   public String getTransCode() {
/* 108 */     return this.transCode;
/*     */   }
/*     */ 
/*     */   public void setTransCode(String transCode) {
/* 112 */     this.transCode = transCode;
/*     */   }
/*     */ 
/*     */   public String getSubTransCode() {
/* 116 */     return this.subTransCode;
/*     */   }
/*     */ 
/*     */   public void setSubTransCode(String subTransCode) {
/* 120 */     this.subTransCode = subTransCode;
/*     */   }
/*     */ 
/*     */   public Long getTransAmount() {
/* 124 */     return this.transAmount;
/*     */   }
/*     */ 
/*     */   public void setTransAmount(Long transAmount) {
/* 128 */     this.transAmount = transAmount;
/*     */   }
/*     */ 
/*     */   public String getBizNo() {
/* 132 */     return this.bizNo;
/*     */   }
/*     */ 
/*     */   public void setBizNo(String bizNo) {
/* 136 */     this.bizNo = bizNo;
/*     */   }
/*     */ 
/*     */   public String getUndoFlag() {
/* 140 */     return this.undoFlag;
/*     */   }
/*     */ 
/*     */   public void setUndoFlag(String undoFlag) {
/* 144 */     this.undoFlag = undoFlag;
/*     */   }
/*     */ 
/*     */   public String getOperator() {
/* 148 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator) {
/* 152 */     this.operator = operator;
/*     */   }
/*     */ 
/*     */   public String getBranchNo() {
/* 156 */     return this.branchNo;
/*     */   }
/*     */ 
/*     */   public void setBranchNo(String branchNo) {
/* 160 */     this.branchNo = branchNo;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate() {
/* 164 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate) {
/* 168 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public String getCreateId() {
/* 172 */     return this.createId;
/*     */   }
/*     */ 
/*     */   public void setCreateId(String createId) {
/* 176 */     this.createId = createId;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify() {
/* 180 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify) {
/* 184 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getModifyId() {
/* 188 */     return this.modifyId;
/*     */   }
/*     */ 
/*     */   public void setModifyId(String modifyId) {
/* 192 */     this.modifyId = modifyId;
/*     */   }
/*     */ 
/*     */   public String getMemo() {
/* 196 */     return this.memo;
/*     */   }
/*     */ 
/*     */   public void setMemo(String memo) {
/* 200 */     this.memo = memo;
/*     */   }
/*     */ 
/*     */   public Long getPostAmount() {
/* 204 */     return this.postAmount;
/*     */   }
/*     */ 
/*     */   public void setPostAmount(Long postAmount) {
/* 208 */     this.postAmount = postAmount;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\houchao\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.houchao.biz.domain.fund.FundAccountLog
 * JD-Core Version:    0.6.0
 */