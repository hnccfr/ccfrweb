/*     */ package com.hundsun.eclp.biz.domain.role;
/*     */ 
/*     */ public class RoleAuthority
/*     */ {
/*     */   private Long id;
/*     */   private Long roleId;
/*     */   private Long authId;
/*     */   private String isDeleted;
/*     */   private Long parentAuthId;
/*     */ 
/*     */   public Long getParentAuthId()
/*     */   {
/*  29 */     return this.parentAuthId;
/*     */   }
/*     */ 
/*     */   public void setParentAuthId(Long parentAuthId) {
/*  33 */     this.parentAuthId = parentAuthId;
/*     */   }
/*     */ 
/*     */   public Long getId() {
/*  37 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/*  41 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public Long getRoleId() {
/*  45 */     return this.roleId;
/*     */   }
/*     */ 
/*     */   public void setRoleId(Long roleId) {
/*  49 */     this.roleId = roleId;
/*     */   }
/*     */ 
/*     */   public Long getAuthId() {
/*  53 */     return this.authId;
/*     */   }
/*     */ 
/*     */   public void setAuthId(Long authId) {
/*  57 */     this.authId = authId;
/*     */   }
/*     */ 
/*     */   public String getIsDeleted() {
/*  61 */     return this.isDeleted;
/*     */   }
/*     */ 
/*     */   public void setIsDeleted(String isDeleted) {
/*  65 */     this.isDeleted = isDeleted;
/*     */   }
/*     */ 
/*     */   public int hashCode()
/*     */   {
/*  70 */     int prime = 31;
/*  71 */     int result = 1;
/*  72 */     result = 31 * result + (this.authId == null ? 0 : this.authId.hashCode());
/*  73 */     result = 31 * result + (this.id == null ? 0 : this.id.hashCode());
/*  74 */     result = 31 * result + (this.isDeleted == null ? 0 : this.isDeleted.hashCode());
/*     */ 
/*  76 */     result = 31 * result + (this.roleId == null ? 0 : this.roleId.hashCode());
/*  77 */     return result;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object obj)
/*     */   {
/*  82 */     if (this == obj)
/*  83 */       return true;
/*  84 */     if (obj == null)
/*  85 */       return false;
/*  86 */     if (getClass() != obj.getClass())
/*  87 */       return false;
/*  88 */     RoleAuthority other = (RoleAuthority)obj;
/*  89 */     if (this.authId == null) {
/*  90 */       if (other.authId != null)
/*  91 */         return false;
/*  92 */     } else if (!this.authId.equals(other.authId))
/*  93 */       return false;
/*  94 */     if (this.id == null) {
/*  95 */       if (other.id != null)
/*  96 */         return false;
/*  97 */     } else if (!this.id.equals(other.id))
/*  98 */       return false;
/*  99 */     if (this.isDeleted == null) {
/* 100 */       if (other.isDeleted != null)
/* 101 */         return false;
/* 102 */     } else if (!this.isDeleted.equals(other.isDeleted))
/* 103 */       return false;
/* 104 */     if (this.roleId == null) {
/* 105 */       if (other.roleId != null)
/* 106 */         return false;
/* 107 */     } else if (!this.roleId.equals(other.roleId))
/* 108 */       return false;
/* 109 */     return true;
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/* 114 */     return "RoleAuthority [id=" + this.id + ", roleId=" + this.roleId + ", authId=" + this.authId + ", isDeleted=" + this.isDeleted + "]";
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.domain.role.RoleAuthority
 * JD-Core Version:    0.6.0
 */