/*    */ package com.hundsun.network.gates.wulin.biz.domain.query;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.page.Pagination;
/*    */ 
/*    */ public class AnnouncementQuery<Announcement> extends Pagination<Announcement>
/*    */ {
/*    */   private static final long serialVersionUID = -7630532158171631432L;
/*    */   private Long id;
/*    */   private String title;
/*    */   private String type;
/*    */   private Long projectId;
/*    */ 
/*    */   public Long getId()
/*    */   {
/* 31 */     return this.id;
/*    */   }
/*    */ 
/*    */   public void setId(Long id) {
/* 35 */     this.id = id;
/*    */   }
/*    */ 
/*    */   public String getTitle() {
/* 39 */     return this.title;
/*    */   }
/*    */ 
/*    */   public void setTitle(String title) {
/* 43 */     this.title = title;
/*    */   }
/*    */ 
/*    */   public String getType() {
/* 47 */     return this.type;
/*    */   }
/*    */ 
/*    */   public void setType(String type) {
/* 51 */     this.type = type;
/*    */   }
/*    */ 
/*    */   public Long getProjectId() {
/* 55 */     return this.projectId;
/*    */   }
/*    */ 
/*    */   public void setProjectId(Long projectId) {
/* 59 */     this.projectId = projectId;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.domain.query.AnnouncementQuery
 * JD-Core Version:    0.6.0
 */