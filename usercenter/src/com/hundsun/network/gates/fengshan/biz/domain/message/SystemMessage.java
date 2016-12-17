/*     */ package com.hundsun.network.gates.fengshan.biz.domain.message;
/*     */ 
/*     */ import com.hundsun.network.gates.fengshan.biz.enums.EnumSystemMessageStatus;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class SystemMessage
/*     */ {
/*     */   private Long id;
/*     */   private String receiveAccount;
/*     */   private String sendAccount;
/*     */   private Long messageId;
/*     */   private String status;
/*     */   private Date sendTime;
/*     */   private String title;
/*     */   private String content;
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  59 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  66 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getReceiveAccount()
/*     */   {
/*  73 */     return this.receiveAccount;
/*     */   }
/*     */ 
/*     */   public void setReceiveAccount(String receiveAccount)
/*     */   {
/*  80 */     this.receiveAccount = receiveAccount;
/*     */   }
/*     */ 
/*     */   public String getSendAccount()
/*     */   {
/*  87 */     return this.sendAccount;
/*     */   }
/*     */ 
/*     */   public void setSendAccount(String sendAccount)
/*     */   {
/*  94 */     this.sendAccount = sendAccount;
/*     */   }
/*     */ 
/*     */   public Long getMessageId()
/*     */   {
/* 101 */     return this.messageId;
/*     */   }
/*     */ 
/*     */   public void setMessageId(Long messageId)
/*     */   {
/* 108 */     this.messageId = messageId;
/*     */   }
/*     */ 
/*     */   public String getStatus()
/*     */   {
/* 115 */     return this.status;
/*     */   }
/*     */ 
/*     */   public void setStatus(String status)
/*     */   {
/* 122 */     this.status = status;
/*     */   }
/*     */ 
/*     */   public Date getSendTime()
/*     */   {
/* 129 */     return this.sendTime;
/*     */   }
/*     */ 
/*     */   public void setSendTime(Date sentTime)
/*     */   {
/* 136 */     this.sendTime = sentTime;
/*     */   }
/*     */ 
/*     */   public String getTitle() {
/* 140 */     return this.title;
/*     */   }
/*     */ 
/*     */   public void setTitle(String title) {
/* 144 */     this.title = title;
/*     */   }
/*     */ 
/*     */   public String getContent() {
/* 148 */     return this.content;
/*     */   }
/*     */ 
/*     */   public void setContent(String content) {
/* 152 */     this.content = content;
/*     */   }
/*     */ 
/*     */   public String getStatusDesc()
/*     */   {
/* 163 */     EnumSystemMessageStatus enumSystemMessageStatus = EnumSystemMessageStatus.indexByValue(this.status);
/* 164 */     if (null == enumSystemMessageStatus) {
/* 165 */       return this.status;
/*     */     }
/* 167 */     return enumSystemMessageStatus.getName();
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.domain.message.SystemMessage
 * JD-Core Version:    0.6.0
 */