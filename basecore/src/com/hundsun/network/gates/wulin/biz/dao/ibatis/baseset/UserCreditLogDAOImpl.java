/*    */ package com.hundsun.network.gates.wulin.biz.dao.ibatis.baseset;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.dao.baseset.UserCreditLogDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.baseset.UserCreditLog;
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
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.ibatis.baseset.UserCreditLogDAOImpl
 * JD-Core Version:    0.6.0
 */