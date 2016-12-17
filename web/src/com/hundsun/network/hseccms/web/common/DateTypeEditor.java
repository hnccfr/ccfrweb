/*    */ package com.hundsun.network.hseccms.web.common;
/*    */ 
/*    */ import java.beans.PropertyEditorSupport;
/*    */ import java.sql.Timestamp;
/*    */ import java.text.DateFormat;
/*    */ import java.text.ParseException;
/*    */ import java.text.SimpleDateFormat;
/*    */ import org.springframework.util.StringUtils;
/*    */ 
/*    */ public class DateTypeEditor extends PropertyEditorSupport
/*    */ {
/* 20 */   public static final DateFormat DF_LONG = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*    */ 
/* 22 */   public static final DateFormat DF_SHORT = new SimpleDateFormat("yyyy-MM-dd");
/*    */   public static final int SHORT_DATE = 10;
/*    */ 
/*    */   public void setAsText(String text)
/*    */     throws IllegalArgumentException
/*    */   {
/* 29 */     text = text.trim();
/* 30 */     if (!StringUtils.hasText(text)) {
/* 31 */       setValue(null);
/* 32 */       return;
/*    */     }
/*    */     try {
/* 35 */       if (text.length() <= 10)
/* 36 */         setValue(new java.sql.Date(DF_SHORT.parse(text).getTime()));
/*    */       else
/* 38 */         setValue(new Timestamp(DF_LONG.parse(text).getTime()));
/*    */     }
/*    */     catch (ParseException ex) {
/* 41 */       IllegalArgumentException iae = new IllegalArgumentException("Could not parse date: " + ex.getMessage());
/*    */ 
/* 43 */       iae.initCause(ex);
/* 44 */       throw iae;
/*    */     }
/*    */   }
/*    */ 
/*    */   public String getAsText()
/*    */   {
/* 52 */     java.util.Date value = (java.util.Date)getValue();
/* 53 */     return value != null ? DF_LONG.format(value) : "";
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy13\cmsWeb\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.web.common.DateTypeEditor
 * JD-Core Version:    0.6.0
 */