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
/*    */ import java.io.IOException;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import org.apache.commons.lang.StringUtils;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.ui.ModelMap;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ 
/*    */ @Controller
/*    */ public class SearchAction
/*    */ {
/* 31 */   private static final Logger logger = LoggerFactory.getLogger(SearchAction.class);
/*    */ 
/*    */   @Autowired
/*    */   private StringTemplateRender templateRender;
/*    */ 
/*    */   @Autowired
/*    */   private Cms2TemplateService cms2TemplateService;
/*    */ 
/* 43 */   @RequestMapping({"/search*"})
/*    */   public void index(HttpServletRequest request, HttpServletResponse response, ModelMap model, SettlerAgent user) { Cms2Site site = Cms2Utils.getSite(request);
/*    */ 
/* 45 */     model.putAll(RequestUtils.getQueryParams(request));
/* 46 */     FrontUtils.frontData(request, model, site, user);
/* 47 */     FrontUtils.frontPageData(request, site, Boolean.valueOf(false), model);
/* 48 */     String q = RequestUtils.getQueryParam(request, "q");
/* 49 */     String channelId = RequestUtils.getQueryParam(request, "channelId");
/* 50 */     String code = RequestUtils.getQueryParam(request, "code");
/* 51 */     String tempContent = null;
/* 52 */     Cms2Template template = null;
/* 53 */     if ((StringUtils.isBlank(q)) && (StringUtils.isBlank(channelId)) && (StringUtils.isBlank(code))) {
/* 54 */       model.remove("q");
/* 55 */       model.remove("channelId");
/* 56 */       model.remove("allsite");
/* 57 */       model.remove("code");
/* 58 */       model.remove("p");
/* 59 */       template = this.cms2TemplateService.getTplByTypeAndName(site.getId() + "", EnumTplDirType.SPECIAL.getCode(), "搜索");
/* 60 */       if (template != null)
/* 61 */         tempContent = template.getCont();
/*    */       try {
/* 63 */         WebUtils.toHtmlPage(response, this.templateRender.render(model, tempContent));
/*    */       } catch (IOException e) {
/* 65 */         logger.error("显示搜索输入页面时出现IO异常：", e);
/*    */       }
/*    */     } else {
/* 68 */       template = this.cms2TemplateService.getTplByTypeAndName(site.getId() + "", EnumTplDirType.SPECIAL.getCode(), "搜索结果");
/* 69 */       if (template != null)
/* 70 */         tempContent = template.getCont();
/*    */       try {
/* 72 */         WebUtils.toHtmlPage(response, this.templateRender.render(model, tempContent));
/*    */       } catch (IOException e) {
/* 74 */         logger.error("显示搜索结果页面时出现IO异常：", e);
/*    */       }
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy13\cmsWeb\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.web.action.SearchAction
 * JD-Core Version:    0.6.0
 */