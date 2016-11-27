/*     */ package com.hundsun.network.gates.genshan.biz.domain.operation;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumAnnouncementStatus;
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
/*  66 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/*  70 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getTitle()
/*     */   {
/*  77 */     return this.title;
/*     */   }
/*     */ 
/*     */   public void setTitle(String title)
/*     */   {
/*  84 */     this.title = title;
/*     */   }
/*     */ 
/*     */   public String getContent()
/*     */   {
/*  91 */     return this.content;
/*     */   }
/*     */ 
/*     */   public void setContent(String content)
/*     */   {
/*  98 */     this.content = content;
/*     */   }
/*     */ 
/*     */   public String getType()
/*     */   {
/* 105 */     return this.type;
/*     */   }
/*     */ 
/*     */   public String getTypeDesc()
/*     */   {
/* 112 */     EnumAnnouncementType aType = EnumAnnouncementType.indexByValue(this.type);
/* 113 */     return aType == null ? this.type : aType.getName();
/*     */   }
/*     */ 
/*     */   public boolean isSysAnn()
/*     */   {
/* 120 */     return EnumAnnouncementType.SYSTEM.getValue().equals(this.type);
/*     */   }
/*     */ 
/*     */   public boolean isProAnn()
/*     */   {
/* 127 */     return EnumAnnouncementType.PROJECT.getValue().equals(this.type);
/*     */   }
/*     */ 
/*     */   public void setType(String type)
/*     */   {
/* 134 */     this.type = type;
/*     */   }
/*     */ 
/*     */   public Long getProjectId()
/*     */   {
/* 141 */     return this.projectId;
/*     */   }
/*     */ 
/*     */   public void setProjectId(Long projectId)
/*     */   {
/* 148 */     this.projectId = projectId;
/*     */   }
/*     */ 
/*     */   public Integer getStatus()
/*     */   {
/* 155 */     return this.status;
/*     */   }
/*     */ 
/*     */   public String getStatusDesc()
/*     */   {
/* 162 */     return EnumAnnouncementStatus.indexByValue(this.status).getName();
/*     */   }
/*     */ 
/*     */   public void setStatus(Integer status)
/*     */   {
/* 169 */     this.status = status;
/*     */   }
/*     */ 
/*     */   public String getCreatorType()
/*     */   {
/* 176 */     return this.creatorType;
/*     */   }
/*     */ 
/*     */   public void setCreatorType(String creatorType)
/*     */   {
/* 183 */     this.creatorType = creatorType;
/*     */   }
/*     */ 
/*     */   public String getCreator()
/*     */   {
/* 190 */     return this.creator;
/*     */   }
/*     */ 
/*     */   public void setCreator(String creator)
/*     */   {
/* 197 */     this.creator = creator;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate() {
/* 201 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate) {
/* 205 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify() {
/* 209 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify) {
/* 213 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public boolean isJoinProject()
/*     */   {
/* 218 */     return (this.projectId != null) && (this.projectId.longValue() > 0L);
/*     */   }
/*     */ 
/*     */   public boolean isCreate()
/*     */   {
/* 223 */     return EnumAnnouncementStatus.CREATE.getValue().equals(this.status);
/*     */   }
/*     */ 
/*     */   public String getProjectTitle() {
/* 227 */     return this.projectTitle;
/*     */   }
/*     */ 
/*     */   public void setProjectTitle(String projectTitle) {
/* 231 */     this.projectTitle = projectTitle;
/*     */   }
/*     */ 
/*     */   public String getOperatorType() {
/* 235 */     return this.operatorType;
/*     */   }
/*     */ 
/*     */   public void setOperatorType(String operatorType) {
/* 239 */     this.operatorType = operatorType;
/*     */   }
/*     */ 
/*     */   public String getOperator() {
/* 243 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator) {
/* 247 */     this.operator = operator;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.operation.Announcement
 * JD-Core Version:    0.6.0
 */