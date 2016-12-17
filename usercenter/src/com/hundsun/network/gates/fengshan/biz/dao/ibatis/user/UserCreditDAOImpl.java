/*    */ package com.hundsun.network.gates.fengshan.biz.dao.ibatis.user;
/*    */ 
/*    */ import com.hundsun.network.gates.fengshan.biz.dao.user.UserCreditDAO;
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.query.EvaluateQuery;
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.user.UserCredit;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("userCreditDAO")
/*    */ public class UserCreditDAOImpl extends BaseDAO
/*    */   implements UserCreditDAO
/*    */ {
/*    */   public int deleteByPrimaryKey(Long id)
/*    */   {
/* 14 */     return getSqlMapClientTemplate().delete("UserCredit.deleteByPrimaryKey", id);
/*    */   }
/*    */ 
/*    */   public void insert(UserCredit record) {
/* 18 */     getSqlMapClientTemplate().insert("UserCredit.insert", record);
/*    */   }
/*    */ 
/*    */   public UserCredit selectByPrimaryKey(Long id) {
/* 22 */     return (UserCredit)getSqlMapClientTemplate().queryForObject("UserCredit.selectByPrimaryKey", id);
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKeySelective(UserCredit record)
/*    */   {
/* 27 */     return getSqlMapClientTemplate().update("UserCredit.updateByPrimaryKeySelective", record);
/*    */   }
/*    */ 
/*    */   public UserCredit selectByUserAccount(String userAccount)
/*    */   {
/* 32 */     return (UserCredit)getSqlMapClientTemplate().queryForObject("UserCredit.selectByUserAccount", userAccount);
/*    */   }
/*    */ 
/*    */   public void selectEvaluateList(EvaluateQuery query)
/*    */   {
/* 37 */     paginate(query, "USER_CREDIT_LOG.selectListCount", "USER_CREDIT_LOG.selectList");
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.dao.ibatis.user.UserCreditDAOImpl
 * JD-Core Version:    0.6.0
 */