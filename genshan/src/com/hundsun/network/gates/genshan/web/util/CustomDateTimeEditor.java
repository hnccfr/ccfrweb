/*     */ package com.hundsun.network.gates.genshan.web.util;
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
/*     */   private DateFormat dateFormat_yearMonth;
/*  24 */   private int yearMonthLength = 7;
/*  25 */   private int shortDateLength = 10;
/*     */   private boolean allowEmpty;
/*     */ 
/*     */   public CustomDateTimeEditor()
/*     */   {
/*  35 */     this.dateFormat_short = new SimpleDateFormat("yyyy-MM-dd");
/*  36 */     this.dateFormat_long = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*  37 */     this.allowEmpty = true;
/*     */   }
/*     */ 
/*     */   public CustomDateTimeEditor(DateFormat dateFormat_short, DateFormat dateFormat_long)
/*     */   {
/*  51 */     this.dateFormat_short = dateFormat_short;
/*  52 */     this.dateFormat_long = dateFormat_long;
/*  53 */     this.allowEmpty = true;
/*     */   }
/*     */ 
/*     */   public CustomDateTimeEditor(DateFormat dateFormat_short, DateFormat dateFormat_long, DateFormat dateFormat_yearMonth, boolean allowEmpty)
/*     */   {
/*  63 */     this.dateFormat_short = dateFormat_short;
/*  64 */     this.dateFormat_long = dateFormat_long;
/*  65 */     this.dateFormat_yearMonth = dateFormat_yearMonth;
/*  66 */     this.allowEmpty = true;
/*     */   }
/*     */ 
/*     */   public CustomDateTimeEditor(DateFormat dateFormat_short, DateFormat dateFormat_long, boolean allowEmpty)
/*     */   {
/*  82 */     this.dateFormat_short = dateFormat_short;
/*  83 */     this.dateFormat_long = dateFormat_long;
/*  84 */     this.allowEmpty = allowEmpty;
/*     */   }
/*     */ 
/*     */   public CustomDateTimeEditor(DateFormat dateFormat_short, DateFormat dateFormat_long, boolean allowEmpty, int shortDateLength)
/*     */   {
/* 104 */     this.dateFormat_short = dateFormat_short;
/* 105 */     this.dateFormat_long = dateFormat_long;
/* 106 */     this.allowEmpty = allowEmpty;
/* 107 */     this.shortDateLength = shortDateLength;
/*     */   }
/*     */ 
/*     */   public void setAsText(String text)
/*     */     throws IllegalArgumentException
/*     */   {
/* 116 */     text = text.trim();
/* 117 */     if ((this.allowEmpty) && (!StringUtils.hasText(text))) {
/* 118 */       setValue(null);
/* 119 */       return;
/*     */     }
/*     */     try {
/* 122 */       if (text.length() <= this.yearMonthLength) {
/* 123 */         setValue(new java.sql.Date(this.dateFormat_yearMonth.parse(text).getTime()));
/*     */       }
/* 126 */       else if (text.length() <= this.shortDateLength) {
/* 127 */         setValue(new java.sql.Date(this.dateFormat_short.parse(text).getTime()));
/*     */       }
/*     */       else
/* 130 */         setValue(new Timestamp(this.dateFormat_long.parse(text).getTime()));
/*     */     }
/*     */     catch (ParseException ex)
/*     */     {
/* 134 */       IllegalArgumentException iae = new IllegalArgumentException("Could not parse date: " + ex.getMessage());
/*     */ 
/* 136 */       iae.initCause(ex);
/* 137 */       throw iae;
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getAsText()
/*     */   {
/* 147 */     java.util.Date value = (java.util.Date)getValue();
/* 148 */     return value != null ? this.dateFormat_long.format(value) : "";
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.util.CustomDateTimeEditor
 * JD-Core Version:    0.6.0
 */