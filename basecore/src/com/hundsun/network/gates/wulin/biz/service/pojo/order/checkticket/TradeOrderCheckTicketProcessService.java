/*    */ package com.hundsun.network.gates.wulin.biz.service.pojo.order.checkticket;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.enums.EnumPaymentType;
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
/*    */ @Service("tradeOrderCheckTicketProcessService")
/*    */ public class TradeOrderCheckTicketProcessService extends BaseService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private TradeOrderOnlineCheckTicketImpl tradeOrderOnlineCheckTicketImpl;
/*    */ 
/*    */   @Autowired
/*    */   private TradeOrderOfflineCheckTicketImpl tradeOrderOfflineCheckTicketImpl;
/*    */ 
/*    */   @Autowired
/*    */   private TradeOrderService tradeOrderService;
/*    */ 
/*    */   public TradeOrderGoodAmountServiceResult process(TradeOrderBaseRequest request)
/*    */   {
/* 45 */     TradeOrderGoodAmountServiceResult result = new TradeOrderGoodAmountServiceResult();
/* 46 */     String operator = request.getOperator();
/*    */ 
/* 48 */     String orderNo = request.getOrderNo();
/* 49 */     String userAccount = request.getUserAccount();
/*    */ 
/* 51 */     if ((null == request) || (StringUtil.isEmpty(operator)) || (StringUtil.isEmpty(userAccount)) || (StringUtil.isEmpty(orderNo)))
/*    */     {
/* 53 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.PARAMETER_ERROR.getValue()));
/* 54 */       result.setErrorInfo(EnumTradeOrderResultErrors.PARAMETER_ERROR.getInfo());
/* 55 */       this.log.error("TradeOrderServiceImpl orderInvoiceValidate error: " + result.getErrorInfo());
/* 56 */       return result;
/*    */     }
/* 58 */     TradeOrder tradeOrder = this.tradeOrderService.selectByOrderNo(orderNo);
/*    */ 
/* 60 */     if (!EnumTradeOrderStatus.WAIT_CHECKTICKET.getValue().equalsIgnoreCase(tradeOrder.getStatus()))
/*    */     {
/* 62 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.STATUS_ERROR_DATA.getValue()));
/* 63 */       result.setErrorInfo(EnumTradeOrderResultErrors.STATUS_ERROR_DATA.getInfo());
/* 64 */       return result;
/*    */     }
/* 66 */     if (tradeOrder == null) {
/* 67 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.PARAMETER_ERROR.getValue()));
/* 68 */       result.setErrorInfo(EnumTradeOrderResultErrors.PARAMETER_ERROR.getInfo());
/* 69 */       return result;
/*    */     }
/* 71 */     if (EnumPaymentType.OnLine.getValue().equalsIgnoreCase(tradeOrder.getPaymentType()))
/*    */     {
/* 73 */       return this.tradeOrderOnlineCheckTicketImpl.process(request, tradeOrder);
/* 74 */     }if (!EnumPaymentType.OnLine.getValue().equalsIgnoreCase(tradeOrder.getPaymentType()))
/*    */     {
/* 76 */       return this.tradeOrderOfflineCheckTicketImpl.process(request, tradeOrder);
/*    */     }
/* 78 */     return result;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.pojo.order.checkticket.TradeOrderCheckTicketProcessService
 * JD-Core Version:    0.6.0
 */