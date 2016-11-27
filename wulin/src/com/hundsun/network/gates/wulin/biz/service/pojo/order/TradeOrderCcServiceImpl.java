/*     */ package com.hundsun.network.gates.wulin.biz.service.pojo.order;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumComplainStarterType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumOperatorType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumSystemDictKey;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeOrderCcDealType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeOrderCcType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeUserType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumValuationUnit;
/*     */ import com.hundsun.network.gates.luosi.common.enums.UserCreditType;
/*     */ import com.hundsun.network.gates.luosi.common.utils.CommonUtils;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.TradeOrderCcDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.TradeOrderFinishDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumTradeOrderCcResultErrors;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.TradeOrderBaseRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.TradeOrderCcRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.TradeOrderCcServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.TradeOrderFinishedServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.TradeOrderGoodAmountServiceResult;
/*     */ import com.hundsun.network.gates.wulin.biz.dao.order.TradeOrderCcDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.dao.order.TradeOrderDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.baseset.SystemDict;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.order.TradeOrder;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.order.TradeOrderCc;
/*     */ import com.hundsun.network.gates.wulin.biz.service.BaseService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.baseset.SystemDictService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.baseset.UserCreditService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.baseset.UserLevelService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.order.TradeOrderCcService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.order.TradeOrderService;
/*     */ import com.hundsun.network.gates.wulin.common.utils.ConvertUtils;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.List;
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
/*     */   private TradeOrderCcDAO tradeOrderCcDAO;
/*     */ 
/*     */   @Autowired
/*     */   private TradeOrderDAO tradeOrderDAO;
/*     */ 
/*     */   @Autowired
/*     */   private TradeOrderService tradeOrderService;
/*     */ 
/*     */   @Autowired
/*     */   private UserCreditService userCreditService;
/*     */ 
/*     */   @Autowired
/*     */   private UserLevelService userLevelService;
/*     */ 
/*     */   @Autowired
/*     */   private SystemDictService systemDictService;
/*     */ 
/*     */   public TradeOrderCcServiceResult addTradeOrderCc(TradeOrderCcRequest request)
/*     */   {
/*  56 */     TradeOrderCcServiceResult result = new TradeOrderCcServiceResult();
/*  57 */     if ((null == request) || (null == request.getTradeOrderCcDTO())) {
/*  58 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderCcResultErrors.PARAMETER_ERROR.getValue()));
/*  59 */       result.setErrorInfo(EnumTradeOrderCcResultErrors.PARAMETER_ERROR.getInfo());
/*  60 */       return result;
/*     */     }
/*  62 */     TradeOrderCc tradeOrderCc = ConvertUtils.convert(request);
/*  63 */     TradeOrderCc queryOrderCc = new TradeOrderCc();
/*     */ 
/*  66 */     queryOrderCc.setOrderNo(tradeOrderCc.getOrderNo());
/*  67 */     queryOrderCc.setCcType(tradeOrderCc.getCcType());
/*  68 */     queryOrderCc.setStatus(tradeOrderCc.getStatus());
/*     */ 
/*  70 */     if (tradeOrderCc.getCcType().equals(EnumTradeOrderCcType.GENERAL.getValue())) {
/*  71 */       queryOrderCc.setCreator(tradeOrderCc.getCreator());
/*     */     }
/*  73 */     List list = this.tradeOrderCcDAO.selectByOrderCc(queryOrderCc);
/*     */ 
/*  76 */     if (list.size() > 0) {
/*  77 */       TradeOrderCc temp = (TradeOrderCc)list.get(0);
/*  78 */       if (temp.getCcStartor().equals(EnumComplainStarterType.SYSTEM.getValue())) {
/*  79 */         result.setErrorNO(Integer.valueOf(EnumTradeOrderCcResultErrors.DUPLICATION_SYSTEM_ERROR.getValue()));
/*  80 */         result.setErrorInfo(EnumTradeOrderCcResultErrors.DUPLICATION_SYSTEM_ERROR.getInfo());
/*     */       } else {
/*  82 */         result.setErrorNO(Integer.valueOf(EnumTradeOrderCcResultErrors.DUPLICATION_MANUAL_ERROR.getValue()));
/*  83 */         result.setErrorInfo(EnumTradeOrderCcResultErrors.DUPLICATION_MANUAL_ERROR.getInfo());
/*     */       }
/*  85 */       TradeOrderCcDTO dto = new TradeOrderCcDTO();
/*  86 */       dto.setOrderCcNum(temp.getOrderCcNum());
/*  87 */       result.setTradeOrderCcDTO(dto);
/*  88 */       return result;
/*     */     }
/*     */ 
/*  91 */     TradeOrder order = this.tradeOrderDAO.selectByOrderNo(tradeOrderCc.getOrderNo());
/*  92 */     tradeOrderCc.setSellerAccount(order.getSellerAccount());
/*  93 */     tradeOrderCc.setBuyerAccount(order.getBuyerAccount());
/*  94 */     tradeOrderCc.setOperator(tradeOrderCc.getCreator());
/*     */     try
/*     */     {
/*  97 */       tradeOrderCc.setOrderCcNum(this.tradeOrderCcDAO.generalOrderCcNum());
/*  98 */       Long tradeOrderCcId = this.tradeOrderCcDAO.insert(tradeOrderCc);
/*  99 */       TradeOrderCcDTO tradeOrderCcDTO = new TradeOrderCcDTO();
/* 100 */       tradeOrderCcDTO.setId(tradeOrderCcId);
/* 101 */       result.setTradeOrderCcDTO(tradeOrderCcDTO);
/*     */     } catch (Exception e) {
/* 103 */       if (this.log.isErrorEnabled()) {
/* 104 */         this.log.error("", e);
/*     */       }
/* 106 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderCcResultErrors.INTERNAL_ERROR.getValue()));
/* 107 */       result.setErrorInfo(EnumTradeOrderCcResultErrors.INTERNAL_ERROR.getInfo());
/* 108 */       return result;
/*     */     }
/* 110 */     return result;
/*     */   }
/*     */ 
/*     */   public TradeOrderCcServiceResult updateTradeOrderCc(TradeOrderCcRequest request)
/*     */   {
/* 115 */     TradeOrderCcServiceResult result = new TradeOrderCcServiceResult();
/* 116 */     if (null == request) {
/* 117 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderCcResultErrors.PARAMETER_ERROR.getValue()));
/* 118 */       result.setErrorInfo(EnumTradeOrderCcResultErrors.PARAMETER_ERROR.getInfo());
/* 119 */       return result;
/*     */     }
/* 121 */     TradeOrderCc tradeOrderCc = ConvertUtils.convert(request);
/*     */ 
/* 123 */     if (null != tradeOrderCc.getDealType())
/*     */     {
/* 125 */       TradeOrderCc detailTradeOrderCc = this.tradeOrderCcDAO.selectByOrderCcNum(tradeOrderCc.getOrderCcNum());
/* 126 */       TradeOrder tradeOrder = this.tradeOrderService.selectByOrderNo(detailTradeOrderCc.getOrderNo());
/*     */ 
/* 129 */       if (!checkDealType(tradeOrderCc, detailTradeOrderCc)) {
/* 130 */         result.setErrorNO(Integer.valueOf(EnumTradeOrderCcResultErrors.DEAL_METHOD_ERROR.getValue()));
/* 131 */         result.setErrorInfo(EnumTradeOrderCcResultErrors.DEAL_METHOD_ERROR.getInfo());
/* 132 */         return result;
/*     */       }
/*     */ 
/* 136 */       if (tradeOrderCc.getDealType().equals(EnumTradeOrderCcDealType.GENERAL.getValue())) {
/*     */         try {
/* 138 */           tradeOrderCc.setReason("[客服备注]" + tradeOrderCc.getReason() + "<br />[系统备注]实际处理方式是普通投诉处理方式！");
/* 139 */           this.tradeOrderCcDAO.updateByOrderCcNum(tradeOrderCc);
/*     */         } catch (Exception e) {
/* 141 */           if (this.log.isErrorEnabled()) {
/* 142 */             this.log.error("", e);
/*     */           }
/* 144 */           result.setErrorNO(Integer.valueOf(EnumTradeOrderCcResultErrors.INTERNAL_ERROR.getValue()));
/* 145 */           result.setErrorInfo(EnumTradeOrderCcResultErrors.INTERNAL_ERROR.getInfo());
/* 146 */           return result;
/*     */         }
/*     */ 
/*     */       }
/* 150 */       else if ((tradeOrderCc.getDealType().equals(EnumTradeOrderCcDealType.DEFAULT_PLACE_UNCHECK.getValue())) || (tradeOrderCc.getDealType().equals(EnumTradeOrderCcDealType.DEFAULT_LIST_UNCHECK.getValue())) || (tradeOrderCc.getDealType().equals(EnumTradeOrderCcDealType.DEFAULT_BUYER_UNPAY.getValue())) || (tradeOrderCc.getDealType().equals(EnumTradeOrderCcDealType.DEFAULT_SELLER_UNDELIVER.getValue())))
/*     */       {
/* 156 */         String orderDealResult = "";
/* 157 */         TradeOrderFinishedServiceResult orderCloseResult = orderDeal(tradeOrderCc, detailTradeOrderCc);
/* 158 */         if (!orderCloseResult.correct()) {
/* 159 */           result.setErrorNO(orderCloseResult.getErrorNO());
/* 160 */           result.setErrorInfo(orderCloseResult.getErrorInfo());
/* 161 */           return result;
/*     */         }
/* 163 */         orderDealResult = orderDealInfo(orderCloseResult);
/*     */ 
/* 166 */         String userCreditDealResult = "";
/*     */         try {
/* 168 */           if (EnumTradeUserType.SELLER.getValue().equals(detailTradeOrderCc.getComplainedType())) {
/* 169 */             userCreditDealResult = userCreditDeal(tradeOrderCc, detailTradeOrderCc, tradeOrder, detailTradeOrderCc.getSellerAccount());
/*     */           }
/* 171 */           else if (EnumTradeUserType.BUYER.getValue().equals(detailTradeOrderCc.getComplainedType()))
/* 172 */             userCreditDealResult = userCreditDeal(tradeOrderCc, detailTradeOrderCc, tradeOrder, detailTradeOrderCc.getBuyerAccount());
/*     */         }
/*     */         catch (Exception e) {
/* 175 */           if (this.log.isErrorEnabled()) {
/* 176 */             this.log.error("", e);
/*     */           }
/* 178 */           result.setErrorNO(Integer.valueOf(EnumTradeOrderCcResultErrors.DEAL_CREDIT_ERROR.getValue()));
/* 179 */           result.setErrorInfo(EnumTradeOrderCcResultErrors.DEAL_CREDIT_ERROR.getInfo());
/* 180 */           return result;
/*     */         }
/*     */ 
/* 184 */         String userLevelDealResult = "";
/*     */         try {
/* 186 */           if (EnumTradeUserType.SELLER.getValue().equals(detailTradeOrderCc.getComplainedType())) {
/* 187 */             userLevelDealResult = userLevelDeal(tradeOrderCc, detailTradeOrderCc, tradeOrder, detailTradeOrderCc.getSellerAccount());
/*     */           }
/* 189 */           else if (EnumTradeUserType.BUYER.getValue().equals(detailTradeOrderCc.getComplainedType()))
/* 190 */             userLevelDealResult = userLevelDeal(tradeOrderCc, detailTradeOrderCc, tradeOrder, detailTradeOrderCc.getBuyerAccount());
/*     */         }
/*     */         catch (Exception e) {
/* 193 */           if (this.log.isErrorEnabled()) {
/* 194 */             this.log.error("", e);
/*     */           }
/* 196 */           result.setErrorNO(Integer.valueOf(EnumTradeOrderCcResultErrors.DEAL_LEVEL_ERROR.getValue()));
/* 197 */           result.setErrorInfo(EnumTradeOrderCcResultErrors.DEAL_LEVEL_ERROR.getInfo());
/* 198 */           return result;
/*     */         }
/*     */         try
/*     */         {
/* 202 */           String dealResult = orderDealResult + "<br />" + userCreditDealResult + "<br />" + userLevelDealResult;
/*     */ 
/* 204 */           tradeOrderCcDeal(tradeOrderCc, dealResult);
/*     */         } catch (Exception e) {
/* 206 */           if (this.log.isErrorEnabled()) {
/* 207 */             this.log.error("", e);
/*     */           }
/* 209 */           result.setErrorNO(Integer.valueOf(EnumTradeOrderCcResultErrors.DEAL_ORDERCC_ERROR.getValue()));
/* 210 */           result.setErrorInfo(EnumTradeOrderCcResultErrors.DEAL_ORDERCC_ERROR.getInfo());
/* 211 */           return result;
/*     */         }
/*     */ 
/*     */       }
/* 216 */       else if ((tradeOrderCc.getDealType().equals(EnumTradeOrderCcDealType.DEFAULT_BUYER_UNCHECK_GOODS_ARRIVAL.getValue())) || (tradeOrderCc.getDealType().equals(EnumTradeOrderCcDealType.DEFAULT_SELLER_GOODS_REFUND.getValue())) || (tradeOrderCc.getDealType().equals(EnumTradeOrderCcDealType.DEFAULT_SELLER_GOODS_REFUND_PENALTY.getValue())) || (tradeOrderCc.getDealType().equals(EnumTradeOrderCcDealType.DEFAULT_SELLER_DOODS_ARIVAL_AMOUNT.getValue())))
/*     */       {
/* 220 */         String goodsDealResult = "";
/* 221 */         TradeOrderGoodAmountServiceResult goodsResult = goodsDeal(tradeOrderCc, tradeOrder);
/* 222 */         if (!goodsResult.correct()) {
/* 223 */           result.setErrorNO(goodsResult.getErrorNO());
/* 224 */           result.setErrorInfo(goodsResult.getErrorInfo());
/* 225 */           return result;
/*     */         }
/* 227 */         goodsDealResult = goodsDealInfo(goodsResult, tradeOrderCc);
/*     */ 
/* 229 */         String userCreditDealResult = "";
/* 230 */         String userLevelDealResult = "";
/* 231 */         String dealResult = goodsDealResult;
/* 232 */         if (EnumTradeOrderCcDealType.DEFAULT_SELLER_GOODS_REFUND_PENALTY.getValue().equals(tradeOrderCc.getDealType()))
/*     */         {
/*     */           try {
/* 235 */             userCreditDealResult = userCreditDeal(tradeOrderCc, detailTradeOrderCc, tradeOrder, detailTradeOrderCc.getSellerAccount());
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/* 239 */             if (this.log.isErrorEnabled()) {
/* 240 */               this.log.error("", e);
/*     */             }
/* 242 */             result.setErrorNO(Integer.valueOf(EnumTradeOrderCcResultErrors.DEAL_CREDIT_ERROR.getValue()));
/* 243 */             result.setErrorInfo(EnumTradeOrderCcResultErrors.DEAL_CREDIT_ERROR.getInfo());
/* 244 */             return result;
/*     */           }
/*     */           try
/*     */           {
/* 248 */             userLevelDealResult = userLevelDeal(tradeOrderCc, detailTradeOrderCc, tradeOrder, detailTradeOrderCc.getSellerAccount());
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/* 252 */             if (this.log.isErrorEnabled()) {
/* 253 */               this.log.error("", e);
/*     */             }
/* 255 */             result.setErrorNO(Integer.valueOf(EnumTradeOrderCcResultErrors.DEAL_LEVEL_ERROR.getValue()));
/* 256 */             result.setErrorInfo(EnumTradeOrderCcResultErrors.DEAL_LEVEL_ERROR.getInfo());
/* 257 */             return result;
/*     */           }
/* 259 */           dealResult = dealResult + "<br />" + userCreditDealResult + "<br />" + userLevelDealResult;
/*     */         }
/*     */ 
/*     */         try
/*     */         {
/* 264 */           tradeOrderCcDeal(tradeOrderCc, dealResult);
/*     */         } catch (Exception e) {
/* 266 */           if (this.log.isErrorEnabled()) {
/* 267 */             this.log.error("", e);
/*     */           }
/* 269 */           e.printStackTrace();
/* 270 */           result.setErrorNO(Integer.valueOf(EnumTradeOrderCcResultErrors.DEAL_ORDERCC_ERROR.getValue()));
/* 271 */           result.setErrorInfo(EnumTradeOrderCcResultErrors.DEAL_ORDERCC_ERROR.getInfo());
/* 272 */           return result;
/*     */         }
/*     */ 
/*     */       }
/* 277 */       else if ((tradeOrderCc.getDealType().equals(EnumTradeOrderCcDealType.DEFAULT_BUYER_UNCHECK_RECEIPT_ARRIVAL.getValue())) || (tradeOrderCc.getDealType().equals(EnumTradeOrderCcDealType.DEFAULT_SELLER_UNBILLING.getValue())) || (tradeOrderCc.getDealType().equals(EnumTradeOrderCcDealType.DEFAULT_SELLER_UNBILLING_PENALTY.getValue())))
/*     */       {
/* 281 */         String invoiceDealResult = "";
/* 282 */         TradeOrderGoodAmountServiceResult invoiceResult = invoiceDeal(tradeOrderCc, tradeOrder);
/* 283 */         if (!invoiceResult.correct()) {
/* 284 */           result.setErrorNO(invoiceResult.getErrorNO());
/* 285 */           result.setErrorInfo(invoiceResult.getErrorInfo());
/* 286 */           return result;
/*     */         }
/* 288 */         invoiceDealResult = invoiceDealInfo(invoiceResult, tradeOrderCc);
/*     */ 
/* 292 */         String userCreditDealResult = "";
/* 293 */         String userLevelDealResult = "";
/* 294 */         String dealResult = invoiceDealResult;
/* 295 */         if (EnumTradeOrderCcDealType.DEFAULT_SELLER_UNBILLING_PENALTY.getValue().equals(tradeOrderCc.getDealType()))
/*     */         {
/*     */           try {
/* 298 */             userCreditDealResult = userCreditDeal(tradeOrderCc, detailTradeOrderCc, tradeOrder, detailTradeOrderCc.getSellerAccount());
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/* 302 */             if (this.log.isErrorEnabled()) {
/* 303 */               this.log.error("", e);
/*     */             }
/* 305 */             result.setErrorNO(Integer.valueOf(EnumTradeOrderCcResultErrors.DEAL_CREDIT_ERROR.getValue()));
/* 306 */             result.setErrorInfo(EnumTradeOrderCcResultErrors.DEAL_CREDIT_ERROR.getInfo());
/* 307 */             return result;
/*     */           }
/*     */           try
/*     */           {
/* 311 */             userLevelDealResult = userLevelDeal(tradeOrderCc, detailTradeOrderCc, tradeOrder, detailTradeOrderCc.getSellerAccount());
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/* 315 */             if (this.log.isErrorEnabled()) {
/* 316 */               this.log.error("", e);
/*     */             }
/* 318 */             result.setErrorNO(Integer.valueOf(EnumTradeOrderCcResultErrors.DEAL_LEVEL_ERROR.getValue()));
/* 319 */             result.setErrorInfo(EnumTradeOrderCcResultErrors.DEAL_LEVEL_ERROR.getInfo());
/* 320 */             return result;
/*     */           }
/* 322 */           dealResult = dealResult + "<br />" + userCreditDealResult + "<br />" + userLevelDealResult;
/*     */         }
/*     */         try
/*     */         {
/* 326 */           tradeOrderCcDeal(tradeOrderCc, dealResult);
/*     */         } catch (Exception e) {
/* 328 */           if (this.log.isErrorEnabled()) {
/* 329 */             this.log.error("", e);
/*     */           }
/* 331 */           e.printStackTrace();
/* 332 */           result.setErrorNO(Integer.valueOf(EnumTradeOrderCcResultErrors.DEAL_ORDERCC_ERROR.getValue()));
/* 333 */           result.setErrorInfo(EnumTradeOrderCcResultErrors.DEAL_ORDERCC_ERROR.getInfo());
/* 334 */           return result;
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*     */     }
/* 340 */     else if (null == request.getTradeOrderCcDTO().getDealType()) {
/* 341 */       return orderCcReplay(tradeOrderCc);
/*     */     }
/* 343 */     return result;
/*     */   }
/*     */ 
/*     */   private TradeOrderCcServiceResult orderCcReplay(TradeOrderCc orderCc)
/*     */   {
/* 352 */     TradeOrderCcServiceResult result = new TradeOrderCcServiceResult();
/*     */     try {
/* 354 */       this.tradeOrderCcDAO.updateByOrderCcNum(orderCc);
/*     */     } catch (Exception e) {
/* 356 */       if (this.log.isErrorEnabled()) {
/* 357 */         this.log.error("", e);
/*     */       }
/* 359 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderCcResultErrors.INTERNAL_ERROR.getValue()));
/* 360 */       result.setErrorInfo(EnumTradeOrderCcResultErrors.INTERNAL_ERROR.getInfo());
/* 361 */       return result;
/*     */     }
/* 363 */     return result;
/*     */   }
/*     */ 
/*     */   private TradeOrderFinishedServiceResult orderDeal(TradeOrderCc tradeOrderCc, TradeOrderCc detailTradeOrderCc)
/*     */   {
/* 373 */     TradeOrderBaseRequest orderBaseRequest = new TradeOrderBaseRequest();
/* 374 */     orderBaseRequest.setOrderNo(detailTradeOrderCc.getOrderNo());
/* 375 */     orderBaseRequest.setOperator(tradeOrderCc.getAuditor());
/* 376 */     orderBaseRequest.setOperatorType(EnumOperatorType.SYSTEM.getValue());
/* 377 */     TradeOrderFinishedServiceResult orderCloseResult = this.tradeOrderService.orderClose(orderBaseRequest);
/* 378 */     return orderCloseResult;
/*     */   }
/*     */ 
/*     */   private String orderDealInfo(TradeOrderFinishedServiceResult orderCloseResult)
/*     */   {
/* 386 */     if (orderCloseResult.correct()) {
/* 387 */       String orderDeal = "";
/* 388 */       String sResult = "";
/* 389 */       String bResult = "";
/* 390 */       TradeOrderFinishDTO seller = orderCloseResult.getSeller();
/* 391 */       sResult = sResult + "[卖家]返还货款:" + CommonUtils.getMoneyDesc(seller.getGoodsAmount()) + "元；" + "违约金:" + getTransferDirect(seller.getPenaltyamount()) + "解冻全部交易保证金:" + CommonUtils.getMoneyDesc(seller.getUnfreezeDepositAmount()) + "元；" + "解冻全部交收保证金：" + CommonUtils.getMoneyDesc(seller.getUnfreezeDeliveryAmount()) + "元。";
/*     */ 
/* 395 */       TradeOrderFinishDTO buyer = orderCloseResult.getBuyer();
/* 396 */       bResult = bResult + "[买家]收到货款:" + CommonUtils.getMoneyDesc(buyer.getGoodsAmount()) + "元；" + "违约金:" + getTransferDirect(buyer.getPenaltyamount()) + "解冻全部交易保证金:" + CommonUtils.getMoneyDesc(buyer.getUnfreezeDepositAmount()) + "元；" + "解冻全部交收保证金：" + CommonUtils.getMoneyDesc(buyer.getUnfreezeDeliveryAmount()) + "元。";
/*     */ 
/* 400 */       orderDeal = sResult + "<br />" + bResult;
/* 401 */       return orderDeal;
/*     */     }
/* 403 */     return orderCloseResult.getErrorInfo();
/*     */   }
/*     */ 
/*     */   private String userCreditDeal(TradeOrderCc tradeOrderCc, TradeOrderCc detailTradeOrderCc, TradeOrder order, String userAccount)
/*     */   {
/* 414 */     String complainedUserType = "";
/* 415 */     SystemDict sysDict = null;
/* 416 */     String dealResult = "";
/*     */ 
/* 418 */     if (userAccount.equals(detailTradeOrderCc.getSellerAccount())) {
/* 419 */       complainedUserType = UserCreditType.SET_SELLER_CREDIT.getValue();
/* 420 */       dealResult = dealResult + "[卖家]信用:";
/*     */     }
/* 422 */     else if (userAccount.equals(detailTradeOrderCc.getBuyerAccount())) {
/* 423 */       complainedUserType = UserCreditType.SET_BUYER_CREDIT.getValue();
/* 424 */       dealResult = dealResult + "[买家]信用:";
/*     */     }
/* 426 */     Integer creditCount = Integer.valueOf(0);
/*     */ 
/* 430 */     this.userCreditService.changeUserCredit(userAccount, complainedUserType, order.getProjectCode(), creditCount, detailTradeOrderCc.getOrderNo(), tradeOrderCc.getAuditor());
/*     */ 
/* 433 */     dealResult = dealResult + creditCount.toString() + "信用分";
/* 434 */     return dealResult;
/*     */   }
/*     */ 
/*     */   private String userLevelDeal(TradeOrderCc tradeOrderCc, TradeOrderCc detailTradeOrderCc, TradeOrder order, String userAccount)
/*     */   {
/* 443 */     SystemDict sysDict = null;
/* 444 */     String dealResult = "";
/*     */ 
/* 446 */     if (userAccount.equals(detailTradeOrderCc.getSellerAccount())) {
/* 447 */       dealResult = dealResult + "[卖家]等级";
/*     */     }
/* 449 */     else if (userAccount.equals(detailTradeOrderCc.getBuyerAccount())) {
/* 450 */       dealResult = dealResult + "[买家]等级";
/*     */     }
/* 452 */     Integer integral = Integer.valueOf(0);
/*     */ 
/* 456 */     this.userLevelService.updateUserLevel(userAccount, Integer.valueOf(sysDict.getParaValue()).intValue());
/* 457 */     this.userLevelService.insertUserIntegralLog(userAccount, detailTradeOrderCc.getOrderNo(), order.getProjectCode(), EnumSystemDictKey.PROJECT_LIQUIDATED_INTEGRAL.getValue(), integral, tradeOrderCc.getAuditor());
/*     */ 
/* 462 */     dealResult = dealResult + integral + "等级分";
/* 463 */     return dealResult;
/*     */   }
/*     */ 
/*     */   private void tradeOrderCcDeal(TradeOrderCc tradeOrderCc, String otherResult)
/*     */   {
/* 471 */     tradeOrderCc.setReason(otherResult + "<br />" + "[客服备注]" + tradeOrderCc.getReason() + "<br />[系统备注]实际处理方式为" + EnumTradeOrderCcDealType.indexByValue(tradeOrderCc.getDealType()).getName() + "方式！");
/*     */ 
/* 479 */     this.tradeOrderCcDAO.updateByOrderCcNum(tradeOrderCc);
/*     */   }
/*     */ 
/*     */   private boolean checkDealType(TradeOrderCc orderCc, TradeOrderCc deatailOrderCc)
/*     */   {
/* 487 */     if ((null != orderCc.getDealType()) && (null != deatailOrderCc.getCcType()))
/*     */     {
/* 489 */       if (orderCc.getDealType().equals(EnumTradeOrderCcDealType.GENERAL.getValue())) {
/* 490 */         return true;
/*     */       }
/*     */ 
/* 493 */       if (EnumTradeOrderCcType.DEFAULT_BUYER_UNCHECK_GOODS_ARRIVAL.getValue().equals(deatailOrderCc.getCcType())) {
/* 494 */         if ((EnumTradeOrderCcDealType.DEFAULT_BUYER_UNCHECK_GOODS_ARRIVAL.getValue().equals(orderCc.getDealType())) || (EnumTradeOrderCcDealType.DEFAULT_SELLER_GOODS_REFUND.getValue().equals(orderCc.getDealType())) || (EnumTradeOrderCcDealType.DEFAULT_SELLER_GOODS_REFUND_PENALTY.getValue().equals(orderCc.getDealType())) || (EnumTradeOrderCcDealType.DEFAULT_SELLER_DOODS_ARIVAL_AMOUNT.getValue().equals(orderCc.getDealType())))
/*     */         {
/* 498 */           return true;
/*     */         }
/*     */ 
/*     */       }
/* 502 */       else if (deatailOrderCc.getCcType().equals(EnumTradeOrderCcType.DEFAULT_BUYER_UNCHECK_RECEIPT_ARRIVAL.getValue())) {
/* 503 */         if ((orderCc.getDealType().equals(EnumTradeOrderCcDealType.DEFAULT_BUYER_UNCHECK_RECEIPT_ARRIVAL.getValue())) || (orderCc.getDealType().equals(EnumTradeOrderCcDealType.DEFAULT_SELLER_UNBILLING.getValue())) || (orderCc.getDealType().equals(EnumTradeOrderCcDealType.DEFAULT_SELLER_UNBILLING_PENALTY.getValue())))
/*     */         {
/* 506 */           return true;
/*     */         }
/*     */ 
/*     */       }
/* 510 */       else if (orderCc.getDealType().equals(deatailOrderCc.getCcType())) {
/* 511 */         return true;
/*     */       }
/*     */     }
/* 514 */     return false;
/*     */   }
/*     */ 
/*     */   private String getTransferDirect(Long money)
/*     */   {
/* 522 */     if (null == money) {
/* 523 */       return "无变动；";
/*     */     }
/* 525 */     if (money.longValue() < 0L) {
/* 526 */       money = Long.valueOf(money.longValue() * -1L);
/* 527 */       return "扣除" + CommonUtils.getMoneyDesc(money) + "元；";
/*     */     }
/* 529 */     if (money.longValue() >= 0L) {
/* 530 */       return "补偿" + CommonUtils.getMoneyDesc(money) + "元；";
/*     */     }
/* 532 */     return "无变动；";
/*     */   }
/*     */ 
/*     */   private TradeOrderGoodAmountServiceResult goodsDeal(TradeOrderCc tradeOrderCc, TradeOrder tradeOrder)
/*     */   {
/* 541 */     TradeOrderGoodAmountServiceResult orderResult = new TradeOrderGoodAmountServiceResult();
/* 542 */     TradeOrderBaseRequest orderRequest = new TradeOrderBaseRequest();
/* 543 */     orderRequest.setOrderNo(tradeOrder.getOrderNo());
/* 544 */     orderRequest.setOperator(tradeOrderCc.getAuditor());
/*     */ 
/* 546 */     if (EnumTradeOrderCcDealType.DEFAULT_BUYER_UNCHECK_GOODS_ARRIVAL.getValue().equals(tradeOrderCc.getDealType())) {
/* 547 */       orderRequest.setUserAccount(tradeOrder.getBuyerAccount());
/* 548 */       orderRequest.setOperatorType(EnumOperatorType.SYSTEM.getValue());
/* 549 */       orderRequest.setCheckPayPwd(Boolean.valueOf(false));
/* 550 */       orderResult = this.tradeOrderService.orderGoodsValidate(orderRequest);
/*     */     } else {
/* 552 */       orderRequest.setOperKey(tradeOrderCc.getDealType());
/*     */ 
/* 554 */       if ((!EnumTradeOrderCcDealType.DEFAULT_SELLER_GOODS_REFUND.getValue().equals(tradeOrderCc.getDealType())) || 
/* 557 */         (EnumTradeOrderCcDealType.DEFAULT_SELLER_GOODS_REFUND_PENALTY.getValue().equals(tradeOrderCc.getDealType()))) {
/* 558 */         orderRequest.setHasSellerPenalty(true);
/*     */       }
/*     */ 
/* 561 */       if (EnumTradeOrderCcDealType.DEFAULT_SELLER_DOODS_ARIVAL_AMOUNT.getValue().equals(tradeOrderCc.getDealType())) {
/* 562 */         Long amount = transMoneyStringToLong(tradeOrderCc.getDealMoney(), tradeOrder.getValuationUnit());
/* 563 */         orderRequest.setGoodsAmount(amount);
/*     */       }
/* 565 */       orderResult = this.tradeOrderService.penaltyCheckGoods(orderRequest);
/*     */     }
/* 567 */     return orderResult;
/*     */   }
/*     */ 
/*     */   private String goodsDealInfo(TradeOrderGoodAmountServiceResult goodsResult, TradeOrderCc tradeOrderCc)
/*     */   {
/* 576 */     if (goodsResult.correct()) {
/* 577 */       String info = "";
/* 578 */       if (EnumTradeOrderCcDealType.DEFAULT_BUYER_UNCHECK_GOODS_ARRIVAL.getValue().equals(tradeOrderCc.getDealType())) {
/* 579 */         info = "[卖家]收到货款" + CommonUtils.getMoneyDesc(goodsResult.getGoodsAmount()) + "元，订单已\"确认到货\"。返还交收保证金：" + CommonUtils.getMoneyDesc(goodsResult.getSellDeliveryDeposit()) + "元，<br />" + "[买家]返还交收保证金：" + CommonUtils.getMoneyDesc(goodsResult.getBuyDeliveryDeposit()) + "元；";
/*     */ 
/* 587 */         return info;
/*     */       }
/* 589 */       if (EnumTradeOrderCcDealType.DEFAULT_SELLER_GOODS_REFUND.getValue().equals(tradeOrderCc.getDealType())) {
/* 590 */         info = "[卖家]返还买家货款：" + CommonUtils.getMoneyDesc(goodsResult.getGoodsAmount()) + "元，返还交收保证金：" + CommonUtils.getMoneyDesc(goodsResult.getSellDeliveryDeposit()) + "元；<br />" + "[买家]获得货款:" + CommonUtils.getMoneyDesc(goodsResult.getGoodsAmount()) + "，返还交收保证金:" + CommonUtils.getMoneyDesc(goodsResult.getBuyDeliveryDeposit()) + "元；";
/*     */ 
/* 600 */         return info;
/* 601 */       }if (EnumTradeOrderCcDealType.DEFAULT_SELLER_GOODS_REFUND_PENALTY.getValue().equals(tradeOrderCc.getDealType())) {
/* 602 */         info = "[卖家]返还买家货款：" + CommonUtils.getMoneyDesc(goodsResult.getGoodsAmount()) + "元，返还交收保证金：" + CommonUtils.getMoneyDesc(goodsResult.getSellDeliveryDeposit()) + "元；违约金扣除：" + CommonUtils.getMoneyDesc(goodsResult.getSellPenaltyAmount()) + "元；<br />" + "[买家]获得货款:" + CommonUtils.getMoneyDesc(goodsResult.getGoodsAmount()) + "元，返还交收保证金:" + CommonUtils.getMoneyDesc(goodsResult.getBuyDeliveryDeposit()) + "元；获得卖家违约补偿：" + CommonUtils.getMoneyDesc(goodsResult.getSellPenaltyAmount()) + "元；";
/*     */ 
/* 616 */         return info;
/* 617 */       }if (EnumTradeOrderCcDealType.DEFAULT_SELLER_DOODS_ARIVAL_AMOUNT.getValue().equals(tradeOrderCc.getDealType())) {
/* 618 */         info = "[卖家]收到货款：" + CommonUtils.getMoneyDesc(goodsResult.getSellGoodsAmount()) + "元，被扣除货款：" + CommonUtils.getMoneyDesc(goodsResult.getGoodsAmount()) + "元；<br />" + "[买家]获得货款补偿:" + CommonUtils.getMoneyDesc(goodsResult.getGoodsAmount()) + "元；";
/*     */ 
/* 626 */         return info;
/*     */       }
/*     */     }
/*     */ 
/* 630 */     return goodsResult.getErrorInfo();
/*     */   }
/*     */ 
/*     */   private TradeOrderGoodAmountServiceResult invoiceDeal(TradeOrderCc tradeOrderCc, TradeOrder tradeOrder)
/*     */   {
/* 640 */     TradeOrderGoodAmountServiceResult orderResult = new TradeOrderGoodAmountServiceResult();
/* 641 */     TradeOrderBaseRequest orderRequest = new TradeOrderBaseRequest();
/* 642 */     orderRequest.setOrderNo(tradeOrder.getOrderNo());
/* 643 */     orderRequest.setOperator(tradeOrderCc.getAuditor());
/*     */ 
/* 645 */     if (tradeOrderCc.getDealType().equals(EnumTradeOrderCcDealType.DEFAULT_BUYER_UNCHECK_RECEIPT_ARRIVAL.getValue()))
/*     */     {
/* 648 */       orderRequest.setUserAccount(tradeOrder.getBuyerAccount());
/* 649 */       orderRequest.setOperator(tradeOrderCc.getAuditor());
/* 650 */       orderRequest.setOperatorType(EnumOperatorType.SYSTEM.getValue());
/* 651 */       orderRequest.setCheckPayPwd(Boolean.valueOf(false));
/* 652 */       orderResult = this.tradeOrderService.orderInvoiceValidate(orderRequest);
/*     */     }
/*     */     else
/*     */     {
/* 656 */       if (tradeOrderCc.getDealType().equals(EnumTradeOrderCcDealType.DEFAULT_SELLER_UNBILLING.getValue()))
/*     */       {
/* 658 */         orderRequest.setHasSellerPenalty(false);
/*     */       }
/* 660 */       if (tradeOrderCc.getDealType().equals(EnumTradeOrderCcDealType.DEFAULT_SELLER_UNBILLING_PENALTY.getValue()))
/*     */       {
/* 662 */         orderRequest.setHasSellerPenalty(true);
/*     */       }
/* 664 */       Long amount = transMoneyStringToLong(tradeOrderCc.getDealMoney(), tradeOrder.getValuationUnit());
/* 665 */       orderRequest.setGoodsAmount(amount);
/* 666 */       orderResult = this.tradeOrderService.penaltyCheckTicket(orderRequest);
/*     */     }
/* 668 */     return orderResult;
/*     */   }
/*     */ 
/*     */   private String invoiceDealInfo(TradeOrderGoodAmountServiceResult invoiceResult, TradeOrderCc tradeOrderCc)
/*     */   {
/* 678 */     if (invoiceResult.correct()) {
/* 679 */       String info = "";
/* 680 */       if (EnumTradeOrderCcDealType.DEFAULT_BUYER_UNCHECK_RECEIPT_ARRIVAL.getValue().equals(tradeOrderCc.getDealType())) {
/* 681 */         info = "[卖家]收到货款：" + CommonUtils.getMoneyDesc(invoiceResult.getGoodsAmount()) + "元，订单已\"确认到票\"。返还交收保证金：" + CommonUtils.getMoneyDesc(invoiceResult.getSellDeliveryDeposit()) + "元，<br />" + "[买家]返还交收保证金：" + CommonUtils.getMoneyDesc(invoiceResult.getBuyDeliveryDeposit()) + "元；";
/*     */ 
/* 689 */         return info;
/* 690 */       }if (EnumTradeOrderCcDealType.DEFAULT_SELLER_UNBILLING.getValue().equals(tradeOrderCc.getDealType())) {
/* 691 */         info = "[卖家]订单剩余货款扣除：" + CommonUtils.getMoneyDesc(invoiceResult.getGoodsAmount()) + "元，收到订单剩余货款：" + CommonUtils.getMoneyDesc(invoiceResult.getSellGoodsAmount()) + "元，返还交收保证金：" + CommonUtils.getMoneyDesc(invoiceResult.getSellDeliveryDeposit()) + "元;<br />" + "[买家]收到货款补偿：" + CommonUtils.getMoneyDesc(invoiceResult.getGoodsAmount()) + "元，返还交收保证金：" + CommonUtils.getMoneyDesc(invoiceResult.getBuyDeliveryDeposit()) + "元";
/*     */ 
/* 703 */         return info;
/* 704 */       }if (EnumTradeOrderCcDealType.DEFAULT_SELLER_UNBILLING_PENALTY.getValue().equals(tradeOrderCc.getDealType())) {
/* 705 */         info = "[卖家]订单剩余货款扣除：" + CommonUtils.getMoneyDesc(invoiceResult.getGoodsAmount()) + "元，扣除违约金：" + CommonUtils.getMoneyDesc(invoiceResult.getSellPenaltyAmount()) + "元，收到订单剩余货款：" + CommonUtils.getMoneyDesc(invoiceResult.getSellGoodsAmount()) + "元，返还交收保证金：" + CommonUtils.getMoneyDesc(invoiceResult.getSellDeliveryDeposit()) + "元;<br />" + "[买家]收到货款补偿：" + CommonUtils.getMoneyDesc(invoiceResult.getGoodsAmount()) + "元，获得卖家违约补偿：" + CommonUtils.getMoneyDesc(invoiceResult.getSellPenaltyAmount()) + "元，返还交收保证金：" + CommonUtils.getMoneyDesc(invoiceResult.getBuyDeliveryDeposit()) + "元";
/*     */ 
/* 721 */         return info;
/*     */       }
/*     */     }
/*     */ 
/* 725 */     return invoiceResult.getErrorInfo();
/*     */   }
/*     */ 
/*     */   private Long transMoneyStringToLong(String moneyStr, String unite)
/*     */   {
/* 735 */     BigDecimal bg = new BigDecimal(moneyStr);
/* 736 */     Long money = Long.valueOf(bg.movePointRight(EnumValuationUnit.indexByValue(unite).getScale()).longValue());
/* 737 */     return money;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.pojo.order.TradeOrderCcServiceImpl
 * JD-Core Version:    0.6.0
 */