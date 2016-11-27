/*    */ package com.hundsun.network.gates.fengshan.biz.domain.user;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public class UserLogin
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1274823403920414220L;
/*    */   private String account;
/*    */   private String password;
/*    */   private String loginIp;
/*    */   private String checkCode;
/*    */ 
/*    */   public String getAccount()
/*    */   {
/* 27 */     return this.account;
/*    */   }
/*    */ 
/*    */   public void setAccount(String account) {
/* 31 */     this.account = account;
/*    */   }
/*    */ 
/*    */   public String getPassword() {
/* 35 */     return this.password;
/*    */   }
/*    */ 
/*    */   public void setPassword(String password) {
/* 39 */     this.password = password;
/*    */   }
/*    */ 
/*    */   public String getCheckCode() {
/* 43 */     return this.checkCode;
/*    */   }
/*    */ 
/*    */   public void setCheckCode(String checkCode) {
/* 47 */     this.checkCode = checkCode;
/*    */   }
/*    */ 
/*    */   public String getLoginIp() {
/* 51 */     return this.loginIp;
/*    */   }
/*    */ 
/*    */   public void setLoginIp(String loginIp) {
/* 55 */     this.loginIp = loginIp;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.domain.user.UserLogin
 * JD-Core Version:    0.6.0
 */