/*    */ package com.hundsun.network.gates.fengshan.biz.domain.supplydemand;
/*    */ 
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.BaseDomain;
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
/* 26 */     return this.id;
/*    */   }
/*    */ 
/*    */   public void setId(Long id) {
/* 30 */     this.id = id;
/*    */   }
/*    */ 
/*    */   public Long getInfoId() {
/* 34 */     return this.infoId;
/*    */   }
/*    */ 
/*    */   public void setInfoId(Long infoId) {
/* 38 */     this.infoId = infoId;
/*    */   }
/*    */ 
/*    */   public String getMark() {
/* 42 */     return this.mark;
/*    */   }
/*    */ 
/*    */   public void setMark(String mark) {
/* 46 */     this.mark = mark;
/*    */   }
/*    */ 
/*    */   public String getAuditResult() {
/* 50 */     return this.auditResult;
/*    */   }
/*    */ 
/*    */   public void setAuditResult(String auditResult) {
/* 54 */     this.auditResult = auditResult;
/*    */   }
/*    */ 
/*    */   public String getOperatorType() {
/* 58 */     return this.operatorType;
/*    */   }
/*    */ 
/*    */   public void setOperatorType(String operatorType) {
/* 62 */     this.operatorType = operatorType;
/*    */   }
/*    */ 
/*    */   public String getOperator() {
/* 66 */     return this.operator;
/*    */   }
/*    */ 
/*    */   public void setOperator(String operator) {
/* 70 */     this.operator = operator;
/*    */   }
/*    */ 
/*    */   public Date getGmtCreate() {
/* 74 */     return this.gmtCreate;
/*    */   }
/*    */ 
/*    */   public void setGmtCreate(Date gmtCreate) {
/* 78 */     this.gmtCreate = gmtCreate;
/*    */   }
/*    */ 
/*    */   public Date getGmtModify() {
/* 82 */     return this.gmtModify;
/*    */   }
/*    */ 
/*    */   public void setGmtModify(Date gmtModify) {
/* 86 */     this.gmtModify = gmtModify;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.domain.supplydemand.SupplyDemandInfoAudit
 * JD-Core Version:    0.6.0
 */