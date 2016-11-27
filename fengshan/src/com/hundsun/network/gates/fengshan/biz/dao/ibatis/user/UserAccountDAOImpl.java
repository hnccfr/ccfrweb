/*    */ package com.hundsun.network.gates.fengshan.biz.dao.ibatis.user;
/*    */ 
/*    */ import com.hundsun.network.gates.fengshan.biz.dao.user.UserAccountDAO;
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.user.UserAccount;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import java.util.Map;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("userAccountDAO")
/*    */ public class UserAccountDAOImpl extends BaseDAO
/*    */   implements UserAccountDAO
/*    */ {
/*    */   public void insert(UserAccount record)
/*    */   {
/* 16 */     getSqlMapClientTemplate().insert("userAccount.insert", record);
/*    */   }
/*    */ 
/*    */   public UserAccount selectByPrimaryKey(Long id)
/*    */   {
/* 21 */     return (UserAccount)getSqlMapClientTemplate().queryForObject("userAccount.selectByPrimaryKey", id);
/*    */   }
/*    */ 
/*    */   public Long selectByParaMap(Map<String, Object> map)
/*    */   {
/* 28 */     return (Long)getSqlMapClientTemplate().queryForObject("userAccount.uniqueUser", map);
/*    */   }
/*    */ 
/*    */   public UserAccount selectByAccount(String account)
/*    */   {
/* 33 */     return (UserAccount)getSqlMapClientTemplate().queryForObject("userAccount.selectByAccount", account);
/*    */   }
/*    */ 
/*    */   public int updateByUserAccount(UserAccount userAccount)
/*    */   {
/* 39 */     return getSqlMapClientTemplate().update("userAccount.updateByUserAccount", userAccount);
/*    */   }
/*    */ 
/*    */   public UserAccount selectFundAccountInfoByAccount(String account)
/*    */   {
/* 45 */     return (UserAccount)getSqlMapClientTemplate().queryForObject("userAccount.selectFundAccountByAccount", account);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.dao.ibatis.user.UserAccountDAOImpl
 * JD-Core Version:    0.6.0
 */