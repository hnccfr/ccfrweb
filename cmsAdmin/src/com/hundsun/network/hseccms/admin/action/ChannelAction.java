/*     */ package com.hundsun.network.hseccms.admin.action;
/*     */ 
/*     */ import com.hundsun.network.hseccms.admin.security.SettlerAccess;
/*     */ import com.hundsun.network.hseccms.admin.security.SettlerAgent;
/*     */ import com.hundsun.network.hseccms.admin.util.Cms2Utils;
/*     */ import com.hundsun.network.hseccms.admin.validator.ChannelValidate;
/*     */ import com.hundsun.network.hseccms.enums.EnumAfterCheck;
/*     */ import com.hundsun.network.hseccms.enums.EnumChannelAllowUpdown;
/*     */ import com.hundsun.network.hseccms.enums.EnumChannelCopyCopy;
/*     */ import com.hundsun.network.hseccms.enums.EnumChannelCopyMain;
/*     */ import com.hundsun.network.hseccms.enums.EnumChannelIsParent;
/*     */ import com.hundsun.network.hseccms.enums.EnumChannelStatus;
/*     */ import com.hundsun.network.hseccms.enums.EnumCommentType;
/*     */ import com.hundsun.network.hseccms.enums.EnumHasImg;
/*     */ import com.hundsun.network.hseccms.enums.EnumIsBlank;
/*     */ import com.hundsun.network.hseccms.enums.EnumIsStatic;
/*     */ import com.hundsun.network.hseccms.enums.EnumSiteStaticRange;
/*     */ import com.hundsun.network.hseccms.enums.EnumStaticOper;
/*     */ import com.hundsun.network.hseccms.enums.EnumStaticType;
/*     */ import com.hundsun.network.hseccms.enums.EnumTplIsDir;
/*     */ import com.hundsun.network.hseccms.model.Cms2Channel;
/*     */ import com.hundsun.network.hseccms.model.Cms2ChannelExt;
/*     */ import com.hundsun.network.hseccms.model.Cms2Job;
/*     */ import com.hundsun.network.hseccms.model.Cms2Model;
/*     */ import com.hundsun.network.hseccms.model.Cms2ModelItem;
/*     */ import com.hundsun.network.hseccms.model.Cms2Site;
/*     */ import com.hundsun.network.hseccms.model.Cms2Template;
/*     */ import com.hundsun.network.hseccms.query.Cms2ChannelQuery;
/*     */ import com.hundsun.network.hseccms.service.Cms2ChannelAttrService;
/*     */ import com.hundsun.network.hseccms.service.Cms2ChannelExtService;
/*     */ import com.hundsun.network.hseccms.service.Cms2ChannelGroupService;
/*     */ import com.hundsun.network.hseccms.service.Cms2ChannelService;
/*     */ import com.hundsun.network.hseccms.service.Cms2ChannelUserService;
/*     */ import com.hundsun.network.hseccms.service.Cms2JobService;
/*     */ import com.hundsun.network.hseccms.service.Cms2ModelItemService;
/*     */ import com.hundsun.network.hseccms.service.Cms2ModelService;
/*     */ import com.hundsun.network.hseccms.service.Cms2SiteService;
/*     */ import com.hundsun.network.hseccms.service.Cms2TemplateService;
/*     */ import com.hundsun.network.hseccms.util.Cms2TreeSortTool;
/*     */ import com.hundsun.network.hseccms.util.RequestUtils;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ 
/*     */ @Controller
/*     */ @RequestMapping({"/channel"})
/*     */ public class ChannelAction extends BaseAction
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private Cms2ModelService cms2ModelService;
/*     */ 
/*     */   @Autowired
/*     */   private ChannelValidate channelValidate;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2ModelItemService cms2ModelItemService;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2ChannelService cms2ChannelService;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2SiteService cms2SiteService;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2ChannelExtService cms2ChannelExtService;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2ChannelGroupService cms2ChannelGroupService;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2ChannelAttrService cms2ChannelAttrService;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2ChannelUserService cms2ChannelUserService;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2TemplateService cms2TemplateService;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2JobService cms2JobService;
/*     */ 
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.CHANNEL_MANAGE})
/*     */   @RequestMapping(value={"/index"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String index()
/*     */   {
/* 104 */     return "channel/index";
/*     */   }
/*     */ 
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.CHANNEL_MANAGE})
/*     */   @RequestMapping(value={"/tree"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String tree(String root, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*     */   {
/* 114 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/* 115 */     Cms2Site site = this.cms2SiteService.queryById(siteId);
/* 116 */     List list = this.cms2ChannelService.getWholeTreeBySite(site.getId());
/* 117 */     model.addAttribute("list", list);
/* 118 */     return "channel/tree";
/*     */   }
/*     */ 
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.CHANNEL_MANAGE})
/*     */   @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String list(@RequestParam(value="q", required=false, defaultValue="") String queryStr, Cms2ChannelQuery query, HttpServletRequest request, Model model)
/*     */   {
/* 128 */     if (StringUtil.isNotEmpty(queryStr)) {
/* 129 */       query = (Cms2ChannelQuery)query.riseUp(queryStr);
/*     */     }
/* 131 */     model.addAttribute("q", queryStr);
/* 132 */     model.addAttribute("query", query);
/* 133 */     Long currentSiteId = Cms2Utils.getCurrentSiteId(request);
/* 134 */     List channelList = null;
/* 135 */     if ((StringUtil.isBlank(query.getParentId())) || (Long.parseLong(query.getParentId()) <= 0L))
/*     */     {
/* 137 */       channelList = this.cms2ChannelService.getTopListBySite(currentSiteId.longValue(), true);
/*     */     }
/* 139 */     else channelList = this.cms2ChannelService.queryListByParent(Long.parseLong(query.getParentId()), true);
/*     */ 
/* 141 */     List modelList = this.cms2ModelService.getEnabledModelList();
/* 142 */     model.addAttribute("parentId", query.getParentId());
/* 143 */     model.addAttribute("modelList", modelList);
/* 144 */     model.addAttribute("channelList", channelList);
/* 145 */     return "channel/list";
/*     */   }
/*     */ 
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.CHANNEL_ADD})
/*     */   @RequestMapping({"/add"})
/*     */   public String add(@RequestParam(value="q", required=false, defaultValue="") String queryStr, Long parentId, Long modelId, HttpServletRequest request, Model model)
/*     */   {
/* 158 */     model.addAttribute("q", queryStr);
/* 159 */     Long currentSiteId = Cms2Utils.getCurrentSiteId(request);
/* 160 */     boolean is_success = this.channelValidate.addOperatorValidate(currentSiteId, parentId, modelId, model);
/* 161 */     if (!is_success) {
/* 162 */       return "error";
/*     */     }
/* 164 */     Cms2Site currentSite = this.cms2SiteService.queryById(currentSiteId);
/* 165 */     Cms2Model cms2Model = this.cms2ModelService.queryById(modelId);
/* 166 */     List modelItem = this.cms2ModelItemService.getItemListForChannel(modelId);
/* 167 */     List channelList = this.cms2ChannelService.getWholeTreeBySite(currentSiteId);
/* 168 */     List tplChnlList = this.cms2TemplateService.getHasPrefixTplList(cms2Model.getTplChannelPrefix(), currentSiteId.toString(), EnumTplIsDir.IS_FILE.getValue().toString());
/* 169 */     List tplContList = this.cms2TemplateService.getHasPrefixTplList(cms2Model.getTplContentPrefix(), currentSiteId.toString(), EnumTplIsDir.IS_FILE.getValue().toString());
/* 170 */     addCommonModel(currentSite, cms2Model, parentId, modelItem, channelList, tplChnlList, tplContList, new Cms2Channel(), new Cms2ChannelExt(), model);
/*     */ 
/* 172 */     return "channel/add";
/*     */   }
/*     */ 
/*     */   private void addCommonModel(Cms2Site currentSite, Cms2Model cms2Model, Long parentId, List<Cms2ModelItem> modelItem, List<Cms2Channel> channelList, List<Cms2Template> tplChnlList, List<Cms2Template> tplContList, Cms2Channel channel, Cms2ChannelExt channelExt, Model model)
/*     */   {
/* 178 */     model.addAttribute("afterCheckMap", EnumAfterCheck.toMap());
/* 179 */     model.addAttribute("commentTypeMap", EnumCommentType.toMap());
/* 180 */     model.addAttribute("currentSite", currentSite);
/* 181 */     model.addAttribute("cms2Model", cms2Model);
/* 182 */     model.addAttribute("parentId", parentId);
/* 183 */     model.addAttribute("modelItemList", modelItem);
/* 184 */     model.addAttribute("channelList", channelList);
/* 185 */     model.addAttribute("tplChnlList", tplChnlList);
/* 186 */     model.addAttribute("tplContList", tplContList);
/* 187 */     model.addAttribute("channel", channel);
/* 188 */     model.addAttribute("channelExt", channelExt);
/*     */   }
/*     */ 
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.CHANNEL_ADD})
/*     */   @RequestMapping(value={"/save"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String save(@RequestParam(value="q", required=false, defaultValue="") String queryStr, Long siteId, Long parentId, Long modelId, Cms2Channel channel, SettlerAgent cmsAgent, Cms2ChannelExt channelExt, HttpServletRequest request, Model model)
/*     */   {
/* 199 */     model.addAttribute("q", queryStr);
/*     */ 
/* 201 */     boolean is_success = this.channelValidate.ifSiteChangeOver(siteId, model, request);
/* 202 */     if (!is_success) {
/* 203 */       model.addAttribute("url", "/channel/list.htm");
/* 204 */       return "error";
/*     */     }
/* 206 */     Map attr = RequestUtils.getRequestMap(request, "attr_");
/* 207 */     model.addAttribute("attr", attr);
/*     */ 
/* 209 */     String maxTreeSort = this.cms2ChannelService.getMaxTreeSortInChildLevel(parentId);
/* 210 */     if (StringUtil.isBlank(maxTreeSort)) {
/* 211 */       Cms2Channel parentChannel = this.cms2ChannelService.queryById(parentId);
/* 212 */       if (parentChannel == null)
/* 213 */         maxTreeSort = "000";
/*     */       else
/* 215 */         maxTreeSort = parentChannel.getTreeSort() + "000";
/*     */     } else {
/* 217 */       is_success = this.channelValidate.channelNumLimit(Cms2TreeSortTool.packageNextTreeSort(maxTreeSort), model);
/* 218 */       if (!is_success) {
/* 219 */         model.addAttribute("url", "/channel/list.htm");
/* 220 */         return "error";
/*     */       }
/*     */     }
/*     */ 
/* 224 */     List modelItem = this.cms2ModelItemService.getItemListForChannel(modelId);
/* 225 */     if ((modelItem == null) || (modelItem.size() <= 0)) {
/* 226 */       model.addAttribute("message", "模型项为空");
/* 227 */       model.addAttribute("url", "/channel/list.htm");
/* 228 */       return "error";
/*     */     }
/*     */ 
/* 232 */     is_success = this.channelValidate.saveOperValidate(siteId, parentId, modelItem, channel, channelExt, model);
/* 233 */     if (!is_success) {
/* 234 */       Cms2Site currentSite = this.cms2SiteService.queryById(siteId);
/* 235 */       Cms2Model cms2Model = this.cms2ModelService.queryById(modelId);
/* 236 */       List channelList = this.cms2ChannelService.getWholeTreeBySite(siteId);
/* 237 */       List tplChnlList = this.cms2TemplateService.getHasPrefixTplList(cms2Model.getTplChannelPrefix(), siteId.toString(), EnumTplIsDir.IS_FILE.getValue().toString());
/* 238 */       List tplContList = this.cms2TemplateService.getHasPrefixTplList(cms2Model.getTplContentPrefix(), siteId.toString(), EnumTplIsDir.IS_FILE.getValue().toString());
/* 239 */       addCommonModel(currentSite, cms2Model, parentId, modelItem, channelList, tplChnlList, tplContList, channel, channelExt, model);
/*     */ 
/* 241 */       return "channel/add";
/*     */     }
/*     */ 
/* 245 */     if ((parentId == null) || (parentId.compareTo(Long.valueOf(0L)) <= 0)) {
/* 246 */       channel.setParentId(null);
/* 247 */       channel.setIsParent(EnumChannelIsParent.IS_NOT_PARENT.getValue());
/*     */     } else {
/* 249 */       channel.setParentId(parentId);
/* 250 */       channel.setIsParent(EnumChannelIsParent.IS_PARENT.getValue());
/*     */     }
/* 252 */     channel.setTreeSort(Cms2TreeSortTool.packageNextTreeSort(maxTreeSort));
/* 253 */     channel.setSiteId(siteId);
/* 254 */     channel.setModelId(modelId);
/* 255 */     channelInitForAddOper(channel);
/* 256 */     Long channelId = this.cms2ChannelService.save(channel);
/*     */ 
/* 258 */     Cms2Site currentSite = this.cms2SiteService.queryById(siteId);
/*     */ 
/* 260 */     if ((EnumSiteStaticRange.STATIC.getValue().equals(currentSite.getStaticRange().toString())) || (EnumSiteStaticRange.PART_STATIC.getValue().equals(currentSite.getStaticRange().toString()))) {
/* 261 */       if (channelExt.getIsStaticChnl() == null) {
/* 262 */         channelExt.setIsStaticChnl(EnumIsStatic.IS_STATIC.getValue());
/*     */       }
/*     */ 
/* 265 */       if (channelExt.getIsStaticCont() == null) {
/* 266 */         channelExt.setIsStaticCont(EnumIsStatic.IS_STATIC.getValue());
/*     */       }
/*     */     }
/*     */ 
/* 270 */     channelExt.setChannelId(channel.getId());
/* 271 */     channelExtInitForAddOper(channelExt);
/* 272 */     this.cms2ChannelExtService.save(channelExt);
/*     */ 
/* 274 */     this.cms2ChannelAttrService.batchInsert(channel.getId(), siteId, attr);
/*     */ 
/* 277 */     Cms2Job cms2Job = new Cms2Job(siteId, EnumStaticType.CHANNEL_STATIC.getType(), channelId, EnumStaticOper.ADD_STATIC.getType(), Long.valueOf(0L), "", null);
/* 278 */     this.cms2JobService.save(cms2Job);
/*     */ 
/* 280 */     model.addAttribute("url", "/channel/list.htm");
/* 281 */     super.addLog(request, cmsAgent, Cms2Utils.getCurrentSiteId(request), "栏目添加", channel.getId().toString(), channel.getChannelName());
/* 282 */     return "success";
/*     */   }
/*     */ 
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.CHANNEL_EDIT})
/*     */   @RequestMapping(value={"/modify"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String modify(@RequestParam(value="q", required=false, defaultValue="") String queryStr, Long channelId, HttpServletRequest request, Model model)
/*     */   {
/* 292 */     model.addAttribute("q", queryStr);
/* 293 */     Cms2Channel channel = this.cms2ChannelService.queryById(channelId);
/*     */ 
/* 295 */     boolean is_success = this.channelValidate.ifSiteChangeOver(channel.getSiteId(), model, request);
/* 296 */     if (!is_success) {
/* 297 */       model.addAttribute("url", "/channel/list.htm");
/* 298 */       return "error";
/*     */     }
/*     */ 
/* 301 */     Long currentSiteId = Cms2Utils.getCurrentSiteId(request);
/* 302 */     Cms2ChannelExt channelExt = this.cms2ChannelExtService.queryChannelExtByChannelId(channelId);
/* 303 */     Cms2Model cms2Model = this.cms2ModelService.queryById(channel.getModelId());
/* 304 */     Cms2Site currentSite = this.cms2SiteService.queryById(currentSiteId);
/* 305 */     List modelItem = this.cms2ModelItemService.getItemListForChannel(cms2Model.getId());
/* 306 */     List channelList = this.cms2ChannelService.getWholeTreeBySite(currentSiteId);
/* 307 */     List tplChnlList = this.cms2TemplateService.getHasPrefixTplList(cms2Model.getTplChannelPrefix(), currentSiteId.toString(), EnumTplIsDir.IS_FILE.getValue().toString());
/* 308 */     List tplContList = this.cms2TemplateService.getHasPrefixTplList(cms2Model.getTplContentPrefix(), currentSiteId.toString(), EnumTplIsDir.IS_FILE.getValue().toString());
/* 309 */     updateCommonModel(currentSite, cms2Model, modelItem, channelList, tplChnlList, tplContList, channel, channelExt, model);
/*     */ 
/* 311 */     return "channel/modify";
/*     */   }
/*     */ 
/*     */   private void updateCommonModel(Cms2Site currentSite, Cms2Model cms2Model, List<Cms2ModelItem> modelItem, List<Cms2Channel> channelList, List<Cms2Template> tplChnlList, List<Cms2Template> tplContList, Cms2Channel channel, Cms2ChannelExt channelExt, Model model)
/*     */   {
/* 317 */     model.addAttribute("afterCheckMap", EnumAfterCheck.toMap());
/* 318 */     model.addAttribute("commentTypeMap", EnumCommentType.toMap());
/* 319 */     model.addAttribute("currentSite", currentSite);
/* 320 */     model.addAttribute("cms2Model", cms2Model);
/* 321 */     model.addAttribute("modelItemList", modelItem);
/* 322 */     model.addAttribute("channelList", channelList);
/* 323 */     model.addAttribute("tplChnlList", tplChnlList);
/* 324 */     model.addAttribute("tplContList", tplContList);
/* 325 */     model.addAttribute("channel", channel);
/* 326 */     model.addAttribute("channelExt", channelExt);
/*     */   }
/*     */ 
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.CHANNEL_EDIT})
/*     */   @RequestMapping(value={"/update"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String update(@RequestParam(value="q", required=false, defaultValue="") String queryStr, Long siteId, Long parentId, Long modelId, Cms2Channel channel, SettlerAgent cmsAgent, Cms2ChannelExt channelExt, HttpServletRequest request, Model model)
/*     */   {
/* 337 */     model.addAttribute("q", queryStr);
/* 338 */     boolean is_success = this.channelValidate.ifSiteChangeOver(siteId, model, request);
/* 339 */     if (!is_success) {
/* 340 */       model.addAttribute("url", "/channel/list.htm");
/* 341 */       return "error";
/*     */     }
/*     */ 
/* 344 */     Cms2Model cms2Model = this.cms2ModelService.queryById(modelId);
/* 345 */     List modelItem = this.cms2ModelItemService.getItemListForChannel(cms2Model.getId());
/* 346 */     if ((modelItem == null) || (modelItem.size() <= 0)) {
/* 347 */       model.addAttribute("message", "模型项为空");
/* 348 */       model.addAttribute("url", "/channel/list.htm");
/* 349 */       return "error";
/*     */     }
/*     */ 
/* 352 */     is_success = this.channelValidate.updateOperatorValidate(siteId, modelItem, channel, channelExt, model);
/* 353 */     if (!is_success) {
/* 354 */       Cms2Site currentSite = this.cms2SiteService.queryById(siteId);
/* 355 */       List channelList = this.cms2ChannelService.getWholeTreeBySite(siteId);
/* 356 */       List tplChnlList = this.cms2TemplateService.getHasPrefixTplList(cms2Model.getTplChannelPrefix(), siteId.toString(), EnumTplIsDir.IS_FILE.getValue().toString());
/* 357 */       List tplContList = this.cms2TemplateService.getHasPrefixTplList(cms2Model.getTplContentPrefix(), siteId.toString(), EnumTplIsDir.IS_FILE.getValue().toString());
/* 358 */       updateCommonModel(currentSite, cms2Model, modelItem, channelList, tplChnlList, tplContList, channel, channelExt, model);
/*     */ 
/* 360 */       return "channel/modify";
/*     */     }
/*     */ 
/* 363 */     channelInitForModifyOper(channel);
/* 364 */     channelExtInitForModifyOper(channelExt);
/*     */ 
/* 366 */     channelExt.setChannelId(channel.getId());
/* 367 */     this.cms2ChannelService.update(channel);
/* 368 */     this.cms2ChannelExtService.updateByChannelId(channelExt);
/*     */ 
/* 371 */     Cms2Job cms2Job = new Cms2Job(siteId, EnumStaticType.CHANNEL_STATIC.getType(), channel.getId(), EnumStaticOper.MODIFY_STATIC.getType(), Long.valueOf(0L), "", null);
/* 372 */     this.cms2JobService.save(cms2Job);
/*     */ 
/* 374 */     model.addAttribute("url", "/channel/list.htm");
/* 375 */     super.addLog(request, cmsAgent, Cms2Utils.getCurrentSiteId(request), "栏目更新", channel.getId().toString(), channel.getChannelName());
/* 376 */     return "success";
/*     */   }
/*     */ 
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.CHANNEL_DEL})
/*     */   @RequestMapping(value={"/delete"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String delete(@RequestParam(value="q", required=false, defaultValue="") String queryStr, Long channelId, SettlerAgent cmsAgent, HttpServletRequest request, Model model)
/*     */   {
/* 386 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/*     */ 
/* 388 */     if (siteId == null) {
/* 389 */       model.addAttribute("url", "/channel/index.htm");
/* 390 */       model.addAttribute("q", queryStr);
/* 391 */       model.addAttribute("message", "系统获取不到当前所在站点，请重新登录");
/* 392 */       return "error";
/*     */     }
/*     */ 
/* 395 */     model.addAttribute("q", queryStr);
/* 396 */     Cms2Channel channel = this.cms2ChannelService.queryById(channelId);
/* 397 */     Long currentSiteId = Cms2Utils.getCurrentSiteId(request);
/* 398 */     if (!channel.getSiteId().equals(currentSiteId)) {
/* 399 */       model.addAttribute("message", "站点不存在或已切换");
/* 400 */       model.addAttribute("url", "/channel/list.htm");
/* 401 */       return "error";
/*     */     }
/* 403 */     boolean is_success = this.channelValidate.deleteOperatorValidate(channel, model);
/* 404 */     if (!is_success) {
/* 405 */       model.addAttribute("url", "/channel/list.htm");
/* 406 */       return "error";
/*     */     }
/* 408 */     Cms2Site currentSite = this.cms2SiteService.queryById(currentSiteId);
/*     */ 
/* 410 */     if (EnumSiteStaticRange.ACTIVE.getValue().equals(currentSite.getStaticRange().toString()))
/*     */     {
/* 412 */       this.cms2ChannelService.deleteById(channelId);
/* 413 */       this.cms2ChannelExtService.deleteByChannelId(channelId);
/* 414 */       this.cms2ChannelGroupService.deleteByChannelId(channelId);
/* 415 */       this.cms2ChannelAttrService.deleteByChannelId(channelId);
/* 416 */       this.cms2ChannelUserService.deleteByChannelId(channelId);
/*     */     } else {
/* 418 */       channel = new Cms2Channel();
/* 419 */       channel.setId(channelId);
/* 420 */       channel.setStatus(EnumChannelStatus.DELETE.getValue());
/* 421 */       this.cms2ChannelService.update(channel);
/*     */     }
/*     */ 
/* 424 */     Cms2Job cms2Job = new Cms2Job(siteId, EnumStaticType.CHANNEL_STATIC.getType(), channel.getId(), EnumStaticOper.DELETE_STATIC.getType(), Long.valueOf(0L), "", null);
/* 425 */     this.cms2JobService.save(cms2Job);
/*     */ 
/* 427 */     model.addAttribute("url", "/channel/list.htm");
/* 428 */     model.addAttribute("message", "删除成功");
/* 429 */     super.addLog(request, cmsAgent, Cms2Utils.getCurrentSiteId(request), "栏目删除", channel.getId().toString(), channel.getChannelName());
/* 430 */     return "success";
/*     */   }
/*     */ 
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.CHANNEL_SORT})
/*     */   @RequestMapping(value={"/down"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String down(Long parentId, Long channelId, HttpServletRequest request, SettlerAgent cmsAgent, Model model)
/*     */   {
/* 439 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/*     */ 
/* 441 */     if (siteId == null) {
/* 442 */       model.addAttribute("url", "/channel/index.htm");
/* 443 */       model.addAttribute("message", "系统获取不到当前所在站点，请重新登录");
/* 444 */       return "error";
/*     */     }
/* 446 */     Cms2Channel eagerChannel = this.cms2ChannelService.queryById(channelId);
/* 447 */     boolean is_success = this.channelValidate.ifSiteChangeOver(eagerChannel.getSiteId(), model, request);
/* 448 */     if (!is_success) {
/* 449 */       model.addAttribute("url", "/channel/list.htm");
/* 450 */       return "error";
/*     */     }
/*     */ 
/* 453 */     String returnUrl = "redirect:list.htm?parentId=";
/* 454 */     if (parentId != null)
/* 455 */       returnUrl = returnUrl + parentId;
/* 456 */     this.cms2ChannelService.downSort(eagerChannel);
/*     */ 
/* 459 */     Cms2Job cms2Job = new Cms2Job(siteId, EnumStaticType.CHANNEL_STATIC.getType(), eagerChannel.getId(), EnumStaticOper.MODIFY_STATIC.getType(), Long.valueOf(0L), "", null);
/* 460 */     this.cms2JobService.save(cms2Job);
/*     */ 
/* 462 */     super.addLog(request, cmsAgent, Cms2Utils.getCurrentSiteId(request), "栏目下移", eagerChannel.getId().toString(), eagerChannel.getChannelName());
/* 463 */     return returnUrl;
/*     */   }
/*     */ 
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.CHANNEL_SORT})
/*     */   @RequestMapping(value={"/up"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String up(Long parentId, Long channelId, SettlerAgent cmsAgent, HttpServletRequest request, Model model)
/*     */   {
/* 472 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/*     */ 
/* 474 */     if (siteId == null) {
/* 475 */       model.addAttribute("url", "/channel/index.htm");
/* 476 */       model.addAttribute("message", "系统获取不到当前所在站点，请重新登录");
/* 477 */       return "error";
/*     */     }
/* 479 */     Cms2Channel eagerChannel = this.cms2ChannelService.queryById(channelId);
/* 480 */     boolean is_success = this.channelValidate.ifSiteChangeOver(eagerChannel.getSiteId(), model, request);
/* 481 */     if (!is_success) {
/* 482 */       model.addAttribute("url", "/channel/list.htm");
/* 483 */       return "error";
/*     */     }
/*     */ 
/* 486 */     String returnUrl = "redirect:list.htm?parentId=";
/* 487 */     if (parentId != null)
/* 488 */       returnUrl = returnUrl + parentId;
/* 489 */     this.cms2ChannelService.upSort(eagerChannel);
/*     */ 
/* 492 */     Cms2Job cms2Job = new Cms2Job(siteId, EnumStaticType.CHANNEL_STATIC.getType(), eagerChannel.getId(), EnumStaticOper.MODIFY_STATIC.getType(), Long.valueOf(0L), "", null);
/* 493 */     this.cms2JobService.save(cms2Job);
/*     */ 
/* 495 */     super.addLog(request, cmsAgent, Cms2Utils.getCurrentSiteId(request), "栏目上移", eagerChannel.getId().toString(), eagerChannel.getChannelName());
/* 496 */     return returnUrl;
/*     */   }
/*     */ 
/*     */   private void channelInitForAddOper(Cms2Channel cms2Channel)
/*     */   {
/* 503 */     cms2Channel.setStatus(EnumChannelStatus.AVAILABLE.getValue());
/* 504 */     cms2Channel.setCopyMain(EnumChannelCopyMain.IS_MAIN.getValue());
/* 505 */     cms2Channel.setCopyCopy(EnumChannelCopyCopy.IS_NOT_COPY.getValue());
/*     */   }
/*     */ 
/*     */   private void channelExtInitForAddOper(Cms2ChannelExt cms2ChannelExt)
/*     */   {
/* 514 */     if (cms2ChannelExt.getIsStaticChnl() == null) {
/* 515 */       cms2ChannelExt.setIsStaticChnl(EnumIsStatic.IS_NOT_STATIC.getValue());
/*     */     }
/*     */ 
/* 518 */     if (cms2ChannelExt.getIsStaticCont() == null) {
/* 519 */       cms2ChannelExt.setIsStaticCont(EnumIsStatic.IS_NOT_STATIC.getValue());
/*     */     }
/*     */ 
/* 522 */     if ((cms2ChannelExt.getHasTitleImg() == null) || (EnumHasImg.NOT_HAVE_IMG.getValue().equals(cms2ChannelExt.getHasTitleImg())))
/*     */     {
/* 524 */       cms2ChannelExt.setHasTitleImg(EnumHasImg.NOT_HAVE_IMG.getValue());
/* 525 */       cms2ChannelExt.setTitleImgHeight(null);
/* 526 */       cms2ChannelExt.setTitleImgWidth(null);
/*     */     }
/*     */ 
/* 529 */     if ((cms2ChannelExt.getHasContImg() == null) || (EnumHasImg.NOT_HAVE_IMG.getValue().equals(cms2ChannelExt.getHasContImg())))
/*     */     {
/* 531 */       cms2ChannelExt.setHasContImg(EnumHasImg.NOT_HAVE_IMG.getValue());
/* 532 */       cms2ChannelExt.setContImgHeight(null);
/* 533 */       cms2ChannelExt.setContImgWidth(null);
/*     */     }
/*     */ 
/* 536 */     if (cms2ChannelExt.getCommentControl() == null) {
/* 537 */       cms2ChannelExt.setCommentControl(Long.valueOf(Long.parseLong(EnumCommentType.COMMENTS_OFF.getCode())));
/*     */     }
/* 539 */     if (cms2ChannelExt.getAllowUpdown() == null) {
/* 540 */       cms2ChannelExt.setAllowUpdown(EnumChannelAllowUpdown.CLOSE.getValue());
/*     */     }
/* 542 */     if (cms2ChannelExt.getIsBlank() == null)
/* 543 */       cms2ChannelExt.setIsBlank(EnumIsBlank.OPEN_NOT_IN_NEW.getValue());
/*     */   }
/*     */ 
/*     */   private void channelInitForModifyOper(Cms2Channel cms2Channel)
/*     */   {
/* 551 */     cms2Channel.setStatus(EnumChannelStatus.AVAILABLE.getValue());
/* 552 */     cms2Channel.setCopyMain(EnumChannelCopyMain.IS_MAIN.getValue());
/* 553 */     cms2Channel.setCopyCopy(EnumChannelCopyCopy.IS_NOT_COPY.getValue());
/*     */   }
/*     */ 
/*     */   private void channelExtInitForModifyOper(Cms2ChannelExt cms2ChannelExt)
/*     */   {
/* 567 */     if (cms2ChannelExt.getHasTitleImg() == null) {
/* 568 */       cms2ChannelExt.setHasTitleImg(EnumHasImg.NOT_HAVE_IMG.getValue());
/* 569 */     } else if (EnumHasImg.NOT_HAVE_IMG.getValue().equals(cms2ChannelExt.getHasTitleImg())) {
/* 570 */       cms2ChannelExt.setTitleImgHeight(null);
/* 571 */       cms2ChannelExt.setTitleImgWidth(null);
/*     */     }
/*     */ 
/* 574 */     if (cms2ChannelExt.getHasContImg() == null) {
/* 575 */       cms2ChannelExt.setHasContImg(EnumHasImg.NOT_HAVE_IMG.getValue());
/* 576 */     } else if (EnumHasImg.NOT_HAVE_IMG.getValue().equals(cms2ChannelExt.getHasContImg())) {
/* 577 */       cms2ChannelExt.setContImgHeight(null);
/* 578 */       cms2ChannelExt.setContImgWidth(null);
/*     */     }
/*     */ 
/* 581 */     if (cms2ChannelExt.getCommentControl() == null) {
/* 582 */       cms2ChannelExt.setCommentControl(Long.valueOf(Long.parseLong(EnumCommentType.COMMENTS_OFF.getCode())));
/*     */     }
/* 584 */     if (cms2ChannelExt.getAllowUpdown() == null) {
/* 585 */       cms2ChannelExt.setAllowUpdown(EnumChannelAllowUpdown.CLOSE.getValue());
/*     */     }
/* 587 */     if (cms2ChannelExt.getIsBlank() == null)
/* 588 */       cms2ChannelExt.setIsBlank(EnumIsBlank.OPEN_NOT_IN_NEW.getValue());
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy\cmsAdmin\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.admin.action.ChannelAction
 * JD-Core Version:    0.6.0
 */