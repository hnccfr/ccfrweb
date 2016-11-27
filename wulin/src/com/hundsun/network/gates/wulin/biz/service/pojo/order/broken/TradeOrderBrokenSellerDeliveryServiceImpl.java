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
/*    */ @Service("tradeOrderBrokenSellerDeliveryService")
/*    */ public class TradeOrderBrokenSellerDeliveryServiceImpl extends TradeOrderBrokenBaseService
/*    */ {
/*    */   private TransRequest transRequest;
/*    */ 
/*    */   protected FundOperateResult dealFundBroken()
/*    */     throws ServiceException
/*    */   {
/* 37 */     this.log.debug("tradeOrderBrokenSellerDeliveryService dealFundBroken");
/* 38 */     FundOperateResult result = new FundOperateResult();
/* 39 */     if (null == this.transRequest) {
/* 40 */       this.log.error("fund request is null,you should do beforeDealFundBroken first!");
/* 41 */       throw new ServiceException(EnumTradeOrderResultErrors.PARAMETER_ERROR.getInfo(), Integer.valueOf(EnumTradeOrderResultErrors.PARAMETER_ERROR.getValue()));
/*    */     }
/*    */     try
/*    */     {
/* 45 */       result = this.remoteFundService.deliveryBroken(this.transRequest);
/*    */     } catch (Exception e) {
/* 47 */       throw new ServiceException(EnumTradeOrderResultErrors.SERVER_ERROR.getInfo(), Integer.valueOf(EnumTradeOrderResultErrors.SERVER_ERROR.getValue()));
/*    */     }
/*    */ 
/* 50 */     return result;
/*    */   }
/*    */ 
/*    */   protected void beforeDealFundBroken() throws ServiceException
/*    */   {
/*    */     try {
/* 56 */       BigDecimal rate = getDeliveryBrokenRate();
/* 57 */       if (null == rate) {
/* 58 */         throw new ServiceException(EnumTradeOrderResultErrors.QUERY_DELIVERY_BROKEN_RATE_ERROR.getInfo(), Integer.valueOf(EnumTradeOrderResultErrors.QUERY_DELIVERY_BROKEN_RATE_ERROR.getValue()));
/*    */       }
/*    */ 
/* 62 */       Money money = new Money();
/* 63 */       money.setCent(this.sellerOrderMoney.getDeliveryDeposit().longValue());
/* 64 */       Long penaltyAmount = Long.valueOf(money.multiply(rate).getCent());
/* 65 */       this.transRequest = new TransRequest();
/* 66 */       this.transRequest.setPenaltyAccount(this.sellerOrderMoney.getFundAccount());
/* 67 */       this.transRequest.setFundAccount(this.buyerOrderMoney.getFundAccount());
/* 68 */       this.transRequest.setOrderProperty(this.order.getTradingType());
/* 69 */       this.transRequest.setPenaltydeliveryAmount(this.sellerOrderMoney.getDeliveryDeposit());
/* 70 */       this.transRequest.setDeliveryAmount(this.buyerOrderMoney.getDeliveryDeposit());
/* 71 */       this.transRequest.setPenaltyamount(penaltyAmount);
/* 72 */       this.transRequest.setGoodsAmount(this.buyerOrderMoney.getGoodsAmount());
/* 73 */       this.transRequest.setBizNo(this.order.getOrderNo());
/* 74 */       this.transRequest.setOperator(this.request.getOperator());
/* 75 */       this.sellerOrderMoney.setPenaltyAmount(Long.valueOf(0L - penaltyAmount.longValue()));
/* 76 */       this.sellerOrderMoney.setDeliveryDeposit(Long.valueOf(0L));
/* 77 */       this.buyerOrderMoney.setPenaltyAmount(penaltyAmount);
/* 78 */       this.buyerOrderMoney.setDeliveryDeposit(Long.valueOf(0L));
/* 79 */       this.buyerOrderMoney.setGoodsAmount(Long.valueOf(0L));
/*    */     } catch (ServiceException e) {
/* 81 */       throw e;
/*    */     } catch (Exception e) {
/* 83 */       this.log.error("", e);
/* 84 */       throw new ServiceException(EnumTradeOrderResultErrors.INTERNAL_ERROR.getInfo(), Integer.valueOf(EnumTradeOrderResultErrors.INTERNAL_ERROR.getValue()));
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.pojo.order.broken.TradeOrderBrokenSellerDeliveryServiceImpl
 * JD-Core Version:    0.6.0
 */