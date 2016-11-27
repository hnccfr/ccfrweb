/*     */ package com.hundsun.network.gates.genshan.web.action.user;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.domain.baseset.UserLevel;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.fund.FundAccountMsg;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.query.UserAccountQuery;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.user.UserAccount;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.user.UserCreditInfo;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.user.UserRole;
/*     */ import com.hundsun.network.gates.genshan.biz.enums.UserRoleEnum;
/*     */ import com.hundsun.network.gates.genshan.biz.enums.UserStatusEnum;
/*     */ import com.hundsun.network.gates.genshan.biz.enums.UserTypeEnum;
/*     */ import com.hundsun.network.gates.genshan.biz.service.fund.FundQueryService;
/*     */ import com.hundsun.network.gates.genshan.biz.service.user.UserAccountService;
/*     */ import com.hundsun.network.gates.genshan.common.UserAgent;
/*     */ import com.hundsun.network.gates.genshan.security.AdminAccess;
/*     */ import com.hundsun.network.gates.genshan.web.action.BaseAction;
/*     */ import com.hundsun.network.gates.genshan.web.validator.UserAccountValidator;
/*     */ import com.hundsun.network.gates.luosi.biz.enums.EnumPasswordType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumBank;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumEnterpiseCertificateType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumPersonalCertificateType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumUserType;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.request.AccountRequest;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.result.FundOperateResult;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.service.RemoteFundService;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumUserResultErrors;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumUserStatus;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.UserResetPWDResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.UserServiceResult;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import org.apache.commons.logging.Log;
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
/*     */   private RemoteFundService remoteFundService;
/*     */ 
/*     */   @Autowired
/*     */   private UserAccountService userAccountService;
/*     */ 
/*     */   @Autowired
/*     */   private FundQueryService fundQueryService;
/*     */ 
/*     */   @Autowired
/*     */   private UserAccountValidator userAccountValidator;
/*     */ 
/*     */   @Value("${remot.fund.app}")
/*     */   private String remotFundApp;
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.USER_R_LIST})
/*     */   @RequestMapping({"/user/list"})
/*     */   public void userAccountList(@ModelAttribute("query") UserAccountQuery query, Model model)
/*     */   {
/*  86 */     List roleList = new ArrayList();
/*  87 */     roleList.add(UserRoleEnum.COMMON.getValue());
/*  88 */     roleList.add(UserRoleEnum.MIDDLE.getValue());
/*  89 */     roleList.add(UserRoleEnum.HIGH.getValue());
/*  90 */     query.setRoleList(roleList);
/*  91 */     if (query.getAccount() != null) {
/*  92 */       query.setAccount(query.getAccount().trim());
/*     */     }
/*  94 */     if (query.getName() != null) {
/*  95 */       query.setName(query.getName().trim());
/*     */     }
/*  97 */     this.userAccountService.getUserAccountList(query);
/*  98 */     List _list = Arrays.asList(UserRoleEnum.values());
/*  99 */     List userRoleList = new ArrayList();
/* 100 */     userRoleList.addAll(_list);
/* 101 */     userRoleList.remove(UserRoleEnum.AUCTIONEER);
/* 102 */     userRoleList.remove(UserRoleEnum.REVIEWER);
/* 103 */     model.addAttribute("userTypeList", UserTypeEnum.values());
/* 104 */     model.addAttribute("userRoleList", userRoleList);
/* 105 */     model.addAttribute("userStatusList", UserStatusEnum.values());
/* 106 */     model.addAttribute("userStatus", UserStatusEnum.FORBIDDEN.getValue());
/* 107 */     model.addAttribute("remotFundApp", this.remotFundApp);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.USER_R_ACCOUNT_QUERY})
/*     */   @RequestMapping(value={"/user/info"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void userAccountView(@ModelAttribute("userAccount") UserAccount userAccount, @ModelAttribute("userLevel") UserLevel userLevel, Model model)
/*     */   {
/* 123 */     userAccount = this.userAccountService.getUserByAccount(userAccount.getAccount());
/* 124 */     userLevel = this.userAccountService.getUserLevelByUserAccount(userAccount.getAccount());
/* 125 */     FundAccountMsg fundAccountMsg = this.fundQueryService.queryFundAccountMsg(null, userAccount
/* 126 */       .getAccount());
/* 127 */     model.addAttribute("userAccount", userAccount);
/* 128 */     model.addAttribute("userLevel", userLevel);
/* 129 */     model.addAttribute("fundAccountMsg", fundAccountMsg);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.USER_U_PASSWORD})
/*     */   @RequestMapping({"/user/password/reset"})
/*     */   public void userPasswordReset(@RequestParam("userAccount") String userAccount, @RequestParam("passwordType") String passwordType, UserAgent userAgent, ModelMap model)
/*     */   {
/* 145 */     UserResetPWDResult result = this.userAccountService.resetUserPwd(userAccount, userAgent
/* 146 */       .getAccount(), passwordType);
/* 147 */     if ((result != null) && (result.correct())) {
/* 148 */       model.addAttribute("password", result.getNewPassword());
/*     */     }
/* 150 */     setResult(model, result);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.USER_U_STATUS})
/*     */   @RequestMapping(value={"/user/changeStatus"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @ResponseBody
/*     */   public int userStatusChange(@ModelAttribute("userAccount") UserAccount userAccount, Model model)
/*     */   {
/* 166 */     int number = this.userAccountService.changeUserStatus(userAccount);
/* 167 */     return number;
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.USER_R_CREDIT})
/*     */   @RequestMapping(value={"/user/credit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void userCreditView(@RequestParam("userAccount") String userAccount, Model model)
/*     */   {
/* 181 */     UserCreditInfo userCredit = this.userAccountService.getUserCreditByUserAccount(userAccount);
/* 182 */     model.addAttribute("userCredit", userCredit);
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/fund/openAccountMock"})
/*     */   public String openAccountMock(Model model, @RequestParam("fundAccount") String fundAccount, @RequestParam("bankNo") String bankNo, @RequestParam("bankAccount") String bankAccount, @RequestParam("idKind") String idKind, @RequestParam("idNo") String idNo)
/*     */     throws Exception
/*     */   {
/* 196 */     AccountRequest request = new AccountRequest();
/* 197 */     request.setFundAccount(fundAccount);
/* 198 */     request.setBankNo(bankNo);
/* 199 */     request.setBankAccount(bankAccount);
/* 200 */     request.setIdKind(idKind);
/* 201 */     request.setIdNo(idNo);
/*     */ 
/* 203 */     request.setBankBranch("10000000");
/* 204 */     request.setBranchNo("100000");
/* 205 */     request.setBankAccountType("1");
/* 206 */     request.setMoneyType("CNY");
/* 207 */     request.setMemo("开户");
/* 208 */     request.setOperator("current user");
/* 209 */     request.setCountry("CHN");
/*     */ 
/* 211 */     FundOperateResult result = this.remoteFundService.createFundAccount(request);
/*     */ 
/* 213 */     if (result.isError()) {
/* 214 */       this.log.error(fundAccount + "激活失败！" + result.getErrorInfo());
/* 215 */       String msg = "激活失败！" + result.getErrorInfo();
/* 216 */       if (EnumUserResultErrors.PARAMETER_ERROR.getValue()==Integer.valueOf(result.getErrorNO())) {
/* 217 */         msg = msg + "，请确认会员银行及银行卡号是否填写完整";
/*     */       }
/* 219 */       model.addAttribute("message", msg);
/* 220 */       return "error";
/*     */     }
/* 222 */     model.addAttribute("url", "/user/list");
/* 223 */     return "success";
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/index"})
/*     */   public void initIndex(Model model)
/*     */   {
/* 254 */     this.userAccountService.initIssueTodo(model);
/*     */   }
/*     */ 
/*     */   private void initeRegPage(ModelMap model)
/*     */   {
/* 262 */     EnumUserType[] userTypes = EnumUserType.values();
/* 263 */     EnumPersonalCertificateType[] pecertificateTypes = EnumPersonalCertificateType.values();
/* 264 */     EnumEnterpiseCertificateType[] enCertificateTypes = EnumEnterpiseCertificateType.values();
/* 265 */     EnumBank[] banks = EnumBank.values();
/* 266 */     model.addAttribute("userTypes", userTypes);
/* 267 */     model.addAttribute("peCertificateTypes", pecertificateTypes);
/* 268 */     model.addAttribute("enCertificateTypes", enCertificateTypes);
/* 269 */     model.addAttribute("banks", banks);
/* 270 */     List _userRoleList = Arrays.asList(UserRoleEnum.values());
/* 271 */     List userRoleList = new ArrayList();
/* 272 */     userRoleList.addAll(_userRoleList);
/* 273 */     userRoleList.remove(UserRoleEnum.AUCTIONEER);
/* 274 */     userRoleList.remove(UserRoleEnum.REVIEWER);
/* 275 */     model.addAttribute("rolesList", userRoleList);
/*     */   }
/*     */ 
/*     */   private void initeRegPage2(ModelMap model)
/*     */   {
/* 283 */     EnumUserType[] userTypes = EnumUserType.values();
/* 284 */     EnumPersonalCertificateType[] pecertificateTypes = EnumPersonalCertificateType.values();
/* 285 */     EnumEnterpiseCertificateType[] enCertificateTypes = EnumEnterpiseCertificateType.values();
/* 286 */     model.addAttribute("userTypes", userTypes);
/* 287 */     model.addAttribute("peCertificateTypes", pecertificateTypes);
/* 288 */     model.addAttribute("enCertificateTypes", enCertificateTypes);
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"/user/add"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String userAdd(@ModelAttribute("userAccount") UserAccount userAccount, ModelMap model)
/*     */   {
/* 297 */     initeRegPage(model);
/* 298 */     return "/user/add";
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"/user/add"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String register(@ModelAttribute("userAccount") UserAccount userAccount, BindingResult result, ModelMap model)
/*     */   {
/* 309 */     this.userAccountValidator.validate(userAccount, result);
/* 310 */     if (result.hasErrors()) {
/* 311 */       initeRegPage(model);
/* 312 */       return "/user/add";
/*     */     }
/*     */ 
/* 315 */     UserServiceResult regResult = this.userAccountService.userAdd(userAccount);
/* 316 */     if (regResult.error()) {
/* 317 */       model.put("message", regResult.getErrorInfo());
/* 318 */       return error(model);
/*     */     }
/* 320 */     model.put("url", "/user/list.htm");
/* 321 */     return success();
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.AUCTIONEER_C_ADD})
/*     */   @RequestMapping(value={"/user/auctioneer"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String auctioneerAdd(@ModelAttribute("userAccount") UserAccount userAccount, ModelMap model)
/*     */   {
/* 335 */     initeRegPage2(model);
/* 336 */     return "/user/auctioneer";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.AUCTIONEER_C_ADD})
/*     */   @RequestMapping(value={"/user/auctioneer"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String auctioneer(@ModelAttribute("userAccount") UserAccount userAccount, BindingResult result, ModelMap model)
/*     */   {
/* 348 */     this.userAccountValidator.validate(userAccount, result);
/* 349 */     if (result.hasErrors()) {
/* 350 */       initeRegPage2(model);
/* 351 */       return "/user/auctioneer";
/*     */     }
/* 353 */     userAccount.setUserClass(UserRoleEnum.AUCTIONEER.getValue());
/* 354 */     UserServiceResult regResult = this.userAccountService.userAuctioneer(userAccount);
/* 355 */     if (regResult.error()) {
/* 356 */       model.put("message", regResult.getErrorInfo());
/* 357 */       return error(model);
/*     */     }
/* 359 */     model.put("url", "/user/auctioneer/list");
/* 360 */     return success(model);
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/user/dialog"})
/*     */   public void queryUserAccounts(@ModelAttribute("query") UserAccountQuery query, @RequestParam("isRadio") String isRadio, @RequestParam(value="roleName", required=false, defaultValue="") String roleName, Model model)
/*     */     throws Exception
/*     */   {
/* 379 */     if (query != null) {
/* 380 */       if (StringUtil.isNotEmpty(query.getAccount())) {
/* 381 */         query.setAccount(query.getAccount().trim());
/*     */       }
/* 383 */       if (StringUtil.isNotEmpty(query.getName())) {
/* 384 */         query.setName(query.getName().trim());
/*     */       }
/* 386 */       if (StringUtil.isNotEmpty(query.getFundAccount())) {
/* 387 */         query.setFundAccount(query.getFundAccount().trim());
/*     */       }
/*     */     }
/* 390 */     if (StringUtil.isNotEmpty(roleName)) {
/* 391 */       query.setUserRole(roleName);
/*     */     }
/* 393 */     List roleList = new ArrayList();
/* 394 */     roleList.add(UserRoleEnum.COMMON.getValue());
/* 395 */     roleList.add(UserRoleEnum.MIDDLE.getValue());
/* 396 */     roleList.add(UserRoleEnum.HIGH.getValue());
/* 397 */     roleList.add(UserRoleEnum.AUCTIONEER.getValue());
/* 398 */     roleList.add(UserRoleEnum.REVIEWER.getValue());
/* 399 */     query.setRoleList(roleList);
/* 400 */     query.setStatus(EnumUserStatus.Normal.getValue());
/* 401 */     this.userAccountService.getUserAccountList(query);
/* 402 */     model.addAttribute("userTypeList", UserTypeEnum.values());
/* 403 */     model.addAttribute("isRadio", isRadio);
/* 404 */     model.addAttribute("roleName", roleName);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.REVIEWER_C_ADD})
/*     */   @RequestMapping(value={"/user/addReviewer"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String addReviewer(@ModelAttribute("userAccount") UserAccount userAccount, ModelMap model)
/*     */   {
/* 416 */     EnumPersonalCertificateType[] pecertificateTypes = EnumPersonalCertificateType.values();
/* 417 */     model.addAttribute("peCertificateTypes", pecertificateTypes);
/* 418 */     return "/user/addReviewer";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.REVIEWER_C_ADD})
/*     */   @RequestMapping(value={"/user/addReviewer"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String addReviewer(@ModelAttribute("userAccount") UserAccount userAccount, BindingResult result, ModelMap model)
/*     */   {
/* 429 */     this.userAccountValidator.validate(userAccount, result);
/* 430 */     if (result.hasErrors()) {
/* 431 */       EnumPersonalCertificateType[] pecertificateTypes = EnumPersonalCertificateType.values();
/* 432 */       List<UserRole> roleList = this.userAccountService.getRoleList();
/* 433 */       UserRole reviewerRole = null;
/* 434 */       for (UserRole userRole : roleList) {
/* 435 */         if ("reviewer".equals(userRole.getName())) {
/* 436 */           reviewerRole = userRole;
/*     */         }
/*     */       }
/* 439 */       roleList.clear();
/* 440 */       roleList.add(reviewerRole);
/* 441 */       model.addAttribute("rolesList", roleList);
/* 442 */       model.addAttribute("peCertificateTypes", pecertificateTypes);
/* 443 */       return "/user/addReviewer";
/*     */     }
/* 445 */     userAccount.setUserClass(UserRoleEnum.REVIEWER.getValue());
/* 446 */     UserServiceResult regResult = this.userAccountService.addReviewer(userAccount);
/* 447 */     if (regResult.error()) {
/* 448 */       model.put("message", regResult.getErrorInfo());
/* 449 */       return error(model);
/*     */     }
/* 451 */     model.put("url", "/user/reviewer/list");
/* 452 */     return success(model);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.AUCTIONEER_QUERY_R_LIST})
/*     */   @RequestMapping({"/user/auctioneer/list"})
/*     */   public void auctioneerList(@ModelAttribute("query") UserAccountQuery query, Model model)
/*     */   {
/* 466 */     List roleList = new ArrayList();
/* 467 */     roleList.add(UserRoleEnum.AUCTIONEER.getValue());
/* 468 */     query.setRoleList(roleList);
/* 469 */     initListParamer(model);
/* 470 */     this.userAccountService.getUserAccountList(query);
/* 471 */     model.addAttribute("userTypeList", UserTypeEnum.values());
/* 472 */     model.addAttribute("userStatus", UserStatusEnum.FORBIDDEN.getValue());
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.AUCTIONEER_R_INFO})
/*     */   @RequestMapping(value={"/user/auctioneer/info"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void auctioneerView(@ModelAttribute("userAccount") UserAccount userAccount, Model model)
/*     */   {
/* 486 */     userAccount = this.userAccountService.getUserByAccount(userAccount.getAccount());
/* 487 */     model.addAttribute("userAccount", userAccount);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.AUCTIONEER_U_PASSWORD_CHANGE})
/*     */   @RequestMapping({"/auctioneer/password/reset"})
/*     */   public String auctioneerPasswordReset(@RequestParam("userAccount") String userAccount, UserAgent userAgent, ModelMap model)
/*     */   {
/* 503 */     UserResetPWDResult result = this.userAccountService.resetUserPwd(userAccount, userAgent
/* 504 */       .getAccount(), EnumPasswordType.SYSTEM.getValue());
/* 505 */     if ((result != null) && (result.correct())) {
/* 506 */       model.addAttribute("password", result.getNewPassword());
/*     */     }
/* 508 */     setResult(model, result);
/* 509 */     return "user/password/reset";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.AUCTIONEER_U_STATUS_CHANGE})
/*     */   @RequestMapping(value={"/auctioneer/changeStatus"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @ResponseBody
/*     */   public int auctioneerStatusChange(@ModelAttribute("userAccount") UserAccount userAccount, Model model)
/*     */   {
/* 525 */     int number = this.userAccountService.changeUserStatus(userAccount);
/* 526 */     return number;
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.REVIEWER_QUERY_R_LIST})
/*     */   @RequestMapping({"/user/reviewer/list"})
/*     */   public void reviewerList(@ModelAttribute("query") UserAccountQuery query, Model model)
/*     */   {
/* 540 */     List roleList = new ArrayList();
/* 541 */     roleList.add(UserRoleEnum.REVIEWER.getValue());
/* 542 */     query.setRoleList(roleList);
/* 543 */     initListParamer(model);
/* 544 */     this.userAccountService.getUserAccountList(query);
/* 545 */     model.addAttribute("userTypeList", UserTypeEnum.values());
/* 546 */     model.addAttribute("userStatus", UserStatusEnum.FORBIDDEN.getValue());
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.REVIEWER_R_INFO})
/*     */   @RequestMapping(value={"/user/reviewer/info"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void reviewerView(@ModelAttribute("userAccount") UserAccount userAccount, Model model)
/*     */   {
/* 560 */     userAccount = this.userAccountService.getUserByAccount(userAccount.getAccount());
/* 561 */     model.addAttribute("userAccount", userAccount);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.REVIEWER_U_PASSWORD_CHANGE})
/*     */   @RequestMapping({"/reviewer/password/reset"})
/*     */   public String reviewerPasswordReset(@RequestParam("userAccount") String userAccount, UserAgent userAgent, ModelMap model)
/*     */   {
/* 577 */     UserResetPWDResult result = this.userAccountService.resetUserPwd(userAccount, userAgent
/* 578 */       .getAccount(), EnumPasswordType.SYSTEM.getValue());
/* 579 */     if ((result != null) && (result.correct())) {
/* 580 */       model.addAttribute("password", result.getNewPassword());
/*     */     }
/* 582 */     setResult(model, result);
/* 583 */     return "user/password/reset";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.REVIEWER_U_STATUS_CHANGE})
/*     */   @RequestMapping(value={"/reviewer/changeStatus"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @ResponseBody
/*     */   public int reviewerStatusChange(@ModelAttribute("userAccount") UserAccount userAccount, Model model)
/*     */   {
/* 599 */     int number = this.userAccountService.changeUserStatus(userAccount);
/* 600 */     return number;
/*     */   }
/*     */ 
/*     */   public void initListParamer(Model model)
/*     */   {
/* 611 */     List _list = Arrays.asList(UserStatusEnum.values());
/* 612 */     List list = new ArrayList();
/* 613 */     list.addAll(_list);
/* 614 */     list.remove(UserStatusEnum.UNFUND);
/* 615 */     list.remove(UserStatusEnum.NOACTIVED);
/* 616 */     model.addAttribute("userStatusList", list);
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.action.user.UserAccountAction
 * JD-Core Version:    0.6.0
 */