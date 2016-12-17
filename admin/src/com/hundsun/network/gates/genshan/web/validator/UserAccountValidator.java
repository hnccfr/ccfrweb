/*    */ package com.hundsun.network.gates.genshan.web.validator;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.domain.user.UserAccount;
/*    */ import com.hundsun.network.gates.genshan.biz.service.user.UserAccountService;
/*    */ import com.hundsun.network.gates.luosi.common.enums.EnumUserType;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.validation.Errors;
/*    */ import org.springmodules.validation.valang.ValangValidator;
/*    */ 
/*    */ public class UserAccountValidator extends ValangValidator
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private UserAccountService userAccountService;
/*    */ 
/*    */   public void validate(Object obj, Errors errors)
/*    */   {
/* 27 */     super.validate(obj, errors);
/*    */ 
/* 29 */     UserAccount userAccount = (UserAccount)obj;
/* 30 */     if (userAccount.getType().equals(EnumUserType.ENTERPRISE.getValue()))
/*    */     {
/* 32 */       if (userAccount.getFullName().equals(""))
/* 33 */         errors.rejectValue("fullName", "common.error.required", null, null);
/* 34 */       else if (userAccount.getFullName().length() > 85) {
/* 35 */         errors.rejectValue("fullName", "common.error.maxlength", new String[] { "85" }, null);
/*    */       }
/*    */ 
/* 38 */       if (userAccount.getTaxNum().equals(""))
/* 39 */         errors.rejectValue("taxNum", "common.error.required", null, null);
/* 40 */       else if (userAccount.getTaxNum().length() > 20) {
/* 41 */         errors.rejectValue("taxNum", "common.error.maxlength", new String[] { "20" }, null);
/*    */       }
/*    */ 
/* 44 */       if ((null != userAccount.getScope()) && 
/* 45 */         (userAccount.getScope().length() > 170)) {
/* 46 */         errors.rejectValue("scope", "common.error.maxlength", new String[] { "170" }, null);
/*    */       }
/*    */ 
/* 50 */       if ((null != userAccount.getIntro()) && 
/* 51 */         (userAccount.getIntro().length() > 340)) {
/* 52 */         errors.rejectValue("intro", "common.error.maxlength", new String[] { "340" }, null);
/*    */       }
/*    */ 
/* 56 */       if ((null == userAccount.getPhone()) || (userAccount.getPhone().equals(""))) {
/* 57 */         errors.rejectValue("phone", "common.error.required", null, null);
/*    */       }
/*    */     }
/*    */ 
/* 61 */     Map dataMap = new HashMap();
/* 62 */     if (null != userAccount.getAccount()) {
/* 63 */       dataMap.put("account", userAccount.getAccount());
/* 64 */       if (0L != this.userAccountService.selectByParaMap(dataMap).longValue()) {
/* 65 */         errors.rejectValue("account", "register.error.dulplicate", new String[] { "账号" }, null);
/*    */       }
/*    */ 
/* 68 */       dataMap.clear();
/*    */     }
/* 70 */     if (null != userAccount.getCertificateNum()) {
/* 71 */       dataMap.put("certificateNum", userAccount.getCertificateNum());
/* 72 */       if (0L != this.userAccountService.selectByParaMap(dataMap).longValue()) {
/* 73 */         errors.rejectValue("certificateNum", "register.error.dulplicate", new String[] { "证件号" }, null);
/*    */       }
/*    */ 
/* 76 */       dataMap.clear();
/*    */     }
/* 78 */     if (null != userAccount.getEmail()) {
/* 79 */       dataMap.put("email", userAccount.getEmail());
/* 80 */       if (0L != this.userAccountService.selectByParaMap(dataMap).longValue()) {
/* 81 */         errors.rejectValue("email", "register.error.dulplicate", new String[] { "邮箱" }, null);
/*    */       }
/*    */ 
/* 84 */       dataMap.clear();
/*    */     }
/*    */ 
/* 87 */     if ((null == userAccount.getArea()) || (userAccount.getArea().equals("")))
/* 88 */       errors.rejectValue("area", "common.error.required", null, null);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.validator.UserAccountValidator
 * JD-Core Version:    0.6.0
 */