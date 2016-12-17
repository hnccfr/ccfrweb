/*    */ package com.hundsun.network.gates.wulin.biz.dao.ibatis.project;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.dao.project.ProjectAuditLogDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.project.ProjectAuditLog;
/*    */ import java.util.List;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("projectAuditLogDAO")
/*    */ public class ProjectAuditLogDAOImpl extends BaseDAO
/*    */   implements ProjectAuditLogDAO
/*    */ {
/*    */   public int countByprojectAuditLog(ProjectAuditLog projectAuditLog)
/*    */   {
/* 19 */     Integer count = (Integer)getSqlMapClientTemplate().queryForObject("ProjectAuditLog.countByprojectAuditLog", projectAuditLog);
/*    */ 
/* 21 */     return count.intValue();
/*    */   }
/*    */ 
/*    */   public int deleteByprojectAuditLog(ProjectAuditLog projectAuditLog) {
/* 25 */     int rows = getSqlMapClientTemplate().delete("ProjectAuditLog.deleteByprojectAuditLog", projectAuditLog);
/*    */ 
/* 27 */     return rows;
/*    */   }
/*    */ 
/*    */   public int deleteByPrimaryKey(Long id) {
/* 31 */     ProjectAuditLog _key = new ProjectAuditLog();
/* 32 */     _key.setId(id);
/* 33 */     int rows = getSqlMapClientTemplate().delete("ProjectAuditLog.deleteByPrimaryKey", _key);
/*    */ 
/* 35 */     return rows;
/*    */   }
/*    */ 
/*    */   public void insert(ProjectAuditLog record) {
/* 39 */     getSqlMapClientTemplate().insert("ProjectAuditLog.insert", record);
/*    */   }
/*    */ 
/*    */   public void insertSelective(ProjectAuditLog record) {
/* 43 */     getSqlMapClientTemplate().insert("ProjectAuditLog.insertSelective", record);
/*    */   }
/*    */ 
/*    */   public List selectByprojectAuditLog(ProjectAuditLog projectAuditLog)
/*    */   {
/* 48 */     List list = getSqlMapClientTemplate().queryForList("ProjectAuditLog.selectByprojectAuditLog", projectAuditLog);
/*    */ 
/* 50 */     return list;
/*    */   }
/*    */ 
/*    */   public ProjectAuditLog selectByPrimaryKey(Long id) {
/* 54 */     ProjectAuditLog _key = new ProjectAuditLog();
/* 55 */     _key.setId(id);
/* 56 */     ProjectAuditLog record = (ProjectAuditLog)getSqlMapClientTemplate().queryForObject("ProjectAuditLog.selectByPrimaryKey", _key);
/*    */ 
/* 58 */     return record;
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKeySelective(ProjectAuditLog record) {
/* 62 */     int rows = getSqlMapClientTemplate().update("ProjectAuditLog.updateByPrimaryKeySelective", record);
/*    */ 
/* 64 */     return rows;
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKey(ProjectAuditLog record) {
/* 68 */     int rows = getSqlMapClientTemplate().update("GATES_PROJECT_AUDIT_LOG.updateByPrimaryKey", record);
/*    */ 
/* 70 */     return rows;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.ibatis.project.ProjectAuditLogDAOImpl
 * JD-Core Version:    0.6.0
 */