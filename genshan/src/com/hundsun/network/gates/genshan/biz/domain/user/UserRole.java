/*     */ package com.hundsun.network.gates.genshan.biz.domain.user;
/*     */ 
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
/*  55 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/*  59 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getName() {
/*  63 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setName(String name) {
/*  67 */     this.name = name;
/*     */   }
/*     */ 
/*     */   public String getDescription() {
/*  71 */     return this.description;
/*     */   }
/*     */ 
/*     */   public void setDescription(String description) {
/*  75 */     this.description = description;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate() {
/*  79 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate) {
/*  83 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify() {
/*  87 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify) {
/*  91 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getOperator() {
/*  95 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator) {
/*  99 */     this.operator = operator;
/*     */   }
/*     */ 
/*     */   public Long getRanking() {
/* 103 */     return this.ranking;
/*     */   }
/*     */ 
/*     */   public void setRanking(Long ranking) {
/* 107 */     this.ranking = ranking;
/*     */   }
/*     */ 
/*     */   public String getRemark() {
/* 111 */     return this.remark;
/*     */   }
/*     */ 
/*     */   public void setRemark(String remark) {
/* 115 */     this.remark = remark;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.user.UserRole
 * JD-Core Version:    0.6.0
 */