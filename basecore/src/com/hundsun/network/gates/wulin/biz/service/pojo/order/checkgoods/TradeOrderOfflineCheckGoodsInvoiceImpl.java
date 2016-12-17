/*     */ package com.hundsun.network.gates.wulin.biz.service.pojo.order.checkgoods;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeOrderStatus;
/*     */ import com.hundsun.network.gates.luosi.common.utils.CommonUtils;
/*     */ import com.hundsun.network.gates.luosi.common.utils.DateUtil;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumTradeOrderResultErrors;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumUserResultErrors;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.TradeOrderBaseRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.TradeOrderGoodAmountServiceResult;
/*     */ import com.hundsun.network.gates.wulin.biz.dao.order.TradeOrderDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.order.TradeOrder;
/*     */ import com.hundsun.network.gates.wulin.biz.service.BaseService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.order.TradeOrderLogService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.user.UserService;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;

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
/*     */ @Service("tradeOrderOfflineCheckGoodsInvoiceImpl")
/*     */ public class TradeOrderOfflineCheckGoodsInvoiceImpl extends BaseService
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private UserService userService;
/*     */ 
/*     */   @Autowired
/*     */   private TradeOrderDAO tradeOrderDAO;
/*     */ 
/*     */   @Autowired
/*     */   private TradeOrderLogService tradeOrderLogService;
/*     */ 
/*     */   public TradeOrderGoodAmountServiceResult process(TradeOrderBaseRequest request, final TradeOrder tradeOrder)
/*     */   {
/*  45 */     TradeOrderGoodAmountServiceResult result = new TradeOrderGoodAmountServiceResult();
/*  46 */     final String operator = request.getOperator();
/*  47 */     final String operatorType = request.getOperatorType();
/*  48 */     String orderNo = request.getOrderNo();
/*  49 */     String userAccount = request.getUserAccount();
/*  50 */     String payPwd = request.getPayPwd();
/*  51 */     if ((request == null) || (StringUtil.isEmpty(operator)) || (StringUtil.isEmpty(userAccount)) || 
/*  52 */       (StringUtil.isEmpty(orderNo))) {
/*  53 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.PARAMETER_ERROR.getValue()));
/*  54 */       result.setErrorInfo(EnumTradeOrderResultErrors.PARAMETER_ERROR.getInfo());
/*  55 */       this.log.error("tradeOrderOfflineCheckGoodsInvoiceImpl error: " + result.getErrorInfo());
/*  56 */       return result;
/*     */     }
/*  58 */     if (!EnumTradeOrderStatus.WAIT_CHECKGOODS.getValue().equalsIgnoreCase(
/*  59 */       tradeOrder.getStatus()))
/*     */     {
/*  61 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.STATUS_ERROR_DATA.getValue()));
/*  62 */       result.setErrorInfo(EnumTradeOrderResultErrors.STATUS_ERROR_DATA.getInfo());
/*  63 */       return result;
/*     */     }
/*     */ 
/*  66 */     if (!tradeOrder.getBuyerAccount().equals(userAccount)) {
/*  67 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.ORDER_NOT_MYSELF_ERROR.getValue()));
/*  68 */       result.setErrorInfo(EnumTradeOrderResultErrors.ORDER_NOT_MYSELF_ERROR.getInfo());
/*  69 */       this.log.error("tradeOrderOfflineCheckGoodsInvoiceImpl error: " + result.getErrorInfo());
/*  70 */       return result;
/*     */     }
/*     */ 
/*  73 */     if ((request.getCheckPayPwd().booleanValue()) && 
/*  74 */       (!this.userService.checkPayPwd(userAccount, payPwd))) {
/*  75 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.INPUT_PAYPWD_ERROR.getValue()));
/*  76 */       result.setErrorInfo(EnumTradeOrderResultErrors.INPUT_PAYPWD_ERROR.getInfo());
/*  77 */       this.log.error("tradeOrderOfflineCheckGoodsInvoiceImpl error: " + result.getErrorInfo());
/*  78 */       return result;
/*     */     }
/*     */ 
/*     */     try
/*     */     {
/*  83 */       result = 
/*  84 */         (TradeOrderGoodAmountServiceResult)this.transactionTemplate
/*  84 */         .execute(new TransactionCallback()
/*     */       {
private String val$orderNo;

/*     */         public TradeOrderGoodAmountServiceResult doInTransaction(TransactionStatus status) {
/*  87 */           TradeOrderGoodAmountServiceResult result = new TradeOrderGoodAmountServiceResult();
/*     */           try
/*     */           {
/*  90 */             result.setGoodsAmount(Long.valueOf(0L));
/*  91 */             Map param = new HashMap();
/*  92 */             param.put("status", EnumTradeOrderStatus.WAIT_CHECKTICKET.getValue());
/*  93 */             param.put("whereStatus",tradeOrder.getStatus());
/*  94 */             param.put("operator",operator);
/*     */ 
/*  96 */             TradeOrderOfflineCheckGoodsInvoiceImpl.this.tradeOrderDAO.updateParamByOrderNo(param,tradeOrder.getOrderNo());
/*     */ 
/*  98 */             String remark = DateUtil.getDateFormat(new Date(), null) + "操作人:" + 
/*  99 */              operator + " 处理确认交割分支②(线下交易或货到付款，需要发票):->订单交易完成 " + 
/* 100 */               " 订单金额:" + CommonUtils.getValuationUnitDesc(tradeOrder.getOrderAmount(),tradeOrder.getValuationUnit());
/* 101 */             TradeOrderOfflineCheckGoodsInvoiceImpl.this.tradeOrderLogService.insert(this.val$orderNo,tradeOrder.getStatus(), 
/* 102 */               EnumTradeOrderStatus.WAIT_CHECKTICKET.getValue(),operator, 
/* 103 */              operatorType, remark);
/*     */           }
/*     */           catch (Exception e) {
/* 106 */             TradeOrderOfflineCheckGoodsInvoiceImpl.this.log.error("tradeOrderOfflineCheckGoodsInvoiceImpl error:", e);
/* 107 */             status.setRollbackOnly();
/* 108 */             result.setErrorNO(Integer.valueOf(EnumUserResultErrors.INTERNAL_ERROR.getValue()));
/* 109 */             result.setErrorInfo(EnumUserResultErrors.INTERNAL_ERROR.getInfo());
/* 110 */             return result;
/*     */           }
/* 112 */           return result;
/*     */         } } );
/*     */     }
/*     */     catch (Exception e) {
/* 117 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.INTERNAL_ERROR.getValue()));
/* 118 */       result.setErrorInfo(EnumTradeOrderResultErrors.INTERNAL_ERROR.getInfo());
/* 119 */       this.log.error("tradeOrderOfflineCheckGoodsInvoiceImpl error: " + result.getErrorInfo());
/* 120 */       return result;
/*     */     }
/* 122 */     return result;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.pojo.order.checkgoods.TradeOrderOfflineCheckGoodsInvoiceImpl
 * JD-Core Version:    0.6.0
 */