/*    */ package com.hundsun.network.gates.genshan.biz.dao.ibatis.baseset;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.baseset.UserCreditDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.baseset.UserCredit;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.query.UserCreditQuery;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.user.UserCreditInfo;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import java.util.List;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("userCreditDAO")
/*    */ public class UserCreditDAOImpl extends BaseDAO
/*    */   implements UserCreditDAO
/*    */ {
/*    */   public void selectPageList(UserCreditQuery query)
/*    */   {
/* 26 */     paginate(query, "USER_CREDIT.selectPageList-count", "USER_CREDIT.selectPageList");
/*    */   }
/*    */ 
/*    */   public List<UserCredit> selectConditionList(UserCreditQuery query)
/*    */   {
/* 36 */     return getSqlMapClientTemplate().queryForList("USER_CREDIT.selectConditionList");
/*    */   }
/*    */ 
/*    */   public Long insert(UserCredit record)
/*    */   {
/* 44 */     return (Long)getSqlMapClientTemplate().insert("USER_CREDIT.insert", record);
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKey(UserCredit record)
/*    */   {
/* 53 */     int rows = getSqlMapClientTemplate().update("USER_CREDIT.updateByPrimaryKey", record);
/* 54 */     return rows;
/*    */   }
/*    */ 
/*    */   public UserCredit selectByPrimaryKey(Long id)
/*    */   {
/* 63 */     UserCredit record = (UserCredit)getSqlMapClientTemplate().queryForObject("USER_CREDIT.selectByPrimaryKey", id);
/* 64 */     return record;
/*    */   }
/*    */ 
/*    */   public UserCreditInfo selectByUserAccount(String userAccount)
/*    */   {
/* 69 */     return (UserCreditInfo)getSqlMapClientTemplate().queryForObject("USER_CREDIT.selectByUserAccount", userAccount);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.ibatis.baseset.UserCreditDAOImpl
 * JD-Core Version:    0.6.0
 */