/*    */ package com.hundsun.network.gates.genshan.biz.dao.ibatis.baseset;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.baseset.UserLevelDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.baseset.UserLevel;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.query.UserLevelQuery;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("userLevelDAO")
/*    */ public class UserLevelDAOImpl extends BaseDAO
/*    */   implements UserLevelDAO
/*    */ {
/*    */   public void selectPageList(UserLevelQuery query)
/*    */   {
/* 23 */     paginate(query, "USER_LEVEL.selectPageList-count", "USER_LEVEL.selectPageList");
/*    */   }
/*    */ 
/*    */   public Long insert(UserLevel record)
/*    */   {
/* 31 */     return (Long)getSqlMapClientTemplate().insert("USER_LEVEL.insert", record);
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKey(UserLevel record)
/*    */   {
/* 40 */     int rows = getSqlMapClientTemplate().update("USER_LEVEL.updateByPrimaryKey", record);
/* 41 */     return rows;
/*    */   }
/*    */ 
/*    */   public UserLevel selectByPrimaryKey(Long id)
/*    */   {
/* 50 */     UserLevel key = new UserLevel();
/* 51 */     key.setId(id);
/* 52 */     UserLevel record = (UserLevel)getSqlMapClientTemplate().queryForObject("USER_LEVEL.selectByPrimaryKey", key);
/* 53 */     return record;
/*    */   }
/*    */ 
/*    */   public UserLevel selectByUserAccount(String userAccount)
/*    */   {
/* 62 */     UserLevel record = (UserLevel)getSqlMapClientTemplate().queryForObject("USER_LEVEL.selectByUserAccount", userAccount);
/* 63 */     return record;
/*    */   }
/*    */ 
/*    */   public int deleteByPrimaryKey(Long id)
/*    */   {
/* 72 */     UserLevel key = new UserLevel();
/* 73 */     key.setId(id);
/* 74 */     int rows = getSqlMapClientTemplate().delete("USER_LEVEL.deleteByPrimaryKey", key);
/* 75 */     return rows;
/*    */   }
/*    */ 
/*    */   public UserLevel selectUserLevelByUserAccount(String userAccount)
/*    */   {
/* 80 */     return (UserLevel)getSqlMapClientTemplate().queryForObject("USER_LEVEL.selectByUserAccount", userAccount);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.ibatis.baseset.UserLevelDAOImpl
 * JD-Core Version:    0.6.0
 */