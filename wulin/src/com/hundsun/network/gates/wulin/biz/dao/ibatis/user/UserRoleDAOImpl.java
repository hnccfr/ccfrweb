/*    */ package com.hundsun.network.gates.wulin.biz.dao.ibatis.user;
/*    */ 
/*    */ import com.hundsun.network.gates.wulin.biz.dao.user.UserRoleDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.user.UserRole;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("userRoleDAO")
/*    */ public class UserRoleDAOImpl
/*    */   implements UserRoleDAO
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private SqlMapClientTemplate sqlMapClientTemplate;
/*    */ 
/*    */   public List<UserRole> getUserRoleBaseInfoByUserId(Long id)
/*    */   {
/* 20 */     return this.sqlMapClientTemplate.queryForList("UserRole.getUserRoleBaseInfoByUserId", id);
/*    */   }
/*    */ 
/*    */   public Long addRole(UserRole userRole)
/*    */   {
/* 25 */     return (Long)this.sqlMapClientTemplate.insert("UserRole.addRole", userRole);
/*    */   }
/*    */ 
/*    */   public int editRole(UserRole userRole) {
/* 29 */     return this.sqlMapClientTemplate.update("UserRole.editRole", userRole);
/*    */   }
/*    */ 
/*    */   public int removeRole(Long id) {
/* 33 */     return this.sqlMapClientTemplate.delete("UserRole.removeRole", id);
/*    */   }
/*    */ 
/*    */   public UserRole getRoleById(Long id) {
/* 37 */     return (UserRole)this.sqlMapClientTemplate.queryForObject("UserRole.getRoleById", id);
/*    */   }
/*    */ 
/*    */   public List<UserRole> getRoles()
/*    */   {
/* 42 */     return this.sqlMapClientTemplate.queryForList("UserRole.getAllRoles");
/*    */   }
/*    */ 
/*    */   public UserRole getRoleByName(String name)
/*    */   {
/* 47 */     return (UserRole)this.sqlMapClientTemplate.queryForObject("UserRole.getRoleByName", name);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.ibatis.user.UserRoleDAOImpl
 * JD-Core Version:    0.6.0
 */