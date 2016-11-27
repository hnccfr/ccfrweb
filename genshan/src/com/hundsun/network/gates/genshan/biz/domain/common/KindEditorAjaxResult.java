/*    */ package com.hundsun.network.gates.genshan.biz.domain.common;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public class KindEditorAjaxResult
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 4822249603425060684L;
/*    */   private int error;
/*    */   private String url;
/*    */   private String message;
/*    */ 
/*    */   public int getError()
/*    */   {
/* 25 */     return this.error;
/*    */   }
/*    */ 
/*    */   public void setError(int error) {
/* 29 */     this.error = error;
/*    */   }
/*    */ 
/*    */   public String getUrl() {
/* 33 */     return this.url;
/*    */   }
/*    */ 
/*    */   public void setUrl(String url) {
/* 37 */     this.url = url;
/*    */   }
/*    */ 
/*    */   public String getMessage() {
/* 41 */     return this.message;
/*    */   }
/*    */ 
/*    */   public void setMessage(String message) {
/* 45 */     this.message = message;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.common.KindEditorAjaxResult
 * JD-Core Version:    0.6.0
 */