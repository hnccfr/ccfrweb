/*     */ package com.hundsun.network.gates.genshan.biz.domain.trade;
/*     */ 
/*     */ import java.util.Date;
/*     */ 
/*     */ public class WishOrderAudit
/*     */ {
/*     */   private Long id;
/*     */   private Long orderId;
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
/*  55 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/*  59 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public Long getOrderId()
/*     */   {
/*  66 */     return this.orderId;
/*     */   }
/*     */ 
/*     */   public void setOrderId(Long orderId)
/*     */   {
/*  73 */     this.orderId = orderId;
/*     */   }
/*     */ 
/*     */   public String getProcessAuditNodes()
/*     */   {
/*  80 */     return this.processAuditNodes;
/*     */   }
/*     */ 
/*     */   public void setProcessAuditNodes(String processAuditNodes)
/*     */   {
/*  87 */     this.processAuditNodes = processAuditNodes;
/*     */   }
/*     */ 
/*     */   public String getAuditNode()
/*     */   {
/*  94 */     return this.auditNode;
/*     */   }
/*     */ 
/*     */   public void setAuditNode(String auditNode)
/*     */   {
/* 101 */     this.auditNode = auditNode;
/*     */   }
/*     */ 
/*     */   public String getAuditRes()
/*     */   {
/* 108 */     return this.auditRes;
/*     */   }
/*     */ 
/*     */   public void setAuditRes(String auditRes)
/*     */   {
/* 115 */     this.auditRes = auditRes;
/*     */   }
/*     */ 
/*     */   public String getAuditMemo()
/*     */   {
/* 122 */     return this.auditMemo;
/*     */   }
/*     */ 
/*     */   public void setAuditMemo(String auditMemo)
/*     */   {
/* 129 */     this.auditMemo = auditMemo;
/*     */   }
/*     */ 
/*     */   public String getOperatorType()
/*     */   {
/* 136 */     return this.operatorType;
/*     */   }
/*     */ 
/*     */   public void setOperatorType(String operatorType)
/*     */   {
/* 143 */     this.operatorType = operatorType;
/*     */   }
/*     */ 
/*     */   public String getOperator()
/*     */   {
/* 150 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator)
/*     */   {
/* 157 */     this.operator = operator;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate() {
/* 161 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate) {
/* 165 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify() {
/* 169 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify) {
/* 173 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.trade.WishOrderAudit
 * JD-Core Version:    0.6.0
 */