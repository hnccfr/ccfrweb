/*     */ package com.hundsun.network.gates.genshan.web.action.order;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.domain.order.ComplaintDeal;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.order.TradeOrder;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.order.TradeOrderCc;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.query.TradeOrderCcQuery;
/*     */ import com.hundsun.network.gates.genshan.biz.service.order.TradeOrderCcService;
/*     */ import com.hundsun.network.gates.genshan.biz.service.order.TradeOrderService;
/*     */ import com.hundsun.network.gates.genshan.common.UserAgent;
/*     */ import com.hundsun.network.gates.genshan.security.AdminAccess;
/*     */ import com.hundsun.network.gates.genshan.web.action.BaseAction;
/*     */ import com.hundsun.network.gates.genshan.web.validator.ComplainValidator;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeOrderCcDealType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeOrderCcStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeOrderCcType;
/*     */ import com.hundsun.network.gates.luosi.common.utils.DateUtil;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumTradeOrderCcResultErrors;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.TradeOrderCcServiceResult;
/*     */ import java.util.Date;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.validation.BindingResult;
/*     */ import org.springframework.web.bind.annotation.ModelAttribute;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ 
/*     */ @Controller
/*     */ public class ComplaintAction extends BaseAction
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private TradeOrderCcService tradeOrderCcService;
/*     */ 
/*     */   @Autowired
/*     */   private TradeOrderService tradeOrderService;
/*     */ 
/*     */   @Autowired
/*     */   private ComplainValidator complainValidator;
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.COM_R_LIST})
/*     */   @RequestMapping({"complain/list"})
/*     */   public void queryBuyerComplaint(@ModelAttribute("query") TradeOrderCcQuery query, UserAgent userAgent, ModelMap model)
/*     */   {
/*  48 */     EnumTradeOrderCcType[] types = EnumTradeOrderCcType.values();
/*  49 */     EnumTradeOrderCcStatus[] status = EnumTradeOrderCcStatus.values();
/*  50 */     this.tradeOrderCcService.getTradeOrderCcByQuery(query);
/*  51 */     model.addAttribute("types", types);
/*  52 */     model.addAttribute("status", status);
/*  53 */     model.addAttribute("query", query);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.COM_R_DETAIL})
/*     */   @RequestMapping({"complain/detail"})
/*     */   public void complaintDetail(@RequestParam(value="orderCcNum", required=true) String orderCcNum, ModelMap model)
/*     */   {
/*  64 */     TradeOrderCc tradeOrderCc = this.tradeOrderCcService.getTradeOrderCcByNum(orderCcNum);
/*  65 */     model.addAttribute("tradeOrderCc", tradeOrderCc);
/*  66 */     ComplaintDeal complaintDeal = new ComplaintDeal();
/*  67 */     model.addAttribute("complaintDeal", complaintDeal);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.COM_U_REPLAY})
/*     */   @RequestMapping({"complain/replay"})
/*     */   public String complaintReplay(@ModelAttribute("tradeOrderCc") TradeOrderCc tradeOrderCc, UserAgent userAgent, ModelMap model)
/*     */   {
/*  78 */     if (tradeOrderCc.getMessage().length() > 100) {
/*  79 */       String message = tradeOrderCc.getMessage();
/*  80 */       tradeOrderCc = this.tradeOrderCcService.getTradeOrderCcByNum(tradeOrderCc.getOrderCcNum());
/*  81 */       tradeOrderCc.setMessage(message);
/*  82 */       model.addAttribute("tradeOrderCc", tradeOrderCc);
/*  83 */       model.addAttribute("msgError", getMessage("common.error.maxlength", new String[] { "100" }));
/*  84 */       return "complain/detail";
/*     */     }
/*     */ 
/*  87 */     String message = "[客服]" + userAgent.getUserAccount() + "(" + DateUtil.getDateFormat(new Date(), null) + "):" + tradeOrderCc.getMessage() + "\n";
/*  88 */     tradeOrderCc.setMessage(message);
/*  89 */     TradeOrderCcServiceResult updateResult = this.tradeOrderCcService.updateByOrderCcNum(tradeOrderCc);
/*     */ 
/*  91 */     if (!updateResult.correct()) {
/*  92 */       return redirect("/error.htm");
/*     */     }
/*  94 */     return redirect("/complain/detail.htm?orderCcNum=" + tradeOrderCc.getOrderCcNum());
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.COM_U_DEAL})
/*     */   @RequestMapping(value={"complain/punish"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String complaintDealPage(@RequestParam(value="orderCcNum", required=true) String orderCcNum, ModelMap model)
/*     */   {
/* 106 */     TradeOrderCc tradeOrderCc = this.tradeOrderCcService.getTradeOrderCcByNum(orderCcNum);
/* 107 */     if (null != tradeOrderCc) {
/* 108 */       if (tradeOrderCc.getStatus().equals(EnumTradeOrderCcStatus.DEALT.getValue()))
/*     */       {
/* 110 */         return redirect("/complain/detail.htm?orderCcNum=" + orderCcNum);
/*     */       }
/*     */     }
/* 113 */     else return redirect("/error.htm");
/*     */ 
/* 116 */     EnumTradeOrderCcDealType[] dealTypes = this.tradeOrderCcService.getAvailableDealTypes(orderCcNum);
/*     */ 
/* 118 */     if ((EnumTradeOrderCcType.DEFAULT_BUYER_UNCHECK_RECEIPT_ARRIVAL.getValue().equals(tradeOrderCc.getCcType())) || (EnumTradeOrderCcType.DEFAULT_BUYER_UNCHECK_GOODS_ARRIVAL.getValue().equals(tradeOrderCc.getCcType())))
/*     */     {
/* 120 */       TradeOrder order = this.tradeOrderService.selectByOrderNo(tradeOrderCc.getOrderNo());
/* 121 */       tradeOrderCc.setMoneyUnite(order.getValuationUnit());
/* 122 */       tradeOrderCc.setAmount(this.tradeOrderCcService.getOrderAmount(orderCcNum));
/*     */     }
/*     */ 
/* 125 */     model.addAttribute("dealTypes", dealTypes);
/* 126 */     model.addAttribute("tradeOrderCc", tradeOrderCc);
/* 127 */     return "complain/punish";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.COM_U_DEAL})
/*     */   @RequestMapping(value={"complain/punish"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String complaintDeal(@ModelAttribute("tradeOrderCc") TradeOrderCc tradeOrderCc, BindingResult result, UserAgent userAgent, ModelMap model)
/*     */   {
/* 137 */     this.complainValidator.validate(tradeOrderCc, result);
/* 138 */     if (result.hasErrors()) {
/* 139 */       EnumTradeOrderCcDealType[] dealTypes = this.tradeOrderCcService.getAvailableDealTypes(tradeOrderCc.getOrderCcNum());
/* 140 */       model.addAttribute("dealTypes", dealTypes);
/* 141 */       return "complain/punish";
/*     */     }
/* 143 */     tradeOrderCc.setAuditor(userAgent.getUserAccount());
/* 144 */     tradeOrderCc.setAuditDate(new Date());
/* 145 */     tradeOrderCc.setStatus(EnumTradeOrderCcStatus.DEALT.getValue());
/* 146 */     TradeOrderCcServiceResult updateResult = this.tradeOrderCcService.updateByOrderCcNum(tradeOrderCc);
/* 147 */     if (!updateResult.correct()) {
/* 148 */       if (updateResult.getErrorNO().intValue() == EnumTradeOrderCcResultErrors.DEAL_DISABLE_ERROR.getValue()) {
/* 149 */         EnumTradeOrderCcDealType[] dealTypes = this.tradeOrderCcService.getAvailableDealTypes(tradeOrderCc.getOrderCcNum());
/* 150 */         model.addAttribute("dealTypes", dealTypes);
/* 151 */         model.addAttribute("msgError", getMessage("ordercc.error.overdue", new String[0]));
/* 152 */         return "complain/punish";
/*     */       }
/* 154 */       model.addAttribute("message", updateResult.getErrorInfo());
/* 155 */       return "/error";
/*     */     }
/* 157 */     return redirect("/complain/detail.htm?orderCcNum=" + tradeOrderCc.getOrderCcNum());
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.action.order.ComplaintAction
 * JD-Core Version:    0.6.0
 */