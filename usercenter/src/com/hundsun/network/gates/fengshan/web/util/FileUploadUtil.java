/*     */ package com.hundsun.network.gates.fengshan.web.util;
/*     */ 
/*     */ import com.hundsun.network.melody.common.util.DateUtil;
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
/*  23 */   private Log log = LogFactory.getLog(getClass());
/*     */   public static final String SEP = "/";
/*     */   public static final String POINT = ".";
/*  26 */   public static String[] EXTARRAY = { "jpg", "jpeg", "gif", "png" };
/*     */ 
/*     */   @Value("${upload.root}")
/*     */   public String uploadRoot;
/*  31 */   public static int MAX_FILE_SIZE = 3145728;
/*     */   public static final String CRM_PIC_PATH = "000000";
/*     */ 
/*     */   @Value("${upload.root.licence.url.path}")
/*     */   public String uploadUrl;
/*     */   public static final String MEMLEVEL_FILE_HOME_DIR = "memlevel";
/*     */   public static final String USERCREDIT_FILE_HOME_DIR = "usercredit";
/*     */ 
/*     */   public static boolean ifFileSizePermitted(MultipartFile file)
/*     */   {
/*  57 */     return file.getSize() < MAX_FILE_SIZE;
/*     */   }
/*     */ 
/*     */   public static boolean ifExtendNamePermitted(MultipartFile file)
/*     */   {
/*  66 */     String orgFileName = file.getOriginalFilename();
/*  67 */     if (StringUtil.isBlank(orgFileName))
/*     */     {
/*  69 */       return true;
/*     */     }
/*  71 */     String exts = orgFileName.substring(orgFileName.lastIndexOf(".") + 1, orgFileName.length());
/*  72 */     return ifExtendNamePermitted(exts);
/*     */   }
/*     */ 
/*     */   public static boolean ifExtendNamePermitted(String exts) {
/*  76 */     for (String s : EXTARRAY) {
/*  77 */       if (exts.equalsIgnoreCase(s)) {
/*  78 */         return true;
/*     */       }
/*     */     }
/*  81 */     return false;
/*     */   }
/*     */ 
/*     */   public String uploadFile(MultipartFile file, String userId, String destDir) {
/*  85 */     if (StringUtil.isBlank(userId)) {
/*  86 */       return uploadFile(file, this.uploadUrl + "/" + destDir);
/*     */     }
/*  88 */     return uploadFile(file, userId + "/" + destDir);
/*     */   }
/*     */ 
/*     */   public String uploadFile(MultipartFile file, String destDir)
/*     */   {
/*  98 */     String filePath = "";
/*  99 */     if ((file == null) || (StringUtil.isEmpty(file.getOriginalFilename()))) {
/* 100 */       return filePath;
/*     */     }
/*     */ 
/* 103 */     String orgFileName = file.getOriginalFilename();
/* 104 */     String exts = orgFileName.substring(orgFileName.lastIndexOf(".") + 1, orgFileName.length());
/*     */ 
/* 106 */     if (!ifExtendNamePermitted(exts))
/*     */     {
/* 108 */       return filePath;
/*     */     }
/*     */ 
/* 111 */     String newFileName = createFileName(exts);
/* 112 */     String saveDir = this.uploadRoot + "/" + destDir + "/" + getSubFileDir();
/*     */     try {
/* 114 */       saveFile(file, saveDir, newFileName);
/*     */     } catch (IOException e) {
/* 116 */       this.log.error("FileUploadUtil.uploadFile", e);
/*     */     }
/* 118 */     filePath = destDir + "/" + getSubFileDir() + "/" + newFileName;
/* 119 */     return filePath;
/*     */   }
/*     */ 
/*     */   private static void saveFile(MultipartFile file, String destDir, String newFileName) throws IOException
/*     */   {
/* 124 */     if (!new File(destDir).exists()) {
/* 125 */       new File(destDir).mkdirs();
/*     */     }
/* 127 */     file.transferTo(new File(destDir + "/" + newFileName));
/*     */   }
/*     */ 
/*     */   public static synchronized String createFileName(String exts) {
/* 131 */     Date date = new Date();
/* 132 */     String fileName = getRandomString(8) + String.valueOf(date.getTime()) + "." + StringUtil.toLowerCase(exts);
/*     */ 
/* 134 */     return fileName;
/*     */   }
/*     */ 
/*     */   public synchronized String createFileNameOrg(String preName, String orgname, String backName) {
/* 138 */     int i = orgname.lastIndexOf(".");
/* 139 */     if (preName == null)
/* 140 */       preName = "";
/* 141 */     if (backName == null)
/* 142 */       backName = "";
/* 143 */     String fileName = "";
/* 144 */     if (i != -1) {
/* 145 */       fileName = preName + orgname.substring(0, i) + backName + StringUtil.toLowerCase(orgname.substring(i));
/*     */     }
/*     */     else {
/* 148 */       fileName = preName + orgname.substring(0, i) + backName;
/*     */     }
/* 150 */     return fileName;
/*     */   }
/*     */ 
/*     */   private static synchronized String getRandomString(int size) {
/* 154 */     char[] c = { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm' };
/*     */ 
/* 156 */     Random random = new Random(System.currentTimeMillis());
/* 157 */     StringBuffer sb = new StringBuffer();
/* 158 */     for (int i = 0; i < size; i++) {
/* 159 */       sb.append(c[(Math.abs(random.nextInt()) % c.length)]);
/*     */     }
/*     */ 
/* 162 */     double randtemp = Math.random();
/* 163 */     if (randtemp < 0.1D)
/* 164 */       randtemp += 0.1D;
/* 165 */     if (randtemp == 1.0D)
/* 166 */       randtemp -= 0.001D;
/* 167 */     long temp = Math.round(randtemp * 1000.0D);
/*     */ 
/* 169 */     return sb.toString() + temp;
/*     */   }
/*     */ 
/*     */   public static String getSubFileDir()
/*     */   {
/* 181 */     return DateUtil.getDateTime("yyyyMMdd", new Date());
/*     */   }
/*     */ 
/*     */   public synchronized String upload(File file, String fileFileName, String uploadSubPath)
/*     */     throws FileNotFoundException, IOException
/*     */   {
/* 196 */     String fileName = null;
/*     */ 
/* 198 */     String realPath = this.uploadRoot + "/" + uploadSubPath + "/";
/*     */ 
/* 200 */     File dirPath = new File(realPath);
/*     */ 
/* 202 */     if (!dirPath.exists()) {
/* 203 */       dirPath.mkdirs();
/*     */     }
/*     */ 
/* 206 */     String fileType = StringUtil.toLowerCase(fileFileName.substring(StringUtil.lastIndexOf(fileFileName, ".") + 1));
/*     */ 
/* 208 */     String randonFile = createFileName(fileType);
/*     */ 
/* 210 */     if (file.length() > 0L) {
/* 211 */       InputStream stream = new FileInputStream(file);
/*     */ 
/* 213 */       fileName = realPath + randonFile;
/* 214 */       OutputStream bos = new FileOutputStream(fileName);
/*     */ 
/* 216 */       byte[] buffer = new byte[8192];
/*     */       int bytesRead;
/* 217 */       while ((bytesRead = stream.read(buffer, 0, 8192)) != -1) {
/* 218 */         bos.write(buffer, 0, bytesRead);
/*     */       }
/*     */ 
/* 221 */       bos.close();
/* 222 */       stream.close();
/*     */     }
/* 224 */     return randonFile;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.web.util.FileUploadUtil
 * JD-Core Version:    0.6.0
 */