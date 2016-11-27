/*     */ package com.hundsun.network.gates.genshan.web.util;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.domain.operation.Announcement;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.order.TradeOrderCc;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectListing;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectMetas;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectStandard;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectTypeAttri;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.user.UserAccount;
/*     */ import com.hundsun.network.gates.luosi.biz.domain.TradeShowDTO;
/*     */ import com.hundsun.network.gates.luosi.biz.domain.UserAgent;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumMetaGroup;
/*     */ import com.hundsun.network.gates.luosi.common.utils.CopyUtil;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.AnnouncementDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.ProjectListingDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.ProjectMetasDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.ProjectStandardDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.ProjectTypeAttriDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.TradeOrderCcDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.UserAccountDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumUserStatus;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.ProjectListingRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.TradeOrderCcRequest;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.UserRegisterRequset;
/*     */ import com.hundsun.network.melody.common.util.DateUtil;
/*     */ import com.hundsun.network.melody.common.util.UUIDGenerator;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import org.apache.commons.beanutils.BeanUtils;
/*     */ 
/*     */ public class ConvertUtils
/*     */ {
/*     */   public static UserAccount convert(UserAccountDTO userAccountDTO)
/*     */   {
/*  42 */     UserAccount account = new UserAccount();
/*     */     try
/*     */     {
/*  78 */       BeanUtils.copyProperties(account, userAccountDTO);
/*     */     } catch (Exception e) {
/*  80 */       e.printStackTrace();
/*     */     }
/*  82 */     return account;
/*     */   }
/*     */ 
/*     */   public static ProjectListingDTO convertProjectListing2ProjectListingDTO(ProjectListing projectListing)
/*     */   {
/*  92 */     ProjectListingDTO projectListingDTO = new ProjectListingDTO();
/*  93 */     projectListingDTO.setId(projectListing.getId());
/*  94 */     projectListingDTO.setTitle(projectListing.getTitle());
/*  95 */     projectListingDTO.setCode(projectListing.getCode());
/*  96 */     projectListingDTO.setUserId(projectListing.getUserId());
/*  97 */     projectListingDTO.setUserAccount(projectListing.getUserAccount());
/*  98 */     projectListingDTO.setFundAccount(projectListing.getFundAccount());
/*  99 */     projectListingDTO.setListingType(projectListing.getListingType());
/* 100 */     projectListingDTO.setMeasureUnit(projectListing.getMeasureUnit());
/* 101 */     projectListingDTO.setQuantity(projectListing.getQuantity());
/* 102 */     projectListingDTO.setValuationUnit(projectListing.getValuationUnit());
/* 103 */     projectListingDTO.setListingPrice(projectListing.getListingPrice());
/* 104 */     projectListingDTO.setMultipleBase(projectListing.getMultipleBase());
/* 105 */     projectListingDTO.setMaxQuantity(projectListing.getMaxQuantity());
/* 106 */     projectListingDTO.setMinQuantity(projectListing.getMinQuantity());
/* 107 */     projectListingDTO.setRetail(projectListing.getRetail());
/* 108 */     projectListingDTO.setProjectTypeCode(projectListing.getProjectTypeCode());
/* 109 */     projectListingDTO.setBreedStandard(projectListing.getBreedStandard());
/* 110 */     projectListingDTO.setTradingType(projectListing.getTradingType());
/* 111 */     projectListingDTO.setDeliveryDate(projectListing.getDeliveryDate());
/* 112 */     projectListingDTO.setDeliveryPlace(projectListing.getDeliveryPlace());
/* 113 */     projectListingDTO.setDeliveryType(projectListing.getDeliveryType());
/* 114 */     projectListingDTO.setPaymentType(projectListing.getPaymentType());
/* 115 */     projectListingDTO.setListingStartTime(projectListing.getListingStartTime());
/* 116 */     projectListingDTO.setListingEndTime(projectListing.getListingEndTime());
/* 117 */     projectListingDTO.setInvoice(projectListing.getInvoice());
/* 118 */     projectListingDTO.setStatus(projectListing.getStatus());
/* 119 */     projectListingDTO.setProcessAuditNodes(projectListing.getProcessAuditNodes());
/* 120 */     projectListingDTO.setAuditNode(projectListing.getAuditNode());
/* 121 */     projectListingDTO.setCreator(projectListing.getCreator());
/* 122 */     projectListingDTO.setCreatorType(projectListing.getCreatorType());
/* 123 */     projectListingDTO.setOperator(projectListing.getOperator());
/* 124 */     projectListingDTO.setGmtCreate(projectListing.getGmtCreate());
/* 125 */     projectListingDTO.setGmtModify(projectListing.getGmtModify());
/* 126 */     projectListingDTO.setDeposit(projectListing.getDeposit());
/* 127 */     projectListingDTO.setProvince(projectListing.getProvince());
/* 128 */     projectListingDTO.setCity(projectListing.getCity());
/* 129 */     projectListingDTO.setArea(projectListing.getArea());
/* 130 */     projectListingDTO.setAddress(projectListing.getAddress());
/* 131 */     projectListingDTO.setLinkMan(projectListing.getLinkMan());
/* 132 */     projectListingDTO.setZipCode(projectListing.getZipCode());
/* 133 */     projectListingDTO.setPhone(projectListing.getPhone());
/* 134 */     projectListingDTO.setStorehouse(projectListing.getStorehouse());
/* 135 */     projectListingDTO.setPicturePath(projectListing.getPicturePath());
/* 136 */     projectListingDTO.setPicturePath1(projectListing.getPicturePath1());
/* 137 */     projectListingDTO.setPicturePath2(projectListing.getPicturePath2());
/* 138 */     projectListingDTO.setPicturePath3(projectListing.getPicturePath3());
/* 139 */     projectListingDTO.setPicturePath4(projectListing.getPicturePath4());
/* 140 */     projectListingDTO.setBreedStandardId(projectListing.getBreedStandardId());
/* 141 */     projectListingDTO.setDescription(projectListing.getDescription());
/* 142 */     return projectListingDTO;
/*     */   }
/*     */ 
/*     */   public static ProjectListing convertProjectListingDTO2ProjectListing(ProjectListingDTO projectListingDTO)
/*     */   {
/* 147 */     ProjectListing projectListing = new ProjectListing();
/* 148 */     projectListing.setId(projectListingDTO.getId());
/* 149 */     projectListing.setTitle(projectListingDTO.getTitle());
/* 150 */     projectListing.setCode(projectListingDTO.getCode());
/* 151 */     projectListing.setUserId(projectListingDTO.getUserId());
/* 152 */     projectListing.setUserAccount(projectListingDTO.getUserAccount());
/* 153 */     projectListing.setFundAccount(projectListingDTO.getFundAccount());
/* 154 */     projectListing.setListingType(projectListingDTO.getListingType());
/* 155 */     projectListing.setMeasureUnit(projectListingDTO.getMeasureUnit());
/* 156 */     projectListing.setQuantity(projectListingDTO.getQuantity());
/* 157 */     projectListing.setValuationUnit(projectListingDTO.getValuationUnit());
/* 158 */     projectListing.setListingPrice(projectListingDTO.getListingPrice());
/* 159 */     projectListing.setMultipleBase(projectListingDTO.getMultipleBase());
/* 160 */     projectListing.setMaxQuantity(projectListingDTO.getMaxQuantity());
/* 161 */     projectListing.setMinQuantity(projectListingDTO.getMinQuantity());
/* 162 */     projectListing.setRetail(projectListingDTO.getRetail());
/* 163 */     projectListing.setProjectTypeCode(projectListingDTO.getProjectTypeCode());
/* 164 */     projectListing.setBreedStandard(projectListingDTO.getBreedStandard());
/* 165 */     projectListing.setTradingType(projectListingDTO.getTradingType());
/* 166 */     projectListing.setDeliveryDate(projectListingDTO.getDeliveryDate());
/* 167 */     projectListing.setDeliveryPlace(projectListingDTO.getDeliveryPlace());
/* 168 */     projectListing.setDeliveryType(projectListingDTO.getDeliveryType());
/* 169 */     projectListing.setPaymentType(projectListingDTO.getPaymentType());
/* 170 */     projectListing.setListingStartTime(projectListingDTO.getListingStartTime());
/* 171 */     projectListing.setListingEndTime(projectListingDTO.getListingEndTime());
/* 172 */     projectListing.setInvoice(projectListingDTO.getInvoice());
/* 173 */     projectListing.setStatus(projectListingDTO.getStatus());
/* 174 */     projectListing.setProcessAuditNodes(projectListingDTO.getProcessAuditNodes());
/* 175 */     projectListing.setAuditNode(projectListingDTO.getAuditNode());
/* 176 */     projectListing.setCreator(projectListingDTO.getCreator());
/* 177 */     projectListing.setCreatorType(projectListingDTO.getCreatorType());
/* 178 */     projectListing.setOperator(projectListingDTO.getOperator());
/* 179 */     projectListing.setGmtCreate(projectListingDTO.getGmtCreate());
/* 180 */     projectListing.setGmtModify(projectListingDTO.getGmtModify());
/* 181 */     projectListing.setDeposit(projectListingDTO.getDeposit());
/* 182 */     projectListing.setProvince(projectListingDTO.getProvince());
/* 183 */     projectListing.setCity(projectListingDTO.getCity());
/* 184 */     projectListing.setArea(projectListingDTO.getArea());
/* 185 */     projectListing.setAddress(projectListingDTO.getAddress());
/* 186 */     projectListing.setLinkMan(projectListingDTO.getLinkMan());
/* 187 */     projectListing.setZipCode(projectListingDTO.getZipCode());
/* 188 */     projectListing.setPhone(projectListingDTO.getPhone());
/* 189 */     projectListing.setStorehouse(projectListingDTO.getStorehouse());
/*     */ 
/* 191 */     projectListing.setPicturePath(projectListingDTO.getPicturePath());
/* 192 */     projectListing.setPicturePath1(projectListingDTO.getPicturePath1());
/* 193 */     projectListing.setPicturePath2(projectListingDTO.getPicturePath2());
/* 194 */     projectListing.setPicturePath3(projectListingDTO.getPicturePath3());
/* 195 */     projectListing.setPicturePath4(projectListingDTO.getPicturePath4());
/* 196 */     projectListing.setBreedStandardId(projectListingDTO.getBreedStandardId());
/* 197 */     projectListing.setDescription(projectListingDTO.getDescription());
/* 198 */     return projectListing;
/*     */   }
/*     */ 
/*     */   public static UserAccount convertRegRequest2UAccount(UserRegisterRequset request)
/*     */   {
/* 297 */     if (null == request) {
/* 298 */       return null;
/*     */     }
/* 300 */     return convert(request.getUserAccountDTO());
/*     */   }
/*     */ 
/*     */   public static ProjectListingRequest convertProjectListing2Request(ProjectListing projectListing)
/*     */   {
/* 335 */     ProjectListingRequest request = new ProjectListingRequest();
/* 336 */     ProjectListingDTO projectListingDTO = new ProjectListingDTO();
/* 337 */     CopyUtil.copyProperties(projectListing, projectListingDTO);
/* 338 */     request.setProjectListingDTO(projectListingDTO);
/* 339 */     return request;
/*     */   }
/*     */ 
/*     */   public static ProjectListing convertRequest2ProjectListing(ProjectListingRequest projectListingRequest)
/*     */   {
/* 349 */     ProjectListing projectListing = new ProjectListing();
/* 350 */     CopyUtil.copyProperties(projectListingRequest.getProjectListingDTO(), projectListing);
/* 351 */     return projectListing;
/*     */   }
/*     */ 
/*     */   public static ProjectTypeAttri convert(ProjectTypeAttriDTO dto) {
/* 355 */     ProjectTypeAttri typeAttri = new ProjectTypeAttri();
/* 356 */     typeAttri.setEnable(dto.getEnable());
/* 357 */     typeAttri.setGmtCreate(dto.getGmtCreate());
/* 358 */     typeAttri.setGmtModify(dto.getGmtModify());
/* 359 */     typeAttri.setId(dto.getId());
/* 360 */     typeAttri.setInputType(dto.getInputType());
/* 361 */     typeAttri.setIsRequired(dto.getIsRequired());
/* 362 */     typeAttri.setKeyName(dto.getKeyName());
/* 363 */     typeAttri.setKeyTitle(dto.getKeyTitle());
/* 364 */     typeAttri.setOperator(dto.getOperator());
/* 365 */     typeAttri.setProTypeCode(dto.getProTypeCode());
/* 366 */     typeAttri.setRank(dto.getRank());
/* 367 */     typeAttri.setRemark(dto.getRemark());
/* 368 */     typeAttri.setText(dto.getText());
/* 369 */     typeAttri.setValueValidate(dto.getValueValidate());
/* 370 */     return typeAttri;
/*     */   }
/*     */ 
/*     */   public static UserAgent convertToUserAgent(UserAccount userAccount) {
/* 374 */     UserAgent agent = new UserAgent();
/* 375 */     agent.setAccount(userAccount.getAccount());
/* 376 */     agent.setAccountId(userAccount.getId());
/* 377 */     agent.setFundAccount(userAccount.getFundAccount());
/* 378 */     agent.setName(userAccount.getName());
/* 379 */     if (userAccount.getLastLoginIp() == null)
/* 380 */       agent.setLastLoginIP("");
/*     */     else {
/* 382 */       agent.setLastLoginIP(userAccount.getLastLoginIp());
/*     */     }
/* 384 */     if (userAccount.getLastLoginTime() == null)
/* 385 */       agent.setLastLoginTime("");
/*     */     else {
/* 387 */       agent.setLastLoginTime(DateUtil.convertDateToString("yyyy-MM-dd HH:mm:ss", userAccount.getLastLoginTime()));
/*     */     }
/*     */ 
/* 392 */     return agent;
/*     */   }
/*     */ 
/*     */   public static ProjectListingDTO convertProjectListing2EditDTO(ProjectListing projectListing)
/*     */   {
/* 401 */     ProjectListingDTO projectListingDTO = new ProjectListingDTO();
/* 402 */     projectListingDTO.setId(projectListing.getId());
/* 403 */     projectListingDTO.setTitle(projectListing.getTitle());
/* 404 */     projectListingDTO.setCode(projectListing.getCode());
/*     */ 
/* 408 */     projectListingDTO.setMeasureUnit(projectListing.getMeasureUnit());
/* 409 */     projectListingDTO.setQuantity(projectListing.getQuantity());
/* 410 */     projectListingDTO.setValuationUnit(projectListing.getValuationUnit());
/*     */ 
/* 418 */     projectListingDTO.setListingPrice(projectListing.getListingPrice());
/*     */ 
/* 421 */     projectListingDTO.setMultipleBase(projectListing.getMultipleBase());
/* 422 */     projectListingDTO.setMaxQuantity(projectListing.getMaxQuantity());
/* 423 */     projectListingDTO.setMinQuantity(projectListing.getMinQuantity());
/* 424 */     projectListingDTO.setRetail(projectListing.getRetail());
/*     */ 
/* 427 */     projectListingDTO.setTradingType(projectListing.getTradingType());
/* 428 */     projectListingDTO.setDeliveryDate(projectListing.getDeliveryDate());
/* 429 */     projectListingDTO.setDeliveryPlace(projectListing.getDeliveryPlace());
/* 430 */     projectListingDTO.setDeliveryType(projectListing.getDeliveryType());
/* 431 */     projectListingDTO.setPaymentType(projectListing.getPaymentType());
/* 432 */     projectListingDTO.setListingStartTime(projectListing.getListingStartTime());
/* 433 */     projectListingDTO.setListingEndTime(projectListing.getListingEndTime());
/* 434 */     projectListingDTO.setInvoice(projectListing.getInvoice());
/*     */ 
/* 440 */     projectListingDTO.setOperator(projectListing.getOperator());
/* 441 */     projectListingDTO.setGmtCreate(projectListing.getGmtCreate());
/* 442 */     projectListingDTO.setGmtModify(projectListing.getGmtModify());
/* 443 */     projectListingDTO.setDeposit(projectListing.getDeposit());
/* 444 */     projectListingDTO.setProvince(projectListing.getProvince());
/* 445 */     projectListingDTO.setCity(projectListing.getCity());
/* 446 */     projectListingDTO.setArea(projectListing.getArea());
/* 447 */     projectListingDTO.setAddress(projectListing.getAddress());
/* 448 */     projectListingDTO.setLinkMan(projectListing.getLinkMan());
/* 449 */     projectListingDTO.setZipCode(projectListing.getZipCode());
/* 450 */     projectListingDTO.setPhone(projectListing.getPhone());
/* 451 */     projectListingDTO.setStorehouse(projectListing.getStorehouse());
/* 452 */     projectListingDTO.setPicturePath(projectListing.getPicturePath());
/* 453 */     projectListingDTO.setPicturePath1(projectListing.getPicturePath1());
/* 454 */     projectListingDTO.setPicturePath2(projectListing.getPicturePath2());
/* 455 */     projectListingDTO.setPicturePath3(projectListing.getPicturePath3());
/* 456 */     projectListingDTO.setPicturePath4(projectListing.getPicturePath4());
/* 457 */     projectListingDTO.setBreedStandardId(projectListing.getBreedStandardId());
/* 458 */     projectListingDTO.setDescription(projectListing.getDescription());
/* 459 */     return projectListingDTO;
/*     */   }
/*     */ 
/*     */   public static List<ProjectMetasDTO> convertMetaValues2DTO(ProjectListing projectListing)
/*     */   {
/* 468 */     List metasDTO = new ArrayList();
/* 469 */     HashMap tmpMap = new HashMap();
/* 470 */     if (projectListing.getMetaValues() != null) {
/* 471 */       for (ProjectMetas meta : projectListing.getMetaValues()) {
/* 472 */         if (meta != null) {
/* 473 */           ProjectMetasDTO metaDTO = new ProjectMetasDTO();
/* 474 */           metaDTO.setMetaGroup(meta.getMetaGroup() == null ? EnumMetaGroup.PROJECTTYPE.getValue() : meta.getMetaGroup());
/*     */ 
/* 476 */           metaDTO.setProjectId(projectListing.getId());
/* 477 */           metaDTO.setMetaKey(meta.getMetaKey());
/* 478 */           metaDTO.setMetaTitle(meta.getMetaTitle());
/* 479 */           metaDTO.setMetaValue(meta.getMetaValue());
/* 480 */           metaDTO.setOperator(projectListing.getOperator());
/* 481 */           metasDTO.add(metaDTO);
/* 482 */           tmpMap.put(metaDTO.getMetaKey(), metaDTO);
/*     */         }
/*     */       }
/*     */     }
/* 486 */     TradeShowDTO[] tradeShowArry = projectListing.getTradeMetas();
/* 487 */     if ((tradeShowArry != null) && (tradeShowArry.length > 0)) {
/* 488 */       Long projectId = projectListing.getId();
/* 489 */       Date gmtCreate = projectListing.getGmtCreate();
/* 490 */       Date gmtModify = projectListing.getGmtModify();
/* 491 */       String operator = projectListing.getOperator();
/* 492 */       if ((metasDTO != null) && (metasDTO.size() > 0)) {
/* 493 */         projectId = ((ProjectMetasDTO)metasDTO.get(0)).getProjectId() == null ? null : ((ProjectMetasDTO)metasDTO.get(0)).getProjectId();
/*     */ 
/* 495 */         gmtCreate = ((ProjectMetasDTO)metasDTO.get(0)).getGmtCreate();
/* 496 */         gmtModify = ((ProjectMetasDTO)metasDTO.get(0)).getGmtModify();
/* 497 */         operator = ((ProjectMetasDTO)metasDTO.get(0)).getOperator();
/*     */       }
/* 499 */       for (TradeShowDTO tradeShowDTO : tradeShowArry) {
/* 500 */         if (!tmpMap.containsKey(tradeShowDTO.getKey())) {
/* 501 */           metasDTO.add(convertTradeShowDTO2ProjectMetasDTO(projectId, gmtCreate, gmtModify, operator, tradeShowDTO));
/*     */         }
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 507 */     return metasDTO;
/*     */   }
/*     */ 
/*     */   private static ProjectMetasDTO convertTradeShowDTO2ProjectMetasDTO(Long projectId, Date gmtCreate, Date gmtModify, String operator, TradeShowDTO tradeShowDTO)
/*     */   {
/* 515 */     ProjectMetasDTO projectMetasDTO = new ProjectMetasDTO();
/* 516 */     projectMetasDTO.setProjectId(projectId);
/* 517 */     projectMetasDTO.setGmtCreate(gmtCreate);
/* 518 */     projectMetasDTO.setGmtModify(gmtModify);
/* 519 */     projectMetasDTO.setOperator(operator);
/* 520 */     projectMetasDTO.setInputType(tradeShowDTO.getShowType());
/* 521 */     projectMetasDTO.setMetaGroup(EnumMetaGroup.TRADINGTYPE.getValue());
/* 522 */     projectMetasDTO.setMetaKey(tradeShowDTO.getKey());
/* 523 */     projectMetasDTO.setMetaTitle(tradeShowDTO.getName());
/* 524 */     projectMetasDTO.setMetaValue(tradeShowDTO.getInputValue());
/* 525 */     return projectMetasDTO;
/*     */   }
/*     */ 
/*     */   public static TradeOrderCcRequest convert(TradeOrderCc tradeOrderCc)
/*     */   {
/* 534 */     TradeOrderCcRequest tradeOrderCcRequest = new TradeOrderCcRequest();
/* 535 */     TradeOrderCcDTO tradeOrderCcDTO = new TradeOrderCcDTO();
/* 536 */     CopyUtil.copyProperties(tradeOrderCc, tradeOrderCcDTO);
/* 537 */     tradeOrderCcRequest.setTradeOrderCcDTO(tradeOrderCcDTO);
/* 538 */     return tradeOrderCcRequest;
/*     */   }
/*     */ 
/*     */   public static List<ProjectStandard> convertProjectStandardDTOList2ProjectStandardList(List<ProjectStandardDTO> data)
/*     */   {
/* 543 */     List list = new ArrayList();
/* 544 */     for (ProjectStandardDTO projectStandardDTO : data) {
/* 545 */       ProjectStandard projectStandard = convertProjectStandardDTO2ProjectStandard(projectStandardDTO);
/* 546 */       list.add(projectStandard);
/* 547 */       projectStandard = null;
/*     */     }
/* 549 */     data.clear();
/* 550 */     return list;
/*     */   }
/*     */ 
/*     */   public static ProjectStandard convertProjectStandardDTO2ProjectStandard(ProjectStandardDTO projectStandardDTO)
/*     */   {
/* 555 */     ProjectStandard projectStandard = new ProjectStandard();
/* 556 */     projectStandard.setContent(projectStandardDTO.getContent());
/*     */ 
/* 558 */     projectStandard.setGmtCreate(projectStandard.getGmtCreate());
/*     */ 
/* 560 */     projectStandard.setId(projectStandardDTO.getId());
/* 561 */     projectStandard.setName(projectStandardDTO.getName());
/* 562 */     projectStandard.setOperator(projectStandard.getOperator());
/* 563 */     projectStandard.setProTypeCode(projectStandard.getProTypeCode());
/* 564 */     projectStandard.setProTypeName(projectStandardDTO.getProTypeName());
/* 565 */     projectStandardDTO = null;
/* 566 */     return projectStandard;
/*     */   }
/*     */ 
/*     */   public static void convertProjectTypeAttriDTO2ProjectTypeAttri(ProjectTypeAttriDTO projectTypeAttriDTO, ProjectTypeAttri projectTypeAttri)
/*     */   {
/* 572 */     projectTypeAttri.setEnable(projectTypeAttriDTO.getEnable());
/* 573 */     projectTypeAttri.setGmtCreate(projectTypeAttriDTO.getGmtCreate());
/* 574 */     projectTypeAttri.setGmtModify(projectTypeAttriDTO.getGmtModify());
/* 575 */     projectTypeAttri.setId(projectTypeAttriDTO.getId());
/* 576 */     projectTypeAttri.setInputType(projectTypeAttriDTO.getInputType());
/* 577 */     projectTypeAttri.setIsRequired(projectTypeAttriDTO.getIsRequired());
/* 578 */     projectTypeAttri.setKeyName(projectTypeAttriDTO.getKeyName());
/* 579 */     projectTypeAttri.setKeyTitle(projectTypeAttriDTO.getKeyTitle());
/* 580 */     projectTypeAttri.setOperator(projectTypeAttriDTO.getOperator());
/* 581 */     projectTypeAttri.setProTypeCode(projectTypeAttriDTO.getProTypeCode());
/* 582 */     projectTypeAttri.setRank(projectTypeAttriDTO.getRank());
/* 583 */     projectTypeAttri.setRemark(projectTypeAttriDTO.getRemark());
/* 584 */     projectTypeAttri.setSelectValues(projectTypeAttriDTO.getSelectValues());
/*     */ 
/* 587 */     projectTypeAttri.setValueValidate(projectTypeAttriDTO.getValueValidate());
/*     */   }
/*     */ 
/*     */   public static AnnouncementDTO convert2AnnouncementDTO(Announcement announcement)
/*     */   {
/* 596 */     AnnouncementDTO announcementDTO = new AnnouncementDTO();
/*     */ 
/* 598 */     CopyUtil.copyProperties(announcement, announcementDTO);
/* 599 */     return announcementDTO;
/*     */   }
/*     */ 
/*     */   public static Announcement convert2Announcement(AnnouncementDTO announcementDTO)
/*     */   {
/* 608 */     Announcement announcement = new Announcement();
/*     */ 
/* 610 */     CopyUtil.copyProperties(announcementDTO, announcement);
/* 611 */     return announcement;
/*     */   }
/*     */ 
/*     */   public static UserAccountDTO convert(UserAccount account)
/*     */   {
/* 619 */     UserAccountDTO userAccountDTO = new UserAccountDTO();
/*     */     try {
/* 621 */       BeanUtils.copyProperties(userAccountDTO, account);
/*     */     } catch (Exception e) {
/* 623 */       e.printStackTrace();
/*     */     }
/* 625 */     return userAccountDTO;
/*     */   }
/*     */ 
/*     */   public static UserRegisterRequset convertUAccount2RegRequest(UserAccount userAccount)
/*     */   {
/* 633 */     if (null == userAccount) {
/* 634 */       return null;
/*     */     }
/* 636 */     UserRegisterRequset request = new UserRegisterRequset();
/* 637 */     UserAccountDTO dto = convert(userAccount);
/* 638 */     dto.setCertificatePath("");
/* 639 */     dto.setActiveCode(UUIDGenerator.generate());
/* 640 */     dto.setCreditClass(Long.valueOf(0L));
/* 641 */     dto.setStatus(EnumUserStatus.Unfund.getValue());
/* 642 */     request.setUserAccountDTO(dto);
/* 643 */     return request;
/*     */   }
/*     */ 
/*     */   public static UserRegisterRequset convertUAccount2RegRequest2(UserAccount userAccount)
/*     */   {
/* 651 */     if (null == userAccount) {
/* 652 */       return null;
/*     */     }
/* 654 */     UserRegisterRequset request = new UserRegisterRequset();
/* 655 */     UserAccountDTO dto = convert(userAccount);
/* 656 */     dto.setCertificatePath("");
/* 657 */     dto.setActiveCode(UUIDGenerator.generate());
/* 658 */     dto.setCreditClass(Long.valueOf(0L));
/* 659 */     dto.setStatus(EnumUserStatus.Normal.getValue());
/* 660 */     request.setUserAccountDTO(dto);
/* 661 */     return request;
/*     */   }
/*     */ 
/*     */   public static List<ProjectMetasDTO> convertMetaValues2DTO(ProjectListing projectListing, List<TradeShowDTO> tradeMetas)
/*     */   {
/* 672 */     List metasDTO = new ArrayList();
/* 673 */     if ((tradeMetas != null) && (tradeMetas.size() > 0)) {
/* 674 */       for (TradeShowDTO tradeShowDTO : tradeMetas) {
/* 675 */         if (tradeShowDTO != null) {
/* 676 */           ProjectMetasDTO metaDTO = new ProjectMetasDTO();
/* 677 */           metaDTO.setMetaGroup(EnumMetaGroup.TRADINGTYPE.getValue());
/* 678 */           metaDTO.setProjectId(projectListing.getId());
/* 679 */           metaDTO.setMetaKey(tradeShowDTO.getKey());
/* 680 */           metaDTO.setMetaTitle(tradeShowDTO.getName());
/* 681 */           metaDTO.setMetaValue(tradeShowDTO.getInputValue());
/* 682 */           metaDTO.setOperator(projectListing.getOperator());
/* 683 */           metasDTO.add(metaDTO);
/*     */         }
/*     */       }
/*     */     }
/* 687 */     return metasDTO;
/*     */   }
/*     */ 
/*     */   public static List<ProjectMetasDTO> convertProjectMetaValues2ProjectMetaDTO(ProjectListing projectListing)
/*     */   {
/* 692 */     List metasDTO = new ArrayList();
/* 693 */     HashMap tmpMap = new HashMap();
/* 694 */     if (projectListing.getMetaValues() != null) {
/* 695 */       for (ProjectMetas meta : projectListing.getMetaValues()) {
/* 696 */         if (meta != null) {
/* 697 */           ProjectMetasDTO metaDTO = new ProjectMetasDTO();
/* 698 */           metaDTO.setMetaGroup(meta.getMetaGroup() == null ? EnumMetaGroup.PROJECTTYPE.getValue() : meta.getMetaGroup());
/*     */ 
/* 700 */           metaDTO.setProjectId(projectListing.getId());
/* 701 */           metaDTO.setMetaKey(meta.getMetaKey());
/* 702 */           metaDTO.setMetaTitle(meta.getMetaTitle());
/* 703 */           metaDTO.setMetaValue(meta.getMetaValue());
/* 704 */           metaDTO.setOperator(projectListing.getOperator());
/* 705 */           metasDTO.add(metaDTO);
/* 706 */           tmpMap.put(metaDTO.getMetaKey(), metaDTO);
/*     */         }
/*     */       }
/*     */     }
/* 710 */     return metasDTO;
/*     */   }
/*     */ 
/*     */   public static List<ProjectMetasDTO> convertProjectMetaValues2ProjectMetaDTO(ProjectListing projectListing, List<TradeShowDTO> tradeMetas)
/*     */   {
/* 717 */     List metasDTO = new ArrayList();
/* 718 */     if ((tradeMetas != null) && (tradeMetas.size() > 0)) {
/* 719 */       for (TradeShowDTO tradeShowDTO : tradeMetas) {
/* 720 */         if (tradeShowDTO != null) {
/* 721 */           ProjectMetasDTO metaDTO = new ProjectMetasDTO();
/* 722 */           metaDTO.setMetaGroup(EnumMetaGroup.TRADINGTYPE.getValue());
/* 723 */           metaDTO.setProjectId(projectListing.getId());
/* 724 */           metaDTO.setMetaKey(tradeShowDTO.getKey());
/* 725 */           metaDTO.setMetaTitle(tradeShowDTO.getName());
/* 726 */           metaDTO.setMetaValue(tradeShowDTO.getInputValue());
/* 727 */           metaDTO.setOperator(projectListing.getOperator());
/* 728 */           metasDTO.add(metaDTO);
/*     */         }
/*     */       }
/*     */     }
/* 732 */     return metasDTO;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.util.ConvertUtils
 * JD-Core Version:    0.6.0
 */