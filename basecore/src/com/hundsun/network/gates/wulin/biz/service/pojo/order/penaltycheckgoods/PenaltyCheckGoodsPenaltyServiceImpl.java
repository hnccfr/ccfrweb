/*     */ package com.hundsun.network.gates.wulin.biz.service.pojo.order.penaltycheckgoods;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumOperatorType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumSystemDictKey;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeOrderCcDealType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeOrderStatus;
/*     */ import com.hundsun.network.gates.luosi.common.utils.CommonUtils;
/*     */ import com.hundsun.network.gates.luosi.common.utils.DateUtil;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.enums.EnumGoodsAmountType;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.enums.EnumPenaltyType;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.request.TransRequest;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.result.FundOperateResult;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.service.RemoteFundService;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.SystemDictDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumTradeOrderResultErrors;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumUserResultErrors;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.SystemDictRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.TradeOrderBaseRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.SystemDictServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.TradeOrderGoodAmountServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteSystemBaseService;
/*     */ import com.hundsun.network.gates.wulin.biz.dao.order.TradeOrderMoneyDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.dao.user.UserAccountDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.order.TradeOrder;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.order.TradeOrderMoney;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.user.UserAccount;
/*     */ import com.hundsun.network.gates.wulin.biz.service.BaseService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.order.TradeOrderLogService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.order.TradeOrderService;
/*     */ import com.hundsun.network.melody.common.util.Money;
/*     */ import java.math.BigDecimal;
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
/*     */ @Service("penaltyCheckGoodsPenaltyServiceImpl")
/*     */ public class PenaltyCheckGoodsPenaltyServiceImpl extends BaseService
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
/*     */   @Autowired
/*     */   private RemoteSystemBaseService remoteSystemBaseService;
/*     */ 
/*     */   public TradeOrderGoodAmountServiceResult process(TradeOrderBaseRequest request, final TradeOrder tradeOrder)
/*     */   {
/*  60 */     TradeOrderGoodAmountServiceResult result = new TradeOrderGoodAmountServiceResult();
/*  61 */     final String orderNo = request.getOrderNo();
/*     */ 
/*  63 */     final String operator = request.getOperator();
/*  64 */     boolean hasSellerPenalty = request.getHasSellerPenalty();
/*  65 */     final String operatorType = EnumOperatorType.SYSTEM.getValue();
/*     */ 
/*  67 */     if (!hasSellerPenalty) {
/*  68 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.PARAMETER_ERROR.getValue()));
/*  69 */       result.setErrorInfo(EnumTradeOrderResultErrors.PARAMETER_ERROR.getInfo());
/*  70 */       this.log.error("PenaltyCheckGoodsProcessService.process() error: " + result.getErrorInfo());
/*  71 */       return result;
/*     */     }
/*  73 */     final TradeOrderMoney buyMoney = this.tradeOrderMoneyDAO.selectByAccountOrderNo(orderNo, tradeOrder.getBuyerAccount());
/*  74 */     final TradeOrderMoney sellMoney = this.tradeOrderMoneyDAO.selectByAccountOrderNo(orderNo, tradeOrder.getSellerAccount());
/*  75 */     final UserAccount sellAcc = this.userAccountDAO.selectByUserAccount(tradeOrder.getSellerAccount());
/*  76 */     final UserAccount buyAcc = this.userAccountDAO.selectByUserAccount(tradeOrder.getBuyerAccount());
/*     */ 
/*  78 */     long spa = 0L;
/*     */ 
/*  80 */     if (hasSellerPenalty) {
/*  81 */       BigDecimal rate = getDeliveryBrokenRate();
/*  82 */       if (rate == null) {
/*  83 */         result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.QUERY_DELIVERY_BROKEN_RATE_ERROR.getValue()));
/*  84 */         result.setErrorInfo(EnumTradeOrderResultErrors.QUERY_DELIVERY_BROKEN_RATE_ERROR.getInfo());
/*  85 */         return result;
/*     */       }
/*  87 */       Money money = new Money();
/*  88 */       money.setCent(sellMoney.getDeliveryDeposit().longValue());
/*  89 */       spa = money.multiply(rate).getCent();
/*     */     }
/*     */ 
/*  92 */     final Long sellPenaltyAmount = Long.valueOf(spa == 0L ? 0L : spa);
/*     */ 
/*  95 */     result = (TradeOrderGoodAmountServiceResult)this.transactionTemplate.execute(new TransactionCallback() {
/*     */       public TradeOrderGoodAmountServiceResult doInTransaction(TransactionStatus status) {
/*  97 */         TradeOrderGoodAmountServiceResult result = new TradeOrderGoodAmountServiceResult();
/*     */         try
/*     */         {
/* 100 */           Map param = new HashMap();
/* 101 */           param.put("operator", operator);
/* 102 */           param.put("whereStatus", tradeOrder.getStatus());
/* 103 */           param.put("status", EnumTradeOrderStatus.COLSE.getValue());
/*     */ 
/* 105 */           PenaltyCheckGoodsPenaltyServiceImpl.this.tradeOrderService.updateParamByOrderNo(param, orderNo);
/*     */ 
/* 107 */           String remark = DateUtil.getDateFormat(new Date(), null) + 
/* 108 */             "操作人:" + 
/* 109 */             operator + 
/* 110 */             " 确认交割投诉操作" + EnumTradeOrderCcDealType.DEFAULT_SELLER_GOODS_REFUND_PENALTY.getName() + 
/* 111 */             CommonUtils.getValuationUnitDesc(
/* 112 */             Long.valueOf(tradeOrder.getOrderAmount()
/* 112 */             .longValue()), tradeOrder.getValuationUnit());
/* 113 */           PenaltyCheckGoodsPenaltyServiceImpl.this.tradeOrderLogService.insert(orderNo, tradeOrder.getStatus(), 
/* 114 */             EnumTradeOrderStatus.COLSE.getValue(), operator, operatorType, 
/* 115 */             remark);
/*     */ 
/* 118 */           Long buyDeliveryDeposit = buyMoney.getDeliveryDeposit();
/* 119 */           Long sellDeliveryDeposit = sellMoney.getDeliveryDeposit();
/* 120 */           Long buyGoodsAmount = buyMoney.getGoodsAmount();
/*     */ 
/* 123 */           buyMoney.setDeliveryDeposit(Long.valueOf(0L));
/* 124 */           buyMoney.setGoodsAmount(Long.valueOf(0L));
/* 125 */           buyMoney.setPenaltyAmount(sellPenaltyAmount);
/* 126 */           if (PenaltyCheckGoodsPenaltyServiceImpl.this.tradeOrderMoneyDAO.updateBySelective(buyMoney) <= 0) {
/* 127 */             status.setRollbackOnly();
/* 128 */             result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.CONFIRM_UPDATE_ORDER_MONEY_ERROR.getValue()));
/* 129 */             result.setErrorInfo(EnumTradeOrderResultErrors.CONFIRM_UPDATE_ORDER_MONEY_ERROR.getInfo());
/* 130 */             return result;
/*     */           }
/*     */ 
/* 133 */           sellMoney.setDeliveryDeposit(Long.valueOf(0L));
/* 134 */           sellMoney.setGoodsAmount(Long.valueOf(0L));
/* 135 */           sellMoney.setPenaltyAmount(Long.valueOf(-sellPenaltyAmount.longValue()));
/* 136 */           if (PenaltyCheckGoodsPenaltyServiceImpl.this.tradeOrderMoneyDAO.updateBySelective(sellMoney) <= 0) {
/* 137 */             status.setRollbackOnly();
/* 138 */             result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.CONFIRM_UPDATE_ORDER_MONEY_ERROR.getValue()));
/* 139 */             result.setErrorInfo(EnumTradeOrderResultErrors.CONFIRM_UPDATE_ORDER_MONEY_ERROR.getInfo());
/* 140 */             return result;
/*     */           }
/*     */ 
/* 144 */           TransRequest trRequest = new TransRequest();
/* 145 */           trRequest.setFundAccount(buyAcc.getFundAccount());
/* 146 */           trRequest.setSellFundAccount(sellAcc.getFundAccount());
/* 147 */           trRequest.setOrderProperty(tradeOrder.getTradingType());
/* 148 */           trRequest.setGoodsAmountType(EnumGoodsAmountType.CHECK_GOODS.getValue());
/* 149 */           trRequest.setHasInvoice(tradeOrder.getHasInvoice());
/* 150 */           trRequest.setGoodsAmount(Long.valueOf(0L));
/* 151 */           trRequest.setBuyerGoodsAmount(buyGoodsAmount);
/* 152 */           trRequest.setPenaltyType(EnumPenaltyType.PENALTY_TYPE_SELLER.getValue());
/* 153 */           trRequest.setPenaltyamount(Long.valueOf(sellPenaltyAmount.longValue()));
/* 154 */           trRequest.setPenaltydeliveryAmount(sellDeliveryDeposit);
/* 155 */           trRequest.setDeliveryAmount(buyDeliveryDeposit);
/* 156 */           trRequest.setCheckGoodsTicketType(EnumTradeOrderCcDealType.DEFAULT_SELLER_GOODS_REFUND_PENALTY.getValue());
/* 157 */           trRequest.setBizNo(orderNo);
/* 158 */           trRequest.setOperator(operator);
/* 159 */           trRequest.setMemo(remark);
/* 160 */           FundOperateResult fundOperateResult = PenaltyCheckGoodsPenaltyServiceImpl.this.remoteFundService.checkGoodsTicketBroken(trRequest);
/* 161 */           if (fundOperateResult.isError())
/*     */           {
/* 163 */             PenaltyCheckGoodsPenaltyServiceImpl.this.log.error("PenaltyCheckGoodsAmountServiceImpl.process() error:" + fundOperateResult.getErrorInfo());
/* 164 */             status.setRollbackOnly();
/* 165 */             result.setErrorNO(Integer.valueOf(EnumUserResultErrors.INTERNAL_ERROR.getValue()));
/* 166 */             result.setErrorInfo(fundOperateResult.getErrorInfo());
/* 167 */             return result;
/*     */           }
/* 169 */           result.setGoodsAmount(buyGoodsAmount);
/* 170 */           result.setSellPenaltyAmount(sellPenaltyAmount);
/* 171 */           result.setSellDeliveryDeposit(sellDeliveryDeposit);
/* 172 */           result.setBuyDeliveryDeposit(buyDeliveryDeposit);
/*     */         }
/*     */         catch (Exception e) {
/* 175 */           PenaltyCheckGoodsPenaltyServiceImpl.this.log.error("PenaltyCheckGoodsAmountServiceImpl.process() error:", e);
/* 176 */           status.setRollbackOnly();
/* 177 */           result.setErrorNO(Integer.valueOf(EnumUserResultErrors.INTERNAL_ERROR.getValue()));
/* 178 */           result.setErrorInfo(EnumUserResultErrors.INTERNAL_ERROR.getInfo());
/* 179 */           return result;
/*     */         }
/* 181 */         return result;
/*     */       }
/*     */     });
/* 184 */     return result;
/*     */   }
/*     */ 
/*     */   private BigDecimal getDeliveryBrokenRate()
/*     */   {
/* 192 */     SystemDictRequest request = new SystemDictRequest();
/* 193 */     request.setParaCode(EnumSystemDictKey.JS_LIQUIDATED_DAMAGES.getValue());
/*     */     try {
/* 195 */       SystemDictServiceResult result = this.remoteSystemBaseService
/* 196 */         .selectLiquidatedDamages(request);
/* 197 */       if (result.correct()) {
/* 198 */         return BigDecimal.valueOf(Long.valueOf(result.getSystemDictDTO().getParaValue()).longValue())
/* 199 */           .movePointLeft(4);
/*     */       }
/* 201 */       this.log
/* 202 */         .error("in getTradeBrokenRate,selectLiquidatedDamages fail:" + 
/* 203 */         result.getErrorInfo());
/*     */     } catch (Exception e) {
/* 205 */       this.log.error("in getTradeBrokenRate,selectLiquidatedDamages fail: ", e);
/*     */     }
/* 207 */     return null;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.pojo.order.penaltycheckgoods.PenaltyCheckGoodsPenaltyServiceImpl
 * JD-Core Version:    0.6.0
 */