/*    */ package com.hundsun.network.gates.wulin.biz.dao.ibatis.user;
/*    */ 
/*    */ import com.hundsun.network.gates.wulin.biz.dao.user.UserRoleRelationshipDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.user.UserRoleRelationship;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("userRoleRelationshipDAO")
/*    */ public class UserRoleRelationshipDAOImpl
/*    */   implements UserRoleRelationshipDAO
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private SqlMapClientTemplate sqlMapClientTemplate;
/*    */ 
/*    */   public Long addUserRole(UserRoleRelationship userRole)
/*    */   {
/* 24 */     return (Long)this.sqlMapClientTemplate.insert("UserRoleRelationship.addUserRole", userRole);
/*    */   }
/*    */ 
/*    */   public int updateUserRole(String userAccount, String roleName)
/*    */   {
/* 31 */     Map map = new HashMap();
/* 32 */     map.put("userAccount", userAccount);
/* 33 */     map.put("roleName", roleName);
/* 34 */     return this.sqlMapClientTemplate.update("UserRoleRelationship.updateUserRole", map);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.ibatis.user.UserRoleRelationshipDAOImpl
 * JD-Core Version:    0.6.0
 */