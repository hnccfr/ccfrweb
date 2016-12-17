/*    */ package com.hundsun.network.gates.genshan.biz.dao.ibatis.user;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.user.UserAccountDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.query.UserAccountQuery;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.user.UserAccount;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.user.UserRole;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("userAccountDAO")
/*    */ public class UserAccountDAOImpl extends BaseDAO
/*    */   implements UserAccountDAO
/*    */ {
/*    */   public void selectUserAccountList(UserAccountQuery query)
/*    */   {
/* 27 */     paginate(query, "userAccount.selectUserList_count", "userAccount.selectUserList");
/*    */   }
/*    */ 
/*    */   public UserAccount selectUserByAccount(String account)
/*    */   {
/* 32 */     return (UserAccount)getSqlMapClientTemplate().queryForObject("userAccount.selectByAccount", account);
/*    */   }
/*    */ 
/*    */   public int updateUserStatus(UserAccount userAccount)
/*    */   {
/* 37 */     return getSqlMapClientTemplate().update("userAccount.updateUserStatus", userAccount);
/*    */   }
/*    */ 
/*    */   public List<UserRole> selectRoleList()
/*    */   {
/* 43 */     return getSqlMapClientTemplate().queryForList("UserRole.getUserRoleList");
/*    */   }
/*    */ 
/*    */   public List<String> selectAccountList(List<String> accountList)
/*    */   {
/* 49 */     Map map = new HashMap();
/* 50 */     map.put("accountList", accountList);
/* 51 */     return getSqlMapClientTemplate().queryForList("userAccount.selectExitAccountList", map);
/*    */   }
/*    */ 
/*    */   public Long selectByParaMap(Map<String, Object> map)
/*    */   {
/* 57 */     return (Long)getSqlMapClientTemplate().queryForObject("userAccount.uniqueUser", map);
/*    */   }
/*    */ 
/*    */   public UserAccount getUserByFundAccount(String fundAccount)
/*    */   {
/* 62 */     return (UserAccount)getSqlMapClientTemplate().queryForObject("userAccount.getUserByFundAccount", fundAccount);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.ibatis.user.UserAccountDAOImpl
 * JD-Core Version:    0.6.0
 */