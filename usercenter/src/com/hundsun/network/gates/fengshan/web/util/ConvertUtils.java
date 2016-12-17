/*     */ package com.hundsun.network.gates.fengshan.web.util;
/*     */ 
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.order.TradeOrderCc;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectListing;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectMetas;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectStandard;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectTypeAttri;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.user.UserAccount;
/*     */ import com.hundsun.network.gates.luosi.biz.domain.TradeShowDTO;
/*     */ import com.hundsun.network.gates.luosi.biz.domain.UserAgent;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumMetaGroup;
/*     */ import com.hundsun.network.gates.luosi.common.utils.CopyUtil;
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
/*     */ import java.util.List;
/*     */ import org.apache.commons.beanutils.BeanUtils;
/*     */ 
/*     */ public class ConvertUtils
/*     */ {
/*     */   public static UserAccount convert(UserAccountDTO userAccountDTO)
/*     */   {
/*  38 */     UserAccount account = new UserAccount();
/*     */     try
/*     */     {
/*  74 */       BeanUtils.copyProperties(account, userAccountDTO);
/*     */     } catch (Exception e) {
/*  76 */       e.printStackTrace();
/*     */     }
/*  78 */     return account;
/*     */   }
/*     */ 
/*     */   public static ProjectListingDTO convertProjectListing2ProjectListingDTO(ProjectListing projectListing)
/*     */   {
/*  88 */     ProjectListingDTO projectListingDTO = new ProjectListingDTO();
/*  89 */     projectListingDTO.setId(projectListing.getId());
/*  90 */     projectListingDTO.setTitle(projectListing.getTitle());
/*  91 */     projectListingDTO.setCode(projectListing.getCode());
/*  92 */     projectListingDTO.setUserId(projectListing.getUserId());
/*  93 */     projectListingDTO.setUserAccount(projectListing.getUserAccount());
/*  94 */     projectListingDTO.setFundAccount(projectListing.getFundAccount());
/*  95 */     projectListingDTO.setListingType(projectListing.getListingType());
/*  96 */     projectListingDTO.setMeasureUnit(projectListing.getMeasureUnit());
/*  97 */     projectListingDTO.setQuantity(projectListing.getQuantity());
/*  98 */     projectListingDTO.setValuationUnit(projectListing.getValuationUnit());
/*  99 */     projectListingDTO.setListingPrice(projectListing.getListingPrice());
/* 100 */     projectListingDTO.setMultipleBase(projectListing.getMultipleBase());
/* 101 */     projectListingDTO.setMaxQuantity(projectListing.getMaxQuantity());
/* 102 */     projectListingDTO.setMinQuantity(projectListing.getMinQuantity());
/* 103 */     projectListingDTO.setRetail(projectListing.getRetail());
/* 104 */     projectListingDTO.setProjectTypeCode(projectListing.getProjectTypeCode());
/* 105 */     projectListingDTO.setBreedStandard(projectListing.getBreedStandard());
/* 106 */     projectListingDTO.setTradingType(projectListing.getTradingType());
/* 107 */     projectListingDTO.setDeliveryDate(projectListing.getDeliveryDate());
/* 108 */     projectListingDTO.setDeliveryPlace(projectListing.getDeliveryPlace());
/* 109 */     projectListingDTO.setDeliveryType(projectListing.getDeliveryType());
/* 110 */     projectListingDTO.setPaymentType(projectListing.getPaymentType());
/* 111 */     projectListingDTO.setListingStartTime(projectListing.getListingStartTime());
/* 112 */     projectListingDTO.setListingEndTime(projectListing.getListingEndTime());
/* 113 */     projectListingDTO.setInvoice(projectListing.getInvoice());
/* 114 */     projectListingDTO.setStatus(projectListing.getStatus());
/* 115 */     projectListingDTO.setProcessAuditNodes(projectListing.getProcessAuditNodes());
/* 116 */     projectListingDTO.setAuditNode(projectListing.getAuditNode());
/* 117 */     projectListingDTO.setCreator(projectListing.getCreator());
/* 118 */     projectListingDTO.setCreatorType(projectListing.getCreatorType());
/* 119 */     projectListingDTO.setOperator(projectListing.getOperator());
/* 120 */     projectListingDTO.setGmtCreate(projectListing.getGmtCreate());
/* 121 */     projectListingDTO.setGmtModify(projectListing.getGmtModify());
/* 122 */     projectListingDTO.setDeposit(projectListing.getDeposit());
/* 123 */     projectListingDTO.setProvince(projectListing.getProvince());
/* 124 */     projectListingDTO.setCity(projectListing.getCity());
/* 125 */     projectListingDTO.setArea(projectListing.getArea());
/* 126 */     projectListingDTO.setAddress(projectListing.getAddress());
/* 127 */     projectListingDTO.setLinkMan(projectListing.getLinkMan());
/* 128 */     projectListingDTO.setZipCode(projectListing.getZipCode());
/* 129 */     projectListingDTO.setPhone(projectListing.getPhone());
/* 130 */     projectListingDTO.setStorehouse(projectListing.getStorehouse());
/* 131 */     projectListingDTO.setPicturePath(projectListing.getPicturePath());
/* 132 */     projectListingDTO.setPicturePath1(projectListing.getPicturePath1());
/* 133 */     projectListingDTO.setPicturePath2(projectListing.getPicturePath2());
/* 134 */     projectListingDTO.setPicturePath3(projectListing.getPicturePath3());
/* 135 */     projectListingDTO.setPicturePath4(projectListing.getPicturePath4());
/* 136 */     projectListingDTO.setBreedStandardId(projectListing.getBreedStandardId());
/* 137 */     projectListingDTO.setDescription(projectListing.getDescription());
/* 138 */     projectListingDTO.setAttachedFilePath(projectListing.getAttachedFilePath());
/* 139 */     projectListingDTO.setSubstationId(projectListing.getSubstationId());
/* 140 */     return projectListingDTO;
/*     */   }
/*     */ 
/*     */   public static ProjectListing convertProjectListingDTO2ProjectListing(ProjectListingDTO projectListingDTO)
/*     */   {
/* 146 */     ProjectListing projectListing = new ProjectListing();
/* 147 */     projectListing.setId(projectListingDTO.getId());
/* 148 */     projectListing.setTitle(projectListingDTO.getTitle());
/* 149 */     projectListing.setCode(projectListingDTO.getCode());
/* 150 */     projectListing.setUserId(projectListingDTO.getUserId());
/* 151 */     projectListing.setUserAccount(projectListingDTO.getUserAccount());
/* 152 */     projectListing.setFundAccount(projectListingDTO.getFundAccount());
/* 153 */     projectListing.setListingType(projectListingDTO.getListingType());
/* 154 */     projectListing.setMeasureUnit(projectListingDTO.getMeasureUnit());
/* 155 */     projectListing.setQuantity(projectListingDTO.getQuantity());
/* 156 */     projectListing.setValuationUnit(projectListingDTO.getValuationUnit());
/* 157 */     projectListing.setListingPrice(projectListingDTO.getListingPrice());
/* 158 */     projectListing.setMultipleBase(projectListingDTO.getMultipleBase());
/* 159 */     projectListing.setMaxQuantity(projectListingDTO.getMaxQuantity());
/* 160 */     projectListing.setMinQuantity(projectListingDTO.getMinQuantity());
/* 161 */     projectListing.setRetail(projectListingDTO.getRetail());
/* 162 */     projectListing.setProjectTypeCode(projectListingDTO.getProjectTypeCode());
/* 163 */     projectListing.setBreedStandard(projectListingDTO.getBreedStandard());
/* 164 */     projectListing.setTradingType(projectListingDTO.getTradingType());
/* 165 */     projectListing.setDeliveryDate(projectListingDTO.getDeliveryDate());
/* 166 */     projectListing.setDeliveryPlace(projectListingDTO.getDeliveryPlace());
/* 167 */     projectListing.setDeliveryType(projectListingDTO.getDeliveryType());
/* 168 */     projectListing.setPaymentType(projectListingDTO.getPaymentType());
/* 169 */     projectListing.setListingStartTime(projectListingDTO.getListingStartTime());
/* 170 */     projectListing.setListingEndTime(projectListingDTO.getListingEndTime());
/* 171 */     projectListing.setInvoice(projectListingDTO.getInvoice());
/* 172 */     projectListing.setStatus(projectListingDTO.getStatus());
/* 173 */     projectListing.setProcessAuditNodes(projectListingDTO.getProcessAuditNodes());
/* 174 */     projectListing.setAuditNode(projectListingDTO.getAuditNode());
/* 175 */     projectListing.setCreator(projectListingDTO.getCreator());
/* 176 */     projectListing.setCreatorType(projectListingDTO.getCreatorType());
/* 177 */     projectListing.setOperator(projectListingDTO.getOperator());
/* 178 */     projectListing.setGmtCreate(projectListingDTO.getGmtCreate());
/* 179 */     projectListing.setGmtModify(projectListingDTO.getGmtModify());
/* 180 */     projectListing.setDeposit(projectListingDTO.getDeposit());
/* 181 */     projectListing.setProvince(projectListingDTO.getProvince());
/* 182 */     projectListing.setCity(projectListingDTO.getCity());
/* 183 */     projectListing.setArea(projectListingDTO.getArea());
/* 184 */     projectListing.setAddress(projectListingDTO.getAddress());
/* 185 */     projectListing.setLinkMan(projectListingDTO.getLinkMan());
/* 186 */     projectListing.setZipCode(projectListingDTO.getZipCode());
/* 187 */     projectListing.setPhone(projectListingDTO.getPhone());
/* 188 */     projectListing.setStorehouse(projectListingDTO.getStorehouse());
/*     */ 
/* 190 */     projectListing.setPicturePath(projectListingDTO.getPicturePath());
/* 191 */     projectListing.setPicturePath1(projectListingDTO.getPicturePath1());
/* 192 */     projectListing.setPicturePath2(projectListingDTO.getPicturePath2());
/* 193 */     projectListing.setPicturePath3(projectListingDTO.getPicturePath3());
/* 194 */     projectListing.setPicturePath4(projectListingDTO.getPicturePath4());
/* 195 */     projectListing.setBreedStandardId(projectListingDTO.getBreedStandardId());
/* 196 */     projectListing.setDescription(projectListingDTO.getDescription());
/* 197 */     return projectListing;
/*     */   }
/*     */ 
/*     */   public static UserAccountDTO convert(UserAccount account)
/*     */   {
/* 206 */     UserAccountDTO userAccountDTO = new UserAccountDTO();
/*     */     try
/*     */     {
/* 242 */       BeanUtils.copyProperties(userAccountDTO, account);
/*     */     } catch (Exception e) {
/* 244 */       e.printStackTrace();
/*     */     }
/* 246 */     return userAccountDTO;
/*     */   }
/*     */ 
/*     */   public static UserRegisterRequset convertUAccount2RegRequest(UserAccount userAccount)
/*     */   {
/* 255 */     if (null == userAccount) {
/* 256 */       return null;
/*     */     }
/* 258 */     UserRegisterRequset request = new UserRegisterRequset();
/* 259 */     UserAccountDTO dto = convert(userAccount);
/* 260 */     dto.setCertificatePath("");
/* 261 */     dto.setActiveCode(UUIDGenerator.generate());
/* 262 */     dto.setCreditClass(Long.valueOf(0L));
/* 263 */     dto.setStatus(EnumUserStatus.Nonactivated.getValue());
/* 264 */     request.setUserAccountDTO(dto);
/* 265 */     return request;
/*     */   }
/*     */ 
/*     */   public static UserAccount convertRegRequest2UAccount(UserRegisterRequset request)
/*     */   {
/* 296 */     if (null == request) {
/* 297 */       return null;
/*     */     }
/* 299 */     return convert(request.getUserAccountDTO());
/*     */   }
/*     */ 
/*     */   public static ProjectListingRequest convertProjectListing2Request(ProjectListing projectListing)
/*     */   {
/* 334 */     ProjectListingRequest request = new ProjectListingRequest();
/* 335 */     ProjectListingDTO projectListingDTO = new ProjectListingDTO();
/* 336 */     CopyUtil.copyProperties(projectListing, projectListingDTO);
/* 337 */     request.setProjectListingDTO(projectListingDTO);
/* 338 */     return request;
/*     */   }
/*     */ 
/*     */   public static ProjectListing convertRequest2ProjectListing(ProjectListingRequest projectListingRequest)
/*     */   {
/* 348 */     ProjectListing projectListing = new ProjectListing();
/* 349 */     CopyUtil.copyProperties(projectListingRequest.getProjectListingDTO(), projectListing);
/* 350 */     return projectListing;
/*     */   }
/*     */ 
/*     */   public static ProjectTypeAttri convert(ProjectTypeAttriDTO dto) {
/* 354 */     ProjectTypeAttri typeAttri = new ProjectTypeAttri();
/* 355 */     typeAttri.setEnable(dto.getEnable());
/* 356 */     typeAttri.setGmtCreate(dto.getGmtCreate());
/* 357 */     typeAttri.setGmtModify(dto.getGmtModify());
/* 358 */     typeAttri.setId(dto.getId());
/* 359 */     typeAttri.setInputType(dto.getInputType());
/* 360 */     typeAttri.setIsRequired(dto.getIsRequired());
/* 361 */     typeAttri.setKeyName(dto.getKeyName());
/* 362 */     typeAttri.setKeyTitle(dto.getKeyTitle());
/* 363 */     typeAttri.setOperator(dto.getOperator());
/* 364 */     typeAttri.setProTypeCode(dto.getProTypeCode());
/* 365 */     typeAttri.setRank(dto.getRank());
/* 366 */     typeAttri.setRemark(dto.getRemark());
/* 367 */     typeAttri.setText(dto.getText());
/* 368 */     typeAttri.setValueValidate(dto.getValueValidate());
/* 369 */     return typeAttri;
/*     */   }
/*     */ 
/*     */   public static UserAgent convertToUserAgent(UserAccount userAccount) {
/* 373 */     UserAgent agent = new UserAgent();
/* 374 */     agent.setAccount(userAccount.getAccount());
/* 375 */     agent.setAccountId(userAccount.getId());
/* 376 */     agent.setFundAccount(userAccount.getFundAccount());
/* 377 */     agent.setName(userAccount.getName());
/* 378 */     if (userAccount.getLastLoginIp() == null)
/* 379 */       agent.setLastLoginIP("");
/*     */     else {
/* 381 */       agent.setLastLoginIP(userAccount.getLastLoginIp());
/*     */     }
/* 383 */     if (userAccount.getLastLoginTime() == null)
/* 384 */       agent.setLastLoginTime("");
/*     */     else {
/* 386 */       agent.setLastLoginTime(DateUtil.convertDateToString("yyyy-MM-dd HH:mm:ss", userAccount.getLastLoginTime()));
/*     */     }
/*     */ 
/* 389 */     agent.setType(userAccount.getType());
/* 390 */     return agent;
/*     */   }
/*     */ 
/*     */   public static ProjectListingDTO convertProjectListing2EditDTO(ProjectListing projectListing)
/*     */   {
/* 399 */     ProjectListingDTO projectListingDTO = new ProjectListingDTO();
/* 400 */     projectListingDTO.setId(projectListing.getId());
/* 401 */     projectListingDTO.setTitle(projectListing.getTitle());
/*     */ 
/* 406 */     projectListingDTO.setMeasureUnit(projectListing.getMeasureUnit());
/* 407 */     projectListingDTO.setQuantity(projectListing.getQuantity());
/* 408 */     projectListingDTO.setValuationUnit(projectListing.getValuationUnit());
/*     */ 
/* 416 */     projectListingDTO.setListingPrice(projectListing.getListingPrice());
/*     */ 
/* 419 */     projectListingDTO.setMultipleBase(projectListing.getMultipleBase());
/* 420 */     projectListingDTO.setMaxQuantity(projectListing.getMaxQuantity());
/* 421 */     projectListingDTO.setMinQuantity(projectListing.getMinQuantity());
/* 422 */     projectListingDTO.setRetail(projectListing.getRetail());
/*     */ 
/* 426 */     projectListingDTO.setDeliveryDate(projectListing.getDeliveryDate());
/* 427 */     projectListingDTO.setDeliveryPlace(projectListing.getDeliveryPlace());
/* 428 */     projectListingDTO.setDeliveryType(projectListing.getDeliveryType());
/* 429 */     projectListingDTO.setPaymentType(projectListing.getPaymentType());
/*     */ 
/* 431 */     projectListingDTO.setListingEndTime(projectListing.getListingEndTime());
/* 432 */     projectListingDTO.setInvoice(projectListing.getInvoice());
/*     */ 
/* 438 */     projectListingDTO.setOperator(projectListing.getOperator());
/* 439 */     projectListingDTO.setGmtCreate(projectListing.getGmtCreate());
/* 440 */     projectListingDTO.setGmtModify(projectListing.getGmtModify());
/* 441 */     projectListingDTO.setDeposit(projectListing.getDeposit());
/* 442 */     projectListingDTO.setProvince(projectListing.getProvince());
/* 443 */     projectListingDTO.setCity(projectListing.getCity());
/* 444 */     projectListingDTO.setArea(projectListing.getArea());
/* 445 */     projectListingDTO.setAddress(projectListing.getAddress());
/* 446 */     projectListingDTO.setLinkMan(projectListing.getLinkMan());
/* 447 */     projectListingDTO.setZipCode(projectListing.getZipCode());
/* 448 */     projectListingDTO.setPhone(projectListing.getPhone());
/* 449 */     projectListingDTO.setStorehouse(projectListing.getStorehouse());
/* 450 */     projectListingDTO.setPicturePath(projectListing.getPicturePath());
/* 451 */     projectListingDTO.setPicturePath1(projectListing.getPicturePath1());
/* 452 */     projectListingDTO.setPicturePath2(projectListing.getPicturePath2());
/* 453 */     projectListingDTO.setPicturePath3(projectListing.getPicturePath3());
/* 454 */     projectListingDTO.setPicturePath4(projectListing.getPicturePath4());
/* 455 */     projectListingDTO.setBreedStandardId(projectListing.getBreedStandardId());
/* 456 */     projectListingDTO.setDescription(projectListing.getDescription());
/* 457 */     projectListingDTO.setAttachedFilePath(projectListing.getAttachedFilePath());
/* 458 */     projectListingDTO.setSubstationId(projectListing.getSubstationId());
/* 459 */     return projectListingDTO;
/*     */   }
/*     */ 
/*     */   public static List<ProjectMetasDTO> convertMetaValues2DTO(ProjectListing projectListing) {
/* 463 */     List metasDTO = new ArrayList();
/* 464 */     if (projectListing.getMetaValues() != null) {
/* 465 */       for (ProjectMetas meta : projectListing.getMetaValues())
/* 466 */         if (meta != null) {
/* 467 */           ProjectMetasDTO metaDTO = new ProjectMetasDTO();
/* 468 */           metaDTO.setMetaGroup(meta.getMetaGroup() == null ? EnumMetaGroup.PROJECTTYPE.getValue() : meta.getMetaGroup());
/*     */ 
/* 470 */           metaDTO.setProjectId(projectListing.getId());
/* 471 */           metaDTO.setMetaKey(meta.getMetaKey());
/* 472 */           metaDTO.setMetaTitle(meta.getMetaTitle());
/* 473 */           metaDTO.setMetaValue(meta.getMetaValue());
/* 474 */           metaDTO.setOperator(projectListing.getOperator());
/* 475 */           metasDTO.add(metaDTO);
/*     */         }
/*     */     }
/* 478 */     return metasDTO;
/*     */   }
/*     */ 
/*     */   public static TradeOrderCcRequest convert(TradeOrderCc tradeOrderCc)
/*     */   {
/* 487 */     TradeOrderCcRequest tradeOrderCcRequest = new TradeOrderCcRequest();
/* 488 */     TradeOrderCcDTO tradeOrderCcDTO = new TradeOrderCcDTO();
/* 489 */     CopyUtil.copyProperties(tradeOrderCc, tradeOrderCcDTO);
/* 490 */     tradeOrderCcRequest.setTradeOrderCcDTO(tradeOrderCcDTO);
/* 491 */     return tradeOrderCcRequest;
/*     */   }
/*     */ 
/*     */   public static List<ProjectStandard> convertProjectStandardDTOList2ProjectStandardList(List<ProjectStandardDTO> data)
/*     */   {
/* 496 */     List list = new ArrayList();
/* 497 */     for (ProjectStandardDTO projectStandardDTO : data) {
/* 498 */       ProjectStandard projectStandard = convertProjectStandardDTO2ProjectStandard(projectStandardDTO);
/* 499 */       list.add(projectStandard);
/* 500 */       projectStandard = null;
/*     */     }
/* 502 */     data.clear();
/* 503 */     return list;
/*     */   }
/*     */ 
/*     */   public static ProjectStandard convertProjectStandardDTO2ProjectStandard(ProjectStandardDTO projectStandardDTO)
/*     */   {
/* 508 */     ProjectStandard projectStandard = new ProjectStandard();
/* 509 */     projectStandard.setContent(projectStandardDTO.getContent());
/*     */ 
/* 511 */     projectStandard.setGmtCreate(projectStandard.getGmtCreate());
/*     */ 
/* 513 */     projectStandard.setId(projectStandardDTO.getId());
/* 514 */     projectStandard.setName(projectStandardDTO.getName());
/* 515 */     projectStandard.setOperator(projectStandard.getOperator());
/* 516 */     projectStandard.setProTypeCode(projectStandard.getProTypeCode());
/* 517 */     projectStandard.setProTypeName(projectStandardDTO.getProTypeName());
/* 518 */     projectStandardDTO = null;
/* 519 */     return projectStandard;
/*     */   }
/*     */ 
/*     */   public static void convertProjectTypeAttriDTO2ProjectTypeAttri(ProjectTypeAttriDTO projectTypeAttriDTO, ProjectTypeAttri projectTypeAttri)
/*     */   {
/* 525 */     projectTypeAttri.setEnable(projectTypeAttriDTO.getEnable());
/* 526 */     projectTypeAttri.setGmtCreate(projectTypeAttriDTO.getGmtCreate());
/* 527 */     projectTypeAttri.setGmtModify(projectTypeAttriDTO.getGmtModify());
/* 528 */     projectTypeAttri.setId(projectTypeAttriDTO.getId());
/* 529 */     projectTypeAttri.setInputType(projectTypeAttriDTO.getInputType());
/* 530 */     projectTypeAttri.setIsRequired(projectTypeAttriDTO.getIsRequired());
/* 531 */     projectTypeAttri.setKeyName(projectTypeAttriDTO.getKeyName());
/* 532 */     projectTypeAttri.setKeyTitle(projectTypeAttriDTO.getKeyTitle());
/* 533 */     projectTypeAttri.setOperator(projectTypeAttriDTO.getOperator());
/* 534 */     projectTypeAttri.setProTypeCode(projectTypeAttriDTO.getProTypeCode());
/* 535 */     projectTypeAttri.setRank(projectTypeAttriDTO.getRank());
/* 536 */     projectTypeAttri.setRemark(projectTypeAttriDTO.getRemark());
/* 537 */     projectTypeAttri.setSelectValues(projectTypeAttriDTO.getSelectValues());
/*     */ 
/* 540 */     projectTypeAttri.setValueValidate(projectTypeAttriDTO.getValueValidate());
/*     */   }
/*     */ 
/*     */   public static List<ProjectMetasDTO> convertMetaValues2DTO(ProjectListing projectListing, List<TradeShowDTO> tradeMetas)
/*     */   {
/* 551 */     List metasDTO = new ArrayList();
/* 552 */     if ((tradeMetas != null) && (tradeMetas.size() > 0)) {
/* 553 */       for (TradeShowDTO tradeShowDTO : tradeMetas) {
/* 554 */         if (tradeShowDTO != null) {
/* 555 */           ProjectMetasDTO metaDTO = new ProjectMetasDTO();
/* 556 */           metaDTO.setMetaGroup(EnumMetaGroup.TRADINGTYPE.getValue());
/* 557 */           metaDTO.setProjectId(projectListing.getId());
/* 558 */           metaDTO.setMetaKey(tradeShowDTO.getKey());
/* 559 */           metaDTO.setMetaTitle(tradeShowDTO.getName());
/* 560 */           metaDTO.setMetaValue(tradeShowDTO.getInputValue());
/* 561 */           metaDTO.setOperator(projectListing.getOperator());
/* 562 */           metasDTO.add(metaDTO);
/*     */         }
/*     */       }
/*     */     }
/* 566 */     return metasDTO;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.web.util.ConvertUtils
 * JD-Core Version:    0.6.0
 */