/*    */ package com.hundsun.network.gates.taiping.biz.service.pojo.trade;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.taiping.reomte.enums.EnumTradeError;
/*    */ import com.hundsun.network.gates.luosi.taiping.reomte.result.OrderServiceResult;
/*    */ import com.hundsun.network.gates.taiping.biz.service.BaseService;
/*    */ import com.hundsun.network.gates.taiping.biz.service.trade.TradeAdapter;
/*    */ import com.hundsun.network.gates.taiping.biz.service.trade.TradeService;
/*    */ import com.hundsun.network.melody.common.util.StringUtil;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import org.apache.commons.logging.Log;
/*    */ 
/*    */ public class TradeServiceImpl extends BaseService
/*    */   implements TradeService<Object>
/*    */ {
/* 26 */   private Map<String, TradeAdapter<Object>> functionMap = new HashMap();
/*    */ 
/*    */   public void setFunctionMap(Map<String, TradeAdapter<Object>> functionMap) {
/* 29 */     this.functionMap.putAll(functionMap);
/*    */   }
/*    */ 
/*    */   public OrderServiceResult bargain(String funId, Object inputData)
/*    */   {
/* 40 */     OrderServiceResult result = new OrderServiceResult();
/* 41 */     if (StringUtil.isEmpty(funId)) {
/* 42 */       result.setErrorNOInfo(Integer.valueOf(EnumTradeError.TRADE_IMPL_CALSS_NOT_FIND_ERROR.getValue()), funId + EnumTradeError.TRADE_IMPL_CALSS_NOT_FIND_ERROR.getName());
/*    */ 
/* 44 */       return result;
/*    */     }
/*    */ 
/* 47 */     TradeAdapter tradeAdapter = (TradeAdapter)this.functionMap.get(funId);
/* 48 */     if (this.log.isInfoEnabled()) {
/* 49 */       this.log.info("--invoke placeOrder method in TradeService!--");
/*    */     }
/* 51 */     return tradeAdapter.bargain(inputData);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.taiping.biz.service.pojo.trade.TradeServiceImpl
 * JD-Core Version:    0.6.0
 */