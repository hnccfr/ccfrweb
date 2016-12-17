/*     */ package com.hundsun.network.gates.genshan.biz.domain.user;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.enums.UserTypeEnum;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class UserAccountAndUpgradeInfo
/*     */ {
/*     */   private Long id;
/*     */   private String account;
/*     */   private String type;
/*     */   private String name;
/*     */   private String mobile;
/*     */   private String userRole;
/*     */   private String applyLevel;
/*     */   private String applyLevelName;
/*     */   private Date gmtCreate;
/*     */   private String auditNode;
/*     */ 
/*     */   public String getAccount()
/*     */   {
/*  59 */     return this.account;
/*     */   }
/*     */ 
/*     */   public void setAccount(String account) {
/*  63 */     this.account = account;
/*     */   }
/*     */ 
/*     */   public String getType() {
/*  67 */     return this.type;
/*     */   }
/*     */ 
/*     */   public void setType(String type) {
/*  71 */     this.type = type;
/*     */   }
/*     */ 
/*     */   public String getName() {
/*  75 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setName(String name) {
/*  79 */     this.name = name;
/*     */   }
/*     */ 
/*     */   public String getMobile() {
/*  83 */     return this.mobile;
/*     */   }
/*     */ 
/*     */   public void setMobile(String mobile) {
/*  87 */     this.mobile = mobile;
/*     */   }
/*     */ 
/*     */   public String getUserRole() {
/*  91 */     return this.userRole;
/*     */   }
/*     */ 
/*     */   public void setUserRole(String userRole) {
/*  95 */     this.userRole = userRole;
/*     */   }
/*     */ 
/*     */   public String getApplyLevel() {
/*  99 */     return this.applyLevel;
/*     */   }
/*     */ 
/*     */   public void setApplyLevel(String applyLevel) {
/* 103 */     this.applyLevel = applyLevel;
/*     */   }
/*     */ 
/*     */   public String getApplyLevelName() {
/* 107 */     return this.applyLevelName;
/*     */   }
/*     */ 
/*     */   public void setApplyLevelName(String applyLevelName) {
/* 111 */     this.applyLevelName = applyLevelName;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate() {
/* 115 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate) {
/* 119 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setAuditNode(String auditNode) {
/* 123 */     this.auditNode = auditNode;
/*     */   }
/*     */ 
/*     */   public String getAuditNode() {
/* 127 */     return this.auditNode;
/*     */   }
/*     */ 
/*     */   public String getUserTypeDesc()
/*     */   {
/* 138 */     UserTypeEnum userTypeEnum = UserTypeEnum.indexByValue(this.type);
/* 139 */     if (null == userTypeEnum) {
/* 140 */       return this.type;
/*     */     }
/* 142 */     return userTypeEnum.getName();
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/* 146 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public Long getId() {
/* 150 */     return this.id;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.user.UserAccountAndUpgradeInfo
 * JD-Core Version:    0.6.0
 */