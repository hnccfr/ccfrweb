/*     */ package com.hundsun.network.hseccms.admin.action;
/*     */ 
/*     */ import com.hundsun.network.hseccms.admin.security.SettlerAccess;
/*     */ import com.hundsun.network.hseccms.admin.security.SettlerAgent;
/*     */ import com.hundsun.network.hseccms.admin.util.Cms2Utils;
/*     */ import com.hundsun.network.hseccms.enums.EnumDeleteStatus;
/*     */ import com.hundsun.network.hseccms.enums.EnumIsEnable;
/*     */ import com.hundsun.network.hseccms.enums.EnumStaticOper;
/*     */ import com.hundsun.network.hseccms.enums.EnumStaticType;
/*     */ import com.hundsun.network.hseccms.model.Cms2Flink;
/*     */ import com.hundsun.network.hseccms.model.Cms2FlinkCtg;
/*     */ import com.hundsun.network.hseccms.model.Cms2Job;
/*     */ import com.hundsun.network.hseccms.model.Cms2Site;
/*     */ import com.hundsun.network.hseccms.query.Cms2FlinkQuery;
/*     */ import com.hundsun.network.hseccms.service.Cms2FlinkCtgService;
/*     */ import com.hundsun.network.hseccms.service.Cms2FlinkService;
/*     */ import com.hundsun.network.hseccms.service.Cms2JobService;
/*     */ import com.hundsun.network.hseccms.service.Cms2SiteService;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.beans.factory.annotation.Value;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.web.bind.annotation.ModelAttribute;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ 
/*     */ @Controller
/*     */ @RequestMapping({"/link"})
/*     */ public class LinkAction extends BaseAction
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private Cms2FlinkService cms2FlinkService;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2FlinkCtgService cms2FlinkCtgService;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2JobService cms2JobService;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2SiteService cms2SiteService;
/*     */ 
/*     */   @Value("${resSys}")
/*     */   private String resSys;
/*  62 */   private static boolean NOIFRAME = true;
/*     */ 
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.LINK_MANAGE})
/*     */   @RequestMapping({"/list"})
/*     */   public String list(@RequestParam(value="q", required=false, defaultValue="") String queryStr, @ModelAttribute("query") Cms2FlinkQuery query, Model model)
/*     */   {
/*  75 */     if (StringUtil.isNotEmpty(queryStr)) {
/*  76 */       query = (Cms2FlinkQuery)query.riseUp(queryStr);
/*     */     }
/*     */ 
/*  79 */     query.setStatus(EnumDeleteStatus.NORMAL.getCode().toString());
/*  80 */     List ctgList = this.cms2FlinkCtgService.getAllLinkCtg();
/*  81 */     model.addAttribute("ctgList", ctgList);
/*  82 */     model.addAttribute("query", this.cms2FlinkService.query(query));
/*  83 */     model.addAttribute("isEnableMap", EnumIsEnable.toMap());
/*  84 */     model.addAttribute("resSys", this.resSys);
/*  85 */     model.addAttribute("q", query.lieDown());
/*  86 */     model.addAttribute("noiframe", Boolean.valueOf(NOIFRAME));
/*  87 */     query.setIsEnable(EnumIsEnable.ENABLE.getCode());
/*  88 */     return "link/list";
/*     */   }
/*     */ 
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.LINK_ADD})
/*     */   @RequestMapping(value={"/add"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String addInit(@RequestParam(value="q", required=false, defaultValue="") String queryStr, @RequestParam(value="root", required=false) String root, @ModelAttribute("link") Cms2Flink link, Model model, HttpServletRequest request)
/*     */   {
/* 104 */     model.addAttribute("q", queryStr);
/* 105 */     model.addAttribute("isEnableList", EnumIsEnable.toListCanBeSee());
/* 106 */     model.addAttribute("ctgList", this.cms2FlinkCtgService.getAllLinkCtg());
/*     */ 
/* 108 */     link.setViewCount(Long.valueOf(0L));
/* 109 */     link.setIsEnable(new Long(EnumIsEnable.ENABLE.getCode()));
/* 110 */     model.addAttribute("q", queryStr);
/* 111 */     model.addAttribute("resSys", this.resSys);
/* 112 */     return "link/add";
/*     */   }
/*     */ 
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.LINK_ADD})
/*     */   @RequestMapping(value={"/add"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String add(@RequestParam(value="q", required=false, defaultValue="") String queryStr, @ModelAttribute("link") Cms2Flink link, SettlerAgent cmsAgent, Model model, HttpServletRequest request)
/*     */   {
/* 129 */     link.setStatus(new Long(EnumDeleteStatus.NORMAL.getCode().longValue()));
/*     */ 
/* 131 */     Cms2FlinkCtg linkCtg = this.cms2FlinkCtgService.getById(link.getCtgId());
/* 132 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/* 133 */     if (siteId == null) {
/* 134 */       model.addAttribute("url", "/link/list.htm");
/* 135 */       model.addAttribute("q", queryStr);
/* 136 */       model.addAttribute("message", "系统获取不到当前所在站点，请重新登录");
/* 137 */       model.addAttribute("noiframe", Boolean.valueOf(NOIFRAME));
/* 138 */       return "error";
/*     */     }
/* 140 */     link.setSiteId(siteId);
/*     */ 
/* 142 */     link.setType(linkCtg.getType());
/* 143 */     Long linkId = this.cms2FlinkService.add(link);
/*     */ 
/* 146 */     Cms2Job cms2Job = new Cms2Job(siteId, EnumStaticType.FRIEND_LINK_STATIC.getType(), null, EnumStaticOper.MODIFY_STATIC.getType(), Long.valueOf(0L), "", null);
/* 147 */     this.cms2JobService.save(cms2Job);
/*     */ 
/* 149 */     model.addAttribute("noiframe", Boolean.valueOf(NOIFRAME));
/* 150 */     model.addAttribute("url", "/link/list.htm");
/* 151 */     model.addAttribute("q", queryStr);
/* 152 */     super.addLog(request, cmsAgent, Cms2Utils.getCurrentSiteId(request), "友链增加", linkId.toString(), link.getName());
/* 153 */     return "success";
/*     */   }
/*     */ 
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.LINK_DEL})
/*     */   @RequestMapping({"/delete"})
/*     */   public String delete(@RequestParam(value="q", required=false, defaultValue="") String queryStr, @RequestParam(value="id", required=true) Long id, SettlerAgent cmsAgent, HttpServletRequest request, Model model)
/*     */   {
/* 167 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/* 168 */     if (siteId == null) {
/* 169 */       model.addAttribute("url", "/link/list.htm");
/* 170 */       model.addAttribute("q", queryStr);
/* 171 */       model.addAttribute("message", "系统获取不到当前所在站点，请重新登录");
/* 172 */       model.addAttribute("noiframe", Boolean.valueOf(NOIFRAME));
/* 173 */       return "error";
/*     */     }
/*     */ 
/* 176 */     Cms2Site site = this.cms2SiteService.queryById(siteId);
/*     */ 
/* 179 */     if (site.getStaticRange().longValue() != 1L) {
/* 180 */       Cms2Flink flink = this.cms2FlinkService.getById(id);
/* 181 */       flink.setStatus(EnumDeleteStatus.DELETING.getCode());
/* 182 */       this.cms2FlinkService.update(flink);
/*     */     }
/*     */     else {
/* 185 */       this.cms2FlinkService.deleteById(id);
/*     */     }
/*     */ 
/* 189 */     Cms2Job cms2Job = new Cms2Job(siteId, EnumStaticType.FRIEND_LINK_STATIC.getType(), null, EnumStaticOper.MODIFY_STATIC.getType(), Long.valueOf(0L), "", null);
/* 190 */     this.cms2JobService.save(cms2Job);
/*     */ 
/* 192 */     model.addAttribute("url", "/link/list.htm");
/* 193 */     model.addAttribute("q", queryStr);
/* 194 */     model.addAttribute("message", "删除成功");
/* 195 */     super.addLog(request, cmsAgent, Cms2Utils.getCurrentSiteId(request), "友链删除", id.toString(), "");
/* 196 */     model.addAttribute("noiframe", Boolean.valueOf(NOIFRAME));
/* 197 */     return "success";
/*     */   }
/*     */ 
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.LINK_EDIT})
/*     */   @RequestMapping(value={"/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String editInit(@RequestParam(value="q", required=false, defaultValue="") String queryStr, @RequestParam(value="id", required=true) Long id, Model model)
/*     */   {
/* 211 */     model.addAttribute("link", this.cms2FlinkService.getById(id));
/* 212 */     model.addAttribute("q", queryStr);
/* 213 */     model.addAttribute("isEnableList", EnumIsEnable.toListCanBeSee());
/* 214 */     model.addAttribute("ctgList", this.cms2FlinkCtgService.getAllLinkCtg());
/* 215 */     model.addAttribute("resSys", this.resSys);
/* 216 */     return "link/edit";
/*     */   }
/*     */ 
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.LINK_EDIT})
/*     */   @RequestMapping(value={"/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String edit(@RequestParam(value="q", required=false, defaultValue="") String queryStr, @RequestParam(value="id", required=true) Long id, @ModelAttribute("link") Cms2Flink link, SettlerAgent cmsAgent, Model model, HttpServletRequest request)
/*     */   {
/* 235 */     Cms2FlinkCtg space = this.cms2FlinkCtgService.getById(link.getCtgId());
/* 236 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/* 237 */     if (siteId == null) {
/* 238 */       model.addAttribute("url", "/link/list.htm");
/* 239 */       model.addAttribute("q", queryStr);
/* 240 */       model.addAttribute("message", "系统获取不到当前所在站点，请重新登录");
/* 241 */       model.addAttribute("noiframe", Boolean.valueOf(NOIFRAME));
/* 242 */       return "error";
/*     */     }
/* 244 */     space.setSiteId(siteId);
/*     */ 
/* 246 */     link.setType(space.getType());
/* 247 */     this.cms2FlinkService.update4EditPage(link);
/*     */ 
/* 250 */     Cms2Job cms2Job = new Cms2Job(siteId, EnumStaticType.FRIEND_LINK_STATIC.getType(), null, EnumStaticOper.MODIFY_STATIC.getType(), Long.valueOf(0L), "", null);
/* 251 */     this.cms2JobService.save(cms2Job);
/*     */ 
/* 253 */     model.addAttribute("url", "/link/list.htm");
/* 254 */     model.addAttribute("q", queryStr);
/* 255 */     model.addAttribute("message", "修改成功");
/* 256 */     model.addAttribute("noiframe", Boolean.valueOf(NOIFRAME));
/* 257 */     super.addLog(request, cmsAgent, Cms2Utils.getCurrentSiteId(request), "友链修改", id.toString(), link.getName());
/* 258 */     return "success";
/*     */   }
/*     */ 
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.LINK_SWITCH})
/*     */   @RequestMapping({"/isEnableChange"})
/*     */   public String isEnableChange(@RequestParam(value="q", required=false, defaultValue="") String queryStr, @RequestParam(value="id", required=true) Long id, HttpServletRequest request, Model model)
/*     */   {
/* 272 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/* 273 */     if (siteId == null) {
/* 274 */       model.addAttribute("url", "/link/list.htm");
/* 275 */       model.addAttribute("q", queryStr);
/* 276 */       model.addAttribute("message", "系统获取不到当前所在站点，请重新登录");
/* 277 */       model.addAttribute("noiframe", Boolean.valueOf(NOIFRAME));
/* 278 */       return "error";
/*     */     }
/*     */ 
/* 282 */     Cms2Flink link = this.cms2FlinkService.getById(id);
/* 283 */     if (EnumIsEnable.ENABLE.getCode().equals(link.getIsEnable().toString()))
/* 284 */       link.setIsEnable(new Long(EnumIsEnable.UNENABLE.getCode()));
/*     */     else {
/* 286 */       link.setIsEnable(new Long(EnumIsEnable.ENABLE.getCode()));
/*     */     }
/* 288 */     this.cms2FlinkService.update(link);
/*     */ 
/* 291 */     Cms2Job cms2Job = new Cms2Job(siteId, EnumStaticType.FRIEND_LINK_STATIC.getType(), null, EnumStaticOper.MODIFY_STATIC.getType(), Long.valueOf(0L), "", null);
/* 292 */     this.cms2JobService.save(cms2Job);
/*     */ 
/* 294 */     return "redirect:list.htm?q=" + queryStr;
/*     */   }
/*     */ 
/*     */   public void responseSetting(HttpServletResponse response, String contentType)
/*     */   {
/* 303 */     response.setContentType(contentType);
/* 304 */     response.setHeader("Pragma", "No-cache");
/* 305 */     response.setHeader("Cache-Control", "no-cache");
/* 306 */     response.setDateHeader("Expires", 0L);
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy\cmsAdmin\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.admin.action.LinkAction
 * JD-Core Version:    0.6.0
 */