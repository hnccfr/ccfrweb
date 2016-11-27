/*     */ package com.hundsun.network.gates.genshan.web.action.fund;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.domain.fund.FundAccountMsg;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.fund.FundAccountReport;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.fund.FundSettlement;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.fund.query.FundAccountLogQuery;
/*     */ import com.hundsun.network.gates.genshan.biz.service.fund.FundQueryService;
/*     */ import com.hundsun.network.gates.genshan.common.UserAgent;
/*     */ import com.hundsun.network.gates.genshan.security.AdminAccess;
/*     */ import com.hundsun.network.gates.genshan.web.action.BaseAction;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTransCode;
/*     */ import com.hundsun.network.gates.luosi.common.utils.DateUtil;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.util.Date;
/*     */ import org.apache.commons.lang.time.DateUtils;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.web.bind.annotation.ModelAttribute;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ 
/*     */ @Controller
/*     */ public class FundQueryAction extends BaseAction
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private FundQueryService fundQueryService;
/*     */ 
/*     */   @RequestMapping({"/fund/queryFundSettlementInit"})
/*     */   public String queryFundSettlementInit(UserAgent userAgent, ModelMap model)
/*     */   {
/*  49 */     model.addAttribute("tradeDate", DateUtil.convertDateToString("yyyy-MM-dd", DateUtils.addDays(new Date(), -1)));
/*  50 */     model.addAttribute("initTradeDate", DateUtil.convertDateToString("yyyy-MM-dd", DateUtils.addDays(new Date(), -1)));
/*  51 */     return "fund/fundSettlement";
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/fund/queryFundAccountLogInit"})
/*     */   public String queryFundAccountLogInit(@ModelAttribute("fundAccountLogQuery") FundAccountLogQuery fundAccountLogQuery, UserAgent userAgent, ModelMap model)
/*     */   {
/*  61 */     model.addAttribute("enumTransCode", EnumTransCode.values());
/*  62 */     return "fund/fundAccountLogList";
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/fund/queryFundAccountMsgInit"})
/*     */   public String queryFundAccountMsgInit(UserAgent userAgent, ModelMap model)
/*     */   {
/*  71 */     model.addAttribute("fundAccount", "");
/*  72 */     return "fund/fundAccountMsg";
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/fund/queryFundAccountReportInit"})
/*     */   public String queryFundReportInit(UserAgent userAgent, ModelMap model)
/*     */   {
/*  80 */     model.addAttribute("fundAccount", "");
/*  81 */     model.addAttribute("tradeDate", "");
/*  82 */     model.addAttribute("initTradeDate", DateUtil.convertDateToString("yyyy-MM-dd", DateUtils.addDays(new Date(), -1)));
/*  83 */     return "fund/queryFundReport";
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/fund/queryPlatformSettlementInit"})
/*     */   public String queryPlatformSettlementInit(UserAgent userAgent, ModelMap model)
/*     */   {
/*  93 */     model.addAttribute("tradeDate", DateUtil.convertDateToString("yyyy-MM-dd", DateUtils.addDays(new Date(), -1)));
/*  94 */     model.addAttribute("initTradeDate", DateUtil.convertDateToString("yyyy-MM-dd", DateUtils.addDays(new Date(), -1)));
/*  95 */     return "fund/platformSettlement";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.FUND_QUERY_R_SETTLENT_LIST})
/*     */   @RequestMapping({"/fund/queryFundSettlement"})
/*     */   public String queryFundSettlement(@RequestParam("tradeDate") String tradeDate, UserAgent userAgent, ModelMap model)
/*     */   {
/* 105 */     if (StringUtil.isBlank(tradeDate)) {
/* 106 */       model.addAttribute("message", "结算日期不能为空！");
/* 107 */       return "error";
/*     */     }
/* 109 */     model.addAttribute("tradeDate", tradeDate);
/*     */ 
/* 112 */     tradeDate = StringUtil.replace(tradeDate, "-", "");
/*     */ 
/* 114 */     FundSettlement fundSettlement = this.fundQueryService.queryFundSettlement(tradeDate);
/* 115 */     FundAccountReport fundMoneyHisReport = this.fundQueryService.queryFundMoneyHisReportTotal(tradeDate);
/* 116 */     FundAccountReport fundMoneyTotalHisReport = this.fundQueryService.queryFundMoneyTotalHisReportTotal(tradeDate);
/* 117 */     model.addAttribute("fundSettlement", fundSettlement);
/* 118 */     model.addAttribute("fundMoneyHisReport", fundMoneyHisReport);
/* 119 */     model.addAttribute("fundMoneyTotalHisReport", fundMoneyTotalHisReport);
/*     */ 
/* 121 */     model.addAttribute("initTradeDate", DateUtil.convertDateToString("yyyy-MM-dd", DateUtils.addDays(new Date(), -1)));
/* 122 */     return "fund/fundSettlement";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.FUND_QUERY_R_PLATSETTLENT_LIST})
/*     */   @RequestMapping({"/fund/queryPlatformSettlement"})
/*     */   public String queryPlatformSettlement(@RequestParam("startTradeDate") String startTradeDate, @RequestParam("endTradeDate") String endTradeDate, UserAgent userAgent, ModelMap model)
/*     */   {
/* 132 */     if ((StringUtil.isBlank(startTradeDate)) || (StringUtil.isBlank(endTradeDate))) {
/* 133 */       model.addAttribute("message", "结算开始日期和结束日期不能为空！");
/* 134 */       return "error";
/*     */     }
/* 136 */     model.addAttribute("startTradeDate", startTradeDate);
/* 137 */     model.addAttribute("endTradeDate", endTradeDate);
/*     */ 
/* 140 */     String s_TradeDate = StringUtil.replace(startTradeDate, "-", "");
/* 141 */     String e_TradeDate = StringUtil.replace(endTradeDate, "-", "");
/*     */ 
/* 143 */     FundSettlement fundSettlement = this.fundQueryService.queryPlatformSettlement(s_TradeDate, e_TradeDate);
/*     */ 
/* 150 */     fundSettlement.setStartTradeDate(startTradeDate);
/* 151 */     fundSettlement.setEndTradeDate(endTradeDate);
/*     */ 
/* 153 */     model.addAttribute("fundSettlement", fundSettlement);
/* 154 */     model.addAttribute("initTradeDate", DateUtil.convertDateToString("yyyy-MM-dd", DateUtils.addDays(new Date(), -1)));
/* 155 */     return "fund/platformSettlement";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.FUND_QUERY_R_ACCOUNTMSG_LIST})
/*     */   @RequestMapping({"/fund/queryFundAccountLogList"})
/*     */   public String queryFundAccountLogList(@ModelAttribute("fundAccountLogQuery") FundAccountLogQuery fundAccountLogQuery, UserAgent userAgent, ModelMap model)
/*     */   {
/* 166 */     if ((StringUtil.isBlank(fundAccountLogQuery.getFundAccount())) && (StringUtil.isBlank(fundAccountLogQuery.getUserAccount())) && (StringUtil.isBlank(fundAccountLogQuery.getBizNo())))
/*     */     {
/* 169 */       model.addAttribute("message", "用户账号、资金账号、流水号三者者必填一！");
/* 170 */       return "error";
/*     */     }
/*     */ 
/* 173 */     this.fundQueryService.queryFundAccountLogList(fundAccountLogQuery);
/*     */ 
/* 175 */     model.addAttribute("enumTransCode", EnumTransCode.values());
/* 176 */     return "fund/fundAccountLogList";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.FUND_QUERY_R_SETTLENT_LIST})
/*     */   @RequestMapping({"/fund/queryFundAccountMsg"})
/*     */   public String queryFundAccountMsg(@RequestParam("fundAccount") String fundAccount, @RequestParam("userAccount") String userAccount, UserAgent userAgent, ModelMap model)
/*     */   {
/* 188 */     if ((StringUtil.isBlank(fundAccount)) && (StringUtil.isBlank(userAccount))) {
/* 189 */       model.addAttribute("message", "用户账号和资金账号二者必填一！");
/* 190 */       return "error";
/*     */     }
/* 192 */     model.addAttribute("fundAccount", fundAccount);
/* 193 */     model.addAttribute("userAccount", userAccount);
/*     */ 
/* 195 */     FundAccountMsg fundAccountMsg = this.fundQueryService.queryFundAccountMsg(fundAccount, userAccount);
/* 196 */     model.addAttribute("fundAccountMsg", fundAccountMsg);
/*     */ 
/* 198 */     return "fund/fundAccountMsg";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.FUND_QUERY_R_REPORT_LIST})
/*     */   @RequestMapping({"/fund/queryFundAccountReport"})
/*     */   public String queryFundAccountReport(@RequestParam("fundAccount") String fundAccount, @RequestParam("userAccount") String userAccount, @RequestParam("tradeDate") String tradeDate, UserAgent userAgent, ModelMap model)
/*     */   {
/* 211 */     if ((StringUtil.isBlank(fundAccount)) && (StringUtil.isBlank(userAccount))) {
/* 212 */       model.addAttribute("message", "资金账号或用户账号必须填写一个！");
/* 213 */       return "error";
/*     */     }
/* 215 */     model.addAttribute("fundAccount", fundAccount);
/* 216 */     model.addAttribute("userAccount", userAccount);
/*     */ 
/* 219 */     if (StringUtil.isBlank(tradeDate)) {
/* 220 */       model.addAttribute("message", "日期不能为空！");
/* 221 */       return "error";
/*     */     }
/* 223 */     model.addAttribute("tradeDate", tradeDate);
/*     */ 
/* 226 */     tradeDate = StringUtil.replace(tradeDate, "-", "");
/*     */ 
/* 228 */     FundAccountReport fundAccountReport = this.fundQueryService.queryFundAccountReport(userAccount, fundAccount, tradeDate);
/* 229 */     model.addAttribute("fundAccountReport", fundAccountReport);
/* 230 */     model.addAttribute("initTradeDate", DateUtil.convertDateToString("yyyy-MM-dd", DateUtils.addDays(new Date(), -1)));
/* 231 */     return "fund/queryFundReport";
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.action.fund.FundQueryAction
 * JD-Core Version:    0.6.0
 */