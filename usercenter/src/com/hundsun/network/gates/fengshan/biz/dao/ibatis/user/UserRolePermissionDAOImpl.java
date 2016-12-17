/*    */ package com.hundsun.network.gates.fengshan.biz.dao.ibatis.user;
/*    */ 
/*    */ import com.hundsun.network.gates.fengshan.biz.dao.user.UserRolePermissionDAO;
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.user.UserRolePermission;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("userRolePermissionDAO")
/*    */ public class UserRolePermissionDAOImpl
/*    */   implements UserRolePermissionDAO
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private SqlMapClientTemplate sqlMapClientTemplate;
/*    */ 
/*    */   public Long addRolePermission(UserRolePermission userRolePermission)
/*    */   {
/* 19 */     return (Long)this.sqlMapClientTemplate.insert("UserRolePermission.addRolePermissions", userRolePermission);
/*    */   }
/*    */ 
/*    */   public List<UserRolePermission> getRolePermsByRoleId(Long roleId)
/*    */   {
/* 25 */     return this.sqlMapClientTemplate.queryForList("UserRolePermission.getRolePermsByRoleId", roleId);
/*    */   }
/*    */ 
/*    */   public int removeRolePermission(Long roleId)
/*    */   {
/* 30 */     return this.sqlMapClientTemplate.delete("UserRolePermission.removeRoleFuncsByRoleId", roleId);
/*    */   }
/*    */ 
/*    */   public int deleteById(Long id)
/*    */   {
/* 35 */     return this.sqlMapClientTemplate.delete("UserRolePermission.deleteById", id);
/*    */   }
/*    */ 
/*    */   public List<Integer> getUserPermissions(Long userId)
/*    */   {
/* 41 */     return this.sqlMapClientTemplate.queryForList("UserRolePermission.getUserPermissions", userId);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.dao.ibatis.user.UserRolePermissionDAOImpl
 * JD-Core Version:    0.6.0
 */