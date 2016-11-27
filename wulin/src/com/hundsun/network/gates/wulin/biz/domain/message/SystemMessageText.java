/*     */ package com.hundsun.network.gates.wulin.biz.domain.message;
/*     */ 
/*     */ import java.util.Date;
/*     */ 
/*     */ public class SystemMessageText
/*     */ {
/*     */   private Long id;
/*     */   private String title;
/*     */   private String content;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */   private String operator;
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  47 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  54 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getContent()
/*     */   {
/*  61 */     return this.content;
/*     */   }
/*     */ 
/*     */   public void setContent(String content)
/*     */   {
/*  68 */     this.content = content;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate()
/*     */   {
/*  75 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate)
/*     */   {
/*  82 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify()
/*     */   {
/*  89 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify)
/*     */   {
/*  96 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getOperator()
/*     */   {
/* 103 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator)
/*     */   {
/* 110 */     this.operator = operator;
/*     */   }
/*     */ 
/*     */   public void setTitle(String title) {
/* 114 */     this.title = title;
/*     */   }
/*     */ 
/*     */   public String getTitle() {
/* 118 */     return this.title;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.domain.message.SystemMessageText
 * JD-Core Version:    0.6.0
 */