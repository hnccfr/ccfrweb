/*     */ package com.hundsun.network.gates.fengshan.biz.domain.user;
/*     */ 
/*     */ import com.hundsun.network.gates.fengshan.biz.enums.UserRoleEnum;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumUserCheckProcess;
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class UserUpgradeAudit
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -2151745654706255804L;
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
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  79 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public Long getId() {
/*  83 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setUserAccount(String userAccount) {
/*  87 */     this.userAccount = userAccount;
/*     */   }
/*     */ 
/*     */   public String getUserAccount() {
/*  91 */     return this.userAccount;
/*     */   }
/*     */ 
/*     */   public String getApplyLevel() {
/*  95 */     return this.applyLevel;
/*     */   }
/*     */ 
/*     */   public void setApplyLevel(String applyLevel) {
/*  99 */     this.applyLevel = applyLevel;
/*     */   }
/*     */ 
/*     */   public String getAuditProcess() {
/* 103 */     return this.auditProcess;
/*     */   }
/*     */ 
/*     */   public void setAuditProcess(String auditProcess) {
/* 107 */     this.auditProcess = auditProcess;
/*     */   }
/*     */ 
/*     */   public String getAuditNode() {
/* 111 */     return this.auditNode;
/*     */   }
/*     */ 
/*     */   public void setAuditNode(String auditNode) {
/* 115 */     this.auditNode = auditNode;
/*     */   }
/*     */ 
/*     */   public String getAuditNodeResult() {
/* 119 */     return this.auditNodeResult;
/*     */   }
/*     */ 
/*     */   public void setAuditNodeResult(String auditNodeResult) {
/* 123 */     this.auditNodeResult = auditNodeResult;
/*     */   }
/*     */ 
/*     */   public String getAuditNodeRemark() {
/* 127 */     return this.auditNodeRemark;
/*     */   }
/*     */ 
/*     */   public void setAuditNodeRemark(String auditNodeRemark) {
/* 131 */     this.auditNodeRemark = auditNodeRemark;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate() {
/* 135 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate) {
/* 139 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify() {
/* 143 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify) {
/* 147 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getOperator() {
/* 151 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator) {
/* 155 */     this.operator = operator;
/*     */   }
/*     */ 
/*     */   public String getOperateType() {
/* 159 */     return this.operateType;
/*     */   }
/*     */ 
/*     */   public void setOperateType(String operateType) {
/* 163 */     this.operateType = operateType;
/*     */   }
/*     */   public String getAppRoleDesc() {
/* 166 */     UserRoleEnum userRoleEnum = UserRoleEnum.indexByValue(this.applyLevel);
/* 167 */     if (null == userRoleEnum) {
/* 168 */       return this.applyLevel;
/*     */     }
/* 170 */     return userRoleEnum.getName();
/*     */   }
/*     */ 
/*     */   public String getAuditNodeDesc()
/*     */   {
/* 181 */     EnumUserCheckProcess userCheckProcess = EnumUserCheckProcess.indexByValue(this.auditNode);
/* 182 */     if (null == userCheckProcess) {
/* 183 */       return this.applyLevel;
/*     */     }
/* 185 */     return userCheckProcess.getName();
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.domain.user.UserUpgradeAudit
 * JD-Core Version:    0.6.0
 */