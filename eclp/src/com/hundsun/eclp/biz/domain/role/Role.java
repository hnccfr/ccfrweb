/*     */ package com.hundsun.eclp.biz.domain.role;
/*     */ 
/*     */ import java.util.Date;
/*     */ import org.apache.commons.lang.builder.EqualsBuilder;
/*     */ import org.apache.commons.lang.builder.HashCodeBuilder;
/*     */ import org.apache.commons.lang.builder.ToStringBuilder;
/*     */ 
/*     */ public class Role
/*     */ {
/*     */   private Long id;
/*     */   private String code;
/*     */   private String displayName;
/*     */   private Short status;
/*     */   private Long sort;
/*     */   private String isDeleted;
/*     */   private String remark;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*  56 */   private String isSelected = "N";
/*     */   private Short isCore;
/*     */   private Short roleType;
/*     */ 
/*     */   public Short getRoleType()
/*     */   {
/*  66 */     return this.roleType;
/*     */   }
/*     */ 
/*     */   public void setRoleType(Short roleType) {
/*  70 */     this.roleType = roleType;
/*     */   }
/*     */ 
/*     */   public String getIsSelected() {
/*  74 */     return this.isSelected;
/*     */   }
/*     */ 
/*     */   public void setIsSelected(String isSelected) {
/*  78 */     this.isSelected = isSelected;
/*     */   }
/*     */ 
/*     */   public Long getId() {
/*  82 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/*  86 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getCode() {
/*  90 */     return this.code;
/*     */   }
/*     */ 
/*     */   public void setCode(String code) {
/*  94 */     this.code = code;
/*     */   }
/*     */ 
/*     */   public String getDisplayName() {
/*  98 */     return this.displayName;
/*     */   }
/*     */ 
/*     */   public void setDisplayName(String displayName) {
/* 102 */     this.displayName = displayName;
/*     */   }
/*     */ 
/*     */   public Short getStatus() {
/* 106 */     return this.status;
/*     */   }
/*     */ 
/*     */   public void setStatus(Short status) {
/* 110 */     this.status = status;
/*     */   }
/*     */ 
/*     */   public Long getSort() {
/* 114 */     return this.sort;
/*     */   }
/*     */ 
/*     */   public void setSort(Long sort) {
/* 118 */     this.sort = sort;
/*     */   }
/*     */ 
/*     */   public String getIsDeleted() {
/* 122 */     return this.isDeleted;
/*     */   }
/*     */ 
/*     */   public void setIsDeleted(String isDeleted) {
/* 126 */     this.isDeleted = isDeleted;
/*     */   }
/*     */ 
/*     */   public String getRemark() {
/* 130 */     return this.remark;
/*     */   }
/*     */ 
/*     */   public void setRemark(String remark) {
/* 134 */     this.remark = remark;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate() {
/* 138 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate) {
/* 142 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify() {
/* 146 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify) {
/* 150 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public Short getIsCore() {
/* 154 */     return this.isCore;
/*     */   }
/*     */ 
/*     */   public void setIsCore(Short isCore) {
/* 158 */     this.isCore = isCore;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object object)
/*     */   {
/* 165 */     if (!(object instanceof Role)) {
/* 166 */       return false;
/*     */     }
/* 168 */     Role rhs = (Role)object;
/* 169 */     return new EqualsBuilder().appendSuper(super.equals(object)).append(this.id, rhs.id).append(this.sort, rhs.sort).append(this.gmtCreate, rhs.gmtCreate).append(this.isSelected, rhs.isSelected).append(this.remark, rhs.remark).append(this.status, rhs.status).append(this.gmtModify, rhs.gmtModify).append(this.isCore, rhs.isCore).append(this.code, rhs.code).append(this.isDeleted, rhs.isDeleted).append(this.displayName, rhs.displayName).isEquals();
/*     */   }
/*     */ 
/*     */   public int hashCode()
/*     */   {
/* 182 */     return new HashCodeBuilder(1784869915, 699864479).appendSuper(super.hashCode()).append(this.id).append(this.sort).append(this.gmtCreate).append(this.isSelected).append(this.remark).append(this.status).append(this.gmtModify).append(this.isCore).append(this.code).append(this.isDeleted).append(this.displayName).toHashCode();
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/* 192 */     return new ToStringBuilder(this).append("remark", this.remark).append("isDeleted", this.isDeleted).append("status", this.status).append("sort", this.sort).append("displayName", this.displayName).append("code", this.code).append("isSelected", this.isSelected).append("isCore", this.isCore).append("gmtCreate", this.gmtCreate).append("gmtModify", this.gmtModify).append("id", this.id).toString();
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.domain.role.Role
 * JD-Core Version:    0.6.0
 */