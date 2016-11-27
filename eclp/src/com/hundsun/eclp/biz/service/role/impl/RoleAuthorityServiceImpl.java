/*    */ package com.hundsun.eclp.biz.service.role.impl;
/*    */ 
/*    */ import com.hundsun.eclp.biz.dao.RoleAuthorityDAO;
/*    */ import com.hundsun.eclp.biz.domain.auth.Authority;
/*    */ import com.hundsun.eclp.biz.domain.role.RoleAuthority;
/*    */ import com.hundsun.eclp.biz.service.AuthorityService;
/*    */ import com.hundsun.eclp.biz.service.role.RoleAuthorityService;
/*    */ import com.hundsun.eclp.enums.EnumAuthorityType;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ import org.springframework.transaction.TransactionStatus;
/*    */ import org.springframework.transaction.support.TransactionCallback;
/*    */ import org.springframework.transaction.support.TransactionTemplate;
/*    */ 
/*    */ @Service("roleAuthorityService")
/*    */ public class RoleAuthorityServiceImpl
/*    */   implements RoleAuthorityService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   RoleAuthorityDAO roleAuthorityDAO;
/*    */ 
/*    */   @Autowired
/*    */   TransactionTemplate transactionTemplate;
/*    */ 
/*    */   @Autowired
/*    */   AuthorityService authorityService;
/*    */ 
/*    */   public List<RoleAuthority> selectRoleAuthorityByRoleId(Long roleId)
/*    */   {
/* 28 */     if (roleId != null) {
/* 29 */       return this.roleAuthorityDAO.selectRoleAuthorityByRoleId(roleId);
/*    */     }
/* 31 */     return null;
/*    */   }
/*    */ 
/*    */   public void batchInsertRoleAuth(final Long roleId, final List<RoleAuthority> list) {
/* 35 */     this.transactionTemplate.execute(new TransactionCallback()
/*    */     {
/*    */       public String doInTransaction(TransactionStatus status)
/*    */       {
/* 39 */         RoleAuthorityServiceImpl.this.roleAuthorityDAO.deleteRoleAuthorityByRoleId(roleId);
/* 40 */         if ((list != null) && (list.size() > 0))
/*    */         {
/* 42 */           RoleAuthorityServiceImpl.this.roleAuthorityDAO.batchInsertRoleAuth(list);
/*    */         }
/* 44 */         return null;
/*    */       } } );
/*    */   }
/*    */ 
/*    */   public Integer deleteRoleAuthorityByRoleId(Long roleId) {
/* 50 */     if (roleId != null) {
/* 51 */       return Integer.valueOf(this.roleAuthorityDAO.deleteRoleAuthorityByRoleId(roleId));
/*    */     }
/* 53 */     return Integer.valueOf(0);
/*    */   }
/*    */ 
/*    */   public Integer deleteRoleAuthorityById(Long id)
/*    */   {
/* 58 */     if (id != null) {
/* 59 */       return Integer.valueOf(this.roleAuthorityDAO.deleteRoleAuthorityById(id));
/*    */     }
/* 61 */     return Integer.valueOf(0);
/*    */   }
/*    */ 
/*    */   public void deleteRoleAuthority(List<RoleAuthority> list)
/*    */   {
/* 69 */     if ((list != null) && (list.size() > 0))
/* 70 */       for (RoleAuthority roleAuth : list) {
/* 71 */         Authority auth = this.authorityService.selectAuthorityById(roleAuth.getAuthId());
/* 72 */         if (auth != null) {
/* 73 */           if (EnumAuthorityType.OPERATION.getCode() != auth.getType().shortValue())
/*    */           {
/* 75 */             List roleAuthList = this.roleAuthorityDAO.findRoleAuthByRoleIdAndAuthId(roleAuth);
/*    */ 
/* 77 */             if ((roleAuthList != null) && (roleAuthList.size() > 0)) {
/* 78 */               this.roleAuthorityDAO.deleteRoleAuthority(roleAuthList);
/*    */             }
/*    */           }
/*    */ 
/* 82 */           deleteParentRoleAuth(auth, roleAuth);
/*    */         }
/*    */       }
/*    */   }
/*    */ 
/*    */   private void deleteParentRoleAuth(Authority auth, RoleAuthority roleAuth)
/*    */   {
/* 93 */     if ((auth != null) && (roleAuth != null))
/*    */     {
/* 95 */       List list = new ArrayList();
/* 96 */       list.add(roleAuth);
/* 97 */       this.roleAuthorityDAO.deleteRoleAuthority(list);
/*    */ 
/* 99 */       if (EnumAuthorityType.SYSTEM.getCode() != auth.getType().shortValue())
/*    */       {
/* 101 */         roleAuth.setAuthId(auth.getParentId());
/* 102 */         List roleAuthList = this.roleAuthorityDAO.findParentRoleAuth(roleAuth);
/*    */ 
/* 104 */         if ((roleAuthList == null) || (roleAuthList.size() == 0))
/*    */         {
/* 106 */           Authority parentAuth = this.authorityService.selectAuthorityById(auth.getParentId());
/* 107 */           RoleAuthority parentRoleAuth = new RoleAuthority();
/* 108 */           parentRoleAuth.setAuthId(parentAuth.getId());
/* 109 */           parentRoleAuth.setRoleId(roleAuth.getRoleId());
/*    */ 
/* 111 */           deleteParentRoleAuth(parentAuth, parentRoleAuth);
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.service.role.impl.RoleAuthorityServiceImpl
 * JD-Core Version:    0.6.0
 */