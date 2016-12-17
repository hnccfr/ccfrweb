/*     */ package com.hundsun.network.gates.genshan.biz.domain.financing;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.domain.BaseDomain;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumFinancingProcessNodes;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class FinancingLog extends BaseDomain
/*     */ {
/*     */   private static final long serialVersionUID = 8969352649108277605L;
/*     */   private Long id;
/*     */   private Long financingId;
/*     */   private String auditNode;
/*     */   private String auditResult;
/*     */   private String logRemark;
/*     */   private String attachedFilePath;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */   private String operator;
/*     */   private String type;
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  63 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/*  67 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public Long getFinancingId() {
/*  71 */     return this.financingId;
/*     */   }
/*     */ 
/*     */   public void setFinancingId(Long financingId) {
/*  75 */     this.financingId = financingId;
/*     */   }
/*     */ 
/*     */   public String getAuditNode() {
/*  79 */     return this.auditNode;
/*     */   }
/*     */ 
/*     */   public String getAuditNodeDes() {
/*  83 */     EnumFinancingProcessNodes eNode = EnumFinancingProcessNodes.indexByValue(this.auditNode);
/*  84 */     return eNode == null ? this.auditNode : eNode.getName();
/*     */   }
/*     */ 
/*     */   public void setAuditNode(String auditNode) {
/*  88 */     this.auditNode = auditNode;
/*     */   }
/*     */ 
/*     */   public String getAuditResult() {
/*  92 */     return this.auditResult;
/*     */   }
/*     */ 
/*     */   public void setAuditResult(String auditResult) {
/*  96 */     this.auditResult = auditResult;
/*     */   }
/*     */ 
/*     */   public String getLogRemark() {
/* 100 */     return this.logRemark;
/*     */   }
/*     */ 
/*     */   public void setLogRemark(String logRemark) {
/* 104 */     this.logRemark = logRemark;
/*     */   }
/*     */ 
/*     */   public String getAttachedFilePath() {
/* 108 */     return this.attachedFilePath;
/*     */   }
/*     */ 
/*     */   public void setAttachedFilePath(String attachedFilePath) {
/* 112 */     this.attachedFilePath = attachedFilePath;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate() {
/* 116 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate) {
/* 120 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify() {
/* 124 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify) {
/* 128 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getOperator() {
/* 132 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator) {
/* 136 */     this.operator = operator;
/*     */   }
/*     */ 
/*     */   public String getType() {
/* 140 */     return this.type;
/*     */   }
/*     */ 
/*     */   public void setType(String type) {
/* 144 */     this.type = type;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.financing.FinancingLog
 * JD-Core Version:    0.6.0
 */