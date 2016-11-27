/*     */ package com.hundsun.network.hseccms.web.action;
/*     */ 
/*     */ import com.hundsun.network.hseccms.enums.EnumAttachStatus;
/*     */ import com.hundsun.network.hseccms.enums.EnumAttachType;
/*     */ import com.hundsun.network.hseccms.enums.EnumChannelGroupType;
/*     */ import com.hundsun.network.hseccms.enums.EnumContIsBold;
/*     */ import com.hundsun.network.hseccms.enums.EnumContIsRejected;
/*     */ import com.hundsun.network.hseccms.enums.EnumContStatus;
/*     */ import com.hundsun.network.hseccms.enums.EnumJobTimingObj;
/*     */ import com.hundsun.network.hseccms.enums.EnumJobTimingType;
/*     */ import com.hundsun.network.hseccms.enums.EnumModelHasContent;
/*     */ import com.hundsun.network.hseccms.enums.EnumStaticOper;
/*     */ import com.hundsun.network.hseccms.enums.EnumStaticType;
/*     */ import com.hundsun.network.hseccms.enums.EnumTplDirType;
/*     */ import com.hundsun.network.hseccms.model.Cms2Attach;
/*     */ import com.hundsun.network.hseccms.model.Cms2BaseDict;
/*     */ import com.hundsun.network.hseccms.model.Cms2Channel;
/*     */ import com.hundsun.network.hseccms.model.Cms2Cont;
/*     */ import com.hundsun.network.hseccms.model.Cms2ContAll;
/*     */ import com.hundsun.network.hseccms.model.Cms2ContCheck;
/*     */ import com.hundsun.network.hseccms.model.Cms2ContExt;
/*     */ import com.hundsun.network.hseccms.model.Cms2Job;
/*     */ import com.hundsun.network.hseccms.model.Cms2Model;
/*     */ import com.hundsun.network.hseccms.model.Cms2Site;
/*     */ import com.hundsun.network.hseccms.model.Cms2Template;
/*     */ import com.hundsun.network.hseccms.query.Cms2ContCheckQuery;
/*     */ import com.hundsun.network.hseccms.query.Cms2JobTimingQuery;
/*     */ import com.hundsun.network.hseccms.security.SettlerAgent;
/*     */ import com.hundsun.network.hseccms.service.Cms2BaseDictService;
/*     */ import com.hundsun.network.hseccms.service.Cms2ContCheckService;
/*     */ import com.hundsun.network.hseccms.service.Cms2ContService;
/*     */ import com.hundsun.network.hseccms.service.Cms2JobService;
/*     */ import com.hundsun.network.hseccms.service.Cms2JobTimingService;
/*     */ import com.hundsun.network.hseccms.service.Cms2ModelItemService;
/*     */ import com.hundsun.network.hseccms.service.Cms2ModelService;
/*     */ import com.hundsun.network.hseccms.service.Cms2SiteService;
/*     */ import com.hundsun.network.hseccms.service.Cms2TemplateService;
/*     */ import com.hundsun.network.hseccms.util.Cms2Utils;
/*     */ import com.hundsun.network.hseccms.util.FrontUtils;
/*     */ import com.hundsun.network.hseccms.web.common.WebUtils;
/*     */ import com.hundsun.network.hseccms.web.render.StringTemplateRender;
/*     */ import com.hundsun.network.hseccms.web.service.SpecialRequestService;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import com.hundsun.network.melody.common.web.url.URLBroker;
/*     */ import com.hundsun.network.melody.common.web.url.URLConfig;
/*     */ import java.text.DateFormat;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.apache.commons.lang.StringUtils;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.beans.factory.annotation.Value;
/*     */ import org.springframework.beans.propertyeditors.CustomDateEditor;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.web.bind.ServletRequestDataBinder;
/*     */ import org.springframework.web.bind.annotation.InitBinder;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ 
/*     */ @Controller
/*     */ public class SpecialRequestAction
/*     */ {
/*  72 */   private static Log _log = LogFactory.getLog(SpecialRequestAction.class);
/*     */ 
/*     */   @Autowired
/*     */   private Cms2TemplateService cms2TemplateService;
/*     */ 
/*     */   @Autowired
/*     */   private StringTemplateRender stringTemplateRender;
/*     */ 
/*     */   @Autowired
/*     */   private SpecialRequestService specialRequestService;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2ModelService cms2ModelService;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2ModelItemService cms2ModelItemService;
/*     */ 
/*     */   @Autowired
/*     */   private URLBroker uploadServerBroker;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2ContService cms2ContService;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2SiteService cms2SiteService;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2ContCheckService cms2ContCheckService;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2BaseDictService cms2BaseDictService;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2JobService cms2JobService;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2JobTimingService cms2JobTimingService;
/*     */   private static final String PARAM_TITLE = "#title#";
/*     */   private static final String PARAM_MEMBER_ID = "#memberId#";
/*     */   private static final String PARAM_STATUS = "#status#";
/*     */   private static final String PARAM_CHANNEL_ID = "#channelId#";
/*     */ 
/*     */   @Value("${resSys}")
/*     */   private String resSys;
/*     */ 
/* 119 */   @InitBinder
/*     */   protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception { DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 120 */     dateFormat.setLenient(false);
/* 121 */     binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/memberSubmissionList*"})
/*     */   public void submissionList(String q, Integer pageNo, String title, String status, String channlId, SettlerAgent memberAgent, HttpServletRequest request, HttpServletResponse response, ModelMap model)
/*     */   {
/* 136 */     if ((StringUtil.isNotBlank(q)) && (StringUtil.isBlank(title)) && (StringUtil.isBlank(status)) && (StringUtil.isBlank(channlId)))
/*     */     {
/* 138 */       String[] param = resolveQ(q);
/* 139 */       if (param.length > 0)
/* 140 */         title = param[0];
/* 141 */       if (param.length > 1)
/* 142 */         status = param[1];
/* 143 */       if (param.length > 2)
/* 144 */         channlId = param[2];
/*     */     }
/* 146 */     model.addAttribute("backUrl", "/memberSubmissionList");
/* 147 */     if ((memberAgent == null) || (StringUtil.isBlank(memberAgent.getUserType())) || (memberAgent.getUserId() == null) || (memberAgent.getUserId().compareTo(Long.valueOf(0L)) <= 0))
/*     */     {
/* 149 */       model.addAttribute("message", "请先登录");
/* 150 */       this.stringTemplateRender.renderTplInCurrentSite(EnumTplDirType.COMMON.getCode(), "错误", request, response, model, memberAgent);
/* 151 */       return;
/*     */     }
/* 153 */     model.addAttribute("memberAgent", memberAgent);
/* 154 */     String groupCode = memberAgent.getMemberType();
/* 155 */     String memberId = memberAgent.getUserId().toString();
/*     */ 
/* 157 */     List canSeeChannels = this.specialRequestService.queryByGroupCode(groupCode, EnumChannelGroupType.LOOK_UP.getCode().toString());
/* 158 */     List canPublishChannels = this.specialRequestService.queryByGroupCode(groupCode, EnumChannelGroupType.CONTRIBUTE.getCode().toString());
/*     */ 
/* 160 */     Cms2Site site = Cms2Utils.getSite(request);
/*     */ 
/* 162 */     status = StringUtil.isBlank(status) ? "all" : status;
/*     */ 
/* 164 */     String channelIds = null;
/*     */ 
/* 166 */     Cms2BaseDict cms2BaseDict = this.cms2BaseDictService.queryWebDictByParam(site.getId(), "memberDef");
/*     */ 
/* 168 */     channelIds = channlId;
/* 169 */     if (StringUtil.isBlank(channelIds)) {
/* 170 */       if ("1".equals(cms2BaseDict.getValue())) {
/* 171 */         if ((canPublishChannels != null) && (canPublishChannels.size() > 0)) {
/* 172 */           Cms2Channel channel = (Cms2Channel)canPublishChannels.get(0);
/* 173 */           channelIds = channel.getId().toString();
/*     */         }
/*     */       }
/* 176 */       else channelIds = packageChannelIds(canPublishChannels);
/*     */     }
/*     */ 
/* 179 */     model.addAttribute("cms2BaseDict", cms2BaseDict);
/* 180 */     model.addAttribute("enumContStatus", EnumContStatus.toListMemberCanBeSee());
/* 181 */     model.addAttribute("canSeeChannels", canSeeChannels);
/* 182 */     model.addAttribute("canPublishChannels", canPublishChannels);
/* 183 */     model.addAttribute("title", title);
/* 184 */     model.addAttribute("status", status);
/* 185 */     model.addAttribute("channlId", channlId);
/* 186 */     model.addAttribute("pageNo", pageNo);
/*     */ 
/* 188 */     model.addAttribute("q", packageQ(title, status, channlId));
/*     */     try {
/* 190 */       Cms2Template template = this.cms2TemplateService.getTplByTypeAndName(new StringBuilder().append(site.getId()).append("").toString(), EnumTplDirType.MEMBER.getCode(), "投稿首页");
/* 191 */       FrontUtils.frontData(request, model, site, memberAgent);
/* 192 */       FrontUtils.frontPageData(request, site, Boolean.valueOf(false), model);
/* 193 */       String str = null;
/* 194 */       if (template != null)
/* 195 */         str = template.getCont();
/* 196 */       if (StringUtil.isBlank(str)) {
/* 197 */         model.addAttribute("message", "模版无内容");
/* 198 */         this.stringTemplateRender.renderTplInCurrentSite(EnumTplDirType.COMMON.getCode(), "错误", request, response, model, memberAgent);
/* 199 */         return;
/*     */       }
/* 201 */       str = str.replace("#title#", StringUtil.isBlank(title) ? "" : title);
/* 202 */       str = str.replace("#memberId#", StringUtil.isBlank(memberId) ? "" : memberId);
/* 203 */       str = str.replace("#status#", StringUtil.isBlank(status) ? "" : status);
/* 204 */       str = str.replace("#channelId#", StringUtil.isBlank(channelIds) ? "" : channelIds);
/* 205 */       str = this.stringTemplateRender.render(model, str);
/* 206 */       WebUtils.toHtmlPage(response, str);
/*     */     } catch (Exception e) {
/* 208 */       _log.error("", e);
/*     */     }
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/memberSubmissionAdd"})
/*     */   public void addContent(String q, Integer pageNo, Long channlId, HttpServletRequest request, HttpServletResponse response, SettlerAgent memberAgent, ModelMap model) {
/* 215 */     model.addAttribute("q", q);
/* 216 */     model.addAttribute("pageNo", pageNo);
/* 217 */     model.addAttribute("backUrl", "/memberSubmissionList");
/* 218 */     if ((memberAgent == null) || (StringUtil.isBlank(memberAgent.getUserType())) || (memberAgent.getUserId() == null) || (memberAgent.getUserId().compareTo(Long.valueOf(0L)) <= 0))
/*     */     {
/* 220 */       model.addAttribute("message", "请先登录");
/* 221 */       this.stringTemplateRender.renderTplInCurrentSite(EnumTplDirType.COMMON.getCode(), "错误", request, response, model, memberAgent);
/* 222 */       return;
/*     */     }
/* 224 */     model.addAttribute("memberAgent", memberAgent);
/* 225 */     String groupCode = memberAgent.getMemberType();
/* 226 */     String memberId = memberAgent.getUserId().toString();
/*     */ 
/* 228 */     Cms2Channel channel = this.specialRequestService.queryChannelByUserOwn(groupCode, EnumChannelGroupType.CONTRIBUTE.getCode().toString(), channlId);
/* 229 */     if (channel == null) {
/* 230 */       model.addAttribute("message", "无权进行该操作");
/* 231 */       this.stringTemplateRender.renderTplInCurrentSite(EnumTplDirType.COMMON.getCode(), "错误", request, response, model, memberAgent);
/* 232 */       return;
/*     */     }
/* 234 */     Cms2Model cms2Model = this.cms2ModelService.queryById(channel.getModelId());
/*     */ 
/* 236 */     if (EnumModelHasContent.MEMBER_ALONE.getCode().equals(cms2Model.getHasContent()))
/*     */     {
/* 238 */       Long count = this.specialRequestService.queryCountByMemberAndChannel(null, memberId, channel.getId());
/* 239 */       if ((count != null) && (count.compareTo(Long.valueOf(0L)) > 0)) {
/* 240 */         model.addAttribute("message", "已存在编辑中或待审核的稿件");
/* 241 */         this.stringTemplateRender.renderTplInCurrentSite(EnumTplDirType.COMMON.getCode(), "错误", request, response, model, memberAgent);
/* 242 */         return;
/*     */       }
/*     */     }
/*     */ 
/* 246 */     List itemList = this.cms2ModelItemService.getItemListForContent(channel.getModelId());
/* 247 */     model.addAttribute("channel", channel);
/* 248 */     model.addAttribute("cms2Model", cms2Model);
/* 249 */     model.addAttribute("itemList", itemList);
/* 250 */     this.stringTemplateRender.renderTplInCurrentSite(EnumTplDirType.MEMBER.getCode(), "投稿添加", request, response, model, memberAgent);
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"/memberSubmissionSave"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void saveContent(String q, Integer pageNo, Cms2ContAll cont, HttpServletRequest request, SettlerAgent memberAgent, HttpServletResponse response, Boolean bold, Boolean draft, ModelMap model) {
/* 256 */     model.addAttribute("q", q);
/* 257 */     model.addAttribute("pageNo", pageNo);
/* 258 */     model.addAttribute("backUrl", "/memberSubmissionList");
/* 259 */     if ((memberAgent == null) || (StringUtil.isBlank(memberAgent.getUserType())) || (StringUtil.isBlank(memberAgent.getUserName())) || (memberAgent.getUserId() == null) || (memberAgent.getUserId().compareTo(Long.valueOf(0L)) <= 0))
/*     */     {
/* 262 */       model.addAttribute("message", "请先登录");
/* 263 */       this.stringTemplateRender.renderTplInCurrentSite(EnumTplDirType.COMMON.getCode(), "错误", request, response, model, memberAgent);
/* 264 */       return;
/*     */     }
/* 266 */     model.addAttribute("memberAgent", memberAgent);
/* 267 */     String groupCode = memberAgent.getMemberType();
/* 268 */     String memberId = memberAgent.getUserId().toString();
/* 269 */     String memberName = memberAgent.getAccount();
/*     */ 
/* 271 */     Cms2Channel channel = this.specialRequestService.queryChannelByUserOwn(groupCode, EnumChannelGroupType.CONTRIBUTE.getCode().toString(), cont.getChannelId());
/* 272 */     if (channel == null) {
/* 273 */       model.addAttribute("message", "无权进行该操作");
/* 274 */       this.stringTemplateRender.renderTplInCurrentSite(EnumTplDirType.COMMON.getCode(), "错误", request, response, model, memberAgent);
/* 275 */       return;
/*     */     }
/*     */ 
/* 278 */     Cms2Site cms2Site = Cms2Utils.getSite(request);
/* 279 */     cont.setSiteId(cms2Site.getId());
/* 280 */     cont.setMemberId(Long.valueOf(Long.parseLong(memberId)));
/* 281 */     cont.setMemberName(memberName);
/*     */ 
/* 283 */     if ((bold != null) && (bold.booleanValue()))
/* 284 */       cont.setIsBold(EnumContIsBold.TRUE.getCode());
/*     */     else {
/* 286 */       cont.setIsBold(EnumContIsBold.FALSE.getCode());
/*     */     }
/*     */ 
/* 289 */     if ((draft != null) && (draft.booleanValue()))
/* 290 */       cont.setStatus(EnumContStatus.DRAFT.getCode());
/*     */     else {
/* 292 */       cont.setStatus(EnumContStatus.AUDITING.getCode());
/*     */     }
/* 294 */     if (cont.getTopLevel() == null)
/* 295 */       cont.setTopLevel(Integer.valueOf(0));
/* 296 */     if ((cont.getContExt() != null) && (cont.getContExt().getReleaseDate() == null))
/* 297 */       cont.getContExt().setReleaseDate(new Date());
/* 298 */     cont = transforAllAttach(cont, request);
/* 299 */     String message = "";
/* 300 */     if (null == cont.getId()) {
/* 301 */       Cms2Model cms2Model = this.cms2ModelService.queryById(channel.getModelId());
/* 302 */       if (EnumModelHasContent.MEMBER_ALONE.getCode().equals(cms2Model.getHasContent()))
/*     */       {
/* 304 */         Long count = this.specialRequestService.queryCountByMemberAndChannel(null, memberId, channel.getId());
/* 305 */         if ((count != null) && (count.compareTo(Long.valueOf(0L)) > 0)) {
/* 306 */           model.addAttribute("message", "已存在编辑中或待审核的稿件");
/* 307 */           this.stringTemplateRender.renderTplInCurrentSite(EnumTplDirType.COMMON.getCode(), "错误", request, response, model, memberAgent);
/* 308 */           return;
/*     */         }
/*     */       }
/* 311 */       message = this.cms2ContService.save(cont);
/* 312 */       if (!message.equals("")) {
/* 313 */         model.addAttribute("message", message);
/* 314 */         this.stringTemplateRender.renderTplInCurrentSite(EnumTplDirType.COMMON.getCode(), "错误", request, response, model, memberAgent);
/* 315 */         return;
/*     */       }
/* 317 */       Cms2ContCheck contCheck = new Cms2ContCheck();
/* 318 */       contCheck.setCheckStep(Long.valueOf(0L));
/* 319 */       contCheck.setIsRejected(EnumContIsRejected.NOT_REJECTED.getCode());
/* 320 */       contCheck.setContentId(cont.getId());
/* 321 */       this.cms2ContCheckService.insert(contCheck);
/* 322 */       this.stringTemplateRender.renderTplInCurrentSite(EnumTplDirType.COMMON.getCode(), "成功", request, response, model, memberAgent);
/* 323 */       return;
/*     */     }
/*     */ 
/* 326 */     Cms2ContAll content = this.cms2ContService.selectAllById(cont.getId());
/* 327 */     if (!EnumContStatus.DRAFT.getCode().equals(content.getStatus())) {
/* 328 */       model.addAttribute("message", "稿件已提交,不允许修改");
/* 329 */       this.stringTemplateRender.renderTplInCurrentSite(EnumTplDirType.COMMON.getCode(), "错误", request, response, model, memberAgent);
/* 330 */       return;
/*     */     }
/* 332 */     this.cms2ContService.update(cont);
/* 333 */     if (!message.equals("")) {
/* 334 */       model.addAttribute("message", message);
/* 335 */       this.stringTemplateRender.renderTplInCurrentSite(EnumTplDirType.COMMON.getCode(), "错误", request, response, model, memberAgent);
/* 336 */       return;
/*     */     }
/*     */ 
/* 339 */     Cms2ContCheckQuery contCheckQuery = new Cms2ContCheckQuery();
/* 340 */     contCheckQuery.setContentId(cont.getId().toString());
/* 341 */     List cms2ContCheckList = this.cms2ContCheckService.queryCms2ContCheckList(contCheckQuery);
/* 342 */     if ((cms2ContCheckList != null) && (cms2ContCheckList.size() > 0)) {
/* 343 */       Cms2ContCheck cms2ContCheck = (Cms2ContCheck)cms2ContCheckList.get(0);
/* 344 */       cms2ContCheck.setCheckOpinion("");
/* 345 */       cms2ContCheck.setIsRejected(EnumContIsRejected.NOT_REJECTED.getCode());
/* 346 */       this.cms2ContCheckService.updateByAllProperity(cms2ContCheck);
/*     */     }
/* 348 */     this.stringTemplateRender.renderTplInCurrentSite(EnumTplDirType.COMMON.getCode(), "成功", request, response, model, memberAgent);
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/memberSubmissionModify"})
/*     */   public void modifyContent(String q, Integer pageNo, Long contentId, HttpServletRequest request, HttpServletResponse response, SettlerAgent memberAgent, ModelMap model)
/*     */   {
/* 356 */     model.addAttribute("q", q);
/* 357 */     model.addAttribute("pageNo", pageNo);
/* 358 */     model.addAttribute("backUrl", "/memberSubmissionList");
/* 359 */     if ((memberAgent == null) || (StringUtil.isBlank(memberAgent.getUserType())) || (memberAgent.getUserId() == null) || (memberAgent.getUserId().compareTo(Long.valueOf(0L)) <= 0))
/*     */     {
/* 361 */       model.addAttribute("message", "请先登录");
/* 362 */       this.stringTemplateRender.renderTplInCurrentSite(EnumTplDirType.COMMON.getCode(), "错误", request, response, model, memberAgent);
/* 363 */       return;
/*     */     }
/* 365 */     model.addAttribute("memberAgent", memberAgent);
/* 366 */     String groupCode = memberAgent.getMemberType();
/* 367 */     String memberId = memberAgent.getUserId().toString();
/*     */ 
/* 369 */     Cms2ContAll content = this.cms2ContService.selectAllById(contentId);
/* 370 */     if (!EnumContStatus.DRAFT.getCode().equals(content.getStatus())) {
/* 371 */       model.addAttribute("message", "稿件已提交,不允许修改");
/* 372 */       this.stringTemplateRender.renderTplInCurrentSite(EnumTplDirType.COMMON.getCode(), "错误", request, response, model, memberAgent);
/* 373 */       return;
/*     */     }
/* 375 */     Cms2Channel channel = this.specialRequestService.queryChannelByUserOwn(groupCode, EnumChannelGroupType.CONTRIBUTE.getCode().toString(), content.getChannelId());
/* 376 */     if (channel == null) {
/* 377 */       model.addAttribute("message", "无权进行该操作");
/* 378 */       this.stringTemplateRender.renderTplInCurrentSite(EnumTplDirType.COMMON.getCode(), "错误", request, response, model, memberAgent);
/* 379 */       return;
/*     */     }
/* 381 */     Cms2Model cms2Model = this.cms2ModelService.queryById(channel.getModelId());
/*     */ 
/* 383 */     if (EnumModelHasContent.MEMBER_ALONE.getCode().equals(cms2Model.getHasContent()))
/*     */     {
/* 385 */       Long count = this.specialRequestService.queryCountByMemberAndChannel(content.getId().toString(), memberId, channel.getId());
/* 386 */       if ((count != null) && (count.compareTo(Long.valueOf(0L)) > 0)) {
/* 387 */         model.addAttribute("message", "已存在编辑中或待审核的稿件");
/* 388 */         this.stringTemplateRender.renderTplInCurrentSite(EnumTplDirType.COMMON.getCode(), "错误", request, response, model, memberAgent);
/* 389 */         return;
/*     */       }
/*     */     }
/*     */ 
/* 393 */     List itemList = this.cms2ModelItemService.getItemListForContent(channel.getModelId());
/* 394 */     model.addAttribute("content", content);
/* 395 */     model.addAttribute("channel", channel);
/* 396 */     model.addAttribute("cms2Model", cms2Model);
/* 397 */     model.addAttribute("itemList", itemList);
/* 398 */     this.stringTemplateRender.renderTplInCurrentSite(EnumTplDirType.MEMBER.getCode(), "投稿修改", request, response, model, memberAgent);
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/memberSubmissionDel"})
/*     */   public void delContent(String q, Integer pageNo, Long id, ModelMap model, SettlerAgent memberAgent, HttpServletRequest request, HttpServletResponse response) {
/* 404 */     model.addAttribute("q", q);
/* 405 */     model.addAttribute("pageNo", pageNo);
/* 406 */     model.addAttribute("backUrl", "/memberSubmissionList");
/* 407 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/* 408 */     if ((memberAgent == null) || (StringUtil.isBlank(memberAgent.getUserType())) || (memberAgent.getUserId() == null) || (memberAgent.getUserId().compareTo(Long.valueOf(0L)) <= 0))
/*     */     {
/* 410 */       model.addAttribute("message", "请先登录");
/* 411 */       this.stringTemplateRender.renderTplInCurrentSite(EnumTplDirType.COMMON.getCode(), "错误", request, response, model, memberAgent);
/* 412 */       return;
/*     */     }
/* 414 */     model.addAttribute("memberAgent", memberAgent);
/* 415 */     Cms2Cont cont = this.cms2ContService.selectById(id);
/* 416 */     if (!EnumContStatus.DRAFT.getCode().equals(cont.getStatus())) {
/* 417 */       model.addAttribute("message", "稿件已提交,不允许删除");
/* 418 */       this.stringTemplateRender.renderTplInCurrentSite(EnumTplDirType.COMMON.getCode(), "错误", request, response, model, memberAgent);
/* 419 */       return;
/*     */     }
/* 421 */     String message = this.cms2ContService.deleteById(id.toString());
/* 422 */     if (message.equals("delete"))
/*     */     {
/* 424 */       Cms2Job cms2Job = new Cms2Job(siteId, EnumStaticType.CONTENT_STATIC.getType(), id, EnumStaticOper.DELETE_STATIC.getType(), Long.valueOf(0L), "", null);
/* 425 */       this.cms2JobService.save(cms2Job);
/*     */ 
/* 428 */       Cms2JobTimingQuery cms2JobTimingQuery = new Cms2JobTimingQuery();
/* 429 */       cms2JobTimingQuery.setObjId(id.toString());
/* 430 */       cms2JobTimingQuery.setObjType(EnumJobTimingObj.OBJ_TYPE_CONTENT.getType().toString());
/* 431 */       cms2JobTimingQuery.setSiteId(siteId.toString());
/*     */ 
/* 433 */       cms2JobTimingQuery.setObjOper(EnumJobTimingType.OBJ_OPER_START_TIME.getType().toString());
/* 434 */       this.cms2JobTimingService.delete(cms2JobTimingQuery);
/* 435 */     } else if (message.equals("recycle"))
/*     */     {
/* 437 */       Cms2Job cms2Job = new Cms2Job(siteId, EnumStaticType.CONTENT_STATIC.getType(), id, EnumStaticOper.CYCLE_STATIC.getType(), Long.valueOf(0L), "", null);
/* 438 */       this.cms2JobService.save(cms2Job);
/*     */ 
/* 441 */       Cms2JobTimingQuery cms2JobTimingQuery = new Cms2JobTimingQuery();
/* 442 */       cms2JobTimingQuery.setObjId(id.toString());
/* 443 */       cms2JobTimingQuery.setObjType(EnumJobTimingObj.OBJ_TYPE_CONTENT.getType().toString());
/* 444 */       cms2JobTimingQuery.setSiteId(siteId.toString());
/*     */ 
/* 446 */       cms2JobTimingQuery.setObjOper(EnumJobTimingType.OBJ_OPER_START_TIME.getType().toString());
/* 447 */       this.cms2JobTimingService.delete(cms2JobTimingQuery);
/*     */     } else {
/* 449 */       model.addAttribute("message", message);
/* 450 */       this.stringTemplateRender.renderTplInCurrentSite(EnumTplDirType.COMMON.getCode(), "错误", request, response, model, memberAgent);
/* 451 */       return;
/*     */     }
/* 453 */     model.addAttribute("message", "删除成功!");
/* 454 */     this.stringTemplateRender.renderTplInCurrentSite(EnumTplDirType.COMMON.getCode(), "成功", request, response, model, memberAgent);
/*     */   }
/*     */ 
/*     */   private String[] resolveQ(String q)
/*     */   {
/* 462 */     return q.split("\\|");
/*     */   }
/*     */ 
/*     */   private String packageQ(String title, String status, String channelId)
/*     */   {
/* 469 */     String sb = StringUtil.isBlank(title) ? "" : title;
/* 470 */     sb = new StringBuilder().append(sb).append("|").append(StringUtil.isBlank(status) ? "" : status).toString();
/* 471 */     sb = new StringBuilder().append(sb).append("|").append(StringUtil.isBlank(channelId) ? "" : channelId).toString();
/* 472 */     return sb;
/*     */   }
/*     */ 
/*     */   private String packageChannelIds(List<Cms2Channel> channels) {
/* 476 */     StringBuilder sb = new StringBuilder();
/* 477 */     if ((channels == null) || (channels.size() <= 0))
/* 478 */       return null;
/* 479 */     for (int i = 0; i < channels.size(); i++) {
/* 480 */       sb.append(((Cms2Channel)channels.get(i)).getId());
/* 481 */       if (i + 1 < channels.size())
/* 482 */         sb.append(",");
/*     */     }
/* 484 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public Cms2Attach transforAttach(Cms2Attach attach, HttpServletRequest request) {
/* 488 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/* 489 */     Cms2Site site = this.cms2SiteService.queryById(siteId);
/* 490 */     String urlPrefix = new StringBuilder().append(this.uploadServerBroker.getConfig().getURL()).append(this.resSys).append(site.getResPath()).toString();
/* 491 */     if (attach != null) {
/* 492 */       String fileUlr = attach.getAttachName();
/* 493 */       int containsIndex = fileUlr.indexOf(urlPrefix);
/* 494 */       if (containsIndex != -1) {
/* 495 */         String filePath = fileUlr.substring(urlPrefix.length(), fileUlr.length());
/* 496 */         filePath = filePath.substring(0, filePath.lastIndexOf("/") + 1);
/* 497 */         String fileName = fileUlr.substring(fileUlr.lastIndexOf("/") + 1, fileUlr.length());
/* 498 */         attach.setAttachName(fileName);
/* 499 */         attach.setAttachPath(filePath);
/*     */       }
/*     */     }
/* 502 */     return attach;
/*     */   }
/*     */ 
/*     */   public Cms2ContAll transforAllAttach(Cms2ContAll cont, HttpServletRequest request) {
/* 506 */     if (cont.getArticleTitleImg() != null) {
/* 507 */       cont.setArticleTitleImg(transforAttach(cont.getArticleTitleImg(), request));
/*     */     }
/* 509 */     if (cont.getArticleContImg() != null) {
/* 510 */       cont.setArticleContImg(transforAttach(cont.getArticleContImg(), request));
/*     */     }
/* 512 */     if (null != cont.getArticleMedia()) {
/* 513 */       cont.setArticleMedia(transforAttach(cont.getArticleMedia(), request));
/*     */     }
/* 515 */     if (null != cont.getAttachmentPaths()) {
/* 516 */       List attachList = new ArrayList();
/* 517 */       int i = 0; for (int len = cont.getAttachmentPaths().length; i < len; i++) {
/* 518 */         if (!StringUtils.isBlank(cont.getAttachmentPaths()[i])) {
/* 519 */           Cms2Attach attach = new Cms2Attach();
/* 520 */           attach.setObjId(cont.getId());
/* 521 */           attach.setPriority(Long.valueOf(0L));
/* 522 */           attach.setDownloadCount(Long.valueOf(0L));
/* 523 */           attach.setStatus(EnumAttachStatus.PERMANENT.getValue());
/* 524 */           attach.setAttachType(EnumAttachType.ARTICLE_ATTACHS.getValue());
/* 525 */           attach.setAttachName(cont.getAttachmentPaths()[i]);
/* 526 */           attach = transforAttach(attach, request);
/* 527 */           attachList.add(attach);
/*     */         }
/*     */       }
/* 530 */       cont.setArticleAttachs(attachList);
/*     */     }
/* 532 */     if (null != cont.getPicPaths()) {
/* 533 */       List attachList = new ArrayList();
/* 534 */       int i = 0; for (int len = cont.getPicPaths().length; i < len; i++) {
/* 535 */         if (!StringUtils.isBlank(cont.getPicPaths()[i])) {
/* 536 */           Cms2Attach attach = new Cms2Attach();
/* 537 */           attach.setObjId(cont.getId());
/* 538 */           attach.setPriority(Long.valueOf(0L));
/* 539 */           attach.setDownloadCount(Long.valueOf(0L));
/* 540 */           attach.setStatus(EnumAttachStatus.PERMANENT.getValue());
/* 541 */           attach.setAttachType(EnumAttachType.ARTICLE_PICTURES.getValue());
/* 542 */           attach.setAttachName(cont.getPicPaths()[i]);
/* 543 */           attach = transforAttach(attach, request);
/* 544 */           attachList.add(attach);
/*     */         }
/*     */       }
/*     */     }
/* 548 */     return cont;
/*     */   }
/*     */ 
/*     */   private boolean canRevocate(Cms2Cont cont)
/*     */   {
/* 555 */     if (EnumContStatus.AUDITING.getCode().equals(cont.getStatus())) {
/* 556 */       Cms2ContCheckQuery contCheckQuery = new Cms2ContCheckQuery();
/* 557 */       contCheckQuery.setContentId(cont.getId().toString());
/* 558 */       List cms2ContCheckList = this.cms2ContCheckService.queryCms2ContCheckList(contCheckQuery);
/* 559 */       if ((cms2ContCheckList != null) && (cms2ContCheckList.size() > 0)) {
/* 560 */         Cms2ContCheck contCheck = (Cms2ContCheck)cms2ContCheckList.get(0);
/* 561 */         if ((EnumContIsRejected.NOT_REJECTED.getCode().equals(contCheck.getIsRejected())) && (new Long(0L).equals(contCheck.getCheckStep())))
/*     */         {
/* 564 */           return true;
/*     */         }
/*     */       }
/*     */     }
/* 567 */     return false;
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/memberRevocation"})
/*     */   public void revocation(String q, Integer pageNo, Long id, ModelMap model, SettlerAgent memberAgent, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/* 576 */     model.addAttribute("q", q);
/* 577 */     model.addAttribute("pageNo", pageNo);
/* 578 */     model.addAttribute("backUrl", "/memberSubmissionList");
/* 579 */     Cms2Cont cont = this.cms2ContService.selectById(id);
/* 580 */     if (canRevocate(cont)) {
/* 581 */       cont = new Cms2Cont();
/* 582 */       cont.setId(id);
/* 583 */       cont.setStatus(EnumContStatus.DRAFT.getCode());
/* 584 */       this.cms2ContService.update(cont);
/* 585 */       this.stringTemplateRender.renderTplInCurrentSite(EnumTplDirType.COMMON.getCode(), "成功", request, response, model, memberAgent);
/*     */     } else {
/* 587 */       model.addAttribute("message", "稿件状态不正确，请刷新重试");
/* 588 */       this.stringTemplateRender.renderTplInCurrentSite(EnumTplDirType.COMMON.getCode(), "错误", request, response, model, memberAgent);
/*     */     }
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/memberBatchRevocation"})
/*     */   public void batchRevocation(String q, Integer pageNo, @RequestParam(value="ids", required=false) List<Long> ids, ModelMap model, SettlerAgent memberAgent, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/* 599 */     model.addAttribute("q", q);
/* 600 */     model.addAttribute("pageNo", pageNo);
/* 601 */     model.addAttribute("backUrl", "/memberSubmissionList");
/* 602 */     List<Cms2Cont> contList = new ArrayList();
/* 603 */     Cms2Cont cont = null;
/* 604 */     for (Long id : ids) {
/* 605 */       cont = this.cms2ContService.selectById(id);
/* 606 */       if (!canRevocate(cont)) {
/* 607 */         model.addAttribute("message", "稿件状态不正确，请刷新重试");
/* 608 */         this.stringTemplateRender.renderTplInCurrentSite(EnumTplDirType.COMMON.getCode(), "错误", request, response, model, memberAgent);
/* 609 */         return;
/*     */       }
/* 611 */       contList.add(cont);
/*     */     }
/* 613 */     Cms2Cont temp = new Cms2Cont();
/* 614 */     for (Cms2Cont contTemp : contList) {
/* 615 */       temp.setId(contTemp.getId());
/* 616 */       temp.setStatus(EnumContStatus.DRAFT.getCode());
/* 617 */       this.cms2ContService.update(temp);
/*     */     }
/* 619 */     this.stringTemplateRender.renderTplInCurrentSite(EnumTplDirType.COMMON.getCode(), "成功", request, response, model, memberAgent);
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy13\cmsWeb\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.web.action.SpecialRequestAction
 * JD-Core Version:    0.6.0
 */