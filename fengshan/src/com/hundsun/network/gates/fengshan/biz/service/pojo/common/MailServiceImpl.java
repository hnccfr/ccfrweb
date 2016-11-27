/*    */ package com.hundsun.network.gates.fengshan.biz.service.pojo.common;
/*    */ 
/*    */ import com.hundsun.network.gates.fengshan.biz.dao.user.UserAccountDAO;
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.user.UserAccount;
/*    */ import com.hundsun.network.gates.fengshan.biz.service.BaseService;
/*    */ import com.hundsun.network.gates.fengshan.biz.service.common.MailService;
/*    */ import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumUserResultErrors;
/*    */ import com.hundsun.network.melody.common.mail.context.MailContext;
/*    */ import com.hundsun.network.melody.common.mail.sender.MailSender;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.beans.factory.annotation.Value;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("mailService")
/*    */ public class MailServiceImpl extends BaseService
/*    */   implements MailService
/*    */ {
/*    */ 
/*    */   @Value("${mail.from}")
/*    */   private String mailFrom;
/*    */ 
/*    */   @Autowired
/*    */   private MailSender velocityMailSender;
/*    */ 
/*    */   @Autowired
/*    */   private UserAccountDAO userAccountDAO;
/*    */ 
/*    */   public ServiceResult sendActivateMail(String account)
/*    */   {
/* 28 */     ServiceResult result = new ServiceResult();
/* 29 */     UserAccount userAccount = this.userAccountDAO.selectByAccount(account);
/* 30 */     if (null == userAccount) {
/* 31 */       result.setErrorInfo(EnumUserResultErrors.USER_NOT_EXISTS.getInfo());
/* 32 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.USER_NOT_EXISTS.getValue()));
/* 33 */       return result;
/*    */     }
/* 35 */     MailContext mail = new MailContext();
/* 36 */     mail.setTemplate("user-activate.vm");
/* 37 */     mail.setFrom(this.mailFrom);
/* 38 */     mail.setSubject("中部林业产权交易服务系统用户激活");
/* 39 */     mail.addAttribute("userAccount", userAccount);
/* 40 */     mail.setTo(userAccount.getEmail());
/* 41 */     this.velocityMailSender.send(mail);
/* 42 */     return result;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.service.pojo.common.MailServiceImpl
 * JD-Core Version:    0.6.0
 */