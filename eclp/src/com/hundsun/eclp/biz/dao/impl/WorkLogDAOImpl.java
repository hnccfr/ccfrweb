/*    */ package com.hundsun.eclp.biz.dao.impl;
/*    */ 
/*    */ import com.hundsun.eclp.biz.dao.WorkLogDAO;
/*    */ import com.hundsun.eclp.biz.domain.sys.WorkLog;
/*    */ import com.hundsun.eclp.biz.query.WorkLogQuery;
/*    */ import com.hundsun.network.common.dao.BaseDAO;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("workLogDAO")
/*    */ public class WorkLogDAOImpl extends BaseDAO
/*    */   implements WorkLogDAO
/*    */ {
/*    */   public void insert(WorkLog record)
/*    */   {
/* 14 */     getSqlMapClientTemplate().insert("ECLP_WORK_LOG.insert", record);
/*    */   }
/*    */ 
/*    */   public int update(WorkLog record) {
/* 18 */     int rows = getSqlMapClientTemplate().update("ECLP_WORK_LOG.update", record);
/* 19 */     return rows;
/*    */   }
/*    */ 
/*    */   public WorkLog selectById(Long id) {
/* 23 */     WorkLog record = (WorkLog)getSqlMapClientTemplate().queryForObject("ECLP_WORK_LOG.selectById", id);
/* 24 */     return record;
/*    */   }
/*    */ 
/*    */   public int delete(Long id) {
/* 28 */     int rows = getSqlMapClientTemplate().delete("ECLP_WORK_LOG.delete", id);
/* 29 */     return rows;
/*    */   }
/*    */ 
/*    */   public WorkLogQuery serarchByPage(WorkLogQuery query)
/*    */   {
/* 34 */     query = (WorkLogQuery)getPagination(query, "ECLP_WORK_LOG.selectCountAll", "ECLP_WORK_LOG.selectAll");
/* 35 */     return query;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.dao.impl.WorkLogDAOImpl
 * JD-Core Version:    0.6.0
 */