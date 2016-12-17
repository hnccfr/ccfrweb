/*     */ package com.hundsun.network.gates.wulin.biz.domain.message;
/*     */ 
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
/*     */   public String getReceiveAccount()
/*     */   {
/*  61 */     return this.receiveAccount;
/*     */   }
/*     */ 
/*     */   public void setReceiveAccount(String receiveAccount)
/*     */   {
/*  68 */     this.receiveAccount = receiveAccount;
/*     */   }
/*     */ 
/*     */   public String getSendAccount()
/*     */   {
/*  75 */     return this.sendAccount;
/*     */   }
/*     */ 
/*     */   public void setSendAccount(String sendAccount)
/*     */   {
/*  82 */     this.sendAccount = sendAccount;
/*     */   }
/*     */ 
/*     */   public Long getMessageId()
/*     */   {
/*  89 */     return this.messageId;
/*     */   }
/*     */ 
/*     */   public void setMessageId(Long messageId)
/*     */   {
/*  96 */     this.messageId = messageId;
/*     */   }
/*     */ 
/*     */   public String getStatus()
/*     */   {
/* 103 */     return this.status;
/*     */   }
/*     */ 
/*     */   public void setStatus(String status)
/*     */   {
/* 110 */     this.status = status;
/*     */   }
/*     */ 
/*     */   public Date getSendTime()
/*     */   {
/* 117 */     return this.sendTime;
/*     */   }
/*     */ 
/*     */   public void setSendTime(Date sendTime)
/*     */   {
/* 124 */     this.sendTime = sendTime;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.domain.message.SystemMessage
 * JD-Core Version:    0.6.0
 */