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
/*    */ @Service("tradeOrderBrokenSellerTradeService")
/*    */ public class TradeOrderBrokenSellerTradeServiceImpl extends TradeOrderBrokenBaseService
/*    */ {
/*    */   private TransRequest transRequest;
/*    */ 
/*    */   protected FundOperateResult dealFundBroken()
/*    */     throws ServiceException
/*    */   {
/* 30 */     this.log.debug("tradeOrderBrokenSellerTradeService dealFundBroken");
/* 31 */     FundOperateResult result = new FundOperateResult();
/* 32 */     if (null == this.transRequest) {
/* 33 */       this.log.error("fund request is null,you should do beforeDealFundBroken first!");
/* 34 */       throw new ServiceException(EnumTradeOrderResultErrors.PARAMETER_ERROR.getInfo(), Integer.valueOf(EnumTradeOrderResultErrors.PARAMETER_ERROR.getValue()));
/*    */     }
/*    */     try
/*    */     {
/* 38 */       result = this.remoteFundService.tradeBroken(this.transRequest);
/*    */     } catch (Exception e) {
/* 40 */       throw new ServiceException(EnumTradeOrderResultErrors.SERVER_ERROR.getInfo(), Integer.valueOf(EnumTradeOrderResultErrors.SERVER_ERROR.getValue()));
/*    */     }
/*    */ 
/* 43 */     return result;
/*    */   }
/*    */ 
/*    */   protected void beforeDealFundBroken() throws ServiceException
/*    */   {
/*    */     try {
/* 49 */       BigDecimal rate = getTradeBrokenRate();
/* 50 */       if (null == rate) {
/* 51 */         throw new ServiceException(EnumTradeOrderResultErrors.QUERY_TRADE_BROKEN_RATE_ERROR.getInfo(), Integer.valueOf(EnumTradeOrderResultErrors.QUERY_TRADE_BROKEN_RATE_ERROR.getValue()));
/*    */       }
/*    */ 
/* 55 */       Money money = new Money();
/* 56 */       money.setCent(this.sellerOrderMoney.getTradeDeposit().longValue());
/* 57 */       Long penaltyAmount = Long.valueOf(money.multiply(rate).getCent());
/* 58 */       this.transRequest = new TransRequest();
/* 59 */       this.transRequest.setPenaltyAccount(this.sellerOrderMoney.getFundAccount());
/* 60 */       this.transRequest.setFundAccount(this.buyerOrderMoney.getFundAccount());
/* 61 */       this.transRequest.setOrderProperty(this.order.getTradingType());
/* 62 */       this.transRequest.setFreezeDepositAmount(this.sellerOrderMoney.getTradeDeposit());
/* 63 */       this.transRequest.setDeliveryAmount(this.buyerOrderMoney.getDeliveryDeposit());
/* 64 */       this.transRequest.setPenaltyamount(penaltyAmount);
/* 65 */       this.transRequest.setBizNo(this.order.getOrderNo());
/* 66 */       this.transRequest.setOperator(this.request.getOperator());
/* 67 */       this.sellerOrderMoney.setPenaltyAmount(Long.valueOf(0L - penaltyAmount.longValue()));
/* 68 */       this.sellerOrderMoney.setTradeDeposit(Long.valueOf(0L));
/* 69 */       this.buyerOrderMoney.setPenaltyAmount(penaltyAmount);
/* 70 */       this.buyerOrderMoney.setDeliveryDeposit(Long.valueOf(0L));
/*    */     } catch (ServiceException e) {
/* 72 */       throw e;
/*    */     } catch (Exception e) {
/* 74 */       this.log.error("", e);
/* 75 */       throw new ServiceException(EnumTradeOrderResultErrors.INTERNAL_ERROR.getInfo(), Integer.valueOf(EnumTradeOrderResultErrors.INTERNAL_ERROR.getValue()));
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.pojo.order.broken.TradeOrderBrokenSellerTradeServiceImpl
 * JD-Core Version:    0.6.0
 */