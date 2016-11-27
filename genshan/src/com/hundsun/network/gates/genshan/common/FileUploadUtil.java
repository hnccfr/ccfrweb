/*     */ package com.hundsun.network.gates.genshan.common;
/*     */ 
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Random;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.springframework.beans.factory.annotation.Value;
/*     */ import org.springframework.web.multipart.MultipartFile;
/*     */ 
/*     */ public class FileUploadUtil
/*     */ {
/*  22 */   private Log log = LogFactory.getLog(getClass());
/*     */   public static final String SEP = "/";
/*     */   public static final String POINT = ".";
/*  25 */   public static final String[] EXTARRAY = { "jpg", "jpeg", "gif", "png" };
/*     */ 
/*     */   @Value("${upload.root}")
/*     */   public String uploadRoot;
/*  30 */   public static int MAX_FILE_SIZE = 3145728;
/*     */   public static final String CRM_PIC_PATH = "000000";
/*     */ 
/*     */   @Value("${upload.root.licence.url.path}")
/*     */   public String uploadUrl;
/*     */   public static final String MEMLEVEL_FILE_HOME_DIR = "memlevel";
/*     */   public static final String USERCREDIT_FILE_HOME_DIR = "usercredit";
/*     */ 
/*     */   public static boolean ifFileSizePermitted(MultipartFile file)
/*     */   {
/*  56 */     return file.getSize() < MAX_FILE_SIZE;
/*     */   }
/*     */ 
/*     */   public static boolean ifExtendNamePermitted(MultipartFile file)
/*     */   {
/*  65 */     String orgFileName = file.getOriginalFilename();
/*  66 */     if (StringUtil.isBlank(orgFileName))
/*     */     {
/*  68 */       return true;
/*     */     }
/*  70 */     String exts = orgFileName.substring(orgFileName.lastIndexOf(".") + 1, orgFileName.length());
/*  71 */     return ifExtendNamePermitted(exts);
/*     */   }
/*     */ 
/*     */   public static boolean ifExtendNamePermitted(String exts) {
/*  75 */     for (String s : EXTARRAY) {
/*  76 */       if (exts.equalsIgnoreCase(s)) {
/*  77 */         return true;
/*     */       }
/*     */     }
/*  80 */     return false;
/*     */   }
/*     */ 
/*     */   public String uploadFile(MultipartFile file, String userId, String destDir) {
/*  84 */     if (StringUtil.isBlank(userId)) {
/*  85 */       return uploadFile(file, this.uploadUrl + "/" + destDir);
/*     */     }
/*  87 */     return uploadFile(file, userId + "/" + destDir);
/*     */   }
/*     */ 
/*     */   public String uploadFile(MultipartFile file, String destDir)
/*     */   {
/*  97 */     String filePath = "";
/*  98 */     if ((file == null) || (StringUtil.isEmpty(file.getOriginalFilename()))) {
/*  99 */       return filePath;
/*     */     }
/*     */ 
/* 102 */     String orgFileName = file.getOriginalFilename();
/* 103 */     String exts = orgFileName.substring(orgFileName.lastIndexOf(".") + 1, orgFileName.length());
/*     */ 
/* 105 */     if (!ifExtendNamePermitted(exts))
/*     */     {
/* 107 */       return filePath;
/*     */     }
/*     */ 
/* 110 */     String newFileName = createFileName(exts);
/* 111 */     String saveDir = this.uploadRoot + "/" + destDir + "/" + getSubFileDir();
/*     */     try {
/* 113 */       saveFile(file, saveDir, newFileName);
/*     */     } catch (IOException e) {
/* 115 */       this.log.error("FileUploadUtil.uploadFile", e);
/*     */     }
/* 117 */     filePath = destDir + "/" + getSubFileDir() + "/" + newFileName;
/* 118 */     return filePath;
/*     */   }
/*     */ 
/*     */   private static void saveFile(MultipartFile file, String destDir, String newFileName) throws IOException
/*     */   {
/* 123 */     if (!new File(destDir).exists()) {
/* 124 */       new File(destDir).mkdirs();
/*     */     }
/* 126 */     file.transferTo(new File(destDir + "/" + newFileName));
/*     */   }
/*     */ 
/*     */   public static synchronized String createFileName(String exts) {
/* 130 */     Date date = new Date();
/* 131 */     String fileName = getRandomString(8) + String.valueOf(date.getTime()) + "." + StringUtil.toLowerCase(exts);
/*     */ 
/* 133 */     return fileName;
/*     */   }
/*     */ 
/*     */   public synchronized String createFileNameOrg(String preName, String orgname, String backName) {
/* 137 */     int i = orgname.lastIndexOf(".");
/* 138 */     if (preName == null)
/* 139 */       preName = "";
/* 140 */     if (backName == null)
/* 141 */       backName = "";
/* 142 */     String fileName = "";
/* 143 */     if (i != -1) {
/* 144 */       fileName = preName + orgname.substring(0, i) + backName + StringUtil.toLowerCase(orgname.substring(i));
/*     */     }
/*     */     else {
/* 147 */       fileName = preName + orgname.substring(0, i) + backName;
/*     */     }
/* 149 */     return fileName;
/*     */   }
/*     */ 
/*     */   private static synchronized String getRandomString(int size) {
/* 153 */     char[] c = { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm' };
/*     */ 
/* 155 */     Random random = new Random(System.currentTimeMillis());
/* 156 */     StringBuffer sb = new StringBuffer();
/* 157 */     for (int i = 0; i < size; i++) {
/* 158 */       sb.append(c[(Math.abs(random.nextInt()) % c.length)]);
/*     */     }
/*     */ 
/* 161 */     double randtemp = Math.random();
/* 162 */     if (randtemp < 0.1D)
/* 163 */       randtemp += 0.1D;
/* 164 */     if (randtemp == 1.0D)
/* 165 */       randtemp -= 0.001D;
/* 166 */     long temp = Math.round(randtemp * 1000.0D);
/*     */ 
/* 168 */     return sb.toString() + temp;
/*     */   }
/*     */ 
/*     */   public static String getSubFileDir()
/*     */   {
/* 180 */     return DateUtil.getDateTime("yyyyMMdd", new Date());
/*     */   }
/*     */ 
/*     */   public synchronized String upload(File file, String fileFileName, String uploadSubPath)
/*     */     throws FileNotFoundException, IOException
/*     */   {
/* 195 */     String fileName = null;
/*     */ 
/* 197 */     String realPath = this.uploadRoot + "/" + uploadSubPath + "/";
/*     */ 
/* 199 */     File dirPath = new File(realPath);
/*     */ 
/* 201 */     if (!dirPath.exists()) {
/* 202 */       dirPath.mkdirs();
/*     */     }
/*     */ 
/* 205 */     String fileType = StringUtil.toLowerCase(fileFileName.substring(StringUtil.lastIndexOf(fileFileName, ".") + 1));
/*     */ 
/* 207 */     String randonFile = createFileName(fileType);
/*     */ 
/* 209 */     if (file.length() > 0L) {
/* 210 */       InputStream stream = new FileInputStream(file);
/*     */ 
/* 212 */       fileName = realPath + randonFile;
/* 213 */       OutputStream bos = new FileOutputStream(fileName);
/*     */ 
/* 215 */       byte[] buffer = new byte[8192];
/*     */       int bytesRead;
/* 216 */       while ((bytesRead = stream.read(buffer, 0, 8192)) != -1) {
/* 217 */         bos.write(buffer, 0, bytesRead);
/*     */       }
/*     */ 
/* 220 */       bos.close();
/* 221 */       stream.close();
/*     */     }
/* 223 */     return randonFile;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.common.FileUploadUtil
 * JD-Core Version:    0.6.0
 */