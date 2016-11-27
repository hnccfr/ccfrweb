/*     */ package com.hundsun.eclp.biz.domain.dept;
/*     */ 
/*     */ import java.util.Date;
/*     */ 
/*     */ public class Department
/*     */ {
/*     */   private Long id;
/*     */   private String name;
/*     */   private Long parentId;
/*     */   private Short sort;
/*     */   private Short status;
/*     */   private String remark;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */   private String fullName;
/*     */ 
/*     */   public String getFullName()
/*     */   {
/*  53 */     return this.fullName;
/*     */   }
/*     */ 
/*     */   public void setFullName(String fullName) {
/*  57 */     this.fullName = fullName;
/*     */   }
/*     */ 
/*     */   public Long getId() {
/*  61 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/*  65 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getName() {
/*  69 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setName(String name) {
/*  73 */     this.name = name;
/*     */   }
/*     */ 
/*     */   public Long getParentId() {
/*  77 */     return this.parentId;
/*     */   }
/*     */ 
/*     */   public void setParentId(Long parentId) {
/*  81 */     this.parentId = parentId;
/*     */   }
/*     */ 
/*     */   public Short getSort() {
/*  85 */     return this.sort;
/*     */   }
/*     */ 
/*     */   public void setSort(Short sort) {
/*  89 */     this.sort = sort;
/*     */   }
/*     */ 
/*     */   public Short getStatus() {
/*  93 */     return this.status;
/*     */   }
/*     */ 
/*     */   public void setStatus(Short status) {
/*  97 */     this.status = status;
/*     */   }
/*     */ 
/*     */   public String getRemark() {
/* 101 */     return this.remark;
/*     */   }
/*     */ 
/*     */   public void setRemark(String remark) {
/* 105 */     this.remark = remark;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate() {
/* 109 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate) {
/* 113 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify() {
/* 117 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify) {
/* 121 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.domain.dept.Department
 * JD-Core Version:    0.6.0
 */