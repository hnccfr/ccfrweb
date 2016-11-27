/*     */ package com.hundsun.network.gates.wulin.biz.service.pojo.order.penaltycheckgoods;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumHasEnabled;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumOperatorType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumPaymentType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumSystemDictKey;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeOrderCcDealType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeOrderStatus;
/*     */ import com.hundsun.network.gates.luosi.common.utils.BigDecimalUtil;
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
/*     */ import com.hundsun.network.gates.wulin.biz.domain.baseset.SystemDict;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.order.TradeOrder;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.order.TradeOrderMoney;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.user.UserAccount;
/*     */ import com.hundsun.network.gates.wulin.biz.service.BaseService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.baseset.SystemDictService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.order.TradeOrderLogService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.order.TradeOrderService;
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
/*     */ @Service("penaltyCheckGoodsAmountLessServiceImpl")
/*     */ public class PenaltyCheckGoodsAmountLessServiceImpl extends BaseService
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
/*     */   private SystemDictService systemDictService;
/*     */ 
/*     */   public TradeOrderGoodAmountServiceResult process(TradeOrderBaseRequest request, final TradeOrder tradeOrder)
/*     */   {
/*  63 */     TradeOrderGoodAmountServiceResult result = new TradeOrderGoodAmountServiceResult();
/*  64 */     final String orderNo = request.getOrderNo();
/*     */ 
/*  66 */     final String operator = request.getOperator();
/*  67 */     final Long goodsAmount = request.getGoodsAmount();
/*  68 */     boolean hasSellerPenalty = request.getHasSellerPenalty();
/*  69 */     final String operatorType = EnumOperatorType.SYSTEM.getValue();
/*     */ 
/*  71 */     if (hasSellerPenalty) {
/*  72 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.PARAMETER_ERROR.getValue()));
/*  73 */       result.setErrorInfo(EnumTradeOrderResultErrors.PARAMETER_ERROR.getInfo());
/*  74 */       this.log.error("PenaltyCheckGoodsProcessService.process() error: " + result.getErrorInfo());
/*  75 */       return result;
/*     */     }
/*  77 */     final TradeOrderMoney buyMoney = this.tradeOrderMoneyDAO.selectByAccountOrderNo(orderNo, tradeOrder.getBuyerAccount());
/*  78 */     final TradeOrderMoney sellMoney = this.tradeOrderMoneyDAO.selectByAccountOrderNo(orderNo, tradeOrder.getSellerAccount());
/*  79 */     final UserAccount sellAcc = this.userAccountDAO.selectByUserAccount(tradeOrder.getSellerAccount());
/*  80 */     final UserAccount buyAcc = this.userAccountDAO.selectByUserAccount(tradeOrder.getBuyerAccount());
/*     */ 
/*  83 */     Long sellGoodsAmount = Long.valueOf(0L);
/*  84 */     Long goodsAmountHold = Long.valueOf(0L);
/*     */ 
/*  86 */     if ((EnumHasEnabled.NEED.getValue().equals(tradeOrder.getHasInvoice())) && 
/*  87 */       (EnumPaymentType.OnLine.getValue().equalsIgnoreCase(tradeOrder.getPaymentType()))) {
/*  88 */       SystemDict payProportion = this.systemDictService.selectSingleByKey(EnumSystemDictKey.GOODS_PAY_PROPORTION.getValue());
/*  89 */       if (payProportion.getParaValue() == null) {
/*  90 */         result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.CONFIG_GOODPAR_ERROR.getValue()));
/*  91 */         result.setErrorInfo(EnumTradeOrderResultErrors.CONFIG_GOODPAR_ERROR.getInfo());
/*  92 */         return result;
/*     */       }
/*     */       try {
/*  95 */         Long kk = Long.valueOf(new BigDecimal(payProportion.getParaValue()).longValue());
/*  96 */         if (kk.longValue() >= 10000L) {
/*  97 */           result.setErrorNO(
/*  98 */             Integer.valueOf(EnumTradeOrderResultErrors.CONFIG_GOODPAR_ERROR
/*  98 */             .getValue()));
/*  99 */           result.setErrorInfo(EnumTradeOrderResultErrors.CONFIG_GOODPAR_ERROR
/* 100 */             .getInfo());
/* 101 */           return result;
/*     */         }
/*     */       } catch (Exception e) {
/* 104 */         result.setErrorNO(
/* 105 */           Integer.valueOf(EnumTradeOrderResultErrors.CONFIG_GOODPAR_ERROR
/* 105 */           .getValue()));
/* 106 */         result.setErrorInfo(EnumTradeOrderResultErrors.CONFIG_GOODPAR_ERROR
/* 107 */           .getInfo());
/* 108 */         return result;
/*     */       }
/*     */ 
/* 112 */       BigDecimal paygodPro = new BigDecimal(payProportion.getParaValue()).movePointLeft(4);
/* 113 */       BigDecimalUtil util = new BigDecimalUtil();
/* 114 */       BigDecimal goodsAmountSend = BigDecimalUtil.mul(new BigDecimal(buyMoney.getGoodsAmount().longValue()), paygodPro).setScale(0, 3);
/* 115 */       goodsAmountHold = Long.valueOf(buyMoney.getGoodsAmount().longValue() - goodsAmountSend.longValue());
/* 116 */       if ((0L >= goodsAmount.longValue()) || (goodsAmount.longValue() > goodsAmountSend.longValue()))
/*     */       {
/* 118 */         result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.PENALTYCG_BUY_GOODSAMOUNT_ERROR.getValue()));
/* 119 */         result.setErrorInfo(EnumTradeOrderResultErrors.PENALTYCG_BUY_GOODSAMOUNT_ERROR.getInfo());
/* 120 */         return result;
/*     */       }
/* 122 */       sellGoodsAmount = Long.valueOf(goodsAmountSend.longValue() - goodsAmount.longValue());
/*     */     } else {
/* 124 */       if ((0L >= goodsAmount.longValue()) || (goodsAmount.longValue() > buyMoney.getGoodsAmount().longValue()))
/*     */       {
/* 126 */         result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.PENALTYCG_BUY_GOODSAMOUNT_ERROR.getValue()));
/* 127 */         result.setErrorInfo(EnumTradeOrderResultErrors.PENALTYCG_BUY_GOODSAMOUNT_ERROR.getInfo());
/* 128 */         return result;
/*     */       }
/* 130 */       sellGoodsAmount = Long.valueOf(buyMoney.getGoodsAmount().longValue() - goodsAmount.longValue());
/* 131 */       goodsAmountHold = Long.valueOf(0L);
/*     */     }
/* 133 */     final Long sellGodAmount = sellGoodsAmount;
/* 134 */     final Long godsAmountHold = goodsAmountHold;
/* 135 */     final boolean nextstep = EnumHasEnabled.NEED.getValue().equals(tradeOrder.getHasInvoice());
/* 136 */     final String orderstatusName = nextstep ? EnumTradeOrderStatus.WAIT_CHECKTICKET.getName() : EnumTradeOrderStatus.FINISHED.getName();
/*     */ 
/* 138 */     result = (TradeOrderGoodAmountServiceResult)this.transactionTemplate.execute(new TransactionCallback() {
/*     */       public TradeOrderGoodAmountServiceResult doInTransaction(TransactionStatus status) {
/* 140 */         TradeOrderGoodAmountServiceResult result = new TradeOrderGoodAmountServiceResult();
/*     */         try
/*     */         {
/* 143 */           Map param = new HashMap();
/* 144 */           param.put("operator", operator);
/* 145 */           param.put("whereStatus", tradeOrder.getStatus());
/*     */ 
/* 147 */           param.put("status", nextstep ? EnumTradeOrderStatus.WAIT_CHECKTICKET.getValue() : EnumTradeOrderStatus.FINISHED.getValue());
/*     */ 
/* 149 */           PenaltyCheckGoodsAmountLessServiceImpl.this.tradeOrderService.updateParamByOrderNo(param, orderNo);
/*     */ 
/* 151 */           String remark = DateUtil.getDateFormat(new Date(), null) + 
/* 152 */             "操作人:" + 
/* 153 */             operator + 
/* 154 */             " 确认交割投诉操作" + EnumTradeOrderCcDealType.DEFAULT_SELLER_DOODS_ARIVAL_AMOUNT.getName() + 
/* 155 */             " 订单状态:" + orderstatusName + 
/* 156 */             CommonUtils.getValuationUnitDesc(
/* 157 */             Long.valueOf(tradeOrder.getOrderAmount()
/* 157 */             .longValue()), tradeOrder.getValuationUnit());
/* 158 */           PenaltyCheckGoodsAmountLessServiceImpl.this.tradeOrderLogService.insert(orderNo, tradeOrder.getStatus(), 
/* 159 */             nextstep ? EnumTradeOrderStatus.WAIT_CHECKTICKET.getValue() : EnumTradeOrderStatus.FINISHED.getValue(), 
/* 160 */             operator, operatorType, remark);
/*     */ 
/* 163 */           Long buyDeliveryDeposit = buyMoney.getDeliveryDeposit();
/* 164 */           Long sellDeliveryDeposit = sellMoney.getDeliveryDeposit();
/*     */ 
/* 167 */           if (!nextstep) {
/* 168 */             buyMoney.setDeliveryDeposit(Long.valueOf(0L));
/*     */           }
/* 170 */           buyMoney.setGoodsAmount(godsAmountHold);
/* 171 */           buyMoney.setPenaltyAmount(Long.valueOf(0L));
/* 172 */           if (PenaltyCheckGoodsAmountLessServiceImpl.this.tradeOrderMoneyDAO.updateBySelective(buyMoney) <= 0) {
/* 173 */             status.setRollbackOnly();
/* 174 */             result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.CONFIRM_UPDATE_ORDER_MONEY_ERROR.getValue()));
/* 175 */             result.setErrorInfo(EnumTradeOrderResultErrors.CONFIRM_UPDATE_ORDER_MONEY_ERROR.getInfo());
/* 176 */             return result;
/*     */           }
/*     */ 
/* 180 */           if (!nextstep) {
/* 181 */             sellMoney.setDeliveryDeposit(Long.valueOf(0L));
/*     */           }
/* 183 */           sellMoney.setGoodsAmount(sellGodAmount);
/* 184 */           sellMoney.setPenaltyAmount(Long.valueOf(0L));
/* 185 */           if (PenaltyCheckGoodsAmountLessServiceImpl.this.tradeOrderMoneyDAO.updateBySelective(sellMoney) <= 0) {
/* 186 */             status.setRollbackOnly();
/* 187 */             result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.CONFIRM_UPDATE_ORDER_MONEY_ERROR.getValue()));
/* 188 */             result.setErrorInfo(EnumTradeOrderResultErrors.CONFIRM_UPDATE_ORDER_MONEY_ERROR.getInfo());
/* 189 */             return result;
/*     */           }
/*     */ 
/* 193 */           TransRequest trRequest = new TransRequest();
/* 194 */           trRequest.setFundAccount(buyAcc.getFundAccount());
/* 195 */           trRequest.setSellFundAccount(sellAcc.getFundAccount());
/* 196 */           trRequest.setOrderProperty(tradeOrder.getTradingType());
/* 197 */           trRequest.setGoodsAmountType(EnumGoodsAmountType.CHECK_GOODS.getValue());
/* 198 */           trRequest.setHasInvoice(tradeOrder.getHasInvoice());
/* 199 */           trRequest.setGoodsAmount(Long.valueOf(sellGodAmount.longValue()));
/* 200 */           trRequest.setBuyerGoodsAmount(Long.valueOf(goodsAmount.longValue()));
/* 201 */           trRequest.setPenaltyType(EnumPenaltyType.PENALTY_TYPE_NO.getValue());
/* 202 */           trRequest.setPenaltyamount(Long.valueOf(0L));
/* 203 */           if (nextstep) {
/* 204 */             trRequest.setPenaltydeliveryAmount(Long.valueOf(0L));
/* 205 */             trRequest.setDeliveryAmount(Long.valueOf(0L));
/*     */           } else {
/* 207 */             trRequest.setPenaltydeliveryAmount(sellDeliveryDeposit);
/* 208 */             trRequest.setDeliveryAmount(buyDeliveryDeposit);
/*     */           }
/* 210 */           trRequest.setCheckGoodsTicketType(EnumTradeOrderCcDealType.DEFAULT_SELLER_DOODS_ARIVAL_AMOUNT.getValue());
/* 211 */           trRequest.setBizNo(orderNo);
/* 212 */           trRequest.setOperator(operator);
/* 213 */           trRequest.setMemo(remark);
/* 214 */           FundOperateResult fundOperateResult = PenaltyCheckGoodsAmountLessServiceImpl.this.remoteFundService.checkGoodsTicketBroken(trRequest);
/* 215 */           if (fundOperateResult.isError())
/*     */           {
/* 217 */             PenaltyCheckGoodsAmountLessServiceImpl.this.log.error("PenaltyCheckGoodsAmountServiceImpl.process() error:" + fundOperateResult.getErrorInfo());
/* 218 */             status.setRollbackOnly();
/* 219 */             result.setErrorNO(Integer.valueOf(EnumUserResultErrors.INTERNAL_ERROR.getValue()));
/* 220 */             result.setErrorInfo(fundOperateResult.getErrorInfo());
/* 221 */             return result;
/*     */           }
/* 223 */           result.setGoodsAmount(goodsAmount);
/* 224 */           result.setSellGoodsAmount(sellGodAmount);
/* 225 */           if (!nextstep) {
/* 226 */             result.setSellDeliveryDeposit(sellDeliveryDeposit);
/* 227 */             result.setBuyDeliveryDeposit(buyDeliveryDeposit);
/*     */           }
/*     */         }
/*     */         catch (Exception e) {
/* 231 */           PenaltyCheckGoodsAmountLessServiceImpl.this.log.error("PenaltyCheckGoodsAmountServiceImpl.process() error:", e);
/* 232 */           status.setRollbackOnly();
/* 233 */           result.setErrorNO(Integer.valueOf(EnumUserResultErrors.INTERNAL_ERROR.getValue()));
/* 234 */           result.setErrorInfo(EnumUserResultErrors.INTERNAL_ERROR.getInfo());
/* 235 */           return result;
/*     */         }
/* 237 */         return result;
/*     */       }
/*     */     });
/* 240 */     return result;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.pojo.order.penaltycheckgoods.PenaltyCheckGoodsAmountLessServiceImpl
 * JD-Core Version:    0.6.0
 */