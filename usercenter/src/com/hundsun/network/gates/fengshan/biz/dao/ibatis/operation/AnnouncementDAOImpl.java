/*    */ package com.hundsun.network.gates.fengshan.biz.dao.ibatis.operation;
/*    */ 
/*    */ import com.hundsun.network.gates.fengshan.biz.dao.operation.AnnouncementDAO;
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.operation.Announcement;
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.query.AnnouncementQuery;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("announcementDAO")
/*    */ public class AnnouncementDAOImpl extends BaseDAO
/*    */   implements AnnouncementDAO
/*    */ {
/*    */   public void paginate(AnnouncementQuery<Announcement> page)
/*    */   {
/* 23 */     paginate(page, "Announcement.getTotalCount", "Announcement.getPaginated");
/*    */   }
/*    */ 
/*    */   public Announcement selectByPrimaryKey(Long id)
/*    */   {
/* 32 */     return (Announcement)getSqlMapClientTemplate().queryForObject("Announcement.selectByPrimaryKey", id);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.dao.ibatis.operation.AnnouncementDAOImpl
 * JD-Core Version:    0.6.0
 */