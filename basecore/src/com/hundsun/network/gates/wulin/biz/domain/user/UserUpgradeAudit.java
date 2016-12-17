/*     */ package com.hundsun.network.gates.wulin.biz.domain.user;
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
/*     */   private Object operateType;
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  44 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/*  48 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getUserAccount() {
/*  52 */     return this.userAccount;
/*     */   }
/*     */ 
/*     */   public void setUserAccount(String userAccount) {
/*  56 */     this.userAccount = userAccount;
/*     */   }
/*     */ 
/*     */   public String getApplyLevel()
/*     */   {
/*  63 */     return this.applyLevel;
/*     */   }
/*     */ 
/*     */   public void setApplyLevel(String applyLevel)
/*     */   {
/*  70 */     this.applyLevel = applyLevel;
/*     */   }
/*     */ 
/*     */   public String getAuditProcess()
/*     */   {
/*  77 */     return this.auditProcess;
/*     */   }
/*     */ 
/*     */   public void setAuditProcess(String auditProcess)
/*     */   {
/*  84 */     this.auditProcess = auditProcess;
/*     */   }
/*     */ 
/*     */   public String getAuditNode()
/*     */   {
/*  91 */     return this.auditNode;
/*     */   }
/*     */ 
/*     */   public void setAuditNode(String auditNode)
/*     */   {
/*  98 */     this.auditNode = auditNode;
/*     */   }
/*     */ 
/*     */   public String getAuditNodeResult()
/*     */   {
/* 105 */     return this.auditNodeResult;
/*     */   }
/*     */ 
/*     */   public void setAuditNodeResult(String auditNodeResult)
/*     */   {
/* 112 */     this.auditNodeResult = auditNodeResult;
/*     */   }
/*     */ 
/*     */   public String getAuditNodeRemark()
/*     */   {
/* 119 */     return this.auditNodeRemark;
/*     */   }
/*     */ 
/*     */   public void setAuditNodeRemark(String auditNodeRemark)
/*     */   {
/* 126 */     this.auditNodeRemark = auditNodeRemark;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate() {
/* 130 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate) {
/* 134 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify() {
/* 138 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify) {
/* 142 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public Object getOperateType() {
/* 146 */     return this.operateType;
/*     */   }
/*     */ 
/*     */   public void setOperateType(Object operateType) {
/* 150 */     this.operateType = operateType;
/*     */   }
/*     */ 
/*     */   public String getOperator() {
/* 154 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator) {
/* 158 */     this.operator = operator;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.domain.user.UserUpgradeAudit
 * JD-Core Version:    0.6.0
 */