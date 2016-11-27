/*    */ package com.hundsun.network.gates.wulin.biz.dao.ibatis.baseset;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.dao.baseset.UserCreditDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.baseset.UserCredit;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("userCreditDAO")
/*    */ public class UserCreditDAOImpl extends BaseDAO
/*    */   implements UserCreditDAO
/*    */ {
/*    */   public Long addInsertUserCredit(UserCredit record)
/*    */   {
/* 22 */     return (Long)getSqlMapClientTemplate().insert("USER_CREDIT.addInsertUserCredit", record);
/*    */   }
/*    */ 
/*    */   public int updateUserCredit(UserCredit userCredit)
/*    */   {
/* 30 */     return getSqlMapClientTemplate().update("USER_CREDIT.updateUserCredit", userCredit);
/*    */   }
/*    */ 
/*    */   public UserCredit selectByUserAccount(String userAccount)
/*    */   {
/* 39 */     return (UserCredit)getSqlMapClientTemplate().queryForObject("USER_CREDIT.selectByUserAccount", userAccount);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.ibatis.baseset.UserCreditDAOImpl
 * JD-Core Version:    0.6.0
 */