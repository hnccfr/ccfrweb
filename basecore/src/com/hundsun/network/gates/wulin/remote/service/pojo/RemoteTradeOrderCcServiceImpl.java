/*    */ package com.hundsun.network.gates.wulin.remote.service.pojo;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumTradeOrderCcResultErrors;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.request.TradeOrderCcRequest;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.result.TradeOrderCcServiceResult;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteTradeOrderCcService;
/*    */ import com.hundsun.network.gates.wulin.biz.service.BaseService;
/*    */ import com.hundsun.network.gates.wulin.biz.service.order.TradeOrderCcService;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("remoteTradeOrderCcService")
/*    */ public class RemoteTradeOrderCcServiceImpl extends BaseService
/*    */   implements RemoteTradeOrderCcService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private TradeOrderCcService tradeOrderCcService;
/*    */ 
/*    */   public TradeOrderCcServiceResult addTradeOrderCc(TradeOrderCcRequest request)
/*    */   {
/* 19 */     TradeOrderCcServiceResult result = new TradeOrderCcServiceResult();
/* 20 */     if (null == request) {
/* 21 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderCcResultErrors.PARAMETER_ERROR.getValue()));
/* 22 */       result.setErrorInfo(EnumTradeOrderCcResultErrors.PARAMETER_ERROR.getInfo());
/* 23 */       return result;
/*    */     }
/* 25 */     return this.tradeOrderCcService.addTradeOrderCc(request);
/*    */   }
/*    */ 
/*    */   public TradeOrderCcServiceResult updateTradeOrderCc(TradeOrderCcRequest request) {
/* 29 */     TradeOrderCcServiceResult result = new TradeOrderCcServiceResult();
/* 30 */     if (null == request) {
/* 31 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderCcResultErrors.PARAMETER_ERROR.getValue()));
/* 32 */       result.setErrorInfo(EnumTradeOrderCcResultErrors.PARAMETER_ERROR.getInfo());
/* 33 */       return result;
/*    */     }
/* 35 */     return this.tradeOrderCcService.updateTradeOrderCc(request);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.remote.service.pojo.RemoteTradeOrderCcServiceImpl
 * JD-Core Version:    0.6.0
 */