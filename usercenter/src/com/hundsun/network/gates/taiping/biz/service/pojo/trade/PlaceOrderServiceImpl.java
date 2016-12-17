/*    */ package com.hundsun.network.gates.taiping.biz.service.pojo.trade;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
/*    */ import com.hundsun.network.gates.luosi.wangjiang.reomte.dto.PlaceOrderDTO;
/*    */ import com.hundsun.network.gates.luosi.wangjiang.reomte.request.TradeRequest;
/*    */ import com.hundsun.network.gates.luosi.wangjiang.reomte.service.RemoteTradeService;
/*    */ import com.hundsun.network.gates.taiping.biz.domain.placeorder.PlaceOrderInput;
/*    */ import com.hundsun.network.gates.taiping.biz.service.BaseService;
/*    */ import com.hundsun.network.gates.taiping.biz.service.trade.PlaceOrderService;
/*    */ import org.apache.commons.beanutils.BeanUtils;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("placeOrderService")
/*    */ public class PlaceOrderServiceImpl extends BaseService
/*    */   implements PlaceOrderService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private RemoteTradeService remoteTradeService;
/*    */ 
/*    */   public ServiceResult bargain(PlaceOrderInput placeOrderInput)
/*    */   {
/* 40 */     ServiceResult result = new ServiceResult();
/* 41 */     PlaceOrderDTO placeOrderDTO = new PlaceOrderDTO();
/*    */     try {
/* 43 */       BeanUtils.copyProperties(placeOrderDTO, placeOrderInput);
/*    */     } catch (Exception e) {
/* 45 */       this.log.error("placeOrderInput 转换出错 placeOrderDTO ", e);
/* 46 */       result.setErrorInfo("placeOrderInput 转换出错 placeOrderDTO");
/*    */     }
/* 48 */     TradeRequest request = new TradeRequest();
/* 49 */     request.setTradeDTO(placeOrderDTO);
/* 50 */     result = this.remoteTradeService.bargain(request);
/* 51 */     return result;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.taiping.biz.service.pojo.trade.PlaceOrderServiceImpl
 * JD-Core Version:    0.6.0
 */