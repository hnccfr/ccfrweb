/*     */ package com.hundsun.network.gates.genshan.biz.service.pojo.order;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.dao.order.TradeOrderCcDAO;
/*     */ import com.hundsun.network.gates.genshan.biz.dao.order.TradeOrderDAO;
/*     */ import com.hundsun.network.gates.genshan.biz.dao.order.TradeOrderMoneyDAO;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.order.TradeOrder;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.order.TradeOrderCc;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.order.TradeOrderMoney;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.query.TradeOrderCcQuery;
/*     */ import com.hundsun.network.gates.genshan.biz.service.BaseService;
/*     */ import com.hundsun.network.gates.genshan.biz.service.order.TradeOrderCcService;
/*     */ import com.hundsun.network.gates.genshan.web.util.ConvertUtils;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumInvoice;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumPaymentType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumSystemDictKey;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeOrderCcDealType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeOrderCcType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeOrderStatus;
/*     */ import com.hundsun.network.gates.luosi.common.utils.BigDecimalUtil;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.SystemDictDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumTradeOrderCcResultErrors;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.SystemDictRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.TradeOrderCcRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.SystemDictServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.TradeOrderCcServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteSystemBaseService;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteTradeOrderCcService;
/*     */ import java.math.BigDecimal;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ @Service("tradeOrderCcService")
/*     */ public class TradeOrderCcServiceImpl extends BaseService
/*     */   implements TradeOrderCcService
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private RemoteTradeOrderCcService remoteTradeOrderCcService;
/*     */ 
/*     */   @Autowired
/*     */   private TradeOrderCcDAO tradeOrderCcDAO;
/*     */ 
/*     */   @Autowired
/*     */   private TradeOrderDAO tradeOrderDAO;
/*     */ 
/*     */   @Autowired
/*     */   private TradeOrderMoneyDAO tradeOrderMoneyDAO;
/*     */ 
/*     */   @Autowired
/*     */   private RemoteSystemBaseService remoteSystemBaseService;
/*     */ 
/*     */   public void getTradeOrderCcByQuery(TradeOrderCcQuery query)
/*     */   {
/*  52 */     if (null != query.getOrderCcNum()) {
/*  53 */       query.setOrderCcNum(query.getOrderCcNum().trim());
/*     */     }
/*  55 */     if (null != query.getOrderNo()) {
/*  56 */       query.setOrderNo(query.getOrderNo().trim());
/*     */     }
/*  58 */     this.tradeOrderCcDAO.selectedByQuery(query);
/*     */   }
/*     */ 
/*     */   public TradeOrderCc getTradeOrderCcByNum(String num)
/*     */   {
/*  63 */     return this.tradeOrderCcDAO.selectedByNum(num);
/*     */   }
/*     */ 
/*     */   public TradeOrderCcServiceResult updateByOrderCcNum(TradeOrderCc tradeOrderCc)
/*     */   {
/*  68 */     TradeOrderCcServiceResult result = new TradeOrderCcServiceResult();
/*  69 */     if (null == tradeOrderCc) {
/*  70 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderCcResultErrors.PARAMETER_ERROR.getValue()));
/*  71 */       result.setErrorInfo(EnumTradeOrderCcResultErrors.PARAMETER_ERROR.getInfo());
/*  72 */       return result;
/*     */     }
/*  74 */     if ((null != tradeOrderCc.getDealType()) && (!tradeOrderCc.getDealType().equals("")) && 
/*  75 */       (!EnumTradeOrderCcDealType.GENERAL.getValue().equals(tradeOrderCc.getDealType())))
/*     */     {
/*  77 */       if (checkDealOverdue(tradeOrderCc.getOrderCcNum()))
/*     */       {
/*  79 */         result.setErrorNO(Integer.valueOf(EnumTradeOrderCcResultErrors.DEAL_DISABLE_ERROR.getValue()));
/*  80 */         result.setErrorInfo(EnumTradeOrderCcResultErrors.DEAL_DISABLE_ERROR.getInfo());
/*  81 */         return result;
/*     */       }
/*     */     }
/*     */     try
/*     */     {
/*  86 */       TradeOrderCcRequest request = ConvertUtils.convert(tradeOrderCc);
/*  87 */       result = this.remoteTradeOrderCcService.updateTradeOrderCc(request);
/*     */     } catch (Exception e) {
/*  89 */       if (this.log.isErrorEnabled()) {
/*  90 */         this.log.error("", e);
/*     */       }
/*  92 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderCcResultErrors.SERVER_ERROR.getValue()));
/*  93 */       result.setErrorInfo(EnumTradeOrderCcResultErrors.SERVER_ERROR.getInfo());
/*  94 */       return result;
/*     */     }
/*  96 */     return result;
/*     */   }
/*     */ 
/*     */   public EnumTradeOrderCcDealType[] getAvailableDealTypes(String orderCcNum)
/*     */   {
/* 102 */     TradeOrderCc orderCc = this.tradeOrderCcDAO.selectedByNum(orderCcNum);
/* 103 */     TradeOrder order = this.tradeOrderDAO.selectByOrderNo(orderCc.getOrderNo());
/* 104 */     if (EnumTradeOrderCcType.GENERAL.getValue().equals(orderCc.getCcType())) {
/* 105 */       EnumTradeOrderCcDealType[] dealTypes = { EnumTradeOrderCcDealType.indexByValue(EnumTradeOrderCcDealType.GENERAL.getValue()) };
/*     */ 
/* 107 */       return dealTypes;
/*     */     }
/*     */ 
/* 110 */     if (!checkDealOverdue(orderCcNum))
/*     */     {
/* 113 */       if (EnumTradeOrderCcType.DEFAULT_BUYER_UNCHECK_GOODS_ARRIVAL.getValue().equals(orderCc.getCcType())) {
/* 114 */         if (EnumPaymentType.OffLine.getValue().equals(order.getPaymentType())) {
/* 115 */           EnumTradeOrderCcDealType[] dealTypes = { EnumTradeOrderCcDealType.indexByValue(EnumTradeOrderCcDealType.DEFAULT_SELLER_GOODS_DELAY_CHECK.getValue()), EnumTradeOrderCcDealType.indexByValue(EnumTradeOrderCcDealType.GENERAL.getValue()), EnumTradeOrderCcDealType.indexByValue(EnumTradeOrderCcDealType.DEFAULT_BUYER_UNCHECK_GOODS_ARRIVAL.getValue()), EnumTradeOrderCcDealType.indexByValue(EnumTradeOrderCcDealType.DEFAULT_SELLER_GOODS_REFUND.getValue()), EnumTradeOrderCcDealType.indexByValue(EnumTradeOrderCcDealType.DEFAULT_SELLER_GOODS_REFUND_PENALTY.getValue()) };
/*     */ 
/* 122 */           return dealTypes;
/*     */         }
/* 124 */         EnumTradeOrderCcDealType[] dealTypes = { EnumTradeOrderCcDealType.indexByValue(EnumTradeOrderCcDealType.DEFAULT_SELLER_GOODS_DELAY_CHECK.getValue()), EnumTradeOrderCcDealType.indexByValue(EnumTradeOrderCcDealType.GENERAL.getValue()), EnumTradeOrderCcDealType.indexByValue(EnumTradeOrderCcDealType.DEFAULT_BUYER_UNCHECK_GOODS_ARRIVAL.getValue()), EnumTradeOrderCcDealType.indexByValue(EnumTradeOrderCcDealType.DEFAULT_SELLER_GOODS_REFUND.getValue()), EnumTradeOrderCcDealType.indexByValue(EnumTradeOrderCcDealType.DEFAULT_SELLER_GOODS_REFUND_PENALTY.getValue()), EnumTradeOrderCcDealType.indexByValue(EnumTradeOrderCcDealType.DEFAULT_SELLER_DOODS_ARIVAL_AMOUNT.getValue()) };
/*     */ 
/* 132 */         return dealTypes;
/*     */       }
/*     */ 
/* 136 */       if (EnumTradeOrderCcType.DEFAULT_BUYER_UNCHECK_RECEIPT_ARRIVAL.getValue().equals(orderCc.getCcType())) {
/* 137 */         if (EnumPaymentType.OffLine.getValue().equals(order.getPaymentType())) {
/* 138 */           EnumTradeOrderCcDealType[] dealTypes = { EnumTradeOrderCcDealType.indexByValue(EnumTradeOrderCcDealType.GENERAL.getValue()), EnumTradeOrderCcDealType.indexByValue(EnumTradeOrderCcDealType.DEFAULT_BUYER_UNCHECK_RECEIPT_ARRIVAL.getValue()) };
/*     */ 
/* 142 */           return dealTypes;
/*     */         }
/* 144 */         EnumTradeOrderCcDealType[] dealTypes = { EnumTradeOrderCcDealType.indexByValue(EnumTradeOrderCcDealType.GENERAL.getValue()), EnumTradeOrderCcDealType.indexByValue(EnumTradeOrderCcDealType.DEFAULT_BUYER_UNCHECK_RECEIPT_ARRIVAL.getValue()), EnumTradeOrderCcDealType.indexByValue(EnumTradeOrderCcDealType.DEFAULT_SELLER_UNBILLING.getValue()), EnumTradeOrderCcDealType.indexByValue(EnumTradeOrderCcDealType.DEFAULT_SELLER_UNBILLING_PENALTY.getValue()) };
/*     */ 
/* 150 */         return dealTypes;
/*     */       }
/*     */ 
/* 154 */       EnumTradeOrderCcDealType[] dealTypes = { EnumTradeOrderCcDealType.indexByValue(EnumTradeOrderCcDealType.GENERAL.getValue()), EnumTradeOrderCcDealType.indexByValue(orderCc.getCcType()) };
/*     */ 
/* 158 */       return dealTypes;
/*     */     }
/*     */ 
/* 162 */     EnumTradeOrderCcDealType[] dealTypes = { EnumTradeOrderCcDealType.indexByValue(EnumTradeOrderCcDealType.GENERAL.getValue()) };
/*     */ 
/* 164 */     return dealTypes;
/*     */   }
/*     */ 
/*     */   private boolean checkDealOverdue(String orderCcNum)
/*     */   {
/* 178 */     TradeOrderCc orderCc = this.tradeOrderCcDAO.selectedByNum(orderCcNum);
/* 179 */     if (null != orderCc) {
/* 180 */       TradeOrder order = this.tradeOrderDAO.selectByOrderNo(orderCc.getOrderNo());
/*     */ 
/* 182 */       if ((EnumTradeOrderCcType.DEFAULT_PLACE_UNCHECK.getValue().equals(orderCc.getCcType())) || (EnumTradeOrderCcType.DEFAULT_LIST_UNCHECK.getValue().equals(orderCc.getCcType())))
/*     */       {
/* 185 */         if (EnumTradeOrderStatus.WAIT_PAYCONFIRM.getValue().equals(order.getStatus()))
/* 186 */           return false;
/*     */       }
/* 188 */       else if (orderCc.getCcType().equals(EnumTradeOrderCcType.DEFAULT_BUYER_UNPAY.getValue())) {
/* 189 */         if (EnumTradeOrderStatus.WAIT_PAYGOODS.getValue().equals(order.getStatus()))
/* 190 */           return false;
/*     */       }
/* 192 */       else if (EnumTradeOrderCcType.DEFAULT_SELLER_UNDELIVER.getValue().equals(orderCc.getCcType())) {
/* 193 */         if (EnumTradeOrderStatus.WAIT_SENDGOODS.getValue().equals(order.getStatus()))
/* 194 */           return false;
/*     */       }
/* 196 */       else if (EnumTradeOrderCcType.DEFAULT_BUYER_UNCHECK_GOODS_ARRIVAL.getValue().equals(orderCc.getCcType())) {
/* 197 */         if (EnumTradeOrderStatus.WAIT_CHECKGOODS.getValue().equals(order.getStatus()))
/* 198 */           return false;
/*     */       }
/* 200 */       else if ((EnumTradeOrderCcType.DEFAULT_BUYER_UNCHECK_RECEIPT_ARRIVAL.getValue().equals(orderCc.getCcType())) && 
/* 201 */         (EnumTradeOrderStatus.WAIT_CHECKTICKET.getValue().equals(order.getStatus()))) {
/* 202 */         return false;
/*     */       }
/*     */     }
/*     */ 
/* 206 */     return true;
/*     */   }
/*     */ 
/*     */   private Long getOrderHoldGoodsAmount(String orderNo, String userAccount) {
/* 210 */     Long holdAmount = Long.valueOf(0L);
/* 211 */     TradeOrder order = this.tradeOrderDAO.selectByOrderNo(orderNo);
/* 212 */     if (EnumTradeOrderStatus.WAIT_CHECKTICKET.getValue().equals(order.getStatus())) {
/* 213 */       TradeOrderMoney money = this.tradeOrderMoneyDAO.selectByAccountOrderNo(orderNo, userAccount);
/* 214 */       holdAmount = money.getGoodsAmount();
/*     */     }
/* 216 */     return holdAmount;
/*     */   }
/*     */ 
/*     */   private Long getOrderSendGoodsAmount(String orderNo, String userAccount)
/*     */   {
/* 221 */     Long sendAmount = Long.valueOf(0L);
/* 222 */     TradeOrder order = this.tradeOrderDAO.selectByOrderNo(orderNo);
/* 223 */     if (EnumTradeOrderStatus.WAIT_CHECKGOODS.getValue().equals(order.getStatus())) {
/* 224 */       TradeOrderMoney money = this.tradeOrderMoneyDAO.selectByAccountOrderNo(orderNo, userAccount);
/* 225 */       Long amount = money.getGoodsAmount();
/*     */ 
/* 228 */       if (EnumInvoice.Y.getValue().equals(order.getHasInvoice())) {
/* 229 */         SystemDictRequest request = new SystemDictRequest();
/* 230 */         request.setParaCode(EnumSystemDictKey.GOODS_PAY_PROPORTION.getValue());
/*     */         try
/*     */         {
/* 233 */           SystemDictServiceResult result = this.remoteSystemBaseService.selectSingleByKey(request);
/* 234 */           if (result.correct()) {
/* 235 */             SystemDictDTO dto = result.getSystemDictDTO();
/* 236 */             BigDecimal paygodPro = new BigDecimal(dto.getParaValue()).movePointLeft(4);
/* 237 */             BigDecimalUtil util = new BigDecimalUtil();
/* 238 */             BigDecimal goodsAmountSend = BigDecimalUtil.mul(new BigDecimal(amount.longValue()), paygodPro).setScale(0, 3);
/*     */ 
/* 240 */             sendAmount = Long.valueOf(goodsAmountSend.longValue());
/*     */           }
/*     */         } catch (Exception e) {
/* 243 */           if (this.log.isErrorEnabled())
/* 244 */             this.log.error("", e);
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 249 */         sendAmount = amount;
/*     */       }
/*     */     }
/*     */ 
/* 253 */     return sendAmount;
/*     */   }
/*     */ 
/*     */   public Long getOrderAmount(String orderCcNum)
/*     */   {
/* 258 */     TradeOrderCc tradeOrderCc = this.tradeOrderCcDAO.selectedByNum(orderCcNum);
/* 259 */     TradeOrder order = this.tradeOrderDAO.selectByOrderNo(tradeOrderCc.getOrderNo());
/* 260 */     Long balance = Long.valueOf(0L);
/* 261 */     if (EnumTradeOrderCcType.DEFAULT_BUYER_UNCHECK_RECEIPT_ARRIVAL.getValue().equals(tradeOrderCc.getCcType()))
/*     */     {
/* 263 */       if (EnumTradeOrderStatus.WAIT_CHECKTICKET.getValue().equals(order.getStatus()))
/* 264 */         balance = getOrderHoldGoodsAmount(order.getOrderNo(), order.getBuyerAccount());
/*     */     }
/* 266 */     else if (EnumTradeOrderCcType.DEFAULT_BUYER_UNCHECK_GOODS_ARRIVAL.getValue().equals(tradeOrderCc.getCcType()))
/*     */     {
/* 268 */       if (EnumTradeOrderStatus.WAIT_CHECKGOODS.getValue().equals(order.getStatus())) {
/* 269 */         balance = getOrderSendGoodsAmount(order.getOrderNo(), order.getBuyerAccount());
/*     */       }
/*     */     }
/* 272 */     return balance;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.service.pojo.order.TradeOrderCcServiceImpl
 * JD-Core Version:    0.6.0
 */