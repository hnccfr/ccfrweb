/*    */ package com.hundsun.network.gates.taiping.biz.common;
/*    */ 
/*    */ import javax.servlet.ServletContextEvent;
/*    */ import javax.servlet.ServletContextListener;
/*    */ import org.springframework.context.ApplicationContext;
/*    */ import org.springframework.web.context.WebApplicationContext;
/*    */ import org.springframework.web.context.support.WebApplicationContextUtils;
/*    */ 
/*    */ public class SpringContextInit
/*    */   implements ServletContextListener
/*    */ {
/*    */   private static WebApplicationContext springContext;
/*    */ 
/*    */   public void contextInitialized(ServletContextEvent event)
/*    */   {
/* 23 */     springContext = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
/*    */   }
/*    */ 
/*    */   public void contextDestroyed(ServletContextEvent event)
/*    */   {
/*    */   }
/*    */ 
/*    */   public static ApplicationContext getApplicationContext() {
/* 31 */     return springContext;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.taiping.biz.common.SpringContextInit
 * JD-Core Version:    0.6.0
 */