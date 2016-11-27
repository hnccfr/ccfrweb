/*     */ package com.hundsun.network.gates.wulin.biz.domain.project;
/*     */ 
/*     */ import com.hundsun.network.gates.wulin.biz.domain.BaseDomain;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class ProjectAuditLog extends BaseDomain
/*     */ {
/*     */   private static final long serialVersionUID = 831742532570424760L;
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
/*  52 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/*  56 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public Long getProjectId()
/*     */   {
/*  63 */     return this.projectId;
/*     */   }
/*     */ 
/*     */   public void setProjectId(Long projectId)
/*     */   {
/*  70 */     this.projectId = projectId;
/*     */   }
/*     */ 
/*     */   public String getProcessAuditNodes()
/*     */   {
/*  77 */     return this.processAuditNodes;
/*     */   }
/*     */ 
/*     */   public void setProcessAuditNodes(String processAuditNodes)
/*     */   {
/*  84 */     this.processAuditNodes = processAuditNodes;
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
/*     */   public String getAuditRes()
/*     */   {
/* 105 */     return this.auditRes;
/*     */   }
/*     */ 
/*     */   public void setAuditRes(String auditRes)
/*     */   {
/* 112 */     this.auditRes = auditRes;
/*     */   }
/*     */ 
/*     */   public String getAuditMemo()
/*     */   {
/* 119 */     return this.auditMemo;
/*     */   }
/*     */ 
/*     */   public void setAuditMemo(String auditMemo)
/*     */   {
/* 126 */     this.auditMemo = auditMemo;
/*     */   }
/*     */ 
/*     */   public String getOperatorType()
/*     */   {
/* 133 */     return this.operatorType;
/*     */   }
/*     */ 
/*     */   public void setOperatorType(String operatorType)
/*     */   {
/* 140 */     this.operatorType = operatorType;
/*     */   }
/*     */ 
/*     */   public String getOperator()
/*     */   {
/* 147 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator)
/*     */   {
/* 154 */     this.operator = operator;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate() {
/* 158 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate) {
/* 162 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify() {
/* 166 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify) {
/* 170 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.domain.project.ProjectAuditLog
 * JD-Core Version:    0.6.0
 */