/*     */ package com.hundsun.network.gates.genshan.biz.service.pojo.order;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.dao.order.TradeOrderDAO;
/*     */ import com.hundsun.network.gates.genshan.biz.dao.order.TradeOrderDetailDAO;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.order.TradeOrder;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.order.TradeOrderDetail;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.query.TradeOrderQuery;
/*     */ import com.hundsun.network.gates.genshan.biz.service.BaseService;
/*     */ import com.hundsun.network.gates.genshan.biz.service.order.TradeOrderService;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumSystemBaseSetErrors;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeCommonErrors;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeOrderStatus;
/*     */ import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumTradeOrderResultErrors;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.TradeOrderBaseRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.TradeOrderCashDepositRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.TradeOrderRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.TradeOrderCashDepositResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.TradeOrderServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteTradeOrderService;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ @Service("tradeOrderService")
/*     */ public class TradeOrderServiceImpl extends BaseService
/*     */   implements TradeOrderService
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private TradeOrderDAO tradeOrderDAO;
/*     */ 
/*     */   @Autowired
/*     */   private TradeOrderDetailDAO tradeOrderDetailDAO;
/*     */ 
/*     */   @Autowired
/*     */   private RemoteTradeOrderService remoteTradeOrderService;
/*     */ 
/*     */   public void queryTradeOrder(TradeOrderQuery query)
/*     */   {
/*  41 */     this.tradeOrderDAO.queryTradeOrder(query);
/*     */   }
/*     */ 
/*     */   public TradeOrder selectByOrderNo(String orderNo)
/*     */   {
/*  46 */     return this.tradeOrderDAO.selectByOrderNo(orderNo);
/*     */   }
/*     */ 
/*     */   public TradeOrderDetail selectDetailByOrderNo(String orderNo)
/*     */   {
/*  51 */     return this.tradeOrderDetailDAO.selectByOrderNo(orderNo);
/*     */   }
/*     */ 
/*     */   public TradeOrderDetail selectBuyerOrderDetailByOrderNo(String orderNo, String buyerAccount)
/*     */   {
/*  56 */     Map map = new HashMap();
/*  57 */     map.put("orderNo", orderNo);
/*  58 */     map.put("buyerAccount", buyerAccount);
/*  59 */     return this.tradeOrderDetailDAO.selectOrderByMapParam(map);
/*     */   }
/*     */ 
/*     */   public TradeOrderDetail selectSellerOrderDetailByOrderNo(String orderNo, String sellerAccount)
/*     */   {
/*  64 */     Map map = new HashMap();
/*  65 */     map.put("orderNo", orderNo);
/*  66 */     map.put("sellerAccount", sellerAccount);
/*  67 */     return this.tradeOrderDetailDAO.selectOrderByMapParam(map);
/*     */   }
/*     */ 
/*     */   public ServiceResult orderConfirm(String userAccount, String fundAccount, String orderNo)
/*     */   {
/*  79 */     ServiceResult serviceResult = new ServiceResult();
/*  80 */     TradeOrderRequest request = new TradeOrderRequest();
/*  81 */     if ((StringUtil.isEmpty(userAccount)) || (StringUtil.isEmpty(orderNo))) {
/*  82 */       serviceResult.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.PARAMETER_ERROR.getValue()));
/*  83 */       serviceResult.setErrorInfo(EnumTradeOrderResultErrors.PARAMETER_ERROR.getInfo());
/*  84 */       return serviceResult;
/*     */     }
/*  86 */     request.setUserAccount(userAccount);
/*  87 */     request.setOrderNo(orderNo);
/*  88 */     request.setFundAccount(fundAccount);
/*     */     try {
/*  90 */       serviceResult = this.remoteTradeOrderService.orderConfirm(request);
/*     */     } catch (Exception e) {
/*  92 */       serviceResult.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.SERVER_ERROR.getValue()));
/*  93 */       serviceResult.setErrorInfo(EnumTradeOrderResultErrors.SERVER_ERROR.getInfo());
/*  94 */       return serviceResult;
/*     */     }
/*  96 */     return serviceResult;
/*     */   }
/*     */ 
/*     */   public TradeOrderServiceResult sendgood(String userAccount, String orderNo)
/*     */   {
/* 110 */     TradeOrderServiceResult result = new TradeOrderServiceResult();
/* 111 */     TradeOrder tradeOrder = this.tradeOrderDAO.selectByOrderNo(orderNo);
/* 112 */     if ((!EnumTradeOrderStatus.WAIT_PAYCONFIRM.getValue().equals(tradeOrder.getStatus())) && (!EnumTradeOrderStatus.WAIT_PAYGOODS.getValue().equals(tradeOrder.getStatus())))
/*     */     {
/* 115 */       result.setErrorNO(Integer.valueOf(EnumTradeCommonErrors.STATUS_ERROR_DATA.getValue()));
/* 116 */       result.setErrorInfo(EnumTradeCommonErrors.STATUS_ERROR_DATA.getInfo());
/*     */     }
/*     */ 
/* 119 */     TradeOrder order = new TradeOrder();
/* 120 */     order.setOrderNo(orderNo);
/* 121 */     order.setStatus(EnumTradeOrderStatus.WAIT_CHECKGOODS.getValue());
/* 122 */     int aa = this.tradeOrderDAO.updateByOrderNo(order);
/* 123 */     if (aa > 0) {
/* 124 */       return result;
/*     */     }
/* 126 */     result.setErrorNO(Integer.valueOf(EnumSystemBaseSetErrors.OTHER_ERROR.getValue()));
/* 127 */     result.setErrorInfo(EnumSystemBaseSetErrors.OTHER_ERROR.getInfo());
/* 128 */     return result;
/*     */   }
/*     */ 
/*     */   public TradeOrderServiceResult paygoods(String userAccount, String orderNo, String payPwd)
/*     */   {
/* 144 */     TradeOrderServiceResult result = new TradeOrderServiceResult();
/*     */ 
/* 147 */     TradeOrder order = new TradeOrder();
/* 148 */     order.setOrderNo(orderNo);
/* 149 */     order.setStatus(EnumTradeOrderStatus.WAIT_SENDGOODS.getValue());
/* 150 */     this.tradeOrderDAO.updateByOrderNo(order);
/* 151 */     return result;
/*     */   }
/*     */ 
/*     */   public TradeOrderServiceResult checkgoods(String userAccount, String orderNo, String payPwd)
/*     */   {
/* 165 */     TradeOrderServiceResult result = new TradeOrderServiceResult();
/* 166 */     TradeOrder order = this.tradeOrderDAO.selectByOrderNo(orderNo);
/*     */ 
/* 168 */     Long orderAmount = order.getOrderAmount();
/* 169 */     order.setStatus(EnumTradeOrderStatus.WAIT_CHECKTICKET.getValue());
/* 170 */     this.tradeOrderDAO.updateByOrderNo(order);
/* 171 */     return result;
/*     */   }
/*     */ 
/*     */   public TradeOrderServiceResult checkticket(String userAccount, String orderNo, String payPwd)
/*     */   {
/* 185 */     TradeOrderServiceResult result = new TradeOrderServiceResult();
/*     */ 
/* 187 */     TradeOrder order = new TradeOrder();
/*     */ 
/* 189 */     Long orderAmount = order.getOrderAmount();
/* 190 */     order.setStatus(EnumTradeOrderStatus.FINISHED.getValue());
/* 191 */     this.tradeOrderDAO.updateByOrderNo(order);
/* 192 */     return result;
/*     */   }
/*     */ 
/*     */   public TradeOrderCashDepositResult queryBuyerOrderCashDeposit(String orderNo, String userAccount)
/*     */   {
/* 197 */     TradeOrderCashDepositRequest request = new TradeOrderCashDepositRequest();
/* 198 */     TradeOrderCashDepositResult result = new TradeOrderCashDepositResult();
/* 199 */     if ((StringUtil.isEmpty(userAccount)) || (StringUtil.isEmpty(orderNo))) {
/* 200 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.PARAMETER_ERROR.getValue()));
/* 201 */       result.setErrorInfo(EnumTradeOrderResultErrors.PARAMETER_ERROR.getInfo());
/* 202 */       return result;
/*     */     }
/* 204 */     request.setBuyerAccount(userAccount);
/* 205 */     request.setOrderNo(orderNo);
/*     */     try {
/* 207 */       result = this.remoteTradeOrderService.queryOrderCashDeposit(request);
/*     */     } catch (Exception e) {
/* 209 */       e.printStackTrace();
/* 210 */       this.log.error("", e);
/* 211 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.SERVER_ERROR.getValue()));
/* 212 */       result.setErrorInfo(EnumTradeOrderResultErrors.SERVER_ERROR.getInfo());
/* 213 */       return result;
/*     */     }
/* 215 */     return result;
/*     */   }
/*     */ 
/*     */   public TradeOrderCashDepositResult querySellerOrderCashDeposit(String orderNo, String userAccount)
/*     */   {
/* 221 */     TradeOrderCashDepositRequest request = new TradeOrderCashDepositRequest();
/* 222 */     TradeOrderCashDepositResult result = new TradeOrderCashDepositResult();
/* 223 */     if ((StringUtil.isEmpty(userAccount)) || (StringUtil.isEmpty(orderNo))) {
/* 224 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.PARAMETER_ERROR.getValue()));
/* 225 */       result.setErrorInfo(EnumTradeOrderResultErrors.PARAMETER_ERROR.getInfo());
/* 226 */       return result;
/*     */     }
/* 228 */     request.setSellerAccount(userAccount);
/* 229 */     request.setOrderNo(orderNo);
/*     */     try {
/* 231 */       result = this.remoteTradeOrderService.queryOrderCashDeposit(request);
/*     */     } catch (Exception e) {
/* 233 */       e.printStackTrace();
/* 234 */       this.log.error("", e);
/* 235 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.SERVER_ERROR.getValue()));
/* 236 */       result.setErrorInfo(EnumTradeOrderResultErrors.SERVER_ERROR.getInfo());
/* 237 */       return result;
/*     */     }
/* 239 */     return result;
/*     */   }
/*     */ 
/*     */   public ServiceResult orderGoodsValidate(TradeOrderBaseRequest request)
/*     */   {
/* 248 */     ServiceResult result = new ServiceResult();
/*     */     try {
/* 250 */       result = this.remoteTradeOrderService.orderGoodsValidate(request);
/*     */     } catch (Exception e) {
/* 252 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.SERVER_ERROR.getValue()));
/* 253 */       result.setErrorInfo(EnumTradeOrderResultErrors.SERVER_ERROR.getInfo());
/*     */     }
/* 255 */     return result;
/*     */   }
/*     */ 
/*     */   public ServiceResult orderInvoiceValidate(TradeOrderBaseRequest request)
/*     */   {
/* 264 */     ServiceResult result = new ServiceResult();
/*     */     try {
/* 266 */       result = this.remoteTradeOrderService.orderInvoiceValidate(request);
/*     */     } catch (Exception e) {
/* 268 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.SERVER_ERROR.getValue()));
/* 269 */       result.setErrorInfo(EnumTradeOrderResultErrors.SERVER_ERROR.getInfo());
/*     */     }
/* 271 */     return result;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.service.pojo.order.TradeOrderServiceImpl
 * JD-Core Version:    0.6.0
 */