/*     */ package com.hundsun.eclp.biz.domain.role;
/*     */ 
/*     */ import java.util.Date;
/*     */ 
/*     */ public class RoleSytem
/*     */ {
/*     */   private Long id;
/*     */   private Long roleId;
/*     */   private Long sysId;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  32 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/*  36 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public Long getRoleId() {
/*  40 */     return this.roleId;
/*     */   }
/*     */ 
/*     */   public void setRoleId(Long roleId) {
/*  44 */     this.roleId = roleId;
/*     */   }
/*     */ 
/*     */   public Long getSysId() {
/*  48 */     return this.sysId;
/*     */   }
/*     */ 
/*     */   public void setSysId(Long sysId) {
/*  52 */     this.sysId = sysId;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate() {
/*  56 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate) {
/*  60 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify() {
/*  64 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify) {
/*  68 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public int hashCode()
/*     */   {
/*  73 */     int prime = 31;
/*  74 */     int result = 1;
/*  75 */     result = 31 * result + (this.gmtCreate == null ? 0 : this.gmtCreate.hashCode());
/*     */ 
/*  77 */     result = 31 * result + (this.gmtModify == null ? 0 : this.gmtModify.hashCode());
/*     */ 
/*  79 */     result = 31 * result + (this.id == null ? 0 : this.id.hashCode());
/*  80 */     result = 31 * result + (this.roleId == null ? 0 : this.roleId.hashCode());
/*  81 */     result = 31 * result + (this.sysId == null ? 0 : this.sysId.hashCode());
/*  82 */     return result;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object obj)
/*     */   {
/*  87 */     if (this == obj)
/*  88 */       return true;
/*  89 */     if (obj == null)
/*  90 */       return false;
/*  91 */     if (getClass() != obj.getClass())
/*  92 */       return false;
/*  93 */     RoleSytem other = (RoleSytem)obj;
/*  94 */     if (this.gmtCreate == null) {
/*  95 */       if (other.gmtCreate != null)
/*  96 */         return false;
/*  97 */     } else if (!this.gmtCreate.equals(other.gmtCreate))
/*  98 */       return false;
/*  99 */     if (this.gmtModify == null) {
/* 100 */       if (other.gmtModify != null)
/* 101 */         return false;
/* 102 */     } else if (!this.gmtModify.equals(other.gmtModify))
/* 103 */       return false;
/* 104 */     if (this.id == null) {
/* 105 */       if (other.id != null)
/* 106 */         return false;
/* 107 */     } else if (!this.id.equals(other.id))
/* 108 */       return false;
/* 109 */     if (this.roleId == null) {
/* 110 */       if (other.roleId != null)
/* 111 */         return false;
/* 112 */     } else if (!this.roleId.equals(other.roleId))
/* 113 */       return false;
/* 114 */     if (this.sysId == null) {
/* 115 */       if (other.sysId != null)
/* 116 */         return false;
/* 117 */     } else if (!this.sysId.equals(other.sysId))
/* 118 */       return false;
/* 119 */     return true;
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/* 124 */     return "RoleSytem [id=" + this.id + ", roleId=" + this.roleId + ", sysId=" + this.sysId + ", gmtCreate=" + this.gmtCreate + ", gmtModify=" + this.gmtModify + "]";
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.domain.role.RoleSytem
 * JD-Core Version:    0.6.0
 */