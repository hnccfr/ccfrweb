/*    */ package com.hundsun.network.gates.fengshan.biz.dao.ibatis.message;
/*    */ 
/*    */ import com.hundsun.network.gates.fengshan.biz.dao.message.SystemMessageDAO;
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.message.SystemMessage;
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.query.SystemMessageQuery;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("systemMessageDAO")
/*    */ public class SystemMessageDAOImpl extends BaseDAO
/*    */   implements SystemMessageDAO
/*    */ {
/*    */   public Integer deleteMessageById(Long id)
/*    */   {
/* 22 */     return Integer.valueOf(getSqlMapClientTemplate().delete("SYSTEM_MESSAGE.deleteByPrimaryKey", id));
/*    */   }
/*    */ 
/*    */   public SystemMessage selectMessageById(Long id)
/*    */   {
/* 27 */     return (SystemMessage)getSqlMapClientTemplate().queryForObject("SYSTEM_MESSAGE.selectByPrimaryKey", id);
/*    */   }
/*    */ 
/*    */   public void selectMessageListByQuery(SystemMessageQuery query)
/*    */   {
/* 32 */     paginate(query, "SYSTEM_MESSAGE.selectListCountByQuery", "SYSTEM_MESSAGE.selectListByQuery");
/*    */   }
/*    */ 
/*    */   public Integer updateMessageById(Long id)
/*    */   {
/* 38 */     return Integer.valueOf(getSqlMapClientTemplate().update("SYSTEM_MESSAGE.updateStatusByPrimaryKey", id));
/*    */   }
/*    */ 
/*    */   public Integer getNumByQuery(SystemMessageQuery query)
/*    */   {
/* 48 */     return (Integer)getSqlMapClientTemplate().queryForObject("SYSTEM_MESSAGE.selectListCountByQuery", query);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.dao.ibatis.message.SystemMessageDAOImpl
 * JD-Core Version:    0.6.0
 */