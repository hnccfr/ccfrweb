/*     */ package com.hundsun.network.gates.wulin.biz.domain.project;
/*     */ 
/*     */ import com.hundsun.network.gates.wulin.biz.domain.BaseDomain;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class ProjectMetas extends BaseDomain
/*     */ {
/*     */   private static final long serialVersionUID = 7936560541073771709L;
/*     */   private Long id;
/*     */   private String metaGroup;
/*     */   private Long projectId;
/*     */   private String metaKey;
/*     */   private String metaTitle;
/*     */   private String metaValue;
/*     */   private String operator;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  47 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/*  51 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getMetaGroup()
/*     */   {
/*  58 */     return this.metaGroup;
/*     */   }
/*     */ 
/*     */   public void setMetaGroup(String metaGroup)
/*     */   {
/*  65 */     this.metaGroup = metaGroup;
/*     */   }
/*     */ 
/*     */   public Long getProjectId()
/*     */   {
/*  72 */     return this.projectId;
/*     */   }
/*     */ 
/*     */   public void setProjectId(Long projectId)
/*     */   {
/*  79 */     this.projectId = projectId;
/*     */   }
/*     */ 
/*     */   public String getMetaKey()
/*     */   {
/*  86 */     return this.metaKey;
/*     */   }
/*     */ 
/*     */   public void setMetaKey(String metaKey)
/*     */   {
/*  93 */     this.metaKey = metaKey;
/*     */   }
/*     */ 
/*     */   public String getMetaTitle()
/*     */   {
/* 100 */     return this.metaTitle;
/*     */   }
/*     */ 
/*     */   public void setMetaTitle(String metaTitle)
/*     */   {
/* 107 */     this.metaTitle = metaTitle;
/*     */   }
/*     */ 
/*     */   public String getMetaValue()
/*     */   {
/* 114 */     return this.metaValue;
/*     */   }
/*     */ 
/*     */   public void setMetaValue(String metaValue)
/*     */   {
/* 121 */     this.metaValue = metaValue;
/*     */   }
/*     */ 
/*     */   public String getOperator()
/*     */   {
/* 128 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator)
/*     */   {
/* 135 */     this.operator = operator;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate() {
/* 139 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate) {
/* 143 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify() {
/* 147 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify) {
/* 151 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.domain.project.ProjectMetas
 * JD-Core Version:    0.6.0
 */