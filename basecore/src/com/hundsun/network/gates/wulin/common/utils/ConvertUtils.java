/*     */ package com.hundsun.network.gates.wulin.common.utils;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.remote.BaseTradeDTO;
/*     */ import com.hundsun.network.gates.luosi.common.utils.CopyUtil;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.AnnouncementDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.ProjectBaseSettingDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.ProjectListingDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.ProjectMetasDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.ProjectTypeAttriDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.ProjectTypeDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.TradeOrderCcDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.TradeOrderDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.TradeWishOrderDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.UserAccountDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.ProjectAuditLogRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.ProjectListingRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.TradeOrderCcRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.TradeWishOrderRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.UserRegisterRequset;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.operation.Announcement;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.order.TradeOrder;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.order.TradeOrderAndPro;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.order.TradeOrderCc;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.project.ProjectAuditLog;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.project.ProjectBaseSetting;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.project.ProjectListing;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.project.ProjectMetas;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.project.ProjectType;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.project.ProjectTypeAttri;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.query.AnnouncementQuery;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.trade.TradeWishOrder;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.user.UserAccount;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.commons.beanutils.BeanUtils;
/*     */ 
/*     */ public class ConvertUtils
/*     */ {
/*     */   public static ProjectListingDTO convertProjectListing2ProjectListDTO(ProjectListing projectListing)
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
/*  83 */     projectListingDTO.setProvince(projectListing.getProvince());
/*  84 */     projectListingDTO.setCity(projectListing.getCity());
/*  85 */     projectListingDTO.setArea(projectListing.getArea());
/*  86 */     projectListingDTO.setAddress(projectListing.getAddress());
/*  87 */     projectListingDTO.setLinkMan(projectListing.getLinkMan());
/*  88 */     projectListingDTO.setZipCode(projectListing.getZipCode());
/*  89 */     projectListingDTO.setPhone(projectListing.getPhone());
/*  90 */     projectListingDTO.setStorehouse(projectListing.getStorehouse());
/*     */ 
/*  92 */     projectListingDTO.setPicturePath(projectListing.getPicturePath());
/*  93 */     projectListingDTO.setPicturePath1(projectListing.getPicturePath1());
/*  94 */     projectListingDTO.setPicturePath2(projectListing.getPicturePath2());
/*  95 */     projectListingDTO.setPicturePath3(projectListing.getPicturePath3());
/*  96 */     projectListingDTO.setPicturePath4(projectListing.getPicturePath4());
/*  97 */     projectListingDTO.setBreedStandardId(projectListing.getBreedStandardId());
/*  98 */     projectListingDTO.setDescription(projectListing.getDescription());
/*  99 */     return projectListingDTO;
/*     */   }
/*     */ 
/*     */   public static UserAccount convert(UserAccountDTO userAccountDTO)
/*     */   {
/* 109 */     UserAccount account = new UserAccount();
/*     */     try
/*     */     {
/* 146 */       BeanUtils.copyProperties(account, userAccountDTO);
/*     */     } catch (Exception e) {
/* 148 */       e.printStackTrace();
/*     */     }
/* 150 */     return account;
/*     */   }
/*     */ 
/*     */   public static UserAccountDTO convert(UserAccount account)
/*     */   {
/* 159 */     UserAccountDTO userAccountDTO = new UserAccountDTO();
/*     */     try
/*     */     {
/* 195 */       BeanUtils.copyProperties(userAccountDTO, account);
/*     */     } catch (Exception e) {
/* 197 */       e.printStackTrace();
/*     */     }
/* 199 */     return userAccountDTO;
/*     */   }
/*     */ 
/*     */   public static UserAccount convertRegRequest2UAccount(UserRegisterRequset request)
/*     */   {
/* 208 */     if (null == request) {
/* 209 */       return null;
/*     */     }
/* 211 */     return convert(request.getUserAccountDTO());
/*     */   }
/*     */ 
/*     */   public static ProjectListingRequest convertProjectListing2Request(ProjectListing projectListing)
/*     */   {
/* 220 */     ProjectListingRequest request = new ProjectListingRequest();
/* 221 */     ProjectListingDTO projectListingDTO = new ProjectListingDTO();
/* 222 */     CopyUtil.copyProperties(projectListing, projectListingDTO);
/* 223 */     request.setProjectListingDTO(projectListingDTO);
/* 224 */     return request;
/*     */   }
/*     */ 
/*     */   public static ProjectListing convertRequest2ProjectListing(ProjectListingRequest projectListingRequest)
/*     */   {
/* 234 */     ProjectListing projectListing = new ProjectListing();
/* 235 */     CopyUtil.copyProperties(projectListingRequest.getProjectListingDTO(), projectListing);
/* 236 */     return projectListing;
/*     */   }
/*     */ 
/*     */   public static ProjectMetas convertRequest2Metas(ProjectMetasDTO metasDTO)
/*     */   {
/* 245 */     ProjectMetas metas = new ProjectMetas();
/* 246 */     CopyUtil.copyProperties(metasDTO, metas);
/* 247 */     return metas;
/*     */   }
/*     */ 
/*     */   public static ProjectTypeDTO convert(ProjectType type) {
/* 251 */     ProjectTypeDTO dto = new ProjectTypeDTO();
/* 252 */     if (null == type) {
/* 253 */       return null;
/*     */     }
/* 255 */     dto.setCode(type.getCode());
/* 256 */     dto.setEnable(type.getEnable());
/* 257 */     dto.setGmtCreate(type.getGmtCreate());
/* 258 */     dto.setGmtModify(type.getGmtModify());
/* 259 */     dto.setId(type.getId());
/* 260 */     dto.setName(type.getName());
/* 261 */     dto.setOperator(type.getOperator());
/* 262 */     dto.setParCode(type.getParCode());
/* 263 */     dto.setRank(type.getRank());
/* 264 */     dto.setRemark(type.getRemark());
/* 265 */     return dto;
/*     */   }
/*     */ 
/*     */   public static ProjectTypeAttriDTO convert(ProjectTypeAttri typeAttri) {
/* 269 */     ProjectTypeAttriDTO dto = new ProjectTypeAttriDTO();
/* 270 */     dto.setEnable(typeAttri.getEnable());
/* 271 */     dto.setGmtCreate(typeAttri.getGmtCreate());
/* 272 */     dto.setGmtModify(typeAttri.getGmtModify());
/* 273 */     dto.setId(typeAttri.getId());
/* 274 */     dto.setInputType(typeAttri.getInputType());
/* 275 */     dto.setIsRequired(typeAttri.getIsRequired());
/* 276 */     dto.setKeyName(typeAttri.getKeyName());
/* 277 */     dto.setKeyTitle(typeAttri.getKeyTitle());
/* 278 */     dto.setOperator(typeAttri.getOperator());
/* 279 */     dto.setProTypeCode(typeAttri.getProTypeCode());
/* 280 */     dto.setRank(typeAttri.getRank());
/* 281 */     dto.setRemark(typeAttri.getRemark());
/* 282 */     dto.setText(typeAttri.getText());
/* 283 */     dto.setValueValidate(typeAttri.getValueValidate());
/* 284 */     return dto;
/*     */   }
/*     */ 
/*     */   public static ProjectAuditLog convertRequest2ProjectAuditLog(ProjectAuditLogRequest projectAuditLogRequest)
/*     */   {
/* 289 */     ProjectAuditLog projectAuditLog = new ProjectAuditLog();
/*     */     try {
/* 291 */       BeanUtils.copyProperties(projectAuditLog, projectAuditLogRequest.getProjectAuditLogDTO());
/*     */     }
/*     */     catch (Exception e) {
/* 294 */       e.printStackTrace();
/*     */     }
/* 296 */     return projectAuditLog;
/*     */   }
/*     */ 
/*     */   public static ProjectListing convertRequest2ProjectListing(ProjectAuditLogRequest projectAuditLogReques)
/*     */   {
/* 301 */     ProjectListing projectListing = new ProjectListing();
/* 302 */     projectListing = convertProjectListingDTO2ProjectListing(projectAuditLogReques.getProjectListingDTO());
/*     */ 
/* 304 */     return projectListing;
/*     */   }
/*     */ 
/*     */   public static TradeWishOrderDTO convertTradeWishOrder2TradeWishOrderDTO(TradeWishOrder tradeWishOrder)
/*     */   {
/* 309 */     TradeWishOrderDTO tradeWishOrderDTO = new TradeWishOrderDTO();
/*     */ 
/* 311 */     tradeWishOrderDTO.setAddress(tradeWishOrder.getAddress());
/* 312 */     tradeWishOrderDTO.setArea(tradeWishOrder.getArea());
/* 313 */     tradeWishOrderDTO.setBidPrice(tradeWishOrder.getBidPrice());
/* 314 */     tradeWishOrderDTO.setPhone(tradeWishOrder.getPhone());
/* 315 */     tradeWishOrderDTO.setCity(tradeWishOrder.getCity());
/* 316 */     tradeWishOrderDTO.setDeposit(tradeWishOrder.getDeposit());
/* 317 */     tradeWishOrderDTO.setZipCode(tradeWishOrder.getZipCode());
/* 318 */     tradeWishOrderDTO.setComments(tradeWishOrder.getComments());
/* 319 */     tradeWishOrderDTO.setDeal(tradeWishOrder.getDeal());
/* 320 */     tradeWishOrderDTO.setDeliveryType(tradeWishOrder.getDeliveryType());
/* 321 */     tradeWishOrderDTO.setExpectTime(tradeWishOrder.getExpectTime());
/* 322 */     tradeWishOrderDTO.setGmtCreate(tradeWishOrder.getGmtCreate());
/* 323 */     tradeWishOrderDTO.setGmtModify(tradeWishOrder.getGmtModify());
/* 324 */     tradeWishOrderDTO.setId(tradeWishOrder.getId());
/* 325 */     tradeWishOrderDTO.setIsInvoice(tradeWishOrder.getIsInvoice());
/* 326 */     tradeWishOrderDTO.setLinkMan(tradeWishOrder.getLinkMan());
/* 327 */     tradeWishOrderDTO.setMeasureUnit(tradeWishOrder.getMeasureUnit());
/* 328 */     tradeWishOrderDTO.setWishOrderNum(tradeWishOrder.getWishOrderNum());
/* 329 */     tradeWishOrderDTO.setPaymentType(tradeWishOrder.getPaymentType());
/* 330 */     tradeWishOrderDTO.setProjectCode(tradeWishOrder.getProjectCode());
/* 331 */     tradeWishOrderDTO.setProjectName(tradeWishOrder.getProjectName());
/* 332 */     tradeWishOrderDTO.setProvince(tradeWishOrder.getProvince());
/* 333 */     tradeWishOrderDTO.setQuantity(tradeWishOrder.getQuantity());
/* 334 */     tradeWishOrderDTO.setSpecialSign(tradeWishOrder.getSpecialSign());
/* 335 */     tradeWishOrderDTO.setStatus(tradeWishOrder.getStatus());
/* 336 */     tradeWishOrderDTO.setTotalPay(tradeWishOrder.getTotalPay());
/* 337 */     tradeWishOrderDTO.setTradeDictor(tradeWishOrder.getTradeDictor());
/* 338 */     tradeWishOrderDTO.setTrademark(tradeWishOrder.getTrademark());
/* 339 */     tradeWishOrderDTO.setTradeType(tradeWishOrder.getTradeType());
/* 340 */     tradeWishOrderDTO.setUserAccount(tradeWishOrder.getUserAccount());
/* 341 */     tradeWishOrderDTO.setValuationUnit(tradeWishOrder.getValuationUnit());
/*     */ 
/* 343 */     return tradeWishOrderDTO;
/*     */   }
/*     */ 
/*     */   public static TradeWishOrder convertTradeWishOrderDTO2TradeWishOrder(TradeWishOrderDTO tradeWishOrderDTO)
/*     */   {
/* 348 */     TradeWishOrder tradeWishOrder = new TradeWishOrder();
/*     */ 
/* 350 */     tradeWishOrder.setAddress(tradeWishOrderDTO.getAddress());
/* 351 */     tradeWishOrder.setArea(tradeWishOrderDTO.getArea());
/* 352 */     tradeWishOrder.setBidPrice(tradeWishOrderDTO.getBidPrice());
/* 353 */     tradeWishOrder.setPhone(tradeWishOrderDTO.getPhone());
/* 354 */     tradeWishOrder.setCity(tradeWishOrderDTO.getCity());
/* 355 */     tradeWishOrder.setDeposit(tradeWishOrderDTO.getDeposit());
/* 356 */     tradeWishOrder.setZipCode(tradeWishOrderDTO.getZipCode());
/* 357 */     tradeWishOrder.setComments(tradeWishOrderDTO.getComments());
/* 358 */     tradeWishOrder.setDeal(tradeWishOrderDTO.getDeal());
/* 359 */     tradeWishOrder.setDeliveryType(tradeWishOrderDTO.getDeliveryType());
/* 360 */     tradeWishOrder.setExpectTime(tradeWishOrderDTO.getExpectTime());
/* 361 */     tradeWishOrder.setGmtCreate(tradeWishOrderDTO.getGmtCreate());
/* 362 */     tradeWishOrder.setGmtModify(tradeWishOrderDTO.getGmtModify());
/* 363 */     tradeWishOrder.setId(tradeWishOrderDTO.getId());
/* 364 */     tradeWishOrder.setIsInvoice(tradeWishOrderDTO.getIsInvoice());
/* 365 */     tradeWishOrder.setLinkMan(tradeWishOrderDTO.getLinkMan());
/* 366 */     tradeWishOrder.setMeasureUnit(tradeWishOrderDTO.getMeasureUnit());
/* 367 */     tradeWishOrder.setWishOrderNum(tradeWishOrderDTO.getWishOrderNum());
/* 368 */     tradeWishOrder.setPaymentType(tradeWishOrderDTO.getPaymentType());
/* 369 */     tradeWishOrder.setProjectCode(tradeWishOrderDTO.getProjectCode());
/* 370 */     tradeWishOrder.setProjectName(tradeWishOrderDTO.getProjectName());
/* 371 */     tradeWishOrder.setProvince(tradeWishOrderDTO.getProvince());
/* 372 */     tradeWishOrder.setQuantity(tradeWishOrderDTO.getQuantity());
/* 373 */     tradeWishOrder.setSpecialSign(tradeWishOrderDTO.getSpecialSign());
/* 374 */     tradeWishOrder.setStatus(tradeWishOrderDTO.getStatus());
/* 375 */     tradeWishOrder.setTotalPay(tradeWishOrderDTO.getTotalPay());
/* 376 */     tradeWishOrder.setTradeDictor(tradeWishOrderDTO.getTradeDictor());
/* 377 */     tradeWishOrder.setTrademark(tradeWishOrderDTO.getTrademark());
/* 378 */     tradeWishOrder.setTradeType(tradeWishOrderDTO.getTradeType());
/* 379 */     tradeWishOrder.setUserAccount(tradeWishOrderDTO.getUserAccount());
/* 380 */     tradeWishOrder.setValuationUnit(tradeWishOrderDTO.getValuationUnit());
/* 381 */     return tradeWishOrder;
/*     */   }
/*     */ 
/*     */   public static TradeWishOrder convertTradeWishOrderDTO2TradeWishOrder(TradeWishOrderRequest request)
/*     */   {
/* 391 */     TradeWishOrder tradeWishOrder = convertTradeWishOrderDTO2TradeWishOrder(request.getTradeWishOrderDTO());
/*     */ 
/* 393 */     return tradeWishOrder;
/*     */   }
/*     */ 
/*     */   public static ProjectListingDTO convertProjectListing2ProjectListingDTO(ProjectListing projectListing)
/*     */   {
/* 403 */     ProjectListingDTO projectListingDTO = new ProjectListingDTO();
/* 404 */     projectListingDTO.setId(projectListing.getId());
/* 405 */     projectListingDTO.setTitle(projectListing.getTitle());
/* 406 */     projectListingDTO.setCode(projectListing.getCode());
/* 407 */     projectListingDTO.setUserId(projectListing.getUserId());
/* 408 */     projectListingDTO.setUserAccount(projectListing.getUserAccount());
/* 409 */     projectListingDTO.setFundAccount(projectListing.getFundAccount());
/* 410 */     projectListingDTO.setListingType(projectListing.getListingType());
/* 411 */     projectListingDTO.setMeasureUnit(projectListing.getMeasureUnit());
/* 412 */     projectListingDTO.setQuantity(projectListing.getQuantity());
/* 413 */     projectListingDTO.setValuationUnit(projectListing.getValuationUnit());
/* 414 */     projectListingDTO.setListingPrice(projectListing.getListingPrice());
/* 415 */     projectListingDTO.setMultipleBase(projectListing.getMultipleBase());
/* 416 */     projectListingDTO.setMaxQuantity(projectListing.getMaxQuantity());
/* 417 */     projectListingDTO.setMinQuantity(projectListing.getMinQuantity());
/* 418 */     projectListingDTO.setRetail(projectListing.getRetail());
/* 419 */     projectListingDTO.setProjectTypeCode(projectListing.getProjectTypeCode());
/* 420 */     projectListingDTO.setBreedStandard(projectListing.getBreedStandard());
/* 421 */     projectListingDTO.setTradingType(projectListing.getTradingType());
/* 422 */     projectListingDTO.setDeliveryDate(projectListing.getDeliveryDate());
/* 423 */     projectListingDTO.setDeliveryPlace(projectListing.getDeliveryPlace());
/* 424 */     projectListingDTO.setDeliveryType(projectListing.getDeliveryType());
/* 425 */     projectListingDTO.setPaymentType(projectListing.getPaymentType());
/* 426 */     projectListingDTO.setListingStartTime(projectListing.getListingStartTime());
/* 427 */     projectListingDTO.setListingEndTime(projectListing.getListingEndTime());
/* 428 */     projectListingDTO.setInvoice(projectListing.getInvoice());
/* 429 */     projectListingDTO.setStatus(projectListing.getStatus());
/* 430 */     projectListingDTO.setProcessAuditNodes(projectListing.getProcessAuditNodes());
/* 431 */     projectListingDTO.setAuditNode(projectListing.getAuditNode());
/* 432 */     projectListingDTO.setCreator(projectListing.getCreator());
/* 433 */     projectListingDTO.setCreatorType(projectListing.getCreatorType());
/* 434 */     projectListingDTO.setOperator(projectListing.getOperator());
/* 435 */     projectListingDTO.setGmtCreate(projectListing.getGmtCreate());
/* 436 */     projectListingDTO.setGmtModify(projectListing.getGmtModify());
/* 437 */     projectListingDTO.setDeposit(projectListing.getDeposit());
/*     */ 
/* 439 */     projectListingDTO.setProvince(projectListing.getProvince());
/* 440 */     projectListingDTO.setCity(projectListing.getCity());
/* 441 */     projectListingDTO.setArea(projectListing.getArea());
/* 442 */     projectListingDTO.setAddress(projectListing.getAddress());
/* 443 */     projectListingDTO.setLinkMan(projectListing.getLinkMan());
/* 444 */     projectListingDTO.setZipCode(projectListing.getZipCode());
/* 445 */     projectListingDTO.setPhone(projectListing.getPhone());
/* 446 */     projectListingDTO.setStorehouse(projectListing.getStorehouse());
/*     */ 
/* 448 */     projectListingDTO.setPicturePath(projectListing.getPicturePath());
/* 449 */     projectListingDTO.setPicturePath1(projectListing.getPicturePath1());
/* 450 */     projectListingDTO.setPicturePath2(projectListing.getPicturePath2());
/* 451 */     projectListingDTO.setPicturePath3(projectListing.getPicturePath3());
/* 452 */     projectListingDTO.setPicturePath4(projectListing.getPicturePath4());
/* 453 */     projectListingDTO.setBreedStandardId(projectListing.getBreedStandardId());
/* 454 */     projectListingDTO.setDescription(projectListing.getDescription());
/* 455 */     return projectListingDTO;
/*     */   }
/*     */ 
/*     */   public static ProjectListing convertProjectListingDTO2ProjectListing(ProjectListingDTO projectListingDTO)
/*     */   {
/* 460 */     ProjectListing projectListing = new ProjectListing();
/* 461 */     projectListing.setId(projectListingDTO.getId());
/* 462 */     projectListing.setTitle(projectListingDTO.getTitle());
/* 463 */     projectListing.setCode(projectListingDTO.getCode());
/* 464 */     projectListing.setUserId(projectListingDTO.getUserId());
/* 465 */     projectListing.setUserAccount(projectListingDTO.getUserAccount());
/* 466 */     projectListing.setFundAccount(projectListingDTO.getFundAccount());
/* 467 */     projectListing.setListingType(projectListingDTO.getListingType());
/* 468 */     projectListing.setMeasureUnit(projectListingDTO.getMeasureUnit());
/* 469 */     projectListing.setQuantity(projectListingDTO.getQuantity());
/* 470 */     projectListing.setValuationUnit(projectListingDTO.getValuationUnit());
/* 471 */     projectListing.setListingPrice(projectListingDTO.getListingPrice());
/* 472 */     projectListing.setMultipleBase(projectListingDTO.getMultipleBase());
/* 473 */     projectListing.setMaxQuantity(projectListingDTO.getMaxQuantity());
/* 474 */     projectListing.setMinQuantity(projectListingDTO.getMinQuantity());
/* 475 */     projectListing.setRetail(projectListingDTO.getRetail());
/* 476 */     projectListing.setProjectTypeCode(projectListingDTO.getProjectTypeCode());
/* 477 */     projectListing.setBreedStandard(projectListingDTO.getBreedStandard());
/* 478 */     projectListing.setTradingType(projectListingDTO.getTradingType());
/* 479 */     projectListing.setDeliveryDate(projectListingDTO.getDeliveryDate());
/* 480 */     projectListing.setDeliveryPlace(projectListingDTO.getDeliveryPlace());
/* 481 */     projectListing.setDeliveryType(projectListingDTO.getDeliveryType());
/* 482 */     projectListing.setPaymentType(projectListingDTO.getPaymentType());
/* 483 */     projectListing.setListingStartTime(projectListingDTO.getListingStartTime());
/* 484 */     projectListing.setListingEndTime(projectListingDTO.getListingEndTime());
/* 485 */     projectListing.setInvoice(projectListingDTO.getInvoice());
/* 486 */     projectListing.setStatus(projectListingDTO.getStatus());
/* 487 */     projectListing.setProcessAuditNodes(projectListingDTO.getProcessAuditNodes());
/* 488 */     projectListing.setAuditNode(projectListingDTO.getAuditNode());
/* 489 */     projectListing.setCreator(projectListingDTO.getCreator());
/* 490 */     projectListing.setCreatorType(projectListingDTO.getCreatorType());
/* 491 */     projectListing.setOperator(projectListingDTO.getOperator());
/* 492 */     projectListing.setGmtCreate(projectListingDTO.getGmtCreate());
/* 493 */     projectListing.setGmtModify(projectListingDTO.getGmtModify());
/* 494 */     projectListing.setDeposit(projectListingDTO.getDeposit());
/* 495 */     projectListing.setProvince(projectListingDTO.getProvince());
/* 496 */     projectListing.setCity(projectListingDTO.getCity());
/* 497 */     projectListing.setArea(projectListingDTO.getArea());
/* 498 */     projectListing.setAddress(projectListingDTO.getAddress());
/* 499 */     projectListing.setLinkMan(projectListingDTO.getLinkMan());
/* 500 */     projectListing.setZipCode(projectListingDTO.getZipCode());
/* 501 */     projectListing.setPhone(projectListingDTO.getPhone());
/* 502 */     projectListing.setStorehouse(projectListingDTO.getStorehouse());
/*     */ 
/* 504 */     projectListing.setPicturePath(projectListingDTO.getPicturePath());
/* 505 */     projectListing.setPicturePath1(projectListingDTO.getPicturePath1());
/* 506 */     projectListing.setPicturePath2(projectListingDTO.getPicturePath2());
/* 507 */     projectListing.setPicturePath3(projectListingDTO.getPicturePath3());
/* 508 */     projectListing.setPicturePath4(projectListingDTO.getPicturePath4());
/* 509 */     projectListing.setBreedStandardId(projectListingDTO.getBreedStandardId());
/* 510 */     projectListing.setDescription(projectListingDTO.getDescription());
/* 511 */     projectListing.setTradeMetasList(copyProjectMetasDTOList2ProjectMetas(projectListingDTO.getTradeMetasList()));
/*     */ 
/* 513 */     projectListing.setAttachedFilePath(projectListingDTO.getAttachedFilePath());
/* 514 */     projectListing.setSubstationId(projectListingDTO.getSubstationId());
/* 515 */     return projectListing;
/*     */   }
/*     */ 
/*     */   public static TradeOrderCc convert(TradeOrderCcDTO tradeOrderCcDTO)
/*     */   {
/* 525 */     TradeOrderCc tradeOrderCc = new TradeOrderCc();
/* 526 */     tradeOrderCc.setAttactment(tradeOrderCcDTO.getAttactment());
/* 527 */     tradeOrderCc.setAuditDate(tradeOrderCcDTO.getAuditDate());
/* 528 */     tradeOrderCc.setAuditor(tradeOrderCcDTO.getAuditor());
/* 529 */     tradeOrderCc.setBuyerAccount(tradeOrderCcDTO.getBuyerAccount());
/* 530 */     tradeOrderCc.setCcStartor(tradeOrderCcDTO.getCcStartor());
/* 531 */     tradeOrderCc.setCcType(tradeOrderCcDTO.getCcType());
/* 532 */     tradeOrderCc.setCreator(tradeOrderCcDTO.getCreator());
/* 533 */     tradeOrderCc.setDescript(tradeOrderCcDTO.getDescript());
/* 534 */     tradeOrderCc.setId(tradeOrderCcDTO.getId());
/* 535 */     tradeOrderCc.setMessage(tradeOrderCcDTO.getMessage());
/* 536 */     tradeOrderCc.setBuyerAmount(tradeOrderCcDTO.getBuyerAmount());
/* 537 */     tradeOrderCc.setBuyerCredit(tradeOrderCcDTO.getBuyerCredit());
/* 538 */     tradeOrderCc.setSellerAmount(tradeOrderCcDTO.getSellerAmount());
/* 539 */     tradeOrderCc.setSellerCredit(tradeOrderCcDTO.getSellerCredit());
/* 540 */     tradeOrderCc.setOperator(tradeOrderCcDTO.getOperator());
/* 541 */     tradeOrderCc.setOrderCcNum(tradeOrderCcDTO.getOrderCcNum());
/* 542 */     tradeOrderCc.setOrderNo(tradeOrderCcDTO.getOrderNo());
/* 543 */     tradeOrderCc.setReason(tradeOrderCcDTO.getReason());
/* 544 */     tradeOrderCc.setRemark(tradeOrderCcDTO.getRemark());
/* 545 */     tradeOrderCc.setSellerAccount(tradeOrderCcDTO.getSellerAccount());
/* 546 */     tradeOrderCc.setStatus(tradeOrderCcDTO.getStatus());
/* 547 */     tradeOrderCc.setComplainedType(tradeOrderCcDTO.getComplainedType());
/* 548 */     tradeOrderCc.setDealType(tradeOrderCcDTO.getDealType());
/* 549 */     tradeOrderCc.setDealMoney(tradeOrderCcDTO.getDealMoney());
/* 550 */     return tradeOrderCc;
/*     */   }
/*     */ 
/*     */   public static TradeOrderCc convert(TradeOrderCcRequest request)
/*     */   {
/* 559 */     TradeOrderCc tradeOrderCc = convert(request.getTradeOrderCcDTO());
/* 560 */     return tradeOrderCc;
/*     */   }
/*     */ 
/*     */   public static AnnouncementQuery<Announcement> convert2AnnouncementQuery(AnnouncementDTO announcementDTO)
/*     */   {
/* 565 */     AnnouncementQuery query = new AnnouncementQuery();
/* 566 */     query.setId(announcementDTO.getId());
/* 567 */     query.setTitle(announcementDTO.getTitle());
/* 568 */     query.setType(announcementDTO.getType());
/* 569 */     query.setProjectId(announcementDTO.getProjectId());
/* 570 */     return query;
/*     */   }
/*     */ 
/*     */   public static AnnouncementDTO convert2AnnouncementDTO(Announcement announcement) {
/* 574 */     AnnouncementDTO announcementDTO = new AnnouncementDTO();
/* 575 */     announcementDTO.setId(announcement.getId());
/* 576 */     announcementDTO.setTitle(announcement.getTitle());
/* 577 */     announcementDTO.setContent(announcement.getContent());
/* 578 */     announcementDTO.setType(announcement.getType());
/* 579 */     announcementDTO.setProjectId(announcement.getProjectId());
/* 580 */     announcementDTO.setStatus(announcement.getStatus());
/* 581 */     announcementDTO.setCreatorType(announcement.getCreatorType());
/* 582 */     announcementDTO.setCreator(announcement.getCreator());
/* 583 */     announcementDTO.setGmtCreate(announcement.getGmtCreate());
/* 584 */     announcementDTO.setGmtModify(announcement.getGmtModify());
/* 585 */     announcementDTO.setOperatorType(announcement.getOperatorType());
/* 586 */     announcementDTO.setOperator(announcement.getOperator());
/* 587 */     return announcementDTO;
/*     */   }
/*     */ 
/*     */   public static Announcement convert2Announcement(AnnouncementDTO announcementDTO) {
/* 591 */     Announcement announcement = new Announcement();
/* 592 */     announcement.setId(announcementDTO.getId());
/* 593 */     announcement.setTitle(announcementDTO.getTitle());
/* 594 */     announcement.setContent(announcementDTO.getContent());
/* 595 */     announcement.setType(announcementDTO.getType());
/* 596 */     announcement.setProjectId(announcementDTO.getProjectId());
/* 597 */     announcement.setStatus(announcementDTO.getStatus());
/* 598 */     announcement.setCreator(announcementDTO.getCreator());
/* 599 */     announcement.setCreatorType(announcementDTO.getCreatorType());
/* 600 */     announcement.setOperator(announcementDTO.getOperator());
/* 601 */     announcement.setOperatorType(announcementDTO.getOperatorType());
/* 602 */     return announcement;
/*     */   }
/*     */ 
/*     */   public static BaseTradeDTO convertProjectListing2BaseTradeDTO(ProjectListing projectListing) {
/* 606 */     BaseTradeDTO baseTradeDTO = new BaseTradeDTO();
/* 607 */     baseTradeDTO.setProjectCode(projectListing.getCode());
/* 608 */     baseTradeDTO.setUserAccount(projectListing.getUserAccount());
/* 609 */     baseTradeDTO.setListingType(projectListing.getListingType());
/* 610 */     baseTradeDTO.setQuantity(projectListing.getQuantity());
/* 611 */     baseTradeDTO.setListingPrice(projectListing.getListingPrice());
/* 612 */     baseTradeDTO.setMultipleBase(projectListing.getMultipleBase());
/* 613 */     baseTradeDTO.setMaxQuantity(projectListing.getMaxQuantity());
/* 614 */     baseTradeDTO.setMinQuantity(projectListing.getMinQuantity());
/* 615 */     baseTradeDTO.setRetail(projectListing.getRetail());
/* 616 */     baseTradeDTO.setProjectTypeCode(projectListing.getProjectTypeCode());
/* 617 */     baseTradeDTO.setTradingType(projectListing.getTradingType());
/* 618 */     baseTradeDTO.setListingStartTime(projectListing.getListingStartTime());
/* 619 */     baseTradeDTO.setListingEndTime(projectListing.getListingEndTime());
/* 620 */     baseTradeDTO.setDeposit(projectListing.getDeposit());
/* 621 */     return baseTradeDTO;
/*     */   }
/*     */ 
/*     */   public static TradeOrder convertTradeOrderDTO2TradeOrder(TradeOrderDTO tradeOrderDTO) {
/* 625 */     TradeOrder tradeOrder = new TradeOrder();
/* 626 */     tradeOrder.setId(tradeOrderDTO.getId());
/* 627 */     tradeOrder.setOrderNo(tradeOrderDTO.getOrderNo());
/* 628 */     tradeOrder.setTradingType(tradeOrderDTO.getTradingType());
/* 629 */     tradeOrder.setBidPrice(tradeOrderDTO.getBidPrice());
/* 630 */     tradeOrder.setValuationUnit(tradeOrderDTO.getValuationUnit());
/* 631 */     tradeOrder.setQuantity(tradeOrderDTO.getQuantity());
/* 632 */     tradeOrder.setMeasureUnit(tradeOrderDTO.getMeasureUnit());
/* 633 */     tradeOrder.setOrderAmount(tradeOrderDTO.getOrderAmount());
/* 634 */     tradeOrder.setHasSellerConfirm(tradeOrderDTO.getHasSellerConfirm());
/* 635 */     tradeOrder.setHasBuyerConfirm(tradeOrderDTO.getHasBuyerConfirm());
/* 636 */     tradeOrder.setSellerDepositAmount(tradeOrderDTO.getSellerDepositAmount());
/* 637 */     tradeOrder.setBuyerDepositAmount(tradeOrderDTO.getBuyerDepositAmount());
/* 638 */     tradeOrder.setDeliveryType(tradeOrderDTO.getDeliveryType());
/* 639 */     tradeOrder.setPaymentType(tradeOrderDTO.getPaymentType());
/* 640 */     tradeOrder.setHasPay(tradeOrderDTO.getHasPay());
/* 641 */     tradeOrder.setSellerAccount(tradeOrderDTO.getSellerAccount());
/* 642 */     tradeOrder.setBuyerAccount(tradeOrderDTO.getBuyerAccount());
/* 643 */     tradeOrder.setExpectTime(tradeOrderDTO.getExpectTime());
/* 644 */     tradeOrder.setEndDatePay(tradeOrderDTO.getEndDatePay());
/* 645 */     tradeOrder.setEndDateGoods(tradeOrderDTO.getEndDateGoods());
/* 646 */     tradeOrder.setEndDateBill(tradeOrderDTO.getEndDateBill());
/* 647 */     tradeOrder.setHasSellerRank(tradeOrderDTO.getHasSellerRank());
/* 648 */     tradeOrder.setHasBuyerRank(tradeOrderDTO.getHasBuyerRank());
/* 649 */     tradeOrder.setHasInvoice(tradeOrderDTO.getHasInvoice());
/* 650 */     tradeOrder.setWishOrderNum(tradeOrderDTO.getWishOrderNum());
/* 651 */     tradeOrder.setProjectCode(tradeOrderDTO.getProjectCode());
/* 652 */     tradeOrder.setProjectName(tradeOrderDTO.getProjectName());
/* 653 */     tradeOrder.setStatus(tradeOrderDTO.getStatus());
/* 654 */     return tradeOrder;
/*     */   }
/*     */ 
/*     */   public static TradeOrderDTO convertTradeOrderAndPro2TradeOrderDTO(TradeOrderAndPro tradeOrder) {
/* 658 */     TradeOrderDTO tradeOrderDTO = new TradeOrderDTO();
/* 659 */     tradeOrderDTO.setId(tradeOrder.getId());
/* 660 */     tradeOrderDTO.setOrderNo(tradeOrder.getOrderNo());
/* 661 */     tradeOrderDTO.setTradingType(tradeOrder.getTradingType());
/* 662 */     tradeOrderDTO.setBidPrice(tradeOrder.getBidPrice());
/* 663 */     tradeOrderDTO.setValuationUnit(tradeOrder.getValuationUnit());
/* 664 */     tradeOrderDTO.setQuantity(tradeOrder.getQuantity());
/* 665 */     tradeOrderDTO.setMeasureUnit(tradeOrder.getMeasureUnit());
/* 666 */     tradeOrderDTO.setOrderAmount(tradeOrder.getOrderAmount());
/* 667 */     tradeOrderDTO.setHasSellerConfirm(tradeOrder.getHasSellerConfirm());
/* 668 */     tradeOrderDTO.setHasBuyerConfirm(tradeOrder.getHasBuyerConfirm());
/* 669 */     tradeOrderDTO.setSellerDepositAmount(tradeOrder.getSellerDepositAmount());
/* 670 */     tradeOrderDTO.setBuyerDepositAmount(tradeOrder.getBuyerDepositAmount());
/* 671 */     tradeOrderDTO.setDeliveryType(tradeOrder.getDeliveryType());
/* 672 */     tradeOrderDTO.setPaymentType(tradeOrder.getPaymentType());
/* 673 */     tradeOrderDTO.setHasPay(tradeOrder.getHasPay());
/* 674 */     tradeOrderDTO.setSellerAccount(tradeOrder.getSellerAccount());
/* 675 */     tradeOrderDTO.setBuyerAccount(tradeOrder.getBuyerAccount());
/* 676 */     tradeOrderDTO.setExpectTime(tradeOrder.getExpectTime());
/* 677 */     tradeOrderDTO.setEndDatePay(tradeOrder.getEndDatePay());
/* 678 */     tradeOrderDTO.setEndDateGoods(tradeOrder.getEndDateGoods());
/* 679 */     tradeOrderDTO.setEndDateBill(tradeOrder.getEndDateBill());
/* 680 */     tradeOrderDTO.setHasSellerRank(tradeOrder.getHasSellerRank());
/* 681 */     tradeOrderDTO.setHasBuyerRank(tradeOrder.getHasBuyerRank());
/* 682 */     tradeOrderDTO.setHasInvoice(tradeOrder.getHasInvoice());
/* 683 */     tradeOrderDTO.setWishOrderNum(tradeOrder.getWishOrderNum());
/* 684 */     tradeOrderDTO.setProjectCode(tradeOrder.getProjectCode());
/* 685 */     tradeOrderDTO.setProjectName(tradeOrder.getProjectName());
/* 686 */     tradeOrderDTO.setStatus(tradeOrder.getStatus());
/* 687 */     tradeOrderDTO.setGmtCreate(tradeOrder.getGmtCreate());
/* 688 */     tradeOrderDTO.setBreedStandard(tradeOrder.getBreedStandard());
/* 689 */     return tradeOrderDTO;
/*     */   }
/*     */ 
/*     */   public static ProjectBaseSettingDTO convertPBS2PBSDTO(ProjectBaseSetting obj) {
/* 693 */     ProjectBaseSettingDTO dto = new ProjectBaseSettingDTO();
/* 694 */     dto.setIntentionCheckProcess(obj.getIntentionCheckProcess());
/* 695 */     dto.setListingCheckProcess(obj.getListingCheckProcess());
/* 696 */     dto.setListingJsProportion(obj.getListingJsProportion());
/* 697 */     dto.setListingJyProportion(obj.getListingJyProportion());
/* 698 */     dto.setOrderJsProportion(obj.getOrderJsProportion());
/* 699 */     dto.setOrderJyProportion(obj.getOrderJyProportion());
/* 700 */     return dto;
/*     */   }
/*     */ 
/*     */   private static List<ProjectMetas> copyProjectMetasDTOList2ProjectMetas(List<ProjectMetasDTO> tradeMetasList)
/*     */   {
/* 710 */     List projectMetasList = new ArrayList();
/* 711 */     if (tradeMetasList != null)
/* 712 */       for (ProjectMetasDTO projectMetasDTO : tradeMetasList) {
/* 713 */         ProjectMetas projectMetas = convertProjectMetasDTO2ProjectMetas(projectMetasDTO);
/* 714 */         projectMetasList.add(projectMetas);
/*     */       }
/* 716 */     return projectMetasList;
/*     */   }
/*     */ 
/*     */   private static ProjectMetas convertProjectMetasDTO2ProjectMetas(ProjectMetasDTO projectMetasDTO)
/*     */   {
/* 725 */     ProjectMetas projectMetas = new ProjectMetas();
/* 726 */     projectMetas.setGmtCreate(projectMetasDTO.getGmtCreate());
/* 727 */     projectMetas.setGmtModify(projectMetasDTO.getGmtModify());
/* 728 */     projectMetas.setId(projectMetasDTO.getId());
/* 729 */     projectMetas.setMetaGroup(projectMetasDTO.getMetaGroup());
/* 730 */     projectMetas.setMetaKey(projectMetasDTO.getMetaKey());
/* 731 */     projectMetas.setMetaTitle(projectMetasDTO.getMetaTitle());
/* 732 */     projectMetas.setMetaValue(projectMetasDTO.getMetaValue());
/* 733 */     projectMetas.setOperator(projectMetasDTO.getOperator());
/* 734 */     projectMetas.setProjectId(projectMetasDTO.getProjectId());
/* 735 */     return projectMetas;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.common.utils.ConvertUtils
 * JD-Core Version:    0.6.0
 */