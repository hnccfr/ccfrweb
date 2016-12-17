/*    */ package com.hundsun.network.gates.taiping.biz.service.pojo.placeorder;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.enums.EnumTradingType;
/*    */ import com.hundsun.network.gates.luosi.taiping.reomte.enums.EnumTradeError;
/*    */ import com.hundsun.network.gates.luosi.taiping.reomte.result.OrderServiceResult;
/*    */ import com.hundsun.network.gates.luosi.wangjiang.reomte.dto.PlaceOrderDTO;
/*    */ import com.hundsun.network.gates.luosi.wangjiang.reomte.request.TradeRequest;
/*    */ import com.hundsun.network.gates.luosi.wangjiang.reomte.service.RemoteTradeService;
/*    */ import com.hundsun.network.gates.taiping.biz.domain.placeorder.PlaceOrderInput;
/*    */ import com.hundsun.network.gates.taiping.biz.service.BaseService;
/*    */ import com.hundsun.network.gates.taiping.biz.service.trade.TradeAdapter;
/*    */ import com.hundsun.network.gates.taiping.common.util.ConvertUtils;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ 
/*    */ public class PlaceOrderAdapterImpl extends BaseService
/*    */   implements TradeAdapter<PlaceOrderInput>
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private RemoteTradeService remoteTradeService;
/*    */ 
/*    */   public OrderServiceResult bargain(PlaceOrderInput placeOrderInput)
/*    */   {
/* 28 */     OrderServiceResult result = new OrderServiceResult();
/* 29 */     PlaceOrderDTO placeOrderDTO = new PlaceOrderDTO();
/*    */     try {
/* 31 */       placeOrderDTO = ConvertUtils.converntProjectInput2ProjectDTO(placeOrderInput);
/*    */     } catch (Exception e) {
/* 33 */       this.log.error("placeOrderInput 转换出错 placeOrderDTO ", e);
/* 34 */       result.setErrorInfo("placeOrderInput 转换出错 placeOrderDTO");
/*    */     }
/* 36 */     TradeRequest request = new TradeRequest();
/* 37 */     request.setTradeDTO(placeOrderDTO);
/* 38 */     request.setFunId(EnumTradingType.PLACE_ORDER.getValue());
/* 39 */     if (this.log.isInfoEnabled()) {
/* 40 */       this.log.info("--Do placeOrder in fengshan at PlceOrderadater:invoke remote method :remoteTradeService.bargain(request)!--");
/*    */     }
/* 42 */     result = this.remoteTradeService.bargain(request);
/* 43 */     if (this.log.isInfoEnabled()) {
/* 44 */       this.log.info("--invoke remote mehod over--");
/*    */     }
/* 46 */     if (result == null) {
/* 47 */       result = new OrderServiceResult();
/* 48 */       result.setErrorNOInfo(Integer.valueOf(EnumTradeError.REMOTE_CALL_ERROR.getValue()), EnumTradeError.REMOTE_CALL_ERROR.getName());
/*    */     }
/*    */ 
/* 51 */     return result;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.taiping.biz.service.pojo.placeorder.PlaceOrderAdapterImpl
 * JD-Core Version:    0.6.0
 */