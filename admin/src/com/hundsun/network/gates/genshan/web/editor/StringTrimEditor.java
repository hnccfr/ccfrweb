/*    */ package com.hundsun.network.gates.genshan.web.editor;
/*    */ 
/*    */ import java.beans.PropertyEditorSupport;
/*    */ 
/*    */ public class StringTrimEditor extends PropertyEditorSupport
/*    */ {
/*    */   public void setAsText(String text)
/*    */   {
/*  9 */     if (text == null) {
/* 10 */       setValue(null);
/*    */     } else {
/* 12 */       String value = text.trim();
/* 13 */       setValue(value);
/*    */     }
/*    */   }
/*    */ 
/*    */   public String getAsText()
/*    */   {
/* 19 */     Object value = getValue();
/* 20 */     return value != null ? value.toString() : "";
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.editor.StringTrimEditor
 * JD-Core Version:    0.6.0
 */