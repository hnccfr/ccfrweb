/*    */ package com.hundsun.network.gates.fengshan.biz.dao.ibatis.user;
/*    */ 
/*    */ import com.hundsun.network.gates.fengshan.biz.dao.user.UserLevelDAO;
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.user.UserLevel;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("userLevelDAO")
/*    */ public class UserLevelDAOImpl extends BaseDAO
/*    */   implements UserLevelDAO
/*    */ {
/*    */   public int deleteByPrimaryKey(Long id)
/*    */   {
/* 13 */     return getSqlMapClientTemplate().delete("UserLevel.deleteByPrimaryKey", id);
/*    */   }
/*    */ 
/*    */   public void insert(UserLevel record) {
/* 17 */     getSqlMapClientTemplate().insert("UserLevel.insert", record);
/*    */   }
/*    */ 
/*    */   public UserLevel selectByPrimaryKey(Long id) {
/* 21 */     return (UserLevel)getSqlMapClientTemplate().queryForObject("UserLevel.selectByPrimaryKey", id);
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKeySelective(UserLevel record)
/*    */   {
/* 26 */     return getSqlMapClientTemplate().update("UserLevel.updateByPrimaryKeySelective", record);
/*    */   }
/*    */ 
/*    */   public UserLevel selectByUserAccount(String userAccount)
/*    */   {
/* 31 */     return (UserLevel)getSqlMapClientTemplate().queryForObject("UserLevel.selectByUserAccount", userAccount);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.dao.ibatis.user.UserLevelDAOImpl
 * JD-Core Version:    0.6.0
 */