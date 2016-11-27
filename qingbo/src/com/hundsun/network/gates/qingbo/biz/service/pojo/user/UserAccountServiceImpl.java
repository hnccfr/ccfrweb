/*    */ package com.hundsun.network.gates.qingbo.biz.service.pojo.user;
/*    */ 
/*    */ import com.hundsun.network.gates.qingbo.biz.dao.user.UserAccountDAO;
/*    */ import com.hundsun.network.gates.qingbo.biz.domain.user.UserAccount;
/*    */ import com.hundsun.network.gates.qingbo.biz.service.BaseService;
/*    */ import com.hundsun.network.gates.qingbo.biz.service.user.UserAccountService;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("userAccountService")
/*    */ public class UserAccountServiceImpl extends BaseService
/*    */   implements UserAccountService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private UserAccountDAO userAccountDAO;
/*    */ 
/*    */   public UserAccount getUserByAccount(String account)
/*    */   {
/* 27 */     return this.userAccountDAO.selectUserByAccount(account);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.qingbo.biz.service.pojo.user.UserAccountServiceImpl
 * JD-Core Version:    0.6.0
 */