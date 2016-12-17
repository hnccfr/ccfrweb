/*     */ package com.hundsun.network.hseccms.web.action;
/*     */ 
/*     */ import com.hundsun.network.hseccms.common.URLHelper;
/*     */ import com.hundsun.network.hseccms.common.URLHelper.PageInfo;
/*     */ import com.hundsun.network.hseccms.enums.EnumContStatus;
/*     */ import com.hundsun.network.hseccms.enums.EnumModelHasContent;
/*     */ import com.hundsun.network.hseccms.enums.EnumTplDirType;
/*     */ import com.hundsun.network.hseccms.model.Cms2Channel;
/*     */ import com.hundsun.network.hseccms.model.Cms2ChannelExt;
/*     */ import com.hundsun.network.hseccms.model.Cms2ContAll;
/*     */ import com.hundsun.network.hseccms.model.Cms2Model;
/*     */ import com.hundsun.network.hseccms.model.Cms2Site;
/*     */ import com.hundsun.network.hseccms.model.Cms2Template;
/*     */ import com.hundsun.network.hseccms.security.SettlerAgent;
/*     */ import com.hundsun.network.hseccms.service.Cms2ChannelExtService;
/*     */ import com.hundsun.network.hseccms.service.Cms2ChannelService;
/*     */ import com.hundsun.network.hseccms.service.Cms2ContService;
/*     */ import com.hundsun.network.hseccms.service.Cms2SiteService;
/*     */ import com.hundsun.network.hseccms.service.Cms2TemplateService;
/*     */ import com.hundsun.network.hseccms.staticpage.StaticPageSvc;
/*     */ import com.hundsun.network.hseccms.util.Cms2Utils;
/*     */ import com.hundsun.network.hseccms.util.FrontUtils;
/*     */ import com.hundsun.network.hseccms.web.common.WebUtils;
/*     */ import com.hundsun.network.hseccms.web.render.StringTemplateRender;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ 
/*     */ @Controller
/*     */ public class RequestDispatcherAction
/*     */ {
/*  48 */   private static Log _log = LogFactory.getLog(WelcomeAction.class);
/*     */ 
/*  50 */   public static String INDEX = "index";
/*     */ 
/*     */   @Autowired
/*     */   private Cms2TemplateService cms2TemplateService;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2ContService cms2ContService;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2ChannelService cms2ChannelService;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2ChannelExtService cms2ChannelExtService;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2SiteService cms2SiteService;
/*     */ 
/*     */   @Autowired
/*     */   private StringTemplateRender stringTemplateRender;
/*     */ 
/*     */   @Autowired
/*     */   private StaticPageSvc staticPageSvc;
/*     */ 
/*  83 */   @RequestMapping(value={"/toDynamic*"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void urlStaicToDynamic(HttpServletRequest request, HttpServletResponse response, ModelMap model, SettlerAgent user) { Cms2Site site = Cms2Utils.getSite(request);
/*  84 */     String url = request.getParameter("url");
/*     */     try {
/*  86 */       if (url.indexOf(this.staticPageSvc.getSiteStaticPre(site)) < 0) {
/*  87 */         _log.debug("toDynamic illegel url");
/*  88 */         this.stringTemplateRender.renderTplInCurrentSite(EnumTplDirType.COMMON.getCode(), "错误", request, response, model, user);
/*  89 */         return;
/*     */       }
/*  91 */       url = url.replace(this.staticPageSvc.getSiteStaticPre(site), "");
/*  92 */       url = url.replace(site.getStaticSuffix(), site.getDynamicSuffix());
/*  93 */       response.sendRedirect(url);
/*  94 */       return;
/*     */     } catch (Exception e) {
/*  96 */       _log.debug("toDynamic error" + e);
/*  97 */       this.stringTemplateRender.renderTplInCurrentSite(EnumTplDirType.COMMON.getCode(), "错误", request, response, model, user);
/*     */     }
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"/index"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void indexForWeblogic(HttpServletRequest request, HttpServletResponse response, ModelMap model, SettlerAgent user)
/*     */   {
/* 107 */     index(request, response, model, user);
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"/"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void index(HttpServletRequest request, HttpServletResponse response, ModelMap model, SettlerAgent user)
/*     */   {
/*     */     try
/*     */     {
/* 116 */       Cms2Site site = Cms2Utils.getSite(request);
/*     */ 
/* 119 */       String url = this.staticPageSvc.getHomepageFile(site);
/* 120 */       if ((url != null) && (url != "") && (site.getStaticIndex())) {
/* 121 */         response.sendRedirect(url);
/* 122 */         return;
/*     */       }
/*     */ 
/* 125 */       String tpl = "首页";
/* 126 */       String tempContent = null;
/* 127 */       Cms2Template template = this.cms2TemplateService.getTplByTypeAndName(site.getId() + "", EnumTplDirType.INDEX.getCode(), tpl);
/* 128 */       if (template != null)
/* 129 */         tempContent = template.getCont();
/* 130 */       FrontUtils.frontData(request, model, site, user);
/* 131 */       tempContent = this.stringTemplateRender.render(model, tempContent);
/* 132 */       WebUtils.toHtmlPage(response, tempContent);
/*     */     } catch (Exception e) {
/* 134 */       _log.error("", e);
/*     */     }
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"/**/*.*"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void dynamic(String visit, HttpServletRequest request, HttpServletResponse response, ModelMap model, SettlerAgent user)
/*     */   {
/* 146 */     int pageNo = URLHelper.getPageNo(request);
/* 147 */     String[] params = URLHelper.getParams(request);
/* 148 */     URLHelper.PageInfo info = URLHelper.getPageInfo(request);
/* 149 */     String[] paths = URLHelper.getPaths(request);
/* 150 */     int len = paths.length;
/*     */     try {
/* 152 */       if (len == 1) {
/* 153 */         channel(paths[0], pageNo, params, info, request, response, model, user);
/* 154 */         return;
/* 155 */       }if (len == 2) {
/* 156 */         if (paths[1].equals(INDEX)) {
/* 157 */           channel(paths[0], pageNo, params, info, request, response, model, user);
/* 158 */           return;
/*     */         }
/* 160 */         Long id = Long.valueOf(Long.parseLong(paths[1]));
/* 161 */         content(id, visit, pageNo, params, info, request, response, model, user);
/* 162 */         return;
/*     */       }
/*     */ 
/* 165 */       _log.debug("Illegal path length: {" + len + "}, paths: {" + paths + "}");
/* 166 */       this.stringTemplateRender.renderTplInCurrentSite(EnumTplDirType.COMMON.getCode(), "错误", request, response, model, user);
/* 167 */       return;
/*     */     }
/*     */     catch (Exception e) {
/* 170 */       _log.debug("request faild", e);
/* 171 */       this.stringTemplateRender.renderTplInCurrentSite(EnumTplDirType.COMMON.getCode(), "错误", request, response, model, user);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void channel(String path, int pageNo, String[] params, URLHelper.PageInfo info, HttpServletRequest request, HttpServletResponse response, ModelMap model, SettlerAgent user)
/*     */     throws Exception
/*     */   {
/* 182 */     Cms2Site site = Cms2Utils.getSite(request);
/* 183 */     Cms2Channel channel = this.cms2ChannelService.channelDirectiveForObject(null, site.getSitePath(), path);
/* 184 */     if (channel == null) {
/* 185 */       _log.debug("Channel path not found: {" + path + "}");
/* 186 */       FrontUtils.frontData(request, model, site, user);
/* 187 */       Cms2Template template = this.cms2TemplateService.getTplByTypeAndName(site.getId() + "", EnumTplDirType.COMMON.getCode(), "无页面");
/* 188 */       String str = template.getCont();
/* 189 */       this.stringTemplateRender.render(model, str);
/* 190 */       WebUtils.toHtmlPage(response, str);
/* 191 */       return;
/*     */     }
/* 193 */     Cms2Model cms2Model = channel.getModel();
/* 194 */     if (EnumModelHasContent.SINGLE.getCode().equals(cms2Model.getHasContent()));
/* 198 */     List channelList = this.cms2ChannelService.getWholeTreeBySite(channel.getSiteId());
/* 199 */     ArrayList channelListParent = new ArrayList();
/* 200 */     if (null != channel.getParentId()) {
/* 201 */       channelListParent = getParentList(channel.getParentId().longValue(), channelList);
/*     */     }
/* 203 */     channel.setParentList(channelListParent);
/*     */ 
/* 205 */     model.addAttribute("channel", channel);
/* 206 */     FrontUtils.frontData(request, model, site, user);
/* 207 */     FrontUtils.frontPageData(request, site, Boolean.valueOf(true), model);
/* 208 */     Cms2ChannelExt channelExt = channel.getChannelExt();
/* 209 */     Cms2Template template = null;
/* 210 */     if ((channelExt.getTplChnlId() == null) || (channelExt.getTplChnlId().compareTo(Long.valueOf(0L)) <= 0)) {
/* 211 */       String tpl = cms2Model.getTplChannelPrefix();
/* 212 */       if (StringUtil.isNotBlank(tpl))
/* 213 */         template = this.cms2TemplateService.getTplByTypeAndName(site.getId() + "", EnumTplDirType.CHANNEL.getCode(), tpl);
/*     */     } else {
/* 215 */       template = this.cms2TemplateService.getByTplId(channelExt.getTplChnlId().toString());
/*     */     }
/* 217 */     channel.setSite(site);
/* 218 */     String str = null;
/* 219 */     if (template != null)
/* 220 */       str = template.getCont();
/* 221 */     str = this.stringTemplateRender.render(model, str);
/* 222 */     WebUtils.toHtmlPage(response, str);
/*     */   }
/*     */ 
/*     */   public void content(Long id, String visit, int pageNo, String[] params, URLHelper.PageInfo info, HttpServletRequest request, HttpServletResponse response, ModelMap model, SettlerAgent user)
/*     */     throws Exception
/*     */   {
/* 231 */     Cms2ContAll content = this.cms2ContService.selectAllById(id);
/* 232 */     if (content == null) {
/* 233 */       _log.debug("Content id not found: " + id);
/* 234 */       model.addAttribute("message", "操作失败");
/* 235 */       this.stringTemplateRender.renderTplInCurrentSite(EnumTplDirType.COMMON.getCode(), "公用错误页面", request, response, model, user);
/* 236 */       return;
/*     */     }
/* 238 */     if ((StringUtil.isBlank(visit)) && (!EnumContStatus.FINISH.getCode().equals(content.getStatus()))) {
/* 239 */       model.addAttribute("message", "操作失败");
/* 240 */       this.stringTemplateRender.renderTplInCurrentSite(EnumTplDirType.COMMON.getCode(), "公用错误页面", request, response, model, user);
/* 241 */       return;
/*     */     }
/* 243 */     Cms2Channel channel = this.cms2ChannelService.channelDirectiveForObject(content.getChannelId(), null, null);
/*     */ 
/* 245 */     List channelList = this.cms2ChannelService.getWholeTreeBySite(channel.getSiteId());
/* 246 */     ArrayList channelListParent = new ArrayList();
/* 247 */     if (null != channel.getParentId()) {
/* 248 */       channelListParent = getParentList(channel.getParentId().longValue(), channelList);
/*     */     }
/* 250 */     channel.setParentList(channelListParent);
/*     */ 
/* 252 */     Cms2Model cms2Model = channel.getModel();
/* 253 */     Cms2Site site = this.cms2SiteService.queryById(content.getSiteId());
/* 254 */     FrontUtils.frontPageData(request, site, Boolean.valueOf(true), model);
/* 255 */     model.addAttribute("content", content);
/* 256 */     model.addAttribute("channel", channel);
/* 257 */     FrontUtils.frontData(request, model, site, user);
/* 258 */     Cms2ChannelExt channelExt = channel.getChannelExt();
/* 259 */     Cms2Template template = null;
/* 260 */     if ((channelExt.getTplContId() == null) || (channelExt.getTplContId().compareTo(Long.valueOf(0L)) <= 0)) {
/* 261 */       String tpl = cms2Model.getTplContentPrefix();
/* 262 */       if (StringUtil.isNotBlank(tpl))
/* 263 */         template = this.cms2TemplateService.getTplByTypeAndName(site.getId() + "", EnumTplDirType.CONTENT.getCode(), tpl);
/*     */     } else {
/* 265 */       template = this.cms2TemplateService.getByTplId(channelExt.getTplContId().toString());
/*     */     }
/*     */ 
/* 268 */     String str = null;
/* 269 */     if (template != null)
/* 270 */       str = template.getCont();
/* 271 */     str = this.stringTemplateRender.render(model, str);
/* 272 */     WebUtils.toHtmlPage(response, str);
/*     */   }
/*     */ 
/*     */   private ArrayList<Cms2Channel> getParentList(long parentId, List<Cms2Channel> channelListAll)
/*     */   {
/* 281 */     ArrayList channelList = new ArrayList();
/* 282 */     Cms2Channel channelParent = new Cms2Channel();
/* 283 */     for (Cms2Channel channelTemp : channelListAll) {
/* 284 */       if ((null != channelTemp) && (null != channelTemp.getId()) && (channelTemp.getId().longValue() == parentId)) {
/* 285 */         channelParent = channelTemp;
/* 286 */         if (null != channelTemp.getParentId()) {
/* 287 */           channelList = getParentList(channelTemp.getParentId().longValue(), channelListAll);
/* 288 */           break;
/*     */         }
/*     */       }
/*     */     }
/* 292 */     channelList.add(channelParent);
/* 293 */     return channelList;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy13\cmsWeb\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.web.action.RequestDispatcherAction
 * JD-Core Version:    0.6.0
 */