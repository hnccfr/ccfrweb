/*     */ package com.hundsun.network.gates.fengshan.biz.domain.project;
/*     */ 
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.BaseDomain;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ 
/*     */ public class ProjectMetas extends BaseDomain
/*     */ {
/*     */   private static final long serialVersionUID = 6086786544271024463L;
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
/*  55 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/*  59 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getMetaGroup()
/*     */   {
/*  66 */     return this.metaGroup;
/*     */   }
/*     */ 
/*     */   public void setMetaGroup(String metaGroup)
/*     */   {
/*  73 */     this.metaGroup = metaGroup;
/*     */   }
/*     */ 
/*     */   public Long getProjectId()
/*     */   {
/*  80 */     return this.projectId;
/*     */   }
/*     */ 
/*     */   public void setProjectId(Long projectId)
/*     */   {
/*  87 */     this.projectId = projectId;
/*     */   }
/*     */ 
/*     */   public String getMetaKey()
/*     */   {
/*  94 */     return this.metaKey;
/*     */   }
/*     */ 
/*     */   public void setMetaKey(String metaKey)
/*     */   {
/* 101 */     this.metaKey = metaKey;
/*     */   }
/*     */ 
/*     */   public String getMetaTitle()
/*     */   {
/* 108 */     return this.metaTitle;
/*     */   }
/*     */ 
/*     */   public void setMetaTitle(String metaTitle)
/*     */   {
/* 115 */     this.metaTitle = metaTitle;
/*     */   }
/*     */ 
/*     */   public String getMetaValue()
/*     */   {
/* 122 */     return this.metaValue;
/*     */   }
/*     */ 
/*     */   public void setMetaValue(String metaValue)
/*     */   {
/* 129 */     this.metaValue = metaValue;
/*     */   }
/*     */ 
/*     */   public String getOperator()
/*     */   {
/* 136 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator)
/*     */   {
/* 143 */     this.operator = operator;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate() {
/* 147 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate) {
/* 151 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify() {
/* 155 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify) {
/* 159 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public void setInputType(String inputType) {
/* 163 */     this.inputType = inputType;
/*     */   }
/*     */ 
/*     */   public String getInputType() {
/* 167 */     return this.inputType;
/*     */   }
/*     */ 
/*     */   public boolean containsVal(String text)
/*     */   {
/* 172 */     return (this.metaValue != null) && (this.metaValue.indexOf(text) >= 0);
/*     */   }
/*     */ 
/*     */   public List<String> getMetValueList()
/*     */   {
/* 177 */     if (this.metaValue == null)
/* 178 */       return new ArrayList();
/* 179 */     return Arrays.asList(this.metaValue.split(","));
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.domain.project.ProjectMetas
 * JD-Core Version:    0.6.0
 */