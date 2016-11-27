/*     */ package com.hundsun.network.gates.genshan.web.validator;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.domain.project.AttriMeta;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectListing;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectMetas;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectTradeBO;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectTypeAttri;
/*     */ import com.hundsun.network.gates.genshan.common.FileUploadUtil;
/*     */ import com.hundsun.network.gates.genshan.web.util.ProjectCopyUtil;
/*     */ import com.hundsun.network.gates.genshan.web.util.TradeMoneyUtil;
/*     */ import com.hundsun.network.gates.luosi.biz.domain.TradeShowDTO;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumBidOrderProperty;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumDeliveryType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumInvoice;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumMeasureUnit;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumMulitBidOrderProperty;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumPaymentType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumPlaceOrderProperty;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumProTypeAttriInputType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTenderOrderProperty;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradingType;
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
/*  44 */   protected final Log log = LogFactory.getLog(getClass());
/*     */ 
/*     */   public void validate(Object obj, Errors err)
/*     */   {
/*  48 */     Assert.notNull(obj);
/*  49 */     Assert.isInstanceOf(ProjectListing.class, obj);
/*  50 */     super.validate(obj, err);
/*  51 */     ProjectListing projectListing = (ProjectListing)obj;
/*  52 */     commonValidate(projectListing, err);
/*     */   }
/*     */ 
/*     */   public void placeOrderVadate(ProjectListing projectListing, ProjectTradeBO tradeBo, Map<String, String> err, List<String> ignoreList)
/*     */   {
/*  63 */     List tradeShowList = tradeBo.getTradeMetas();
/*  64 */     if ((tradeShowList != null) && (tradeShowList.size() > 0)) {
/*  65 */       int maxQuantity = 0;
/*  66 */       int minQuantity = 0;
/*  67 */       int multipleBase = 0;
/*  68 */       HashMap keyValueMap = getMapFromList(tradeShowList);
/*  69 */       if (!ignoreList.contains(EnumPlaceOrderProperty.RETAIL.getKey())) {
/*  70 */         TradeShowDTO tradeShowDTO = (TradeShowDTO)keyValueMap.get(EnumPlaceOrderProperty.RETAIL.getKey());
/*  71 */         if (StringUtil.isEmpty(tradeShowDTO.getInputValue())) {
/*  72 */           err.put(tradeShowDTO.getKey(), "此项为必填项!");
/*     */         }
/*     */       }
/*  75 */       if (!ignoreList.contains(EnumPlaceOrderProperty.MULTIPLE_BASE.getKey())) {
/*  76 */         TradeShowDTO tradeShowDTO = (TradeShowDTO)keyValueMap.get(EnumPlaceOrderProperty.MULTIPLE_BASE.getKey());
/*     */ 
/*  79 */         if (StringUtil.isEmpty(tradeShowDTO.getInputValue())) {
/*  80 */           err.put(tradeShowDTO.getKey(), "此项为必填项!");
/*     */         }
/*  82 */         if (!FormatValidate.isValidInteger(tradeShowDTO.getInputValue())) {
/*  83 */           err.put(tradeShowDTO.getKey(), "请输入正确的数字!");
/*     */         }
/*  85 */         multipleBase = Integer.valueOf(tradeShowDTO.getInputValue()).intValue();
/*  86 */         if (projectListing.getQuantity().longValue() % multipleBase != 0L) {
/*  87 */           err.put(tradeShowDTO.getKey(), "下单数量必须是下单基数的整数倍!");
/*     */         }
/*  89 */         if (multipleBase > projectListing.getQuantity().longValue()) {
/*  90 */           err.put(tradeShowDTO.getKey(), "必须要小于挂牌数量!");
/*     */         }
/*     */       }
/*  93 */       if (!ignoreList.contains(EnumPlaceOrderProperty.MIN_QUANTITY.getKey())) {
/*  94 */         TradeShowDTO tradeShowDTO = (TradeShowDTO)keyValueMap.get(EnumPlaceOrderProperty.MIN_QUANTITY.getKey());
/*     */ 
/*  96 */         if (StringUtil.isEmpty(tradeShowDTO.getInputValue())) {
/*  97 */           err.put(tradeShowDTO.getKey(), "此项为必填项!");
/*     */         }
/*  99 */         if (!FormatValidate.isValidInteger(tradeShowDTO.getInputValue())) {
/* 100 */           err.put(tradeShowDTO.getKey(), "请输入正确的数字!");
/*     */         }
/* 102 */         minQuantity = Integer.valueOf(tradeShowDTO.getInputValue()).intValue();
/* 103 */         if ((minQuantity > 0) && (multipleBase > 0) && (minQuantity % multipleBase != 0)) {
/* 104 */           err.put(tradeShowDTO.getKey(), "必须是下单基数的整数倍!");
/*     */         }
/* 106 */         if (minQuantity > projectListing.getQuantity().longValue()) {
/* 107 */           err.put(tradeShowDTO.getKey(), "必须要小于挂牌数量!");
/*     */         }
/*     */       }
/* 110 */       if (!ignoreList.contains(EnumPlaceOrderProperty.MAX_QUANTITY.getKey())) {
/* 111 */         TradeShowDTO tradeShowDTO = (TradeShowDTO)keyValueMap.get(EnumPlaceOrderProperty.MAX_QUANTITY.getKey());
/*     */ 
/* 113 */         if (StringUtil.isEmpty(tradeShowDTO.getInputValue())) {
/* 114 */           err.put(tradeShowDTO.getKey(), "此项为必填项!");
/*     */         }
/* 116 */         if (!FormatValidate.isValidInteger(tradeShowDTO.getInputValue())) {
/* 117 */           err.put(tradeShowDTO.getKey(), "请输入正确的数字!");
/*     */         }
/* 119 */         maxQuantity = Integer.valueOf(tradeShowDTO.getInputValue()).intValue();
/* 120 */         if ((maxQuantity > 0) && (multipleBase > 0) && (maxQuantity % multipleBase != 0)) {
/* 121 */           err.put(tradeShowDTO.getKey(), "必须是下单基数的整数倍!");
/*     */         }
/* 123 */         if (maxQuantity > projectListing.getQuantity().longValue())
/* 124 */           err.put(tradeShowDTO.getKey(), "必须要小于挂牌数量!");
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public HashMap<String, TradeShowDTO> getMapFromList(List<TradeShowDTO> tradeShowDTOList)
/*     */   {
/* 137 */     HashMap keyValueMap = new HashMap();
/* 138 */     if ((tradeShowDTOList != null) && (tradeShowDTOList.size() > 0)) {
/* 139 */       for (TradeShowDTO tradeShowDTO : tradeShowDTOList) {
/* 140 */         if (tradeShowDTO != null)
/* 141 */           keyValueMap.put(tradeShowDTO.getKey(), tradeShowDTO);
/*     */       }
/*     */     }
/* 144 */     return keyValueMap;
/*     */   }
/*     */ 
/*     */   public void bidOrderVadate(ProjectListing projectListing, ProjectTradeBO tradeBo, Map<String, String> err, List<String> ignoreList)
/*     */   {
/* 155 */     List tradeShowList = tradeBo.getTradeMetas();
/* 156 */     if ((tradeShowList != null) && (tradeShowList.size() > 0)) {
/* 157 */       HashMap keyValueMap = getMapFromList(tradeShowList);
/* 158 */       Date applyStartTime = new Date();
/* 159 */       Date applyEndTime = new Date();
/* 160 */       Date bidStartTime = new Date();
/* 161 */       Date listingStartTime = projectListing.getListingStartTime();
/* 162 */       Date listingEndTime = projectListing.getListingEndTime();
/* 163 */       if (!ignoreList.contains(EnumBidOrderProperty.HAVE_AUCTIONEER.getKey())) {
/* 164 */         TradeShowDTO tradeShowDTO = (TradeShowDTO)keyValueMap.get(EnumBidOrderProperty.HAVE_AUCTIONEER.getKey());
/*     */ 
/* 166 */         if (StringUtil.isEmpty(tradeShowDTO.getInputValue())) {
/* 167 */           err.put(tradeShowDTO.getKey(), "此项为必填项!");
/*     */         }
/*     */       }
/* 170 */       if (!ignoreList.contains(EnumBidOrderProperty.BID_START_PRICE.getKey())) {
/* 171 */         TradeShowDTO tradeShowDTO = (TradeShowDTO)keyValueMap.get(EnumBidOrderProperty.BID_START_PRICE.getKey());
/*     */ 
/* 173 */         if (StringUtil.isEmpty(tradeShowDTO.getInputValue())) {
/* 174 */           err.put(tradeShowDTO.getKey(), "此项为必填项!");
/*     */         }
/* 176 */         if (StringUtil.isNotEmpty(tradeShowDTO.getInputValue())) {
/* 177 */           if (!FormatValidate.isValidFloat(tradeShowDTO.getInputValue())) {
/* 178 */             if (!FormatValidate.isValidInteger(tradeShowDTO.getInputValue())) {
/* 179 */               err.put(tradeShowDTO.getKey(), "请入正确的起拍价格（最小单位精确到分）!");
/*     */             }
/*     */           }
/* 182 */           else if (!FormatValidate.isValidInteger(TradeMoneyUtil.getCentByValueUnit(tradeShowDTO.getInputValue(), projectListing.getValuationUnit()).toString()))
/*     */           {
/* 185 */             err.put(tradeShowDTO.getKey(), "请入正确的起拍价格（最小单位精确到分）!");
/*     */           }
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 191 */       if (!ignoreList.contains(EnumBidOrderProperty.PRICE_DIRECTION.getKey())) {
/* 192 */         TradeShowDTO tradeShowDTO = (TradeShowDTO)keyValueMap.get(EnumBidOrderProperty.PRICE_DIRECTION.getKey());
/*     */ 
/* 194 */         if (StringUtil.isEmpty(tradeShowDTO.getInputValue())) {
/* 195 */           err.put(tradeShowDTO.getKey(), "此项为必填项!");
/*     */         }
/*     */       }
/* 198 */       if (!ignoreList.contains(EnumBidOrderProperty.BID_RATE.getKey())) {
/* 199 */         TradeShowDTO tradeShowDTO = (TradeShowDTO)keyValueMap.get(EnumBidOrderProperty.BID_RATE.getKey());
/*     */ 
/* 203 */         if (StringUtil.isNotEmpty(tradeShowDTO.getInputValue())) {
/* 204 */           if (!FormatValidate.isValidFloat(tradeShowDTO.getInputValue())) {
/* 205 */             if (!FormatValidate.isValidInteger(tradeShowDTO.getInputValue())) {
/* 206 */               err.put(tradeShowDTO.getKey(), "请入正确的出价幅度（最小单位精确到分）! ");
/*     */             }
/*     */           }
/* 209 */           else if (!FormatValidate.isValidInteger(TradeMoneyUtil.getCentByValueUnit(tradeShowDTO.getInputValue(), projectListing.getValuationUnit()).toString()))
/*     */           {
/* 212 */             err.put(tradeShowDTO.getKey(), "请入正确的出价幅度（最小单位精确到分）! ");
/*     */           }
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 218 */       if (!ignoreList.contains(EnumBidOrderProperty.SUPPORT_PRIORITY.getKey())) {
/* 219 */         TradeShowDTO tradeShowDTO = (TradeShowDTO)keyValueMap.get(EnumBidOrderProperty.SUPPORT_PRIORITY.getKey());
/*     */ 
/* 221 */         if (StringUtil.isEmpty(tradeShowDTO.getInputValue())) {
/* 222 */           err.put(tradeShowDTO.getKey(), "此项为必填项!");
/*     */         }
/*     */       }
/* 225 */       if (!ignoreList.contains(EnumBidOrderProperty.BID_START_TIME)) {
/* 226 */         TradeShowDTO tradeShowDTO = (TradeShowDTO)keyValueMap.get(EnumBidOrderProperty.BID_START_TIME.getKey());
/*     */ 
/* 228 */         if (StringUtil.isEmpty(tradeShowDTO.getInputValue()))
/* 229 */           err.put(tradeShowDTO.getKey(), "此项为必填项!");
/*     */         try
/*     */         {
/* 232 */           bidStartTime = DateUtil.convertStringToDate("yyyy-MM-dd HH:mm:ss", ((TradeShowDTO)keyValueMap.get(EnumBidOrderProperty.BID_START_TIME.getKey())).getInputValue());
/*     */         }
/*     */         catch (ParseException e) {
/* 235 */           err.put(EnumBidOrderProperty.BID_START_TIME.getKey(), "日期格式错误!");
/*     */         }
/*     */       }
/*     */ 
/* 239 */       if (!ignoreList.contains(EnumBidOrderProperty.BID_LIMITED_PERIOD.getKey())) {
/* 240 */         TradeShowDTO tradeShowDTO = (TradeShowDTO)keyValueMap.get(EnumBidOrderProperty.BID_LIMITED_PERIOD.getKey());
/*     */ 
/* 242 */         if (StringUtil.isEmpty(tradeShowDTO.getInputValue())) {
/* 243 */           err.put(tradeShowDTO.getKey(), "此项为必填项!");
/*     */         }
/* 245 */         if (!FormatValidate.isValidInteger(tradeShowDTO.getInputValue())) {
/* 246 */           err.put(tradeShowDTO.getKey(), "必须为整数!");
/*     */         }
/*     */       }
/* 249 */       if (!ignoreList.contains(EnumBidOrderProperty.HAVE_RESERVE_PRICE.getKey())) {
/* 250 */         TradeShowDTO tradeShowDTO = (TradeShowDTO)keyValueMap.get(EnumBidOrderProperty.HAVE_RESERVE_PRICE.getKey());
/*     */ 
/* 252 */         if (StringUtil.isEmpty(tradeShowDTO.getInputValue())) {
/* 253 */           err.put(tradeShowDTO.getKey(), "此项为必填项!");
/*     */         }
/* 255 */         if ((StringUtil.isEmpty(tradeShowDTO.getInputValue())) && ("N".equals(((TradeShowDTO)keyValueMap.get(EnumBidOrderProperty.HAVE_AUCTIONEER.getKey())).getInputValue())))
/*     */         {
/* 258 */           err.put(tradeShowDTO.getKey(), "无拍卖师必须设置保留价!");
/*     */         }
/*     */       }
/* 261 */       if (!ignoreList.contains(EnumBidOrderProperty.RESERVE_PRICE.getKey())) {
/* 262 */         TradeShowDTO tradeShowDTO = (TradeShowDTO)keyValueMap.get(EnumBidOrderProperty.RESERVE_PRICE.getKey());
/*     */ 
/* 264 */         if ((StringUtil.isEmpty(tradeShowDTO.getInputValue())) && (StringUtil.isNotEmpty(((TradeShowDTO)keyValueMap.get(EnumBidOrderProperty.HAVE_RESERVE_PRICE.getKey())).getInputValue())) && ("Y".equals(((TradeShowDTO)keyValueMap.get(EnumBidOrderProperty.HAVE_RESERVE_PRICE.getKey())).getInputValue())))
/*     */         {
/* 269 */           err.put(tradeShowDTO.getKey(), "此项为必填项!");
/*     */         }
/* 271 */         if (StringUtil.isNotEmpty(tradeShowDTO.getInputValue())) {
/* 272 */           if (!FormatValidate.isValidFloat(tradeShowDTO.getInputValue())) {
/* 273 */             if (!FormatValidate.isValidInteger(tradeShowDTO.getInputValue())) {
/* 274 */               err.put(tradeShowDTO.getKey(), "请入正确的保留价格（最小单位精确到分）! ");
/*     */             }
/*     */           }
/* 277 */           else if (!FormatValidate.isValidInteger(TradeMoneyUtil.getCentByValueUnit(tradeShowDTO.getInputValue(), projectListing.getValuationUnit()).toString()))
/*     */           {
/* 280 */             err.put(tradeShowDTO.getKey(), "请入正确的保留价格（最小单位精确到分）! ");
/*     */           }
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 286 */       if (!ignoreList.contains(EnumBidOrderProperty.ALLOW_WATCH.getKey())) {
/* 287 */         TradeShowDTO tradeShowDTO = (TradeShowDTO)keyValueMap.get(EnumBidOrderProperty.ALLOW_WATCH.getKey());
/*     */ 
/* 289 */         if (StringUtil.isEmpty(tradeShowDTO.getInputValue())) {
/* 290 */           err.put(tradeShowDTO.getKey(), "此项为必填项!");
/*     */         }
/*     */       }
/* 293 */       if (!ignoreList.contains(EnumBidOrderProperty.WATCH_PASSWORD.getKey())) {
/* 294 */         TradeShowDTO tradeShowDTO = (TradeShowDTO)keyValueMap.get(EnumBidOrderProperty.WATCH_PASSWORD.getKey());
/*     */ 
/* 296 */         if (tradeShowDTO.getInputValue().length() > 16) {
/* 297 */           err.put(tradeShowDTO.getKey(), "观看码长度不能超过16字符长度!");
/*     */         }
/*     */       }
/* 300 */       if (!ignoreList.contains(EnumBidOrderProperty.APPLY_START_TIME.getKey())) {
/* 301 */         TradeShowDTO tradeShowDTO = (TradeShowDTO)keyValueMap.get(EnumBidOrderProperty.APPLY_START_TIME.getKey());
/*     */ 
/* 303 */         if (StringUtil.isEmpty(tradeShowDTO.getInputValue()))
/* 304 */           err.put(tradeShowDTO.getKey(), "此项为必填项!");
/*     */         try
/*     */         {
/* 307 */           applyStartTime = DateUtil.convertStringToDate("yyyy-MM-dd HH:mm:ss", tradeShowDTO.getInputValue());
/*     */         }
/*     */         catch (ParseException e) {
/* 310 */           err.put(EnumBidOrderProperty.APPLY_START_TIME.getKey(), "日期格式错误!");
/*     */         }
/*     */       }
/*     */ 
/* 314 */       if (!ignoreList.contains(EnumBidOrderProperty.APPLY_END_TIME.getKey())) {
/* 315 */         TradeShowDTO tradeShowDTO = (TradeShowDTO)keyValueMap.get(EnumBidOrderProperty.APPLY_END_TIME.getKey());
/*     */ 
/* 317 */         if (StringUtil.isEmpty(tradeShowDTO.getInputValue()))
/* 318 */           err.put(tradeShowDTO.getKey(), "此项为必填项!");
/*     */         try
/*     */         {
/* 321 */           applyEndTime = DateUtil.convertStringToDate("yyyy-MM-dd HH:mm:ss", tradeShowDTO.getInputValue());
/*     */         }
/*     */         catch (ParseException e) {
/* 324 */           err.put(EnumBidOrderProperty.APPLY_END_TIME.getKey(), "日期格式错误!");
/*     */         }
/*     */ 
/* 327 */         if (applyStartTime.after(applyEndTime)) {
/* 328 */           err.put(tradeShowDTO.getKey(), "必须要晚于报名开始时间!");
/*     */         }
/*     */ 
/* 331 */         if (applyEndTime.after(bidStartTime)) {
/* 332 */           err.put(tradeShowDTO.getKey(), "必须要早于竞价开始时间!");
/*     */         }
/*     */       }
/* 335 */       if (!ignoreList.contains(EnumBidOrderProperty.FIRST_WAIT_TIME.getKey())) {
/* 336 */         TradeShowDTO tradeShowDTO = (TradeShowDTO)keyValueMap.get("firstWaitTime");
/* 337 */         if (StringUtil.isEmpty(tradeShowDTO.getInputValue())) {
/* 338 */           err.put(tradeShowDTO.getKey(), "此项为必填项!");
/*     */         }
/* 340 */         if (!FormatValidate.isValidInteger(tradeShowDTO.getInputValue())) {
/* 341 */           err.put(tradeShowDTO.getKey(), "必须为整数!");
/*     */         }
/*     */       }
/* 344 */       if (!ignoreList.contains(EnumBidOrderProperty.HAVE_AUCTIONEER.getKey())) {
/* 345 */         TradeShowDTO tradeShowDTO = (TradeShowDTO)keyValueMap.get(EnumBidOrderProperty.HAVE_AUCTIONEER.getKey());
/*     */ 
/* 347 */         if ((StringUtil.isEmpty(tradeShowDTO.getInputValue())) && (StringUtil.isNotEmpty(((TradeShowDTO)keyValueMap.get(EnumBidOrderProperty.HAVE_AUCTIONEER.getKey())).getInputValue())) && ("Y".equals(((TradeShowDTO)keyValueMap.get(EnumBidOrderProperty.HAVE_AUCTIONEER.getKey())).getInputValue())))
/*     */         {
/* 352 */           err.put(tradeShowDTO.getKey(), "此项为必填项!");
/*     */         }
/*     */       }
/*     */ 
/* 356 */       if ((!applyStartTime.after(listingStartTime)) || (!applyStartTime.before(applyEndTime))) {
/* 357 */         err.put(EnumBidOrderProperty.APPLY_START_TIME.getKey(), "必须在挂牌开始时间之后,报名结束时间之前!");
/*     */       }
/* 359 */       if ((!applyEndTime.after(applyStartTime)) || (!applyEndTime.before(bidStartTime))) {
/* 360 */         err.put(EnumBidOrderProperty.APPLY_END_TIME.getKey(), "必须在报名开始时间之后,竞价开始时间之前!");
/*     */       }
/* 362 */       if ((!bidStartTime.after(listingStartTime)) || (!bidStartTime.before(listingEndTime))) {
/* 363 */         err.put(EnumBidOrderProperty.BID_START_TIME.getKey(), "必须晚于挂牌开始且早于挂牌结束时间!");
/*     */       }
/*     */ 
/* 371 */       if (EnumTradingType.MULIT_BID_ORDER.getValue().equals(projectListing.getTradingType())) {
/* 372 */         TradeShowDTO tradeShowDTO = (TradeShowDTO)keyValueMap.get(EnumMulitBidOrderProperty.REVIEWER_ACCOUNT.getKey());
/* 373 */         if (StringUtil.isEmpty(tradeShowDTO.getInputValue()))
/* 374 */           err.put(EnumMulitBidOrderProperty.REVIEWER_ACCOUNT.getKey(), "评审员不能为空");
/* 375 */         else if (tradeShowDTO.getInputValue().length() >= 680)
/* 376 */           err.put(EnumMulitBidOrderProperty.REVIEWER_ACCOUNT.getKey(), "评审员长度不能超过680");
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public void commonValidate(ProjectListing project, Errors err)
/*     */   {
/* 390 */     String measureUnit = project.getMeasureUnit();
/* 391 */     if (EnumMeasureUnit.indexByValue(measureUnit) == null) {
/* 392 */       err.rejectValue("measureUnit", null, null, "无此计量单位");
/*     */     }
/*     */ 
/* 396 */     EnumValuationUnit valuationUnit = EnumValuationUnit.indexByValue(project.getValuationUnit());
/*     */ 
/* 398 */     if (valuationUnit == null) {
/* 399 */       err.rejectValue("valuationUnit", null, null, "无此计价单位");
/*     */     }
/*     */ 
/* 403 */     Long maxPrice = Long.valueOf(99999999999999999L);
/*     */ 
/* 405 */     Double listingPriceDesc = project.getListingPriceDesc();
/* 406 */     if ((listingPriceDesc.doubleValue() > 0.0D) && (valuationUnit != null)) {
/* 407 */       BigDecimal gb = new BigDecimal(listingPriceDesc.doubleValue());
/*     */ 
/* 410 */       Long listingPriceConvert2Fen = Long.valueOf(0L);
/* 411 */       listingPriceConvert2Fen = Long.valueOf(gb.movePointRight(valuationUnit.getScale()).longValue());
/*     */ 
/* 413 */       if (listingPriceConvert2Fen.longValue() > maxPrice.longValue()) {
/* 414 */         err.rejectValue("listingPrice", null, null, "挂牌价格 不能超过9999999" + EnumValuationUnit.YIYUAN.getName());
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 419 */     String deliveryType = project.getDeliveryType();
/* 420 */     for (String dt : deliveryType.split(",")) {
/* 421 */       if ((StringUtil.isNotEmpty(dt)) && (EnumDeliveryType.indexByValue(dt) == null)) {
/* 422 */         err.rejectValue("deliveryType", null, null, "无此交货方式");
/* 423 */         break;
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 428 */     String paymentType = project.getPaymentType();
/* 429 */     for (String pt : paymentType.split(",")) {
/* 430 */       if ((StringUtil.isNotEmpty(pt)) && (EnumPaymentType.indexByValue(pt) == null)) {
/* 431 */         err.rejectValue("paymentType", null, null, "无此货款支付方式");
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 436 */     String invoice = project.getInvoice();
/* 437 */     for (String in : invoice.split(",")) {
/* 438 */       if ((StringUtil.isNotEmpty(in)) && (EnumInvoice.indexByValue(in) == null)) {
/* 439 */         err.rejectValue("invoice", null, null, "请输入正确的值");
/*     */       }
/*     */     }
/*     */ 
/* 443 */     Date listingStartTime = project.getListingStartTime();
/* 444 */     Date listingEndTime = project.getListingEndTime();
/*     */ 
/* 447 */     if (!listingEndTime.after(listingStartTime)) {
/* 448 */       err.rejectValue("listingEndTime", null, null, "挂牌结束时间 要晚于挂牌开始时间");
/*     */     }
/*     */ 
/* 452 */     if (!listingEndTime.after(new Date()))
/* 453 */       err.rejectValue("listingEndTime", null, null, "挂牌结束时间 要晚于当前时间");
/*     */   }
/*     */ 
/*     */   public void dynamicValidate(ProjectListing project, Map<String, String> err, ProjectListing regexPro)
/*     */   {
/* 460 */     if ((StringUtil.isBlank(project.getBreedStandard())) && (project.getMetaValues() != null) && (project.getMetaValues().length > 0))
/*     */     {
/* 463 */       Map attriMap = regexPro.getAttriMap();
/* 464 */       ProjectMetas[] metas = project.getMetaValues();
/* 465 */       if ((metas != null) && (metas.length > 0))
/*     */       {
/*     */         ProjectMetas meta;
/* 466 */         for (int index = 0; index < metas.length; index++) {
/* 467 */           meta = metas[index];
/* 468 */           if (meta == null)
/*     */             continue;
/* 470 */           ProjectTypeAttri regexAttri = (ProjectTypeAttri)attriMap.get(meta.getMetaKey());
/* 471 */           if (regexAttri == null)
/*     */             continue;
/* 473 */           if ((regexAttri.getIsRequired().shortValue() == 1) && (StringUtil.isBlank(meta.getMetaValue()))) {
/* 474 */             err.put("" + index, meta.getMetaTitle() + " 为必填项");
/*     */           }
/*     */           else
/*     */           {
/* 483 */             boolean needText = (EnumProTypeAttriInputType.SELECT.getValue().equals(regexAttri.getInputType())) || (EnumProTypeAttriInputType.CHECKBOX.getValue().equals(regexAttri.getInputType())) || (EnumProTypeAttriInputType.RADIO.getValue().equals(regexAttri.getInputType()));
/*     */ 
/* 489 */             String regex = regexAttri.getValueValidate();
/* 490 */             if ((meta.getMetaValue() != null) && (meta.getMetaValue().length() > 0)) {
/* 491 */               for (String metaValue : meta.getMetaValue().split(",")) {
/* 492 */                 boolean bValue = false;
/* 493 */                 if ((needText) && (regexAttri.getText().indexOf(metaValue) < 0)) {
/* 494 */                   err.put("" + index, "无此 " + meta.getMetaTitle());
/* 495 */                   bValue = true;
/*     */                 }
/* 497 */                 if ((regex != null) && (!regex.matches(metaValue))) {
/* 498 */                   err.put("" + index, "与验证值不匹配 ");
/* 499 */                   bValue = true;
/*     */                 }
/* 501 */                 if (bValue)
/*     */                 {
/*     */                   break;
/*     */                 }
/*     */               }
/*     */             }
/* 507 */             List<AttriMeta> attriMetaNow = regexPro.getAttriMeta();
/* 508 */             for (AttriMeta attriMeta : attriMetaNow)
/*     */             {
/* 511 */               if (attriMeta.getAttr().getKeyName().equals(meta.getMetaKey()))
/* 512 */                 attriMeta.getMeta().setMetaValue(meta.getMetaValue());
/*     */             }
/*     */           }
/*     */         }
/*     */       } else {
/* 517 */         this.log.error("====================edit projectLisint validate   动态属性列表为空！");
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public void dynamicValidate(ProjectListing project, Map<String, String> err, List<ProjectTypeAttri> projectTypeAttriList)
/*     */   {
/* 530 */     if ((StringUtil.isBlank(project.getBreedStandard())) && (project.getMetaValues() != null) && (project.getMetaValues().length > 0))
/*     */     {
/* 532 */       HashMap attriMap = new HashMap();
/* 533 */       ProjectCopyUtil.convertProjectTypeAttrList2Map(projectTypeAttriList, attriMap);
/* 534 */       ProjectMetas[] metas = project.getMetaValues();
/* 535 */       if ((metas != null) && (metas.length > 0)) {
/* 536 */         for (int index = 0; index < metas.length; index++) {
/* 537 */           ProjectMetas meta = metas[index];
/* 538 */           if (meta == null)
/*     */             continue;
/* 540 */           ProjectTypeAttri regexAttri = (ProjectTypeAttri)attriMap.get(meta.getMetaKey());
/* 541 */           if (regexAttri == null)
/*     */             continue;
/* 543 */           if ((regexAttri.getIsRequired().shortValue() == 1) && (StringUtil.isBlank(meta.getMetaValue()))) {
/* 544 */             err.put("" + index, meta.getMetaTitle() + " 为必填项");
/*     */           }
/*     */           else
/*     */           {
/* 553 */             boolean needText = (EnumProTypeAttriInputType.SELECT.getValue().equals(regexAttri.getInputType())) || (EnumProTypeAttriInputType.CHECKBOX.getValue().equals(regexAttri.getInputType())) || (EnumProTypeAttriInputType.RADIO.getValue().equals(regexAttri.getInputType()));
/*     */ 
/* 559 */             String regex = regexAttri.getValueValidate();
/* 560 */             if ((meta.getMetaValue() != null) && (meta.getMetaValue().length() > 0)) {
/* 561 */               for (String metaValue : meta.getMetaValue().split(",")) {
/* 562 */                 boolean bValue = false;
/* 563 */                 if ((needText) && (regexAttri.getText().indexOf(metaValue) < 0)) {
/* 564 */                   err.put("" + index, "无此 " + meta.getMetaTitle());
/* 565 */                   bValue = true;
/*     */                 }
/* 567 */                 if ((regex != null) && (!regex.matches(metaValue))) {
/* 568 */                   err.put("" + index, "与验证值不匹配 ");
/* 569 */                   bValue = true;
/*     */                 }
/* 571 */                 if (bValue)
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
/* 586 */         this.log.error("====================edit projectLisint validate   动态属性列表为空！");
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   public void validateFile(MultipartFile file, Map<String, String> metaErrors)
/*     */   {
/* 596 */     if ((file != null) && (!file.isEmpty()) && (file.getSize() > 0L)) {
/* 597 */       FileUploadUtil.MAX_FILE_SIZE = 204800;
/* 598 */       if (!FileUploadUtil.ifFileSizePermitted(file)) {
/* 599 */         metaErrors.put("fileErrorDiv", "上传的图片的大小不能超过200K!");
/*     */       }
/* 601 */       if (!FileUploadUtil.ifExtendNamePermitted(file))
/* 602 */         metaErrors.put("fileErrorDiv", "仅仅支持jpg,jpeg,gif,png的图片上传!");
/*     */     }
/*     */   }
/*     */ 
/*     */   public void transferOrderVadate(ProjectListing projectListing, ProjectTradeBO tradeBo, Map<String, String> err, List<String> ignoreList)
/*     */   {
/* 615 */     List tradeShowList = tradeBo.getTradeMetas();
/* 616 */     if ((tradeShowList != null) && (tradeShowList.size() > 0)) {
/* 617 */       HashMap keyValueMap = getMapFromList(tradeShowList);
/* 618 */       Date applyStartTime = new Date();
/* 619 */       Date applyEndTime = new Date();
/* 620 */       Date bidStartTime = new Date();
/* 621 */       Date listingStartTime = projectListing.getListingStartTime();
/* 622 */       Date listingEndTime = projectListing.getListingEndTime();
/* 623 */       if (!ignoreList.contains(EnumTransferOrderProperty.START_PRICE.getKey())) {
/* 624 */         TradeShowDTO tradeShowDTO = (TradeShowDTO)keyValueMap.get(EnumTransferOrderProperty.START_PRICE.getKey());
/* 625 */         if (StringUtil.isEmpty(tradeShowDTO.getInputValue())) {
/* 626 */           err.put(tradeShowDTO.getKey(), "此项为必填项!");
/*     */         }
/* 628 */         if (StringUtil.isNotEmpty(tradeShowDTO.getInputValue())) {
/* 629 */           if (!FormatValidate.isValidFloat(tradeShowDTO.getInputValue())) {
/* 630 */             if (!FormatValidate.isValidInteger(tradeShowDTO.getInputValue())) {
/* 631 */               err.put(tradeShowDTO.getKey(), "请入正确的转让价格（最小单位精确到分）!");
/*     */             }
/*     */           }
/* 634 */           else if (!FormatValidate.isValidInteger(TradeMoneyUtil.getCentByValueUnit(tradeShowDTO.getInputValue(), projectListing.getValuationUnit()).toString()))
/*     */           {
/* 637 */             err.put(tradeShowDTO.getKey(), "请入正确的转让价格（最小单位精确到分）!");
/*     */           }
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 643 */       if (!ignoreList.contains(EnumTransferOrderProperty.BID_START_TIME)) {
/* 644 */         TradeShowDTO tradeShowDTO = (TradeShowDTO)keyValueMap.get(EnumTransferOrderProperty.BID_START_TIME.getKey());
/*     */ 
/* 646 */         if (StringUtil.isEmpty(tradeShowDTO.getInputValue()))
/* 647 */           err.put(tradeShowDTO.getKey(), "此项为必填项!");
/*     */         try
/*     */         {
/* 650 */           bidStartTime = DateUtil.convertStringToDate("yyyy-MM-dd HH:mm:ss", ((TradeShowDTO)keyValueMap.get(EnumTransferOrderProperty.BID_START_TIME.getKey())).getInputValue());
/*     */         }
/*     */         catch (ParseException e) {
/* 653 */           err.put(EnumTransferOrderProperty.BID_START_TIME.getKey(), "日期格式错误!");
/*     */         }
/*     */       }
/* 656 */       if (!ignoreList.contains(EnumTransferOrderProperty.APPLY_START_TIME.getKey())) {
/* 657 */         TradeShowDTO tradeShowDTO = (TradeShowDTO)keyValueMap.get(EnumTransferOrderProperty.APPLY_START_TIME.getKey());
/*     */ 
/* 659 */         if (StringUtil.isEmpty(tradeShowDTO.getInputValue()))
/* 660 */           err.put(tradeShowDTO.getKey(), "此项为必填项!");
/*     */         try
/*     */         {
/* 663 */           applyStartTime = DateUtil.convertStringToDate("yyyy-MM-dd HH:mm:ss", tradeShowDTO.getInputValue());
/*     */         }
/*     */         catch (ParseException e) {
/* 666 */           err.put(EnumTransferOrderProperty.APPLY_START_TIME.getKey(), "日期格式错误!");
/*     */         }
/*     */       }
/*     */ 
/* 670 */       if (!ignoreList.contains(EnumTransferOrderProperty.APPLY_END_TIME.getKey())) {
/* 671 */         TradeShowDTO tradeShowDTO = (TradeShowDTO)keyValueMap.get(EnumTransferOrderProperty.APPLY_END_TIME.getKey());
/*     */ 
/* 673 */         if (StringUtil.isEmpty(tradeShowDTO.getInputValue()))
/* 674 */           err.put(tradeShowDTO.getKey(), "此项为必填项!");
/*     */         try
/*     */         {
/* 677 */           applyEndTime = DateUtil.convertStringToDate("yyyy-MM-dd HH:mm:ss", tradeShowDTO.getInputValue());
/*     */         }
/*     */         catch (ParseException e) {
/* 680 */           err.put(EnumTransferOrderProperty.APPLY_END_TIME.getKey(), "日期格式错误!");
/*     */         }
/*     */ 
/* 683 */         if (applyStartTime.after(applyEndTime)) {
/* 684 */           err.put(tradeShowDTO.getKey(), "必须要晚于报名开始时间!");
/*     */         }
/* 686 */         if (applyEndTime.after(bidStartTime)) {
/* 687 */           err.put(tradeShowDTO.getKey(), "必须要早于协议转让开始时间!");
/*     */         }
/*     */       }
/*     */ 
/* 691 */       if ((!applyStartTime.after(listingStartTime)) || (!applyStartTime.before(applyEndTime))) {
/* 692 */         err.put(EnumTransferOrderProperty.APPLY_START_TIME.getKey(), "必须在挂牌开始时间之后,报名结束时间之前!");
/*     */       }
/* 694 */       if ((!applyEndTime.after(applyStartTime)) || (!applyEndTime.before(bidStartTime))) {
/* 695 */         err.put(EnumTransferOrderProperty.APPLY_END_TIME.getKey(), "必须在报名开始时间之后,协议转让开始时间之前!");
/*     */       }
/* 697 */       if ((!bidStartTime.after(listingStartTime)) || (!bidStartTime.before(listingEndTime)))
/* 698 */         err.put(EnumTransferOrderProperty.BID_START_TIME.getKey(), "必须晚于挂牌开始且早于挂牌结束时间!");
/*     */     }
/*     */   }
/*     */ 
/*     */   public void tenderOrderVadate(ProjectListing projectListing, ProjectTradeBO tradeBo, Map<String, String> err, List<String> ignoreList)
/*     */   {
/* 711 */     List tradeShowList = tradeBo.getTradeMetas();
/* 712 */     if ((tradeShowList != null) && (tradeShowList.size() > 0)) {
/* 713 */       HashMap keyValueMap = getMapFromList(tradeShowList);
/* 714 */       Date applyStartTime = new Date();
/* 715 */       Date applyEndTime = new Date();
/* 716 */       Date bidStartTime = new Date();
/* 717 */       Date listingStartTime = projectListing.getListingStartTime();
/* 718 */       Date listingEndTime = projectListing.getListingEndTime();
/* 719 */       if (!ignoreList.contains(EnumTenderOrderProperty.EVALUATION.getKey())) {
/* 720 */         TradeShowDTO tradeShowDTO = (TradeShowDTO)keyValueMap.get(EnumTenderOrderProperty.EVALUATION.getKey());
/* 721 */         if (StringUtil.isEmpty(tradeShowDTO.getInputValue())) {
/* 722 */           err.put(tradeShowDTO.getKey(), "此项为必填项!");
/*     */         }
/* 724 */         if (StringUtil.isNotEmpty(tradeShowDTO.getInputValue())) {
/* 725 */           if (!FormatValidate.isValidFloat(tradeShowDTO.getInputValue())) {
/* 726 */             if (!FormatValidate.isValidInteger(tradeShowDTO.getInputValue())) {
/* 727 */               err.put(tradeShowDTO.getKey(), "请入正确的评估价（最小单位精确到分）!");
/*     */             }
/*     */           }
/* 730 */           else if (!FormatValidate.isValidInteger(TradeMoneyUtil.getCentByValueUnit(tradeShowDTO.getInputValue(), projectListing.getValuationUnit()).toString()))
/*     */           {
/* 733 */             err.put(tradeShowDTO.getKey(), "请入正确的评估价（最小单位精确到分）!");
/*     */           }
/*     */         }
/*     */       }
/*     */ 
/* 738 */       if (!ignoreList.contains(EnumTransferOrderProperty.BID_START_TIME)) {
/* 739 */         TradeShowDTO tradeShowDTO = (TradeShowDTO)keyValueMap.get(EnumTransferOrderProperty.BID_START_TIME.getKey());
/*     */ 
/* 741 */         if (StringUtil.isEmpty(tradeShowDTO.getInputValue()))
/* 742 */           err.put(tradeShowDTO.getKey(), "此项为必填项!");
/*     */         try
/*     */         {
/* 745 */           bidStartTime = DateUtil.convertStringToDate("yyyy-MM-dd HH:mm:ss", ((TradeShowDTO)keyValueMap.get(EnumTransferOrderProperty.BID_START_TIME.getKey())).getInputValue());
/*     */         }
/*     */         catch (ParseException e) {
/* 748 */           err.put(EnumTransferOrderProperty.BID_START_TIME.getKey(), "日期格式错误!");
/*     */         }
/*     */       }
/*     */ 
/* 752 */       if (!ignoreList.contains(EnumTenderOrderProperty.APPLY_START_TIME.getKey())) {
/* 753 */         TradeShowDTO tradeShowDTO = (TradeShowDTO)keyValueMap.get(EnumTenderOrderProperty.APPLY_START_TIME.getKey());
/*     */ 
/* 755 */         if (StringUtil.isEmpty(tradeShowDTO.getInputValue()))
/* 756 */           err.put(tradeShowDTO.getKey(), "此项为必填项!");
/*     */         try
/*     */         {
/* 759 */           applyStartTime = DateUtil.convertStringToDate("yyyy-MM-dd HH:mm:ss", tradeShowDTO.getInputValue());
/*     */         }
/*     */         catch (ParseException e) {
/* 762 */           err.put(EnumTenderOrderProperty.APPLY_START_TIME.getKey(), "日期格式错误!");
/*     */         }
/*     */       }
/*     */ 
/* 766 */       if (!ignoreList.contains(EnumTenderOrderProperty.APPLY_END_TIME.getKey())) {
/* 767 */         TradeShowDTO tradeShowDTO = (TradeShowDTO)keyValueMap.get(EnumTenderOrderProperty.APPLY_END_TIME.getKey());
/*     */ 
/* 769 */         if (StringUtil.isEmpty(tradeShowDTO.getInputValue()))
/* 770 */           err.put(tradeShowDTO.getKey(), "此项为必填项!");
/*     */         try
/*     */         {
/* 773 */           applyEndTime = DateUtil.convertStringToDate("yyyy-MM-dd HH:mm:ss", tradeShowDTO.getInputValue());
/*     */         }
/*     */         catch (ParseException e) {
/* 776 */           err.put(EnumTenderOrderProperty.APPLY_END_TIME.getKey(), "日期格式错误!");
/*     */         }
/*     */ 
/* 779 */         if (applyStartTime.after(applyEndTime)) {
/* 780 */           err.put(tradeShowDTO.getKey(), "必须要晚于报名开始时间!");
/*     */         }
/* 782 */         if (applyEndTime.after(bidStartTime)) {
/* 783 */           err.put(tradeShowDTO.getKey(), "必须要早于招标转让开始时间!");
/*     */         }
/*     */       }
/*     */ 
/* 787 */       if ((!applyStartTime.after(listingStartTime)) || (!applyStartTime.before(applyEndTime))) {
/* 788 */         err.put(EnumTenderOrderProperty.APPLY_START_TIME.getKey(), "必须在挂牌开始时间之后,报名结束时间之前!");
/*     */       }
/* 790 */       if ((!applyStartTime.after(listingStartTime)) || (!applyStartTime.before(applyEndTime))) {
/* 791 */         err.put(EnumTenderOrderProperty.APPLY_START_TIME.getKey(), "必须在挂牌开始时间之后,报名结束时间之前!");
/*     */       }
/* 793 */       if ((!applyEndTime.after(applyStartTime)) || (!applyEndTime.before(bidStartTime))) {
/* 794 */         err.put(EnumTenderOrderProperty.APPLY_END_TIME.getKey(), "必须在报名开始时间之后,招标转让开始时间之前!");
/*     */       }
/* 796 */       if ((!bidStartTime.after(listingStartTime)) || (!bidStartTime.before(listingEndTime)))
/* 797 */         err.put(EnumTenderOrderProperty.BID_START_TIME.getKey(), "必须晚于挂牌开始且早于挂牌结束时间!");
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.validator.ProEditValidator
 * JD-Core Version:    0.6.0
 */