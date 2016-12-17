/*     */ package com.hundsun.network.gates.genshan.biz.domain.message;
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
/*     */   private String status;
/*     */   private String systemMessageId;
/*     */   private String receiveAccount;
/*     */ 
/*     */   public String getStatus()
/*     */   {
/*  59 */     return this.status;
/*     */   }
/*     */ 
/*     */   public void setStatus(String status) {
/*  63 */     this.status = status;
/*     */   }
/*     */ 
/*     */   public String getSystemMessageId() {
/*  67 */     return this.systemMessageId;
/*     */   }
/*     */ 
/*     */   public void setSystemMessageId(String systemMessageId) {
/*  71 */     this.systemMessageId = systemMessageId;
/*     */   }
/*     */ 
/*     */   public String getReceiveAccount() {
/*  75 */     return this.receiveAccount;
/*     */   }
/*     */ 
/*     */   public void setReceiveAccount(String receiveAccount) {
/*  79 */     this.receiveAccount = receiveAccount;
/*     */   }
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  86 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  93 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getContent()
/*     */   {
/* 100 */     return this.content;
/*     */   }
/*     */ 
/*     */   public void setContent(String content)
/*     */   {
/* 107 */     this.content = content;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate()
/*     */   {
/* 114 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate)
/*     */   {
/* 121 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify()
/*     */   {
/* 128 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify)
/*     */   {
/* 135 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getOperator()
/*     */   {
/* 142 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator)
/*     */   {
/* 149 */     this.operator = operator;
/*     */   }
/*     */ 
/*     */   public void setTitle(String title) {
/* 153 */     this.title = title;
/*     */   }
/*     */ 
/*     */   public String getTitle() {
/* 157 */     return this.title;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.message.SystemMessageText
 * JD-Core Version:    0.6.0
 */