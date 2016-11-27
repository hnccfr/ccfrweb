/*    */ package com.hundsun.network.gates.genshan.biz.domain.common;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import org.springframework.web.multipart.MultipartFile;
/*    */ 
/*    */ public class KindEditorAjaxRequest
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 2228772103935029802L;
/*    */   private MultipartFile imgFile;
/*    */   private String localUrl;
/*    */   private String width;
/*    */   private String height;
/*    */   private String align;
/*    */   private String title;
/*    */ 
/*    */   public MultipartFile getImgFile()
/*    */   {
/* 42 */     return this.imgFile;
/*    */   }
/*    */ 
/*    */   public void setImgFile(MultipartFile imgFile) {
/* 46 */     this.imgFile = imgFile;
/*    */   }
/*    */ 
/*    */   public String getLocalUrl() {
/* 50 */     return this.localUrl;
/*    */   }
/*    */ 
/*    */   public void setLocalUrl(String localUrl) {
/* 54 */     this.localUrl = localUrl;
/*    */   }
/*    */ 
/*    */   public String getWidth() {
/* 58 */     return this.width;
/*    */   }
/*    */ 
/*    */   public void setWidth(String width) {
/* 62 */     this.width = width;
/*    */   }
/*    */ 
/*    */   public String getHeight() {
/* 66 */     return this.height;
/*    */   }
/*    */ 
/*    */   public void setHeight(String height) {
/* 70 */     this.height = height;
/*    */   }
/*    */ 
/*    */   public String getAlign() {
/* 74 */     return this.align;
/*    */   }
/*    */ 
/*    */   public void setAlign(String align) {
/* 78 */     this.align = align;
/*    */   }
/*    */ 
/*    */   public String getTitle() {
/* 82 */     return this.title;
/*    */   }
/*    */ 
/*    */   public void setTitle(String title) {
/* 86 */     this.title = title;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.common.KindEditorAjaxRequest
 * JD-Core Version:    0.6.0
 */