/*     */ package com.hundsun.network.hseccms.web.common;
/*     */ 
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.InputStream;
/*     */ import java.util.Properties;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ public class PropertiesLoader
/*     */ {
/*  29 */   private static final Logger logger = LoggerFactory.getLogger(PropertiesLoader.class);
/*     */   private static final String DEFAULT_FILENAME = "default.properties";
/*     */   private static final String LOCAL_PROPERTIES = "/app.properties";
/*  35 */   private static Properties properties = new Properties();
/*     */ 
/*     */   public static String getProperty(String key)
/*     */   {
/*  91 */     return properties.getProperty(key);
/*     */   }
/*     */ 
/*     */   public static void setProperty(String key, String value)
/*     */   {
/* 100 */     properties.setProperty(key, value);
/*     */   }
/*     */ 
/*     */   public static String getFileResourceTypePath()
/*     */   {
/* 107 */     return properties.getProperty("connector.resourceType.file.path");
/*     */   }
/*     */ 
/*     */   public static String getFlashResourceTypePath()
/*     */   {
/* 114 */     return properties.getProperty("connector.resourceType.flash.path");
/*     */   }
/*     */ 
/*     */   public static String getImageResourceTypePath()
/*     */   {
/* 121 */     return properties.getProperty("connector.resourceType.image.path");
/*     */   }
/*     */ 
/*     */   public static String getMediaResourceTypePath()
/*     */   {
/* 128 */     return properties.getProperty("connector.resourceType.media.path");
/*     */   }
/*     */ 
/*     */   public static String getFileResourceTypeAllowedExtensions()
/*     */   {
/* 136 */     return properties.getProperty("connector.resourceType.file.extensions.allowed");
/*     */   }
/*     */ 
/*     */   public static String getFileResourceTypeDeniedExtensions()
/*     */   {
/* 145 */     return properties.getProperty("connector.resourceType.file.extensions.denied");
/*     */   }
/*     */ 
/*     */   public static String getFlashResourceTypeAllowedExtensions()
/*     */   {
/* 154 */     return properties.getProperty("connector.resourceType.flash.extensions.allowed");
/*     */   }
/*     */ 
/*     */   public static String getFlashResourceTypeDeniedExtensions()
/*     */   {
/* 163 */     return properties.getProperty("connector.resourceType.flash.extensions.denied");
/*     */   }
/*     */ 
/*     */   public static String getImageResourceTypeAllowedExtensions()
/*     */   {
/* 172 */     return properties.getProperty("connector.resourceType.image.extensions.allowed");
/*     */   }
/*     */ 
/*     */   public static String getImageResourceTypeDeniedExtensions()
/*     */   {
/* 181 */     return properties.getProperty("connector.resourceType.image.extensions.denied");
/*     */   }
/*     */ 
/*     */   public static String getMediaResourceTypeAllowedExtensions()
/*     */   {
/* 190 */     return properties.getProperty("connector.resourceType.media.extensions.allowed");
/*     */   }
/*     */ 
/*     */   public static String getMediaResourceTypeDeniedExtensions()
/*     */   {
/* 199 */     return properties.getProperty("connector.resourceType.media.extensions.denied");
/*     */   }
/*     */ 
/*     */   public static String getUserFilesPath()
/*     */   {
/* 207 */     return properties.getProperty("connector.userFilesPath");
/*     */   }
/*     */ 
/*     */   public static String getUserFilesAbsolutePath()
/*     */   {
/* 214 */     return properties.getProperty("connector.userFilesAbsolutePath");
/*     */   }
/*     */ 
/*     */   static
/*     */   {
/*  40 */     InputStream in = PropertiesLoader.class.getResourceAsStream("default.properties");
/*     */ 
/*  43 */     if (in == null) {
/*  44 */       logger.error("{} not found", "default.properties");
/*  45 */       throw new RuntimeException("default.properties not found");
/*     */     }
/*  47 */     if (!(in instanceof BufferedInputStream))
/*  48 */       in = new BufferedInputStream(in);
/*     */     try
/*     */     {
/*  51 */       properties.load(in);
/*  52 */       in.close();
/*  53 */       logger.debug("{} loaded", "default.properties");
/*     */     } catch (Exception e) {
/*  55 */       logger.error("Error while processing {}", "default.properties");
/*  56 */       throw new RuntimeException("Error while processing default.properties", e);
/*     */     }
/*     */ 
/*  62 */     InputStream in2 = PropertiesLoader.class.getResourceAsStream("/app.properties");
/*     */ 
/*  65 */     if (in2 == null) {
/*  66 */       logger.info("{} not found", "/app.properties");
/*     */     }
/*     */     else {
/*  69 */       if (!(in2 instanceof BufferedInputStream))
/*  70 */         in2 = new BufferedInputStream(in2);
/*     */       try
/*     */       {
/*  73 */         properties.load(in2);
/*  74 */         in2.close();
/*  75 */         logger.debug("{} loaded", "/app.properties");
/*     */       } catch (Exception e) {
/*  77 */         logger.error("Error while processing {}", "/app.properties");
/*  78 */         throw new RuntimeException("Error while processing /app.properties", e);
/*     */       }
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy13\cmsWeb\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.web.common.PropertiesLoader
 * JD-Core Version:    0.6.0
 */