/*     */ package com.hundsun.network.gates.genshan.biz.domain.financing;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.domain.BaseDomain;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumFinancingProcessNodes;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumFinancingStatus;
/*     */ import java.util.Date;
/*     */ import java.util.List;
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
/*     */   private List<FinancingLog> financingLogList;
/*     */ 
/*     */   public Long getId()
/*     */   {
/* 199 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/* 203 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getCode() {
/* 207 */     return this.code;
/*     */   }
/*     */ 
/*     */   public void setCode(String code) {
/* 211 */     this.code = code;
/*     */   }
/*     */ 
/*     */   public String getType() {
/* 215 */     return this.type;
/*     */   }
/*     */ 
/*     */   public void setType(String type) {
/* 219 */     this.type = type;
/*     */   }
/*     */ 
/*     */   public String getStatus() {
/* 223 */     return this.status;
/*     */   }
/*     */ 
/*     */   public String getStatusDes() {
/* 227 */     String result = this.status;
/* 228 */     EnumFinancingStatus eStatus = EnumFinancingStatus.indexByValue(this.status);
/* 229 */     if (eStatus != null) {
/* 230 */       result = eStatus.getName();
/* 231 */       if (EnumFinancingStatus.CREATE.equals(eStatus)) {
/* 232 */         result = result + "(" + EnumFinancingProcessNodes.indexByValue(this.auditNode).getName() + ")";
/*     */       }
/*     */     }
/* 235 */     return result;
/*     */   }
/*     */ 
/*     */   public void setStatus(String status) {
/* 239 */     this.status = status;
/*     */   }
/*     */ 
/*     */   public String getBizType() {
/* 243 */     return this.bizType;
/*     */   }
/*     */ 
/*     */   public void setBizType(String bizType) {
/* 247 */     this.bizType = bizType;
/*     */   }
/*     */ 
/*     */   public String getBizNo() {
/* 251 */     return this.bizNo;
/*     */   }
/*     */ 
/*     */   public void setBizNo(String bizNo) {
/* 255 */     this.bizNo = bizNo;
/*     */   }
/*     */ 
/*     */   public String getUserAccount() {
/* 259 */     return this.userAccount;
/*     */   }
/*     */ 
/*     */   public void setUserAccount(String userAccount) {
/* 263 */     this.userAccount = userAccount;
/*     */   }
/*     */ 
/*     */   public String getUserName() {
/* 267 */     return this.userName;
/*     */   }
/*     */ 
/*     */   public void setUserName(String userName) {
/* 271 */     this.userName = userName;
/*     */   }
/*     */ 
/*     */   public String getUserTel() {
/* 275 */     return this.userTel;
/*     */   }
/*     */ 
/*     */   public void setUserTel(String userTel) {
/* 279 */     this.userTel = userTel;
/*     */   }
/*     */ 
/*     */   public String getUserAddress() {
/* 283 */     return this.userAddress;
/*     */   }
/*     */ 
/*     */   public void setUserAddress(String userAddress) {
/* 287 */     this.userAddress = userAddress;
/*     */   }
/*     */ 
/*     */   public Long getApplyAmount() {
/* 291 */     return this.applyAmount;
/*     */   }
/*     */ 
/*     */   public void setApplyAmount(Long applyAmount) {
/* 295 */     this.applyAmount = applyAmount;
/*     */   }
/*     */ 
/*     */   public String getValuationUnit() {
/* 299 */     return this.valuationUnit;
/*     */   }
/*     */ 
/*     */   public void setValuationUnit(String valuationUnit) {
/* 303 */     this.valuationUnit = valuationUnit;
/*     */   }
/*     */ 
/*     */   public String getBank() {
/* 307 */     return this.bank;
/*     */   }
/*     */ 
/*     */   public void setBank(String bank) {
/* 311 */     this.bank = bank;
/*     */   }
/*     */ 
/*     */   public String getBankCard() {
/* 315 */     return this.bankCard;
/*     */   }
/*     */ 
/*     */   public void setBankCard(String bankCard) {
/* 319 */     this.bankCard = bankCard;
/*     */   }
/*     */ 
/*     */   public String getRemark() {
/* 323 */     return this.remark;
/*     */   }
/*     */ 
/*     */   public void setRemark(String remark) {
/* 327 */     this.remark = remark;
/*     */   }
/*     */ 
/*     */   public String getAttachedFilePath() {
/* 331 */     return this.attachedFilePath;
/*     */   }
/*     */ 
/*     */   public void setAttachedFilePath(String attachedFilePath) {
/* 335 */     this.attachedFilePath = attachedFilePath;
/*     */   }
/*     */ 
/*     */   public Date getGmtLoan() {
/* 339 */     return this.gmtLoan;
/*     */   }
/*     */ 
/*     */   public void setGmtLoan(Date gmtLoan) {
/* 343 */     this.gmtLoan = gmtLoan;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate() {
/* 347 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate) {
/* 351 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify() {
/* 355 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify) {
/* 359 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getCreator() {
/* 363 */     return this.creator;
/*     */   }
/*     */ 
/*     */   public void setCreator(String creator) {
/* 367 */     this.creator = creator;
/*     */   }
/*     */ 
/*     */   public String getOperator() {
/* 371 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator) {
/* 375 */     this.operator = operator;
/*     */   }
/*     */ 
/*     */   public String getApplyAmountDes() {
/* 379 */     return this.applyAmountDes;
/*     */   }
/*     */ 
/*     */   public void setApplyAmountDes(String applyAmountDes) {
/* 383 */     this.applyAmountDes = applyAmountDes;
/*     */   }
/*     */ 
/*     */   public String getProcessAuditNodes() {
/* 387 */     return this.processAuditNodes;
/*     */   }
/*     */ 
/*     */   public void setProcessAuditNodes(String processAuditNodes) {
/* 391 */     this.processAuditNodes = processAuditNodes;
/*     */   }
/*     */ 
/*     */   public String getAuditNode() {
/* 395 */     return this.auditNode;
/*     */   }
/*     */ 
/*     */   public String getAuditNodeDes() {
/* 399 */     EnumFinancingProcessNodes eNode = EnumFinancingProcessNodes.indexByValue(this.auditNode);
/* 400 */     return eNode == null ? this.auditNode : eNode.getName();
/*     */   }
/*     */ 
/*     */   public void setAuditNode(String auditNode) {
/* 404 */     this.auditNode = auditNode;
/*     */   }
/*     */ 
/*     */   public String getGuaranteeAccount() {
/* 408 */     return this.guaranteeAccount;
/*     */   }
/*     */ 
/*     */   public void setGuaranteeAccount(String guaranteeAccount) {
/* 412 */     this.guaranteeAccount = guaranteeAccount;
/*     */   }
/*     */ 
/*     */   public String getGuaranteeName() {
/* 416 */     return this.guaranteeName;
/*     */   }
/*     */ 
/*     */   public void setGuaranteeName(String guaranteeName) {
/* 420 */     this.guaranteeName = guaranteeName;
/*     */   }
/*     */ 
/*     */   public String getGuaranteeTel() {
/* 424 */     return this.guaranteeTel;
/*     */   }
/*     */ 
/*     */   public void setGuaranteeTel(String guaranteeTel) {
/* 428 */     this.guaranteeTel = guaranteeTel;
/*     */   }
/*     */ 
/*     */   public String getGuaranteeAddress() {
/* 432 */     return this.guaranteeAddress;
/*     */   }
/*     */ 
/*     */   public void setGuaranteeAddress(String guaranteeAddress) {
/* 436 */     this.guaranteeAddress = guaranteeAddress;
/*     */   }
/*     */ 
/*     */   public Long getLoanAmount() {
/* 440 */     return this.loanAmount;
/*     */   }
/*     */ 
/*     */   public void setLoanAmount(Long loanAmount) {
/* 444 */     this.loanAmount = loanAmount;
/*     */   }
/*     */ 
/*     */   public String getLoanAmountDes() {
/* 448 */     return this.loanAmountDes;
/*     */   }
/*     */ 
/*     */   public void setLoanAmountDes(String loanAmountDes) {
/* 452 */     this.loanAmountDes = loanAmountDes;
/*     */   }
/*     */ 
/*     */   public Long getLoanRate() {
/* 456 */     return this.loanRate;
/*     */   }
/*     */ 
/*     */   public void setLoanRate(Long loanRate) {
/* 460 */     this.loanRate = loanRate;
/*     */   }
/*     */ 
/*     */   public String getLoanRateDes() {
/* 464 */     return this.loanRateDes;
/*     */   }
/*     */ 
/*     */   public void setLoanRateDes(String loanRateDes) {
/* 468 */     this.loanRateDes = loanRateDes;
/*     */   }
/*     */ 
/*     */   public Long getRepayAmount() {
/* 472 */     return this.repayAmount;
/*     */   }
/*     */ 
/*     */   public void setRepayAmount(Long repayAmount) {
/* 476 */     this.repayAmount = repayAmount;
/*     */   }
/*     */ 
/*     */   public Long getApplyLimit() {
/* 480 */     return this.applyLimit;
/*     */   }
/*     */ 
/*     */   public void setApplyLimit(Long applyLimit) {
/* 484 */     this.applyLimit = applyLimit;
/*     */   }
/*     */ 
/*     */   public Date getGmtApply() {
/* 488 */     return this.gmtApply;
/*     */   }
/*     */ 
/*     */   public void setGmtApply(Date gmtApply) {
/* 492 */     this.gmtApply = gmtApply;
/*     */   }
/*     */ 
/*     */   public Date getGmtLimit() {
/* 496 */     return this.gmtLimit;
/*     */   }
/*     */ 
/*     */   public void setGmtLimit(Date gmtLimit) {
/* 500 */     this.gmtLimit = gmtLimit;
/*     */   }
/*     */ 
/*     */   public Date getGmtRepay() {
/* 504 */     return this.gmtRepay;
/*     */   }
/*     */ 
/*     */   public void setGmtRepay(Date gmtRepay) {
/* 508 */     this.gmtRepay = gmtRepay;
/*     */   }
/*     */ 
/*     */   public String getApplyLimitDes() {
/* 512 */     return this.applyLimitDes;
/*     */   }
/*     */ 
/*     */   public void setApplyLimitDes(String applyLimitDes) {
/* 516 */     this.applyLimitDes = applyLimitDes;
/*     */   }
/*     */ 
/*     */   public String getRepayAmountDes() {
/* 520 */     return this.repayAmountDes;
/*     */   }
/*     */ 
/*     */   public void setRepayAmountDes(String repayAmountDes) {
/* 524 */     this.repayAmountDes = repayAmountDes;
/*     */   }
/*     */ 
/*     */   public boolean isCanDelete()
/*     */   {
/* 529 */     return (EnumFinancingStatus.CREATE.getValue().equals(this.status)) && (this.processAuditNodes.indexOf(EnumFinancingProcessNodes.ADVANCE.getValue()) >= 0) && (EnumFinancingProcessNodes.ADVANCE.getValue().equals(this.auditNode));
/*     */   }
/*     */ 
/*     */   public boolean isCanEdit()
/*     */   {
/* 537 */     return !EnumFinancingStatus.DELETE.getValue().equals(this.status);
/*     */   }
/*     */ 
/*     */   public boolean isCanAdvance()
/*     */   {
/* 545 */     return (EnumFinancingStatus.CREATE.getValue().equals(this.status)) && (this.processAuditNodes.indexOf(EnumFinancingProcessNodes.ADVANCE.getValue()) >= 0) && (EnumFinancingProcessNodes.ADVANCE.getValue().equals(this.auditNode));
/*     */   }
/*     */ 
/*     */   public boolean isCanFinalAudit()
/*     */   {
/* 555 */     return (EnumFinancingStatus.CREATE.getValue().equals(this.status)) && (this.processAuditNodes.indexOf(EnumFinancingProcessNodes.FINAL.getValue()) >= 0) && (EnumFinancingProcessNodes.FINAL.getValue().equals(this.auditNode));
/*     */   }
/*     */ 
/*     */   public boolean isCanLoan()
/*     */   {
/* 565 */     return (EnumFinancingStatus.LOAN.getValue().equals(this.status)) && (this.processAuditNodes.indexOf(EnumFinancingProcessNodes.LOAN.getValue()) >= 0) && (EnumFinancingProcessNodes.LOAN.getValue().equals(this.auditNode));
/*     */   }
/*     */ 
/*     */   public boolean isCanRepay()
/*     */   {
/* 574 */     return EnumFinancingStatus.REPAY.getValue().equals(this.status);
/*     */   }
/*     */ 
/*     */   public List<FinancingLog> getFinancingLogList() {
/* 578 */     return this.financingLogList;
/*     */   }
/*     */ 
/*     */   public void setFinancingLogList(List<FinancingLog> financingLogList) {
/* 582 */     this.financingLogList = financingLogList;
/*     */   }
/*     */ 
/*     */   public String getTitle() {
/* 586 */     return this.title;
/*     */   }
/*     */ 
/*     */   public void setTitle(String title) {
/* 590 */     this.title = title;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.financing.Financing
 * JD-Core Version:    0.6.0
 */