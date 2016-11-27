/*      */ package com.hundsun.network.hseccms.admin.action;
/*      */ 
/*      */ import com.hundsun.eclp.client.common.GenericUserAgent;
/*      */ import com.hundsun.network.file.client.request.FileRequest;
/*      */ import com.hundsun.network.file.client.result.FileBatchResult;
/*      */ import com.hundsun.network.file.client.service.FileService;
/*      */ import com.hundsun.network.hseccms.admin.security.SettlerAccess;
/*      */ import com.hundsun.network.hseccms.admin.security.SettlerAgent;
/*      */ import com.hundsun.network.hseccms.admin.util.Cms2Utils;
/*      */ import com.hundsun.network.hseccms.enums.EnumAttachStatus;
/*      */ import com.hundsun.network.hseccms.enums.EnumAttachType;
/*      */ import com.hundsun.network.hseccms.enums.EnumContCurrentStatus;
/*      */ import com.hundsun.network.hseccms.enums.EnumContIsBold;
/*      */ import com.hundsun.network.hseccms.enums.EnumContIsRejected;
/*      */ import com.hundsun.network.hseccms.enums.EnumContOrderByMethod;
/*      */ import com.hundsun.network.hseccms.enums.EnumContOrderCondition;
/*      */ import com.hundsun.network.hseccms.enums.EnumContStatus;
/*      */ import com.hundsun.network.hseccms.enums.EnumJobTimingObj;
/*      */ import com.hundsun.network.hseccms.enums.EnumJobTimingType;
/*      */ import com.hundsun.network.hseccms.enums.EnumModelHasContent;
/*      */ import com.hundsun.network.hseccms.enums.EnumSiteOverReview;
/*      */ import com.hundsun.network.hseccms.enums.EnumStaticOper;
/*      */ import com.hundsun.network.hseccms.enums.EnumStaticType;
/*      */ import com.hundsun.network.hseccms.model.Cms2Attach;
/*      */ import com.hundsun.network.hseccms.model.Cms2Channel;
/*      */ import com.hundsun.network.hseccms.model.Cms2ChannelExt;
/*      */ import com.hundsun.network.hseccms.model.Cms2ChannelUser;
/*      */ import com.hundsun.network.hseccms.model.Cms2Cont;
/*      */ import com.hundsun.network.hseccms.model.Cms2ContAll;
/*      */ import com.hundsun.network.hseccms.model.Cms2ContCheck;
/*      */ import com.hundsun.network.hseccms.model.Cms2ContExt;
/*      */ import com.hundsun.network.hseccms.model.Cms2Job;
/*      */ import com.hundsun.network.hseccms.model.Cms2JobTiming;
/*      */ import com.hundsun.network.hseccms.model.Cms2Model;
/*      */ import com.hundsun.network.hseccms.model.Cms2Site;
/*      */ import com.hundsun.network.hseccms.model.Cms2UserSite;
/*      */ import com.hundsun.network.hseccms.query.Cms2ChannelUserQuery;
/*      */ import com.hundsun.network.hseccms.query.Cms2ContCheckQuery;
/*      */ import com.hundsun.network.hseccms.query.Cms2ContQuery;
/*      */ import com.hundsun.network.hseccms.query.Cms2JobTimingQuery;
/*      */ import com.hundsun.network.hseccms.query.Cms2UserSiteQuery;
/*      */ import com.hundsun.network.hseccms.service.Cms2ChannelExtService;
/*      */ import com.hundsun.network.hseccms.service.Cms2ChannelService;
/*      */ import com.hundsun.network.hseccms.service.Cms2ChannelUserService;
/*      */ import com.hundsun.network.hseccms.service.Cms2ContCheckService;
/*      */ import com.hundsun.network.hseccms.service.Cms2ContService;
/*      */ import com.hundsun.network.hseccms.service.Cms2JobService;
/*      */ import com.hundsun.network.hseccms.service.Cms2JobTimingService;
/*      */ import com.hundsun.network.hseccms.service.Cms2ModelItemService;
/*      */ import com.hundsun.network.hseccms.service.Cms2ModelService;
/*      */ import com.hundsun.network.hseccms.service.Cms2SiteService;
/*      */ import com.hundsun.network.hseccms.service.Cms2UserSiteService;
/*      */ import com.hundsun.network.hseccms.util.editor.ResourceType;
/*      */ import com.hundsun.network.melody.common.util.StringUtil;
/*      */ import com.hundsun.network.melody.common.web.url.URLBroker;
/*      */ import com.hundsun.network.melody.common.web.url.URLConfig;
/*      */ import java.text.DateFormat;
/*      */ import java.text.ParseException;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Date;
/*      */ import java.util.List;
/*      */ import javax.servlet.http.HttpServletRequest;
/*      */ import org.apache.commons.lang.StringUtils;
/*      */ import org.apache.commons.logging.Log;
/*      */ import org.springframework.beans.factory.annotation.Autowired;
/*      */ import org.springframework.beans.factory.annotation.Value;
/*      */ import org.springframework.beans.propertyeditors.CustomDateEditor;
/*      */ import org.springframework.stereotype.Controller;
/*      */ import org.springframework.ui.Model;
/*      */ import org.springframework.web.bind.ServletRequestDataBinder;
/*      */ import org.springframework.web.bind.annotation.InitBinder;
/*      */ import org.springframework.web.bind.annotation.ModelAttribute;
/*      */ import org.springframework.web.bind.annotation.RequestMapping;
/*      */ import org.springframework.web.bind.annotation.RequestParam;
/*      */ import org.springframework.web.bind.annotation.ResponseBody;
/*      */ 
/*      */ @Controller
/*      */ public class ContAction extends BaseAction
/*      */ {
/*      */ 
/*      */   @Value("${file.server.url}")
/*      */   private String fileServerUrl;
/*      */ 
/*      */   @Value("${file.sysCode}")
/*      */   private String sysCode;
/*      */ 
/*      */   @Value("${file.bizRule}")
/*      */   private String bizRule;
/*      */ 
/*      */   @Value("${use.fileUploadSystem}")
/*      */   private boolean useFileUploadSystem;
/*      */ 
/*      */   @Value("${resSys}")
/*      */   private String resSys;
/*      */ 
/*      */   @Autowired
/*      */   private URLBroker uploadServerBroker;
/*      */ 
/*      */   @Autowired
/*      */   private Cms2ContService cms2ContService;
/*      */ 
/*      */   @Autowired
/*      */   private Cms2ChannelService cms2ChannelService;
/*      */ 
/*      */   @Autowired
/*      */   private Cms2ModelService cms2ModelService;
/*      */ 
/*      */   @Autowired
/*      */   private Cms2ModelItemService cms2ModelItemService;
/*      */ 
/*      */   @Autowired
/*      */   private Cms2SiteService cms2SiteService;
/*      */ 
/*      */   @Autowired
/*      */   FileService fileService;
/*      */ 
/*      */   @Autowired
/*      */   private Cms2ChannelUserService cms2ChannelUserService;
/*      */ 
/*      */   @Autowired
/*      */   private Cms2UserSiteService cms2UserSiteService;
/*      */ 
/*      */   @Autowired
/*      */   private Cms2ContCheckService cms2ContCheckService;
/*      */ 
/*      */   @Autowired
/*      */   private Cms2ChannelExtService cms2ChannelExtService;
/*      */ 
/*      */   @Autowired
/*      */   private Cms2JobService cms2JobService;
/*      */ 
/*      */   @Autowired
/*      */   private Cms2JobTimingService cms2JobTimingService;
/*      */ 
/*      */   @InitBinder
/*      */   protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder)
/*      */     throws Exception
/*      */   {
/*  111 */     DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*  112 */     dateFormat.setLenient(false);
/*  113 */     binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
/*      */   }
/*      */ 
/*      */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.CONT_MANAGE})
/*      */   @RequestMapping({"/cont/index"})
/*      */   public String index(Model model)
/*      */   {
/*  151 */     return "/cont/index";
/*      */   }
/*  157 */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.CONT_MANAGE})
/*      */   @RequestMapping({"/cont/tree"})
/*      */   public String tree(Model model, HttpServletRequest request) { Long siteId = Cms2Utils.getCurrentSiteId(request);
/*  158 */     Cms2Site site = this.cms2SiteService.queryById(siteId);
/*  159 */     List list = this.cms2ChannelService.getWholeTreeBySite(site.getId());
/*  160 */     model.addAttribute("list", list);
/*  161 */     return "/cont/tree"; }
/*      */ 
/*      */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.CONT_MANAGE})
/*      */   @RequestMapping({"/cont/list"})
/*      */   public String list(@RequestParam(value="q", required=false, defaultValue="") String queryStr, Model model, HttpServletRequest request, Cms2ContQuery query, SettlerAgent settlerAgent)
/*      */   {
/*  169 */     if (StringUtil.isNotEmpty(queryStr)) {
/*  170 */       query = (Cms2ContQuery)query.riseUp(queryStr);
/*      */     }
/*      */ 
/*  173 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/*  174 */     Cms2Site site = this.cms2SiteService.queryById(siteId);
/*      */ 
/*  176 */     List currentStatusList = getUserStatus(site.getId(), Long.valueOf(settlerAgent.getId()));
/*  177 */     if ((null == query.getCurrentStatus()) || (query.getCurrentStatus().equals(""))) {
/*  178 */       if (currentStatusList.size() == EnumContCurrentStatus.enumCounts()) {
/*  179 */         query.setCurrentStatus(EnumContCurrentStatus.AUDITING.getCode().toString());
/*      */       } else {
/*  181 */         String adminName = StringUtil.isNotBlank(settlerAgent.getName()) ? settlerAgent.getName() : settlerAgent.getUserAccount();
/*  182 */         query.setAdminName(adminName);
/*  183 */         query.setCurrentStatus(EnumContCurrentStatus.DRAFT.getCode().toString());
/*      */       }
/*      */     }
/*  186 */     query.setOverReview(site.getOverReview());
/*  187 */     query.setUserId(Long.valueOf(settlerAgent.getId()));
/*  188 */     dealContStatus(query);
/*  189 */     if ((query != null) && (StringUtil.isNotBlank(query.getAdminName()))) {
/*  190 */       query.setMemberName(query.getAdminName());
/*      */     }
/*  192 */     String selectEndDate = null;
/*  193 */     if (StringUtil.isNotBlank(query.getReleaseDateEnd())) {
/*  194 */       selectEndDate = query.getReleaseDateEnd();
/*  195 */       query.setReleaseDateEnd(new StringBuilder().append(query.getReleaseDateEnd()).append(" 23:59:59").toString());
/*      */     }
/*      */ 
/*  198 */     if (StringUtil.isBlank(query.getOrderCondition()))
/*      */     {
/*  200 */       query.setOrderBy(EnumContOrderCondition.GMT_MODIFY.getContAttrName());
/*  201 */       query.setOrderAsc(EnumContOrderByMethod.DESC.getValue());
/*  202 */       query.setOrderCondition(EnumContOrderCondition.GMT_MODIFY.getContAttrName());
/*  203 */       query.setOrderMethod(EnumContOrderByMethod.DESC.getValue());
/*      */     }
/*      */     else {
/*  206 */       if (StringUtil.isBlank(query.getOrderMethod()))
/*  207 */         query.setOrderAsc(EnumContOrderByMethod.DESC.getValue());
/*      */       else {
/*  209 */         query.setOrderAsc(query.getOrderMethod());
/*      */       }
/*  211 */       if (EnumContOrderCondition.COPYWRITER.getContAttrName().equalsIgnoreCase(query.getOrderCondition())) {
/*  212 */         if (EnumContOrderByMethod.DESC.getValue().equalsIgnoreCase(query.getOrderAsc()))
/*  213 */           query.setOrderBy(new StringBuilder().append(" CONT.ADMIN_NAME ").append(query.getOrderAsc()).append(", CONT.MEMBER_NAME ").toString());
/*      */         else
/*  215 */           query.setOrderBy(new StringBuilder().append(" CONT.MEMBER_NAME ").append(query.getOrderAsc()).append(", CONT.ADMIN_NAME ").toString());
/*      */       }
/*  217 */       else query.setOrderBy(query.getOrderCondition());
/*      */     }
/*      */ 
/*  220 */     query = this.cms2ContService.selectPageAdmin(query);
/*  221 */     List channelIdList = new ArrayList();
/*  222 */     List<Cms2Cont> contList = (List<Cms2Cont>) query.getItems();
/*      */     Cms2ContCheckQuery contCheckQuery;
/*      */     List cms2ContCheckList;
/*  223 */     if ((null != contList) && (contList.size() > 0)) {
/*  224 */       contCheckQuery = new Cms2ContCheckQuery();
/*  225 */       cms2ContCheckList = null;
/*  226 */       for (Cms2Cont cont : contList) {
/*  227 */         channelIdList.add(cont.getChannelId());
/*  228 */         contCheckQuery.setContentId(cont.getId().toString());
/*  229 */         cms2ContCheckList = this.cms2ContCheckService.queryCms2ContCheckList(contCheckQuery);
/*  230 */         if ((cms2ContCheckList != null) && (cms2ContCheckList.size() > 0))
/*  231 */           cont.setContCheck((Cms2ContCheck)cms2ContCheckList.get(0));
/*  232 */         cont.setUserFinalStep(getUserFinalStep(cont.getChannelId(), cont.getSiteId(), Long.valueOf(settlerAgent.getId())));
/*  233 */         cont.setChannelFinalStep(getChannelFinalStep(cont.getChannelId(), cont.getSiteId()));
/*  234 */         cont.setSite(site);
/*  235 */         cont.setCurrentStatus(query.getCurrentStatus());
/*      */       }
/*      */     }
/*  238 */     List channelList = new ArrayList();
/*  239 */     if ((null != channelIdList) && (channelIdList.size() > 0)) {
/*  240 */       channelList = this.cms2ChannelService.queryChannelListByIds(channelIdList);
/*      */     }
/*  242 */     Cms2Channel channel = new Cms2Channel();
/*  243 */     if ((null != query.getChannelId()) && (!query.getChannelId().equals(""))) {
/*  244 */       channel = this.cms2ChannelService.queryById(Long.valueOf(Long.parseLong(query.getChannelId())));
/*      */ 
/*  246 */       boolean hasChild = false;
/*  247 */       if (!hasChild) {
/*  248 */         Cms2Model cmsModel = this.cms2ModelService.queryById(channel.getModelId());
/*  249 */         model.addAttribute("model", cmsModel);
/*      */       }
/*  251 */       model.addAttribute("hasChild", Boolean.valueOf(hasChild));
/*      */     }
/*  253 */     if (StringUtil.isNotBlank(query.getReleaseDateEnd())) {
/*  254 */       query.setReleaseDateEnd(selectEndDate);
/*      */     }
/*  256 */     model.addAttribute("isCycle", Boolean.valueOf(EnumContStatus.CYCLE.getCode().toString().equals(query.getStatus())));
/*  257 */     model.addAttribute("channel", channel);
/*  258 */     model.addAttribute("query", query);
/*  259 */     model.addAttribute("q", queryStr);
/*  260 */     model.addAttribute("channelList", channelList);
/*  261 */     model.addAttribute("wholeChannelList", this.cms2ChannelService.getWholeTreeBySite(siteId));
/*  262 */     model.addAttribute("statusList", currentStatusList);
/*      */ 
/*  264 */     model.addAttribute("orderCondition", EnumContOrderCondition.toList());
/*  265 */     model.addAttribute("orderMethod", EnumContOrderByMethod.toList());
/*  266 */     return "/cont/list";
/*      */   }
/*      */ 
/*      */   private void dealContStatus(Cms2ContQuery query)
/*      */   {
/*  273 */     short currentStatus = Short.parseShort(query.getCurrentStatus());
/*  274 */     if (currentStatus == 0)
/*  275 */       return;
/*  276 */     switch (currentStatus) { case 1:
/*  277 */       query.setStatus(EnumContStatus.DRAFT.getCode().toString()); break;
/*      */     case 5:
/*  278 */       query.setStatus(EnumContStatus.FINISH.getCode().toString()); break;
/*      */     case 7:
/*  279 */       query.setStatus(EnumContStatus.CYCLE.getCode().toString()); break;
/*      */     default:
/*  280 */       query.setStatus(EnumContStatus.AUDITING.getCode().toString());
/*      */     }
/*  282 */     if (EnumContCurrentStatus.REJECT.getCode().equals(Short.valueOf(currentStatus)))
/*  283 */       query.setIsRejected(EnumContIsRejected.REJECTED.getCode().toString());
/*      */     else
/*  285 */       query.setIsRejected(EnumContIsRejected.NOT_REJECTED.getCode().toString());
/*      */   }
/*      */ 
/*      */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.CONT_ADD})
/*      */   @RequestMapping({"/cont/add"})
/*      */   public String add(@RequestParam(value="q", required=false, defaultValue="") String queryStr, Model model, HttpServletRequest request, @ModelAttribute("titleImg") Cms2Attach articleTitleImg, @ModelAttribute("contImg") Cms2Attach articleContImg, @RequestParam("channelId") Long channelId, GenericUserAgent admin, SettlerAgent cmsAgent)
/*      */   {
/*  294 */     model.addAttribute("q", queryStr);
/*  295 */     this._log.debug("========    in ContAction.add()!!! ========");
/*  296 */     Cms2Channel channel = null;
/*  297 */     if (channelId != null) {
/*  298 */       channel = this.cms2ChannelService.queryById(channelId);
/*      */     }
/*      */ 
/*  301 */     Cms2Model cmsModel = null;
/*  302 */     if (channel != null) {
/*  303 */       cmsModel = this.cms2ModelService.queryById(channel.getModelId());
/*  304 */       String com_message = null;
/*  305 */       if (new Integer(2).equals(cmsModel.getHasContent())) {
/*  306 */         com_message = "该栏目下不允许存在内容";
/*      */       }
/*  308 */       if (new Integer(0).equals(cmsModel.getHasContent())) {
/*  309 */         Cms2ContQuery query = new Cms2ContQuery();
/*  310 */         query.setChannelId(channelId.toString());
/*  311 */         query.setIsHide("1");
/*  312 */         List contentList = this.cms2ContService.selectList(query);
/*  313 */         if (contentList.size() >= 1)
/*  314 */           com_message = "该栏目下已存在文章或文章已放入回收站";
/*      */       }
/*  316 */       if (!StringUtil.isBlank(com_message))
/*  317 */         return error(model, com_message, "", request.getHeader("Referer"));
/*      */     }
/*      */     else {
/*  320 */       cmsModel = this.cms2ModelService.queryById(Long.valueOf(999L));
/*  321 */       if (cmsModel == null) {
/*  322 */         return error(model, "默认模板找不到", "", request.getHeader("Referer"));
/*      */       }
/*      */     }
/*      */ 
/*  326 */     List itemList = this.cms2ModelItemService.getItemListForContent(cmsModel.getId());
/*      */ 
/*  328 */     List channelList = new ArrayList();
/*  329 */     channelList.add(channel);
/*  330 */     model.addAttribute("cmsModel", cmsModel);
/*  331 */     model.addAttribute("itemList", itemList);
/*  332 */     model.addAttribute("channelList", channelList);
/*  333 */     model.addAttribute("channelId", channelId);
/*  334 */     model.addAttribute("channel", channel);
/*  335 */     Cms2ContAll cont = new Cms2ContAll();
/*  336 */     cont.setChannelId(channelId);
/*      */ 
/*  338 */     cont.setArticleAttachs(new ArrayList());
/*  339 */     cont.setArticlePics(new ArrayList());
/*  340 */     model.addAttribute("cont", cont);
/*  341 */     model.addAttribute("fileServerUrl", this.fileServerUrl);
/*  342 */     model.addAttribute("sysCode", this.sysCode);
/*  343 */     model.addAttribute("bizRule", this.bizRule);
/*  344 */     if (this.useFileUploadSystem)
/*      */     {
/*  346 */       FileRequest batchRequest = new FileRequest();
/*  347 */       batchRequest.setSysCode(this.sysCode);
/*  348 */       FileBatchResult batchResult = this.fileService.getBatch(batchRequest);
/*  349 */       if (batchResult.isError())
/*  350 */         model.addAttribute("message", "文件上传批次获取失败");
/*      */       else {
/*  352 */         model.addAttribute("batchId", batchResult.getBatchId());
/*      */       }
/*      */     }
/*  355 */     ResourceType type = ResourceType.getDefaultResourceTypeByExtName("jpg");
/*  356 */     model.addAttribute("resource", type.getPath());
/*  357 */     return "cont/add";
/*      */   }
/*      */ 
/*      */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.CONT_ADD, com.hundsun.network.hseccms.admin.security.PermissionEnum.CONT_EDIT})
/*      */   @RequestMapping({"/cont/save"})
/*      */   public String save(@RequestParam(value="q", required=false, defaultValue="") String queryStr, Model model, HttpServletRequest request, Cms2ContAll cont, @RequestParam(value="draft", required=false) Boolean draft, @RequestParam(value="bold", required=false) Boolean bold, @RequestParam(value="batchId", required=false) Long batchId, SettlerAgent cmsAgent, Cms2ContQuery query)
/*      */   {
/*  367 */     model.addAttribute("q", queryStr);
/*  368 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/*  369 */     if ((siteId == null) || (!siteId.equals(siteId))) {
/*  370 */       return super.error(model, "", "", null);
/*      */     }
/*  372 */     cont.setSiteId(siteId);
/*  373 */     if ((bold != null) && (bold.booleanValue()))
/*  374 */       cont.setIsBold(EnumContIsBold.TRUE.getCode());
/*      */     else {
/*  376 */       cont.setIsBold(EnumContIsBold.FALSE.getCode());
/*      */     }
/*      */ 
/*  380 */     if (StringUtil.isNotBlank(cont.getSortDateStr())) {
/*  381 */       DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*      */       try {
/*  383 */         cont.setSortDate(dateFormat.parse(cont.getSortDateStr()));
/*      */       } catch (ParseException e) {
/*  385 */         return super.error(model, "排序时间格式不正确", "", "/cont/list.htm");
/*      */       }
/*      */     }
/*      */ 
/*  389 */     Long userFinalStep = getUserFinalStep(cont.getChannelId(), siteId, Long.valueOf(cmsAgent.getId()));
/*  390 */     Long sysFinalStep = getChannelFinalStep(cont.getChannelId(), siteId);
/*      */ 
/*  392 */     draft = Boolean.valueOf(draft == null ? true : draft.booleanValue());
/*  393 */     if ((cont.getStatus() == null) || (!draft.booleanValue())) {
/*  394 */       if ((draft != null) && (draft.booleanValue())) {
/*  395 */         cont.setStatus(EnumContStatus.DRAFT.getCode());
/*      */ 
/*  397 */         cont.setModifyTime(null);
/*      */       }
/*      */       else {
/*  400 */         if (userFinalStep == null) userFinalStep = Long.valueOf(0L);
/*      */ 
/*  402 */         if (userFinalStep.compareTo(sysFinalStep) < 0) {
/*  403 */           cont.setStatus(EnumContStatus.AUDITING.getCode());
/*      */ 
/*  405 */           cont.setModifyTime(null);
/*      */         } else {
/*  407 */           cont.setStatus(EnumContStatus.FINISH.getCode());
/*      */ 
/*  409 */           cont.setModifyTime(new Date());
/*      */         }
/*  411 */         if ((userFinalStep == null) || (userFinalStep.compareTo(Long.valueOf(0L)) <= 0)) {
/*  412 */           cont.setModifyTime(new Date());
/*      */         }
/*      */       }
/*      */     }
/*  416 */     if (cont.getTopLevel() == null)
/*  417 */       cont.setTopLevel(Integer.valueOf(0));
/*  418 */     if ((cont.getContExt() != null) && (cont.getContExt().getReleaseDate() == null))
/*  419 */       cont.getContExt().setReleaseDate(new Date());
/*  420 */     String message = "";
/*  421 */     cont = transforAllAttach(cont, request);
/*  422 */     if (null == cont.getId()) {
/*  423 */       cont.setAdminId(Long.valueOf(cmsAgent.getId()));
/*  424 */       String adminName = StringUtil.isNotBlank(cmsAgent.getName()) ? cmsAgent.getName() : cmsAgent.getUserAccount();
/*  425 */       cont.setAdminName(adminName);
/*  426 */       message = this.cms2ContService.save(cont);
/*  427 */       if (message.equals("")) {
/*  428 */         message = "增加成功!";
/*  429 */         super.addLog(request, cmsAgent, Cms2Utils.getCurrentSiteId(request), "文章增加", cont.getId().toString(), cont.getTitle());
/*      */       } else {
/*  431 */         return super.error(model, message, "", "/cont/list.htm");
/*      */       }
/*      */     } else {
/*  434 */       this.cms2ContService.update(cont);
/*  435 */       if (message.equals("")) {
/*  436 */         message = "修改成功!";
/*  437 */         super.addLog(request, cmsAgent, Cms2Utils.getCurrentSiteId(request), "文章修改", cont.getId().toString(), cont.getTitle());
/*      */       } else {
/*  439 */         return super.error(model, message, "", "/cont/list.htm");
/*      */       }
/*      */     }
/*      */ 
/*  443 */     Cms2ContCheckQuery contCheckQuery = new Cms2ContCheckQuery();
/*  444 */     contCheckQuery.setContentId(cont.getId().toString());
/*  445 */     List cms2ContCheckList = this.cms2ContCheckService.queryCms2ContCheckList(contCheckQuery);
/*  446 */     if ((cms2ContCheckList != null) && (cms2ContCheckList.size() > 0)) {
/*  447 */       if ((draft != null) && (!draft.booleanValue())) {
/*  448 */         Cms2ContCheck cms2ContCheck = (Cms2ContCheck)cms2ContCheckList.get(0);
/*  449 */         if (userFinalStep == null)
/*  450 */           userFinalStep = Long.valueOf(0L);
/*  451 */         else if (userFinalStep.compareTo(sysFinalStep) > 0) {
/*  452 */           userFinalStep = sysFinalStep;
/*      */         }
/*  454 */         cms2ContCheck.setCheckOpinion("");
/*  455 */         cms2ContCheck.setCheckStep(userFinalStep);
/*  456 */         cms2ContCheck.setIsRejected(EnumContIsRejected.NOT_REJECTED.getCode());
/*  457 */         this.cms2ContCheckService.updateByAllProperity(cms2ContCheck);
/*      */       }
/*      */ 
/*  461 */       Cms2Job cms2Job = new Cms2Job(siteId, EnumStaticType.CONTENT_STATIC.getType(), cont.getId(), EnumStaticOper.MODIFY_STATIC.getType(), Long.valueOf(0L), "", null);
/*  462 */       this.cms2JobService.save(cms2Job);
/*      */ 
/*  465 */       Cms2JobTiming cms2JobStartTiming = new Cms2JobTiming(siteId, EnumJobTimingObj.OBJ_TYPE_CONTENT.getType(), cont.getId(), cont.getReleaseDate(), EnumJobTimingType.OBJ_OPER_START_TIME.getType());
/*  466 */       this.cms2JobTimingService.save(cms2JobStartTiming);
/*      */     } else {
/*  468 */       Cms2ContCheck contCheck = new Cms2ContCheck();
/*  469 */       if ((draft != null) && (!draft.booleanValue())) {
/*  470 */         if (userFinalStep == null)
/*  471 */           userFinalStep = Long.valueOf(0L);
/*  472 */         else if (userFinalStep.compareTo(sysFinalStep) > 0)
/*  473 */           userFinalStep = sysFinalStep;
/*      */       }
/*      */       else {
/*  476 */         userFinalStep = Long.valueOf(0L);
/*      */       }
/*  478 */       contCheck.setCheckStep(userFinalStep);
/*  479 */       contCheck.setIsRejected(EnumContIsRejected.NOT_REJECTED.getCode());
/*  480 */       contCheck.setContentId(cont.getId());
/*  481 */       this.cms2ContCheckService.insert(contCheck);
/*      */ 
/*  484 */       Cms2Job cms2Job = new Cms2Job(siteId, EnumStaticType.CONTENT_STATIC.getType(), cont.getId(), EnumStaticOper.ADD_STATIC.getType(), Long.valueOf(0L), "", null);
/*  485 */       this.cms2JobService.save(cms2Job);
/*      */ 
/*  488 */       Cms2JobTiming cms2JobStartTiming = new Cms2JobTiming(siteId, EnumJobTimingObj.OBJ_TYPE_CONTENT.getType(), cont.getId(), cont.getReleaseDate(), EnumJobTimingType.OBJ_OPER_START_TIME.getType());
/*  489 */       this.cms2JobTimingService.save(cms2JobStartTiming);
/*      */     }
/*      */ 
/*  492 */     return super.success(model, message, "/cont/list.htm");
/*      */   }
/*      */ 
/*      */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.CONT_ADD})
/*      */   @RequestMapping({"/cont/edit"})
/*      */   public String edit(@RequestParam(value="q", required=false, defaultValue="") String queryStr, Model model, HttpServletRequest request, SettlerAgent admin, @RequestParam("id") Long id, @RequestParam(value="channelId", required=false) Long channelId) {
/*  500 */     Cms2ContAll cont = this.cms2ContService.selectAllById(id);
/*  501 */     model.addAttribute("q", queryStr);
/*  502 */     Cms2Channel channel = null;
/*  503 */     if (cont != null) {
/*  504 */       channel = this.cms2ChannelService.queryById(cont.getChannelId());
/*      */     }
/*      */ 
/*  507 */     Cms2Model cmsModel = null;
/*  508 */     if (channel != null) {
/*  509 */       cmsModel = this.cms2ModelService.queryById(channel.getModelId());
/*  510 */       String com_message = null;
/*  511 */       if (new Integer(2).equals(cmsModel.getHasContent())) {
/*  512 */         com_message = "该栏目下不允许存在内容";
/*      */       }
/*  514 */       if (new Integer(0).equals(cmsModel.getHasContent())) {
/*  515 */         Cms2ContQuery query = new Cms2ContQuery();
/*  516 */         query.setChannelId(channel.getId().toString());
/*  517 */         query.setIsHide("1");
/*  518 */         List contentList = this.cms2ContService.selectList(query);
/*  519 */         if (contentList.size() >= 1)
/*  520 */           com_message = "该栏目下已存在文章或文章已放入回收站";
/*      */       }
/*  522 */       if (!StringUtil.isBlank(com_message))
/*  523 */         return error(model, com_message, "", request.getHeader("Referer"));
/*      */     }
/*      */     else {
/*  526 */       cmsModel = this.cms2ModelService.queryById(Long.valueOf(999L));
/*  527 */       if (cmsModel == null) {
/*  528 */         return error(model, "默认模板找不到", "", request.getHeader("Referer"));
/*      */       }
/*      */     }
/*      */ 
/*  532 */     List itemList = this.cms2ModelItemService.getItemListForContent(cmsModel.getId());
/*      */ 
/*  534 */     List channelList = new ArrayList();
/*  535 */     channelList.add(channel);
/*  536 */     model.addAttribute("cmsModel", cmsModel);
/*  537 */     model.addAttribute("itemList", itemList);
/*  538 */     model.addAttribute("channelList", channelList);
/*  539 */     model.addAttribute("channelId", channelId);
/*  540 */     model.addAttribute("channel", channel);
/*  541 */     model.addAttribute("cont", cont);
/*      */ 
/*  543 */     model.addAttribute("fileServerUrl", this.fileServerUrl);
/*  544 */     model.addAttribute("sysCode", this.sysCode);
/*  545 */     model.addAttribute("bizRule", this.bizRule);
/*      */ 
/*  548 */     Long userFinalStep = getUserFinalStep(channel.getId(), channel.getSiteId(), Long.valueOf(admin.getId()));
/*  549 */     Long channelFinalStep = getChannelFinalStep(channel.getId(), channel.getSiteId());
/*      */ 
/*  551 */     if (null == userFinalStep) {
/*  552 */       userFinalStep = Long.valueOf(0L);
/*      */     }
/*  554 */     if (channelFinalStep.compareTo(userFinalStep) < 0)
/*  555 */       userFinalStep = channelFinalStep;
/*  556 */     model.addAttribute("userFinalStep", userFinalStep);
/*      */ 
/*  558 */     Cms2ContCheckQuery contCheckQuery = new Cms2ContCheckQuery();
/*  559 */     contCheckQuery.setContentId(cont.getId().toString());
/*  560 */     List cms2ContCheckList = this.cms2ContCheckService.queryCms2ContCheckList(contCheckQuery);
/*  561 */     Cms2ContCheck cms2ContCheck = null;
/*  562 */     if ((cms2ContCheckList != null) && (cms2ContCheckList.size() > 0))
/*  563 */       cms2ContCheck = (Cms2ContCheck)cms2ContCheckList.get(0);
/*  564 */     model.addAttribute("contCurrentStep", cms2ContCheck.getCheckStep());
/*  565 */     model.addAttribute("cms2ContCheck", cms2ContCheck);
/*      */ 
/*  567 */     if (this.useFileUploadSystem)
/*      */     {
/*  569 */       FileRequest batchRequest = new FileRequest();
/*  570 */       batchRequest.setSysCode(this.sysCode);
/*  571 */       FileBatchResult batchResult = this.fileService.getBatch(batchRequest);
/*  572 */       if (batchResult.isError())
/*  573 */         model.addAttribute("message", "文件上传批次获取失败");
/*      */       else {
/*  575 */         model.addAttribute("batchId", batchResult.getBatchId());
/*      */       }
/*      */     }
/*  578 */     return "/cont/edit";
/*      */   }
/*      */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.CONT_MANAGE})
/*      */   @RequestMapping({"/cont/view"})
/*      */   public String view(Model model, HttpServletRequest request, SettlerAgent admin, @RequestParam("id") Long id) {
/*  585 */     String url = this.cms2ContService.getUrlById(id);
/*  586 */     return new StringBuilder().append("redirect:").append(url).append("?visit=1").toString();
/*      */   }
/*      */ 
/*      */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.CONT_DEL})
/*      */   @RequestMapping({"/cont/del"})
/*      */   public String del(@RequestParam(value="q", required=false, defaultValue="") String queryStr, Model model, HttpServletRequest request, SettlerAgent cmsAgent, @RequestParam("id") String id, Cms2ContQuery query) {
/*  594 */     model.addAttribute("q", queryStr);
/*  595 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/*      */ 
/*  597 */     String message = this.cms2ContService.deleteById(id);
/*  598 */     if (message.equals("delete"))
/*      */     {
/*  600 */       Cms2Job cms2Job = new Cms2Job(siteId, EnumStaticType.CONTENT_STATIC.getType(), Long.valueOf(Long.parseLong(id)), EnumStaticOper.DELETE_STATIC.getType(), Long.valueOf(0L), "", null);
/*  601 */       this.cms2JobService.save(cms2Job);
/*      */ 
/*  604 */       Cms2JobTimingQuery cms2JobTimingQuery = new Cms2JobTimingQuery();
/*  605 */       cms2JobTimingQuery.setObjId(id);
/*  606 */       cms2JobTimingQuery.setObjType(EnumJobTimingObj.OBJ_TYPE_CONTENT.getType().toString());
/*  607 */       cms2JobTimingQuery.setSiteId(siteId.toString());
/*      */ 
/*  609 */       cms2JobTimingQuery.setObjOper(EnumJobTimingType.OBJ_OPER_START_TIME.getType().toString());
/*  610 */       this.cms2JobTimingService.delete(cms2JobTimingQuery);
/*      */ 
/*  612 */       super.addLog(request, cmsAgent, Cms2Utils.getCurrentSiteId(request), "文章删除", id, "文章删除成功");
/*  613 */     } else if (message.equals("recycle"))
/*      */     {
/*  615 */       Cms2Job cms2Job = new Cms2Job(siteId, EnumStaticType.CONTENT_STATIC.getType(), Long.valueOf(Long.parseLong(id)), EnumStaticOper.CYCLE_STATIC.getType(), Long.valueOf(0L), "", null);
/*  616 */       this.cms2JobService.save(cms2Job);
/*      */ 
/*  619 */       Cms2JobTimingQuery cms2JobTimingQuery = new Cms2JobTimingQuery();
/*  620 */       cms2JobTimingQuery.setObjId(id);
/*  621 */       cms2JobTimingQuery.setObjType(EnumJobTimingObj.OBJ_TYPE_CONTENT.getType().toString());
/*  622 */       cms2JobTimingQuery.setSiteId(siteId.toString());
/*      */ 
/*  624 */       cms2JobTimingQuery.setObjOper(EnumJobTimingType.OBJ_OPER_START_TIME.getType().toString());
/*  625 */       this.cms2JobTimingService.delete(cms2JobTimingQuery);
/*      */ 
/*  627 */       super.addLog(request, cmsAgent, Cms2Utils.getCurrentSiteId(request), "文章删除", id, "文章删除成功");
/*      */     } else {
/*  629 */       return super.error(model, message, "", "/cont/list.htm");
/*      */     }
/*  631 */     message = "删除成功";
/*  632 */     return super.success(model, message, "/cont/list.htm");
/*      */   }
/*      */ 
/*      */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.CONT_DEL})
/*      */   @RequestMapping({"/cont/delByList"})
/*      */   public String delByList(@RequestParam(value="q", required=false, defaultValue="") String queryStr, Model model, HttpServletRequest request, SettlerAgent cmsAgent, @RequestParam(value="ids", required=false) List<String> idList, Cms2ContQuery query) {
/*  640 */     model.addAttribute("q", queryStr);
/*  641 */     List idListUnique = getUnique(idList);
/*  642 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/*  643 */     String message = this.cms2ContService.deleteByIds(idListUnique);
/*  644 */     if (message.equals("delete")) {
/*  645 */       for (String id : idList)
/*      */       {
/*  647 */         Cms2Job cms2Job = new Cms2Job(siteId, EnumStaticType.CONTENT_STATIC.getType(), Long.valueOf(Long.parseLong(id)), EnumStaticOper.DELETE_STATIC.getType(), Long.valueOf(0L), "", null);
/*  648 */         this.cms2JobService.save(cms2Job);
/*      */ 
/*  651 */         Cms2JobTimingQuery cms2JobTimingQuery = new Cms2JobTimingQuery();
/*  652 */         cms2JobTimingQuery.setObjId(id);
/*  653 */         cms2JobTimingQuery.setObjType(EnumJobTimingObj.OBJ_TYPE_CONTENT.getType().toString());
/*  654 */         cms2JobTimingQuery.setSiteId(siteId.toString());
/*      */ 
/*  656 */         cms2JobTimingQuery.setObjOper(EnumJobTimingType.OBJ_OPER_START_TIME.getType().toString());
/*  657 */         this.cms2JobTimingService.delete(cms2JobTimingQuery);
/*      */       }
/*      */ 
/*  660 */       super.addLog(request, cmsAgent, Cms2Utils.getCurrentSiteId(request), "文章删除", idListUnique.toString(), "文章批量删除成功");
/*  661 */     } else if (message.equals("recycle")) {
/*  662 */       for (String id : idList)
/*      */       {
/*  664 */         Cms2Job cms2Job = new Cms2Job(siteId, EnumStaticType.CONTENT_STATIC.getType(), Long.valueOf(Long.parseLong(id)), EnumStaticOper.CYCLE_STATIC.getType(), Long.valueOf(0L), "", null);
/*  665 */         this.cms2JobService.save(cms2Job);
/*      */ 
/*  668 */         Cms2JobTimingQuery cms2JobTimingQuery = new Cms2JobTimingQuery();
/*  669 */         cms2JobTimingQuery.setObjId(id);
/*  670 */         cms2JobTimingQuery.setObjType(EnumJobTimingObj.OBJ_TYPE_CONTENT.getType().toString());
/*  671 */         cms2JobTimingQuery.setSiteId(siteId.toString());
/*      */ 
/*  673 */         cms2JobTimingQuery.setObjOper(EnumJobTimingType.OBJ_OPER_START_TIME.getType().toString());
/*  674 */         this.cms2JobTimingService.delete(cms2JobTimingQuery);
/*      */       }
/*  676 */       super.addLog(request, cmsAgent, Cms2Utils.getCurrentSiteId(request), "文章删除", idListUnique.toString(), "文章批量删除成功");
/*      */     } else {
/*  678 */       return super.error(model, message, "", "/cont/list.htm");
/*      */     }
/*  680 */     message = "删除成功";
/*  681 */     return super.success(model, message, "/cont/list.htm");
/*      */   }
/*      */ 
/*      */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.CONT_DEL})
/*      */   @RequestMapping({"/cont/delSeculity"})
/*      */   public String delSeculity(@RequestParam(value="q", required=false, defaultValue="") String queryStr, Model model, HttpServletRequest request, SettlerAgent cmsAgent, @RequestParam("id") String id, Cms2ContQuery query) {
/*  689 */     model.addAttribute("q", queryStr);
/*  690 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/*  691 */     String message = this.cms2ContService.deleteSeculityById(id);
/*  692 */     if (message.equals(""))
/*      */     {
/*  694 */       Cms2Job cms2Job = new Cms2Job(siteId, EnumStaticType.CONTENT_STATIC.getType(), Long.valueOf(Long.parseLong(id)), EnumStaticOper.DELETE_STATIC.getType(), Long.valueOf(0L), "", null);
/*  695 */       this.cms2JobService.save(cms2Job);
/*      */ 
/*  698 */       Cms2JobTimingQuery cms2JobTimingQuery = new Cms2JobTimingQuery();
/*  699 */       cms2JobTimingQuery.setObjId(id);
/*  700 */       cms2JobTimingQuery.setObjType(EnumJobTimingObj.OBJ_TYPE_CONTENT.getType().toString());
/*  701 */       cms2JobTimingQuery.setSiteId(siteId.toString());
/*      */ 
/*  703 */       cms2JobTimingQuery.setObjOper(EnumJobTimingType.OBJ_OPER_START_TIME.getType().toString());
/*  704 */       this.cms2JobTimingService.delete(cms2JobTimingQuery);
/*  705 */       super.addLog(request, cmsAgent, Cms2Utils.getCurrentSiteId(request), "文章彻底删除", id, "文章彻底删除成功");
/*      */     } else {
/*  707 */       return super.error(model, message, "", "/cont/list.htm");
/*      */     }
/*  709 */     message = "删除成功";
/*  710 */     return super.success(model, message, "/cont/list.htm");
/*      */   }
/*      */ 
/*      */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.CONT_DEL})
/*      */   @RequestMapping({"/cont/delSeculityByList"})
/*      */   public String delSeculityByList(@RequestParam(value="q", required=false, defaultValue="") String queryStr, Model model, HttpServletRequest request, SettlerAgent cmsAgent, @RequestParam(value="ids", required=false) List<String> idList, Cms2ContQuery query) {
/*  718 */     model.addAttribute("q", queryStr);
/*  719 */     List idListUnique = getUnique(idList);
/*  720 */     String message = this.cms2ContService.deleteSeculityByIds(idListUnique);
/*  721 */     if (message.equals(""))
/*  722 */       super.addLog(request, cmsAgent, Cms2Utils.getCurrentSiteId(request), "文章彻底删除", idListUnique.toString(), "批量文章彻底删除成功");
/*      */     else {
/*  724 */       return super.error(model, message, "", "/cont/list.htm");
/*      */     }
/*  726 */     message = "删除成功";
/*  727 */     return super.success(model, message, "/cont/list.htm");
/*      */   }
/*      */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.CONT_DEL})
/*      */   @RequestMapping({"/cont/restore"})
/*      */   public String restore(@RequestParam(value="q", required=false, defaultValue="") String queryStr, Model model, HttpServletRequest request, SettlerAgent cmsAgent, @RequestParam("id") String id, Cms2ContQuery query) {
/*  734 */     model.addAttribute("q", queryStr);
/*  735 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/*  736 */     if ((siteId == null) || (!siteId.equals(siteId))) {
/*  737 */       return super.error(model, "", "", null);
/*      */     }
/*  739 */     String message = this.cms2ContService.restore(id);
/*  740 */     if (message.equals(""))
/*  741 */       super.addLog(request, cmsAgent, Cms2Utils.getCurrentSiteId(request), "文章恢复", id, "文章恢复成功");
/*      */     else {
/*  743 */       return super.error(model, message, "", "/cont/list.htm");
/*      */     }
/*      */ 
/*  746 */     Cms2Job cms2Job = new Cms2Job(siteId, EnumStaticType.CONTENT_STATIC.getType(), Long.valueOf(Long.parseLong(id)), EnumStaticOper.MODIFY_STATIC.getType(), Long.valueOf(0L), "", null);
/*  747 */     this.cms2JobService.save(cms2Job);
/*      */ 
/*  750 */     Cms2ContAll cont = this.cms2ContService.selectAllById(Long.valueOf(Long.parseLong(id)));
/*  751 */     Cms2JobTiming cms2JobStartTiming = new Cms2JobTiming(siteId, EnumJobTimingObj.OBJ_TYPE_CONTENT.getType(), Long.valueOf(Long.parseLong(id)), cont.getReleaseDate(), EnumJobTimingType.OBJ_OPER_START_TIME.getType());
/*  752 */     this.cms2JobTimingService.save(cms2JobStartTiming);
/*      */ 
/*  754 */     message = "还原成功";
/*  755 */     return super.success(model, message, "/cont/list.htm");
/*      */   }
/*      */   @RequestMapping({"/cont/audit"})
/*      */   public String audit(@RequestParam(value="q", required=false, defaultValue="") String queryStr, Long[] ids, Model model) {
/*  760 */     model.addAttribute("q", queryStr);
/*  761 */     if (!this.cms2ContService.batchAudit(ids))
/*  762 */       return super.error(model, "审核失败", "", "/cont/list.htm");
/*  763 */     return super.success(model, "审核成功", "/cont/list.htm");
/*      */   }
/*      */ 
/*      */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.CONT_DEL})
/*      */   @RequestMapping({"/cont/batchPass"})
/*      */   public String batchPass(@RequestParam(value="q", required=false, defaultValue="") String queryStr, Model model, HttpServletRequest request, SettlerAgent cmsAgent, @RequestParam(value="ids", required=false) List<Long> idList, Cms2ContQuery query)
/*      */   {
/*  774 */     model.addAttribute("q", queryStr);
/*  775 */     String message = null;
/*  776 */     List contList = new ArrayList();
/*  777 */     List contCheckList = new ArrayList();
/*  778 */     Cms2ContCheckQuery contCheckQuery = new Cms2ContCheckQuery();
/*  779 */     Cms2Cont cont = null;
/*  780 */     List cms2ContCheckList = null;
/*  781 */     Cms2ContCheck cms2ContCheck = null;
/*  782 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/*  783 */     Cms2Site site = this.cms2SiteService.queryById(siteId);
/*  784 */     for (Long id : idList) {
/*  785 */       cont = this.cms2ContService.selectById(id);
/*  786 */       contCheckQuery.setContentId(cont.getId().toString());
/*  787 */       cms2ContCheckList = this.cms2ContCheckService.queryCms2ContCheckList(contCheckQuery);
/*  788 */       if ((cms2ContCheckList != null) && (cms2ContCheckList.size() > 0))
/*      */       {
/*  790 */         cms2ContCheck = (Cms2ContCheck)cms2ContCheckList.get(0);
/*      */       }
/*  792 */       else cms2ContCheck = new Cms2ContCheck();
/*  793 */       message = canPass(cont, cms2ContCheck, site, cmsAgent);
/*  794 */       if (StringUtil.isNotBlank(message))
/*  795 */         return super.error(model, message, "", "/cont/list.htm");
/*  796 */       contList.add(cont);
/*  797 */       contCheckList.add(cms2ContCheck);
/*      */     }
/*      */ 
/*  800 */     Cms2Channel channel = null;
/*  801 */     Cms2Model cms2Model = null;
/*  802 */     List delContsList = null;
/*  803 */     Long userFinalStep = null;
/*  804 */     Long sysFinalStep = null;
/*  805 */     Cms2Cont contTemp = new Cms2Cont();
/*  806 */     for (int i = 0; i < contList.size(); i++) {
/*  807 */       cont = (Cms2Cont)contList.get(i);
/*  808 */       userFinalStep = getUserFinalStep(cont.getChannelId(), cont.getSiteId(), Long.valueOf(cmsAgent.getId()));
/*  809 */       sysFinalStep = getChannelFinalStep(cont.getChannelId(), cont.getSiteId());
/*  810 */       cms2ContCheck = (Cms2ContCheck)contCheckList.get(i);
/*  811 */       if (userFinalStep.compareTo(sysFinalStep) < 0) {
/*  812 */         cms2ContCheck.setCheckStep(userFinalStep);
/*      */       } else {
/*  814 */         cms2ContCheck.setCheckStep(sysFinalStep);
/*  815 */         contTemp.setId(cont.getId());
/*  816 */         contTemp.setStatus(EnumContStatus.FINISH.getCode());
/*  817 */         contTemp.setModifyTime(new Date());
/*  818 */         this.cms2ContService.update(contTemp);
/*      */       }
/*  820 */       this.cms2ContCheckService.update(cms2ContCheck);
/*  821 */       if ((cont != null) && (cont.getMemberId() != null) && (cont.getMemberId().compareTo(Long.valueOf(0L)) > 0)) {
/*  822 */         channel = this.cms2ChannelService.queryById(cont.getChannelId());
/*  823 */         cms2Model = this.cms2ModelService.queryById(channel.getModelId());
/*  824 */         if (EnumModelHasContent.MEMBER_ALONE.getCode().equals(cms2Model.getHasContent()))
/*      */         {
/*  826 */           delContsList = this.cms2ContService.queryAloneContIds(channel.getId(), cont.getMemberId(), cont.getId());
/*  827 */           this.cms2ContService.deleteSeculityByIds(delContsList);
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/*  832 */       Cms2Job cms2Job = new Cms2Job(siteId, EnumStaticType.CONTENT_STATIC.getType(), cont.getId(), EnumStaticOper.MODIFY_STATIC.getType(), Long.valueOf(0L), "", null);
/*  833 */       this.cms2JobService.save(cms2Job);
/*      */     }
/*  835 */     message = "操作成功";
/*  836 */     return super.success(model, message, "/cont/list.htm");
/*      */   }
/*      */ 
/*      */   public String canPass(Cms2Cont cont, Cms2ContCheck cms2ContCheck, Cms2Site site, SettlerAgent settlerAgent)
/*      */   {
/*  843 */     if (!EnumContStatus.AUDITING.getCode().equals(cont.getStatus())) {
/*  844 */       return "审核失败,文章状态不正确";
/*      */     }
/*  846 */     Long userFinalStep = getUserFinalStep(cont.getChannelId(), cont.getSiteId(), Long.valueOf(settlerAgent.getId()));
/*  847 */     if ((userFinalStep == null) || (userFinalStep.compareTo(Long.valueOf(0L)) <= 0)) {
/*  848 */       return "审核失败，用户无权限";
/*      */     }
/*  850 */     Long sysFinalStep = getChannelFinalStep(cont.getChannelId(), cont.getSiteId());
/*      */ 
/*  852 */     if (EnumContIsRejected.REJECTED.getCode().equals(cms2ContCheck.getIsRejected())) {
/*  853 */       return "审核失败，退回文章不允许审核通过";
/*      */     }
/*  855 */     if (userFinalStep.compareTo(cms2ContCheck.getCheckStep()) <= 0) {
/*  856 */       return "审核失败，当前环节管理员已审或审核权限不足";
/*      */     }
/*  858 */     if (userFinalStep.compareTo(sysFinalStep) < 0) {
/*  859 */       if ((EnumSiteOverReview.FALSE.getCode().equals(site.getOverReview())) && (cms2ContCheck.getCheckStep().compareTo(Long.valueOf(userFinalStep.longValue() - 1L)) < 0))
/*      */       {
/*  861 */         return "审核失败，不允许越级通过";
/*      */       }
/*  863 */     } else if ((EnumSiteOverReview.FALSE.getCode().equals(site.getOverReview())) && (cms2ContCheck.getCheckStep().compareTo(Long.valueOf(sysFinalStep.longValue() - 1L)) < 0))
/*      */     {
/*  865 */       return "审核失败，不允许越级通过";
/*      */     }
/*  867 */     return "";
/*      */   }
/*      */ 
/*      */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.CONT_AUDIT})
/*      */   @RequestMapping({"/cont/pass"})
/*      */   public String pass(@RequestParam(value="q", required=false, defaultValue="") String queryStr, Long id, Model model, SettlerAgent settlerAgent, HttpServletRequest request)
/*      */   {
/*  877 */     model.addAttribute("q", queryStr);
/*  878 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/*  879 */     if ((siteId == null) || (!siteId.equals(siteId))) {
/*  880 */       return super.error(model, "", "", null);
/*      */     }
/*  882 */     Cms2Cont cont = this.cms2ContService.selectById(id);
/*  883 */     if (!EnumContStatus.AUDITING.getCode().equals(cont.getStatus())) {
/*  884 */       return super.error(model, "审核失败,文章状态不正确", "", "/cont/list.htm");
/*      */     }
/*  886 */     Long userFinalStep = getUserFinalStep(cont.getChannelId(), cont.getSiteId(), Long.valueOf(settlerAgent.getId()));
/*  887 */     if ((userFinalStep == null) || (userFinalStep.compareTo(Long.valueOf(0L)) <= 0)) {
/*  888 */       return super.error(model, "审核失败，用户无权限", "", "/cont/list.htm");
/*      */     }
/*      */ 
/*  891 */     Long sysFinalStep = getChannelFinalStep(cont.getChannelId(), cont.getSiteId());
/*      */ 
/*  894 */     Cms2ContCheckQuery contCheckQuery = new Cms2ContCheckQuery();
/*  895 */     contCheckQuery.setContentId(cont.getId().toString());
/*  896 */     List cms2ContCheckList = this.cms2ContCheckService.queryCms2ContCheckList(contCheckQuery);
/*  897 */     Cms2Site site = this.cms2SiteService.queryById(cont.getSiteId());
/*  898 */     if ((cms2ContCheckList != null) && (cms2ContCheckList.size() > 0))
/*      */     {
/*  900 */       Cms2ContCheck cms2ContCheck = (Cms2ContCheck)cms2ContCheckList.get(0);
/*  901 */       if (EnumContIsRejected.REJECTED.getCode().equals(cms2ContCheck.getIsRejected())) {
/*  902 */         return super.error(model, "审核失败，退回文章不允许审核通过", "", "/cont/list.htm");
/*      */       }
/*  904 */       if (userFinalStep.compareTo(cms2ContCheck.getCheckStep()) <= 0) {
/*  905 */         return super.error(model, "审核失败，当前环节管理员已审或审核权限不足", "", "/cont/list.htm");
/*      */       }
/*  907 */       if (userFinalStep.compareTo(sysFinalStep) < 0) {
/*  908 */         if ((EnumSiteOverReview.FALSE.getCode().equals(site.getOverReview())) && (cms2ContCheck.getCheckStep().compareTo(Long.valueOf(userFinalStep.longValue() - 1L)) < 0))
/*      */         {
/*  910 */           return super.error(model, "审核失败，不允许越级通过", "", "/cont/list.htm");
/*      */         }
/*      */ 
/*  913 */         cms2ContCheck.setCheckStep(userFinalStep);
/*      */       } else {
/*  915 */         if ((EnumSiteOverReview.FALSE.getCode().equals(site.getOverReview())) && (cms2ContCheck.getCheckStep().compareTo(Long.valueOf(sysFinalStep.longValue() - 1L)) < 0))
/*      */         {
/*  917 */           return super.error(model, "审核失败，不允许越级通过", "", "/cont/list.htm");
/*      */         }
/*      */ 
/*  920 */         cms2ContCheck.setCheckStep(sysFinalStep);
/*  921 */         Cms2Cont contTemp = new Cms2Cont();
/*  922 */         contTemp.setId(id);
/*  923 */         contTemp.setStatus(EnumContStatus.FINISH.getCode());
/*  924 */         contTemp.setModifyTime(new Date());
/*  925 */         this.cms2ContService.update(contTemp);
/*      */ 
/*  928 */         Cms2Job cms2Job = new Cms2Job(siteId, EnumStaticType.CONTENT_STATIC.getType(), cont.getId(), EnumStaticOper.MODIFY_STATIC.getType(), Long.valueOf(0L), "", null);
/*  929 */         this.cms2JobService.save(cms2Job);
/*      */       }
/*  931 */       this.cms2ContCheckService.update(cms2ContCheck);
/*      */     }
/*      */     else {
/*  934 */       Cms2ContCheck contCheck = new Cms2ContCheck();
/*  935 */       contCheck.setContentId(cont.getId());
/*  936 */       contCheck.setIsRejected(EnumContIsRejected.NOT_REJECTED.getCode());
/*  937 */       if (userFinalStep.compareTo(sysFinalStep) < 0) {
/*  938 */         if ((EnumSiteOverReview.FALSE.getCode().equals(site.getOverReview())) && (new Long(0L).compareTo(Long.valueOf(userFinalStep.longValue() - 1L)) < 0))
/*      */         {
/*  940 */           return super.error(model, "审核失败，不允许越级通过", "", "/cont/list.htm");
/*      */         }
/*      */ 
/*  943 */         contCheck.setCheckStep(userFinalStep);
/*      */       } else {
/*  945 */         if ((EnumSiteOverReview.FALSE.getCode().equals(site.getOverReview())) && (new Long(0L).compareTo(Long.valueOf(sysFinalStep.longValue() - 1L)) < 0))
/*      */         {
/*  947 */           return super.error(model, "审核失败，不允许越级通过", "", "/cont/list.htm");
/*      */         }
/*      */ 
/*  950 */         contCheck.setCheckStep(sysFinalStep);
/*  951 */         Cms2Cont contTemp = new Cms2Cont();
/*  952 */         contTemp.setId(id);
/*  953 */         contTemp.setStatus(EnumContStatus.FINISH.getCode());
/*  954 */         contTemp.setModifyTime(new Date());
/*  955 */         this.cms2ContService.update(contTemp);
/*      */ 
/*  958 */         Cms2Job cms2Job = new Cms2Job(siteId, EnumStaticType.CONTENT_STATIC.getType(), cont.getId(), EnumStaticOper.MODIFY_STATIC.getType(), Long.valueOf(0L), "", null);
/*  959 */         this.cms2JobService.save(cms2Job);
/*      */       }
/*  961 */       this.cms2ContCheckService.insert(contCheck);
/*      */     }
/*  963 */     if ((cont != null) && (cont.getMemberId() != null) && (cont.getMemberId().compareTo(Long.valueOf(0L)) > 0)) {
/*  964 */       Cms2Channel channel = this.cms2ChannelService.queryById(cont.getChannelId());
/*  965 */       Cms2Model cms2Model = this.cms2ModelService.queryById(channel.getModelId());
/*      */ 
/*  967 */       if (EnumModelHasContent.MEMBER_ALONE.getCode().equals(cms2Model.getHasContent()))
/*      */       {
/*  969 */         List delContsList = this.cms2ContService.queryAloneContIds(channel.getId(), cont.getMemberId(), cont.getId());
/*  970 */         this.cms2ContService.deleteSeculityByIds(delContsList);
/*      */       }
/*      */ 
/*  974 */       Cms2Job cms2Job = new Cms2Job(siteId, EnumStaticType.CONTENT_STATIC.getType(), cont.getId(), EnumStaticOper.MODIFY_STATIC.getType(), Long.valueOf(0L), "", null);
/*  975 */       this.cms2JobService.save(cms2Job);
/*      */     }
/*  977 */     super.addLog(request, settlerAgent, Cms2Utils.getCurrentSiteId(request), "文章通过", id.toString(), "文章通过成功");
/*  978 */     return super.success(model, "审核成功", "/cont/list.htm");
/*      */   }
/*      */ 
/*      */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.CONT_AUDIT})
/*      */   @RequestMapping({"/cont/batchReject"})
/*      */   public String batchReject(@RequestParam(value="q", required=false, defaultValue="") String queryStr, @RequestParam(value="ids", required=false) List<Long> idList, Long rejectStep, String checkOpinion, Model model, SettlerAgent settlerAgent, HttpServletRequest request)
/*      */   {
/*  989 */     model.addAttribute("q", queryStr);
/*  990 */     List contList = new ArrayList();
/*  991 */     List contCheckList = new ArrayList();
/*  992 */     String message = null;
/*  993 */     Cms2Cont cont = null;
/*  994 */     Cms2ContCheckQuery contCheckQuery = new Cms2ContCheckQuery();
/*  995 */     List cms2ContCheckList = null;
/*  996 */     Cms2ContCheck cms2ContCheck = null;
/*  997 */     Long userFinalStep = null;
/*  998 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/*  999 */     Cms2Site site = this.cms2SiteService.queryById(siteId);
/* 1000 */     for (Long id : idList) {
/* 1001 */       cont = this.cms2ContService.selectById(id);
/* 1002 */       contCheckQuery.setContentId(cont.getId().toString());
/* 1003 */       cms2ContCheckList = this.cms2ContCheckService.queryCms2ContCheckList(contCheckQuery);
/* 1004 */       if ((cms2ContCheckList != null) && (cms2ContCheckList.size() > 0))
/*      */       {
/* 1006 */         cms2ContCheck = (Cms2ContCheck)cms2ContCheckList.get(0);
/*      */       }
/* 1008 */       else cms2ContCheck = new Cms2ContCheck();
/* 1009 */       userFinalStep = getUserFinalStep(cont.getChannelId(), cont.getSiteId(), Long.valueOf(settlerAgent.getId()));
/* 1010 */       message = canReject(cont, userFinalStep, cms2ContCheck, site);
/* 1011 */       if (StringUtil.isNotBlank(message))
/* 1012 */         return super.error(model, message, "", "/cont/list.htm");
/* 1013 */       contList.add(cont);
/* 1014 */       contCheckList.add(cms2ContCheck);
/*      */     }
/*      */ 
/* 1017 */     cont = new Cms2Cont();
/* 1018 */     StringBuilder sb = new StringBuilder();
/* 1019 */     for (int i = 0; i < contCheckList.size(); i++) {
/* 1020 */       cms2ContCheck = (Cms2ContCheck)contCheckList.get(i);
/* 1021 */       cms2ContCheck.setCheckOpinion(checkOpinion);
/* 1022 */       cms2ContCheck.setCheckStep(rejectStep);
/* 1023 */       cms2ContCheck.setIsRejected(EnumContIsRejected.REJECTED.getCode());
/* 1024 */       this.cms2ContCheckService.update(cms2ContCheck);
/* 1025 */       if ((rejectStep == null) || (rejectStep.compareTo(Long.valueOf(0L)) == 0)) {
/* 1026 */         cont.setId(((Cms2Cont)contList.get(i)).getId());
/* 1027 */         cont.setStatus(EnumContStatus.DRAFT.getCode());
/*      */ 
/* 1029 */         cont.setModifyTime(null);
/* 1030 */         this.cms2ContService.update(cont);
/*      */       }
/* 1032 */       sb.append(cms2ContCheck.getContentId());
/* 1033 */       if (i + 1 < contCheckList.size()) {
/* 1034 */         sb.append(",");
/*      */       }
/*      */ 
/* 1037 */       Cms2Job cms2Job = new Cms2Job(siteId, EnumStaticType.CONTENT_STATIC.getType(), cont.getId(), EnumStaticOper.MODIFY_STATIC.getType(), Long.valueOf(0L), "", null);
/* 1038 */       this.cms2JobService.save(cms2Job);
/*      */     }
/* 1040 */     super.addLog(request, settlerAgent, Cms2Utils.getCurrentSiteId(request), "文章退回", sb.toString(), "文章退回成功");
/* 1041 */     return super.success(model, "批量退回成功", "/cont/list.htm");
/*      */   }
/*      */ 
/*      */   private String canReject(Cms2Cont cont, Long userFinalStep, Cms2ContCheck contCheck, Cms2Site site)
/*      */   {
/* 1048 */     if (!EnumContStatus.AUDITING.getCode().equals(cont.getStatus())) {
/* 1049 */       return "审核失败,文章状态不正确";
/*      */     }
/* 1051 */     if (null == userFinalStep) {
/* 1052 */       userFinalStep = Long.valueOf(0L);
/*      */     }
/*      */ 
/* 1056 */     if (EnumContIsRejected.REJECTED.getCode().equals(contCheck.getIsRejected()))
/* 1057 */       return "退回失败，存在已经退回的文章";
/* 1058 */     if (userFinalStep.compareTo(contCheck.getCheckStep()) < 0) {
/* 1059 */       return "退回失败，用户权限不足";
/*      */     }
/* 1061 */     if ((EnumSiteOverReview.FALSE.getCode().equals(site.getOverReview())) && (contCheck.getCheckStep().compareTo(Long.valueOf(userFinalStep.longValue() - 1L)) < 0))
/*      */     {
/* 1063 */       return "退回失败，不允许越级退回";
/* 1064 */     }return null;
/*      */   }
/*      */ 
/*      */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.CONT_AUDIT})
/*      */   @RequestMapping({"/cont/reject"})
/*      */   public String reject(@RequestParam(value="q", required=false, defaultValue="") String queryStr, Long id, Long rejectStep, String checkOpinion, Model model, SettlerAgent settlerAgent, HttpServletRequest request)
/*      */   {
/* 1075 */     model.addAttribute("q", queryStr);
/*      */ 
/* 1077 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/* 1078 */     if ((siteId == null) || (!siteId.equals(siteId))) {
/* 1079 */       return super.error(model, "", "", null);
/*      */     }
/*      */ 
/* 1082 */     Cms2Cont cont = this.cms2ContService.selectById(id);
/* 1083 */     if (!EnumContStatus.AUDITING.getCode().equals(cont.getStatus()))
/* 1084 */       return super.error(model, "审核失败,文章状态不正确", "", "/cont/list.htm");
/* 1085 */     Long userFinalStep = getUserFinalStep(cont.getChannelId(), cont.getSiteId(), Long.valueOf(settlerAgent.getId()));
/*      */ 
/* 1090 */     if (null == userFinalStep) {
/* 1091 */       userFinalStep = Long.valueOf(0L);
/*      */     }
/*      */ 
/* 1098 */     Cms2ContCheckQuery contCheckQuery = new Cms2ContCheckQuery();
/* 1099 */     contCheckQuery.setContentId(cont.getId().toString());
/* 1100 */     List cms2ContCheckList = this.cms2ContCheckService.queryCms2ContCheckList(contCheckQuery);
/* 1101 */     if ((cms2ContCheckList != null) && (cms2ContCheckList.size() > 0)) {
/* 1102 */       Cms2ContCheck contCheck = (Cms2ContCheck)cms2ContCheckList.get(0);
/* 1103 */       if (EnumContIsRejected.REJECTED.getCode().equals(contCheck.getIsRejected())) {
/* 1104 */         return super.error(model, "审核失败，该文章已经退回", "", "/cont/list.htm");
/*      */       }
/* 1106 */       if (userFinalStep.compareTo(contCheck.getCheckStep()) < 0) {
/* 1107 */         return super.error(model, "退回失败，用户权限不足", "", "/cont/list.htm");
/*      */       }
/* 1109 */       Cms2Site site = this.cms2SiteService.queryById(cont.getSiteId());
/* 1110 */       if ((EnumSiteOverReview.FALSE.getCode().equals(site.getOverReview())) && (contCheck.getCheckStep().compareTo(Long.valueOf(userFinalStep.longValue() - 1L)) < 0))
/*      */       {
/* 1112 */         return super.error(model, "退回失败，不允许越级退回", "", "/cont/list.htm");
/*      */       }
/* 1114 */       contCheck.setCheckOpinion(checkOpinion);
/* 1115 */       contCheck.setCheckStep(rejectStep);
/* 1116 */       contCheck.setIsRejected(EnumContIsRejected.REJECTED.getCode());
/*      */ 
/* 1118 */       this.cms2ContCheckService.update(contCheck);
/*      */     } else {
/* 1120 */       Cms2ContCheck contCheck = new Cms2ContCheck();
/* 1121 */       contCheck.setCheckOpinion(checkOpinion);
/* 1122 */       contCheck.setCheckStep(rejectStep);
/* 1123 */       contCheck.setContentId(cont.getId());
/* 1124 */       contCheck.setIsRejected(EnumContIsRejected.REJECTED.getCode());
/* 1125 */       this.cms2ContCheckService.insert(contCheck);
/*      */     }
/* 1127 */     if ((rejectStep == null) || (rejectStep.compareTo(Long.valueOf(0L)) == 0)) {
/* 1128 */       cont = new Cms2Cont();
/* 1129 */       cont.setId(id);
/* 1130 */       cont.setStatus(EnumContStatus.DRAFT.getCode());
/*      */ 
/* 1132 */       cont.setModifyTime(null);
/* 1133 */       this.cms2ContService.update(cont);
/*      */     }
/*      */ 
/* 1136 */     Cms2Job cms2Job = new Cms2Job(siteId, EnumStaticType.CONTENT_STATIC.getType(), cont.getId(), EnumStaticOper.MODIFY_STATIC.getType(), Long.valueOf(0L), "", null);
/* 1137 */     this.cms2JobService.save(cms2Job);
/*      */ 
/* 1139 */     super.addLog(request, settlerAgent, Cms2Utils.getCurrentSiteId(request), "文章退回", id.toString(), "文章退回成功");
/* 1140 */     return super.success(model, "退回成功", "/cont/list.htm");
/*      */   }
/*      */ 
/*      */   @RequestMapping({"/cont/revocation"})
/*      */   public String revocation(@RequestParam(value="q", required=false, defaultValue="") String queryStr, Long id, Model model, SettlerAgent settlerAgent, HttpServletRequest request)
/*      */   {
/* 1150 */     model.addAttribute("q", queryStr);
/*      */ 
/* 1152 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/* 1153 */     if ((siteId == null) || (!siteId.equals(siteId))) {
/* 1154 */       return super.error(model, "", "", null);
/*      */     }
/*      */ 
/* 1157 */     Cms2Cont cont = this.cms2ContService.selectById(id);
/* 1158 */     Cms2ContCheckQuery contCheckQuery = new Cms2ContCheckQuery();
/* 1159 */     contCheckQuery.setContentId(cont.getId().toString());
/* 1160 */     List cms2ContCheckList = this.cms2ContCheckService.queryCms2ContCheckList(contCheckQuery);
/* 1161 */     boolean flag = false;
/* 1162 */     if ((cms2ContCheckList != null) && (cms2ContCheckList.size() > 0)) {
/* 1163 */       Cms2ContCheck contCheck = (Cms2ContCheck)cms2ContCheckList.get(0);
/*      */ 
/* 1165 */       Long userFinalStep = getUserFinalStep(cont.getChannelId(), cont.getSiteId(), Long.valueOf(settlerAgent.getId()));
/* 1166 */       Long userFinalStepTemp = userFinalStep;
/* 1167 */       userFinalStep = Long.valueOf(userFinalStep == null ? 0L : userFinalStep.longValue());
/* 1168 */       Long sysFinalStep = getChannelFinalStep(cont.getChannelId(), cont.getSiteId());
/* 1169 */       if (sysFinalStep.compareTo(userFinalStep) < 0) {
/* 1170 */         userFinalStep = sysFinalStep;
/*      */       }
/* 1172 */       if ((EnumContIsRejected.REJECTED.getCode().equals(contCheck.getIsRejected())) && (userFinalStep.compareTo(contCheck.getCheckStep()) > 0))
/*      */       {
/* 1175 */         contCheck.setCheckOpinion("");
/* 1176 */         contCheck.setCheckStep(Long.valueOf(userFinalStep.longValue() - 1L));
/* 1177 */         contCheck.setIsRejected(EnumContIsRejected.NOT_REJECTED.getCode());
/* 1178 */         this.cms2ContCheckService.update(contCheck);
/* 1179 */         if (EnumContStatus.DRAFT.getCode().equals(cont.getStatus())) {
/* 1180 */           cont = new Cms2Cont();
/* 1181 */           cont.setId(id);
/* 1182 */           cont.setStatus(EnumContStatus.AUDITING.getCode());
/* 1183 */           this.cms2ContService.update(cont);
/*      */         }
/* 1185 */         super.addLog(request, settlerAgent, Cms2Utils.getCurrentSiteId(request), "文章撤销", id.toString(), "文章撤销成功");
/* 1186 */         return super.success(model, "撤销成功", "/cont/list.htm");
/*      */       }
/*      */ 
/* 1189 */       if (EnumContStatus.AUDITING.getCode().equals(cont.getStatus())) {
/* 1190 */         if ((contCheck.getCheckStep().equals(Long.valueOf(0L))) && (userFinalStep.compareTo(Long.valueOf(0L)) <= 0)) {
/* 1191 */           cont = new Cms2Cont();
/* 1192 */           cont.setId(id);
/* 1193 */           cont.setStatus(EnumContStatus.DRAFT.getCode());
/* 1194 */           this.cms2ContService.update(cont);
/* 1195 */           flag = true;
/* 1196 */         } else if (contCheck.getCheckStep().compareTo(Long.valueOf(userFinalStep.longValue() + 1L)) == 0) {
/* 1197 */           contCheck.setCheckStep(Long.valueOf(contCheck.getCheckStep().longValue() - 1L));
/* 1198 */           this.cms2ContCheckService.update(contCheck);
/* 1199 */           flag = true;
/*      */         }
/* 1201 */       } else if ((EnumContStatus.FINISH.getCode().equals(cont.getStatus())) && (sysFinalStep.compareTo(userFinalStepTemp) <= 0))
/*      */       {
/* 1203 */         cont = new Cms2Cont();
/* 1204 */         cont.setId(id);
/* 1205 */         cont.setStatus(EnumContStatus.AUDITING.getCode());
/* 1206 */         this.cms2ContService.update(cont);
/* 1207 */         contCheck.setCheckStep(Long.valueOf(contCheck.getCheckStep().longValue() - 1L));
/* 1208 */         this.cms2ContCheckService.update(contCheck);
/* 1209 */         flag = true;
/*      */       }
/*      */     } else {
/* 1212 */       return super.error(model, "撤销失败,缺少审核过程记录", "", "/cont/list.htm");
/*      */     }
/* 1214 */     if (flag)
/*      */     {
/* 1216 */       Cms2Job cms2Job = new Cms2Job(siteId, EnumStaticType.CONTENT_STATIC.getType(), cont.getId(), EnumStaticOper.CANSER_RELESAE.getType(), Long.valueOf(0L), "", null);
/* 1217 */       this.cms2JobService.save(cms2Job);
/*      */ 
/* 1219 */       super.addLog(request, settlerAgent, Cms2Utils.getCurrentSiteId(request), "文章撤销", id.toString(), "文章撤销成功");
/* 1220 */       return super.success(model, "撤销成功", "/cont/list.htm");
/*      */     }
/* 1222 */     return super.error(model, "撤销失败,用户权限不足或文章已被上级处理", "", "/cont/list.htm");
/*      */   }
/*      */ 
/*      */   @RequestMapping({"/cont/batchRevocation"})
/*      */   public String batchRevocation(@RequestParam(value="q", required=false, defaultValue="") String queryStr, @RequestParam(value="ids", required=false) List<Long> idList, Model model, SettlerAgent settlerAgent, HttpServletRequest request)
/*      */   {
/* 1233 */     model.addAttribute("q", queryStr);
/* 1234 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/* 1235 */     String message = this.cms2ContService.batchRevocation(idList, Long.valueOf(settlerAgent.getId()));
/* 1236 */     if (StringUtil.isNotBlank(message)) {
/* 1237 */       return super.error(model, message, "", "/cont/list.htm");
/*      */     }
/* 1239 */     for (Long id : idList)
/*      */     {
/* 1241 */       Cms2Job cms2Job = new Cms2Job(siteId, EnumStaticType.CONTENT_STATIC.getType(), id, EnumStaticOper.CANSER_RELESAE.getType(), Long.valueOf(0L), "", null);
/* 1242 */       this.cms2JobService.save(cms2Job);
/*      */     }
/* 1244 */     super.addLog(request, settlerAgent, Cms2Utils.getCurrentSiteId(request), "文章批量撤销", listToStr(idList), "文章撤销成功");
/* 1245 */     return super.success(model, "批量撤销成功", "/cont/list.htm");
/*      */   }
/*      */ 
/*      */   private String listToStr(List<Long> idList)
/*      */   {
/* 1253 */     StringBuilder sb = new StringBuilder();
/* 1254 */     for (Long id : idList) {
/* 1255 */       sb.append(id);
/* 1256 */       sb.append(",");
/*      */     }
/* 1258 */     return sb.substring(0, sb.lastIndexOf(","));
/*      */   }
/*      */ 
/*      */   private Long getUserFinalStep(Long channelId, Long siteId, Long adminId)
/*      */   {
/* 1265 */     Cms2ChannelUserQuery query = new Cms2ChannelUserQuery();
/* 1266 */     query.setAdminId(new StringBuilder().append("").append(adminId).toString());
/* 1267 */     query.setChannelId(new StringBuilder().append("").append(channelId).toString());
/* 1268 */     List channelUserList = this.cms2ChannelUserService.queryCms2ChannelUserList(query);
/* 1269 */     Long userFinalStep = null;
/* 1270 */     if ((channelUserList != null) && (channelUserList.size() > 0)) {
/* 1271 */       Cms2ChannelUser channelUser = (Cms2ChannelUser)channelUserList.get(0);
/* 1272 */       userFinalStep = channelUser.getCheckStep();
/*      */     } else {
/* 1274 */       Cms2UserSiteQuery userSiteQuery = new Cms2UserSiteQuery();
/* 1275 */       userSiteQuery.setAdminId(new StringBuilder().append("").append(adminId).toString());
/* 1276 */       userSiteQuery.setSiteId(new StringBuilder().append("").append(siteId).toString());
/* 1277 */       List userSiteList = this.cms2UserSiteService.queryCms2UserSiteList(userSiteQuery);
/* 1278 */       if ((userSiteList != null) && (userSiteList.size() > 0)) {
/* 1279 */         Cms2UserSite userSite = (Cms2UserSite)userSiteList.get(0);
/* 1280 */         userFinalStep = userSite.getCheckStep();
/*      */       }
/*      */     }
/* 1283 */     return userFinalStep;
/*      */   }
/*      */ 
/*      */   private Long getChannelFinalStep(Long channelId, Long siteId)
/*      */   {
/* 1290 */     Cms2ChannelExt channelExt = this.cms2ChannelExtService.queryChannelExtByChannelId(channelId);
/* 1291 */     Long sysFinalStep = null;
/* 1292 */     if ((channelExt != null) && (channelExt.getFinalStep() != null) && (channelExt.getFinalStep().compareTo(Long.valueOf(0L)) > 0)) {
/* 1293 */       sysFinalStep = channelExt.getFinalStep();
/*      */     } else {
/* 1295 */       Cms2Site site = this.cms2SiteService.queryById(siteId);
/* 1296 */       sysFinalStep = site.getFinalStep();
/*      */     }
/* 1298 */     return sysFinalStep;
/*      */   }
/*      */ 
/*      */   private Long getUserWantStatus()
/*      */   {
/* 1308 */     return Long.valueOf(0L);
/*      */   }
/*      */ 
/*      */   public Cms2Attach transforAttach(Cms2Attach attach, HttpServletRequest request) {
/* 1312 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/* 1313 */     Cms2Site site = this.cms2SiteService.queryById(siteId);
/* 1314 */     String urlPrefix = new StringBuilder().append(this.uploadServerBroker.getConfig().getURL()).append(this.resSys).append(site.getResPath()).toString();
/* 1315 */     if (attach != null) {
/* 1316 */       String fileUlr = attach.getAttachName();
/* 1317 */       int containsIndex = fileUlr.indexOf(urlPrefix);
/* 1318 */       if (containsIndex != -1) {
/* 1319 */         String filePath = fileUlr.substring(urlPrefix.length(), fileUlr.length());
/* 1320 */         filePath = filePath.substring(0, filePath.lastIndexOf("/") + 1);
/* 1321 */         String fileName = fileUlr.substring(fileUlr.lastIndexOf("/") + 1, fileUlr.length());
/* 1322 */         attach.setAttachName(fileName);
/* 1323 */         attach.setAttachPath(filePath);
/*      */       }
/*      */     }
/* 1326 */     return attach;
/*      */   }
/*      */ 
/*      */   public Cms2ContAll transforAllAttach(Cms2ContAll cont, HttpServletRequest request) {
/* 1330 */     if ((cont.getArticleTitleImg() != null) && (StringUtil.isNotBlank(cont.getArticleTitleImg().getAttachName())))
/* 1331 */       cont.setArticleTitleImg(transforAttach(cont.getArticleTitleImg(), request));
/*      */     else {
/* 1333 */       cont.setArticleTitleImg(null);
/*      */     }
/* 1335 */     if ((cont.getArticleContImg() != null) && (StringUtil.isNotBlank(cont.getArticleContImg().getAttachName())))
/* 1336 */       cont.setArticleContImg(transforAttach(cont.getArticleContImg(), request));
/*      */     else {
/* 1338 */       cont.setArticleContImg(null);
/*      */     }
/* 1340 */     if ((null != cont.getArticleMedia()) && (StringUtil.isNotBlank(cont.getArticleMedia().getAttachName())))
/* 1341 */       cont.setArticleMedia(transforAttach(cont.getArticleMedia(), request));
/*      */     else {
/* 1343 */       cont.setArticleMedia(null);
/*      */     }
/* 1345 */     if (null != cont.getAttachmentPaths()) {
/* 1346 */       List attachList = new ArrayList();
/* 1347 */       int i = 0; for (int len = cont.getAttachmentPaths().length; i < len; i++) {
/* 1348 */         if (!StringUtils.isBlank(cont.getAttachmentPaths()[i])) {
/* 1349 */           Cms2Attach attach = new Cms2Attach();
/* 1350 */           attach.setObjId(cont.getId());
/*      */ 
/* 1353 */           attach.setPriority(Long.valueOf(i + 1L));
/* 1354 */           attach.setDownloadCount(Long.valueOf(0L));
/* 1355 */           attach.setStatus(EnumAttachStatus.PERMANENT.getValue());
/* 1356 */           attach.setAttachType(EnumAttachType.ARTICLE_ATTACHS.getValue());
/* 1357 */           attach.setAttachName(cont.getAttachmentPaths()[i]);
/*      */ 
/* 1359 */           attach.setFileName(cont.getAttachmentNames()[i]);
/* 1360 */           attach = transforAttach(attach, request);
/* 1361 */           attachList.add(attach);
/*      */         }
/*      */       }
/* 1364 */       cont.setArticleAttachs(attachList);
/*      */     }
/* 1366 */     if (null != cont.getPicPaths()) {
/* 1367 */       List attachList = new ArrayList();
/* 1368 */       int i = 0; for (int len = cont.getPicPaths().length; i < len; i++) {
/* 1369 */         if (!StringUtils.isBlank(cont.getPicPaths()[i])) {
/* 1370 */           Cms2Attach attach = new Cms2Attach();
/* 1371 */           attach.setObjId(cont.getId());
/*      */ 
/* 1374 */           attach.setPriority(Long.valueOf(i + 1L));
/* 1375 */           attach.setDownloadCount(Long.valueOf(0L));
/* 1376 */           attach.setStatus(EnumAttachStatus.PERMANENT.getValue());
/* 1377 */           attach.setAttachType(EnumAttachType.ARTICLE_PICTURES.getValue());
/* 1378 */           attach.setAttachName(cont.getPicPaths()[i]);
/*      */ 
/* 1380 */           attach.setRemark(cont.getPicDescs()[i]);
/* 1381 */           attach = transforAttach(attach, request);
/* 1382 */           attachList.add(attach);
/*      */         }
/*      */       }
/*      */ 
/* 1386 */       cont.setArticlePics(attachList);
/*      */     }
/* 1388 */     return cont;
/*      */   }
/*      */ 
/*      */   private List<EnumContCurrentStatus> getUserStatus(Long siteId, Long adminId)
/*      */   {
/* 1395 */     boolean flag = true;
/* 1396 */     Integer count = this.cms2ChannelUserService.getCountsForUserFinalStep(adminId, siteId, null);
/* 1397 */     if ((count == null) || (count.intValue() <= 0)) {
/* 1398 */       Cms2UserSiteQuery userSiteQuery = new Cms2UserSiteQuery();
/* 1399 */       userSiteQuery.setAdminId(new StringBuilder().append("").append(adminId).toString());
/* 1400 */       userSiteQuery.setSiteId(new StringBuilder().append("").append(siteId).toString());
/* 1401 */       List userSiteList = this.cms2UserSiteService.queryCms2UserSiteList(userSiteQuery);
/* 1402 */       if ((userSiteList != null) && (userSiteList.size() > 0)) {
/* 1403 */         Cms2UserSite userSite = (Cms2UserSite)userSiteList.get(0);
/* 1404 */         if ((userSite.getCheckStep() == null) || (userSite.getCheckStep().compareTo(Long.valueOf(0L)) <= 0))
/* 1405 */           flag = false;
/*      */       } else {
/* 1407 */         flag = false;
/*      */       }
/*      */     } else {
/* 1409 */       count = this.cms2ChannelUserService.getCountsForUserFinalStep(adminId, siteId, Long.valueOf(0L));
/* 1410 */       if ((count == null) || (count.intValue() <= 0))
/* 1411 */         flag = false;
/*      */     }
/* 1413 */     if (flag) {
/* 1414 */       return EnumContCurrentStatus.adminList();
/*      */     }
/* 1416 */     return EnumContCurrentStatus.publisherList();
/*      */   }
/*      */ 
/*      */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.CONT_MOVE})
/*      */   @RequestMapping({"/cont/moveContents"})
/*      */   public String moveContents(@RequestParam(value="q", required=false, defaultValue="") String queryStr, String contIds, Long moveChannel, Long targetChannel, Model model, SettlerAgent settlerAgent, HttpServletRequest request)
/*      */   {
/* 1427 */     model.addAttribute("q", queryStr);
/*      */ 
/* 1429 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/* 1430 */     if ((siteId == null) || (!siteId.equals(siteId))) {
/* 1431 */       return super.error(model, "", "", null);
/*      */     }
/*      */ 
/* 1434 */     String[] ids = null;
/* 1435 */     if (!StringUtil.isBlank(contIds)) {
/* 1436 */       if (contIds.endsWith(","))
/* 1437 */         contIds = contIds.substring(0, contIds.lastIndexOf(","));
/* 1438 */       ids = contIds.split(",");
/*      */     }
/* 1440 */     if ((ids == null) || (ids.length <= 0)) {
/* 1441 */       if ((moveChannel == null) || (moveChannel.compareTo(Long.valueOf(0L)) <= 0)) {
/* 1442 */         return super.error(model, "文章迁移失败,请选择迁移文章", "", "/cont/list.htm");
/*      */       }
/* 1444 */       if (moveChannel.compareTo(targetChannel) == 0) {
/* 1445 */         return super.error(model, "文章迁移失败,同一栏目下不允许迁移", "", "/cont/list.htm");
/*      */       }
/* 1447 */       Cms2ContQuery query = new Cms2ContQuery();
/* 1448 */       query.setChannelId(moveChannel.toString());
/* 1449 */       List<Cms2Cont> contList = this.cms2ContService.selectList(query);
/* 1450 */       this.cms2ContService.batchMoveContent(targetChannel, moveChannel, null);
/* 1451 */       for (Cms2Cont cont : contList)
/*      */       {
/* 1453 */         Cms2Job cms2Job = new Cms2Job(siteId, EnumStaticType.CONTENT_STATIC.getType(), cont.getId(), EnumStaticOper.MODIFY_STATIC.getType(), Long.valueOf(0L), "", null);
/* 1454 */         this.cms2JobService.save(cms2Job);
/*      */       }
/*      */ 
/* 1458 */       Cms2Job cms2Job = new Cms2Job(siteId, EnumStaticType.CHANNEL_STATIC.getType(), moveChannel, EnumStaticOper.MODIFY_STATIC.getType(), Long.valueOf(0L), "", null);
/* 1459 */       this.cms2JobService.save(cms2Job);
/*      */     }
/*      */     else {
/* 1462 */       this.cms2ContService.batchMoveContent(targetChannel, null, ids);
/* 1463 */       for (String id : ids)
/*      */       {
/* 1465 */         Cms2Job cms2Job = new Cms2Job(siteId, EnumStaticType.CONTENT_STATIC.getType(), Long.valueOf(Long.parseLong(id)), EnumStaticOper.MODIFY_STATIC.getType(), Long.valueOf(0L), "", null);
/* 1466 */         this.cms2JobService.save(cms2Job);
/*      */       }
/*      */ 
/* 1469 */       List<Long> channelIds = this.cms2ContService.queryChannelIdsByContentIds(ids);
/* 1470 */       for (Long channelId : channelIds)
/*      */       {
/* 1472 */         Cms2Job cms2Job = new Cms2Job(siteId, EnumStaticType.CHANNEL_STATIC.getType(), channelId, EnumStaticOper.MODIFY_STATIC.getType(), Long.valueOf(0L), "", null);
/* 1473 */         this.cms2JobService.save(cms2Job);
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1480 */     super.addLog(request, settlerAgent, Cms2Utils.getCurrentSiteId(request), "文章迁移", targetChannel.toString(), "文章迁入成功");
/* 1481 */     return super.success(model, "迁移成功", "/cont/list.htm");
/*      */   }
/*      */ 
/*      */   @RequestMapping(value={"/cont/ajaxTitleSwitch"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*      */   @ResponseBody
/*      */   public Model ajaxTitleSwitch(String title, Long contId, Model model)
/*      */   {
/* 1490 */     boolean flag = false;
/* 1491 */     if (StringUtil.isNotBlank(title))
/* 1492 */       flag = this.cms2ContService.ajaxTitleSwitch(contId, title);
/* 1493 */     model.addAttribute("message", Boolean.valueOf(flag));
/* 1494 */     return model;
/*      */   }
/*      */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy\cmsAdmin\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.admin.action.ContAction
 * JD-Core Version:    0.6.0
 */