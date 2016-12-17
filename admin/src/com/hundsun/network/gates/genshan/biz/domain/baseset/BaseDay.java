/*     */ package com.hundsun.network.gates.genshan.biz.domain.baseset;
/*     */ 
/*     */ import java.text.DateFormat;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class BaseDay
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private Long id;
/*     */   private Integer year;
/*     */   private Integer month;
/*     */   private Date day;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */   private String operator;
/*  45 */   DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  51 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  58 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public Integer getYear()
/*     */   {
/*  65 */     return this.year;
/*     */   }
/*     */ 
/*     */   public void setYear(Integer year)
/*     */   {
/*  72 */     this.year = year;
/*     */   }
/*     */ 
/*     */   public Integer getMonth()
/*     */   {
/*  79 */     return this.month;
/*     */   }
/*     */ 
/*     */   public void setMonth(Integer month)
/*     */   {
/*  86 */     this.month = month;
/*     */   }
/*     */ 
/*     */   public Date getDay()
/*     */   {
/*  93 */     return this.day;
/*     */   }
/*     */ 
/*     */   public void setDay(Date day)
/*     */   {
/* 100 */     this.day = day;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate()
/*     */   {
/* 107 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate)
/*     */   {
/* 114 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify()
/*     */   {
/* 121 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify)
/*     */   {
/* 128 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getDayStr() {
/* 132 */     if (this.day != null) {
/* 133 */       return this.df.format(this.day);
/*     */     }
/* 135 */     return null;
/*     */   }
/*     */ 
/*     */   public String getOperator() {
/* 139 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator) {
/* 143 */     this.operator = operator;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.baseset.BaseDay
 * JD-Core Version:    0.6.0
 */