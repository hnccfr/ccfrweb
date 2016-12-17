/*    */ package com.hundsun.network.gates.genshan.biz.dao.ibatis.baseset;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.baseset.UserCreditLogDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.baseset.UserCreditLog;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("userCreditLogDAO")
/*    */ public class UserCreditLogDAOImpl extends BaseDAO
/*    */   implements UserCreditLogDAO
/*    */ {
/*    */   public Long insert(UserCreditLog record)
/*    */   {
/* 17 */     return (Long)getSqlMapClientTemplate().insert("USER_CREDIT_LOG.insert", record);
/*    */   }
/*    */ 
/*    */   public UserCreditLog selectByPrimaryKey(Long id) {
/* 21 */     UserCreditLog key = new UserCreditLog();
/* 22 */     key.setId(id);
/* 23 */     UserCreditLog record = (UserCreditLog)getSqlMapClientTemplate().queryForObject("USER_CREDIT_LOG.selectByPrimaryKey", key);
/* 24 */     return record;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.ibatis.baseset.UserCreditLogDAOImpl
 * JD-Core Version:    0.6.0
 */