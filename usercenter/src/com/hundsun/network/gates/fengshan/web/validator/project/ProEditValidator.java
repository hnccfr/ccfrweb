/*     */ package com.hundsun.network.gates.fengshan.web.validator.project;
/*     */ 
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.project.AttriMeta;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectListing;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectMetas;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectTradeBO;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectTypeAttri;
/*     */ import com.hundsun.network.gates.fengshan.web.util.FileUploadUtil;
/*     */ import com.hundsun.network.gates.fengshan.web.util.ProjectCopyUtil;
/*     */ import com.hundsun.network.gates.fengshan.web.util.TradeMoneyUtil;
/*     */ import com.hundsun.network.gates.luosi.biz.domain.TradeShowDTO;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumBidOrderProperty;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumDeliveryType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumInvoice;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumMeasureUnit;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumPaymentType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumPlaceOrderProperty;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumProTypeAttriInputType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTenderOrderProperty;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTransferOrderProperty;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumValuationUnit;
/*     */ import com.hundsun.network.gates.luosi.common.utils.DateUtil;
/*     */ import com.hundsun.network.gates.luosi.common.utils.FormatValidate;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.math.BigDecimal;
/*     */ import java.text.ParseException;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.springframework.util.Assert;
/*     */ import org.springframework.validation.Errors;
/*     */ import org.springframework.web.multipart.MultipartFile;
/*     */ import org.springmodules.validation.valang.ValangValidator;
/*     */ 
/*     */ public class ProEditValidator extends ValangValidator
/*     */ {
/*  45 */   protected final Log log = LogFactory.getLog(getClass());
/*     */ 
/*     */   public void validate(Object obj, Errors err)
/*     */   {
/*  49 */     Assert.notNull(obj);
/*  50 */     Assert.isInstanceOf(ProjectListing.class, obj);
/*  51 */     super.validate(obj, err);
/*  52 */     ProjectListing projectListing = (ProjectListing)obj;
/*  53 */     commonValidate(projectListing, err);
/*     */   }
/*     */ 
/*     */   public void placeOrderVadate(ProjectListing projectListing, ProjectTradeBO tradeBo, Map<String, String> err, List<String> ignoreList)
/*     */   {
/*  64 */     List tradeShowList = tradeBo.getTradeMetas();
/*  65 */     if ((tradeShowList != null) && (tradeShowList.size() > 0)) {
/*  66 */       int maxQuantity = 0;
/*  67 */       int minQuantity = 0;
/*  68 */       int multipleBase = 0;
/*  69 */       HashMap keyValueMap = getMapFromList(tradeShowList);
/*  70 */       if (!ignoreList.contains(EnumPlaceOrderProperty.RETAIL.getKey())) {
/*  71 */         TradeShowDTO tradeShowDTO = (TradeShowDTO)keyValueMap.get(EnumPlaceOrderProperty.RETAIL.getKey());
/*  72 */         if (StringUtil.isEmpty(tradeShowDTO.getInputValue())) {
/*  73 */           err.put(tradeShowDTO.getKey(), "此项为必填项!");
/*     */         }
/*     */       }
/*  76 */       if (!ignoreList.contains(EnumPlaceOrderProperty.MULTIPLE_BASE.getKey())) {
/*  77 */         TradeShowDTO tradeShowDTO = (TradeShowDTO)keyValueMap.get(EnumPlaceOrderProperty.MULTIPLE_BASE.getKey());
/*     */ 
/*  80 */         if (StringUtil.isEmpty(tradeShowDTO.getInputValue())) {
/*  81 */           err.put(tradeShowDTO.getKey(), "此项为必填项!");
/*     */         }
/*  83 */         if (!FormatValidate.isValidInteger(tradeShowDTO.getInputValue())) {
/*  84 */           err.put(tradeShowDTO.getKey(), "请输入正确的数字!");
/*     */         }
/*  86 */         multipleBase = Integer.valueOf(tradeShowDTO.getInputValue()).intValue();
/*  87 */         if (projectListing.getQuantity().longValue() % multipleBase != 0L) {
/*  88 */           err.put(tradeShowDTO.getKey(), "下单数量必须是下单基数的整数倍!");
/*     */         }
/*  90 */         if (multipleBase > projectListing.getQuantity().longValue()) {
/*  91 */           err.put(tradeShowDTO.getKey(), "必须要小于挂牌数量!");
/*     */         }
/*     */       }
/*  94 */       if (!ignoreList.contains(EnumPlaceOrderProperty.MIN_QUANTITY.getKey())) {
/*  95 */         TradeShowDTO tradeShowDTO = (TradeShowDTO)keyValueMap.get(EnumPlaceOrderProperty.MIN_QUANTITY.getKey());
/*     */ 
/*  97 */         if (StringUtil.isEmpty(tradeShowDTO.getInputValue())) {
/*  98 */           err.put(tradeShowDTO.getKey(), "此项为必填项!");
/*     */         }
/* 100 */         if (!FormatValidate.isValidInteger(tradeShowDTO.getInputValue())) {
/* 101 */           err.put(tradeShowDTO.getKey(), "请输入正确的数字!");
/*     */         }
/* 103 */         minQuantity = Integer.valueOf(tradeShowDTO.getInputValue()).intValue();
/* 104 */         if ((minQuantity > 0) && (multipleBase > 0) && (minQuantity % multipleBase != 0)) {
/* 105 */           err.put(tradeShowDTO.getKey(), "必须是下单基数的整数倍!");
/*     */         }
/* 107 */         if (minQuantity > projectListing.getQuantity().longValue()) {
/* 108 */           err.put(tradeShowDTO.getKey(), "必须要小于挂牌数量!");
/*     */         }
/*     */       }
/* 111 */       if (!ignoreList.contains(EnumPlaceOrderProperty.MAX_QUANTITY.getKey())) {
/* 112 */         TradeShowDTO tradeShowDTO = (TradeShowDTO)keyValueMap.get(EnumPlaceOrderProperty.MAX_QUANTITY.getKey());
/*     */ 
/* 114 */         if (StringUtil.isEmpty(tradeShowDTO.getInputValue())) {
/* 115 */           err.put(tradeShowDTO.getKey(), "此项为必填项!");
/*     */         }
/* 117 */         if (!FormatValidate.isValidInteger(tradeShowDTO.getInputValue())) {
/* 118 */           err.put(tradeShowDTO.getKey(), "请输入正确的数字!");
/*     */         }
/* 120 */         maxQuantity = Integer.valueOf(tradeShowDTO.getInputValue()).intValue();
/* 121 */         if ((maxQuantity > 0) && (multipleBase > 0) && (maxQuantity % multipleBase != 0)) {
/* 122 */           err.put(tradeShowDTO.getKey(), "必须是下单基数的整数倍!");
/*     */         }
/* 124 */         if (maxQuantity > projectListing.getQuantity().longValue())
/* 125 */           err.put(tradeShowDTO.getKey(), "必须要小于挂牌数量!");
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public HashMap<String, TradeShowDTO> getMapFromList(List<TradeShowDTO> tradeShowDTOList)
/*     */   {
/* 138 */     HashMap keyValueMap = new HashMap();
/* 139 */     if ((tradeShowDTOList != null) && (tradeShowDTOList.size() > 0)) {
/* 140 */       for (TradeShowDTO tradeShowDTO : tradeShowDTOList) {
/* 141 */         if (tradeShowDTO != null)
/* 142 */           keyValueMap.put(tradeShowDTO.getKey(), tradeShowDTO);
/*     */       }
/*     */     }
/* 145 */     return keyValueMap;
/*     */   }
/*     */ 
/*     */   public void bidOrderVadate(ProjectListing projectListing, ProjectTradeBO tradeBo, Map<String, String> err, List<String> ignoreList)
/*     */   {
/* 156 */     List tradeShowList = tradeBo.getTradeMetas();
/* 157 */     if ((tradeShowList != null) && (tradeShowList.size() > 0)) {
/* 158 */       HashMap keyValueMap = getMapFromList(tradeShowList);
/* 159 */       Date applyStartTime = new Date();
/* 160 */       Date applyEndTime = new Date();
/* 161 */       Date bidStartTime = new Date();
/* 162 */       Date listingStartTime = projectListing.getListingStartTime();
/* 163 */       Date listingEndTime = projectListing.getListingEndTime();
/* 164 */       if (!ignoreList.contains(EnumBidOrderProperty.HAVE_AUCTIONEER.getKey())) {
/* 165 */         TradeShowDTO tradeShowDTO = (TradeShowDTO)keyValueMap.get(EnumBidOrderProperty.HAVE_AUCTIONEER.getKey());
/*     */ 
/* 167 */         if (StringUtil.isEmpty(tradeShowDTO.getInputValue())) {
/* 168 */           err.put(tradeShowDTO.getKey(), "此项为必填项!");
/*     */         }
/*     */       }
/* 171 */       if (!ignoreList.contains(EnumBidOrderProperty.BID_START_PRICE.getKey())) {
/* 172 */         TradeShowDTO tradeShowDTO = (TradeShowDTO)keyValueMap.get(EnumBidOrderProperty.BID_START_PRICE.getKey());
/*     */ 
/* 174 */         if (StringUtil.isEmpty(tradeShowDTO.getInputValue())) {
/* 175 */           err.put(tradeShowDTO.getKey(), "此项为必填项!");
/*     */         }
/* 177 */         if (StringUtil.isNotEmpty(tradeShowDTO.getInputValue())) {
/* 178 */           if (!FormatValidate.isValidFloat(tradeShowDTO.getInputValue())) {
/* 179 */             if (!FormatValidate.isValidInteger(tradeShowDTO.getInputValue())) {
/* 180 */               err.put(tradeShowDTO.getKey(), "请入正确的起拍价格（最小单位精确到分）!");
/*     */             }
/*     */           }
/* 183 */           else if (!FormatValidate.isValidInteger(TradeMoneyUtil.getCentByValueUnit(tradeShowDTO.getInputValue(), projectListing.getValuationUnit()).toString()))
/*     */           {
/* 186 */             err.put(tradeShowDTO.getKey(), "请入正确的起拍价格（最小单位精确到分）!");
/*     */           }
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 192 */       if (!ignoreList.contains(EnumBidOrderProperty.PRICE_DIRECTION.getKey())) {
/* 193 */         TradeShowDTO tradeShowDTO = (TradeShowDTO)keyValueMap.get(EnumBidOrderProperty.PRICE_DIRECTION.getKey());
/*     */ 
/* 195 */         if (StringUtil.isEmpty(tradeShowDTO.getInputValue())) {
/* 196 */           err.put(tradeShowDTO.getKey(), "此项为必填项!");
/*     */         }
/*     */       }
/* 199 */       if (!ignoreList.contains(EnumBidOrderProperty.BID_RATE.getKey())) {
/* 200 */         TradeShowDTO tradeShowDTO = (TradeShowDTO)keyValueMap.get(EnumBidOrderProperty.BID_RATE.getKey());
/*     */ 
/* 204 */         if (StringUtil.isNotEmpty(tradeShowDTO.getInputValue())) {
/* 205 */           if (!FormatValidate.isValidFloat(tradeShowDTO.getInputValue())) {
/* 206 */             if (!FormatValidate.isValidInteger(tradeShowDTO.getInputValue())) {
/* 207 */               err.put(tradeShowDTO.getKey(), "请入正确的出价幅度（最小单位精确到分）! ");
/*     */             }
/*     */           }
/* 210 */           else if (!FormatValidate.isValidInteger(TradeMoneyUtil.getCentByValueUnit(tradeShowDTO.getInputValue(), projectListing.getValuationUnit()).toString()))
/*     */           {
/* 213 */             err.put(tradeShowDTO.getKey(), "请入正确的出价幅度（最小单位精确到分）! ");
/*     */           }
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 219 */       if (!ignoreList.contains(EnumBidOrderProperty.SUPPORT_PRIORITY.getKey())) {
/* 220 */         TradeShowDTO tradeShowDTO = (TradeShowDTO)keyValueMap.get(EnumBidOrderProperty.SUPPORT_PRIORITY.getKey());
/*     */ 
/* 222 */         if (StringUtil.isEmpty(tradeShowDTO.getInputValue())) {
/* 223 */           err.put(tradeShowDTO.getKey(), "此项为必填项!");
/*     */         }
/*     */       }
/* 226 */       if (!ignoreList.contains(EnumBidOrderProperty.BID_START_TIME)) {
/* 227 */         TradeShowDTO tradeShowDTO = (TradeShowDTO)keyValueMap.get(EnumBidOrderProperty.BID_START_TIME.getKey());
/*     */ 
/* 229 */         if (StringUtil.isEmpty(tradeShowDTO.getInputValue()))
/* 230 */           err.put(tradeShowDTO.getKey(), "此项为必填项!");
/*     */         try
/*     */         {
/* 233 */           bidStartTime = DateUtil.convertStringToDate("yyyy-MM-dd HH:mm:ss", ((TradeShowDTO)keyValueMap.get(EnumBidOrderProperty.BID_START_TIME.getKey())).getInputValue());
/*     */         }
/*     */         catch (ParseException e) {
/* 236 */           err.put(EnumBidOrderProperty.BID_START_TIME.getKey(), "日期格式错误!");
/*     */         }
/*     */       }
/*     */ 
/* 240 */       if (!ignoreList.contains(EnumBidOrderProperty.BID_LIMITED_PERIOD.getKey())) {
/* 241 */         TradeShowDTO tradeShowDTO = (TradeShowDTO)keyValueMap.get(EnumBidOrderProperty.BID_LIMITED_PERIOD.getKey());
/*     */ 
/* 243 */         if (StringUtil.isEmpty(tradeShowDTO.getInputValue())) {
/* 244 */           err.put(tradeShowDTO.getKey(), "此项为必填项!");
/*     */         }
/* 246 */         if (!FormatValidate.isValidInteger(tradeShowDTO.getInputValue())) {
/* 247 */           err.put(tradeShowDTO.getKey(), "必须为整数!");
/*     */         }
/*     */       }
/* 250 */       if (!ignoreList.contains(EnumBidOrderProperty.HAVE_RESERVE_PRICE.getKey())) {
/* 251 */         TradeShowDTO tradeShowDTO = (TradeShowDTO)keyValueMap.get(EnumBidOrderProperty.HAVE_RESERVE_PRICE.getKey());
/*     */ 
/* 253 */         if (StringUtil.isEmpty(tradeShowDTO.getInputValue())) {
/* 254 */           err.put(tradeShowDTO.getKey(), "此项为必填项!");
/*     */         }
/* 256 */         if ((StringUtil.isEmpty(tradeShowDTO.getInputValue())) && ("N".equals(((TradeShowDTO)keyValueMap.get(EnumBidOrderProperty.HAVE_AUCTIONEER.getKey())).getInputValue())))
/*     */         {
/* 259 */           err.put(tradeShowDTO.getKey(), "无拍卖师必须设置保留价!");
/*     */         }
/*     */       }
/* 262 */       if (!ignoreList.contains(EnumBidOrderProperty.RESERVE_PRICE.getKey())) {
/* 263 */         TradeShowDTO tradeShowDTO = (TradeShowDTO)keyValueMap.get(EnumBidOrderProperty.RESERVE_PRICE.getKey());
/*     */ 
/* 265 */         if ((StringUtil.isEmpty(tradeShowDTO.getInputValue())) && (StringUtil.isNotEmpty(((TradeShowDTO)keyValueMap.get(EnumBidOrderProperty.HAVE_RESERVE_PRICE.getKey())).getInputValue())) && ("Y".equals(((TradeShowDTO)keyValueMap.get(EnumBidOrderProperty.HAVE_RESERVE_PRICE.getKey())).getInputValue())))
/*     */         {
/* 270 */           err.put(tradeShowDTO.getKey(), "此项为必填项!");
/*     */         }
/* 272 */         if (StringUtil.isNotEmpty(tradeShowDTO.getInputValue())) {
/* 273 */           if (!FormatValidate.isValidFloat(tradeShowDTO.getInputValue())) {
/* 274 */             if (!FormatValidate.isValidInteger(tradeShowDTO.getInputValue())) {
/* 275 */               err.put(tradeShowDTO.getKey(), "请入正确的保留价格（最小单位精确到分）! ");
/*     */             }
/*     */           }
/* 278 */           else if (!FormatValidate.isValidInteger(TradeMoneyUtil.getCentByValueUnit(tradeShowDTO.getInputValue(), projectListing.getValuationUnit()).toString()))
/*     */           {
/* 281 */             err.put(tradeShowDTO.getKey(), "请入正确的保留价格（最小单位精确到分）! ");
/*     */           }
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 287 */       if (!ignoreList.contains(EnumBidOrderProperty.ALLOW_WATCH.getKey())) {
/* 288 */         TradeShowDTO tradeShowDTO = (TradeShowDTO)keyValueMap.get(EnumBidOrderProperty.ALLOW_WATCH.getKey());
/*     */ 
/* 290 */         if (StringUtil.isEmpty(tradeShowDTO.getInputValue())) {
/* 291 */           err.put(tradeShowDTO.getKey(), "此项为必填项!");
/*     */         }
/*     */       }
/* 294 */       if (!ignoreList.contains(EnumBidOrderProperty.WATCH_PASSWORD.getKey())) {
/* 295 */         TradeShowDTO tradeShowDTO = (TradeShowDTO)keyValueMap.get(EnumBidOrderProperty.WATCH_PASSWORD.getKey());
/*     */ 
/* 297 */         if (tradeShowDTO.getInputValue().length() > 16) {
/* 298 */           err.put(tradeShowDTO.getKey(), "观看码长度不能超过16字符长度!");
/*     */         }
/*     */       }
/* 301 */       if (!ignoreList.contains(EnumBidOrderProperty.APPLY_START_TIME.getKey())) {
/* 302 */         TradeShowDTO tradeShowDTO = (TradeShowDTO)keyValueMap.get(EnumBidOrderProperty.APPLY_START_TIME.getKey());
/*     */ 
/* 304 */         if (StringUtil.isEmpty(tradeShowDTO.getInputValue()))
/* 305 */           err.put(tradeShowDTO.getKey(), "此项为必填项!");
/*     */         try
/*     */         {
/* 308 */           applyStartTime = DateUtil.convertStringToDate("yyyy-MM-dd HH:mm:ss", tradeShowDTO.getInputValue());
/*     */         }
/*     */         catch (ParseException e) {
/* 311 */           err.put(EnumBidOrderProperty.APPLY_START_TIME.getKey(), "日期格式错误!");
/*     */         }
/*     */       }
/*     */ 
/* 315 */       if (!ignoreList.contains(EnumBidOrderProperty.APPLY_END_TIME.getKey())) {
/* 316 */         TradeShowDTO tradeShowDTO = (TradeShowDTO)keyValueMap.get(EnumBidOrderProperty.APPLY_END_TIME.getKey());
/*     */ 
/* 318 */         if (StringUtil.isEmpty(tradeShowDTO.getInputValue()))
/* 319 */           err.put(tradeShowDTO.getKey(), "此项为必填项!");
/*     */         try
/*     */         {
/* 322 */           applyEndTime = DateUtil.convertStringToDate("yyyy-MM-dd HH:mm:ss", tradeShowDTO.getInputValue());
/*     */         }
/*     */         catch (ParseException e) {
/* 325 */           err.put(EnumBidOrderProperty.APPLY_END_TIME.getKey(), "日期格式错误!");
/*     */         }
/*     */ 
/* 328 */         if (applyStartTime.after(applyEndTime)) {
/* 329 */           err.put(tradeShowDTO.getKey(), "必须要晚于报名开始时间!");
/*     */         }
/*     */ 
/* 332 */         if (applyEndTime.after(bidStartTime)) {
/* 333 */           err.put(tradeShowDTO.getKey(), "必须要早于竞价开始时间!");
/*     */         }
/*     */       }
/* 336 */       if (!ignoreList.contains(EnumBidOrderProperty.FIRST_WAIT_TIME.getKey())) {
/* 337 */         TradeShowDTO tradeShowDTO = (TradeShowDTO)keyValueMap.get("firstWaitTime");
/* 338 */         if (StringUtil.isEmpty(tradeShowDTO.getInputValue())) {
/* 339 */           err.put(tradeShowDTO.getKey(), "此项为必填项!");
/*     */         }
/* 341 */         if (!FormatValidate.isValidInteger(tradeShowDTO.getInputValue())) {
/* 342 */           err.put(tradeShowDTO.getKey(), "必须为整数!");
/*     */         }
/*     */       }
/* 345 */       if (!ignoreList.contains(EnumBidOrderProperty.HAVE_AUCTIONEER.getKey())) {
/* 346 */         TradeShowDTO tradeShowDTO = (TradeShowDTO)keyValueMap.get(EnumBidOrderProperty.HAVE_AUCTIONEER.getKey());
/*     */ 
/* 348 */         if ((StringUtil.isEmpty(tradeShowDTO.getInputValue())) && (StringUtil.isNotEmpty(((TradeShowDTO)keyValueMap.get(EnumBidOrderProperty.HAVE_AUCTIONEER.getKey())).getInputValue())) && ("Y".equals(((TradeShowDTO)keyValueMap.get(EnumBidOrderProperty.HAVE_AUCTIONEER.getKey())).getInputValue())))
/*     */         {
/* 353 */           err.put(tradeShowDTO.getKey(), "此项为必填项!");
/*     */         }
/*     */       }
/*     */ 
/* 357 */       if ((!applyStartTime.after(listingStartTime)) || (!applyStartTime.before(applyEndTime))) {
/* 358 */         err.put(EnumBidOrderProperty.APPLY_START_TIME.getKey(), "必须在挂牌开始时间之后,报名结束时间之前!");
/*     */       }
/* 360 */       if ((!applyEndTime.after(applyStartTime)) || (!applyEndTime.before(bidStartTime))) {
/* 361 */         err.put(EnumBidOrderProperty.APPLY_END_TIME.getKey(), "必须在报名开始时间之后,竞价开始时间之前!");
/*     */       }
/* 363 */       if ((!bidStartTime.after(listingStartTime)) || (!bidStartTime.before(listingEndTime)))
/* 364 */         err.put(EnumBidOrderProperty.BID_START_TIME.getKey(), "必须晚于挂牌开始且早于挂牌结束时间!");
/*     */     }
/*     */   }
/*     */ 
/*     */   public void transferOrderVadate(ProjectListing projectListing, ProjectTradeBO tradeBo, Map<String, String> err, List<String> ignoreList)
/*     */   {
/* 383 */     List tradeShowList = tradeBo.getTradeMetas();
/* 384 */     if ((tradeShowList != null) && (tradeShowList.size() > 0)) {
/* 385 */       HashMap keyValueMap = getMapFromList(tradeShowList);
/* 386 */       Date applyStartTime = new Date();
/* 387 */       Date applyEndTime = new Date();
/* 388 */       Date bidStartTime = new Date();
/* 389 */       Date listingStartTime = projectListing.getListingStartTime();
/* 390 */       Date listingEndTime = projectListing.getListingEndTime();
/* 391 */       if (!ignoreList.contains(EnumTransferOrderProperty.START_PRICE.getKey())) {
/* 392 */         TradeShowDTO tradeShowDTO = (TradeShowDTO)keyValueMap.get(EnumTransferOrderProperty.START_PRICE.getKey());
/* 393 */         if (StringUtil.isEmpty(tradeShowDTO.getInputValue())) {
/* 394 */           err.put(tradeShowDTO.getKey(), "此项为必填项!");
/*     */         }
/* 396 */         if (StringUtil.isNotEmpty(tradeShowDTO.getInputValue())) {
/* 397 */           if (!FormatValidate.isValidFloat(tradeShowDTO.getInputValue())) {
/* 398 */             if (!FormatValidate.isValidInteger(tradeShowDTO.getInputValue())) {
/* 399 */               err.put(tradeShowDTO.getKey(), "请入正确的转让价格（最小单位精确到分）!");
/*     */             }
/*     */           }
/* 402 */           else if (!FormatValidate.isValidInteger(TradeMoneyUtil.getCentByValueUnit(tradeShowDTO.getInputValue(), projectListing.getValuationUnit()).toString()))
/*     */           {
/* 405 */             err.put(tradeShowDTO.getKey(), "请入正确的转让价格（最小单位精确到分）!");
/*     */           }
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 411 */       if (!ignoreList.contains(EnumTransferOrderProperty.BID_START_TIME)) {
/* 412 */         TradeShowDTO tradeShowDTO = (TradeShowDTO)keyValueMap.get(EnumTransferOrderProperty.BID_START_TIME.getKey());
/*     */ 
/* 414 */         if (StringUtil.isEmpty(tradeShowDTO.getInputValue()))
/* 415 */           err.put(tradeShowDTO.getKey(), "此项为必填项!");
/*     */         try
/*     */         {
/* 418 */           bidStartTime = DateUtil.convertStringToDate("yyyy-MM-dd HH:mm:ss", ((TradeShowDTO)keyValueMap.get(EnumTransferOrderProperty.BID_START_TIME.getKey())).getInputValue());
/*     */         }
/*     */         catch (ParseException e) {
/* 421 */           err.put(EnumTransferOrderProperty.BID_START_TIME.getKey(), "日期格式错误!");
/*     */         }
/*     */       }
/* 424 */       if (!ignoreList.contains(EnumTransferOrderProperty.APPLY_START_TIME.getKey())) {
/* 425 */         TradeShowDTO tradeShowDTO = (TradeShowDTO)keyValueMap.get(EnumTransferOrderProperty.APPLY_START_TIME.getKey());
/*     */ 
/* 427 */         if (StringUtil.isEmpty(tradeShowDTO.getInputValue()))
/* 428 */           err.put(tradeShowDTO.getKey(), "此项为必填项!");
/*     */         try
/*     */         {
/* 431 */           applyStartTime = DateUtil.convertStringToDate("yyyy-MM-dd HH:mm:ss", tradeShowDTO.getInputValue());
/*     */         }
/*     */         catch (ParseException e) {
/* 434 */           err.put(EnumTransferOrderProperty.APPLY_START_TIME.getKey(), "日期格式错误!");
/*     */         }
/*     */       }
/*     */ 
/* 438 */       if (!ignoreList.contains(EnumTransferOrderProperty.APPLY_END_TIME.getKey())) {
/* 439 */         TradeShowDTO tradeShowDTO = (TradeShowDTO)keyValueMap.get(EnumTransferOrderProperty.APPLY_END_TIME.getKey());
/*     */ 
/* 441 */         if (StringUtil.isEmpty(tradeShowDTO.getInputValue()))
/* 442 */           err.put(tradeShowDTO.getKey(), "此项为必填项!");
/*     */         try
/*     */         {
/* 445 */           applyEndTime = DateUtil.convertStringToDate("yyyy-MM-dd HH:mm:ss", tradeShowDTO.getInputValue());
/*     */         }
/*     */         catch (ParseException e) {
/* 448 */           err.put(EnumTransferOrderProperty.APPLY_END_TIME.getKey(), "日期格式错误!");
/*     */         }
/* 450 */         if (applyStartTime.after(applyEndTime)) {
/* 451 */           err.put(tradeShowDTO.getKey(), "必须要晚于报名开始时间!");
/*     */         }
/* 453 */         if (applyEndTime.after(bidStartTime)) {
/* 454 */           err.put(tradeShowDTO.getKey(), "必须要早于协议转让开始时间!");
/*     */         }
/*     */       }
/*     */ 
/* 458 */       if ((!applyStartTime.after(listingStartTime)) || (!applyStartTime.before(applyEndTime))) {
/* 459 */         err.put(EnumTransferOrderProperty.APPLY_START_TIME.getKey(), "必须在挂牌开始时间之后,报名结束时间之前!");
/*     */       }
/* 461 */       if ((!applyEndTime.after(applyStartTime)) || (!applyEndTime.before(bidStartTime))) {
/* 462 */         err.put(EnumTransferOrderProperty.APPLY_END_TIME.getKey(), "必须在报名开始时间之后,协议转让开始时间之前!");
/*     */       }
/* 464 */       if ((!bidStartTime.after(listingStartTime)) || (!bidStartTime.before(listingEndTime)))
/* 465 */         err.put(EnumTransferOrderProperty.BID_START_TIME.getKey(), "必须晚于挂牌开始且早于挂牌结束时间!");
/*     */     }
/*     */   }
/*     */ 
/*     */   public void tenderOrderVadate(ProjectListing projectListing, ProjectTradeBO tradeBo, Map<String, String> err, List<String> ignoreList)
/*     */   {
/* 478 */     List tradeShowList = tradeBo.getTradeMetas();
/* 479 */     if ((tradeShowList != null) && (tradeShowList.size() > 0)) {
/* 480 */       HashMap keyValueMap = getMapFromList(tradeShowList);
/* 481 */       Date applyStartTime = new Date();
/* 482 */       Date applyEndTime = new Date();
/* 483 */       Date bidStartTime = new Date();
/* 484 */       Date listingStartTime = projectListing.getListingStartTime();
/* 485 */       Date listingEndTime = projectListing.getListingEndTime();
/* 486 */       if (!ignoreList.contains(EnumTenderOrderProperty.EVALUATION.getKey())) {
/* 487 */         TradeShowDTO tradeShowDTO = (TradeShowDTO)keyValueMap.get(EnumTenderOrderProperty.EVALUATION.getKey());
/* 488 */         if (StringUtil.isEmpty(tradeShowDTO.getInputValue())) {
/* 489 */           err.put(tradeShowDTO.getKey(), "此项为必填项!");
/*     */         }
/* 491 */         if (StringUtil.isNotEmpty(tradeShowDTO.getInputValue())) {
/* 492 */           if (!FormatValidate.isValidFloat(tradeShowDTO.getInputValue())) {
/* 493 */             if (!FormatValidate.isValidInteger(tradeShowDTO.getInputValue())) {
/* 494 */               err.put(tradeShowDTO.getKey(), "请入正确的评估价（最小单位精确到分）!");
/*     */             }
/*     */           }
/* 497 */           else if (!FormatValidate.isValidInteger(TradeMoneyUtil.getCentByValueUnit(tradeShowDTO.getInputValue(), projectListing.getValuationUnit()).toString()))
/*     */           {
/* 500 */             err.put(tradeShowDTO.getKey(), "请入正确的评估价（最小单位精确到分）!");
/*     */           }
/*     */         }
/*     */       }
/*     */ 
/* 505 */       if (!ignoreList.contains(EnumTransferOrderProperty.BID_START_TIME)) {
/* 506 */         TradeShowDTO tradeShowDTO = (TradeShowDTO)keyValueMap.get(EnumTransferOrderProperty.BID_START_TIME.getKey());
/*     */ 
/* 508 */         if (StringUtil.isEmpty(tradeShowDTO.getInputValue()))
/* 509 */           err.put(tradeShowDTO.getKey(), "此项为必填项!");
/*     */         try
/*     */         {
/* 512 */           bidStartTime = DateUtil.convertStringToDate("yyyy-MM-dd HH:mm:ss", ((TradeShowDTO)keyValueMap.get(EnumTransferOrderProperty.BID_START_TIME.getKey())).getInputValue());
/*     */         }
/*     */         catch (ParseException e) {
/* 515 */           err.put(EnumTransferOrderProperty.BID_START_TIME.getKey(), "日期格式错误!");
/*     */         }
/*     */       }
/* 518 */       if (!ignoreList.contains(EnumTenderOrderProperty.APPLY_START_TIME.getKey())) {
/* 519 */         TradeShowDTO tradeShowDTO = (TradeShowDTO)keyValueMap.get(EnumTenderOrderProperty.APPLY_START_TIME.getKey());
/*     */ 
/* 521 */         if (StringUtil.isEmpty(tradeShowDTO.getInputValue()))
/* 522 */           err.put(tradeShowDTO.getKey(), "此项为必填项!");
/*     */         try
/*     */         {
/* 525 */           applyStartTime = DateUtil.convertStringToDate("yyyy-MM-dd HH:mm:ss", tradeShowDTO.getInputValue());
/*     */         }
/*     */         catch (ParseException e) {
/* 528 */           err.put(EnumTenderOrderProperty.APPLY_START_TIME.getKey(), "日期格式错误!");
/*     */         }
/*     */       }
/*     */ 
/* 532 */       if (!ignoreList.contains(EnumTenderOrderProperty.APPLY_END_TIME.getKey())) {
/* 533 */         TradeShowDTO tradeShowDTO = (TradeShowDTO)keyValueMap.get(EnumTenderOrderProperty.APPLY_END_TIME.getKey());
/*     */ 
/* 535 */         if (StringUtil.isEmpty(tradeShowDTO.getInputValue()))
/* 536 */           err.put(tradeShowDTO.getKey(), "此项为必填项!");
/*     */         try
/*     */         {
/* 539 */           applyEndTime = DateUtil.convertStringToDate("yyyy-MM-dd HH:mm:ss", tradeShowDTO.getInputValue());
/*     */         }
/*     */         catch (ParseException e) {
/* 542 */           err.put(EnumTenderOrderProperty.APPLY_END_TIME.getKey(), "日期格式错误!");
/*     */         }
/*     */ 
/* 545 */         if (applyStartTime.after(applyEndTime)) {
/* 546 */           err.put(tradeShowDTO.getKey(), "必须要晚于报名开始时间!");
/*     */         }
/* 548 */         if (applyEndTime.after(bidStartTime)) {
/* 549 */           err.put(tradeShowDTO.getKey(), "必须要早于协议转让开始时间!");
/*     */         }
/*     */       }
/*     */ 
/* 553 */       if ((!applyStartTime.after(listingStartTime)) || (!applyStartTime.before(applyEndTime))) {
/* 554 */         err.put(EnumTenderOrderProperty.APPLY_START_TIME.getKey(), "必须在挂牌开始时间之后,报名结束时间之前!");
/*     */       }
/* 556 */       if ((!applyStartTime.after(listingStartTime)) || (!applyStartTime.before(applyEndTime))) {
/* 557 */         err.put(EnumTenderOrderProperty.APPLY_START_TIME.getKey(), "必须在挂牌开始时间之后,报名结束时间之前!");
/*     */       }
/* 559 */       if ((!applyEndTime.after(applyStartTime)) || (!applyEndTime.before(bidStartTime))) {
/* 560 */         err.put(EnumTenderOrderProperty.APPLY_END_TIME.getKey(), "必须在报名开始时间之后,招标转让开始时间之前!");
/*     */       }
/* 562 */       if ((!bidStartTime.after(listingStartTime)) || (!bidStartTime.before(listingEndTime)))
/* 563 */         err.put(EnumTenderOrderProperty.BID_START_TIME.getKey(), "必须晚于挂牌开始且早于挂牌结束时间!");
/*     */     }
/*     */   }
/*     */ 
/*     */   public void commonValidate(ProjectListing project, Errors err)
/*     */   {
/* 576 */     String measureUnit = project.getMeasureUnit();
/* 577 */     if (EnumMeasureUnit.indexByValue(measureUnit) == null) {
/* 578 */       err.rejectValue("measureUnit", null, null, "无此计量单位");
/*     */     }
/*     */ 
/* 582 */     EnumValuationUnit valuationUnit = EnumValuationUnit.indexByValue(project.getValuationUnit());
/*     */ 
/* 584 */     if (valuationUnit == null) {
/* 585 */       err.rejectValue("valuationUnit", null, null, "无此计价单位");
/*     */     }
/*     */ 
/* 589 */     Long maxPrice = Long.valueOf(99999999999999999L);
/*     */ 
/* 591 */     String listingPriceDesc = project.getListingPriceDesc();
/* 592 */     if ((StringUtil.isNotEmpty(listingPriceDesc)) && (valuationUnit != null)) {
/* 593 */       if ((!FormatValidate.isValidFloat(listingPriceDesc)) && (!FormatValidate.isValidInteger(listingPriceDesc)))
/*     */       {
/* 595 */         err.rejectValue("listingPrice", null, null, "请输入正确的挂牌价格!");
/*     */       }
/* 597 */       BigDecimal gb = new BigDecimal(listingPriceDesc);
/* 598 */       Long listingPriceConvert2Fen = Long.valueOf(0L);
/* 599 */       listingPriceConvert2Fen = Long.valueOf(gb.movePointRight(valuationUnit.getScale()).longValue());
/* 600 */       if (listingPriceConvert2Fen.longValue() > maxPrice.longValue()) {
/* 601 */         err.rejectValue("listingPrice", null, null, "挂牌价格 不能超过9999999" + EnumValuationUnit.YIYUAN.getName());
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 606 */     String deliveryType = project.getDeliveryType();
/* 607 */     for (String dt : deliveryType.split(",")) {
/* 608 */       if ((StringUtil.isNotEmpty(dt)) && (EnumDeliveryType.indexByValue(dt) == null)) {
/* 609 */         err.rejectValue("deliveryType", null, null, "无此交货方式");
/* 610 */         break;
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 615 */     String paymentType = project.getPaymentType();
/* 616 */     for (String pt : paymentType.split(",")) {
/* 617 */       if ((StringUtil.isNotEmpty(pt)) && (EnumPaymentType.indexByValue(pt) == null)) {
/* 618 */         err.rejectValue("paymentType", null, null, "无此货款支付方式");
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 623 */     String invoice = project.getInvoice();
/* 624 */     for (String in : invoice.split(",")) {
/* 625 */       if ((StringUtil.isNotEmpty(in)) && (EnumInvoice.indexByValue(in) == null)) {
/* 626 */         err.rejectValue("invoice", null, null, "请输入正确的值");
/*     */       }
/*     */     }
/*     */ 
/* 630 */     Date listingStartTime = project.getListingStartTime();
/* 631 */     Date listingEndTime = project.getListingEndTime();
/*     */ 
/* 634 */     if (!listingEndTime.after(listingStartTime)) {
/* 635 */       err.rejectValue("listingEndTime", null, null, "挂牌结束时间 要晚于挂牌开始时间");
/*     */     }
/*     */ 
/* 639 */     if (!listingEndTime.after(new Date()))
/* 640 */       err.rejectValue("listingEndTime", null, null, "挂牌结束时间 要晚于当前时间");
/*     */   }
/*     */ 
/*     */   public void dynamicValidate(ProjectListing project, Map<String, String> err, ProjectListing regexPro)
/*     */   {
/* 648 */     if ((StringUtil.isBlank(project.getBreedStandard())) && (project.getMetaValues() != null) && (project.getMetaValues().length > 0))
/*     */     {
/* 651 */       Map attriMap = regexPro.getAttriMap();
/* 652 */       ProjectMetas[] metas = project.getMetaValues();
/* 653 */       if ((metas != null) && (metas.length > 0))
/*     */       {
/*     */         ProjectMetas meta;
/* 654 */         for (int index = 0; index < metas.length; index++) {
/* 655 */           meta = metas[index];
/* 656 */           if (meta == null)
/*     */             continue;
/* 658 */           ProjectTypeAttri regexAttri = (ProjectTypeAttri)attriMap.get(meta.getMetaKey());
/* 659 */           if (regexAttri == null)
/*     */             continue;
/* 661 */           if ((regexAttri.getIsRequired().shortValue() == 1) && (StringUtil.isBlank(meta.getMetaValue()))) {
/* 662 */             err.put("" + index, meta.getMetaTitle() + " 为必填项");
/*     */           }
/*     */           else
/*     */           {
/* 671 */             boolean needText = (EnumProTypeAttriInputType.SELECT.getValue().equals(regexAttri.getInputType())) || (EnumProTypeAttriInputType.CHECKBOX.getValue().equals(regexAttri.getInputType())) || (EnumProTypeAttriInputType.RADIO.getValue().equals(regexAttri.getInputType()));
/*     */ 
/* 677 */             String regex = regexAttri.getValueValidate();
/* 678 */             if ((meta.getMetaValue() != null) && (meta.getMetaValue().length() > 0)) {
/* 679 */               for (String metaValue : meta.getMetaValue().split(",")) {
/* 680 */                 boolean bValue = false;
/* 681 */                 if ((needText) && (regexAttri.getText().indexOf(metaValue) < 0)) {
/* 682 */                   err.put("" + index, "无此 " + meta.getMetaTitle());
/* 683 */                   bValue = true;
/*     */                 }
/* 685 */                 if ((regex != null) && (!regex.matches(metaValue))) {
/* 686 */                   err.put("" + index, "与验证值不匹配 ");
/* 687 */                   bValue = true;
/*     */                 }
/* 689 */                 if (bValue)
/*     */                 {
/*     */                   break;
/*     */                 }
/*     */               }
/*     */             }
/* 695 */             List<AttriMeta> attriMetaNow = regexPro.getAttriMeta();
/* 696 */             for (AttriMeta attriMeta : attriMetaNow)
/*     */             {
/* 699 */               if (attriMeta.getAttr().getKeyName().equals(meta.getMetaKey()))
/* 700 */                 attriMeta.getMeta().setMetaValue(meta.getMetaValue());
/*     */             }
/*     */           }
/*     */         }
/*     */       } else {
/* 705 */         this.log.error("====================edit projectLisint validate   动态属性列表为空！");
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public void dynamicValidate(ProjectListing project, Map<String, String> err, List<ProjectTypeAttri> projectTypeAttriList)
/*     */   {
/* 718 */     if ((StringUtil.isBlank(project.getBreedStandard())) && (project.getMetaValues() != null) && (project.getMetaValues().length > 0))
/*     */     {
/* 720 */       HashMap attriMap = new HashMap();
/* 721 */       ProjectCopyUtil.convertProjectTypeAttrList2Map(projectTypeAttriList, attriMap);
/* 722 */       ProjectMetas[] metas = project.getMetaValues();
/* 723 */       if ((metas != null) && (metas.length > 0)) {
/* 724 */         for (int index = 0; index < metas.length; index++) {
/* 725 */           ProjectMetas meta = metas[index];
/* 726 */           if (meta == null)
/*     */             continue;
/* 728 */           ProjectTypeAttri regexAttri = (ProjectTypeAttri)attriMap.get(meta.getMetaKey());
/* 729 */           if (regexAttri == null)
/*     */             continue;
/* 731 */           if ((regexAttri.getIsRequired().shortValue() == 1) && (StringUtil.isBlank(meta.getMetaValue()))) {
/* 732 */             err.put("" + index, meta.getMetaTitle() + " 为必填项");
/*     */           }
/*     */           else
/*     */           {
/* 741 */             boolean needText = (EnumProTypeAttriInputType.SELECT.getValue().equals(regexAttri.getInputType())) || (EnumProTypeAttriInputType.CHECKBOX.getValue().equals(regexAttri.getInputType())) || (EnumProTypeAttriInputType.RADIO.getValue().equals(regexAttri.getInputType()));
/*     */ 
/* 747 */             String regex = regexAttri.getValueValidate();
/* 748 */             if ((meta.getMetaValue() != null) && (meta.getMetaValue().length() > 0)) {
/* 749 */               for (String metaValue : meta.getMetaValue().split(",")) {
/* 750 */                 boolean bValue = false;
/* 751 */                 if ((needText) && (regexAttri.getText().indexOf(metaValue) < 0)) {
/* 752 */                   err.put("" + index, "无此 " + meta.getMetaTitle());
/* 753 */                   bValue = true;
/*     */                 }
/* 755 */                 if ((regex != null) && (!regex.matches(metaValue))) {
/* 756 */                   err.put("" + index, "与验证值不匹配 ");
/* 757 */                   bValue = true;
/*     */                 }
/* 759 */                 if (bValue)
/*     */                 {
/*     */                   break;
/*     */                 }
/*     */               }
/*     */ 
/*     */             }
/*     */ 
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 774 */         this.log.error("====================edit projectLisint validate   动态属性列表为空！");
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public void validateFile(MultipartFile file, Map<String, String> metaErrors)
/*     */   {
/* 784 */     if ((file != null) && (!file.isEmpty()) && (file.getSize() > 0L)) {
/* 785 */       FileUploadUtil.MAX_FILE_SIZE = 204800;
/* 786 */       if (!FileUploadUtil.ifFileSizePermitted(file)) {
/* 787 */         metaErrors.put("fileErrorDiv", "上传的图片的大小不能超过200K!");
/*     */       }
/* 789 */       if (!FileUploadUtil.ifExtendNamePermitted(file))
/* 790 */         metaErrors.put("fileErrorDiv", "仅仅支持jpg,jpeg,gif,png的图片上传!");
/*     */     }
/*     */   }
/*     */ 
/*     */   public void validateAttachedFile(MultipartFile file, Map<String, String> metaErrors)
/*     */   {
/* 801 */     if ((file != null) && (!file.isEmpty()) && (file.getSize() > 0L)) {
/* 802 */       FileUploadUtil.MAX_FILE_SIZE = 5242880;
/* 803 */       if (!FileUploadUtil.ifFileSizePermitted(file))
/* 804 */         metaErrors.put("attachedFile", "附件最大支持5M!");
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.web.validator.project.ProEditValidator
 * JD-Core Version:    0.6.0
 */