/*     */ package com.hundsun.network.gates.genshan.biz.domain.user;
/*     */ 
/*     */ import java.util.Date;
/*     */ 
/*     */ public class UserUpgradeAudit
/*     */ {
/*     */   private Long id;
/*     */   private String userAccount;
/*     */   private String applyLevel;
/*     */   private String auditProcess;
/*     */   private String auditNode;
/*     */   private String auditNodeResult;
/*     */   private String auditNodeRemark;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */   private String operator;
/*     */   private String operateType;
/*     */   private String applyLevelName;
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  73 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/*  77 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getUserAccount() {
/*  81 */     return this.userAccount;
/*     */   }
/*     */ 
/*     */   public void setUserAccount(String userAccount) {
/*  85 */     this.userAccount = userAccount;
/*     */   }
/*     */ 
/*     */   public String getApplyLevel() {
/*  89 */     return this.applyLevel;
/*     */   }
/*     */ 
/*     */   public void setApplyLevel(String applyLevel) {
/*  93 */     this.applyLevel = applyLevel;
/*     */   }
/*     */ 
/*     */   public String getAuditProcess() {
/*  97 */     return this.auditProcess;
/*     */   }
/*     */ 
/*     */   public void setAuditProcess(String auditProcess) {
/* 101 */     this.auditProcess = auditProcess;
/*     */   }
/*     */ 
/*     */   public String getAuditNode() {
/* 105 */     return this.auditNode;
/*     */   }
/*     */ 
/*     */   public void setAuditNode(String auditNode) {
/* 109 */     this.auditNode = auditNode;
/*     */   }
/*     */ 
/*     */   public String getAuditNodeResult() {
/* 113 */     return this.auditNodeResult;
/*     */   }
/*     */ 
/*     */   public void setAuditNodeResult(String auditNodeResult) {
/* 117 */     this.auditNodeResult = auditNodeResult;
/*     */   }
/*     */ 
/*     */   public String getAuditNodeRemark() {
/* 121 */     return this.auditNodeRemark;
/*     */   }
/*     */ 
/*     */   public void setAuditNodeRemark(String auditNodeRemark) {
/* 125 */     this.auditNodeRemark = auditNodeRemark;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate() {
/* 129 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate) {
/* 133 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify() {
/* 137 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify) {
/* 141 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getOperator() {
/* 145 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator) {
/* 149 */     this.operator = operator;
/*     */   }
/*     */ 
/*     */   public String getOperateType() {
/* 153 */     return this.operateType;
/*     */   }
/*     */ 
/*     */   public void setOperateType(String operateType) {
/* 157 */     this.operateType = operateType;
/*     */   }
/*     */ 
/*     */   public void setApplyLevelName(String applyLevelName) {
/* 161 */     this.applyLevelName = applyLevelName;
/*     */   }
/*     */ 
/*     */   public String getApplyLevelName() {
/* 165 */     return this.applyLevelName;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.user.UserUpgradeAudit
 * JD-Core Version:    0.6.0
 */