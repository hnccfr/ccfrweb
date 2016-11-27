/*     */ package com.hundsun.network.gates.wulin.biz.service.pojo.order.checkgoods;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumHasEnabled;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumPaymentType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeOrderStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumUserIntegralLogOperateCode;
/*     */ import com.hundsun.network.gates.luosi.common.utils.CommonUtils;
/*     */ import com.hundsun.network.gates.luosi.common.utils.DateUtil;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.enums.EnumGoodsAmountType;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.request.TransRequest;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.result.FundOperateResult;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.service.RemoteFundService;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumTradeOrderResultErrors;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumUserResultErrors;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.TradeOrderBaseRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.UserLevelRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.TradeOrderGoodAmountServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.UserLevelServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteSystemBaseService;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteUserService;
/*     */ import com.hundsun.network.gates.wulin.biz.dao.order.TradeOrderDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.dao.order.TradeOrderMoneyDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.dao.user.UserAccountDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.order.TradeOrder;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.order.TradeOrderMoney;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.user.UserAccount;
/*     */ import com.hundsun.network.gates.wulin.biz.service.BaseService;
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
/*     */ @Service("tradeOrderOnlineCheckGoodsNoInvoiceImpl")
/*     */ public class TradeOrderOnlineCheckGoodsNoInvoiceImpl extends BaseService
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private UserService userService;
/*     */ 
/*     */   @Autowired
/*     */   private RemoteSystemBaseService remoteSystemBaseService;
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
/*     */   private RemoteUserService remoteUserService;
/*     */ 
/*     */   @Autowired
/*     */   private RemoteFundService remoteFundService;
/*     */ 
/*     */   public TradeOrderGoodAmountServiceResult process(TradeOrderBaseRequest request, final TradeOrder tradeOrder)
/*     */   {
/*  73 */     TradeOrderGoodAmountServiceResult result = new TradeOrderGoodAmountServiceResult();
/*  74 */     final String operator = request.getOperator();
/*  75 */     final String operatorType = request.getOperatorType();
/*  76 */     final String orderNo = request.getOrderNo();
/*  77 */     String userAccount = request.getUserAccount();
/*  78 */     String payPwd = request.getPayPwd();
/*  79 */     if ((request == null) || (StringUtil.isEmpty(operator)) || (StringUtil.isEmpty(userAccount)) || 
/*  80 */       (StringUtil.isEmpty(orderNo))) {
/*  81 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.PARAMETER_ERROR.getValue()));
/*  82 */       result.setErrorInfo(EnumTradeOrderResultErrors.PARAMETER_ERROR.getInfo());
/*  83 */       this.log.error("tradeOrderOnlineCheckGoodsNoInvoiceImpl error: " + result.getErrorInfo());
/*  84 */       return result;
/*     */     }
/*  86 */     if (!EnumTradeOrderStatus.WAIT_CHECKGOODS.getValue().equalsIgnoreCase(
/*  87 */       tradeOrder.getStatus()))
/*     */     {
/*  89 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.STATUS_ERROR_DATA.getValue()));
/*  90 */       result.setErrorInfo(EnumTradeOrderResultErrors.STATUS_ERROR_DATA.getInfo());
/*  91 */       return result;
/*     */     }
/*     */ 
/*  94 */     if (!tradeOrder.getBuyerAccount().equals(userAccount)) {
/*  95 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.ORDER_NOT_MYSELF_ERROR.getValue()));
/*  96 */       result.setErrorInfo(EnumTradeOrderResultErrors.ORDER_NOT_MYSELF_ERROR.getInfo());
/*  97 */       this.log.error("tradeOrderOnlineCheckGoodsNoInvoiceImpl error: " + result.getErrorInfo());
/*  98 */       return result;
/*     */     }
/*     */ 
/* 101 */     if ((request.getCheckPayPwd().booleanValue()) && 
/* 102 */       (!this.userService.checkPayPwd(userAccount, payPwd))) {
/* 103 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.INPUT_PAYPWD_ERROR.getValue()));
/* 104 */       result.setErrorInfo(EnumTradeOrderResultErrors.INPUT_PAYPWD_ERROR.getInfo());
/* 105 */       this.log.error("tradeOrderOnlineCheckGoodsNoInvoiceImpl error: " + 
/* 106 */         result.getErrorInfo());
/* 107 */       return result;
/*     */     }
/*     */ 
/* 111 */     int orderFinishedAddintegral = 0;
/*     */ 
/* 124 */     final int orderFinishedAddintegralInt = orderFinishedAddintegral;
/*     */ 
/* 127 */     final UserAccount buyAcc = this.userAccountDAO.selectByUserAccount(tradeOrder.getBuyerAccount());
/*     */ 
/* 129 */     final UserAccount sellAcc = this.userAccountDAO.selectByUserAccount(tradeOrder
/* 130 */       .getSellerAccount());
/*     */ 
/* 132 */     final TradeOrderMoney sellMoney = this.tradeOrderMoneyDAO.selectByAccountOrderNo(tradeOrder
/* 133 */       .getOrderNo(), tradeOrder.getSellerAccount());
/*     */ 
/* 135 */     final TradeOrderMoney buyMoney = this.tradeOrderMoneyDAO.selectByAccountOrderNo(tradeOrder
/* 136 */       .getOrderNo(), tradeOrder.getBuyerAccount());
/*     */     try
/*     */     {
/* 140 */       if ((EnumHasEnabled.NO_NEED.getValue().equals(tradeOrder.getHasInvoice())) && 
/* 141 */         (EnumPaymentType.OnLine.getValue().equalsIgnoreCase(
/* 142 */         tradeOrder.getPaymentType())))
/*     */       {
/* 144 */         result = 
/* 145 */           (TradeOrderGoodAmountServiceResult)this.transactionTemplate
/* 145 */           .execute(new TransactionCallback()
/*     */         {
/*     */           public TradeOrderGoodAmountServiceResult doInTransaction(TransactionStatus status) {
/* 148 */             TradeOrderGoodAmountServiceResult result = new TradeOrderGoodAmountServiceResult();
/*     */             try
/*     */             {
/* 151 */               Map param = new HashMap();
/* 152 */               param.put("status", EnumTradeOrderStatus.FINISHED.getValue());
/* 153 */               param.put("whereStatus", tradeOrder.getStatus());
/* 154 */               param.put("operator", operator);
/*     */ 
/* 157 */               BigDecimal sellDeliveryDeposit = new BigDecimal(sellMoney
/* 158 */                 .getDeliveryDeposit().longValue());
/*     */ 
/* 160 */               BigDecimal buyDeliveryDeposit = new BigDecimal(buyMoney
/* 161 */                 .getDeliveryDeposit().longValue());
/*     */ 
/* 163 */               BigDecimal goodsAmount = new BigDecimal(buyMoney.getGoodsAmount() == null ? 0L : buyMoney.getGoodsAmount().longValue());
/* 164 */               sellMoney.setGoodsAmount(Long.valueOf(goodsAmount.longValue()));
/* 165 */               sellMoney.setDeliveryDeposit(Long.valueOf(0L));
/* 166 */               sellMoney.setOperator(operator);
/* 167 */               buyMoney.setDeliveryDeposit(Long.valueOf(0L));
/* 168 */               buyMoney.setGoodsAmount(Long.valueOf(0L));
/* 169 */               buyMoney.setOperator(operator);
/*     */ 
/* 171 */               if (TradeOrderOnlineCheckGoodsNoInvoiceImpl.this.tradeOrderMoneyDAO.updateBySelective(sellMoney) <= 0) {
/* 172 */                 status.setRollbackOnly();
/* 173 */                 result
/* 174 */                   .setErrorNO(
/* 175 */                   Integer.valueOf(EnumTradeOrderResultErrors.CONFIRM_UPDATE_ORDER_MONEY_ERROR
/* 175 */                   .getValue()));
/* 176 */                 result
/* 177 */                   .setErrorInfo(EnumTradeOrderResultErrors.CONFIRM_UPDATE_ORDER_MONEY_ERROR
/* 178 */                   .getInfo());
/* 179 */                 return result;
/*     */               }
/* 181 */               if (TradeOrderOnlineCheckGoodsNoInvoiceImpl.this.tradeOrderMoneyDAO.updateBySelective(buyMoney) <= 0) {
/* 182 */                 status.setRollbackOnly();
/* 183 */                 result
/* 184 */                   .setErrorNO(
/* 185 */                   Integer.valueOf(EnumTradeOrderResultErrors.CONFIRM_UPDATE_ORDER_MONEY_ERROR
/* 185 */                   .getValue()));
/* 186 */                 result
/* 187 */                   .setErrorInfo(EnumTradeOrderResultErrors.CONFIRM_UPDATE_ORDER_MONEY_ERROR
/* 188 */                   .getInfo());
/* 189 */                 return result;
/*     */               }
/*     */ 
/* 192 */               if (TradeOrderOnlineCheckGoodsNoInvoiceImpl.this.tradeOrderDAO.updateParamByOrderNo(param, tradeOrder
/* 193 */                 .getOrderNo()) <= 0) {
/* 194 */                 status.setRollbackOnly();
/* 195 */                 result
/* 196 */                   .setErrorNO(
/* 197 */                   Integer.valueOf(EnumTradeOrderResultErrors.CONFIRM_UPDATE_ORDER_ERROR
/* 197 */                   .getValue()));
/* 198 */                 result
/* 199 */                   .setErrorInfo(EnumTradeOrderResultErrors.CONFIRM_UPDATE_ORDER_ERROR
/* 200 */                   .getInfo());
/* 201 */                 return result;
/*     */               }
/*     */ 
/* 204 */               String remark = DateUtil.getDateFormat(new Date(), null) + "操作人:" + 
/* 205 */                 operator + " 处理确认交割分支④(线上交易不 需要发票):->交易完成" + 
/* 206 */                 " 订单金额:" + CommonUtils.getValuationUnitDesc(Long.valueOf(tradeOrder.getOrderAmount().longValue()), tradeOrder.getValuationUnit()) + 
/* 207 */                 " 卖家交收保证金：" + CommonUtils.getValuationUnitDesc(Long.valueOf(sellDeliveryDeposit.longValue()), tradeOrder.getValuationUnit()) + 
/* 208 */                 " 买家交收保证金：" + CommonUtils.getValuationUnitDesc(Long.valueOf(buyDeliveryDeposit.longValue()), tradeOrder.getValuationUnit());
/* 209 */               TradeOrderOnlineCheckGoodsNoInvoiceImpl.this.tradeOrderLogService.insert(orderNo, tradeOrder.getStatus(), 
/* 210 */                 EnumTradeOrderStatus.FINISHED.getValue(), operator, 
/* 211 */                 operatorType, remark);
/*     */ 
/* 214 */               UserLevelRequest rs = new UserLevelRequest();
/* 215 */               rs.setUserAccount(tradeOrder.getBuyerAccount());
/* 216 */               rs.setOrderNo(tradeOrder.getOrderNo());
/* 217 */               rs.setProjectCode(tradeOrder.getProjectCode());
/* 218 */               rs.setIntegral(Integer.valueOf(orderFinishedAddintegralInt));
/* 219 */               rs.setOperator(operator);
/* 220 */               rs.setOperateCode(EnumUserIntegralLogOperateCode.PROJECT_TURNOVER_INTEGRAL.getValue());
/*     */ 
/* 222 */               UserLevelServiceResult result3 = TradeOrderOnlineCheckGoodsNoInvoiceImpl.this.remoteUserService.updateUserLevel(rs);
/*     */ 
/* 225 */               result.setGoodsAmount(Long.valueOf(goodsAmount.longValue()));
/* 226 */               result.setBuyDeliveryDeposit(Long.valueOf(buyDeliveryDeposit.longValue()));
/* 227 */               result.setSellDeliveryDeposit(Long.valueOf(sellDeliveryDeposit.longValue()));
/*     */ 
/* 230 */               TransRequest request = new TransRequest();
/* 231 */               request.setOrderProperty(tradeOrder.getTradingType());
/* 232 */               request.setGoodsAmount(Long.valueOf(goodsAmount.longValue()));
/* 233 */               request.setBizNo(orderNo);
/* 234 */               request.setOperator(operator);
/* 235 */               request.setMemo(remark);
/* 236 */               request.setGoodsAmountType(EnumGoodsAmountType.CHECK_GOODS.getValue());
/* 237 */               request.setHasInvoice(tradeOrder.getHasInvoice());
/*     */ 
/* 239 */               request.setSellFundAccount(sellAcc.getFundAccount());
/* 240 */               request.setSellDeliveryAmount(Long.valueOf(sellDeliveryDeposit.longValue()));
/*     */ 
/* 242 */               request.setFundAccount(buyAcc.getFundAccount());
/* 243 */               request.setDeliveryAmount(Long.valueOf(buyDeliveryDeposit.longValue()));
/*     */ 
/* 245 */               FundOperateResult rr = TradeOrderOnlineCheckGoodsNoInvoiceImpl.this.remoteFundService.payPayment(request);
/* 246 */               if (rr.isError())
/*     */               {
/* 248 */                 TradeOrderOnlineCheckGoodsNoInvoiceImpl.this.log.error("remoteFundService.payPayment error:" + rr.getErrorInfo());
/* 249 */                 status.setRollbackOnly();
/* 250 */                 result.setErrorNO(
/* 251 */                   Integer.valueOf(EnumUserResultErrors.INTERNAL_ERROR
/* 251 */                   .getValue()));
/* 252 */                 result.setErrorInfo(rr.getErrorInfo());
/* 253 */                 return result;
/*     */               }
/*     */             }
/*     */             catch (Exception e) {
/* 257 */               TradeOrderOnlineCheckGoodsNoInvoiceImpl.this.log.error("tradeOrderOnlineCheckGoodsNoInvoiceImpl error:", e);
/* 258 */               status.setRollbackOnly();
/* 259 */               result.setErrorNO(Integer.valueOf(EnumUserResultErrors.INTERNAL_ERROR.getValue()));
/* 260 */               result.setErrorInfo(EnumUserResultErrors.INTERNAL_ERROR.getInfo());
/* 261 */               return result;
/*     */             }
/* 263 */             return result;
/*     */           } } );
/*     */       }
/*     */     } catch (Exception e) {
/* 268 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.INTERNAL_ERROR.getValue()));
/* 269 */       result.setErrorInfo(EnumTradeOrderResultErrors.INTERNAL_ERROR.getInfo());
/* 270 */       this.log.error("tradeOrderOnlineCheckGoodsNoInvoiceImpl error: " + result.getErrorInfo());
/* 271 */       return result;
/*     */     }
/* 273 */     return result;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.pojo.order.checkgoods.TradeOrderOnlineCheckGoodsNoInvoiceImpl
 * JD-Core Version:    0.6.0
 */