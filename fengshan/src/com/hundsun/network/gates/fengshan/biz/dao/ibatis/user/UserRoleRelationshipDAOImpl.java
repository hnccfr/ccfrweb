/*    */ package com.hundsun.network.gates.fengshan.biz.dao.ibatis.user;
/*    */ 
/*    */ import com.hundsun.network.gates.fengshan.biz.dao.user.UserRoleRelationshipDAO;
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.user.UserRoleRelationship;
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
/* 21 */     return (Long)this.sqlMapClientTemplate.insert("UserRoleRelationship.addUserRole", userRole);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.dao.ibatis.user.UserRoleRelationshipDAOImpl
 * JD-Core Version:    0.6.0
 */