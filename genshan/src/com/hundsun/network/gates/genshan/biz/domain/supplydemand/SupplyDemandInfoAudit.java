/*    */ package com.hundsun.network.gates.genshan.biz.domain.supplydemand;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.domain.BaseDomain;
/*    */ import java.util.Date;
/*    */ 
/*    */ public class SupplyDemandInfoAudit extends BaseDomain
/*    */ {
/*    */   private static final long serialVersionUID = -3848485716634319653L;
/*    */   private Long id;
/*    */   private Long infoId;
/*    */   private String auditResult;
/*    */   private String mark;
/*    */   private String operatorType;
/*    */   private String operator;
/*    */   private Date gmtCreate;
/*    */   private Date gmtModify;
/*    */ 
/*    */   public Long getId()
/*    */   {
/* 28 */     return this.id;
/*    */   }
/*    */ 
/*    */   public void setId(Long id) {
/* 32 */     this.id = id;
/*    */   }
/*    */ 
/*    */   public Long getInfoId() {
/* 36 */     return this.infoId;
/*    */   }
/*    */ 
/*    */   public void setInfoId(Long infoId) {
/* 40 */     this.infoId = infoId;
/*    */   }
/*    */ 
/*    */   public String getMark() {
/* 44 */     return this.mark;
/*    */   }
/*    */ 
/*    */   public void setMark(String mark) {
/* 48 */     this.mark = mark;
/*    */   }
/*    */ 
/*    */   public String getAuditResult() {
/* 52 */     return this.auditResult;
/*    */   }
/*    */ 
/*    */   public void setAuditResult(String auditResult) {
/* 56 */     this.auditResult = auditResult;
/*    */   }
/*    */ 
/*    */   public String getOperatorType() {
/* 60 */     return this.operatorType;
/*    */   }
/*    */ 
/*    */   public void setOperatorType(String operatorType) {
/* 64 */     this.operatorType = operatorType;
/*    */   }
/*    */ 
/*    */   public String getOperator() {
/* 68 */     return this.operator;
/*    */   }
/*    */ 
/*    */   public void setOperator(String operator) {
/* 72 */     this.operator = operator;
/*    */   }
/*    */ 
/*    */   public Date getGmtCreate() {
/* 76 */     return this.gmtCreate;
/*    */   }
/*    */ 
/*    */   public void setGmtCreate(Date gmtCreate) {
/* 80 */     this.gmtCreate = gmtCreate;
/*    */   }
/*    */ 
/*    */   public Date getGmtModify() {
/* 84 */     return this.gmtModify;
/*    */   }
/*    */ 
/*    */   public void setGmtModify(Date gmtModify) {
/* 88 */     this.gmtModify = gmtModify;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.supplydemand.SupplyDemandInfoAudit
 * JD-Core Version:    0.6.0
 */