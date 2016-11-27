/*    */ package com.hundsun.network.gates.qingbo.biz.dao.ibatis.user;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import com.hundsun.network.gates.qingbo.biz.dao.user.UserAccountDAO;
/*    */ import com.hundsun.network.gates.qingbo.biz.domain.user.UserAccount;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("userAccountDAO")
/*    */ public class UserAccountDAOImpl extends BaseDAO
/*    */   implements UserAccountDAO
/*    */ {
/*    */   public UserAccount selectUserByAccount(String account)
/*    */   {
/* 21 */     return (UserAccount)getSqlMapClientTemplate().queryForObject("userAccount.selectByAccount", account);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.qingbo.biz.dao.ibatis.user.UserAccountDAOImpl
 * JD-Core Version:    0.6.0
 */