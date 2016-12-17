/*     */ package com.hundsun.eclp.web.action.index;
/*     */ 
/*     */ import com.hundsun.eclp.biz.dao.RoleSystemDAO;
/*     */ import com.hundsun.eclp.biz.domain.auth.Authority;
/*     */ import com.hundsun.eclp.biz.domain.sys.SubSystem;
/*     */ import com.hundsun.eclp.biz.domain.sys.SysConfig;
/*     */ import com.hundsun.eclp.biz.domain.user.UserAgent;
/*     */ import com.hundsun.eclp.biz.service.AuthorityService;
/*     */ import com.hundsun.eclp.biz.service.SubSystemService;
/*     */ import com.hundsun.eclp.biz.service.SysConfigService;
/*     */ import com.hundsun.eclp.biz.service.UsersService;
/*     */ import com.hundsun.eclp.biz.service.common.CookieWriter;
/*     */ import com.hundsun.eclp.common.BaseAction;
/*     */ import com.hundsun.eclp.enums.EnumAuthorityType;
/*     */ import com.hundsun.eclp.security.AdminAccess;
/*     */ import com.hundsun.eclp.util.DateUtil;
/*     */ import com.hundsun.network.melody.common.web.cookyjar.Cookyjar;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.lang.StringUtils;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.ui.Model;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ 
/*     */ @Controller
/*     */ public class IndexAction extends BaseAction
/*     */ {
/*     */ 
/*     */   @Autowired
/*     */   SubSystemService subSystemService;
/*     */ 
/*     */   @Autowired
/*     */   AuthorityService authorityService;
/*     */ 
/*     */   @Autowired
/*     */   SysConfigService sysConfigService;
/*     */ 
/*     */   @Autowired
/*     */   CookieWriter cookieWriter;
/*     */ 
/*     */   @Autowired
/*     */   UsersService userService;
/*     */ 
/*     */   @Autowired
/*     */   RoleSystemDAO roleSystemDAO;
/*     */ 
/*     */   @RequestMapping({"/contain/crmheader"})

/*     */   @AdminAccess(value = {  })
/*     */   public String header(UserAgent user, Model model)
/*     */   {
/*  49 */     if (user == null) {
/*  50 */       return "system/login";
/*     */     }
/*     */ 
/*  54 */     List<SubSystem>  sysList = this.subSystemService.getSubSystemByUserId(Long.valueOf(user.getId()));
/*  55 */     if (sysList == null) {
/*  56 */       sysList = new ArrayList();
/*     */     }
/*     */ 
/*  62 */     List _sysList = this.roleSystemDAO.selectSystemByUserId(Long.valueOf(user.getId()));
/*     */ 
/*  65 */     sysList.addAll(_sysList);
/*     */ 
/*  67 */     Map map = new HashMap();
/*  68 */     List subSysList = new ArrayList();
/*     */ 
/*  70 */     for (SubSystem subsys : sysList) {
/*  71 */       if (!map.containsKey(subsys.getId())) {
/*  72 */         map.put(subsys.getId(), null);
/*  73 */         subSysList.add(subsys);
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  79 */     model.addAttribute("sysList", subSysList);
/*     */ 
/*  81 */     initSysConfig(model);
/*  82 */     return "contain/crmheader";
/*     */   }
/*  88 */   @RequestMapping({"/contain/crmmenu"})
/*     */   @AdminAccess(value = {  })
/*     */   public String menu(UserAgent user, Model model, @RequestParam(value="subSysId", required=false) Long subSysId, Cookyjar cookyjar) { if (user == null) {
/*  89 */       return "system/login";
/*     */     }
/*  91 */     String currSysCode = null;
/*  92 */     SubSystem subSys = null;
/*  93 */     if (subSysId != null) {
/*  94 */       subSys = this.subSystemService.selectById(subSysId);
/*  95 */       if (subSys != null) {
/*  96 */         currSysCode = subSys.getName();
/*  97 */         model.addAttribute("subSys", subSys);
/*     */       }
/*     */     }
/* 100 */     if (StringUtils.isBlank(currSysCode)) {
/* 101 */       currSysCode = user.getCurrentSystemCode();
/* 102 */       subSys = this.subSystemService.selectByCode(currSysCode);
/* 103 */       model.addAttribute("subSys", subSys);
/*     */     }
/* 105 */     this._log.debug("user.getCurrentSystemCode()====" + user.getCurrentSystemCode());
/* 106 */     if (currSysCode != null)
/*     */     {
/* 108 */       this.cookieWriter.updateUserAgentPermissionBySubsystem(user, cookyjar, currSysCode);
/*     */     }
/*     */ 
/* 111 */     this._log.debug("currSysCode====" + currSysCode);
/* 112 */     if (StringUtils.isNotBlank(currSysCode)) {
/* 113 */       List<Authority> authList = new ArrayList<Authority>();
/* 114 */       this._log.debug("user.isSuperUser()====" + user.isSuperUser());
/*     */ 
/* 116 */       if (user.isSuperUser())
/*     */       {
/* 118 */         authList = this.authorityService.selectMenuBySubsystem(subSys.getId());
/*     */       }
/*     */       else {
/* 121 */         authList = this.authorityService.selectMenuByUserAndSubsystem(Long.valueOf(user.getId()), currSysCode);
/*     */       }
/*     */ 
/* 124 */       if (authList != null) {
/* 125 */         List menuList = new ArrayList();
/* 126 */         for (Authority auth : authList) {
/* 127 */           if (auth.getType().shortValue() == EnumAuthorityType.MENU_BAR.getCode()) {
/* 128 */             List childList = new ArrayList();
/* 129 */             for (Authority child : authList) {
/* 130 */               if ((child.getType().shortValue() == EnumAuthorityType.MENU.getCode()) && (auth.getId().longValue() == child.getParentId().longValue()))
/*     */               {
/* 132 */                 childList.add(child);
/*     */               }
/*     */             }
/* 135 */             auth.setChildList(childList);
/* 136 */             menuList.add(auth);
/*     */           }
/*     */         }
/* 139 */         model.addAttribute("menuList", menuList);
/*     */       }
/*     */     }
/*     */ 
/* 143 */     initSysConfig(model);
/* 144 */     return "contain/crmmenu";
/*     */   }
/*     */ 
/*     */   private void initSysConfig(Model model)
/*     */   {
/* 149 */     List<SysConfig> list = this.sysConfigService.selectAllSysConfig();
/* 150 */     if ((list != null) && (list.size() > 0))
/* 151 */       for (SysConfig sys : list)
/* 152 */         if ("system_logo".equalsIgnoreCase(sys.getCode()))
/*     */         {
/* 154 */           model.addAttribute("systemLogo", sys.getValue());
/* 155 */         } else if ("system_style".equalsIgnoreCase(sys.getCode()))
/*     */         {
/* 157 */           model.addAttribute("systemStyle", sys.getValue());
/* 158 */         } else if ("system_name".equalsIgnoreCase(sys.getCode()))
/*     */         {
/* 160 */           model.addAttribute("systemName", sys.getValue());
/* 161 */         } else if ("system_title".equalsIgnoreCase(sys.getCode()))
/*     */         {
/* 163 */           model.addAttribute("title", sys.getValue());
/*     */         }
/*     */   }
/*     */ 
/*     */   @RequestMapping({"/contain/crmbody"})
/*     */   @AdminAccess(value = {  })
/*     */   public String body(Model model, UserAgent user)
/*     */   {
/* 173 */     SysConfig con = this.sysConfigService.selectSysConfigByCode("system_name");
/* 174 */     if (con != null) {
/* 175 */       model.addAttribute("systemName", con.getValue());
/*     */     }
/* 177 */     if (StringUtils.isNotBlank(user.getCurrentSystemCode())) {
/* 178 */       model.addAttribute("subSys", this.subSystemService.selectByCode(user.getCurrentSystemCode()));
/*     */     }
/* 180 */     if ((user.getEclpLastLoginTime() != null) && (user.getEclpLastLoginTime().longValue() != -1L)) {
/* 181 */       model.addAttribute("lastLoginTime", DateUtil.convertDateToString("yyyy-MM-dd HH:mm:ss", new Date(user.getEclpLastLoginTime().longValue())));
/*     */     }
/* 183 */     return "contain/crmbody";
/*     */   }
/*     */   @RequestMapping({"/contain/crmfooter"})

			@AdminAccess(value = {  })
/*     */   public String crmfooter(Model model) {
/* 190 */     initSysConfig(model);
/* 191 */     return "contain/crmfooter";
/*     */   }
/* 197 */   @RequestMapping({"/index"})
			@AdminAccess(value = {  })
/*     */   public String index(Model model, UserAgent user) { if (user == null) {
/* 198 */       return "redirect:system/login.htm";
/*     */     }
/*     */ 
/* 201 */     SysConfig con = this.sysConfigService.selectSysConfigByCode("system_title");
/* 202 */     if (con != null)
/* 203 */       model.addAttribute("systemTitle", con.getValue());
/* 204 */     return "system/index";
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.web.action.index.IndexAction
 * JD-Core Version:    0.6.0
 */