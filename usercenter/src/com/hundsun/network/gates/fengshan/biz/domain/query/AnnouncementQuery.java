/*     */ package com.hundsun.network.gates.fengshan.biz.domain.query;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.page.Pagination;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class AnnouncementQuery<Announcement> extends Pagination<Announcement>
/*     */ {
/*     */   private static final long serialVersionUID = -7709444666370610663L;
/*     */   private Long id;
/*     */   private String title;
/*     */   private String type;
/*     */   private Long projectId;
/*     */   private String projectTitle;
/*     */   private Date gmtCreateL;
/*     */   private Date gmtCreateR;
/*     */   private Date gmtModify;
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  54 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/*  58 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getTitle() {
/*  62 */     return this.title;
/*     */   }
/*     */ 
/*     */   public void setTitle(String title) {
/*  66 */     this.title = title;
/*     */   }
/*     */ 
/*     */   public String getType() {
/*  70 */     return this.type;
/*     */   }
/*     */ 
/*     */   public void setType(String type) {
/*  74 */     this.type = type;
/*     */   }
/*     */ 
/*     */   public Long getProjectId() {
/*  78 */     return this.projectId;
/*     */   }
/*     */ 
/*     */   public void setProjectId(Long projectId) {
/*  82 */     this.projectId = projectId;
/*     */   }
/*     */ 
/*     */   public String getProjectTitle() {
/*  86 */     return this.projectTitle;
/*     */   }
/*     */ 
/*     */   public void setProjectTitle(String projectTitle) {
/*  90 */     this.projectTitle = projectTitle;
/*     */   }
/*     */ 
/*     */   public void trim()
/*     */   {
/*  95 */     if (this.title != null) setTitle(this.title.trim()); 
/*     */   }
/*     */ 
/*     */   public Date getGmtCreateL()
/*     */   {
/*  99 */     return this.gmtCreateL;
/*     */   }
/*     */ 
/*     */   public void setGmtCreateL(Date gmtCreateL) {
/* 103 */     this.gmtCreateL = gmtCreateL;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreateR() {
/* 107 */     return this.gmtCreateR;
/*     */   }
/*     */ 
/*     */   public void setGmtCreateR(Date gmtCreateR) {
/* 111 */     this.gmtCreateR = gmtCreateR;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify) {
/* 115 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify() {
/* 119 */     return this.gmtModify;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.domain.query.AnnouncementQuery
 * JD-Core Version:    0.6.0
 */