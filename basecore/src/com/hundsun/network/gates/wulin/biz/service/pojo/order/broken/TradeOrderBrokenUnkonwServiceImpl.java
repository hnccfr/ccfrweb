/*    */ package com.hundsun.network.gates.wulin.biz.service.pojo.order.broken;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.biz.security.ServiceException;
/*    */ import com.hundsun.network.gates.luosi.houchao.reomte.result.FundOperateResult;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumTradeOrderResultErrors;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("tradeOrderBrokenUnkonwService")
/*    */ public class TradeOrderBrokenUnkonwServiceImpl extends TradeOrderBrokenBaseService
/*    */ {
/*    */   protected FundOperateResult dealFundBroken()
/*    */     throws ServiceException
/*    */   {
/* 19 */     this.log.debug("tradeOrderBrokenUnkonwService dealFundBroken");
/* 20 */     FundOperateResult result = new FundOperateResult();
/* 21 */     result.setErrorInfo(EnumTradeOrderResultErrors.ORDER_BROKEN_UNKNOW_ERROR.getInfo());
/* 22 */     result.setErrorNO(String.valueOf(EnumTradeOrderResultErrors.ORDER_BROKEN_UNKNOW_ERROR.getValue()));
/*    */ 
/* 24 */     return result;
/*    */   }
/*    */ 
/*    */   protected void beforeDealFundBroken() throws ServiceException
/*    */   {
/* 29 */     throw new ServiceException(EnumTradeOrderResultErrors.ORDER_BROKEN_UNKNOW_ERROR.getInfo(), Integer.valueOf(EnumTradeOrderResultErrors.ORDER_BROKEN_UNKNOW_ERROR.getValue()));
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.pojo.order.broken.TradeOrderBrokenUnkonwServiceImpl
 * JD-Core Version:    0.6.0
 */