/*     */ package com.hundsun.network.gates.taiping.common.util;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.qingbo.reomte.dto.ProjectBaseDTO;
/*     */ import com.hundsun.network.gates.luosi.qingbo.reomte.dto.ProjectDTO;
/*     */ import com.hundsun.network.gates.luosi.taiping.reomte.dto.ProjectInfo;
/*     */ import com.hundsun.network.gates.luosi.wangjiang.reomte.dto.PlaceOrderDTO;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.ProjectListingDTO;
/*     */ import com.hundsun.network.gates.taiping.biz.domain.placeorder.PlaceOrderInput;
/*     */ 
/*     */ public class ConvertUtils
/*     */ {
/*     */   public static ProjectInfo converntProjectDTO2ProjectInfo(ProjectDTO projectDTO)
/*     */   {
/*  12 */     ProjectInfo projectInfo = new ProjectInfo();
/*  13 */     projectInfo.setProjectListingDTO(projectDTO.getProjectBaseDTO().getProjectListingDTO());
/*  14 */     projectInfo.setProjectMetasDTOList(projectDTO.getProjectBaseDTO().getMetasDTOList());
/*  15 */     return projectInfo;
/*     */   }
/*     */ 
/*     */   public static void copyBaseTradeToPalceOrder(PlaceOrderInput placeOrderInput, ProjectListingDTO projectListingDTO)
/*     */   {
/*  25 */     placeOrderInput.setProjectCode(projectListingDTO.getCode());
/*  26 */     placeOrderInput.setProjectName(projectListingDTO.getTitle());
/*  27 */     placeOrderInput.setListingPrice(projectListingDTO.getListingPrice());
/*  28 */     placeOrderInput.setListingType(projectListingDTO.getListingType());
/*  29 */     placeOrderInput.setTradingType(projectListingDTO.getTradingType());
/*  30 */     placeOrderInput.setMeasureUnit(projectListingDTO.getMeasureUnit());
/*  31 */     placeOrderInput.setValuationUnit(projectListingDTO.getValuationUnit());
/*  32 */     placeOrderInput.setProjectTypeCode(projectListingDTO.getProjectTypeCode());
/*  33 */     placeOrderInput.setStorehouse(placeOrderInput.getStorehouse());
/*  34 */     placeOrderInput.setMultipleBase(projectListingDTO.getMultipleBase());
/*  35 */     placeOrderInput.setMaxQuantity(projectListingDTO.getMaxQuantity());
/*  36 */     placeOrderInput.setMinQuantity(projectListingDTO.getMinQuantity());
/*  37 */     placeOrderInput.setRetail(projectListingDTO.getRetail());
/*  38 */     placeOrderInput.setBreedStandardId(projectListingDTO.getBreedStandardId());
/*     */   }
/*     */ 
/*     */   public static PlaceOrderInput converntProjectInfo2PlaceOrderINfo(ProjectInfo projectInfo) {
/*  42 */     PlaceOrderInput placeOrderInput = new PlaceOrderInput();
/*  43 */     placeOrderInput.setProjectCode(projectInfo.getProjectListingDTO().getCode());
/*  44 */     placeOrderInput.setProjectName(projectInfo.getProjectListingDTO().getTitle());
/*  45 */     placeOrderInput.setListingPrice(projectInfo.getProjectListingDTO().getListingPrice());
/*  46 */     placeOrderInput.setListingType(projectInfo.getProjectListingDTO().getListingType());
/*  47 */     placeOrderInput.setQuantity(projectInfo.getProjectListingDTO().getQuantity());
/*  48 */     placeOrderInput.setTradingType(projectInfo.getProjectListingDTO().getTradingType());
/*  49 */     placeOrderInput.setDeliveryDate(projectInfo.getProjectListingDTO().getDeliveryDate());
/*  50 */     placeOrderInput.setDeliveryPlace(projectInfo.getProjectListingDTO().getDeliveryPlace());
/*  51 */     placeOrderInput.setDeliveryType(projectInfo.getProjectListingDTO().getDeliveryType());
/*  52 */     placeOrderInput.setPaymentType(projectInfo.getProjectListingDTO().getPaymentType());
/*  53 */     placeOrderInput.setInvoice(projectInfo.getProjectListingDTO().getInvoice());
/*  54 */     placeOrderInput.setMeasureUnit(projectInfo.getProjectListingDTO().getMeasureUnit());
/*  55 */     placeOrderInput.setValuationUnit(projectInfo.getProjectListingDTO().getValuationUnit());
/*  56 */     placeOrderInput.setProjectTypeCode(projectInfo.getProjectListingDTO().getProjectTypeCode());
/*     */ 
/*  58 */     placeOrderInput.setAddress(projectInfo.getProjectListingDTO().getAddress());
/*  59 */     placeOrderInput.setLinkMan(projectInfo.getProjectListingDTO().getLinkMan());
/*  60 */     placeOrderInput.setZipCode(projectInfo.getProjectListingDTO().getZipCode());
/*  61 */     placeOrderInput.setPhone(projectInfo.getProjectListingDTO().getPhone());
/*  62 */     placeOrderInput.setStorehouse(projectInfo.getProjectListingDTO().getStorehouse());
/*  63 */     placeOrderInput.setCity(projectInfo.getProjectListingDTO().getCity());
/*  64 */     placeOrderInput.setProvince(projectInfo.getProjectListingDTO().getProvince());
/*  65 */     placeOrderInput.setArea(projectInfo.getProjectListingDTO().getArea());
/*     */ 
/*  69 */     placeOrderInput.setMultipleBase(projectInfo.getProjectListingDTO().getMultipleBase());
/*     */ 
/*  75 */     placeOrderInput.setMaxQuantity(projectInfo.getProjectListingDTO().getMaxQuantity());
/*     */ 
/*  84 */     placeOrderInput.setMinQuantity(projectInfo.getProjectListingDTO().getMinQuantity());
/*     */ 
/*  91 */     placeOrderInput.setRetail(projectInfo.getProjectListingDTO().getRetail());
/*  92 */     placeOrderInput.setPicturePath(projectInfo.getProjectListingDTO().getPicturePath());
/*  93 */     placeOrderInput.setPicturePath1(projectInfo.getProjectListingDTO().getPicturePath1());
/*  94 */     placeOrderInput.setPicturePath2(projectInfo.getProjectListingDTO().getPicturePath2());
/*  95 */     placeOrderInput.setPicturePath3(projectInfo.getProjectListingDTO().getPicturePath3());
/*  96 */     placeOrderInput.setPicturePath4(projectInfo.getProjectListingDTO().getPicturePath4());
/*  97 */     placeOrderInput.setBreedStandardId(projectInfo.getProjectListingDTO().getBreedStandardId());
/*  98 */     placeOrderInput.setDescription(projectInfo.getProjectListingDTO().getDescription());
/*  99 */     return placeOrderInput;
/*     */   }
/*     */ 
/*     */   public static PlaceOrderDTO converntProjectInput2ProjectDTO(PlaceOrderInput placeOrderInput) {
/* 103 */     PlaceOrderDTO placeOrderDTO = new PlaceOrderDTO();
/* 104 */     placeOrderDTO.setProjectName(placeOrderInput.getProjectName());
/* 105 */     placeOrderDTO.setUserId(placeOrderInput.getUserId());
/*     */ 
/* 107 */     placeOrderDTO.setMeasureUnit(placeOrderInput.getMeasureUnit());
/*     */ 
/* 109 */     placeOrderDTO.setValuationUnit(placeOrderInput.getValuationUnit());
/*     */ 
/* 111 */     placeOrderDTO.setDeliveryDate(placeOrderInput.getDeliveryDate());
/*     */ 
/* 113 */     placeOrderDTO.setDeliveryPlace(placeOrderInput.getDeliveryPlace());
/*     */ 
/* 115 */     placeOrderDTO.setDeliveryType(placeOrderInput.getDeliveryType());
/*     */ 
/* 117 */     placeOrderDTO.setPaymentType(placeOrderInput.getPaymentType());
/*     */ 
/* 119 */     placeOrderDTO.setInvoice(placeOrderInput.getInvoice());
/* 120 */     placeOrderDTO.setProjectCode(placeOrderInput.getProjectCode());
/* 121 */     placeOrderDTO.setUserAccount(placeOrderInput.getUserAccount());
/* 122 */     placeOrderDTO.setFundAccount(placeOrderInput.getFundAccount());
/* 123 */     placeOrderDTO.setTradingType(placeOrderInput.getTradingType());
/* 124 */     placeOrderDTO.setQuantity(placeOrderInput.getQuantity());
/* 125 */     placeOrderDTO.setListingPrice(placeOrderInput.getListingPrice());
/* 126 */     placeOrderDTO.setListingType(placeOrderInput.getListingType());
/* 127 */     placeOrderDTO.setTotalPay(placeOrderInput.getTotalPay());
/* 128 */     placeOrderDTO.setComments(placeOrderInput.getComments());
/* 129 */     placeOrderDTO.setUserName(placeOrderInput.getUserName());
/* 130 */     placeOrderDTO.setProjectTypeCode(placeOrderInput.getProjectTypeCode());
/* 131 */     placeOrderDTO.setProvince(placeOrderInput.getProvince());
/* 132 */     placeOrderDTO.setCity(placeOrderInput.getCity());
/* 133 */     placeOrderDTO.setArea(placeOrderInput.getArea());
/* 134 */     placeOrderDTO.setAddress(placeOrderInput.getAddress());
/* 135 */     placeOrderDTO.setLinkMan(placeOrderInput.getLinkMan());
/* 136 */     placeOrderDTO.setZipCode(placeOrderInput.getZipCode());
/* 137 */     placeOrderDTO.setPhone(placeOrderInput.getPhone());
/* 138 */     placeOrderDTO.setStorehouse(placeOrderInput.getStorehouse());
/*     */ 
/* 140 */     placeOrderDTO.setPicturePath(placeOrderInput.getPicturePath());
/* 141 */     placeOrderDTO.setPicturePath1(placeOrderInput.getPicturePath1());
/* 142 */     placeOrderDTO.setPicturePath2(placeOrderInput.getPicturePath2());
/* 143 */     placeOrderDTO.setPicturePath3(placeOrderInput.getPicturePath3());
/* 144 */     placeOrderDTO.setPicturePath4(placeOrderInput.getPicturePath4());
/* 145 */     placeOrderDTO.setBreedStandardId(placeOrderInput.getBreedStandardId());
/* 146 */     placeOrderDTO.setDescription(placeOrderInput.getDescription());
/*     */ 
/* 148 */     return placeOrderDTO;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.taiping.common.util.ConvertUtils
 * JD-Core Version:    0.6.0
 */