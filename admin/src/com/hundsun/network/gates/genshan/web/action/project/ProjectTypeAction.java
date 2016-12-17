/*     */ package com.hundsun.network.gates.genshan.web.action.project;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectType;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectTypeAttri;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectTypeJson;
/*     */ import com.hundsun.network.gates.genshan.biz.service.project.ProjectTypeService;
/*     */ import com.hundsun.network.gates.genshan.common.UserAgent;
/*     */ import com.hundsun.network.gates.genshan.security.AdminAccess;
/*     */ import com.hundsun.network.gates.genshan.web.action.BaseAction;
/*     */ import com.hundsun.network.gates.genshan.web.validator.ProTypeAttriValidator;
/*     */ import com.hundsun.network.gates.genshan.web.validator.ProTypeValidator;
/*     */ import com.hundsun.network.gates.luosi.biz.domain.PackageTradeData;
/*     */ import com.hundsun.network.gates.luosi.biz.domain.TradeShowDTO;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumListingType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumProTypeAttriInputType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradingType;
/*     */ import com.hundsun.network.gates.luosi.wulin.reomte.dto.ProjectListingDTO;
/*     */ import com.hundsun.network.melody.common.web.cookyjar.Cookyjar;
/*     */ import java.util.ArrayList;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.validation.BindingResult;
/*     */ import org.springframework.web.bind.annotation.ModelAttribute;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ import org.springframework.web.servlet.ModelAndView;
/*     */ 
/*     */ @Controller
/*     */ public class ProjectTypeAction extends BaseAction
/*     */ {
/*  49 */   protected final Log logger = LogFactory.getLog(getClass());
/*     */ 
/*     */   @Autowired
/*     */   private ProjectTypeService projectTypeService;
/*     */ 
/*     */   @Autowired
/*     */   private ProTypeAttriValidator proTypeAttriValidator;
/*     */ 
/*     */   @Autowired
/*     */   private ProTypeValidator proTypeValidator;
/*     */ 
/*  70 */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_TYPELIST})
/*     */   @RequestMapping({"/baseset/projecttype/list"})
/*     */   public String activityList() throws Exception { return "/baseset/projecttype/listframe"; } 
/*     */   @RequestMapping({"/ajax/getProjectTypeTree"})
/*     */   @ResponseBody
/*     */   public List<ProjectTypeJson> getProjectTypeTree() {
/*  76 */     return this.projectTypeService.queryProjectTypeTree("0");
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_TYPEADD})
/*     */   @RequestMapping(value={"/baseset/projecttype/addtype"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String addTypePage(@ModelAttribute("projectType") ProjectType projectType, @RequestParam("tCode") String parCode, Model model)
/*     */   {
/*  91 */     if (parCode.equals("0")) {
/*  92 */       model.addAttribute("parCodeName", "顶级类型无父类型");
/*  93 */       return "/baseset/projecttype/addtype";
/*     */     }
/*     */ 
/*  96 */     projectType.setParCode(parCode);
/*  97 */     ProjectType parObj = this.projectTypeService.getProjectTypeByCode(parCode);
/*  98 */     model.addAttribute("parCodeName", parObj.getName());
/*     */ 
/* 100 */     if (parObj.getEnable().shortValue() == 0) {
/* 101 */       return "/baseset/projecttype/addtype";
/*     */     }
/* 103 */     return "/baseset/projecttype/closed";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_TYPEADD})
/*     */   @RequestMapping(value={"/baseset/projecttype/addtype"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String addTypeAciton(UserAgent userAgent, @ModelAttribute("projectType") ProjectType projectType, BindingResult result, Cookyjar cookyjar, ModelMap model)
/*     */   {
/* 121 */     this.proTypeValidator.validate(projectType, result);
/* 122 */     if (result.hasErrors()) {
/* 123 */       ProjectType parObj = this.projectTypeService.getProjectTypeByCode(projectType.getParCode());
/* 124 */       model.addAttribute("parCodeName", parObj == null ? "" : parObj.getName());
/* 125 */       return null;
/*     */     }
/*     */ 
/* 128 */     String code = this.projectTypeService.getCodeWhenInsert(projectType.getParCode());
/* 129 */     projectType.setCode(code);
/* 130 */     projectType.setOperator(userAgent.getUserAccount());
/* 131 */     this.projectTypeService.insertProjectType(projectType);
/*     */ 
/* 133 */     return "/baseset/projecttype/addTypeOk";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_TYPEEDIT})
/*     */   @RequestMapping(value={"/baseset/projecttype/edittype"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String editTypePage(@ModelAttribute("projectType") ProjectType projectType, @RequestParam("tCode") String code, Model model)
/*     */   {
/* 147 */     ProjectType proType = this.projectTypeService.getProjectTypeByCode(code);
/* 148 */     model.addAttribute("projectType", proType);
/*     */ 
/* 150 */     if (proType.getEnable().shortValue() == 0) {
/* 151 */       return "/baseset/projecttype/edittype";
/*     */     }
/* 153 */     return "/baseset/projecttype/closed";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_TYPEEDIT})
/*     */   @RequestMapping(value={"/baseset/projecttype/edittype"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String editTypeAciton(UserAgent userAgent, @ModelAttribute("projectType") ProjectType projectType, BindingResult result, Cookyjar cookyjar, ModelMap model)
/*     */   {
/* 170 */     this.proTypeValidator.validate(projectType, result);
/* 171 */     if (result.hasErrors()) {
/* 172 */       ProjectType parObj = this.projectTypeService.getProjectTypeByCode(projectType.getParCode());
/* 173 */       model.addAttribute("parCodeName", parObj.getName());
/* 174 */       return null;
/*     */     }
/*     */ 
/* 177 */     projectType.setOperator(userAgent.getUserAccount());
/* 178 */     this.projectTypeService.updateByPrimaryKeySelective(projectType);
/*     */ 
/* 180 */     return "/baseset/projecttype/addTypeOk";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_TYPEOPEN})
/*     */   @RequestMapping(value={"/baseset/projecttype/enabletype"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @ResponseBody
/*     */   public String getParrentEnable(@RequestParam("tCode") String code, ModelMap model)
/*     */   {
/* 193 */     ProjectType obj = this.projectTypeService.getProjectTypeByCode(code);
/* 194 */     String parCode = obj.getParCode();
/* 195 */     if (parCode.equals("0")) {
/* 196 */       return "Y";
/*     */     }
/* 198 */     ProjectType parObj = this.projectTypeService.getProjectTypeByCode(parCode);
/* 199 */     if ((parObj != null) && (parObj.getEnable().shortValue() == 0)) {
/* 200 */       return "Y";
/*     */     }
/* 202 */     return "N";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_TYPEOPEN})
/*     */   @RequestMapping(value={"/baseset/projecttype/enabletype"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public ModelAndView enableType(@RequestParam("tCode") String code, ModelMap model)
/*     */   {
/* 215 */     this.projectTypeService.updateEnableStatus(code, 0);
/* 216 */     return new ModelAndView("redirect:/baseset/projecttype/attriList.htm?tCode=" + code, model);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_TYPECLOSE})
/*     */   @RequestMapping(value={"/baseset/projecttype/closetype"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String closeType(@RequestParam("tCode") String code)
/*     */   {
/* 230 */     this.projectTypeService.updateEnableStatus(code, 1);
/* 231 */     return "/baseset/projecttype/closed";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_ATTRILIST})
/*     */   @RequestMapping({"/baseset/projecttype/attriList"})
/*     */   public String getProAttriList(@RequestParam("tCode") String proTypeCode, Model model)
/*     */   {
/* 246 */     if (proTypeCode.equals("0")) {
/* 247 */       return "/baseset/projecttype/attriList";
/*     */     }
/* 249 */     ProjectType projectType = this.projectTypeService.getProjectTypeByCode(proTypeCode);
/*     */ 
/* 252 */     if (projectType.getEnable().shortValue() == 1) {
/* 253 */       return "/baseset/projecttype/closed";
/*     */     }
/*     */ 
/* 256 */     ProjectTypeAttri queryObj = new ProjectTypeAttri();
/* 257 */     queryObj.setProTypeCode(proTypeCode);
/* 258 */     List list = new ArrayList();
/* 259 */     list = this.projectTypeService.getProjectAttriListByQuery(proTypeCode);
/* 260 */     model.addAttribute("list", list);
/* 261 */     model.addAttribute("projectType", projectType);
/*     */ 
/* 263 */     return "/baseset/projecttype/attriList";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_ATTRIADD})
/*     */   @RequestMapping(value={"/baseset/projecttype/addAttri"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void addTypeAttriPage(@ModelAttribute("projectTypeAttri") ProjectTypeAttri projectTypeAttri, @RequestParam("tCode") String proTypeCode, Model model)
/*     */   {
/* 279 */     projectTypeAttri.setProTypeCode(proTypeCode);
/* 280 */     model.addAttribute("inputTypeList", EnumProTypeAttriInputType.values());
/* 281 */     ProjectType parObj = this.projectTypeService.getProjectTypeByCode(proTypeCode);
/* 282 */     model.addAttribute("proTypeName", parObj.getName());
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_ATTRIADD})
/*     */   @RequestMapping(value={"/baseset/projecttype/addAttri"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public ModelAndView addTypeAttriAciton(UserAgent userAgent, @ModelAttribute("projectTypeAttri") ProjectTypeAttri projectTypeAttri, BindingResult result, Cookyjar cookyjar, Model model)
/*     */   {
/* 299 */     this.proTypeAttriValidator.validate(projectTypeAttri, result);
/*     */ 
/* 301 */     if (result.hasErrors()) {
/* 302 */       ProjectType parObj = this.projectTypeService.getProjectTypeByCode(projectTypeAttri
/* 303 */         .getProTypeCode());
/* 304 */       model.addAttribute("proTypeName", parObj.getName());
/* 305 */       model.addAttribute("inputTypeList", EnumProTypeAttriInputType.values());
/* 306 */       return null;
/*     */     }
/*     */ 
/* 309 */     projectTypeAttri.setOperator(userAgent.getUserAccount());
/* 310 */     this.projectTypeService.insertProjectTypeAttri(projectTypeAttri);
/*     */ 
/* 312 */     model.addAttribute("url", "/baseset/projecttype/attriList");
/* 313 */     model.addAttribute("urlParas", "tCode=" + projectTypeAttri.getProTypeCode());
/* 314 */     return new ModelAndView("forward:/success.htm", model.asMap());
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_ATTRIEDIT})
/*     */   @RequestMapping(value={"/baseset/projecttype/editAttri"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void editTypeAttriPage(@ModelAttribute("projectTypeAttri") ProjectTypeAttri projectTypeAttri, @RequestParam("attriId") Long attriId, Model model)
/*     */   {
/* 332 */     ProjectTypeAttri objAttri = this.projectTypeService.getProjectTypeAttriById(attriId);
/* 333 */     model.addAttribute("inputTypeList", EnumProTypeAttriInputType.values());
/* 334 */     model.addAttribute("projectTypeAttri", objAttri);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_ATTRIEDIT})
/*     */   @RequestMapping(value={"/baseset/projecttype/editAttri"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public ModelAndView editTypeAttriAciton(UserAgent userAgent, @ModelAttribute("projectTypeAttri") ProjectTypeAttri projectTypeAttri, BindingResult result, Cookyjar cookyjar, Model model)
/*     */   {
/* 352 */     this.proTypeAttriValidator.validate(projectTypeAttri, result);
/* 353 */     if (result.hasErrors()) {
/* 354 */       ProjectType parObj = this.projectTypeService.getProjectTypeByCode(projectTypeAttri
/* 355 */         .getProTypeCode());
/* 356 */       model.addAttribute("proTypeName", parObj.getName());
/* 357 */       model.addAttribute("inputTypeList", EnumProTypeAttriInputType.values());
/* 358 */       return null;
/*     */     }
/*     */ 
/* 361 */     projectTypeAttri.setOperator(userAgent.getUserAccount());
/* 362 */     this.projectTypeService.updateAttriByPrimaryKey(projectTypeAttri);
/*     */ 
/* 364 */     model.addAttribute("url", "/baseset/projecttype/attriList");
/* 365 */     model.addAttribute("urlParas", "tCode=" + projectTypeAttri.getProTypeCode());
/* 366 */     return new ModelAndView("forward:/success.htm", model.asMap());
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/baseset/projecttype/viewAttri"})
/*     */   public void viewTypeAttri(@RequestParam("attriId") Long attriId, Model model)
/*     */   {
/* 376 */     ProjectTypeAttri objAttri = this.projectTypeService.getProjectTypeAttriById(attriId);
/* 377 */     model.addAttribute("projectTypeAttri", objAttri);
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"/baseset/projecttype/enableAttri"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public ModelAndView enableTypeAttri(@RequestParam("attriId") Long attriId, @RequestParam("enable") Long enable, @RequestParam("tCode") String tCode, Model model)
/*     */   {
/* 392 */     this.projectTypeService.updateAttriEnableStatus(attriId, enable);
/* 393 */     return new ModelAndView("redirect:/baseset/projecttype/attriList.htm?tCode=" + tCode, model
/* 394 */       .asMap());
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/project/attri"})
/*     */   public void getProjectAttri(@RequestParam(value="typeCode", required=false) String typeCode, @RequestParam(value="tradingType", required=false) String tradeType, ModelMap model)
/*     */   {
/* 408 */     List projectTradeAttri = new ArrayList();
/* 409 */     if (EnumTradingType.PLACE_ORDER.getValue().equals(tradeType)) {
/* 410 */       ProjectListingDTO plDto = new ProjectListingDTO();
/* 411 */       plDto.setListingType(EnumListingType.SELL.getValue());
/*     */ 
/* 413 */       projectTradeAttri = PackageTradeData.getPlaceOrderShowDTO(plDto);
/* 414 */     } else if ((EnumTradingType.BID_ORDER.getValue().equals(tradeType)) || (EnumTradingType.MULIT_BID_ORDER.getValue().equals(tradeType))) {
/* 415 */       projectTradeAttri = PackageTradeData.getBidOrderShowDTO();
/* 416 */     } else if (EnumTradingType.TRANSFER_ORDER.getValue().equals(tradeType)) {
/* 417 */       projectTradeAttri = PackageTradeData.getTransferOrderShowDTO();
/* 418 */     } else if (EnumTradingType.TENDER_ORDER.getValue().equals(tradeType)) {
/* 419 */       projectTradeAttri = PackageTradeData.getTenderOrderShowDTO();
/*     */     }
/*     */ 
/* 422 */     List<ProjectTypeAttri> projectTypeAttri = this.projectTypeService.queryProjectTypeAttri(typeCode);
/* 423 */     if ((projectTypeAttri != null) && (projectTypeAttri.size() > 0)) {
/* 424 */       for (ProjectTypeAttri e : projectTypeAttri) {
/* 425 */         TradeShowDTO show = new TradeShowDTO();
/* 426 */         show.setKey(e.getKeyName());
/* 427 */         show.setName(e.getKeyTitle());
/* 428 */         projectTradeAttri.add(show);
/*     */       }
/*     */     }
/*     */ 
/* 432 */     model.addAttribute("projectTypeAttriList", projectTradeAttri);
/*     */   }
/*     */ 
/*     */   @RequestMapping(value={"/project/attri"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @ResponseBody
/*     */   public Map<String, Object> getProjectListByJQ(@RequestParam("typeCode") String typeCode, @RequestParam("tradingType") String tradingType, ModelMap model)
/*     */   {
/* 446 */     getProjectAttri(typeCode, tradingType, model);
/*     */ 
/* 448 */     Map jsonData = new LinkedHashMap();
/* 449 */     jsonData.put("data", model.get("projectTypeAttriList"));
/* 450 */     return jsonData;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.action.project.ProjectTypeAction
 * JD-Core Version:    0.6.0
 */