/*    */ package com.hundsun.network.hseccms.admin.action;
/*    */ 
/*    */ import com.hundsun.network.hseccms.admin.security.SettlerAgent;
/*    */ import com.hundsun.network.hseccms.admin.util.Cms2Utils;
/*    */ import com.hundsun.network.hseccms.model.Cms2Site;
/*    */ import com.hundsun.network.hseccms.service.Cms2SiteService;
/*    */ import com.hundsun.network.melody.common.web.cookyjar.Cookyjar;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.ui.Model;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ 
/*    */ @Controller
/*    */ public class WelcomeAction
/*    */ {
/* 25 */   private static Log _log = LogFactory.getLog(WelcomeAction.class);
/*    */ 
/*    */   @Autowired
/*    */   private Cms2SiteService cms2SiteService;
/*    */ 
/* 34 */   @RequestMapping({"/welcome"})
/*    */   public String showWelcome(Cookyjar cookyjar, HttpServletRequest request, Model model) { Runtime runtime = Runtime.getRuntime();
/* 35 */     long freeMemoery = runtime.freeMemory();
/* 36 */     long totalMemory = runtime.totalMemory();
/* 37 */     long usedMemory = totalMemory - freeMemoery;
/* 38 */     long maxMemory = runtime.maxMemory();
/* 39 */     long useableMemory = maxMemory - totalMemory + freeMemoery;
/* 40 */     model.addAttribute("freeMemoery", Long.valueOf(freeMemoery));
/* 41 */     model.addAttribute("totalMemory", Long.valueOf(totalMemory));
/* 42 */     model.addAttribute("usedMemory", Long.valueOf(usedMemory));
/* 43 */     model.addAttribute("maxMemory", Long.valueOf(maxMemory));
/* 44 */     model.addAttribute("useableMemory", Long.valueOf(useableMemory));
/* 45 */     model.addAttribute("version", "2.0.0");
/*    */ 
/* 49 */     Cms2Site cms2Site = this.cms2SiteService.getOnlySite();
/* 50 */     Cms2Utils.setSite(cookyjar, cms2Site);
/* 51 */     SettlerAgent agent = (SettlerAgent)cookyjar.getObject("settlerAgent");
/* 52 */     _log.debug("siteId:" + agent.getCurrentSiteId());
/* 53 */     agent = (SettlerAgent)request.getAttribute("settlerAgent");
/* 54 */     _log.debug("siteId:" + agent.getCurrentSiteId());
/* 55 */     return "/welcome";
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy\cmsAdmin\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.admin.action.WelcomeAction
 * JD-Core Version:    0.6.0
 */