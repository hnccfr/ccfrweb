/*    */ package com.hundsun.network.gates.fengshan.biz.service.pojo.user;
/*    */ 
/*    */ import com.hundsun.network.gates.fengshan.biz.dao.user.UserRoleDAO;
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.user.UserRole;
/*    */ import com.hundsun.network.gates.fengshan.biz.service.user.UserRoleService;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("userRoleService")
/*    */ public class UserRoleServiceImpl
/*    */   implements UserRoleService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private UserRoleDAO userRoleDAO;
/*    */ 
/*    */   public UserRole getRoleByUserId(Long userId)
/*    */   {
/* 20 */     List roleList = this.userRoleDAO.getUserRoleBaseInfoByUserId(userId);
/* 21 */     if ((null != roleList) && (roleList.size() > 0)) {
/* 22 */       return (UserRole)roleList.get(0);
/*    */     }
/* 24 */     return null;
/*    */   }
/*    */ 
/*    */   public UserRole getRoleById(Long id)
/*    */   {
/* 29 */     return this.userRoleDAO.getRoleById(id);
/*    */   }
/*    */ 
/*    */   public List<UserRole> getRoles()
/*    */   {
/* 34 */     return this.userRoleDAO.getRoles();
/*    */   }
/*    */ 
/*    */   public List<UserRole> getUpRoleByRoleName(String userAccount)
/*    */   {
/* 39 */     String name = this.userRoleDAO.selectRoleInfoByUserAccount(userAccount).getName();
/* 40 */     return this.userRoleDAO.selectUpRoleByRoleName(name);
/*    */   }
/*    */ 
/*    */   public UserRole getRoleInfoByAccount(String userAccount)
/*    */   {
/* 45 */     return this.userRoleDAO.selectRoleInfoByUserAccount(userAccount);
/*    */   }
/*    */ 
/*    */   public UserRole getRoleInfoByName(String name)
/*    */   {
/* 50 */     return this.userRoleDAO.getRoleByName(name);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.service.pojo.user.UserRoleServiceImpl
 * JD-Core Version:    0.6.0
 */