/*    */ package com.hundsun.eclp.biz.dao.impl;
/*    */ 
/*    */ import com.hundsun.eclp.biz.dao.LoginLogDAO;
/*    */ import com.hundsun.eclp.biz.domain.sys.LoginLog;
/*    */ import com.hundsun.eclp.biz.query.LoginLogQuery;
/*    */ import com.hundsun.network.common.dao.BaseDAO;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("loginLogDAO")
/*    */ public class LoginLogDAOImpl extends BaseDAO
/*    */   implements LoginLogDAO
/*    */ {
/*    */   public static final String SQL_LOGINLOGCOUNTALL = "ECLP_LOGIN_LOG.loginLogCountAll";
/*    */   public static final String SQL_LOGINLOGSELECTALL = "ECLP_LOGIN_LOG.loginLogselectAll";
/*    */ 
/*    */   public void insert(LoginLog record)
/*    */   {
/* 23 */     getSqlMapClientTemplate().insert("ECLP_LOGIN_LOG.insert", record);
/*    */   }
/*    */ 
/*    */   public int update(LoginLog record) {
/* 27 */     int rows = getSqlMapClientTemplate().update("ECLP_LOGIN_LOG.update", record);
/* 28 */     return rows;
/*    */   }
/*    */ 
/*    */   public LoginLog selectById(Long id) {
/* 32 */     LoginLog record = (LoginLog)getSqlMapClientTemplate().queryForObject("ECLP_LOGIN_LOG.selectById", id);
/* 33 */     return record;
/*    */   }
/*    */ 
/*    */   public int delete(Long id) {
/* 37 */     int rows = getSqlMapClientTemplate().delete("ECLP_LOGIN_LOG.delete", id);
/* 38 */     return rows;
/*    */   }
/*    */ 
/*    */   public LoginLog getLastLoginLog(String account)
/*    */   {
/* 43 */     LoginLog record = (LoginLog)getSqlMapClientTemplate().queryForObject("ECLP_LOGIN_LOG.getLastLoginLog", account);
/* 44 */     return record;
/*    */   }
/*    */ 
/*    */   public LoginLogQuery serarchByPage(LoginLogQuery query)
/*    */   {
/* 50 */     query = (LoginLogQuery)getPagination(query, "ECLP_LOGIN_LOG.loginLogCountAll", "ECLP_LOGIN_LOG.loginLogselectAll");
/* 51 */     return query;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.dao.impl.LoginLogDAOImpl
 * JD-Core Version:    0.6.0
 */