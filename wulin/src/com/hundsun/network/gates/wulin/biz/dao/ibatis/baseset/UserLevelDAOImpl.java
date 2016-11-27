/*    */ package com.hundsun.network.gates.wulin.biz.dao.ibatis.baseset;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.dao.baseset.UserLevelDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.baseset.UserLevel;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("userLevelDAO")
/*    */ public class UserLevelDAOImpl extends BaseDAO
/*    */   implements UserLevelDAO
/*    */ {
/*    */   public UserLevel selectByAccount(String userAccount)
/*    */   {
/* 13 */     return (UserLevel)getSqlMapClientTemplate().queryForObject("USER_LEVEL.selectByAccount", userAccount);
/*    */   }
/*    */ 
/*    */   public Long insertUserLevel(UserLevel userLevel) {
/* 17 */     return (Long)getSqlMapClientTemplate().insert("USER_LEVEL.insertUserLevel", userLevel);
/*    */   }
/*    */ 
/*    */   public int updateUserLevel(UserLevel userLevel) {
/* 21 */     return getSqlMapClientTemplate().update("USER_LEVEL.updateUserLevel", userLevel);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.ibatis.baseset.UserLevelDAOImpl
 * JD-Core Version:    0.6.0
 */