/*    */ package com.hundsun.network.gates.genshan.biz.dao.ibatis.operation;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.operation.AnnouncementDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.operation.Announcement;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.query.AnnouncementQuery;
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
/* 22 */     paginate(page, "Announcement.getTotalCount", "Announcement.getPaginated");
/*    */   }
/*    */ 
/*    */   public Announcement selectByPrimaryKey(Long id)
/*    */   {
/* 31 */     return (Announcement)getSqlMapClientTemplate().queryForObject("Announcement.selectByPrimaryKey", id);
/*    */   }
/*    */ 
/*    */   public Integer getNumByQuery(AnnouncementQuery<Announcement> query)
/*    */   {
/* 41 */     return (Integer)getSqlMapClientTemplate().queryForObject("Announcement.getTotalCount", query);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.ibatis.operation.AnnouncementDAOImpl
 * JD-Core Version:    0.6.0
 */