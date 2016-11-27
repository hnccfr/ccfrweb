/*     */ package com.hundsun.network.hseccms.admin.action;
/*     */ 
/*     */ import com.hundsun.network.hseccms.admin.security.SettlerAccess;
/*     */ import com.hundsun.network.hseccms.admin.security.SettlerAgent;
/*     */ import com.hundsun.network.hseccms.admin.util.Cms2Utils;
/*     */ import com.hundsun.network.hseccms.enums.EnumDeleteStatus;
/*     */ import com.hundsun.network.hseccms.enums.EnumFlinkType;
/*     */ import com.hundsun.network.hseccms.enums.EnumIsEnable;
/*     */ import com.hundsun.network.hseccms.enums.EnumSortType;
/*     */ import com.hundsun.network.hseccms.enums.EnumStaticOper;
/*     */ import com.hundsun.network.hseccms.enums.EnumStaticType;
/*     */ import com.hundsun.network.hseccms.model.Cms2FlinkCtg;
/*     */ import com.hundsun.network.hseccms.model.Cms2Job;
/*     */ import com.hundsun.network.hseccms.model.Cms2Site;
/*     */ import com.hundsun.network.hseccms.query.Cms2FlinkCtgQuery;
/*     */ import com.hundsun.network.hseccms.query.Cms2FlinkQuery;
/*     */ import com.hundsun.network.hseccms.service.Cms2FlinkCtgService;
/*     */ import com.hundsun.network.hseccms.service.Cms2FlinkService;
/*     */ import com.hundsun.network.hseccms.service.Cms2JobService;
/*     */ import com.hundsun.network.hseccms.service.Cms2SiteService;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.web.bind.annotation.ModelAttribute;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ 
/*     */ @Controller
/*     */ @RequestMapping({"/linkctg"})
/*     */ public class LinkCtgAction extends BaseAction
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private Cms2FlinkCtgService cms2FlinkCtgService;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2FlinkService cms2FlinkService;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2JobService cms2JobService;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2SiteService cms2SiteService;
/*  66 */   private static boolean NOIFRAME = true;
/*     */ 
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.LINK_CTG_MANAGE})
/*     */   @RequestMapping({"/list"})
/*     */   public String list(@RequestParam(value="q", required=false, defaultValue="") String queryStr, @ModelAttribute("query") Cms2FlinkCtgQuery query, Model model)
/*     */   {
/*  78 */     if (StringUtil.isNotEmpty(queryStr)) {
/*  79 */       query = (Cms2FlinkCtgQuery)query.riseUp(queryStr);
/*     */     }
/*  81 */     query.setStatus(EnumDeleteStatus.NORMAL.getCode().toString());
/*  82 */     model.addAttribute("q", query.lieDown());
/*  83 */     model.addAttribute("query", this.cms2FlinkCtgService.query(query));
/*  84 */     model.addAttribute("isEnableMap", EnumIsEnable.toMap());
/*  85 */     model.addAttribute("sortTypeMap", EnumSortType.toMap());
/*  86 */     return "linkctg/list";
/*     */   }
/*     */ 
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.LINK_CTG_ADD})
/*     */   @RequestMapping(value={"/add"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String addInit(@RequestParam(value="q", required=false, defaultValue="") String queryStr, @ModelAttribute("cms2FlinkCtg") Cms2FlinkCtg cms2FlinkCtg, Model model)
/*     */   {
/* 100 */     model.addAttribute("isEnableList", EnumIsEnable.toListCanBeSee());
/* 101 */     model.addAttribute("flinkTypeList", EnumFlinkType.toListCanBeSee());
/* 102 */     model.addAttribute("sortTypeList", EnumSortType.toListCanBeSee());
/*     */ 
/* 104 */     cms2FlinkCtg.setType(new Long(EnumFlinkType.PICTURE.getCode()));
/* 105 */     cms2FlinkCtg.setIsEnable(new Long(EnumIsEnable.ENABLE.getCode()));
/* 106 */     cms2FlinkCtg.setSortType(new Long(EnumSortType.ASC.getCode()));
/* 107 */     model.addAttribute("q", queryStr);
/* 108 */     return "linkctg/add";
/*     */   }
/*     */ 
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.LINK_CTG_ADD})
/*     */   @RequestMapping(value={"/add"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String add(@RequestParam(value="q", required=false, defaultValue="") String queryStr, @ModelAttribute("cms2FlinkCtg") Cms2FlinkCtg cms2FlinkCtg, Model model, SettlerAgent cmsAgent, HttpServletRequest request)
/*     */   {
/* 124 */     model.addAttribute("q", queryStr);
/* 125 */     cms2FlinkCtg.setIsParent(Long.valueOf(1L));
/* 126 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/* 127 */     if (siteId == null) {
/* 128 */       model.addAttribute("url", "/linkctg/list.htm");
/* 129 */       model.addAttribute("message", "系统获取不到当前所在站点，请重新登录");
/* 130 */       model.addAttribute("noiframe", Boolean.valueOf(true));
/* 131 */       return "error";
/*     */     }
/* 133 */     cms2FlinkCtg.setSiteId(siteId);
/* 134 */     cms2FlinkCtg.setStatus(EnumDeleteStatus.NORMAL.getCode());
/* 135 */     Long linkCtgId = this.cms2FlinkCtgService.add(cms2FlinkCtg);
/*     */ 
/* 138 */     Cms2Job cms2Job = new Cms2Job(siteId, EnumStaticType.FRIEND_LINK_STATIC.getType(), null, EnumStaticOper.MODIFY_STATIC.getType(), Long.valueOf(0L), "", null);
/* 139 */     this.cms2JobService.save(cms2Job);
/*     */ 
/* 141 */     model.addAttribute("url", "/linkctg/list.htm");
/* 142 */     model.addAttribute("noiframe", Boolean.valueOf(NOIFRAME));
/* 143 */     super.addLog(request, cmsAgent, Cms2Utils.getCurrentSiteId(request), "友链类别增加", linkCtgId.toString(), cms2FlinkCtg.getName());
/* 144 */     return "success";
/*     */   }
/*     */ 
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.LINK_CTG_DEL})
/*     */   @RequestMapping({"/delete"})
/*     */   public String delete(@RequestParam(value="q", required=false, defaultValue="") String queryStr, @RequestParam(value="id", required=true) Long id, SettlerAgent cmsAgent, HttpServletRequest request, Model model)
/*     */   {
/* 157 */     model.addAttribute("q", queryStr);
/*     */ 
/* 159 */     Cms2FlinkQuery query = new Cms2FlinkQuery();
/*     */ 
/* 161 */     query.setStatus(EnumDeleteStatus.NORMAL.getCode().toString());
/* 162 */     query.setCtgId(id.toString());
/* 163 */     List flinkList = this.cms2FlinkService.getListByQuery(query);
/* 164 */     if ((null != flinkList) && (flinkList.size() > 0)) {
/* 165 */       model.addAttribute("q", queryStr);
/* 166 */       model.addAttribute("url", "/advspace/list.htm");
/* 167 */       model.addAttribute("message", "该版位已被调用，请先删除版位下广告");
/* 168 */       return "error";
/*     */     }
/*     */ 
/* 172 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/* 173 */     if (siteId == null) {
/* 174 */       model.addAttribute("q", queryStr);
/* 175 */       model.addAttribute("url", "/advspace/list.htm");
/* 176 */       model.addAttribute("message", "系统获取不到当前所在站点，请重新登录");
/* 177 */       return "error";
/*     */     }
/* 179 */     Cms2Site site = this.cms2SiteService.queryById(siteId);
/*     */ 
/* 182 */     if (site.getStaticRange().longValue() != 1L) {
/* 183 */       Cms2FlinkCtg flinkCtg = this.cms2FlinkCtgService.getById(id);
/* 184 */       flinkCtg.setStatus(EnumDeleteStatus.DELETING.getCode());
/* 185 */       this.cms2FlinkCtgService.update(flinkCtg);
/*     */     }
/*     */     else {
/* 188 */       this.cms2FlinkCtgService.deleteById(id);
/*     */     }
/*     */ 
/* 191 */     model.addAttribute("url", "/linkctg/list.htm");
/* 192 */     model.addAttribute("message", "删除成功");
/* 193 */     model.addAttribute("noiframe", Boolean.valueOf(NOIFRAME));
/*     */ 
/* 196 */     Cms2Job cms2Job = new Cms2Job(siteId, EnumStaticType.FRIEND_LINK_STATIC.getType(), null, EnumStaticOper.MODIFY_STATIC.getType(), Long.valueOf(0L), "", null);
/* 197 */     this.cms2JobService.save(cms2Job);
/*     */ 
/* 199 */     super.addLog(request, cmsAgent, Cms2Utils.getCurrentSiteId(request), "友链类别删除", id.toString(), "");
/* 200 */     return "success";
/*     */   }
/*     */ 
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.LINK_CTG_EDIT})
/*     */   @RequestMapping(value={"/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String editInit(@RequestParam(value="q", required=false, defaultValue="") String queryStr, @RequestParam(value="id", required=true) Long id, Model model)
/*     */   {
/* 213 */     model.addAttribute("q", queryStr);
/* 214 */     model.addAttribute("cms2FlinkCtg", this.cms2FlinkCtgService.getById(id));
/* 215 */     model.addAttribute("isEnableList", EnumIsEnable.toListCanBeSee());
/* 216 */     model.addAttribute("flinkTypeList", EnumFlinkType.toListCanBeSee());
/* 217 */     model.addAttribute("sortTypeList", EnumSortType.toListCanBeSee());
/* 218 */     return "linkctg/edit";
/*     */   }
/*     */ 
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.LINK_CTG_EDIT})
/*     */   @RequestMapping(value={"/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String edit(@RequestParam(value="q", required=false, defaultValue="") String queryStr, @ModelAttribute("cms2FlinkCtg") Cms2FlinkCtg cms2FlinkCtg, SettlerAgent cmsAgent, Model model, HttpServletRequest request)
/*     */   {
/* 233 */     model.addAttribute("q", queryStr);
/*     */ 
/* 235 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/* 236 */     if (siteId == null) {
/* 237 */       model.addAttribute("url", "/linkctg/list.htm");
/* 238 */       model.addAttribute("message", "系统获取不到当前所在站点，请重新登录");
/* 239 */       model.addAttribute("noiframe", Boolean.valueOf(true));
/* 240 */       return "error";
/*     */     }
/* 242 */     cms2FlinkCtg.setSiteId(siteId);
/* 243 */     this.cms2FlinkCtgService.update4EditPage(cms2FlinkCtg);
/*     */ 
/* 246 */     Cms2Job cms2Job = new Cms2Job(siteId, EnumStaticType.FRIEND_LINK_STATIC.getType(), null, EnumStaticOper.MODIFY_STATIC.getType(), Long.valueOf(0L), "", null);
/* 247 */     this.cms2JobService.save(cms2Job);
/*     */ 
/* 249 */     model.addAttribute("url", "/linkctg/list.htm");
/* 250 */     model.addAttribute("message", "修改成功");
/* 251 */     model.addAttribute("noiframe", Boolean.valueOf(NOIFRAME));
/* 252 */     super.addLog(request, cmsAgent, Cms2Utils.getCurrentSiteId(request), "友链类别修改", cms2FlinkCtg.getId().toString(), cms2FlinkCtg.getName());
/* 253 */     return "success";
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/ajax/checkCtgNameUnique.htm"})
/*     */   public String checkCtgNameUnique(@RequestParam(value="id", required=false) Long id, @RequestParam("ctgName") String ctgName, ModelMap model, HttpServletRequest request)
/*     */   {
/* 268 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/*     */ 
/* 275 */     model.put("content", String.valueOf(this.cms2FlinkCtgService.checkNameUnique(id, ctgName, siteId)));
/*     */ 
/* 277 */     return "common/ajax/content";
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/ajax/checkCtgCodeUnique.htm"})
/*     */   public String checkCtgCodeUnique(@RequestParam(value="id", required=false) Long id, @RequestParam("ctgCode") String ctgCode, ModelMap model, HttpServletRequest request)
/*     */   {
/* 292 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/* 293 */     model.put("content", String.valueOf(this.cms2FlinkCtgService.checkCodeUnique(id, ctgCode, siteId)));
/*     */ 
/* 295 */     return "common/ajax/content";
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy\cmsAdmin\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.admin.action.LinkCtgAction
 * JD-Core Version:    0.6.0
 */