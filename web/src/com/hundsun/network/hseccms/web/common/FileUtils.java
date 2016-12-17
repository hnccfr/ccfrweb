/*     */ package com.hundsun.network.hseccms.web.common;
/*     */ 
/*     */ import com.hundsun.network.hseccms.util.editor.Num62;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.text.DateFormat;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import org.apache.commons.lang.RandomStringUtils;
/*     */ import org.springframework.web.multipart.MaxUploadSizeExceededException;
/*     */ import org.springframework.web.multipart.MultipartFile;
/*     */ 
/*     */ public class FileUtils
/*     */ {
/*  27 */   public static final String[] EXTARRAY = { "jpg", "jpeg", "gif", "png" };
/*     */ 
/*  32 */   public static final DateFormat MONTH_FORMAT = new SimpleDateFormat("/yyyyMM/ddHHmmss");
/*     */ 
/*     */   public static boolean renameFile(String fileName, String newfileName)
/*     */   {
/*     */     try
/*     */     {
/*  42 */       File file = new File(fileName);
/*  43 */       if (!file.exists()) {
/*  44 */         return false;
/*     */       }
/*  46 */       File newFile = new File(newfileName);
/*  47 */       if (newFile.getName().equals(file.getName())) {
/*  48 */         return true;
/*     */       }
/*  50 */       if (file.renameTo(newFile)) {
/*  51 */         file.delete();
/*  52 */         return true;
/*     */       }
/*  54 */       return false;
/*     */     } catch (Exception e) {
/*     */     }
/*  57 */     return false;
/*     */   }
/*     */ 
/*     */   public static boolean delFile(String fileName)
/*     */   {
/*     */     try
/*     */     {
/*  68 */       File file = new File(fileName);
/*  69 */       if (!file.exists()) {
/*  70 */         return false;
/*     */       }
/*  72 */       if (!file.isFile()) {
/*  73 */         return false;
/*     */       }
/*  75 */       file.delete();
/*  76 */       return true; } catch (Exception e) {
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */ 
/*     */   private static boolean writeFile(InputStream input, String filePath)
/*     */   {
/*     */     try
/*     */     {
/*  90 */       if (null == input) {
/*  91 */         return false;
/*     */       }
/*  93 */       FileOutputStream output = new FileOutputStream(filePath);
/*  94 */       ByteArrayOutputStream data = new ByteArrayOutputStream();
/*  95 */       int num = 0;
/*  96 */       byte[] buffer = new byte[1024];
/*  97 */       while ((num = input.read(buffer)) > 0) {
/*  98 */         data.write(buffer, 0, num);
/*  99 */         output.write(buffer);
/*     */       }
/* 101 */       output.close();
/* 102 */       return true; } catch (Exception e) {
/*     */     }
/* 104 */     return false;
/*     */   }
/*     */ 
/*     */   public static String uploadAffix(String path, String fileName, MultipartFile file)
/*     */     throws IOException
/*     */   {
/* 117 */     if (null == file) {
/* 118 */       return null;
/*     */     }
/* 120 */     if (null == path)
/* 121 */       return null;
/*     */     try
/*     */     {
/* 124 */       mkdir(path);
/* 125 */       fileName = path + fileName;
/* 126 */       if (writeFile(file.getInputStream(), fileName)) {
/* 127 */         return fileName;
/*     */       }
/* 129 */       return null;
/*     */     }
/*     */     catch (MaxUploadSizeExceededException e)
/*     */     {
/* 133 */       file.getInputStream().close();
/*     */     } catch (IOException e) {
/* 135 */       file.getInputStream().close();
/*     */     }
/*     */     catch (Exception e) {
/* 138 */       file.getInputStream().close();
/*     */     }
/* 140 */     return null;
/*     */   }
/*     */ 
/*     */   public static void mkdir(String path)
/*     */   {
/* 149 */     File dirPath = new File(path);
/* 150 */     if (!dirPath.exists())
/* 151 */       dirPath.mkdirs();
/*     */   }
/*     */ 
/*     */   public static boolean ifExtendNamePermitted(String exts)
/*     */   {
/* 162 */     for (String s : EXTARRAY) {
/* 163 */       if (exts.equalsIgnoreCase(s)) {
/* 164 */         return true;
/*     */       }
/*     */     }
/* 167 */     return false;
/*     */   }
/*     */ 
/*     */   public static String generateFilename(String ext) {
/* 171 */     return RandomStringUtils.random(4, Num62.N36_CHARS) + "." + ext;
/*     */   }
/*     */ 
/*     */   public static String generateFilePath(String path) {
/* 175 */     return path + MONTH_FORMAT.format(new Date());
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy13\cmsWeb\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.web.common.FileUtils
 * JD-Core Version:    0.6.0
 */