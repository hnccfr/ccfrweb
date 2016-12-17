/*     */ package com.hundsun.network.gates.qingbo.biz.domain.project;
/*     */ 
/*     */ import com.hundsun.network.gates.qingbo.biz.domain.BaseDomain;
/*     */ 
/*     */ public class ClearProject extends BaseDomain
/*     */ {
/*     */   private static final long serialVersionUID = -9138860603385653189L;
/*     */   private String projectId;
/*     */   private String projectName;
/*     */   private String projectCoce;
/*     */   private String projectStatus;
/*     */   private Long quantity;
/*     */   private Long userId;
/*     */   private String userAccount;
/*     */ 
/*     */   public String getProjectId()
/*     */   {
/*  49 */     return this.projectId;
/*     */   }
/*     */ 
/*     */   public void setProjectId(String projectId) {
/*  53 */     this.projectId = projectId;
/*     */   }
/*     */ 
/*     */   public String getProjectName() {
/*  57 */     return this.projectName;
/*     */   }
/*     */ 
/*     */   public void setProjectName(String projectName) {
/*  61 */     this.projectName = projectName;
/*     */   }
/*     */ 
/*     */   public String getProjectCoce() {
/*  65 */     return this.projectCoce;
/*     */   }
/*     */ 
/*     */   public void setProjectCoce(String projectCoce) {
/*  69 */     this.projectCoce = projectCoce;
/*     */   }
/*     */ 
/*     */   public String getProjectStatus() {
/*  73 */     return this.projectStatus;
/*     */   }
/*     */ 
/*     */   public void setProjectStatus(String projectStatus) {
/*  77 */     this.projectStatus = projectStatus;
/*     */   }
/*     */ 
/*     */   public Long getQuantity() {
/*  81 */     return this.quantity;
/*     */   }
/*     */ 
/*     */   public void setQuantity(Long quantity) {
/*  85 */     this.quantity = quantity;
/*     */   }
/*     */ 
/*     */   public Long getUserId() {
/*  89 */     return this.userId;
/*     */   }
/*     */ 
/*     */   public void setUserId(Long userId) {
/*  93 */     this.userId = userId;
/*     */   }
/*     */ 
/*     */   public String getUserAccount() {
/*  97 */     return this.userAccount;
/*     */   }
/*     */ 
/*     */   public void setUserAccount(String userAccount) {
/* 101 */     this.userAccount = userAccount;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.qingbo.biz.domain.project.ClearProject
 * JD-Core Version:    0.6.0
 */