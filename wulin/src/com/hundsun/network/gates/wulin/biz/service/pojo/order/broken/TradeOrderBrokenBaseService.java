/*     */ package com.hundsun.network.gates.wulin.biz.service.pojo.order.broken;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.biz.security.ServiceException;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumSystemDictKey;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeOrderStatus;
/*     */ import com.hundsun.network.gates.luosi.common.utils.DateUtil;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.result.FundOperateResult;
/*     */ import com.hundsun.network.gates.luosi.houchao.reomte.service.RemoteFundService;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.SystemDictDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.TradeOrderFinishDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumTradeOrderResultErrors;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.SystemDictRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.TradeOrderBaseRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.SystemDictServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.TradeOrderFinishedServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteSystemBaseService;
/*     */ import com.hundsun.network.gates.wulin.biz.dao.order.TradeOrderDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.dao.order.TradeOrderMoneyDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.order.TradeOrder;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.order.TradeOrderMoney;
/*     */ import com.hundsun.network.gates.wulin.biz.service.BaseService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.order.TradeOrderBrokenService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.order.TradeOrderLogService;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.context.MessageSource;
/*     */ import org.springframework.transaction.TransactionStatus;
/*     */ import org.springframework.transaction.support.TransactionCallback;
/*     */ import org.springframework.transaction.support.TransactionTemplate;
/*     */ 
/*     */ public abstract class TradeOrderBrokenBaseService extends BaseService
/*     */   implements TradeOrderBrokenService
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   protected RemoteSystemBaseService remoteSystemBaseService;
/*     */ 
/*     */   @Autowired
/*     */   protected TradeOrderMoneyDAO tradeOrderMoneyDAO;
/*     */ 
/*     */   @Autowired
/*     */   protected TradeOrderDAO tradeOrderDAO;
/*     */ 
/*     */   @Autowired
/*     */   protected TradeOrderLogService tradeOrderLogService;
/*     */ 
/*     */   @Autowired
/*     */   protected RemoteFundService remoteFundService;
/*     */ 
/*     */   @Autowired
/*     */   private MessageSource messageSource;
/*     */   protected TradeOrderMoney buyerOrderMoney;
/*     */   protected TradeOrderMoney sellerOrderMoney;
/*     */   protected TradeOrder order;
/*     */   protected TradeOrderBaseRequest request;
/*     */ 
/*     */   protected BigDecimal getTradeBrokenRate()
/*     */   {
/*  66 */     SystemDictRequest request = new SystemDictRequest();
/*  67 */     request.setParaCode(EnumSystemDictKey.JY_LIQUIDATED_DAMAGES.getValue());
/*     */     try {
/*  69 */       SystemDictServiceResult result = this.remoteSystemBaseService.selectLiquidatedDamages(request);
/*     */ 
/*  71 */       if (result.correct()) {
/*  72 */         return BigDecimal.valueOf(Long.valueOf(result.getSystemDictDTO().getParaValue()).longValue()).movePointLeft(4);
/*     */       }
/*     */ 
/*  75 */       this.log.error("in getTradeBrokenRate,selectLiquidatedDamages fail:" + result.getErrorInfo());
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  79 */       this.log.error("in getTradeBrokenRate,selectLiquidatedDamages fail: ", e);
/*     */     }
/*  81 */     return null;
/*     */   }
/*     */ 
/*     */   protected BigDecimal getDeliveryBrokenRate()
/*     */   {
/*  89 */     SystemDictRequest request = new SystemDictRequest();
/*  90 */     request.setParaCode(EnumSystemDictKey.JS_LIQUIDATED_DAMAGES.getValue());
/*     */     try {
/*  92 */       SystemDictServiceResult result = this.remoteSystemBaseService.selectLiquidatedDamages(request);
/*     */ 
/*  94 */       if (result.correct()) {
/*  95 */         return BigDecimal.valueOf(Long.valueOf(result.getSystemDictDTO().getParaValue()).longValue()).movePointLeft(4);
/*     */       }
/*     */ 
/*  98 */       this.log.error("in getTradeBrokenRate,selectLiquidatedDamages fail:" + result.getErrorInfo());
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 102 */       this.log.error("in getTradeBrokenRate,selectLiquidatedDamages fail: ", e);
/*     */     }
/* 104 */     return null;
/*     */   }
/*     */ 
/*     */   protected TradeOrderMoney getTradeOrderMoney(String orderNo, String userAccount) {
/* 108 */     return this.tradeOrderMoneyDAO.selectByAccountOrderNo(orderNo, userAccount);
/*     */   }
/*     */ 
/*     */   protected TradeOrderFinishDTO convert(TradeOrderMoney money) {
/* 112 */     if (null == money) {
/* 113 */       return null;
/*     */     }
/* 115 */     TradeOrderFinishDTO dto = new TradeOrderFinishDTO();
/* 116 */     dto.setUserAccount(money.getUserAccount());
/* 117 */     dto.setGoodsAmount(money.getGoodsAmount());
/* 118 */     dto.setPenaltyamount(money.getPenaltyAmount());
/* 119 */     dto.setUnfreezeDeliveryAmount(money.getDeliveryDeposit());
/* 120 */     dto.setUnfreezeDepositAmount(money.getTradeDeposit());
/* 121 */     return dto;
/*     */   }
/*     */ 
/*     */   public TradeOrderFinishedServiceResult dealBroken(final TradeOrderBaseRequest request)
/*     */   {
/* 126 */     this.request = request;
/* 127 */     TradeOrderFinishedServiceResult result = new TradeOrderFinishedServiceResult();
/* 128 */     if ((null == request) || (StringUtil.isEmpty(request.getOrderNo()))) {
/* 129 */       result.setErrorInfo(EnumTradeOrderResultErrors.PARAMETER_ERROR.getInfo());
/* 130 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.PARAMETER_ERROR.getValue()));
/* 131 */       return result;
/*     */     }
/* 133 */     this.order = this.tradeOrderDAO.selectByOrderNo(request.getOrderNo());
/* 134 */     if (null == this.order) {
/* 135 */       result.setErrorInfo(EnumTradeOrderResultErrors.ORDER_NULL_ERROR.getInfo());
/* 136 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.ORDER_NULL_ERROR.getValue()));
/* 137 */       return result;
/*     */     }
/* 139 */     this.buyerOrderMoney = getTradeOrderMoney(this.order.getOrderNo(), this.order.getBuyerAccount());
/* 140 */     this.sellerOrderMoney = getTradeOrderMoney(this.order.getOrderNo(), this.order.getSellerAccount());
/* 141 */     if ((null == this.buyerOrderMoney) || (null == this.sellerOrderMoney)) {
/* 142 */       result.setErrorInfo(EnumTradeOrderResultErrors.QUERY_TRADE_ORDER_MONEY_NULL_ERROR.getInfo());
/*     */ 
/* 144 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.QUERY_TRADE_ORDER_MONEY_NULL_ERROR.getValue()));
/*     */ 
/* 146 */       return result;
/*     */     }
/*     */ 
/* 149 */     final TradeOrder fOrder = this.order;
/* 150 */     result = (TradeOrderFinishedServiceResult)this.transactionTemplate.execute(new TransactionCallback()
/*     */     {
/*     */       public TradeOrderFinishedServiceResult doInTransaction(TransactionStatus status) {
/* 153 */         TradeOrderFinishedServiceResult tradeOrderFinishedServiceResult = new TradeOrderFinishedServiceResult();
/* 154 */         Object savePoint = status.createSavepoint();
/*     */         try {
/* 156 */           TradeOrderFinishDTO buyer = TradeOrderBrokenBaseService.this.convert(TradeOrderBrokenBaseService.this.buyerOrderMoney);
/* 157 */           TradeOrderFinishDTO seller = TradeOrderBrokenBaseService.this.convert(TradeOrderBrokenBaseService.this.sellerOrderMoney);
/* 158 */           TradeOrderBrokenBaseService.this.beforeDealFundBroken();
/* 159 */           TradeOrderBrokenBaseService.this.buyerOrderMoney.setOperator(request.getOperator());
/* 160 */           TradeOrderBrokenBaseService.this.sellerOrderMoney.setOperator(request.getOperator());
/* 161 */           buyer.setPenaltyamount(TradeOrderBrokenBaseService.this.buyerOrderMoney.getPenaltyAmount());
/* 162 */           seller.setPenaltyamount(TradeOrderBrokenBaseService.this.sellerOrderMoney.getPenaltyAmount());
/* 163 */           if (TradeOrderBrokenBaseService.this.tradeOrderMoneyDAO.updateBySelective(TradeOrderBrokenBaseService.this.buyerOrderMoney) <= 0) {
/* 164 */             throw new ServiceException(EnumTradeOrderResultErrors.CONFIRM_UPDATE_ORDER_MONEY_ERROR.getInfo(), Integer.valueOf(EnumTradeOrderResultErrors.CONFIRM_UPDATE_ORDER_MONEY_ERROR.getValue()));
/*     */           }
/*     */ 
/* 170 */           if (TradeOrderBrokenBaseService.this.tradeOrderMoneyDAO.updateBySelective(TradeOrderBrokenBaseService.this.sellerOrderMoney) <= 0) {
/* 171 */             throw new ServiceException(EnumTradeOrderResultErrors.CONFIRM_UPDATE_ORDER_MONEY_ERROR.getInfo(), Integer.valueOf(EnumTradeOrderResultErrors.CONFIRM_UPDATE_ORDER_MONEY_ERROR.getValue()));
/*     */           }
/*     */ 
/* 178 */           Map paramMap = new HashMap();
/* 179 */           paramMap.put("status", EnumTradeOrderStatus.COLSE.getValue());
/* 180 */           paramMap.put("whereStatus", fOrder.getStatus());
/* 181 */           if (TradeOrderBrokenBaseService.this.tradeOrderDAO.updateParamByOrderNo(paramMap, fOrder.getOrderNo()) <= 0) {
/* 182 */             throw new ServiceException(EnumTradeOrderResultErrors.CONFIRM_UPDATE_ORDER_ERROR.getInfo(), Integer.valueOf(EnumTradeOrderResultErrors.CONFIRM_UPDATE_ORDER_ERROR.getValue()));
/*     */           }
/*     */ 
/* 187 */           String remark = DateUtil.getDateFormat(new Date(), null) + "操作人:" + request.getOperator() + " 处理:订单关闭";
/*     */ 
/* 189 */           TradeOrderBrokenBaseService.this.tradeOrderLogService.insert(request.getOrderNo(), TradeOrderBrokenBaseService.this.order.getStatus(), paramMap.get("status").toString(), request.getOperator(), request.getOperatorType(), remark);
/*     */ 
/* 193 */           FundOperateResult fundOperateResult = TradeOrderBrokenBaseService.this.dealFundBroken();
/* 194 */           if (fundOperateResult.isError()) {
/* 195 */             TradeOrderBrokenBaseService.this.log.error("remoteFundService tradeBroken fail,errorNo:" + fundOperateResult.getErrorNO() + ",errorInfo:" + fundOperateResult.getErrorInfo());
/*     */ 
/* 198 */             throw new ServiceException(fundOperateResult.getErrorInfo());
/*     */           }
/*     */ 
/* 201 */           tradeOrderFinishedServiceResult.setBuyer(buyer);
/* 202 */           tradeOrderFinishedServiceResult.setSeller(seller);
/*     */         } catch (ServiceException e) {
/* 204 */           status.rollbackToSavepoint(savePoint);
/* 205 */           TradeOrderBrokenBaseService.this.log.error("TradeOrderServiceImpl orderConfirm fail", e);
/* 206 */           tradeOrderFinishedServiceResult.setErrorNO(e.getErrorNO());
/* 207 */           tradeOrderFinishedServiceResult.setErrorInfo(e.getErrorInfo());
/*     */         } catch (Exception e) {
/* 209 */           status.rollbackToSavepoint(savePoint);
/* 210 */           TradeOrderBrokenBaseService.this.log.error("TradeOrderServiceImpl orderConfirm error", e);
/* 211 */           tradeOrderFinishedServiceResult.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.INTERNAL_ERROR.getValue()));
/*     */ 
/* 213 */           tradeOrderFinishedServiceResult.setErrorInfo(EnumTradeOrderResultErrors.INTERNAL_ERROR.getInfo());
/*     */         }
/*     */ 
/* 216 */         return tradeOrderFinishedServiceResult;
/*     */       }
/*     */     });
/* 219 */     return result;
/*     */   }
/*     */ 
/*     */   protected String getMessage(String code, String[] args) {
/* 223 */     return this.messageSource.getMessage(code, args, Locale.CHINA);
/*     */   }
/*     */ 
/*     */   protected abstract void beforeDealFundBroken()
/*     */     throws ServiceException;
/*     */ 
/*     */   protected abstract FundOperateResult dealFundBroken()
/*     */     throws ServiceException;
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.pojo.order.broken.TradeOrderBrokenBaseService
 * JD-Core Version:    0.6.0
 */