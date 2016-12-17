/*     */ package com.hundsun.network.hseccms.web.resolver;
/*     */ 
/*     */ import com.hundsun.network.hseccms.security.SettlerAgent;
/*     */ import com.hundsun.network.hseccms.web.security.SettlerAccessDeniedException;
/*     */ import com.hundsun.network.melody.common.web.cookyjar.Cookyjar;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.net.URLEncoder;
/*     */ import java.util.Enumeration;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.springframework.web.servlet.HandlerExceptionResolver;
/*     */ import org.springframework.web.servlet.ModelAndView;
/*     */ 
/*     */ public class SettlerExceptionResolver
/*     */   implements HandlerExceptionResolver
/*     */ {
/*  25 */   private static final Log logger = LogFactory.getLog(SettlerExceptionResolver.class);
/*     */   private String webEncoding;
/*     */   private String errorPage;
/*     */   private String adminLoginPath;
/*     */   private String adminDeniedPage;
/*     */   private String adminLoginReturnParameterName;
/*     */ 
/*     */   public void setWebEncoding(String webEncoding)
/*     */   {
/*  38 */     this.webEncoding = webEncoding;
/*     */   }
/*     */ 
/*     */   public void setErrorPage(String errorPage) {
/*  42 */     this.errorPage = errorPage;
/*     */   }
/*     */ 
/*     */   public void setAdminLoginPath(String adminLoginPath) {
/*  46 */     this.adminLoginPath = adminLoginPath;
/*     */   }
/*     */ 
/*     */   public void setAdminDeniedPage(String adminDeniedPage) {
/*  50 */     this.adminDeniedPage = adminDeniedPage;
/*     */   }
/*     */ 
/*     */   public void setAdminLoginReturnParameterName(String adminLoginReturnParameterName) {
/*  54 */     this.adminLoginReturnParameterName = adminLoginReturnParameterName;
/*     */   }
/*     */ 
/*     */   public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
/*     */   {
/*  59 */     if ((ex instanceof SettlerAccessDeniedException)) {
/*  60 */       return resolveSettlerAccessDeniedException(request);
/*     */     }
/*  62 */     logger.error("web error", ex);
/*  63 */     return new ModelAndView(this.errorPage);
/*     */   }
/*     */ 
/*     */   private ModelAndView resolveSettlerAccessDeniedException(HttpServletRequest request) {
/*  67 */     Cookyjar cookyjar = (Cookyjar)request.getAttribute("cookyjar");
/*  68 */     SettlerAgent agent = (SettlerAgent)cookyjar.getObject(SettlerAgent.class);
/*  69 */     if (agent == null) {
/*  70 */       String returnUrl = getReturnUrl(request);
/*  71 */       return new ModelAndView("redirect:" + this.adminLoginPath, this.adminLoginReturnParameterName, returnUrl);
/*     */     }
/*     */ 
/*  74 */     return new ModelAndView(this.adminDeniedPage);
/*     */   }
/*     */ 
/*     */   private String getReturnUrl(HttpServletRequest request) {
/*  78 */     StringBuffer sb = request.getRequestURL();
/*  79 */     appendRequestParameters(sb, request);
/*     */     try {
/*  81 */       return URLEncoder.encode(sb.toString(), this.webEncoding); } catch (UnsupportedEncodingException e) {
/*     */     }
/*  83 */     return null;
/*     */   }
/*     */ 
/*     */   private void appendRequestParameters(StringBuffer sb, HttpServletRequest request)
/*     */   {
/*  89 */     Enumeration en = request.getParameterNames();
/*  90 */     if (!en.hasMoreElements()) {
/*  91 */       return;
/*     */     }
/*  93 */     sb.append('?');
/*  94 */     while (en.hasMoreElements()) {
/*  95 */       String name = (String)en.nextElement();
/*  96 */       String[] values = request.getParameterValues(name);
/*  97 */       if ((values == null) || (values.length == 0)) {
/*     */         continue;
/*     */       }
/* 100 */       for (String v : values) {
/*     */         try {
/* 102 */           v = URLEncoder.encode(v, this.webEncoding);
/*     */         } catch (UnsupportedEncodingException ignore) {
/*     */         }
/* 105 */         sb.append(name).append('=').append(v).append('&');
/*     */       }
/*     */     }
/* 108 */     sb.deleteCharAt(sb.length() - 1);
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy13\cmsWeb\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.web.resolver.SettlerExceptionResolver
 * JD-Core Version:    0.6.0
 */