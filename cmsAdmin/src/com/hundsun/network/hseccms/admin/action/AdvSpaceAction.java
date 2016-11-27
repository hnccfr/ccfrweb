/*     */ package com.hundsun.network.hseccms.admin.action;
/*     */ 
/*     */ import com.hundsun.network.hseccms.admin.security.SettlerAccess;
/*     */ import com.hundsun.network.hseccms.admin.util.Cms2Utils;
/*     */ import com.hundsun.network.hseccms.enums.EnumAdvType;
/*     */ import com.hundsun.network.hseccms.enums.EnumDeleteStatus;
/*     */ import com.hundsun.network.hseccms.enums.EnumIsEnable;
/*     */ import com.hundsun.network.hseccms.enums.EnumStaticOper;
/*     */ import com.hundsun.network.hseccms.enums.EnumStaticType;
/*     */ import com.hundsun.network.hseccms.model.Cms2AdvSpace;
/*     */ import com.hundsun.network.hseccms.model.Cms2Job;
/*     */ import com.hundsun.network.hseccms.model.Cms2Site;
/*     */ import com.hundsun.network.hseccms.query.Cms2AdvQuery;
/*     */ import com.hundsun.network.hseccms.query.Cms2AdvSpaceQuery;
/*     */ import com.hundsun.network.hseccms.service.Cms2AdvService;
/*     */ import com.hundsun.network.hseccms.service.Cms2AdvSpaceService;
/*     */ import com.hundsun.network.hseccms.service.Cms2JobService;
/*     */ import com.hundsun.network.hseccms.service.Cms2SiteService;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.web.bind.annotation.ModelAttribute;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ 
/*     */ @Controller
/*     */ @RequestMapping({"/advspace"})
/*     */ public class AdvSpaceAction extends BaseAction
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private Cms2AdvService cms2AdvService;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2AdvSpaceService cms2AdvSpaceService;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2JobService cms2JobService;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2SiteService cms2SiteService;
/*  56 */   private static boolean NOIFRAME = true;
/*     */ 
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.ADV_SPACE_MANAGE})
/*     */   @RequestMapping({"/list"})
/*     */   public String list(@RequestParam(value="q", required=false, defaultValue="") String queryStr, @ModelAttribute("query") Cms2AdvSpaceQuery query, ModelMap model)
/*     */   {
/*  68 */     if (StringUtil.isNotEmpty(queryStr)) {
/*  69 */       query = (Cms2AdvSpaceQuery)query.riseUp(queryStr);
/*     */     }
/*  71 */     query.setStatus(EnumDeleteStatus.NORMAL.getCode().toString());
/*  72 */     model.addAttribute("q", query.lieDown());
/*  73 */     model.addAttribute("query", this.cms2AdvSpaceService.query(query));
/*  74 */     model.addAttribute("advTypeMap", EnumAdvType.toMapCanBeSee());
/*  75 */     model.addAttribute("isEnableMap", EnumIsEnable.toMap());
/*  76 */     return "advspace/list";
/*     */   }
/*     */ 
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.ADV_SPACE_ADD})
/*     */   @RequestMapping(value={"/add"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String addInit(@RequestParam(value="q", required=false, defaultValue="") String queryStr, @ModelAttribute("space") Cms2AdvSpace space, ModelMap model)
/*     */   {
/*  89 */     model.addAttribute("q", queryStr);
/*  90 */     model.addAttribute("advTypeList", EnumAdvType.toListCanBeSee());
/*  91 */     model.addAttribute("isEnableList", EnumIsEnable.toListCanBeSee());
/*     */ 
/*  96 */     space = space.init(space);
/*  97 */     return "advspace/add";
/*     */   }
/*     */ 
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.ADV_SPACE_ADD})
/*     */   @RequestMapping(value={"/add"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String add(@RequestParam(value="q", required=false, defaultValue="") String queryStr, @ModelAttribute("space") Cms2AdvSpace space, ModelMap model, HttpServletRequest request)
/*     */   {
/* 119 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/* 120 */     if (siteId == null) {
/* 121 */       model.addAttribute("q", queryStr);
/* 122 */       model.addAttribute("url", "/advspace/list.htm");
/* 123 */       model.addAttribute("message", "系统获取不到当前所在站点，请重新登录");
/* 124 */       return "error";
/*     */     }
/* 126 */     space.setSiteId(siteId);
/* 127 */     Long AdvSpaceId = this.cms2AdvSpaceService.add(space);
/*     */ 
/* 130 */     Cms2Job cms2Job = new Cms2Job(siteId, EnumStaticType.ADV_STATIC.getType(), null, EnumStaticOper.MODIFY_STATIC.getType(), Long.valueOf(0L), "", null);
/* 131 */     this.cms2JobService.save(cms2Job);
/*     */ 
/* 133 */     model.addAttribute("url", "/advspace/list.htm");
/* 134 */     model.addAttribute("noiframe", Boolean.valueOf(NOIFRAME));
/* 135 */     model.addAttribute("q", queryStr);
/* 136 */     return "success";
/*     */   }
/*     */ 
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.ADV_SPACE_DEL})
/*     */   @RequestMapping({"/delete"})
/*     */   public String delete(@RequestParam(value="q", required=false, defaultValue="") String queryStr, @RequestParam(value="id", required=true) Long id, ModelMap model, HttpServletRequest request)
/*     */   {
/* 149 */     Cms2AdvQuery query = new Cms2AdvQuery();
/*     */ 
/* 151 */     query.setStatus(EnumDeleteStatus.NORMAL.getCode().toString());
/* 152 */     query.setSpaceId(id.toString());
/* 153 */     List advList = this.cms2AdvService.getAllByCondition(query);
/* 154 */     if ((null != advList) && (advList.size() > 0)) {
/* 155 */       model.addAttribute("q", queryStr);
/* 156 */       model.addAttribute("url", "/advspace/list.htm");
/* 157 */       model.addAttribute("message", "该版位已被调用，请先删除版位下广告");
/* 158 */       return "error";
/*     */     }
/*     */ 
/* 162 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/* 163 */     if (siteId == null) {
/* 164 */       model.addAttribute("q", queryStr);
/* 165 */       model.addAttribute("url", "/advspace/list.htm");
/* 166 */       model.addAttribute("message", "系统获取不到当前所在站点，请重新登录");
/* 167 */       return "error";
/*     */     }
/* 169 */     Cms2Site site = this.cms2SiteService.queryById(siteId);
/*     */ 
/* 172 */     if (site.getStaticRange().longValue() != 1L) {
/* 173 */       Cms2AdvSpace advSpace = this.cms2AdvSpaceService.getById(id);
/* 174 */       advSpace.setStatus(EnumDeleteStatus.DELETING.getCode());
/* 175 */       this.cms2AdvSpaceService.update(advSpace);
/*     */     }
/*     */     else {
/* 178 */       this.cms2AdvSpaceService.deleteById(id);
/*     */     }
/*     */ 
/* 182 */     Cms2Job cms2Job = new Cms2Job(siteId, EnumStaticType.ADV_STATIC.getType(), null, EnumStaticOper.MODIFY_STATIC.getType(), Long.valueOf(0L), "", null);
/* 183 */     this.cms2JobService.save(cms2Job);
/*     */ 
/* 185 */     model.addAttribute("url", "/advspace/list.htm");
/* 186 */     model.addAttribute("q", queryStr);
/* 187 */     model.addAttribute("message", "删除成功");
/* 188 */     model.addAttribute("noiframe", Boolean.valueOf(NOIFRAME));
/* 189 */     return "success";
/*     */   }
/*     */ 
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.ADV_SPACE_EDIT})
/*     */   @RequestMapping(value={"/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String editInit(@RequestParam(value="q", required=false, defaultValue="") String queryStr, @RequestParam(value="id", required=true) Long id, ModelMap model)
/*     */   {
/* 201 */     model.addAttribute("space", this.cms2AdvSpaceService.getById(id));
/* 202 */     model.addAttribute("q", queryStr);
/* 203 */     model.addAttribute("advTypeList", EnumAdvType.toListCanBeSee());
/* 204 */     model.addAttribute("isEnableList", EnumIsEnable.toListCanBeSee());
/* 205 */     model.addAttribute("advSpaceList", this.cms2AdvSpaceService.getAllAdvSpace());
/* 206 */     return "advspace/edit";
/*     */   }
/*     */ 
/*     */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.ADV_SPACE_EDIT})
/*     */   @RequestMapping(value={"/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String edit(@RequestParam(value="q", required=false, defaultValue="") String queryStr, @RequestParam(value="id", required=true) Long id, @ModelAttribute("space") Cms2AdvSpace space, ModelMap model, HttpServletRequest request)
/*     */   {
/* 226 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/* 227 */     if (siteId == null) {
/* 228 */       model.addAttribute("url", "/advspace/list.htm");
/* 229 */       model.addAttribute("q", queryStr);
/* 230 */       model.addAttribute("message", "系统获取不到当前所在站点，请重新登录");
/* 231 */       return "error";
/*     */     }
/* 233 */     space.setSiteId(siteId);
/* 234 */     this.cms2AdvSpaceService.update4EditPage(space);
/*     */ 
/* 237 */     Cms2Job cms2Job = new Cms2Job(siteId, EnumStaticType.ADV_STATIC.getType(), null, EnumStaticOper.MODIFY_STATIC.getType(), Long.valueOf(0L), "", null);
/* 238 */     this.cms2JobService.save(cms2Job);
/*     */ 
/* 240 */     model.addAttribute("url", "/advspace/list.htm");
/* 241 */     model.addAttribute("message", "修改成功");
/* 242 */     model.addAttribute("noiframe", Boolean.valueOf(NOIFRAME));
/* 243 */     model.addAttribute("q", queryStr);
/* 244 */     return "success";
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/ajax/checkSpaceNameUnique.htm"})
/*     */   public String checkSpaceNameUnique(@RequestParam(value="id", required=false) Long id, @RequestParam("spaceName") String spaceName, ModelMap model, HttpServletRequest request)
/*     */   {
/* 259 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/*     */ 
/* 265 */     model.put("content", String.valueOf(this.cms2AdvSpaceService.checkNameUnique(id, spaceName, siteId)));
/*     */ 
/* 267 */     return "common/ajax/content";
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/ajax/checkSpaceCodeUnique.htm"})
/*     */   public String checkSpaceCodeUnique(@RequestParam(value="id", required=false) Long id, @RequestParam("spaceCode") String spaceCode, ModelMap model, HttpServletRequest request)
/*     */   {
/* 282 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/* 283 */     model.put("content", String.valueOf(this.cms2AdvSpaceService.checkCodeUnique(id, spaceCode, siteId)));
/*     */ 
/* 285 */     return "common/ajax/content";
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy\cmsAdmin\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.admin.action.AdvSpaceAction
 * JD-Core Version:    0.6.0
 */