/*    */ package com.hundsun.eclp.biz.dao.impl;
/*    */ 
/*    */ import com.hundsun.eclp.biz.dao.UserRoleDAO;
/*    */ import com.hundsun.eclp.biz.domain.user.UserRole;
/*    */ import com.hundsun.network.common.dao.BaseDAO;
/*    */ import java.util.List;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("userRoleDao")
/*    */ public class UserRoleDAOImpl extends BaseDAO
/*    */   implements UserRoleDAO
/*    */ {
/*    */   public int deleteById(Long id)
/*    */   {
/* 17 */     if (id != null) {
/* 18 */       return getSqlMapClientTemplate().delete("ECLP_USER_ROLE.SELECT_BY_ID", id);
/*    */     }
/* 20 */     return 0;
/*    */   }
/*    */ 
/*    */   public int deleteByUserId(Long userId)
/*    */   {
/* 25 */     if (userId != null) {
/* 26 */       UserRole userRole = new UserRole();
/* 27 */       userRole.setUserId(userId);
/* 28 */       return getSqlMapClientTemplate().delete("ECLP_USER_ROLE.DELETE_BY_USERID", userId);
/*    */     }
/* 30 */     return 0;
/*    */   }
/*    */ 
/*    */   public int insert(List<UserRole> list)
/*    */   {
/* 35 */     if (list != null) {
/* 36 */       return exectuteBatchInsert("ECLP_USER_ROLE.INSERT", list);
/*    */     }
/* 38 */     return 0;
/*    */   }
/*    */ 
/*    */   public List<UserRole> selectByUserId(Long userId)
/*    */   {
/* 44 */     if (userId != null) {
/* 45 */       return getSqlMapClientTemplate().queryForList("ECLP_USER_ROLE.SELECT_BY_USERID", userId);
/*    */     }
/* 47 */     return null;
/*    */   }
/*    */ 
/*    */   public int update(UserRole record)
/*    */   {
/* 52 */     if (record != null) {
/* 53 */       getSqlMapClientTemplate().update("ECLP_USER_ROLE.UPDATE", record);
/*    */     }
/* 55 */     return 0;
/*    */   }
/*    */ 
/*    */   public int getUserRoleCount(Long roleId) {
/* 59 */     return ((Integer)getSqlMapClientTemplate().queryForObject("ECLP_USER_ROLE.getUserRoleCount", roleId)).intValue();
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.dao.impl.UserRoleDAOImpl
 * JD-Core Version:    0.6.0
 */