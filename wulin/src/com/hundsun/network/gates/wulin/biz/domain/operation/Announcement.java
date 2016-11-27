/*     */ package com.hundsun.network.gates.wulin.biz.domain.operation;
/*     */ 
/*     */ import java.util.Date;
/*     */ 
/*     */ public class Announcement
/*     */ {
/*     */   private Long id;
/*     */   private String title;
/*     */   private String content;
/*     */   private String type;
/*     */   private Long projectId;
/*     */   private Integer status;
/*     */   private String creatorType;
/*     */   private String creator;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */   private String operatorType;
/*     */   private String operator;
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  58 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/*  62 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getTitle()
/*     */   {
/*  69 */     return this.title;
/*     */   }
/*     */ 
/*     */   public void setTitle(String title)
/*     */   {
/*  76 */     this.title = title;
/*     */   }
/*     */ 
/*     */   public String getContent()
/*     */   {
/*  83 */     return this.content;
/*     */   }
/*     */ 
/*     */   public void setContent(String content)
/*     */   {
/*  90 */     this.content = content;
/*     */   }
/*     */ 
/*     */   public String getType()
/*     */   {
/*  97 */     return this.type;
/*     */   }
/*     */ 
/*     */   public void setType(String type)
/*     */   {
/* 104 */     this.type = type;
/*     */   }
/*     */ 
/*     */   public Long getProjectId()
/*     */   {
/* 111 */     return this.projectId;
/*     */   }
/*     */ 
/*     */   public void setProjectId(Long projectId)
/*     */   {
/* 118 */     this.projectId = projectId;
/*     */   }
/*     */ 
/*     */   public Integer getStatus()
/*     */   {
/* 125 */     return this.status;
/*     */   }
/*     */ 
/*     */   public void setStatus(Integer status)
/*     */   {
/* 132 */     this.status = status;
/*     */   }
/*     */ 
/*     */   public String getCreatorType()
/*     */   {
/* 139 */     return this.creatorType;
/*     */   }
/*     */ 
/*     */   public void setCreatorType(String creatorType)
/*     */   {
/* 146 */     this.creatorType = creatorType;
/*     */   }
/*     */ 
/*     */   public String getCreator()
/*     */   {
/* 153 */     return this.creator;
/*     */   }
/*     */ 
/*     */   public void setCreator(String creator)
/*     */   {
/* 160 */     this.creator = creator;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate() {
/* 164 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate) {
/* 168 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify() {
/* 172 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify) {
/* 176 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getOperatorType() {
/* 180 */     return this.operatorType;
/*     */   }
/*     */ 
/*     */   public void setOperatorType(String operatorType) {
/* 184 */     this.operatorType = operatorType;
/*     */   }
/*     */ 
/*     */   public String getOperator() {
/* 188 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator) {
/* 192 */     this.operator = operator;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.domain.operation.Announcement
 * JD-Core Version:    0.6.0
 */