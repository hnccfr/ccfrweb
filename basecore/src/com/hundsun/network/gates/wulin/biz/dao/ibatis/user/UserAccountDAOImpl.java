/*    */ package com.hundsun.network.gates.wulin.biz.dao.ibatis.user;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.dao.user.UserAccountDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.user.UserAccount;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("userAccountDAO")
/*    */ public class UserAccountDAOImpl extends BaseDAO
/*    */   implements UserAccountDAO
/*    */ {
/*    */   public UserAccount queryByAccount(UserAccount account)
/*    */   {
/* 17 */     return (UserAccount)getSqlMapClientTemplate().queryForObject("userAccount.queryByAccount", account);
/*    */   }
/*    */ 
/*    */   public UserAccount selectByUserAccount(String userAccount)
/*    */   {
/* 27 */     return (UserAccount)getSqlMapClientTemplate().queryForObject("userAccount.selectByUserAccount", userAccount);
/*    */   }
/*    */ 
/*    */   public int queryNumBySericeCode(String serviceCode)
/*    */   {
/* 36 */     Map paras = new HashMap();
/* 37 */     paras.put("serviceCode", serviceCode);
/* 38 */     Integer count = (Integer)getSqlMapClientTemplate().queryForObject("userAccount.queryUsersNum", paras);
/*    */ 
/* 40 */     return count.intValue();
/*    */   }
/*    */ 
/*    */   public Integer updateUserAccountByAccount(UserAccount account)
/*    */   {
/* 45 */     return Integer.valueOf(getSqlMapClientTemplate().update("userAccount.updateUserAccountByAccount", account));
/*    */   }
/*    */ 
/*    */   public void addUserAccount(UserAccount userAccount)
/*    */   {
/* 52 */     getSqlMapClientTemplate().insert("userAccount.insert", userAccount);
/*    */   }
/*    */ 
/*    */   public UserAccount selectByFundAccount(String fundAccount)
/*    */   {
/* 57 */     return (UserAccount)getSqlMapClientTemplate().queryForObject("userAccount.selectByFundAccount", fundAccount);
/*    */   }
/*    */ 
/*    */   public int updateUserAccountByAccount(Map<String, Object> map)
/*    */   {
/* 63 */     return getSqlMapClientTemplate().update("userAccount.updateUserAccountByAccountMap", map);
/*    */   }
/*    */ 
/*    */   public String getMaxFundAccount()
/*    */   {
/* 69 */     Object obj = getSqlMapClientTemplate().queryForObject("userAccount.getMaxFundAccount");
/* 70 */     return null == obj ? null : String.valueOf(obj);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.ibatis.user.UserAccountDAOImpl
 * JD-Core Version:    0.6.0
 */