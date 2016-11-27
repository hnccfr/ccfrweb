/*     */ package com.hundsun.network.gates.fengshan.web.action.funds;
/*     */ 
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.query.FundDetailQuery;
/*     */ import com.hundsun.network.gates.fengshan.biz.service.funds.CashTradeAccountService;
/*     */ import com.hundsun.network.gates.fengshan.web.action.BaseAction;
/*     */ import com.hundsun.network.gates.luosi.biz.domain.UserAgent;
/*     */ import com.hundsun.network.gates.luosi.biz.security.SystemAccess;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumBank;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTransCode;
/*     */ import com.hundsun.network.gates.luosi.common.page.SimplePage;
/*     */ import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.dto.FundQueryDTO;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.request.FundQueryPageRequest;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.request.FundQueryRequest;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.request.TransRequest;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.result.FundInOutQueryResult;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.result.FundOperateResult;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.result.FundQueryResult;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.service.RemoteFundQueryService;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.service.RemoteFundService;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.UserAccountDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumUserStatus;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.UserLoginRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.UserResetPasswordRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.UserServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteUserService;
/*     */ import java.text.DecimalFormat;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.web.bind.annotation.ModelAttribute;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.servlet.ModelAndView;
/*     */ 
/*     */ @Controller
/*     */ public class CashTradeAccountAction extends BaseAction
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private RemoteFundService remoteFundService;
/*     */ 
/*     */   @Autowired
/*     */   private RemoteFundQueryService remoteFundQueryService;
/*     */ 
/*     */   @Autowired
/*     */   private RemoteUserService remoteUserService;
/*     */ 
/*     */   @Autowired
/*     */   private CashTradeAccountService cashTradeAccountService;
/*     */ 
/*     */   @RequestMapping(value={"/contain/fundmsg"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String selectFundInfo(UserAgent userAgent, Model model)
/*     */   {
/*     */     try
/*     */     {
/*  80 */       String fundsAccount = userAgent.getFundAccount();
/*     */ 
/*  82 */       UserLoginRequest uRequest = new UserLoginRequest();
/*  83 */       uRequest.setUserAccount(userAgent.getAccount());
/*  84 */       UserServiceResult ur = this.remoteUserService.getUserMsgByAccount(uRequest);
/*  85 */       if (ur.correct()) {
/*  86 */         UserAccountDTO dto = ur.getUserAccountDTO();
/*  87 */         if (!dto.getStatus().equals(EnumUserStatus.Normal.getValue())) {
/*  88 */           model.addAttribute("message", "资金账号未激活或已被禁用！");
/*  89 */           return "/contain/fundmsg";
/*     */         }
/*     */       }
/*     */ 
/*  93 */       FundQueryRequest request = new FundQueryRequest();
/*  94 */       request.setFundAccount(fundsAccount);
/*  95 */       FundQueryResult result = this.remoteFundQueryService.useBalanceCalculate(request);
/*  96 */       if (result.isError()) {
/*  97 */         model.addAttribute("message", "获取资金账户失败！" + result.getErrorInfo());
/*  98 */         return "/contain/fundmsg";
/*     */       }
/* 100 */       DecimalFormat df = new DecimalFormat("0.00");
/* 101 */       model.addAttribute("allMoney", df.format(result.getAmount().longValue() / 100.0D));
/* 102 */       model.addAttribute("freeMoney", df.format(result.getUsedBalance().longValue() / 100.0D));
/* 103 */       model.addAttribute("frozenMoney", df.format(result.getFreezeAmount().longValue() / 100.0D));
/* 104 */       return "/contain/fundmsg";
/*     */     }
/*     */     catch (Exception e) {
/* 107 */       this.log.error("获取资金账户信息失败！");
/* 108 */       e.printStackTrace();
/* 109 */       model.addAttribute("message", "服务器出现异常！");
/* 110 */     }return "/contain/fundmsg";
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"/funds/info"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String selectUserCashInfo(UserAgent userAgent, Model model)
/*     */   {
/* 124 */     String fundsAccount = userAgent.getFundAccount();
/*     */ 
/* 126 */     UserLoginRequest uRequest = new UserLoginRequest();
/* 127 */     uRequest.setUserAccount(userAgent.getAccount());
/* 128 */     UserServiceResult ur = this.remoteUserService.getUserMsgByAccount(uRequest);
/* 129 */     if (ur.correct()) {
/* 130 */       UserAccountDTO dto = ur.getUserAccountDTO();
/* 131 */       if (!dto.getStatus().equals(EnumUserStatus.Normal.getValue())) {
/* 132 */         model.addAttribute("message", "对不起，资金账号未激活或已被禁用！");
/* 133 */         return "error";
/*     */       }
/* 135 */       model.addAttribute("fundsAccount", fundsAccount);
/* 136 */       model.addAttribute("fundsStatus", EnumUserStatus.indexByValue(dto.getStatus()).getName());
/* 137 */       model.addAttribute("bankName", EnumBank.getByBankNo(dto.getBank()) == null ? dto.getBank() : EnumBank.getByBankNo(dto.getBank()).getDescription());
/* 138 */       model.addAttribute("bankNum", dto.getBankCard());
/*     */     }
/*     */ 
/* 142 */     FundQueryRequest request = new FundQueryRequest();
/* 143 */     request.setFundAccount(fundsAccount);
/* 144 */     FundQueryResult result = this.remoteFundQueryService.useBalanceCalculate(request);
/* 145 */     if (result.isError()) {
/* 146 */       model.addAttribute("message", "获取资金账户失败！" + result.getErrorInfo());
/* 147 */       return "error";
/*     */     }
/* 149 */     DecimalFormat df = new DecimalFormat("0.00");
/* 150 */     model.addAttribute("allMoney", df.format(result.getAmount().longValue() / 100.0D));
/* 151 */     model.addAttribute("freeMoney", df.format(result.getUsedBalance().longValue() / 100.0D));
/* 152 */     model.addAttribute("frozenMoney", df.format(result.getFreezeAmount().longValue() / 100.0D));
/* 153 */     return "/funds/info";
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"/funds/report"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String selectUserCashReportPage(UserAgent userAgent, Model model)
/*     */   {
/* 169 */     UserLoginRequest uRequest = new UserLoginRequest();
/* 170 */     uRequest.setUserAccount(userAgent.getAccount());
/* 171 */     UserServiceResult ur = this.remoteUserService.getUserMsgByAccount(uRequest);
/* 172 */     if (ur.correct()) {
/* 173 */       UserAccountDTO dto = ur.getUserAccountDTO();
/* 174 */       if (!dto.getStatus().equals(EnumUserStatus.Normal.getValue())) {
/* 175 */         model.addAttribute("message", "对不起，资金账号未激活或已被禁用！");
/* 176 */         return "error";
/*     */       }
/* 178 */       model.addAttribute("fundsAccount", userAgent.getFundAccount());
/* 179 */       model.addAttribute("bankName", EnumBank.getByBankNo(dto.getBank()) == null ? dto.getBank() : EnumBank.getByBankNo(dto.getBank()).getDescription());
/* 180 */       model.addAttribute("bankNum", dto.getBankCard());
/*     */     }
/*     */ 
/* 183 */     return "/funds/report";
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"/funds/report"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String selectUserCashReportAction(@RequestParam("tradeDate") String tradeDate, UserAgent userAgent, Model model)
/*     */   {
/* 197 */     String fundsAccount = userAgent.getFundAccount();
/* 198 */     UserLoginRequest uRequest = new UserLoginRequest();
/* 199 */     uRequest.setUserAccount(userAgent.getAccount());
/* 200 */     UserServiceResult ur = this.remoteUserService.getUserMsgByAccount(uRequest);
/* 201 */     if (ur.correct()) {
/* 202 */       UserAccountDTO dto = ur.getUserAccountDTO();
/* 203 */       if (!dto.getStatus().equals(EnumUserStatus.Normal.getValue())) {
/* 204 */         model.addAttribute("message", "对不起，资金账号未激活或已被禁用！");
/* 205 */         return "error";
/*     */       }
/* 207 */       model.addAttribute("fundsAccount", fundsAccount);
/* 208 */       model.addAttribute("bankName", EnumBank.getByBankNo(dto.getBank()) == null ? dto.getBank() : EnumBank.getByBankNo(dto.getBank()).getDescription());
/* 209 */       model.addAttribute("bankNum", dto.getBankCard());
/*     */     }
/*     */ 
/* 213 */     FundQueryRequest request = new FundQueryRequest();
/* 214 */     request.setFundAccount(fundsAccount);
/* 215 */     String tradeDateF = tradeDate.replace("-", "");
/* 216 */     request.setTradeDate(tradeDateF);
/* 217 */     FundQueryResult result = new FundQueryResult();
/* 218 */     result = this.remoteFundQueryService.queryFundByTrader(request);
/* 219 */     if (result.isError()) {
/* 220 */       model.addAttribute("message", "获取信息失败！" + result.getErrorInfo());
/* 221 */       return "error";
/*     */     }
/* 223 */     ReportMsg reportMsg = new ReportMsg();
/* 224 */     DecimalFormat df = new DecimalFormat("0.00");
/*     */ 
/* 226 */     List listFund = result.getFundRecords();
/*     */ 
/* 228 */     if ((listFund != null) && (listFund.size() > 0)) {
/* 229 */       for (int i = 0; i < listFund.size(); i++) {
/* 230 */         FundQueryDTO dto = (FundQueryDTO)listFund.get(i);
/* 231 */         if (dto.getTradeDate().equals(tradeDateF)) {
/* 232 */           reportMsg.setCurrFundDtoBeginAmount(dto.getBeginAmount() != null ? df.format(dto.getBeginAmount().longValue() / 100.0D) + "元" : "0元");
/* 233 */           reportMsg.setCurrFundDtoCommissionAmount(dto.getCommissionAmount() != null ? df.format(dto.getCommissionAmount().longValue() / 100.0D) + "元" : "0元");
/* 234 */           reportMsg.setCurrFundDtoCurrAmount(dto.getCurrAmount() != null ? df.format(dto.getCurrAmount().longValue() / 100.0D) + "元" : "0元");
/* 235 */           reportMsg.setCurrFundDtoFreezeTotal(dto.getFreezeTotal() != null ? df.format(dto.getFreezeTotal().longValue() / 100.0D) + "元" : "0元");
/* 236 */           reportMsg.setCurrFundDtoFundinAmount(dto.getFundinAmount() != null ? df.format(dto.getFundinAmount().longValue() / 100.0D) + "元" : "0元");
/* 237 */           reportMsg.setCurrFundDtoFundoutAmount(dto.getFundoutAmount() != null ? df.format(dto.getFundoutAmount().longValue() / 100.0D) + "元" : "0元");
/* 238 */           reportMsg.setCurrFundDtoGoodsFundin(dto.getGoodsFundin() != null ? df.format(dto.getGoodsFundin().longValue() / 100.0D) + "元" : "0元");
/* 239 */           reportMsg.setCurrFundDtoGoodsFundout(dto.getGoodsFundout() != null ? df.format(dto.getGoodsFundout().longValue() / 100.0D) + "元" : "0元");
/* 240 */           reportMsg.setCurrFundDtoPenaltyFundin(dto.getPenaltyFundin() != null ? df.format(dto.getPenaltyFundin().longValue() / 100.0D) + "元" : "0元");
/* 241 */           reportMsg.setCurrFundDtoPenaltyFundout(dto.getPenaltyFundout() != null ? df.format(dto.getPenaltyFundout().longValue() / 100.0D) + "元" : "0元");
/* 242 */           reportMsg.setCurrFundDtoUseBalance(dto.getUseBalance() != null ? df.format(dto.getUseBalance().longValue() / 100.0D) + "元" : "0元");
/*     */         }
/*     */         else {
/* 245 */           reportMsg.setBeforFundDtoBeginAmount(dto.getBeginAmount() != null ? df.format(dto.getBeginAmount().longValue() / 100.0D) + "元" : "0元");
/* 246 */           reportMsg.setBeforFundDtoCurrAmount(dto.getCurrAmount() != null ? df.format(dto.getCurrAmount().longValue() / 100.0D) + "元" : "0元");
/* 247 */           reportMsg.setBeforFundDtoFreezeTotal(dto.getFreezeTotal() != null ? df.format(dto.getFreezeTotal().longValue() / 100.0D) + "元" : "0元");
/* 248 */           reportMsg.setBeforFundDtoUseBalance(dto.getUseBalance() != null ? df.format(dto.getUseBalance().longValue() / 100.0D) + "元" : "0元");
/*     */         }
/*     */       }
/*     */     }
/* 252 */     model.addAttribute("reportMsg", reportMsg);
/* 253 */     model.addAttribute("tradeDate", tradeDate);
/* 254 */     return "/funds/report";
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/funds/detail"})
/*     */   public String selectUserCashDetailAction(@ModelAttribute("query") FundDetailQuery query, UserAgent userAgent, Model model)
/*     */     throws Exception
/*     */   {
/* 270 */     UserLoginRequest uRequest = new UserLoginRequest();
/* 271 */     uRequest.setUserAccount(userAgent.getAccount());
/* 272 */     UserServiceResult ur = this.remoteUserService.getUserMsgByAccount(uRequest);
/* 273 */     if (ur.correct()) {
/* 274 */       UserAccountDTO dto = ur.getUserAccountDTO();
/* 275 */       if (!dto.getStatus().equals(EnumUserStatus.Normal.getValue())) {
/* 276 */         model.addAttribute("message", "对不起，资金账号未激活或已被禁用！");
/* 277 */         return "error";
/*     */       }
/* 279 */       model.addAttribute("fundsAccount", userAgent.getFundAccount());
/* 280 */       model.addAttribute("bankName", EnumBank.getByBankNo(dto.getBank()) == null ? dto.getBank() : EnumBank.getByBankNo(dto.getBank()).getDescription());
/* 281 */       model.addAttribute("bankNum", dto.getBankCard());
/*     */     }
/*     */ 
/* 285 */     if ((query.getStartDate() == null) && (query.getEndDate() == null)) {
/* 286 */       return "/funds/detail";
/*     */     }
/*     */ 
/* 289 */     FundQueryPageRequest request = new FundQueryPageRequest();
/* 290 */     request.setFundAccount(userAgent.getFundAccount());
/*     */ 
/* 292 */     SimpleDateFormat simFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 293 */     Date sDate = simFormat.parse(query.getStartDate());
/* 294 */     Date eDate = simFormat.parse(query.getEndDate());
/* 295 */     request.setStartDate(sDate);
/* 296 */     request.setEndDate(eDate);
/* 297 */     request.setPageNo(Integer.valueOf(query.getPageNo()));
/* 298 */     request.setPageSize(Integer.valueOf(query.getPageSize()));
/*     */ 
/* 300 */     FundInOutQueryResult result = this.remoteFundQueryService.fundInOutQuery(request);
/* 301 */     if (result.isError()) {
/* 302 */       model.addAttribute("message", "获取信息失败！" + result.getErrorInfo());
/* 303 */       return "error";
/*     */     }
/* 305 */     int totalCount = result.getFundCount().intValue();
/*     */ 
/* 307 */     SimplePage _page = query;
/*     */ 
/* 309 */     if (totalCount > 0) {
/* 310 */       _page.setTotalCount(totalCount);
/* 311 */       _page.setData(result.getFundRecords());
/*     */     } else {
/* 313 */       _page.setData(new ArrayList());
/*     */     }
/* 315 */     model.addAttribute("EnumTransCode", EnumTransCode.toMap());
/* 316 */     return "/funds/detail";
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_U_FUND_IN})
/*     */   @RequestMapping(value={"/funds/in"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String inCashPage(UserAgent userAgent, Model model)
/*     */   {
/* 333 */     UserLoginRequest uRequest = new UserLoginRequest();
/* 334 */     uRequest.setUserAccount(userAgent.getAccount());
/* 335 */     UserServiceResult ur = this.remoteUserService.getUserMsgByAccount(uRequest);
/* 336 */     if (ur.correct()) {
/* 337 */       UserAccountDTO dto = ur.getUserAccountDTO();
/* 338 */       if (!dto.getStatus().equals(EnumUserStatus.Normal.getValue())) {
/* 339 */         model.addAttribute("message", "对不起，资金账号未激活或已被禁用！");
/* 340 */         return "error";
/*     */       }
/*     */     }
/*     */ 
/* 344 */     return "/funds/in";
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_U_FUND_IN})
/*     */   @RequestMapping(value={"/funds/in"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public ModelAndView inCashAction(@RequestParam("money") Double money, UserAgent userAgent, Model model)
/*     */   {
/* 359 */     String fundsAccount = userAgent.getFundAccount();
/* 360 */     String account = userAgent.getAccount();
/*     */ 
/* 362 */     long moneyF = new Double(money.doubleValue() * 100.0D).longValue();
/* 363 */     TransRequest request = new TransRequest();
/* 364 */     request.setFundAccount(fundsAccount);
/* 365 */     request.setAmount(Long.valueOf(moneyF));
/* 366 */     request.setOperator(account);
/* 367 */     FundOperateResult result = this.remoteFundService.fundInByExchange(request);
/* 368 */     if (null == result) {
/* 369 */       this.log.error("入金时，调用资金账务接口失败。");
/* 370 */       model.addAttribute("message", "入金时，调用资金账务接口失败。");
/* 371 */       return new ModelAndView("forward:/error.htm", model.asMap());
/*     */     }
/* 373 */     if (result.isError()) {
/* 374 */       this.log.error("入金时，调用资金账务接口失败.原因：" + result.getErrorNO() + "," + result.getErrorInfo());
/* 375 */       model.addAttribute("message", "操作失败。" + result.getErrorInfo());
/* 376 */       return new ModelAndView("forward:/error.htm", model.asMap());
/*     */     }
/* 378 */     return new ModelAndView("forward:/success.htm", model.asMap());
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_U_FUND_OUT})
/*     */   @RequestMapping(value={"/funds/out"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String outCashPage(UserAgent userAgent, Model model)
/*     */   {
/* 394 */     UserLoginRequest uRequest = new UserLoginRequest();
/* 395 */     uRequest.setUserAccount(userAgent.getAccount());
/* 396 */     UserServiceResult ur = this.remoteUserService.getUserMsgByAccount(uRequest);
/* 397 */     if (ur.correct()) {
/* 398 */       UserAccountDTO dto = ur.getUserAccountDTO();
/* 399 */       if (!dto.getStatus().equals(EnumUserStatus.Normal.getValue())) {
/* 400 */         model.addAttribute("message", "对不起，资金账号未激活或已被禁用！");
/* 401 */         return "error";
/*     */       }
/*     */     }
/*     */ 
/* 405 */     return "/funds/out";
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_U_FUND_OUT})
/*     */   @RequestMapping(value={"/funds/out"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public ModelAndView outCashAction(@RequestParam("money") Double money, UserAgent userAgent, Model model)
/*     */   {
/* 419 */     String fundsAccount = userAgent.getFundAccount();
/*     */ 
/* 421 */     long moneyF = new Double(money.doubleValue() * 100.0D).longValue();
/* 422 */     TransRequest request = new TransRequest();
/* 423 */     request.setFundAccount(fundsAccount);
/* 424 */     request.setAmount(Long.valueOf(moneyF));
/* 425 */     request.setOperator(userAgent.getAccount());
/* 426 */     FundOperateResult result = this.remoteFundService.fundOutByExchange(request);
/* 427 */     if (null == result) {
/* 428 */       model.addAttribute("message", "出金时，调用资金账务接口失败。");
/* 429 */       return new ModelAndView("forward:/error.htm", model.asMap());
/*     */     }
/* 431 */     if (result.isError()) {
/* 432 */       this.log.error("出金时，调用资金账务接口失败。原因：" + result.getErrorNO() + "," + result.getErrorInfo());
/* 433 */       model.addAttribute("message", "操作失败。" + result.getErrorInfo());
/* 434 */       return new ModelAndView("forward:/error.htm", model.asMap());
/*     */     }
/* 436 */     return new ModelAndView("forward:/success.htm", model.asMap());
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_U_FUND_PASSWORD_RESET})
/*     */   @RequestMapping(value={"/funds/passwordreset"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void initFundPwdChange(Model model)
/*     */   {
/* 451 */     model.addAttribute("message", "init");
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_U_FUND_PASSWORD_RESET})
/*     */   @RequestMapping(value={"/funds/passwordreset"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void fundPwdChange(UserAgent userAgent, @RequestParam("oldPassword") String oldPassword, @RequestParam("newPassword") String newPassword, Model model)
/*     */   {
/* 469 */     UserResetPasswordRequest request = new UserResetPasswordRequest();
/* 470 */     request.setAccount(userAgent.getAccount());
/* 471 */     request.setOldPassword(oldPassword);
/* 472 */     request.setNewPassword(newPassword);
/* 473 */     request.setOperator(userAgent.getAccount());
/* 474 */     ServiceResult result = this.cashTradeAccountService.changeFundPwd(request);
/* 475 */     if (result.error())
/* 476 */       model.addAttribute("message", result.getErrorInfo());
/*     */     else
/* 478 */       model.addAttribute("message", "success");
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.web.action.funds.CashTradeAccountAction
 * JD-Core Version:    0.6.0
 */