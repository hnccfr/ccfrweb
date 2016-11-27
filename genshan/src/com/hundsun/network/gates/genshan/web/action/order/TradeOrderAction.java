/*     */ package com.hundsun.network.gates.genshan.web.action.order;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.dao.order.TradeOrderMoneyDAO;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.message.MessageInfo;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.order.TradeOrder;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.order.TradeOrderDetail;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.order.TradeOrderMoney;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.query.TradeOrderQuery;
/*     */ import com.hundsun.network.gates.genshan.biz.service.message.SystemMessageService;
/*     */ import com.hundsun.network.gates.genshan.biz.service.order.TradeOrderService;
/*     */ import com.hundsun.network.gates.genshan.common.UserAgent;
/*     */ import com.hundsun.network.gates.genshan.security.AdminAccess;
/*     */ import com.hundsun.network.gates.genshan.web.action.BaseAction;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumDeliveryType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumHasEnabled;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumOperatorType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumPaymentType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumSystemDictKey;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeOrderStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradingType;
/*     */ import com.hundsun.network.gates.luosi.common.remote.AjaxResult;
/*     */ import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
/*     */ import com.hundsun.network.gates.luosi.common.utils.BigDecimalUtil;
/*     */ import com.hundsun.network.gates.luosi.common.utils.CommonUtils;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.SystemDictDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumTradeOrderResultErrors;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.SystemDictRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.TradeOrderBaseRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.SystemDictServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.SystemMessageResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteSystemBaseService;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.web.bind.annotation.ModelAttribute;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ 
/*     */ @Controller
/*     */ public class TradeOrderAction extends BaseAction
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private TradeOrderService tradeOrderService;
/*     */ 
/*     */   @Autowired
/*     */   private TradeOrderMoneyDAO tradeOrderMoneyDAO;
/*     */ 
/*     */   @Autowired
/*     */   private RemoteSystemBaseService remoteSystemBaseService;
/*     */ 
/*     */   @Autowired
/*     */   private SystemMessageService systemMessageService;
/*     */ 
/*     */   private void initParam(ModelMap model)
/*     */   {
/*  68 */     List _list = Arrays.asList(EnumTradeOrderStatus.values());
/*  69 */     List list = new ArrayList();
/*  70 */     list.addAll(_list);
/*  71 */     list.remove(EnumTradeOrderStatus.ROLLBACK_DELETE);
/*  72 */     model.addAttribute("orderStatusList", list);
/*  73 */     model.addAttribute("tradingTypeList", EnumTradingType.values());
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.ORDER_R_LIST})
/*     */   @RequestMapping({"order/list"})
/*     */   public void buyList(@ModelAttribute("query") TradeOrderQuery query, UserAgent userAgent, ModelMap model)
/*     */   {
/*  86 */     if (StringUtil.isNotEmpty(query.getOrderNo())) {
/*  87 */       query.setOrderNo(query.getOrderNo().trim());
/*     */     }
/*     */ 
/*  90 */     Long substationId = getSubstationId(userAgent);
/*     */ 
/*  92 */     if (substationId != null) {
/*  93 */       query.setSubstationId(Long.valueOf(substationId.longValue()));
/*     */     }
/*     */ 
/*  96 */     initParam(model);
/*  97 */     this.tradeOrderService.queryTradeOrder(query);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.ORDER_R_DETAIL})
/*     */   @RequestMapping({"order/detail"})
/*     */   public String buyOrderDetail(@RequestParam("orderNo") String orderNo, UserAgent userAgent, ModelMap model)
/*     */   {
/* 110 */     TradeOrder tradeOrder = this.tradeOrderService.selectByOrderNo(orderNo);
/*     */ 
/* 112 */     Long substationId = getSubstationId(userAgent);
/*     */ 
/* 114 */     if ((substationId != null) && (!substationId.equals(tradeOrder.getSubstationId()))) {
/* 115 */       return "accessDenied";
/*     */     }
/*     */ 
/* 118 */     TradeOrderDetail detail = this.tradeOrderService.selectDetailByOrderNo(orderNo);
/* 119 */     if (null == detail) {
/* 120 */       return error(model, "trade.order.null", new String[0]);
/*     */     }
/*     */ 
/* 123 */     TradeOrderMoney sellMoney = this.tradeOrderMoneyDAO.selectByAccountOrderNo(orderNo, tradeOrder.getSellerAccount());
/*     */ 
/* 126 */     TradeOrderMoney buyMoney = this.tradeOrderMoneyDAO.selectByAccountOrderNo(orderNo, tradeOrder.getBuyerAccount());
/*     */ 
/* 128 */     model.addAttribute("enumPaymentTypeMap", EnumPaymentType.toMap());
/* 129 */     model.addAttribute("orderStatusMap", EnumTradeOrderStatus.toMap());
/* 130 */     model.addAttribute("tradingTypeMap", EnumTradingType.toMap());
/* 131 */     model.addAttribute("enumDeliveryTypeMap", EnumDeliveryType.toMap());
/* 132 */     model.addAttribute("tradeOrder", tradeOrder);
/* 133 */     model.addAttribute("tradeOrderDetail", detail);
/* 134 */     model.addAttribute("sellMoney", sellMoney);
/* 135 */     model.addAttribute("buyMoney", buyMoney);
/* 136 */     return "order/detail";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.ORDER_U_CHECK_GOODS})
/*     */   @RequestMapping(value={"order/checkgoods"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String checkGoodsInput(@RequestParam("orderNo") String orderNo, UserAgent userAgent, ModelMap model)
/*     */   {
/* 149 */     TradeOrder tradeOrder = this.tradeOrderService.selectByOrderNo(orderNo);
/* 150 */     TradeOrderDetail detail = this.tradeOrderService.selectDetailByOrderNo(orderNo);
/* 151 */     if (null == detail) {
/* 152 */       return error(model, "trade.order.null", new String[0]);
/*     */     }
/*     */ 
/* 155 */     if ((EnumPaymentType.OnLine.getValue().equalsIgnoreCase(tradeOrder.getPaymentType())) && (EnumHasEnabled.NEED.getValue().equalsIgnoreCase(tradeOrder.getHasInvoice())))
/*     */     {
/* 157 */       SystemDictRequest request = new SystemDictRequest();
/* 158 */       request.setParaCode(EnumSystemDictKey.GOODS_PAY_PROPORTION.getValue());
/* 159 */       SystemDictServiceResult result = this.remoteSystemBaseService.selectSingleByKey(request);
/* 160 */       if (result.correct()) {
/* 161 */         SystemDictDTO payProportion = result.getSystemDictDTO();
/* 162 */         if (payProportion.getParaValue() == null) {
/* 163 */           model.addAttribute("errorInfo", error(model, EnumTradeOrderResultErrors.CONFIG_GOODPAR_ERROR.getInfo(), new String[0]));
/*     */ 
/* 165 */           return null;
/*     */         }
/*     */         try {
/* 168 */           Long kk = Long.valueOf(new BigDecimal(payProportion.getParaValue()).longValue());
/* 169 */           if (kk.longValue() >= 10000L) {
/* 170 */             result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.CONFIG_GOODPAR_ERROR.getValue()));
/*     */ 
/* 172 */             result.setErrorInfo(EnumTradeOrderResultErrors.CONFIG_GOODPAR_ERROR.getInfo());
/*     */ 
/* 174 */             model.addAttribute("errorInfo", EnumTradeOrderResultErrors.CONFIG_GOODPAR_ERROR.getInfo());
/*     */ 
/* 176 */             return null;
/*     */           }
/*     */         } catch (Exception e) {
/* 179 */           result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.SERVER_ERROR.getValue()));
/* 180 */           result.setErrorInfo(EnumTradeOrderResultErrors.SERVER_ERROR.getInfo());
/* 181 */           model.addAttribute("errorInfo", EnumTradeOrderResultErrors.SERVER_ERROR.getInfo());
/*     */ 
/* 183 */           return null;
/*     */         }
/*     */ 
/* 187 */         BigDecimal paygodPro = new BigDecimal(payProportion.getParaValue()).movePointLeft(4);
/*     */ 
/* 189 */         BigDecimal goodsAmountSend = BigDecimalUtil.mul(new BigDecimal(tradeOrder.getOrderAmount().longValue()), paygodPro).setScale(0, 3);
/*     */ 
/* 191 */         BigDecimal goodsAmountHold = BigDecimalUtil.sub(new BigDecimal(tradeOrder.getOrderAmount().longValue()), goodsAmountSend);
/*     */ 
/* 193 */         String orderAmount = CommonUtils.getValuationUnitDesc(Long.valueOf(goodsAmountSend.longValue()), tradeOrder.getValuationUnit());
/*     */ 
/* 195 */         String otherOrderAmount = CommonUtils.getValuationUnitDesc(Long.valueOf(goodsAmountHold.longValue()), tradeOrder.getValuationUnit());
/*     */ 
/* 197 */         model.addAttribute("payProportion", new BigDecimal(payProportion.getParaValue()).movePointLeft(2));
/*     */ 
/* 199 */         model.addAttribute("orderAmount", orderAmount);
/* 200 */         model.addAttribute("otherOrderAmount", otherOrderAmount);
/*     */       }
/*     */       else {
/* 203 */         model.addAttribute("errorInfo", error(model, EnumTradeOrderResultErrors.SERVER_ERROR.getInfo(), new String[0]));
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 208 */       String orderAmount = CommonUtils.getValuationUnitDesc(Long.valueOf(tradeOrder.getOrderAmount().longValue()), tradeOrder.getValuationUnit());
/*     */ 
/* 210 */       model.addAttribute("orderAmount", orderAmount);
/*     */     }
/* 212 */     model.addAttribute("enumPaymentTypeMap", EnumPaymentType.toMap());
/* 213 */     model.addAttribute("orderStatusMap", EnumTradeOrderStatus.toMap());
/* 214 */     model.addAttribute("tradingTypeMap", EnumTradingType.toMap());
/* 215 */     model.addAttribute("enumDeliveryTypeMap", EnumDeliveryType.toMap());
/* 216 */     model.addAttribute("tradeOrder", tradeOrder);
/* 217 */     model.addAttribute("tradeOrderDetail", detail);
/* 218 */     return "order/checkgoods";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.ORDER_U_CHECK_GOODS})
/*     */   @RequestMapping(value={"order/checkgoods"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @ResponseBody
/*     */   public AjaxResult checkgoods(@RequestParam("orderNo") String orderNo, UserAgent userAgent, Model model)
/*     */     throws Exception
/*     */   {
/* 230 */     AjaxResult ajaxResult = new AjaxResult();
/* 231 */     TradeOrder tradeOrder = this.tradeOrderService.selectByOrderNo(orderNo);
/* 232 */     if (null == tradeOrder) {
/* 233 */       ajaxResult.setErrorInfo(getMessage("trade.order.null", new String[0]));
/* 234 */       return ajaxResult;
/*     */     }
/*     */ 
/* 237 */     TradeOrderBaseRequest request = new TradeOrderBaseRequest();
/* 238 */     request.setOrderNo(tradeOrder.getOrderNo());
/* 239 */     request.setUserAccount(tradeOrder.getBuyerAccount());
/* 240 */     request.setOperator(userAgent.getUserAccount());
/* 241 */     request.setOperatorType(EnumOperatorType.USER.getValue());
/* 242 */     request.setCheckPayPwd(Boolean.valueOf(false));
/* 243 */     ServiceResult result = this.tradeOrderService.orderGoodsValidate(request);
/* 244 */     if (result.correct()) {
/* 245 */       MessageInfo messageInfo = new MessageInfo();
/* 246 */       messageInfo.setUserAccounts(tradeOrder.getBuyerAccount());
/* 247 */       messageInfo.setSendAccount(EnumOperatorType.SYSTEM.getValue());
/* 248 */       messageInfo.setTitle(getMessage("trade.order.system.checkgoods.message.title", new String[0]));
/* 249 */       messageInfo.setContent(getMessage("trade.order.system.checkgoods.message.content", new String[] { tradeOrder.getOrderNo(), userAgent.getUserAccount() }));
/*     */       try
/*     */       {
/* 252 */         SystemMessageResult systemMessageResult = this.systemMessageService.sendMessage(messageInfo);
/*     */ 
/* 254 */         if (systemMessageResult.error()) {
/* 255 */           ajaxResult.setErrorInfo(getMessage("trade.order.system.checkgoods.message.error", new String[] { systemMessageResult.getErrorInfo() }));
/*     */ 
/* 258 */           ajaxResult.setErrorNO(systemMessageResult.getErrorNO());
/* 259 */           return ajaxResult;
/*     */         }
/*     */       } catch (Exception e) {
/* 262 */         ajaxResult.setErrorInfo(getMessage("trade.order.system.checkgoods.message.error", new String[] { EnumTradeOrderResultErrors.INTERNAL_ERROR.getInfo() }));
/*     */ 
/* 265 */         ajaxResult.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.INTERNAL_ERROR.getValue()));
/* 266 */         return ajaxResult;
/*     */       }
/*     */     }
/* 269 */     ajaxResult.setServiceResult(result);
/* 270 */     return ajaxResult;
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.ORDER_U_CHECK_TICKET})
/*     */   @RequestMapping({"order/checkticket"})
/*     */   public String checkTicketInput(@RequestParam("orderNo") String orderNo, UserAgent userAgent, ModelMap model)
/*     */   {
/* 283 */     TradeOrder tradeOrder = this.tradeOrderService.selectByOrderNo(orderNo);
/* 284 */     TradeOrderDetail detail = this.tradeOrderService.selectDetailByOrderNo(orderNo);
/* 285 */     if (null == tradeOrder) {
/* 286 */       model.addAttribute("errorInfo", error(model, "trade.order.null", new String[0]));
/*     */     }
/* 288 */     if ((EnumPaymentType.OnLine.getValue().equalsIgnoreCase(tradeOrder.getPaymentType())) && (EnumHasEnabled.NEED.getValue().equalsIgnoreCase(tradeOrder.getHasInvoice())))
/*     */     {
/* 291 */       TradeOrderMoney userMoney = this.tradeOrderMoneyDAO.selectByAccountOrderNo(orderNo, tradeOrder.getBuyerAccount());
/*     */ 
/* 293 */       String otherOrderAmount = CommonUtils.getValuationUnitDesc(userMoney.getGoodsAmount(), tradeOrder.getValuationUnit());
/*     */ 
/* 295 */       model.addAttribute("otherOrderAmount", otherOrderAmount);
/* 296 */       model.addAttribute("userMoney", userMoney);
/*     */     }
/* 298 */     model.addAttribute("enumPaymentTypeMap", EnumPaymentType.toMap());
/* 299 */     model.addAttribute("orderStatusMap", EnumTradeOrderStatus.toMap());
/* 300 */     model.addAttribute("tradingTypeMap", EnumTradingType.toMap());
/* 301 */     model.addAttribute("enumDeliveryTypeMap", EnumDeliveryType.toMap());
/* 302 */     model.addAttribute("tradeOrder", tradeOrder);
/* 303 */     model.addAttribute("tradeOrderDetail", detail);
/* 304 */     return "order/checkticket";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.ORDER_U_CHECK_TICKET})
/*     */   @RequestMapping(value={"order/checkticket"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @ResponseBody
/*     */   public AjaxResult checkTicket(UserAgent userAgent, @RequestParam("orderNo") String orderNo, Model model)
/*     */     throws Exception
/*     */   {
/* 316 */     AjaxResult ajaxResult = new AjaxResult();
/* 317 */     TradeOrder tradeOrder = this.tradeOrderService.selectByOrderNo(orderNo);
/* 318 */     if (null == tradeOrder) {
/* 319 */       model.addAttribute("errorInfo", error(model, "trade.order.null", new String[0]));
/*     */     }
/*     */ 
/* 322 */     TradeOrderBaseRequest request = new TradeOrderBaseRequest();
/* 323 */     request.setOrderNo(tradeOrder.getOrderNo());
/* 324 */     request.setUserAccount(tradeOrder.getBuyerAccount());
/* 325 */     request.setOperator(userAgent.getUserAccount());
/* 326 */     request.setOperatorType(EnumOperatorType.SYSTEM.getValue());
/* 327 */     request.setCheckPayPwd(Boolean.valueOf(false));
/* 328 */     ServiceResult result = this.tradeOrderService.orderInvoiceValidate(request);
/* 329 */     if (result.correct()) {
/* 330 */       MessageInfo messageInfo = new MessageInfo();
/* 331 */       messageInfo.setUserAccounts(tradeOrder.getBuyerAccount());
/* 332 */       messageInfo.setSendAccount(EnumOperatorType.SYSTEM.getValue());
/* 333 */       messageInfo.setTitle(getMessage("trade.order.system.checkticket.message.title", new String[0]));
/* 334 */       messageInfo.setContent(getMessage("trade.order.system.checkticket.message.content", new String[] { tradeOrder.getOrderNo(), userAgent.getUserAccount() }));
/*     */       try
/*     */       {
/* 338 */         SystemMessageResult systemMessageResult = this.systemMessageService.sendMessage(messageInfo);
/*     */ 
/* 340 */         if (systemMessageResult.error()) {
/* 341 */           ajaxResult.setErrorInfo(getMessage("trade.order.system.checkticket.message.error", new String[] { systemMessageResult.getErrorInfo() }));
/*     */ 
/* 344 */           ajaxResult.setErrorNO(systemMessageResult.getErrorNO());
/* 345 */           return ajaxResult;
/*     */         }
/*     */       } catch (Exception e) {
/* 348 */         ajaxResult.setErrorInfo(getMessage("trade.order.system.checkgoods.message.error", new String[] { EnumTradeOrderResultErrors.INTERNAL_ERROR.getInfo() }));
/*     */ 
/* 351 */         ajaxResult.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.INTERNAL_ERROR.getValue()));
/* 352 */         return ajaxResult;
/*     */       }
/*     */     }
/* 355 */     ajaxResult.setServiceResult(result);
/* 356 */     return ajaxResult;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.action.order.TradeOrderAction
 * JD-Core Version:    0.6.0
 */