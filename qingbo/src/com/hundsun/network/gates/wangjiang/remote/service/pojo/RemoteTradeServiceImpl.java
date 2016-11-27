/*    */ package com.hundsun.network.gates.wangjiang.remote.service.pojo;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.biz.service.TradeAdapter;
/*    */ import com.hundsun.network.gates.luosi.common.remote.BaseTradeDTO;
/*    */ import com.hundsun.network.gates.luosi.taiping.reomte.enums.EnumTradeError;
/*    */ import com.hundsun.network.gates.luosi.taiping.reomte.result.OrderServiceResult;
/*    */ import com.hundsun.network.gates.luosi.wangjiang.reomte.request.TradeRequest;
/*    */ import com.hundsun.network.gates.luosi.wangjiang.reomte.service.RemoteTradeService;
/*    */ import com.hundsun.network.gates.wangjiang.biz.service.BaseService;
/*    */ import com.hundsun.network.gates.wangjiang.biz.validator.CommonValidator;
/*    */ import com.hundsun.network.melody.common.util.StringUtil;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("remoteTradeService")
/*    */ public class RemoteTradeServiceImpl extends BaseService
/*    */   implements RemoteTradeService
/*    */ {
/* 21 */   private Map<String, TradeAdapter<Object>> functionMap = new HashMap();
/*    */ 
/*    */   @Autowired
/*    */   private CommonValidator commonVilidator;
/*    */ 
/* 24 */   public void setFunctionMap(Map<String, TradeAdapter<Object>> functionMap) { this.functionMap.putAll(functionMap);
/*    */   }
/*    */ 
/*    */   public OrderServiceResult bargain(TradeRequest request)
/*    */   {
/* 32 */     OrderServiceResult result = new OrderServiceResult();
/*    */ 
/* 37 */     String funId = request.getFunId();
/* 38 */     BaseTradeDTO baseTradeDTO = (BaseTradeDTO)request.getTradeDTO();
/* 39 */     result = this.commonVilidator.validateData(baseTradeDTO);
/* 40 */     if (!result.correct())
/* 41 */       return result;
/* 42 */     result = this.commonVilidator.validateUser(baseTradeDTO.getUserAccount());
/* 43 */     if (!result.correct())
/* 44 */       return result;
/* 45 */     result = this.commonVilidator.isMarketOpen();
/* 46 */     if (!result.correct())
/* 47 */       return result;
/* 48 */     if (!result.correct()) {
/* 49 */       return result;
/*    */     }
/* 51 */     if ((StringUtil.isEmpty(funId)) || (null == funId)) {
/* 52 */       result.setErrorNOInfo(Integer.valueOf(EnumTradeError.TRADE_IMPL_CALSS_NOT_FIND_ERROR.getValue()), funId + EnumTradeError.TRADE_IMPL_CALSS_NOT_FIND_ERROR.getName());
/*    */ 
/* 54 */       return result;
/*    */     }
/* 56 */     TradeAdapter tradeAdapter = (TradeAdapter)this.functionMap.get(funId);
/* 57 */     if (this.log.isInfoEnabled()) {
/* 58 */       this.log.info("--Do placeOrder in qingbo at RemoteTradeService:tradeAdapter.bargain(baseTradeDTO--");
/*    */     }
/* 60 */     return tradeAdapter.bargain(baseTradeDTO);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wangjiang.remote.service.pojo.RemoteTradeServiceImpl
 * JD-Core Version:    0.6.0
 */