/*    */ package com.hundsun.eclp.interfaces.impl;
/*    */ 
/*    */ import com.hundsun.eclp.biz.domain.user.Users;
/*    */ import com.hundsun.eclp.biz.service.UsersService;
/*    */ import com.hundsun.eclp.client.remote.client.RemoteUserLoginService;
/*    */ import com.hundsun.eclp.client.remote.dto.UserDTO;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("remoteUserLoginService")
/*    */ public class RemoteUserLoginServiceImpl
/*    */   implements RemoteUserLoginService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   UsersService userService;
/*    */ 
/*    */   public UserDTO login(String username, String password)
/*    */   {
/* 31 */     Users user = new Users(username, password);
/* 32 */     if (this.userService.checkAccountAndPassword(user)) {
/* 33 */       user = this.userService.getUserByAccount(username);
/* 34 */       UserDTO userDTO = new UserDTO();
/* 35 */       userDTO.setId(user.getId());
/* 36 */       userDTO.setAccount(user.getAccount());
/* 37 */       userDTO.setRealName(user.getName());
/* 38 */       userDTO.setLastLoginIP(user.getLastLoginIp());
/* 39 */       userDTO.setLastLoginTime(user.getLastLoginTime());
/* 40 */       return userDTO;
/*    */     }
/* 42 */     return null;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.interfaces.impl.RemoteUserLoginServiceImpl
 * JD-Core Version:    0.6.0
 */