/*     */ package com.hundsun.network.gates.genshan.web.action.baseset;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.domain.baseset.SystemMemberlevelSet;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.baseset.UserLevel;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.query.UserLevelQuery;
/*     */ import com.hundsun.network.gates.genshan.biz.service.baseset.SystemMemberlevelSetService;
/*     */ import com.hundsun.network.gates.genshan.biz.service.baseset.UserLevelService;
/*     */ import com.hundsun.network.gates.genshan.common.UserAgent;
/*     */ import com.hundsun.network.gates.genshan.security.AdminAccess;
/*     */ import com.hundsun.network.gates.genshan.web.action.BaseAction;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import com.hundsun.network.melody.common.web.cookyjar.Cookyjar;
/*     */ import java.util.List;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.validation.BindingResult;
/*     */ import org.springframework.validation.Validator;
/*     */ import org.springframework.web.bind.annotation.ModelAttribute;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ import org.springframework.web.servlet.ModelAndView;
/*     */ 
/*     */ @Controller
/*     */ public class UserLevelAction extends BaseAction
/*     */ {
/*  40 */   protected final Log logger = LogFactory.getLog(getClass());
/*     */ 
/*     */   @Autowired
/*     */   private UserLevelService userLevelService;
/*     */ 
/*     */   @Autowired
/*     */   private SystemMemberlevelSetService systemMemberlevelSetService;
/*     */ 
/*     */   @Autowired
/*     */   private Validator userLevelAddValidator;
/*     */ 
/*     */   @Autowired
/*     */   private Validator userLevelEditValidator;
/*     */ 
/*  61 */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_USERLEVEL_LIST})
/*     */   @RequestMapping({"/baseset/userlevel/list"})
/*     */   public void list(@RequestParam(value="userAccount", required=false) String userAccount, @ModelAttribute("query") UserLevelQuery query, ModelMap model) throws Exception { if (StringUtil.isNotEmpty(userAccount)) {
/*  62 */       query.setUserAccount(userAccount.trim());
/*     */     }
/*  64 */     List smLevelsetList = this.systemMemberlevelSetService.selectSystemMemberlevelList();
/*  65 */     model.addAttribute("smLevelsetList", smLevelsetList);
/*  66 */     this.userLevelService.selectPageList(query);
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_USERLEVEL_ADD})
/*     */   @RequestMapping(value={"/baseset/userlevel/add"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String add(@ModelAttribute("userLevel") UserLevel userLevel, Model model)
/*     */     throws Exception
/*     */   {
/*  78 */     List memLevelList = this.systemMemberlevelSetService.selectSystemMemberlevelList();
/*  79 */     model.addAttribute("memLevelList", memLevelList);
/*  80 */     return "/baseset/userlevel/add";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_USERLEVEL_ADD})
/*     */   @RequestMapping(value={"/baseset/userlevel/add"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public ModelAndView add2(@ModelAttribute("userLevel") UserLevel userLevel, BindingResult result, Model model, Cookyjar cookyjar)
/*     */     throws Exception
/*     */   {
/*  93 */     List memLevelList = this.systemMemberlevelSetService.selectSystemMemberlevelList();
/*  94 */     model.addAttribute("memLevelList", memLevelList);
/*     */ 
/*  97 */     this.userLevelAddValidator.validate(userLevel, result);
/*  98 */     if (result.hasErrors()) {
/*  99 */       model.addAttribute("hasError", Boolean.valueOf(true));
/* 100 */       return null;
/*     */     }
/* 102 */     this.userLevelService.insert(userLevel);
/* 103 */     model.addAttribute("url", "/baseset/userlevel/list");
/* 104 */     return new ModelAndView("forward:/success.htm", model.asMap());
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_USERLEVEL_UPDATE})
/*     */   @RequestMapping(value={"/baseset/userlevel/update"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String update(@RequestParam(value="id", required=true) Long id, @ModelAttribute("userLevel") UserLevel userLevel, Model model)
/*     */     throws Exception
/*     */   {
/* 117 */     userLevel = this.userLevelService.selectByPrimaryKey(id);
/* 118 */     List memLevelList = this.systemMemberlevelSetService.selectSystemMemberlevelList();
/* 119 */     model.addAttribute("memLevelList", memLevelList);
/* 120 */     model.addAttribute("userLevel", userLevel);
/* 121 */     return "/baseset/userlevel/update";
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_USERLEVEL_UPDATE})
/*     */   @RequestMapping(value={"/baseset/userlevel/update"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public ModelAndView update2(@ModelAttribute("userLevel") UserLevel userLevel, BindingResult result, Model model)
/*     */     throws Exception
/*     */   {
/* 135 */     List memLevelList = this.systemMemberlevelSetService.selectSystemMemberlevelList();
/* 136 */     model.addAttribute("memLevelList", memLevelList);
/*     */ 
/* 138 */     this.userLevelEditValidator.validate(userLevel, result);
/* 139 */     if (result.hasErrors()) {
/* 140 */       model.addAttribute("hasError", Boolean.valueOf(true));
/* 141 */       return null;
/*     */     }
/* 143 */     this.userLevelService.updateByPrimaryKey(userLevel);
/* 144 */     model.addAttribute("url", "/baseset/userlevel/list");
/* 145 */     return new ModelAndView("forward:/success.htm", model.asMap());
/*     */   }
/*     */ 
/*     */   @AdminAccess({com.hundsun.network.gates.genshan.common.PermissionEnum.S_B_USERLEVEL_VIEW})
/*     */   @RequestMapping({"/baseset/userlevel/view"})
/*     */   public void view(@RequestParam("id") Long id, Model model)
/*     */     throws Exception
/*     */   {
/* 155 */     UserLevel smls = this.userLevelService.selectByPrimaryKey(id);
/* 156 */     model.addAttribute("smls", smls);
/* 157 */     List memLevelList = this.systemMemberlevelSetService.selectSystemMemberlevelList();
/* 158 */     model.addAttribute("memLevelList", memLevelList);
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/baseset/userlevel/ajaxMemlevel"})
/*     */   @ResponseBody
/*     */   public SystemMemberlevelSet ajaxSystemDictEnable(UserAgent userAgent, @RequestParam(value="integral", required=true) String integral, Model model)
/*     */   {
/* 175 */     int integralInt = new Integer(integral).intValue();
/* 176 */     SystemMemberlevelSet calcMemberlevelSet = this.systemMemberlevelSetService.selectByIntegral(integralInt);
/* 177 */     return calcMemberlevelSet;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.action.baseset.UserLevelAction
 * JD-Core Version:    0.6.0
 */