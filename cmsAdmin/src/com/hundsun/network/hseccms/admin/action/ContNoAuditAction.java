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
/*      */ import com.hundsun.network.hseccms.enums.EnumStaticOper;
/*      */ import com.hundsun.network.hseccms.enums.EnumStaticType;
/*      */ import com.hundsun.network.hseccms.model.Cms2Attach;
/*      */ import com.hundsun.network.hseccms.model.Cms2Channel;
/*      */ import com.hundsun.network.hseccms.model.Cms2Cont;
/*      */ import com.hundsun.network.hseccms.model.Cms2ContAll;
/*      */ import com.hundsun.network.hseccms.model.Cms2ContCheck;
/*      */ import com.hundsun.network.hseccms.model.Cms2ContExt;
/*      */ import com.hundsun.network.hseccms.model.Cms2Job;
/*      */ import com.hundsun.network.hseccms.model.Cms2JobTiming;
/*      */ import com.hundsun.network.hseccms.model.Cms2Model;
/*      */ import com.hundsun.network.hseccms.model.Cms2Site;
/*      */ import com.hundsun.network.hseccms.query.Cms2ContCheckQuery;
/*      */ import com.hundsun.network.hseccms.query.Cms2ContQuery;
/*      */ import com.hundsun.network.hseccms.query.Cms2JobTimingQuery;
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
/*      */ public class ContNoAuditAction extends BaseAction
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
/*  105 */     DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*  106 */     dateFormat.setLenient(false);
/*  107 */     binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
/*      */   }
/*      */ 
/*      */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.CONT_MANAGE_NOAUDIT})
/*      */   @RequestMapping({"/contNoAudit/index"})
/*      */   public String index(Model model)
/*      */   {
/*  145 */     return "/contNoAudit/index";
/*      */   }
/*  151 */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.CONT_MANAGE_NOAUDIT})
/*      */   @RequestMapping({"/contNoAudit/tree"})
/*      */   public String tree(Model model, HttpServletRequest request) { Long siteId = Cms2Utils.getCurrentSiteId(request);
/*  152 */     Cms2Site site = this.cms2SiteService.queryById(siteId);
/*  153 */     List list = this.cms2ChannelService.getWholeTreeBySite(site.getId());
/*  154 */     model.addAttribute("list", list);
/*  155 */     return "/contNoAudit/tree"; }
/*      */ 
/*      */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.CONT_MANAGE_NOAUDIT})
/*      */   @RequestMapping({"/contNoAudit/list"})
/*      */   public String list(@RequestParam(value="q", required=false, defaultValue="") String queryStr, Model model, HttpServletRequest request, Cms2ContQuery query, SettlerAgent settlerAgent)
/*      */   {
/*  163 */     if (StringUtil.isNotEmpty(queryStr)) {
/*  164 */       query = (Cms2ContQuery)query.riseUp(queryStr);
/*      */     }
/*  166 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/*  167 */     Cms2Site site = this.cms2SiteService.queryById(siteId);
/*  168 */     List currentStatusList = getUserStatus(site.getId(), Long.valueOf(settlerAgent.getId()));
/*  169 */     if ((null == query.getCurrentStatus()) || (query.getCurrentStatus().equals(""))) {
/*  170 */       if (currentStatusList.size() == EnumContCurrentStatus.enumCounts()) {
/*  171 */         query.setCurrentStatus(EnumContCurrentStatus.AUDITING.getCode().toString());
/*      */       } else {
/*  173 */         String adminName = StringUtil.isNotBlank(settlerAgent.getName()) ? settlerAgent.getName() : settlerAgent.getUserAccount();
/*  174 */         query.setAdminName(adminName);
/*  175 */         query.setCurrentStatus(EnumContCurrentStatus.DRAFT.getCode().toString());
/*      */       }
/*      */     }
/*  178 */     query.setOverReview(site.getOverReview());
/*  179 */     query.setUserId(Long.valueOf(settlerAgent.getId()));
/*  180 */     dealContStatus(query);
/*  181 */     if ((query != null) && (StringUtil.isNotBlank(query.getAdminName()))) {
/*  182 */       query.setMemberName(query.getAdminName());
/*      */     }
/*  184 */     String selectEndDate = null;
/*  185 */     if (StringUtil.isNotBlank(query.getReleaseDateEnd())) {
/*  186 */       selectEndDate = query.getReleaseDateEnd();
/*  187 */       query.setReleaseDateEnd(new StringBuilder().append(query.getReleaseDateEnd()).append(" 23:59:59").toString());
/*      */     }
/*      */ 
/*  190 */     if (StringUtil.isBlank(query.getOrderCondition()))
/*      */     {
/*  192 */       query.setOrderBy(EnumContOrderCondition.GMT_MODIFY.getContAttrName());
/*  193 */       query.setOrderAsc(EnumContOrderByMethod.DESC.getValue());
/*  194 */       query.setOrderCondition(EnumContOrderCondition.GMT_MODIFY.getContAttrName());
/*  195 */       query.setOrderMethod(EnumContOrderByMethod.DESC.getValue());
/*      */     }
/*      */     else {
/*  198 */       if (StringUtil.isBlank(query.getOrderMethod()))
/*  199 */         query.setOrderAsc(EnumContOrderByMethod.DESC.getValue());
/*      */       else {
/*  201 */         query.setOrderAsc(query.getOrderMethod());
/*      */       }
/*  203 */       if (EnumContOrderCondition.COPYWRITER.getContAttrName().equalsIgnoreCase(query.getOrderCondition())) {
/*  204 */         if (EnumContOrderByMethod.DESC.getValue().equalsIgnoreCase(query.getOrderAsc()))
/*  205 */           query.setOrderBy(new StringBuilder().append(" CONT.ADMIN_NAME ").append(query.getOrderAsc()).append(", CONT.MEMBER_NAME ").toString());
/*      */         else
/*  207 */           query.setOrderBy(new StringBuilder().append(" CONT.MEMBER_NAME ").append(query.getOrderAsc()).append(", CONT.ADMIN_NAME ").toString());
/*      */       }
/*  209 */       else query.setOrderBy(query.getOrderCondition());
/*      */     }
/*      */ 
/*  212 */     query = this.cms2ContService.selectPageAdmin(query);
/*  213 */     List channelIdList = new ArrayList();
/*  214 */     List<Cms2Cont> contList = (List<Cms2Cont>) query.getItems();
/*      */     Cms2ContCheckQuery contCheckQuery;
/*      */     List cms2ContCheckList;
/*  215 */     if ((null != contList) && (contList.size() > 0)) {
/*  216 */       contCheckQuery = new Cms2ContCheckQuery();
/*  217 */       cms2ContCheckList = null;
/*  218 */       for (Cms2Cont cont : contList) {
/*  219 */         channelIdList.add(cont.getChannelId());
/*  220 */         contCheckQuery.setContentId(cont.getId().toString());
/*  221 */         cms2ContCheckList = this.cms2ContCheckService.queryCms2ContCheckList(contCheckQuery);
/*  222 */         if ((cms2ContCheckList != null) && (cms2ContCheckList.size() > 0))
/*  223 */           cont.setContCheck((Cms2ContCheck)cms2ContCheckList.get(0));
/*  224 */         cont.setSite(site);
/*  225 */         cont.setCurrentStatus(query.getCurrentStatus());
/*      */       }
/*      */     }
/*  228 */     List channelList = new ArrayList();
/*  229 */     if ((null != channelIdList) && (channelIdList.size() > 0)) {
/*  230 */       channelList = this.cms2ChannelService.queryChannelListByIds(channelIdList);
/*      */     }
/*  232 */     Cms2Channel channel = new Cms2Channel();
/*  233 */     if ((null != query.getChannelId()) && (!query.getChannelId().equals(""))) {
/*  234 */       channel = this.cms2ChannelService.queryById(Long.valueOf(Long.parseLong(query.getChannelId())));
/*      */ 
/*  236 */       boolean hasChild = false;
/*  237 */       if (!hasChild) {
/*  238 */         Cms2Model cmsModel = this.cms2ModelService.queryById(channel.getModelId());
/*  239 */         model.addAttribute("model", cmsModel);
/*      */       }
/*  241 */       model.addAttribute("hasChild", Boolean.valueOf(hasChild));
/*      */     }
/*  243 */     if (StringUtil.isNotBlank(query.getReleaseDateEnd())) {
/*  244 */       query.setReleaseDateEnd(selectEndDate);
/*      */     }
/*  246 */     model.addAttribute("isCycle", Boolean.valueOf(EnumContStatus.CYCLE.getCode().toString().equals(query.getStatus())));
/*  247 */     model.addAttribute("channel", channel);
/*  248 */     model.addAttribute("query", query);
/*  249 */     model.addAttribute("channelList", channelList);
/*  250 */     model.addAttribute("wholeChannelList", this.cms2ChannelService.getWholeTreeBySite(siteId));
/*  251 */     model.addAttribute("statusList", currentStatusList);
/*      */ 
/*  253 */     model.addAttribute("orderCondition", EnumContOrderCondition.toList());
/*  254 */     model.addAttribute("orderMethod", EnumContOrderByMethod.toList());
/*  255 */     return "/contNoAudit/list";
/*      */   }
/*      */ 
/*      */   private void dealContStatus(Cms2ContQuery query)
/*      */   {
/*  262 */     short currentStatus = Short.parseShort(query.getCurrentStatus());
/*  263 */     if (currentStatus == 0)
/*  264 */       return;
/*  265 */     switch (currentStatus) { case 1:
/*  266 */       query.setStatus(EnumContStatus.DRAFT.getCode().toString()); break;
/*      */     case 5:
/*  267 */       query.setStatus(EnumContStatus.FINISH.getCode().toString()); break;
/*      */     case 7:
/*  268 */       query.setStatus(EnumContStatus.CYCLE.getCode().toString()); break;
/*      */     default:
/*  269 */       query.setStatus(EnumContStatus.AUDITING.getCode().toString());
/*      */     }
/*  271 */     if (EnumContCurrentStatus.REJECT.getCode().equals(Short.valueOf(currentStatus)))
/*  272 */       query.setIsRejected(EnumContIsRejected.REJECTED.getCode().toString());
/*      */     else
/*  274 */       query.setIsRejected(EnumContIsRejected.NOT_REJECTED.getCode().toString());
/*      */   }
/*      */ 
/*      */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.CONT_MANAGE_NOAUDIT})
/*      */   @RequestMapping({"/contNoAudit/add"})
/*      */   public String add(@RequestParam(value="q", required=false, defaultValue="") String queryStr, Model model, HttpServletRequest request, @ModelAttribute("titleImg") Cms2Attach articleTitleImg, @ModelAttribute("contImg") Cms2Attach articleContImg, @RequestParam("channelId") Long channelId, GenericUserAgent admin, SettlerAgent cmsAgent)
/*      */   {
/*  283 */     model.addAttribute("q", queryStr);
/*  284 */     Cms2Channel channel = null;
/*  285 */     if (channelId != null) {
/*  286 */       channel = this.cms2ChannelService.queryById(channelId);
/*      */     }
/*      */ 
/*  289 */     Cms2Model cmsModel = null;
/*  290 */     if (channel != null) {
/*  291 */       cmsModel = this.cms2ModelService.queryById(channel.getModelId());
/*  292 */       String com_message = null;
/*  293 */       if (new Integer(2).equals(cmsModel.getHasContent())) {
/*  294 */         com_message = "该栏目下不允许存在内容";
/*      */       }
/*  296 */       if (new Integer(0).equals(cmsModel.getHasContent())) {
/*  297 */         Cms2ContQuery query = new Cms2ContQuery();
/*  298 */         query.setChannelId(channelId.toString());
/*  299 */         query.setIsHide("1");
/*  300 */         List contentList = this.cms2ContService.selectList(query);
/*  301 */         if (contentList.size() >= 1)
/*  302 */           com_message = "该栏目下已存在文章或文章已放入回收站";
/*      */       }
/*  304 */       if (!StringUtil.isBlank(com_message))
/*  305 */         return error(model, com_message, "", request.getHeader("Referer"));
/*      */     }
/*      */     else {
/*  308 */       cmsModel = this.cms2ModelService.queryById(Long.valueOf(999L));
/*  309 */       if (cmsModel == null) {
/*  310 */         return error(model, "默认模板找不到", "", request.getHeader("Referer"));
/*      */       }
/*      */     }
/*      */ 
/*  314 */     List itemList = this.cms2ModelItemService.getItemListForContent(cmsModel.getId());
/*      */ 
/*  316 */     List channelList = new ArrayList();
/*  317 */     channelList.add(channel);
/*  318 */     model.addAttribute("cmsModel", cmsModel);
/*  319 */     model.addAttribute("itemList", itemList);
/*  320 */     model.addAttribute("channelList", channelList);
/*  321 */     model.addAttribute("channelId", channelId);
/*  322 */     model.addAttribute("channel", channel);
/*  323 */     Cms2ContAll cont = new Cms2ContAll();
/*  324 */     cont.setChannelId(channelId);
/*      */ 
/*  326 */     cont.setArticleAttachs(new ArrayList());
/*  327 */     cont.setArticlePics(new ArrayList());
/*  328 */     model.addAttribute("cont", cont);
/*  329 */     model.addAttribute("fileServerUrl", this.fileServerUrl);
/*  330 */     model.addAttribute("sysCode", this.sysCode);
/*  331 */     model.addAttribute("bizRule", this.bizRule);
/*  332 */     if (this.useFileUploadSystem)
/*      */     {
/*  334 */       FileRequest batchRequest = new FileRequest();
/*  335 */       batchRequest.setSysCode(this.sysCode);
/*  336 */       FileBatchResult batchResult = this.fileService.getBatch(batchRequest);
/*  337 */       if (batchResult.isError())
/*  338 */         model.addAttribute("message", "文件上传批次获取失败");
/*      */       else {
/*  340 */         model.addAttribute("batchId", batchResult.getBatchId());
/*      */       }
/*      */     }
/*  343 */     ResourceType type = ResourceType.getDefaultResourceTypeByExtName("jpg");
/*  344 */     model.addAttribute("resource", type.getPath());
/*  345 */     return "contNoAudit/add";
/*      */   }
/*      */ 
/*      */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.CONT_MANAGE_NOAUDIT})
/*      */   @RequestMapping({"/contNoAudit/save"})
/*      */   public String save(@RequestParam(value="q", required=false, defaultValue="") String queryStr, Model model, HttpServletRequest request, Cms2ContAll cont, @RequestParam(value="draft", required=false) Boolean draft, @RequestParam(value="bold", required=false) Boolean bold, @RequestParam(value="batchId", required=false) Long batchId, SettlerAgent cmsAgent, Cms2ContQuery query)
/*      */   {
/*  355 */     this._log.debug("========    in ContAction.save()!!! ========");
/*  356 */     model.addAttribute("q", queryStr);
/*  357 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/*  358 */     if ((siteId == null) || (!siteId.equals(siteId))) {
/*  359 */       return super.error(model, "", "", null);
/*      */     }
/*  361 */     cont.setSiteId(siteId);
/*  362 */     if ((bold != null) && (bold.booleanValue()))
/*  363 */       cont.setIsBold(EnumContIsBold.TRUE.getCode());
/*      */     else {
/*  365 */       cont.setIsBold(EnumContIsBold.FALSE.getCode());
/*      */     }
/*      */ 
/*  369 */     if (StringUtil.isNotBlank(cont.getSortDateStr())) {
/*  370 */       DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*      */       try {
/*  372 */         cont.setSortDate(dateFormat.parse(cont.getSortDateStr()));
/*      */       } catch (ParseException e) {
/*  374 */         return super.error(model, "排序时间格式不正确", "", "/contNoAudit/list.htm");
/*      */       }
/*      */     }
/*      */ 
/*  378 */     draft = Boolean.valueOf(draft == null ? true : draft.booleanValue());
/*      */ 
/*  380 */     if ((draft != null) && (draft.booleanValue())) {
/*  381 */       cont.setStatus(EnumContStatus.DRAFT.getCode());
/*      */ 
/*  383 */       cont.setModifyTime(null);
/*      */     } else {
/*  385 */       cont.setStatus(EnumContStatus.FINISH.getCode());
/*  386 */       cont.setModifyTime(new Date());
/*      */     }
/*  388 */     if (cont.getTopLevel() == null)
/*  389 */       cont.setTopLevel(Integer.valueOf(0));
/*  390 */     if ((cont.getContExt() != null) && (cont.getContExt().getReleaseDate() == null))
/*  391 */       cont.getContExt().setReleaseDate(new Date());
/*  392 */     String message = "";
/*  393 */     cont = transforAllAttach(cont, request);
/*  394 */     if (null == cont.getId()) {
/*  395 */       cont.setAdminId(Long.valueOf(cmsAgent.getId()));
/*  396 */       String adminName = StringUtil.isNotBlank(cmsAgent.getName()) ? cmsAgent.getName() : cmsAgent.getUserAccount();
/*  397 */       cont.setAdminName(adminName);
/*  398 */       message = this.cms2ContService.save(cont);
/*  399 */       if (message.equals("")) {
/*  400 */         message = "增加成功!";
/*  401 */         super.addLog(request, cmsAgent, Cms2Utils.getCurrentSiteId(request), "文章增加", cont.getId().toString(), cont.getTitle());
/*      */       } else {
/*  403 */         return super.error(model, message, "", "/contNoAudit/list.htm");
/*      */       }
/*      */     } else {
/*  406 */       this.cms2ContService.update(cont);
/*  407 */       if (message.equals("")) {
/*  408 */         message = "修改成功!";
/*  409 */         super.addLog(request, cmsAgent, Cms2Utils.getCurrentSiteId(request), "文章修改", cont.getId().toString(), cont.getTitle());
/*      */       } else {
/*  411 */         return super.error(model, message, "", "/contNoAudit/list.htm");
/*      */       }
/*      */     }
/*      */ 
/*  415 */     Cms2ContCheckQuery contCheckQuery = new Cms2ContCheckQuery();
/*  416 */     contCheckQuery.setContentId(cont.getId().toString());
/*  417 */     List cms2ContCheckList = this.cms2ContCheckService.queryCms2ContCheckList(contCheckQuery);
/*  418 */     if ((cms2ContCheckList != null) && (cms2ContCheckList.size() > 0)) {
/*  419 */       if ((draft != null) && (!draft.booleanValue())) {
/*  420 */         Cms2ContCheck cms2ContCheck = (Cms2ContCheck)cms2ContCheckList.get(0);
/*  421 */         cms2ContCheck.setCheckOpinion("");
/*  422 */         cms2ContCheck.setCheckStep(Long.valueOf(1L));
/*  423 */         cms2ContCheck.setIsRejected(EnumContIsRejected.NOT_REJECTED.getCode());
/*  424 */         this.cms2ContCheckService.updateByAllProperity(cms2ContCheck);
/*      */       }
/*      */ 
/*  427 */       Cms2Job cms2Job = new Cms2Job(siteId, EnumStaticType.CONTENT_STATIC.getType(), cont.getId(), EnumStaticOper.MODIFY_STATIC.getType(), Long.valueOf(0L), "", null);
/*  428 */       this.cms2JobService.save(cms2Job);
/*      */ 
/*  431 */       Cms2JobTiming cms2JobStartTiming = new Cms2JobTiming(siteId, EnumJobTimingObj.OBJ_TYPE_CONTENT.getType(), cont.getId(), cont.getReleaseDate(), EnumJobTimingType.OBJ_OPER_START_TIME.getType());
/*  432 */       this.cms2JobTimingService.save(cms2JobStartTiming);
/*      */     } else {
/*  434 */       Cms2ContCheck contCheck = new Cms2ContCheck();
/*  435 */       if ((draft != null) && (!draft.booleanValue()));
/*  438 */       contCheck.setCheckStep(Long.valueOf(1L));
/*  439 */       contCheck.setIsRejected(EnumContIsRejected.NOT_REJECTED.getCode());
/*  440 */       contCheck.setContentId(cont.getId());
/*  441 */       this.cms2ContCheckService.insert(contCheck);
/*      */ 
/*  443 */       Cms2Job cms2Job = new Cms2Job(siteId, EnumStaticType.CONTENT_STATIC.getType(), cont.getId(), EnumStaticOper.ADD_STATIC.getType(), Long.valueOf(0L), "", null);
/*  444 */       this.cms2JobService.save(cms2Job);
/*      */ 
/*  447 */       Cms2JobTiming cms2JobStartTiming = new Cms2JobTiming(siteId, EnumJobTimingObj.OBJ_TYPE_CONTENT.getType(), cont.getId(), cont.getReleaseDate(), EnumJobTimingType.OBJ_OPER_START_TIME.getType());
/*  448 */       this.cms2JobTimingService.save(cms2JobStartTiming);
/*      */     }
/*      */ 
/*  451 */     return super.success(model, message, "/contNoAudit/list.htm");
/*      */   }
/*      */ 
/*      */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.CONT_MANAGE_NOAUDIT})
/*      */   @RequestMapping({"/contNoAudit/edit"})
/*      */   public String edit(@RequestParam(value="q", required=false, defaultValue="") String queryStr, Model model, HttpServletRequest request, SettlerAgent admin, @RequestParam("id") Long id, @RequestParam(value="channelId", required=false) Long channelId) {
/*  459 */     Cms2ContAll cont = this.cms2ContService.selectAllById(id);
/*  460 */     model.addAttribute("q", queryStr);
/*  461 */     Cms2Channel channel = null;
/*  462 */     if (cont != null) {
/*  463 */       channel = this.cms2ChannelService.queryById(cont.getChannelId());
/*      */     }
/*      */ 
/*  466 */     Cms2Model cmsModel = null;
/*  467 */     if (channel != null) {
/*  468 */       cmsModel = this.cms2ModelService.queryById(channel.getModelId());
/*  469 */       String com_message = null;
/*  470 */       if (new Integer(2).equals(cmsModel.getHasContent())) {
/*  471 */         com_message = "该栏目下不允许存在内容";
/*      */       }
/*  473 */       if (new Integer(0).equals(cmsModel.getHasContent())) {
/*  474 */         Cms2ContQuery query = new Cms2ContQuery();
/*  475 */         query.setChannelId(channel.getId().toString());
/*  476 */         query.setIsHide("1");
/*  477 */         List contentList = this.cms2ContService.selectList(query);
/*  478 */         if (contentList.size() >= 1)
/*  479 */           com_message = "该栏目下已存在文章或文章已放入回收站";
/*      */       }
/*  481 */       if (!StringUtil.isBlank(com_message))
/*  482 */         return error(model, com_message, "", request.getHeader("Referer"));
/*      */     }
/*      */     else {
/*  485 */       cmsModel = this.cms2ModelService.queryById(Long.valueOf(999L));
/*  486 */       if (cmsModel == null) {
/*  487 */         return error(model, "默认模板找不到", "", request.getHeader("Referer"));
/*      */       }
/*      */     }
/*      */ 
/*  491 */     List itemList = this.cms2ModelItemService.getItemListForContent(cmsModel.getId());
/*      */ 
/*  493 */     List channelList = new ArrayList();
/*  494 */     channelList.add(channel);
/*  495 */     model.addAttribute("cmsModel", cmsModel);
/*  496 */     model.addAttribute("itemList", itemList);
/*  497 */     model.addAttribute("channelList", channelList);
/*  498 */     model.addAttribute("channelId", channelId);
/*  499 */     model.addAttribute("channel", channel);
/*  500 */     model.addAttribute("cont", cont);
/*      */ 
/*  502 */     model.addAttribute("fileServerUrl", this.fileServerUrl);
/*  503 */     model.addAttribute("sysCode", this.sysCode);
/*  504 */     model.addAttribute("bizRule", this.bizRule);
/*      */ 
/*  506 */     Cms2ContCheckQuery contCheckQuery = new Cms2ContCheckQuery();
/*  507 */     contCheckQuery.setContentId(cont.getId().toString());
/*  508 */     List cms2ContCheckList = this.cms2ContCheckService.queryCms2ContCheckList(contCheckQuery);
/*  509 */     Cms2ContCheck cms2ContCheck = null;
/*  510 */     if ((cms2ContCheckList != null) && (cms2ContCheckList.size() > 0))
/*  511 */       cms2ContCheck = (Cms2ContCheck)cms2ContCheckList.get(0);
/*  512 */     model.addAttribute("contCurrentStep", cms2ContCheck.getCheckStep());
/*  513 */     model.addAttribute("cms2ContCheck", cms2ContCheck);
/*      */ 
/*  515 */     if (this.useFileUploadSystem)
/*      */     {
/*  517 */       FileRequest batchRequest = new FileRequest();
/*  518 */       batchRequest.setSysCode(this.sysCode);
/*  519 */       FileBatchResult batchResult = this.fileService.getBatch(batchRequest);
/*  520 */       if (batchResult.isError())
/*  521 */         model.addAttribute("message", "文件上传批次获取失败");
/*      */       else {
/*  523 */         model.addAttribute("batchId", batchResult.getBatchId());
/*      */       }
/*      */     }
/*  526 */     return "/contNoAudit/edit";
/*      */   }
/*      */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.CONT_MANAGE_NOAUDIT})
/*      */   @RequestMapping({"/contNoAudit/view"})
/*      */   public String view(Model model, HttpServletRequest request, SettlerAgent admin, @RequestParam("id") Long id) {
/*  533 */     String url = this.cms2ContService.getUrlById(id);
/*  534 */     return new StringBuilder().append("redirect:").append(url).append("?visit=1").toString();
/*      */   }
/*      */ 
/*      */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.CONT_MANAGE_NOAUDIT})
/*      */   @RequestMapping({"/contNoAudit/del"})
/*      */   public String del(@RequestParam(value="q", required=false, defaultValue="") String queryStr, Model model, HttpServletRequest request, SettlerAgent cmsAgent, @RequestParam("id") String id, Cms2ContQuery query) {
/*  542 */     model.addAttribute("q", queryStr);
/*  543 */     String message = this.cms2ContService.deleteById(id);
/*  544 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/*  545 */     if (message.equals("delete"))
/*      */     {
/*  547 */       Cms2Job cms2Job = new Cms2Job(siteId, EnumStaticType.CONTENT_STATIC.getType(), Long.valueOf(Long.parseLong(id)), EnumStaticOper.DELETE_STATIC.getType(), Long.valueOf(0L), "", null);
/*  548 */       this.cms2JobService.save(cms2Job);
/*      */ 
/*  551 */       Cms2JobTimingQuery cms2JobTimingQuery = new Cms2JobTimingQuery();
/*  552 */       cms2JobTimingQuery.setObjId(id);
/*  553 */       cms2JobTimingQuery.setObjType(EnumJobTimingObj.OBJ_TYPE_CONTENT.getType().toString());
/*  554 */       cms2JobTimingQuery.setSiteId(siteId.toString());
/*      */ 
/*  556 */       cms2JobTimingQuery.setObjOper(EnumJobTimingType.OBJ_OPER_START_TIME.getType().toString());
/*  557 */       this.cms2JobTimingService.delete(cms2JobTimingQuery);
/*      */ 
/*  559 */       super.addLog(request, cmsAgent, Cms2Utils.getCurrentSiteId(request), "文章删除", id, "文章删除成功");
/*  560 */     } else if (message.equals("recycle"))
/*      */     {
/*  562 */       Cms2Job cms2Job = new Cms2Job(siteId, EnumStaticType.CONTENT_STATIC.getType(), Long.valueOf(Long.parseLong(id)), EnumStaticOper.CYCLE_STATIC.getType(), Long.valueOf(0L), "", null);
/*  563 */       this.cms2JobService.save(cms2Job);
/*      */ 
/*  566 */       Cms2JobTimingQuery cms2JobTimingQuery = new Cms2JobTimingQuery();
/*  567 */       cms2JobTimingQuery.setObjId(id);
/*  568 */       cms2JobTimingQuery.setObjType(EnumJobTimingObj.OBJ_TYPE_CONTENT.getType().toString());
/*  569 */       cms2JobTimingQuery.setSiteId(siteId.toString());
/*      */ 
/*  571 */       cms2JobTimingQuery.setObjOper(EnumJobTimingType.OBJ_OPER_START_TIME.getType().toString());
/*  572 */       this.cms2JobTimingService.delete(cms2JobTimingQuery);
/*      */ 
/*  574 */       super.addLog(request, cmsAgent, Cms2Utils.getCurrentSiteId(request), "文章删除", id, "文章删除成功");
/*      */     } else {
/*  576 */       return super.error(model, message, "", "/contNoAudit/list.htm");
/*      */     }
/*  578 */     message = "删除成功";
/*  579 */     return super.success(model, message, "/contNoAudit/list.htm");
/*      */   }
/*      */ 
/*      */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.CONT_MANAGE_NOAUDIT})
/*      */   @RequestMapping({"/contNoAudit/delByList"})
/*      */   public String delByList(@RequestParam(value="q", required=false, defaultValue="") String queryStr, Model model, HttpServletRequest request, SettlerAgent cmsAgent, @RequestParam(value="ids", required=false) List<String> idList, Cms2ContQuery query) {
/*  587 */     model.addAttribute("q", queryStr);
/*  588 */     List idListUnique = getUnique(idList);
/*  589 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/*  590 */     String message = this.cms2ContService.deleteByIds(idListUnique);
/*  591 */     if (message.equals("delete")) {
/*  592 */       for (String id : idList)
/*      */       {
/*  594 */         Cms2Job cms2Job = new Cms2Job(siteId, EnumStaticType.CONTENT_STATIC.getType(), Long.valueOf(Long.parseLong(id)), EnumStaticOper.DELETE_STATIC.getType(), Long.valueOf(0L), "", null);
/*  595 */         this.cms2JobService.save(cms2Job);
/*      */ 
/*  598 */         Cms2JobTimingQuery cms2JobTimingQuery = new Cms2JobTimingQuery();
/*  599 */         cms2JobTimingQuery.setObjId(id);
/*  600 */         cms2JobTimingQuery.setObjType(EnumJobTimingObj.OBJ_TYPE_CONTENT.getType().toString());
/*  601 */         cms2JobTimingQuery.setSiteId(siteId.toString());
/*      */ 
/*  603 */         cms2JobTimingQuery.setObjOper(EnumJobTimingType.OBJ_OPER_START_TIME.getType().toString());
/*  604 */         this.cms2JobTimingService.delete(cms2JobTimingQuery);
/*      */       }
/*      */ 
/*  607 */       super.addLog(request, cmsAgent, Cms2Utils.getCurrentSiteId(request), "文章删除", idListUnique.toString(), "文章批量删除成功");
/*  608 */     } else if (message.equals("recycle")) {
/*  609 */       for (String id : idList)
/*      */       {
/*  611 */         Cms2Job cms2Job = new Cms2Job(siteId, EnumStaticType.CONTENT_STATIC.getType(), Long.valueOf(Long.parseLong(id)), EnumStaticOper.CYCLE_STATIC.getType(), Long.valueOf(0L), "", null);
/*  612 */         this.cms2JobService.save(cms2Job);
/*      */ 
/*  615 */         Cms2JobTimingQuery cms2JobTimingQuery = new Cms2JobTimingQuery();
/*  616 */         cms2JobTimingQuery.setObjId(id);
/*  617 */         cms2JobTimingQuery.setObjType(EnumJobTimingObj.OBJ_TYPE_CONTENT.getType().toString());
/*  618 */         cms2JobTimingQuery.setSiteId(siteId.toString());
/*      */ 
/*  620 */         cms2JobTimingQuery.setObjOper(EnumJobTimingType.OBJ_OPER_START_TIME.getType().toString());
/*  621 */         this.cms2JobTimingService.delete(cms2JobTimingQuery);
/*      */       }
/*  623 */       super.addLog(request, cmsAgent, Cms2Utils.getCurrentSiteId(request), "文章删除", idListUnique.toString(), "文章批量删除成功");
/*      */     } else {
/*  625 */       return super.error(model, message, "", "/contNoAudit/list.htm");
/*      */     }
/*  627 */     message = "删除成功";
/*  628 */     return super.success(model, message, "/contNoAudit/list.htm");
/*      */   }
/*      */ 
/*      */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.CONT_MANAGE_NOAUDIT})
/*      */   @RequestMapping({"/contNoAudit/delSeculity"})
/*      */   public String delSeculity(@RequestParam(value="q", required=false, defaultValue="") String queryStr, Model model, HttpServletRequest request, SettlerAgent cmsAgent, @RequestParam("id") String id, Cms2ContQuery query) {
/*  636 */     model.addAttribute("q", queryStr);
/*  637 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/*  638 */     String message = this.cms2ContService.deleteSeculityById(id);
/*  639 */     if (message.equals(""))
/*      */     {
/*  641 */       Cms2Job cms2Job = new Cms2Job(siteId, EnumStaticType.CONTENT_STATIC.getType(), Long.valueOf(Long.parseLong(id)), EnumStaticOper.DELETE_STATIC.getType(), Long.valueOf(0L), "", null);
/*  642 */       this.cms2JobService.save(cms2Job);
/*      */ 
/*  645 */       Cms2JobTimingQuery cms2JobTimingQuery = new Cms2JobTimingQuery();
/*  646 */       cms2JobTimingQuery.setObjId(id);
/*  647 */       cms2JobTimingQuery.setObjType(EnumJobTimingObj.OBJ_TYPE_CONTENT.getType().toString());
/*  648 */       cms2JobTimingQuery.setSiteId(siteId.toString());
/*      */ 
/*  650 */       cms2JobTimingQuery.setObjOper(EnumJobTimingType.OBJ_OPER_START_TIME.getType().toString());
/*  651 */       this.cms2JobTimingService.delete(cms2JobTimingQuery);
/*  652 */       super.addLog(request, cmsAgent, Cms2Utils.getCurrentSiteId(request), "文章彻底删除", id, "文章彻底删除成功");
/*      */     } else {
/*  654 */       return super.error(model, message, "", "/contNoAudit/list.htm");
/*      */     }
/*  656 */     message = "删除成功";
/*  657 */     return super.success(model, message, "/contNoAudit/list.htm");
/*      */   }
/*      */ 
/*      */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.CONT_MANAGE_NOAUDIT})
/*      */   @RequestMapping({"/contNoAudit/delSeculityByList"})
/*      */   public String delSeculityByList(@RequestParam(value="q", required=false, defaultValue="") String queryStr, Model model, HttpServletRequest request, SettlerAgent cmsAgent, @RequestParam(value="ids", required=false) List<String> idList, Cms2ContQuery query) {
/*  665 */     model.addAttribute("q", queryStr);
/*  666 */     List idListUnique = getUnique(idList);
/*  667 */     String message = this.cms2ContService.deleteSeculityByIds(idListUnique);
/*  668 */     if (message.equals(""))
/*  669 */       super.addLog(request, cmsAgent, Cms2Utils.getCurrentSiteId(request), "文章彻底删除", idListUnique.toString(), "批量文章彻底删除成功");
/*      */     else {
/*  671 */       return super.error(model, message, "", "/contNoAudit/list.htm");
/*      */     }
/*  673 */     message = "删除成功";
/*  674 */     return super.success(model, message, "/contNoAudit/list.htm");
/*      */   }
/*      */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.CONT_MANAGE_NOAUDIT})
/*      */   @RequestMapping({"/contNoAudit/restore"})
/*      */   public String restore(@RequestParam(value="q", required=false, defaultValue="") String queryStr, Model model, HttpServletRequest request, SettlerAgent cmsAgent, @RequestParam("id") String id, Cms2ContQuery query) {
/*  681 */     model.addAttribute("q", queryStr);
/*  682 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/*  683 */     String message = this.cms2ContService.restore(id);
/*  684 */     if (message.equals(""))
/*  685 */       super.addLog(request, cmsAgent, Cms2Utils.getCurrentSiteId(request), "文章恢复", id, "文章恢复成功");
/*      */     else {
/*  687 */       return super.error(model, message, "", "/contNoAudit/list.htm");
/*      */     }
/*      */ 
/*  691 */     Cms2Job cms2Job = new Cms2Job(siteId, EnumStaticType.CONTENT_STATIC.getType(), Long.valueOf(Long.parseLong(id)), EnumStaticOper.MODIFY_STATIC.getType(), Long.valueOf(0L), "", null);
/*  692 */     this.cms2JobService.save(cms2Job);
/*      */ 
/*  695 */     Cms2ContAll cont = this.cms2ContService.selectAllById(Long.valueOf(Long.parseLong(id)));
/*  696 */     Cms2JobTiming cms2JobStartTiming = new Cms2JobTiming(siteId, EnumJobTimingObj.OBJ_TYPE_CONTENT.getType(), Long.valueOf(Long.parseLong(id)), cont.getReleaseDate(), EnumJobTimingType.OBJ_OPER_START_TIME.getType());
/*  697 */     this.cms2JobTimingService.save(cms2JobStartTiming);
/*      */ 
/*  699 */     message = "还原成功";
/*  700 */     return super.success(model, message, "/contNoAudit/list.htm");
/*      */   }
/*      */ 
/*      */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.CONT_MANAGE_NOAUDIT})
/*      */   @RequestMapping({"/contNoAudit/batchPass"})
/*      */   public String batchPass(@RequestParam(value="q", required=false, defaultValue="") String queryStr, Model model, HttpServletRequest request, SettlerAgent cmsAgent, @RequestParam(value="ids", required=false) List<Long> idList, Cms2ContQuery query)
/*      */   {
/*  711 */     model.addAttribute("q", queryStr);
/*  712 */     String message = "";
/*  713 */     List contList = new ArrayList();
/*  714 */     List contCheckList = new ArrayList();
/*  715 */     Cms2ContCheckQuery contCheckQuery = new Cms2ContCheckQuery();
/*  716 */     Cms2Cont cont = null;
/*  717 */     List cms2ContCheckList = null;
/*  718 */     Cms2ContCheck cms2ContCheck = null;
/*  719 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/*  720 */     for (Long id : idList) {
/*  721 */       cont = this.cms2ContService.selectById(id);
/*  722 */       contCheckQuery.setContentId(cont.getId().toString());
/*  723 */       cms2ContCheckList = this.cms2ContCheckService.queryCms2ContCheckList(contCheckQuery);
/*  724 */       if ((cms2ContCheckList != null) && (cms2ContCheckList.size() > 0))
/*      */       {
/*  726 */         cms2ContCheck = (Cms2ContCheck)cms2ContCheckList.get(0);
/*      */       }
/*  728 */       else cms2ContCheck = new Cms2ContCheck();
/*  729 */       if (StringUtil.isNotBlank(message))
/*  730 */         return super.error(model, message, "", "/contNoAudit/list.htm");
/*  731 */       contList.add(cont);
/*  732 */       contCheckList.add(cms2ContCheck);
/*      */     }
/*      */ 
/*  735 */     Cms2Channel channel = null;
/*  736 */     Cms2Model cms2Model = null;
/*  737 */     List delContsList = null;
/*  738 */     Cms2Cont contTemp = new Cms2Cont();
/*  739 */     for (int i = 0; i < contList.size(); i++) {
/*  740 */       cont = (Cms2Cont)contList.get(i);
/*  741 */       cms2ContCheck = (Cms2ContCheck)contCheckList.get(i);
/*  742 */       cms2ContCheck.setCheckStep(Long.valueOf(1L));
/*  743 */       contTemp.setId(cont.getId());
/*  744 */       contTemp.setStatus(EnumContStatus.FINISH.getCode());
/*  745 */       contTemp.setModifyTime(new Date());
/*  746 */       this.cms2ContService.update(contTemp);
/*  747 */       this.cms2ContCheckService.update(cms2ContCheck);
/*  748 */       if ((cont != null) && (cont.getMemberId() != null) && (cont.getMemberId().compareTo(Long.valueOf(0L)) > 0)) {
/*  749 */         channel = this.cms2ChannelService.queryById(cont.getChannelId());
/*  750 */         cms2Model = this.cms2ModelService.queryById(channel.getModelId());
/*  751 */         if (EnumModelHasContent.MEMBER_ALONE.getCode().equals(cms2Model.getHasContent()))
/*      */         {
/*  753 */           delContsList = this.cms2ContService.queryAloneContIds(channel.getId(), cont.getMemberId(), cont.getId());
/*  754 */           this.cms2ContService.deleteSeculityByIds(delContsList);
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/*  759 */       Cms2Job cms2Job = new Cms2Job(siteId, EnumStaticType.CONTENT_STATIC.getType(), cont.getId(), EnumStaticOper.MODIFY_STATIC.getType(), Long.valueOf(0L), "", null);
/*  760 */       this.cms2JobService.save(cms2Job);
/*      */     }
/*      */ 
/*  763 */     message = "操作成功";
/*  764 */     return super.success(model, message, "/contNoAudit/list.htm");
/*      */   }
/*      */ 
/*      */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.CONT_MANAGE_NOAUDIT})
/*      */   @RequestMapping({"/contNoAudit/pass"})
/*      */   public String pass(@RequestParam(value="q", required=false, defaultValue="") String queryStr, Long id, Model model, SettlerAgent settlerAgent, HttpServletRequest request)
/*      */   {
/*  774 */     model.addAttribute("q", queryStr);
/*  775 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/*  776 */     if ((siteId == null) || (!siteId.equals(siteId))) {
/*  777 */       return super.error(model, "", "", null);
/*      */     }
/*  779 */     Cms2Cont cont = this.cms2ContService.selectById(id);
/*  780 */     if (!EnumContStatus.AUDITING.getCode().equals(cont.getStatus())) {
/*  781 */       return super.error(model, "审核失败,文章状态不正确", "", "/contNoAudit/list.htm");
/*      */     }
/*      */ 
/*  786 */     Cms2ContCheckQuery contCheckQuery = new Cms2ContCheckQuery();
/*  787 */     contCheckQuery.setContentId(cont.getId().toString());
/*  788 */     List cms2ContCheckList = this.cms2ContCheckService.queryCms2ContCheckList(contCheckQuery);
/*  789 */     if ((cms2ContCheckList != null) && (cms2ContCheckList.size() > 0))
/*      */     {
/*  791 */       Cms2ContCheck cms2ContCheck = (Cms2ContCheck)cms2ContCheckList.get(0);
/*      */ 
/*  793 */       cms2ContCheck.setCheckStep(Long.valueOf(1L));
/*  794 */       Cms2Cont contTemp = new Cms2Cont();
/*  795 */       contTemp.setId(id);
/*  796 */       contTemp.setStatus(EnumContStatus.FINISH.getCode());
/*  797 */       contTemp.setModifyTime(new Date());
/*  798 */       this.cms2ContService.update(contTemp);
/*  799 */       this.cms2ContCheckService.update(cms2ContCheck);
/*      */ 
/*  802 */       Cms2Job cms2Job = new Cms2Job(siteId, EnumStaticType.CONTENT_STATIC.getType(), cont.getId(), EnumStaticOper.MODIFY_STATIC.getType(), Long.valueOf(0L), "", null);
/*  803 */       this.cms2JobService.save(cms2Job);
/*      */     }
/*      */     else {
/*  806 */       Cms2ContCheck contCheck = new Cms2ContCheck();
/*  807 */       contCheck.setContentId(cont.getId());
/*  808 */       contCheck.setIsRejected(EnumContIsRejected.NOT_REJECTED.getCode());
/*      */ 
/*  810 */       contCheck.setCheckStep(Long.valueOf(1L));
/*  811 */       Cms2Cont contTemp = new Cms2Cont();
/*  812 */       contTemp.setId(id);
/*  813 */       contTemp.setStatus(EnumContStatus.FINISH.getCode());
/*  814 */       contTemp.setModifyTime(new Date());
/*  815 */       this.cms2ContService.update(contTemp);
/*  816 */       this.cms2ContCheckService.insert(contCheck);
/*      */ 
/*  819 */       Cms2Job cms2Job = new Cms2Job(siteId, EnumStaticType.CONTENT_STATIC.getType(), cont.getId(), EnumStaticOper.MODIFY_STATIC.getType(), Long.valueOf(0L), "", null);
/*  820 */       this.cms2JobService.save(cms2Job);
/*      */     }
/*  822 */     if ((cont != null) && (cont.getMemberId() != null) && (cont.getMemberId().compareTo(Long.valueOf(0L)) > 0)) {
/*  823 */       Cms2Channel channel = this.cms2ChannelService.queryById(cont.getChannelId());
/*  824 */       Cms2Model cms2Model = this.cms2ModelService.queryById(channel.getModelId());
/*      */ 
/*  826 */       if (EnumModelHasContent.MEMBER_ALONE.getCode().equals(cms2Model.getHasContent()))
/*      */       {
/*  828 */         List delContsList = this.cms2ContService.queryAloneContIds(channel.getId(), cont.getMemberId(), cont.getId());
/*  829 */         this.cms2ContService.deleteSeculityByIds(delContsList);
/*      */       }
/*      */ 
/*  833 */       Cms2Job cms2Job = new Cms2Job(siteId, EnumStaticType.CONTENT_STATIC.getType(), cont.getId(), EnumStaticOper.MODIFY_STATIC.getType(), Long.valueOf(0L), "", null);
/*  834 */       this.cms2JobService.save(cms2Job);
/*      */     }
/*  836 */     super.addLog(request, settlerAgent, Cms2Utils.getCurrentSiteId(request), "文章通过", id.toString(), "文章通过成功");
/*  837 */     return super.success(model, "审核成功", "/contNoAudit/list.htm");
/*      */   }
/*      */ 
/*      */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.CONT_MANAGE_NOAUDIT})
/*      */   @RequestMapping({"/contNoAudit/batchReject"})
/*      */   public String batchReject(@RequestParam(value="q", required=false, defaultValue="") String queryStr, @RequestParam(value="ids", required=false) List<Long> idList, Long rejectStep, String checkOpinion, Model model, SettlerAgent settlerAgent, HttpServletRequest request)
/*      */   {
/*  848 */     model.addAttribute("q", queryStr);
/*  849 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/*  850 */     List contList = new ArrayList();
/*  851 */     List contCheckList = new ArrayList();
/*  852 */     String message = null;
/*  853 */     Cms2Cont cont = null;
/*  854 */     Cms2ContCheckQuery contCheckQuery = new Cms2ContCheckQuery();
/*  855 */     List cms2ContCheckList = null;
/*  856 */     Cms2ContCheck cms2ContCheck = null;
/*  857 */     for (Long id : idList) {
/*  858 */       cont = this.cms2ContService.selectById(id);
/*  859 */       contCheckQuery.setContentId(cont.getId().toString());
/*  860 */       cms2ContCheckList = this.cms2ContCheckService.queryCms2ContCheckList(contCheckQuery);
/*  861 */       if ((cms2ContCheckList != null) && (cms2ContCheckList.size() > 0))
/*      */       {
/*  863 */         cms2ContCheck = (Cms2ContCheck)cms2ContCheckList.get(0);
/*      */       }
/*  865 */       else cms2ContCheck = new Cms2ContCheck();
/*  866 */       if (StringUtil.isNotBlank(message))
/*  867 */         return super.error(model, message, "", "/contNoAudit/list.htm");
/*  868 */       contList.add(cont);
/*  869 */       contCheckList.add(cms2ContCheck);
/*      */     }
/*      */ 
/*  872 */     cont = new Cms2Cont();
/*  873 */     StringBuilder sb = new StringBuilder();
/*  874 */     for (int i = 0; i < contCheckList.size(); i++) {
/*  875 */       cms2ContCheck = (Cms2ContCheck)contCheckList.get(i);
/*  876 */       cms2ContCheck.setCheckOpinion(checkOpinion);
/*  877 */       cms2ContCheck.setCheckStep(rejectStep);
/*  878 */       cms2ContCheck.setIsRejected(EnumContIsRejected.REJECTED.getCode());
/*  879 */       this.cms2ContCheckService.update(cms2ContCheck);
/*  880 */       if ((rejectStep == null) || (rejectStep.compareTo(Long.valueOf(0L)) == 0)) {
/*  881 */         cont.setId(((Cms2Cont)contList.get(i)).getId());
/*  882 */         cont.setStatus(EnumContStatus.DRAFT.getCode());
/*      */ 
/*  884 */         cont.setModifyTime(null);
/*  885 */         this.cms2ContService.update(cont);
/*      */       }
/*  887 */       sb.append(cms2ContCheck.getContentId());
/*  888 */       if (i + 1 < contCheckList.size()) {
/*  889 */         sb.append(",");
/*      */       }
/*      */ 
/*  892 */       Cms2Job cms2Job = new Cms2Job(siteId, EnumStaticType.CONTENT_STATIC.getType(), cont.getId(), EnumStaticOper.MODIFY_STATIC.getType(), Long.valueOf(0L), "", null);
/*  893 */       this.cms2JobService.save(cms2Job);
/*      */     }
/*  895 */     super.addLog(request, settlerAgent, Cms2Utils.getCurrentSiteId(request), "文章退回", sb.toString(), "文章退回成功");
/*  896 */     return super.success(model, "批量退回成功", "/contNoAudit/list.htm");
/*      */   }
/*      */ 
/*      */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.CONT_MANAGE_NOAUDIT})
/*      */   @RequestMapping({"/contNoAudit/reject"})
/*      */   public String reject(@RequestParam(value="q", required=false, defaultValue="") String queryStr, Long id, Long rejectStep, String checkOpinion, Model model, SettlerAgent settlerAgent, HttpServletRequest request)
/*      */   {
/*  907 */     model.addAttribute("q", queryStr);
/*      */ 
/*  909 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/*  910 */     if ((siteId == null) || (!siteId.equals(siteId))) {
/*  911 */       return super.error(model, "", "", null);
/*      */     }
/*      */ 
/*  914 */     Cms2Cont cont = this.cms2ContService.selectById(id);
/*      */ 
/*  916 */     Cms2ContCheckQuery contCheckQuery = new Cms2ContCheckQuery();
/*  917 */     contCheckQuery.setContentId(cont.getId().toString());
/*  918 */     List cms2ContCheckList = this.cms2ContCheckService.queryCms2ContCheckList(contCheckQuery);
/*  919 */     if ((cms2ContCheckList != null) && (cms2ContCheckList.size() > 0)) {
/*  920 */       Cms2ContCheck contCheck = (Cms2ContCheck)cms2ContCheckList.get(0);
/*  921 */       contCheck.setCheckOpinion(checkOpinion);
/*  922 */       contCheck.setCheckStep(rejectStep);
/*  923 */       contCheck.setIsRejected(EnumContIsRejected.REJECTED.getCode());
/*  924 */       this.cms2ContCheckService.update(contCheck);
/*      */     } else {
/*  926 */       Cms2ContCheck contCheck = new Cms2ContCheck();
/*  927 */       contCheck.setCheckOpinion(checkOpinion);
/*  928 */       contCheck.setCheckStep(rejectStep);
/*  929 */       contCheck.setContentId(cont.getId());
/*  930 */       contCheck.setIsRejected(EnumContIsRejected.REJECTED.getCode());
/*  931 */       this.cms2ContCheckService.insert(contCheck);
/*      */     }
/*  933 */     if ((rejectStep == null) || (rejectStep.compareTo(Long.valueOf(0L)) == 0)) {
/*  934 */       cont = new Cms2Cont();
/*  935 */       cont.setId(id);
/*  936 */       cont.setStatus(EnumContStatus.DRAFT.getCode());
/*      */ 
/*  938 */       cont.setModifyTime(null);
/*  939 */       this.cms2ContService.update(cont);
/*      */     }
/*      */ 
/*  942 */     Cms2Job cms2Job = new Cms2Job(siteId, EnumStaticType.CONTENT_STATIC.getType(), cont.getId(), EnumStaticOper.MODIFY_STATIC.getType(), Long.valueOf(0L), "", null);
/*  943 */     this.cms2JobService.save(cms2Job);
/*      */ 
/*  945 */     super.addLog(request, settlerAgent, Cms2Utils.getCurrentSiteId(request), "文章退回", id.toString(), "文章退回成功");
/*  946 */     return super.success(model, "退回成功", "/contNoAudit/list.htm");
/*      */   }
/*      */ 
/*      */   public Cms2Attach transforAttach(Cms2Attach attach, HttpServletRequest request) {
/*  950 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/*  951 */     Cms2Site site = this.cms2SiteService.queryById(siteId);
/*  952 */     String urlPrefix = new StringBuilder().append(this.uploadServerBroker.getConfig().getURL()).append(this.resSys).append(site.getResPath()).toString();
/*  953 */     if (attach != null) {
/*  954 */       String fileUlr = attach.getAttachName();
/*  955 */       int containsIndex = fileUlr.indexOf(urlPrefix);
/*  956 */       if (containsIndex != -1) {
/*  957 */         String filePath = fileUlr.substring(urlPrefix.length(), fileUlr.length());
/*  958 */         filePath = filePath.substring(0, filePath.lastIndexOf("/") + 1);
/*  959 */         String fileName = fileUlr.substring(fileUlr.lastIndexOf("/") + 1, fileUlr.length());
/*  960 */         attach.setAttachName(fileName);
/*  961 */         attach.setAttachPath(filePath);
/*      */       }
/*      */     }
/*  964 */     return attach;
/*      */   }
/*      */ 
/*      */   public Cms2ContAll transforAllAttach(Cms2ContAll cont, HttpServletRequest request) {
/*  968 */     if ((cont.getArticleTitleImg() != null) && (StringUtil.isNotBlank(cont.getArticleTitleImg().getAttachName())))
/*  969 */       cont.setArticleTitleImg(transforAttach(cont.getArticleTitleImg(), request));
/*      */     else {
/*  971 */       cont.setArticleTitleImg(null);
/*      */     }
/*  973 */     if ((cont.getArticleContImg() != null) && (StringUtil.isNotBlank(cont.getArticleContImg().getAttachName())))
/*  974 */       cont.setArticleContImg(transforAttach(cont.getArticleContImg(), request));
/*      */     else {
/*  976 */       cont.setArticleContImg(null);
/*      */     }
/*  978 */     if ((null != cont.getArticleMedia()) && (StringUtil.isNotBlank(cont.getArticleMedia().getAttachName())))
/*  979 */       cont.setArticleMedia(transforAttach(cont.getArticleMedia(), request));
/*      */     else {
/*  981 */       cont.setArticleMedia(null);
/*      */     }
/*  983 */     if (null != cont.getAttachmentPaths()) {
/*  984 */       List attachList = new ArrayList();
/*  985 */       int i = 0; for (int len = cont.getAttachmentPaths().length; i < len; i++) {
/*  986 */         if (!StringUtils.isBlank(cont.getAttachmentPaths()[i])) {
/*  987 */           Cms2Attach attach = new Cms2Attach();
/*  988 */           attach.setObjId(cont.getId());
/*      */ 
/*  991 */           attach.setPriority(Long.valueOf(i + 1L));
/*  992 */           attach.setDownloadCount(Long.valueOf(0L));
/*  993 */           attach.setStatus(EnumAttachStatus.PERMANENT.getValue());
/*  994 */           attach.setAttachType(EnumAttachType.ARTICLE_ATTACHS.getValue());
/*  995 */           attach.setAttachName(cont.getAttachmentPaths()[i]);
/*      */ 
/*  997 */           attach.setFileName(cont.getAttachmentNames()[i]);
/*  998 */           attach = transforAttach(attach, request);
/*  999 */           attachList.add(attach);
/*      */         }
/*      */       }
/* 1002 */       cont.setArticleAttachs(attachList);
/*      */     }
/* 1004 */     if (null != cont.getPicPaths()) {
/* 1005 */       List attachList = new ArrayList();
/* 1006 */       int i = 0; for (int len = cont.getPicPaths().length; i < len; i++) {
/* 1007 */         if (!StringUtils.isBlank(cont.getPicPaths()[i])) {
/* 1008 */           Cms2Attach attach = new Cms2Attach();
/* 1009 */           attach.setObjId(cont.getId());
/*      */ 
/* 1012 */           attach.setPriority(Long.valueOf(i + 1L));
/* 1013 */           attach.setDownloadCount(Long.valueOf(0L));
/* 1014 */           attach.setStatus(EnumAttachStatus.PERMANENT.getValue());
/* 1015 */           attach.setAttachType(EnumAttachType.ARTICLE_PICTURES.getValue());
/* 1016 */           attach.setAttachName(cont.getPicPaths()[i]);
/*      */ 
/* 1018 */           attach.setRemark(cont.getPicDescs()[i]);
/* 1019 */           attach = transforAttach(attach, request);
/* 1020 */           attachList.add(attach);
/*      */         }
/*      */       }
/*      */ 
/* 1024 */       cont.setArticlePics(attachList);
/*      */     }
/* 1026 */     return cont;
/*      */   }
/*      */ 
/*      */   private List<EnumContCurrentStatus> getUserStatus(Long siteId, Long adminId)
/*      */   {
/* 1033 */     return EnumContCurrentStatus.adminNoAuditList();
/*      */   }
/*      */ 
/*      */   @RequestMapping(value={"/contNoAudit/ajaxTitleSwitch"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*      */   @ResponseBody
/*      */   public Model ajaxTitleSwitch(String title, Long contId, Model model)
/*      */   {
/* 1042 */     boolean flag = false;
/* 1043 */     if (StringUtil.isNotBlank(title))
/* 1044 */       flag = this.cms2ContService.ajaxTitleSwitch(contId, title);
/* 1045 */     model.addAttribute("message", Boolean.valueOf(flag));
/* 1046 */     return model;
/*      */   }
/*      */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy\cmsAdmin\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.admin.action.ContNoAuditAction
 * JD-Core Version:    0.6.0
 */