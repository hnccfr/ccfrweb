/*    */ package com.hundsun.eclp.biz.dao.impl;
/*    */ 
/*    */ import com.hundsun.eclp.biz.dao.UsersDAO;
/*    */ import com.hundsun.eclp.biz.domain.user.Users;
/*    */ import com.hundsun.eclp.biz.query.UsersQuery;
/*    */ import com.hundsun.eclp.enums.EnumUserStatus;
/*    */ import com.hundsun.network.common.dao.BaseDAO;
/*    */ import java.util.List;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("usersDao")
/*    */ public class UsersDAOImpl extends BaseDAO
/*    */   implements UsersDAO
/*    */ {
/*    */   public Long insert(Users record)
/*    */   {
/* 18 */     if (record != null) {
/* 19 */       return (Long)getSqlMapClientTemplate().insert("ECLP_USERS.INSERT", record);
/*    */     }
/* 21 */     return null;
/*    */   }
/*    */ 
/*    */   public List<Users> select(Users record)
/*    */   {
/* 27 */     if (record != null) {
/* 28 */       return getSqlMapClientTemplate().queryForList("ECLP_USERS.SELECT", record);
/*    */     }
/* 30 */     return null;
/*    */   }
/*    */ 
/*    */   public Users selectById(Long id)
/*    */   {
/* 35 */     if (id != null) {
/* 36 */       return (Users)getSqlMapClientTemplate().queryForObject("ECLP_USERS.SELECT_BY_ID", id);
/*    */     }
/* 38 */     return null;
/*    */   }
/*    */ 
/*    */   public int update(Users record)
/*    */   {
/* 43 */     if (record != null) {
/* 44 */       return getSqlMapClientTemplate().update("ECLP_USERS.UPDATE", record);
/*    */     }
/* 46 */     return 0;
/*    */   }
/*    */ 
/*    */   public int delete(Long id)
/*    */   {
/* 51 */     if (id != null) {
/* 52 */       Users user = selectById(id);
/* 53 */       if (user != null) {
/* 54 */         user.setStatus(Short.valueOf(EnumUserStatus.DELETE_STATUS.getCode()));
/* 55 */         return getSqlMapClientTemplate().update("ECLP_USERS.UPDATE", user);
/*    */       }
/*    */     }
/* 58 */     return 0;
/*    */   }
/*    */ 
/*    */   public UsersQuery serarchByPage(UsersQuery query)
/*    */   {
/* 63 */     query = (UsersQuery)getPagination(query, "ECLP_USERS.usersCountAll", "ECLP_USERS.usersSelectAll");
/*    */ 
/* 65 */     return query;
/*    */   }
/*    */ 
/*    */   public List<Users> selectNotReleUsers()
/*    */   {
/* 72 */     return getSqlMapClientTemplate().queryForList("ECLP_USERS.SELECTNOTRELE");
/*    */   }
/*    */ 
/*    */   public UsersQuery selectByAuthId(UsersQuery query)
/*    */   {
/* 77 */     query = (UsersQuery)getPagination(query, "ECLP_USERS.selectByAuthIdCount", "ECLP_USERS.selectByAuthId");
/* 78 */     return query;
/*    */   }
/*    */ 
/*    */   public List<Users> selectListByRoleList(UsersQuery query) {
/* 82 */     return getSqlMapClientTemplate().queryForList("ECLP_USERS.selectListByRoleList", query);
/*    */   }
/*    */ 
/*    */   public UsersQuery selectUsersByRoleId(UsersQuery query)
/*    */   {
/* 87 */     return (UsersQuery)getPagination(query, "ECLP_USERS.selectByRoleIdCount", "ECLP_USERS.selectByRoleId");
/*    */   }
/*    */ 
/*    */   public List<Users> selectUsersListByRoleId(Long roleId)
/*    */   {
/* 93 */     if (roleId == null) {
/* 94 */       return null;
/*    */     }
/* 96 */     return getSqlMapClientTemplate().queryForList("ECLP_USERS.selectUserListByRoleId", roleId);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.dao.impl.UsersDAOImpl
 * JD-Core Version:    0.6.0
 */