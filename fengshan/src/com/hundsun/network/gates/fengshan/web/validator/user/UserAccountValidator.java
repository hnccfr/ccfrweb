/*     */ package com.hundsun.network.gates.fengshan.web.validator.user;
/*     */ 
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.user.UserAccount;
/*     */ import com.hundsun.network.gates.fengshan.biz.service.user.UserAccountService;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumUserType;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.validation.Errors;
/*     */ import org.springmodules.validation.valang.ValangValidator;
/*     */ 
/*     */ public class UserAccountValidator extends ValangValidator
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private UserAccountService userAccountService;
/*     */ 
/*     */   public void validate(Object obj, Errors errors)
/*     */   {
/*  25 */     super.validate(obj, errors);
/*     */ 
/*  27 */     UserAccount userAccount = (UserAccount)obj;
/*  28 */     if (userAccount.getType().equals(EnumUserType.ENTERPRISE.getValue()))
/*     */     {
/*  30 */       if ((null == userAccount.getFullName()) || (userAccount.getFullName().equals("")))
/*  31 */         errors.rejectValue("fullName", "common.error.required", null, null);
/*  32 */       else if (userAccount.getFullName().length() > 85) {
/*  33 */         errors.rejectValue("fullName", "common.error.maxlength", new String[] { "85" }, null);
/*     */       }
/*     */ 
/*  36 */       if ((null == userAccount.getTaxNum()) || (userAccount.getTaxNum().equals("")))
/*  37 */         errors.rejectValue("taxNum", "common.error.required", null, null);
/*  38 */       else if (userAccount.getTaxNum().length() > 20) {
/*  39 */         errors.rejectValue("taxNum", "common.error.maxlength", new String[] { "20" }, null);
/*     */       }
/*     */ 
/*  42 */       if ((null != userAccount.getScope()) && 
/*  43 */         (userAccount.getScope().length() > 170)) {
/*  44 */         errors.rejectValue("scope", "common.error.maxlength", new String[] { "170" }, null);
/*     */       }
/*     */ 
/*  48 */       if ((null != userAccount.getIntro()) && 
/*  49 */         (userAccount.getIntro().length() > 340)) {
/*  50 */         errors.rejectValue("intro", "common.error.maxlength", new String[] { "340" }, null);
/*     */       }
/*     */ 
/*  54 */       if ((null == userAccount.getPhone()) || (userAccount.getPhone().equals(""))) {
/*  55 */         errors.rejectValue("phone", "common.error.required", null, null);
/*     */       }
/*     */     }
/*     */ 
/*  59 */     if ((null == userAccount.getCity()) || (userAccount.getCity().equals("")))
/*  60 */       errors.rejectValue("area", "common.error.required", null, null);
/*     */   }
/*     */ 
/*     */   public void uniqueValidate(Object obj, Errors errors)
/*     */   {
/*  67 */     UserAccount userAccount = (UserAccount)obj;
/*     */ 
/*  70 */     Map dataMap = new HashMap();
/*  71 */     if (null != userAccount.getAccount()) {
/*  72 */       dataMap.put("account", userAccount.getAccount());
/*  73 */       if (0L != this.userAccountService.selectByParaMap(dataMap).longValue()) {
/*  74 */         errors.rejectValue("account", "register.error.dulplicate", new String[] { "账号" }, null);
/*     */       }
/*     */ 
/*  77 */       dataMap.clear();
/*     */     }
/*  79 */     if (null != userAccount.getCertificateNum()) {
/*  80 */       dataMap.put("certificateNum", userAccount.getCertificateNum());
/*  81 */       if (0L != this.userAccountService.selectByParaMap(dataMap).longValue()) {
/*  82 */         errors.rejectValue("certificateNum", "register.error.dulplicate", new String[] { "证件号" }, null);
/*     */       }
/*     */ 
/*  85 */       dataMap.clear();
/*     */     }
/*  87 */     if (null != userAccount.getEmail()) {
/*  88 */       dataMap.put("email", userAccount.getEmail());
/*  89 */       if (0L != this.userAccountService.selectByParaMap(dataMap).longValue()) {
/*  90 */         errors.rejectValue("email", "register.error.dulplicate", new String[] { "邮箱" }, null);
/*     */       }
/*     */ 
/*  93 */       dataMap.clear();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void editValidate(Object obj, Errors errors) {
/*  98 */     UserAccount userAccount = (UserAccount)obj;
/*  99 */     if ((null == userAccount.getName()) || (userAccount.getName().equals(""))) {
/* 100 */       errors.rejectValue("name", "common.error.required", null, null);
/*     */     }
/* 102 */     if ((null == userAccount.getMobile()) || (userAccount.getMobile().equals(""))) {
/* 103 */       errors.rejectValue("mobile", "common.error.required", null, null);
/*     */     }
/* 105 */     if ((null == userAccount.getArea()) || (userAccount.getArea().equals("")))
/* 106 */       errors.rejectValue("area", "common.error.required", null, null);
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.web.validator.user.UserAccountValidator
 * JD-Core Version:    0.6.0
 */