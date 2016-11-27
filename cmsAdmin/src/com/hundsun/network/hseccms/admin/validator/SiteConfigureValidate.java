/*    */ package com.hundsun.network.hseccms.admin.validator;
/*    */ 
/*    */ import com.hundsun.network.hseccms.model.Cms2Site;
/*    */ import com.hundsun.network.melody.common.util.StringUtil;
/*    */ import org.springframework.stereotype.Service;
/*    */ import org.springframework.ui.Model;
/*    */ 
/*    */ @Service("siteConfigureValidate")
/*    */ public class SiteConfigureValidate
/*    */ {
/*    */   public boolean frontValidate(Cms2Site site, Model model)
/*    */   {
/* 17 */     boolean is_success = true;
/* 18 */     is_success = nullValidate(site, model);
/* 19 */     if (!is_success) {
/* 20 */       return is_success;
/*    */     }
/*    */ 
/* 23 */     return is_success;
/*    */   }
/*    */ 
/*    */   public boolean innerValidate(Cms2Site site, Model model)
/*    */   {
/* 31 */     boolean is_success = true;
/* 32 */     return is_success;
/*    */   }
/*    */ 
/*    */   private boolean nullValidate(Cms2Site site, Model model)
/*    */   {
/* 40 */     boolean is_success = true;
/* 41 */     if (StringUtil.isBlank(site.getSiteName())) {
/* 42 */       model.addAttribute("siteNameError", "站点名称不能为空!");
/* 43 */       is_success = false;
/*    */     }
/* 45 */     if (StringUtil.isBlank(site.getShortName())) {
/* 46 */       model.addAttribute("shortNameError", "站点简称不能为空!");
/* 47 */       is_success = false;
/*    */     }
/* 49 */     if (StringUtil.isBlank(site.getDomain())) {
/* 50 */       model.addAttribute("domainError", "域名不能为空!");
/* 51 */       is_success = false;
/*    */     }
/* 53 */     if ((site.getPageSize() == null) || (site.getPageSize().compareTo(Long.valueOf(0L)) <= 0)) {
/* 54 */       model.addAttribute("pageSizeError", "每页记录数不能为空!");
/* 55 */       is_success = false;
/*    */     }
/* 57 */     return is_success;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy\cmsAdmin\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.admin.validator.SiteConfigureValidate
 * JD-Core Version:    0.6.0
 */