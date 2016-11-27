/*     */ package com.hundsun.network.hseccms.admin.action;
/*     */ 
/*     */ import com.hundsun.network.hseccms.admin.security.SettlerAccess;
/*     */ import com.hundsun.network.hseccms.admin.util.Cms2Utils;
/*     */ import com.hundsun.network.hseccms.admin.util.ResponseUtils;
/*     */ import com.hundsun.network.hseccms.model.Cms2Channel;
/*     */ import com.hundsun.network.hseccms.model.Cms2Cont;
/*     */ import com.hundsun.network.hseccms.model.Cms2ContAll;
/*     */ import com.hundsun.network.hseccms.query.Cms2ContQuery;
/*     */ import com.hundsun.network.hseccms.service.Cms2ChannelService;
/*     */ import com.hundsun.network.hseccms.service.Cms2ContService;
/*     */ import com.hundsun.network.hseccms.service.Cms2SiteService;
/*     */ import com.hundsun.network.hseccms.staticpage.StaticPageSvc;
/*     */ import freemarker.template.TemplateException;
/*     */ import java.io.IOException;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ 
/*     */ @Controller
/*     */ @RequestMapping({"/static"})
/*     */ public class StaticAction extends BaseAction
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private Cms2SiteService cms2SiteService;
/*     */ 
/*     */   @Autowired
/*     */   private StaticPageSvc staticPageSvc;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2ChannelService cms2ChannelService;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2ContService cms2ContService;
/*     */ 
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.HOMESTATIC})
/*     */   @RequestMapping({"/v_creatindex"})
/*     */   public String v_creatindex(HttpServletRequest request, HttpServletResponse response, Model model)
/*     */   {
/*  73 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/*  74 */     model.addAttribute("siteId", siteId);
/*  75 */     return "static/index";
/*     */   }
/*     */ 
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.HOMESTATIC})
/*     */   @RequestMapping({"/creatindex"})
/*     */   public void creatindex(Long siteId, HttpServletRequest request, HttpServletResponse response, Model model)
/*     */   {
/*     */     try
/*     */     {
/*  86 */       this.staticPageSvc.advertisingSpace(siteId);
/*  87 */       this.staticPageSvc.Frindlink(siteId);
/*  88 */       this.staticPageSvc.menu(siteId);
/*  89 */       this.staticPageSvc.Homepage(siteId);
/*  90 */       ResponseUtils.renderJson(response, "{'success':true}");
/*     */     } catch (IOException e) {
/*  92 */       this._log.error("static index error!", e);
/*  93 */       ResponseUtils.renderJson(response, "{'success':false,'msg':'" + e.getMessage() + "'}");
/*     */     }
/*     */     catch (TemplateException e) {
/*  96 */       this._log.error("static index error!", e);
/*  97 */       ResponseUtils.renderJson(response, "{'success':false,'msg':'" + e.getMessage() + "'}");
/*     */     }
/*     */     catch (Exception e) {
/* 100 */       this._log.error("static index error!", e);
/* 101 */       ResponseUtils.renderJson(response, "{'success':false,'msg':'" + e.getMessage() + "'}");
/*     */     }
/*     */   }
/*     */ 
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.HOMESTATIC})
/*     */   @RequestMapping({"/deleteindex"})
/*     */   public void deleteindex(Long siteId, HttpServletRequest request, HttpServletResponse response, Model model)
/*     */   {
/*     */     String msg;
/*     */     try
/*     */     {
/* 115 */       this.staticPageSvc.homepageDelete(siteId);
/* 116 */       msg = "{'success':true}";
/*     */     } catch (Exception e) {
/* 118 */       this._log.error("indexRemove error!", e);
/* 119 */       msg = "{'success':false,'msg':'" + e.getMessage() + "'}";
/*     */     }
/* 121 */     ResponseUtils.renderJson(response, msg);
/*     */   }
/*     */ 
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.HOMESTATIC})
/*     */   @RequestMapping({"/creatadv"})
/*     */   public void creatadv(Long siteId, HttpServletRequest request, HttpServletResponse response, Model model)
/*     */   {
/*     */     try
/*     */     {
/* 132 */       this.staticPageSvc.advertisingSpace(siteId);
/* 133 */       ResponseUtils.renderJson(response, "{'success':true}");
/*     */     } catch (IOException e) {
/* 135 */       this._log.error("static index error!", e);
/* 136 */       ResponseUtils.renderJson(response, "{'success':false,'msg':'" + e.getMessage() + "'}");
/*     */     }
/*     */     catch (TemplateException e) {
/* 139 */       this._log.error("static index error!", e);
/* 140 */       ResponseUtils.renderJson(response, "{'success':false,'msg':'" + e.getMessage() + "'}");
/*     */     }
/*     */     catch (Exception e) {
/* 143 */       this._log.error("static index error!", e);
/* 144 */       ResponseUtils.renderJson(response, "{'success':false,'msg':'" + e.getMessage() + "'}");
/*     */     }
/*     */   }
/*     */ 
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.HOMESTATIC})
/*     */   @RequestMapping({"/creatfriend"})
/*     */   public void creatfriend(Long siteId, HttpServletRequest request, HttpServletResponse response, Model model)
/*     */   {
/*     */     try
/*     */     {
/* 157 */       this.staticPageSvc.Frindlink(siteId);
/* 158 */       ResponseUtils.renderJson(response, "{'success':true}");
/*     */     } catch (IOException e) {
/* 160 */       this._log.error("static index error!", e);
/* 161 */       ResponseUtils.renderJson(response, "{'success':false,'msg':'" + e.getMessage() + "'}");
/*     */     }
/*     */     catch (TemplateException e) {
/* 164 */       this._log.error("static index error!", e);
/* 165 */       ResponseUtils.renderJson(response, "{'success':false,'msg':'" + e.getMessage() + "'}");
/*     */     }
/*     */     catch (Exception e) {
/* 168 */       this._log.error("static index error!", e);
/* 169 */       ResponseUtils.renderJson(response, "{'success':false,'msg':'" + e.getMessage() + "'}");
/*     */     }
/*     */   }
/*     */ 
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.HOMESTATIC})
/*     */   @RequestMapping({"/creatmenu"})
/*     */   public void creatmenu(Long siteId, HttpServletRequest request, HttpServletResponse response, Model model)
/*     */   {
/*     */     try
/*     */     {
/* 182 */       this.staticPageSvc.menu(siteId);
/* 183 */       ResponseUtils.renderJson(response, "{'success':true}");
/*     */     } catch (IOException e) {
/* 185 */       this._log.error("static index error!", e);
/* 186 */       ResponseUtils.renderJson(response, "{'success':false,'msg':'" + e.getMessage() + "'}");
/*     */     }
/*     */     catch (TemplateException e) {
/* 189 */       this._log.error("static index error!", e);
/* 190 */       ResponseUtils.renderJson(response, "{'success':false,'msg':'" + e.getMessage() + "'}");
/*     */     }
/*     */     catch (Exception e) {
/* 193 */       this._log.error("static index error!", e);
/* 194 */       ResponseUtils.renderJson(response, "{'success':false,'msg':'" + e.getMessage() + "'}");
/*     */     }
/*     */   }
/*     */ 
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.CHANNELSTATIC})
/*     */   @RequestMapping({"/v_creatchannel"})
/*     */   public String v_creatchannel(Long siteId, HttpServletRequest request, ModelMap model)
/*     */   {
/* 206 */     if (siteId == null) {
/* 207 */       siteId = Cms2Utils.getCurrentSiteId(request);
/*     */     }
/*     */ 
/* 210 */     List wholeChannelList = this.cms2ChannelService.getWholeTreeBySite(siteId);
/* 211 */     model.addAttribute("wholeChannelList", wholeChannelList);
/* 212 */     model.addAttribute("siteId", siteId);
/* 213 */     return "static/channel";
/*     */   }
/*     */ 
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.CHANNELSTATIC})
/*     */   @RequestMapping({"/creatchannel"})
/*     */   public void creatchannel(Long siteId, Long channelId, Boolean containChild, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/* 223 */     if (containChild == null)
/* 224 */       containChild = Boolean.valueOf(true);
/*     */     String msg;
/*     */     try
/*     */     {
/* 229 */       this.staticPageSvc.menu(siteId);
/*     */ 
/* 231 */       this.staticPageSvc.advertisingSpace(siteId);
/* 232 */       this.staticPageSvc.Frindlink(siteId);
/*     */ 
/* 234 */       List<Cms2Channel> channelList = this.cms2ChannelService.channelALLForListBySite(siteId);
/*     */ 
/* 236 */       for (Cms2Channel channelforRelate : channelList)
/*     */       {
/* 238 */         this.staticPageSvc.relatePage(siteId, channelforRelate);
/*     */       }
/*     */ 
/* 241 */       if (null != channelId) {
/* 242 */         Cms2Channel channel = this.cms2ChannelService.channelALLForObjectById(channelId, Long.valueOf(1L));
/* 243 */         this.staticPageSvc.channel(siteId, channel);
/*     */       }
/* 245 */       if ((containChild.booleanValue()) || (channelId == null)) {
/* 246 */         List<Long> childIds = this.cms2ChannelService.queryChannelIdListByParentId(channelId);
/* 247 */         for (Long childId : childIds) {
/* 248 */           Cms2Channel childChannel = this.cms2ChannelService.channelALLForObjectById(childId, Long.valueOf(1L));
/* 249 */           this.staticPageSvc.channel(siteId, childChannel);
/*     */         }
/*     */       }
/*     */ 
/* 253 */       msg = "{'success':true,'count':'生成成功'}";
/*     */     } catch (IOException e) {
/* 255 */       this._log.error("static channel error!", e);
/* 256 */       msg = "{'success':false,'msg':'" + e.getMessage() + "'}";
/*     */     } catch (TemplateException e) {
/* 258 */       this._log.error("static channel error!", e);
/* 259 */       msg = "{'success':false,'msg':'" + e.getMessage() + "'}";
/*     */     } catch (Exception e) {
/* 261 */       this._log.error("static channel error!", e);
/* 262 */       msg = "{'success':false,'msg':'" + e.getMessage() + "'}";
/*     */     }
/* 264 */     ResponseUtils.renderJson(response, msg);
/*     */   }
/*     */ 
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.CONTENTSTATIC})
/*     */   @RequestMapping({"/v_creatcontent"})
/*     */   public String v_creatcontent(Long siteId, HttpServletRequest request, ModelMap model)
/*     */   {
/* 274 */     if (siteId == null) {
/* 275 */       siteId = Cms2Utils.getCurrentSiteId(request);
/*     */     }
/*     */ 
/* 278 */     List wholeChannelList = this.cms2ChannelService.getWholeTreeBySite(siteId);
/* 279 */     model.addAttribute("wholeChannelList", wholeChannelList);
/* 280 */     model.addAttribute("siteId", siteId);
/* 281 */     return "static/content";
/*     */   }
/*     */ 
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.CONTENTSTATIC})
/*     */   @RequestMapping({"/creatcontent"})
/*     */   public void creatcontent(Long siteId, Long channelId, String startDate, HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*     */     String msg;
/*     */     try
/*     */     {
/* 295 */       this.staticPageSvc.advertisingSpace(siteId);
/* 296 */       this.staticPageSvc.Frindlink(siteId);
/*     */ 
/* 298 */       List<Cms2Channel> channelList = this.cms2ChannelService.channelALLForListBySite(siteId);
/*     */ 
/* 300 */       for (Cms2Channel channelforRelate : channelList)
/*     */       {
/* 302 */         this.staticPageSvc.relatePage(siteId, channelforRelate);
/*     */       }
/*     */ 
/* 306 */       this.staticPageSvc.menu(siteId);
/*     */ 
/* 309 */       Cms2ContQuery query = new Cms2ContQuery();
/* 310 */       if (channelId != null)
/*     */       {
/* 312 */         query.setChannelId(channelId.toString());
/*     */       }
/* 314 */       else query.setSiteId(siteId.toString());
/*     */ 
/* 316 */       if (null != startDate) {
/* 317 */         query.setSortDateStart(startDate);
/*     */       }
/* 319 */       List<Cms2Cont> contList = this.cms2ContService.selectList(query);
/* 320 */       for (Cms2Cont cont : contList) {
/* 321 */         Cms2ContAll content = this.cms2ContService.selectAllById(cont.getId());
/* 322 */         this.staticPageSvc.content(siteId, content);
/*     */       }
/*     */ 
/* 325 */       msg = "{'success':true,'count':" + contList.size() + "}";
/*     */     } catch (IOException e) {
/* 327 */       this._log.error("static channel error!", e);
/* 328 */       msg = "{'success':false,'msg':'" + e.getMessage() + "'}";
/*     */     } catch (TemplateException e) {
/* 330 */       this._log.error("static channel error!", e);
/* 331 */       msg = "{'success':false,'msg':'" + e.getMessage() + "'}";
/*     */     } catch (Exception e) {
/* 333 */       this._log.error("static channel error!", e);
/* 334 */       msg = "{'success':false,'msg':'" + e.getMessage() + "'}";
/*     */     }
/* 336 */     ResponseUtils.renderJson(response, msg);
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy\cmsAdmin\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.admin.action.StaticAction
 * JD-Core Version:    0.6.0
 */