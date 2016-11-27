/*     */ package com.hundsun.network.gates.qingbo.biz.util;
/*     */ 
/*     */ import org.springframework.beans.BeansException;
/*     */ import org.springframework.beans.factory.NoSuchBeanDefinitionException;
/*     */ import org.springframework.context.ApplicationContext;
/*     */ import org.springframework.context.ApplicationContextAware;
/*     */ 
/*     */ public class WebContextFactoryUtil
/*     */   implements ApplicationContextAware
/*     */ {
/*     */   private static ApplicationContext applicationContext;
/*     */ 
/*     */   public void setApplicationContext(ApplicationContext applicationContext)
/*     */     throws BeansException
/*     */   {
/*  35 */     applicationContext = applicationContext;
/*     */   }
/*     */ 
/*     */   public static ApplicationContext getApplicationContext()
/*     */   {
/*  42 */     return applicationContext;
/*     */   }
/*     */ 
/*     */   public static Object getBean(String beanName)
/*     */     throws BeansException
/*     */   {
/*  53 */     if (!containsBean(beanName)) {
/*  54 */       return null;
/*     */     }
/*  56 */     return applicationContext.getBean(beanName);
/*     */   }
/*     */ 
/*     */   public static Object getBean(String name, Class requiredType)
/*     */     throws BeansException
/*     */   {
/*  73 */     return applicationContext.getBean(name, requiredType);
/*     */   }
/*     */ 
/*     */   public static boolean containsBean(String name)
/*     */   {
/*  83 */     return applicationContext.containsBean(name);
/*     */   }
/*     */ 
/*     */   public static boolean isSingleton(String name)
/*     */     throws NoSuchBeanDefinitionException
/*     */   {
/*  95 */     return applicationContext.isSingleton(name);
/*     */   }
/*     */ 
/*     */   public static Class getType(String name)
/*     */     throws NoSuchBeanDefinitionException
/*     */   {
/* 105 */     return applicationContext.getType(name);
/*     */   }
/*     */ 
/*     */   public static String[] getAliases(String name)
/*     */     throws NoSuchBeanDefinitionException
/*     */   {
/* 116 */     return applicationContext.getAliases(name);
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.qingbo.biz.util.WebContextFactoryUtil
 * JD-Core Version:    0.6.0
 */