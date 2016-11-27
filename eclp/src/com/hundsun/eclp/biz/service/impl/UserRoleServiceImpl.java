/*    */ package com.hundsun.eclp.biz.service.impl;
/*    */ 
/*    */ import com.hundsun.eclp.biz.dao.UserRoleDAO;
/*    */ import com.hundsun.eclp.biz.domain.user.UserAgent;
/*    */ import com.hundsun.eclp.biz.domain.user.UserRole;
/*    */ import com.hundsun.eclp.biz.service.ToolService;
/*    */ import com.hundsun.eclp.biz.service.UserRoleService;
/*    */ import com.hundsun.eclp.biz.service.sys.WorkLogService;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ import org.springframework.transaction.TransactionStatus;
/*    */ import org.springframework.transaction.support.TransactionCallback;
/*    */ import org.springframework.transaction.support.TransactionTemplate;
/*    */ 
/*    */ @Service("userRoleService")
/*    */ public class UserRoleServiceImpl
/*    */   implements UserRoleService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private UserRoleDAO userRoleDAO;
/*    */ 
/*    */   @Autowired
/*    */   TransactionTemplate transactionTemplate;
/*    */ 
/*    */   @Autowired
/*    */   private ToolService toolService;
/*    */ 
/*    */   @Autowired
/*    */   private WorkLogService workLogService;
/*    */ 
/*    */   public int getUserRoleCount(Long roleId)
/*    */   {
/* 38 */     return this.userRoleDAO.getUserRoleCount(roleId);
/*    */   }
/*    */ 
/*    */   public List<UserRole> selectByUserId(Long userId)
/*    */   {
/* 43 */     if (userId != null) {
/* 44 */       return this.userRoleDAO.selectByUserId(userId);
/*    */     }
/* 46 */     return null;
/*    */   }
/*    */ 
/*    */   public void insert(final Long userId,final List<UserRole> list,final UserAgent userAgent)
/*    */   {
/* 52 */     if (list != null)
/* 53 */       this.transactionTemplate.execute(new TransactionCallback()
/*    */       {
/*    */         public String doInTransaction(TransactionStatus status) {
/* 56 */           UserRoleServiceImpl.this.userRoleDAO.deleteByUserId(userId);
/*    */ 
/* 58 */           String result = "0";
/* 59 */           if ((list != null) && (list.size() > 0)) {
/* 60 */             int row = UserRoleServiceImpl.this.userRoleDAO.insert(list);
/* 61 */             result = Integer.toString(row);
/*    */           }
/*    */ 
/* 64 */           UserRoleServiceImpl.this.toolService.synchronizeUpdateTime(null);
/*    */ 
/* 67 */           UserRoleServiceImpl.this.workLogService.addWorkLog("分配角色", "用户ID:" + userAgent.getId() + ",name:'" + userAgent.getName() + "分配角色成功", userAgent);
/*    */ 
/* 69 */           return result;
/*    */         }
/*    */       });
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.service.impl.UserRoleServiceImpl
 * JD-Core Version:    0.6.0
 */