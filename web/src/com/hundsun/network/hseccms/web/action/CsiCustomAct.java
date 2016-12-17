/*    */ package com.hundsun.network.hseccms.web.action;
/*    */ 
/*    */ import com.hundsun.network.hseccms.enums.EnumTplDirType;
/*    */ import com.hundsun.network.hseccms.model.Cms2Site;
/*    */ import com.hundsun.network.hseccms.model.Cms2Template;
/*    */ import com.hundsun.network.hseccms.security.SettlerAgent;
/*    */ import com.hundsun.network.hseccms.service.Cms2TemplateService;
/*    */ import com.hundsun.network.hseccms.util.Cms2Utils;
/*    */ import com.hundsun.network.hseccms.util.FrontUtils;
/*    */ import com.hundsun.network.hseccms.util.RequestUtils;
/*    */ import com.hundsun.network.hseccms.web.common.WebUtils;
/*    */ import com.hundsun.network.hseccms.web.render.StringTemplateRender;
/*    */ import com.hundsun.network.melody.common.util.StringUtil;
/*    */ import java.io.IOException;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import org.apache.commons.logging.Log;
/*    */ import org.apache.commons.logging.LogFactory;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.ui.ModelMap;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ 
/*    */ @Controller
/*    */ public class CsiCustomAct
/*    */ {
/* 36 */   private static Log _log = LogFactory.getLog(CsiCustomAct.class);
/*    */ 
/*    */   @Autowired
/*    */   private StringTemplateRender templateRender;
/*    */ 
/*    */   @Autowired
/*    */   private Cms2TemplateService cms2TemplateService;
/*    */ 
/*    */   @RequestMapping({"/custom*"})
/*    */   public void custom(HttpServletRequest request, HttpServletResponse response, ModelMap model, SettlerAgent user) {
/* 51 */     Cms2Site site = Cms2Utils.getSite(request);
/*    */ 
/* 53 */     model.putAll(RequestUtils.getQueryParams(request));
/* 54 */     FrontUtils.frontData(request, model, site, user);
/* 55 */     FrontUtils.frontPageData(request, site, Boolean.valueOf(false), model);
/* 56 */     String tpl = RequestUtils.getQueryParam(request, "tplName");
/* 57 */     String tempContent = null;
/* 58 */     if (StringUtil.isNotBlank(tpl)) {
/* 59 */       Cms2Template template = this.cms2TemplateService.getTplByTypeAndName(site.getId() + "", EnumTplDirType.CSI_CUSTOM.getCode(), tpl);
/* 60 */       if (template != null)
/* 61 */         tempContent = template.getCont();
/*    */     }
/*    */     try {
/* 64 */       WebUtils.toHtmlPage(response, this.templateRender.render(model, tempContent));
/*    */     } catch (IOException e) {
/* 66 */       _log.error("", e);
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy13\cmsWeb\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.web.action.CsiCustomAct
 * JD-Core Version:    0.6.0
 */