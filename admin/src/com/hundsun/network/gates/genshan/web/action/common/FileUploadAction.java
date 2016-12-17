/*     */ package com.hundsun.network.gates.genshan.web.action.common;
/*     */ 
/*     */ import com.hundsun.network.melody.common.util.ShortUUIDGenerator;
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.commons.httpclient.util.DateUtil;
/*     */ import org.apache.commons.io.IOUtils;
/*     */ import org.apache.velocity.texen.util.FileUtil;
/*     */ import org.springframework.beans.factory.annotation.Value;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ 
/*     */ @Controller
/*     */ public class FileUploadAction
/*     */ {
/*     */   private static final long serialVersionUID = 6748857432950840322L;
/*     */ 
/*     */   @Value("${upload.root}")
/*     */   private String uploadRoot;
/*     */ 
/*     */   @Value("${upload.root.licence.url.path}")
/*     */   private String uploadUrl;
/*     */ 
/*     */   @RequestMapping({"ajaxFileUpload/upload"})
/*     */   @ResponseBody
/*     */   public HashMap<String, Object> upload(HttpServletRequest request)
/*     */     throws IOException
/*     */   {
/*  51 */     InputStream is = null;
/*  52 */     FileOutputStream fos = null;
/*  53 */     HashMap returnMap = new HashMap();
/*     */ 
/*  55 */     String filename = request.getHeader("X-File-Name");
/*  56 */     String imgExt = filename.substring(filename.lastIndexOf(".") + 1);
/*  57 */     String pathPart = DateUtil.formatDate(new Date(), "/yyyy/MM/dd/");
/*  58 */     String fileName = ShortUUIDGenerator.randomUUID() + "." + imgExt;
/*  59 */     StringBuffer imgPath = new StringBuffer();
/*  60 */     StringBuffer contextPath = new StringBuffer();
/*  61 */     imgPath.append(this.uploadRoot);
/*  62 */     contextPath.append(this.uploadUrl);
/*  63 */     imgPath.append(pathPart);
/*  64 */     contextPath.append(pathPart);
/*  65 */     FileUtil.mkdir(imgPath.toString());
/*  66 */     imgPath.append(fileName);
/*  67 */     contextPath.append(fileName);
/*     */     try {
/*  69 */       is = request.getInputStream();
/*  70 */       fos = new FileOutputStream(new File(imgPath.toString()));
/*  71 */       IOUtils.copy(is, fos);
/*  72 */       returnMap.put("success", "true");
/*  73 */       returnMap.put("backUrl", contextPath);
/*     */     }
/*     */     catch (FileNotFoundException ignored)
/*     */     {
/*  79 */       returnMap.put("success", "false");
/*  80 */       returnMap.put("backUrl", contextPath);
/*     */     }
/*     */     catch (IOException ignored) {
/*  83 */       returnMap.put("success", "false");
/*  84 */       returnMap.put("backUrl", contextPath);
/*     */     }
/*     */     finally
/*     */     {
/*     */       try
/*     */       {
/*  90 */         fos.close();
/*  91 */         is.close();
/*     */       } catch (IOException ignored) {
/*     */       }
/*     */     }
/*  95 */     return returnMap;
/*     */   }
/*     */ 
/*     */   public void SaveFileFromInputStream(InputStream stream, String path, String filename)
/*     */     throws IOException
/*     */   {
/* 109 */     FileOutputStream fs = new FileOutputStream(path + "/" + filename);
/* 110 */     byte[] buffer = new byte[1048576];
/* 111 */     int bytesum = 0;
/* 112 */     int byteread = 0;
/* 113 */     while ((byteread = stream.read(buffer)) != -1) {
/* 114 */       bytesum += byteread;
/* 115 */       fs.write(buffer, 0, byteread);
/* 116 */       fs.flush();
/*     */     }
/* 118 */     fs.close();
/* 119 */     stream.close();
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.action.common.FileUploadAction
 * JD-Core Version:    0.6.0
 */