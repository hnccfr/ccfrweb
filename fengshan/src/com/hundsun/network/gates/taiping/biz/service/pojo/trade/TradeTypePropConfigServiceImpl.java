/*    */ package com.hundsun.network.gates.taiping.biz.service.pojo.trade;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.taiping.reomte.dto.TradeTypePropConfigDTO;
/*    */ import com.hundsun.network.gates.luosi.taiping.reomte.request.TradeTypePropConfigRequest;
/*    */ import com.hundsun.network.gates.luosi.taiping.reomte.result.TradeTypePropConfigServiceResult;
/*    */ import com.hundsun.network.gates.luosi.taiping.reomte.service.RemoteTradeTypePropConfigService;
/*    */ import com.hundsun.network.gates.taiping.biz.service.trade.TradeTypePropConfigService;
/*    */ import com.hundsun.network.melody.common.util.StringUtil;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("tradeTypePropConfigService")
/*    */ public class TradeTypePropConfigServiceImpl
/*    */   implements TradeTypePropConfigService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private RemoteTradeTypePropConfigService remoteTradeTypePropConfigService;
/*    */ 
/*    */   public List getTradeTypePropList(String tradeType)
/*    */   {
/* 40 */     if (StringUtil.isEmpty(tradeType)) {
/* 41 */       return null;
/*    */     }
/* 43 */     TradeTypePropConfigDTO tradeTypePropConfigDTO = new TradeTypePropConfigDTO();
/* 44 */     tradeTypePropConfigDTO.setTradeType(tradeType);
/* 45 */     TradeTypePropConfigRequest request = new TradeTypePropConfigRequest();
/* 46 */     request.setTradeTypePropConfigDTO(tradeTypePropConfigDTO);
/* 47 */     TradeTypePropConfigServiceResult result = this.remoteTradeTypePropConfigService.getTradeTypePropList(request);
/*    */ 
/* 49 */     return result.getTradeTypePropList();
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.taiping.biz.service.pojo.trade.TradeTypePropConfigServiceImpl
 * JD-Core Version:    0.6.0
 */