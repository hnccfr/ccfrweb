/*    */ package com.hundsun.eclp.biz.service.role.impl;
/*    */ 
/*    */ import com.hundsun.eclp.biz.dao.RoleSystemDAO;
/*    */ import com.hundsun.eclp.biz.domain.role.RoleSytem;
/*    */ import com.hundsun.eclp.biz.service.role.RoleSystemService;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("roleSytemService")
/*    */ public class RoleSystemServiceImpl
/*    */   implements RoleSystemService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private RoleSystemDAO roleSystemDao;
/*    */ 
/*    */   public Long insertRoleSystem(RoleSytem roleSytem)
/*    */   {
/* 17 */     return this.roleSystemDao.insertRoleSystem(roleSytem);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.service.role.impl.RoleSystemServiceImpl
 * JD-Core Version:    0.6.0
 */