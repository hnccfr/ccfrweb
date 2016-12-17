/*    */ package com.hundsun.network.gates.wulin.remote.service.pojo;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.taiping.reomte.request.TradeTypePropConfigRequest;
/*    */ import com.hundsun.network.gates.luosi.taiping.reomte.result.TradeTypePropConfigServiceResult;
/*    */ import com.hundsun.network.gates.luosi.taiping.reomte.service.RemoteTradeTypePropConfigService;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumTradeOrderResultErrors;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.trade.TradeTypePropConfig;
/*    */ import com.hundsun.network.gates.wulin.biz.service.BaseService;
/*    */ import com.hundsun.network.gates.wulin.biz.service.trade.TradeTypePropConfigService;
/*    */ import java.util.List;
/*    */ import org.apache.commons.beanutils.BeanUtils;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("remoteTradeTypePropConfigService")
/*    */ public class RemoteTradeTypePropConfigServiceImpl extends BaseService
/*    */   implements RemoteTradeTypePropConfigService
/*    */ {
/* 23 */   protected final Log logger = LogFactory.getLog(getClass());
/*    */ 
/*    */   @Autowired
/*    */   private TradeTypePropConfigService tradeTypePropConfigService;
/*    */ 
/*    */   public TradeTypePropConfigServiceResult getTradeTypePropList(TradeTypePropConfigRequest request)
/*    */   {
/* 35 */     TradeTypePropConfigServiceResult result = new TradeTypePropConfigServiceResult();
/* 36 */     if (null == request) {
/* 37 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.PARAMETER_ERROR.getValue()));
/* 38 */       result.setErrorInfo(EnumTradeOrderResultErrors.PARAMETER_ERROR.getInfo());
/* 39 */       return result;
/*    */     }
/* 41 */     TradeTypePropConfig tradeTypePropConfig = new TradeTypePropConfig();
/*    */     try {
/* 43 */       BeanUtils.copyProperties(tradeTypePropConfig, request.getTradeTypePropConfigDTO());
/*    */     } catch (Exception e) {
/* 45 */       this.log.error("tradeTypePropConfig 转换出错 ", e);
/* 46 */       result.setErrorInfo("tradeTypePropConfig 转换出错 ");
/* 47 */       return result;
/*    */     }
/* 49 */     List list = this.tradeTypePropConfigService.getTradeTypePropList(tradeTypePropConfig);
/*    */ 
/* 51 */     result.setTradeTypePropList(list);
/* 52 */     return result;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.remote.service.pojo.RemoteTradeTypePropConfigServiceImpl
 * JD-Core Version:    0.6.0
 */