/*    */ package com.hundsun.network.gates.fengshan.biz.dao.ibatis.project;
/*    */ 
/*    */ import com.hundsun.network.gates.fengshan.biz.dao.project.ProjectAuditLogDAO;
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectAuditLog;
/*    */ import java.util.List;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
/*    */ 
/*    */ public class ProjectAuditLogDAOImpl extends SqlMapClientDaoSupport
/*    */   implements ProjectAuditLogDAO
/*    */ {
/*    */   public int countByExample(ProjectAuditLog projectAuditLog)
/*    */   {
/* 19 */     Integer count = (Integer)getSqlMapClientTemplate().queryForObject("GATES_PROJECT_AUDIT_LOG.countByExample", projectAuditLog);
/*    */ 
/* 21 */     return count.intValue();
/*    */   }
/*    */ 
/*    */   public int deleteByExample(ProjectAuditLog projectAuditLog) {
/* 25 */     int rows = getSqlMapClientTemplate().delete("GATES_PROJECT_AUDIT_LOG.deleteByExample", projectAuditLog);
/*    */ 
/* 27 */     return rows;
/*    */   }
/*    */ 
/*    */   public int deleteByPrimaryKey(Long id) {
/* 31 */     ProjectAuditLog _key = new ProjectAuditLog();
/* 32 */     _key.setId(id);
/* 33 */     int rows = getSqlMapClientTemplate().delete("GATES_PROJECT_AUDIT_LOG.deleteByPrimaryKey", _key);
/*    */ 
/* 35 */     return rows;
/*    */   }
/*    */ 
/*    */   public void insert(ProjectAuditLog record) {
/* 39 */     getSqlMapClientTemplate().insert("GATES_PROJECT_AUDIT_LOG.insert", record);
/*    */   }
/*    */ 
/*    */   public void insertSelective(ProjectAuditLog record)
/*    */   {
/* 44 */     getSqlMapClientTemplate().insert("GATES_PROJECT_AUDIT_LOG.insertSelective", record);
/*    */   }
/*    */ 
/*    */   public List selectByExample(ProjectAuditLog projectAuditLog)
/*    */   {
/* 49 */     List list = getSqlMapClientTemplate().queryForList("GATES_PROJECT_AUDIT_LOG.selectByExample", projectAuditLog);
/*    */ 
/* 51 */     return list;
/*    */   }
/*    */ 
/*    */   public ProjectAuditLog selectByPrimaryKey(Long id) {
/* 55 */     ProjectAuditLog _key = new ProjectAuditLog();
/* 56 */     _key.setId(id);
/* 57 */     ProjectAuditLog record = (ProjectAuditLog)getSqlMapClientTemplate().queryForObject("GATES_PROJECT_AUDIT_LOG.selectByPrimaryKey", _key);
/*    */ 
/* 60 */     return record;
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKeySelective(ProjectAuditLog record) {
/* 64 */     int rows = getSqlMapClientTemplate().update("GATES_PROJECT_AUDIT_LOG.updateByPrimaryKeySelective", record);
/*    */ 
/* 66 */     return rows;
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKey(ProjectAuditLog record) {
/* 70 */     int rows = getSqlMapClientTemplate().update("GATES_PROJECT_AUDIT_LOG.updateByPrimaryKey", record);
/*    */ 
/* 72 */     return rows;
/*    */   }
/*    */ 
/*    */   public int countByprojectAuditLog(ProjectAuditLog projectAuditLog) {
/* 76 */     return 0;
/*    */   }
/*    */ 
/*    */   public List selectByprojectAuditLog(ProjectAuditLog projectAuditLog) {
/* 80 */     return null;
/*    */   }
/*    */ 
/*    */   public int deleteByprojectAuditLog(ProjectAuditLog projectAuditLog)
/*    */   {
/* 85 */     return 0;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.dao.ibatis.project.ProjectAuditLogDAOImpl
 * JD-Core Version:    0.6.0
 */