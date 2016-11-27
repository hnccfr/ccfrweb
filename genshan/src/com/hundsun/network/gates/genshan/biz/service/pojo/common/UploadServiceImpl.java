/*     */ package com.hundsun.network.gates.genshan.biz.service.pojo.common;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.service.BaseService;
/*     */ import com.hundsun.network.gates.genshan.biz.service.common.UploadService;
/*     */ import com.hundsun.network.gates.luosi.common.utils.CommonUtils;
/*     */ import com.hundsun.network.melody.common.util.ShortUUIDGenerator;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.Date;
/*     */ import org.apache.commons.httpclient.util.DateUtil;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.velocity.texen.util.FileUtil;
/*     */ import org.springframework.beans.factory.annotation.Value;
/*     */ import org.springframework.stereotype.Service;
/*     */ import org.springframework.web.multipart.MultipartFile;
/*     */ 
/*     */ @Service("uploadService")
/*     */ public class UploadServiceImpl extends BaseService
/*     */   implements UploadService
/*     */ {
/*     */ 
/*     */   @Value("${upload.root}")
/*     */   private String uploadRoot;
/*     */ 
/*     */   @Value("${upload.root.licence.url.path}")
/*     */   private String uploadUrl;
/*     */ 
/*     */   public String uploadFile(InputStream input, String imgExt)
/*     */   {
/*  44 */     StringBuffer imgPath = new StringBuffer();
/*  45 */     StringBuffer contextPath = new StringBuffer();
/*     */ 
/*  47 */     String pathPart = DateUtil.formatDate(new Date(), "/yyyy/MM/dd/");
/*  48 */     String fileName = ShortUUIDGenerator.randomUUID() + "." + imgExt;
/*  49 */     imgPath.append(this.uploadRoot);
/*  50 */     contextPath.append(this.uploadUrl);
/*  51 */     imgPath.append(pathPart);
/*  52 */     contextPath.append(pathPart);
/*  53 */     FileUtil.mkdir(imgPath.toString());
/*  54 */     imgPath.append(fileName);
/*  55 */     contextPath.append(fileName);
/*  56 */     if (writeFile(input, imgPath.toString())) {
/*  57 */       return contextPath.toString();
/*     */     }
/*  59 */     return null;
/*     */   }
/*     */ 
/*     */   public String uploadFile(MultipartFile file)
/*     */   {
/*  71 */     if (null == file) {
/*  72 */       this.log.error("uploadFile fail, file is null");
/*  73 */       return null;
/*     */     }
/*     */     try {
/*  76 */       return uploadFile(file.getInputStream(), CommonUtils.getFileSuffix(file.getOriginalFilename()));
/*     */     }
/*     */     catch (IOException e) {
/*  79 */       this.log.error("uploadFile fail", e);
/*  80 */     }return null;
/*     */   }
/*     */ 
/*     */   private boolean writeFile(InputStream input, String filePath)
/*     */   {
/*     */     try
/*     */     {
/*  92 */       if (null == input) {
/*  93 */         this.log.error("Parameter (InputStream in) is null!");
/*  94 */         return false;
/*     */       }
/*  96 */       FileOutputStream output = new FileOutputStream(filePath);
/*  97 */       ByteArrayOutputStream data = new ByteArrayOutputStream();
/*  98 */       int num = 0;
/*  99 */       byte[] buffer = new byte[1024];
/* 100 */       while ((num = input.read(buffer)) > 0) {
/* 101 */         data.write(buffer, 0, num);
/* 102 */         output.write(buffer);
/*     */       }
/* 104 */       output.close();
/* 105 */       return true;
/*     */     } catch (Exception e) {
/* 107 */       this.log.error("upload file error", e);
/* 108 */     }return false;
/*     */   }
/*     */ 
/*     */   public boolean deleteOriginalFile(String filePath)
/*     */   {
/* 113 */     StringBuffer sb = new StringBuffer();
/*     */ 
/* 115 */     sb.append(this.uploadRoot.substring(0, this.uploadRoot.length() - this.uploadUrl.length()));
/* 116 */     sb.append(filePath);
/* 117 */     File file = new File(sb.toString());
/* 118 */     if (file.exists()) {
/*     */       try {
/* 120 */         file.delete();
/* 121 */         return true;
/*     */       } catch (Exception e) {
/* 123 */         this.log.error("delete originalFile error, cause by:" + e);
/* 124 */         return false;
/*     */       }
/*     */     }
/* 127 */     this.log.debug("warning:the original file is not deleted, file name is:" + filePath);
/* 128 */     return true;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.service.pojo.common.UploadServiceImpl
 * JD-Core Version:    0.6.0
 */