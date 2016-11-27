/*     */ package com.hundsun.network.gates.wulin.biz.service.pojo.order.penaltycheckgoods;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumOperatorType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeOrderCcDealType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeOrderStatus;
/*     */ import com.hundsun.network.gates.luosi.common.utils.CommonUtils;
/*     */ import com.hundsun.network.gates.luosi.common.utils.DateUtil;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.enums.EnumGoodsAmountType;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.enums.EnumPenaltyType;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.request.TransRequest;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.result.FundOperateResult;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.service.RemoteFundService;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumTradeOrderResultErrors;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumUserResultErrors;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.TradeOrderBaseRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.TradeOrderGoodAmountServiceResult;
/*     */ import com.hundsun.network.gates.wulin.biz.dao.order.TradeOrderMoneyDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.dao.user.UserAccountDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.order.TradeOrder;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.order.TradeOrderMoney;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.user.UserAccount;
/*     */ import com.hundsun.network.gates.wulin.biz.service.BaseService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.order.TradeOrderLogService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.order.TradeOrderService;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ import org.springframework.transaction.TransactionStatus;
/*     */ import org.springframework.transaction.support.TransactionCallback;
/*     */ import org.springframework.transaction.support.TransactionTemplate;
/*     */ 
/*     */ @Service("penaltyCheckGoodsAmountServiceImpl")
/*     */ public class PenaltyCheckGoodsAmountServiceImpl extends BaseService
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private UserAccountDAO userAccountDAO;
/*     */ 
/*     */   @Autowired
/*     */   private TradeOrderMoneyDAO tradeOrderMoneyDAO;
/*     */ 
/*     */   @Autowired
/*     */   private TradeOrderLogService tradeOrderLogService;
/*     */ 
/*     */   @Autowired
/*     */   private RemoteFundService remoteFundService;
/*     */ 
/*     */   @Autowired
/*     */   private TradeOrderService tradeOrderService;
/*     */ 
/*     */   public TradeOrderGoodAmountServiceResult process(TradeOrderBaseRequest request, final TradeOrder tradeOrder)
/*     */   {
/*  52 */     TradeOrderGoodAmountServiceResult result = new TradeOrderGoodAmountServiceResult();
/*  53 */     final String orderNo = request.getOrderNo();
/*     */ 
/*  55 */     final String operator = request.getOperator();
/*  56 */     boolean hasSellerPenalty = request.getHasSellerPenalty();
/*  57 */     final String operatorType = EnumOperatorType.SYSTEM.getValue();
/*     */ 
/*  59 */     if (hasSellerPenalty) {
/*  60 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.PARAMETER_ERROR.getValue()));
/*  61 */       result.setErrorInfo(EnumTradeOrderResultErrors.PARAMETER_ERROR.getInfo());
/*  62 */       this.log.error("PenaltyCheckGoodsProcessService.process() error: " + result.getErrorInfo());
/*  63 */       return result;
/*     */     }
/*     */ 
/*  66 */     final TradeOrderMoney buyMoney = this.tradeOrderMoneyDAO.selectByAccountOrderNo(orderNo, tradeOrder.getBuyerAccount());
/*  67 */     final TradeOrderMoney sellMoney = this.tradeOrderMoneyDAO.selectByAccountOrderNo(orderNo, tradeOrder.getSellerAccount());
/*  68 */     final UserAccount sellAcc = this.userAccountDAO.selectByUserAccount(tradeOrder.getSellerAccount());
/*  69 */     final UserAccount buyAcc = this.userAccountDAO.selectByUserAccount(tradeOrder.getBuyerAccount());
/*     */ 
/*  72 */     result = (TradeOrderGoodAmountServiceResult)this.transactionTemplate.execute(new TransactionCallback() {
/*     */       public TradeOrderGoodAmountServiceResult doInTransaction(TransactionStatus status) {
/*  74 */         TradeOrderGoodAmountServiceResult result = new TradeOrderGoodAmountServiceResult();
/*     */         try
/*     */         {
/*  77 */           Map param = new HashMap();
/*  78 */           param.put("operator", operator);
/*  79 */           param.put("whereStatus", tradeOrder.getStatus());
/*  80 */           param.put("status", EnumTradeOrderStatus.COLSE.getValue());
/*     */ 
/*  82 */           PenaltyCheckGoodsAmountServiceImpl.this.tradeOrderService.updateParamByOrderNo(param, orderNo);
/*     */ 
/*  84 */           String remark = DateUtil.getDateFormat(new Date(), null) + 
/*  85 */             "操作人:" + 
/*  86 */             operator + 
/*  87 */             " 确认交割投诉操作" + EnumTradeOrderCcDealType.DEFAULT_SELLER_GOODS_REFUND.getName() + 
/*  88 */             CommonUtils.getValuationUnitDesc(
/*  89 */             Long.valueOf(tradeOrder.getOrderAmount()
/*  89 */             .longValue()), tradeOrder.getValuationUnit());
/*  90 */           PenaltyCheckGoodsAmountServiceImpl.this.tradeOrderLogService.insert(orderNo, tradeOrder.getStatus(), 
/*  91 */             EnumTradeOrderStatus.COLSE.getValue(), operator, operatorType, 
/*  92 */             remark);
/*     */ 
/*  95 */           Long buyDeliveryDeposit = buyMoney.getDeliveryDeposit();
/*  96 */           Long sellDeliveryDeposit = sellMoney.getDeliveryDeposit();
/*  97 */           Long buyGoodsAmount = buyMoney.getGoodsAmount();
/*     */ 
/*  99 */           buyMoney.setDeliveryDeposit(Long.valueOf(0L));
/* 100 */           buyMoney.setGoodsAmount(Long.valueOf(0L));
/* 101 */           buyMoney.setPenaltyAmount(Long.valueOf(0L));
/* 102 */           if (PenaltyCheckGoodsAmountServiceImpl.this.tradeOrderMoneyDAO.updateBySelective(buyMoney) <= 0) {
/* 103 */             status.setRollbackOnly();
/* 104 */             result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.CONFIRM_UPDATE_ORDER_MONEY_ERROR.getValue()));
/* 105 */             result.setErrorInfo(EnumTradeOrderResultErrors.CONFIRM_UPDATE_ORDER_MONEY_ERROR.getInfo());
/* 106 */             return result;
/*     */           }
/*     */ 
/* 109 */           sellMoney.setDeliveryDeposit(Long.valueOf(0L));
/* 110 */           sellMoney.setGoodsAmount(Long.valueOf(0L));
/* 111 */           sellMoney.setPenaltyAmount(Long.valueOf(0L));
/* 112 */           if (PenaltyCheckGoodsAmountServiceImpl.this.tradeOrderMoneyDAO.updateBySelective(sellMoney) <= 0) {
/* 113 */             status.setRollbackOnly();
/* 114 */             result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.CONFIRM_UPDATE_ORDER_MONEY_ERROR.getValue()));
/* 115 */             result.setErrorInfo(EnumTradeOrderResultErrors.CONFIRM_UPDATE_ORDER_MONEY_ERROR.getInfo());
/* 116 */             return result;
/*     */           }
/*     */ 
/* 120 */           TransRequest trRequest = new TransRequest();
/* 121 */           trRequest.setFundAccount(buyAcc.getFundAccount());
/* 122 */           trRequest.setSellFundAccount(sellAcc.getFundAccount());
/* 123 */           trRequest.setOrderProperty(tradeOrder.getTradingType());
/* 124 */           trRequest.setGoodsAmountType(EnumGoodsAmountType.CHECK_GOODS.getValue());
/* 125 */           trRequest.setHasInvoice(tradeOrder.getHasInvoice());
/* 126 */           trRequest.setGoodsAmount(Long.valueOf(0L));
/* 127 */           trRequest.setBuyerGoodsAmount(buyGoodsAmount);
/* 128 */           trRequest.setPenaltyType(EnumPenaltyType.PENALTY_TYPE_SELLER.getValue());
/* 129 */           trRequest.setPenaltyamount(Long.valueOf(0L));
/* 130 */           trRequest.setPenaltydeliveryAmount(sellDeliveryDeposit);
/* 131 */           trRequest.setDeliveryAmount(buyDeliveryDeposit);
/* 132 */           trRequest.setCheckGoodsTicketType(EnumTradeOrderCcDealType.DEFAULT_SELLER_GOODS_REFUND.getValue());
/* 133 */           trRequest.setBizNo(orderNo);
/* 134 */           trRequest.setOperator(operator);
/* 135 */           trRequest.setMemo(remark);
/* 136 */           FundOperateResult fundOperateResult = PenaltyCheckGoodsAmountServiceImpl.this.remoteFundService.checkGoodsTicketBroken(trRequest);
/* 137 */           if (fundOperateResult.isError())
/*     */           {
/* 139 */             PenaltyCheckGoodsAmountServiceImpl.this.log.error("PenaltyCheckGoodsAmountServiceImpl.process() error:" + fundOperateResult.getErrorInfo());
/* 140 */             status.setRollbackOnly();
/* 141 */             result.setErrorNO(Integer.valueOf(EnumUserResultErrors.INTERNAL_ERROR.getValue()));
/* 142 */             result.setErrorInfo(fundOperateResult.getErrorInfo());
/* 143 */             return result;
/*     */           }
/* 145 */           result.setGoodsAmount(buyGoodsAmount);
/* 146 */           result.setSellDeliveryDeposit(sellDeliveryDeposit);
/* 147 */           result.setBuyDeliveryDeposit(buyDeliveryDeposit);
/*     */         }
/*     */         catch (Exception e) {
/* 150 */           PenaltyCheckGoodsAmountServiceImpl.this.log.error("PenaltyCheckGoodsAmountServiceImpl.process() error:", e);
/* 151 */           status.setRollbackOnly();
/* 152 */           result.setErrorNO(Integer.valueOf(EnumUserResultErrors.INTERNAL_ERROR.getValue()));
/* 153 */           result.setErrorInfo(EnumUserResultErrors.INTERNAL_ERROR.getInfo());
/* 154 */           return result;
/*     */         }
/* 156 */         return result;
/*     */       }
/*     */     });
/* 159 */     return result;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.pojo.order.penaltycheckgoods.PenaltyCheckGoodsAmountServiceImpl
 * JD-Core Version:    0.6.0
 */