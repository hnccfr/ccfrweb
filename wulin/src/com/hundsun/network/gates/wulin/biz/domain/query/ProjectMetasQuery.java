/*     */ package com.hundsun.network.gates.wulin.biz.domain.query;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.page.Pagination;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class ProjectMetasQuery extends Pagination<ProjectMetasQuery>
/*     */ {
/*     */   private static final long serialVersionUID = -1883951835327276222L;
/*     */   private Long id;
/*     */   private String metaGroup;
/*     */   private Long projectId;
/*     */   private String metaKey;
/*     */   private String metaTitle;
/*     */   private String metaValue;
/*     */   private String operator;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */   private String projectCode;
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
/*     */   public String getMetaGroup()
/*     */   {
/*  64 */     return this.metaGroup;
/*     */   }
/*     */ 
/*     */   public void setMetaGroup(String metaGroup)
/*     */   {
/*  71 */     this.metaGroup = metaGroup;
/*     */   }
/*     */ 
/*     */   public Long getProjectId()
/*     */   {
/*  78 */     return this.projectId;
/*     */   }
/*     */ 
/*     */   public void setProjectId(Long projectId)
/*     */   {
/*  85 */     this.projectId = projectId;
/*     */   }
/*     */ 
/*     */   public String getMetaKey()
/*     */   {
/*  92 */     return this.metaKey;
/*     */   }
/*     */ 
/*     */   public void setMetaKey(String metaKey)
/*     */   {
/*  99 */     this.metaKey = metaKey;
/*     */   }
/*     */ 
/*     */   public String getMetaTitle()
/*     */   {
/* 106 */     return this.metaTitle;
/*     */   }
/*     */ 
/*     */   public void setMetaTitle(String metaTitle)
/*     */   {
/* 113 */     this.metaTitle = metaTitle;
/*     */   }
/*     */ 
/*     */   public String getMetaValue()
/*     */   {
/* 120 */     return this.metaValue;
/*     */   }
/*     */ 
/*     */   public void setMetaValue(String metaValue)
/*     */   {
/* 127 */     this.metaValue = metaValue;
/*     */   }
/*     */ 
/*     */   public String getOperator()
/*     */   {
/* 134 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator)
/*     */   {
/* 141 */     this.operator = operator;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate() {
/* 145 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate) {
/* 149 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify() {
/* 153 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify) {
/* 157 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getProjectCode() {
/* 161 */     return this.projectCode;
/*     */   }
/*     */ 
/*     */   public void setProjectCode(String projectCode) {
/* 165 */     this.projectCode = projectCode;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.domain.query.ProjectMetasQuery
 * JD-Core Version:    0.6.0
 */