/*     */ package com.hundsun.network.gates.wulin.biz.dao.ibatis.operation;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.dao.operation.AnnouncementDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.operation.Announcement;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.query.AnnouncementQuery;
/*     */ import java.util.List;
/*     */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*     */ import org.springframework.stereotype.Repository;
/*     */ 
/*     */ @Repository("announcementDAO")
/*     */ public class AnnouncementDAOImpl extends BaseDAO
/*     */   implements AnnouncementDAO
/*     */ {
/*     */   public int deleteByPrimaryKey(Long id)
/*     */   {
/*  20 */     Announcement _key = new Announcement();
/*  21 */     _key.setId(id);
/*  22 */     int rows = getSqlMapClientTemplate().delete("Announcement.deleteByPrimaryKey", _key);
/*  23 */     return rows;
/*     */   }
/*     */ 
/*     */   public Long insert(Announcement record)
/*     */   {
/*  32 */     return (Long)getSqlMapClientTemplate().insert("Announcement.insert", record);
/*     */   }
/*     */ 
/*     */   public void insertSelective(Announcement record) {
/*  36 */     getSqlMapClientTemplate().insert("Announcement.insertSelective", record);
/*     */   }
/*     */ 
/*     */   public Announcement selectByPrimaryKey(Long id)
/*     */   {
/*  45 */     return (Announcement)getSqlMapClientTemplate().queryForObject("Announcement.selectByPrimaryKey", id);
/*     */   }
/*     */ 
/*     */   public int updateByPrimaryKeySelective(Announcement record)
/*     */   {
/*  54 */     int rows = getSqlMapClientTemplate().update("Announcement.updateByPrimaryKeySelective", record);
/*  55 */     return rows;
/*     */   }
/*     */ 
/*     */   public void paginated(AnnouncementQuery<Announcement> page)
/*     */   {
/*  63 */     paginate(page, "Announcement.getTotalCount", "Announcement.getPaginated");
/*     */   }
/*     */ 
/*     */   public List<Announcement> queryAnnouncementList(AnnouncementQuery<Announcement> query)
/*     */   {
/*  73 */     return getSqlMapClientTemplate().queryForList("Announcement.queryAnnouncementList", query);
/*     */   }
/*     */ 
/*     */   public int removeByPrimaryKey(Long announcementId)
/*     */   {
/*  81 */     int rows = getSqlMapClientTemplate().update("Announcement.removeByPrimaryKey", announcementId);
/*  82 */     return rows;
/*     */   }
/*     */ 
/*     */   public int leaveProjectByPrimaryKey(Announcement announcement)
/*     */   {
/*  92 */     int rows = getSqlMapClientTemplate().update("Announcement.leaveProjectByPrimaryKey", announcement);
/*  93 */     return rows;
/*     */   }
/*     */ 
/*     */   public Announcement selectNewestAnnouncement()
/*     */   {
/* 102 */     return (Announcement)getSqlMapClientTemplate().queryForObject("Announcement.selectNewestAnnouncement");
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.ibatis.operation.AnnouncementDAOImpl
 * JD-Core Version:    0.6.0
 */