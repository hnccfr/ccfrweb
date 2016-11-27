/*    */ package com.hundsun.eclp.biz.service.impl;
/*    */ 
/*    */ import com.hundsun.eclp.biz.dao.LoginLogDAO;
/*    */ import com.hundsun.eclp.biz.domain.sys.LoginLog;
/*    */ import com.hundsun.eclp.biz.domain.user.Users;
/*    */ import com.hundsun.eclp.biz.query.LoginLogQuery;
/*    */ import com.hundsun.eclp.biz.service.LogService;
/*    */ import java.util.Date;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("logService")
/*    */ public class LogServiceImpl
/*    */   implements LogService
/*    */ {
/* 19 */   protected Log log = LogFactory.getLog(getClass());
/*    */ 
/*    */   @Autowired
/*    */   LoginLogDAO loginLogDao;
/*    */ 
/* 26 */   public void createLoginLog(Users user, String loginIp, boolean isSuccess, String tips, String mac) { LoginLog log = new LoginLog();
/* 27 */     log.setUserId(user.getId());
/* 28 */     log.setAccount(user.getAccount());
/* 29 */     log.setLoginIp(loginIp);
/* 30 */     log.setLoginTime(new Date());
/* 31 */     log.setStatus(Short.valueOf((short) (isSuccess ? 1 : 2)));
/* 32 */     log.setMac(mac);
/* 33 */     log.setRemark(tips);
/* 34 */     this.loginLogDao.insert(log);
/*    */   }
/*    */ 
/*    */   public LoginLogQuery selectLoginLogByPage(LoginLogQuery query)
/*    */   {
/* 39 */     this.log.info("LogServiceImpl.selectByPage method");
/*    */     try {
/* 41 */       return this.loginLogDao.serarchByPage(query);
/*    */     } catch (Exception e) {
/* 43 */       this.log.error(e.getMessage());
/*    */     }
/* 45 */     return null;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.service.impl.LogServiceImpl
 * JD-Core Version:    0.6.0
 */