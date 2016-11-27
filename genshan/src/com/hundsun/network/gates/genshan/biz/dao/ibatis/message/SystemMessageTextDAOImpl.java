/*    */ package com.hundsun.network.gates.genshan.biz.dao.ibatis.message;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.message.SystemMessageTextDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.message.SystemMessageText;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.query.SystemMessageTextQuery;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import java.util.List;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("systemMessageTextDAO")
/*    */ public class SystemMessageTextDAOImpl extends BaseDAO
/*    */   implements SystemMessageTextDAO
/*    */ {
/*    */   public Integer deleteTextById(Long id)
/*    */   {
/* 24 */     return Integer.valueOf(getSqlMapClientTemplate().delete("SYSTEM_MESSAGE_TEXT.deleteByPrimaryKey", id));
/*    */   }
/*    */ 
/*    */   public Integer deleteUnionByMessageId(Long id)
/*    */   {
/* 29 */     return Integer.valueOf(getSqlMapClientTemplate().delete("SYSTEM_MESSAGE_TEXT.deleteUnionByPrimaryKey", id));
/*    */   }
/*    */ 
/*    */   public void selectSystemMessageTextList(SystemMessageTextQuery query)
/*    */   {
/* 34 */     paginate(query, "SYSTEM_MESSAGE_TEXT.selectListCountByQuery", "SYSTEM_MESSAGE_TEXT.selectListByQuery");
/*    */   }
/*    */ 
/*    */   public SystemMessageText selectTextById(Long id)
/*    */   {
/* 39 */     return (SystemMessageText)getSqlMapClientTemplate().queryForObject("SYSTEM_MESSAGE_TEXT.selectByPrimaryKey", id);
/*    */   }
/*    */ 
/*    */   public Integer updateTextById(SystemMessageText systemMessageText)
/*    */   {
/* 44 */     return Integer.valueOf(getSqlMapClientTemplate().update("", systemMessageText));
/*    */   }
/*    */ 
/*    */   public List<String> selectReceiveAccountList(SystemMessageText systemMessageText)
/*    */   {
/* 50 */     return getSqlMapClientTemplate().queryForList("SYSTEM_MESSAGE_TEXT.selectUserAccountList", systemMessageText);
/*    */   }
/*    */ 
/*    */   public Integer deleteMessageOfOne(Long id)
/*    */   {
/* 55 */     return Integer.valueOf(getSqlMapClientTemplate().delete("SYSTEM_MESSAGE_TEXT.deleteMessageOfOne", id));
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.ibatis.message.SystemMessageTextDAOImpl
 * JD-Core Version:    0.6.0
 */