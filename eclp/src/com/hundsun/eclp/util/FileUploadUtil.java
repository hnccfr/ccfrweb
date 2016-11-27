/*     */ package com.hundsun.eclp.util;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.util.Date;
/*     */ import java.util.Random;
/*     */ import org.apache.commons.lang.StringUtils;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ import org.springframework.web.multipart.MultipartFile;
/*     */ 
/*     */ public class FileUploadUtil
/*     */ {
/*  26 */   private Log log = LogFactory.getLog(getClass());
/*     */   public static final String SEP = "/";
/*     */   public static final String POINT = ".";
/*  29 */   public static final String[] EXTARRAY = { "jpg", "jpeg", "gif", "png" };
/*     */   public String fileUploadDir;
/*     */   public static final int MAX_FILE_SIZE = 204800;
/*     */   public static final String CRM_PIC_PATH = "000000";
/*     */   public static final String UNLOGIN_USER_PIC_PATH = "posgoo";
/*     */   public static final String SHOP_FILE_HOME_DIR = "shop";
/*     */   public static final String ACTIVITY_FILE_HOME_DIR = "activity";
/*     */   public static final String COMPANY_LICENSE_HOME_DIR = "company";
/*     */   public static final String GOODS_FILE_HOME_DIR = "goods";
/*     */   public static final String BRAND_FILE_HOME_DIR = "brand";
/*     */   public static final String CATEGORY_FILE_HOME_DIR = "category";
/*     */   public static final String CABINET_FILE_HOME_DIR = "cabinet";
/*     */   public static final String AD_MEDIACODE = "advertisement";
/*     */   public static final String DIYCARD_FILE_HOME_DIR = "diycard";
/*     */   public static final String SYSTEM_LOGO_DIR = "logo";
/*     */   public static final String SUB_SYSTEM_LOGO_DIR = "subsys_logo";
/*     */ 
/*     */   public static boolean ifFileSizePermitted(MultipartFile file)
/*     */   {
/*  96 */     return file.getSize() < 204800L;
/*     */   }
/*     */ 
/*     */   public static boolean ifExtendNamePermitted(MultipartFile file)
/*     */   {
/* 105 */     String orgFileName = file.getOriginalFilename();
/* 106 */     if (StringUtils.isBlank(orgFileName))
/*     */     {
/* 108 */       return true;
/*     */     }
/* 110 */     String exts = orgFileName.substring(orgFileName.lastIndexOf(".") + 1, orgFileName.length());
/* 111 */     return ifExtendNamePermitted(exts);
/*     */   }
/*     */ 
/*     */   public static boolean ifExtendNamePermitted(String exts) {
/* 115 */     for (String s : EXTARRAY) {
/* 116 */       if (exts.equalsIgnoreCase(s)) {
/* 117 */         return true;
/*     */       }
/*     */     }
/* 120 */     return false;
/*     */   }
/*     */ 
/*     */   public String uploadFile(MultipartFile file, String userId, String destDir) {
/* 124 */     if (StringUtils.isBlank(userId)) {
/* 125 */       return uploadFile(file, "posgoo/" + destDir);
/*     */     }
/* 127 */     return uploadFile(file, userId + "/" + destDir);
/*     */   }
/*     */ 
/*     */   public String uploadFile(MultipartFile file, String destDir)
/*     */   {
/* 137 */     String filePath = "";
/* 138 */     if ((file == null) || (StringUtils.isEmpty(file.getOriginalFilename()))) {
/* 139 */       return filePath;
/*     */     }
/*     */ 
/* 142 */     String orgFileName = file.getOriginalFilename();
/* 143 */     String exts = orgFileName.substring(orgFileName.lastIndexOf(".") + 1, orgFileName.length());
/*     */ 
/* 145 */     if (!ifExtendNamePermitted(exts))
/*     */     {
/* 147 */       return filePath;
/*     */     }
/*     */ 
/* 150 */     String newFileName = createFileName(exts);
/* 151 */     String saveDir = this.fileUploadDir + "/" + destDir + "/" + getSubFileDir();
/*     */     try
/*     */     {
/* 154 */       saveFile(file, saveDir, newFileName);
/*     */     } catch (IOException e) {
/* 156 */       this.log.error("FileUploadUtil.uploadFile", e);
/*     */     }
/* 158 */     filePath = destDir + "/" + getSubFileDir() + "/" + newFileName;
/* 159 */     return filePath;
/*     */   }
/*     */ 
/*     */   private static void saveFile(MultipartFile file, String destDir, String newFileName) throws IOException {
/* 163 */     if (!new File(destDir).exists()) {
/* 164 */       new File(destDir).mkdirs();
/*     */     }
/* 166 */     file.transferTo(new File(destDir + "/" + newFileName));
/*     */   }
/*     */ 
/*     */   public static synchronized String createFileName(String exts) {
/* 170 */     Date date = new Date();
/* 171 */     String fileName = getRandomString(8) + String.valueOf(date.getTime()) + "." + StringUtil.toLowerCase(exts);
/*     */ 
/* 173 */     return fileName;
/*     */   }
/*     */ 
/*     */   public synchronized String createFileNameOrg(String preName, String orgname, String backName)
/*     */   {
/* 178 */     int i = orgname.lastIndexOf(".");
/* 179 */     if (preName == null)
/* 180 */       preName = "";
/* 181 */     if (backName == null)
/* 182 */       backName = "";
/* 183 */     String fileName = "";
/* 184 */     if (i != -1) {
/* 185 */       fileName = preName + orgname.substring(0, i) + backName + StringUtil.toLowerCase(orgname.substring(i));
/*     */     }
/*     */     else {
/* 188 */       fileName = preName + orgname.substring(0, i) + backName;
/*     */     }
/* 190 */     return fileName;
/*     */   }
/*     */ 
/*     */   private static synchronized String getRandomString(int size) {
/* 194 */     char[] c = { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm' };
/*     */ 
/* 196 */     Random random = new Random(System.currentTimeMillis());
/* 197 */     StringBuffer sb = new StringBuffer();
/* 198 */     for (int i = 0; i < size; i++) {
/* 199 */       sb.append(c[(Math.abs(random.nextInt()) % c.length)]);
/*     */     }
/*     */ 
/* 202 */     double randtemp = Math.random();
/* 203 */     if (randtemp < 0.1D)
/* 204 */       randtemp += 0.1D;
/* 205 */     if (randtemp == 1.0D)
/* 206 */       randtemp -= 0.001D;
/* 207 */     long temp = Math.round(randtemp * 1000.0D);
/*     */ 
/* 209 */     return sb.toString() + temp;
/*     */   }
/*     */ 
/*     */   public String getFileUploadDir() {
/* 213 */     return this.fileUploadDir;
/*     */   }
/*     */ 
/*     */   public void setFileUploadDir(String fileUploadDir) {
/* 217 */     this.fileUploadDir = fileUploadDir;
/*     */   }
/*     */ 
/*     */   public static String getSubFileDir() {
/* 221 */     return DateUtil.getDateTime("yyyyMMdd", new Date());
/*     */   }
/*     */ 
/*     */   public synchronized String upload(File file, String fileFileName, String uploadSubPath)
/*     */     throws FileNotFoundException, IOException
/*     */   {
/* 235 */     String fileName = null;
/*     */ 
/* 237 */     String realPath = this.fileUploadDir + "/" + uploadSubPath + "/";
/*     */ 
/* 239 */     File dirPath = new File(realPath);
/*     */ 
/* 241 */     if (!dirPath.exists()) {
/* 242 */       dirPath.mkdirs();
/*     */     }
/*     */ 
/* 245 */     String fileType = StringUtil.toLowerCase(fileFileName.substring(StringUtil.lastIndexOf(fileFileName, ".") + 1));
/*     */ 
/* 247 */     String randonFile = createFileName(fileType);
/*     */ 
/* 249 */     if (file.length() > 0L) {
/* 250 */       InputStream stream = new FileInputStream(file);
/*     */ 
/* 252 */       fileName = realPath + randonFile;
/* 253 */       OutputStream bos = new FileOutputStream(fileName);
/*     */ 
/* 255 */       byte[] buffer = new byte[8192];
/*     */       int bytesRead;
/* 256 */       while ((bytesRead = stream.read(buffer, 0, 8192)) != -1) {
/* 257 */         bos.write(buffer, 0, bytesRead);
/*     */       }
/*     */ 
/* 260 */       bos.close();
/* 261 */       stream.close();
/*     */     }
/* 263 */     return randonFile;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.util.FileUploadUtil
 * JD-Core Version:    0.6.0
 */