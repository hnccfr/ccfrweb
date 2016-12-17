/*     */ package com.hundsun.network.gates.genshan.web.action.project;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectBaseSetting;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.query.ProjectBaseSettingQuery;
/*     */ import com.hundsun.network.gates.genshan.biz.service.project.ProjectBaseSettingService;
/*     */ import com.hundsun.network.gates.genshan.common.UserAgent;
/*     */ import com.hundsun.network.gates.genshan.security.AdminAccess;
/*     */ import com.hundsun.network.gates.genshan.web.action.BaseAction;
/*     */ import com.hundsun.network.gates.genshan.web.validator.ProjectBaseSettingValidator;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumCheckCommonNodes;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumProcessAuditNodes;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradingType;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.request.SystemMemberLevelRequset;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.result.SystemMemberLevelServiceResult;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.service.RemoteSystemBaseService;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import com.hundsun.network.melody.common.web.cookyjar.Cookyjar;
/*     */ import java.util.List;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.validation.BindingResult;
/*     */ import org.springframework.web.bind.annotation.ModelAttribute;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.servlet.ModelAndView;
/*     */ 
/*     */ @Controller
/*     */ public class ProjectBaseSettingAction extends BaseAction
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   private ProjectBaseSettingService projectBaseSettingService;
/*     */ 
/*     */   @Autowired
/*     */   private RemoteSystemBaseService remoteSystemBaseService;
/*     */ 
/*     */   @Autowired
/*     */   private ProjectBaseSettingValidator ProjectBaseSettingValidator;
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_BSET_LIST})
/*     */   @RequestMapping({"/project/setting/list"})
/*     */   public void list(@ModelAttribute("query") ProjectBaseSettingQuery query, ModelMap model)
/*     */     throws Exception
/*     */   {
/*  60 */     SystemMemberLevelServiceResult result = this.remoteSystemBaseService.selectAllMemberLevel(new SystemMemberLevelRequset());
/*     */ 
/*  62 */     List levelDtoList = result.getSystemMemberLevelList();
/*  63 */     model.put("transTypeList", getTradingTypes());
/*     */ 
/*  65 */     model.put("memLevelList", levelDtoList);
/*  66 */     model.put("auditProcess", EnumProcessAuditNodes.values());
/*  67 */     this.projectBaseSettingService.selectPageList(query);
/*     */   }
/*     */ 
/*     */   private EnumTradingType[] getTradingTypes()
/*     */   {
/*  72 */     EnumTradingType[] tradingTypes = { EnumTradingType.BID_ORDER, EnumTradingType.TRANSFER_ORDER, EnumTradingType.TENDER_ORDER, EnumTradingType.PLACE_ORDER };
/*     */ 
/*  78 */     return tradingTypes;
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_BSET_ADD})
/*     */   @RequestMapping(value={"/project/setting/add"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String add(@ModelAttribute("projectBaseSetting") ProjectBaseSetting projectBaseSetting, Model model)
/*     */     throws Exception
/*     */   {
/*  89 */     SystemMemberLevelServiceResult result = this.remoteSystemBaseService.selectAllMemberLevel(new SystemMemberLevelRequset());
/*     */ 
/*  91 */     List levelDtoList = result.getSystemMemberLevelList();
/*  92 */     model.addAttribute("memLevelList", levelDtoList);
/*  93 */     model.addAttribute("transTypeList", getTradingTypes());
/*     */ 
/*  95 */     model.addAttribute("auditProcess", EnumProcessAuditNodes.values());
/*  96 */     return "/project/setting/add";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_BSET_ADD})
/*     */   @RequestMapping(value={"/project/setting/add"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public ModelAndView add2(UserAgent userAgent, @ModelAttribute("projectBaseSetting") ProjectBaseSetting projectBaseSetting, BindingResult result, Cookyjar cookyjar, ModelMap model)
/*     */     throws Exception
/*     */   {
/* 111 */     this.ProjectBaseSettingValidator.validate(projectBaseSetting, result);
/* 112 */     if (result.hasErrors()) {
/* 113 */       model.addAttribute("hasError", Boolean.valueOf(true));
/* 114 */       SystemMemberLevelServiceResult smlResult = this.remoteSystemBaseService.selectAllMemberLevel(new SystemMemberLevelRequset());
/* 115 */       List levelDtoList = smlResult.getSystemMemberLevelList();
/* 116 */       model.addAttribute("memLevelList", levelDtoList);
/* 117 */       model.addAttribute("transTypeList", getTradingTypes());
/*     */ 
/* 119 */       model.addAttribute("auditProcess", EnumProcessAuditNodes.values());
/* 120 */       return null;
/*     */     }
/*     */ 
/* 123 */     projectBaseSetting.setOperator(userAgent.getUserAccount());
/*     */ 
/* 126 */     String lcp = projectBaseSetting.getListingCheckProcess();
/* 127 */     String icp = projectBaseSetting.getIntentionCheckProcess();
/* 128 */     if (StringUtil.isNotEmpty(lcp)) {
/* 129 */       if (lcp.indexOf(",") > 0) {
/* 130 */         lcp = lcp.replaceAll(",", "");
/*     */       }
/* 132 */       lcp = lcp + EnumCheckCommonNodes.END_NODE.getValue();
/* 133 */       projectBaseSetting.setListingCheckProcess(lcp);
/*     */     }
/* 135 */     if (StringUtil.isNotEmpty(icp)) {
/* 136 */       if (icp.indexOf(",") > 0) {
/* 137 */         icp = icp.replaceAll(",", "");
/*     */       }
/* 139 */       icp = icp + EnumCheckCommonNodes.END_NODE.getValue();
/* 140 */       projectBaseSetting.setIntentionCheckProcess(icp);
/*     */     }
/*     */ 
/* 143 */     this.projectBaseSettingService.insert(projectBaseSetting);
/* 144 */     model.addAttribute("url", "/project/setting/list");
/* 145 */     return new ModelAndView("forward:/success.htm", model);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_BSET_UPDATE})
/*     */   @RequestMapping(value={"/project/setting/update"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String update(@RequestParam("id") Long id, @ModelAttribute("projectBaseSetting") ProjectBaseSetting projectBaseSetting, Model model)
/*     */     throws Exception
/*     */   {
/* 159 */     projectBaseSetting = this.projectBaseSettingService.selectByPrimaryKey(id);
/* 160 */     SystemMemberLevelServiceResult result = this.remoteSystemBaseService.selectAllMemberLevel(new SystemMemberLevelRequset());
/*     */ 
/* 162 */     List levelDtoList = result.getSystemMemberLevelList();
/* 163 */     model.addAttribute("memLevelList", levelDtoList);
/*     */ 
/* 165 */     model.addAttribute("projectBaseSetting", projectBaseSetting);
/* 166 */     model.addAttribute("transTypeList", getTradingTypes());
/*     */ 
/* 168 */     model.addAttribute("auditProcess", EnumProcessAuditNodes.values());
/* 169 */     return "/project/setting/update";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_BSET_UPDATE})
/*     */   @RequestMapping(value={"/project/setting/update"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public ModelAndView update2(UserAgent userAgent, @ModelAttribute("projectBaseSetting") ProjectBaseSetting projectBaseSetting, BindingResult result, Cookyjar cookyjar, ModelMap model)
/*     */     throws Exception
/*     */   {
/* 183 */     this.ProjectBaseSettingValidator.validate(projectBaseSetting, result);
/* 184 */     if (result.hasErrors()) {
/* 185 */       model.addAttribute("hasError", Boolean.valueOf(true));
/* 186 */       SystemMemberLevelServiceResult smlResult = this.remoteSystemBaseService.selectAllMemberLevel(new SystemMemberLevelRequset());
/* 187 */       List levelDtoList = smlResult.getSystemMemberLevelList();
/* 188 */       model.addAttribute("memLevelList", levelDtoList);
/* 189 */       model.addAttribute("transTypeList", getTradingTypes());
/*     */ 
/* 191 */       model.addAttribute("auditProcess", EnumProcessAuditNodes.values());
/* 192 */       return null;
/*     */     }
/*     */ 
/* 195 */     projectBaseSetting.setOperator(userAgent.getUserAccount());
/*     */ 
/* 197 */     String lcp = projectBaseSetting.getListingCheckProcess();
/* 198 */     String icp = projectBaseSetting.getIntentionCheckProcess();
/* 199 */     if (StringUtil.isNotEmpty(lcp)) {
/* 200 */       if (lcp.indexOf(",") > 0) {
/* 201 */         lcp = lcp.replaceAll(",", "");
/*     */       }
/* 203 */       lcp = lcp + EnumCheckCommonNodes.END_NODE.getValue();
/* 204 */       projectBaseSetting.setListingCheckProcess(lcp);
/*     */     }
/* 206 */     if (StringUtil.isNotEmpty(icp)) {
/* 207 */       if (icp.indexOf(",") > 0) {
/* 208 */         icp = icp.replaceAll(",", "");
/*     */       }
/* 210 */       icp = icp + EnumCheckCommonNodes.END_NODE.getValue();
/* 211 */       projectBaseSetting.setIntentionCheckProcess(icp);
/*     */     }
/*     */ 
/* 214 */     this.projectBaseSettingService.updateByPrimaryKey(projectBaseSetting);
/* 215 */     model.addAttribute("url", "/project/setting/list");
/* 216 */     return new ModelAndView("forward:/success.htm", model);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_BSET_VIEW})
/*     */   @RequestMapping({"/project/setting/view"})
/*     */   public void view(@RequestParam("id") Long id, Model model)
/*     */     throws Exception
/*     */   {
/* 227 */     ProjectBaseSetting smls = this.projectBaseSettingService.selectByPrimaryKey(id);
/* 228 */     model.addAttribute("projectBaseSetting", smls);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_BSET_UPDATE})
/*     */   @RequestMapping({"/project/setting/enable"})
/*     */   public ModelAndView enable(@RequestParam("id") Long id, @RequestParam("enable") String enable, Model model)
/*     */     throws Exception
/*     */   {
/* 240 */     this.projectBaseSettingService.setenableStatus(id, enable);
/* 241 */     return new ModelAndView("redirect:/project/setting/list.htm?pageNo=1", model.asMap());
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.action.project.ProjectBaseSettingAction
 * JD-Core Version:    0.6.0
 */