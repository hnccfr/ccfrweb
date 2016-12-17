/*     */ package com.hundsun.network.gates.genshan.web.action.supplydemand;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.domain.query.SupplyDemandInfoAccuseQuery;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.supplydemand.SupplyDemandInfo;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.supplydemand.SupplyDemandInfoAccuse;
/*     */ import com.hundsun.network.gates.genshan.biz.enums.AccuseStatusEnum;
/*     */ import com.hundsun.network.gates.genshan.biz.enums.EnumInfoStatus;
/*     */ import com.hundsun.network.gates.genshan.biz.service.supplydemand.SupplyDemandInfoAccuseService;
/*     */ import com.hundsun.network.gates.genshan.common.UserAgent;
/*     */ import com.hundsun.network.gates.genshan.security.AdminAccess;
/*     */ import com.hundsun.network.gates.genshan.web.action.BaseAction;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.web.bind.annotation.ModelAttribute;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.servlet.ModelAndView;
/*     */ 
/*     */ @Controller
/*     */ public class SupplyDemandInfoAccuseAction extends BaseAction
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private SupplyDemandInfoAccuseService accuseService;
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.ACCUSE_R_LIST})
/*     */   @RequestMapping({"/supplyDemand/accuse/list"})
/*     */   public String list(@ModelAttribute("query") SupplyDemandInfoAccuseQuery query, ModelMap model)
/*     */   {
/*  45 */     if (null != query.getTitle()) {
/*  46 */       query.setTitle(query.getTitle().trim());
/*     */     }
/*  48 */     this.accuseService.selectPageList(query);
/*  49 */     return "/supplyDemand/accuse/list";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.ACCUSE_R_DETAIL})
/*     */   @RequestMapping({"/supplyDemand/accuse/showDetail"})
/*     */   public String showDetail(@RequestParam("aid") Long aid, ModelMap model)
/*     */   {
/*  61 */     SupplyDemandInfoAccuse accuse = this.accuseService.selectAccuseById(aid);
/*  62 */     if (accuse == null) {
/*  63 */       model.addAttribute("message", "该举报信息不存在或已删除!");
/*  64 */       model.addAttribute("url", "/supplyDemand/accuse/list");
/*  65 */       return "forward:/error.htm";
/*     */     }
/*  67 */     model.addAttribute("accuse", accuse);
/*  68 */     return "/supplyDemand/accuse/detail";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.SUP_R_INFO_DETAIL})
/*     */   @RequestMapping({"/supplyDemand/accuse/showInfoDetail"})
/*     */   public String showInfoDetail(@RequestParam("sid") Long sid, ModelMap model)
/*     */   {
/*  80 */     SupplyDemandInfo supplyDemandInfo = this.accuseService.selectInfoById(sid);
/*  81 */     if (null == supplyDemandInfo) {
/*  82 */       model.addAttribute("message", "该供求信息不存在或已删除!");
/*  83 */       model.addAttribute("url", "/supplyDemand/accuse/list");
/*  84 */       return "forward:/error.htm";
/*     */     }
/*  86 */     model.addAttribute("supplyDemandInfo", supplyDemandInfo);
/*  87 */     return "/supplyDemand/accuse/infoDetail";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.ACCUSE_U_AUDIT})
/*     */   @RequestMapping(value={"/supplyDemand/accuse/audit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String toAuditPage(@RequestParam("aid") Long aid, ModelMap model)
/*     */   {
/*  99 */     SupplyDemandInfoAccuse accuse = this.accuseService.selectAccuseById(aid);
/* 100 */     if (accuse == null) {
/* 101 */       return "/supplyDemand/accuse/list";
/*     */     }
/* 103 */     if (!EnumInfoStatus.AUDIT.getValue().equalsIgnoreCase(accuse.getStatus())) {
/* 104 */       return "/supplyDemand/accuse/list";
/*     */     }
/* 106 */     model.addAttribute("accuse", accuse);
/* 107 */     return "/supplyDemand/accuse/audit";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.SUP_U_INFO_AUDIT})
/*     */   @RequestMapping(value={"/supplyDemand/accuse/audit"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public ModelAndView auditAccuseOperator(SupplyDemandInfoAccuse accuse, UserAgent userAgent, ModelMap model)
/*     */   {
/* 122 */     SupplyDemandInfo supplyDemandInfo = this.accuseService.selectInfoById(accuse.getInfoId());
/* 123 */     if (supplyDemandInfo == null) {
/* 124 */       model.addAttribute("message", "该供求信息不存在或已删除");
/* 125 */       model.addAttribute("url", "/supplyDemand/accuse/list");
/* 126 */       return new ModelAndView("forward:/error.htm", model);
/*     */     }
/* 128 */     if (EnumInfoStatus.FORBIDDEN.getValue().equalsIgnoreCase(supplyDemandInfo.getStatus())) {
/* 129 */       model.addAttribute("message", "该信息已禁用");
/* 130 */       model.addAttribute("url", "/supplyDemand/accuse/list");
/* 131 */       return new ModelAndView("forward:/error.htm", model);
/* 132 */     }if (EnumInfoStatus.OVERDUE.getValue().equalsIgnoreCase(supplyDemandInfo.getStatus())) {
/* 133 */       model.addAttribute("message", "该信息已过期");
/* 134 */       model.addAttribute("url", "/supplyDemand/accuse/list");
/* 135 */       return new ModelAndView("forward:/error.htm", model);
/* 136 */     }if (EnumInfoStatus.DELETED.getValue().equalsIgnoreCase(supplyDemandInfo.getStatus())) {
/* 137 */       model.addAttribute("message", "该信息用户已删除");
/* 138 */       model.addAttribute("url", "/supplyDemand/accuse/list");
/* 139 */       return new ModelAndView("forward:/error.htm", model);
/* 140 */     }if (!EnumInfoStatus.NORMAL.getValue().equalsIgnoreCase(supplyDemandInfo.getStatus())) {
/* 141 */       model.addAttribute("message", "该信息已审核或不在审核范围内");
/* 142 */       model.addAttribute("url", "/supplyDemand/accuse/list");
/* 143 */       return new ModelAndView("forward:/error.htm", model);
/*     */     }
/* 145 */     SupplyDemandInfoAccuse accuseTemp = this.accuseService.selectAccuseById(accuse.getId());
/* 146 */     if (accuseTemp == null) {
/* 147 */       model.addAttribute("message", "该举报信息不存在或已删除");
/* 148 */       model.addAttribute("url", "/supplyDemand/accuse/list");
/* 149 */       return new ModelAndView("forward:/error.htm", model);
/*     */     }
/* 151 */     if (!AccuseStatusEnum.AUDIT.getValue().equalsIgnoreCase(accuseTemp.getStatus())) {
/* 152 */       model.addAttribute("message", "该举报信息已经评审");
/* 153 */       model.addAttribute("url", "/supplyDemand/accuse/list");
/* 154 */       return new ModelAndView("forward:/error.htm", model);
/*     */     }
/*     */ 
/* 157 */     Map map = new HashMap();
/* 158 */     map.put("sid", accuse.getInfoId());
/*     */ 
/* 160 */     map.put("operator", userAgent.getUserAccount());
/* 161 */     map.put("status", EnumInfoStatus.FORBIDDEN.getValue());
/*     */ 
/* 164 */     this.accuseService.updateAccuse(accuse);
/* 165 */     if (AccuseStatusEnum.EFFECTIVE.getValue().equals(accuse.getStatus())) {
/* 166 */       accuse.setStatus(AccuseStatusEnum.UNACCEPT.getValue());
/* 167 */       this.accuseService.updateOtherAccuse(accuse);
/* 168 */       this.accuseService.updateInfoStatus(map);
/*     */     }
/* 170 */     model.addAttribute("url", "/supplyDemand/accuse/list");
/* 171 */     return new ModelAndView("forward:/success.htm", model);
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.action.supplydemand.SupplyDemandInfoAccuseAction
 * JD-Core Version:    0.6.0
 */