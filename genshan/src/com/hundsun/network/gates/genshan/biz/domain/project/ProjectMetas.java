/*     */ package com.hundsun.network.gates.genshan.biz.domain.project;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ 
/*     */ public class ProjectMetas
/*     */ {
/*     */   private Long id;
/*     */   private String metaGroup;
/*     */   private Long projectId;
/*     */   private String metaKey;
/*     */   private String metaTitle;
/*     */   private String metaValue;
/*     */   private String inputType;
/*     */   private String operator;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  51 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/*  55 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getMetaGroup()
/*     */   {
/*  62 */     return this.metaGroup;
/*     */   }
/*     */ 
/*     */   public void setMetaGroup(String metaGroup)
/*     */   {
/*  69 */     this.metaGroup = metaGroup;
/*     */   }
/*     */ 
/*     */   public Long getProjectId()
/*     */   {
/*  76 */     return this.projectId;
/*     */   }
/*     */ 
/*     */   public void setProjectId(Long projectId)
/*     */   {
/*  83 */     this.projectId = projectId;
/*     */   }
/*     */ 
/*     */   public String getMetaKey()
/*     */   {
/*  90 */     return this.metaKey;
/*     */   }
/*     */ 
/*     */   public void setMetaKey(String metaKey)
/*     */   {
/*  97 */     this.metaKey = metaKey;
/*     */   }
/*     */ 
/*     */   public String getMetaTitle()
/*     */   {
/* 104 */     return this.metaTitle;
/*     */   }
/*     */ 
/*     */   public void setMetaTitle(String metaTitle)
/*     */   {
/* 111 */     this.metaTitle = metaTitle;
/*     */   }
/*     */ 
/*     */   public String getMetaValue()
/*     */   {
/* 118 */     return this.metaValue;
/*     */   }
/*     */ 
/*     */   public void setMetaValue(String metaValue)
/*     */   {
/* 125 */     this.metaValue = metaValue;
/*     */   }
/*     */ 
/*     */   public String getOperator()
/*     */   {
/* 132 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator)
/*     */   {
/* 139 */     this.operator = operator;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate() {
/* 143 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate) {
/* 147 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify() {
/* 151 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify) {
/* 155 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public void setInputType(String inputType) {
/* 159 */     this.inputType = inputType;
/*     */   }
/*     */ 
/*     */   public String getInputType() {
/* 163 */     return this.inputType;
/*     */   }
/*     */ 
/*     */   public boolean containsVal(String text)
/*     */   {
/* 168 */     return (this.metaValue != null) && (this.metaValue.indexOf(text) >= 0);
/*     */   }
/*     */ 
/*     */   public List<String> getMetValueList()
/*     */   {
/* 173 */     if (this.metaValue == null) return new ArrayList();
/* 174 */     return Arrays.asList(this.metaValue.split(","));
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.project.ProjectMetas
 * JD-Core Version:    0.6.0
 */