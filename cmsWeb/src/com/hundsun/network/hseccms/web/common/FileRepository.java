/*    */ package com.hundsun.network.hseccms.web.common;
/*    */ 
/*    */ import com.hundsun.network.hseccms.util.editor.UploadUtils;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import org.apache.commons.io.FileUtils;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ import org.springframework.web.multipart.MultipartFile;
/*    */ 
/*    */ public class FileRepository
/*    */ {
/* 19 */   private Logger log = LoggerFactory.getLogger(FileRepository.class);
/*    */   private String uploadResource;
/*    */ 
/*    */   public String getUploadResource()
/*    */   {
/* 23 */     return this.uploadResource;
/*    */   }
/*    */ 
/*    */   public void setUploadResource(String uploadResource) {
/* 27 */     this.uploadResource = uploadResource;
/*    */   }
/*    */ 
/*    */   public String storeByExt(String path, String ext, MultipartFile file) throws IOException {
/* 31 */     String filename = UploadUtils.generateFilename(path, ext);
/* 32 */     File dest = new File(getRealPath(filename));
/* 33 */     dest = UploadUtils.getUniqueFile(dest);
/* 34 */     store(file, dest);
/* 35 */     return filename;
/*    */   }
/*    */ 
/*    */   public String storeByFilename(String filename, MultipartFile file) throws IOException {
/* 39 */     File dest = new File(getRealPath(filename));
/* 40 */     store(file, dest);
/* 41 */     return filename;
/*    */   }
/*    */ 
/*    */   public String storeByExt(String path, String ext, File file) throws IOException {
/* 45 */     String filename = UploadUtils.generateFilename(path, ext);
/* 46 */     File dest = new File(getRealPath(filename));
/* 47 */     dest = UploadUtils.getUniqueFile(dest);
/* 48 */     store(file, dest);
/* 49 */     return filename;
/*    */   }
/*    */ 
/*    */   public String storeByFilename(String filename, File file) throws IOException {
/* 53 */     File dest = new File(getRealPath(filename));
/* 54 */     store(file, dest);
/* 55 */     return filename;
/*    */   }
/*    */ 
/*    */   private void store(MultipartFile file, File dest) throws IOException {
/*    */     try {
/* 60 */       UploadUtils.checkDirAndCreate(dest.getParentFile());
/* 61 */       file.transferTo(dest);
/*    */     } catch (IOException e) {
/* 63 */       this.log.error("Transfer file error when upload file", e);
/* 64 */       throw e;
/*    */     }
/*    */   }
/*    */ 
/*    */   private void store(File file, File dest) throws IOException {
/*    */     try {
/* 70 */       UploadUtils.checkDirAndCreate(dest.getParentFile());
/* 71 */       FileUtils.copyFile(file, dest);
/*    */     } catch (IOException e) {
/* 73 */       this.log.error("Transfer file error when upload file", e);
/* 74 */       throw e;
/*    */     }
/*    */   }
/*    */ 
/*    */   public File retrieve(String name) {
/* 79 */     return new File(getRealPath(name));
/*    */   }
/*    */ 
/*    */   private String getRealPath(String path) {
/* 83 */     if (path == null) {
/* 84 */       return path;
/*    */     }
/* 86 */     return this.uploadResource + "/" + path;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy13\cmsWeb\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.web.common.FileRepository
 * JD-Core Version:    0.6.0
 */