/*    */ package com.hundsun.network.gates.wulin.biz.service.pojo.order.penaltycheckgoods;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeOrderCcDealType;
/*    */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeOrderStatus;
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
/*    */ @Service("penaltyCheckGoodsProcessService")
/*    */ public class PenaltyCheckGoodsProcessService extends BaseService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private PenaltyCheckGoodsAmountServiceImpl penaltyCheckGoodsAmountServiceImpl;
/*    */ 
/*    */   @Autowired
/*    */   private PenaltyCheckGoodsPenaltyServiceImpl penaltyCheckGoodsPenaltyServiceImpl;
/*    */ 
/*    */   @Autowired
/*    */   private PenaltyCheckGoodsAmountLessServiceImpl penaltyCheckGoodsAmountLessServiceImpl;
/*    */ 
/*    */   @Autowired
/*    */   private TradeOrderService tradeOrderService;
/*    */ 
/*    */   public TradeOrderGoodAmountServiceResult process(TradeOrderBaseRequest request)
/*    */   {
/* 45 */     TradeOrderGoodAmountServiceResult result = new TradeOrderGoodAmountServiceResult();
/* 46 */     String orderNo = request.getOrderNo();
/* 47 */     String operKey = request.getOperKey();
/* 48 */     String operator = request.getOperator();
/*    */ 
/* 52 */     if ((request == null) || (StringUtil.isEmpty(operator)) || (StringUtil.isEmpty(operKey)) || 
/* 53 */       (StringUtil.isEmpty(orderNo))) {
/* 54 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.PARAMETER_ERROR.getValue()));
/* 55 */       result.setErrorInfo(EnumTradeOrderResultErrors.PARAMETER_ERROR.getInfo());
/* 56 */       this.log.error("PenaltyCheckGoodsProcessService.process() error: " + result.getErrorInfo());
/* 57 */       return result;
/*    */     }
/* 59 */     TradeOrder tradeOrder = this.tradeOrderService.selectByOrderNo(orderNo);
/* 60 */     if (!EnumTradeOrderStatus.WAIT_CHECKGOODS.getValue().equals(tradeOrder.getStatus()))
/*    */     {
/* 62 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.STATUS_ERROR_DATA.getValue()));
/* 63 */       result.setErrorInfo(EnumTradeOrderResultErrors.STATUS_ERROR_DATA.getInfo());
/* 64 */       return result;
/*    */     }
/* 66 */     if (EnumTradeOrderCcDealType.DEFAULT_SELLER_GOODS_REFUND.getValue().equals(operKey))
/*    */     {
/* 68 */       return this.penaltyCheckGoodsAmountServiceImpl.process(request, tradeOrder);
/* 69 */     }if (EnumTradeOrderCcDealType.DEFAULT_SELLER_GOODS_REFUND_PENALTY.getValue().equals(operKey))
/*    */     {
/* 71 */       return this.penaltyCheckGoodsPenaltyServiceImpl.process(request, tradeOrder);
/* 72 */     }if (EnumTradeOrderCcDealType.DEFAULT_SELLER_DOODS_ARIVAL_AMOUNT.getValue().equals(operKey))
/*    */     {
/* 74 */       return this.penaltyCheckGoodsAmountLessServiceImpl.process(request, tradeOrder);
/*    */     }
/* 76 */     return result;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.pojo.order.penaltycheckgoods.PenaltyCheckGoodsProcessService
 * JD-Core Version:    0.6.0
 */