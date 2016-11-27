/*     */ package com.hundsun.network.hseccms.admin.action;
/*     */ 
/*     */ import com.hundsun.network.hseccms.admin.util.Cms2Utils;
/*     */ import com.hundsun.network.hseccms.enums.EnumAdvTarget;
/*     */ import com.hundsun.network.hseccms.enums.EnumDeleteStatus;
/*     */ import com.hundsun.network.hseccms.enums.EnumIsEnable;
/*     */ import com.hundsun.network.hseccms.enums.EnumJobTimingObj;
/*     */ import com.hundsun.network.hseccms.enums.EnumJobTimingType;
/*     */ import com.hundsun.network.hseccms.enums.EnumStaticOper;
/*     */ import com.hundsun.network.hseccms.enums.EnumStaticType;
/*     */ import com.hundsun.network.hseccms.model.Cms2Adv;
/*     */ import com.hundsun.network.hseccms.model.Cms2AdvSpace;
/*     */ import com.hundsun.network.hseccms.model.Cms2Job;
/*     */ import com.hundsun.network.hseccms.model.Cms2JobTiming;
/*     */ import com.hundsun.network.hseccms.model.Cms2Site;
/*     */ import com.hundsun.network.hseccms.query.Cms2AdvQuery;
/*     */ import com.hundsun.network.hseccms.query.Cms2JobTimingQuery;
/*     */ import com.hundsun.network.hseccms.service.Cms2AdvService;
/*     */ import com.hundsun.network.hseccms.service.Cms2AdvSpaceService;
/*     */ import com.hundsun.network.hseccms.service.Cms2JobService;
/*     */ import com.hundsun.network.hseccms.service.Cms2JobTimingService;
/*     */ import com.hundsun.network.hseccms.service.Cms2SiteService;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.beans.factory.annotation.Value;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.web.bind.annotation.ModelAttribute;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ 
/*     */ @Controller
/*     */ @RequestMapping({"/adv"})
/*     */ public class AdvAction extends BaseAction
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private Cms2AdvSpaceService cms2AdvSpaceService;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2AdvService cms2AdvService;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2JobService cms2JobService;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2JobTimingService cms2JobTimingService;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2SiteService cms2SiteService;
/*     */ 
/*     */   @Value("${resSys}")
/*     */   private String resSys;
/*  66 */   private static boolean NOIFRAME = true;
/*     */ 
/*     */   @RequestMapping({"/list"})
/*     */   public String list(@RequestParam(value="q", required=false, defaultValue="") String queryStr, @ModelAttribute("query") Cms2AdvQuery query, Model model)
/*     */   {
/*  78 */     if (StringUtil.isNotEmpty(queryStr)) {
/*  79 */       query = (Cms2AdvQuery)query.riseUp(queryStr);
/*     */     }
/*     */ 
/*  82 */     query.setStatus(EnumDeleteStatus.NORMAL.getCode().toString());
/*  83 */     List spaceList = this.cms2AdvSpaceService.getAllAdvSpace();
/*  84 */     model.addAttribute("spaceList", spaceList);
/*  85 */     model.addAttribute("query", this.cms2AdvService.query(query, spaceList));
/*  86 */     model.addAttribute("isEnableMap", EnumIsEnable.toMap());
/*  87 */     model.addAttribute("q", query.lieDown());
/*  88 */     return "adv/list";
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"/add"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String addInit(@RequestParam(value="q", required=false, defaultValue="") String queryStr, @ModelAttribute("adv") Cms2Adv adv, Model model)
/*     */   {
/* 102 */     model.addAttribute("q", queryStr);
/* 103 */     model.addAttribute("isEnableList", EnumIsEnable.toListCanBeSee());
/* 104 */     model.addAttribute("targetList", EnumAdvTarget.toListCanBeSee());
/* 105 */     model.addAttribute("advSpaceList", this.cms2AdvSpaceService.getAllAdvSpace());
/*     */ 
/* 107 */     adv.setTarget(new Long(EnumAdvTarget.BLANK.getCode()));
/* 108 */     adv.setIsEnable(new Long(EnumIsEnable.ENABLE.getCode()));
/* 109 */     adv.setIsDefault(Long.valueOf(2L));
/* 110 */     model.addAttribute("q", queryStr);
/* 111 */     model.addAttribute("resSys", this.resSys);
/* 112 */     return "adv/add";
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"/add"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String add(@RequestParam(value="q", required=false, defaultValue="") String queryStr, @ModelAttribute("adv") Cms2Adv adv, Model model, HttpServletRequest request)
/*     */   {
/* 129 */     adv.setStatus(new Long(EnumDeleteStatus.NORMAL.getCode().longValue()));
/*     */ 
/* 131 */     Cms2AdvSpace space = this.cms2AdvSpaceService.getById(adv.getSpaceId());
/* 132 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/* 133 */     if (siteId == null) {
/* 134 */       model.addAttribute("url", "/adv/list.htm");
/* 135 */       model.addAttribute("q", queryStr);
/* 136 */       model.addAttribute("message", "系统获取不到当前所在站点，请重新登录");
/* 137 */       return "error";
/*     */     }
/* 139 */     adv.setSiteId(siteId);
/*     */ 
/* 141 */     adv.setType(space.getType());
/*     */ 
/* 143 */     adv.setClickCount(Long.valueOf(0L));
/* 144 */     adv.setDisplayCount(Long.valueOf(0L));
/* 145 */     Long AdvId = this.cms2AdvService.add(adv);
/*     */ 
/* 148 */     Cms2Job cms2Job = new Cms2Job(siteId, EnumStaticType.ADV_STATIC.getType(), null, EnumStaticOper.MODIFY_STATIC.getType(), Long.valueOf(0L), "", null);
/* 149 */     this.cms2JobService.save(cms2Job);
/*     */ 
/* 152 */     Cms2JobTiming cms2JobStartTiming = new Cms2JobTiming(siteId, EnumJobTimingObj.OBJ_TYPE_ADVERSITING.getType(), AdvId, adv.getStartTime(), EnumJobTimingType.OBJ_OPER_START_TIME.getType());
/* 153 */     this.cms2JobTimingService.save(cms2JobStartTiming);
/* 154 */     Cms2JobTiming cms2JobEndTiming = new Cms2JobTiming(siteId, EnumJobTimingObj.OBJ_TYPE_ADVERSITING.getType(), AdvId, adv.getEndTime(), EnumJobTimingType.OBJ_OPER_END_TIME.getType());
/* 155 */     this.cms2JobTimingService.save(cms2JobEndTiming);
/*     */ 
/* 157 */     model.addAttribute("url", "/adv/list.htm");
/* 158 */     model.addAttribute("noiframe", Boolean.valueOf(NOIFRAME));
/* 159 */     model.addAttribute("q", queryStr);
/* 160 */     return "success";
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/delete"})
/*     */   public String delete(@RequestParam(value="q", required=false, defaultValue="") String queryStr, @RequestParam(value="id", required=true) Long id, HttpServletRequest request, Model model)
/*     */   {
/* 174 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/* 175 */     if (siteId == null) {
/* 176 */       model.addAttribute("url", "/adv/list.htm");
/* 177 */       model.addAttribute("q", queryStr);
/* 178 */       model.addAttribute("message", "系统获取不到当前所在站点，请重新登录");
/* 179 */       return "error";
/*     */     }
/* 181 */     Cms2Site site = this.cms2SiteService.queryById(siteId);
/*     */ 
/* 184 */     if (site.getStaticRange().longValue() != 1L) {
/* 185 */       Cms2Adv adv = this.cms2AdvService.getById(id);
/* 186 */       adv.setStatus(EnumDeleteStatus.DELETING.getCode());
/* 187 */       this.cms2AdvService.update(adv);
/*     */     }
/*     */     else {
/* 190 */       this.cms2AdvService.deleteById(id);
/*     */     }
/*     */ 
/* 196 */     Cms2Job cms2Job = new Cms2Job(siteId, EnumStaticType.ADV_STATIC.getType(), null, EnumStaticOper.MODIFY_STATIC.getType(), Long.valueOf(0L), "", null);
/* 197 */     this.cms2JobService.save(cms2Job);
/*     */ 
/* 200 */     Cms2JobTimingQuery cms2JobTimingQuery = new Cms2JobTimingQuery();
/* 201 */     cms2JobTimingQuery.setObjId(id.toString());
/* 202 */     cms2JobTimingQuery.setObjType(EnumJobTimingObj.OBJ_TYPE_ADVERSITING.getType().toString());
/* 203 */     cms2JobTimingQuery.setSiteId(siteId.toString());
/*     */ 
/* 205 */     cms2JobTimingQuery.setObjOper(EnumJobTimingType.OBJ_OPER_START_TIME.getType().toString());
/* 206 */     this.cms2JobTimingService.delete(cms2JobTimingQuery);
/*     */ 
/* 208 */     cms2JobTimingQuery.setObjOper(EnumJobTimingType.OBJ_OPER_END_TIME.getType().toString());
/* 209 */     this.cms2JobTimingService.delete(cms2JobTimingQuery);
/*     */ 
/* 212 */     model.addAttribute("url", "/adv/list.htm");
/* 213 */     model.addAttribute("q", queryStr);
/* 214 */     model.addAttribute("message", "删除成功");
/* 215 */     model.addAttribute("noiframe", Boolean.valueOf(NOIFRAME));
/* 216 */     return "success";
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String editInit(@RequestParam(value="q", required=false, defaultValue="") String queryStr, @RequestParam(value="id", required=true) Long id, Model model)
/*     */   {
/* 230 */     model.addAttribute("adv", this.cms2AdvService.getById(id));
/* 231 */     model.addAttribute("q", queryStr);
/* 232 */     model.addAttribute("isEnableList", EnumIsEnable.toListCanBeSee());
/* 233 */     model.addAttribute("targetList", EnumAdvTarget.toListCanBeSee());
/* 234 */     model.addAttribute("advSpaceList", this.cms2AdvSpaceService.getAllAdvSpace());
/* 235 */     model.addAttribute("resSys", this.resSys);
/* 236 */     return "adv/edit";
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String edit(@RequestParam(value="q", required=false, defaultValue="") String queryStr, @RequestParam(value="id", required=true) Long id, @ModelAttribute("adv") Cms2Adv adv, Model model, HttpServletRequest request)
/*     */   {
/* 255 */     Cms2AdvSpace space = this.cms2AdvSpaceService.getById(adv.getSpaceId());
/* 256 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/* 257 */     if (siteId == null) {
/* 258 */       model.addAttribute("url", "/adv/list.htm");
/* 259 */       model.addAttribute("q", queryStr);
/* 260 */       model.addAttribute("message", "系统获取不到当前所在站点，请重新登录");
/* 261 */       return "error";
/*     */     }
/* 263 */     space.setSiteId(siteId);
/*     */ 
/* 265 */     adv.setType(space.getType());
/* 266 */     this.cms2AdvService.update4EditPage(adv);
/*     */ 
/* 269 */     Cms2Job cms2Job = new Cms2Job(siteId, EnumStaticType.ADV_STATIC.getType(), null, EnumStaticOper.MODIFY_STATIC.getType(), Long.valueOf(0L), "", null);
/* 270 */     this.cms2JobService.save(cms2Job);
/*     */ 
/* 273 */     Cms2JobTiming cms2JobStartTiming = new Cms2JobTiming(siteId, EnumJobTimingObj.OBJ_TYPE_ADVERSITING.getType(), adv.getId(), adv.getStartTime(), EnumJobTimingType.OBJ_OPER_START_TIME.getType());
/* 274 */     this.cms2JobTimingService.save(cms2JobStartTiming);
/* 275 */     Cms2JobTiming cms2JobEndTiming = new Cms2JobTiming(siteId, EnumJobTimingObj.OBJ_TYPE_ADVERSITING.getType(), adv.getId(), adv.getEndTime(), EnumJobTimingType.OBJ_OPER_END_TIME.getType());
/* 276 */     this.cms2JobTimingService.save(cms2JobEndTiming);
/*     */ 
/* 278 */     model.addAttribute("url", "/adv/list.htm");
/* 279 */     model.addAttribute("q", queryStr);
/* 280 */     model.addAttribute("message", "修改成功");
/* 281 */     model.addAttribute("noiframe", Boolean.valueOf(NOIFRAME));
/* 282 */     return "success";
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/isEnableChange"})
/*     */   public String isEnableChange(@RequestParam(value="q", required=false, defaultValue="") String queryStr, @RequestParam(value="id", required=true) Long id, Model model, HttpServletRequest request)
/*     */   {
/* 296 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/* 297 */     if (siteId == null) {
/* 298 */       model.addAttribute("url", "/adv/list.htm");
/* 299 */       model.addAttribute("q", queryStr);
/* 300 */       model.addAttribute("message", "系统获取不到当前所在站点，请重新登录");
/* 301 */       return "error";
/*     */     }
/*     */ 
/* 305 */     Cms2Adv adv = this.cms2AdvService.getById(id);
/* 306 */     if (EnumIsEnable.ENABLE.getCode().equals(adv.getIsEnable().toString()))
/* 307 */       adv.setIsEnable(new Long(EnumIsEnable.UNENABLE.getCode()));
/*     */     else {
/* 309 */       adv.setIsEnable(new Long(EnumIsEnable.ENABLE.getCode()));
/*     */     }
/* 311 */     this.cms2AdvService.update(adv);
/*     */ 
/* 314 */     Cms2Job cms2Job = new Cms2Job(siteId, EnumStaticType.ADV_STATIC.getType(), null, EnumStaticOper.MODIFY_STATIC.getType(), Long.valueOf(0L), "", null);
/* 315 */     this.cms2JobService.save(cms2Job);
/*     */ 
/* 317 */     return "redirect:list.htm?q=" + queryStr;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy\cmsAdmin\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.admin.action.AdvAction
 * JD-Core Version:    0.6.0
 */