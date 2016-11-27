/*     */ package com.hundsun.network.gates.fengshan.biz.domain.operation;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumAnnouncementType;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class Announcement
/*     */ {
/*     */   private Long id;
/*     */   private String title;
/*     */   private String content;
/*     */   private String type;
/*     */   private Long projectId;
/*     */   private String projectTitle;
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
/*  65 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/*  69 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getTitle()
/*     */   {
/*  76 */     return this.title;
/*     */   }
/*     */ 
/*     */   public void setTitle(String title)
/*     */   {
/*  83 */     this.title = title;
/*     */   }
/*     */ 
/*     */   public String getContent()
/*     */   {
/*  90 */     return this.content;
/*     */   }
/*     */ 
/*     */   public void setContent(String content)
/*     */   {
/*  97 */     this.content = content;
/*     */   }
/*     */ 
/*     */   public String getType()
/*     */   {
/* 104 */     return this.type;
/*     */   }
/*     */ 
/*     */   public String getTypeDesc()
/*     */   {
/* 111 */     EnumAnnouncementType aType = EnumAnnouncementType.indexByValue(this.type);
/* 112 */     return aType == null ? this.type : aType.getName();
/*     */   }
/*     */ 
/*     */   public void setType(String type)
/*     */   {
/* 119 */     this.type = type;
/*     */   }
/*     */ 
/*     */   public Long getProjectId()
/*     */   {
/* 126 */     return this.projectId;
/*     */   }
/*     */ 
/*     */   public void setProjectId(Long projectId)
/*     */   {
/* 133 */     this.projectId = projectId;
/*     */   }
/*     */ 
/*     */   public Integer getStatus()
/*     */   {
/* 140 */     return this.status;
/*     */   }
/*     */ 
/*     */   public void setStatus(Integer status)
/*     */   {
/* 147 */     this.status = status;
/*     */   }
/*     */ 
/*     */   public String getCreatorType()
/*     */   {
/* 154 */     return this.creatorType;
/*     */   }
/*     */ 
/*     */   public void setCreatorType(String creatorType)
/*     */   {
/* 161 */     this.creatorType = creatorType;
/*     */   }
/*     */ 
/*     */   public String getCreator()
/*     */   {
/* 168 */     return this.creator;
/*     */   }
/*     */ 
/*     */   public void setCreator(String creator)
/*     */   {
/* 175 */     this.creator = creator;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate() {
/* 179 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate) {
/* 183 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify() {
/* 187 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify) {
/* 191 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public boolean isJoinProject()
/*     */   {
/* 196 */     return (this.projectId != null) && (this.projectId.longValue() > 0L);
/*     */   }
/*     */ 
/*     */   public String getProjectTitle() {
/* 200 */     return this.projectTitle;
/*     */   }
/*     */ 
/*     */   public void setProjectTitle(String projectTitle) {
/* 204 */     this.projectTitle = projectTitle;
/*     */   }
/*     */ 
/*     */   public String getOperatorType() {
/* 208 */     return this.operatorType;
/*     */   }
/*     */ 
/*     */   public void setOperatorType(String operatorType) {
/* 212 */     this.operatorType = operatorType;
/*     */   }
/*     */ 
/*     */   public String getOperator() {
/* 216 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator) {
/* 220 */     this.operator = operator;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.domain.operation.Announcement
 * JD-Core Version:    0.6.0
 */