/*    */ package com.hundsun.network.gates.wulin.biz.service.pojo.order.broken;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.biz.security.ServiceException;
/*    */ import com.hundsun.network.gates.luosi.houchao.reomte.request.TransRequest;
/*    */ import com.hundsun.network.gates.luosi.houchao.reomte.result.FundBatchResult;
/*    */ import com.hundsun.network.gates.luosi.houchao.reomte.result.FundOperateResult;
/*    */ import com.hundsun.network.gates.luosi.houchao.reomte.service.RemoteFundService;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumTradeOrderResultErrors;
/*    */ import com.hundsun.network.gates.luosi.wulin.reomte.request.TradeOrderBaseRequest;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.order.TradeOrder;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.order.TradeOrderMoney;
/*    */ import com.hundsun.network.melody.common.util.StringUtil;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("tradeOrderBrokenTradeService")
/*    */ public class TradeOrderBrokenTradeServiceImpl extends TradeOrderBrokenBaseService
/*    */ {
/* 23 */   private TransRequest buyerRequest = new TransRequest();
/*    */ 
/* 25 */   private TransRequest sellerRequest = new TransRequest();
/*    */ 
/*    */   protected FundOperateResult dealFundBroken() throws ServiceException
/*    */   {
/* 29 */     this.log.debug("tradeOrderBrokenTradeService dealFundBroken");
/* 30 */     FundOperateResult result = new FundOperateResult();
/* 31 */     List request = new ArrayList();
/* 32 */     request.add(this.buyerRequest);
/* 33 */     request.add(this.sellerRequest);
/*    */     try {
/* 35 */       FundBatchResult fundBatchResult = this.remoteFundService.cancelFundBatchByTrade(request);
/* 36 */       for (FundOperateResult fundOperateResult : fundBatchResult.getFundResultList())
/* 37 */         if (fundOperateResult.isError()) {
/* 38 */           String msg = new StringBuilder().append(StringUtil.isEmpty(result.getErrorInfo()) ? "" : new StringBuilder().append(result.getErrorInfo()).append("        ").toString()).append(getMessage("trade.order.fund.cancel", new String[] { fundOperateResult.getFundAccount(), fundOperateResult.getErrorInfo() })).toString();
/*    */ 
/* 42 */           result.setErrorInfo(msg);
/* 43 */           result.setErrorNO(fundOperateResult.getBizNo());
/*    */         }
/*    */     }
/*    */     catch (Exception e) {
/* 47 */       throw new ServiceException(EnumTradeOrderResultErrors.SERVER_ERROR.getInfo(), Integer.valueOf(EnumTradeOrderResultErrors.SERVER_ERROR.getValue()));
/*    */     }
/*    */ 
/* 50 */     return result;
/*    */   }
/*    */ 
/*    */   protected void beforeDealFundBroken() throws ServiceException
/*    */   {
/* 55 */     this.buyerRequest.setFundAccount(this.buyerOrderMoney.getFundAccount());
/* 56 */     this.buyerRequest.setAmount(this.buyerOrderMoney.getTradeDeposit());
/* 57 */     this.buyerRequest.setOrderProperty(this.order.getTradingType());
/* 58 */     this.buyerRequest.setBizNo(this.order.getOrderNo());
/* 59 */     this.buyerRequest.setOperator(this.request.getOperator());
/* 60 */     this.sellerRequest.setFundAccount(this.sellerOrderMoney.getFundAccount());
/* 61 */     this.sellerRequest.setAmount(this.sellerOrderMoney.getTradeDeposit());
/* 62 */     this.sellerRequest.setOrderProperty(this.order.getTradingType());
/* 63 */     this.sellerRequest.setBizNo(this.order.getOrderNo());
/* 64 */     this.sellerRequest.setOperator(this.request.getOperator());
/* 65 */     this.buyerOrderMoney.setTradeDeposit(Long.valueOf(0L));
/* 66 */     this.sellerOrderMoney.setTradeDeposit(Long.valueOf(0L));
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.pojo.order.broken.TradeOrderBrokenTradeServiceImpl
 * JD-Core Version:    0.6.0
 */