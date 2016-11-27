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
/*     */ @Service("tradeOrderOnlineCheckTicketImpl")
/*     */ public class TradeOrderOnlineCheckTicketImpl extends BaseService
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
/*  69 */     TradeOrderGoodAmountServiceResult result = new TradeOrderGoodAmountServiceResult();
/*  70 */     final String operator = request.getOperator();
/*  71 */     final String operatorType = request.getOperatorType();
/*  72 */     final String orderNo = request.getOrderNo();
/*  73 */     String userAccount = request.getUserAccount();
/*  74 */     String payPwd = request.getPayPwd();
/*  75 */     if ((null == request) || (StringUtil.isEmpty(operator)) || (StringUtil.isEmpty(userAccount)) || (StringUtil.isEmpty(orderNo)))
/*     */     {
/*  77 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.PARAMETER_ERROR.getValue()));
/*  78 */       result.setErrorInfo(EnumTradeOrderResultErrors.PARAMETER_ERROR.getInfo());
/*  79 */       this.log.error("tradeOrderOnlineCheckTicketImpl error: " + result.getErrorInfo());
/*  80 */       return result;
/*     */     }
/*     */ 
/*  83 */     if (!EnumTradeOrderStatus.WAIT_CHECKTICKET.getValue().equalsIgnoreCase(tradeOrder.getStatus()))
/*     */     {
/*  85 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.STATUS_ERROR_DATA.getValue()));
/*  86 */       result.setErrorInfo(EnumTradeOrderResultErrors.STATUS_ERROR_DATA.getInfo());
/*  87 */       return result;
/*     */     }
/*     */ 
/*  90 */     if (!tradeOrder.getBuyerAccount().equals(userAccount)) {
/*  91 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.ORDER_NOT_MYSELF_ERROR.getValue()));
/*  92 */       result.setErrorInfo(EnumTradeOrderResultErrors.ORDER_NOT_MYSELF_ERROR.getInfo());
/*  93 */       this.log.error("tradeOrderOnlineCheckTicketImpl error: " + result.getErrorInfo());
/*  94 */       return result;
/*     */     }
/*     */ 
/*  97 */     if ((request.getCheckPayPwd().booleanValue()) && 
/*  98 */       (!this.userService.checkPayPwd(userAccount, payPwd))) {
/*  99 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.INPUT_PAYPWD_ERROR.getValue()));
/* 100 */       result.setErrorInfo(EnumTradeOrderResultErrors.INPUT_PAYPWD_ERROR.getInfo());
/* 101 */       this.log.error("TradeOrderServiceImpl orderGoodsValidate error: " + result.getErrorInfo());
/*     */ 
/* 103 */       return result;
/*     */     }
/*     */ 
/* 107 */     int orderFinishedAddintegral = 0;
/*     */ 
/* 120 */     final int orderFinishedAddintegralInt = orderFinishedAddintegral;
/*     */ 
/* 123 */     final UserAccount buyAcc = this.userAccountDAO.selectByUserAccount(tradeOrder.getBuyerAccount());
/*     */ 
/* 125 */     final UserAccount sellAcc = this.userAccountDAO.selectByUserAccount(tradeOrder.getSellerAccount());
/*     */ 
/* 128 */     final TradeOrderMoney sellMoney = this.tradeOrderMoneyDAO.selectByAccountOrderNo(tradeOrder.getOrderNo(), tradeOrder.getSellerAccount());
/*     */ 
/* 131 */     final TradeOrderMoney buyMoney = this.tradeOrderMoneyDAO.selectByAccountOrderNo(tradeOrder.getOrderNo(), tradeOrder.getBuyerAccount());
/*     */ 
/* 134 */     result = (TradeOrderGoodAmountServiceResult)this.transactionTemplate.execute(new TransactionCallback()
/*     */     {
/*     */       public TradeOrderGoodAmountServiceResult doInTransaction(TransactionStatus status) {
/* 137 */         TradeOrderGoodAmountServiceResult result = new TradeOrderGoodAmountServiceResult();
/*     */         try
/*     */         {
/* 140 */           Map param = new HashMap();
/* 141 */           param.put("status", EnumTradeOrderStatus.FINISHED.getValue());
/* 142 */           param.put("whereStatus", tradeOrder.getStatus());
/* 143 */           param.put("operator", operator);
/*     */ 
/* 146 */           BigDecimal sellDeliveryDeposit = new BigDecimal(sellMoney.getDeliveryDeposit().longValue());
/*     */ 
/* 149 */           BigDecimal buyDeliveryDeposit = new BigDecimal(buyMoney.getDeliveryDeposit().longValue());
/*     */ 
/* 152 */           BigDecimal goodsAmount = new BigDecimal(buyMoney.getGoodsAmount() == null ? 0L : buyMoney.getGoodsAmount().longValue());
/* 153 */           sellMoney.setGoodsAmount(Long.valueOf(sellMoney.getGoodsAmount() == null ? 0L : sellMoney.getGoodsAmount().longValue() + goodsAmount.longValue()));
/* 154 */           sellMoney.setDeliveryDeposit(Long.valueOf(0L));
/* 155 */           sellMoney.setOperator(operator);
/* 156 */           buyMoney.setDeliveryDeposit(Long.valueOf(0L));
/* 157 */           buyMoney.setGoodsAmount(Long.valueOf(0L));
/* 158 */           buyMoney.setOperator(operator);
/*     */ 
/* 160 */           if (TradeOrderOnlineCheckTicketImpl.this.tradeOrderMoneyDAO.updateBySelective(sellMoney) <= 0) {
/* 161 */             status.setRollbackOnly();
/* 162 */             result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.CONFIRM_UPDATE_ORDER_MONEY_ERROR.getValue()));
/*     */ 
/* 165 */             result.setErrorInfo(EnumTradeOrderResultErrors.CONFIRM_UPDATE_ORDER_MONEY_ERROR.getInfo());
/*     */ 
/* 168 */             return result;
/*     */           }
/* 170 */           if (TradeOrderOnlineCheckTicketImpl.this.tradeOrderMoneyDAO.updateBySelective(buyMoney) <= 0) {
/* 171 */             status.setRollbackOnly();
/* 172 */             result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.CONFIRM_UPDATE_ORDER_MONEY_ERROR.getValue()));
/*     */ 
/* 175 */             result.setErrorInfo(EnumTradeOrderResultErrors.CONFIRM_UPDATE_ORDER_MONEY_ERROR.getInfo());
/*     */ 
/* 178 */             return result;
/*     */           }
/*     */ 
/* 181 */           if (TradeOrderOnlineCheckTicketImpl.this.tradeOrderDAO.updateParamByOrderNo(param, tradeOrder.getOrderNo()) <= 0) {
/* 182 */             status.setRollbackOnly();
/* 183 */             result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.CONFIRM_UPDATE_ORDER_ERROR.getValue()));
/*     */ 
/* 185 */             result.setErrorInfo(EnumTradeOrderResultErrors.CONFIRM_UPDATE_ORDER_ERROR.getInfo());
/*     */ 
/* 188 */             return result;
/*     */           }
/*     */ 
/* 191 */           String remark = DateUtil.getDateFormat(new Date(), null) + "操作人:" + operator + " 处理订单验票(线上):->交易完成" + " 订单金额：" + CommonUtils.getValuationUnitDesc(Long.valueOf(tradeOrder.getOrderAmount().longValue()), tradeOrder.getValuationUnit()) + " 订单剩余金额：" + CommonUtils.getValuationUnitDesc(Long.valueOf(goodsAmount.longValue()), tradeOrder.getValuationUnit()) + " 退还卖家交收保证金:" + CommonUtils.getValuationUnitDesc(Long.valueOf(sellDeliveryDeposit.longValue()), tradeOrder.getValuationUnit()) + " 退还买家交收保证金:" + CommonUtils.getValuationUnitDesc(Long.valueOf(buyDeliveryDeposit.longValue()), tradeOrder.getValuationUnit());
/*     */ 
/* 198 */           TradeOrderOnlineCheckTicketImpl.this.tradeOrderLogService.insert(orderNo, tradeOrder.getStatus(), EnumTradeOrderStatus.FINISHED.getValue(), operator, operatorType, remark);
/*     */ 
/* 203 */           UserLevelRequest rs = new UserLevelRequest();
/* 204 */           rs.setUserAccount(tradeOrder.getBuyerAccount());
/* 205 */           rs.setOrderNo(tradeOrder.getOrderNo());
/* 206 */           rs.setProjectCode(tradeOrder.getProjectCode());
/* 207 */           rs.setIntegral(Integer.valueOf(orderFinishedAddintegralInt));
/* 208 */           rs.setOperator(operator);
/* 209 */           rs.setOperateCode(EnumUserIntegralLogOperateCode.PROJECT_TURNOVER_INTEGRAL.getValue());
/*     */ 
/* 211 */           UserLevelServiceResult result3 = TradeOrderOnlineCheckTicketImpl.this.remoteUserService.updateUserLevel(rs);
/*     */ 
/* 214 */           TransRequest request = new TransRequest();
/* 215 */           request.setOrderProperty(tradeOrder.getTradingType());
/* 216 */           request.setGoodsAmount(Long.valueOf(goodsAmount.longValue()));
/* 217 */           request.setBizNo(orderNo);
/* 218 */           request.setOperator(operator);
/* 219 */           request.setMemo(remark);
/* 220 */           request.setGoodsAmountType(EnumGoodsAmountType.CHECK_TICKETS.getValue());
/* 221 */           request.setHasInvoice(tradeOrder.getHasInvoice());
/*     */ 
/* 223 */           request.setSellFundAccount(sellAcc.getFundAccount());
/* 224 */           request.setSellDeliveryAmount(Long.valueOf(sellDeliveryDeposit.longValue()));
/*     */ 
/* 226 */           request.setFundAccount(buyAcc.getFundAccount());
/* 227 */           request.setDeliveryAmount(Long.valueOf(buyDeliveryDeposit.longValue()));
/*     */ 
/* 229 */           result.setGoodsAmount(Long.valueOf(goodsAmount.longValue()));
/* 230 */           result.setBuyDeliveryDeposit(Long.valueOf(buyDeliveryDeposit.longValue()));
/* 231 */           result.setSellDeliveryDeposit(Long.valueOf(sellDeliveryDeposit.longValue()));
/*     */ 
/* 233 */           FundOperateResult rr = TradeOrderOnlineCheckTicketImpl.this.remoteFundService.payPayment(request);
/* 234 */           if (rr.isError())
/*     */           {
/* 236 */             TradeOrderOnlineCheckTicketImpl.this.log.error("remoteFundService.payPayment error:" + rr.getErrorInfo());
/* 237 */             status.setRollbackOnly();
/* 238 */             result.setErrorNO(Integer.valueOf(EnumUserResultErrors.INTERNAL_ERROR.getValue()));
/* 239 */             result.setErrorInfo(rr.getErrorInfo());
/* 240 */             return result;
/*     */           }
/*     */         }
/*     */         catch (Exception e) {
/* 244 */           TradeOrderOnlineCheckTicketImpl.this.log.error("tradeOrderOnlineCheckTicketImpl error:", e);
/* 245 */           status.setRollbackOnly();
/* 246 */           result.setErrorNO(Integer.valueOf(EnumUserResultErrors.INTERNAL_ERROR.getValue()));
/* 247 */           result.setErrorInfo(EnumUserResultErrors.INTERNAL_ERROR.getInfo());
/* 248 */           return result;
/*     */         }
/* 250 */         return result;
/*     */       }
/*     */     });
/* 253 */     return result;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.pojo.order.checkticket.TradeOrderOnlineCheckTicketImpl
 * JD-Core Version:    0.6.0
 */