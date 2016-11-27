/*    */ package com.hundsun.network.gates.wulin.biz.dao.ibatis.message;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.dao.message.SystemMessageDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.message.MessageForMore;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.message.SystemMessage;
/*    */ import com.ibatis.sqlmap.client.SqlMapExecutor;
/*    */ import java.sql.SQLException;
/*    */ import java.util.List;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.springframework.orm.ibatis.SqlMapClientCallback;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("systemMessageDAO")
/*    */ public class SystemMessageDAOImpl extends BaseDAO
/*    */   implements SystemMessageDAO
/*    */ {
/*    */   public int deleteByPrimaryKey(Long id)
/*    */   {
/* 19 */     SystemMessage _key = new SystemMessage();
/* 20 */     _key.setId(id);
/* 21 */     int rows = getSqlMapClientTemplate().delete("SYSTEM_MESSAGE.deleteByPrimaryKey", _key);
/* 22 */     return rows;
/*    */   }
/*    */ 
/*    */   public void insert(SystemMessage record) {
/* 26 */     getSqlMapClientTemplate().insert("SYSTEM_MESSAGE.insert", record);
/*    */   }
/*    */ 
/*    */   public void insertSelective(SystemMessage record) {
/* 30 */     getSqlMapClientTemplate().insert("SYSTEM_MESSAGE.insertSelective", record);
/*    */   }
/*    */ 
/*    */   public SystemMessage selectByPrimaryKey(Long id) {
/* 34 */     SystemMessage _key = new SystemMessage();
/* 35 */     _key.setId(id);
/* 36 */     SystemMessage record = (SystemMessage)getSqlMapClientTemplate().queryForObject("SYSTEM_MESSAGE.selectByPrimaryKey", _key);
/* 37 */     return record;
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKeySelective(SystemMessage record) {
/* 41 */     int rows = getSqlMapClientTemplate().update("SYSTEM_MESSAGE.updateByPrimaryKeySelective", record);
/* 42 */     return rows;
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKey(SystemMessage record) {
/* 46 */     int rows = getSqlMapClientTemplate().update("SYSTEM_MESSAGE.updateByPrimaryKey", record);
/* 47 */     return rows;
/*    */   }
/*    */ 
/*    */   public void batchInsertMessage(final MessageForMore messageForMore)
/*    */   {
/* 60 */     final List userAccountList = messageForMore.getUserAccountList();
/*    */     try {
/* 62 */       if (userAccountList != null)
/* 63 */         getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
/*    */           public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
/* 65 */             executor.startBatch();
/* 66 */             int i = 0; for (int n = userAccountList.size(); i < n; i++) {
/* 67 */               messageForMore.setReceiveAccount((String)userAccountList.get(i));
/* 68 */               SystemMessageDAOImpl.this.log.info("send:" + messageForMore.getSendAccount() + "rece:" + messageForMore.getReceiveAccount() + "id:" + messageForMore.getMessageId());
/* 69 */               executor.insert("SYSTEM_MESSAGE.insert", messageForMore);
/*    */             }
/* 71 */             executor.executeBatch();
/* 72 */             return null;
/*    */           } } );
/*    */     }
/*    */     catch (Exception e) {
/* 77 */       if (this.log.isDebugEnabled()) {
/* 78 */         e.printStackTrace();
/* 79 */         this.log.error("batchInsertMessage error: id [ SYSTEM_MESSAGE.insert + ], parameterObject [" + messageForMore + "].  Cause: " + e.getMessage());
/*    */       }
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.ibatis.message.SystemMessageDAOImpl
 * JD-Core Version:    0.6.0
 */