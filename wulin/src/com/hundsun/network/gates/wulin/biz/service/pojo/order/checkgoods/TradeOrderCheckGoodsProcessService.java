/*    */ package com.hundsun.network.gates.wulin.biz.service.pojo.order.checkgoods;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.enums.EnumHasEnabled;
/*    */ import com.hundsun.network.gates.luosi.common.enums.EnumPaymentType;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumTradeOrderResultErrors;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.request.TradeOrderBaseRequest;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.result.TradeOrderGoodAmountServiceResult;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.order.TradeOrder;
/*    */ import com.hundsun.network.gates.wulin.biz.service.BaseService;
/*    */ import com.hundsun.network.gates.wulin.biz.service.order.TradeOrderService;
/*    */ import com.hundsun.network.melody.common.util.StringUtil;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("tradeOrderCheckGoodsProcessService")
/*    */ public class TradeOrderCheckGoodsProcessService extends BaseService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private TradeOrderOfflineCheckGoodsNoInvoiceImpl tradeOrderOfflineCheckGoodsNoInvoiceImpl;
/*    */ 
/*    */   @Autowired
/*    */   private TradeOrderOfflineCheckGoodsInvoiceImpl tradeOrderOfflineCheckGoodsInvoiceImpl;
/*    */ 
/*    */   @Autowired
/*    */   private TradeOrderOnlineCheckGoodsInvoiceImpl tradeOrderOnlineCheckGoodsInvoiceImpl;
/*    */ 
/*    */   @Autowired
/*    */   private TradeOrderOnlineCheckGoodsNoInvoiceImpl tradeOrderOnlineCheckGoodsNoInvoiceImpl;
/*    */ 
/*    */   @Autowired
/*    */   private TradeOrderService tradeOrderService;
/*    */ 
/*    */   public TradeOrderGoodAmountServiceResult process(TradeOrderBaseRequest request)
/*    */   {
/* 50 */     TradeOrderGoodAmountServiceResult result = new TradeOrderGoodAmountServiceResult();
/* 51 */     String operator = request.getOperator();
/*    */ 
/* 53 */     String orderNo = request.getOrderNo();
/* 54 */     String userAccount = request.getUserAccount();
/*    */ 
/* 56 */     if ((request == null) || (StringUtil.isEmpty(operator)) || (StringUtil.isEmpty(userAccount)) || 
/* 57 */       (StringUtil.isEmpty(orderNo))) {
/* 58 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.PARAMETER_ERROR.getValue()));
/* 59 */       result.setErrorInfo(EnumTradeOrderResultErrors.PARAMETER_ERROR.getInfo());
/* 60 */       this.log.error("TradeOrderServiceImpl orderGoodsValidate error: " + result.getErrorInfo());
/* 61 */       return result;
/*    */     }
/* 63 */     TradeOrder tradeOrder = this.tradeOrderService.selectByOrderNo(orderNo);
/* 64 */     if (tradeOrder == null) {
/* 65 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.PARAMETER_ERROR.getValue()));
/* 66 */       result.setErrorInfo(EnumTradeOrderResultErrors.PARAMETER_ERROR.getInfo());
/* 67 */       return result;
/*    */     }
/* 69 */     if ((EnumHasEnabled.NO_NEED.getValue().equals(tradeOrder.getHasInvoice())) && 
/* 70 */       (!EnumPaymentType.OnLine.getValue().equalsIgnoreCase(tradeOrder.getPaymentType())))
/*    */     {
/* 72 */       return this.tradeOrderOfflineCheckGoodsNoInvoiceImpl.process(request, tradeOrder);
/* 73 */     }if ((EnumHasEnabled.NEED.getValue().equals(tradeOrder.getHasInvoice())) && 
/* 74 */       (!EnumPaymentType.OnLine.getValue().equalsIgnoreCase(tradeOrder.getPaymentType())))
/*    */     {
/* 76 */       return this.tradeOrderOfflineCheckGoodsInvoiceImpl.process(request, tradeOrder);
/* 77 */     }if ((EnumHasEnabled.NEED.getValue().equals(tradeOrder.getHasInvoice())) && 
/* 78 */       (EnumPaymentType.OnLine.getValue().equalsIgnoreCase(
/* 79 */       tradeOrder.getPaymentType())))
/*    */     {
/* 81 */       return this.tradeOrderOnlineCheckGoodsInvoiceImpl.process(request, tradeOrder);
/* 82 */     }if ((EnumHasEnabled.NO_NEED.getValue().equals(tradeOrder.getHasInvoice())) && 
/* 83 */       (EnumPaymentType.OnLine.getValue().equalsIgnoreCase(
/* 84 */       tradeOrder.getPaymentType())))
/*    */     {
/* 86 */       return this.tradeOrderOnlineCheckGoodsNoInvoiceImpl.process(request, tradeOrder);
/*    */     }
/* 88 */     return result;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.pojo.order.checkgoods.TradeOrderCheckGoodsProcessService
 * JD-Core Version:    0.6.0
 */