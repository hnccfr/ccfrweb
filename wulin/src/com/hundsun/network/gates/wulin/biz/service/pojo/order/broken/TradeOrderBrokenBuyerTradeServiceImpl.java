/*    */ package com.hundsun.network.gates.wulin.biz.service.pojo.order.broken;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.biz.security.ServiceException;
/*    */ import com.hundsun.network.gates.luosi.houchao.reomte.request.TransRequest;
/*    */ import com.hundsun.network.gates.luosi.houchao.reomte.result.FundOperateResult;
/*    */ import com.hundsun.network.gates.luosi.houchao.reomte.service.RemoteFundService;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumTradeOrderResultErrors;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.request.TradeOrderBaseRequest;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.order.TradeOrder;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.order.TradeOrderMoney;
/*    */ import com.hundsun.network.melody.common.util.Money;
/*    */ import java.math.BigDecimal;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("tradeOrderBrokenBuyerTradeService")
/*    */ public class TradeOrderBrokenBuyerTradeServiceImpl extends TradeOrderBrokenBaseService
/*    */ {
/*    */   private TransRequest transRequest;
/*    */ 
/*    */   protected FundOperateResult dealFundBroken()
/*    */     throws ServiceException
/*    */   {
/* 33 */     this.log.debug("tradeOrderBrokenBuyerTradeService dealFundBroken");
/* 34 */     FundOperateResult result = new FundOperateResult();
/* 35 */     if (null == this.transRequest) {
/* 36 */       this.log.error("fund request is null,you should do beforeDealFundBroken first!");
/* 37 */       throw new ServiceException(EnumTradeOrderResultErrors.PARAMETER_ERROR.getInfo(), Integer.valueOf(EnumTradeOrderResultErrors.PARAMETER_ERROR.getValue()));
/*    */     }
/*    */ 
/*    */     try
/*    */     {
/* 42 */       result = this.remoteFundService.tradeBroken(this.transRequest);
/*    */     } catch (Exception e) {
/* 44 */       throw new ServiceException(EnumTradeOrderResultErrors.SERVER_ERROR.getInfo(), Integer.valueOf(EnumTradeOrderResultErrors.SERVER_ERROR.getValue()));
/*    */     }
/*    */ 
/* 47 */     return result;
/*    */   }
/*    */ 
/*    */   protected void beforeDealFundBroken() throws ServiceException
/*    */   {
/*    */     try {
/* 53 */       BigDecimal rate = getTradeBrokenRate();
/* 54 */       if (null == rate) {
/* 55 */         throw new ServiceException(EnumTradeOrderResultErrors.QUERY_TRADE_BROKEN_RATE_ERROR.getInfo(), Integer.valueOf(EnumTradeOrderResultErrors.QUERY_TRADE_BROKEN_RATE_ERROR.getValue()));
/*    */       }
/*    */ 
/* 59 */       Money money = new Money();
/* 60 */       money.setCent(this.buyerOrderMoney.getTradeDeposit().longValue());
/* 61 */       Long penaltyAmount = Long.valueOf(money.multiply(rate).getCent());
/* 62 */       this.transRequest = new TransRequest();
/* 63 */       this.transRequest.setPenaltyAccount(this.buyerOrderMoney.getFundAccount());
/* 64 */       this.transRequest.setFundAccount(this.sellerOrderMoney.getFundAccount());
/* 65 */       this.transRequest.setOrderProperty(this.order.getTradingType());
/* 66 */       this.transRequest.setFreezeDepositAmount(this.buyerOrderMoney.getTradeDeposit());
/* 67 */       this.transRequest.setDeliveryAmount(this.sellerOrderMoney.getDeliveryDeposit());
/* 68 */       this.transRequest.setPenaltyamount(penaltyAmount);
/* 69 */       this.transRequest.setBizNo(this.order.getOrderNo());
/* 70 */       this.transRequest.setOperator(this.request.getOperator());
/* 71 */       this.buyerOrderMoney.setPenaltyAmount(Long.valueOf(0L - penaltyAmount.longValue()));
/* 72 */       this.buyerOrderMoney.setTradeDeposit(Long.valueOf(0L));
/* 73 */       this.sellerOrderMoney.setPenaltyAmount(penaltyAmount);
/* 74 */       this.sellerOrderMoney.setDeliveryDeposit(Long.valueOf(0L));
/*    */     } catch (ServiceException e) {
/* 76 */       throw e;
/*    */     } catch (Exception e) {
/* 78 */       this.log.error("", e);
/* 79 */       throw new ServiceException(EnumTradeOrderResultErrors.INTERNAL_ERROR.getInfo(), Integer.valueOf(EnumTradeOrderResultErrors.INTERNAL_ERROR.getValue()));
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.pojo.order.broken.TradeOrderBrokenBuyerTradeServiceImpl
 * JD-Core Version:    0.6.0
 */