/*     */ package com.hundsun.network.gates.wulin.biz.service.pojo.order;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumActiveStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumComplainStarterType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumOperatorType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumSystemDictKey;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeOrderCcStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeOrderCcType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeOrderStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeUserType;
/*     */ import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.TradeOrderCcDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumTradeOrderResultErrors;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.SystemMessageRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.TradeOrderCcRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.SystemMessageResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.TradeOrderCcServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteSystemMessageService;
/*     */ import com.hundsun.network.gates.wulin.biz.dao.baseset.SystemDictDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.dao.order.TradeOrderDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.baseset.SystemDict;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.order.TradeOrder;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.query.TradeOrderQueryAddition;
/*     */ import com.hundsun.network.gates.wulin.biz.factory.TradeOrderQueryFactory;
/*     */ import com.hundsun.network.gates.wulin.biz.service.BaseService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.baseset.UserCreditService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.order.TradeOrderAutoService;
/*     */ import com.hundsun.network.gates.wulin.biz.service.order.TradeOrderCcService;

/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import java.util.Set;

/*     */ import org.apache.commons.logging.Log;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.context.MessageSource;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ @Service("tradeOrderAutoService")
/*     */ public class TradeOrderAutoServiceImpl extends BaseService
/*     */   implements TradeOrderAutoService
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private SystemDictDAO systemDictDAO;
/*     */ 
/*     */   @Autowired
/*     */   private TradeOrderDAO tradeOrderDAO;
/*     */ 
/*     */   @Autowired
/*     */   private RemoteSystemMessageService remoteSystemMessageService;
/*     */ 
/*     */   @Autowired
/*     */   private MessageSource messageSource;
/*     */ 
/*     */   @Autowired
/*     */   private TradeOrderCcService tradeOrderCcService;
/*     */ 
/*     */   @Autowired
/*     */   private UserCreditService userCreditService;
/*     */ 
/*     */   public ServiceResult autoOrderOption()
/*     */   {
/*  68 */     ServiceResult result = new ServiceResult();
/*  69 */     this.log.debug("<---------------quartz autoOrderOption start ------------------->");
/*     */     try
/*     */     {
/*  76 */       result = dealOrderRemindOption();
/*  77 */       if (result.error())
/*  78 */         this.log.error("deal order remind option fail:" + result.getErrorInfo());
/*     */       else
/*  80 */         this.log.info("deal order remind optoin success");
/*     */     }
/*     */     catch (Exception e) {
/*  83 */       this.log.error("deal order remind option error", e);
/*     */     }
/*     */     try
/*     */     {
/*  87 */       result = dealOrderGrnorderOption();
/*  88 */       if (result.error())
/*  89 */         this.log.error("deal order grnorder option fail:" + result.getErrorInfo());
/*     */       else
/*  91 */         this.log.info("deal order grnorder optoin success");
/*     */     }
/*     */     catch (Exception e) {
/*  94 */       this.log.error("deal order grnorder option error", e);
/*     */     }
/*     */     try
/*     */     {
/*  98 */       result = dealUncommentOption();
/*  99 */       if (result.error())
/* 100 */         this.log.error("deal order uncomment option fail:" + result.getErrorInfo());
/*     */       else
/* 102 */         this.log.info("deal order uncomment optoin success");
/*     */     }
/*     */     catch (Exception e) {
/* 105 */       this.log.error("deal order uncomment option error", e);
/*     */     }
/*     */ 
/* 108 */     this.log.debug("<---------------quartz autoOrderOption end ------------------->");
/* 109 */     return result;
/*     */   }
/*     */ 
/*     */   public ServiceResult dealOrderRemindOption()
/*     */   {
/* 114 */     this.log.info("dealOrderRemindOption start");
/* 115 */     ServiceResult result = new ServiceResult();
/* 116 */     List param = new ArrayList();
/* 117 */     param.add(EnumSystemDictKey.COMFIM_REMIND_DAYS);
/* 118 */     param.add(EnumSystemDictKey.UNPAY_REMIND_DAYS);
/* 119 */     param.add(EnumSystemDictKey.UNDELIVERY_REMIND_DAYS);
/* 120 */     param.add(EnumSystemDictKey.ARRIVEDGOODS_REMIND_DAYS);
/* 121 */     param.add(EnumSystemDictKey.ARRIVEDTICKET_REMIND_DAYS);
/* 122 */     Map<String, SystemDict> systemDictMap = this.systemDictDAO.selectListByMultiKey(param);
/* 123 */     if ((null == systemDictMap) || (systemDictMap.size() <= 0)) {
/* 124 */       this.log.error("[error]获取基础配置失败！");
/* 125 */       result.setErrorInfo(EnumTradeOrderResultErrors.AUTO_ORDER_GET_BASE_SETTING_ERROR.getInfo());
/*     */ 
/* 127 */       result.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.AUTO_ORDER_GET_BASE_SETTING_ERROR.getValue()));
/*     */ 
/* 129 */       return result;
/*     */     }
/*     */ 
/* 132 */     for (String key : systemDictMap.keySet()) {
/* 133 */       SystemDict dict = (SystemDict)systemDictMap.get(key);
				TradeOrderQueryAddition query;
/* 134 */       query = TradeOrderQueryFactory.getTradeOrderQuery(EnumSystemDictKey.indexByValue(key), dict);
/*     */ 
/* 136 */       if (null == query) {
/* 137 */         this.log.error("can not build trade order query! key:" + key + " dict:" + systemDictMap.get(key));
/*     */ 
/* 139 */         continue;
/*     */       }
/* 141 */       List<TradeOrder> list = this.tradeOrderDAO.queryTradeOrderByCondition(query);
/* 142 */       if (null != list)
/* 143 */         for (TradeOrder tradeOrder : list) {
/* 144 */           SystemMessageRequest request = new SystemMessageRequest();
/* 145 */           if (query.getIsRemindBuyer(tradeOrder)) {
/* 146 */             request.addUser(tradeOrder.getBuyerAccount());
/*     */           }
/* 148 */           if (query.getIsRemindSeller(tradeOrder)) {
/* 149 */             request.addUser(tradeOrder.getSellerAccount());
/*     */           }
/* 151 */           request.setSendAccount(EnumOperatorType.SYSTEM.getValue());
/* 152 */           request.setTitle(getMessage(query.getTitle(), new String[0]));
/* 153 */           request.setContent(getMessage(query.getContent(), new String[] { tradeOrder.getOrderNo() }));
/*     */           try {
/* 155 */             SystemMessageResult systemMessageResult = this.remoteSystemMessageService.sendSystemMessage(request);
/*     */ 
/* 157 */             if (systemMessageResult.error())
/* 158 */               this.log.error("send system message fail," + systemMessageResult.getErrorInfo());
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/* 162 */             this.log.error("sendSystemMessage error:", e);
/* 163 */           }continue;
/*     */         }
/*     */     }
/*     */     
/* 168 */     return result;
/*     */   }
/*     */ 
/*     */   public ServiceResult dealOrderGrnorderOption()
/*     */   {
/* 173 */     ServiceResult result = new ServiceResult();
/* 174 */     Set param = new HashSet();
/* 175 */     param.add(EnumSystemDictKey.CONFIM_ORDER_DAYS);
/* 176 */     param.add(EnumSystemDictKey.UNPAY_GENORDER_DAYS);
/* 177 */     param.add(EnumSystemDictKey.UNDELIVERY_GENORDER_DAYS);
/* 178 */     param.add(EnumSystemDictKey.ARRIVEDGOODS_GENORDER_DAYS);
/* 179 */     param.add(EnumSystemDictKey.ARRIVEDTICKET_GENORDER_DAYS);

				EnumSystemDictKey key;
/*     */     TradeOrderQueryAddition query;
/* 180 */     for (Iterator i$ = param.iterator(); i$.hasNext(); ) { key = (EnumSystemDictKey)i$.next();
/* 181 */       query = TradeOrderQueryFactory.getTradeOrderQuery(key, null);
/* 182 */       if (null == query) {
/* 183 */         this.log.error("can not build trade order query! key:" + key.getValue());
/* 184 */         continue;
/*     */       }
/* 186 */       List<TradeOrder> list = this.tradeOrderDAO.queryTradeOrderByCondition(query);
/* 187 */       if (null != list)
/* 188 */         for (TradeOrder tradeOrder : list)
/*     */         {
/* 192 */           TradeOrderCcRequest requestBuyer = null;
/* 193 */           TradeOrderCcRequest requestSeller = null;
/*     */ 
/* 195 */           if (EnumSystemDictKey.CONFIM_ORDER_DAYS.equals(key)) {
/* 196 */             String type = isComplainAble(EnumTradeUserType.BUYER.getValue(), tradeOrder);
/* 197 */             if (null != type) {
/* 198 */               requestBuyer = new TradeOrderCcRequest();
/* 199 */               TradeOrderCcDTO tradeOrderCcDTO = new TradeOrderCcDTO();
/* 200 */               tradeOrderCcDTO.setCcStartor(EnumComplainStarterType.SYSTEM.getValue());
/* 201 */               tradeOrderCcDTO.setCcType(type);
/* 202 */               tradeOrderCcDTO.setOrderNo(tradeOrder.getOrderNo());
/* 203 */               tradeOrderCcDTO.setStatus(EnumTradeOrderCcStatus.SUBMIT.getValue());
/* 204 */               tradeOrderCcDTO.setCreator(EnumComplainStarterType.SYSTEM.getValue());
/* 205 */               tradeOrderCcDTO.setComplainedType(EnumTradeUserType.BUYER.getValue());
/* 206 */               requestBuyer.setTradeOrderCcDTO(tradeOrderCcDTO);
/*     */             }
/* 208 */             type = isComplainAble(EnumTradeUserType.SELLER.getValue(), tradeOrder);
/* 209 */             if (null != type) {
/* 210 */               requestSeller = new TradeOrderCcRequest();
/* 211 */               TradeOrderCcDTO tradeOrderCcDTO = new TradeOrderCcDTO();
/* 212 */               tradeOrderCcDTO.setCcStartor(EnumComplainStarterType.SYSTEM.getValue());
/* 213 */               tradeOrderCcDTO.setCcType(type);
/* 214 */               tradeOrderCcDTO.setOrderNo(tradeOrder.getOrderNo());
/* 215 */               tradeOrderCcDTO.setStatus(EnumTradeOrderCcStatus.SUBMIT.getValue());
/* 216 */               tradeOrderCcDTO.setCreator(EnumComplainStarterType.SYSTEM.getValue());
/* 217 */               tradeOrderCcDTO.setComplainedType(EnumTradeUserType.SELLER.getValue());
/* 218 */               requestSeller.setTradeOrderCcDTO(tradeOrderCcDTO);
/*     */             }
/*     */           }
/*     */           else {
/* 222 */             if (query.getIsRemindBuyer(tradeOrder)) {
/* 223 */               requestBuyer = new TradeOrderCcRequest();
/* 224 */               TradeOrderCcDTO tradeOrderCcDTO = new TradeOrderCcDTO();
/* 225 */               tradeOrderCcDTO.setCcStartor(EnumComplainStarterType.SYSTEM.getValue());
/* 226 */               tradeOrderCcDTO.setCcType(query.getCcBuyerType().getValue());
/* 227 */               tradeOrderCcDTO.setOrderNo(tradeOrder.getOrderNo());
/* 228 */               tradeOrderCcDTO.setStatus(EnumTradeOrderCcStatus.SUBMIT.getValue());
/* 229 */               tradeOrderCcDTO.setCreator(EnumComplainStarterType.SYSTEM.getValue());
/* 230 */               tradeOrderCcDTO.setComplainedType(EnumTradeUserType.BUYER.getValue());
/* 231 */               requestBuyer.setTradeOrderCcDTO(tradeOrderCcDTO);
/*     */             }
/* 233 */             if (query.getIsRemindSeller(tradeOrder)) {
/* 234 */               requestSeller = new TradeOrderCcRequest();
/* 235 */               TradeOrderCcDTO tradeOrderCcDTO = new TradeOrderCcDTO();
/* 236 */               tradeOrderCcDTO.setCcStartor(EnumComplainStarterType.SYSTEM.getValue());
/* 237 */               tradeOrderCcDTO.setCcType(query.getCcSellerType().getValue());
/* 238 */               tradeOrderCcDTO.setOrderNo(tradeOrder.getOrderNo());
/* 239 */               tradeOrderCcDTO.setStatus(EnumTradeOrderCcStatus.SUBMIT.getValue());
/* 240 */               tradeOrderCcDTO.setCreator(EnumComplainStarterType.SYSTEM.getValue());
/* 241 */               tradeOrderCcDTO.setComplainedType(EnumTradeUserType.SELLER.getValue());
/* 242 */               requestSeller.setTradeOrderCcDTO(tradeOrderCcDTO);
/*     */             }
/*     */           }
/*     */           try
/*     */           {
/* 247 */             if (null != requestBuyer) {
/* 248 */               TradeOrderCcServiceResult ccResult = this.tradeOrderCcService.addTradeOrderCc(requestBuyer);
/*     */ 
/* 250 */               if (ccResult.error()) {
/* 251 */                 this.log.error("buyer addTradeOrderCc fail,return info:" + ccResult.getErrorInfo());
/*     */               }
/*     */             }
/*     */ 
/* 255 */             if (null != requestSeller) {
/* 256 */               TradeOrderCcServiceResult ccResult = this.tradeOrderCcService.addTradeOrderCc(requestSeller);
/*     */ 
/* 258 */               if (ccResult.error())
/* 259 */                 this.log.error("seller addTradeOrderCc fail,return info:" + ccResult.getErrorInfo());
/*     */             }
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/* 264 */             this.log.error("tradeOrderCcService.addTradeOrderCc error, orderNo:" + tradeOrder.getOrderNo());
/*     */           }
/* 266 */           continue;
/*     */         }
/*     */     }
/*     */     
/* 271 */     return result;
/*     */   }
/*     */ 
/*     */   public ServiceResult dealUncommentOption()
/*     */   {
/* 276 */     ServiceResult result = new ServiceResult();
/* 277 */     Set<EnumSystemDictKey> param = new HashSet();
/* 278 */     param.add(EnumSystemDictKey.ARRIVED_UNCOMMENT_DAYS);
/* 279 */     SystemDict dict = new SystemDict();
/* 280 */     dict.setParaValue("5");
/*     */ 
/* 283 */     for (EnumSystemDictKey key : param) {
/* 284 */       TradeOrderQueryAddition query = TradeOrderQueryFactory.getTradeOrderQuery(key, dict);
/* 285 */       if (null == query) {
/* 286 */         this.log.error("can not build trade order query! key:" + key.getValue());
/* 287 */         continue;
/*     */       }
/* 289 */       List<TradeOrder> list = this.tradeOrderDAO.queryTradeOrderByCondition(query);
/* 290 */       if (null != list) {
/* 291 */         for (TradeOrder tradeOrder : list) {
/* 292 */           this.log.info("autoUserCredit orderNo:" + tradeOrder.getOrderNo());
/*     */           try {
/* 294 */             if (isShouldBuyerAutoUserCredit(tradeOrder)) {
/* 295 */               autoUserCredit(tradeOrder, tradeOrder.getSellerAccount(), tradeOrder.getBuyerAccount());
/*     */             }
/*     */ 
/* 298 */             if (isShouldSellerAutoUserCredit(tradeOrder))
/* 299 */               autoUserCredit(tradeOrder, tradeOrder.getBuyerAccount(), tradeOrder.getSellerAccount());
/*     */           }
/*     */           catch (Exception e)
/*     */           {
/* 303 */             this.log.error("AutoUserCredit internal error:", e);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 308 */     return result;
/*     */   }
/*     */ 
/*     */   private ServiceResult autoUserCredit(TradeOrder order, String userAccount, String operator)
/*     */   {
/* 319 */     ServiceResult serviceResult = new ServiceResult();
/*     */     try {
/* 321 */       serviceResult = this.userCreditService.autoUserCredit(order, userAccount, operator);
/* 322 */       if (serviceResult.error()) {
/* 323 */         this.log.error("autoUserCredit fail,orderNo:" + order.getOrderNo() + ",userAccount:" + userAccount + ",operator:" + operator + ",errorInfo:" + serviceResult.getErrorInfo());
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 328 */       this.log.error("autoUserCredit error orderNo:" + order.getOrderNo() + ",userAccount:" + userAccount + ",operator:" + operator, e);
/*     */ 
/* 330 */       serviceResult.setErrorInfo(EnumTradeOrderResultErrors.INTERNAL_ERROR.getInfo());
/* 331 */       serviceResult.setErrorNO(Integer.valueOf(EnumTradeOrderResultErrors.INTERNAL_ERROR.getValue()));
/* 332 */       return serviceResult;
/*     */     }
/* 334 */     return serviceResult;
/*     */   }
/*     */ 
/*     */   private boolean isShouldBuyerAutoUserCredit(TradeOrder order)
/*     */   {
/* 344 */     return EnumActiveStatus.No.getValue().equals(order.getHasBuyerRank());
/*     */   }
/*     */ 
/*     */   private boolean isShouldSellerAutoUserCredit(TradeOrder order)
/*     */   {
/* 353 */     return EnumActiveStatus.No.getValue().equals(order.getHasSellerRank());
/*     */   }
/*     */ 
/*     */   protected String getMessage(String code, String[] args)
/*     */   {
/* 363 */     return this.messageSource.getMessage(code, args, Locale.CHINA);
/*     */   }
/*     */ 
/*     */   protected String isComplainAble(String userType, TradeOrder order)
/*     */   {
/* 375 */     String type = null;
/* 376 */     if ((null == order) || (!EnumTradeOrderStatus.WAIT_PAYCONFIRM.getValue().equals(order.getStatus()))) {
/* 377 */       return type;
/*     */     }
/* 379 */     if (EnumTradeUserType.BUYER.getValue().equals(userType)) {
/* 380 */       if (("N".equals(order.getHasBuyerConfirm())) && ("Y".equals(order.getHasSellerConfirm()))) {
/* 381 */         if (order.getBuyerAccount().equals(order.getCreator()))
/* 382 */           type = EnumTradeOrderCcType.DEFAULT_PLACE_UNCHECK.getValue();
/*     */         else
/* 384 */           type = EnumTradeOrderCcType.DEFAULT_LIST_UNCHECK.getValue();
/*     */       }
/*     */     }
/* 387 */     else if ((EnumTradeUserType.SELLER.getValue().equals(userType)) && 
/* 388 */       ("N".equals(order.getHasSellerConfirm())) && ("Y".equals(order.getHasBuyerConfirm()))) {
/* 389 */       if (order.getSellerAccount().equals(order.getCreator()))
/* 390 */         type = EnumTradeOrderCcType.DEFAULT_PLACE_UNCHECK.getValue();
/*     */       else {
/* 392 */         type = EnumTradeOrderCcType.DEFAULT_LIST_UNCHECK.getValue();
/*     */       }
/*     */     }
/*     */ 
/* 396 */     return type;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.pojo.order.TradeOrderAutoServiceImpl
 * JD-Core Version:    0.6.0
 */