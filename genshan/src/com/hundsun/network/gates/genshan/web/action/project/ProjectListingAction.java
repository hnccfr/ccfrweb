/*      */ package com.hundsun.network.gates.genshan.web.action.project;
/*      */ 
/*      */ import com.hundsun.network.gates.genshan.biz.domain.operation.Announcement;
/*      */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectAuditLog;
/*      */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectListing;
/*      */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectMetas;
/*      */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectTradeBO;
/*      */ import com.hundsun.network.gates.genshan.biz.domain.query.ProjectListingQuery;
/*      */ import com.hundsun.network.gates.genshan.biz.domain.user.UserAccount;
/*      */ import com.hundsun.network.gates.genshan.biz.service.auction.AuctionActiveService;
/*      */ import com.hundsun.network.gates.genshan.biz.service.common.UploadService;
/*      */ import com.hundsun.network.gates.genshan.biz.service.project.ProjectListingService;
/*      */ import com.hundsun.network.gates.genshan.biz.service.project.ProjectMetasService;
/*      */ import com.hundsun.network.gates.genshan.biz.service.project.ProjectTypeService;
/*      */ import com.hundsun.network.gates.genshan.biz.service.user.UserAccountService;
/*      */ import com.hundsun.network.gates.genshan.common.DateUtil;
/*      */ import com.hundsun.network.gates.genshan.common.MobileMessageUtil;
/*      */ import com.hundsun.network.gates.genshan.common.UserAgent;
/*      */ import com.hundsun.network.gates.genshan.security.AdminAccess;
/*      */ import com.hundsun.network.gates.genshan.web.action.BaseAction;
/*      */ import com.hundsun.network.gates.genshan.web.util.ProjectCopyUtil;
/*      */ import com.hundsun.network.gates.genshan.web.util.TradeMoneyUtil;
/*      */ import com.hundsun.network.gates.genshan.web.validator.ProEditValidator;
/*      */ import com.hundsun.network.gates.luosi.biz.domain.TradeShowDTO;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumAnnouncementType;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumAuditRes;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumBidOrderProperty;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumDeliveryType;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumListingType;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumMeasureUnit;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumMetaGroup;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumMulitBidOrderProperty;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumOperatorType;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumPaymentType;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumProcessAuditNodes;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumProjectRetail;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumProjectStatus;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumTradingType;
/*      */ import com.hundsun.network.gates.luosi.common.enums.EnumValuationUnit;
/*      */ import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
/*      */ import com.hundsun.network.gates.luosi.common.utils.CommonUtils;
/*      */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.AnnouncementDTO;
/*      */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.ProjectAuditLogDTO;
/*      */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.ProjectListingDTO;
/*      */ import com.hundsun.network.gates.luosi.wulin.reomte.enums.EnumProjectListingResultErrors;
/*      */ import com.hundsun.network.gates.luosi.wulin.reomte.request.AnnouncementRequest;
/*      */ import com.hundsun.network.gates.luosi.wulin.reomte.request.ProjectAuditLogRequest;
/*      */ import com.hundsun.network.gates.luosi.wulin.reomte.result.ProjectAuditLogServiceResult;
/*      */ import com.hundsun.network.gates.luosi.wulin.reomte.result.ProjectListingServiceResult;
/*      */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteProjectListingService;
/*      */ import com.hundsun.network.melody.common.util.StringUtil;
/*      */ import java.io.IOException;
/*      */ import java.net.URLDecoder;
/*      */ import java.text.DateFormat;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Calendar;
/*      */ import java.util.Date;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import org.apache.commons.lang.StringUtils;
/*      */ import org.apache.commons.logging.Log;
/*      */ import org.apache.commons.logging.LogFactory;
/*      */ import org.codehaus.jackson.JsonGenerationException;
/*      */ import org.codehaus.jackson.map.JsonMappingException;
/*      */ import org.codehaus.jackson.map.ObjectMapper;
/*      */ import org.springframework.beans.factory.annotation.Autowired;
/*      */ import org.springframework.beans.propertyeditors.CustomDateEditor;
/*      */ import org.springframework.stereotype.Controller;
/*      */ import org.springframework.ui.ModelMap;
/*      */ import org.springframework.validation.BindingResult;
/*      */ import org.springframework.web.bind.WebDataBinder;
/*      */ import org.springframework.web.bind.annotation.ModelAttribute;
/*      */ import org.springframework.web.bind.annotation.RequestMapping;
/*      */ import org.springframework.web.bind.annotation.RequestParam;
/*      */ import org.springframework.web.multipart.MultipartFile;
/*      */ 
/*      */ @Controller
/*      */ public class ProjectListingAction extends BaseAction
/*      */ {
/*   90 */   protected final Log logger = LogFactory.getLog(getClass());
/*      */ 
/*      */   @Autowired
/*      */   private ProjectListingService projectListingService;
/*      */ 
/*      */   @Autowired
/*      */   private ProjectMetasService projectMetasService;
/*      */ 
/*      */   @Autowired
/*      */   private RemoteProjectListingService remoteProjectListingService;
/*      */ 
/*      */   @Autowired
/*      */   private ProEditValidator proEditValidator;
/*      */ 
/*      */   @Autowired
/*      */   private AuctionActiveService auctionActiveService;
/*      */ 
/*      */   @Autowired
/*      */   private ProjectTypeService projectTypeService;
/*      */ 
/*      */   @Autowired
/*      */   private UploadService uploadService;
/*      */ 
/*      */   @Autowired
/*      */   private UserAccountService userAccountService;
/*      */ 
/*      */   @Autowired
/*      */   private MobileMessageUtil mobileMessageUtil;
/*      */ 
/*  119 */   protected void registerDefaultCustomDateEditor(WebDataBinder binder) { DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*  120 */     dateFormat.setLenient(false);
/*  121 */     binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
/*      */   }
/*      */ 
/*      */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.PRO_R_PROJECT_LISTING_LIST})
/*      */   @RequestMapping({"/project/sell/list"})
/*      */   public String projectListingListSell(ModelMap model, UserAgent userAgent, @ModelAttribute("page") ProjectListingQuery<ProjectListing> page)
/*      */     throws Exception
/*      */   {
/*  135 */     Long substationId = getSubstationId(userAgent);
/*      */ 
/*  137 */     if (substationId != null) {
/*  138 */       page.setSubstationId(Long.valueOf(substationId.longValue()));
/*      */     }
/*  140 */     page.trim();
/*  141 */     page.setListingType(EnumListingType.SELL.getValue());
/*  142 */     this.projectListingService.paginate(page);
/*  143 */     initPageData(model);
/*  144 */     return "/project/sell/list";
/*      */   }
/*      */ 
/*      */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.PRO_R_PROJECT_LISTING_LIST})
/*      */   @RequestMapping({"/project/buy/list"})
/*      */   public String projectListingListBuy(ModelMap model, UserAgent userAgent, @ModelAttribute("page") ProjectListingQuery<ProjectListing> page)
/*      */     throws Exception
/*      */   {
/*  158 */     Long substationId = getSubstationId(userAgent);
/*      */ 
/*  160 */     if (substationId != null) {
/*  161 */       page.setSubstationId(Long.valueOf(substationId.longValue()));
/*      */     }
/*  163 */     page.trim();
/*  164 */     page.setListingType(EnumListingType.BUY.getValue());
/*  165 */     this.projectListingService.paginate(page);
/*  166 */     initPageData(model);
/*  167 */     return "/project/buy/list";
/*      */   }
/*      */ 
/*      */   private void initPageData(ModelMap model)
/*      */   {
/*  176 */     model.put("projectStatusList", EnumProjectStatus.values());
/*  177 */     model.put("projectAuditLog", new ProjectAuditLog());
/*  178 */     model.put("announcement", new Announcement());
/*  179 */     initPageEnumData(model);
/*      */   }
/*      */ 
/*      */   @RequestMapping({"/project/dialog"})
/*      */   public String projectListingListDialog(ModelMap model, @ModelAttribute("page") ProjectListingQuery<ProjectListing> page)
/*      */     throws Exception
/*      */   {
/*  193 */     if (StringUtil.isNotBlank(page.getTitle()))
/*  194 */       page.setTitle(URLDecoder.decode(page.getTitle(), "UTF-8"));
/*  195 */     page.trim();
/*  196 */     page.setCodeExist(true);
/*  197 */     this.projectListingService.paginate(page);
/*  198 */     model.put("projectStatusList", EnumProjectStatus.values());
/*  199 */     return "/project/dialog";
/*      */   }
/*      */ 
/*      */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.PRO_R_PROJECT_LISTING_INFO})
/*      */   @RequestMapping({"/project/info"})
/*      */   public String projectListingInfo(ModelMap model, UserAgent userAgent, @RequestParam("projectListingId") Long projectListingId)
/*      */     throws Exception
/*      */   {
/*  212 */     ProjectListing projectListing = this.projectListingService.getProjectListingById(projectListingId);
/*      */ 
/*  214 */     Long substationId = getSubstationId(userAgent);
/*      */ 
/*  216 */     if ((substationId != null) && (!substationId.equals(projectListing.getSubstationId()))) {
/*  217 */       return "accessDenied";
/*      */     }
/*  219 */     TradeMoneyUtil.conver2ValueUnit(projectListing);
/*  220 */     model.put("projectListing", projectListing);
/*  221 */     initPageData(model);
/*  222 */     HashMap map = new HashMap();
/*  223 */     map.put(EnumBidOrderProperty.RESERVE_PRICE.getKey(), "hiddenMetas");
/*      */ 
/*  225 */     ProjectCopyUtil.hiddenTradeMetas(projectListing, map);
/*  226 */     model.put("url", "/project/" + projectListing.getListingType() + "/list.htm");
/*  227 */     return "/project/info";
/*      */   }
/*      */ 
/*      */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.PRO_R_PROJECT_LISTING_INFO})
/*      */   @RequestMapping({"/project/view"})
/*      */   public String projectListingInfo(ModelMap model, UserAgent userAgent, @RequestParam("projectCode") String projectCode)
/*      */     throws Exception
/*      */   {
/*  239 */     ProjectListing projectListing = this.projectListingService.getProjectListingByCode(projectCode);
/*  240 */     Long substationId = getSubstationId(userAgent);
/*      */ 
/*  242 */     if ((substationId != null) && (!substationId.equals(projectListing.getSubstationId()))) {
/*  243 */       return "accessDenied";
/*      */     }
/*  245 */     TradeMoneyUtil.conver2ValueUnit(projectListing);
/*  246 */     model.put("projectListing", projectListing);
/*  247 */     initPageData(model);
/*  248 */     HashMap map = new HashMap();
/*  249 */     map.put(EnumBidOrderProperty.RESERVE_PRICE.getKey(), "hiddenMetas");
/*      */ 
/*  251 */     ProjectCopyUtil.hiddenTradeMetas(projectListing, map);
/*  252 */     return "/project/info";
/*      */   }
/*      */ 
/*      */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.PRO_U_PROJECT_LISTING_AUDIT})
/*      */   @RequestMapping(value={"/project/audit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*      */   public String projectListingAuditDialog(ModelMap model, UserAgent userAgent, @RequestParam("projectListingId") Long projectListingId)
/*      */     throws Exception
/*      */   {
/*  266 */     ProjectListing projectListing = this.projectListingService.getProjectListingById(projectListingId);
/*      */ 
/*  268 */     Long substationId = getSubstationId(userAgent);
/*      */ 
/*  270 */     if ((substationId != null) && (!substationId.equals(projectListing.getSubstationId()))) {
/*  271 */       return "accessDenied";
/*      */     }
/*  273 */     if ((substationId != null) && ((!substationId.equals(projectListing.getSubstationId())) || (!EnumProcessAuditNodes.ADVANCE_AUDIT.getValue().endsWith(projectListing.getAuditNode()))))
/*      */     {
/*  275 */       model.put("message", "终审由系统管理员执行");
/*  276 */       return "accessDenied";
/*      */     }
/*  278 */     ProjectTradeBO tradeBo = new ProjectTradeBO();
/*  279 */     if ((projectListingId != null) && (projectListingId.longValue() > 0L)) {
/*  280 */       List tradeMetas = new ArrayList();
/*  281 */       if (EnumTradingType.PLACE_ORDER.getValue().equals(projectListing.getTradingType())) {
/*  282 */         tradeMetas = this.projectMetasService.getMetasByProjectListing(projectListing);
/*      */       } else {
/*  284 */         List pMetas = this.projectMetasService.getMetasByProjectIdAndMetaGroup(projectListingId, EnumMetaGroup.TRADINGTYPE.getValue());
/*      */ 
/*  286 */         tradeMetas = copyProjectMetasList2TradeShowDTOList(pMetas);
/*      */       }
/*  288 */       tradeBo.setTradeMetas(tradeMetas);
/*  289 */       TradeMoneyUtil.conver2ValueUnit(projectListing, tradeBo);
/*      */     }
/*      */ 
/*  292 */     HashMap ignoreMap = new HashMap();
/*  293 */     ignoreMap.put(EnumBidOrderProperty.BID_START_PRICE.getKey(), "hidden");
/*  294 */     ignoreMap.put(EnumBidOrderProperty.PRICE_DIRECTION.getKey(), "hidden");
/*  295 */     ignoreMap.put(EnumBidOrderProperty.BID_RATE.getKey(), "hidden");
/*  296 */     ignoreMap.put(EnumBidOrderProperty.SUPPORT_PRIORITY.getKey(), "hidden");
/*  297 */     ignoreMap.put(EnumBidOrderProperty.BID_START_TIME.getKey(), "hidden");
/*  298 */     ignoreMap.put(EnumBidOrderProperty.BID_LIMITED_PERIOD.getKey(), "hidden");
/*  299 */     ignoreMap.put(EnumBidOrderProperty.HAVE_RESERVE_PRICE.getKey(), "hidden");
/*  300 */     ignoreMap.put(EnumBidOrderProperty.RESERVE_PRICE.getKey(), "hidden");
/*  301 */     ignoreMap.put(EnumBidOrderProperty.APPLY_START_TIME.getKey(), "hidden");
/*  302 */     ignoreMap.put(EnumBidOrderProperty.APPLY_END_TIME.getKey(), "hidden");
/*  303 */     ignoreMap.put(EnumBidOrderProperty.FIRST_WAIT_TIME.getKey(), "hidden");
/*  304 */     if (EnumTradingType.MULIT_BID_ORDER.getValue().equals(projectListing.getTradingType())) {
/*  305 */       ignoreMap.put(EnumMulitBidOrderProperty.REVIEWER_ACCOUNT.getKey(), "hidden");
/*      */     }
/*  307 */     model.put("projectListing", projectListing);
/*  308 */     model.put("projectAuditLog", new ProjectAuditLog());
/*  309 */     model.addAttribute("tradeBo", tradeBo);
/*  310 */     model.addAttribute("attriList", this.projectListingService.getProjectTradeTypeAttri(projectListing.getTradingType(), ignoreMap, projectListing.getListingType()));
/*      */ 
/*  312 */     return "/project/auditDialog";
/*      */   }
/*      */ 
/*      */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.PRO_U_PROJECT_LISTING_AUDIT})
/*      */   @RequestMapping(value={"/project/audit"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*      */   public String projectListingAudit(ModelMap model, UserAgent userAgent, @ModelAttribute("projectAuditLog") ProjectAuditLog projectAuditLog, BindingResult auditValiResult, @ModelAttribute("tradeBo") ProjectTradeBO tradeBo, @ModelAttribute("projectListing") ProjectListing projectListing, BindingResult proValiResult)
/*      */     throws Exception
/*      */   {
/*  331 */     if ((projectAuditLog == null) || (projectListing.getId() == null) || (EnumAuditRes.indexByValue(projectAuditLog.getAuditRes()) == null))
/*      */     {
/*  333 */       model.put("message", "输入参数错误");
/*  334 */       return error(model);
/*      */     }
/*  336 */     Map metaErrors = new HashMap();
/*  337 */     Map metaSubmitValue = new HashMap();
/*  338 */     String auditResult = projectAuditLog.getAuditRes();
/*  339 */     String memo = projectAuditLog.getAuditMemo();
/*  340 */     memo = URLDecoder.decode(memo, "UTF-8");
/*  341 */     if (EnumAuditRes.NO.getValue().equals(auditResult)) {
/*  342 */       if (StringUtil.isBlank(memo)) {
/*  343 */         auditValiResult.rejectValue("auditMemo", null, null, "审核不通过时必须填写说明");
/*  344 */         metaErrors.put("auditMemo", "审核不通过时必须填写说明");
/*  345 */       } else if (memo.length() > 150) {
/*  346 */         auditValiResult.rejectValue("auditMemo", null, null, "审核说明 不得超过150字符");
/*  347 */         metaErrors.put("auditMemo", "审核说明 不得超过150字符");
/*      */       }
/*      */     }
/*  350 */     Long projectListingId = projectListing.getId();
/*      */ 
/*  352 */     ProjectListing proSimp = this.projectListingService.getProjectListingById(projectListingId);
/*  353 */     Date listingStartTime = projectListing.getListingStartTime();
/*  354 */     Date listingEndTime = projectListing.getListingEndTime();
/*      */ 
/*  356 */     if (!listingEndTime.after(listingStartTime)) {
/*  357 */       proValiResult.rejectValue("listingEndTime", null, null, "挂牌结束时间 要晚于挂牌开始时间");
/*  358 */       metaErrors.put("listingEndTime", "挂牌结束时间 要晚于挂牌开始时间");
/*      */     }
/*      */ 
/*  361 */     if (!listingEndTime.after(new Date())) {
/*  362 */       proValiResult.rejectValue("listingEndTime", null, null, "挂牌结束时间 要晚于当前时间");
/*  363 */       metaErrors.put("listingEndTime", "挂牌结束时间 要晚于当前时间");
/*      */     }
/*      */ 
/*  367 */     if (!proSimp.isAudit()) {
/*  368 */       model.put("message", "挂牌审核操作 失败 ，请检查项目是否处于待审状态");
/*  369 */       return error(model);
/*      */     }
/*  371 */     String auditNode_now = EnumProcessAuditNodes.FINAL_AUDIT.getValue();
/*  372 */     if (proSimp.getProcessAuditNodes().indexOf(auditNode_now) < 0) {
/*  373 */       model.put("message", "挂牌审核操作 失败 ，请检查项目是否有后台审核的节点");
/*  374 */       return error(model);
/*      */     }
/*  376 */     if ((EnumTradingType.BID_ORDER.getValue().equals(proSimp.getTradingType())) && (EnumAuditRes.YES.getValue().equals(auditResult)))
/*      */     {
/*  379 */       HashMap map = ProjectCopyUtil.getTradeMap(tradeBo.getTradeMetas());
/*  380 */       String haveAuctioneer = (String)map.get(EnumBidOrderProperty.HAVE_AUCTIONEER.getKey());
/*  381 */       String auctioneerAccount = (String)map.get(EnumBidOrderProperty.AUCTIONEER_ACCOUNT.getKey());
/*  382 */       String allowWatch = (String)map.get(EnumBidOrderProperty.ALLOW_WATCH.getKey());
/*  383 */       String watchPassword = (String)map.get(EnumBidOrderProperty.WATCH_PASSWORD.getKey());
/*  384 */       metaSubmitValue = map;
/*  385 */       model.put("projectListing", proSimp);
/*  386 */       if (StringUtil.isEmpty(haveAuctioneer))
/*  387 */         metaErrors.put(EnumBidOrderProperty.HAVE_AUCTIONEER.getKey(), "是否有拍卖师不能为空!");
/*  388 */       else if (("Y".equals(haveAuctioneer)) && 
/*  389 */         (StringUtil.isEmpty(auctioneerAccount))) {
/*  390 */         metaErrors.put(EnumBidOrderProperty.AUCTIONEER_ACCOUNT.getKey(), "拍卖师账户不能为空!");
/*      */       }
/*      */ 
/*  393 */       if (StringUtil.isEmpty(allowWatch)) {
/*  394 */         metaErrors.put(EnumBidOrderProperty.ALLOW_WATCH.getKey(), "是否允许观看不能为空!");
/*      */       }
/*  396 */       if ((StringUtil.isNotEmpty(watchPassword)) && (watchPassword.length() > 16)) {
/*  397 */         metaErrors.put(EnumBidOrderProperty.WATCH_PASSWORD.getKey(), "观看码长度不能超过16字符长度!");
/*      */       }
/*      */     }
/*  400 */     else if ((EnumTradingType.MULIT_BID_ORDER.getValue().equals(proSimp.getTradingType())) && (EnumAuditRes.YES.getValue().equals(auditResult)))
/*      */     {
/*  403 */       HashMap map = ProjectCopyUtil.getTradeMap(tradeBo.getTradeMetas());
/*  404 */       String haveAuctioneer = (String)map.get(EnumBidOrderProperty.HAVE_AUCTIONEER.getKey());
/*  405 */       String auctioneerAccount = (String)map.get(EnumBidOrderProperty.AUCTIONEER_ACCOUNT.getKey());
/*  406 */       String allowWatch = (String)map.get(EnumBidOrderProperty.ALLOW_WATCH.getKey());
/*  407 */       String watchPassword = (String)map.get(EnumBidOrderProperty.WATCH_PASSWORD.getKey());
/*  408 */       String reviewerAccount = (String)map.get(EnumMulitBidOrderProperty.REVIEWER_ACCOUNT.getKey());
/*  409 */       metaSubmitValue = map;
/*  410 */       model.put("projectListing", proSimp);
/*  411 */       if (StringUtil.isEmpty(haveAuctioneer))
/*  412 */         metaErrors.put(EnumBidOrderProperty.HAVE_AUCTIONEER.getKey(), "是否有拍卖师不能为空!");
/*  413 */       else if (("Y".equals(haveAuctioneer)) && 
/*  414 */         (StringUtil.isEmpty(auctioneerAccount))) {
/*  415 */         metaErrors.put(EnumBidOrderProperty.AUCTIONEER_ACCOUNT.getKey(), "拍卖师账户不能为空!");
/*      */       }
/*      */ 
/*  418 */       if (StringUtil.isEmpty(allowWatch)) {
/*  419 */         metaErrors.put(EnumBidOrderProperty.ALLOW_WATCH.getKey(), "是否允许观看不能为空!");
/*      */       }
/*      */ 
/*  425 */       if ((StringUtil.isNotEmpty(watchPassword)) && (watchPassword.length() > 16)) {
/*  426 */         metaErrors.put(EnumBidOrderProperty.WATCH_PASSWORD.getKey(), "观看码长度不能超过16字符长度!");
/*      */       }
/*      */ 
/*  429 */       if (EnumTradingType.MULIT_BID_ORDER.getValue().equals(proSimp.getTradingType())) {
/*  430 */         if (StringUtil.isEmpty(reviewerAccount)) {
/*  431 */           metaErrors.put(EnumMulitBidOrderProperty.REVIEWER_ACCOUNT.getKey(), "评审员不能为空!");
/*      */         }
/*  433 */         if (reviewerAccount.length() >= 680) {
/*  434 */           metaErrors.put(EnumMulitBidOrderProperty.REVIEWER_ACCOUNT.getKey(), "评审员长度不能超过680！");
/*      */         }
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  440 */     if ((auditValiResult.hasErrors()) || (proValiResult.hasErrors()) || (!metaErrors.isEmpty())) {
/*  441 */       ObjectMapper mapper = new ObjectMapper();
/*  442 */       String tradeMetaError = "";
/*  443 */       String metaSubmitValueStr = "";
/*      */       try {
/*  445 */         tradeMetaError = mapper.writeValueAsString(metaErrors);
/*  446 */         metaSubmitValueStr = mapper.writeValueAsString(metaSubmitValue);
/*      */       } catch (JsonGenerationException e) {
/*  448 */         this.log.error("", e);
/*      */       } catch (JsonMappingException e) {
/*  450 */         this.log.error("", e);
/*      */       } catch (IOException e) {
/*  452 */         this.log.error("", e);
/*      */       }
/*      */ 
/*  455 */       HashMap ignoreMap = new HashMap();
/*  456 */       ignoreMap.put(EnumBidOrderProperty.BID_START_PRICE.getKey(), "hidden");
/*  457 */       ignoreMap.put(EnumBidOrderProperty.PRICE_DIRECTION.getKey(), "hidden");
/*  458 */       ignoreMap.put(EnumBidOrderProperty.BID_RATE.getKey(), "hidden");
/*  459 */       ignoreMap.put(EnumBidOrderProperty.SUPPORT_PRIORITY.getKey(), "hidden");
/*  460 */       ignoreMap.put(EnumBidOrderProperty.BID_START_TIME.getKey(), "hidden");
/*  461 */       ignoreMap.put(EnumBidOrderProperty.BID_LIMITED_PERIOD.getKey(), "hidden");
/*  462 */       ignoreMap.put(EnumBidOrderProperty.HAVE_RESERVE_PRICE.getKey(), "hidden");
/*  463 */       ignoreMap.put(EnumBidOrderProperty.RESERVE_PRICE.getKey(), "hidden");
/*  464 */       ignoreMap.put(EnumBidOrderProperty.APPLY_START_TIME.getKey(), "hidden");
/*  465 */       ignoreMap.put(EnumBidOrderProperty.APPLY_END_TIME.getKey(), "hidden");
/*  466 */       ignoreMap.put(EnumBidOrderProperty.FIRST_WAIT_TIME.getKey(), "hidden");
/*  467 */       if (EnumTradingType.MULIT_BID_ORDER.getValue().equals(projectListing.getTradingType())) {
/*  468 */         ignoreMap.put(EnumMulitBidOrderProperty.REVIEWER_ACCOUNT.getKey(), "hidden");
/*      */       }
/*  470 */       model.addAttribute("attriList", this.projectListingService.getProjectTradeTypeAttri(proSimp.getTradingType(), ignoreMap, projectListing.getListingType()));
/*      */ 
/*  472 */       projectListing.setTradeMeta(proSimp.getTradeMeta());
/*  473 */       projectListing.setTradeMetas(proSimp.getTradeMetas());
/*  474 */       projectListing.setTradingType(proSimp.getTradingType());
/*  475 */       model.put("projectListing", projectListing);
/*  476 */       model.put("metaErrors", tradeMetaError);
/*  477 */       model.addAttribute("metaSubmitValue", metaSubmitValueStr);
/*  478 */       return "/project/auditDialog";
/*      */     }
/*      */ 
/*  483 */     ProjectAuditLogRequest request = new ProjectAuditLogRequest();
/*  484 */     ProjectAuditLogDTO projectAuditLogDTO = new ProjectAuditLogDTO();
/*  485 */     projectAuditLogDTO.setProjectId(projectListingId);
/*  486 */     projectAuditLogDTO.setAuditRes(auditResult);
/*  487 */     projectAuditLogDTO.setAuditMemo(memo);
/*  488 */     projectAuditLogDTO.setOperatorType(EnumOperatorType.SYSTEM.getValue());
/*  489 */     projectAuditLogDTO.setOperator(userAgent.getUserAccount());
/*      */ 
/*  491 */     projectAuditLogDTO.setProcessAuditNodes(projectListing.getProcessAuditNodes());
/*  492 */     projectAuditLogDTO.setAuditNode(auditNode_now);
/*  493 */     request.setProjectAuditLogDTO(projectAuditLogDTO);
/*      */ 
/*  495 */     ProjectListingDTO proDTO = new ProjectListingDTO();
/*  496 */     proDTO.setTradeMetasList(ProjectCopyUtil.convertTradeShowDTOList2TradeMetasList(projectListingId, proSimp.getGmtCreate() == null ? new Date() : proSimp.getGmtCreate(), proSimp.getGmtModify() == null ? new Date() : proSimp.getGmtModify(), proSimp.getOperator() == null ? userAgent.getUserAccount() : proSimp.getOperator(), tradeBo.getTradeMetas()));
/*      */ 
/*  501 */     proDTO.setId(projectListingId);
/*  502 */     proDTO.setListingStartTime(listingStartTime);
/*  503 */     proDTO.setListingEndTime(listingEndTime);
/*  504 */     request.setProjectListingDTO(proDTO);
/*      */ 
/*  507 */     List oldAuctionerAccounts = new ArrayList();
/*  508 */     if (EnumTradingType.MULIT_BID_ORDER.getValue().equals(projectListing.getTradingType())) {
/*  509 */       ProjectMetas projectMetas = new ProjectMetas();
/*  510 */       projectMetas.setProjectId(projectListing.getId());
/*  511 */       projectMetas.setMetaKey(EnumBidOrderProperty.AUCTIONEER_ACCOUNT.getKey());
/*  512 */       List _oldAuctionerAccounts = new ArrayList();
/*  513 */       String auctionerAccounts = this.projectListingService.selectOneMetaValue(projectMetas);
/*  514 */       if (StringUtil.isNotEmpty(auctionerAccounts)) {
/*  515 */         _oldAuctionerAccounts = Arrays.asList(auctionerAccounts.split(","));
/*  516 */         oldAuctionerAccounts.addAll(_oldAuctionerAccounts);
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  522 */     ProjectAuditLogServiceResult result = new ProjectAuditLogServiceResult();
/*      */     try {
/*  524 */       result = this.remoteProjectListingService.audit(request);
/*      */     } catch (Exception e) {
/*  526 */       this.log.error("", e);
/*  527 */       result.setErrorNO(Integer.valueOf(EnumProjectListingResultErrors.SERVER_ERROR.getValue()));
/*  528 */       result.setErrorInfo(EnumProjectListingResultErrors.SERVER_ERROR.getInfo());
/*      */     }
/*      */ 
/*  531 */     if (result.correct())
/*      */     {
/*  534 */       if ((EnumTradingType.BID_ORDER.getValue().equals(projectListing.getTradingType())) || (EnumTradingType.MULIT_BID_ORDER.getValue().equals(projectListing.getTradingType())))
/*      */       {
/*  536 */         ProjectListing simpleProject = this.projectListingService.getProSimpInfo(projectListingId);
/*  537 */         this.projectListingService.sendMessageToAuctioners(oldAuctionerAccounts, tradeBo, simpleProject);
/*      */       }
/*      */ 
/*  540 */       model.put("message", "挂牌审核操作成功!");
/*  541 */       model.put("url", "/project/" + projectListing.getListingType() + "/list.htm");
/*      */       try
/*      */       {
/*  545 */         UserAccount userAccount = this.userAccountService.getUserByAccount(proSimp.getUserAccount());
/*  546 */         List nums = new ArrayList();
/*  547 */         nums.add(userAccount.getMobile());
/*  548 */         String msg = "尊敬的" + userAccount.getName() + "您好，您的挂牌项目" + proSimp.getTitle();
/*  549 */         if (EnumAuditRes.NO.getValue().equals(auditResult))
/*      */         {
/*  551 */           msg = msg + "未通过审核【中部林业产权交易服务中心】";
/*  552 */           this.mobileMessageUtil.sendMsg(nums, msg);
/*  553 */         } else if ((proSimp.isAudit()) && (!proSimp.isAdvanceAudit()))
/*      */         {
/*  555 */           msg = msg + "已通过审核，请及时关注交易动态【中部林业产权交易服务中心】";
/*  556 */           this.mobileMessageUtil.sendMsg(nums, msg);
/*      */         }
/*      */       } catch (Exception e) {
/*  559 */         this.log.error("send mobileMessage for project audit error cause by:" + e);
/*      */       }
/*      */     } else {
/*  562 */       model.put("message", "挂牌审核操作 失败 ，错误代码" + result.getErrorNO() + "，" + result.getErrorInfo());
/*      */     }
/*      */ 
/*  565 */     return result(result.correct());
/*      */   }
/*      */ 
/*      */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.PRO_U_PROJECT_LISTING_EDIT})
/*      */   @RequestMapping(value={"/project/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*      */   public String editPage(ModelMap model, UserAgent userAgent, @RequestParam("projectListingId") Long projectListingId)
/*      */     throws Exception
/*      */   {
/*  577 */     ProjectListing projectListing = this.projectListingService.getProArriMetaInfo(projectListingId);
/*      */ 
/*  579 */     Long substationId = getSubstationId(userAgent);
/*      */ 
/*  581 */     if ((substationId != null) && (!substationId.equals(projectListing.getSubstationId()))) {
/*  582 */       return "accessDenied";
/*      */     }
/*  584 */     model.put("projectListing", projectListing);
/*  585 */     initPageEnumData(model);
/*  586 */     model.put("url", "/project/" + projectListing.getListingType() + "/list.htm");
/*  587 */     return "/project/edit";
/*      */   }
/*      */ 
/*      */   private void prepareListingType(ModelMap model)
/*      */   {
/*  596 */     model.addAttribute("listingTypes", EnumListingType.values());
/*  597 */     model.addAttribute("tradingTypes", EnumTradingType.values());
/*  598 */     model.addAttribute("measureUnits", EnumMeasureUnit.values());
/*  599 */     model.addAttribute("valuationUnits", EnumValuationUnit.values());
/*  600 */     model.addAttribute("deliveryTypes", EnumDeliveryType.values());
/*  601 */     model.addAttribute("paymentTypes", EnumPaymentType.values());
/*      */   }
/*      */ 
/*      */   private void initPageEnumData(ModelMap model)
/*      */   {
/*  612 */     model.put("measureUnitList", EnumMeasureUnit.values());
/*      */ 
/*  614 */     model.put("valuationUnitList", EnumValuationUnit.values());
/*      */ 
/*  616 */     model.put("projectRetailList", EnumProjectRetail.values());
/*      */ 
/*  618 */     model.put("deliveryTypeList", EnumDeliveryType.values());
/*      */ 
/*  620 */     model.put("paymentTypeList", EnumPaymentType.values());
/*      */   }
/*      */ 
/*      */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.PRO_U_PROJECT_LISTING_EDIT})
/*      */   @RequestMapping(value={"/project/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*      */   public String edit(@ModelAttribute("projectListing") ProjectListing projectListing, BindingResult valiResult, @ModelAttribute("tradeBo") ProjectTradeBO tradeBo, @RequestParam("uploadFile0") MultipartFile file0, @RequestParam("uploadFile1") MultipartFile file1, @RequestParam("uploadFile2") MultipartFile file2, @RequestParam("uploadFile3") MultipartFile file3, @RequestParam("uploadFile4") MultipartFile file4, UserAgent userAgent, ModelMap model)
/*      */     throws Exception
/*      */   {
/*  639 */     Map metaErrors = new HashMap();
/*  640 */     Map metaSubmitValue = new HashMap();
/*      */ 
/*  642 */     this.proEditValidator.validate(projectListing, valiResult);
/*  643 */     this.proEditValidator.validateFile(file0, metaErrors);
/*  644 */     this.proEditValidator.validateFile(file1, metaErrors);
/*  645 */     this.proEditValidator.validateFile(file2, metaErrors);
/*  646 */     this.proEditValidator.validateFile(file3, metaErrors);
/*  647 */     this.proEditValidator.validateFile(file4, metaErrors);
/*      */ 
/*  649 */     List projectTypeAttriList = this.projectTypeService.queryProjectTypeAttri(projectListing.getProjectTypeCode());
/*      */ 
/*  652 */     this.proEditValidator.dynamicValidate(projectListing, metaErrors, projectTypeAttriList);
/*  653 */     if (EnumTradingType.PLACE_ORDER.getValue().equals(projectListing.getTradingType())) {
/*  654 */       List ignoreList = new ArrayList();
/*  655 */       this.proEditValidator.placeOrderVadate(projectListing, tradeBo, metaErrors, ignoreList);
/*  656 */     } else if ((EnumTradingType.BID_ORDER.getValue().equals(projectListing.getTradingType())) || (EnumTradingType.MULIT_BID_ORDER.getValue().equals(projectListing.getTradingType())))
/*      */     {
/*  659 */       List ignoreList = new ArrayList();
/*  660 */       ignoreList.add(EnumBidOrderProperty.AUCTIONEER_ACCOUNT.getKey());
/*      */ 
/*  662 */       this.proEditValidator.bidOrderVadate(projectListing, tradeBo, metaErrors, ignoreList);
/*  663 */     } else if (EnumTradingType.TRANSFER_ORDER.getValue().equals(projectListing.getTradingType())) {
/*  664 */       List ignoreList = new ArrayList();
/*  665 */       this.proEditValidator.transferOrderVadate(projectListing, tradeBo, metaErrors, ignoreList);
/*  666 */     } else if (EnumTradingType.TENDER_ORDER.getValue().equals(projectListing.getTradingType())) {
/*  667 */       List ignoreList = new ArrayList();
/*  668 */       this.proEditValidator.tenderOrderVadate(projectListing, tradeBo, metaErrors, ignoreList);
/*      */     }
/*      */ 
/*  671 */     ProjectCopyUtil.copyTradeMetasList2Map(tradeBo.getTradeMetas(), metaSubmitValue);
/*  672 */     ProjectCopyUtil.copyProjectMetasList2Map(projectListing.getMetaValues(), metaSubmitValue);
/*      */ 
/*  675 */     ObjectMapper mapper = new ObjectMapper();
/*  676 */     String tradeMetaError = "";
/*  677 */     String metaSubmitValueStr = "";
/*      */     try {
/*  679 */       tradeMetaError = mapper.writeValueAsString(metaErrors);
/*  680 */       metaSubmitValueStr = mapper.writeValueAsString(metaSubmitValue);
/*      */     } catch (JsonGenerationException e) {
/*  682 */       this.log.error("", e);
/*      */     } catch (JsonMappingException e) {
/*  684 */       this.log.error("", e);
/*      */     } catch (IOException e) {
/*  686 */       this.log.error("", e);
/*      */     }
/*      */ 
/*  689 */     if ((valiResult.hasErrors()) || (!metaErrors.isEmpty())) {
/*  690 */       ProjectListing oldProjectlisting = this.projectListingService.getProArriMetaInfo(projectListing.getId());
/*      */ 
/*  692 */       projectListing.setAttriMeta(oldProjectlisting.getAttriMeta());
/*  693 */       model.addAttribute("metaErrors", tradeMetaError);
/*  694 */       prepareListingType(model);
/*  695 */       model.put("url", "/project/" + projectListing.getListingType() + "/list.htm");
/*  696 */       initPageEnumData(model);
/*  697 */       model.addAttribute("curTradeType", projectListing.getTradingType());
/*  698 */       model.addAttribute("metaSubmitValue", metaSubmitValueStr);
/*  699 */       model.addAttribute("projectListing", projectListing);
/*  700 */       return "/project/edit";
/*      */     }
/*      */ 
/*  704 */     TradeMoneyUtil.convert2Cent(projectListing, tradeBo);
/*      */     try
/*      */     {
/*  708 */       String picturePath = "";
/*  709 */       String picturePath1 = "";
/*  710 */       String picturePath2 = "";
/*  711 */       String picturePath3 = "";
/*  712 */       String picturePath4 = "";
/*  713 */       if ((file0 != null) && (file0.getSize() > 0L)) {
/*  714 */         if (StringUtils.isNotEmpty(picturePath)) {
/*  715 */           this.uploadService.deleteOriginalFile(picturePath);
/*      */         }
/*  717 */         String imgExg = CommonUtils.getFileSuffix(file0.getOriginalFilename());
/*  718 */         picturePath = this.uploadService.uploadFile(file0.getInputStream(), imgExg);
/*  719 */         projectListing.setPicturePath(picturePath);
/*      */       }
/*  721 */       else if (StringUtils.isEmpty(projectListing.getTempPath())) {
/*  722 */         this.uploadService.deleteOriginalFile(picturePath);
/*  723 */         projectListing.setPicturePath("");
/*      */       }
/*      */ 
/*  726 */       if ((file1 != null) && (file1.getSize() > 0L)) {
/*  727 */         if (StringUtils.isNotEmpty(picturePath1)) {
/*  728 */           this.uploadService.deleteOriginalFile(picturePath1);
/*      */         }
/*  730 */         String imgExg = CommonUtils.getFileSuffix(file1.getOriginalFilename());
/*  731 */         picturePath1 = this.uploadService.uploadFile(file1.getInputStream(), imgExg);
/*  732 */         projectListing.setPicturePath1(picturePath1);
/*      */       }
/*  734 */       else if (StringUtils.isEmpty(projectListing.getTempPath1())) {
/*  735 */         this.uploadService.deleteOriginalFile(picturePath1);
/*  736 */         projectListing.setPicturePath1("");
/*      */       }
/*      */ 
/*  739 */       if ((file2 != null) && (file2.getSize() > 0L)) {
/*  740 */         if (StringUtils.isNotEmpty(picturePath2)) {
/*  741 */           this.uploadService.deleteOriginalFile(picturePath2);
/*      */         }
/*  743 */         String imgExg = CommonUtils.getFileSuffix(file2.getOriginalFilename());
/*  744 */         picturePath2 = this.uploadService.uploadFile(file2.getInputStream(), imgExg);
/*  745 */         projectListing.setPicturePath2(picturePath2);
/*      */       }
/*  747 */       else if (StringUtils.isEmpty(projectListing.getTempPath2())) {
/*  748 */         this.uploadService.deleteOriginalFile(picturePath2);
/*  749 */         projectListing.setPicturePath2("");
/*      */       }
/*      */ 
/*  752 */       if ((file3 != null) && (file3.getSize() > 0L)) {
/*  753 */         if (StringUtils.isNotEmpty(picturePath3)) {
/*  754 */           this.uploadService.deleteOriginalFile(picturePath3);
/*      */         }
/*  756 */         String imgExg = CommonUtils.getFileSuffix(file3.getOriginalFilename());
/*  757 */         picturePath3 = this.uploadService.uploadFile(file3.getInputStream(), imgExg);
/*  758 */         projectListing.setPicturePath3(picturePath3);
/*      */       }
/*  760 */       else if (StringUtils.isEmpty(projectListing.getTempPath3())) {
/*  761 */         this.uploadService.deleteOriginalFile(picturePath3);
/*  762 */         projectListing.setPicturePath3("");
/*      */       }
/*      */ 
/*  765 */       if ((file4 != null) && (file4.getSize() > 0L)) {
/*  766 */         if (StringUtils.isNotEmpty(picturePath4)) {
/*  767 */           this.uploadService.deleteOriginalFile(picturePath4);
/*      */         }
/*  769 */         String imgExg = CommonUtils.getFileSuffix(file4.getOriginalFilename());
/*  770 */         picturePath4 = this.uploadService.uploadFile(file4.getInputStream(), imgExg);
/*  771 */         projectListing.setPicturePath4(picturePath4);
/*      */       }
/*  773 */       else if (StringUtils.isEmpty(projectListing.getTempPath4())) {
/*  774 */         this.uploadService.deleteOriginalFile(picturePath4);
/*  775 */         projectListing.setPicturePath4("");
/*      */       }
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  780 */       this.log.error("", e);
/*      */     }
/*      */ 
/*  785 */     projectListing.setOperator(userAgent.getUserAccount());
/*      */ 
/*  788 */     List oldReceiverAccounts = new ArrayList();
/*  789 */     if (EnumTradingType.MULIT_BID_ORDER.getValue().equals(projectListing.getTradingType())) {
/*  790 */       ProjectMetas projectMetas = new ProjectMetas();
/*  791 */       projectMetas.setProjectId(projectListing.getId());
/*  792 */       projectMetas.setMetaKey(EnumMulitBidOrderProperty.REVIEWER_ACCOUNT.getKey());
/*  793 */       List _oldReceiverAccounts = new ArrayList();
/*  794 */       String reviewers = this.projectListingService.selectOneMetaValue(projectMetas);
/*  795 */       if (StringUtil.isNotEmpty(reviewers)) {
/*  796 */         _oldReceiverAccounts = Arrays.asList(reviewers.split(","));
/*  797 */         oldReceiverAccounts.addAll(_oldReceiverAccounts);
/*      */       } else {
/*  799 */         oldReceiverAccounts = null;
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  805 */     List oldAuctionerAccounts = new ArrayList();
/*  806 */     if (!EnumTradingType.PLACE_ORDER.getValue().equals(projectListing.getTradingType())) {
/*  807 */       ProjectMetas projectMetas = new ProjectMetas();
/*  808 */       projectMetas.setProjectId(projectListing.getId());
/*  809 */       projectMetas.setMetaKey(EnumBidOrderProperty.AUCTIONEER_ACCOUNT.getKey());
/*  810 */       List _oldAuctionerAccounts = new ArrayList();
/*  811 */       String auctionners = this.projectListingService.selectOneMetaValue(projectMetas);
/*  812 */       if (StringUtil.isNotEmpty(auctionners)) {
/*  813 */         _oldAuctionerAccounts = Arrays.asList(auctionners.split(","));
/*  814 */         oldAuctionerAccounts.addAll(_oldAuctionerAccounts);
/*      */       } else {
/*  816 */         oldAuctionerAccounts = null;
/*      */       }
/*      */     }
/*      */ 
/*  820 */     ProjectListingServiceResult result = new ProjectListingServiceResult();
/*      */     try {
/*  822 */       result = this.projectListingService.updateProjectListing(projectListing, tradeBo);
/*      */     } catch (Exception e) {
/*  824 */       result.setErrorNO(Integer.valueOf(EnumProjectListingResultErrors.SERVER_ERROR.getValue()));
/*  825 */       result.setErrorInfo(EnumProjectListingResultErrors.SERVER_ERROR.getInfo());
/*      */     }
/*      */ 
/*  828 */     if (result.correct())
/*      */     {
/*  831 */       if ((EnumTradingType.MULIT_BID_ORDER.getValue().equals(projectListing.getTradingType())) && (!EnumProjectStatus.AUDIT.getValue().equals(projectListing.getStatus())))
/*      */       {
/*  833 */         this.projectListingService.sendMessageToReviewers(oldReceiverAccounts, tradeBo, projectListing);
/*      */       }
/*      */ 
/*  836 */       if (EnumTradingType.BID_ORDER.getValue().equals(projectListing.getTradingType())) {
/*  837 */         this.projectListingService.sendMessageToAuctioners(oldAuctionerAccounts, tradeBo, projectListing);
/*      */       }
/*      */ 
/*  840 */       model.put("message", "修改挂牌资料操作 成功！");
/*  841 */       model.put("url", "/project/" + projectListing.getListingType() + "/list.htm");
/*      */     } else {
/*  843 */       model.put("message", "修改挂牌资料 失败 ，错误代码" + result.getErrorNO() + "，" + result.getErrorInfo());
/*      */     }
/*      */ 
/*  846 */     return result(result.correct());
/*      */   }
/*      */ 
/*      */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.PRO_U_PROJECT_LISTING_SUSPENSION})
/*      */   @RequestMapping(value={"/project/suspension"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*      */   public String suspension(@ModelAttribute("announcement") Announcement announcement, ModelMap model, UserAgent userAgent)
/*      */     throws Exception
/*      */   {
/*  859 */     ProjectListing projectListing = this.projectListingService.getProSimpInfo(announcement.getProjectId());
/*      */ 
/*  862 */     Long substationId = getSubstationId(userAgent);
/*      */ 
/*  864 */     if ((substationId != null) && (!substationId.equals(projectListing.getSubstationId()))) {
/*  865 */       return "accessDenied";
/*      */     }
/*      */ 
/*  869 */     if ((projectListing == null) || (!projectListing.isTrade())) {
/*  870 */       model.put("message", "操作失败！只能对挂牌成功,还没结束的项目进行停牌操作");
/*  871 */       model.put("url", "/project/" + projectListing.getListingType() + "/list.htm");
/*  872 */       return error(model);
/*      */     }
/*      */ 
/*  876 */     if ((StringUtil.isBlank(announcement.getTitle())) || (announcement.getTitle().length() > 160)) {
/*  877 */       model.put("message", "公告标题 请输入160以内字符");
/*  878 */       model.put("url", "/project/" + projectListing.getListingType() + "/list.htm");
/*  879 */       return error(model);
/*      */     }
/*      */ 
/*  883 */     if (StringUtil.isBlank(announcement.getContent())) {
/*  884 */       model.put("message", "公告内容 为必填项");
/*  885 */       model.put("url", "/project/" + projectListing.getListingType() + "/list.htm");
/*  886 */       return error(model);
/*      */     }
/*      */ 
/*  895 */     AnnouncementRequest request = createAnnouncementRequest(announcement, userAgent);
/*      */ 
/*  898 */     ServiceResult result = new ServiceResult();
/*      */     try {
/*  900 */       result = this.remoteProjectListingService.suspension(request);
/*      */     } catch (Exception e) {
/*  902 */       this.log.error("", e);
/*  903 */       result.setErrorNO(Integer.valueOf(EnumProjectListingResultErrors.SERVER_ERROR.getValue()));
/*  904 */       result.setErrorInfo(EnumProjectListingResultErrors.SERVER_ERROR.getInfo());
/*      */     }
/*      */ 
/*  907 */     if (result.correct())
/*      */     {
/*  909 */       if (!EnumTradingType.PLACE_ORDER.getValue().equals(projectListing.getTradingType())) {
/*      */         try {
/*  911 */           this.projectListingService.sendMessageToAuctionners(projectListing, EnumProjectStatus.SUSPENSION.getValue());
/*      */         } catch (Exception e) {
/*  913 */           this.log.error("send message to auctionners error when resumption, cause by:" + e);
/*      */         }
/*  915 */         if (EnumTradingType.MULIT_BID_ORDER.getValue().equals(projectListing.getTradingType())) {
/*      */           try {
/*  917 */             this.projectListingService.sendMessageToReviewers(projectListing, EnumProjectStatus.SUSPENSION.getValue());
/*      */           } catch (Exception e) {
/*  919 */             this.log.error("send message to reviewers error when resumption, cause by:" + e);
/*      */           }
/*      */         }
/*      */       }
/*  923 */       model.put("message", "停牌操作 成功！");
/*  924 */       model.put("url", "/project/" + projectListing.getListingType() + "/list.htm");
/*      */       try
/*      */       {
/*  928 */         UserAccount userAccount = this.userAccountService.getUserByAccount(projectListing.getUserAccount());
/*  929 */         List nums = new ArrayList();
/*  930 */         nums.add(userAccount.getMobile());
/*  931 */         String msg = "尊敬的" + userAccount.getName() + "您好，您的挂牌项目" + projectListing.getTitle() + "已停牌，请及时关注市场动态【中部林业产权交易服务中心】";
/*      */ 
/*  934 */         this.mobileMessageUtil.sendMsg(nums, msg);
/*      */       } catch (Exception e) {
/*  936 */         this.log.error("send mobileMessage for audit error cause by:" + e);
/*      */       }
/*      */     } else {
/*  939 */       model.put("message", "停牌操作 失败 ，错误代码" + result.getErrorNO() + "，" + result.getErrorInfo());
/*      */     }
/*      */ 
/*  942 */     return result(result.correct());
/*      */   }
/*      */ 
/*      */   private AnnouncementRequest createAnnouncementRequest(Announcement announcement, UserAgent userAgent)
/*      */   {
/*  948 */     AnnouncementRequest request = new AnnouncementRequest();
/*  949 */     AnnouncementDTO announcementDTO = new AnnouncementDTO();
/*  950 */     announcementDTO.setTitle(announcement.getTitle());
/*  951 */     announcementDTO.setContent(announcement.getContent());
/*      */ 
/*  953 */     announcementDTO.setType(EnumAnnouncementType.SYSTEM.getValue());
/*  954 */     announcementDTO.setProjectId(announcement.getProjectId());
/*      */ 
/*  956 */     announcementDTO.setCreatorType(EnumOperatorType.SYSTEM.getValue());
/*  957 */     announcementDTO.setCreator(userAgent.getUserAccount());
/*  958 */     request.setAnnouncementDTO(announcementDTO);
/*  959 */     return request;
/*      */   }
/*      */ 
/*      */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.PRO_U_PROJECT_LISTING_WITHDRAWAL})
/*      */   @RequestMapping(value={"/project/withdrawal"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*      */   public String withdrawal(@ModelAttribute("announcement") Announcement announcement, ModelMap model, UserAgent userAgent)
/*      */     throws Exception
/*      */   {
/*  972 */     ProjectListing projectListing = this.projectListingService.getProSimpInfo(announcement.getProjectId());
/*      */ 
/*  975 */     Long substationId = getSubstationId(userAgent);
/*      */ 
/*  977 */     if ((substationId != null) && (!substationId.equals(projectListing.getSubstationId()))) {
/*  978 */       return "accessDenied";
/*      */     }
/*      */ 
/*  982 */     if ((projectListing.isTrade()) || (projectListing.isSuspension()))
/*      */     {
/*  984 */       if ((StringUtil.isBlank(announcement.getTitle())) || (announcement.getTitle().length() > 160))
/*      */       {
/*  986 */         model.put("message", "公告标题 请输入160以内字符");
/*  987 */         model.put("url", "/project/" + projectListing.getListingType() + "/list.htm");
/*  988 */         return error(model);
/*      */       }
/*      */ 
/*  991 */       if (StringUtil.isBlank(announcement.getContent())) {
/*  992 */         model.put("message", "公告内容 为必填项");
/*  993 */         model.put("url", "/project/" + projectListing.getListingType() + "/list.htm");
/*  994 */         return error(model);
/*      */       }
/*      */ 
/* 1003 */       AnnouncementRequest request = createAnnouncementRequest(announcement, userAgent);
/*      */ 
/* 1006 */       ServiceResult result = new ServiceResult();
/*      */       try {
/* 1008 */         result = this.remoteProjectListingService.withdrawal(request);
/*      */       } catch (Exception e) {
/* 1010 */         result.setErrorNO(Integer.valueOf(EnumProjectListingResultErrors.SERVER_ERROR.getValue()));
/* 1011 */         result.setErrorInfo(EnumProjectListingResultErrors.SERVER_ERROR.getInfo());
/*      */       }
/* 1013 */       if (result.correct())
/*      */       {
/* 1015 */         if (!EnumTradingType.PLACE_ORDER.getValue().equals(projectListing.getTradingType())) {
/*      */           try {
/* 1017 */             this.projectListingService.sendMessageToAuctionners(projectListing, EnumProjectStatus.WITHDRAWAL.getValue());
/*      */           } catch (Exception e) {
/* 1019 */             this.log.error("send message to auctionners error when resumption, cause by:" + e);
/*      */           }
/* 1021 */           if (EnumTradingType.MULIT_BID_ORDER.getValue().equals(projectListing.getTradingType())) {
/*      */             try {
/* 1023 */               this.projectListingService.sendMessageToReviewers(projectListing, EnumProjectStatus.WITHDRAWAL.getValue());
/*      */             } catch (Exception e) {
/* 1025 */               this.log.error("send message to reviewers error when resumption, cause by:" + e);
/*      */             }
/*      */           }
/*      */         }
/* 1029 */         model.put("message", "撤牌操作 成功！");
/* 1030 */         model.put("url", "/project/" + projectListing.getListingType() + "/list.htm");
/*      */         try
/*      */         {
/* 1034 */           UserAccount userAccount = this.userAccountService.getUserByAccount(projectListing.getUserAccount());
/* 1035 */           List nums = new ArrayList();
/* 1036 */           nums.add(userAccount.getMobile());
/* 1037 */           String msg = "尊敬的" + userAccount.getName() + "您好，您的挂牌项目" + projectListing.getTitle() + "已撤牌，请及时关注市场动态【中部林业产权交易服务中心】";
/*      */ 
/* 1040 */           this.mobileMessageUtil.sendMsg(nums, msg);
/*      */         } catch (Exception e) {
/* 1042 */           this.log.error("send mobileMessage for audit error cause by:" + e);
/*      */         }
/*      */       } else {
/* 1045 */         model.put("message", "撤牌操作 失败 ，错误代码" + result.getErrorNO() + "，" + result.getErrorInfo());
/*      */       }
/*      */ 
/* 1048 */       return result(result.correct());
/*      */     }
/* 1050 */     model.put("message", "操作失败！只能对交易中或停牌中的项目进行撤牌操作");
/* 1051 */     model.put("url", "/project/" + projectListing.getListingType() + "/list.htm");
/* 1052 */     return error(model);
/*      */   }
/*      */ 
/*      */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.PRO_U_PROJECT_LISTING_RESUMPTION})
/*      */   @RequestMapping(value={"/project/resumption"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*      */   public String resumption(@ModelAttribute("announcement") Announcement announcement, ModelMap model, UserAgent userAgent)
/*      */     throws Exception
/*      */   {
/* 1067 */     ProjectListing projectListing = this.projectListingService.getProSimpInfo(announcement.getProjectId());
/*      */ 
/* 1070 */     Long substationId = getSubstationId(userAgent);
/*      */ 
/* 1072 */     if ((substationId != null) && (!substationId.equals(projectListing.getSubstationId()))) {
/* 1073 */       return "accessDenied";
/*      */     }
/*      */ 
/* 1076 */     if ((projectListing == null) || (!projectListing.isSuspension())) {
/* 1077 */       model.put("message", "操作失败！只能对停牌的项目进行复牌操作");
/* 1078 */       model.put("url", "/project/" + projectListing.getListingType() + "/list.htm");
/* 1079 */       return error(model);
/*      */     }
/*      */ 
/* 1082 */     if ((EnumTradingType.BID_ORDER.getValue().equals(projectListing.getTradingType())) || (EnumTradingType.MULIT_BID_ORDER.getValue().equals(projectListing.getTradingType())))
/*      */     {
/* 1085 */       ProjectMetas projectMetas = new ProjectMetas();
/* 1086 */       projectMetas.setProjectId(announcement.getProjectId());
/* 1087 */       projectMetas.setMetaKey("bidStartTime");
/* 1088 */       String bidStartTimeStr = this.projectListingService.selectOneMetaValue(projectMetas);
/* 1089 */       if (bidStartTimeStr != null) {
/* 1090 */         Date bidStartTime = DateUtil.convertStringToDate("yyyy-MM-dd HH:mm:ss", bidStartTimeStr);
/*      */ 
/* 1092 */         Calendar currentTime = DateUtil.getCurrentDay();
/* 1093 */         currentTime.add(12, 5);
/* 1094 */         if ((bidStartTime == null) || (currentTime.getTime().after(bidStartTime))) {
/* 1095 */           model.put("message", "竞价开始时间 至少要在5分钟之后，请先修改 竞价开始时间");
/* 1096 */           model.put("url", "/project/" + projectListing.getListingType() + "/list.htm");
/* 1097 */           return error(model);
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/* 1102 */     if ((StringUtil.isBlank(announcement.getTitle())) || (announcement.getTitle().length() > 160)) {
/* 1103 */       model.put("message", "公告标题 请输入160以内字符");
/* 1104 */       model.put("url", "/project/" + projectListing.getListingType() + "/list.htm");
/* 1105 */       return error(model);
/*      */     }
/*      */ 
/* 1108 */     if (StringUtil.isBlank(announcement.getContent())) {
/* 1109 */       model.put("message", "公告内容 为必填项");
/* 1110 */       model.put("url", "/project/" + projectListing.getListingType() + "/list.htm");
/* 1111 */       return error(model);
/*      */     }
/*      */ 
/* 1120 */     AnnouncementRequest request = createAnnouncementRequest(announcement, userAgent);
/*      */ 
/* 1123 */     ServiceResult result = new ServiceResult();
/*      */     try {
/* 1125 */       result = this.remoteProjectListingService.resumption(request);
/*      */     } catch (Exception e) {
/* 1127 */       result.setErrorNO(Integer.valueOf(EnumProjectListingResultErrors.SERVER_ERROR.getValue()));
/* 1128 */       result.setErrorInfo(EnumProjectListingResultErrors.SERVER_ERROR.getInfo());
/*      */     }
/*      */ 
/* 1131 */     if (result.correct())
/*      */     {
/*      */       try {
/* 1134 */         if ((EnumTradingType.BID_ORDER.getValue().equals(projectListing.getTradingType())) || (EnumTradingType.MULIT_BID_ORDER.getValue().equals(projectListing.getTradingType())))
/*      */         {
/* 1136 */           this.auctionActiveService.activeAuctionProjectsBatch();
/* 1137 */         } else if ((EnumTradingType.TRANSFER_ORDER.getValue().equals(projectListing.getTradingType())) || (EnumTradingType.TENDER_ORDER.getValue().equals(projectListing.getTradingType())))
/*      */         {
/* 1139 */           this.auctionActiveService.activeTransferProjectsBatch();
/* 1140 */           this.auctionActiveService.activeTenderProjectsBatch();
/*      */         }
/*      */       } catch (Exception e) {
/* 1143 */         e.printStackTrace();
/* 1144 */         this.log.error("resumption internal success, but active hall error:", e);
/* 1145 */         model.put("message", EnumProjectListingResultErrors.ACTIVE_HALL_ERROR.getInfo());
/* 1146 */         model.put("url", "/timerTask/auctionActive.htm");
/* 1147 */         model.put("buttonName", "手动激活");
/* 1148 */         return "waring";
/*      */       }
/*      */ 
/* 1151 */       if (!EnumTradingType.PLACE_ORDER.getValue().equals(projectListing.getTradingType())) {
/*      */         try {
/* 1153 */           this.projectListingService.sendMessageToAuctionners(projectListing, EnumProjectStatus.TRADE.getValue());
/*      */         } catch (Exception e) {
/* 1155 */           this.log.error("send message to auctionners error when resumption, cause by:" + e);
/*      */         }
/* 1157 */         if (EnumTradingType.MULIT_BID_ORDER.getValue().equals(projectListing.getTradingType())) {
/*      */           try {
/* 1159 */             this.projectListingService.sendMessageToReviewers(projectListing, EnumProjectStatus.TRADE.getValue());
/*      */           } catch (Exception e) {
/* 1161 */             this.log.error("send message to reviewers error when resumption, cause by:" + e);
/*      */           }
/*      */         }
/*      */       }
/* 1165 */       model.put("message", "复牌操作 成功！");
/* 1166 */       model.put("url", "/project/" + projectListing.getListingType() + "/list.htm");
/*      */       try
/*      */       {
/* 1170 */         UserAccount userAccount = this.userAccountService.getUserByAccount(projectListing.getUserAccount());
/* 1171 */         List nums = new ArrayList();
/* 1172 */         nums.add(userAccount.getMobile());
/* 1173 */         String msg = "尊敬的" + userAccount.getName() + "您好，您的挂牌项目" + projectListing.getTitle() + "已复牌，请及时关注交易动态【中部林业产权交易服务中心】";
/*      */ 
/* 1176 */         this.mobileMessageUtil.sendMsg(nums, msg);
/*      */       } catch (Exception e) {
/* 1178 */         this.log.error("send mobileMessage for audit error cause by:" + e);
/*      */       }
/*      */     } else {
/* 1181 */       model.put("message", "复牌操作 失败 ，错误代码" + result.getErrorNO() + "，" + result.getErrorInfo());
/*      */     }
/*      */ 
/* 1184 */     return result(result.correct());
/*      */   }
/*      */ 
/*      */   private List<TradeShowDTO> copyProjectMetasList2TradeShowDTOList(List<ProjectMetas> pMetas) {
/* 1188 */     List tradeShowDTOList = new ArrayList();
/* 1189 */     for (ProjectMetas projectMetas : pMetas) {
/* 1190 */       tradeShowDTOList.add(copyProjectMetas2TradeShowDTO(projectMetas));
/*      */     }
/* 1192 */     return tradeShowDTOList;
/*      */   }
/*      */ 
/*      */   private TradeShowDTO copyProjectMetas2TradeShowDTO(ProjectMetas projectMetas) {
/* 1196 */     TradeShowDTO tradeShowDTO = new TradeShowDTO();
/* 1197 */     tradeShowDTO.setInputValue(projectMetas.getMetaValue());
/* 1198 */     tradeShowDTO.setKey(projectMetas.getMetaKey());
/* 1199 */     tradeShowDTO.setLength(Integer.valueOf(1024));
/* 1200 */     tradeShowDTO.setName(projectMetas.getMetaTitle());
/* 1201 */     tradeShowDTO.setShowType(projectMetas.getInputType());
/* 1202 */     return tradeShowDTO;
/*      */   }
/*      */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.action.project.ProjectListingAction
 * JD-Core Version:    0.6.0
 */