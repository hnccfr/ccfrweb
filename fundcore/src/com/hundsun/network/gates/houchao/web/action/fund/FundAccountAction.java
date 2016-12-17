/*     */ package com.hundsun.network.gates.houchao.web.action.fund;
/*     */ 
/*     */ import com.hundsun.network.gates.houchao.biz.dao.fund.TradeDayCurrentDAO;
/*     */ import com.hundsun.network.gates.houchao.biz.domain.acctrans.Cache;
/*     */ import com.hundsun.network.gates.houchao.biz.domain.fund.TradeDayCurrent;
/*     */ import com.hundsun.network.gates.houchao.biz.manager.pojo.DailyWorkEngine;
/*     */ import com.hundsun.network.gates.luosi.common.utils.DateUtil;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.request.AccountRequest;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.request.TransRequest;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.result.FundOperateResult;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.service.RemoteFundService;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.util.Date;
/*     */ import org.apache.commons.lang.time.DateUtils;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.web.bind.annotation.ModelAttribute;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ 
/*     */ public class FundAccountAction
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private RemoteFundService remoteFundService;
/*     */ 
/*     */   @Autowired
/*     */   private DailyWorkEngine dailyWork;
/*     */ 
/*     */   @Autowired
/*     */   private TradeDayCurrentDAO tradeDayCurrentDAO;
/*     */ 
/*     */   public String inFundTransPage(ModelMap model)
/*     */     throws Exception
/*     */   {
/*  56 */     AccountRequest transReq = new AccountRequest();
/*  57 */     model.put("transReq", transReq);
/*  58 */     return "fund/openAccountPage";
/*     */   }
/*     */ 
/*     */   public String outFundTransPage(ModelMap model)
/*     */     throws Exception
/*     */   {
/*  67 */     AccountRequest transReq = new AccountRequest();
/*  68 */     model.put("transReq", transReq);
/*  69 */     return "fund/closeAccountPage";
/*     */   }
/*     */ 
/*     */   public String bankFundOutPage(ModelMap model)
/*     */     throws Exception
/*     */   {
/*  78 */     TransRequest transReq = new TransRequest();
/*  79 */     model.put("transReq", transReq);
/*  80 */     return "fund/bankFundOutPage";
/*     */   }
/*     */ 
/*     */   public String bankFundInPage(ModelMap model)
/*     */     throws Exception
/*     */   {
/*  89 */     TransRequest transReq = new TransRequest();
/*  90 */     model.put("transReq", transReq);
/*  91 */     return "fund/bankFundInPage";
/*     */   }
/*     */ 
/*     */   public String inFundTrans(ModelMap model, @ModelAttribute("transReq") AccountRequest transReq)
/*     */     throws Exception
/*     */   {
/* 101 */     AccountRequest request = new AccountRequest();
/* 102 */     request.setFundAccount(transReq.getFundAccount());
/* 103 */     request.setBankNo(transReq.getBankNo());
/* 104 */     request.setBankBranch(transReq.getBankBranch());
/* 105 */     request.setBankAccountType(transReq.getBankAccountType());
/* 106 */     request.setBankAccount(transReq.getBankAccount());
/* 107 */     request.setMoneyType(transReq.getMoneyType());
/* 108 */     request.setMemo(transReq.getMemo());
/* 109 */     request.setOperator(transReq.getOperator());
/* 110 */     request.setTransDate(transReq.getTransDate());
/* 111 */     request.setCountry(transReq.getCountry());
/* 112 */     request.setClientId(transReq.getClientId());
/* 113 */     request.setIdKind(transReq.getIdKind());
/* 114 */     request.setIdNo(transReq.getIdNo());
/* 115 */     request.setBranchNo(transReq.getBranchNo());
/* 116 */     request.setPositionId(transReq.getClientId());
/* 117 */     FundOperateResult result = this.remoteFundService.createFundAccount(request);
/*     */ 
/* 119 */     boolean isSuccess = !result.isError();
/*     */ 
/* 121 */     if (isSuccess)
/* 122 */       model.put("message", transReq.getFundAccount() + " 开户成功！");
/*     */     else {
/* 124 */       model.put("message", transReq.getFundAccount() + " 开户失败 ，错误代码" + result.getErrorNO() + "，" + result.getErrorInfo());
/*     */     }
/*     */ 
/* 127 */     return result(isSuccess);
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"/fund/close_fund_trans"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String outFundTrans(ModelMap model, @ModelAttribute("transReq") AccountRequest transReq)
/*     */     throws Exception
/*     */   {
/* 137 */     AccountRequest request = new AccountRequest();
/* 138 */     request.setFundAccount(transReq.getFundAccount());
/* 139 */     request.setOperator(transReq.getOperator());
/* 140 */     request.setMemo(transReq.getMemo());
/* 141 */     request.setTransDate(transReq.getTransDate());
/*     */ 
/* 143 */     FundOperateResult result = this.remoteFundService.cancelFundAccount(request);
/* 144 */     boolean isSuccess = !result.isError();
/* 145 */     if (isSuccess)
/* 146 */       model.put("message", transReq.getFundAccount() + " 销户成功！");
/*     */     else {
/* 148 */       model.put("message", transReq.getFundAccount() + " 销户失败 ，错误代码" + result.getErrorNO() + "，" + result.getErrorInfo());
/*     */     }
/* 150 */     return result(isSuccess);
/*     */   }
/*     */ 
/*     */   protected String result(boolean result) {
/* 154 */     return result ? "success" : "error";
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"/fund/bank_fund_outtrans"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String bankFundOutTrans(ModelMap model, @ModelAttribute("transReq") TransRequest transReq)
/*     */     throws Exception
/*     */   {
/* 165 */     if ((null == transReq) || (StringUtil.isBlank(transReq.getFundAccount())) || (null == transReq.getAmount()) || (!StringUtil.isNumber(transReq.getAmount().toString())))
/*     */     {
/* 167 */       model.put("message", "请填写正确的信息，资金账号：" + transReq.getFundAccount() + "，金额：" + transReq.getAmount());
/* 168 */       return result(false);
/*     */     }
/* 170 */     transReq.setOperator("admin");
/* 171 */     transReq.setTransDate(DateUtil.convertDateToString("yyyyMMdd", new Date()));
/* 172 */     FundOperateResult result = this.remoteFundService.fundInAccount(transReq);
/* 173 */     boolean isSuccess = !result.isError();
/* 174 */     if (isSuccess)
/* 175 */       model.put("message", transReq.getFundAccount() + " 充值成功！");
/*     */     else {
/* 177 */       model.put("message", transReq.getFundAccount() + " 充值失败 ，错误代码" + result.getErrorNO() + "，" + result.getErrorInfo());
/*     */     }
/* 179 */     return result(isSuccess);
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"/fund/bank_fund_intrans"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String bankFundInTrans(ModelMap model, @ModelAttribute("transReq") TransRequest transReq)
/*     */     throws Exception
/*     */   {
/* 191 */     if ((null == transReq) || (StringUtil.isBlank(transReq.getFundAccount())) || (null == transReq.getAmount()) || (!StringUtil.isNumber(transReq.getAmount().toString())))
/*     */     {
/* 193 */       model.put("message", "请填写正确的信息，资金账号：" + transReq.getFundAccount() + "，金额：" + transReq.getAmount());
/* 194 */       return result(false);
/*     */     }
/* 196 */     transReq.setOperator("admin");
/* 197 */     transReq.setTransDate(DateUtil.convertDateToString("yyyyMMdd", new Date()));
/*     */ 
/* 199 */     FundOperateResult result = this.remoteFundService.fundOutAccount(transReq);
/* 200 */     boolean isSuccess = !result.isError();
/* 201 */     if (isSuccess)
/* 202 */       model.put("message", transReq.getFundAccount() + " 提现成功！");
/*     */     else {
/* 204 */       model.put("message", transReq.getFundAccount() + " 提现失败 ，错误代码" + result.getErrorNO() + "，" + result.getErrorInfo());
/*     */     }
/* 206 */     return result(isSuccess);
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/fund/current_trade_day"})
/*     */   public String currentTradeDay(ModelMap model)
/*     */     throws Exception
/*     */   {
/* 215 */     model.put("currentTradeDay", Cache.coreCurrentTradingDay);
/* 216 */     model.put("lastTradeDay", Cache.coreBeforeTradingDay);
/* 217 */     model.put("nextTradeDay", Cache.coreNextTradingDay);
/* 218 */     return "fund/tradeDayPage";
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/fund/change_current_trade_day"})
/*     */   public String changeCurrentTradeDay(ModelMap model)
/*     */     throws Exception
/*     */   {
/* 227 */     TradeDayCurrent tradeDayCurrent = new TradeDayCurrent();
/* 228 */     tradeDayCurrent.setLastTradeDay(DateUtils.addDays(new Date(), -1));
/* 229 */     tradeDayCurrent.setCurrentTradeDay(DateUtils.addDays(new Date(), 0));
/* 230 */     tradeDayCurrent.setNextTradeDay(DateUtils.addDays(new Date(), 1));
/* 231 */     this.tradeDayCurrentDAO.editTradeDayCurrent(tradeDayCurrent);
/* 232 */     return result(true);
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/fund/init_current_trade_day"})
/*     */   public String initCurrentTradeDay(ModelMap model)
/*     */     throws Exception
/*     */   {
/* 241 */     this.dailyWork.initTradeDay();
/* 242 */     return result(true);
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"/fund/openAccount"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   @ResponseBody
/*     */   public String openAccount(ModelMap model, @RequestParam("fundAccount") String fundAccount, @RequestParam("bankNo") String bankNo, @RequestParam("bankAccount") String bankAccount, @RequestParam("idKind") String idKind, @RequestParam("idNo") String idNo, @RequestParam("jsoncallback") String jsoncallback)
/*     */     throws Exception
/*     */   {
/* 260 */     AccountRequest request = new AccountRequest();
/* 261 */     request.setFundAccount(fundAccount);
/* 262 */     request.setBankNo(bankNo);
/* 263 */     request.setBankAccount(bankAccount);
/* 264 */     request.setIdKind(idKind);
/* 265 */     request.setIdNo(idNo);
/*     */ 
/* 267 */     request.setBankBranch("10000000");
/* 268 */     request.setBranchNo("100000");
/* 269 */     request.setBankAccountType("1");
/* 270 */     request.setMoneyType("CNY");
/* 271 */     request.setMemo("开户");
/* 272 */     request.setOperator("current user");
/* 273 */     request.setCountry("CHN");
/* 274 */     request.setClientId("66666666");
/* 275 */     request.setPositionId("66666666");
/* 276 */     FundOperateResult result = this.remoteFundService.createFundAccount(request);
/*     */ 
/* 278 */     boolean isSuccess = !result.isError();
/*     */ 
/* 280 */     String msg = "";
/* 281 */     if (isSuccess)
/* 282 */       msg = jsoncallback + "({\"success\":\"true\"})";
/*     */     else {
/* 284 */       msg = jsoncallback + "({\"success\":\"false\",\"msg\":\"异常码：" + result.getErrorInfo() + "\"})";
/*     */     }
/*     */ 
/* 287 */     return msg;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\houchao\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.houchao.web.action.fund.FundAccountAction
 * JD-Core Version:    0.6.0
 */