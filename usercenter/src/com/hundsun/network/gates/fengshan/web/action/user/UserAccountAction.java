/*     */ package com.hundsun.network.gates.fengshan.web.action.user;
/*     */ 
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.user.UserAccount;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.user.UserLogin;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.user.UserRole;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.user.UserUpgradeAudit;
/*     */ import com.hundsun.network.gates.fengshan.biz.service.user.UserAccountService;
/*     */ import com.hundsun.network.gates.fengshan.biz.service.user.UserRoleService;
/*     */ import com.hundsun.network.gates.fengshan.biz.service.user.UserUpgradeAuditService;
/*     */ import com.hundsun.network.gates.fengshan.web.action.BaseAction;
/*     */ import com.hundsun.network.gates.fengshan.web.util.ConvertUtils;
/*     */ import com.hundsun.network.gates.fengshan.web.validator.user.UserAccountLoginValidator;
/*     */ import com.hundsun.network.gates.fengshan.web.validator.user.UserAccountValidator;
/*     */ import com.hundsun.network.gates.luosi.biz.domain.UserAgent;
/*     */ import com.hundsun.network.gates.luosi.biz.security.SystemAccess;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumBank;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumEnterpiseCertificateType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumPersonalCertificateType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumUserType;
/*     */ import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
/*     */ import com.hundsun.network.gates.luosi.common.utils.CommonUtils;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumCancleAccount;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumUserResultErrors;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumUserStatus;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.CancleAccountResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.UserServiceResult;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import com.hundsun.network.melody.common.web.cookyjar.Cookyjar;
/*     */ import java.io.IOException;
/*     */ import java.net.URLDecoder;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.beans.factory.annotation.Value;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.validation.BindingResult;
/*     */ import org.springframework.web.bind.annotation.ModelAttribute;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ 
/*     */ @Controller
/*     */ public class UserAccountAction extends BaseAction
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private UserAccountService userAccountService;
/*     */ 
/*     */   @Autowired
/*     */   private UserAccountValidator userAccountValidator;
/*     */ 
/*     */   @Autowired
/*     */   private UserAccountLoginValidator UserAccountLoginValidator;
/*     */ 
/*     */   @Autowired
/*     */   private UserRoleService userRoleService;
/*     */ 
/*     */   @Autowired
/*     */   private UserUpgradeAuditService userUpgradeAuditService;
/*     */ 
/*     */   @Value("${web.encoding}")
/*     */   private String webEncoding;
/*     */ 
/*     */   @Value("${fengshan.fundActiveHelp.url}")
/*     */   private String fundActiveHelpUrl;
/*     */ 
/*     */   private void initeRegPage(ModelMap model)
/*     */   {
/*  79 */     EnumUserType[] userTypes = EnumUserType.values();
/*  80 */     EnumPersonalCertificateType[] pecertificateTypes = EnumPersonalCertificateType.values();
/*  81 */     EnumEnterpiseCertificateType[] enCertificateTypes = EnumEnterpiseCertificateType.values();
/*  82 */     EnumBank[] banks = EnumBank.values();
/*  83 */     model.addAttribute("userTypes", userTypes);
/*  84 */     model.addAttribute("peCertificateTypes", pecertificateTypes);
/*  85 */     model.addAttribute("enCertificateTypes", enCertificateTypes);
/*  86 */     List<UserRole> rolesList = this.userRoleService.getRoles();
/*  87 */     List tradeSysRolesList = new ArrayList();
/*  88 */     for (UserRole userRole : rolesList) {
/*  89 */       if (("common".equals(userRole.getName())) || ("middle".equals(userRole.getName())) || ("high".equals(userRole.getName()))) {
/*  90 */         tradeSysRolesList.add(userRole);
/*     */       }
/*     */     }
/*  93 */     model.addAttribute("rolesList", tradeSysRolesList);
/*  94 */     model.addAttribute("banks", banks);
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"/home/agreement"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void agreementPage()
/*     */   {
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"register"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void regPage(@ModelAttribute("userAccount") UserAccount userAccount, @ModelAttribute("checkCode") String checkCode, ModelMap model)
/*     */   {
/* 112 */     initeRegPage(model);
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"/register"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String register(@ModelAttribute("userAccount") UserAccount userAccount, BindingResult result, @RequestParam(value="checkCode", required=false) String checkCode, Cookyjar cookyjar, ModelMap model)
/*     */   {
/* 124 */     model.addAttribute("rolesList", this.userRoleService.getRoles());
/* 125 */     if (!checkCode.equalsIgnoreCase(cookyjar.get("checkCode"))) {
/* 126 */       model.addAttribute("checkCodeError", getMessage("common.error.checkcode", new String[0]));
/* 127 */       initeRegPage(model);
/* 128 */       return "/register";
/*     */     }
/* 130 */     this.userAccountValidator.validate(userAccount, result);
/* 131 */     if (result.hasErrors()) {
/* 132 */       initeRegPage(model);
/* 133 */       return "/register";
/*     */     }
/* 135 */     this.userAccountValidator.uniqueValidate(userAccount, result);
/* 136 */     if (result.hasErrors()) {
/* 137 */       initeRegPage(model);
/* 138 */       return "/register";
/*     */     }
/* 140 */     UserServiceResult regResult = this.userAccountService.register(userAccount);
/* 141 */     if (regResult.correct()) {
/* 142 */       model.addAttribute("userAccount", ConvertUtils.convert(regResult.getUserAccountDTO()));
/* 143 */       model.addAttribute("fundActiveHelpUrl", this.fundActiveHelpUrl);
/* 144 */       return "/regSuccess";
/*     */     }
/* 146 */     setResult(model, regResult);
/* 147 */     initeRegPage(model);
/* 148 */     return "/register";
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"/login"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void loginInit(@ModelAttribute("userLogin") UserLogin userLogin, HttpServletRequest request, @RequestParam(value="returnurl", required=false) String returnurl, ModelMap model)
/*     */   {
/* 162 */     model.addAttribute("returnurl", returnurl);
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"/login"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String login(@ModelAttribute("userLogin") UserLogin userLogin, BindingResult bindingResult, Cookyjar cookyjar, HttpServletRequest request, @RequestParam(value="returnurl", required=false) String returnurl, ModelMap model)
/*     */     throws IOException
/*     */   {
/* 177 */     model.addAttribute("returnurl", returnurl);
/* 178 */     if (!userLogin.getCheckCode().equalsIgnoreCase(cookyjar.get("checkCode"))) {
/* 179 */       model.addAttribute("checkCodeError", getMessage("common.error.checkcode", new String[0]));
/* 180 */       return "/login";
/*     */     }
/* 182 */     this.UserAccountLoginValidator.validate(userLogin, bindingResult);
/* 183 */     if (bindingResult.hasErrors()) {
/* 184 */       return "/login";
/*     */     }
/* 186 */     String ip = CommonUtils.getIpAddr(request);
/* 187 */     if (ip == null) {
/* 188 */       ip = "";
/*     */     }
/* 190 */     userLogin.setLoginIp(ip);
/* 191 */     UserServiceResult userServiceResult = this.userAccountService.login(userLogin);
/* 192 */     if (userServiceResult == null) {
/* 193 */       setErrorResult(model, "remote.error.null", new String[0]);
/* 194 */       return "/login";
/*     */     }
/*     */ 
/* 197 */     if (userServiceResult.error()) {
/* 198 */       setResult(model, userServiceResult);
/* 199 */       return "/login";
/*     */     }
/* 201 */     UserAccount userAccount = ConvertUtils.convert(userServiceResult.getUserAccountDTO());
/* 202 */     UserAgent agent = ConvertUtils.convertToUserAgent(userAccount);
/*     */ 
/* 204 */     List permissions = this.userAccountService.getUserPermissions(userAccount.getId());
/* 205 */     for (Iterator it = permissions.iterator(); it.hasNext(); ) {
/* 206 */       int permissionId = ((Integer)it.next()).intValue();
/* 207 */       agent.setFunctions(permissionId);
/*     */     }
/* 209 */     UserRole userRole = this.userRoleService.getRoleByUserId(userAccount.getId());
/* 210 */     if (userRole != null) {
/* 211 */       agent.setRoleId(userRole.getId());
/* 212 */       agent.setRoleName(userRole.getDescription());
/*     */     }
/* 214 */     cookyjar.set(agent);
/* 215 */     model.clear();
/*     */ 
/* 217 */     if (!StringUtil.isBlank(returnurl)) {
/* 218 */       returnurl = URLDecoder.decode(returnurl, this.webEncoding);
/* 219 */       return "redirect:" + returnurl;
/*     */     }
/* 221 */     return redirectIndex();
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/logout"})
/*     */   public String userLogout(Cookyjar cookyjar)
/*     */     throws Exception
/*     */   {
/* 231 */     cookyjar.clean();
/* 232 */     return redirectIndex();
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/user/activate"})
/*     */   public String userActivate(@RequestParam(value="a", required=false) String accountId, @RequestParam(value="c", required=false) String activeCode, ModelMap model)
/*     */     throws Exception
/*     */   {
/* 246 */     ServiceResult result = new ServiceResult();
/* 247 */     if ((StringUtil.isEmpty(accountId)) || (StringUtil.isEmpty(activeCode)) || 
/* 248 */       (!StringUtil.isNumeric(accountId))) {
/* 249 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.PARAMETER_ERROR.getValue()));
/* 250 */       result.setErrorInfo(EnumUserResultErrors.PARAMETER_ERROR.getInfo());
/* 251 */       setResult(model, result);
/* 252 */       return "/user/activate/error";
/*     */     }
/* 254 */     UserAccount userAccount = null;
/*     */     try {
/* 256 */       userAccount = this.userAccountService
/* 257 */         .getUserAccountById(Long.valueOf(accountId));
/*     */     } catch (Exception e) {
/* 259 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.INTERNAL_ERROR.getValue()));
/* 260 */       result.setErrorInfo(EnumUserResultErrors.INTERNAL_ERROR.getInfo());
/* 261 */       setResult(model, result);
/* 262 */       return "/user/activate/error";
/*     */     }
/* 264 */     if (userAccount == null) {
/* 265 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.USER_NOT_EXISTS.getValue()));
/* 266 */       result.setErrorInfo(EnumUserResultErrors.USER_NOT_EXISTS.getInfo());
/* 267 */       setResult(model, result);
/* 268 */       return "/user/activate/error";
/*     */     }
/* 270 */     result = this.userAccountService.activate(userAccount.getAccount(), activeCode);
/* 271 */     if (result.correct())
/*     */     {
/* 273 */       UserRole userRole = this.userRoleService.getRoleByUserId(userAccount.getId());
/* 274 */       UserUpgradeAudit userUpgradeAudit = this.userUpgradeAuditService
/* 275 */         .getRecentAuditResult(userAccount.getAccount());
/* 276 */       model.addAttribute("role", userRole.getUserRoleDesc());
/* 277 */       if (userUpgradeAudit != null) {
/* 278 */         model.addAttribute("appRole", userUpgradeAudit.getAppRoleDesc());
/*     */       }
/* 280 */       model.addAttribute("userAccount", userAccount.getAccount());
/* 281 */       return "/user/activate/success";
/*     */     }
/* 283 */     setResult(model, result);
/* 284 */     return "/user/activate/error";
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_U_USER_PASSWORD_RESET})
/*     */   @RequestMapping(value={"/user/passwordreset"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void initPasswordRest(Model model)
/*     */   {
/* 299 */     model.addAttribute("error", "init");
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_U_USER_PASSWORD_RESET})
/*     */   @RequestMapping(value={"/user/passwordreset"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void passwordReset(UserAgent userAgent, @RequestParam(value="oldPassword", required=false) String oldPassword, @RequestParam(value="newPassword", required=false) String newPassword, Model model)
/*     */   {
/* 318 */     String account = userAgent.getAccount();
/* 319 */     ServiceResult result = this.userAccountService.resetPassword(account, oldPassword, newPassword);
/* 320 */     if ((result == null) || (result.getErrorInfo() == null))
/* 321 */       model.addAttribute("error", "success");
/*     */     else
/* 323 */       model.addAttribute("error", result.getErrorInfo());
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_U_USER_INDEX})
/*     */   @RequestMapping({"/user/index"})
/*     */   public void userAddressModify(UserAgent userAgent, Model model)
/*     */   {
/* 338 */     this.userAccountService.initIssueTodoForAuctioneer(model, userAgent.getAccount());
/*     */ 
/* 341 */     this.userAccountService.initIssueTodoForReviewer(model, userAgent.getAccount());
/*     */ 
/* 344 */     this.userAccountService.initIssueTodo(model, userAgent.getAccount());
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_U_USER_INFO_EDIT})
/*     */   @RequestMapping(value={"/user/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void initUserAccountEdit(UserAgent userAgent, @ModelAttribute("userAccount") UserAccount userAccount, Model model)
/*     */   {
/* 361 */     userAccount = this.userAccountService.getUserAccountByAccount(userAgent.getAccount());
/* 362 */     UserAccount displayUserAccount = userAccount;
/* 363 */     model.addAttribute("userAccount", userAccount);
/* 364 */     model.addAttribute("displayUserAccount", displayUserAccount);
/* 365 */     model.addAttribute("banks", EnumBank.values());
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_U_USER_INFO_EDIT})
/*     */   @RequestMapping(value={"/user/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String UserAccountEdit(UserAgent userAgent, @ModelAttribute("userAccount") UserAccount userAccount, BindingResult result, Model model)
/*     */   {
/* 382 */     userAccount.setAccount(userAgent.getAccount());
/* 383 */     this.userAccountValidator.editValidate(userAccount, result);
/* 384 */     UserAccount displayUserAccount = this.userAccountService.getUserAccountByAccount(userAccount
/* 385 */       .getAccount());
/* 386 */     if (result.hasErrors()) {
/* 387 */       model.addAttribute("displayUserAccount", displayUserAccount);
/* 388 */       return "/user/edit";
/*     */     }
/* 390 */     int number = this.userAccountService.changeUserAccount(userAccount);
/* 391 */     userAccount = this.userAccountService.getUserAccountByAccount(userAgent.getAccount());
/* 392 */     model.addAttribute("displayUserAccount", displayUserAccount);
/* 393 */     model.addAttribute("userAccount", userAccount);
/* 394 */     model.addAttribute("number", Integer.valueOf(number));
/* 395 */     model.addAttribute("banks", EnumBank.values());
/* 396 */     return "/user/edit";
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_R_USER_LEVELS_VIEW})
/*     */   @RequestMapping({"/user/level/member"})
/*     */   public void userAccountLevel(UserAgent userAgent, ModelMap model)
/*     */   {
/* 407 */     model.addAttribute("userLevel", this.userAccountService.getUserLevelByUserAccount(userAgent
/* 408 */       .getAccount()));
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_R_USER_LEVELS_VIEW})
/*     */   @RequestMapping({"/user/level/credit"})
/*     */   public void userCreditLevel(UserAgent userAgent, ModelMap model)
/*     */   {
/* 419 */     model.addAttribute("userCredit", this.userAccountService.getUserCreditLevelUserAccount(userAgent
/* 420 */       .getAccount()));
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_U_USER_UPGRADE})
/*     */   @RequestMapping(value={"/user/upgrade/apply"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void initUserUpGrade(UserAgent userAgent, Model model)
/*     */   {
/* 434 */     UserUpgradeAudit userUpgradeAudit = this.userUpgradeAuditService.getRecentAuditResult(userAgent
/* 435 */       .getAccount());
/* 436 */     UserRole userRole = this.userRoleService.getRoleInfoByAccount(userAgent.getAccount());
/* 437 */     List userRoleList = this.userRoleService.getUpRoleByRoleName(userAgent.getAccount());
/* 438 */     UserAccount fundInfo = this.userAccountService.getFundInfoByAccount(userAgent.getAccount());
/* 439 */     if (EnumUserStatus.Unfund.getValue().equals(fundInfo.getStatus()))
/* 440 */       model.addAttribute("fundInfo", fundInfo);
/*     */     else {
/* 442 */       model.addAttribute("fundInfo", "");
/*     */     }
/* 444 */     model.addAttribute("userRole", userRole);
/* 445 */     model.addAttribute("userAuditInfo", userUpgradeAudit);
/* 446 */     model.addAttribute("userRoleList", userRoleList);
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_U_USER_UPGRADE})
/*     */   @RequestMapping(value={"/user/upgrade/apply"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @ResponseBody
/*     */   public Integer userUpGrade(UserAgent userAgent, @RequestParam("roleName") String roleName, Model model)
/*     */   {
/* 462 */     UserUpgradeAudit userUpgradeAudit = new UserUpgradeAudit();
/* 463 */     userUpgradeAudit.setApplyLevel(roleName);
/* 464 */     userUpgradeAudit.setUserAccount(userAgent.getAccount());
/* 465 */     userUpgradeAudit.setOperator(userAgent.getAccount());
/* 466 */     Integer result = this.userUpgradeAuditService.upGradeUserRole(userUpgradeAudit, userAgent
/* 467 */       .getAccount());
/* 468 */     return result;
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"/user/delete"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String userApplyCancleAccount(Cookyjar cookyjar, UserAgent userAgent, ModelMap model)
/*     */   {
/* 482 */     CancleAccountResult result = new CancleAccountResult();
/* 483 */     UserAccount account = this.userAccountService.getUserAccountByAccount(userAgent.getAccount());
/* 484 */     result = this.userAccountService.applyCancle(account, userAgent.getFundAccount());
/* 485 */     if (result.error()) {
/* 486 */       model.put("message", result.getErrorInfo());
/* 487 */       model.put("url", "/funds/info");
/* 488 */       return "user/cancle/error";
/* 489 */     }if (EnumCancleAccount.CANCLE_SUCCESS.getValue().equals(result.getResult())) {
/* 490 */       cookyjar.clean();
/* 491 */       model.put("message", result.getResult());
/* 492 */       model.put("url", "/funds/info");
/* 493 */       return "user/cancle/success";
/*     */     }
/* 495 */     model.put("account", account);
/* 496 */     model.put("message", result.getResult());
/* 497 */     model.put("url", "/funds/info");
/* 498 */     return "user/cancle/success";
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.web.action.user.UserAccountAction
 * JD-Core Version:    0.6.0
 */