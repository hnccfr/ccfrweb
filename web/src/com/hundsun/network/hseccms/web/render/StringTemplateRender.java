/*     */ package com.hundsun.network.hseccms.web.render;
/*     */ 
/*     */ import com.hundsun.network.hseccms.enums.EnumTplDirType;
/*     */ import com.hundsun.network.hseccms.model.Cms2Site;
/*     */ import com.hundsun.network.hseccms.model.Cms2Template;
/*     */ import com.hundsun.network.hseccms.security.SettlerAgent;
/*     */ import com.hundsun.network.hseccms.service.Cms2TemplateService;
/*     */ import com.hundsun.network.hseccms.util.Cms2Utils;
/*     */ import com.hundsun.network.hseccms.util.FrontUtils;
/*     */ import com.hundsun.network.hseccms.web.common.WebUtils;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import freemarker.template.SimpleHash;
/*     */ import freemarker.template.Template;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.BufferedWriter;
/*     */ import java.io.StringReader;
/*     */ import java.io.StringWriter;
/*     */ import java.util.Map;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.apache.commons.lang.StringUtils;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.beans.factory.annotation.Value;
/*     */ import org.springframework.stereotype.Service;
/*     */ import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
/*     */ 
/*     */ @Service("stringTemplateRender")
/*     */ public class StringTemplateRender
/*     */ {
/*  41 */   private static Log _log = LogFactory.getLog(StringTemplateRender.class);
/*     */ 
/*     */   @Autowired
/*     */   private FreeMarkerConfigurer freeMarkerConfigurer;
/*     */ 
/*     */   @Autowired
/*     */   private Cms2TemplateService cms2TemplateService;
/*     */   public static final String ENCODE_UTF8 = "UTF-8";
/*     */ 
/*     */   @Value("${system.devMode}")
/*     */   private String devMode;
/*     */ 
/*     */   public void renderTplInCurrentSite(String type, String tplName, HttpServletRequest request, HttpServletResponse response, Map<String, Object> model, SettlerAgent user)
/*     */   {
/*  63 */     renderTpl(type, tplName, null, request, response, model, user);
/*     */   }
/*     */ 
/*     */   public void renderTpl(String type, String tplName, Cms2Site site, HttpServletRequest request, HttpServletResponse response, Map<String, Object> model, SettlerAgent user)
/*     */   {
/*  77 */     site = site == null ? Cms2Utils.getSite(request) : site;
/*  78 */     if ((StringUtils.isBlank(type)) || (StringUtils.isBlank(tplName))) {
/*  79 */       type = EnumTplDirType.COMMON.getCode();
/*  80 */       tplName = "错误";
/*     */     }
/*     */     try {
/*  83 */       FrontUtils.frontData(request, model, site, user);
/*  84 */       Cms2Template template = this.cms2TemplateService.getTplByTypeAndName(new StringBuilder().append(site.getId()).append("").toString(), type, tplName);
/*     */ 
/*  86 */       String str = null;
/*  87 */       if (template != null)
/*  88 */         str = template.getCont();
/*  89 */       str = render(model, str);
/*  90 */       WebUtils.toHtmlPage(response, str);
/*     */     } catch (Exception e) {
/*  92 */       _log.error("", e);
/*     */     }
/*     */   }
/*     */ 
/*     */   public String render(Object dataModel, String templateStr)
/*     */   {
/* 101 */     StringBuilder renderResult = new StringBuilder();
/* 102 */     if (!(dataModel instanceof Map)) {
/* 103 */       if ("true".equals(this.devMode)) {
/* 104 */         renderResult.append("参数dataModel必须为一个Map对象");
/*     */       }
/* 106 */       _log.error("render error!!!", new IllegalArgumentException("参数dataModel必须为一个Map对象"));
/* 107 */       return renderResult.toString();
/*     */     }
/*     */ 
/* 110 */     templateStr = StringUtil.isBlank(templateStr) ? "模版内容为空" : templateStr;
/* 111 */     BufferedReader reader = new BufferedReader(new StringReader(templateStr));
/* 112 */     Template template = null;
/*     */     try
/*     */     {
/* 115 */       template = new Template(null, reader, this.freeMarkerConfigurer.getConfiguration(), "UTF-8");
/* 116 */       SimpleHash root = new SimpleHash();
/* 117 */       root.putAll((Map)dataModel);
/* 118 */       StringWriter stringWriter = new StringWriter();
/* 119 */       BufferedWriter writer = new BufferedWriter(stringWriter);
/* 120 */       template.process(root, writer);
/* 121 */       writer.flush();
/* 122 */       renderResult.append(stringWriter);
/*     */     } catch (Exception e) {
/* 124 */       if ("true".equals(this.devMode)) {
/* 125 */         renderResult.append(e);
/*     */       }
/* 127 */       _log.error("render error!!!", e);
/*     */     }
/* 129 */     return renderResult.toString();
/*     */   }
/*     */ 
/*     */   public void setFreeMarkerConfigurer(FreeMarkerConfigurer freeMarkerConfigurer) {
/* 133 */     this.freeMarkerConfigurer = freeMarkerConfigurer;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy13\cmsWeb\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.web.render.StringTemplateRender
 * JD-Core Version:    0.6.0
 */