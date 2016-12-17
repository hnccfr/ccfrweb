/*     */ package com.hundsun.network.gates.fengshan.web.action.user;
/*     */ 
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.order.TradeOrder;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.query.EvaluateQuery;
/*     */ import com.hundsun.network.gates.fengshan.biz.enums.EnumEvaluateResult;
/*     */ import com.hundsun.network.gates.fengshan.biz.enums.EnumUserEvaluate;
/*     */ import com.hundsun.network.gates.fengshan.biz.service.order.TradeOrderService;
/*     */ import com.hundsun.network.gates.fengshan.biz.service.user.UserAccountService;
/*     */ import com.hundsun.network.gates.fengshan.web.action.BaseAction;
/*     */ import com.hundsun.network.gates.luosi.biz.domain.UserAgent;
/*     */ import com.hundsun.network.gates.luosi.biz.security.SystemAccess;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumHasEnabled;
/*     */ import com.hundsun.network.gates.luosi.common.enums.UserCreditType;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.UserCreditRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.UserCreditServiceResult;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.web.bind.annotation.ModelAttribute;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ 
/*     */ @Controller
/*     */ public class UserEvaluateAction extends BaseAction
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private TradeOrderService tradeOrderService;
/*     */ 
/*     */   @Autowired
/*     */   private UserAccountService userAccountService;
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_C_EVALUATE})
/*     */   @RequestMapping(value={"/evaluate/buyer"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void initBuyerEvaluate(UserAgent userAgent, @ModelAttribute("request") UserCreditRequest request, Model model)
/*     */   {
/*  63 */     TradeOrder tradeOrder = this.tradeOrderService.selectByOrderNo(request.getOrderNo());
/*  64 */     if ((null == tradeOrder) || (!userAgent.getAccount().equals(tradeOrder.getBuyerAccount())) || (EnumHasEnabled.NEED.getValue().equals(tradeOrder.getHasBuyerRank())))
/*     */     {
/*  66 */       model.addAttribute("result", "disable");
/*     */     }
/*  68 */     request.setUserAccount(tradeOrder.getSellerAccount());
/*  69 */     request.setProjectListingCode(tradeOrder.getProjectCode());
/*  70 */     model.addAttribute("request", request);
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_C_EVALUATE})
/*     */   @RequestMapping(value={"/evaluate/buyer"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String buyerEvaluate(UserAgent userAgent, @ModelAttribute("request") UserCreditRequest request, ModelMap model)
/*     */   {
/*  86 */     request.setOperator(userAgent.getAccount());
/*  87 */     request.setUserCreditType(UserCreditType.SET_SELLER_CREDIT.getValue());
/*  88 */     UserCreditServiceResult result = this.tradeOrderService.evaluateUser(request);
/*  89 */     if (result.error()) {
/*  90 */       model.put("message", result.getErrorInfo());
/*  91 */       model.put("url", "/order/buy/list");
/*  92 */       return "error";
/*     */     }
/*  94 */     model.put("url", "/order/buy/list");
/*  95 */     return "success";
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_C_EVALUATE})
/*     */   @RequestMapping(value={"/evaluate/seller"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void initSellerEvaluate(UserAgent userAgent, @ModelAttribute("request") UserCreditRequest request, Model model)
/*     */   {
/* 113 */     TradeOrder tradeOrder = this.tradeOrderService.selectByOrderNo(request.getOrderNo());
/* 114 */     if ((null == tradeOrder) || (!userAgent.getAccount().equals(tradeOrder.getSellerAccount())) || (EnumHasEnabled.NEED.getValue().equals(tradeOrder.getHasSellerRank())))
/*     */     {
/* 116 */       model.addAttribute("result", "disable");
/*     */     }
/* 118 */     request.setUserAccount(tradeOrder.getBuyerAccount());
/* 119 */     request.setProjectListingCode(tradeOrder.getProjectCode());
/* 120 */     model.addAttribute("request", request);
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_C_EVALUATE})
/*     */   @RequestMapping(value={"/evaluate/seller"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String sellerEvaluate(UserAgent userAgent, @ModelAttribute("request") UserCreditRequest request, ModelMap model)
/*     */   {
/* 136 */     request.setOperator(userAgent.getAccount());
/* 137 */     request.setUserCreditType(UserCreditType.SET_BUYER_CREDIT.getValue());
/* 138 */     UserCreditServiceResult result = this.tradeOrderService.evaluateUser(request);
/* 139 */     if (result.error()) {
/* 140 */       model.put("message", result.getErrorInfo());
/* 141 */       model.put("url", "/order/sell/list");
/* 142 */       return "error";
/*     */     }
/* 144 */     model.put("url", "/order/sell/list");
/* 145 */     return "success";
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_R_EVALUATE_LIST})
/*     */   @RequestMapping({"/evaluate/list/buyer"})
/*     */   public void getBuyerList(UserAgent userAgent, @ModelAttribute("query") EvaluateQuery query, Model model)
/*     */   {
/* 160 */     EnumEvaluateResult[] enumEvaluateResult = EnumEvaluateResult.values();
/* 161 */     query.setUserAccount(userAgent.getAccount());
/* 162 */     query.setRankType(Integer.valueOf(EnumUserEvaluate.BUYER_EVALUATE.getValue()));
/* 163 */     model.addAttribute("evaluateList", enumEvaluateResult);
/* 164 */     this.userAccountService.getEvaluateList(query);
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_R_EVALUATE_LIST})
/*     */   @RequestMapping({"/evaluate/list/seller"})
/*     */   public void getSellerList(UserAgent userAgent, @ModelAttribute("query") EvaluateQuery query, Model model)
/*     */   {
/* 178 */     EnumEvaluateResult[] enumEvaluateResult = EnumEvaluateResult.values();
/* 179 */     query.setUserAccount(userAgent.getAccount());
/* 180 */     query.setRankType(Integer.valueOf(EnumUserEvaluate.SELLER_EVALUATE.getValue()));
/* 181 */     model.addAttribute("evaluateList", enumEvaluateResult);
/* 182 */     this.userAccountService.getEvaluateList(query);
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_R_EVALUATE_LIST})
/*     */   @RequestMapping({"/evaluate/list/tobuyer"})
/*     */   public void getTobuyerList(UserAgent userAgent, @ModelAttribute("query") EvaluateQuery query, Model model)
/*     */   {
/* 196 */     EnumEvaluateResult[] enumEvaluateResult = EnumEvaluateResult.values();
/* 197 */     query.setCreator(userAgent.getAccount());
/* 198 */     query.setRankType(Integer.valueOf(EnumUserEvaluate.SELLER_EVALUATE.getValue()));
/* 199 */     model.addAttribute("evaluateList", enumEvaluateResult);
/* 200 */     this.userAccountService.getEvaluateList(query);
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_R_EVALUATE_LIST})
/*     */   @RequestMapping({"/evaluate/list/toseller"})
/*     */   public void getToSellerList(UserAgent userAgent, @ModelAttribute("query") EvaluateQuery query, Model model)
/*     */   {
/* 214 */     EnumEvaluateResult[] enumEvaluateResult = EnumEvaluateResult.values();
/* 215 */     query.setCreator(userAgent.getAccount());
/* 216 */     query.setRankType(Integer.valueOf(EnumUserEvaluate.BUYER_EVALUATE.getValue()));
/* 217 */     model.addAttribute("evaluateList", enumEvaluateResult);
/* 218 */     this.userAccountService.getEvaluateList(query);
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.web.action.user.UserEvaluateAction
 * JD-Core Version:    0.6.0
 */