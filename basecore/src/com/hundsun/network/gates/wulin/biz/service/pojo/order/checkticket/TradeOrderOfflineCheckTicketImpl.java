/*     */ package com.hundsun.network.gates.wulin.biz.service.pojo.order.checkticket;
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
/*     */ @Service("tradeOrderOfflineCheckTicketImpl")
/*     */ public class TradeOrderOfflineCheckTicketImpl extends BaseService
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
/*  68 */     TradeOrderGoodAmountServiceResult result = new TradeOrderGoodAmountServiceResult();
/*  69 */     final String operator = request.getOperator();
/*  70 */     final String operatorType = request.getOperatorType();
/*  71 */     final String orderNo = request.getOrderNo();
/*  72 */     String userAccount = request.getUserAccount();
/*  73 */     String payPwd = request.getPayPwd();
/*  74 */     if ((null == request) || (StringUtil.isEmpty(operator)) || (StringUtil.isEmpty(userAccount)) || (StringUtil.isEmpty(orderNo)))
/*     */     {
/*  76 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.PARAMETER_ERROR.getValue()));
/*  77 */       result.setErrorInfo(EnumTradeOrderResultErrors.PARAMETER_ERROR.getInfo());
/*  78 */       this.log.error("tradeOrderOfflineCheckTicketImpl error: " + result.getErrorInfo());
/*  79 */       return result;
/*     */     }
/*     */ 
/*  82 */     if (!EnumTradeOrderStatus.WAIT_CHECKTICKET.getValue().equalsIgnoreCase(tradeOrder.getStatus()))
/*     */     {
/*  84 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.STATUS_ERROR_DATA.getValue()));
/*  85 */       result.setErrorInfo(EnumTradeOrderResultErrors.STATUS_ERROR_DATA.getInfo());
/*  86 */       return result;
/*     */     }
/*     */ 
/*  89 */     if (!tradeOrder.getBuyerAccount().equals(userAccount)) {
/*  90 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.ORDER_NOT_MYSELF_ERROR.getValue()));
/*  91 */       result.setErrorInfo(EnumTradeOrderResultErrors.ORDER_NOT_MYSELF_ERROR.getInfo());
/*  92 */       this.log.error("tradeOrderOfflineCheckTicketImpl error: " + result.getErrorInfo());
/*  93 */       return result;
/*     */     }
/*     */ 
/*  96 */     if ((request.getCheckPayPwd().booleanValue()) && 
/*  97 */       (!this.userService.checkPayPwd(userAccount, payPwd))) {
/*  98 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.INPUT_PAYPWD_ERROR.getValue()));
/*  99 */       result.setErrorInfo(EnumTradeOrderResultErrors.INPUT_PAYPWD_ERROR.getInfo());
/* 100 */       this.log.error("TradeOrderServiceImpl orderGoodsValidate error: " + result.getErrorInfo());
/*     */ 
/* 102 */       return result;
/*     */     }
/*     */ 
/* 106 */     int orderFinishedAddintegral = 0;
/*     */ 
/* 119 */     final int orderFinishedAddintegralInt = orderFinishedAddintegral;
/*     */ 
/* 122 */     final UserAccount buyAcc = this.userAccountDAO.selectByUserAccount(tradeOrder.getBuyerAccount());
/*     */ 
/* 124 */     final UserAccount sellAcc = this.userAccountDAO.selectByUserAccount(tradeOrder.getSellerAccount());
/*     */ 
/* 127 */     final TradeOrderMoney sellMoney = this.tradeOrderMoneyDAO.selectByAccountOrderNo(tradeOrder.getOrderNo(), tradeOrder.getSellerAccount());
/*     */ 
/* 130 */     final TradeOrderMoney buyMoney = this.tradeOrderMoneyDAO.selectByAccountOrderNo(tradeOrder.getOrderNo(), tradeOrder.getBuyerAccount());
/*     */ 
/* 133 */     result = (TradeOrderGoodAmountServiceResult)this.transactionTemplate.execute(new TransactionCallback()
/*     */     {
/*     */       public TradeOrderGoodAmountServiceResult doInTransaction(TransactionStatus status) {
/* 136 */         TradeOrderGoodAmountServiceResult result = new TradeOrderGoodAmountServiceResult();
/*     */         try
/*     */         {
/* 139 */           Map param = new HashMap();
/* 140 */           param.put("status", EnumTradeOrderStatus.FINISHED.getValue());
/* 141 */           param.put("whereStatus", tradeOrder.getStatus());
/* 142 */           param.put("operator", operator);
/*     */ 
/* 145 */           BigDecimal sellDeliveryDeposit = new BigDecimal(sellMoney.getDeliveryDeposit().longValue());
/*     */ 
/* 148 */           BigDecimal buyDeliveryDeposit = new BigDecimal(buyMoney.getDeliveryDeposit().longValue());
/*     */ 
/* 150 */           sellMoney.setDeliveryDeposit(Long.valueOf(0L));
/* 151 */           sellMoney.setOperator(operator);
/* 152 */           buyMoney.setDeliveryDeposit(Long.valueOf(0L));
/* 153 */           buyMoney.setGoodsAmount(Long.valueOf(0L));
/* 154 */           buyMoney.setOperator(operator);
/*     */ 
/* 156 */           if (TradeOrderOfflineCheckTicketImpl.this.tradeOrderMoneyDAO.updateBySelective(sellMoney) <= 0) {
/* 157 */             status.setRollbackOnly();
/* 158 */             result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.CONFIRM_UPDATE_ORDER_MONEY_ERROR.getValue()));
/*     */ 
/* 161 */             result.setErrorInfo(EnumTradeOrderResultErrors.CONFIRM_UPDATE_ORDER_MONEY_ERROR.getInfo());
/*     */ 
/* 164 */             return result;
/*     */           }
/* 166 */           if (TradeOrderOfflineCheckTicketImpl.this.tradeOrderMoneyDAO.updateBySelective(buyMoney) <= 0) {
/* 167 */             status.setRollbackOnly();
/* 168 */             result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.CONFIRM_UPDATE_ORDER_MONEY_ERROR.getValue()));
/*     */ 
/* 171 */             result.setErrorInfo(EnumTradeOrderResultErrors.CONFIRM_UPDATE_ORDER_MONEY_ERROR.getInfo());
/*     */ 
/* 174 */             return result;
/*     */           }
/*     */ 
/* 177 */           if (TradeOrderOfflineCheckTicketImpl.this.tradeOrderDAO.updateParamByOrderNo(param, tradeOrder.getOrderNo()) <= 0) {
/* 178 */             status.setRollbackOnly();
/* 179 */             result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.CONFIRM_UPDATE_ORDER_ERROR.getValue()));
/*     */ 
/* 181 */             result.setErrorInfo(EnumTradeOrderResultErrors.CONFIRM_UPDATE_ORDER_ERROR.getInfo());
/*     */ 
/* 184 */             return result;
/*     */           }
/*     */ 
/* 187 */           String remark = DateUtil.getDateFormat(new Date(), null) + "操作人:" + operator + " 处理订单验票(线下):->交易完成" + " 订单金额：" + CommonUtils.getValuationUnitDesc(Long.valueOf(tradeOrder.getOrderAmount().longValue()), tradeOrder.getValuationUnit()) + " 退还卖家交收保证金:" + CommonUtils.getValuationUnitDesc(Long.valueOf(sellDeliveryDeposit.longValue()), tradeOrder.getValuationUnit()) + " 退还买家交收保证金:" + CommonUtils.getValuationUnitDesc(Long.valueOf(buyDeliveryDeposit.longValue()), tradeOrder.getValuationUnit());
/*     */ 
/* 193 */           TradeOrderOfflineCheckTicketImpl.this.tradeOrderLogService.insert(orderNo, tradeOrder.getStatus(), EnumTradeOrderStatus.FINISHED.getValue(), operator, operatorType, remark);
/*     */ 
/* 198 */           UserLevelRequest rs = new UserLevelRequest();
/* 199 */           rs.setUserAccount(tradeOrder.getBuyerAccount());
/* 200 */           rs.setOrderNo(tradeOrder.getOrderNo());
/* 201 */           rs.setProjectCode(tradeOrder.getProjectCode());
/* 202 */           rs.setIntegral(Integer.valueOf(orderFinishedAddintegralInt));
/* 203 */           rs.setOperator(operator);
/* 204 */           rs.setOperateCode(EnumUserIntegralLogOperateCode.PROJECT_TURNOVER_INTEGRAL.getValue());
/*     */ 
/* 206 */           UserLevelServiceResult result3 = TradeOrderOfflineCheckTicketImpl.this.remoteUserService.updateUserLevel(rs);
/*     */ 
/* 209 */           result.setGoodsAmount(Long.valueOf(0L));
/* 210 */           result.setBuyDeliveryDeposit(Long.valueOf(buyDeliveryDeposit.longValue()));
/* 211 */           result.setSellDeliveryDeposit(Long.valueOf(sellDeliveryDeposit.longValue()));
/*     */ 
/* 213 */           TransRequest request = new TransRequest();
/* 214 */           request.setOrderProperty(tradeOrder.getTradingType());
/* 215 */           request.setGoodsAmount(Long.valueOf(0L));
/* 216 */           request.setBizNo(orderNo);
/* 217 */           request.setOperator(operator);
/* 218 */           request.setMemo(remark);
/* 219 */           request.setGoodsAmountType(EnumGoodsAmountType.CHECK_TICKETS.getValue());
/* 220 */           request.setHasInvoice(tradeOrder.getHasInvoice());
/*     */ 
/* 222 */           request.setSellFundAccount(sellAcc.getFundAccount());
/* 223 */           request.setSellDeliveryAmount(Long.valueOf(sellDeliveryDeposit.longValue()));
/*     */ 
/* 225 */           request.setFundAccount(buyAcc.getFundAccount());
/* 226 */           request.setDeliveryAmount(Long.valueOf(buyDeliveryDeposit.longValue()));
/*     */ 
/* 228 */           FundOperateResult rr = TradeOrderOfflineCheckTicketImpl.this.remoteFundService.payPayment(request);
/* 229 */           if (rr.isError())
/*     */           {
/* 231 */             TradeOrderOfflineCheckTicketImpl.this.log.error("remoteFundService.payPayment error:" + rr.getErrorInfo());
/* 232 */             status.setRollbackOnly();
/* 233 */             result.setErrorNO(Integer.valueOf(EnumUserResultErrors.INTERNAL_ERROR.getValue()));
/* 234 */             result.setErrorInfo(rr.getErrorInfo());
/* 235 */             return result;
/*     */           }
/*     */         }
/*     */         catch (Exception e) {
/* 239 */           TradeOrderOfflineCheckTicketImpl.this.log.error("tradeOrderOfflineCheckTicketImpl error:", e);
/* 240 */           status.setRollbackOnly();
/* 241 */           result.setErrorNO(Integer.valueOf(EnumUserResultErrors.INTERNAL_ERROR.getValue()));
/* 242 */           result.setErrorInfo(EnumUserResultErrors.INTERNAL_ERROR.getInfo());
/* 243 */           return result;
/*     */         }
/* 245 */         return result;
/*     */       }
/*     */     });
/* 248 */     return result;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.pojo.order.checkticket.TradeOrderOfflineCheckTicketImpl
 * JD-Core Version:    0.6.0
 */