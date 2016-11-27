/*     */ package com.hundsun.network.gates.wulin.remote.service.pojo;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumSystemBaseSetErrors;
/*     */ import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.TradeOrderDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.TradeOrderDetailDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumTradeOrderResultErrors;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumUserResultErrors;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.TradeOrderBaseRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.TradeOrderCashDepositRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.TradeOrderRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.TradeOrderCashDepositResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.TradeOrderFinishedServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.TradeOrderGoodAmountServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.TradeOrderServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteTradeOrderService;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.order.TradeOrder;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.order.TradeOrderDetail;
/*     */ import com.hundsun.network.gates.wulin.biz.service.BaseService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.order.TradeOrderService;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import org.apache.commons.beanutils.BeanUtils;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ @Service("remoteTradeOrderService")
/*     */ public class RemoteTradeOrderServiceImpl extends BaseService
/*     */   implements RemoteTradeOrderService
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private TradeOrderService tradeOrderService;
/*     */ 
/*     */   public TradeOrderServiceResult initAddOrder(TradeOrderRequest request)
/*     */   {
/*  41 */     TradeOrderServiceResult result = new TradeOrderServiceResult();
/*  42 */     TradeOrderDTO tradeOrderDTO = request.getTradeOrderDTO();
/*  43 */     TradeOrderDetailDTO tradeOrderDetailDTO = request.getTradeOrderDetailDTO();
/*  44 */     String operator = request.getOperator();
/*  45 */     Long buyTradeDeposit = request.getBuyTradeDeposit();
/*  46 */     Long sellTradeDeposit = request.getSellTradeDeposit();
/*  47 */     if ((tradeOrderDTO == null) || (tradeOrderDetailDTO == null)) {
/*  48 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.PARAMETER_ERROR.getValue()));
/*  49 */       result.setErrorInfo(EnumUserResultErrors.PARAMETER_ERROR.getInfo());
/*  50 */       this.log.error("TradeOrderServiceImpl initAddOrder error: " + result.getErrorInfo());
/*  51 */       return result;
/*     */     }
/*     */ 
/*  54 */     TradeOrder tradeOrder = new TradeOrder();
/*  55 */     TradeOrderDetail tradeOrderDetail = new TradeOrderDetail();
/*     */     try {
/*  57 */       BeanUtils.copyProperties(tradeOrder, tradeOrderDTO);
/*  58 */       BeanUtils.copyProperties(tradeOrderDetail, tradeOrderDetailDTO);
/*     */     } catch (IllegalAccessException e) {
/*  60 */       result.setErrorNO(Integer.valueOf(EnumSystemBaseSetErrors.OTHER_ERROR.getValue()));
/*  61 */       result.setErrorInfo(EnumSystemBaseSetErrors.OTHER_ERROR.getInfo());
/*  62 */       this.log.error("RemoteTradeOrderServiceImpl initAddOrder error:", e);
/*     */     } catch (InvocationTargetException e) {
/*  64 */       result.setErrorNO(Integer.valueOf(EnumSystemBaseSetErrors.OTHER_ERROR.getValue()));
/*  65 */       result.setErrorInfo(EnumSystemBaseSetErrors.OTHER_ERROR.getInfo());
/*  66 */       this.log.error("RemoteTradeOrderServiceImpl initAddOrder error:", e);
/*     */     }
/*  68 */     tradeOrder.setCreator(operator);
/*  69 */     tradeOrder.setOperator(operator);
/*  70 */     tradeOrderDetail.setOperator(operator);
/*  71 */     result = this.tradeOrderService.initAddOrder(tradeOrder, tradeOrderDetail, operator, buyTradeDeposit, sellTradeDeposit);
/*     */ 
/*  73 */     return result;
/*     */   }
/*     */ 
/*     */   public TradeOrderServiceResult rollbackOrder(TradeOrderRequest request)
/*     */   {
/*  82 */     TradeOrderServiceResult result = new TradeOrderServiceResult();
/*  83 */     String orderNo = request.getOrderNo();
/*  84 */     if (StringUtil.isBlank(orderNo)) {
/*  85 */       result.setErrorNO(Integer.valueOf(EnumUserResultErrors.PARAMETER_ERROR.getValue()));
/*  86 */       result.setErrorInfo(EnumUserResultErrors.PARAMETER_ERROR.getInfo());
/*  87 */       this.log.error("TradeOrderServiceImpl rollbackOrder error: " + result.getErrorInfo());
/*  88 */       return result;
/*     */     }
/*     */ 
/*  91 */     result = this.tradeOrderService.rollbackOrder(request);
/*  92 */     return result;
/*     */   }
/*     */ 
/*     */   public TradeOrderCashDepositResult queryOrderCashDeposit(TradeOrderCashDepositRequest request)
/*     */   {
/*  97 */     TradeOrderCashDepositResult result = new TradeOrderCashDepositResult();
/*     */     try {
/*  99 */       result = this.tradeOrderService.queryOrderCashDeposit(request);
/*     */     } catch (Exception e) {
/* 101 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.INTERNAL_ERROR.getValue()));
/* 102 */       result.setErrorInfo(EnumTradeOrderResultErrors.INTERNAL_ERROR.getInfo());
/* 103 */       this.log.error("TradeOrderServiceImpl orderClose error: " + result.getErrorInfo());
/* 104 */       return result;
/*     */     }
/* 106 */     return result;
/*     */   }
/*     */ 
/*     */   public ServiceResult orderConfirm(TradeOrderRequest request)
/*     */   {
/* 111 */     ServiceResult result = new ServiceResult();
/* 112 */     if ((null == request) || (StringUtil.isEmpty(request.getOrderNo())) || (StringUtil.isEmpty(request.getUserAccount())))
/*     */     {
/* 114 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.PARAMETER_ERROR.getValue()));
/* 115 */       result.setErrorInfo(EnumTradeOrderResultErrors.PARAMETER_ERROR.getInfo());
/* 116 */       this.log.error("TradeOrderServiceImpl orderConfirm error: " + result.getErrorInfo());
/* 117 */       return result;
/*     */     }
/*     */     try {
/* 120 */       result = this.tradeOrderService.orderConfirm(request);
/*     */     } catch (Exception e) {
/* 122 */       e.printStackTrace();
/* 123 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.INTERNAL_ERROR.getValue()));
/* 124 */       result.setErrorInfo(EnumTradeOrderResultErrors.INTERNAL_ERROR.getInfo());
/* 125 */       this.log.error("TradeOrderServiceImpl orderConfirm error: " + result.getErrorInfo());
/* 126 */       return result;
/*     */     }
/* 128 */     return result;
/*     */   }
/*     */ 
/*     */   public TradeOrderFinishedServiceResult orderClose(TradeOrderBaseRequest request)
/*     */   {
/* 137 */     TradeOrderFinishedServiceResult result = new TradeOrderFinishedServiceResult();
/*     */     try {
/* 139 */       result = this.tradeOrderService.orderClose(request);
/*     */     } catch (Exception e) {
/* 141 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.INTERNAL_ERROR.getValue()));
/* 142 */       result.setErrorInfo(EnumTradeOrderResultErrors.INTERNAL_ERROR.getInfo());
/* 143 */       this.log.error("TradeOrderServiceImpl orderClose error: " + result.getErrorInfo());
/* 144 */       return result;
/*     */     }
/* 146 */     return result;
/*     */   }
/*     */ 
/*     */   public TradeOrderGoodAmountServiceResult orderGoodsValidate(TradeOrderBaseRequest request)
/*     */   {
/* 164 */     TradeOrderGoodAmountServiceResult result = new TradeOrderGoodAmountServiceResult();
/*     */     try {
/* 166 */       result = this.tradeOrderService.orderGoodsValidate(request);
/*     */     } catch (Exception e) {
/* 168 */       this.log.error("TradeOrderServiceImpl orderGoodsValidate error:", e);
/* 169 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.INTERNAL_ERROR.getValue()));
/* 170 */       result.setErrorInfo(EnumTradeOrderResultErrors.INTERNAL_ERROR.getInfo());
/* 171 */       this.log.error("TradeOrderServiceImpl orderGoodsValidate error: " + result.getErrorInfo());
/* 172 */       return result;
/*     */     }
/* 174 */     return result;
/*     */   }
/*     */ 
/*     */   public TradeOrderGoodAmountServiceResult orderInvoiceValidate(TradeOrderBaseRequest request)
/*     */   {
/* 183 */     TradeOrderGoodAmountServiceResult result = new TradeOrderGoodAmountServiceResult();
/*     */     try {
/* 185 */       result = this.tradeOrderService.orderInvoiceValidate(request);
/*     */     } catch (Exception e) {
/* 187 */       this.log.error("TradeOrderServiceImpl orderInvoiceValidate error:", e);
/* 188 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.INTERNAL_ERROR.getValue()));
/* 189 */       result.setErrorInfo(EnumTradeOrderResultErrors.INTERNAL_ERROR.getInfo());
/* 190 */       this.log.error("TradeOrderServiceImpl orderInvoiceValidate error: " + result.getErrorInfo());
/* 191 */       return result;
/*     */     }
/* 193 */     return result;
/*     */   }
/*     */ 
/*     */   public ServiceResult orderPay(TradeOrderBaseRequest request)
/*     */   {
/* 202 */     ServiceResult result = new ServiceResult();
/*     */     try {
/* 204 */       result = this.tradeOrderService.orderPay(request);
/*     */     } catch (Exception e) {
/* 206 */       this.log.error("TradeOrderServiceImpl orderPay error:", e);
/* 207 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.INTERNAL_ERROR.getValue()));
/* 208 */       result.setErrorInfo(EnumTradeOrderResultErrors.INTERNAL_ERROR.getInfo());
/* 209 */       this.log.error("TradeOrderServiceImpl orderPay error: " + result.getErrorInfo());
/* 210 */       return result;
/*     */     }
/* 212 */     return result;
/*     */   }
/*     */ 
/*     */   public ServiceResult orderSendGoods(TradeOrderBaseRequest request)
/*     */   {
/* 221 */     ServiceResult result = new ServiceResult();
/*     */     try {
/* 223 */       result = this.tradeOrderService.orderSendGoods(request);
/*     */     } catch (Exception e) {
/* 225 */       this.log.error("TradeOrderServiceImpl orderSendGoods error:", e);
/* 226 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.INTERNAL_ERROR.getValue()));
/* 227 */       result.setErrorInfo(EnumTradeOrderResultErrors.INTERNAL_ERROR.getInfo());
/* 228 */       this.log.error("TradeOrderServiceImpl orderSendGoods error: " + result.getErrorInfo());
/* 229 */       return result;
/*     */     }
/* 231 */     return result;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.remote.service.pojo.RemoteTradeOrderServiceImpl
 * JD-Core Version:    0.6.0
 */