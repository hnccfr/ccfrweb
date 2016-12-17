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
/*    */ @Service("tradeOrderBrokenBuyerDeliveryService")
/*    */ public class TradeOrderBrokenBuyerDeliveryServiceImpl extends TradeOrderBrokenBaseService
/*    */ {
/*    */   private TransRequest transRequest;
/*    */ 
/*    */   protected FundOperateResult dealFundBroken()
/*    */     throws ServiceException
/*    */   {
/* 30 */     this.log.debug("tradeOrderBrokenBuyerDeliveryService dealFundBroken");
/* 31 */     FundOperateResult result = new FundOperateResult();
/* 32 */     if (null == this.transRequest) {
/* 33 */       this.log.error("fund request is null,you should do beforeDealFundBroken first!");
/* 34 */       throw new ServiceException(EnumTradeOrderResultErrors.PARAMETER_ERROR.getInfo(), Integer.valueOf(EnumTradeOrderResultErrors.PARAMETER_ERROR.getValue()));
/*    */     }
/*    */ 
/*    */     try
/*    */     {
/* 39 */       result = this.remoteFundService.deliveryBroken(this.transRequest);
/*    */     } catch (Exception e) {
/* 41 */       throw new ServiceException(EnumTradeOrderResultErrors.SERVER_ERROR.getInfo(), Integer.valueOf(EnumTradeOrderResultErrors.SERVER_ERROR.getValue()));
/*    */     }
/*    */ 
/* 44 */     return result;
/*    */   }
/*    */ 
/*    */   protected void beforeDealFundBroken() throws ServiceException
/*    */   {
/*    */     try {
/* 50 */       BigDecimal rate = getDeliveryBrokenRate();
/* 51 */       if (null == rate) {
/* 52 */         throw new ServiceException(EnumTradeOrderResultErrors.QUERY_DELIVERY_BROKEN_RATE_ERROR.getInfo(), Integer.valueOf(EnumTradeOrderResultErrors.QUERY_DELIVERY_BROKEN_RATE_ERROR.getValue()));
/*    */       }
/*    */ 
/* 56 */       Money money = new Money();
/* 57 */       money.setCent(this.buyerOrderMoney.getDeliveryDeposit().longValue());
/* 58 */       Long penaltyAmount = Long.valueOf(money.multiply(rate).getCent());
/* 59 */       this.transRequest = new TransRequest();
/* 60 */       this.transRequest.setPenaltyAccount(this.buyerOrderMoney.getFundAccount());
/* 61 */       this.transRequest.setFundAccount(this.sellerOrderMoney.getFundAccount());
/* 62 */       this.transRequest.setOrderProperty(this.order.getTradingType());
/* 63 */       this.transRequest.setPenaltydeliveryAmount(this.buyerOrderMoney.getDeliveryDeposit());
/* 64 */       this.transRequest.setDeliveryAmount(this.sellerOrderMoney.getDeliveryDeposit());
/* 65 */       this.transRequest.setPenaltyamount(penaltyAmount);
/* 66 */       this.transRequest.setGoodsAmount(this.buyerOrderMoney.getGoodsAmount());
/* 67 */       this.transRequest.setBizNo(this.order.getOrderNo());
/* 68 */       this.transRequest.setOperator(this.request.getOperator());
/* 69 */       this.buyerOrderMoney.setPenaltyAmount(Long.valueOf(0L - penaltyAmount.longValue()));
/* 70 */       this.buyerOrderMoney.setDeliveryDeposit(Long.valueOf(0L));
/* 71 */       this.buyerOrderMoney.setGoodsAmount(Long.valueOf(0L));
/*    */ 
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
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.pojo.order.broken.TradeOrderBrokenBuyerDeliveryServiceImpl
 * JD-Core Version:    0.6.0
 */