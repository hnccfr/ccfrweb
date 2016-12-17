/*    */ package com.hundsun.network.gates.wulin.remote.service.pojo;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumTradeOrderResultErrors;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.request.TradeWishOrderRequest;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.result.TradeWishOrderServiceResult;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteTradeWishOrderService;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.trade.TradeWishOrder;
/*    */ import com.hundsun.network.gates.wulin.biz.service.BaseService;
/*    */ import com.hundsun.network.gates.wulin.biz.service.trade.TradeWishOrderService;
/*    */ import com.hundsun.network.gates.wulin.common.utils.ConvertUtils;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("remoteTradeWishOrderService")
/*    */ public class RemoteTradeWishOrderServiceImpl extends BaseService
/*    */   implements RemoteTradeWishOrderService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private TradeWishOrderService tradeWishOrderService;
/*    */ 
/*    */   public TradeWishOrderServiceResult saveTradeWishOrder(TradeWishOrderRequest request)
/*    */   {
/* 24 */     TradeWishOrderServiceResult result = new TradeWishOrderServiceResult();
/* 25 */     if (null == request) {
/* 26 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.PARAMETER_ERROR.getValue()));
/* 27 */       result.setErrorInfo(EnumTradeOrderResultErrors.PARAMETER_ERROR.getInfo());
/* 28 */       return result;
/*    */     }
/* 30 */     TradeWishOrder tradeWishOrder = ConvertUtils.convertTradeWishOrderDTO2TradeWishOrder(request);
/*    */ 
/* 32 */     result = this.tradeWishOrderService.addTradeWishOrder(tradeWishOrder);
/* 33 */     return result;
/*    */   }
/*    */ 
/*    */   public TradeWishOrderServiceResult rollbackClearWishOrder(TradeWishOrderRequest toRequest)
/*    */   {
/* 38 */     return null;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.remote.service.pojo.RemoteTradeWishOrderServiceImpl
 * JD-Core Version:    0.6.0
 */