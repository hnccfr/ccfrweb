/*     */ package com.hundsun.network.gates.fengshan.biz.domain.user;
/*     */ 
/*     */ import com.hundsun.network.gates.fengshan.biz.enums.UserRoleEnum;
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class UserRole
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 2687720845719803593L;
/*     */   private Long id;
/*     */   private String name;
/*     */   private String description;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */   private String operator;
/*     */   private Long ranking;
/*     */   private String remark;
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  53 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/*  57 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getName() {
/*  61 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setName(String name) {
/*  65 */     this.name = name;
/*     */   }
/*     */ 
/*     */   public String getDescription() {
/*  69 */     return this.description;
/*     */   }
/*     */ 
/*     */   public void setDescription(String description) {
/*  73 */     this.description = description;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate() {
/*  77 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate) {
/*  81 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify() {
/*  85 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify) {
/*  89 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getOperator() {
/*  93 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator) {
/*  97 */     this.operator = operator;
/*     */   }
/*     */ 
/*     */   public String getUserRoleDesc() {
/* 101 */     UserRoleEnum userRoleEnum = UserRoleEnum.indexByValue(this.name);
/* 102 */     if (null == userRoleEnum) {
/* 103 */       return this.name;
/*     */     }
/* 105 */     return userRoleEnum.getName();
/*     */   }
/*     */ 
/*     */   public Long getRanking() {
/* 109 */     return this.ranking;
/*     */   }
/*     */ 
/*     */   public void setRanking(Long ranking) {
/* 113 */     this.ranking = ranking;
/*     */   }
/*     */ 
/*     */   public String getRemark() {
/* 117 */     return this.remark;
/*     */   }
/*     */ 
/*     */   public void setRemark(String remark) {
/* 121 */     this.remark = remark;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.domain.user.UserRole
 * JD-Core Version:    0.6.0
 */