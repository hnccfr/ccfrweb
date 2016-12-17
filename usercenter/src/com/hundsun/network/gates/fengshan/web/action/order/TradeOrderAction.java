/*     */ package com.hundsun.network.gates.fengshan.web.action.order;
/*     */ 
/*     */ import com.hundsun.network.gates.fengshan.biz.dao.order.TradeOrderMoneyDAO;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.order.TradeOrder;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.order.TradeOrderDetail;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.order.TradeOrderMoney;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.query.TradeOrderQuery;
/*     */ import com.hundsun.network.gates.fengshan.biz.service.order.TradeOrderService;
/*     */ import com.hundsun.network.gates.fengshan.web.action.BaseAction;
/*     */ import com.hundsun.network.gates.luosi.biz.domain.UserAgent;
/*     */ import com.hundsun.network.gates.luosi.biz.security.SystemAccess;
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
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.TradeOrderRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.SystemDictServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.TradeOrderCashDepositResult;
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
/*     */   private void initParam(ModelMap model)
/*     */   {
/*  65 */     List _list = Arrays.asList(EnumTradeOrderStatus.values());
/*  66 */     List list = new ArrayList();
/*  67 */     list.addAll(_list);
/*  68 */     list.remove(EnumTradeOrderStatus.ROLLBACK_DELETE);
/*  69 */     model.addAttribute("orderStatusList", list);
/*  70 */     model.addAttribute("tradingTypeList", EnumTradingType.values());
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_O_BUY_ORDERLIST_LIST})
/*     */   @RequestMapping({"order/buy/list"})
/*     */   public void buyList(@ModelAttribute("query") TradeOrderQuery query, UserAgent userAgent, ModelMap model)
/*     */   {
/*  83 */     initParam(model);
/*  84 */     if (StringUtil.isNotEmpty(query.getOrderNo())) {
/*  85 */       query.setOrderNo(query.getOrderNo().trim());
/*     */     }
/*  87 */     query.setBuyerAccount(userAgent.getAccount());
/*  88 */     this.tradeOrderService.queryTradeOrder(query);
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_O_BUY_ORDERLIST_DETAIL})
/*     */   @RequestMapping({"order/buy/detail"})
/*     */   public String buyOrderDetail(@RequestParam("orderNo") String orderNo, @RequestParam(value="url", required=false) String url, UserAgent userAgent, ModelMap model)
/*     */   {
/* 102 */     TradeOrder order = this.tradeOrderService.selectByOrderNo(orderNo);
/* 103 */     TradeOrderDetail detail = this.tradeOrderService.selectBuyerOrderDetailByOrderNo(orderNo, userAgent.getAccount());
/*     */ 
/* 105 */     if (null == detail) {
/* 106 */       model.addAttribute("url", url);
/* 107 */       return error(model, "trade.order.null", new String[0]);
/*     */     }
/*     */ 
/* 110 */     TradeOrderMoney sellMoney = this.tradeOrderMoneyDAO.selectByAccountOrderNo(order.getOrderNo(), order.getSellerAccount());
/*     */ 
/* 113 */     TradeOrderMoney buyMoney = this.tradeOrderMoneyDAO.selectByAccountOrderNo(order.getOrderNo(), order.getBuyerAccount());
/*     */ 
/* 115 */     model.addAttribute("enumPaymentTypeMap", EnumPaymentType.toMap());
/* 116 */     model.addAttribute("orderStatusMap", EnumTradeOrderStatus.toMap());
/* 117 */     model.addAttribute("tradingTypeMap", EnumTradingType.toMap());
/* 118 */     model.addAttribute("enumDeliveryTypeMap", EnumDeliveryType.toMap());
/* 119 */     model.addAttribute("tradeOrder", order);
/* 120 */     model.addAttribute("tradeOrderDetail", detail);
/* 121 */     model.addAttribute("sellMoney", sellMoney);
/* 122 */     model.addAttribute("buyMoney", buyMoney);
/* 123 */     return "order/buy/detail";
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_O_SELL_ORDERLIST_LIST})
/*     */   @RequestMapping({"order/sell/list"})
/*     */   public void sellList(@ModelAttribute("query") TradeOrderQuery query, UserAgent userAgent, ModelMap model)
/*     */   {
/* 136 */     initParam(model);
/* 137 */     query.setSellerAccount(userAgent.getAccount());
/* 138 */     this.tradeOrderService.queryTradeOrder(query);
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_O_SELL_ORDERLIST_DETAIL})
/*     */   @RequestMapping({"order/sell/detail"})
/*     */   public String sellOrderDetail(@RequestParam("orderNo") String orderNo, @RequestParam(value="url", required=false) String url, UserAgent userAgent, ModelMap model)
/*     */   {
/* 152 */     TradeOrder order = this.tradeOrderService.selectByOrderNo(orderNo);
/* 153 */     TradeOrderDetail detail = this.tradeOrderService.selectSellerOrderDetailByOrderNo(orderNo, userAgent.getAccount());
/*     */ 
/* 155 */     if (null == detail) {
/* 156 */       model.addAttribute("url", url);
/* 157 */       return error(model, "trade.order.null", new String[0]);
/*     */     }
/*     */ 
/* 160 */     TradeOrderMoney sellMoney = this.tradeOrderMoneyDAO.selectByAccountOrderNo(order.getOrderNo(), order.getSellerAccount());
/*     */ 
/* 163 */     TradeOrderMoney buyMoney = this.tradeOrderMoneyDAO.selectByAccountOrderNo(order.getOrderNo(), order.getBuyerAccount());
/*     */ 
/* 165 */     model.addAttribute("enumPaymentTypeMap", EnumPaymentType.toMap());
/* 166 */     model.addAttribute("orderStatusMap", EnumTradeOrderStatus.toMap());
/* 167 */     model.addAttribute("tradingTypeMap", EnumTradingType.toMap());
/* 168 */     model.addAttribute("enumDeliveryTypeMap", EnumDeliveryType.toMap());
/* 169 */     model.addAttribute("tradeOrder", order);
/* 170 */     model.addAttribute("tradeOrderDetail", detail);
/* 171 */     model.addAttribute("sellMoney", sellMoney);
/* 172 */     model.addAttribute("buyMoney", buyMoney);
/* 173 */     return "order/sell/detail";
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_O_BUY_ORDERLIST_CONFIRM})
/*     */   @RequestMapping(value={"order/buy/confirm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String buyOrderConfirmInit(@RequestParam("orderNo") String orderNo, UserAgent userAgent, ModelMap model)
/*     */   {
/* 187 */     TradeOrder tradeOrder = this.tradeOrderService.selectByOrderNo(orderNo);
/* 188 */     TradeOrderDetail detail = this.tradeOrderService.selectBuyerOrderDetailByOrderNo(orderNo, userAgent.getAccount());
/*     */ 
/* 190 */     if (null == detail) {
/* 191 */       return error(model, "trade.order.null", new String[0]);
/*     */     }
/*     */ 
/* 194 */     TradeOrderMoney userMoney = this.tradeOrderMoneyDAO.selectByAccountOrderNo(orderNo, userAgent.getAccount());
/*     */ 
/* 196 */     model.addAttribute("enumPaymentTypeMap", EnumPaymentType.toMap());
/* 197 */     model.addAttribute("orderStatusMap", EnumTradeOrderStatus.toMap());
/* 198 */     model.addAttribute("tradingTypeMap", EnumTradingType.toMap());
/* 199 */     model.addAttribute("enumDeliveryTypeMap", EnumDeliveryType.toMap());
/* 200 */     model.addAttribute("tradeOrder", tradeOrder);
/* 201 */     model.addAttribute("tradeOrderDetail", detail);
/* 202 */     model.addAttribute("userMoney", userMoney);
/*     */ 
/* 204 */     TradeOrderCashDepositResult result = this.tradeOrderService.queryBuyerOrderCashDeposit(orderNo, userAgent.getAccount());
/*     */ 
/* 206 */     model.addAttribute("orderNo", orderNo);
/* 207 */     if (result.correct()) {
/* 208 */       model.addAttribute("cashDeposit", CommonUtils.getValuationUnitDesc(Long.valueOf(result.getBuyerDeliveryCashDeposit()), tradeOrder.getValuationUnit()));
/*     */ 
/* 210 */       model.addAttribute("serviceCharge", CommonUtils.getValuationUnitDesc(Long.valueOf(result.getBuyerServiceCharge()), tradeOrder.getValuationUnit()));
/*     */     }
/*     */ 
/* 213 */     setResult(model, result);
/* 214 */     return "order/buy/confirm";
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_O_BUY_ORDERLIST_CONFIRM})
/*     */   @RequestMapping(value={"order/buy/nodialogconfirm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String buyOrderConfirmNoDialogInit(@RequestParam("orderNo") String orderNo, UserAgent userAgent, ModelMap model)
/*     */   {
/* 229 */     TradeOrder tradeOrder = this.tradeOrderService.selectByOrderNo(orderNo);
/* 230 */     TradeOrderDetail detail = this.tradeOrderService.selectBuyerOrderDetailByOrderNo(orderNo, userAgent.getAccount());
/*     */ 
/* 232 */     if (null == detail) {
/* 233 */       return error(model, "trade.order.null", new String[0]);
/*     */     }
/*     */ 
/* 236 */     TradeOrderMoney userMoney = this.tradeOrderMoneyDAO.selectByAccountOrderNo(orderNo, userAgent.getAccount());
/*     */ 
/* 238 */     model.addAttribute("enumPaymentTypeMap", EnumPaymentType.toMap());
/* 239 */     model.addAttribute("orderStatusMap", EnumTradeOrderStatus.toMap());
/* 240 */     model.addAttribute("tradingTypeMap", EnumTradingType.toMap());
/* 241 */     model.addAttribute("enumDeliveryTypeMap", EnumDeliveryType.toMap());
/* 242 */     model.addAttribute("tradeOrder", tradeOrder);
/* 243 */     model.addAttribute("tradeOrderDetail", detail);
/* 244 */     model.addAttribute("userMoney", userMoney);
/*     */ 
/* 246 */     TradeOrderCashDepositResult result = this.tradeOrderService.queryBuyerOrderCashDeposit(orderNo, userAgent.getAccount());
/*     */ 
/* 248 */     model.addAttribute("orderNo", orderNo);
/* 249 */     if (result.correct()) {
/* 250 */       model.addAttribute("cashDeposit", CommonUtils.getValuationUnitDesc(Long.valueOf(result.getBuyerDeliveryCashDeposit()), tradeOrder.getValuationUnit()));
/*     */ 
/* 252 */       model.addAttribute("serviceCharge", CommonUtils.getValuationUnitDesc(Long.valueOf(result.getBuyerServiceCharge()), tradeOrder.getValuationUnit()));
/*     */     }
/*     */ 
/* 255 */     setResult(model, result);
/* 256 */     return "order/buy/nodialogconfirm";
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_O_BUY_ORDERLIST_CONFIRM})
/*     */   @RequestMapping(value={"order/buy/confirm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @ResponseBody
/*     */   public AjaxResult buyOrderConfirm(@RequestParam("orderNo") String orderNo, UserAgent userAgent, ModelMap model)
/*     */   {
/* 271 */     AjaxResult result = new AjaxResult();
/* 272 */     TradeOrderRequest request = new TradeOrderRequest();
/* 273 */     request.setFundAccount(userAgent.getFundAccount());
/* 274 */     request.setUserAccount(userAgent.getAccount());
/* 275 */     request.setOperator(userAgent.getAccount());
/* 276 */     request.setOperatorType(EnumOperatorType.USER.getValue());
/* 277 */     request.setOrderNo(orderNo);
/* 278 */     ServiceResult serviceResult = this.tradeOrderService.orderConfirm(request);
/* 279 */     result.setServiceResult(serviceResult);
/* 280 */     return result;
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_O_SELL_ORDERLIST_CONFIRM})
/*     */   @RequestMapping(value={"order/sell/confirm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String sellOrderConfirmInit(@RequestParam("orderNo") String orderNo, UserAgent userAgent, ModelMap model)
/*     */   {
/* 294 */     TradeOrder tradeOrder = this.tradeOrderService.selectByOrderNo(orderNo);
/* 295 */     TradeOrderDetail detail = this.tradeOrderService.selectSellerOrderDetailByOrderNo(orderNo, userAgent.getAccount());
/*     */ 
/* 297 */     if (null == detail) {
/* 298 */       return error(model, "trade.order.null", new String[0]);
/*     */     }
/*     */ 
/* 301 */     TradeOrderMoney userMoney = this.tradeOrderMoneyDAO.selectByAccountOrderNo(orderNo, userAgent.getAccount());
/*     */ 
/* 303 */     model.addAttribute("enumPaymentTypeMap", EnumPaymentType.toMap());
/* 304 */     model.addAttribute("orderStatusMap", EnumTradeOrderStatus.toMap());
/* 305 */     model.addAttribute("tradingTypeMap", EnumTradingType.toMap());
/* 306 */     model.addAttribute("enumDeliveryTypeMap", EnumDeliveryType.toMap());
/* 307 */     model.addAttribute("tradeOrder", tradeOrder);
/* 308 */     model.addAttribute("tradeOrderDetail", detail);
/* 309 */     model.addAttribute("userMoney", userMoney);
/*     */ 
/* 311 */     TradeOrderCashDepositResult result = this.tradeOrderService.querySellerOrderCashDeposit(orderNo, userAgent.getAccount());
/*     */ 
/* 313 */     model.addAttribute("orderNo", orderNo);
/* 314 */     if (result.correct()) {
/* 315 */       model.addAttribute("cashDeposit", CommonUtils.getValuationUnitDesc(Long.valueOf(result.getSellerDeliveryCashDeposit()), tradeOrder.getValuationUnit()));
/*     */ 
/* 317 */       model.addAttribute("serviceCharge", CommonUtils.getValuationUnitDesc(Long.valueOf(result.getSellerServiceCharge()), tradeOrder.getValuationUnit()));
/*     */     }
/*     */ 
/* 320 */     setResult(model, result);
/* 321 */     return "order/sell/confirm";
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_O_SELL_ORDERLIST_CONFIRM})
/*     */   @RequestMapping(value={"order/sell/nodialogconfirm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String sellOrderNoDialogConfirmInit(@RequestParam("orderNo") String orderNo, UserAgent userAgent, ModelMap model)
/*     */   {
/* 335 */     TradeOrder tradeOrder = this.tradeOrderService.selectByOrderNo(orderNo);
/* 336 */     TradeOrderDetail detail = this.tradeOrderService.selectSellerOrderDetailByOrderNo(orderNo, userAgent.getAccount());
/*     */ 
/* 338 */     if (null == detail) {
/* 339 */       return error(model, "trade.order.null", new String[0]);
/*     */     }
/*     */ 
/* 342 */     TradeOrderMoney userMoney = this.tradeOrderMoneyDAO.selectByAccountOrderNo(orderNo, userAgent.getAccount());
/*     */ 
/* 344 */     model.addAttribute("enumPaymentTypeMap", EnumPaymentType.toMap());
/* 345 */     model.addAttribute("orderStatusMap", EnumTradeOrderStatus.toMap());
/* 346 */     model.addAttribute("tradingTypeMap", EnumTradingType.toMap());
/* 347 */     model.addAttribute("enumDeliveryTypeMap", EnumDeliveryType.toMap());
/* 348 */     model.addAttribute("tradeOrder", tradeOrder);
/* 349 */     model.addAttribute("tradeOrderDetail", detail);
/* 350 */     model.addAttribute("userMoney", userMoney);
/*     */ 
/* 352 */     TradeOrderCashDepositResult result = this.tradeOrderService.querySellerOrderCashDeposit(orderNo, userAgent.getAccount());
/*     */ 
/* 354 */     model.addAttribute("orderNo", orderNo);
/* 355 */     if (result.correct()) {
/* 356 */       model.addAttribute("cashDeposit", CommonUtils.getValuationUnitDesc(Long.valueOf(result.getSellerDeliveryCashDeposit()), tradeOrder.getValuationUnit()));
/*     */ 
/* 358 */       model.addAttribute("serviceCharge", CommonUtils.getValuationUnitDesc(Long.valueOf(result.getSellerServiceCharge()), tradeOrder.getValuationUnit()));
/*     */     }
/*     */ 
/* 361 */     setResult(model, result);
/* 362 */     return "order/sell/nodialogconfirm";
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_O_SELL_ORDERLIST_CONFIRM})
/*     */   @RequestMapping(value={"order/sell/confirm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @ResponseBody
/*     */   public AjaxResult sellOrderConfirm(@RequestParam("orderNo") String orderNo, UserAgent userAgent, ModelMap model)
/*     */   {
/* 376 */     AjaxResult result = new AjaxResult();
/* 377 */     TradeOrderRequest request = new TradeOrderRequest();
/* 378 */     request.setFundAccount(userAgent.getFundAccount());
/* 379 */     request.setUserAccount(userAgent.getAccount());
/* 380 */     request.setOperator(userAgent.getAccount());
/* 381 */     request.setOperatorType(EnumOperatorType.USER.getValue());
/* 382 */     request.setOrderNo(orderNo);
/* 383 */     ServiceResult serviceResult = this.tradeOrderService.orderConfirm(request);
/* 384 */     result.setServiceResult(serviceResult);
/* 385 */     return result;
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_O_SELL_ORDERLIST_SENDGOODS})
/*     */   @RequestMapping(value={"order/sell/sendgoods"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String sellSendgoodConfirmInit(@RequestParam("orderNo") String orderNo, UserAgent userAgent, ModelMap model)
/*     */   {
/* 399 */     TradeOrder tradeOrder = this.tradeOrderService.selectByOrderNo(orderNo);
/* 400 */     TradeOrderDetail detail = this.tradeOrderService.selectSellerOrderDetailByOrderNo(orderNo, userAgent.getAccount());
/*     */ 
/* 402 */     if (null == detail) {
/* 403 */       return error(model, "trade.order.null", new String[0]);
/*     */     }
/* 405 */     model.addAttribute("enumPaymentTypeMap", EnumPaymentType.toMap());
/* 406 */     model.addAttribute("orderStatusMap", EnumTradeOrderStatus.toMap());
/* 407 */     model.addAttribute("tradingTypeMap", EnumTradingType.toMap());
/* 408 */     model.addAttribute("enumDeliveryTypeMap", EnumDeliveryType.toMap());
/* 409 */     model.addAttribute("tradeOrder", tradeOrder);
/* 410 */     model.addAttribute("tradeOrderDetail", detail);
/* 411 */     ServiceResult result = new ServiceResult();
/* 412 */     setResult(model, result);
/* 413 */     return "order/sell/sendgoods";
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_O_SELL_ORDERLIST_SENDGOODS})
/*     */   @RequestMapping(value={"order/sell/sendgoods"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @ResponseBody
/*     */   public AjaxResult sellSendgoodConfirm(@RequestParam("orderNo") String orderNo, UserAgent userAgent, ModelMap model)
/*     */   {
/* 428 */     AjaxResult result = new AjaxResult();
/* 429 */     TradeOrderBaseRequest request = new TradeOrderBaseRequest();
/* 430 */     request.setOrderNo(orderNo);
/* 431 */     request.setUserAccount(userAgent.getAccount());
/* 432 */     request.setOperator(userAgent.getAccount());
/* 433 */     request.setOperatorType(EnumOperatorType.USER.getValue());
/* 434 */     ServiceResult serviceResult = this.tradeOrderService.orderSendGoods(request);
/* 435 */     result.setServiceResult(serviceResult);
/* 436 */     return result;
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_O_BUY_ORDERLIST_PAYGOODS})
/*     */   @RequestMapping(value={"order/buy/paygoods"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String buyPaygoodsConfirmInit(@RequestParam("orderNo") String orderNo, UserAgent userAgent, ModelMap model)
/*     */   {
/* 450 */     TradeOrder tradeOrder = this.tradeOrderService.selectByOrderNo(orderNo);
/* 451 */     TradeOrderDetail detail = this.tradeOrderService.selectBuyerOrderDetailByOrderNo(orderNo, userAgent.getAccount());
/*     */ 
/* 453 */     if (null == detail) {
/* 454 */       return error(model, "trade.order.null", new String[0]);
/*     */     }
/* 456 */     model.addAttribute("enumPaymentTypeMap", EnumPaymentType.toMap());
/* 457 */     model.addAttribute("orderStatusMap", EnumTradeOrderStatus.toMap());
/* 458 */     model.addAttribute("tradingTypeMap", EnumTradingType.toMap());
/* 459 */     model.addAttribute("enumDeliveryTypeMap", EnumDeliveryType.toMap());
/* 460 */     model.addAttribute("tradeOrder", tradeOrder);
/* 461 */     model.addAttribute("tradeOrderDetail", detail);
/* 462 */     return "order/buy/paygoods";
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_O_BUY_ORDERLIST_PAYGOODS})
/*     */   @RequestMapping(value={"order/buy/paygoods"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @ResponseBody
/*     */   public AjaxResult buyPaygoodsConfirm(@RequestParam("orderNo") String orderNo, @RequestParam("payPwd") String payPwd, UserAgent userAgent, ModelMap model)
/*     */   {
/* 478 */     AjaxResult result = new AjaxResult();
/* 479 */     if (StringUtil.isEmpty(payPwd)) {
/* 480 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.INPUT_PAYPWD_EMPTY.getValue()));
/* 481 */       result.setErrorInfo(EnumTradeOrderResultErrors.INPUT_PAYPWD_EMPTY.getInfo());
/* 482 */       return result;
/*     */     }
/*     */ 
/* 485 */     TradeOrderBaseRequest request = new TradeOrderBaseRequest();
/* 486 */     request.setOrderNo(orderNo);
/* 487 */     request.setUserAccount(userAgent.getAccount());
/* 488 */     request.setOperator(userAgent.getAccount());
/* 489 */     request.setOperatorType(EnumOperatorType.USER.getValue());
/* 490 */     request.setPayPwd(payPwd);
/* 491 */     ServiceResult serviceResult = this.tradeOrderService.orderPay(request);
/*     */ 
/* 493 */     result.setServiceResult(serviceResult);
/* 494 */     return result;
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_O_BUY_ORDERLIST_CHECKGOODS})
/*     */   @RequestMapping(value={"order/buy/checkgoods"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String checkGoodsInput(@RequestParam("orderNo") String orderNo, UserAgent userAgent, ModelMap model)
/*     */   {
/* 508 */     TradeOrder tradeOrder = this.tradeOrderService.selectByOrderNo(orderNo);
/* 509 */     if ((null == tradeOrder) || (!userAgent.getAccount().equals(tradeOrder.getBuyerAccount()))) {
/* 510 */       model.addAttribute("errorInfo", error(model, "trade.order.null", new String[0]));
/*     */     }
/* 512 */     TradeOrderDetail detail = this.tradeOrderService.selectBuyerOrderDetailByOrderNo(orderNo, userAgent.getAccount());
/*     */ 
/* 515 */     if ((EnumPaymentType.OnLine.getValue().equalsIgnoreCase(tradeOrder.getPaymentType())) && (EnumHasEnabled.NEED.getValue().equalsIgnoreCase(tradeOrder.getHasInvoice())))
/*     */     {
/* 517 */       SystemDictRequest request = new SystemDictRequest();
/* 518 */       request.setParaCode(EnumSystemDictKey.GOODS_PAY_PROPORTION.getValue());
/* 519 */       SystemDictServiceResult result = this.remoteSystemBaseService.selectSingleByKey(request);
/* 520 */       BigDecimalUtil util = new BigDecimalUtil();
/* 521 */       if (result.correct()) {
/* 522 */         SystemDictDTO payProportion = result.getSystemDictDTO();
/* 523 */         if (payProportion.getParaValue() == null) {
/* 524 */           model.addAttribute("errorInfo", error(model, EnumTradeOrderResultErrors.CONFIG_GOODPAR_ERROR.getInfo(), new String[0]));
/*     */ 
/* 526 */           return "order/buy/checkgoods";
/*     */         }
/*     */         try {
/* 529 */           Long kk = Long.valueOf(new BigDecimal(payProportion.getParaValue()).longValue());
/* 530 */           if (kk.longValue() >= 10000L) {
/* 531 */             result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.CONFIG_GOODPAR_ERROR.getValue()));
/*     */ 
/* 533 */             result.setErrorInfo(EnumTradeOrderResultErrors.CONFIG_GOODPAR_ERROR.getInfo());
/*     */ 
/* 535 */             model.addAttribute("errorInfo", EnumTradeOrderResultErrors.CONFIG_GOODPAR_ERROR.getInfo());
/*     */ 
/* 537 */             return "order/buy/checkgoods";
/*     */           }
/*     */         } catch (Exception e) {
/* 540 */           result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.SERVER_ERROR.getValue()));
/* 541 */           result.setErrorInfo(EnumTradeOrderResultErrors.SERVER_ERROR.getInfo());
/* 542 */           model.addAttribute("errorInfo", EnumTradeOrderResultErrors.SERVER_ERROR.getInfo());
/*     */ 
/* 544 */           return "order/buy/checkgoods";
/*     */         }
/*     */ 
/* 548 */         BigDecimal paygodPro = new BigDecimal(payProportion.getParaValue()).movePointLeft(4);
/*     */ 
/* 550 */         BigDecimal goodsAmountSend = BigDecimalUtil.mul(new BigDecimal(tradeOrder.getOrderAmount().longValue()), paygodPro).setScale(0, 3);
/*     */ 
/* 552 */         BigDecimal goodsAmountHold = BigDecimalUtil.sub(new BigDecimal(tradeOrder.getOrderAmount().longValue()), goodsAmountSend);
/*     */ 
/* 554 */         String orderAmount = CommonUtils.getValuationUnitDesc(Long.valueOf(goodsAmountSend.longValue()), tradeOrder.getValuationUnit());
/*     */ 
/* 556 */         String otherOrderAmount = CommonUtils.getValuationUnitDesc(Long.valueOf(goodsAmountHold.longValue()), tradeOrder.getValuationUnit());
/*     */ 
/* 558 */         model.addAttribute("payProportion", new BigDecimal(payProportion.getParaValue()).movePointLeft(2));
/*     */ 
/* 560 */         model.addAttribute("orderAmount", orderAmount);
/* 561 */         model.addAttribute("otherOrderAmount", otherOrderAmount);
/*     */       }
/*     */       else {
/* 564 */         model.addAttribute("errorInfo", error(model, EnumTradeOrderResultErrors.SERVER_ERROR.getInfo(), new String[0]));
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 569 */       String orderAmount = CommonUtils.getValuationUnitDesc(Long.valueOf(tradeOrder.getOrderAmount().longValue()), tradeOrder.getValuationUnit());
/*     */ 
/* 571 */       model.addAttribute("orderAmount", orderAmount);
/*     */     }
/* 573 */     model.addAttribute("enumPaymentTypeMap", EnumPaymentType.toMap());
/* 574 */     model.addAttribute("orderStatusMap", EnumTradeOrderStatus.toMap());
/* 575 */     model.addAttribute("tradingTypeMap", EnumTradingType.toMap());
/* 576 */     model.addAttribute("enumDeliveryTypeMap", EnumDeliveryType.toMap());
/* 577 */     model.addAttribute("tradeOrder", tradeOrder);
/* 578 */     model.addAttribute("tradeOrderDetail", detail);
/* 579 */     return "order/buy/checkgoods";
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_O_BUY_ORDERLIST_CHECKGOODS})
/*     */   @RequestMapping(value={"order/buy/checkgoods"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @ResponseBody
/*     */   public AjaxResult checkgoods(@RequestParam("payPwd") String payPwd, @RequestParam("orderNo") String orderNo, UserAgent userAgent, Model model)
/*     */     throws Exception
/*     */   {
/* 592 */     AjaxResult result = new AjaxResult();
/* 593 */     TradeOrder tradeOrder = this.tradeOrderService.selectByOrderNo(orderNo);
/* 594 */     if ((null == tradeOrder) || (!userAgent.getAccount().equals(tradeOrder.getBuyerAccount()))) {
/* 595 */       result.setErrorInfo(getMessage("trade.order.null", new String[0]));
/* 596 */       return result;
/*     */     }
/* 598 */     if (StringUtil.isEmpty(payPwd)) {
/* 599 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.INPUT_PAYPWD_EMPTY.getValue()));
/* 600 */       result.setErrorInfo(EnumTradeOrderResultErrors.INPUT_PAYPWD_EMPTY.getInfo());
/* 601 */       return result;
/*     */     }
/*     */ 
/* 604 */     TradeOrderBaseRequest request = new TradeOrderBaseRequest();
/* 605 */     request.setOrderNo(tradeOrder.getOrderNo());
/* 606 */     request.setUserAccount(userAgent.getAccount());
/* 607 */     request.setOperator(userAgent.getAccount());
/* 608 */     request.setOperatorType(EnumOperatorType.USER.getValue());
/* 609 */     request.setPayPwd(payPwd);
/* 610 */     result.setServiceResult(this.tradeOrderService.orderGoodsValidate(request));
/* 611 */     return result;
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_O_BUY_ORDERLIST_CHECKTICKET})
/*     */   @RequestMapping({"order/buy/checkticket"})
/*     */   public String checkTicketInput(@RequestParam("orderNo") String orderNo, UserAgent userAgent, ModelMap model)
/*     */   {
/* 624 */     TradeOrder tradeOrder = this.tradeOrderService.selectByOrderNo(orderNo);
/* 625 */     if (!userAgent.getAccount().equals(tradeOrder.getBuyerAccount())) {
/* 626 */       model.addAttribute("errorInfo", error(model, "trade.order.null", new String[0]));
/*     */     }
/* 628 */     model.addAttribute("tradeOrder", tradeOrder);
/*     */ 
/* 630 */     TradeOrderDetail detail = this.tradeOrderService.selectBuyerOrderDetailByOrderNo(orderNo, userAgent.getAccount());
/*     */ 
/* 632 */     if ((EnumPaymentType.OnLine.getValue().equalsIgnoreCase(tradeOrder.getPaymentType())) && (EnumHasEnabled.NEED.getValue().equalsIgnoreCase(tradeOrder.getHasInvoice())))
/*     */     {
/* 635 */       TradeOrderMoney userMoney = this.tradeOrderMoneyDAO.selectByAccountOrderNo(orderNo, userAgent.getAccount());
/*     */ 
/* 637 */       String otherOrderAmount = CommonUtils.getValuationUnitDesc(userMoney.getGoodsAmount(), tradeOrder.getValuationUnit());
/*     */ 
/* 639 */       model.addAttribute("otherOrderAmount", otherOrderAmount);
/* 640 */       model.addAttribute("userMoney", userMoney);
/*     */     }
/* 642 */     model.addAttribute("enumPaymentTypeMap", EnumPaymentType.toMap());
/* 643 */     model.addAttribute("orderStatusMap", EnumTradeOrderStatus.toMap());
/* 644 */     model.addAttribute("tradingTypeMap", EnumTradingType.toMap());
/* 645 */     model.addAttribute("enumDeliveryTypeMap", EnumDeliveryType.toMap());
/* 646 */     model.addAttribute("tradeOrder", tradeOrder);
/* 647 */     model.addAttribute("tradeOrderDetail", detail);
/* 648 */     return "order/buy/checkticket";
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_O_BUY_ORDERLIST_CHECKTICKET})
/*     */   @RequestMapping(value={"order/buy/checkticket"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @ResponseBody
/*     */   public AjaxResult checkTicket(UserAgent userAgent, @RequestParam("payPwd") String payPwd, @RequestParam("orderNo") String orderNo, Model model)
/*     */     throws Exception
/*     */   {
/* 660 */     AjaxResult result = new AjaxResult();
/* 661 */     TradeOrder tradeOrder = this.tradeOrderService.selectByOrderNo(orderNo);
/* 662 */     if (!userAgent.getAccount().equals(tradeOrder.getBuyerAccount())) {
/* 663 */       model.addAttribute("errorInfo", error(model, "trade.order.null", new String[0]));
/*     */     }
/* 665 */     if (StringUtil.isEmpty(payPwd)) {
/* 666 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.INPUT_PAYPWD_EMPTY.getValue()));
/* 667 */       result.setErrorInfo(EnumTradeOrderResultErrors.INPUT_PAYPWD_EMPTY.getInfo());
/* 668 */       return result;
/*     */     }
/*     */ 
/* 671 */     TradeOrderBaseRequest request = new TradeOrderBaseRequest();
/* 672 */     request.setOrderNo(tradeOrder.getOrderNo());
/* 673 */     request.setUserAccount(userAgent.getAccount());
/* 674 */     request.setOperator(userAgent.getAccount());
/* 675 */     request.setOperatorType(EnumOperatorType.USER.getValue());
/* 676 */     request.setPayPwd(payPwd);
/* 677 */     result.setServiceResult(this.tradeOrderService.orderInvoiceValidate(request));
/* 678 */     return result;
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_O_BUY_ORDERLIST_DETAIL, com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_O_SELL_ORDERLIST_DETAIL})
/*     */   @RequestMapping({"order/detail"})
/*     */   public String orderDetailGuid(@RequestParam("orderNo") String orderNo, @RequestParam(value="url", required=false) String url, UserAgent userAgent, ModelMap model)
/*     */   {
/* 694 */     TradeOrder order = this.tradeOrderService.selectByOrderNo(orderNo);
/* 695 */     if (null == order) {
/* 696 */       model.addAttribute("url", url);
/* 697 */       return error(model, "trade.order.null", new String[0]);
/*     */     }
/* 699 */     if (userAgent.getAccount().equals(order.getSellerAccount()))
/* 700 */       return redirect("/order/sell/detail.htm?orderNo=" + orderNo);
/* 701 */     if (userAgent.getAccount().equals(order.getBuyerAccount())) {
/* 702 */       return redirect("/order/buy/detail.htm?orderNo=" + orderNo);
/*     */     }
/* 704 */     return error(model, "trade.order.null", new String[0]);
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.web.action.order.TradeOrderAction
 * JD-Core Version:    0.6.0
 */