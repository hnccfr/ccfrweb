/*    */ package com.hundsun.network.gates.wulin.biz.dao.ibatis.message;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.dao.message.SystemMessageTextDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.message.SystemMessageText;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("systemMessageTextDAO")
/*    */ public class SystemMessageTextDAOImpl extends BaseDAO
/*    */   implements SystemMessageTextDAO
/*    */ {
/*    */   public int deleteByPrimaryKey(Long id)
/*    */   {
/* 19 */     SystemMessageText _key = new SystemMessageText();
/* 20 */     _key.setId(id);
/* 21 */     int rows = getSqlMapClientTemplate().delete("SYSTEM_MESSAGE_TEXT.deleteByPrimaryKey", _key);
/* 22 */     return rows;
/*    */   }
/*    */ 
/*    */   public Long insert(SystemMessageText record)
/*    */   {
/* 27 */     return (Long)getSqlMapClientTemplate().insert("SYSTEM_MESSAGE_TEXT.insert", record);
/*    */   }
/*    */ 
/*    */   public void insertSelective(SystemMessageText record) {
/* 31 */     getSqlMapClientTemplate().insert("SYSTEM_MESSAGE_TEXT.insertSelective", record);
/*    */   }
/*    */ 
/*    */   public SystemMessageText selectByPrimaryKey(Long id) {
/* 35 */     SystemMessageText _key = new SystemMessageText();
/* 36 */     _key.setId(id);
/* 37 */     SystemMessageText record = (SystemMessageText)getSqlMapClientTemplate().queryForObject("SYSTEM_MESSAGE_TEXT.selectByPrimaryKey", _key);
/* 38 */     return record;
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKeySelective(SystemMessageText record)
/*    */   {
/* 43 */     int rows = getSqlMapClientTemplate().update("SYSTEM_MESSAGE_TEXT.updateByPrimaryKeySelective", record);
/* 44 */     return rows;
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKey(SystemMessageText record) {
/* 48 */     int rows = getSqlMapClientTemplate().update("SYSTEM_MESSAGE_TEXT.updateByPrimaryKey", record);
/* 49 */     return rows;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.ibatis.message.SystemMessageTextDAOImpl
 * JD-Core Version:    0.6.0
 */