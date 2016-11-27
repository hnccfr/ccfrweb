/*      */ package com.hundsun.network.gates.fengshan.web.action.project;
/*      */ 
/*      */ import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectListing;
/*      */ import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectMetas;
/*      */ import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectMetasBO;
/*      */ import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectTradeBO;
/*      */ import com.hundsun.network.gates.fengshan.biz.domain.query.ProjectListingQuery;
/*      */ import com.hundsun.network.gates.fengshan.biz.service.common.AreaService;
/*      */ import com.hundsun.network.gates.fengshan.biz.service.common.UploadService;
/*      */ import com.hundsun.network.gates.fengshan.biz.service.financing.FinancingService;
/*      */ import com.hundsun.network.gates.fengshan.biz.service.order.TradeOrderService;
/*      */ import com.hundsun.network.gates.fengshan.biz.service.project.ProjectListingService;
/*      */ import com.hundsun.network.gates.fengshan.biz.service.project.ProjectMetasService;
/*      */ import com.hundsun.network.gates.fengshan.biz.service.project.ProjectStandardService;
/*      */ import com.hundsun.network.gates.fengshan.biz.service.project.ProjectTypeService;
/*      */ import com.hundsun.network.gates.fengshan.biz.service.project.TradeSubstationService;
/*      */ import com.hundsun.network.gates.fengshan.web.action.BaseAction;
/*      */ import com.hundsun.network.gates.fengshan.web.util.CustomDateTimeEditor;
/*      */ import com.hundsun.network.gates.fengshan.web.util.ProjectCopyUtil;
/*      */ import com.hundsun.network.gates.fengshan.web.util.RandomString;
/*      */ import com.hundsun.network.gates.fengshan.web.util.TradeMoneyUtil;
/*      */ import com.hundsun.network.gates.fengshan.web.validator.common.UserValidator;
/*      */ import com.hundsun.network.gates.fengshan.web.validator.project.ProEditValidator;
/*      */ import com.hundsun.network.gates.luosi.biz.domain.UserAgent;
/*      */ import com.hundsun.network.gates.luosi.biz.security.ServiceException;
/*      */ import com.hundsun.network.gates.luosi.biz.security.SystemAccess;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumBidOrderProperty;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumDeliveryType;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumListingType;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumMeasureUnit;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumMetaGroup;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumMulitBidOrderProperty;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumOperatorType;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumPaymentType;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumProjectStatus;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumTradingType;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumValuationUnit;
/*      */ import com.hundsun.network.gates.luosi.common.remote.AjaxResult;
/*      */ import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
/*      */ import com.hundsun.network.gates.luosi.common.utils.CommonUtils;
/*      */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.ProjectListingDTO;
/*      */ import com.hundsun.network.gates.luosi.wulin.reomte.result.ProjectListingServiceResult;
/*      */ import com.hundsun.network.melody.common.util.StringUtil;
/*      */ import java.io.IOException;
/*      */ import java.math.BigDecimal;
/*      */ import java.text.DateFormat;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Date;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import org.apache.commons.lang.StringUtils;
/*      */ import org.apache.commons.logging.Log;
/*      */ import org.codehaus.jackson.JsonGenerationException;
/*      */ import org.codehaus.jackson.map.JsonMappingException;
/*      */ import org.codehaus.jackson.map.ObjectMapper;
/*      */ import org.springframework.beans.factory.annotation.Autowired;
/*      */ import org.springframework.stereotype.Controller;
/*      */ import org.springframework.ui.Model;
/*      */ import org.springframework.ui.ModelMap;
/*      */ import org.springframework.validation.BindingResult;
/*      */ import org.springframework.web.bind.WebDataBinder;
/*      */ import org.springframework.web.bind.annotation.ModelAttribute;
/*      */ import org.springframework.web.bind.annotation.RequestMapping;
/*      */ import org.springframework.web.bind.annotation.RequestParam;
/*      */ import org.springframework.web.bind.annotation.ResponseBody;
/*      */ import org.springframework.web.multipart.MultipartFile;
/*      */ 
/*      */ @Controller
/*      */ public class ProjectListingAction extends BaseAction
/*      */ {
/*      */ 
/*      */   @Autowired
/*      */   private ProjectListingService projectListingService;
/*      */ 
/*      */   @Autowired
/*      */   private ProjectStandardService projectStandardService;
/*      */ 
/*      */   @Autowired
/*      */   private ProEditValidator proEditValidator;
/*      */ 
/*      */   @Autowired
/*      */   private TradeOrderService tradeOrderService;
/*      */ 
/*      */   @Autowired
/*      */   private UserValidator userValidator;
/*      */ 
/*      */   @Autowired
/*      */   private ProjectTypeService projectTypeService;
/*      */ 
/*      */   @Autowired
/*      */   private UploadService uploadService;
/*      */ 
/*      */   @Autowired
/*      */   private TradeSubstationService tradeSubstationService;
/*      */ 
/*      */   @Autowired
/*      */   private FinancingService financingService;
/*      */ 
/*      */   @Autowired
/*      */   private AreaService areaService;
/*      */ 
/*      */   @Autowired
/*      */   private ProjectMetasService projectMetasService;
/*      */ 
/*      */   protected void registerDefaultCustomDateEditor(WebDataBinder binder)
/*      */   {
/*  116 */     DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
/*  117 */     DateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*  118 */     dateFormat.setLenient(false);
/*  119 */     binder.registerCustomEditor(Date.class, 
/*  120 */       new CustomDateTimeEditor(dateFormat, timeFormat, true));
/*      */   }
/*      */ 
/*      */   private void prepareListingType(ModelMap model)
/*      */   {
/*  130 */     model.addAttribute("listingTypes", EnumListingType.values());
/*      */ 
/*  132 */     EnumTradingType[] tradingTypes = { 
/*  133 */       EnumTradingType.BID_ORDER, 
/*  134 */       EnumTradingType.TRANSFER_ORDER, 
/*  135 */       EnumTradingType.TENDER_ORDER, 
/*  136 */       EnumTradingType.PLACE_ORDER };
/*      */ 
/*  138 */     model.addAttribute("tradingTypes", tradingTypes);
/*  139 */     model.addAttribute("measureUnits", EnumMeasureUnit.values());
/*  140 */     model.addAttribute("valuationUnits", EnumValuationUnit.values());
/*  141 */     model.addAttribute("deliveryTypes", EnumDeliveryType.values());
/*  142 */     model.addAttribute("paymentTypes", EnumPaymentType.values());
/*  143 */     List list = this.projectStandardService.selectStandardList();
/*  144 */     model.addAttribute("queyList", list);
/*  145 */     List substations = this.tradeSubstationService.selectAllSubstationList();
/*  146 */     model.addAttribute("substations", substations);
/*      */   }
/*      */ 
/*      */   @RequestMapping({"home/list"})
/*      */   public void doSearchApprovedProjects(@ModelAttribute("query") ProjectListingQuery query, ModelMap model)
/*      */   {
/*  158 */     if (query == null) {
/*  159 */       query = new ProjectListingQuery();
/*      */     }
/*      */ 
/*  162 */     query.setStatus(EnumProjectStatus.TRADE.getValue());
/*  163 */     query.setSysTimeFlag("Y");
/*  164 */     this.projectListingService.getProjectListingByQuery(query);
/*  165 */     EnumListingType[] listingTypes = EnumListingType.values();
/*      */ 
/*  171 */     for (ProjectListing pro : query.getData()) {
/*  172 */       String forestryQuantityDes = "";
/*  173 */       ProjectMetas projectMetas = new ProjectMetas();
/*  174 */       projectMetas.setProjectId(pro.getId());
/*  175 */       projectMetas.setMetaKey("AREA");
/*  176 */       String mushu = this.projectMetasService.getMetaValue(projectMetas);
/*  177 */       projectMetas.setMetaKey("AREA_UNIT");
/*  178 */       String mu = this.projectMetasService.getMetaValue(projectMetas);
/*  179 */       if ((StringUtil.isNotBlank(mushu)) && (StringUtil.isNotBlank(mu))) {
/*  180 */         forestryQuantityDes = mushu + mu;
/*      */       }
/*  182 */       pro.setForestryQuantityDes(forestryQuantityDes);
/*      */     }
/*      */ 
/*  185 */     model.addAttribute("query", query);
/*  186 */     model.addAttribute("listingTypes", listingTypes);
/*      */   }
/*      */ 
/*      */   @RequestMapping({"home/detail"})
/*      */   public String doShowApprovedProjectsDetail(@RequestParam(value="id", required=false) Long id, @RequestParam(value="projectCode", required=false) String projectCode, ModelMap model)
/*      */   {
/*  200 */     ProjectListing projectListing = null;
/*  201 */     if ((id != null) && (!id.equals("")))
/*  202 */       projectListing = this.projectListingService.getProjectListingById(id);
/*  203 */     else if ((projectCode != null) && (!projectCode.equals("")))
/*  204 */       projectListing = this.projectListingService.getProjectListingByCode(projectCode);
/*      */     else {
/*  206 */       return error(model, "parameter.error.null", new String[0]);
/*      */     }
/*  208 */     if ((projectListing.getCode() == null) || ("".equals(projectListing.getCode()))) {
/*  209 */       model.addAttribute("message", "您无权查看该挂牌项目的信息。");
/*  210 */       return "error";
/*      */     }
/*  212 */     TradeMoneyUtil.conver2ValueUnit(projectListing);
/*  213 */     HashMap map = new HashMap();
/*  214 */     map.put(EnumBidOrderProperty.RESERVE_PRICE.getKey(), "hiddenMetas");
/*  215 */     map.put(EnumBidOrderProperty.WATCH_PASSWORD.getKey(), "hiddenMetas");
/*  216 */     map.put(EnumBidOrderProperty.AUCTIONEER_ACCOUNT.getKey(), "hiddenMetas");
/*  217 */     map.put(EnumMulitBidOrderProperty.REVIEWER_ACCOUNT.getKey(), "hiddenMetas");
/*  218 */     ProjectCopyUtil.hiddenTradeMetas(projectListing, map);
/*  219 */     model.addAttribute("projectListing", projectListing);
/*  220 */     projectListing.setArea(this.areaService.getAreaFullName(projectListing.getArea()));
/*  221 */     return "home/detail";
/*      */   }
/*      */ 
/*      */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_R_PROJECT_INDEX})
/*      */   @RequestMapping(value={"project/index"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*      */   public void goProjectIndex(Model model)
/*      */   {
/*      */   }
/*      */ 
/*      */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_C_PROJECT_SELLER_ADD_PROJECT})
/*      */   @RequestMapping(value={"project/seller/add"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*      */   public void goSellProjectAdd(@ModelAttribute("projectListing") ProjectListing projectListing, ModelMap model)
/*      */   {
/*  244 */     prepareListingType(model);
/*  245 */     ProjectMetasBO metesBo = new ProjectMetasBO();
/*  246 */     ProjectTradeBO tradeBo = new ProjectTradeBO();
/*  247 */     model.addAttribute("metesBo", metesBo);
/*  248 */     model.addAttribute("tradeBo", tradeBo);
/*  249 */     List list = this.projectStandardService.selectStandardList();
/*      */ 
/*  262 */     model.addAttribute("queyList", list);
/*      */   }
/*      */ 
/*      */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_C_PROJECT_BUYER_ADD_PROJECT})
/*      */   @RequestMapping(value={"project/buyer/add"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*      */   public void goBuyProjectAdd(@ModelAttribute("projectListing") ProjectListing projectListing, UserAgent userAgent, ModelMap model)
/*      */   {
/*  274 */     prepareListingType(model);
/*  275 */     ProjectMetasBO metesBo = new ProjectMetasBO();
/*  276 */     ProjectTradeBO tradeBo = new ProjectTradeBO();
/*  277 */     model.addAttribute("metesBo", metesBo);
/*  278 */     model.addAttribute("tradeBo", tradeBo);
/*  279 */     List list = this.projectStandardService.selectStandardList();
/*      */ 
/*  291 */     model.addAttribute("queyList", list);
/*      */   }
/*      */ 
/*      */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_C_PROJECT_SELLER_ADD_PROJECT})
/*      */   @RequestMapping(value={"project/seller/add"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*      */   public String doSellerAddProject(@ModelAttribute("metesBo") ProjectMetasBO metesBo, @ModelAttribute("tradeBo") ProjectTradeBO tradeBo, @ModelAttribute("projectListing") ProjectListing projectListing, BindingResult valiResult, @RequestParam("uploadFile0") MultipartFile uploadFile0, @RequestParam("uploadFile1") MultipartFile uploadFile1, @RequestParam("uploadFile2") MultipartFile uploadFile2, @RequestParam("uploadFile3") MultipartFile uploadFile3, @RequestParam("uploadFile4") MultipartFile uploadFile4, @RequestParam("attachedFile") MultipartFile attachedFile, UserAgent userAgent, ModelMap model)
/*      */   {
/*  316 */     ServiceResult result = this.userValidator.isPermission(userAgent);
/*  317 */     if (!result.correct()) {
/*  318 */       model.put("message", result.getErrorInfo());
/*  319 */       return "error";
/*      */     }
/*  321 */     Map metaErrors = new HashMap();
/*  322 */     Map metaSubmitValue = new HashMap();
/*      */ 
/*  324 */     this.proEditValidator.validate(projectListing, valiResult);
/*  325 */     this.proEditValidator.validateFile(uploadFile0, metaErrors);
/*  326 */     this.proEditValidator.validateFile(uploadFile1, metaErrors);
/*  327 */     this.proEditValidator.validateFile(uploadFile2, metaErrors);
/*  328 */     this.proEditValidator.validateFile(uploadFile3, metaErrors);
/*  329 */     this.proEditValidator.validateFile(uploadFile4, metaErrors);
/*  330 */     this.proEditValidator.validateAttachedFile(attachedFile, metaErrors);
/*      */ 
/*  332 */     List projectTypeAttriList = this.projectTypeService
/*  333 */       .queryProjectTypeAttri(projectListing.getProjectTypeCode());
/*      */ 
/*  335 */     this.proEditValidator.dynamicValidate(projectListing, metaErrors, projectTypeAttriList);
/*  336 */     if (EnumTradingType.PLACE_ORDER.getValue().equals(projectListing.getTradingType())) {
/*  337 */       List ignoreList = new ArrayList();
/*  338 */       this.proEditValidator.placeOrderVadate(projectListing, tradeBo, metaErrors, ignoreList);
/*  339 */     } else if (EnumTradingType.BID_ORDER.getValue().equals(projectListing.getTradingType())) {
/*  340 */       List ignoreList = new ArrayList();
/*  341 */       ignoreList.add(EnumBidOrderProperty.AUCTIONEER_ACCOUNT.getKey());
/*  342 */       ignoreList.add(EnumBidOrderProperty.WATCH_PASSWORD.getKey());
/*  343 */       this.proEditValidator.bidOrderVadate(projectListing, tradeBo, metaErrors, ignoreList);
/*  344 */     } else if (EnumTradingType.TRANSFER_ORDER.getValue().equals(projectListing.getTradingType())) {
/*  345 */       List ignoreList = new ArrayList();
/*  346 */       this.proEditValidator.transferOrderVadate(projectListing, tradeBo, metaErrors, ignoreList);
/*  347 */     } else if (EnumTradingType.TENDER_ORDER.getValue().equals(projectListing.getTradingType())) {
/*  348 */       List ignoreList = new ArrayList();
/*  349 */       this.proEditValidator.tenderOrderVadate(projectListing, tradeBo, metaErrors, ignoreList);
/*      */     }
/*      */ 
/*  352 */     ProjectCopyUtil.copyTradeMetasList2Map(tradeBo.getTradeMetas(), metaSubmitValue);
/*  353 */     ProjectCopyUtil.copyProjectMetasList2Map(projectListing.getMetaValues(), metaSubmitValue);
/*      */ 
/*  356 */     ObjectMapper mapper = new ObjectMapper();
/*  357 */     String tradeMetaError = "";
/*  358 */     String metaSubmitValueStr = "";
/*      */     try {
/*  360 */       tradeMetaError = mapper.writeValueAsString(metaErrors);
/*  361 */       metaSubmitValueStr = mapper.writeValueAsString(metaSubmitValue);
/*      */     } catch (JsonGenerationException e) {
/*  363 */       this.log.error("", e);
/*      */     } catch (JsonMappingException e) {
/*  365 */       this.log.error("", e);
/*      */     } catch (IOException e) {
/*  367 */       this.log.error("", e);
/*      */     }
/*      */ 
/*  370 */     if ((valiResult.hasErrors()) || (!metaErrors.isEmpty())) {
/*  371 */       model.addAttribute("metaErrors", tradeMetaError);
/*  372 */       prepareListingType(model);
/*  373 */       model.addAttribute("url", "/project/" + projectListing.getListingType() + "er/add.htm");
/*  374 */       model.addAttribute(projectListing);
/*  375 */       model.addAttribute("breedStandards", this.projectStandardService
/*  376 */         .getStandardByProTypeCode(projectListing.getProjectTypeCode()));
/*  377 */       model.addAttribute("curTradeType", projectListing.getTradingType());
/*  378 */       model.addAttribute("metaSubmitValue", metaSubmitValueStr);
/*  379 */       return "project/seller/add";
/*      */     }
/*      */ 
/*  383 */     TradeMoneyUtil.convert2Cent(projectListing, tradeBo);
/*      */     try
/*      */     {
/*  387 */       String picturePath = "";
/*  388 */       String picturePath1 = "";
/*  389 */       String picturePath2 = "";
/*  390 */       String picturePath3 = "";
/*  391 */       String picturePath4 = "";
/*  392 */       if ((uploadFile0 != null) && (uploadFile0.getSize() > 0L)) {
/*  393 */         String imgExg = CommonUtils.getFileSuffix(uploadFile0.getOriginalFilename());
/*  394 */         picturePath = this.uploadService.uploadFile(uploadFile0.getInputStream(), imgExg);
/*  395 */         projectListing.setPicturePath(picturePath);
/*      */       } else {
/*  397 */         projectListing.setPicturePath(null);
/*      */       }
/*  399 */       if ((uploadFile1 != null) && (uploadFile1.getSize() > 0L)) {
/*  400 */         String imgExg = CommonUtils.getFileSuffix(uploadFile1.getOriginalFilename());
/*  401 */         picturePath1 = this.uploadService.uploadFile(uploadFile1.getInputStream(), imgExg);
/*  402 */         projectListing.setPicturePath1(picturePath1);
/*      */       } else {
/*  404 */         projectListing.setPicturePath1(null);
/*      */       }
/*  406 */       if ((uploadFile2 != null) && (uploadFile2.getSize() > 0L)) {
/*  407 */         String imgExg = CommonUtils.getFileSuffix(uploadFile2.getOriginalFilename());
/*  408 */         picturePath2 = this.uploadService.uploadFile(uploadFile2.getInputStream(), imgExg);
/*  409 */         projectListing.setPicturePath2(picturePath2);
/*      */       } else {
/*  411 */         projectListing.setPicturePath2(null);
/*      */       }
/*  413 */       if ((uploadFile3 != null) && (uploadFile3.getSize() > 0L)) {
/*  414 */         String imgExg = CommonUtils.getFileSuffix(uploadFile3.getOriginalFilename());
/*  415 */         picturePath3 = this.uploadService.uploadFile(uploadFile3.getInputStream(), imgExg);
/*  416 */         projectListing.setPicturePath3(picturePath3);
/*      */       } else {
/*  418 */         projectListing.setPicturePath3(null);
/*      */       }
/*  420 */       if ((uploadFile4 != null) && (uploadFile4.getSize() > 0L)) {
/*  421 */         String imgExg = CommonUtils.getFileSuffix(uploadFile4.getOriginalFilename());
/*  422 */         picturePath4 = this.uploadService.uploadFile(uploadFile4.getInputStream(), imgExg);
/*  423 */         projectListing.setPicturePath4(picturePath4);
/*      */       } else {
/*  425 */         projectListing.setPicturePath4(null);
/*      */       }
/*  427 */       if ((attachedFile != null) && (attachedFile.getSize() > 0L)) {
/*  428 */         String fileExg = CommonUtils.getFileSuffix(attachedFile.getOriginalFilename());
/*  429 */         projectListing.setAttachedFilePath(this.uploadService.uploadFile(attachedFile.getInputStream(), fileExg));
/*      */       } else {
/*  431 */         projectListing.setAttachedFilePath(null);
/*      */       }
/*      */     } catch (IOException e) {
/*  434 */       this.log.error("", e);
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  441 */       if ((projectListing.getTradingType() != null) && 
/*  442 */         (projectListing.getTradingType().equals(EnumTradingType.PLACE_ORDER.getValue()))) {
/*  443 */         if ((tradeBo != null) && (tradeBo.getTradeMetas() != null) && 
/*  444 */           (tradeBo.getTradeMetas().size() > 0))
/*  445 */           projectListing = ProjectCopyUtil.copyTradeShowDTOList2ProjectListing(tradeBo
/*  446 */             .getTradeMetas(), projectListing);
/*      */       } else {
/*  448 */         ProjectCopyUtil.copyProjectTradeBO2ProjectMetasBO(tradeBo, metesBo);
/*      */ 
/*  451 */         metesBo.getMetaValues().add(
/*  452 */           getWatchPassword(((ProjectMetas)metesBo.getMetaValues().get(0)).getProjectId(), 
/*  453 */           ((ProjectMetas)metesBo
/*  453 */           .getMetaValues().get(0)).getGmtCreate(), ((ProjectMetas)metesBo.getMetaValues().get(0))
/*  454 */           .getGmtModify(), ((ProjectMetas)metesBo.getMetaValues().get(0)).getOperator()));
/*  455 */         if (projectListing.getTradingType().equals(
/*  456 */           EnumTradingType.MULIT_BID_ORDER.getValue()))
/*  457 */           metesBo.getMetaValues().add(
/*  458 */             setReviewerAccount(((ProjectMetas)metesBo.getMetaValues().get(0)).getProjectId(), 
/*  459 */             ((ProjectMetas)metesBo
/*  459 */             .getMetaValues().get(0)).getGmtCreate(), ((ProjectMetas)metesBo.getMetaValues().get(0))
/*  460 */             .getGmtModify(), userAgent.getAccount(), ((ProjectMetas)metesBo.getMetaValues().get(0))
/*  461 */             .getOperator()));
/*      */       }
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  466 */       model.addAttribute("metesBo", metesBo);
/*  467 */       model.addAttribute("tradeBo", tradeBo);
/*  468 */       this.log.error("将动态交易属性转换为项目主表出错！", e);
/*  469 */       model.addAttribute("message", "将动态交易属性转换为项目主表出错");
/*  470 */       return "/error";
/*      */     }
/*      */ 
/*  473 */     projectListing.setListingType(EnumListingType.SELL.getValue());
/*  474 */     projectListing.setUserId(userAgent.getAccountId());
/*  475 */     projectListing.setUserAccount(userAgent.getAccount());
/*  476 */     projectListing.setCreator(userAgent.getAccount());
/*  477 */     projectListing.setOperator(userAgent.getAccount());
/*  478 */     BigDecimal bg = new BigDecimal(projectListing.getListingPriceDesc());
/*  479 */     Long p = 
/*  481 */       Long.valueOf(bg.movePointRight(
/*  480 */       EnumValuationUnit.indexByValue(projectListing.getValuationUnit()).getScale())
/*  481 */       .longValue());
/*  482 */     projectListing.setListingPrice(p);
/*  483 */     projectListing.setFundAccount(userAgent.getFundAccount());
/*  484 */     projectListing.setStatus(EnumProjectStatus.CREATE.getValue());
/*  485 */     projectListing.setCreatorType(EnumOperatorType.USER.getValue());
/*  486 */     projectListing.setGmtCreate(new Date());
/*  487 */     projectListing.setGmtModify(new Date());
/*      */ 
/*  489 */     ProjectListingServiceResult addResult = this.projectListingService.addProjectListing(
/*  490 */       projectListing, metesBo);
/*  491 */     if (addResult.correct()) {
/*  492 */       Long projectId = addResult.getProjectListingDTO().getId();
/*  493 */       return redirect("/project/addSuccess.htm?id=" + projectId);
/*      */     }
/*  495 */     this.log.debug(addResult.getErrorInfo());
/*  496 */     model.addAttribute("message", addResult.getErrorInfo());
/*  497 */     return "/error";
/*      */   }
/*      */ 
/*      */   private ProjectMetas getWatchPassword(Long projectId, Date gmtCreate, Date gmtModify, String operator)
/*      */   {
/*  507 */     RandomString rds = new RandomString();
/*  508 */     ProjectMetas metas = new ProjectMetas();
/*  509 */     metas.setProjectId(projectId);
/*  510 */     metas.setGmtCreate(gmtCreate);
/*  511 */     metas.setGmtModify(gmtModify);
/*  512 */     metas.setOperator(operator);
/*  513 */     metas.setInputType(EnumBidOrderProperty.WATCH_PASSWORD.getShowType());
/*  514 */     metas.setMetaGroup(EnumMetaGroup.TRADINGTYPE.getValue());
/*  515 */     metas.setMetaKey(EnumBidOrderProperty.WATCH_PASSWORD.getKey());
/*  516 */     metas.setMetaTitle(EnumBidOrderProperty.WATCH_PASSWORD.getName());
/*  517 */     metas.setMetaValue(rds.getRandomString(16, "ilu"));
/*  518 */     return metas;
/*      */   }
/*      */ 
/*      */   private ProjectMetas setReviewerAccount(Long projectId, Date gmtCreate, Date gmtModify, String userAccount, String operator)
/*      */   {
/*  535 */     ProjectMetas metas = new ProjectMetas();
/*  536 */     metas.setProjectId(projectId);
/*  537 */     metas.setGmtCreate(gmtCreate);
/*  538 */     metas.setGmtModify(gmtModify);
/*  539 */     metas.setOperator(operator);
/*  540 */     metas.setMetaKey(EnumMulitBidOrderProperty.REVIEWER_ACCOUNT.getKey());
/*  541 */     metas.setMetaValue(userAccount);
/*  542 */     metas.setMetaTitle(EnumMulitBidOrderProperty.REVIEWER_ACCOUNT.getName());
/*  543 */     metas.setMetaGroup(EnumMetaGroup.TRADINGTYPE.getValue());
/*  544 */     metas.setInputType(EnumMulitBidOrderProperty.REVIEWER_ACCOUNT.getShowType());
/*  545 */     return metas;
/*      */   }
/*      */ 
/*      */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_C_PROJECT_BUYER_ADD_PROJECT})
/*      */   @RequestMapping(value={"project/buyer/add"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*      */   public String doBuyerAddProject(@ModelAttribute("bo") ProjectMetasBO metesBo, @ModelAttribute("tradeBo") ProjectTradeBO tradeBo, @ModelAttribute("projectListing") ProjectListing projectListing, BindingResult valiResult, @RequestParam("uploadFile0") MultipartFile file0, @RequestParam("uploadFile1") MultipartFile file1, @RequestParam("uploadFile2") MultipartFile file2, @RequestParam("uploadFile3") MultipartFile file3, @RequestParam("uploadFile4") MultipartFile file4, @RequestParam("attachedFile") MultipartFile attachedFile, UserAgent userAgent, ModelMap model)
/*      */   {
/*  569 */     ServiceResult result = this.userValidator.isPermission(userAgent);
/*  570 */     if (!result.correct()) {
/*  571 */       model.put("message", result.getErrorInfo());
/*  572 */       return "error";
/*      */     }
/*  574 */     Map metaErrors = new HashMap();
/*  575 */     Map metaSubmitValue = new HashMap();
/*      */ 
/*  577 */     this.proEditValidator.validate(projectListing, valiResult);
/*  578 */     this.proEditValidator.validateFile(file0, metaErrors);
/*  579 */     this.proEditValidator.validateFile(file1, metaErrors);
/*  580 */     this.proEditValidator.validateFile(file2, metaErrors);
/*  581 */     this.proEditValidator.validateFile(file3, metaErrors);
/*  582 */     this.proEditValidator.validateFile(file4, metaErrors);
/*      */ 
/*  584 */     List projectTypeAttriList = this.projectTypeService
/*  585 */       .queryProjectTypeAttri(projectListing.getProjectTypeCode());
/*      */ 
/*  587 */     this.proEditValidator.dynamicValidate(projectListing, metaErrors, projectTypeAttriList);
/*  588 */     if (EnumTradingType.PLACE_ORDER.getValue().equals(projectListing.getTradingType())) {
/*  589 */       List ignoreList = new ArrayList();
/*  590 */       this.proEditValidator.placeOrderVadate(projectListing, tradeBo, metaErrors, ignoreList);
/*  591 */     } else if (EnumTradingType.BID_ORDER.getValue().equals(projectListing.getTradingType())) {
/*  592 */       List ignoreList = new ArrayList();
/*  593 */       ignoreList.add(EnumBidOrderProperty.AUCTIONEER_ACCOUNT.getKey());
/*  594 */       ignoreList.add(EnumBidOrderProperty.WATCH_PASSWORD.getKey());
/*  595 */       this.proEditValidator.bidOrderVadate(projectListing, tradeBo, metaErrors, ignoreList);
/*  596 */     } else if (EnumTradingType.TRANSFER_ORDER.getValue().equals(projectListing.getTradingType())) {
/*  597 */       List ignoreList = new ArrayList();
/*  598 */       this.proEditValidator.transferOrderVadate(projectListing, tradeBo, metaErrors, ignoreList);
/*  599 */     } else if (EnumTradingType.TENDER_ORDER.getValue().equals(projectListing.getTradingType())) {
/*  600 */       List ignoreList = new ArrayList();
/*  601 */       this.proEditValidator.tenderOrderVadate(projectListing, tradeBo, metaErrors, ignoreList);
/*      */     }
/*      */ 
/*  604 */     ProjectCopyUtil.copyTradeMetasList2Map(tradeBo.getTradeMetas(), metaSubmitValue);
/*  605 */     ProjectCopyUtil.copyProjectMetasList2Map(projectListing.getMetaValues(), metaSubmitValue);
/*      */ 
/*  608 */     ObjectMapper mapper = new ObjectMapper();
/*  609 */     String tradeMetaError = "";
/*  610 */     String metaSubmitValueStr = "";
/*      */     try {
/*  612 */       tradeMetaError = mapper.writeValueAsString(metaErrors);
/*  613 */       metaSubmitValueStr = mapper.writeValueAsString(metaSubmitValue);
/*      */     } catch (JsonGenerationException e) {
/*  615 */       this.log.error("", e);
/*      */     } catch (JsonMappingException e) {
/*  617 */       this.log.error("", e);
/*      */     } catch (IOException e) {
/*  619 */       this.log.error("", e);
/*      */     }
/*  621 */     if ((valiResult.hasErrors()) || (!metaErrors.isEmpty())) {
/*  622 */       model.addAttribute("metaErrors", tradeMetaError);
/*  623 */       prepareListingType(model);
/*  624 */       model.addAttribute("url", "/project/" + projectListing.getListingType() + "er/add.htm");
/*  625 */       model.addAttribute(projectListing);
/*  626 */       model.addAttribute("breedStandards", this.projectStandardService
/*  627 */         .getStandardByProTypeCode(projectListing.getProjectTypeCode()));
/*  628 */       model.addAttribute("curTradeType", projectListing.getTradingType());
/*  629 */       model.addAttribute("metaSubmitValue", metaSubmitValueStr);
/*  630 */       return "project/buyer/add";
/*      */     }
/*      */ 
/*  634 */     TradeMoneyUtil.convert2Cent(projectListing, tradeBo);
/*      */     try
/*      */     {
/*  639 */       String picturePath = "";
/*  640 */       String picturePath1 = "";
/*  641 */       String picturePath2 = "";
/*  642 */       String picturePath3 = "";
/*  643 */       String picturePath4 = "";
/*  644 */       if ((file0 != null) && (file0.getSize() > 0L)) {
/*  645 */         String imgExg = CommonUtils.getFileSuffix(file0.getOriginalFilename());
/*  646 */         picturePath = this.uploadService.uploadFile(file0.getInputStream(), imgExg);
/*  647 */         projectListing.setPicturePath(picturePath);
/*      */       } else {
/*  649 */         projectListing.setPicturePath(null);
/*      */       }
/*  651 */       if ((file1 != null) && (file1.getSize() > 0L)) {
/*  652 */         String imgExg = CommonUtils.getFileSuffix(file1.getOriginalFilename());
/*  653 */         picturePath1 = this.uploadService.uploadFile(file1.getInputStream(), imgExg);
/*  654 */         projectListing.setPicturePath1(picturePath1);
/*      */       } else {
/*  656 */         projectListing.setPicturePath1(null);
/*      */       }
/*  658 */       if ((file2 != null) && (file2.getSize() > 0L)) {
/*  659 */         String imgExg = CommonUtils.getFileSuffix(file2.getOriginalFilename());
/*  660 */         picturePath2 = this.uploadService.uploadFile(file2.getInputStream(), imgExg);
/*  661 */         projectListing.setPicturePath2(picturePath2);
/*      */       } else {
/*  663 */         projectListing.setPicturePath2(null);
/*      */       }
/*  665 */       if ((file3 != null) && (file3.getSize() > 0L)) {
/*  666 */         String imgExg = CommonUtils.getFileSuffix(file3.getOriginalFilename());
/*  667 */         picturePath3 = this.uploadService.uploadFile(file3.getInputStream(), imgExg);
/*  668 */         projectListing.setPicturePath3(picturePath3);
/*      */       } else {
/*  670 */         projectListing.setPicturePath3(null);
/*      */       }
/*  672 */       if ((file4 != null) && (file4.getSize() > 0L)) {
/*  673 */         String imgExg = CommonUtils.getFileSuffix(file4.getOriginalFilename());
/*  674 */         picturePath4 = this.uploadService.uploadFile(file4.getInputStream(), imgExg);
/*  675 */         projectListing.setPicturePath4(picturePath4);
/*      */       } else {
/*  677 */         projectListing.setPicturePath4(null);
/*      */       }
/*  679 */       if ((attachedFile != null) && (attachedFile.getSize() > 0L)) {
/*  680 */         String fileExg = CommonUtils.getFileSuffix(attachedFile.getOriginalFilename());
/*  681 */         projectListing.setAttachedFilePath(this.uploadService.uploadFile(attachedFile.getInputStream(), fileExg));
/*      */       } else {
/*  683 */         projectListing.setAttachedFilePath(null);
/*      */       }
/*      */     }
/*      */     catch (IOException e) {
/*  687 */       this.log.error("", e);
/*      */     }
/*      */ 
/*      */     try
/*      */     {
/*  693 */       if ((projectListing.getTradingType() != null) && 
/*  694 */         (projectListing.getTradingType().equals(EnumTradingType.PLACE_ORDER.getValue()))) {
/*  695 */         if ((tradeBo != null) && (tradeBo.getTradeMetas() != null) && 
/*  696 */           (tradeBo.getTradeMetas().size() > 0))
/*  697 */           projectListing = ProjectCopyUtil.copyTradeShowDTOList2ProjectListing(tradeBo
/*  698 */             .getTradeMetas(), projectListing);
/*      */       } else {
/*  700 */         ProjectCopyUtil.copyProjectTradeBO2ProjectMetasBO(tradeBo, metesBo);
/*      */ 
/*  703 */         metesBo.getMetaValues().add(
/*  704 */           getWatchPassword(((ProjectMetas)metesBo.getMetaValues().get(0)).getProjectId(), 
/*  705 */           ((ProjectMetas)metesBo
/*  705 */           .getMetaValues().get(0)).getGmtCreate(), ((ProjectMetas)metesBo.getMetaValues().get(0))
/*  706 */           .getGmtModify(), ((ProjectMetas)metesBo.getMetaValues().get(0)).getOperator()));
/*  707 */         if (projectListing.getTradingType().equals(
/*  708 */           EnumTradingType.MULIT_BID_ORDER.getValue()))
/*  709 */           metesBo.getMetaValues().add(
/*  710 */             setReviewerAccount(((ProjectMetas)metesBo.getMetaValues().get(0)).getProjectId(), 
/*  711 */             ((ProjectMetas)metesBo
/*  711 */             .getMetaValues().get(0)).getGmtCreate(), ((ProjectMetas)metesBo.getMetaValues().get(0))
/*  712 */             .getGmtModify(), userAgent.getAccount(), ((ProjectMetas)metesBo.getMetaValues().get(0))
/*  713 */             .getOperator()));
/*      */       }
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/*  718 */       model.addAttribute("metesBo", metesBo);
/*  719 */       model.addAttribute("tradeBo", tradeBo);
/*  720 */       this.log.error("将动态交易属性转换为项目主表出错！", e);
/*  721 */       model.addAttribute("message", "将动态交易属性转换为项目主表出错");
/*  722 */       return "/error";
/*      */     }
/*      */ 
/*  725 */     projectListing.setListingType(EnumListingType.BUY.getValue());
/*  726 */     projectListing.setUserId(userAgent.getAccountId());
/*  727 */     projectListing.setUserAccount(userAgent.getAccount());
/*  728 */     projectListing.setCreator(userAgent.getAccount());
/*  729 */     projectListing.setOperator(userAgent.getAccount());
/*  730 */     BigDecimal bg = new BigDecimal(projectListing.getListingPriceDesc());
/*  731 */     Long p = 
/*  733 */       Long.valueOf(bg.movePointRight(
/*  732 */       EnumValuationUnit.indexByValue(projectListing.getValuationUnit()).getScale())
/*  733 */       .longValue());
/*  734 */     projectListing.setListingPrice(p);
/*  735 */     projectListing.setFundAccount(userAgent.getFundAccount());
/*  736 */     projectListing.setStatus(EnumProjectStatus.CREATE.getValue());
/*  737 */     projectListing.setCreatorType(EnumOperatorType.USER.getValue());
/*  738 */     projectListing.setGmtCreate(new Date());
/*  739 */     projectListing.setGmtModify(new Date());
/*      */ 
/*  741 */     ProjectListingServiceResult addResult = this.projectListingService.addProjectListing(
/*  742 */       projectListing, metesBo);
/*  743 */     if (addResult.correct()) {
/*  744 */       Long projectId = addResult.getProjectListingDTO().getId();
/*  745 */       return redirect("/project/addSuccess.htm?id=" + projectId);
/*      */     }
/*  747 */     this.log.debug(addResult.getErrorInfo());
/*  748 */     model.addAttribute("message", addResult.getErrorInfo());
/*  749 */     return "/error";
/*      */   }
/*      */ 
/*      */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_R_PROJECT_SELLER_EDIT_PROJECT})
/*      */   @RequestMapping(value={"project/seller/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*      */   public String goSellerProjectEdit(@RequestParam(value="proId", required=true) Long proId, UserAgent userAgent, ModelMap model)
/*      */   {
/*  764 */     ProjectListing projectListing = this.projectListingService.getProjectListingById(proId);
/*  765 */     if (!projectListing.getUserAccount().equals(userAgent.getAccount())) {
/*  766 */       model.addAttribute("message", "无权限");
/*  767 */       return "/error";
/*      */     }
/*  769 */     model.addAttribute("projectListing", projectListing);
/*  770 */     prepareListingType(model);
/*  771 */     model.addAttribute("url", "/project/" + projectListing.getListingType() + "er/list.htm");
/*  772 */     return "/project/seller/edit";
/*      */   }
/*      */ 
/*      */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_U_PROJECT_SELLER_EDIT_PROJECT})
/*      */   @RequestMapping(value={"project/seller/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*      */   public String doProjectEdit(@ModelAttribute("projectListing") ProjectListing projectListing, BindingResult valiResult, @ModelAttribute("metesBo") ProjectMetasBO metesBo, @ModelAttribute("tradeBo") ProjectTradeBO tradeBo, @RequestParam("uploadFile0") MultipartFile file0, @RequestParam("uploadFile1") MultipartFile file1, @RequestParam("uploadFile2") MultipartFile file2, @RequestParam("uploadFile3") MultipartFile file3, @RequestParam("uploadFile4") MultipartFile file4, @RequestParam("attachedFile") MultipartFile attachedFile, UserAgent userAgent, ModelMap model)
/*      */   {
/*  795 */     ServiceResult result = this.userValidator.isPermission(userAgent);
/*  796 */     if (!result.correct()) {
/*  797 */       model.put("message", result.getErrorInfo());
/*  798 */       return "error";
/*      */     }
/*  800 */     Map metaErrors = new HashMap();
/*  801 */     Map metaSubmitValue = new HashMap();
/*      */ 
/*  803 */     this.proEditValidator.validate(projectListing, valiResult);
/*  804 */     this.proEditValidator.validateFile(file0, metaErrors);
/*  805 */     this.proEditValidator.validateFile(file1, metaErrors);
/*  806 */     this.proEditValidator.validateFile(file2, metaErrors);
/*  807 */     this.proEditValidator.validateFile(file3, metaErrors);
/*  808 */     this.proEditValidator.validateFile(file4, metaErrors);
/*      */ 
/*  810 */     List projectTypeAttriList = this.projectTypeService
/*  811 */       .queryProjectTypeAttri(projectListing.getProjectTypeCode());
/*      */ 
/*  813 */     this.proEditValidator.dynamicValidate(projectListing, metaErrors, projectTypeAttriList);
/*  814 */     if (EnumTradingType.PLACE_ORDER.getValue().equals(projectListing.getTradingType())) {
/*  815 */       List ignoreList = new ArrayList();
/*  816 */       this.proEditValidator.placeOrderVadate(projectListing, tradeBo, metaErrors, ignoreList);
/*  817 */     } else if (EnumTradingType.BID_ORDER.getValue().equals(projectListing.getTradingType())) {
/*  818 */       List ignoreList = new ArrayList();
/*  819 */       ignoreList.add(EnumBidOrderProperty.AUCTIONEER_ACCOUNT.getKey());
/*  820 */       ignoreList.add(EnumBidOrderProperty.WATCH_PASSWORD.getKey());
/*  821 */       this.proEditValidator.bidOrderVadate(projectListing, tradeBo, metaErrors, ignoreList);
/*  822 */     } else if (EnumTradingType.TRANSFER_ORDER.getValue().equals(projectListing.getTradingType())) {
/*  823 */       List ignoreList = new ArrayList();
/*  824 */       this.proEditValidator.transferOrderVadate(projectListing, tradeBo, metaErrors, ignoreList);
/*  825 */     } else if (EnumTradingType.TENDER_ORDER.getValue().equals(projectListing.getTradingType())) {
/*  826 */       List ignoreList = new ArrayList();
/*  827 */       this.proEditValidator.tenderOrderVadate(projectListing, tradeBo, metaErrors, ignoreList);
/*      */     }
/*      */ 
/*  830 */     ProjectCopyUtil.copyTradeMetasList2Map(tradeBo.getTradeMetas(), metaSubmitValue);
/*      */ 
/*  833 */     ObjectMapper mapper = new ObjectMapper();
/*  834 */     String tradeMetaError = "";
/*  835 */     String metaSubmitValueStr = "";
/*      */     try {
/*  837 */       tradeMetaError = mapper.writeValueAsString(metaErrors);
/*  838 */       metaSubmitValueStr = mapper.writeValueAsString(metaSubmitValue);
/*      */     } catch (JsonGenerationException e) {
/*  840 */       this.log.error("", e);
/*      */     } catch (JsonMappingException e) {
/*  842 */       this.log.error("", e);
/*      */     } catch (IOException e) {
/*  844 */       this.log.error("", e);
/*      */     }
/*      */ 
/*  847 */     if ((valiResult.hasErrors()) || (!metaErrors.isEmpty())) {
/*  848 */       model.addAttribute("metaErrors", tradeMetaError);
/*  849 */       prepareListingType(model);
/*  850 */       model.addAttribute("url", "/project/" + projectListing.getListingType() + "er/add.htm");
/*  851 */       model.addAttribute(projectListing);
/*  852 */       model.addAttribute("curTradeType", projectListing.getTradingType());
/*  853 */       model.addAttribute("metaSubmitValue", metaSubmitValueStr);
/*  854 */       return "project/seller/edit";
/*      */     }
/*      */ 
/*  858 */     TradeMoneyUtil.convert2Cent(projectListing, tradeBo);
/*      */     try
/*      */     {
/*  863 */       String picturePath = "";
/*  864 */       String picturePath1 = "";
/*  865 */       String picturePath2 = "";
/*  866 */       String picturePath3 = "";
/*  867 */       String picturePath4 = "";
/*  868 */       if ((file0 != null) && (file0.getSize() > 0L)) {
/*  869 */         if (StringUtils.isNotEmpty(picturePath)) {
/*  870 */           this.uploadService.deleteOriginalFile(picturePath);
/*      */         }
/*  872 */         String imgExg = CommonUtils.getFileSuffix(file0.getOriginalFilename());
/*  873 */         picturePath = this.uploadService.uploadFile(file0.getInputStream(), imgExg);
/*  874 */         projectListing.setPicturePath(picturePath);
/*      */       }
/*  876 */       else if (StringUtils.isEmpty(projectListing.getTempPath())) {
/*  877 */         this.uploadService.deleteOriginalFile(picturePath);
/*  878 */         projectListing.setPicturePath("");
/*      */       }
/*      */ 
/*  881 */       if ((file1 != null) && (file1.getSize() > 0L)) {
/*  882 */         if (StringUtils.isNotEmpty(picturePath1)) {
/*  883 */           this.uploadService.deleteOriginalFile(picturePath1);
/*      */         }
/*  885 */         String imgExg = CommonUtils.getFileSuffix(file1.getOriginalFilename());
/*  886 */         picturePath1 = this.uploadService.uploadFile(file1.getInputStream(), imgExg);
/*  887 */         projectListing.setPicturePath1(picturePath1);
/*      */       }
/*  889 */       else if (StringUtils.isEmpty(projectListing.getTempPath1())) {
/*  890 */         this.uploadService.deleteOriginalFile(picturePath1);
/*  891 */         projectListing.setPicturePath1("");
/*      */       }
/*      */ 
/*  894 */       if ((file2 != null) && (file2.getSize() > 0L)) {
/*  895 */         if (StringUtils.isNotEmpty(picturePath2)) {
/*  896 */           this.uploadService.deleteOriginalFile(picturePath2);
/*      */         }
/*  898 */         String imgExg = CommonUtils.getFileSuffix(file2.getOriginalFilename());
/*  899 */         picturePath2 = this.uploadService.uploadFile(file2.getInputStream(), imgExg);
/*  900 */         projectListing.setPicturePath2(picturePath2);
/*      */       }
/*  902 */       else if (StringUtils.isEmpty(projectListing.getTempPath2())) {
/*  903 */         this.uploadService.deleteOriginalFile(picturePath2);
/*  904 */         projectListing.setPicturePath2("");
/*      */       }
/*      */ 
/*  907 */       if ((file3 != null) && (file3.getSize() > 0L)) {
/*  908 */         if (StringUtils.isNotEmpty(picturePath3)) {
/*  909 */           this.uploadService.deleteOriginalFile(picturePath3);
/*      */         }
/*  911 */         String imgExg = CommonUtils.getFileSuffix(file3.getOriginalFilename());
/*  912 */         picturePath3 = this.uploadService.uploadFile(file3.getInputStream(), imgExg);
/*  913 */         projectListing.setPicturePath3(picturePath3);
/*      */       }
/*  915 */       else if (StringUtils.isEmpty(projectListing.getTempPath3())) {
/*  916 */         this.uploadService.deleteOriginalFile(picturePath3);
/*  917 */         projectListing.setPicturePath3("");
/*      */       }
/*      */ 
/*  920 */       if ((file4 != null) && (file4.getSize() > 0L)) {
/*  921 */         if (StringUtils.isNotEmpty(picturePath4)) {
/*  922 */           this.uploadService.deleteOriginalFile(picturePath4);
/*      */         }
/*  924 */         String imgExg = CommonUtils.getFileSuffix(file4.getOriginalFilename());
/*  925 */         picturePath4 = this.uploadService.uploadFile(file4.getInputStream(), imgExg);
/*  926 */         projectListing.setPicturePath4(picturePath4);
/*      */       }
/*  928 */       else if (StringUtils.isEmpty(projectListing.getTempPath4())) {
/*  929 */         this.uploadService.deleteOriginalFile(picturePath4);
/*  930 */         projectListing.setPicturePath4("");
/*      */       }
/*      */ 
/*  933 */       if ((attachedFile != null) && (attachedFile.getSize() > 0L)) {
/*  934 */         String fileExg = CommonUtils.getFileSuffix(attachedFile.getOriginalFilename());
/*  935 */         projectListing.setAttachedFilePath(this.uploadService.uploadFile(attachedFile.getInputStream(), fileExg));
/*      */       }
/*      */     }
/*      */     catch (IOException e) {
/*  939 */       this.log.error("", e);
/*      */     }
/*      */ 
/*  943 */     projectListing.setOperator(userAgent.getAccount());
/*      */ 
/*  946 */     ProjectListingServiceResult presult = this.projectListingService.updateProjectListing(
/*  947 */       projectListing, tradeBo);
/*      */ 
/*  949 */     if (presult.correct()) {
/*  950 */       model.addAttribute("message", "修改挂牌资料操作 成功！");
/*  951 */       model.addAttribute("url", "/project/" + projectListing.getListingType() + "er/list");
/*      */     } else {
/*  953 */       model.addAttribute("message", "修改挂牌资料 失败 ，错误代码" + presult.getErrorNO() + "，" + 
/*  954 */         presult.getErrorInfo());
/*      */     }
/*  956 */     return result.correct() ? "success" : "error";
/*      */   }
/*      */ 
/*      */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_R_PROJECT_SELLER_LIST})
/*      */   @RequestMapping({"project/seller/list"})
/*      */   public void doSearchMyApprovedSellingProjects(@ModelAttribute("query") ProjectListingQuery query, UserAgent userAgent, ModelMap model)
/*      */   {
/*  972 */     EnumProjectStatus[] pjStatus = EnumProjectStatus.values();
/*  973 */     if (query == null) {
/*  974 */       query = new ProjectListingQuery();
/*      */     }
/*  976 */     query.setUserAccount(userAgent.getAccount());
/*  977 */     query.setListingType(EnumListingType.SELL.getValue());
/*  978 */     this.projectListingService.getProjectListingByQuery(query);
/*  979 */     model.addAttribute("query", query);
/*  980 */     model.addAttribute("pjStatus", pjStatus);
/*      */   }
/*      */ 
/*      */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_R_PROJECT_BUYER_LIST})
/*      */   @RequestMapping({"project/buyer/list"})
/*      */   public void doSearchMyApprovedBuyingProjects(@ModelAttribute("query") ProjectListingQuery query, UserAgent userAgent, ModelMap model)
/*      */   {
/*  995 */     EnumProjectStatus[] pjStatus = EnumProjectStatus.values();
/*  996 */     if (query == null) {
/*  997 */       query = new ProjectListingQuery();
/*      */     }
/*  999 */     query.setUserAccount(userAgent.getAccount());
/* 1000 */     query.setListingType(EnumListingType.BUY.getValue());
/* 1001 */     this.projectListingService.getProjectListingByQuery(query);
/* 1002 */     model.addAttribute("query", query);
/* 1003 */     model.addAttribute("pjStatus", pjStatus);
/*      */   }
/*      */ 
/*      */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_R_PROJECT_DETAIL})
/*      */   @RequestMapping({"project/detail"})
/*      */   public String doShowProjectDetail(@RequestParam(value="id", required=false) Long id, @RequestParam(value="projectCode", required=false) String projectCode, UserAgent userAgent, ModelMap model)
/*      */   {
/* 1020 */     ProjectListing projectListing = null;
/* 1021 */     if ((id != null) && (!id.equals("")))
/* 1022 */       projectListing = this.projectListingService.getProjectListingById(id);
/* 1023 */     else if ((projectCode != null) && (!projectCode.equals("")))
/* 1024 */       projectListing = this.projectListingService.getProjectListingByCode(projectCode);
/*      */     else {
/* 1026 */       return error(model, "parameter.error.null", new String[0]);
/*      */     }
/* 1028 */     if (!userAgent.getAccount().equals(projectListing.getUserAccount())) {
/* 1029 */       model.addAttribute("message", "您无权查看该挂牌项目的信息。");
/* 1030 */       return "error";
/*      */     }
/* 1032 */     TradeMoneyUtil.conver2ValueUnit(projectListing);
/* 1033 */     HashMap map = new HashMap();
/*      */ 
/* 1036 */     ProjectCopyUtil.hiddenTradeMetas(projectListing, map);
/* 1037 */     projectListing.setArea(this.areaService.getAreaFullName(projectListing.getArea()));
/* 1038 */     model.addAttribute("projectListing", projectListing);
/* 1039 */     return "project/detail";
/*      */   }
/*      */ 
/*      */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_D_PROJECT_DELETE})
/*      */   @RequestMapping({"project/delete"})
/*      */   @ResponseBody
/*      */   public String doDeletProjectListing(@RequestParam(value="id", required=true) Long projectListingId, UserAgent userAgent)
/*      */   {
/* 1055 */     if (projectListingId == null) {
/* 1056 */       return "fail";
/*      */     }
/* 1058 */     ProjectListing projectListing = this.projectListingService
/* 1059 */       .getProjectListingById(projectListingId);
/*      */ 
/* 1061 */     if ((projectListing.getUserAccount().equals(userAgent.getAccount())) && 
/* 1062 */       (projectListing.getStatus().equals(EnumProjectStatus.CREATE.getValue())))
/* 1063 */       this.projectListingService.deletProjectListingById(projectListingId);
/*      */     else {
/* 1065 */       return "fail";
/*      */     }
/* 1067 */     return "success";
/*      */   }
/*      */ 
/*      */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_R_PROJECT_MATCHE_LIST})
/*      */   @RequestMapping({"project/match"})
/*      */   public String doMatche(@ModelAttribute("query") ProjectListingQuery query, @RequestParam(value="id", required=true) Long projectListingId, UserAgent userAgent, ModelMap model)
/*      */   {
/* 1083 */     if (projectListingId == null) {
/* 1084 */       return error(model, "parameter.error.null", new String[0]);
/*      */     }
/* 1086 */     query.setId(projectListingId);
/* 1087 */     this.projectListingService.matcheProjectListingByQuery(query);
/* 1088 */     model.addAttribute("query", query);
/* 1089 */     return "project/match";
/*      */   }
/*      */ 
/*      */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_C_PROJECT_SELLER_ADD_PROJECT, com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_C_PROJECT_BUYER_ADD_PROJECT})
/*      */   @RequestMapping(value={"project/addSuccess"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*      */   public String doShowListingProjectSuccessPage(@RequestParam(value="id", required=true) Long projectListingId, ModelMap model)
/*      */   {
/* 1104 */     if (projectListingId != null) {
/* 1105 */       ProjectListing projectListing = this.projectListingService
/* 1106 */         .getProjectListingById(projectListingId);
/*      */ 
/* 1108 */       if ((projectListing.getTradingType().equals(EnumTradingType.PLACE_ORDER.getValue())) && 
/* 1109 */         (projectListing.getBreedStandard() != null) && 
/* 1110 */         (!projectListing.getBreedStandard().equals(""))) {
/* 1111 */         model.addAttribute("matche", "YES");
/*      */       }
/*      */ 
/* 1114 */       String reURL = "/project/" + projectListing.getListingType() + "er/list.htm";
/* 1115 */       model.addAttribute("reURL", reURL);
/* 1116 */       model.addAttribute("projectListingId", projectListingId);
/*      */     }
/*      */     else {
/* 1119 */       return error(model, "parameter.error.null", new String[0]);
/*      */     }
/* 1121 */     return "project/addSuccess";
/*      */   }
/*      */ 
/*      */   @RequestMapping({"cms/list"})
/*      */   public String cmsProjectListingList(ModelMap model)
/*      */   {
/* 1132 */     Integer count = Integer.valueOf(10);
/* 1133 */     Map latestPro = this.projectListingService.selectLatestProjectListing(count);
/* 1134 */     model.put("proListType1", latestPro.get("type1"));
/* 1135 */     model.put("proListType2", latestPro.get("type2"));
/* 1136 */     model.put("proListType3", latestPro.get("type3"));
/* 1137 */     model.put("proListType4", latestPro.get("type4"));
/*      */ 
/* 1139 */     count = Integer.valueOf(6);
/* 1140 */     Map orderList = this.tradeOrderService.selectLatestOrder(count);
/* 1141 */     model.put("orderListType1", orderList.get("type1"));
/* 1142 */     model.put("orderListType2", orderList.get("type2"));
/* 1143 */     model.put("orderListType3", orderList.get("type3"));
/* 1144 */     model.put("orderListType4", orderList.get("type4"));
/*      */ 
/* 1146 */     return "/home/cms/list";
/*      */   }
/*      */ 
/*      */   @RequestMapping({"cms/forestry"})
/*      */   public String cmsForestryProjectListingList(ModelMap model)
/*      */   {
/* 1156 */     Integer count = Integer.valueOf(12);
/* 1157 */     Map latestPro = this.projectListingService.selectLatestProjectListing(count);
/* 1158 */     model.put("proListType3", latestPro.get("type3"));
/* 1159 */     return "/home/cms/forestry";
/*      */   }
/*      */ 
/*      */   @RequestMapping({"cms/order"})
/*      */   public String cmsOrderList(ModelMap model)
/*      */   {
/* 1169 */     Integer count = Integer.valueOf(12);
/* 1170 */     Map orderList = this.tradeOrderService.selectLatestOrder(count);
/* 1171 */     model.put("orderListType3", orderList.get("type3"));
/* 1172 */     return "/home/cms/order";
/*      */   }
/*      */ 
/*      */   @RequestMapping({"cms/other"})
/*      */   public String cmsOtherProjectListingList(ModelMap model)
/*      */   {
/* 1182 */     Integer count = Integer.valueOf(12);
/* 1183 */     Map latestPro = this.projectListingService.selectLatestProjectListing(count);
/* 1184 */     model.put("proListTypeOther", latestPro.get("other"));
/* 1185 */     return "/home/cms/other";
/*      */   }
/*      */ 
/*      */   @RequestMapping({"cms/financing"})
/*      */   public String cmsFinancingList(ModelMap model)
/*      */   {
/* 1195 */     Integer count = Integer.valueOf(12);
/* 1196 */     List latestPro = this.financingService.selectFinancingListing(count);
/* 1197 */     model.put("financingList", latestPro);
/* 1198 */     return "/home/cms/financing";
/*      */   }
/*      */ 
/*      */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_R_PROJECT_BUYER_CHOOSE_LIST})
/*      */   @RequestMapping({"project/buyer/chooseList"})
/*      */   public void getBuyerChooseProjectList(@ModelAttribute("query") ProjectListingQuery query, UserAgent userAgent, ModelMap model)
/*      */     throws Exception
/*      */   {
/* 1212 */     EnumProjectStatus[] pjStatus = EnumProjectStatus.values();
/* 1213 */     if (query == null) {
/* 1214 */       query = new ProjectListingQuery();
/*      */     }
/* 1216 */     query.setUserAccount(userAgent.getAccount());
/* 1217 */     query.setListingType(EnumListingType.BUY.getValue());
/* 1218 */     this.projectListingService.getProjectListingByQuery(query);
/* 1219 */     model.addAttribute("query", query);
/* 1220 */     model.addAttribute("pjStatus", pjStatus);
/*      */   }
/*      */ 
/*      */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_R_PROJECT_SELLER_CHOOSE_LIST})
/*      */   @RequestMapping({"project/seller/chooseList"})
/*      */   public void getSellerChooseProjectList(@ModelAttribute("query") ProjectListingQuery query, UserAgent userAgent, ModelMap model)
/*      */     throws Exception
/*      */   {
/* 1235 */     EnumProjectStatus[] pjStatus = EnumProjectStatus.values();
/* 1236 */     if (query == null) {
/* 1237 */       query = new ProjectListingQuery();
/*      */     }
/* 1239 */     query.setUserAccount(userAgent.getAccount());
/* 1240 */     query.setListingType(EnumListingType.SELL.getValue());
/* 1241 */     this.projectListingService.getProjectListingByQuery(query);
/* 1242 */     model.addAttribute("query", query);
/* 1243 */     model.addAttribute("pjStatus", pjStatus);
/*      */   }
/*      */ 
/*      */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_R_PROJECT_QUERY})
/*      */   @RequestMapping({"project/getProjectListingById"})
/*      */   @ResponseBody
/*      */   public ProjectListing getProjectListingById(@RequestParam(value="id", required=true) Long id, UserAgent userAgent, ModelMap model)
/*      */   {
/* 1258 */     ProjectListing projectListing = this.projectListingService.getProjectListingById(id);
/*      */ 
/* 1265 */     return projectListing;
/*      */   }
/*      */ 
/*      */   @RequestMapping({"project/sell/submitAuditConfirm"})
/*      */   public String submitAuditConfirm(ModelMap model, @RequestParam(value="projectId", required=true) Long projectId, UserAgent userAgent)
/*      */   {
/* 1279 */     ProjectListing projectListing = this.projectListingService.getProjectListingById(projectId);
/* 1280 */     if (!projectListing.getUserAccount().equals(userAgent.getAccount())) {
/* 1281 */       model.addAttribute("message", "无权限");
/* 1282 */       return "/error";
/*      */     }
/*      */     try {
/* 1285 */       projectListing.setDeposit(this.projectListingService.getListingJYDeposit(projectListing, 
/* 1286 */         userAgent.getAccount()));
/*      */     } catch (ServiceException e) {
/* 1288 */       this.log.error("获得挂牌交易保证金失败！", e);
/*      */     }
/* 1290 */     model.addAttribute("projectListing", projectListing);
/* 1291 */     return "/project/confirm";
/*      */   }
/*      */ 
/*      */   @SystemAccess({com.hundsun.network.gates.luosi.biz.enums.PermissionEnum.BIZ_U_PROJECT_AUDIT})
/*      */   @RequestMapping({"/project/subAudit"})
/*      */   @ResponseBody
/*      */   public AjaxResult doUpdateProjToAudit(@RequestParam(value="projectId", required=true) Long projectId, UserAgent userAgent, ModelMap model)
/*      */   {
/* 1307 */     AjaxResult result = new AjaxResult();
/* 1308 */     ProjectListing prjLis = this.projectListingService.getProjectListingById(projectId);
/* 1309 */     if (!prjLis.getUserAccount().equals(userAgent.getAccount())) {
/* 1310 */       result.setErrorNO(Integer.valueOf(1));
/* 1311 */       result.setErrorInfo("无权限");
/* 1312 */       return result;
/*      */     }
/* 1314 */     if (!prjLis.getStatus().equals(EnumProjectStatus.CREATE.getValue()))
/*      */     {
/* 1316 */       result.setErrorNO(Integer.valueOf(0));
/* 1317 */       result.setErrorInfo("提交审核项目状态错误");
/* 1318 */       return result;
/*      */     }
/*      */ 
/* 1325 */     prjLis.setFundAccount(userAgent.getFundAccount());
/* 1326 */     ProjectListingServiceResult presult = this.projectListingService
/* 1327 */       .updateProjectListingStatusById(prjLis);
/* 1328 */     result.setServiceResult(presult);
/*      */ 
/* 1330 */     return result;
/*      */   }
/*      */ 
/*      */   @RequestMapping(value={"/project/soonAdd"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*      */   public String goSellerSoonAdd(@RequestParam(value="projectId", required=true) Long projectId, ModelMap model)
/*      */   {
/* 1344 */     ProjectListing projectListing = this.projectListingService.getProjectListingById(projectId);
/* 1345 */     model.addAttribute("projectListing", projectListing);
/* 1346 */     prepareListingType(model);
/* 1347 */     return "project/" + projectListing.getListingType() + "er/soonAdd";
/*      */   }
/*      */ 
/*      */   @RequestMapping(value={"/project/deleteFile"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*      */   @ResponseBody
/*      */   public int deleteOraginalFile(@RequestParam("projectId") Long projectId, @RequestParam("attachedFilePath") String attachedFilePath)
/*      */   {
/* 1362 */     if ((projectId == null) && (StringUtil.isEmpty(attachedFilePath))) {
/* 1363 */       return 0;
/*      */     }
/* 1365 */     ProjectListing projectListing = new ProjectListing();
/* 1366 */     projectListing.setId(projectId);
/* 1367 */     projectListing.setAttachedFilePath(attachedFilePath);
/*      */ 
/* 1369 */     return this.projectListingService.updateAttachedFile(projectListing).intValue();
/*      */   }
/*      */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.web.action.project.ProjectListingAction
 * JD-Core Version:    0.6.0
 */