/*     */ package com.hundsun.network.hseccms.admin.util;
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
/*  26 */   public static final String[] EXTARRAY = { "jpg", "jpeg", "gif", "png" };
/*     */ 
/*  31 */   public static final DateFormat MONTH_FORMAT = new SimpleDateFormat("/yyyyMM/ddHHmmss");
/*     */ 
/*     */   public static boolean renameFile(String fileName, String newfileName)
/*     */   {
/*     */     try
/*     */     {
/*  41 */       File file = new File(fileName);
/*  42 */       if (!file.exists()) {
/*  43 */         return false;
/*     */       }
/*  45 */       File newFile = new File(newfileName);
/*  46 */       if (newFile.getName().equals(file.getName())) {
/*  47 */         return true;
/*     */       }
/*  49 */       if (file.renameTo(newFile)) {
/*  50 */         file.delete();
/*  51 */         return true;
/*     */       }
/*  53 */       return false;
/*     */     } catch (Exception e) {
/*     */     }
/*  56 */     return false;
/*     */   }
/*     */ 
/*     */   public static boolean delFile(String fileName)
/*     */   {
/*     */     try
/*     */     {
/*  67 */       File file = new File(fileName);
/*  68 */       if (!file.exists()) {
/*  69 */         return false;
/*     */       }
/*  71 */       if (!file.isFile()) {
/*  72 */         return false;
/*     */       }
/*  74 */       file.delete();
/*  75 */       return true; } catch (Exception e) {
/*     */     }
/*  77 */     return false;
/*     */   }
/*     */ 
/*     */   private static boolean writeFile(InputStream input, String filePath)
/*     */   {
/*     */     try
/*     */     {
/*  89 */       if (null == input) {
/*  90 */         return false;
/*     */       }
/*  92 */       FileOutputStream output = new FileOutputStream(filePath);
/*  93 */       ByteArrayOutputStream data = new ByteArrayOutputStream();
/*  94 */       int num = 0;
/*  95 */       byte[] buffer = new byte[1024];
/*  96 */       while ((num = input.read(buffer)) > 0) {
/*  97 */         data.write(buffer, 0, num);
/*  98 */         output.write(buffer);
/*     */       }
/* 100 */       output.close();
/* 101 */       return true; } catch (Exception e) {
/*     */     }
/* 103 */     return false;
/*     */   }
/*     */ 
/*     */   public static String uploadAffix(String path, String fileName, MultipartFile file)
/*     */     throws IOException
/*     */   {
/* 116 */     if (null == file) {
/* 117 */       return null;
/*     */     }
/* 119 */     if (null == path)
/* 120 */       return null;
/*     */     try
/*     */     {
/* 123 */       mkdir(path);
/* 124 */       fileName = path + fileName;
/* 125 */       if (writeFile(file.getInputStream(), fileName)) {
/* 126 */         return fileName;
/*     */       }
/* 128 */       return null;
/*     */     }
/*     */     catch (MaxUploadSizeExceededException e)
/*     */     {
/* 132 */       file.getInputStream().close();
/*     */     } catch (IOException e) {
/* 134 */       file.getInputStream().close();
/*     */     }
/*     */     catch (Exception e) {
/* 137 */       file.getInputStream().close();
/*     */     }
/* 139 */     return null;
/*     */   }
/*     */ 
/*     */   public static void mkdir(String path)
/*     */   {
/* 148 */     File dirPath = new File(path);
/* 149 */     if (!dirPath.exists())
/* 150 */       dirPath.mkdirs();
/*     */   }
/*     */ 
/*     */   public static boolean ifExtendNamePermitted(String exts)
/*     */   {
/* 161 */     for (String s : EXTARRAY) {
/* 162 */       if (exts.equalsIgnoreCase(s)) {
/* 163 */         return true;
/*     */       }
/*     */     }
/* 166 */     return false;
/*     */   }
/*     */ 
/*     */   public static String generateFilename(String ext) {
/* 170 */     return RandomStringUtils.random(4, Num62.N36_CHARS) + "." + ext;
/*     */   }
/*     */ 
/*     */   public static String generateFilePath(String path) {
/* 174 */     return path + MONTH_FORMAT.format(new Date());
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy\cmsAdmin\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.admin.util.FileUtils
 * JD-Core Version:    0.6.0
 */