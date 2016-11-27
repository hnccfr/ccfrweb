/*     */ package com.hundsun.network.gates.genshan.web.resolver;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.common.UserAgent;
/*     */ import com.hundsun.network.gates.genshan.security.AdminAccessDeniedException;
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
/*  22 */   private static final Log logger = LogFactory.getLog(PermissionDeniedExceptionResolver.class);
/*     */   private String webEncoding;
/*     */   private String errorPage;
/*     */   private String adminLoginPath;
/*     */   private String adminDeniedPage;
/*     */   private String adminLoginReturnParameterName;
/*     */ 
/*     */   public void setWebEncoding(String webEncoding)
/*     */   {
/*  35 */     this.webEncoding = webEncoding;
/*     */   }
/*     */ 
/*     */   public void setErrorPage(String errorPage) {
/*  39 */     this.errorPage = errorPage;
/*     */   }
/*     */ 
/*     */   public void setAdminLoginPath(String adminLoginPath) {
/*  43 */     this.adminLoginPath = adminLoginPath;
/*     */   }
/*     */ 
/*     */   public void setAdminDeniedPage(String adminDeniedPage) {
/*  47 */     this.adminDeniedPage = adminDeniedPage;
/*     */   }
/*     */ 
/*     */   public void setAdminLoginReturnParameterName(String adminLoginReturnParameterName) {
/*  51 */     this.adminLoginReturnParameterName = adminLoginReturnParameterName;
/*     */   }
/*     */ 
/*     */   public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
/*     */   {
/*  56 */     if ((ex instanceof AdminAccessDeniedException)) {
/*  57 */       return resolveSystemAccessDeniedException(request);
/*     */     }
/*  59 */     logger.error("web error", ex);
/*  60 */     return new ModelAndView(this.errorPage);
/*     */   }
/*     */ 
/*     */   private ModelAndView resolveSystemAccessDeniedException(HttpServletRequest request) {
/*  64 */     Cookyjar cookyjar = (Cookyjar)request.getAttribute("cookyjar");
/*  65 */     UserAgent agent = (UserAgent)cookyjar.getObject(UserAgent.class);
/*  66 */     if (agent == null) {
/*  67 */       String returnUrl = getReturnUrl(request);
/*  68 */       return new ModelAndView("redirect:" + this.adminLoginPath, this.adminLoginReturnParameterName, returnUrl);
/*     */     }
/*     */ 
/*  71 */     return new ModelAndView(this.adminDeniedPage);
/*     */   }
/*     */ 
/*     */   private String getReturnUrl(HttpServletRequest request) {
/*  75 */     StringBuffer sb = request.getRequestURL();
/*  76 */     appendRequestParameters(sb, request);
/*     */     try {
/*  78 */       return URLEncoder.encode(sb.toString(), this.webEncoding); } catch (UnsupportedEncodingException e) {
/*     */     }
/*  80 */     return null;
/*     */   }
/*     */ 
/*     */   private void appendRequestParameters(StringBuffer sb, HttpServletRequest request)
/*     */   {
/*  86 */     Enumeration en = request.getParameterNames();
/*  87 */     if (!en.hasMoreElements()) {
/*  88 */       return;
/*     */     }
/*  90 */     sb.append('?');
/*  91 */     while (en.hasMoreElements()) {
/*  92 */       String name = (String)en.nextElement();
/*  93 */       String[] values = request.getParameterValues(name);
/*  94 */       if ((values == null) || (values.length == 0)) {
/*     */         continue;
/*     */       }
/*  97 */       for (String v : values) {
/*     */         try {
/*  99 */           v = URLEncoder.encode(v, this.webEncoding);
/*     */         } catch (UnsupportedEncodingException ignore) {
/*     */         }
/* 102 */         sb.append(name).append('=').append(v).append('&');
/*     */       }
/*     */     }
/* 105 */     sb.deleteCharAt(sb.length() - 1);
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.resolver.PermissionDeniedExceptionResolver
 * JD-Core Version:    0.6.0
 */