/*     */ package com.hundsun.network.gates.fengshan.biz.service.pojo.order;
/*     */ 
/*     */ import com.hundsun.network.gates.fengshan.biz.dao.order.TradeOrderCcDAO;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.order.TradeOrder;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.order.TradeOrderCc;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectListing;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.query.TradeOrderCcQuery;
/*     */ import com.hundsun.network.gates.fengshan.biz.service.BaseService;
/*     */ import com.hundsun.network.gates.fengshan.biz.service.order.TradeOrderCcService;
/*     */ import com.hundsun.network.gates.fengshan.biz.service.order.TradeOrderService;
/*     */ import com.hundsun.network.gates.fengshan.biz.service.project.ProjectListingService;
/*     */ import com.hundsun.network.gates.fengshan.web.util.ConvertUtils;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeOrderCcStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeOrderCcType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeOrderStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeUserType;
/*     */ import com.hundsun.network.gates.luosi.common.utils.DateUtil;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumTradeOrderResultErrors;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.TradeOrderCcRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.TradeOrderCcServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteTradeOrderCcService;
/*     */ import java.util.Date;
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
/*     */   private TradeOrderService tradeOrderService;
/*     */ 
/*     */   @Autowired
/*     */   private ProjectListingService projectListingService;
/*     */ 
/*     */   public TradeOrderCcServiceResult addTradeOrderCc(TradeOrderCc tradeOrderCc)
/*     */   {
/*  39 */     TradeOrderCcServiceResult result = new TradeOrderCcServiceResult();
/*  40 */     if (null == tradeOrderCc) {
/*  41 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.PARAMETER_ERROR.getValue()));
/*  42 */       result.setErrorInfo(EnumTradeOrderResultErrors.PARAMETER_ERROR.getInfo());
/*  43 */       return result;
/*     */     }
/*     */     try {
/*  46 */       tradeOrderCc.setStatus(EnumTradeOrderCcStatus.SUBMIT.getValue());
/*  47 */       TradeOrderCcRequest request = ConvertUtils.convert(tradeOrderCc);
/*  48 */       result = this.remoteTradeOrderCcService.addTradeOrderCc(request);
/*     */     } catch (Exception e) {
/*  50 */       if (this.log.isErrorEnabled()) {
/*  51 */         this.log.error("", e);
/*     */       }
/*  53 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.SERVER_ERROR.getValue()));
/*  54 */       result.setErrorInfo(EnumTradeOrderResultErrors.SERVER_ERROR.getInfo());
/*  55 */       return result;
/*     */     }
/*  57 */     return result;
/*     */   }
/*     */ 
/*     */   public void getTradeOrderCcByQuery(TradeOrderCcQuery query)
/*     */   {
/*  62 */     if (null != query.getOrderCcNum()) {
/*  63 */       query.setOrderCcNum(query.getOrderCcNum().trim());
/*     */     }
/*  65 */     if (null != query.getOrderNo()) {
/*  66 */       query.setOrderNo(query.getOrderNo().trim());
/*     */     }
/*  68 */     this.tradeOrderCcDAO.selectedByQuery(query);
/*     */   }
/*     */ 
/*     */   public TradeOrderCc getTradeOrderCcByNum(String num)
/*     */   {
/*  73 */     return this.tradeOrderCcDAO.selectedByNum(num);
/*     */   }
/*     */ 
/*     */   public TradeOrderCcServiceResult updateByOrderCcNum(TradeOrderCc tradeOrderCc, String userAccount)
/*     */   {
/*  78 */     TradeOrderCcServiceResult result = new TradeOrderCcServiceResult();
/*  79 */     if (null == tradeOrderCc) {
/*  80 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.PARAMETER_ERROR.getValue()));
/*  81 */       result.setErrorInfo(EnumTradeOrderResultErrors.PARAMETER_ERROR.getInfo());
/*  82 */       return result;
/*     */     }
/*  84 */     String messagePrefix = getReplayPrefix(tradeOrderCc.getOrderCcNum(), userAccount);
/*  85 */     tradeOrderCc.setMessage(messagePrefix + tradeOrderCc.getMessage() + "\n");
/*     */     try {
/*  87 */       TradeOrderCcRequest request = ConvertUtils.convert(tradeOrderCc);
/*  88 */       result = this.remoteTradeOrderCcService.updateTradeOrderCc(request);
/*     */     } catch (Exception e) {
/*  90 */       if (this.log.isErrorEnabled()) {
/*  91 */         this.log.error("", e);
/*     */       }
/*  93 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.SERVER_ERROR.getValue()));
/*  94 */       result.setErrorInfo(EnumTradeOrderResultErrors.SERVER_ERROR.getInfo());
/*  95 */       return result;
/*     */     }
/*  97 */     return result;
/*     */   }
/*     */ 
/*     */   public EnumTradeOrderCcType[] getAvailableCcTypes(String orderNo, String userAccount, String userType)
/*     */   {
/* 103 */     TradeOrder order = this.tradeOrderService.selectByOrderNo(orderNo);
/*     */ 
/* 105 */     if ((order.getStatus().equals(EnumTradeOrderStatus.FINISHED.getValue())) || (order.getStatus().equals(EnumTradeOrderStatus.COLSE.getValue())) || (order.getStatus().equals(EnumTradeOrderStatus.CANCEL.getValue())))
/*     */     {
/* 108 */       return null;
/*     */     }
/*     */ 
/* 111 */     if (!complainAble(order))
/*     */     {
/* 113 */       EnumTradeOrderCcType[] availableCcTypes = { EnumTradeOrderCcType.indexByValue(EnumTradeOrderCcType.GENERAL.getValue()) };
/*     */ 
/* 115 */       return availableCcTypes;
/*     */     }
/* 117 */     if (userType.equals(EnumTradeUserType.BUYER.getValue()))
/*     */     {
/* 119 */       if (order.getStatus().equals(EnumTradeOrderStatus.WAIT_PAYCONFIRM.getValue()))
/*     */       {
/* 121 */         if (userAccount.equals(order.getCreator()))
/*     */         {
/* 123 */           if ((order.getHasBuyerConfirm().equals("Y")) && (order.getHasSellerConfirm().equals("N"))) {
/* 124 */             EnumTradeOrderCcType[] availableCcTypes = { EnumTradeOrderCcType.indexByValue(EnumTradeOrderCcType.DEFAULT_LIST_UNCHECK.getValue()), EnumTradeOrderCcType.indexByValue(EnumTradeOrderCcType.GENERAL.getValue()) };
/*     */ 
/* 130 */             return availableCcTypes;
/*     */           }
/*     */ 
/*     */         }
/* 134 */         else if (userAccount.equals(this.projectListingService.getProjectListingByCode(order.getProjectCode()).getUserAccount()))
/*     */         {
/* 137 */           if ((order.getHasBuyerConfirm().equals("Y")) && (order.getHasSellerConfirm().equals("N"))) {
/* 138 */             EnumTradeOrderCcType[] availableCcTypes = { EnumTradeOrderCcType.indexByValue(EnumTradeOrderCcType.DEFAULT_PLACE_UNCHECK.getValue()), EnumTradeOrderCcType.indexByValue(EnumTradeOrderCcType.GENERAL.getValue()) };
/*     */ 
/* 144 */             return availableCcTypes;
/*     */           }
/*     */         }
/*     */       }
/*     */ 
/* 149 */       if (order.getStatus().equals(EnumTradeOrderStatus.WAIT_SENDGOODS.getValue())) {
/* 150 */         EnumTradeOrderCcType[] availableCcTypes = { EnumTradeOrderCcType.indexByValue(EnumTradeOrderCcType.DEFAULT_SELLER_UNDELIVER.getValue()), EnumTradeOrderCcType.indexByValue(EnumTradeOrderCcType.GENERAL.getValue()) };
/*     */ 
/* 154 */         return availableCcTypes;
/*     */       }
/*     */     }
/* 157 */     else if (userType.equals(EnumTradeUserType.SELLER.getValue())) {
/* 158 */       if (order.getStatus().equals(EnumTradeOrderStatus.WAIT_PAYCONFIRM.getValue()))
/*     */       {
/* 160 */         if (userAccount.equals(order.getCreator()))
/*     */         {
/* 162 */           if ((order.getHasSellerConfirm().equals("Y")) && (order.getHasBuyerConfirm().equals("N"))) {
/* 163 */             EnumTradeOrderCcType[] availableCcTypes = { EnumTradeOrderCcType.indexByValue(EnumTradeOrderCcType.DEFAULT_LIST_UNCHECK.getValue()), EnumTradeOrderCcType.indexByValue(EnumTradeOrderCcType.GENERAL.getValue()) };
/*     */ 
/* 169 */             return availableCcTypes;
/*     */           }
/*     */ 
/*     */         }
/* 173 */         else if (userAccount.equals(this.projectListingService.getProjectListingByCode(order.getProjectCode()).getUserAccount()))
/*     */         {
/* 176 */           if ((order.getHasSellerConfirm().equals("Y")) && (order.getHasBuyerConfirm().equals("N"))) {
/* 177 */             EnumTradeOrderCcType[] availableCcTypes = { EnumTradeOrderCcType.indexByValue(EnumTradeOrderCcType.DEFAULT_PLACE_UNCHECK.getValue()), EnumTradeOrderCcType.indexByValue(EnumTradeOrderCcType.GENERAL.getValue()) };
/*     */ 
/* 183 */             return availableCcTypes;
/*     */           }
/*     */         }
/*     */       } else {
/* 187 */         if (order.getStatus().equals(EnumTradeOrderStatus.WAIT_PAYGOODS.getValue())) {
/* 188 */           EnumTradeOrderCcType[] availableCcTypes = { EnumTradeOrderCcType.indexByValue(EnumTradeOrderCcType.DEFAULT_BUYER_UNPAY.getValue()), EnumTradeOrderCcType.indexByValue(EnumTradeOrderCcType.GENERAL.getValue()) };
/*     */ 
/* 192 */           return availableCcTypes;
/* 193 */         }if (order.getStatus().equals(EnumTradeOrderStatus.WAIT_CHECKGOODS.getValue())) {
/* 194 */           EnumTradeOrderCcType[] availableCcTypes = { EnumTradeOrderCcType.indexByValue(EnumTradeOrderCcType.DEFAULT_BUYER_UNCHECK_GOODS_ARRIVAL.getValue()), EnumTradeOrderCcType.indexByValue(EnumTradeOrderCcType.GENERAL.getValue()) };
/*     */ 
/* 199 */           return availableCcTypes;
/* 200 */         }if (order.getStatus().equals(EnumTradeOrderStatus.WAIT_CHECKTICKET.getValue())) {
/* 201 */           EnumTradeOrderCcType[] availableCcTypes = { EnumTradeOrderCcType.indexByValue(EnumTradeOrderCcType.DEFAULT_BUYER_UNCHECK_RECEIPT_ARRIVAL.getValue()), EnumTradeOrderCcType.indexByValue(EnumTradeOrderCcType.GENERAL.getValue()) };
/*     */ 
/* 206 */           return availableCcTypes;
/*     */         }
/*     */       }
/*     */     }
/* 209 */     EnumTradeOrderCcType[] availableCcTypes = { EnumTradeOrderCcType.indexByValue(EnumTradeOrderCcType.GENERAL.getValue()) };
/* 210 */     return availableCcTypes;
/*     */   }
/*     */ 
/*     */   private String getReplayPrefix(String orderCcNum, String userAccount)
/*     */   {
/* 220 */     String message = "";
/* 221 */     TradeOrderCc tempOrderCc = this.tradeOrderCcDAO.selectedByNum(orderCcNum);
/* 222 */     if (tempOrderCc.getComplainedType().equals(EnumTradeUserType.SELLER.getValue())) {
/* 223 */       if (userAccount.equals(tempOrderCc.getSellerAccount()))
/* 224 */         message = "[被投诉方]";
/* 225 */       else if (userAccount.equals(tempOrderCc.getBuyerAccount()))
/* 226 */         message = "[发起方]";
/*     */     }
/* 228 */     else if (tempOrderCc.getComplainedType().equals(EnumTradeUserType.BUYER.getValue())) {
/* 229 */       if (userAccount.equals(tempOrderCc.getSellerAccount()))
/* 230 */         message = "[发起方]";
/* 231 */       else if (userAccount.equals(tempOrderCc.getBuyerAccount())) {
/* 232 */         message = "[被投诉方]";
/*     */       }
/*     */     }
/* 235 */     return message + userAccount + "(" + DateUtil.getDateFormat(new Date(), null) + ")：";
/*     */   }
/*     */ 
/*     */   private boolean complainAble(TradeOrder order)
/*     */   {
/* 244 */     if (null == order) {
/* 245 */       return false;
/*     */     }
/* 247 */     if (order.getStatus().equals(EnumTradeOrderStatus.WAIT_PAYCONFIRM.getValue())) {
/* 248 */       Date limitDate = order.getEndDateConfirm();
/* 249 */       return dateSequence(limitDate);
/*     */     }
/* 251 */     if (order.getStatus().equals(EnumTradeOrderStatus.WAIT_PAYGOODS.getValue())) {
/* 252 */       Date limitDate = order.getEndDatePay();
/* 253 */       return dateSequence(limitDate);
/*     */     }
/* 255 */     if (order.getStatus().equals(EnumTradeOrderStatus.WAIT_SENDGOODS.getValue())) {
/* 256 */       Date limitDate = order.getEndDateSendGoods();
/* 257 */       return dateSequence(limitDate);
/*     */     }
/*     */ 
/* 260 */     if (order.getStatus().equals(EnumTradeOrderStatus.WAIT_CHECKGOODS.getValue())) {
/* 261 */       Date limitDate = order.getEndDateGoods();
/* 262 */       return dateSequence(limitDate);
/*     */     }
/*     */ 
/* 265 */     if (order.getStatus().equals(EnumTradeOrderStatus.WAIT_CHECKTICKET.getValue())) {
/* 266 */       Date limitDate = order.getEndDateBill();
/* 267 */       return dateSequence(limitDate);
/*     */     }
/*     */ 
/* 270 */     return false;
/*     */   }
/*     */ 
/*     */   private boolean dateSequence(Date date)
/*     */   {
/* 278 */     Date now = new Date();
/*     */ 
/* 280 */     return now.getTime() > date.getTime();
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.service.pojo.order.TradeOrderCcServiceImpl
 * JD-Core Version:    0.6.0
 */