/*     */ package com.hundsun.network.gates.genshan.web.action.project;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectStandard;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.query.ProjectStandardQuery;
/*     */ import com.hundsun.network.gates.genshan.biz.service.project.ProjectStandardService;
/*     */ import com.hundsun.network.gates.genshan.common.UserAgent;
/*     */ import com.hundsun.network.gates.genshan.security.AdminAccess;
/*     */ import com.hundsun.network.gates.genshan.web.action.BaseAction;
/*     */ import com.hundsun.network.gates.genshan.web.validator.ProjectStandardValidator;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import com.hundsun.network.melody.common.web.cookyjar.Cookyjar;
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
/*     */ import org.springframework.web.servlet.ModelAndView;
/*     */ 
/*     */ @Controller
/*     */ public class ProjectStandardAction extends BaseAction
/*     */ {
/*  36 */   protected final Log logger = LogFactory.getLog(getClass());
/*     */ 
/*     */   @Autowired
/*     */   private ProjectStandardService standardService;
/*     */ 
/*     */   @Autowired
/*     */   private ProjectStandardValidator standardValidator;
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_STANDARD_LIST})
/*     */   @RequestMapping({"/project/standard/list"})
/*     */   public void list(@ModelAttribute("query") ProjectStandardQuery query, ModelMap model) throws Exception {
/*  53 */     if (!StringUtil.isEmpty(query.getStandardName())) {
/*  54 */       query.setStandardName(query.getStandardName().trim());
/*     */     }
/*  56 */     this.standardService.selectPageList(query);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_STANDARD_ADD})
/*     */   @RequestMapping(value={"/project/standard/add"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String add(@ModelAttribute("standard") ProjectStandard standard, Model model)
/*     */     throws Exception
/*     */   {
/*  68 */     return "/project/standard/add";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_STANDARD_ADD})
/*     */   @RequestMapping(value={"/project/standard/add"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public ModelAndView add2(UserAgent userAgent, @ModelAttribute("standard") ProjectStandard standard, BindingResult result, Cookyjar cookyjar, ModelMap model)
/*     */     throws Exception
/*     */   {
/*  82 */     this.standardValidator.validate(standard, result);
/*  83 */     if (result.hasErrors()) {
/*  84 */       model.addAttribute("hasError", Boolean.valueOf(true));
/*  85 */       return null;
/*     */     }
/*     */ 
/*  88 */     standard.setOperator(userAgent.getUserAccount());
/*  89 */     this.standardService.insert(standard);
/*  90 */     model.addAttribute("url", "/project/standard/list");
/*  91 */     return new ModelAndView("forward:/success.htm", model);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_STANDARD_UPDATE})
/*     */   @RequestMapping(value={"/project/standard/update"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String update(@RequestParam("id") Long id, @ModelAttribute("standard") ProjectStandard standard, Model model)
/*     */     throws Exception
/*     */   {
/* 105 */     standard = this.standardService.selectByPrimaryKey(id);
/* 106 */     model.addAttribute("standard", standard);
/* 107 */     return "/project/standard/update";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_STANDARD_UPDATE})
/*     */   @RequestMapping(value={"/project/standard/update"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public ModelAndView update2(UserAgent userAgent, @ModelAttribute("standard") ProjectStandard standard, BindingResult result, Cookyjar cookyjar, ModelMap model)
/*     */     throws Exception
/*     */   {
/* 121 */     this.standardValidator.validate(standard, result);
/* 122 */     if (result.hasErrors()) {
/* 123 */       model.addAttribute("hasError", Boolean.valueOf(true));
/* 124 */       return null;
/*     */     }
/*     */ 
/* 127 */     standard.setOperator(userAgent.getUserAccount());
/* 128 */     this.standardService.updateByPrimaryKey(standard);
/* 129 */     model.addAttribute("url", "/project/standard/list");
/* 130 */     return new ModelAndView("forward:/success.htm", model);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_STANDARD_VIEW})
/*     */   @RequestMapping({"/project/standard/view"})
/*     */   public void view(@RequestParam("id") Long id, Model model)
/*     */     throws Exception
/*     */   {
/* 141 */     ProjectStandard smls = this.standardService.selectByPrimaryKey(id);
/* 142 */     model.addAttribute("smls", smls);
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/project/standard/enable"})
/*     */   public ModelAndView enable(@RequestParam("id") Long id, @RequestParam("enable") String enable, Model model)
/*     */     throws Exception
/*     */   {
/* 152 */     this.standardService.setenableStatus(id, enable);
/* 153 */     return new ModelAndView("redirect:/project/standard/list.htm?pageNo=1", model.asMap());
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.action.project.ProjectStandardAction
 * JD-Core Version:    0.6.0
 */