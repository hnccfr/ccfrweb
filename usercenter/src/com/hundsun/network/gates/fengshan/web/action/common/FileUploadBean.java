/*    */ package com.hundsun.network.gates.fengshan.web.action.common;
/*    */ 
/*    */ import org.springframework.web.multipart.MultipartFile;
/*    */ 
/*    */ public class FileUploadBean
/*    */ {
/*    */   private MultipartFile file;
/*    */ 
/*    */   public void setFile(MultipartFile file)
/*    */   {
/* 21 */     this.file = file;
/*    */   }
/*    */ 
/*    */   public MultipartFile getFile() {
/* 25 */     return this.file;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.web.action.common.FileUploadBean
 * JD-Core Version:    0.6.0
 */