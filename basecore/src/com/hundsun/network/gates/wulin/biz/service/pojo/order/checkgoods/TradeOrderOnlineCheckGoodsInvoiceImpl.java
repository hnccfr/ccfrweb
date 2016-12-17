/*     */ package com.hundsun.network.gates.wulin.biz.service.pojo.order.checkgoods;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumSystemDictKey;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeOrderStatus;
/*     */ import com.hundsun.network.gates.luosi.common.utils.BigDecimalUtil;
/*     */ import com.hundsun.network.gates.luosi.common.utils.CommonUtils;
/*     */ import com.hundsun.network.gates.luosi.common.utils.DateUtil;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.enums.EnumGoodsAmountType;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.request.TransRequest;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.result.FundOperateResult;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.service.RemoteFundService;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumTradeOrderResultErrors;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumUserResultErrors;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.TradeOrderBaseRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.TradeOrderGoodAmountServiceResult;
/*     */ import com.hundsun.network.gates.wulin.biz.dao.order.TradeOrderDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.dao.order.TradeOrderMoneyDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.dao.user.UserAccountDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.baseset.SystemDict;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.order.TradeOrder;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.order.TradeOrderMoney;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.user.UserAccount;
/*     */ import com.hundsun.network.gates.wulin.biz.service.BaseService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.baseset.SystemDictService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.order.TradeOrderLogService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.user.UserService;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
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
/*     */ @Service("tradeOrderOnlineCheckGoodsInvoiceImpl")
/*     */ public class TradeOrderOnlineCheckGoodsInvoiceImpl extends BaseService
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private UserService userService;
/*     */ 
/*     */   @Autowired
/*     */   private UserAccountDAO userAccountDAO;
/*     */ 
/*     */   @Autowired
/*     */   private TradeOrderMoneyDAO tradeOrderMoneyDAO;
/*     */ 
/*     */   @Autowired
/*     */   private TradeOrderDAO tradeOrderDAO;
/*     */ 
/*     */   @Autowired
/*     */   private TradeOrderLogService tradeOrderLogService;
/*     */ 
/*     */   @Autowired
/*     */   private RemoteFundService remoteFundService;
/*     */ 
/*     */   @Autowired
/*     */   private SystemDictService systemDictService;
/*     */ 
/*     */   public TradeOrderGoodAmountServiceResult process(TradeOrderBaseRequest request, final TradeOrder tradeOrder)
/*     */   {
/*  65 */     TradeOrderGoodAmountServiceResult result = new TradeOrderGoodAmountServiceResult();
/*  66 */     final String operator = request.getOperator();
/*  67 */     final String operatorType = request.getOperatorType();
/*  68 */     final String orderNo = request.getOrderNo();
/*  69 */     String userAccount = request.getUserAccount();
/*  70 */     String payPwd = request.getPayPwd();
/*  71 */     if ((request == null) || (StringUtil.isEmpty(operator)) || (StringUtil.isEmpty(userAccount)) || 
/*  72 */       (StringUtil.isEmpty(orderNo))) {
/*  73 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.PARAMETER_ERROR.getValue()));
/*  74 */       result.setErrorInfo(EnumTradeOrderResultErrors.PARAMETER_ERROR.getInfo());
/*  75 */       this.log.error("tradeOrderOnlineCheckGoodsInvoiceImpl error: " + result.getErrorInfo());
/*  76 */       return result;
/*     */     }
/*  78 */     if (!EnumTradeOrderStatus.WAIT_CHECKGOODS.getValue().equalsIgnoreCase(
/*  79 */       tradeOrder.getStatus()))
/*     */     {
/*  81 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.STATUS_ERROR_DATA.getValue()));
/*  82 */       result.setErrorInfo(EnumTradeOrderResultErrors.STATUS_ERROR_DATA.getInfo());
/*  83 */       return result;
/*     */     }
/*     */ 
/*  86 */     if (!tradeOrder.getBuyerAccount().equals(userAccount)) {
/*  87 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.ORDER_NOT_MYSELF_ERROR.getValue()));
/*  88 */       result.setErrorInfo(EnumTradeOrderResultErrors.ORDER_NOT_MYSELF_ERROR.getInfo());
/*  89 */       this.log.error("tradeOrderOnlineCheckGoodsInvoiceImpl error: " + result.getErrorInfo());
/*  90 */       return result;
/*     */     }
/*     */ 
/*  93 */     if ((request.getCheckPayPwd().booleanValue()) && 
/*  94 */       (!this.userService.checkPayPwd(userAccount, payPwd))) {
/*  95 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.INPUT_PAYPWD_ERROR.getValue()));
/*  96 */       result.setErrorInfo(EnumTradeOrderResultErrors.INPUT_PAYPWD_ERROR.getInfo());
/*  97 */       this.log.error("tradeOrderOnlineCheckGoodsInvoiceImpl error: " + result.getErrorInfo());
/*  98 */       return result;
/*     */     }
/*     */ 
/* 102 */     final UserAccount buyAcc = this.userAccountDAO.selectByUserAccount(tradeOrder.getBuyerAccount());
/*     */ 
/* 104 */     final UserAccount sellAcc = this.userAccountDAO.selectByUserAccount(tradeOrder
/* 105 */       .getSellerAccount());
/*     */ 
/* 107 */     final TradeOrderMoney sellMoney = this.tradeOrderMoneyDAO.selectByAccountOrderNo(tradeOrder
/* 108 */       .getOrderNo(), tradeOrder.getSellerAccount());
/*     */ 
/* 110 */     final TradeOrderMoney buyMoney = this.tradeOrderMoneyDAO.selectByAccountOrderNo(tradeOrder
/* 111 */       .getOrderNo(), tradeOrder.getBuyerAccount());
/* 112 */     BigDecimalUtil util = new BigDecimalUtil();
/*     */     try
/*     */     {
/* 116 */       SystemDict payProportion = this.systemDictService
/* 117 */         .selectSingleByKey(EnumSystemDictKey.GOODS_PAY_PROPORTION.getValue());
/* 118 */       if (payProportion.getParaValue() == null) {
/* 119 */         result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.CONFIG_GOODPAR_ERROR.getValue()));
/* 120 */         result.setErrorInfo(EnumTradeOrderResultErrors.CONFIG_GOODPAR_ERROR.getInfo());
/* 121 */         return result;
/*     */       }
/*     */       try {
/* 124 */         Long kk = Long.valueOf(new BigDecimal(payProportion.getParaValue()).longValue());
/* 125 */         if (kk.longValue() >= 10000L) {
/* 126 */           result.setErrorNO(
/* 127 */             Integer.valueOf(EnumTradeOrderResultErrors.CONFIG_GOODPAR_ERROR
/* 127 */             .getValue()));
/* 128 */           result.setErrorInfo(EnumTradeOrderResultErrors.CONFIG_GOODPAR_ERROR
/* 129 */             .getInfo());
/* 130 */           return result;
/*     */         }
/*     */       } catch (Exception e) {
/* 133 */         result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.CONFIG_GOODPAR_ERROR.getValue()));
/* 134 */         result.setErrorInfo(EnumTradeOrderResultErrors.CONFIG_GOODPAR_ERROR.getInfo());
/* 135 */         return result;
/*     */       }
/*     */ 
/* 139 */       final BigDecimal paygodPro = new BigDecimal(payProportion.getParaValue())
/* 140 */         .movePointLeft(4);
/* 141 */       result = 
/* 142 */         (TradeOrderGoodAmountServiceResult)this.transactionTemplate
/* 142 */         .execute(new TransactionCallback()
/*     */       {
/*     */         public TradeOrderGoodAmountServiceResult doInTransaction(TransactionStatus status)
/*     */         {
/* 146 */           TradeOrderGoodAmountServiceResult result = new TradeOrderGoodAmountServiceResult();
/*     */           try
/*     */           {
/* 149 */             Map param = new HashMap();
/* 150 */             param.put("status", EnumTradeOrderStatus.WAIT_CHECKTICKET.getValue());
/* 151 */             param.put("whereStatus", tradeOrder.getStatus());
/* 152 */             param.put("operator", operator);
/*     */ 
/* 155 */             BigDecimal goodsAmountSend = BigDecimalUtil.mul(
/* 156 */               new BigDecimal(buyMoney.getGoodsAmount().longValue()), paygodPro).setScale(0, 
/* 157 */               3);
/* 158 */             BigDecimal goodsAmountHold = BigDecimalUtil.sub(new BigDecimal(buyMoney
/* 159 */               .getGoodsAmount().longValue()), goodsAmountSend);
/* 160 */             buyMoney.setGoodsAmount(Long.valueOf(goodsAmountHold.longValue()));
/* 161 */             buyMoney.setOperator(operator);
/* 162 */             sellMoney.setGoodsAmount(Long.valueOf(goodsAmountSend.longValue()));
/* 163 */             sellMoney.setOperator(operator);
/*     */ 
/* 165 */             if (TradeOrderOnlineCheckGoodsInvoiceImpl.this.tradeOrderMoneyDAO.updateBySelective(sellMoney) <= 0) {
/* 166 */               status.setRollbackOnly();
/* 167 */               result
/* 168 */                 .setErrorNO(
/* 169 */                 Integer.valueOf(EnumTradeOrderResultErrors.CONFIRM_UPDATE_ORDER_MONEY_ERROR
/* 169 */                 .getValue()));
/* 170 */               result
/* 171 */                 .setErrorInfo(EnumTradeOrderResultErrors.CONFIRM_UPDATE_ORDER_MONEY_ERROR
/* 172 */                 .getInfo());
/* 173 */               return result;
/*     */             }
/* 175 */             if (TradeOrderOnlineCheckGoodsInvoiceImpl.this.tradeOrderMoneyDAO.updateBySelective(buyMoney) <= 0) {
/* 176 */               status.setRollbackOnly();
/* 177 */               result
/* 178 */                 .setErrorNO(
/* 179 */                 Integer.valueOf(EnumTradeOrderResultErrors.CONFIRM_UPDATE_ORDER_MONEY_ERROR
/* 179 */                 .getValue()));
/* 180 */               result
/* 181 */                 .setErrorInfo(EnumTradeOrderResultErrors.CONFIRM_UPDATE_ORDER_MONEY_ERROR
/* 182 */                 .getInfo());
/* 183 */               return result;
/*     */             }
/*     */ 
/* 186 */             if (TradeOrderOnlineCheckGoodsInvoiceImpl.this.tradeOrderDAO.updateParamByOrderNo(param, tradeOrder.getOrderNo()) <= 0) {
/* 187 */               status.setRollbackOnly();
/* 188 */               result
/* 189 */                 .setErrorNO(
/* 190 */                 Integer.valueOf(EnumTradeOrderResultErrors.CONFIRM_UPDATE_ORDER_ERROR
/* 190 */                 .getValue()));
/* 191 */               result
/* 192 */                 .setErrorInfo(EnumTradeOrderResultErrors.CONFIRM_UPDATE_ORDER_ERROR
/* 193 */                 .getInfo());
/* 194 */               return result;
/*     */             }
/*     */ 
/* 197 */             String remark = DateUtil.getDateFormat(new Date(), null) + 
/* 198 */               "操作人:" + 
/* 199 */               operator + 
/* 200 */               " 处理确认交割分支③(线上交易需要发票):->待买家验票" + 
/* 201 */               " 订单金额：" + 
/* 202 */               CommonUtils.getValuationUnitDesc(
/* 203 */               Long.valueOf(tradeOrder
/* 203 */               .getOrderAmount().longValue()), tradeOrder
/* 204 */               .getValuationUnit()) + 
/* 205 */               " 付给卖家货款:" + 
/* 206 */               CommonUtils.getValuationUnitDesc(
/* 207 */               Long.valueOf(goodsAmountSend
/* 207 */               .longValue()), tradeOrder.getValuationUnit()) + 
/* 208 */               " 剩余货款:" + 
/* 209 */               CommonUtils.getValuationUnitDesc(
/* 210 */               Long.valueOf(goodsAmountHold
/* 210 */               .longValue()), tradeOrder.getValuationUnit());
/* 211 */             TradeOrderOnlineCheckGoodsInvoiceImpl.this.tradeOrderLogService.insert(orderNo, tradeOrder.getStatus(), 
/* 212 */               EnumTradeOrderStatus.WAIT_CHECKTICKET.getValue(), operator, 
/* 213 */               operatorType, remark);
/*     */ 
/* 215 */             TransRequest request = new TransRequest();
/* 216 */             request.setOrderProperty(tradeOrder.getTradingType());
/* 217 */             request.setGoodsAmount(Long.valueOf(goodsAmountSend.longValue()));
/* 218 */             request.setBizNo(orderNo);
/* 219 */             request.setOperator(operator);
/* 220 */             request.setMemo(remark);
/* 221 */             request.setGoodsAmountType(EnumGoodsAmountType.CHECK_GOODS.getValue());
/* 222 */             request.setHasInvoice(tradeOrder.getHasInvoice());
/*     */ 
/* 224 */             request.setSellFundAccount(sellAcc.getFundAccount());
/* 225 */             request.setSellDeliveryAmount(Long.valueOf(0L));
/*     */ 
/* 227 */             request.setFundAccount(buyAcc.getFundAccount());
/* 228 */             request.setDeliveryAmount(Long.valueOf(0L));
/*     */ 
/* 230 */             result.setGoodsAmount(Long.valueOf(goodsAmountSend.longValue()));
/*     */ 
/* 232 */             FundOperateResult rr = TradeOrderOnlineCheckGoodsInvoiceImpl.this.remoteFundService.payPayment(request);
/* 233 */             if (rr.isError())
/*     */             {
/* 235 */               TradeOrderOnlineCheckGoodsInvoiceImpl.this.log.error("tradeOrderOnlineCheckGoodsInvoiceImpl error:" + 
/* 236 */                 rr.getErrorInfo());
/* 237 */               status.setRollbackOnly();
/* 238 */               result.setErrorNO(Integer.valueOf(EnumUserResultErrors.INTERNAL_ERROR.getValue()));
/* 239 */               result.setErrorInfo(rr.getErrorInfo());
/* 240 */               return result;
/*     */             }
/*     */           }
/*     */           catch (Exception e) {
/* 244 */             TradeOrderOnlineCheckGoodsInvoiceImpl.this.log.error("tradeOrderOnlineCheckGoodsInvoiceImpl error:", e);
/* 245 */             status.setRollbackOnly();
/* 246 */             result.setErrorNO(Integer.valueOf(EnumUserResultErrors.INTERNAL_ERROR.getValue()));
/* 247 */             result.setErrorInfo(EnumUserResultErrors.INTERNAL_ERROR.getInfo());
/* 248 */             return result;
/*     */           }
/* 250 */           return result;
/*     */         } } );
/*     */     } catch (Exception e) {
/* 254 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.INTERNAL_ERROR.getValue()));
/* 255 */       result.setErrorInfo(EnumTradeOrderResultErrors.INTERNAL_ERROR.getInfo());
/* 256 */       this.log.error("tradeOrderOnlineCheckGoodsInvoiceImpl error: " + result.getErrorInfo());
/* 257 */       return result;
/*     */     }
/* 259 */     return result;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.pojo.order.checkgoods.TradeOrderOnlineCheckGoodsInvoiceImpl
 * JD-Core Version:    0.6.0
 */