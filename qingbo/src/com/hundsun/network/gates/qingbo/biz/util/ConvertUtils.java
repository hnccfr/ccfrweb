/*     */ package com.hundsun.network.gates.qingbo.biz.util;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumDeliveryType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumListingType;
/*     */ import com.hundsun.network.gates.luosi.common.remote.BaseTradeDTO;
/*     */ import com.hundsun.network.gates.luosi.qingbo.reomte.dto.PlaceOrderTradeDTO;
/*     */ import com.hundsun.network.gates.luosi.wangjiang.reomte.dto.AuctionLatestBidDTO;
/*     */ import com.hundsun.network.gates.luosi.wangjiang.reomte.dto.AuctionResultDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.ProjectListingDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.TradeOrderDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.TradeWishOrderDTO;
/*     */ import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionLatestBid;
/*     */ import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionResult;
/*     */ import com.hundsun.network.gates.qingbo.biz.domain.cash.TradeCashDTO;
/*     */ import com.hundsun.network.gates.qingbo.biz.domain.project.ProjectListing;
/*     */ import com.hundsun.network.gates.qingbo.biz.domain.trade.TradeWishOrder;
/*     */ 
/*     */ public class ConvertUtils
/*     */ {
/*     */   public static TradeCashDTO converntPlaceOrderTradeDTO2TradeCashDTO(PlaceOrderTradeDTO placeOrderTradeDTO)
/*     */   {
/*  26 */     TradeCashDTO tradeCashDTO = new TradeCashDTO();
/*  27 */     tradeCashDTO.setUserName(placeOrderTradeDTO.getUserName());
/*  28 */     tradeCashDTO.setProjectTypeCode(placeOrderTradeDTO.getProjectTypeCode());
/*  29 */     tradeCashDTO.setUserId(placeOrderTradeDTO.getUserId());
/*  30 */     tradeCashDTO.setProjectCode(placeOrderTradeDTO.getProjectCode());
/*  31 */     tradeCashDTO.setUserAccount(placeOrderTradeDTO.getUserAccount());
/*  32 */     tradeCashDTO.setFundAccount(placeOrderTradeDTO.getFundAccount());
/*  33 */     tradeCashDTO.setTradingType(placeOrderTradeDTO.getTradingType());
/*  34 */     tradeCashDTO.setQuantity(placeOrderTradeDTO.getQuantity());
/*  35 */     tradeCashDTO.setListingPrice(placeOrderTradeDTO.getListingPrice());
/*  36 */     tradeCashDTO.setListingType(placeOrderTradeDTO.getListingType());
/*  37 */     tradeCashDTO.setTotalPay(placeOrderTradeDTO.getTotalPay());
/*  38 */     return tradeCashDTO;
/*     */   }
/*     */ 
/*     */   public static ProjectListingDTO convertProjectListing2ProjectListingDTO(ProjectListing projectListing)
/*     */   {
/*  48 */     ProjectListingDTO projectListingDTO = new ProjectListingDTO();
/*  49 */     projectListingDTO.setId(projectListing.getId());
/*  50 */     projectListingDTO.setTitle(projectListing.getTitle());
/*  51 */     projectListingDTO.setCode(projectListing.getCode());
/*  52 */     projectListingDTO.setUserId(projectListing.getUserId());
/*  53 */     projectListingDTO.setUserAccount(projectListing.getUserAccount());
/*  54 */     projectListingDTO.setFundAccount(projectListing.getFundAccount());
/*  55 */     projectListingDTO.setListingType(projectListing.getListingType());
/*  56 */     projectListingDTO.setMeasureUnit(projectListing.getMeasureUnit());
/*  57 */     projectListingDTO.setQuantity(projectListing.getQuantity());
/*  58 */     projectListingDTO.setValuationUnit(projectListing.getValuationUnit());
/*  59 */     projectListingDTO.setListingPrice(projectListing.getListingPrice());
/*  60 */     projectListingDTO.setMultipleBase(projectListing.getMultipleBase());
/*  61 */     projectListingDTO.setMaxQuantity(projectListing.getMaxQuantity());
/*  62 */     projectListingDTO.setMinQuantity(projectListing.getMinQuantity());
/*  63 */     projectListingDTO.setRetail(projectListing.getRetail());
/*  64 */     projectListingDTO.setProjectTypeCode(projectListing.getProjectTypeCode());
/*  65 */     projectListingDTO.setBreedStandard(projectListing.getBreedStandard());
/*  66 */     projectListingDTO.setTradingType(projectListing.getTradingType());
/*  67 */     projectListingDTO.setDeliveryDate(projectListing.getDeliveryDate());
/*  68 */     projectListingDTO.setDeliveryPlace(projectListing.getDeliveryPlace());
/*  69 */     projectListingDTO.setDeliveryType(projectListing.getDeliveryType());
/*  70 */     projectListingDTO.setPaymentType(projectListing.getPaymentType());
/*  71 */     projectListingDTO.setListingStartTime(projectListing.getListingStartTime());
/*  72 */     projectListingDTO.setListingEndTime(projectListing.getListingEndTime());
/*  73 */     projectListingDTO.setInvoice(projectListing.getInvoice());
/*  74 */     projectListingDTO.setStatus(projectListing.getStatus());
/*  75 */     projectListingDTO.setProcessAuditNodes(projectListing.getProcessAuditNodes());
/*  76 */     projectListingDTO.setAuditNode(projectListing.getAuditNode());
/*  77 */     projectListingDTO.setCreator(projectListing.getCreator());
/*  78 */     projectListingDTO.setCreatorType(projectListing.getCreatorType());
/*  79 */     projectListingDTO.setOperator(projectListing.getOperator());
/*  80 */     projectListingDTO.setGmtCreate(projectListing.getGmtCreate());
/*  81 */     projectListingDTO.setGmtModify(projectListing.getGmtModify());
/*  82 */     projectListingDTO.setDeposit(projectListing.getDeposit());
/*     */ 
/*  84 */     projectListingDTO.setProvince(projectListing.getProvince());
/*  85 */     projectListingDTO.setCity(projectListing.getCity());
/*  86 */     projectListingDTO.setArea(projectListing.getArea());
/*  87 */     projectListingDTO.setAddress(projectListing.getAddress());
/*  88 */     projectListingDTO.setLinkMan(projectListing.getLinkMan());
/*  89 */     projectListingDTO.setZipCode(projectListing.getZipCode());
/*  90 */     projectListingDTO.setPhone(projectListing.getPhone());
/*  91 */     projectListingDTO.setStorehouse(projectListing.getStorehouse());
/*     */ 
/*  93 */     projectListingDTO.setPicturePath(projectListing.getPicturePath());
/*  94 */     projectListingDTO.setPicturePath1(projectListing.getPicturePath1());
/*  95 */     projectListingDTO.setPicturePath2(projectListing.getPicturePath2());
/*  96 */     projectListingDTO.setPicturePath3(projectListing.getPicturePath3());
/*  97 */     projectListingDTO.setPicturePath4(projectListing.getPicturePath4());
/*  98 */     projectListingDTO.setBreedStandardId(projectListing.getBreedStandardId());
/*  99 */     projectListingDTO.setDescription(projectListing.getDescription());
/* 100 */     return projectListingDTO;
/*     */   }
/*     */ 
/*     */   public static ProjectListing convertProjectListingDTO2ProjectListing(ProjectListingDTO projectListingDTO)
/*     */   {
/* 105 */     ProjectListing projectListing = new ProjectListing();
/* 106 */     projectListing.setId(projectListingDTO.getId());
/* 107 */     projectListing.setTitle(projectListingDTO.getTitle());
/* 108 */     projectListing.setCode(projectListingDTO.getCode());
/* 109 */     projectListing.setUserId(projectListingDTO.getUserId());
/* 110 */     projectListing.setUserAccount(projectListingDTO.getUserAccount());
/* 111 */     projectListing.setFundAccount(projectListingDTO.getFundAccount());
/* 112 */     projectListing.setListingType(projectListingDTO.getListingType());
/* 113 */     projectListing.setMeasureUnit(projectListingDTO.getMeasureUnit());
/* 114 */     projectListing.setQuantity(projectListingDTO.getQuantity());
/* 115 */     projectListing.setValuationUnit(projectListingDTO.getValuationUnit());
/* 116 */     projectListing.setListingPrice(projectListingDTO.getListingPrice());
/* 117 */     projectListing.setMultipleBase(projectListingDTO.getMultipleBase());
/* 118 */     projectListing.setMaxQuantity(projectListingDTO.getMaxQuantity());
/* 119 */     projectListing.setMinQuantity(projectListingDTO.getMinQuantity());
/* 120 */     projectListing.setRetail(projectListingDTO.getRetail());
/* 121 */     projectListing.setProjectTypeCode(projectListingDTO.getProjectTypeCode());
/* 122 */     projectListing.setBreedStandard(projectListingDTO.getBreedStandard());
/* 123 */     projectListing.setTradingType(projectListingDTO.getTradingType());
/* 124 */     projectListing.setDeliveryDate(projectListingDTO.getDeliveryDate());
/* 125 */     projectListing.setDeliveryPlace(projectListingDTO.getDeliveryPlace());
/* 126 */     projectListing.setDeliveryType(projectListingDTO.getDeliveryType());
/* 127 */     projectListing.setPaymentType(projectListingDTO.getPaymentType());
/* 128 */     projectListing.setListingStartTime(projectListingDTO.getListingStartTime());
/* 129 */     projectListing.setListingEndTime(projectListingDTO.getListingEndTime());
/* 130 */     projectListing.setInvoice(projectListingDTO.getInvoice());
/* 131 */     projectListing.setStatus(projectListingDTO.getStatus());
/* 132 */     projectListing.setProcessAuditNodes(projectListingDTO.getProcessAuditNodes());
/* 133 */     projectListing.setAuditNode(projectListingDTO.getAuditNode());
/* 134 */     projectListing.setCreator(projectListingDTO.getCreator());
/* 135 */     projectListing.setCreatorType(projectListingDTO.getCreatorType());
/* 136 */     projectListing.setOperator(projectListingDTO.getOperator());
/* 137 */     projectListing.setGmtCreate(projectListingDTO.getGmtCreate());
/* 138 */     projectListing.setGmtModify(projectListingDTO.getGmtModify());
/* 139 */     projectListing.setDeposit(projectListingDTO.getDeposit());
/* 140 */     projectListing.setProvince(projectListingDTO.getProvince());
/* 141 */     projectListing.setCity(projectListingDTO.getCity());
/* 142 */     projectListing.setArea(projectListingDTO.getArea());
/* 143 */     projectListing.setAddress(projectListingDTO.getAddress());
/* 144 */     projectListing.setLinkMan(projectListingDTO.getLinkMan());
/* 145 */     projectListing.setZipCode(projectListingDTO.getZipCode());
/* 146 */     projectListing.setPhone(projectListingDTO.getPhone());
/* 147 */     projectListing.setStorehouse(projectListingDTO.getStorehouse());
/*     */ 
/* 149 */     projectListing.setPicturePath(projectListingDTO.getPicturePath());
/* 150 */     projectListing.setPicturePath1(projectListingDTO.getPicturePath1());
/* 151 */     projectListing.setPicturePath2(projectListingDTO.getPicturePath2());
/* 152 */     projectListing.setPicturePath3(projectListingDTO.getPicturePath3());
/* 153 */     projectListing.setPicturePath4(projectListingDTO.getPicturePath4());
/* 154 */     projectListing.setBreedStandardId(projectListingDTO.getBreedStandardId());
/* 155 */     projectListing.setDescription(projectListingDTO.getDescription());
/* 156 */     return projectListing;
/*     */   }
/*     */ 
/*     */   public static ProjectListingDTO converntPlaceOrderTradeDTO2ProjectListingDTO(PlaceOrderTradeDTO placeOrderTradeDTO)
/*     */   {
/* 161 */     ProjectListingDTO projectListingDTO = new ProjectListingDTO();
/* 162 */     projectListingDTO.setTitle(placeOrderTradeDTO.getProjectName());
/* 163 */     projectListingDTO.setCode(placeOrderTradeDTO.getProjectCode());
/* 164 */     projectListingDTO.setUserId(placeOrderTradeDTO.getUserId());
/* 165 */     projectListingDTO.setUserAccount(placeOrderTradeDTO.getUserAccount());
/* 166 */     projectListingDTO.setListingType(placeOrderTradeDTO.getListingType());
/* 167 */     projectListingDTO.setMeasureUnit(placeOrderTradeDTO.getMeasureUnit());
/* 168 */     projectListingDTO.setQuantity(placeOrderTradeDTO.getQuantity());
/* 169 */     projectListingDTO.setValuationUnit(placeOrderTradeDTO.getValuationUnit());
/* 170 */     projectListingDTO.setListingPrice(placeOrderTradeDTO.getListingPrice());
/* 171 */     projectListingDTO.setProjectTypeCode(placeOrderTradeDTO.getProjectTypeCode());
/* 172 */     projectListingDTO.setTradingType(placeOrderTradeDTO.getTradingType());
/* 173 */     projectListingDTO.setDeliveryDate(placeOrderTradeDTO.getDeliveryDate());
/* 174 */     projectListingDTO.setDeliveryPlace(placeOrderTradeDTO.getDeliveryPlace());
/* 175 */     projectListingDTO.setDeliveryType(placeOrderTradeDTO.getDeliveryType());
/* 176 */     projectListingDTO.setPaymentType(placeOrderTradeDTO.getPaymentType());
/* 177 */     projectListingDTO.setInvoice(placeOrderTradeDTO.getInvoice());
/* 178 */     projectListingDTO.setOperator(placeOrderTradeDTO.getUserAccount());
/* 179 */     projectListingDTO.setDeposit(placeOrderTradeDTO.getDeposit());
/* 180 */     projectListingDTO.setProvince(placeOrderTradeDTO.getProvince());
/* 181 */     projectListingDTO.setCity(placeOrderTradeDTO.getCity());
/* 182 */     projectListingDTO.setArea(placeOrderTradeDTO.getArea());
/* 183 */     projectListingDTO.setAddress(placeOrderTradeDTO.getAddress());
/* 184 */     projectListingDTO.setLinkMan(placeOrderTradeDTO.getLinkMan());
/* 185 */     projectListingDTO.setZipCode(placeOrderTradeDTO.getZipCode());
/* 186 */     projectListingDTO.setPhone(placeOrderTradeDTO.getPhone());
/* 187 */     projectListingDTO.setStorehouse(placeOrderTradeDTO.getStorehouse());
/*     */ 
/* 189 */     projectListingDTO.setPicturePath(placeOrderTradeDTO.getPicturePath());
/* 190 */     projectListingDTO.setPicturePath1(placeOrderTradeDTO.getPicturePath1());
/* 191 */     projectListingDTO.setPicturePath2(placeOrderTradeDTO.getPicturePath2());
/* 192 */     projectListingDTO.setPicturePath3(placeOrderTradeDTO.getPicturePath3());
/* 193 */     projectListingDTO.setPicturePath4(placeOrderTradeDTO.getPicturePath4());
/* 194 */     projectListingDTO.setBreedStandardId(placeOrderTradeDTO.getBreedStandardId());
/* 195 */     projectListingDTO.setDescription(placeOrderTradeDTO.getDescription());
/* 196 */     return projectListingDTO;
/*     */   }
/*     */ 
/*     */   public static ProjectListing converntPlaceOrderTradeDTO2ProjectListing(PlaceOrderTradeDTO placeOrderTradeDTO)
/*     */   {
/* 201 */     ProjectListing projectListing = new ProjectListing();
/* 202 */     projectListing.setTitle(placeOrderTradeDTO.getProjectName());
/* 203 */     projectListing.setCode(placeOrderTradeDTO.getProjectCode());
/* 204 */     projectListing.setUserId(placeOrderTradeDTO.getUserId());
/* 205 */     projectListing.setUserAccount(placeOrderTradeDTO.getUserAccount());
/* 206 */     projectListing.setListingType(placeOrderTradeDTO.getListingType());
/* 207 */     projectListing.setMeasureUnit(placeOrderTradeDTO.getMeasureUnit());
/* 208 */     projectListing.setQuantity(placeOrderTradeDTO.getQuantity());
/* 209 */     projectListing.setValuationUnit(placeOrderTradeDTO.getValuationUnit());
/* 210 */     projectListing.setListingPrice(placeOrderTradeDTO.getListingPrice());
/* 211 */     projectListing.setProjectTypeCode(placeOrderTradeDTO.getProjectTypeCode());
/* 212 */     projectListing.setTradingType(placeOrderTradeDTO.getTradingType());
/* 213 */     projectListing.setDeliveryDate(placeOrderTradeDTO.getDeliveryDate());
/* 214 */     projectListing.setDeliveryPlace(placeOrderTradeDTO.getDeliveryPlace());
/* 215 */     projectListing.setDeliveryType(placeOrderTradeDTO.getDeliveryType());
/* 216 */     projectListing.setPaymentType(placeOrderTradeDTO.getPaymentType());
/* 217 */     projectListing.setInvoice(placeOrderTradeDTO.getInvoice());
/* 218 */     projectListing.setOperator(placeOrderTradeDTO.getUserAccount());
/* 219 */     projectListing.setDeposit(placeOrderTradeDTO.getDeposit());
/* 220 */     projectListing.setProvince(placeOrderTradeDTO.getProvince());
/* 221 */     projectListing.setCity(placeOrderTradeDTO.getCity());
/* 222 */     projectListing.setArea(placeOrderTradeDTO.getArea());
/* 223 */     projectListing.setAddress(placeOrderTradeDTO.getAddress());
/* 224 */     projectListing.setLinkMan(placeOrderTradeDTO.getLinkMan());
/* 225 */     projectListing.setZipCode(placeOrderTradeDTO.getZipCode());
/* 226 */     projectListing.setPhone(placeOrderTradeDTO.getPhone());
/*     */ 
/* 228 */     projectListing.setPicturePath(placeOrderTradeDTO.getPicturePath());
/* 229 */     projectListing.setPicturePath1(placeOrderTradeDTO.getPicturePath1());
/* 230 */     projectListing.setPicturePath2(placeOrderTradeDTO.getPicturePath2());
/* 231 */     projectListing.setPicturePath3(placeOrderTradeDTO.getPicturePath3());
/* 232 */     projectListing.setPicturePath4(placeOrderTradeDTO.getPicturePath4());
/* 233 */     projectListing.setBreedStandardId(placeOrderTradeDTO.getBreedStandardId());
/* 234 */     projectListing.setDescription(placeOrderTradeDTO.getDescription());
/* 235 */     return projectListing;
/*     */   }
/*     */ 
/*     */   public static TradeOrderDTO converntPlaceOrderTradeDTO2TradeOrderDTO(PlaceOrderTradeDTO placeOrderTradeDTO)
/*     */   {
/* 240 */     TradeOrderDTO tradeOrderDTO = new TradeOrderDTO();
/* 241 */     tradeOrderDTO.setTradingType(placeOrderTradeDTO.getTradingType());
/* 242 */     tradeOrderDTO.setBidPrice(placeOrderTradeDTO.getListingPrice());
/* 243 */     tradeOrderDTO.setValuationUnit(placeOrderTradeDTO.getValuationUnit());
/* 244 */     tradeOrderDTO.setQuantity(placeOrderTradeDTO.getQuantity());
/* 245 */     tradeOrderDTO.setMeasureUnit(placeOrderTradeDTO.getMeasureUnit());
/* 246 */     tradeOrderDTO.setOrderAmount(placeOrderTradeDTO.getTotalPay());
/*     */ 
/* 249 */     tradeOrderDTO.setDeliveryType(placeOrderTradeDTO.getDeliveryType());
/* 250 */     tradeOrderDTO.setPaymentType(placeOrderTradeDTO.getPaymentType());
/*     */ 
/* 252 */     tradeOrderDTO.setBuyerAccount(placeOrderTradeDTO.getUserAccount());
/* 253 */     tradeOrderDTO.setExpectTime(placeOrderTradeDTO.getDeliveryDate());
/* 254 */     tradeOrderDTO.setHasInvoice(placeOrderTradeDTO.getInvoice());
/*     */ 
/* 256 */     tradeOrderDTO.setProjectCode(placeOrderTradeDTO.getProjectCode());
/* 257 */     tradeOrderDTO.setProjectName(placeOrderTradeDTO.getProjectName());
/*     */ 
/* 259 */     tradeOrderDTO.setCreator(placeOrderTradeDTO.getUserAccount());
/* 260 */     tradeOrderDTO.setOperator(placeOrderTradeDTO.getUserAccount());
/*     */ 
/* 269 */     return tradeOrderDTO;
/*     */   }
/*     */ 
/*     */   public static BaseTradeDTO converntTradeOrderDTO2TradeOrderDTO(BaseTradeDTO baseTradeDTOOld) {
/* 273 */     BaseTradeDTO baseTradeDTONew = new BaseTradeDTO();
/* 274 */     baseTradeDTONew.setListingStartTime(baseTradeDTOOld.getListingStartTime());
/* 275 */     baseTradeDTONew.setListingEndTime(baseTradeDTOOld.getListingEndTime());
/* 276 */     baseTradeDTONew.setProjectTypeCode(baseTradeDTOOld.getProjectTypeCode());
/* 277 */     baseTradeDTONew.setRetail(baseTradeDTOOld.getRetail());
/* 278 */     baseTradeDTONew.setTradeStatus(baseTradeDTOOld.getTradeStatus());
/* 279 */     baseTradeDTONew.setDeposit(baseTradeDTOOld.getDeposit());
/* 280 */     baseTradeDTONew.setMultipleBase(baseTradeDTOOld.getMultipleBase());
/* 281 */     baseTradeDTONew.setMaxQuantity(baseTradeDTOOld.getMaxQuantity());
/* 282 */     baseTradeDTONew.setMinQuantity(baseTradeDTOOld.getMinQuantity());
/* 283 */     baseTradeDTONew.setProjectCode(baseTradeDTOOld.getProjectCode());
/* 284 */     baseTradeDTONew.setUserAccount(baseTradeDTOOld.getUserAccount());
/* 285 */     baseTradeDTONew.setFundAccount(baseTradeDTOOld.getFundAccount());
/* 286 */     baseTradeDTONew.setTradingType(baseTradeDTOOld.getTradingType());
/* 287 */     baseTradeDTONew.setQuantity(baseTradeDTOOld.getQuantity());
/* 288 */     baseTradeDTONew.setListingPrice(baseTradeDTOOld.getListingPrice());
/* 289 */     baseTradeDTONew.setTotalPay(baseTradeDTOOld.getTotalPay());
/* 290 */     baseTradeDTONew.setListingType(baseTradeDTOOld.getListingType());
/* 291 */     return baseTradeDTONew;
/*     */   }
/*     */ 
/*     */   public static TradeWishOrderDTO converntPlaceOrderTradeDTO2TradeWishOrderDTO(PlaceOrderTradeDTO placeOrderTradeDTO)
/*     */   {
/* 296 */     TradeWishOrderDTO tradeWishOrderDTO = new TradeWishOrderDTO();
/*     */ 
/* 298 */     tradeWishOrderDTO.setAddress(placeOrderTradeDTO.getAddress());
/* 299 */     tradeWishOrderDTO.setArea(placeOrderTradeDTO.getArea());
/* 300 */     tradeWishOrderDTO.setBidPrice(placeOrderTradeDTO.getListingPrice());
/* 301 */     tradeWishOrderDTO.setPhone(placeOrderTradeDTO.getPhone());
/* 302 */     tradeWishOrderDTO.setCity(placeOrderTradeDTO.getCity());
/* 303 */     tradeWishOrderDTO.setDeposit(placeOrderTradeDTO.getDeposit());
/* 304 */     tradeWishOrderDTO.setComments(placeOrderTradeDTO.getComments());
/* 305 */     tradeWishOrderDTO.setDeliveryType(placeOrderTradeDTO.getDeliveryType());
/* 306 */     tradeWishOrderDTO.setExpectTime(placeOrderTradeDTO.getDeliveryDate());
/* 307 */     tradeWishOrderDTO.setIsInvoice(placeOrderTradeDTO.getInvoice());
/* 308 */     tradeWishOrderDTO.setLinkMan(placeOrderTradeDTO.getLinkMan());
/* 309 */     tradeWishOrderDTO.setMeasureUnit(placeOrderTradeDTO.getMeasureUnit());
/* 310 */     tradeWishOrderDTO.setPaymentType(placeOrderTradeDTO.getPaymentType());
/* 311 */     tradeWishOrderDTO.setProjectCode(placeOrderTradeDTO.getProjectCode());
/* 312 */     tradeWishOrderDTO.setProjectName(placeOrderTradeDTO.getProjectName());
/* 313 */     tradeWishOrderDTO.setProvince(placeOrderTradeDTO.getProvince());
/* 314 */     tradeWishOrderDTO.setQuantity(placeOrderTradeDTO.getQuantity());
/*     */ 
/* 316 */     tradeWishOrderDTO.setTotalPay(placeOrderTradeDTO.getTotalPay());
/* 317 */     tradeWishOrderDTO.setTradeDictor(placeOrderTradeDTO.getListingType());
/* 318 */     tradeWishOrderDTO.setTradeType(placeOrderTradeDTO.getTradingType());
/* 319 */     tradeWishOrderDTO.setUserAccount(placeOrderTradeDTO.getUserAccount());
/* 320 */     tradeWishOrderDTO.setValuationUnit(placeOrderTradeDTO.getValuationUnit());
/* 321 */     tradeWishOrderDTO.setZipCode(placeOrderTradeDTO.getZipCode());
/* 322 */     tradeWishOrderDTO.setStorehouse(placeOrderTradeDTO.getStorehouse());
/* 323 */     return tradeWishOrderDTO;
/*     */   }
/*     */ 
/*     */   public static TradeWishOrderDTO convertTradeWishOrder2TradeWishOrderDTO(TradeWishOrder tradeWishOrder)
/*     */   {
/* 328 */     TradeWishOrderDTO tradeWishOrderDTO = new TradeWishOrderDTO();
/*     */ 
/* 330 */     tradeWishOrderDTO.setAddress(tradeWishOrder.getAddress());
/* 331 */     tradeWishOrderDTO.setArea(tradeWishOrder.getArea());
/* 332 */     tradeWishOrderDTO.setBidPrice(tradeWishOrder.getBidPrice());
/* 333 */     tradeWishOrderDTO.setPhone(tradeWishOrder.getPhone());
/* 334 */     tradeWishOrderDTO.setCity(tradeWishOrder.getCity());
/* 335 */     tradeWishOrderDTO.setDeposit(tradeWishOrder.getDeposit());
/*     */ 
/* 337 */     tradeWishOrderDTO.setComments(tradeWishOrder.getComments());
/* 338 */     tradeWishOrderDTO.setDeal(tradeWishOrder.getDeal());
/* 339 */     tradeWishOrderDTO.setDeliveryType(tradeWishOrder.getDeliveryType());
/* 340 */     tradeWishOrderDTO.setExpectTime(tradeWishOrder.getExpectTime());
/* 341 */     tradeWishOrderDTO.setGmtCreate(tradeWishOrder.getGmtCreate());
/* 342 */     tradeWishOrderDTO.setGmtModify(tradeWishOrder.getGmtModify());
/* 343 */     tradeWishOrderDTO.setId(tradeWishOrder.getId());
/* 344 */     tradeWishOrderDTO.setIsInvoice(tradeWishOrder.getIsInvoice());
/* 345 */     tradeWishOrderDTO.setLinkMan(tradeWishOrder.getLinkMan());
/* 346 */     tradeWishOrderDTO.setMeasureUnit(tradeWishOrder.getMeasureUnit());
/* 347 */     tradeWishOrderDTO.setWishOrderNum(tradeWishOrder.getWishOrderNum());
/* 348 */     tradeWishOrderDTO.setPaymentType(tradeWishOrder.getPaymentType());
/* 349 */     tradeWishOrderDTO.setProjectCode(tradeWishOrder.getProjectCode());
/* 350 */     tradeWishOrderDTO.setProjectName(tradeWishOrder.getProjectName());
/* 351 */     tradeWishOrderDTO.setProvince(tradeWishOrder.getProvince());
/* 352 */     tradeWishOrderDTO.setQuantity(tradeWishOrder.getQuantity());
/* 353 */     tradeWishOrderDTO.setSpecialSign(tradeWishOrder.getSpecialSign());
/* 354 */     tradeWishOrderDTO.setStatus(tradeWishOrder.getStatus());
/* 355 */     tradeWishOrderDTO.setTotalPay(tradeWishOrder.getTotalPay());
/* 356 */     tradeWishOrderDTO.setTradeDictor(tradeWishOrder.getTradeDictor());
/* 357 */     tradeWishOrderDTO.setTrademark(tradeWishOrder.getTrademark());
/* 358 */     tradeWishOrderDTO.setTradeType(tradeWishOrder.getTradeType());
/* 359 */     tradeWishOrderDTO.setUserAccount(tradeWishOrder.getUserAccount());
/* 360 */     tradeWishOrderDTO.setValuationUnit(tradeWishOrder.getValuationUnit());
/* 361 */     tradeWishOrderDTO.setZipCode(tradeWishOrder.getZipCode());
/* 362 */     tradeWishOrderDTO.setStorehouse(tradeWishOrder.getStorehouse());
/* 363 */     return tradeWishOrderDTO;
/*     */   }
/*     */ 
/*     */   public static TradeWishOrder convertTradeWishOrderDTO2TradeWishOrder(TradeWishOrderDTO tradeWishOrderDTO)
/*     */   {
/* 368 */     TradeWishOrder tradeWishOrder = new TradeWishOrder();
/*     */ 
/* 370 */     tradeWishOrder.setAddress(tradeWishOrderDTO.getAddress());
/* 371 */     tradeWishOrder.setArea(tradeWishOrderDTO.getArea());
/* 372 */     tradeWishOrder.setBidPrice(tradeWishOrderDTO.getBidPrice());
/* 373 */     tradeWishOrder.setPhone(tradeWishOrderDTO.getPhone());
/* 374 */     tradeWishOrder.setCity(tradeWishOrderDTO.getCity());
/* 375 */     tradeWishOrder.setDeposit(tradeWishOrderDTO.getDeposit());
/*     */ 
/* 377 */     tradeWishOrder.setComments(tradeWishOrderDTO.getComments());
/* 378 */     tradeWishOrder.setDeal(tradeWishOrderDTO.getDeal());
/* 379 */     tradeWishOrder.setDeliveryType(tradeWishOrderDTO.getDeliveryType());
/* 380 */     tradeWishOrder.setExpectTime(tradeWishOrderDTO.getExpectTime());
/* 381 */     tradeWishOrder.setGmtCreate(tradeWishOrderDTO.getGmtCreate());
/* 382 */     tradeWishOrder.setGmtModify(tradeWishOrderDTO.getGmtModify());
/* 383 */     tradeWishOrder.setId(tradeWishOrderDTO.getId());
/* 384 */     tradeWishOrder.setIsInvoice(tradeWishOrderDTO.getIsInvoice());
/* 385 */     tradeWishOrder.setLinkMan(tradeWishOrderDTO.getLinkMan());
/* 386 */     tradeWishOrder.setMeasureUnit(tradeWishOrderDTO.getMeasureUnit());
/* 387 */     tradeWishOrder.setWishOrderNum(tradeWishOrderDTO.getWishOrderNum());
/* 388 */     tradeWishOrder.setPaymentType(tradeWishOrderDTO.getPaymentType());
/* 389 */     tradeWishOrder.setProjectCode(tradeWishOrderDTO.getProjectCode());
/* 390 */     tradeWishOrder.setProjectName(tradeWishOrderDTO.getProjectName());
/* 391 */     tradeWishOrder.setProvince(tradeWishOrderDTO.getProvince());
/* 392 */     tradeWishOrder.setQuantity(tradeWishOrderDTO.getQuantity());
/* 393 */     tradeWishOrder.setSpecialSign(tradeWishOrderDTO.getSpecialSign());
/* 394 */     tradeWishOrder.setStatus(tradeWishOrderDTO.getStatus());
/* 395 */     tradeWishOrder.setTotalPay(tradeWishOrderDTO.getTotalPay());
/* 396 */     tradeWishOrder.setTradeDictor(tradeWishOrderDTO.getTradeDictor());
/* 397 */     tradeWishOrder.setTrademark(tradeWishOrderDTO.getTrademark());
/* 398 */     tradeWishOrder.setTradeType(tradeWishOrderDTO.getTradeType());
/* 399 */     tradeWishOrder.setUserAccount(tradeWishOrderDTO.getUserAccount());
/* 400 */     tradeWishOrder.setValuationUnit(tradeWishOrderDTO.getValuationUnit());
/* 401 */     tradeWishOrder.setZipCode(tradeWishOrderDTO.getZipCode());
/* 402 */     tradeWishOrder.setStorehouse(tradeWishOrderDTO.getStorehouse());
/* 403 */     return tradeWishOrder;
/*     */   }
/*     */ 
/*     */   public static TradeWishOrder convertTradeWishOrderDTO2TradeWishOrder(PlaceOrderTradeDTO placeOrderTradeDTO, ProjectListing projectListing)
/*     */   {
/* 409 */     TradeWishOrder tradeWishOrder = new TradeWishOrder();
/*     */ 
/* 411 */     if (((EnumListingType.SELL.getValue().equals(projectListing.getListingType())) && (EnumDeliveryType.BUYERSELF.getValue().equals(placeOrderTradeDTO.getDeliveryType()))) || ((EnumListingType.BUY.getValue().equals(projectListing.getListingType())) && (EnumDeliveryType.SELLERSEND.getValue().equals(placeOrderTradeDTO.getDeliveryType()))))
/*     */     {
/* 413 */       tradeWishOrder.setProvince(projectListing.getProvince());
/* 414 */       tradeWishOrder.setCity(projectListing.getCity());
/* 415 */       tradeWishOrder.setArea(projectListing.getArea());
/* 416 */       tradeWishOrder.setLinkMan(projectListing.getLinkMan());
/* 417 */       tradeWishOrder.setPhone(projectListing.getPhone());
/* 418 */       tradeWishOrder.setAddress(projectListing.getAddress());
/* 419 */       tradeWishOrder.setZipCode(projectListing.getZipCode());
/* 420 */       tradeWishOrder.setStorehouse(projectListing.getStorehouse());
/*     */     } else {
/* 422 */       tradeWishOrder.setProvince(placeOrderTradeDTO.getProvince());
/* 423 */       tradeWishOrder.setCity(placeOrderTradeDTO.getCity());
/* 424 */       tradeWishOrder.setArea(placeOrderTradeDTO.getArea());
/* 425 */       tradeWishOrder.setLinkMan(placeOrderTradeDTO.getLinkMan());
/* 426 */       tradeWishOrder.setPhone(placeOrderTradeDTO.getPhone());
/* 427 */       tradeWishOrder.setAddress(placeOrderTradeDTO.getAddress());
/* 428 */       tradeWishOrder.setZipCode(placeOrderTradeDTO.getZipCode());
/* 429 */       tradeWishOrder.setStorehouse(placeOrderTradeDTO.getStorehouse());
/*     */     }
/* 431 */     tradeWishOrder.setBidPrice(placeOrderTradeDTO.getListingPrice());
/* 432 */     tradeWishOrder.setDeposit(placeOrderTradeDTO.getDeposit());
/*     */ 
/* 434 */     tradeWishOrder.setComments(placeOrderTradeDTO.getComments());
/* 435 */     tradeWishOrder.setDeliveryType(placeOrderTradeDTO.getDeliveryType());
/* 436 */     tradeWishOrder.setExpectTime(placeOrderTradeDTO.getDeliveryDate());
/* 437 */     tradeWishOrder.setIsInvoice(placeOrderTradeDTO.getInvoice());
/* 438 */     tradeWishOrder.setMeasureUnit(placeOrderTradeDTO.getMeasureUnit());
/* 439 */     tradeWishOrder.setPaymentType(placeOrderTradeDTO.getPaymentType());
/* 440 */     tradeWishOrder.setProjectCode(placeOrderTradeDTO.getProjectCode());
/* 441 */     tradeWishOrder.setProjectName(placeOrderTradeDTO.getProjectName());
/* 442 */     tradeWishOrder.setQuantity(placeOrderTradeDTO.getQuantity());
/*     */ 
/* 445 */     tradeWishOrder.setTotalPay(placeOrderTradeDTO.getTotalPay());
/* 446 */     tradeWishOrder.setTradeDictor(placeOrderTradeDTO.getListingType());
/*     */ 
/* 448 */     tradeWishOrder.setTradeType(placeOrderTradeDTO.getTradingType());
/* 449 */     tradeWishOrder.setUserAccount(placeOrderTradeDTO.getUserAccount());
/* 450 */     tradeWishOrder.setValuationUnit(placeOrderTradeDTO.getValuationUnit());
/* 451 */     return tradeWishOrder;
/*     */   }
/*     */ 
/*     */   public static AuctionLatestBidDTO convertauctionLatestBid2DTO(AuctionLatestBid auctionLatestBid)
/*     */   {
/* 456 */     AuctionLatestBidDTO auctionLatestBidDTO = new AuctionLatestBidDTO();
/* 457 */     auctionLatestBidDTO.setId(auctionLatestBid.getId());
/* 458 */     auctionLatestBidDTO.setProjectCode(auctionLatestBid.getProjectCode());
/* 459 */     auctionLatestBidDTO.setBidderTrademark(auctionLatestBid.getBidderTrademark());
/* 460 */     auctionLatestBidDTO.setLatestBid(auctionLatestBid.getLatestBid());
/* 461 */     auctionLatestBidDTO.setIsPriority(auctionLatestBid.getIsPriority());
/* 462 */     auctionLatestBidDTO.setLatestBidTime(auctionLatestBid.getLatestBidTime());
/* 463 */     auctionLatestBidDTO.setNextBidEndtime(auctionLatestBid.getNextBidEndtime());
/* 464 */     auctionLatestBidDTO.setLatestStatus(auctionLatestBid.getLatestStatus());
/* 465 */     auctionLatestBidDTO.setBidRate(auctionLatestBid.getBidRate());
/* 466 */     auctionLatestBidDTO.setLastBidTrademark(auctionLatestBid.getLastBidTrademark());
/* 467 */     auctionLatestBidDTO.setGmtCreate(auctionLatestBid.getGmtCreate());
/* 468 */     auctionLatestBidDTO.setGmtModify(auctionLatestBid.getGmtModify());
/* 469 */     auctionLatestBidDTO.setOperator(auctionLatestBid.getOperator());
/* 470 */     auctionLatestBidDTO.setNextBidInterval(auctionLatestBid.getNextBidInterval());
/* 471 */     return auctionLatestBidDTO;
/*     */   }
/*     */ 
/*     */   public static AuctionResultDTO convertAuctionResult2DTO(AuctionResult auctionResult)
/*     */   {
/* 476 */     AuctionResultDTO auctionResultDTO = new AuctionResultDTO();
/* 477 */     auctionResultDTO.setId(auctionResult.getId());
/* 478 */     auctionResultDTO.setProjectCode(auctionResult.getProjectCode());
/* 479 */     auctionResultDTO.setTranResult(auctionResult.getTranResult());
/* 480 */     auctionResultDTO.setPrice(auctionResult.getPrice());
/* 481 */     auctionResultDTO.setAuctioneerAccount(auctionResult.getAuctioneerAccount());
/* 482 */     auctionResultDTO.setValuationUnit(auctionResult.getValuationUnit());
/* 483 */     auctionResultDTO.setBidderAccount(auctionResult.getBidderAccount());
/* 484 */     auctionResultDTO.setBidderTrademark(auctionResult.getBidderTrademark());
/* 485 */     auctionResultDTO.setEndTime(auctionResult.getEndTime());
/* 486 */     auctionResultDTO.setRemark(auctionResult.getRemark());
/* 487 */     auctionResultDTO.setGmtCreate(auctionResult.getGmtCreate());
/* 488 */     auctionResultDTO.setGmtModify(auctionResult.getGmtModify());
/* 489 */     auctionResultDTO.setOperator(auctionResult.getOperator());
/* 490 */     return auctionResultDTO;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.qingbo.biz.util.ConvertUtils
 * JD-Core Version:    0.6.0
 */