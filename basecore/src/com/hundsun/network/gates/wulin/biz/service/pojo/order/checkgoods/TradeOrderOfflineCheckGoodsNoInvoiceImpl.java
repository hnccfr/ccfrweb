/*     */ package com.hundsun.network.gates.wulin.biz.service.pojo.order.checkgoods;
/*     */ 
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
/*     */ @Service("tradeOrderOfflineCheckGoodsNoInvoiceImpl")
/*     */ public class TradeOrderOfflineCheckGoodsNoInvoiceImpl extends BaseService
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
/*  72 */     TradeOrderGoodAmountServiceResult result = new TradeOrderGoodAmountServiceResult();
/*  73 */     final String operator = request.getOperator();
/*  74 */     final String operatorType = request.getOperatorType();
/*  75 */     final String orderNo = request.getOrderNo();
/*  76 */     String userAccount = request.getUserAccount();
/*  77 */     String payPwd = request.getPayPwd();
/*  78 */     if ((request == null) || (StringUtil.isEmpty(operator)) || (StringUtil.isEmpty(userAccount)) || 
/*  79 */       (StringUtil.isEmpty(orderNo))) {
/*  80 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.PARAMETER_ERROR.getValue()));
/*  81 */       result.setErrorInfo(EnumTradeOrderResultErrors.PARAMETER_ERROR.getInfo());
/*  82 */       this.log.error("tradeOrderOfflineCheckGoodsNoInvoiceImpl error: " + result.getErrorInfo());
/*  83 */       return result;
/*     */     }
/*  85 */     if (!EnumTradeOrderStatus.WAIT_CHECKGOODS.getValue().equalsIgnoreCase(
/*  86 */       tradeOrder.getStatus()))
/*     */     {
/*  88 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.STATUS_ERROR_DATA.getValue()));
/*  89 */       result.setErrorInfo(EnumTradeOrderResultErrors.STATUS_ERROR_DATA.getInfo());
/*  90 */       return result;
/*     */     }
/*     */ 
/*  93 */     if (!tradeOrder.getBuyerAccount().equals(userAccount)) {
/*  94 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.ORDER_NOT_MYSELF_ERROR.getValue()));
/*  95 */       result.setErrorInfo(EnumTradeOrderResultErrors.ORDER_NOT_MYSELF_ERROR.getInfo());
/*  96 */       this.log.error("tradeOrderOfflineCheckGoodsNoInvoiceImpl error: " + result.getErrorInfo());
/*  97 */       return result;
/*     */     }
/*     */ 
/* 100 */     if ((request.getCheckPayPwd().booleanValue()) && 
/* 101 */       (!this.userService.checkPayPwd(userAccount, payPwd))) {
/* 102 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.INPUT_PAYPWD_ERROR.getValue()));
/* 103 */       result.setErrorInfo(EnumTradeOrderResultErrors.INPUT_PAYPWD_ERROR.getInfo());
/* 104 */       this.log.error("tradeOrderOfflineCheckGoodsNoInvoiceImpl error: " + 
/* 105 */         result.getErrorInfo());
/* 106 */       return result;
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
/* 141 */       result = 
/* 142 */         (TradeOrderGoodAmountServiceResult)this.transactionTemplate
/* 142 */         .execute(new TransactionCallback()
/*     */       {
/*     */         public TradeOrderGoodAmountServiceResult doInTransaction(TransactionStatus status) {
/* 145 */           TradeOrderGoodAmountServiceResult result = new TradeOrderGoodAmountServiceResult();
/*     */           try
/*     */           {
/* 148 */             Map param = new HashMap();
/* 149 */             param.put("status", EnumTradeOrderStatus.FINISHED.getValue());
/* 150 */             param.put("whereStatus", tradeOrder.getStatus());
/* 151 */             param.put("operator", operator);
/*     */ 
/* 153 */             BigDecimal sellDeliveryDeposit = new BigDecimal(sellMoney
/* 154 */               .getDeliveryDeposit().longValue());
/*     */ 
/* 156 */             BigDecimal buyDeliveryDeposit = new BigDecimal(buyMoney
/* 157 */               .getDeliveryDeposit().longValue());
/* 158 */             sellMoney.setDeliveryDeposit(Long.valueOf(0L));
/* 159 */             sellMoney.setOperator(operator);
/* 160 */             buyMoney.setDeliveryDeposit(Long.valueOf(0L));
/* 161 */             buyMoney.setOperator(operator);
/*     */ 
/* 163 */             if (TradeOrderOfflineCheckGoodsNoInvoiceImpl.this.tradeOrderMoneyDAO.updateBySelective(sellMoney) <= 0) {
/* 164 */               status.setRollbackOnly();
/* 165 */               result
/* 166 */                 .setErrorNO(
/* 167 */                 Integer.valueOf(EnumTradeOrderResultErrors.CONFIRM_UPDATE_ORDER_MONEY_ERROR
/* 167 */                 .getValue()));
/* 168 */               result
/* 169 */                 .setErrorInfo(EnumTradeOrderResultErrors.CONFIRM_UPDATE_ORDER_MONEY_ERROR
/* 170 */                 .getInfo());
/* 171 */               return result;
/*     */             }
/* 173 */             if (TradeOrderOfflineCheckGoodsNoInvoiceImpl.this.tradeOrderMoneyDAO.updateBySelective(buyMoney) <= 0) {
/* 174 */               status.setRollbackOnly();
/* 175 */               result
/* 176 */                 .setErrorNO(
/* 177 */                 Integer.valueOf(EnumTradeOrderResultErrors.CONFIRM_UPDATE_ORDER_MONEY_ERROR
/* 177 */                 .getValue()));
/* 178 */               result
/* 179 */                 .setErrorInfo(EnumTradeOrderResultErrors.CONFIRM_UPDATE_ORDER_MONEY_ERROR
/* 180 */                 .getInfo());
/* 181 */               return result;
/*     */             }
/*     */ 
/* 184 */             TradeOrderOfflineCheckGoodsNoInvoiceImpl.this.tradeOrderDAO.updateParamByOrderNo(param, tradeOrder.getOrderNo());
/*     */ 
/* 186 */             String remark = DateUtil.getDateFormat(new Date(), null) + "操作人:" + 
/* 187 */               operator + " 处理确认交割分支①(线下交易或货到付款，不需要发票):->订单交易完成 " + 
/* 188 */               " 订单金额:" + CommonUtils.getValuationUnitDesc(Long.valueOf(tradeOrder.getOrderAmount().longValue()), tradeOrder.getValuationUnit()) + 
/* 189 */               " 退还买家保证金:" + CommonUtils.getValuationUnitDesc(Long.valueOf(buyDeliveryDeposit.longValue()), tradeOrder.getValuationUnit()) + 
/* 190 */               " 退还卖家保证金:" + CommonUtils.getValuationUnitDesc(Long.valueOf(sellDeliveryDeposit.longValue()), tradeOrder.getValuationUnit());
/* 191 */             TradeOrderOfflineCheckGoodsNoInvoiceImpl.this.tradeOrderLogService.insert(orderNo, tradeOrder.getStatus(), 
/* 192 */               EnumTradeOrderStatus.FINISHED.getValue(), operator, 
/* 193 */               operatorType, remark);
/*     */ 
/* 196 */             UserLevelRequest rs = new UserLevelRequest();
/* 197 */             rs.setUserAccount(tradeOrder.getBuyerAccount());
/* 198 */             rs.setOrderNo(tradeOrder.getOrderNo());
/* 199 */             rs.setProjectCode(tradeOrder.getProjectCode());
/* 200 */             rs.setIntegral(Integer.valueOf(orderFinishedAddintegralInt));
/* 201 */             rs.setOperator(operator);
/* 202 */             rs.setOperateCode(EnumUserIntegralLogOperateCode.PROJECT_TURNOVER_INTEGRAL.getValue());
/*     */ 
/* 204 */             UserLevelServiceResult result3 = TradeOrderOfflineCheckGoodsNoInvoiceImpl.this.remoteUserService.updateUserLevel(rs);
/*     */ 
/* 207 */             TransRequest request = new TransRequest();
/* 208 */             request.setOrderProperty(tradeOrder.getTradingType());
/* 209 */             request.setBizNo(orderNo);
/* 210 */             request.setOperator(operator);
/* 211 */             request.setGoodsAmount(Long.valueOf(0L));
/* 212 */             request.setMemo(remark);
/* 213 */             request.setGoodsAmountType(EnumGoodsAmountType.CHECK_GOODS.getValue());
/* 214 */             request.setHasInvoice(tradeOrder.getHasInvoice());
/*     */ 
/* 216 */             request.setSellFundAccount(sellAcc.getFundAccount());
/* 217 */             request.setSellDeliveryAmount(Long.valueOf(sellDeliveryDeposit.longValue()));
/*     */ 
/* 219 */             request.setFundAccount(buyAcc.getFundAccount());
/* 220 */             request.setDeliveryAmount(Long.valueOf(buyDeliveryDeposit.longValue()));
/*     */ 
/* 222 */             result.setGoodsAmount(Long.valueOf(0L));
/* 223 */             result.setBuyDeliveryDeposit(Long.valueOf(buyDeliveryDeposit.longValue()));
/* 224 */             result.setSellDeliveryDeposit(Long.valueOf(sellDeliveryDeposit.longValue()));
/*     */ 
/* 226 */             FundOperateResult rr = TradeOrderOfflineCheckGoodsNoInvoiceImpl.this.remoteFundService.payPayment(request);
/* 227 */             if (rr.isError())
/*     */             {
/* 229 */               TradeOrderOfflineCheckGoodsNoInvoiceImpl.this.log.error("remoteFundService.payPayment error:" + rr.getErrorInfo());
/* 230 */               status.setRollbackOnly();
/* 231 */               result.setErrorNO(
/* 232 */                 Integer.valueOf(EnumUserResultErrors.INTERNAL_ERROR
/* 232 */                 .getValue()));
/* 233 */               result.setErrorInfo(rr.getErrorInfo());
/* 234 */               return result;
/*     */             }
/*     */           }
/*     */           catch (Exception e) {
/* 238 */             TradeOrderOfflineCheckGoodsNoInvoiceImpl.this.log.error("tradeOrderOfflineCheckGoodsNoInvoiceImpl error:", e);
/* 239 */             status.setRollbackOnly();
/* 240 */             result.setErrorNO(Integer.valueOf(EnumUserResultErrors.INTERNAL_ERROR.getValue()));
/* 241 */             result.setErrorInfo(EnumUserResultErrors.INTERNAL_ERROR.getInfo());
/* 242 */             return result;
/*     */           }
/* 244 */           return result;
/*     */         } } );
/*     */     }
/*     */     catch (Exception e) {
/* 249 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.INTERNAL_ERROR.getValue()));
/* 250 */       result.setErrorInfo(EnumTradeOrderResultErrors.INTERNAL_ERROR.getInfo());
/* 251 */       this.log.error("tradeOrderOfflineCheckGoodsNoInvoiceImpl error: " + result.getErrorInfo());
/* 252 */       return result;
/*     */     }
/* 254 */     return result;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.pojo.order.checkgoods.TradeOrderOfflineCheckGoodsNoInvoiceImpl
 * JD-Core Version:    0.6.0
 */