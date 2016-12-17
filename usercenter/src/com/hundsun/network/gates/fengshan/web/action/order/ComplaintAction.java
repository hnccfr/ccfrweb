/*     */ package com.hundsun.network.gates.fengshan.web.action.order;
/*     */ 
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.order.TradeOrder;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.order.TradeOrderCc;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.query.TradeOrderCcQuery;
/*     */ import com.hundsun.network.gates.fengshan.biz.service.common.UploadService;
/*     */ import com.hundsun.network.gates.fengshan.biz.service.order.TradeOrderCcService;
/*     */ import com.hundsun.network.gates.fengshan.biz.service.order.TradeOrderService;
/*     */ import com.hundsun.network.gates.fengshan.web.action.BaseAction;
/*     */ import com.hundsun.network.gates.luosi.biz.domain.UserAgent;
/*     */ import com.hundsun.network.gates.luosi.biz.security.SystemAccess;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumComplainStarterType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeOrderCcStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeOrderCcType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeUserType;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.TradeOrderCcDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumTradeOrderCcResultErrors;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.TradeOrderCcServiceResult;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.validation.BindingResult;
/*     */ import org.springframework.web.bind.annotation.ModelAttribute;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.multipart.MultipartFile;
/*     */ 
/*     */ @Controller
/*     */ public class ComplaintAction extends BaseAction
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private TradeOrderService tradeOrderService;
/*     */ 
/*     */   @Autowired
/*     */   private TradeOrderCcService tradeOrderCcService;
/*     */ 
/*     */   @Autowired
/*     */   private UploadService uploadService;
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_C_ORDERCC_BUYER_ADD})
/*     */   @RequestMapping(value={"complain/buy/add"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String doShowBuyerComplainPage(@RequestParam(value="orderNo", required=true) String orderNo, @ModelAttribute("tradeOrderCc") TradeOrderCc tradeOrderCc, UserAgent userAgent, ModelMap model)
/*     */   {
/*  50 */     TradeOrder order = this.tradeOrderService.selectByOrderNo(orderNo);
/*  51 */     EnumTradeOrderCcType[] availableCcTypes = this.tradeOrderCcService.getAvailableCcTypes(orderNo, userAgent.getAccount(), EnumTradeUserType.BUYER.getValue());
/*  52 */     model.addAttribute("availableCcTypes", availableCcTypes);
/*  53 */     model.addAttribute("order", order);
/*  54 */     return "complain/buy/add";
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_C_ORDERCC_SELLER_ADD})
/*     */   @RequestMapping(value={"complain/sell/add"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String doShowSellerComplainPage(@RequestParam(value="orderNo", required=false) String orderNo, @ModelAttribute("tradeOrderCc") TradeOrderCc tradeOrderCc, UserAgent userAgent, ModelMap model)
/*     */   {
/*  67 */     TradeOrder order = this.tradeOrderService.selectByOrderNo(orderNo);
/*  68 */     EnumTradeOrderCcType[] availableCcTypes = this.tradeOrderCcService.getAvailableCcTypes(orderNo, userAgent.getAccount(), EnumTradeUserType.SELLER.getValue());
/*  69 */     model.addAttribute("availableCcTypes", availableCcTypes);
/*  70 */     model.addAttribute("order", order);
/*  71 */     return "complain/sell/add";
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_C_ORDERCC_BUYER_ADD})
/*     */   @RequestMapping(value={"complain/buy/add"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String addBuyerComplaint(@ModelAttribute("tradeOrderCc") TradeOrderCc tradeOrderCc, BindingResult result, @RequestParam("uploadFile") MultipartFile file, UserAgent userAgent, ModelMap model)
/*     */   {
/*  86 */     if ((tradeOrderCc.getDescript().length() < 1) || (tradeOrderCc.getDescript().length() > 170)) {
/*  87 */       TradeOrder order = this.tradeOrderService.selectByOrderNo(tradeOrderCc.getOrderNo());
/*  88 */       EnumTradeOrderCcType[] availableCcTypes = this.tradeOrderCcService.getAvailableCcTypes(order.getOrderNo(), userAgent.getAccount(), EnumTradeUserType.SELLER.getValue());
/*  89 */       model.addAttribute("availableCcTypes", availableCcTypes);
/*  90 */       model.addAttribute("order", order);
/*  91 */       if (tradeOrderCc.getDescript().length() > 170)
/*  92 */         model.addAttribute("reasonError", getMessage("common.error.maxlength", new String[] { "170" }));
/*     */       else {
/*  94 */         model.addAttribute("reasonError", getMessage("common.error.required", new String[0]));
/*     */       }
/*     */ 
/*  97 */       return "complain/buy/add";
/*     */     }
/*     */ 
/* 100 */     if ((null != file.getOriginalFilename()) && (!file.getOriginalFilename().equals(""))) {
/* 101 */       String attactment = this.uploadService.uploadFile(file);
/* 102 */       tradeOrderCc.setAttactment(attactment);
/*     */     }
/* 104 */     tradeOrderCc.setCcStartor(EnumComplainStarterType.BUYER.getValue());
/* 105 */     tradeOrderCc.setCreator(userAgent.getAccount());
/* 106 */     tradeOrderCc.setComplainedType(EnumTradeUserType.SELLER.getValue());
/*     */ 
/* 108 */     TradeOrderCcServiceResult addResult = this.tradeOrderCcService.addTradeOrderCc(tradeOrderCc);
/* 109 */     if (!addResult.correct())
/*     */     {
/* 111 */       if ((addResult.getErrorNO().intValue() == EnumTradeOrderCcResultErrors.DUPLICATION_MANUAL_ERROR.getValue()) || (addResult.getErrorNO().intValue() == EnumTradeOrderCcResultErrors.DUPLICATION_SYSTEM_ERROR.getValue()))
/*     */       {
/* 113 */         setResult(model, addResult);
/* 114 */         model.addAttribute("message", addResult.getErrorInfo());
/* 115 */         model.addAttribute("url", "/complain/detail.htm?orderCcNum=" + addResult.getTradeOrderCcDTO().getOrderCcNum());
/* 116 */         return "/complain/warning";
/*     */       }
/* 118 */       model.addAttribute("message", addResult.getErrorInfo());
/* 119 */       return "/error";
/*     */     }
/* 121 */     model.addAttribute("message", getMessage("ordercc.add.success", new String[0]));
/* 122 */     model.addAttribute("url", "/complain/buy/complain");
/* 123 */     return "/success";
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_C_ORDERCC_SELLER_ADD})
/*     */   @RequestMapping(value={"complain/sell/add"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String addSellerComplaint(@ModelAttribute("tradeOrderCc") TradeOrderCc tradeOrderCc, BindingResult result, @RequestParam("uploadFile") MultipartFile file, UserAgent userAgent, ModelMap model)
/*     */   {
/* 138 */     if ((tradeOrderCc.getDescript().length() < 1) || (tradeOrderCc.getDescript().length() > 170)) {
/* 139 */       TradeOrder order = this.tradeOrderService.selectByOrderNo(tradeOrderCc.getOrderNo());
/* 140 */       EnumTradeOrderCcType[] availableCcTypes = this.tradeOrderCcService.getAvailableCcTypes(order.getOrderNo(), userAgent.getAccount(), EnumTradeUserType.SELLER.getValue());
/* 141 */       model.addAttribute("availableCcTypes", availableCcTypes);
/* 142 */       model.addAttribute("order", order);
/* 143 */       if (tradeOrderCc.getDescript().length() > 170)
/* 144 */         model.addAttribute("reasonError", getMessage("common.error.maxlength", new String[] { "170" }));
/*     */       else {
/* 146 */         model.addAttribute("reasonError", getMessage("common.error.required", new String[0]));
/*     */       }
/*     */ 
/* 149 */       return "complain/sell/add";
/*     */     }
/*     */ 
/* 152 */     if ((null != file) && (StringUtil.isNotEmpty(file.getOriginalFilename()))) {
/* 153 */       String attactment = this.uploadService.uploadFile(file);
/* 154 */       tradeOrderCc.setAttactment(attactment);
/*     */     }
/*     */ 
/* 157 */     tradeOrderCc.setCcStartor(EnumComplainStarterType.SELLER.getValue());
/* 158 */     tradeOrderCc.setCreator(userAgent.getAccount());
/* 159 */     tradeOrderCc.setComplainedType(EnumTradeUserType.BUYER.getValue());
/*     */ 
/* 161 */     TradeOrderCcServiceResult addResult = this.tradeOrderCcService.addTradeOrderCc(tradeOrderCc);
/* 162 */     if (!addResult.correct())
/*     */     {
/* 164 */       if ((addResult.getErrorNO().intValue() == EnumTradeOrderCcResultErrors.DUPLICATION_MANUAL_ERROR.getValue()) || (addResult.getErrorNO().intValue() == EnumTradeOrderCcResultErrors.DUPLICATION_SYSTEM_ERROR.getValue()))
/*     */       {
/* 166 */         setResult(model, addResult);
/* 167 */         model.addAttribute("message", addResult.getErrorInfo());
/* 168 */         model.addAttribute("url", "/complain/detail.htm?orderCcNum=" + addResult.getTradeOrderCcDTO().getOrderCcNum());
/* 169 */         return "/complain/warning";
/*     */       }
/* 171 */       model.addAttribute("message", addResult.getErrorInfo());
/* 172 */       return "/error";
/*     */     }
/* 174 */     model.addAttribute("message", getMessage("ordercc.add.success", new String[0]));
/* 175 */     model.addAttribute("url", "/complain/sell/complain");
/* 176 */     return "/success";
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_R_ORDERCC_BUYER_COMPLAIN_LIST})
/*     */   @RequestMapping({"complain/buy/complain"})
/*     */   public void queryBuyerComplaint(@ModelAttribute("query") TradeOrderCcQuery query, UserAgent userAgent, ModelMap model)
/*     */   {
/* 187 */     query.setBuyerAccount(userAgent.getAccount());
/* 188 */     query.setComplainedType(EnumTradeUserType.SELLER.getValue());
/* 189 */     this.tradeOrderCcService.getTradeOrderCcByQuery(query);
/*     */ 
/* 191 */     EnumTradeOrderCcStatus[] status = EnumTradeOrderCcStatus.values();
/* 192 */     model.addAttribute("status", status);
/* 193 */     model.addAttribute("query", query);
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_R_ORDERCC_SELLER_COMPLAIN_LIST})
/*     */   @RequestMapping({"complain/sell/complain"})
/*     */   public void querySellerComplain(@ModelAttribute("query") TradeOrderCcQuery query, UserAgent userAgent, ModelMap model)
/*     */   {
/* 205 */     query.setSellerAccount(userAgent.getAccount());
/* 206 */     query.setComplainedType(EnumTradeUserType.BUYER.getValue());
/* 207 */     this.tradeOrderCcService.getTradeOrderCcByQuery(query);
/*     */ 
/* 209 */     EnumTradeOrderCcStatus[] status = EnumTradeOrderCcStatus.values();
/* 210 */     model.addAttribute("status", status);
/* 211 */     model.addAttribute("query", query);
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_R_ORDERCC_BUYER_COMPLAINED_LIST})
/*     */   @RequestMapping({"complain/buy/complained"})
/*     */   public void queryBuyerComplained(@ModelAttribute("query") TradeOrderCcQuery query, UserAgent userAgent, ModelMap model)
/*     */   {
/* 223 */     query.setComplainedType(EnumTradeUserType.BUYER.getValue());
/* 224 */     query.setBuyerAccount(userAgent.getAccount());
/* 225 */     this.tradeOrderCcService.getTradeOrderCcByQuery(query);
/* 226 */     EnumTradeOrderCcStatus[] status = EnumTradeOrderCcStatus.values();
/* 227 */     model.addAttribute("status", status);
/* 228 */     model.addAttribute("query", query);
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_R_ORDERCC_SELLER_COMPLAINED_LIST})
/*     */   @RequestMapping({"complain/sell/complained"})
/*     */   public void querySellerComplained(@ModelAttribute("query") TradeOrderCcQuery query, UserAgent userAgent, ModelMap model)
/*     */   {
/* 240 */     query.setComplainedType(EnumTradeUserType.SELLER.getValue());
/* 241 */     query.setSellerAccount(userAgent.getAccount());
/* 242 */     this.tradeOrderCcService.getTradeOrderCcByQuery(query);
/* 243 */     EnumTradeOrderCcStatus[] status = EnumTradeOrderCcStatus.values();
/* 244 */     model.addAttribute("status", status);
/* 245 */     model.addAttribute("query", query);
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_R_ORDERCC_DETAIL})
/*     */   @RequestMapping(value={"complain/detail"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void complaintDetail(@RequestParam(value="orderCcNum", required=true) String orderCcNum, ModelMap model)
/*     */   {
/* 254 */     TradeOrderCc tradeOrderCc = this.tradeOrderCcService.getTradeOrderCcByNum(orderCcNum);
/* 255 */     model.addAttribute("tradeOrderCc", tradeOrderCc);
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_U_ORDERCC_REPLAY})
/*     */   @RequestMapping(value={"complain/detail"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String complaintReplay(@ModelAttribute("tradeOrderCc") TradeOrderCc tradeOrderCc, UserAgent userAgent, ModelMap model)
/*     */   {
/* 264 */     if (tradeOrderCc.getMessage().length() > 100) {
/* 265 */       tradeOrderCc = this.tradeOrderCcService.getTradeOrderCcByNum(tradeOrderCc.getOrderCcNum());
/* 266 */       tradeOrderCc.setMessage(tradeOrderCc.getMessage());
/* 267 */       model.addAttribute("tradeOrderCc", tradeOrderCc);
/* 268 */       model.addAttribute("msgError", getMessage("common.error.maxlength", new String[] { "100" }));
/* 269 */       return "complain/detail";
/*     */     }
/* 271 */     TradeOrderCcServiceResult updateResult = this.tradeOrderCcService.updateByOrderCcNum(tradeOrderCc, userAgent.getAccount());
/* 272 */     if (!updateResult.correct()) {
/* 273 */       model.addAttribute("message", updateResult.getErrorInfo());
/* 274 */       return "/error";
/*     */     }
/* 276 */     return redirect("/complain/detail.htm?orderCcNum=" + tradeOrderCc.getOrderCcNum());
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"complain/order/detail"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String orderDetailDispatch(@RequestParam("orderNo") String orderNo, UserAgent userAgent, ModelMap model)
/*     */   {
/* 284 */     TradeOrder order = this.tradeOrderService.selectByOrderNo(orderNo);
/* 285 */     if (null == order) {
/* 286 */       return error(model, "trade.order.null", new String[0]);
/*     */     }
/* 288 */     String dispatchURL = "";
/* 289 */     if (userAgent.getAccount().equals(order.getBuyerAccount()))
/* 290 */       dispatchURL = "/order/buy/detail.htm?orderNo=" + orderNo;
/* 291 */     else if (userAgent.getAccount().equals(order.getSellerAccount())) {
/* 292 */       dispatchURL = "/order/sell/detail.htm?orderNo=" + orderNo;
/*     */     }
/* 294 */     return redirect(dispatchURL);
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.web.action.order.ComplaintAction
 * JD-Core Version:    0.6.0
 */