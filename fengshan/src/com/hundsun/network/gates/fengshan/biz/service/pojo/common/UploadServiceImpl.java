/*     */ package com.hundsun.network.gates.fengshan.biz.service.pojo.common;
/*     */ 
/*     */ import com.hundsun.network.gates.fengshan.biz.service.BaseService;
/*     */ import com.hundsun.network.gates.fengshan.biz.service.common.UploadService;
/*     */ import com.hundsun.network.gates.luosi.common.utils.CommonUtils;
/*     */ import com.hundsun.network.melody.common.util.ShortUUIDGenerator;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
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
/*  48 */     StringBuffer imgPath = new StringBuffer();
/*  49 */     StringBuffer contextPath = new StringBuffer();
/*     */ 
/*  51 */     String pathPart = DateUtil.formatDate(new Date(), "/yyyy/MM/dd/");
/*  52 */     String fileName = ShortUUIDGenerator.randomUUID() + "." + imgExt;
/*  53 */     imgPath.append(this.uploadRoot);
/*  54 */     contextPath.append(this.uploadUrl);
/*  55 */     imgPath.append(pathPart);
/*  56 */     contextPath.append(pathPart);
/*  57 */     FileUtil.mkdir(imgPath.toString());
/*  58 */     imgPath.append(fileName);
/*  59 */     contextPath.append(fileName);
/*  60 */     if (writeFile(input, imgPath.toString())) {
/*  61 */       return contextPath.toString();
/*     */     }
/*  63 */     return null;
/*     */   }
/*     */ 
/*     */   public String uploadFile(String modelName, InputStream input, String imgExt)
/*     */   {
/*  76 */     StringBuffer imgPath = new StringBuffer();
/*  77 */     StringBuffer contextPath = new StringBuffer();
/*     */ 
/*  79 */     String pathPart = DateUtil.formatDate(new Date(), "/yyyy/MM/dd/");
/*  80 */     String fileName = ShortUUIDGenerator.randomUUID() + "." + imgExt;
/*  81 */     imgPath.append(this.uploadRoot);
/*  82 */     contextPath.append(this.uploadUrl);
/*  83 */     if (StringUtil.isNotEmpty(modelName))
/*     */     {
/*  86 */       imgPath.append("/" + modelName);
/*  87 */       contextPath.append("/" + modelName);
/*     */     }
/*  89 */     imgPath.append(pathPart);
/*  90 */     contextPath.append(pathPart);
/*  91 */     FileUtil.mkdir(imgPath.toString());
/*  92 */     imgPath.append(fileName);
/*  93 */     contextPath.append(fileName);
/*  94 */     if (writeFile(input, imgPath.toString())) {
/*  95 */       return contextPath.toString();
/*     */     }
/*  97 */     return null;
/*     */   }
/*     */ 
/*     */   public String uploadFile(MultipartFile file)
/*     */   {
/* 110 */     if (null == file) {
/* 111 */       this.log.error("uploadFile fail, file is null");
/* 112 */       return null;
/*     */     }
/*     */     try {
/* 115 */       return uploadFile(file.getInputStream(), CommonUtils.getFileSuffix(file.getOriginalFilename()));
/*     */     }
/*     */     catch (IOException e) {
/* 118 */       this.log.error("uploadFile fail", e);
/* 119 */     }return null;
/*     */   }
/*     */ 
/*     */   private boolean writeFile(InputStream input, String filePath)
/*     */   {
/*     */     try
/*     */     {
/* 132 */       if (null == input) {
/* 133 */         this.log.error("Parameter (InputStream in) is null!");
/* 134 */         return false;
/*     */       }
/* 136 */       FileOutputStream output = new FileOutputStream(filePath);
/* 137 */       ByteArrayOutputStream data = new ByteArrayOutputStream();
/* 138 */       int num = 0;
/* 139 */       byte[] buffer = new byte[1024];
/* 140 */       while ((num = input.read(buffer)) > 0) {
/* 141 */         data.write(buffer, 0, num);
/* 142 */         output.write(buffer);
/*     */       }
/* 144 */       output.close();
/* 145 */       return true;
/*     */     } catch (Exception e) {
/* 147 */       this.log.error("upload file error", e);
/* 148 */     }return false;
/*     */   }
/*     */ 
/*     */   public boolean deleteOriginalFile(String filePath)
/*     */   {
/* 161 */     StringBuffer sb = new StringBuffer();
/*     */ 
/* 163 */     sb.append(this.uploadRoot.substring(0, this.uploadRoot.length() - this.uploadUrl.length()));
/* 164 */     sb.append(filePath);
/* 165 */     File file = new File(sb.toString());
/* 166 */     if (file.exists()) {
/*     */       try {
/* 168 */         file.delete();
/* 169 */         return true;
/*     */       } catch (Exception e) {
/* 171 */         this.log.error("delete originalFile error, cause by:" + e);
/* 172 */         return false;
/*     */       }
/*     */     }
/* 175 */     this.log.debug("warning:the original file is not deleted, file name is:" + filePath);
/* 176 */     return true;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.service.pojo.common.UploadServiceImpl
 * JD-Core Version:    0.6.0
 */