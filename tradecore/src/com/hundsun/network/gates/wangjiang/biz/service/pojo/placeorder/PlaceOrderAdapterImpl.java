/*    */ package com.hundsun.network.gates.wangjiang.biz.service.pojo.placeorder;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.biz.service.TradeAdapter;
/*    */ import com.hundsun.network.gates.luosi.common.enums.EnumTradingType;
/*    */ import com.hundsun.network.gates.luosi.qingbo.reomte.dto.PlaceOrderTradeDTO;
/*    */ import com.hundsun.network.gates.luosi.qingbo.reomte.request.TradeRequest;
/*    */ import com.hundsun.network.gates.luosi.qingbo.reomte.service.RemoteGoldTradeService;
/*    */ import com.hundsun.network.gates.luosi.taiping.reomte.result.OrderServiceResult;
/*    */ import com.hundsun.network.gates.luosi.wangjiang.reomte.dto.PlaceOrderDTO;
/*    */ import com.hundsun.network.gates.wangjiang.biz.service.BaseService;
/*    */ import com.hundsun.network.gates.wangjiang.biz.util.ConventUtil;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ 
/*    */ public class PlaceOrderAdapterImpl extends BaseService
/*    */   implements TradeAdapter<PlaceOrderDTO>
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private RemoteGoldTradeService<PlaceOrderTradeDTO> remoteGoldTradeService;
/*    */ 
/*    */   public OrderServiceResult bargain(PlaceOrderDTO placeOrderDTO)
/*    */   {
/* 34 */     OrderServiceResult result = new OrderServiceResult();
/* 35 */     TradeRequest request = new TradeRequest();
/* 36 */     PlaceOrderTradeDTO palceOrderTradeDTO = ConventUtil.conventPlaceOrderDTO2PlaceOrderTradeDTO(placeOrderDTO);
/*    */ 
/* 38 */     request.setTradeDTO(palceOrderTradeDTO);
/* 39 */     request.setFunId(EnumTradingType.PLACE_ORDER.getValue());
/* 40 */     if (this.log.isInfoEnabled()) {
/* 41 */       this.log.info("--In qingbo..gates.wangjiang.biz andready to invoke :remoteGoldTradeService.bargain(request)--");
/*    */     }
/* 43 */     result = this.remoteGoldTradeService.bargain(request);
/* 44 */     return result;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wangjiang.biz.service.pojo.placeorder.PlaceOrderAdapterImpl
 * JD-Core Version:    0.6.0
 */