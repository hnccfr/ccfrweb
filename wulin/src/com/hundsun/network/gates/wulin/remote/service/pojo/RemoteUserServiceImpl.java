/*     */ package com.hundsun.network.gates.wulin.remote.service.pojo;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.biz.enums.EnumPasswordType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumHasEnabled;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumUserCreditLogRanktype;
/*     */ import com.hundsun.network.gates.luosi.common.enums.UserCreditType;
/*     */ import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
/*     */ import com.hundsun.network.gates.luosi.common.utils.DateUtil;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.UserCreditDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.UserLevelDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumCancleAccount;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumTradeOrderResultErrors;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumUserResultErrors;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.UserActivateRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.UserCreditRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.UserFundRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.UserLevelRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.UserLoginRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.UserRegisterRequset;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.UserResetPasswordRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.UserUpgradeAuditRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.CancleAccountResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.UserCreditServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.UserLevelServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.UserResetPWDResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.UserServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteUserService;
/*     */ import com.hundsun.network.gates.wulin.biz.dao.order.TradeOrderDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.baseset.UserCredit;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.baseset.UserLevel;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.user.UserAccount;
/*     */ import com.hundsun.network.gates.wulin.biz.service.BaseService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.baseset.UserCreditService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.baseset.UserLevelService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.user.UserService;
/*     */ import com.hundsun.network.gates.wulin.common.utils.ConvertUtils;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.beanutils.BeanUtils;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ import org.springframework.transaction.TransactionStatus;
/*     */ import org.springframework.transaction.support.TransactionCallback;
/*     */ import org.springframework.transaction.support.TransactionTemplate;
/*     */ 
/*     */ @Service("remoteUserService")
/*     */ public class RemoteUserServiceImpl extends BaseService
/*     */   implements RemoteUserService
/*     */ {
/*  55 */   protected final Log logger = LogFactory.getLog(getClass());
/*     */ 
/*     */   @Autowired
/*     */   private UserService userService;
/*     */ 
/*     */   @Autowired
/*     */   private UserLevelService userLevelService;
/*     */ 
/*     */   @Autowired
/*     */   private UserCreditService userCreditService;
/*     */ 
/*     */   @Autowired
/*     */   private TradeOrderDAO tradeOrderDAO;
/*     */ 
/*  74 */   public UserServiceResult login(UserLoginRequest request) { UserServiceResult result = new UserServiceResult();
/*  75 */     this.log.debug("RemoteUserService login");
/*  76 */     if (null == request) {
/*  77 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.PARAMETER_ERROR.getValue()));
/*  78 */       result.setErrorInfo(EnumUserResultErrors.PARAMETER_ERROR.getInfo());
/*  79 */       this.log.error("login fail, " + result.getErrorInfo());
/*  80 */       return result;
/*     */     }
/*  82 */     UserAccount account = new UserAccount();
/*  83 */     account.setAccount(request.getUserAccount());
/*  84 */     account.setPassword(request.getPassword());
/*  85 */     result = this.userService.login(account, request.getLoginIp());
/*  86 */     return result;
/*     */   }
/*     */ 
/*     */   public UserServiceResult register(UserRegisterRequset request)
/*     */   {
/*  91 */     this.log.debug("RemoteUserService register");
/*  92 */     UserServiceResult result = new UserServiceResult();
/*  93 */     if (null == request) {
/*  94 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.PARAMETER_ERROR.getValue()));
/*  95 */       result.setErrorInfo(EnumUserResultErrors.PARAMETER_ERROR.getInfo());
/*  96 */       this.log.error("login fail, " + EnumUserResultErrors.PARAMETER_ERROR.getInfo());
/*  97 */       return result;
/*     */     }
/*  99 */     UserAccount userAccount = ConvertUtils.convertRegRequest2UAccount(request);
/* 100 */     result = this.userService.register(userAccount);
/* 101 */     return result;
/*     */   }
/*     */ 
/*     */   public ServiceResult activate(UserActivateRequest request)
/*     */   {
/* 106 */     this.log.debug("RemoteUserService activate");
/* 107 */     if (null == request) {
/* 108 */       ServiceResult result = new ServiceResult();
/* 109 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.PARAMETER_ERROR.getValue()));
/* 110 */       result.setErrorInfo(EnumUserResultErrors.PARAMETER_ERROR.getInfo());
/* 111 */       this.log.error("login fail, " + result.getErrorInfo());
/* 112 */       return result;
/*     */     }
/* 114 */     return this.userService.activate(request.getAccount(), request.getActiveCode());
/*     */   }
/*     */ 
/*     */   public ServiceResult resetPassword(UserResetPasswordRequest request)
/*     */   {
/* 119 */     if (null == request) {
/* 120 */       ServiceResult result = new ServiceResult();
/* 121 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.PARAMETER_ERROR.getValue()));
/* 122 */       result.setErrorInfo(EnumUserResultErrors.PARAMETER_ERROR.getInfo());
/* 123 */       this.log.error("login fail, " + result.getErrorInfo());
/* 124 */       return result;
/*     */     }
/* 126 */     return this.userService.resetPassword(request.getAccount(), request.getOldPassword(), request.getNewPassword());
/*     */   }
/*     */ 
/*     */   public UserResetPWDResult updatePassword(UserResetPasswordRequest request)
/*     */   {
/* 132 */     UserResetPWDResult result = new UserResetPWDResult();
/* 133 */     if ((null == request) || (StringUtil.isEmpty(request.getAccount()))) {
/* 134 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.PARAMETER_ERROR.getValue()));
/* 135 */       result.setErrorInfo(EnumUserResultErrors.PARAMETER_ERROR.getInfo());
/* 136 */       this.log.error("updatePassword fail, " + result.getErrorInfo());
/* 137 */       return result;
/*     */     }
/*     */ 
/* 140 */     if ((null == request.getPasswordType()) || ((!EnumPasswordType.SYSTEM.getValue().equals(request.getPasswordType())) && (!EnumPasswordType.FUND.getValue().equals(request.getPasswordType()))))
/*     */     {
/* 143 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.USER_PASSWORD_TYPE_NOT_CLEAR.getValue()));
/* 144 */       result.setErrorInfo(EnumUserResultErrors.USER_PASSWORD_TYPE_NOT_CLEAR.getInfo());
/* 145 */       this.log.error("updatePassword fail, " + result.getErrorInfo());
/* 146 */       return result;
/*     */     }
/* 148 */     return this.userService.updatePassword(request);
/*     */   }
/*     */ 
/*     */   public UserLevelServiceResult selectUserLevelByAccount(UserLevelRequest request)
/*     */   {
/* 156 */     UserLevelServiceResult result = new UserLevelServiceResult();
/* 157 */     String userAccount = request.getUserAccount();
/* 158 */     if (StringUtil.isEmpty(userAccount)) {
/* 159 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.PARAMETER_ERROR.getValue()));
/* 160 */       result.setErrorInfo(EnumUserResultErrors.PARAMETER_ERROR.getInfo());
/* 161 */       return result;
/*     */     }
/* 163 */     UserLevel userLevel = this.userLevelService.selectByAccount(userAccount);
/* 164 */     UserLevelDTO userLevelDTO = new UserLevelDTO();
/*     */     try {
/* 166 */       BeanUtils.copyProperties(userLevelDTO, userLevel);
/*     */     } catch (IllegalAccessException e) {
/* 168 */       this.logger.error("RemoteUserLevelServiceImpl error:", e);
/*     */     } catch (InvocationTargetException e) {
/* 170 */       this.logger.error("RemoteUserLevelServiceImpl error:", e);
/*     */     }
/* 172 */     result.setUserLevelDTO(userLevelDTO);
/* 173 */     return result;
/*     */   }
/*     */ 
/*     */   public UserLevelServiceResult insertUserLevel(UserLevelRequest request)
/*     */   {
/* 183 */     UserLevelServiceResult result = new UserLevelServiceResult();
/* 184 */     String userAccount = request.getUserAccount();
/* 185 */     UserLevel userLevel = this.userLevelService.selectByAccount(userAccount);
/*     */     Long aa;
/* 186 */     if (userLevel == null)
/*     */     {
/* 188 */       aa = this.userLevelService.insertUserLevel(userAccount);
/*     */     } else {
/* 190 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.USER_EXISTS.getValue()));
/* 191 */       result.setErrorInfo(EnumUserResultErrors.USER_EXISTS.getInfo());
/*     */     }
/* 193 */     return result;
/*     */   }
/*     */ 
/*     */   public UserLevelServiceResult updateUserLevel(UserLevelRequest request)
/*     */   {
/* 203 */     UserLevelServiceResult result = new UserLevelServiceResult();
/* 204 */     final String userAccount = request.getUserAccount();
/* 205 */     final String orderNo = request.getOrderNo();
/* 206 */     final String projectCode = request.getProjectCode();
/* 207 */     final String operateCode = request.getOperateCode();
/* 208 */     final String operator = request.getOperator();
/* 209 */     final int integral = request.getIntegral().intValue();
/* 210 */     UserLevel userLevel = this.userLevelService.selectByAccount(userAccount);
/* 211 */     if (userLevel == null) {
/* 212 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.USER_NOT_EXISTS.getValue()));
/* 213 */       result.setErrorInfo(EnumUserResultErrors.USER_NOT_EXISTS.getInfo());
/* 214 */       return result;
/*     */     }
/* 216 */     result = (UserLevelServiceResult)this.transactionTemplate.execute(new TransactionCallback() {
/*     */       public UserLevelServiceResult doInTransaction(TransactionStatus status) {
/* 218 */         UserLevelServiceResult result = new UserLevelServiceResult();
/*     */         try
/*     */         {
/* 221 */           RemoteUserServiceImpl.this.userLevelService.updateUserLevel(userAccount, integral);
/*     */ 
/* 223 */           RemoteUserServiceImpl.this.userLevelService.insertUserIntegralLog(userAccount, orderNo, projectCode, operateCode, Integer.valueOf(integral), operator);
/*     */         }
/*     */         catch (Exception e) {
/* 226 */           RemoteUserServiceImpl.this.logger.error("RemoteUserServiceImpl updateUserLevel error:", e);
/* 227 */           status.setRollbackOnly();
/* 228 */           result.setErrorNO(Integer.valueOf(EnumUserResultErrors.INTERNAL_ERROR.getValue()));
/* 229 */           result.setErrorInfo(EnumUserResultErrors.INTERNAL_ERROR.getInfo());
/* 230 */           return result;
/*     */         }
/* 232 */         return result;
/*     */       }
/*     */     });
/* 235 */     return result;
/*     */   }
/*     */ 
/*     */   public ServiceResult userUpgradeAudit(UserUpgradeAuditRequest request)
/*     */   {
/* 240 */     return this.userService.userUpgradeAudit(request);
/*     */   }
/*     */ 
/*     */   public UserCreditServiceResult addInsertUserCredit(UserCreditRequest request)
/*     */   {
/* 250 */     UserCreditServiceResult result = new UserCreditServiceResult();
/* 251 */     String userAccount = request.getUserAccount();
/* 252 */     String operator = request.getOperator();
/* 253 */     if ((StringUtil.isEmpty(userAccount)) || (StringUtil.isEmpty(operator))) {
/* 254 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.USER_NOT_EXISTS.getValue()));
/* 255 */       result.setErrorInfo(EnumUserResultErrors.USER_NOT_EXISTS.getInfo());
/* 256 */       return result;
/*     */     }
/* 258 */     Long userCreditId = this.userCreditService.addInsertUserCredit(userAccount);
/* 259 */     if (userCreditId == null) {
/* 260 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.DATABASE_OPERATE_ERROR.getValue()));
/* 261 */       result.setErrorInfo(EnumUserResultErrors.DATABASE_OPERATE_ERROR.getInfo());
/*     */     }
/* 263 */     return result;
/*     */   }
/*     */ 
/*     */   public UserCreditServiceResult updateUserCredit(UserCreditRequest request)
/*     */   {
/* 278 */     UserCreditServiceResult result = new UserCreditServiceResult();
/* 279 */     final String userAccount = request.getUserAccount();
/* 280 */     final String orderNo = request.getOrderNo();
/* 281 */     final String projectListingCode = request.getProjectListingCode();
/* 282 */     final String userCreditType = request.getUserCreditType();
/* 283 */     final String operator = request.getOperator();
/* 284 */     final Integer integral = request.getIntegral();
/* 285 */     final Integer serviceAttitude = request.getServiceAttitude();
/* 286 */     final Integer logisticsSpeed = request.getLogisticsSpeed();
/* 287 */     final String remark = request.getRemark();
/*     */ 
/* 289 */     if (UserCreditType.SET_BUYER_CREDIT.getValue().equals(userCreditType)) {
/* 290 */       if ((StringUtil.isEmpty(userAccount)) || (StringUtil.isEmpty(userCreditType)) || (StringUtil.isEmpty(operator)) || (integral == null))
/*     */       {
/* 292 */         result.setErrorNO(Integer.valueOf(EnumUserResultErrors.USER_NOT_EXISTS.getValue()));
/* 293 */         result.setErrorInfo(EnumUserResultErrors.USER_NOT_EXISTS.getInfo());
/* 294 */         return result;
/*     */       }
/* 296 */       result = (UserCreditServiceResult)this.transactionTemplate.execute(new TransactionCallback()
/*     */       {
/*     */         public UserCreditServiceResult doInTransaction(TransactionStatus status) {
/* 299 */           UserCreditServiceResult result = new UserCreditServiceResult();
/*     */           try
/*     */           {
/* 303 */             int count = RemoteUserServiceImpl.this.userCreditService.updateUserCredit(userAccount, userCreditType, integral, null, null, operator);
/*     */ 
/* 306 */             String memo = DateUtil.getDateFormat(new Date(), null) + "操作人:" + operator + " 评价用户" + userAccount + "卖家信用" + integral.intValue();
/*     */ 
/* 309 */             RemoteUserServiceImpl.this.userCreditService.addUserCreditLog(userAccount, orderNo, projectListingCode, Short.valueOf(EnumUserCreditLogRanktype.SET_SELL.getValue()), integral, null, null, memo, operator, remark);
/*     */ 
/* 313 */             Map param = new HashMap();
/* 314 */             param.put("hasSellerRank", EnumHasEnabled.NEED.getValue());
/* 315 */             param.put("operator", operator);
/*     */ 
/* 317 */             if (RemoteUserServiceImpl.this.tradeOrderDAO.updateParamByOrderNo(param, orderNo) <= 0) {
/* 318 */               status.setRollbackOnly();
/* 319 */               result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.UPDATE_ORDER_ERROR.getValue()));
/*     */ 
/* 321 */               result.setErrorInfo(EnumTradeOrderResultErrors.UPDATE_ORDER_ERROR.getInfo());
/*     */ 
/* 323 */               return result;
/*     */             }
/*     */           }
/*     */           catch (Exception e) {
/* 327 */             RemoteUserServiceImpl.this.logger.error("TradeOrderServiceImpl initAddOrder error:", e);
/* 328 */             status.setRollbackOnly();
/* 329 */             result.setErrorNO(Integer.valueOf(EnumUserResultErrors.INTERNAL_ERROR.getValue()));
/* 330 */             result.setErrorInfo(EnumUserResultErrors.INTERNAL_ERROR.getInfo());
/* 331 */             return result;
/*     */           }
/* 333 */           return result;
/*     */         } } );
/* 336 */     } else if (UserCreditType.SET_SELLER_CREDIT.getValue().equals(userCreditType))
/*     */     {
/* 338 */       if ((StringUtil.isEmpty(userAccount)) || (StringUtil.isEmpty(userCreditType)) || (StringUtil.isEmpty(operator)) || (integral == null))
/*     */       {
/* 340 */         result.setErrorNO(Integer.valueOf(EnumUserResultErrors.USER_NOT_EXISTS.getValue()));
/* 341 */         result.setErrorInfo(EnumUserResultErrors.USER_NOT_EXISTS.getInfo());
/* 342 */         return result;
/*     */       }
/*     */ 
/* 345 */       result = (UserCreditServiceResult)this.transactionTemplate.execute(new TransactionCallback()
/*     */       {
/*     */         public UserCreditServiceResult doInTransaction(TransactionStatus status) {
/* 348 */           UserCreditServiceResult result = new UserCreditServiceResult();
/*     */           try
/*     */           {
/* 351 */             RemoteUserServiceImpl.this.userCreditService.updateUserCredit(userAccount, userCreditType, integral, serviceAttitude, logisticsSpeed, operator);
/*     */ 
/* 354 */             String memo = DateUtil.getDateFormat(new Date(), null) + "操作人:" + operator + " 评价用户" + userAccount + "买家信用" + integral.intValue();
/*     */ 
/* 357 */             RemoteUserServiceImpl.this.userCreditService.addUserCreditLog(userAccount, orderNo, projectListingCode, Short.valueOf(EnumUserCreditLogRanktype.SET_BUY.getValue()), integral, serviceAttitude, logisticsSpeed, memo, operator, remark);
/*     */ 
/* 360 */             Map param = new HashMap();
/* 361 */             param.put("hasBuyerRank", EnumHasEnabled.NEED.getValue());
/* 362 */             param.put("operator", operator);
/*     */ 
/* 364 */             if (RemoteUserServiceImpl.this.tradeOrderDAO.updateParamByOrderNo(param, orderNo) <= 0) {
/* 365 */               status.setRollbackOnly();
/* 366 */               result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.UPDATE_ORDER_ERROR.getValue()));
/*     */ 
/* 368 */               result.setErrorInfo(EnumTradeOrderResultErrors.UPDATE_ORDER_ERROR.getInfo());
/*     */ 
/* 370 */               return result;
/*     */             }
/*     */           } catch (Exception e) {
/* 373 */             RemoteUserServiceImpl.this.logger.error("TradeOrderServiceImpl initAddOrder error:", e);
/* 374 */             status.setRollbackOnly();
/* 375 */             result.setErrorNO(Integer.valueOf(EnumUserResultErrors.INTERNAL_ERROR.getValue()));
/* 376 */             result.setErrorInfo(EnumUserResultErrors.INTERNAL_ERROR.getInfo());
/* 377 */             return result;
/*     */           }
/* 379 */           return result;
/*     */         } } );
/*     */     }
/* 383 */     return result;
/*     */   }
/*     */ 
/*     */   public UserCreditServiceResult selectByUserAccount(UserCreditRequest request)
/*     */   {
/* 393 */     UserCreditServiceResult result = new UserCreditServiceResult();
/* 394 */     String userAccount = request.getUserAccount();
/* 395 */     if (StringUtil.isEmpty(userAccount)) {
/* 396 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.USER_NOT_EXISTS.getValue()));
/* 397 */       result.setErrorInfo(EnumUserResultErrors.USER_NOT_EXISTS.getInfo());
/* 398 */       return result;
/*     */     }
/* 400 */     UserCredit userCredit = this.userCreditService.selectByUserAccount(userAccount);
/* 401 */     UserCreditDTO dto = new UserCreditDTO();
/*     */     try {
/* 403 */       BeanUtils.copyProperties(dto, userCredit);
/* 404 */       result.setUserCreditDTO(dto);
/*     */     } catch (IllegalAccessException e) {
/* 406 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.DATABASE_OPERATE_ERROR.getValue()));
/* 407 */       result.setErrorInfo(EnumUserResultErrors.DATABASE_OPERATE_ERROR.getInfo());
/* 408 */       this.logger.error("RemoteUserServiceImpl selectByUserAccount:", e);
/*     */     } catch (InvocationTargetException e) {
/* 410 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.DATABASE_OPERATE_ERROR.getValue()));
/* 411 */       result.setErrorInfo(EnumUserResultErrors.DATABASE_OPERATE_ERROR.getInfo());
/* 412 */       this.logger.error("RemoteUserServiceImpl selectByUserAccount:", e);
/*     */     }
/* 414 */     return result;
/*     */   }
/*     */ 
/*     */   @Deprecated
/*     */   public UserCreditServiceResult deductUserCredit(UserCreditRequest request)
/*     */   {
/* 428 */     UserCreditServiceResult result = new UserCreditServiceResult();
/* 429 */     final String userAccount = request.getUserAccount();
/* 430 */     final String orderNo = request.getOrderNo();
/* 431 */     final String projectListingCode = request.getProjectListingCode();
/* 432 */     final String userCreditType = request.getUserCreditType();
/* 433 */     final String operator = request.getOperator();
/* 434 */     final Integer integral = request.getIntegral();
/* 435 */     if ((StringUtil.isEmpty(userAccount)) || (StringUtil.isEmpty(userCreditType)) || (StringUtil.isEmpty(operator)) || (integral == null))
/*     */     {
/* 437 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.USER_NOT_EXISTS.getValue()));
/* 438 */       result.setErrorInfo(EnumUserResultErrors.USER_NOT_EXISTS.getInfo());
/* 439 */       return result;
/*     */     }
/*     */ 
/* 442 */     result = (UserCreditServiceResult)this.transactionTemplate.execute(new TransactionCallback() {
/*     */       public UserCreditServiceResult doInTransaction(TransactionStatus status) {
/* 444 */         UserCreditServiceResult result = new UserCreditServiceResult();
/*     */         try
/*     */         {
/* 447 */           RemoteUserServiceImpl.this.userCreditService.deductUserCredit(userAccount, userCreditType, integral, operator);
/*     */ 
/* 450 */           Short rankType = Short.valueOf(EnumUserCreditLogRanktype.SET_DEDUCT.getValue());
/* 451 */           String memo = DateUtil.getDateFormat(new Date(), null) + "操作人:" + operator + " 扣除用户" + userAccount + "信用" + integral.intValue();
/*     */ 
/* 453 */           RemoteUserServiceImpl.this.userCreditService.addUserCreditLog(userAccount, orderNo, projectListingCode, rankType, integral, null, null, memo, operator, "投诉工单扣除客户信用");
/*     */         }
/*     */         catch (Exception e) {
/* 456 */           RemoteUserServiceImpl.this.logger.error("TradeOrderServiceImpl deductUserCredit error:", e);
/* 457 */           status.setRollbackOnly();
/* 458 */           result.setErrorNO(Integer.valueOf(EnumUserResultErrors.INTERNAL_ERROR.getValue()));
/* 459 */           result.setErrorInfo(EnumUserResultErrors.INTERNAL_ERROR.getInfo());
/* 460 */           return result;
/*     */         }
/* 462 */         return result;
/*     */       }
/*     */     });
/* 465 */     return result;
/*     */   }
/*     */ 
/*     */   public ServiceResult resetFundPwd(UserResetPasswordRequest request)
/*     */   {
/* 470 */     ServiceResult result = new ServiceResult();
/* 471 */     if (null == request) {
/* 472 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.PARAMETER_ERROR.getValue()));
/* 473 */       result.setErrorInfo(EnumUserResultErrors.PARAMETER_ERROR.getInfo());
/* 474 */       this.log.error("resetFundPwd error, cause by:" + result.getErrorInfo());
/* 475 */       return result;
/*     */     }
/* 477 */     if (request.getOldPassword().equals(request.getNewPassword())) {
/* 478 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.USER_FUNDPWD_RESET_SAME.getValue()));
/* 479 */       result.setErrorInfo(EnumUserResultErrors.USER_FUNDPWD_RESET_SAME.getInfo());
/* 480 */       return result;
/*     */     }
/*     */     try {
/* 483 */       result = this.userService.resetFundPwd(request);
/*     */     } catch (Exception e) {
/* 485 */       this.log.error("resetFundPwd error, cause by:" + e.getMessage());
/* 486 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.INTERNAL_ERROR.getValue()));
/* 487 */       result.setErrorInfo(EnumUserResultErrors.INTERNAL_ERROR.getInfo());
/*     */     }
/* 489 */     return result;
/*     */   }
/*     */ 
/*     */   public ServiceResult fundActivate(UserActivateRequest request)
/*     */   {
/* 494 */     ServiceResult result = new ServiceResult();
/* 495 */     if ((null == request) || (StringUtil.isEmpty(request.getFundAccount()))) {
/* 496 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.PARAMETER_ERROR.getValue()));
/* 497 */       result.setErrorInfo(EnumUserResultErrors.PARAMETER_ERROR.getInfo());
/* 498 */       this.log.error("com.hundsun.network.gates.wulin.remote.service.pojo.RemoteUserServiceImpl fundActivate error, cause by:" + result.getErrorInfo());
/*     */ 
/* 501 */       return result;
/*     */     }
/*     */     try {
/* 504 */       result = this.userService.fundActivate(request);
/*     */     } catch (Exception e) {
/* 506 */       this.log.error("", e);
/* 507 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.INTERNAL_ERROR.getValue()));
/* 508 */       result.setErrorInfo(EnumUserResultErrors.INTERNAL_ERROR.getInfo());
/*     */     }
/* 510 */     return result;
/*     */   }
/*     */ 
/*     */   public UserServiceResult checkFundActivate(UserActivateRequest request)
/*     */   {
/* 515 */     UserServiceResult result = new UserServiceResult();
/* 516 */     if ((null == request) || (StringUtil.isEmpty(request.getFundAccount()))) {
/* 517 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.PARAMETER_ERROR.getValue()));
/* 518 */       result.setErrorInfo(EnumUserResultErrors.PARAMETER_ERROR.getInfo());
/* 519 */       this.log.error("com.hundsun.network.gates.wulin.remote.service.pojo.RemoteUserServiceImpl checkFundActivate error, cause by:" + result.getErrorInfo());
/*     */ 
/* 522 */       return result;
/*     */     }
/*     */     try {
/* 525 */       result = this.userService.checkFundActivate(request);
/*     */     } catch (Exception e) {
/* 527 */       this.log.error("", e);
/* 528 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.INTERNAL_ERROR.getValue()));
/* 529 */       result.setErrorInfo(EnumUserResultErrors.INTERNAL_ERROR.getInfo());
/*     */     }
/* 531 */     return result;
/*     */   }
/*     */ 
/*     */   public ServiceResult checkFundOut(UserFundRequest request)
/*     */   {
/* 540 */     ServiceResult result = new ServiceResult();
/* 541 */     if ((null == request) || (StringUtil.isEmpty(request.getFundAccount()))) {
/* 542 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.PARAMETER_ERROR.getValue()));
/* 543 */       result.setErrorInfo(EnumUserResultErrors.PARAMETER_ERROR.getInfo());
/* 544 */       this.log.error("com.hundsun.network.gates.wulin.remote.service.pojo.RemoteUserServiceImpl checkFundOut error, cause by:" + result.getErrorInfo());
/*     */ 
/* 547 */       return result;
/*     */     }
/*     */     try {
/* 550 */       result = this.userService.checkFundOut(request.getFundAccount());
/*     */     } catch (Exception e) {
/* 552 */       this.log.error("", e);
/* 553 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.INTERNAL_ERROR.getValue()));
/* 554 */       result.setErrorInfo(EnumUserResultErrors.INTERNAL_ERROR.getInfo());
/*     */     }
/* 556 */     return result;
/*     */   }
/*     */ 
/*     */   public UserServiceResult getUserMsgByAccount(UserLoginRequest request)
/*     */   {
/* 563 */     UserServiceResult result = new UserServiceResult();
/* 564 */     if ((null == request) || ((StringUtil.isEmpty(request.getUserAccount())) && (StringUtil.isEmpty(request.getFundAccount()))))
/*     */     {
/* 567 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.PARAMETER_ERROR.getValue()));
/* 568 */       result.setErrorInfo(EnumUserResultErrors.PARAMETER_ERROR.getInfo());
/* 569 */       this.log.error("com.hundsun.network.gates.wulin.remote.service.pojo.RemoteUserServiceImpl getUserMsgByAccount error, cause by:" + result.getErrorInfo());
/*     */ 
/* 572 */       return result;
/*     */     }
/*     */     try {
/* 575 */       result = this.userService.getUserMsgByAccount(request);
/*     */     } catch (Exception e) {
/* 577 */       this.log.error("", e);
/* 578 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.INTERNAL_ERROR.getValue()));
/* 579 */       result.setErrorInfo(EnumUserResultErrors.INTERNAL_ERROR.getInfo());
/*     */     }
/* 581 */     return result;
/*     */   }
/*     */ 
/*     */   public CancleAccountResult applyCancleAccount(UserLoginRequest request)
/*     */   {
/* 589 */     CancleAccountResult result = new CancleAccountResult();
/* 590 */     if ((null == request) || (null == request.getUserAccount())) {
/* 591 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.PARAMETER_ERROR.getValue()));
/* 592 */       result.setErrorInfo(EnumUserResultErrors.PARAMETER_ERROR.getInfo());
/* 593 */       result.setResult(EnumCancleAccount.CANCLE_ERROR.getValue());
/* 594 */       return result;
/*     */     }
/* 596 */     result = this.userService.deleteUserValidate(request.getUserAccount());
/* 597 */     return result;
/*     */   }
/*     */ 
/*     */   public CancleAccountResult cancleAccount(UserLoginRequest request)
/*     */   {
/* 605 */     CancleAccountResult result = new CancleAccountResult();
/* 606 */     if ((null == request) || (null == request.getUserAccount())) {
/* 607 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.PARAMETER_ERROR.getValue()));
/* 608 */       result.setErrorInfo(EnumUserResultErrors.PARAMETER_ERROR.getInfo());
/* 609 */       result.setResult(EnumCancleAccount.CANCLE_ERROR.getValue());
/* 610 */       return result;
/*     */     }
/* 612 */     result = this.userService.cancleAccount(request.getUserAccount());
/* 613 */     return result;
/*     */   }
/*     */ 
/*     */   public UserServiceResult specialRegister(UserRegisterRequset request)
/*     */   {
/* 618 */     this.log.debug("RemoteUserService specialRegister");
/* 619 */     UserServiceResult result = new UserServiceResult();
/* 620 */     if (null == request) {
/* 621 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.PARAMETER_ERROR.getValue()));
/* 622 */       result.setErrorInfo(EnumUserResultErrors.PARAMETER_ERROR.getInfo());
/* 623 */       this.log.error("login fail, " + EnumUserResultErrors.PARAMETER_ERROR.getInfo());
/* 624 */       return result;
/*     */     }
/* 626 */     UserAccount userAccount = ConvertUtils.convertRegRequest2UAccount(request);
/* 627 */     result = this.userService.specialRegister(userAccount);
/* 628 */     return result;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.remote.service.pojo.RemoteUserServiceImpl
 * JD-Core Version:    0.6.0
 */