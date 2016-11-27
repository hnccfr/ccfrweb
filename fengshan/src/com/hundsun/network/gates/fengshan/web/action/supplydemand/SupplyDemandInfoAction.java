/*     */ package com.hundsun.network.gates.fengshan.web.action.supplydemand;
/*     */ 
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.query.SupplyDemandInfoQuery;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.query.SupplyDemandVisitorsQuery;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.supplydemand.AccuseInfo;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.supplydemand.SupplyDemandInfo;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.supplydemand.SupplyDemandInfoAudit;
/*     */ import com.hundsun.network.gates.fengshan.biz.enums.EnumAccuseType;
/*     */ import com.hundsun.network.gates.fengshan.biz.service.common.UploadService;
/*     */ import com.hundsun.network.gates.fengshan.biz.service.supplydemand.SupplyDemandInfoService;
/*     */ import com.hundsun.network.gates.fengshan.web.action.BaseAction;
/*     */ import com.hundsun.network.gates.fengshan.web.validator.supplydemand.SupplyDemandInfoValidator;
/*     */ import com.hundsun.network.gates.luosi.biz.domain.UserAgent;
/*     */ import com.hundsun.network.gates.luosi.biz.security.SystemAccess;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumDeliveryType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumInfoRetail;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumInfoStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumInfoType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumInvoice;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumMeasureUnit;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumValuationUnit;
/*     */ import com.hundsun.network.gates.luosi.common.utils.CommonUtils;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.io.IOException;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.List;
/*     */ import org.apache.commons.lang.StringUtils;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.validation.BindingResult;
/*     */ import org.springframework.web.bind.annotation.ModelAttribute;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ import org.springframework.web.multipart.MultipartFile;
/*     */ 
/*     */ @Controller
/*     */ public class SupplyDemandInfoAction extends BaseAction
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private SupplyDemandInfoService supplyDemandInfoService;
/*     */ 
/*     */   @Autowired
/*     */   private SupplyDemandInfoValidator supplyDemandInfoValidator;
/*     */ 
/*     */   @Autowired
/*     */   private UploadService uploadService;
/*     */ 
/*     */   public void prepareSupplyDemandInfo(ModelMap model)
/*     */   {
/*  67 */     model.addAttribute("infoTypes", EnumInfoType.values());
/*  68 */     model.addAttribute("measureUnits", EnumMeasureUnit.values());
/*  69 */     model.addAttribute("valuationUnits", EnumValuationUnit.values());
/*  70 */     model.addAttribute("deliveryTypes", EnumDeliveryType.values());
/*  71 */     model.addAttribute("infoRetails", EnumInfoRetail.values());
/*  72 */     model.addAttribute("infoInvoices", EnumInvoice.values());
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_C_INFO_ADD})
/*     */   @RequestMapping(value={"supplydemand/add"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void goInfoAdd(@ModelAttribute("supplyDemandInfo") SupplyDemandInfo supplyDemandInfo, ModelMap model)
/*     */   {
/*  86 */     prepareSupplyDemandInfo(model);
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_C_INFO_ADD})
/*     */   @RequestMapping(value={"supplydemand/add"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String doInfoAdd(@ModelAttribute("supplyDemandInfo") SupplyDemandInfo supplyDemandInfo, BindingResult result, UserAgent userAgent, @RequestParam("uploadFile0") MultipartFile uploadFile0, @RequestParam("uploadFile1") MultipartFile uploadFile1, @RequestParam("uploadFile2") MultipartFile uploadFile2, @RequestParam("uploadFile3") MultipartFile uploadFile3, @RequestParam("uploadFile4") MultipartFile uploadFile4, ModelMap model)
/*     */   {
/*  99 */     this.supplyDemandInfoValidator.validatePictures(uploadFile0, "picturePath", result);
/* 100 */     if (result.hasErrors()) {
/* 101 */       prepareSupplyDemandInfo(model);
/* 102 */       model.addAttribute("supplyDemandInfo", supplyDemandInfo);
/* 103 */       return "supplydemand/add";
/*     */     }
/* 105 */     this.supplyDemandInfoValidator.validatePictures(uploadFile1, "picturePath1", result);
/* 106 */     if (result.hasErrors()) {
/* 107 */       prepareSupplyDemandInfo(model);
/* 108 */       model.addAttribute("supplyDemandInfo", supplyDemandInfo);
/* 109 */       return "supplydemand/add";
/*     */     }
/* 111 */     this.supplyDemandInfoValidator.validatePictures(uploadFile2, "picturePath2", result);
/* 112 */     if (result.hasErrors()) {
/* 113 */       prepareSupplyDemandInfo(model);
/* 114 */       model.addAttribute("supplyDemandInfo", supplyDemandInfo);
/* 115 */       return "supplydemand/add";
/*     */     }
/* 117 */     this.supplyDemandInfoValidator.validatePictures(uploadFile3, "picturePath3", result);
/* 118 */     if (result.hasErrors()) {
/* 119 */       prepareSupplyDemandInfo(model);
/* 120 */       model.addAttribute("supplyDemandInfo", supplyDemandInfo);
/* 121 */       return "supplydemand/add";
/*     */     }
/* 123 */     this.supplyDemandInfoValidator.validatePictures(uploadFile4, "picturePath4", result);
/* 124 */     if (result.hasErrors()) {
/* 125 */       prepareSupplyDemandInfo(model);
/* 126 */       model.addAttribute("supplyDemandInfo", supplyDemandInfo);
/* 127 */       return "supplydemand/add";
/*     */     }
/* 129 */     this.supplyDemandInfoValidator.validate(supplyDemandInfo, result);
/* 130 */     if (result.hasErrors()) {
/* 131 */       prepareSupplyDemandInfo(model);
/* 132 */       model.addAttribute("supplyDemandInfo", supplyDemandInfo);
/* 133 */       return "supplydemand/add";
/*     */     }
/* 135 */     prepareSupplyDemandInfo(model);
/* 136 */     BigDecimal bg = new BigDecimal(supplyDemandInfo.getPriceDesc());
/* 137 */     Long p = Long.valueOf(bg.movePointRight(EnumValuationUnit.indexByValue(supplyDemandInfo.getValuationUnit()).getScale()).longValue());
/*     */ 
/* 140 */     supplyDemandInfo.setPrice(p);
/* 141 */     supplyDemandInfo.setOperator(userAgent.getAccount());
/* 142 */     supplyDemandInfo.setPublisherAccount(userAgent.getAccount());
/* 143 */     supplyDemandInfo.setStatus(EnumInfoStatus.CREATE.getValue());
/* 144 */     supplyDemandInfo.setProjectCode(this.supplyDemandInfoService.projectCodeCreator(supplyDemandInfo));
/*     */     try
/*     */     {
/* 149 */       String picturePath = "";
/* 150 */       String picturePath1 = "";
/* 151 */       String picturePath2 = "";
/* 152 */       String picturePath3 = "";
/* 153 */       String picturePath4 = "";
/* 154 */       if ((uploadFile0 != null) && (uploadFile0.getSize() > 0L)) {
/* 155 */         String imgExg = CommonUtils.getFileSuffix(uploadFile0.getOriginalFilename());
/* 156 */         picturePath = this.uploadService.uploadFile(uploadFile0.getInputStream(), imgExg);
/* 157 */         supplyDemandInfo.setPicturePath(picturePath);
/*     */       } else {
/* 159 */         supplyDemandInfo.setPicturePath(null);
/*     */       }
/* 161 */       if ((uploadFile1 != null) && (uploadFile1.getSize() > 0L)) {
/* 162 */         String imgExg = CommonUtils.getFileSuffix(uploadFile1.getOriginalFilename());
/* 163 */         picturePath1 = this.uploadService.uploadFile(uploadFile1.getInputStream(), imgExg);
/* 164 */         supplyDemandInfo.setPicturePath1(picturePath1);
/*     */       } else {
/* 166 */         supplyDemandInfo.setPicturePath1(null);
/*     */       }
/* 168 */       if ((uploadFile2 != null) && (uploadFile2.getSize() > 0L)) {
/* 169 */         String imgExg = CommonUtils.getFileSuffix(uploadFile2.getOriginalFilename());
/* 170 */         picturePath2 = this.uploadService.uploadFile(uploadFile2.getInputStream(), imgExg);
/* 171 */         supplyDemandInfo.setPicturePath2(picturePath2);
/*     */       } else {
/* 173 */         supplyDemandInfo.setPicturePath2(null);
/*     */       }
/* 175 */       if ((uploadFile3 != null) && (uploadFile3.getSize() > 0L)) {
/* 176 */         String imgExg = CommonUtils.getFileSuffix(uploadFile3.getOriginalFilename());
/* 177 */         picturePath3 = this.uploadService.uploadFile(uploadFile3.getInputStream(), imgExg);
/* 178 */         supplyDemandInfo.setPicturePath3(picturePath3);
/*     */       } else {
/* 180 */         supplyDemandInfo.setPicturePath3(null);
/*     */       }
/* 182 */       if ((uploadFile4 != null) && (uploadFile4.getSize() > 0L)) {
/* 183 */         String imgExg = CommonUtils.getFileSuffix(uploadFile4.getOriginalFilename());
/* 184 */         picturePath4 = this.uploadService.uploadFile(uploadFile4.getInputStream(), imgExg);
/* 185 */         supplyDemandInfo.setPicturePath4(picturePath4);
/*     */       } else {
/* 187 */         supplyDemandInfo.setPicturePath4(null);
/*     */       }
/*     */     }
/*     */     catch (IOException e) {
/* 191 */       this.log.error("uploadPicture error, cause by:" + e);
/*     */     }
/* 193 */     this.supplyDemandInfoService.addSupplyDemandInfo(supplyDemandInfo);
/* 194 */     Long infoId = Long.valueOf(supplyDemandInfo.getId());
/* 195 */     return redirect("/supplydemand/addSuccess.htm?id=" + infoId.toString());
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_C_INFO_ADD})
/*     */   @RequestMapping(value={"supplydemand/addSuccess"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String doShowSuccessPage(@RequestParam("id") Long supplyDemandInfoId, ModelMap model)
/*     */   {
/* 211 */     if (null != supplyDemandInfoId)
/*     */     {
/* 213 */       String reURL = "/supplydemand/list.htm";
/* 214 */       model.addAttribute("reURL", reURL);
/* 215 */       model.addAttribute("supplyDemandInfoId", supplyDemandInfoId);
/*     */     } else {
/* 217 */       return error(model, "parameter.error.null", new String[0]);
/*     */     }
/* 219 */     return "supplydemand/addSuccess";
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_R_INFO_LIST})
/*     */   @RequestMapping({"supplydemand/list"})
/*     */   public void doSearchInfoList(@ModelAttribute("query") SupplyDemandInfoQuery query, UserAgent userAgent, ModelMap model)
/*     */   {
/* 234 */     EnumInfoStatus[] status = EnumInfoStatus.values();
/* 235 */     if (null == query) {
/* 236 */       query = new SupplyDemandInfoQuery();
/*     */     }
/* 238 */     query.setPublisherAccount(userAgent.getAccount());
/* 239 */     int num = this.supplyDemandInfoService.updateSupplyDemandInfoOverdue();
/* 240 */     if (num > 0) {
/* 241 */       this.supplyDemandInfoService.updateSupplyDemandInfoAccuseOverdue();
/*     */     }
/* 243 */     this.supplyDemandInfoService.getSupplyDemandInfoByQuery(query);
/* 244 */     model.addAttribute("query", query);
/* 245 */     model.addAttribute("sdiStatus", status);
/* 246 */     model.addAttribute("infoTypes", EnumInfoType.values());
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_U_INFO_AUDIT})
/*     */   @RequestMapping({"supplydemand/subAudit"})
/*     */   @ResponseBody
/*     */   public String doUpdateInfoToAudit(@RequestParam(value="projectId", required=true) Long projectId, UserAgent userAgent, ModelMap model)
/*     */   {
/* 260 */     SupplyDemandInfo infoLis = this.supplyDemandInfoService.getSupplyDemandInfoById2(projectId);
/* 261 */     if (!infoLis.getPublisherAccount().equals(userAgent.getAccount())) {
/* 262 */       return "userError";
/*     */     }
/* 264 */     if (!infoLis.getStatus().equals(EnumInfoStatus.CREATE.getValue())) {
/* 265 */       return "logicError";
/*     */     }
/* 267 */     infoLis.setStatus(EnumInfoStatus.AUDIT.getValue());
/* 268 */     this.supplyDemandInfoService.updateSupplyDemandInfoStatusById(infoLis);
/* 269 */     return "success";
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_U_INFO_EDIT})
/*     */   @RequestMapping(value={"supplydemand/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String goInfoEdit(@RequestParam(value="proId", required=true) Long proId, UserAgent userAgent, ModelMap model)
/*     */   {
/* 281 */     SupplyDemandInfo supplyDemandInfo = this.supplyDemandInfoService.getSupplyDemandInfoById(proId);
/* 282 */     if (!supplyDemandInfo.getPublisherAccount().equals(userAgent.getAccount())) {
/* 283 */       return "403";
/*     */     }
/* 285 */     model.addAttribute("supplyDemandInfo", supplyDemandInfo);
/* 286 */     prepareSupplyDemandInfo(model);
/* 287 */     model.addAttribute("url", "/supplydemand/list.htm");
/* 288 */     return "supplydemand/edit";
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_U_INFO_EDIT})
/*     */   @RequestMapping(value={"supplydemand/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String doInfoEdit(@ModelAttribute("supplyDemandInfo") SupplyDemandInfo supplyDemandInfo, BindingResult result, UserAgent userAgent, @RequestParam("uploadFile0") MultipartFile uploadFile0, @RequestParam("uploadFile1") MultipartFile uploadFile1, @RequestParam("uploadFile2") MultipartFile uploadFile2, @RequestParam("uploadFile3") MultipartFile uploadFile3, @RequestParam("uploadFile4") MultipartFile uploadFile4, ModelMap model)
/*     */   {
/* 300 */     this.supplyDemandInfoValidator.validatePictures(uploadFile0, "picturePath", result);
/* 301 */     if (result.hasErrors()) {
/* 302 */       prepareSupplyDemandInfo(model);
/* 303 */       model.addAttribute("supplyDemandInfo", supplyDemandInfo);
/* 304 */       return "supplydemand/edit";
/*     */     }
/* 306 */     this.supplyDemandInfoValidator.validatePictures(uploadFile1, "picturePath1", result);
/* 307 */     if (result.hasErrors()) {
/* 308 */       prepareSupplyDemandInfo(model);
/* 309 */       model.addAttribute("supplyDemandInfo", supplyDemandInfo);
/* 310 */       return "supplydemand/edit";
/*     */     }
/* 312 */     this.supplyDemandInfoValidator.validatePictures(uploadFile2, "picturePath2", result);
/* 313 */     if (result.hasErrors()) {
/* 314 */       prepareSupplyDemandInfo(model);
/* 315 */       model.addAttribute("supplyDemandInfo", supplyDemandInfo);
/* 316 */       return "supplydemand/edit";
/*     */     }
/* 318 */     this.supplyDemandInfoValidator.validatePictures(uploadFile3, "picturePath3", result);
/* 319 */     if (result.hasErrors()) {
/* 320 */       prepareSupplyDemandInfo(model);
/* 321 */       model.addAttribute("supplyDemandInfo", supplyDemandInfo);
/* 322 */       return "supplydemand/edit";
/*     */     }
/* 324 */     this.supplyDemandInfoValidator.validatePictures(uploadFile4, "picturePath4", result);
/* 325 */     if (result.hasErrors()) {
/* 326 */       prepareSupplyDemandInfo(model);
/* 327 */       model.addAttribute("supplyDemandInfo", supplyDemandInfo);
/* 328 */       return "supplydemand/edit";
/*     */     }
/* 330 */     this.supplyDemandInfoValidator.validate(supplyDemandInfo, result);
/* 331 */     if (result.hasErrors()) {
/* 332 */       prepareSupplyDemandInfo(model);
/* 333 */       model.addAttribute("supplyDemandInfo", supplyDemandInfo);
/* 334 */       return "supplydemand/edit";
/*     */     }
/* 336 */     this.supplyDemandInfoValidator.validate(supplyDemandInfo, result);
/* 337 */     if (result.hasErrors()) {
/* 338 */       prepareSupplyDemandInfo(model);
/* 339 */       model.addAttribute("supplyDemandInfo", supplyDemandInfo);
/* 340 */       return "supplydemand/edit";
/*     */     }
/* 342 */     BigDecimal bg = new BigDecimal(supplyDemandInfo.getPriceDesc());
/* 343 */     Long p = Long.valueOf(bg.movePointRight(EnumValuationUnit.indexByValue(supplyDemandInfo.getValuationUnit()).getScale()).longValue());
/*     */ 
/* 346 */     supplyDemandInfo.setPrice(p);
/* 347 */     supplyDemandInfo.setOperator(userAgent.getAccount());
/* 348 */     supplyDemandInfo.setPublisherAccount(userAgent.getAccount());
/*     */     try {
/* 350 */       String picturePath = supplyDemandInfo.getPicturePath();
/* 351 */       String picturePath1 = supplyDemandInfo.getPicturePath1();
/* 352 */       String picturePath2 = supplyDemandInfo.getPicturePath2();
/* 353 */       String picturePath3 = supplyDemandInfo.getPicturePath3();
/* 354 */       String picturePath4 = supplyDemandInfo.getPicturePath4();
/* 355 */       if ((null != uploadFile0) && (uploadFile0.getSize() > 0L)) {
/* 356 */         if (StringUtils.isNotEmpty(picturePath)) {
/* 357 */           this.uploadService.deleteOriginalFile(picturePath);
/*     */         }
/* 359 */         String imgExg = CommonUtils.getFileSuffix(uploadFile0.getOriginalFilename());
/* 360 */         picturePath = this.uploadService.uploadFile(uploadFile0.getInputStream(), imgExg);
/* 361 */         supplyDemandInfo.setPicturePath(picturePath);
/*     */       }
/* 363 */       else if (StringUtils.isEmpty(supplyDemandInfo.getTempPath())) {
/* 364 */         this.uploadService.deleteOriginalFile(picturePath);
/* 365 */         supplyDemandInfo.setPicturePath("");
/*     */       }
/*     */ 
/* 368 */       if ((null != uploadFile1) && (uploadFile1.getSize() > 0L)) {
/* 369 */         if (StringUtils.isNotEmpty(picturePath1)) {
/* 370 */           this.uploadService.deleteOriginalFile(picturePath1);
/*     */         }
/* 372 */         String imgExg = CommonUtils.getFileSuffix(uploadFile1.getOriginalFilename());
/* 373 */         picturePath1 = this.uploadService.uploadFile(uploadFile1.getInputStream(), imgExg);
/* 374 */         supplyDemandInfo.setPicturePath1(picturePath1);
/*     */       }
/* 376 */       else if (StringUtils.isEmpty(supplyDemandInfo.getTempPath1())) {
/* 377 */         this.uploadService.deleteOriginalFile(picturePath1);
/* 378 */         supplyDemandInfo.setPicturePath1("");
/*     */       }
/*     */ 
/* 381 */       if ((null != uploadFile2) && (uploadFile2.getSize() > 0L)) {
/* 382 */         if (StringUtils.isNotEmpty(picturePath2)) {
/* 383 */           this.uploadService.deleteOriginalFile(picturePath2);
/*     */         }
/* 385 */         String imgExg = CommonUtils.getFileSuffix(uploadFile2.getOriginalFilename());
/* 386 */         picturePath2 = this.uploadService.uploadFile(uploadFile2.getInputStream(), imgExg);
/* 387 */         supplyDemandInfo.setPicturePath2(picturePath2);
/*     */       }
/* 389 */       else if (StringUtils.isEmpty(supplyDemandInfo.getTempPath2())) {
/* 390 */         this.uploadService.deleteOriginalFile(picturePath2);
/* 391 */         supplyDemandInfo.setPicturePath2("");
/*     */       }
/*     */ 
/* 394 */       if ((null != uploadFile3) && (uploadFile3.getSize() > 0L)) {
/* 395 */         if (StringUtils.isNotEmpty(picturePath3)) {
/* 396 */           this.uploadService.deleteOriginalFile(picturePath3);
/*     */         }
/* 398 */         String imgExg = CommonUtils.getFileSuffix(uploadFile3.getOriginalFilename());
/* 399 */         picturePath3 = this.uploadService.uploadFile(uploadFile3.getInputStream(), imgExg);
/* 400 */         supplyDemandInfo.setPicturePath3(picturePath3);
/*     */       }
/* 402 */       else if (StringUtils.isEmpty(supplyDemandInfo.getTempPath3())) {
/* 403 */         this.uploadService.deleteOriginalFile(picturePath3);
/* 404 */         supplyDemandInfo.setPicturePath3("");
/*     */       }
/*     */ 
/* 407 */       if ((null != uploadFile4) && (uploadFile4.getSize() > 0L)) {
/* 408 */         if (StringUtils.isNotEmpty(picturePath4)) {
/* 409 */           this.uploadService.deleteOriginalFile(picturePath4);
/*     */         }
/* 411 */         String imgExg = CommonUtils.getFileSuffix(uploadFile4.getOriginalFilename());
/* 412 */         picturePath4 = this.uploadService.uploadFile(uploadFile4.getInputStream(), imgExg);
/* 413 */         supplyDemandInfo.setPicturePath4(picturePath4);
/*     */       }
/* 415 */       else if (StringUtils.isEmpty(supplyDemandInfo.getTempPath4())) {
/* 416 */         this.uploadService.deleteOriginalFile(picturePath4);
/* 417 */         supplyDemandInfo.setPicturePath4("");
/*     */       }
/*     */     }
/*     */     catch (IOException e) {
/* 421 */       this.log.error("uploadPicture error, cause by:" + e);
/*     */     }
/* 423 */     this.supplyDemandInfoService.updateSupplyDemandInfo(supplyDemandInfo);
/* 424 */     Long infoId = Long.valueOf(supplyDemandInfo.getId());
/* 425 */     return redirect("/supplydemand/editSuccess.htm?proId=" + infoId.toString());
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"supplydemand/editSuccess"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String doShowEditSuccessPage(@RequestParam("proId") Long proId, ModelMap model)
/*     */   {
/* 438 */     if (null != proId)
/*     */     {
/* 440 */       String reURL = "/supplydemand/list.htm";
/* 441 */       model.addAttribute("reURL", reURL);
/* 442 */       model.addAttribute("supplyDemandInfoId", proId);
/*     */     } else {
/* 444 */       return error(model, "parameter.error.null", new String[0]);
/*     */     }
/* 446 */     return "supplydemand/editSuccess";
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_U_INFO_OVERDUE})
/*     */   @RequestMapping({"supplydemand/markOverdue"})
/*     */   @ResponseBody
/*     */   public String doMarkInfoOverdue(@RequestParam(value="projectId", required=true) Long projectId, UserAgent userAgent, ModelMap model)
/*     */   {
/* 461 */     SupplyDemandInfo infoLis = this.supplyDemandInfoService.getSupplyDemandInfoById2(projectId);
/* 462 */     List accuseLis = this.supplyDemandInfoService.getSupplyDemandInfoAccuseById(projectId);
/* 463 */     if (accuseLis.size() != 0) {
/* 464 */       return "warning";
/*     */     }
/* 466 */     if (!infoLis.getPublisherAccount().equals(userAgent.getAccount())) {
/* 467 */       return "userError";
/*     */     }
/* 469 */     if (!infoLis.getStatus().equals(EnumInfoStatus.NORMAL.getValue())) {
/* 470 */       return "logicError";
/*     */     }
/* 472 */     infoLis.setStatus(EnumInfoStatus.OVERDUE.getValue());
/* 473 */     this.supplyDemandInfoService.updateSupplyDemandInfoStatusById(infoLis);
/* 474 */     return "success";
/*     */   }
/*     */ 
/*     */   @RequestMapping({"supplydemand/viewAccuseInfo"})
/*     */   @ResponseBody
/*     */   public Object doViewAccuseInfo(@RequestParam(value="projectId", required=true) Long projectId)
/*     */   {
/* 485 */     AccuseInfo accuseInfo = this.supplyDemandInfoService.getAccuseReasonById(projectId);
/* 486 */     if (null != accuseInfo) {
/* 487 */       return accuseInfo;
/*     */     }
/* 489 */     SupplyDemandInfoAudit auditLis = this.supplyDemandInfoService.getSupplyDemandInfoAuditById(projectId);
/* 490 */     return auditLis;
/*     */   }
/*     */ 
/*     */   @RequestMapping({"supplydemand/viewAuditInfo"})
/*     */   @ResponseBody
/*     */   public SupplyDemandInfoAudit doViewAuditInfo(@RequestParam(value="projectId", required=true) Long projectId)
/*     */   {
/* 502 */     SupplyDemandInfoAudit auditLis = this.supplyDemandInfoService.getSupplyDemandInfoAuditById(projectId);
/* 503 */     return auditLis;
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_D_INFO_DELETE})
/*     */   @RequestMapping({"supplydemand/deleteInfo"})
/*     */   @ResponseBody
/*     */   public String doDeleteInfo(@RequestParam(value="projectId", required=true) Long projectId, UserAgent userAgent)
/*     */   {
/* 516 */     SupplyDemandInfo infoLis = this.supplyDemandInfoService.getSupplyDemandInfoById2(projectId);
/* 517 */     if (!infoLis.getPublisherAccount().equals(userAgent.getAccount())) {
/* 518 */       return "userError";
/*     */     }
/* 520 */     List accuseLis = this.supplyDemandInfoService.getSupplyDemandInfoAccuseById(projectId);
/*     */ 
/* 542 */     if (infoLis.getStatus().equals(EnumInfoStatus.CREATE.getValue())) {
/* 543 */       this.supplyDemandInfoService.deleteSupplyDemandInfoById(infoLis);
/* 544 */       return "success";
/* 545 */     }if ((infoLis.getStatus().equals(EnumInfoStatus.NORMAL.getValue())) || (infoLis.getStatus().equals(EnumInfoStatus.FAIL.getValue())) || (infoLis.getStatus().equals(EnumInfoStatus.OVERDUE.getValue())))
/*     */     {
/* 548 */       if (accuseLis.size() != 0) {
/* 549 */         return "warning";
/*     */       }
/* 551 */       infoLis.setStatus(EnumInfoStatus.DELETED.getValue());
/* 552 */       this.supplyDemandInfoService.updateSupplyDemandInfoStatusById(infoLis);
/* 553 */       return "success";
/*     */     }
/*     */ 
/* 556 */     return "logicError";
/*     */   }
/*     */ 
/*     */   @RequestMapping({"home/supplydemand/information"})
/*     */   public void doSearchApprovedProjects(@ModelAttribute("query") SupplyDemandVisitorsQuery query, ModelMap model)
/*     */   {
/* 570 */     query.setStatus("N");
/* 571 */     query.setSysTimeFlag("Y");
/* 572 */     this.supplyDemandInfoService.getSupplyDemandByQuery(query);
/* 573 */     EnumInfoType[] infoType = EnumInfoType.values();
/* 574 */     model.addAttribute("infoType", infoType);
/*     */   }
/*     */ 
/*     */   @RequestMapping({"cms/supply"})
/*     */   public String cmsSupply(ModelMap model)
/*     */   {
/* 584 */     Integer count = Integer.valueOf(8);
/* 585 */     SupplyDemandVisitorsQuery query = new SupplyDemandVisitorsQuery();
/* 586 */     query.setPageSize(count.intValue());
/* 587 */     query.setStatus("N");
/* 588 */     query.setSysTimeFlag("Y");
/* 589 */     query.setInfoType(EnumInfoType.SUPPLY.getValue());
/* 590 */     this.supplyDemandInfoService.getSupplyDemandByQuery(query);
/* 591 */     model.addAttribute("supplyList", query.getData());
/* 592 */     return "/home/cms/supply";
/*     */   }
/*     */ 
/*     */   @RequestMapping({"cms/demand"})
/*     */   public String cmsDemand(ModelMap model)
/*     */   {
/* 602 */     Integer count = Integer.valueOf(8);
/* 603 */     SupplyDemandVisitorsQuery query = new SupplyDemandVisitorsQuery();
/* 604 */     query.setPageSize(count.intValue());
/* 605 */     query.setStatus("N");
/* 606 */     query.setSysTimeFlag("Y");
/* 607 */     query.setInfoType(EnumInfoType.DEMAND.getValue());
/* 608 */     this.supplyDemandInfoService.getSupplyDemandByQuery(query);
/* 609 */     model.addAttribute("supplyList", query.getData());
/* 610 */     return "/home/cms/supply";
/*     */   }
/*     */ 
/*     */   @RequestMapping({"home/supplydemand/detail"})
/*     */   public String doShowSupplyDemand(@RequestParam(value="projectCode", required=true) String projectCode, ModelMap model)
/*     */   {
/* 622 */     SupplyDemandInfo supplyDemandInfo = null;
/* 623 */     if (!StringUtil.isEmpty(projectCode))
/* 624 */       supplyDemandInfo = this.supplyDemandInfoService.getSupplyDemandByCode(projectCode);
/*     */     else {
/* 626 */       return error(model, "parameter.error.null", new String[0]);
/*     */     }
/* 628 */     model.addAttribute("supplyDemandInfo", supplyDemandInfo);
/* 629 */     return "home/supplydemand/detail";
/*     */   }
/*     */ 
/*     */   private void initeRegPage(ModelMap model)
/*     */   {
/* 637 */     EnumAccuseType[] enumAccuseTypes = EnumAccuseType.values();
/* 638 */     model.addAttribute("enumAccuseTypes", enumAccuseTypes);
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_U_INFO_ACCUSE})
/*     */   @RequestMapping({"home/supplydemand/checkAccuse"})
/*     */   @ResponseBody
/*     */   public String accuse(@RequestParam(value="infoId", required=false) long infoId, UserAgent userAgent, ModelMap model)
/*     */   {
/* 650 */     initeRegPage(model);
/* 651 */     SupplyDemandInfo supplyDemandInfo = this.supplyDemandInfoService.getSupplyDemandInfoById2(Long.valueOf(infoId));
/* 652 */     if (EnumInfoStatus.FORBIDDEN.getValue().equals(supplyDemandInfo.getStatus()))
/* 653 */       return "forbidden";
/* 654 */     if (supplyDemandInfo.getPublisherAccount().equals(userAgent.getAccount()))
/* 655 */       return "reject";
/* 656 */     if ((supplyDemandInfo.getStatus().equals(EnumInfoStatus.OVERDUE.getValue())) || (supplyDemandInfo.getStatus().equals(EnumInfoStatus.DELETED.getValue())))
/*     */     {
/* 658 */       return "overdue";
/*     */     }
/* 660 */     return "success";
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_U_INFO_ACCUSE})
/*     */   @RequestMapping(value={"home/supplydemand/accuse"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String accuse(@ModelAttribute("accuseInfo") AccuseInfo accuseInfo, @RequestParam(value="infoId", required=false) long infoId, @RequestParam(value="accuser", required=false) String accuser, ModelMap model)
/*     */   {
/* 674 */     initeRegPage(model);
/* 675 */     accuseInfo.setInfoId(infoId);
/* 676 */     accuseInfo.setAccuser(accuser);
/* 677 */     return "home/supplydemand/accuse";
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_U_INFO_ACCUSE})
/*     */   @RequestMapping(value={"home/supplydemand/accuse"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String accuseInfo(@ModelAttribute("accuseInfo") AccuseInfo accuseInfo, @RequestParam(value="infoId", required=false) long infoId, @RequestParam(value="accuser", required=false) String accuser, ModelMap model)
/*     */   {
/* 690 */     String result = this.supplyDemandInfoService.accuseType(accuseInfo, infoId, accuser);
/* 691 */     if ("success".equals(result)) {
/* 692 */       return "/home/supplydemand/success";
/*     */     }
/* 694 */     return "/home/supplydemand/error";
/*     */   }
/*     */ 
/*     */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_R_INFO_DETAIL})
/*     */   @RequestMapping({"supplydemand/detailInfo"})
/*     */   public String doShowPerSupplyDemand(@RequestParam(value="projectCode", required=true) String projectCode, UserAgent userAgent, ModelMap model)
/*     */   {
/* 706 */     SupplyDemandInfo supplyDemandInfo = null;
/* 707 */     if (!StringUtil.isEmpty(projectCode))
/* 708 */       supplyDemandInfo = this.supplyDemandInfoService.getSupplyDemandByCode(projectCode);
/*     */     else {
/* 710 */       return error(model, "parameter.error.null", new String[0]);
/*     */     }
/* 712 */     if (!supplyDemandInfo.getPublisherAccount().equals(userAgent.getAccount())) {
/* 713 */       return "403";
/*     */     }
/* 715 */     model.addAttribute("supplyDemandInfo", supplyDemandInfo);
/* 716 */     return "supplydemand/detailInfo";
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.web.action.supplydemand.SupplyDemandInfoAction
 * JD-Core Version:    0.6.0
 */