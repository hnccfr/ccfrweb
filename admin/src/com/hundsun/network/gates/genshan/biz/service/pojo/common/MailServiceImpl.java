/*    */ package com.hundsun.network.gates.genshan.biz.service.pojo.common;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.user.UserAccountDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.user.UserAccount;
/*    */ import com.hundsun.network.gates.genshan.biz.service.BaseService;
/*    */ import com.hundsun.network.gates.genshan.biz.service.common.MailService;
/*    */ import com.hundsun.network.gates.luosi.biz.enums.EnumPasswordType;
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
/*    */   @Value("${fengshan.domain}")
/*    */   private String fengshanDomain;
/*    */ 
/*    */   public ServiceResult sendPassWordRestMail(String account, String passwordType, String newPassword)
/*    */   {
/* 31 */     ServiceResult result = new ServiceResult();
/* 32 */     UserAccount userAccount = this.userAccountDAO.selectUserByAccount(account);
/* 33 */     if (null == userAccount) {
/* 34 */       result.setErrorInfo(EnumUserResultErrors.USER_NOT_EXISTS.getInfo());
/* 35 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.USER_NOT_EXISTS.getValue()));
/* 36 */       return result;
/*    */     }
/* 38 */     MailContext mail = new MailContext();
/* 39 */     mail.setFrom(this.mailFrom);
/* 40 */     mail.setTo(userAccount.getEmail());
/* 41 */     mail.addAttribute("userAccount", userAccount);
/*    */ 
/* 43 */     mail.addAttribute("passwordTypeDesc", EnumPasswordType.indexByValue(passwordType).getName());
/* 44 */     mail.setTemplate("user-password-reset.vm");
/* 45 */     mail.addAttribute("newPassword", newPassword);
/* 46 */     mail.addAttribute("fengshanDomain", "http://" + this.fengshanDomain);
/* 47 */     if (EnumPasswordType.SYSTEM.getValue().equals(passwordType))
/* 48 */       mail.setSubject("中部林业产权交易服务系统用户系统密码重置结果");
/*    */     else {
/* 50 */       mail.setSubject("中部林业产权交易服务系统用户资金账户密码重置结果");
/*    */     }
/* 52 */     this.velocityMailSender.send(mail);
/*    */ 
/* 54 */     return result;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.service.pojo.common.MailServiceImpl
 * JD-Core Version:    0.6.0
 */