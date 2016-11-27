/*     */ package com.hundsun.network.gates.fengshan.biz.domain.project;
/*     */ 
/*     */ import java.util.Date;
/*     */ 
/*     */ public class ProjectAuditLog
/*     */ {
/*     */   private Long id;
/*     */   private Long projectId;
/*     */   private String processAuditNodes;
/*     */   private String auditNode;
/*     */   private String auditRes;
/*     */   private String auditMemo;
/*     */   private String operatorType;
/*     */   private String operator;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  48 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/*  52 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public Long getProjectId()
/*     */   {
/*  59 */     return this.projectId;
/*     */   }
/*     */ 
/*     */   public void setProjectId(Long projectId)
/*     */   {
/*  66 */     this.projectId = projectId;
/*     */   }
/*     */ 
/*     */   public String getProcessAuditNodes()
/*     */   {
/*  73 */     return this.processAuditNodes;
/*     */   }
/*     */ 
/*     */   public void setProcessAuditNodes(String processAuditNodes)
/*     */   {
/*  80 */     this.processAuditNodes = processAuditNodes;
/*     */   }
/*     */ 
/*     */   public String getAuditNode()
/*     */   {
/*  87 */     return this.auditNode;
/*     */   }
/*     */ 
/*     */   public void setAuditNode(String auditNode)
/*     */   {
/*  94 */     this.auditNode = auditNode;
/*     */   }
/*     */ 
/*     */   public String getAuditRes()
/*     */   {
/* 101 */     return this.auditRes;
/*     */   }
/*     */ 
/*     */   public void setAuditRes(String auditRes)
/*     */   {
/* 108 */     this.auditRes = auditRes;
/*     */   }
/*     */ 
/*     */   public String getAuditMemo()
/*     */   {
/* 115 */     return this.auditMemo;
/*     */   }
/*     */ 
/*     */   public void setAuditMemo(String auditMemo)
/*     */   {
/* 122 */     this.auditMemo = auditMemo;
/*     */   }
/*     */ 
/*     */   public String getOperatorType()
/*     */   {
/* 129 */     return this.operatorType;
/*     */   }
/*     */ 
/*     */   public void setOperatorType(String operatorType)
/*     */   {
/* 136 */     this.operatorType = operatorType;
/*     */   }
/*     */ 
/*     */   public String getOperator()
/*     */   {
/* 143 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator)
/*     */   {
/* 150 */     this.operator = operator;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate() {
/* 154 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate) {
/* 158 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify() {
/* 162 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify) {
/* 166 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.domain.project.ProjectAuditLog
 * JD-Core Version:    0.6.0
 */