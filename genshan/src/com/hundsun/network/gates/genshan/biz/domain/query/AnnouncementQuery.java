/*    */ package com.hundsun.network.gates.genshan.biz.domain.query;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.page.Pagination;
/*    */ 
/*    */ public class AnnouncementQuery<Announcement> extends Pagination<Announcement>
/*    */ {
/*    */   private static final long serialVersionUID = 326098800669604002L;
/*    */   private Long id;
/*    */   private String title;
/*    */   private String type;
/*    */   private Long projectId;
/*    */   private String projectTitle;
/*    */   private Integer status;
/*    */ 
/*    */   public Long getId()
/*    */   {
/* 42 */     return this.id;
/*    */   }
/*    */ 
/*    */   public void setId(Long id) {
/* 46 */     this.id = id;
/*    */   }
/*    */ 
/*    */   public String getTitle() {
/* 50 */     return this.title;
/*    */   }
/*    */ 
/*    */   public void setTitle(String title) {
/* 54 */     this.title = title;
/*    */   }
/*    */ 
/*    */   public String getType() {
/* 58 */     return this.type;
/*    */   }
/*    */ 
/*    */   public void setType(String type) {
/* 62 */     this.type = type;
/*    */   }
/*    */ 
/*    */   public Long getProjectId() {
/* 66 */     return this.projectId;
/*    */   }
/*    */ 
/*    */   public void setProjectId(Long projectId) {
/* 70 */     this.projectId = projectId;
/*    */   }
/*    */ 
/*    */   public String getProjectTitle() {
/* 74 */     return this.projectTitle;
/*    */   }
/*    */ 
/*    */   public void setProjectTitle(String projectTitle) {
/* 78 */     this.projectTitle = projectTitle;
/*    */   }
/*    */ 
/*    */   public void trim()
/*    */   {
/* 83 */     if (this.title != null) setTitle(this.title.trim()); 
/*    */   }
/*    */ 
/*    */   public Integer getStatus()
/*    */   {
/* 87 */     return this.status;
/*    */   }
/*    */ 
/*    */   public void setStatus(Integer status) {
/* 91 */     this.status = status;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.query.AnnouncementQuery
 * JD-Core Version:    0.6.0
 */