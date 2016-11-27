/*     */ package com.hundsun.eclp.web.resolver;
/*     */ 
/*     */ import com.hundsun.eclp.biz.domain.user.UserAgent;
/*     */ import com.hundsun.eclp.security.AdminAccessDeniedException;
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
/*     */ public class PermissionDeniedExceptionResolver
/*     */   implements HandlerExceptionResolver
/*     */ {
/*  24 */   private static final Log logger = LogFactory.getLog(PermissionDeniedExceptionResolver.class);
/*     */   private String webEncoding;
/*     */   private String errorPage;
/*     */   private String adminLoginPath;
/*     */   private String adminDeniedPage;
/*     */   private String adminLoginReturnParameterName;
/*     */ 
/*     */   public void setWebEncoding(String webEncoding)
/*     */   {
/*  37 */     this.webEncoding = webEncoding;
/*     */   }
/*     */ 
/*     */   public void setErrorPage(String errorPage) {
/*  41 */     this.errorPage = errorPage;
/*     */   }
/*     */ 
/*     */   public void setAdminLoginPath(String adminLoginPath) {
/*  45 */     this.adminLoginPath = adminLoginPath;
/*     */   }
/*     */ 
/*     */   public void setAdminDeniedPage(String adminDeniedPage) {
/*  49 */     this.adminDeniedPage = adminDeniedPage;
/*     */   }
/*     */ 
/*     */   public void setAdminLoginReturnParameterName(String adminLoginReturnParameterName) {
/*  53 */     this.adminLoginReturnParameterName = adminLoginReturnParameterName;
/*     */   }
/*     */ 
/*     */   public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
/*     */   {
/*  58 */     if ((ex instanceof AdminAccessDeniedException)) {
/*  59 */       return resolveSystemAccessDeniedException(request);
/*     */     }
/*  61 */     logger.error("web error", ex);
/*  62 */     return new ModelAndView(this.errorPage);
/*     */   }
/*     */ 
/*     */   private ModelAndView resolveSystemAccessDeniedException(HttpServletRequest request) {
/*  66 */     Cookyjar cookyjar = (Cookyjar)request.getAttribute("cookyjar");
/*  67 */     UserAgent agent = (UserAgent)cookyjar.getObject(UserAgent.class);
/*  68 */     if (agent == null) {
/*  69 */       String returnUrl = getReturnUrl(request);
/*  70 */       return new ModelAndView("redirect:" + this.adminLoginPath, this.adminLoginReturnParameterName, returnUrl);
/*     */     }
/*     */ 
/*  73 */     return new ModelAndView(this.adminDeniedPage);
/*     */   }
/*     */ 
/*     */   private String getReturnUrl(HttpServletRequest request) {
/*  77 */     StringBuffer sb = request.getRequestURL();
/*  78 */     appendRequestParameters(sb, request);
/*     */     try {
/*  80 */       return URLEncoder.encode(sb.toString(), this.webEncoding); } catch (UnsupportedEncodingException e) {
/*     */     }
/*  82 */     return null;
/*     */   }
/*     */ 
/*     */   private void appendRequestParameters(StringBuffer sb, HttpServletRequest request)
/*     */   {
/*  88 */     Enumeration en = request.getParameterNames();
/*  89 */     if (!en.hasMoreElements()) {
/*  90 */       return;
/*     */     }
/*  92 */     sb.append('?');
/*  93 */     while (en.hasMoreElements()) {
/*  94 */       String name = (String)en.nextElement();
/*  95 */       String[] values = request.getParameterValues(name);
/*  96 */       if ((values == null) || (values.length == 0)) {
/*     */         continue;
/*     */       }
/*  99 */       for (String v : values) {
/*     */         try {
/* 101 */           v = URLEncoder.encode(v, this.webEncoding);
/*     */         } catch (UnsupportedEncodingException ignore) {
/*     */         }
/* 104 */         sb.append(name).append('=').append(v).append('&');
/*     */       }
/*     */     }
/* 107 */     sb.deleteCharAt(sb.length() - 1);
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.web.resolver.PermissionDeniedExceptionResolver
 * JD-Core Version:    0.6.0
 */