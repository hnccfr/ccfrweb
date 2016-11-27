/*    */ package com.hundsun.network.hseccms.web.common;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.PrintWriter;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ 
/*    */ public final class ResponseUtils
/*    */ {
/* 17 */   public static final Logger log = LoggerFactory.getLogger(ResponseUtils.class);
/*    */ 
/*    */   public static void renderText(HttpServletResponse response, String text)
/*    */   {
/* 29 */     render(response, "text/plain;charset=UTF-8", text);
/*    */   }
/*    */ 
/*    */   public static void renderJson(HttpServletResponse response, String text)
/*    */   {
/* 41 */     render(response, "application/json;charset=UTF-8", text);
/*    */   }
/*    */ 
/*    */   public static void renderXml(HttpServletResponse response, String text)
/*    */   {
/* 53 */     render(response, "text/xml;charset=UTF-8", text);
/*    */   }
/*    */ 
/*    */   public static void render(HttpServletResponse response, String contentType, String text)
/*    */   {
/* 65 */     response.setContentType(contentType);
/* 66 */     response.setHeader("Pragma", "No-cache");
/* 67 */     response.setHeader("Cache-Control", "no-cache");
/* 68 */     response.setDateHeader("Expires", 0L);
/*    */     try {
/* 70 */       response.getWriter().write(text);
/*    */     } catch (IOException e) {
/* 72 */       log.error(e.getMessage(), e);
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy13\cmsWeb\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.web.common.ResponseUtils
 * JD-Core Version:    0.6.0
 */