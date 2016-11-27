/*     */ package com.hundsun.network.gates.fengshan.web.resolver;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.biz.domain.UserAgent;
/*     */ import com.hundsun.network.gates.luosi.biz.security.SystemAccessDeniedException;
/*     */ import com.hundsun.network.melody.common.web.cookyjar.Cookyjar;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.math.BigDecimal;
/*     */ import java.net.URLEncoder;
/*     */ import java.util.Enumeration;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.springframework.ui.ModelMap;
/*     */ import org.springframework.web.multipart.MaxUploadSizeExceededException;
/*     */ import org.springframework.web.servlet.HandlerExceptionResolver;
/*     */ import org.springframework.web.servlet.ModelAndView;
/*     */ 
/*     */ public class SystemExceptionResolver
/*     */   implements HandlerExceptionResolver
/*     */ {
/*  27 */   private static final Log logger = LogFactory.getLog(SystemExceptionResolver.class);
/*     */   private String webEncoding;
/*     */   private String errorPage;
/*     */   private String adminLoginPath;
/*     */   private String adminDeniedPage;
/*     */   private String adminLoginReturnParameterName;
/*     */ 
/*     */   public void setWebEncoding(String webEncoding)
/*     */   {
/*  40 */     this.webEncoding = webEncoding;
/*     */   }
/*     */ 
/*     */   public void setErrorPage(String errorPage) {
/*  44 */     this.errorPage = errorPage;
/*     */   }
/*     */ 
/*     */   public void setAdminLoginPath(String adminLoginPath) {
/*  48 */     this.adminLoginPath = adminLoginPath;
/*     */   }
/*     */ 
/*     */   public void setAdminDeniedPage(String adminDeniedPage) {
/*  52 */     this.adminDeniedPage = adminDeniedPage;
/*     */   }
/*     */ 
/*     */   public void setAdminLoginReturnParameterName(String adminLoginReturnParameterName) {
/*  56 */     this.adminLoginReturnParameterName = adminLoginReturnParameterName;
/*     */   }
/*     */ 
/*     */   public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
/*     */   {
/*  61 */     if ((ex instanceof SystemAccessDeniedException)) {
/*  62 */       return resolveSystemAccessDeniedException(request);
/*     */     }
/*     */ 
/*  65 */     ModelMap model = new ModelMap();
/*  66 */     if ((ex instanceof MaxUploadSizeExceededException)) {
/*  67 */       long maxFileSize = ((MaxUploadSizeExceededException)ex).getMaxUploadSize();
/*  68 */       long b = 1048576L;
/*  69 */       BigDecimal bigDecimal = new BigDecimal(maxFileSize);
/*  70 */       BigDecimal divisor = new BigDecimal(b);
/*  71 */       String message = "您上传的文件总大小超过" + bigDecimal.divide(divisor).setScale(0, 5) + "M!";
/*  72 */       model.put("message", message);
/*     */     }
/*  74 */     logger.error("web error", ex);
/*  75 */     return new ModelAndView(this.errorPage, model);
/*     */   }
/*     */ 
/*     */   private ModelAndView resolveSystemAccessDeniedException(HttpServletRequest request) {
/*  79 */     Cookyjar cookyjar = (Cookyjar)request.getAttribute("cookyjar");
/*  80 */     UserAgent agent = (UserAgent)cookyjar.getObject(UserAgent.class);
/*  81 */     if (agent == null) {
/*  82 */       String returnUrl = getReturnUrl(request);
/*  83 */       return new ModelAndView("redirect:" + this.adminLoginPath, this.adminLoginReturnParameterName, returnUrl);
/*     */     }
/*     */ 
/*  86 */     return new ModelAndView(this.adminDeniedPage);
/*     */   }
/*     */ 
/*     */   private String getReturnUrl(HttpServletRequest request) {
/*  90 */     StringBuffer sb = request.getRequestURL();
/*  91 */     appendRequestParameters(sb, request);
/*     */     try {
/*  93 */       return URLEncoder.encode(sb.toString(), this.webEncoding); } catch (UnsupportedEncodingException e) {
/*     */     }
/*  95 */     return null;
/*     */   }
/*     */ 
/*     */   private void appendRequestParameters(StringBuffer sb, HttpServletRequest request)
/*     */   {
/* 101 */     Enumeration en = request.getParameterNames();
/* 102 */     if (!en.hasMoreElements()) {
/* 103 */       return;
/*     */     }
/* 105 */     sb.append('?');
/* 106 */     while (en.hasMoreElements()) {
/* 107 */       String name = (String)en.nextElement();
/* 108 */       String[] values = request.getParameterValues(name);
/* 109 */       if ((values == null) || (values.length == 0)) {
/*     */         continue;
/*     */       }
/* 112 */       for (String v : values) {
/*     */         try {
/* 114 */           v = URLEncoder.encode(v, this.webEncoding);
/*     */         } catch (UnsupportedEncodingException ignore) {
/*     */         }
/* 117 */         sb.append(name).append('=').append(v).append('&');
/*     */       }
/*     */     }
/* 120 */     sb.deleteCharAt(sb.length() - 1);
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.web.resolver.SystemExceptionResolver
 * JD-Core Version:    0.6.0
 */