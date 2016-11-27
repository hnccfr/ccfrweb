/*    */ package com.hundsun.network.hseccms.admin.util;
/*    */ 
/*    */ import com.hundsun.network.hseccms.admin.security.SettlerAgent;
/*    */ import com.hundsun.network.hseccms.model.Cms2Site;
/*    */ import com.hundsun.network.melody.common.util.StringUtil;
/*    */ import com.hundsun.network.melody.common.web.cookyjar.Cookyjar;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ 
/*    */ public class Cms2Utils
/*    */ {
/*    */   public static final String USER_KEY = "settlerAgent";
/*    */   public static final String SITE_KEY = "_site_key";
/*    */ 
/*    */   public static Long getCurrentSiteId(HttpServletRequest request)
/*    */   {
/* 33 */     SettlerAgent settlerAgent = (SettlerAgent)request.getAttribute("settlerAgent");
/* 34 */     if ((settlerAgent == null) || (StringUtil.isBlank(settlerAgent.getCurrentSiteId())))
/* 35 */       return null;
/* 36 */     return Long.valueOf(Long.parseLong(settlerAgent.getCurrentSiteId()));
/*    */   }
/*    */ 
/*    */   public static void setSite(Cookyjar cookyjar, Cms2Site site)
/*    */   {
/* 46 */     SettlerAgent settlerAgent = (SettlerAgent)cookyjar.getObject("settlerAgent");
/* 47 */     settlerAgent.setCurrentSiteId(site.getId().toString());
/* 48 */     cookyjar.set(settlerAgent);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy\cmsAdmin\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.admin.util.Cms2Utils
 * JD-Core Version:    0.6.0
 */