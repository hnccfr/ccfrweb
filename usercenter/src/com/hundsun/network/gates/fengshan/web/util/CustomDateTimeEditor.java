/*     */ package com.hundsun.network.gates.fengshan.web.util;
/*     */ 
/*     */ import java.beans.PropertyEditorSupport;
/*     */ import java.sql.Timestamp;
/*     */ import java.text.DateFormat;
/*     */ import java.text.ParseException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import org.springframework.util.StringUtils;
/*     */ 
/*     */ public class CustomDateTimeEditor extends PropertyEditorSupport
/*     */ {
/*     */   private DateFormat dateFormat_short;
/*     */   private DateFormat dateFormat_long;
/*  23 */   private int shortDateLength = 10;
/*     */   private boolean allowEmpty;
/*     */ 
/*     */   public CustomDateTimeEditor()
/*     */   {
/*  33 */     this.dateFormat_short = new SimpleDateFormat("yyyy-MM-dd");
/*  34 */     this.dateFormat_long = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*  35 */     this.allowEmpty = true;
/*     */   }
/*     */ 
/*     */   public CustomDateTimeEditor(DateFormat dateFormat_short, DateFormat dateFormat_long)
/*     */   {
/*  49 */     this.dateFormat_short = dateFormat_short;
/*  50 */     this.dateFormat_long = dateFormat_long;
/*  51 */     this.allowEmpty = true;
/*     */   }
/*     */ 
/*     */   public CustomDateTimeEditor(DateFormat dateFormat_short, DateFormat dateFormat_long, boolean allowEmpty)
/*     */   {
/*  67 */     this.dateFormat_short = dateFormat_short;
/*  68 */     this.dateFormat_long = dateFormat_long;
/*  69 */     this.allowEmpty = allowEmpty;
/*     */   }
/*     */ 
/*     */   public CustomDateTimeEditor(DateFormat dateFormat_short, DateFormat dateFormat_long, boolean allowEmpty, int shortDateLength)
/*     */   {
/*  89 */     this.dateFormat_short = dateFormat_short;
/*  90 */     this.dateFormat_long = dateFormat_long;
/*  91 */     this.allowEmpty = allowEmpty;
/*  92 */     this.shortDateLength = shortDateLength;
/*     */   }
/*     */ 
/*     */   public void setAsText(String text)
/*     */     throws IllegalArgumentException
/*     */   {
/* 100 */     text = text.trim();
/* 101 */     if ((this.allowEmpty) && (!StringUtils.hasText(text))) {
/* 102 */       setValue(null);
/* 103 */       return;
/*     */     }
/*     */     try {
/* 106 */       if (text.length() <= this.shortDateLength) {
/* 107 */         setValue(new java.sql.Date(this.dateFormat_short.parse(text).getTime()));
/*     */       }
/*     */       else
/* 110 */         setValue(new Timestamp(this.dateFormat_long.parse(text).getTime()));
/*     */     }
/*     */     catch (ParseException ex)
/*     */     {
/* 114 */       IllegalArgumentException iae = new IllegalArgumentException("Could not parse date: " + ex.getMessage());
/*     */ 
/* 116 */       iae.initCause(ex);
/* 117 */       throw iae;
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getAsText()
/*     */   {
/* 126 */     java.util.Date value = (java.util.Date)getValue();
/* 127 */     return value != null ? this.dateFormat_long.format(value) : "";
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.web.util.CustomDateTimeEditor
 * JD-Core Version:    0.6.0
 */