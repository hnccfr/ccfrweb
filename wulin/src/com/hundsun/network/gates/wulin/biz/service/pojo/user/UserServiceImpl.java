/*     */ package com.hundsun.network.gates.wulin.biz.service.pojo.user;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.biz.enums.EnumPasswordType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumActiveStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumAuditRes;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumCheckCommonNodes;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumSystemDictKey;
/*     */ import com.hundsun.network.gates.luosi.common.password.PasswordValidator;
/*     */ import com.hundsun.network.gates.luosi.common.password.impl.PasswordValidatorImpl;
/*     */ import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.UserAccountDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumCancleAccount;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumUserResultErrors;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumUserStatus;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.UserActivateRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.UserLoginRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.UserResetPasswordRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.UserUpgradeAuditRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.CancleAccountResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.UserResetPWDResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.UserServiceResult;
/*     */ import com.hundsun.network.gates.wulin.biz.dao.order.TradeOrderDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.dao.trade.TradeWishOrderDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.dao.user.UserAccountDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.dao.user.UserRoleDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.dao.user.UserRoleRelationshipDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.dao.user.UserUpgradeAuditDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.baseset.SystemDict;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.baseset.SystemUserCheck;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.user.UserAccount;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.user.UserRole;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.user.UserRoleRelationship;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.user.UserUpgradeAudit;
/*     */ import com.hundsun.network.gates.wulin.biz.service.BaseService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.baseset.SystemDictService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.baseset.SystemUserCheckService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.baseset.UserCreditService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.baseset.UserLevelService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.user.UserService;
/*     */ import com.hundsun.network.gates.wulin.common.utils.ConvertUtils;
/*     */ import com.hundsun.network.gates.wulin.common.utils.PasswordGenerator;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.beans.factory.annotation.Value;
/*     */ import org.springframework.stereotype.Repository;
/*     */ import org.springframework.transaction.TransactionStatus;
/*     */ import org.springframework.transaction.support.TransactionCallback;
/*     */ import org.springframework.transaction.support.TransactionTemplate;
/*     */ 
/*     */ @Repository("userService")
/*     */ public class UserServiceImpl extends BaseService
/*     */   implements UserService
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private UserAccountDAO userAccountDAO;
/*     */ 
/*     */   @Autowired
/*     */   private PasswordValidator passwordValidator;
/*     */ 
/*     */   @Autowired
/*     */   private UserRoleDAO userRoleDAO;
/*     */ 
/*     */   @Autowired
/*     */   private UserRoleRelationshipDAO userRoleRelationshipDAO;
/*     */ 
/*     */   @Autowired
/*     */   private UserLevelService userLevelService;
/*     */ 
/*     */   @Autowired
/*     */   private UserUpgradeAuditDAO userUpgradeAuditDAO;
/*     */ 
/*     */   @Autowired
/*     */   private SystemDictService SystemDictService;
/*     */ 
/*     */   @Autowired
/*     */   private SystemUserCheckService systemUserCheckService;
/*     */ 
/*     */   @Autowired
/*     */   private UserCreditService userCreditService;
/*     */ 
/*     */   @Value("${user.role.common}")
/*     */   private String BASE_ROLE;
/*     */ 
/*     */   @Autowired
/*     */   private PasswordValidatorImpl passwordValidatorImpl;
/*     */ 
/*     */   @Autowired
/*     */   private TradeOrderDAO tradeOrderDAO;
/*     */ 
/*     */   @Autowired
/*     */   private TradeWishOrderDAO tradeWishOrderDAO;
/*     */ 
/*     */   public UserServiceResult login(UserAccount account, String loginIp)
/*     */   {
/*  86 */     UserServiceResult result = new UserServiceResult();
/*     */     try {
/*  88 */       if ((null == account) || (StringUtil.isEmpty(account.getAccount())) || (StringUtil.isEmpty(loginIp)))
/*     */       {
/*  90 */         result.setErrorNO(Integer.valueOf(EnumUserResultErrors.PARAMETER_ERROR.getValue()));
/*  91 */         result.setErrorInfo(EnumUserResultErrors.PARAMETER_ERROR.getInfo());
/*  92 */         this.log.error("login fail, " + result.getErrorInfo());
/*  93 */         return result;
/*     */       }
/*  95 */       UserAccount userAccount = this.userAccountDAO.queryByAccount(account);
/*  96 */       if (null == userAccount) {
/*  97 */         result.setErrorNO(Integer.valueOf(EnumUserResultErrors.USER_LOGIN_ACCOUNT_ERROR.getValue()));
/*  98 */         result.setErrorInfo(EnumUserResultErrors.USER_LOGIN_ACCOUNT_ERROR.getInfo());
/*  99 */         this.log.debug("user login fail, " + result.getErrorInfo());
/* 100 */         return result;
/*     */       }
/* 102 */       if (!this.passwordValidator.validate(userAccount.getPassword(), account.getPassword())) {
/* 103 */         result.setErrorNO(Integer.valueOf(EnumUserResultErrors.USER_LOGIN_PASSWORD_ERROR.getValue()));
/* 104 */         result.setErrorInfo(EnumUserResultErrors.USER_LOGIN_PASSWORD_ERROR.getInfo());
/* 105 */         this.log.debug("user login fail, " + result.getErrorInfo());
/* 106 */         return result;
/*     */       }
/* 108 */       if ((!EnumUserStatus.Normal.getValue().equals(userAccount.getStatus())) && (!EnumUserStatus.Unfund.getValue().equals(userAccount.getStatus())))
/*     */       {
/* 110 */         result.setErrorNO(Integer.valueOf(EnumUserResultErrors.USER_LOGIN_STATUS_ERROR.getValue()));
/* 111 */         result.setErrorInfo(EnumUserResultErrors.USER_LOGIN_STATUS_ERROR.getInfo());
/* 112 */         this.log.debug("user login fail, status is not normal " + result.getErrorInfo());
/* 113 */         return result;
/*     */       }
/*     */ 
/* 116 */       result.setUserAccountDTO(ConvertUtils.convert(userAccount));
/* 117 */       UserAccount updateUserAccount = new UserAccount();
/* 118 */       updateUserAccount.setAccount(userAccount.getAccount());
/* 119 */       updateUserAccount.setLastLoginIp(loginIp);
/* 120 */       updateUserAccount.setLastLoginTime(new Date());
/* 121 */       this.userAccountDAO.updateUserAccountByAccount(updateUserAccount);
/*     */     } catch (Exception e) {
/* 123 */       this.log.error("login error,", e);
/* 124 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.INTERNAL_ERROR.getValue()));
/* 125 */       result.setErrorInfo(EnumUserResultErrors.INTERNAL_ERROR.getInfo());
/* 126 */       return result;
/*     */     }
/* 128 */     return result;
/*     */   }
/*     */ 
/*     */   public UserServiceResult register(UserAccount userAccount)
/*     */   {
/* 134 */     UserServiceResult result = new UserServiceResult();
/* 135 */     if (null == userAccount) {
/* 136 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.PARAMETER_ERROR.getValue()));
/* 137 */       result.setErrorInfo(EnumUserResultErrors.PARAMETER_ERROR.getInfo());
/* 138 */       this.log.error("register fail, " + result.getErrorInfo());
/* 139 */       return result;
/*     */     }
/* 141 */     userAccount.setPassword(this.passwordValidator.digest(userAccount.getPassword()));
/* 142 */     userAccount.setFundPassword(this.passwordValidator.digest(userAccount.getFundPassword()));
/* 143 */     boolean active = false;
/* 144 */     SystemDict systemDict = this.SystemDictService.selectSingleByKey(EnumSystemDictKey.REGISTER_EMAIL_ACTIVE.getValue());
/*     */ 
/* 146 */     if (null != systemDict) {
/* 147 */       active = EnumActiveStatus.Yes.getValue().equals(systemDict.getParaValue());
/*     */     }
/*     */ 
/* 151 */     String process = "";
/* 152 */     if ((userAccount.getUserClass() != null) && (!this.BASE_ROLE.equals(userAccount.getUserClass()))) {
/* 153 */       SystemUserCheck sysUserCheck = this.systemUserCheckService.selectByRole(userAccount.getUserClass());
/*     */ 
/* 155 */       process = sysUserCheck.getCheckProcess();
/*     */     }
/* 157 */     UserUpgradeAudit audit = null;
/* 158 */     if (!StringUtil.isEmpty(process)) {
/* 159 */       audit = new UserUpgradeAudit();
/* 160 */       audit.setApplyLevel(userAccount.getUserClass());
/* 161 */       audit.setAuditNode(String.valueOf(process.charAt(0)));
/* 162 */       audit.setAuditProcess(process + EnumCheckCommonNodes.END_NODE.getValue());
/*     */ 
/* 164 */       audit.setUserAccount(userAccount.getAccount());
/*     */     }
/*     */ 
/* 167 */     if ((!active) && (EnumUserStatus.Nonactivated.getValue().equals(userAccount.getStatus()))) {
/* 168 */       userAccount.setStatus(EnumUserStatus.Unfund.getValue());
/*     */     }
/*     */ 
/* 171 */     final boolean isShouldActive = active;
/* 172 */     final UserUpgradeAudit faudit = audit;
/*     */ 
/* 174 */     UserRole commonUserRole = this.userRoleDAO.getRoleByName(this.BASE_ROLE);
/* 175 */     if (null == commonUserRole) {
/* 176 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.USER_REGISTER_ROLENULL_ERROR.getValue()));
/* 177 */       result.setErrorInfo(EnumUserResultErrors.USER_REGISTER_ROLENULL_ERROR.getInfo());
/* 178 */       this.log.error("register fail, " + result.getErrorInfo());
/* 179 */       return result;
/*     */     }
/* 181 */     final UserAccount account = userAccount;
/* 182 */     final Long roleId = commonUserRole.getId();
/*     */ 
/* 184 */     result = (UserServiceResult)this.transactionTemplate.execute(new TransactionCallback() {
/*     */       public UserServiceResult doInTransaction(TransactionStatus status) {
/* 186 */         UserServiceResult result = new UserServiceResult();
/* 187 */         Object savePoint = status.createSavepoint();
/*     */         try {
/* 189 */           UserAccount newUserAccount = UserServiceImpl.this.addUserAccount(account);
/* 190 */           if (null == newUserAccount) {
/* 191 */             throw new Exception();
/*     */           }
/* 193 */           UserRoleRelationship systemUserRole = new UserRoleRelationship();
/* 194 */           systemUserRole.setUserId(newUserAccount.getId());
/* 195 */           systemUserRole.setRoleId(roleId);
/* 196 */           UserServiceImpl.this.userRoleRelationshipDAO.addUserRole(systemUserRole);
/* 197 */           UserAccountDTO dto = ConvertUtils.convert(newUserAccount);
/* 198 */           dto.setShouldActive(isShouldActive);
/* 199 */           result.setUserAccountDTO(dto);
/*     */ 
/* 201 */           if (null != faudit) {
/* 202 */             UserServiceImpl.this.userUpgradeAuditDAO.insert(faudit);
/*     */           }
/*     */ 
/* 205 */           UserServiceImpl.this.userLevelService.insertUserLevel(account.getAccount());
/*     */ 
/* 207 */           UserServiceImpl.this.userCreditService.addInsertUserCredit(account.getAccount());
/*     */         } catch (Exception e) {
/* 209 */           status.rollbackToSavepoint(savePoint);
/* 210 */           UserServiceImpl.this.log.error("", e);
/* 211 */           result.setErrorNO(Integer.valueOf(EnumUserResultErrors.USER_REGISTER_REG_ERROR.getValue()));
/* 212 */           result.setErrorInfo(EnumUserResultErrors.USER_REGISTER_REG_ERROR.getInfo());
/* 213 */           return result;
/*     */         }
/* 215 */         return result;
/*     */       }
/*     */     });
/* 219 */     return result;
/*     */   }
/*     */ 
/*     */   public ServiceResult activate(String account, String activeCode)
/*     */   {
/* 224 */     ServiceResult result = new ServiceResult();
/*     */     try
/*     */     {
/* 227 */       if ((StringUtil.isEmpty(account)) || (StringUtil.isEmpty(activeCode))) {
/* 228 */         result.setErrorNO(Integer.valueOf(EnumUserResultErrors.PARAMETER_ERROR.getValue()));
/* 229 */         result.setErrorInfo(EnumUserResultErrors.PARAMETER_ERROR.getInfo());
/* 230 */         this.log.error("login fail, " + result.getErrorInfo());
/* 231 */         return result;
/*     */       }
/* 233 */       UserAccount userAccount = new UserAccount();
/* 234 */       userAccount.setAccount(account);
/* 235 */       UserAccount queryUserAccount = this.userAccountDAO.queryByAccount(userAccount);
/*     */ 
/* 237 */       if (null == queryUserAccount) {
/* 238 */         result.setErrorNO(Integer.valueOf(EnumUserResultErrors.USER_NOT_EXISTS.getValue()));
/* 239 */         result.setErrorInfo(EnumUserResultErrors.USER_NOT_EXISTS.getInfo());
/* 240 */         this.log.debug("activate fail, " + result.getErrorInfo());
/* 241 */         return result;
/*     */       }
/*     */ 
/* 244 */       if (!EnumUserStatus.Nonactivated.getValue().equals(queryUserAccount.getStatus())) {
/* 245 */         result.setErrorNO(Integer.valueOf(EnumUserResultErrors.USER_ACTIVATE_STATUS_ERROR.getValue()));
/* 246 */         result.setErrorInfo(EnumUserResultErrors.USER_ACTIVATE_STATUS_ERROR.getInfo());
/* 247 */         this.log.debug("activate fail, " + result.getErrorInfo());
/* 248 */         return result;
/*     */       }
/*     */ 
/* 251 */       if (!activeCode.equals(queryUserAccount.getActiveCode())) {
/* 252 */         result.setErrorNO(Integer.valueOf(EnumUserResultErrors.USER_ACTIVATE_CODE_ERROR.getValue()));
/* 253 */         result.setErrorInfo(EnumUserResultErrors.USER_ACTIVATE_CODE_ERROR.getInfo());
/* 254 */         this.log.debug("activate fail, " + result.getErrorInfo());
/* 255 */         return result;
/*     */       }
/* 257 */       UserAccount updateUserAccount = new UserAccount();
/* 258 */       updateUserAccount.setAccount(userAccount.getAccount());
/* 259 */       updateUserAccount.setStatus(EnumUserStatus.Unfund.getValue());
/* 260 */       this.userAccountDAO.updateUserAccountByAccount(updateUserAccount);
/* 261 */       return result;
/*     */     } catch (Exception e) {
/* 263 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.INTERNAL_ERROR.getValue()));
/* 264 */       result.setErrorInfo(EnumUserResultErrors.INTERNAL_ERROR.getInfo());
/* 265 */       this.log.error("activate error", e);
/* 266 */     }return result;
/*     */   }
/*     */ 
/*     */   public ServiceResult resetPassword(String account, String oldPassword, String newPassword)
/*     */   {
/* 273 */     ServiceResult result = new ServiceResult();
/*     */     try {
/* 275 */       UserAccount userAccount = new UserAccount();
/* 276 */       userAccount.setAccount(account);
/* 277 */       userAccount = this.userAccountDAO.queryByAccount(userAccount);
/* 278 */       if (null == userAccount) {
/* 279 */         result.setErrorNO(Integer.valueOf(EnumUserResultErrors.USER_LOGIN_ACCOUNT_ERROR.getValue()));
/* 280 */         result.setErrorInfo(EnumUserResultErrors.USER_LOGIN_ACCOUNT_ERROR.getInfo());
/* 281 */         this.log.debug("user login fail, " + result.getErrorInfo());
/* 282 */         return result;
/*     */       }
/* 284 */       if (!this.passwordValidator.validate(userAccount.getPassword(), oldPassword)) {
/* 285 */         result.setErrorNO(Integer.valueOf(EnumUserResultErrors.USER_LOGIN_PASSWORD_ERROR.getValue()));
/* 286 */         result.setErrorInfo(EnumUserResultErrors.USER_LOGIN_PASSWORD_ERROR.getInfo());
/* 287 */         this.log.debug("user login fail, " + result.getErrorInfo());
/* 288 */         return result;
/*     */       }
/* 290 */       if ((!EnumUserStatus.Normal.getValue().equals(userAccount.getStatus())) && (!EnumUserStatus.Unfund.getValue().equals(userAccount.getStatus())))
/*     */       {
/* 292 */         result.setErrorNO(Integer.valueOf(EnumUserResultErrors.USER_LOGIN_STATUS_ERROR.getValue()));
/* 293 */         result.setErrorInfo(EnumUserResultErrors.USER_LOGIN_STATUS_ERROR.getInfo());
/* 294 */         this.log.debug("user login fail, status is not normal " + result.getErrorInfo());
/* 295 */         return result;
/*     */       }
/*     */ 
/* 298 */       UserAccount updateUserAccount = new UserAccount();
/* 299 */       updateUserAccount.setAccount(userAccount.getAccount());
/* 300 */       updateUserAccount.setPassword(this.passwordValidator.digest(newPassword));
/* 301 */       this.userAccountDAO.updateUserAccountByAccount(updateUserAccount);
/* 302 */       return result;
/*     */     } catch (Exception e) {
/* 304 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.INTERNAL_ERROR.getValue()));
/* 305 */       result.setErrorInfo(EnumUserResultErrors.INTERNAL_ERROR.getInfo());
/* 306 */       this.log.error("resetPassword error", e);
/* 307 */     }return result;
/*     */   }
/*     */ 
/*     */   public UserResetPWDResult updatePassword(UserResetPasswordRequest request)
/*     */   {
/* 313 */     UserResetPWDResult result = new UserResetPWDResult();
/* 314 */     if ((null == request) || (StringUtil.isEmpty(request.getAccount()))) {
/* 315 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.PARAMETER_ERROR.getValue()));
/* 316 */       result.setErrorInfo(EnumUserResultErrors.PARAMETER_ERROR.getInfo());
/* 317 */       this.log.debug("updatePassword fail, " + result.getErrorInfo());
/* 318 */       return result;
/*     */     }
/* 320 */     UserAccount userAccount = new UserAccount();
/* 321 */     userAccount.setAccount(request.getAccount());
/* 322 */     userAccount = this.userAccountDAO.queryByAccount(userAccount);
/* 323 */     if (null == userAccount) {
/* 324 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.USER_LOGIN_ACCOUNT_ERROR.getValue()));
/* 325 */       result.setErrorInfo(EnumUserResultErrors.USER_LOGIN_ACCOUNT_ERROR.getInfo());
/* 326 */       this.log.debug("updatePassword fail, " + result.getErrorInfo());
/* 327 */       return result;
/*     */     }
/* 329 */     String pwd = PasswordGenerator.pwGenerator();
/* 330 */     userAccount = new UserAccount();
/*     */ 
/* 332 */     if (EnumPasswordType.SYSTEM.getValue().equals(request.getPasswordType()))
/* 333 */       userAccount.setPassword(this.passwordValidator.digest(pwd));
/*     */     else {
/* 335 */       userAccount.setFundPassword(this.passwordValidator.digest(pwd));
/*     */     }
/* 337 */     userAccount.setAccount(request.getAccount());
/* 338 */     userAccount.setOperator(request.getOperator());
/* 339 */     if (this.userAccountDAO.updateUserAccountByAccount(userAccount).intValue() > 0)
/*     */     {
/* 341 */       result.setNewPassword(pwd);
/*     */     }
/*     */     else {
/* 344 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.DATABASE_OPERATE_ERROR.getValue()));
/* 345 */       result.setErrorInfo(EnumUserResultErrors.DATABASE_OPERATE_ERROR.getInfo());
/*     */     }
/* 347 */     return result;
/*     */   }
/*     */ 
/*     */   public synchronized UserAccount addUserAccount(UserAccount userAccount)
/*     */   {
/* 358 */     if (null == userAccount) {
/* 359 */       return null;
/*     */     }
/* 361 */     String newFundAccount = "";
/* 362 */     String maxFundAccount = this.userAccountDAO.getMaxFundAccount();
/* 363 */     if (null == maxFundAccount) {
/* 364 */       newFundAccount = "0000000001";
/*     */     } else {
/* 366 */       long seq = Long.valueOf(maxFundAccount).longValue() + 1L;
/* 367 */       String seqStr = Long.valueOf(seq).toString();
/* 368 */       String tempSeq = "0000000000" + seqStr;
/* 369 */       newFundAccount = tempSeq.substring(tempSeq.length() - 10, tempSeq.length());
/*     */     }
/* 371 */     userAccount.setFundAccount(newFundAccount);
/* 372 */     this.userAccountDAO.addUserAccount(userAccount);
/* 373 */     UserAccount queryUserAccount = new UserAccount();
/* 374 */     queryUserAccount.setAccount(userAccount.getAccount());
/* 375 */     return this.userAccountDAO.queryByAccount(queryUserAccount);
/*     */   }
/*     */ 
/*     */   public ServiceResult userUpgradeAudit(final UserUpgradeAuditRequest request)
/*     */   {
/* 398 */     ServiceResult result = new ServiceResult();
/*     */     try {
/* 400 */       if ((null == request) || (null == request.getAuditId())) {
/* 401 */         result.setErrorNO(Integer.valueOf(EnumUserResultErrors.PARAMETER_ERROR.getValue()));
/* 402 */         result.setErrorInfo(EnumUserResultErrors.PARAMETER_ERROR.getInfo());
/* 403 */         this.log.debug("UserUpgradeAudit fail, " + result.getErrorInfo());
/* 404 */         return result;
/*     */       }
/* 406 */       UserUpgradeAudit audit = this.userUpgradeAuditDAO.selectByPrimaryKey(request.getAuditId());
/* 407 */       if (null == audit) {
/* 408 */         result.setErrorNO(Integer.valueOf(EnumUserResultErrors.UPGRADE_AUDIT_NO_RECORD.getValue()));
/* 409 */         result.setErrorInfo(EnumUserResultErrors.UPGRADE_AUDIT_NO_RECORD.getInfo());
/* 410 */         this.log.debug("UserUpgradeAudit fail, " + result.getErrorInfo());
/* 411 */         return result;
/*     */       }
/* 413 */       String process = audit.getAuditProcess();
/* 414 */       if (null == process) {
/* 415 */         result.setErrorNO(Integer.valueOf(EnumUserResultErrors.UPGRADE_AUDIT_NO_NODE.getValue()));
/* 416 */         result.setErrorInfo(EnumUserResultErrors.UPGRADE_AUDIT_NO_NODE.getInfo());
/* 417 */         this.log.debug("UserUpgradeAudit fail, " + result.getErrorInfo());
/* 418 */         return result;
/*     */       }
/* 420 */       int index = process.indexOf(audit.getAuditNode());
/* 421 */       if (index < 0) {
/* 422 */         result.setErrorNO(Integer.valueOf(EnumUserResultErrors.UPGRADE_AUDIT_NO_NODE.getValue()));
/* 423 */         result.setErrorInfo(EnumUserResultErrors.UPGRADE_AUDIT_NO_NODE.getInfo());
/* 424 */         this.log.debug("UserUpgradeAudit fail, " + result.getErrorInfo());
/* 425 */         return result;
/*     */       }
/* 427 */       String node = "";
/* 428 */       if ((index < process.length() - 1) && (EnumAuditRes.YES.getValue().equals(request.getAuditNodeResult())))
/*     */       {
/* 430 */         node = String.valueOf(process.charAt(index + 1));
/*     */       }
/* 432 */       if (EnumAuditRes.NO.getValue().equals(request.getAuditNodeResult())) {
/* 433 */         node = EnumCheckCommonNodes.END_NODE.getValue();
/*     */       }
/* 435 */       if (StringUtil.isEmpty(node)) {
/* 436 */         result.setErrorNO(Integer.valueOf(EnumUserResultErrors.UPGRADE_AUDIT_NO_NEXT_NODE.getValue()));
/* 437 */         result.setErrorInfo(EnumUserResultErrors.UPGRADE_AUDIT_NO_NEXT_NODE.getInfo());
/* 438 */         this.log.debug("UserUpgradeAudit fail, " + result.getErrorInfo());
/* 439 */         return result;
/*     */       }
/* 441 */       audit.setAuditNodeResult(request.getAuditNodeResult());
/* 442 */       audit.setAuditNodeRemark(audit.getAuditNodeRemark() + "</br>" + request.getAuditNodeRemark());
/*     */ 
/* 445 */       audit.setOperateType(request.getOperateType());
/* 446 */       audit.setOperator(request.getOperator());
/* 447 */       audit.setAuditNode(node);
/*     */ 
/* 449 */       final UserUpgradeAudit fAudit = audit;
/* 450 */       final String fNode = node;
/* 451 */       result = (ServiceResult)this.transactionTemplate.execute(new TransactionCallback() {
/*     */         public UserServiceResult doInTransaction(TransactionStatus status) {
/* 453 */           UserServiceResult result = new UserServiceResult();
/* 454 */           Object savePoint = status.createSavepoint();
/*     */           try {
/* 456 */             if ((EnumAuditRes.YES.getValue().equals(request.getAuditNodeResult())) && (EnumCheckCommonNodes.END_NODE.getValue().equals(fNode)))
/*     */             {
/* 459 */               if (UserServiceImpl.this.userRoleRelationshipDAO.updateUserRole(fAudit.getUserAccount(), fAudit.getApplyLevel()) <= 0)
/*     */               {
/* 461 */                 throw new Exception();
/*     */               }
/*     */             }
/* 464 */             UserServiceImpl.this.userUpgradeAuditDAO.updateByPrimaryKeySelective(fAudit);
/*     */           }
/*     */           catch (Exception e) {
/* 467 */             status.rollbackToSavepoint(savePoint);
/* 468 */             UserServiceImpl.this.log.error("", e);
/* 469 */             result.setErrorNO(Integer.valueOf(EnumUserResultErrors.UPGRADE_AUDIT_INTERNAL_ERROR.getValue()));
/*     */ 
/* 471 */             result.setErrorInfo(EnumUserResultErrors.UPGRADE_AUDIT_INTERNAL_ERROR.getInfo());
/*     */ 
/* 473 */             return result;
/*     */           }
/* 475 */           return result;
/*     */         }
/*     */       });
/*     */     }
/*     */     catch (Exception e) {
/* 481 */       this.log.error("UserUpgradeAudit error", e);
/* 482 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.INTERNAL_ERROR.getValue()));
/* 483 */       result.setErrorInfo(EnumUserResultErrors.INTERNAL_ERROR.getInfo());
/* 484 */       return result;
/*     */     }
/* 486 */     return result;
/*     */   }
/*     */ 
/*     */   public boolean checkPayPwd(String userAccount, String paypwd)
/*     */   {
/* 496 */     UserAccount ua = this.userAccountDAO.selectByUserAccount(userAccount);
/* 497 */     if (StringUtil.isBlank(paypwd)) {
/* 498 */       return false;
/*     */     }
/*     */ 
/* 501 */     return this.passwordValidatorImpl.validate(ua.getFundPassword(), paypwd);
/*     */   }
/*     */ 
/*     */   public ServiceResult resetFundPwd(UserResetPasswordRequest request)
/*     */   {
/* 513 */     ServiceResult result = new ServiceResult();
/*     */     try
/*     */     {
/* 516 */       if ((null == request) || (StringUtil.isEmpty(request.getAccount())) || (StringUtil.isEmpty(request.getOldPassword())) || (StringUtil.isEmpty(request.getNewPassword())))
/*     */       {
/* 519 */         result.setErrorNO(Integer.valueOf(EnumUserResultErrors.PARAMETER_ERROR.getValue()));
/* 520 */         result.setErrorInfo(EnumUserResultErrors.PARAMETER_ERROR.getInfo());
/* 521 */         return result;
/*     */       }
/* 523 */       UserAccount ua = this.userAccountDAO.selectByUserAccount(request.getAccount());
/*     */ 
/* 525 */       if (!this.passwordValidator.validate(ua.getFundPassword(), request.getOldPassword())) {
/* 526 */         result.setErrorNO(Integer.valueOf(EnumUserResultErrors.USER_FUND_PWD_ERROR.getValue()));
/* 527 */         result.setErrorInfo(EnumUserResultErrors.USER_FUND_PWD_ERROR.getInfo());
/* 528 */         return result;
/*     */       }
/* 530 */       UserAccount upFundPwd = new UserAccount();
/* 531 */       upFundPwd.setAccount(request.getAccount());
/* 532 */       upFundPwd.setFundPassword(this.passwordValidator.digest(request.getNewPassword()));
/* 533 */       upFundPwd.setOperator(request.getOperator());
/*     */ 
/* 535 */       int number = this.userAccountDAO.updateUserAccountByAccount(upFundPwd).intValue();
/*     */ 
/* 537 */       if (number == 0) {
/* 538 */         result.setErrorNO(Integer.valueOf(EnumUserResultErrors.USER_NOT_EXISTS.getValue()));
/* 539 */         result.setErrorInfo(EnumUserResultErrors.USER_NOT_EXISTS.getInfo());
/* 540 */         return result;
/*     */       }
/* 542 */       return result;
/*     */     } catch (Exception e) {
/* 544 */       this.log.error("com.hundsun.network.gates.wulin.biz.service.pojo.user.UserServiceImpl resetFundPwd error,cause by:" + e.getMessage());
/*     */ 
/* 547 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.SERVER_ERROR.getValue()));
/* 548 */       result.setErrorInfo(EnumUserResultErrors.SERVER_ERROR.getInfo());
/* 549 */     }return result;
/*     */   }
/*     */ 
/*     */   public ServiceResult fundActivate(UserActivateRequest request)
/*     */   {
/* 555 */     ServiceResult result = new ServiceResult();
/*     */     try
/*     */     {
/* 559 */       if ((null == request) || (StringUtil.isEmpty(request.getFundAccount())) || (StringUtil.isEmpty(request.getBank())) || (StringUtil.isEmpty(request.getBankCard())) || (StringUtil.isEmpty(request.getCertificateNum())) || (StringUtil.isEmpty(request.getCertificateType())))
/*     */       {
/* 564 */         result.setErrorNO(Integer.valueOf(EnumUserResultErrors.PARAMETER_ERROR.getValue()));
/* 565 */         result.setErrorInfo(EnumUserResultErrors.PARAMETER_ERROR.getInfo());
/* 566 */         return result;
/*     */       }
/* 568 */       UserAccount userAccount = this.userAccountDAO.selectByFundAccount(request.getFundAccount());
/* 569 */       result = checkFundActivate(request, userAccount);
/* 570 */       if (result.error()) {
/* 571 */         return result;
/*     */       }
/* 573 */       Map map = new HashMap();
/* 574 */       map.put("status", EnumUserStatus.Normal.getValue());
/* 575 */       map.put("account", userAccount.getAccount());
/* 576 */       map.put("whereStatus", userAccount.getStatus());
/* 577 */       map.put("whereBank", userAccount.getBank());
/* 578 */       map.put("whereBankCard", userAccount.getBankCard());
/* 579 */       map.put("whereCertificateNum", userAccount.getCertificateNum());
/* 580 */       map.put("whereCertificateType", userAccount.getCertificateType());
/*     */ 
/* 583 */       if (this.userAccountDAO.updateUserAccountByAccount(map) <= 0) {
/* 584 */         result.setErrorNO(Integer.valueOf(EnumUserResultErrors.USER_NOT_EXISTS.getValue()));
/* 585 */         result.setErrorInfo(EnumUserResultErrors.USER_NOT_EXISTS.getInfo());
/* 586 */         return result;
/*     */       }
/* 588 */       return result;
/*     */     } catch (Exception e) {
/* 590 */       e.printStackTrace();
/* 591 */       this.log.error("com.hundsun.network.gates.wulin.biz.service.pojo.user.UserServiceImpl resetFundPwd error,cause by:" + e.getMessage());
/*     */ 
/* 594 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.SERVER_ERROR.getValue()));
/* 595 */       result.setErrorInfo(EnumUserResultErrors.SERVER_ERROR.getInfo());
/* 596 */     }return result;
/*     */   }
/*     */ 
/*     */   public UserServiceResult checkFundActivate(UserActivateRequest request)
/*     */   {
/* 607 */     UserServiceResult result = new UserServiceResult();
/*     */     try
/*     */     {
/* 611 */       if ((null == request) || (StringUtil.isEmpty(request.getFundAccount())) || (StringUtil.isEmpty(request.getBank())) || (StringUtil.isEmpty(request.getBankCard())) || (StringUtil.isEmpty(request.getCertificateNum())) || (StringUtil.isEmpty(request.getCertificateType())))
/*     */       {
/* 616 */         result.setErrorNO(Integer.valueOf(EnumUserResultErrors.PARAMETER_ERROR.getValue()));
/* 617 */         result.setErrorInfo(EnumUserResultErrors.PARAMETER_ERROR.getInfo());
/* 618 */         return result;
/*     */       }
/* 620 */       UserAccount userAccount = this.userAccountDAO.selectByFundAccount(request.getFundAccount());
/* 621 */       ServiceResult serviceResult = checkFundActivate(request, userAccount);
/* 622 */       if (serviceResult.error()) {
/* 623 */         result.setErrorInfo(serviceResult.getErrorInfo());
/* 624 */         result.setErrorNO(serviceResult.getErrorNO());
/* 625 */         return result;
/*     */       }
/* 627 */       result.setUserAccountDTO(ConvertUtils.convert(userAccount));
/* 628 */       return result;
/*     */     } catch (Exception e) {
/* 630 */       e.printStackTrace();
/* 631 */       this.log.error("com.hundsun.network.gates.wulin.biz.service.pojo.user.UserServiceImpl checkFundActivate error,cause by:" + e.getMessage());
/*     */ 
/* 634 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.SERVER_ERROR.getValue()));
/* 635 */       result.setErrorInfo(EnumUserResultErrors.SERVER_ERROR.getInfo());
/* 636 */     }return result;
/*     */   }
/*     */ 
/*     */   private ServiceResult checkFundActivate(UserActivateRequest request, UserAccount userAccount)
/*     */   {
/* 641 */     ServiceResult result = new ServiceResult();
/*     */ 
/* 643 */     if ((null == request) || (StringUtil.isEmpty(request.getFundAccount())) || (StringUtil.isEmpty(request.getBank())) || (StringUtil.isEmpty(request.getBankCard())) || (StringUtil.isEmpty(request.getCertificateNum())) || (StringUtil.isEmpty(request.getCertificateType())))
/*     */     {
/* 647 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.PARAMETER_ERROR.getValue()));
/* 648 */       result.setErrorInfo(EnumUserResultErrors.PARAMETER_ERROR.getInfo());
/* 649 */       return result;
/*     */     }
/* 651 */     if (null == userAccount) {
/* 652 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.USER_NOT_EXISTS.getValue()));
/* 653 */       result.setErrorInfo(EnumUserResultErrors.USER_NOT_EXISTS.getInfo());
/* 654 */       return result;
/*     */     }
/* 656 */     if ((!EnumUserStatus.Unfund.getValue().equals(userAccount.getStatus())) && (!EnumUserStatus.Nonactivated.getValue().equals(userAccount.getStatus())))
/*     */     {
/* 658 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.USER_ACTIVATE_STATUS_ERROR.getValue()));
/* 659 */       result.setErrorInfo(EnumUserResultErrors.USER_ACTIVATE_STATUS_ERROR.getInfo());
/* 660 */       return result;
/*     */     }
/* 662 */     if (!request.getBank().equals(userAccount.getBank())) {
/* 663 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.FUND_ACCOUNT_ACITVE_BANK_ERROR.getValue()));
/* 664 */       result.setErrorInfo(EnumUserResultErrors.FUND_ACCOUNT_ACITVE_BANK_ERROR.getInfo());
/* 665 */       return result;
/*     */     }
/* 667 */     if (!request.getBankCard().equals(userAccount.getBankCard())) {
/* 668 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.FUND_ACCOUNT_ACITVE_BANKCARD_ERROR.getValue()));
/* 669 */       result.setErrorInfo(EnumUserResultErrors.FUND_ACCOUNT_ACITVE_BANKCARD_ERROR.getInfo());
/* 670 */       return result;
/*     */     }
/* 672 */     if (!request.getCertificateNum().equals(userAccount.getCertificateNum())) {
/* 673 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.FUND_ACCOUNT_ACITVE_CERTIFICATENUM_ERROR.getValue()));
/*     */ 
/* 675 */       result.setErrorInfo(EnumUserResultErrors.FUND_ACCOUNT_ACITVE_CERTIFICATENUM_ERROR.getInfo());
/*     */ 
/* 677 */       return result;
/*     */     }
/* 679 */     if (!request.getCertificateType().equals(userAccount.getCertificateType())) {
/* 680 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.FUND_ACCOUNT_ACITVE_CERTIFICATETYPE_ERROR.getValue()));
/*     */ 
/* 682 */       result.setErrorInfo(EnumUserResultErrors.FUND_ACCOUNT_ACITVE_CERTIFICATETYPE_ERROR.getInfo());
/*     */ 
/* 684 */       return result;
/*     */     }
/* 686 */     return result;
/*     */   }
/*     */ 
/*     */   public ServiceResult checkFundOut(String fundAccount)
/*     */   {
/* 695 */     ServiceResult result = new ServiceResult();
/*     */     try
/*     */     {
/* 698 */       if (StringUtil.isEmpty(fundAccount)) {
/* 699 */         result.setErrorNO(Integer.valueOf(EnumUserResultErrors.PARAMETER_ERROR.getValue()));
/* 700 */         result.setErrorInfo(EnumUserResultErrors.PARAMETER_ERROR.getInfo());
/* 701 */         return result;
/*     */       }
/* 703 */       UserAccount userAccount = this.userAccountDAO.selectByFundAccount(fundAccount);
/* 704 */       if (null == userAccount) {
/* 705 */         result.setErrorNO(Integer.valueOf(EnumUserResultErrors.USER_NOT_EXISTS.getValue()));
/* 706 */         result.setErrorInfo(EnumUserResultErrors.USER_NOT_EXISTS.getInfo());
/* 707 */         return result;
/*     */       }
/*     */ 
/* 710 */       if (!EnumUserStatus.Normal.getValue().equals(userAccount.getStatus())) {
/* 711 */         result.setErrorNO(Integer.valueOf(EnumUserResultErrors.USER_LOGIN_STATUS_ERROR.getValue()));
/* 712 */         result.setErrorInfo(EnumUserResultErrors.USER_LOGIN_STATUS_ERROR.getInfo());
/* 713 */         return result;
/*     */       }
/* 715 */       return result;
/*     */     } catch (Exception e) {
/* 717 */       e.printStackTrace();
/* 718 */       this.log.error("com.hundsun.network.gates.wulin.biz.service.pojo.user.UserServiceImpl checkFundOut error,cause by:" + e.getMessage());
/*     */ 
/* 721 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.SERVER_ERROR.getValue()));
/* 722 */       result.setErrorInfo(EnumUserResultErrors.SERVER_ERROR.getInfo());
/* 723 */     }return result;
/*     */   }
/*     */ 
/*     */   public UserServiceResult getUserMsgByAccount(UserLoginRequest request)
/*     */   {
/* 731 */     UserServiceResult result = new UserServiceResult();
/*     */     try
/*     */     {
/* 734 */       if ((null == request) || ((StringUtil.isEmpty(request.getUserAccount())) && (StringUtil.isEmpty(request.getFundAccount()))))
/*     */       {
/* 737 */         result.setErrorNO(Integer.valueOf(EnumUserResultErrors.PARAMETER_ERROR.getValue()));
/* 738 */         result.setErrorInfo(EnumUserResultErrors.PARAMETER_ERROR.getInfo());
/* 739 */         return result;
/*     */       }
/*     */ 
/* 742 */       UserAccount ua = null;
/* 743 */       if (!StringUtil.isEmpty(request.getUserAccount()))
/* 744 */         ua = this.userAccountDAO.selectByUserAccount(request.getUserAccount());
/* 745 */       else if (!StringUtil.isEmpty(request.getFundAccount())) {
/* 746 */         ua = this.userAccountDAO.selectByFundAccount(request.getFundAccount());
/*     */       }
/* 748 */       if (null == ua) {
/* 749 */         result.setErrorNO(Integer.valueOf(EnumUserResultErrors.USER_NOT_EXISTS.getValue()));
/* 750 */         result.setErrorInfo(EnumUserResultErrors.USER_NOT_EXISTS.getInfo());
/* 751 */         return result;
/*     */       }
/* 753 */       result.setUserAccountDTO(ConvertUtils.convert(ua));
/* 754 */       return result;
/*     */     } catch (Exception e) {
/* 756 */       e.printStackTrace();
/* 757 */       this.log.error("com.hundsun.network.gates.wulin.biz.service.pojo.user.UserServiceImpl getUserMsgByAccount error,cause by:" + e.getMessage());
/*     */ 
/* 760 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.SERVER_ERROR.getValue()));
/* 761 */       result.setErrorInfo(EnumUserResultErrors.SERVER_ERROR.getInfo());
/* 762 */     }return result;
/*     */   }
/*     */ 
/*     */   public CancleAccountResult deleteUserValidate(String userAccount)
/*     */   {
/* 777 */     CancleAccountResult result = new CancleAccountResult();
/* 778 */     UserAccount uc = this.userAccountDAO.selectByUserAccount(userAccount);
/* 779 */     if (null == uc) {
/* 780 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.USER_NOT_EXISTS.getValue()));
/* 781 */       result.setErrorInfo(EnumUserResultErrors.USER_NOT_EXISTS.getInfo());
/* 782 */       result.setResult(EnumCancleAccount.CANCLE_ERROR.getValue());
/* 783 */       return result;
/*     */     }
/* 785 */     if (EnumUserStatus.Unfund.getValue().equals(uc.getStatus())) {
/* 786 */       result = deleteAccount(userAccount);
/* 787 */       return result;
/*     */     }
/* 789 */     int NumOfOrder = this.tradeOrderDAO.selectNumOfUnfinishedOrder(userAccount);
/* 790 */     if (NumOfOrder > 0) {
/* 791 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.USER_DELETE_UNFINISHED_ORDER_ERROR.getValue()));
/* 792 */       result.setErrorInfo(EnumUserResultErrors.USER_DELETE_UNFINISHED_ORDER_ERROR.getInfo());
/* 793 */       result.setResult(EnumCancleAccount.CANCLE_ERROR.getValue());
/* 794 */       return result;
/*     */     }
/* 796 */     int NumOfWishOrder = this.tradeWishOrderDAO.selectNumOfUnfinishedWishOrder(userAccount);
/* 797 */     if (NumOfWishOrder > 0) {
/* 798 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.USER_DELETE_UNFINISHED_WISHORDER_ERROR.getValue()));
/*     */ 
/* 800 */       result.setErrorInfo(EnumUserResultErrors.USER_DELETE_UNFINISHED_WISHORDER_ERROR.getInfo());
/*     */ 
/* 802 */       result.setResult(EnumCancleAccount.CANCLE_ERROR.getValue());
/* 803 */       return result;
/*     */     }
/* 805 */     result.setResult(EnumCancleAccount.IN_CANCLE.getValue());
/* 806 */     return result;
/*     */   }
/*     */ 
/*     */   public CancleAccountResult deleteAccount(String userAccount)
/*     */   {
/* 818 */     CancleAccountResult result = new CancleAccountResult();
/* 819 */     UserAccount uc = new UserAccount();
/* 820 */     uc.setAccount(userAccount);
/* 821 */     uc.setStatus(EnumUserStatus.Delete.getValue());
/*     */     try {
/* 823 */       int number = this.userAccountDAO.updateUserAccountByAccount(uc).intValue();
/* 824 */       if (number > 0) {
/* 825 */         result.setResult(EnumCancleAccount.CANCLE_SUCCESS.getValue());
/* 826 */         return result;
/*     */       }
/* 828 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.DATABASE_OPERATE_ERROR.getValue()));
/* 829 */       result.setErrorInfo(EnumUserResultErrors.DATABASE_OPERATE_ERROR.getInfo());
/* 830 */       result.setResult(EnumCancleAccount.CANCLE_ERROR.getValue());
/* 831 */       return result;
/*     */     }
/*     */     catch (Exception e) {
/* 834 */       this.log.error("deleteAccount error, cause by:", e);
/* 835 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.INTERNAL_ERROR.getValue()));
/* 836 */       result.setErrorInfo(EnumUserResultErrors.INTERNAL_ERROR.getInfo());
/* 837 */       result.setResult(EnumCancleAccount.CANCLE_ERROR.getValue());
/* 838 */     }return result;
/*     */   }
/*     */ 
/*     */   public CancleAccountResult cancleAccount(String userAccount)
/*     */   {
/* 852 */     CancleAccountResult result = new CancleAccountResult();
/* 853 */     result = deleteAccount(userAccount);
/* 854 */     return result;
/*     */   }
/*     */ 
/*     */   public UserServiceResult specialRegister(UserAccount userAccount)
/*     */   {
/* 859 */     UserServiceResult result = new UserServiceResult();
/* 860 */     if (null == userAccount) {
/* 861 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.PARAMETER_ERROR.getValue()));
/* 862 */       result.setErrorInfo(EnumUserResultErrors.PARAMETER_ERROR.getInfo());
/* 863 */       this.log.error("register fail, " + result.getErrorInfo());
/* 864 */       return result;
/*     */     }
/* 866 */     userAccount.setPassword(this.passwordValidator.digest(userAccount.getPassword()));
/* 867 */     userAccount.setFundPassword(this.passwordValidator.digest(userAccount.getFundPassword()));
/*     */ 
/* 898 */     UserRole commonUserRole = this.userRoleDAO.getRoleByName(userAccount.getUserClass());
/* 899 */     if (null == commonUserRole) {
/* 900 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.USER_REGISTER_ROLENULL_ERROR.getValue()));
/* 901 */       result.setErrorInfo(EnumUserResultErrors.USER_REGISTER_ROLENULL_ERROR.getInfo());
/* 902 */       this.log.error("register fail, " + result.getErrorInfo());
/* 903 */       return result;
/*     */     }
/* 905 */     final UserAccount account = userAccount;
/* 906 */     final Long roleId = commonUserRole.getId();
/*     */ 
/* 908 */     result = (UserServiceResult)this.transactionTemplate.execute(new TransactionCallback() {
/*     */       public UserServiceResult doInTransaction(TransactionStatus status) {
/* 910 */         UserServiceResult result = new UserServiceResult();
/* 911 */         Object savePoint = status.createSavepoint();
/*     */         try {
/* 913 */           UserAccount newUserAccount = UserServiceImpl.this.addUserAccount(account);
/* 914 */           if (null == newUserAccount) {
/* 915 */             throw new Exception();
/*     */           }
/* 917 */           UserRoleRelationship systemUserRole = new UserRoleRelationship();
/* 918 */           systemUserRole.setUserId(newUserAccount.getId());
/* 919 */           systemUserRole.setRoleId(roleId);
/* 920 */           UserServiceImpl.this.userRoleRelationshipDAO.addUserRole(systemUserRole);
/* 921 */           UserAccountDTO dto = ConvertUtils.convert(newUserAccount);
/* 922 */           dto.setShouldActive(false);
/* 923 */           result.setUserAccountDTO(dto);
/*     */ 
/* 929 */           UserServiceImpl.this.userLevelService.insertUserLevel(account.getAccount());
/*     */ 
/* 931 */           UserServiceImpl.this.userCreditService.addInsertUserCredit(account.getAccount());
/*     */         } catch (Exception e) {
/* 933 */           status.rollbackToSavepoint(savePoint);
/* 934 */           e.printStackTrace();
/* 935 */           UserServiceImpl.this.log.error("", e);
/* 936 */           result.setErrorNO(Integer.valueOf(EnumUserResultErrors.USER_REGISTER_REG_ERROR.getValue()));
/* 937 */           result.setErrorInfo(EnumUserResultErrors.USER_REGISTER_REG_ERROR.getInfo());
/* 938 */           return result;
/*     */         }
/* 940 */         return result;
/*     */       }
/*     */     });
/* 944 */     return result;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.pojo.user.UserServiceImpl
 * JD-Core Version:    0.6.0
 */