/*    */ package com.hundsun.network.gates.fengshan.biz.service.pojo.operation;
/*    */ 
/*    */ import com.hundsun.network.gates.fengshan.biz.dao.operation.AnnouncementDAO;
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.operation.Announcement;
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.query.AnnouncementQuery;
/*    */ import com.hundsun.network.gates.fengshan.biz.service.BaseService;
/*    */ import com.hundsun.network.gates.fengshan.biz.service.operation.AnnouncementService;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("announcementService")
/*    */ public class AnnouncementServiceImpl extends BaseService
/*    */   implements AnnouncementService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private AnnouncementDAO announcementDAO;
/*    */ 
/*    */   public void paginate(AnnouncementQuery<Announcement> page)
/*    */   {
/* 23 */     this.announcementDAO.paginate(page);
/*    */   }
/*    */ 
/*    */   public Announcement queryAnnouncementInfo(Long announcementId)
/*    */   {
/* 32 */     return this.announcementDAO.selectByPrimaryKey(announcementId);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.service.pojo.operation.AnnouncementServiceImpl
 * JD-Core Version:    0.6.0
 */