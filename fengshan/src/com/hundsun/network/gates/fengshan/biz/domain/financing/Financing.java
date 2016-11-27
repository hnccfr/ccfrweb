/*     */ package com.hundsun.network.gates.fengshan.biz.domain.financing;
/*     */ 
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.BaseDomain;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumFinancingProcessNodes;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumFinancingStatus;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class Financing extends BaseDomain
/*     */ {
/*     */   private static final long serialVersionUID = -7786729228419529730L;
/*     */   private Long id;
/*     */   private String code;
/*     */   private String title;
/*     */   private String type;
/*     */   private String status;
/*     */   private String processAuditNodes;
/*     */   private String auditNode;
/*     */   private String bizType;
/*     */   private String bizNo;
/*     */   private String userAccount;
/*     */   private String userName;
/*     */   private String userTel;
/*     */   private String userAddress;
/*     */   private String guaranteeAccount;
/*     */   private String guaranteeName;
/*     */   private String guaranteeTel;
/*     */   private String guaranteeAddress;
/*     */   private Long applyAmount;
/*     */   private String applyAmountDes;
/*     */   private Long loanAmount;
/*     */   private String loanAmountDes;
/*     */   private Long loanRate;
/*     */   private String loanRateDes;
/*     */   private Long repayAmount;
/*     */   private String repayAmountDes;
/*     */   private String valuationUnit;
/*     */   private Long applyLimit;
/*     */   private String applyLimitDes;
/*     */   private String bank;
/*     */   private String bankCard;
/*     */   private String remark;
/*     */   private String attachedFilePath;
/*     */   private Date gmtApply;
/*     */   private Date gmtLoan;
/*     */   private Date gmtLimit;
/*     */   private Date gmtRepay;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */   private String creator;
/*     */   private String operator;
/*     */ 
/*     */   public Long getId()
/*     */   {
/* 193 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/* 197 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getCode() {
/* 201 */     return this.code;
/*     */   }
/*     */ 
/*     */   public void setCode(String code) {
/* 205 */     this.code = code;
/*     */   }
/*     */ 
/*     */   public String getType() {
/* 209 */     return this.type;
/*     */   }
/*     */ 
/*     */   public void setType(String type) {
/* 213 */     this.type = type;
/*     */   }
/*     */ 
/*     */   public String getStatus() {
/* 217 */     return this.status;
/*     */   }
/*     */ 
/*     */   public String getStatusDes() {
/* 221 */     String result = this.status;
/* 222 */     EnumFinancingStatus eStatus = EnumFinancingStatus.indexByValue(this.status);
/* 223 */     if (eStatus != null) {
/* 224 */       result = eStatus.getName();
/*     */     }
/*     */ 
/* 229 */     return result;
/*     */   }
/*     */ 
/*     */   public void setStatus(String status) {
/* 233 */     this.status = status;
/*     */   }
/*     */ 
/*     */   public String getBizType() {
/* 237 */     return this.bizType;
/*     */   }
/*     */ 
/*     */   public void setBizType(String bizType) {
/* 241 */     this.bizType = bizType;
/*     */   }
/*     */ 
/*     */   public String getBizNo() {
/* 245 */     return this.bizNo;
/*     */   }
/*     */ 
/*     */   public void setBizNo(String bizNo) {
/* 249 */     this.bizNo = bizNo;
/*     */   }
/*     */ 
/*     */   public String getUserAccount() {
/* 253 */     return this.userAccount;
/*     */   }
/*     */ 
/*     */   public void setUserAccount(String userAccount) {
/* 257 */     this.userAccount = userAccount;
/*     */   }
/*     */ 
/*     */   public String getUserName() {
/* 261 */     return this.userName;
/*     */   }
/*     */ 
/*     */   public void setUserName(String userName) {
/* 265 */     this.userName = userName;
/*     */   }
/*     */ 
/*     */   public String getUserTel() {
/* 269 */     return this.userTel;
/*     */   }
/*     */ 
/*     */   public void setUserTel(String userTel) {
/* 273 */     this.userTel = userTel;
/*     */   }
/*     */ 
/*     */   public String getUserAddress() {
/* 277 */     return this.userAddress;
/*     */   }
/*     */ 
/*     */   public void setUserAddress(String userAddress) {
/* 281 */     this.userAddress = userAddress;
/*     */   }
/*     */ 
/*     */   public Long getApplyAmount() {
/* 285 */     return this.applyAmount;
/*     */   }
/*     */ 
/*     */   public void setApplyAmount(Long applyAmount) {
/* 289 */     this.applyAmount = applyAmount;
/*     */   }
/*     */ 
/*     */   public String getValuationUnit() {
/* 293 */     return this.valuationUnit;
/*     */   }
/*     */ 
/*     */   public void setValuationUnit(String valuationUnit) {
/* 297 */     this.valuationUnit = valuationUnit;
/*     */   }
/*     */ 
/*     */   public String getBank() {
/* 301 */     return this.bank;
/*     */   }
/*     */ 
/*     */   public void setBank(String bank) {
/* 305 */     this.bank = bank;
/*     */   }
/*     */ 
/*     */   public String getBankCard() {
/* 309 */     return this.bankCard;
/*     */   }
/*     */ 
/*     */   public void setBankCard(String bankCard) {
/* 313 */     this.bankCard = bankCard;
/*     */   }
/*     */ 
/*     */   public String getRemark() {
/* 317 */     return this.remark;
/*     */   }
/*     */ 
/*     */   public void setRemark(String remark) {
/* 321 */     this.remark = remark;
/*     */   }
/*     */ 
/*     */   public String getAttachedFilePath() {
/* 325 */     return this.attachedFilePath;
/*     */   }
/*     */ 
/*     */   public void setAttachedFilePath(String attachedFilePath) {
/* 329 */     this.attachedFilePath = attachedFilePath;
/*     */   }
/*     */ 
/*     */   public Date getGmtLoan() {
/* 333 */     return this.gmtLoan;
/*     */   }
/*     */ 
/*     */   public void setGmtLoan(Date gmtLoan) {
/* 337 */     this.gmtLoan = gmtLoan;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate() {
/* 341 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate) {
/* 345 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify() {
/* 349 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify) {
/* 353 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getCreator() {
/* 357 */     return this.creator;
/*     */   }
/*     */ 
/*     */   public void setCreator(String creator) {
/* 361 */     this.creator = creator;
/*     */   }
/*     */ 
/*     */   public String getOperator() {
/* 365 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator) {
/* 369 */     this.operator = operator;
/*     */   }
/*     */ 
/*     */   public String getApplyAmountDes() {
/* 373 */     return this.applyAmountDes;
/*     */   }
/*     */ 
/*     */   public void setApplyAmountDes(String applyAmountDes) {
/* 377 */     this.applyAmountDes = applyAmountDes;
/*     */   }
/*     */ 
/*     */   public String getProcessAuditNodes() {
/* 381 */     return this.processAuditNodes;
/*     */   }
/*     */ 
/*     */   public void setProcessAuditNodes(String processAuditNodes) {
/* 385 */     this.processAuditNodes = processAuditNodes;
/*     */   }
/*     */ 
/*     */   public String getAuditNode() {
/* 389 */     return this.auditNode;
/*     */   }
/*     */ 
/*     */   public String getAuditNodeDes() {
/* 393 */     EnumFinancingProcessNodes eNode = EnumFinancingProcessNodes.indexByValue(this.auditNode);
/* 394 */     return eNode == null ? this.auditNode : eNode.getName();
/*     */   }
/*     */ 
/*     */   public void setAuditNode(String auditNode) {
/* 398 */     this.auditNode = auditNode;
/*     */   }
/*     */ 
/*     */   public String getGuaranteeAccount() {
/* 402 */     return this.guaranteeAccount;
/*     */   }
/*     */ 
/*     */   public void setGuaranteeAccount(String guaranteeAccount) {
/* 406 */     this.guaranteeAccount = guaranteeAccount;
/*     */   }
/*     */ 
/*     */   public String getGuaranteeName() {
/* 410 */     return this.guaranteeName;
/*     */   }
/*     */ 
/*     */   public void setGuaranteeName(String guaranteeName) {
/* 414 */     this.guaranteeName = guaranteeName;
/*     */   }
/*     */ 
/*     */   public String getGuaranteeTel() {
/* 418 */     return this.guaranteeTel;
/*     */   }
/*     */ 
/*     */   public void setGuaranteeTel(String guaranteeTel) {
/* 422 */     this.guaranteeTel = guaranteeTel;
/*     */   }
/*     */ 
/*     */   public String getGuaranteeAddress() {
/* 426 */     return this.guaranteeAddress;
/*     */   }
/*     */ 
/*     */   public void setGuaranteeAddress(String guaranteeAddress) {
/* 430 */     this.guaranteeAddress = guaranteeAddress;
/*     */   }
/*     */ 
/*     */   public Long getLoanAmount() {
/* 434 */     return this.loanAmount;
/*     */   }
/*     */ 
/*     */   public void setLoanAmount(Long loanAmount) {
/* 438 */     this.loanAmount = loanAmount;
/*     */   }
/*     */ 
/*     */   public String getLoanAmountDes() {
/* 442 */     return this.loanAmountDes;
/*     */   }
/*     */ 
/*     */   public void setLoanAmountDes(String loanAmountDes) {
/* 446 */     this.loanAmountDes = loanAmountDes;
/*     */   }
/*     */ 
/*     */   public Long getLoanRate() {
/* 450 */     return this.loanRate;
/*     */   }
/*     */ 
/*     */   public void setLoanRate(Long loanRate) {
/* 454 */     this.loanRate = loanRate;
/*     */   }
/*     */ 
/*     */   public String getLoanRateDes() {
/* 458 */     return this.loanRateDes;
/*     */   }
/*     */ 
/*     */   public void setLoanRateDes(String loanRateDes) {
/* 462 */     this.loanRateDes = loanRateDes;
/*     */   }
/*     */ 
/*     */   public Long getRepayAmount() {
/* 466 */     return this.repayAmount;
/*     */   }
/*     */ 
/*     */   public void setRepayAmount(Long repayAmount) {
/* 470 */     this.repayAmount = repayAmount;
/*     */   }
/*     */ 
/*     */   public Long getApplyLimit() {
/* 474 */     return this.applyLimit;
/*     */   }
/*     */ 
/*     */   public void setApplyLimit(Long applyLimit) {
/* 478 */     this.applyLimit = applyLimit;
/*     */   }
/*     */ 
/*     */   public Date getGmtApply() {
/* 482 */     return this.gmtApply;
/*     */   }
/*     */ 
/*     */   public void setGmtApply(Date gmtApply) {
/* 486 */     this.gmtApply = gmtApply;
/*     */   }
/*     */ 
/*     */   public Date getGmtLimit() {
/* 490 */     return this.gmtLimit;
/*     */   }
/*     */ 
/*     */   public void setGmtLimit(Date gmtLimit) {
/* 494 */     this.gmtLimit = gmtLimit;
/*     */   }
/*     */ 
/*     */   public Date getGmtRepay() {
/* 498 */     return this.gmtRepay;
/*     */   }
/*     */ 
/*     */   public void setGmtRepay(Date gmtRepay) {
/* 502 */     this.gmtRepay = gmtRepay;
/*     */   }
/*     */ 
/*     */   public String getApplyLimitDes() {
/* 506 */     return this.applyLimitDes;
/*     */   }
/*     */ 
/*     */   public void setApplyLimitDes(String applyLimitDes) {
/* 510 */     this.applyLimitDes = applyLimitDes;
/*     */   }
/*     */ 
/*     */   public String getRepayAmountDes() {
/* 514 */     return this.repayAmountDes;
/*     */   }
/*     */ 
/*     */   public void setRepayAmountDes(String repayAmountDes) {
/* 518 */     this.repayAmountDes = repayAmountDes;
/*     */   }
/*     */ 
/*     */   public boolean isCanDelete()
/*     */   {
/* 523 */     return (EnumFinancingStatus.CREATE.getValue().equals(this.status)) && (this.processAuditNodes.indexOf(EnumFinancingProcessNodes.ADVANCE.getValue()) >= 0) && (EnumFinancingProcessNodes.ADVANCE.getValue().equals(this.auditNode));
/*     */   }
/*     */ 
/*     */   public boolean isCanEdit()
/*     */   {
/* 531 */     return !EnumFinancingStatus.DELETE.getValue().equals(this.status);
/*     */   }
/*     */ 
/*     */   public boolean isCanAdvance()
/*     */   {
/* 539 */     return (EnumFinancingStatus.CREATE.getValue().equals(this.status)) && (this.processAuditNodes.indexOf(EnumFinancingProcessNodes.ADVANCE.getValue()) >= 0) && (EnumFinancingProcessNodes.ADVANCE.getValue().equals(this.auditNode));
/*     */   }
/*     */ 
/*     */   public boolean isCanFinalAudit()
/*     */   {
/* 549 */     return (EnumFinancingStatus.CREATE.getValue().equals(this.status)) && (this.processAuditNodes.indexOf(EnumFinancingProcessNodes.FINAL.getValue()) >= 0) && (EnumFinancingProcessNodes.FINAL.getValue().equals(this.auditNode));
/*     */   }
/*     */ 
/*     */   public boolean isCanLoan()
/*     */   {
/* 559 */     return (EnumFinancingStatus.LOAN.getValue().equals(this.status)) && (this.processAuditNodes.indexOf(EnumFinancingProcessNodes.LOAN.getValue()) >= 0) && (EnumFinancingProcessNodes.LOAN.getValue().equals(this.auditNode));
/*     */   }
/*     */ 
/*     */   public boolean isCanRepay()
/*     */   {
/* 568 */     return EnumFinancingStatus.REPAY.getValue().equals(this.status);
/*     */   }
/*     */ 
/*     */   public String getTitle() {
/* 572 */     return this.title;
/*     */   }
/*     */ 
/*     */   public void setTitle(String title) {
/* 576 */     this.title = title;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.domain.financing.Financing
 * JD-Core Version:    0.6.0
 */