/*    */ package com.hundsun.network.hseccms.admin.action;
/*    */ 
/*    */ import com.hundsun.network.hseccms.admin.security.SettlerAccess;
/*    */ import com.hundsun.network.hseccms.admin.security.SettlerAgent;
/*    */ import com.hundsun.network.hseccms.admin.util.Cms2Utils;
/*    */ import com.hundsun.network.hseccms.admin.validator.SiteConfigureValidate;
/*    */ import com.hundsun.network.hseccms.enums.EnumAfterCheck;
/*    */ import com.hundsun.network.hseccms.enums.EnumSiteIsIndexToRoot;
/*    */ import com.hundsun.network.hseccms.enums.EnumSiteIsRelativePath;
/*    */ import com.hundsun.network.hseccms.enums.EnumSiteIsStaticIndex;
/*    */ import com.hundsun.network.hseccms.enums.EnumSiteStaticRange;
/*    */ import com.hundsun.network.hseccms.model.Cms2Site;
/*    */ import com.hundsun.network.hseccms.service.Cms2SiteService;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.beans.factory.annotation.Value;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.ui.Model;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ 
/*    */ @Controller
/*    */ @RequestMapping({"/siteConfig"})
/*    */ public class SiteConfigureAction extends BaseAction
/*    */ {
/* 31 */   private static Log _log = LogFactory.getLog(SiteConfigureAction.class);
/*    */ 
/*    */   @Value("${sys.default.finalStep}")
/*    */   private Integer sysDefFinalStep;
/*    */ 
/*    */   @Autowired
/*    */   private Cms2SiteService cms2SiteService;
/*    */ 
/*    */   @Autowired
/*    */   private SiteConfigureValidate siteConfigureValidate;
/*    */ 
/* 44 */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.SITE_MODIFY})
/*    */   @RequestMapping(value={"/modify"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*    */   public String modify(SettlerAgent settlerAgent, HttpServletRequest request, Model model) { _log.debug("========" + settlerAgent.getCurrentSiteId() + "========");
/* 45 */     Long siteId = Cms2Utils.getCurrentSiteId(request);
/* 46 */     Cms2Site cms2Site = this.cms2SiteService.queryById(siteId);
/* 47 */     if (cms2Site == null) {
/* 48 */       model.addAttribute("message", "站点不存在!");
/* 49 */       model.addAttribute("noiframe", Boolean.valueOf(true));
/* 50 */       return "error";
/*    */     }
/* 52 */     model.addAttribute("afterCheckMap", EnumAfterCheck.toMap());
/* 53 */     model.addAttribute("SiteIsStaticIndexMap", EnumSiteIsStaticIndex.toMap());
/* 54 */     model.addAttribute("SiteIsIndexToRootMap", EnumSiteIsIndexToRoot.toMap());
/* 55 */     model.addAttribute("siteStaticRangeMap", EnumSiteStaticRange.toMap());
/* 56 */     model.addAttribute("SiteIsRelativePathMap", EnumSiteIsRelativePath.toMap());
/* 57 */     model.addAttribute("cms2Site", cms2Site);
/* 58 */     model.addAttribute("sysDefFinalStep", this.sysDefFinalStep);
/* 59 */     return "/site/siteConfig"; } 
/*    */   @SettlerAccess({com.hundsun.network.hseccms.admin.security.PermissionEnum.SITE_MODIFY})
/*    */   @RequestMapping(value={"/update"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*    */   public String update(Cms2Site cms2Site, SettlerAgent cmsAgent, HttpServletRequest request, Model model) {
/* 65 */     if (!this.siteConfigureValidate.frontValidate(cms2Site, model)) {
/* 66 */       model.addAttribute("cms2Site", cms2Site);
/* 67 */       model.addAttribute("SiteIsStaticIndexMap", EnumSiteIsStaticIndex.toMap());
/* 68 */       model.addAttribute("SiteIsIndexToRootMap", EnumSiteIsIndexToRoot.toMap());
/* 69 */       model.addAttribute("SiteIsRelativePathMap", EnumSiteIsRelativePath.toMap());
/* 70 */       model.addAttribute("siteStaticRangeMap", EnumSiteStaticRange.toMap());
/* 71 */       model.addAttribute("afterCheckMap", EnumAfterCheck.toMap());
/* 72 */       model.addAttribute("sysDefFinalStep", this.sysDefFinalStep);
/* 73 */       return "/site/siteConfig";
/*    */     }
/*    */ 
/* 76 */     super.addLog(request, cmsAgent, Cms2Utils.getCurrentSiteId(request), "当前站点更新", cms2Site.getId().toString(), cms2Site.getSiteName());
/* 77 */     this.cms2SiteService.update(cms2Site);
/* 78 */     model.addAttribute("message", "修改成功!");
/* 79 */     model.addAttribute("url", "/siteConfig/modify.htm");
/* 80 */     model.addAttribute("noiframe", Boolean.valueOf(true));
/* 81 */     return "success";
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy\cmsAdmin\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.admin.action.SiteConfigureAction
 * JD-Core Version:    0.6.0
 */