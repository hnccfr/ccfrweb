/*     */ package com.hundsun.network.gates.fengshan.web.validator.common;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.biz.domain.UserAgent;
/*     */ import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.UserAccountDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumUserResultErrors;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumUserStatus;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.UserLoginRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.UserServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteUserService;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Component;
/*     */ 
/*     */ @Component
/*     */ public class UserValidator
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private RemoteUserService remoteUserService;
/*     */ 
/*     */   public ServiceResult isPermission(UserAgent userAgent)
/*     */   {
/*  39 */     ServiceResult result = new ServiceResult();
/*  40 */     if ((userAgent == null) || (StringUtil.isEmpty(userAgent.getAccount()))) {
/*  41 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.INTERNAL_ERROR.getValue()));
/*  42 */       result.setErrorInfo(EnumUserResultErrors.USER_LOGIN_FIRST.getInfo());
/*  43 */       return result;
/*     */     }
/*  45 */     UserLoginRequest request = new UserLoginRequest();
/*  46 */     request.setUserAccount(userAgent.getAccount());
/*  47 */     UserServiceResult ur = this.remoteUserService.getUserMsgByAccount(request);
/*  48 */     if (ur.correct()) {
/*  49 */       UserAccountDTO dto = ur.getUserAccountDTO();
/*  50 */       if (dto.getStatus().equals(EnumUserStatus.Unfund.getValue())) {
/*  51 */         result.setErrorNO(Integer.valueOf(EnumUserResultErrors.FUND_ACCOUNT_ACTIVE_ERROR.getValue()));
/*  52 */         result.setErrorInfo(EnumUserResultErrors.FUND_ACCOUNT_ACTIVE_ERROR.getInfo());
/*  53 */         return result;
/*  54 */       }if (dto.getStatus().equals(EnumUserStatus.Forbid.getValue())) {
/*  55 */         result.setErrorNO(Integer.valueOf(EnumUserResultErrors.USER_ACCOUNT_FORBID.getValue()));
/*  56 */         result.setErrorInfo(EnumUserResultErrors.USER_ACCOUNT_FORBID.getInfo());
/*  57 */         return result;
/*  58 */       }if (dto.getStatus().equals(EnumUserStatus.Delete.getValue())) {
/*  59 */         result.setErrorNO(Integer.valueOf(EnumUserResultErrors.USER_ACCOUNT_DELETE.getValue()));
/*  60 */         result.setErrorInfo(EnumUserResultErrors.USER_ACCOUNT_DELETE.getInfo());
/*  61 */         return result;
/*  62 */       }if (dto.getStatus().equals(EnumUserStatus.Nonactivated.getValue())) {
/*  63 */         result.setErrorNO(Integer.valueOf(EnumUserResultErrors.USER_ACCOUNT_TO_DO.getValue()));
/*  64 */         result.setErrorInfo(EnumUserResultErrors.USER_ACCOUNT_TO_DO.getInfo());
/*  65 */         return result;
/*  66 */       }if (dto.getStatus().equals(EnumUserStatus.Normal.getValue())) {
/*  67 */         return result;
/*     */       }
/*  69 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.USER_ACCOUNT_ERROR_ORTHER.getValue()));
/*  70 */       result.setErrorInfo(EnumUserResultErrors.USER_ACCOUNT_ERROR_ORTHER.getInfo());
/*  71 */       return result;
/*     */     }
/*     */ 
/*  74 */     result.setErrorNO(ur.getErrorNO());
/*  75 */     result.setErrorInfo(ur.getErrorInfo());
/*  76 */     return result;
/*     */   }
/*     */ 
/*     */   public ServiceResult isPermission(String userAccount)
/*     */   {
/*  87 */     ServiceResult result = new ServiceResult();
/*  88 */     if (StringUtil.isEmpty(userAccount)) {
/*  89 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.INTERNAL_ERROR.getValue()));
/*  90 */       result.setErrorInfo("对不起，请先登陆！");
/*  91 */       return result;
/*     */     }
/*  93 */     UserLoginRequest request = new UserLoginRequest();
/*  94 */     request.setUserAccount(userAccount);
/*  95 */     UserServiceResult ur = this.remoteUserService.getUserMsgByAccount(request);
/*  96 */     if (ur.correct()) {
/*  97 */       UserAccountDTO dto = ur.getUserAccountDTO();
/*  98 */       if (dto.getStatus().equals(EnumUserStatus.Unfund.getValue())) {
/*  99 */         result.setErrorNO(Integer.valueOf(EnumUserResultErrors.FUND_ACCOUNT_ACTIVE_ERROR.getValue()));
/* 100 */         result.setErrorInfo(EnumUserResultErrors.FUND_ACCOUNT_ACTIVE_ERROR.getInfo());
/* 101 */         return result;
/* 102 */       }if (dto.getStatus().equals(EnumUserStatus.Forbid.getValue())) {
/* 103 */         result.setErrorNO(Integer.valueOf(EnumUserResultErrors.USER_ACCOUNT_FORBID.getValue()));
/* 104 */         result.setErrorInfo(EnumUserResultErrors.USER_ACCOUNT_FORBID.getInfo());
/* 105 */         return result;
/* 106 */       }if (dto.getStatus().equals(EnumUserStatus.Delete.getValue())) {
/* 107 */         result.setErrorNO(Integer.valueOf(EnumUserResultErrors.USER_ACCOUNT_DELETE.getValue()));
/* 108 */         result.setErrorInfo(EnumUserResultErrors.USER_ACCOUNT_DELETE.getInfo());
/* 109 */         return result;
/* 110 */       }if (dto.getStatus().equals(EnumUserStatus.Nonactivated.getValue())) {
/* 111 */         result.setErrorNO(Integer.valueOf(EnumUserResultErrors.USER_ACCOUNT_TO_DO.getValue()));
/* 112 */         result.setErrorInfo(EnumUserResultErrors.USER_ACCOUNT_TO_DO.getInfo());
/* 113 */         return result;
/* 114 */       }if (dto.getStatus().equals(EnumUserStatus.Normal.getValue())) {
/* 115 */         return result;
/*     */       }
/* 117 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.USER_ACCOUNT_ERROR_ORTHER.getValue()));
/* 118 */       result.setErrorInfo(EnumUserResultErrors.USER_ACCOUNT_ERROR_ORTHER.getInfo());
/* 119 */       return result;
/*     */     }
/*     */ 
/* 122 */     result.setErrorNO(ur.getErrorNO());
/* 123 */     result.setErrorInfo(ur.getErrorInfo());
/* 124 */     return result;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.web.validator.common.UserValidator
 * JD-Core Version:    0.6.0
 */