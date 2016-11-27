/*     */ package com.hundsun.network.gates.wulin.biz.domain.funds;
/*     */ 
/*     */ import java.util.Date;
/*     */ 
/*     */ public class CashTradeStatus
/*     */ {
/*     */   private Long id;
/*     */   private String taid;
/*     */   private String sourceId;
/*     */   private Date createTime;
/*     */   private Long totalPay;
/*     */   private String comments;
/*     */   private String subject;
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  74 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  81 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getTaid()
/*     */   {
/*  88 */     return this.taid;
/*     */   }
/*     */ 
/*     */   public void setTaid(String taid)
/*     */   {
/*  95 */     this.taid = taid;
/*     */   }
/*     */ 
/*     */   public String getSourceId()
/*     */   {
/* 104 */     return this.sourceId;
/*     */   }
/*     */ 
/*     */   public void setSourceId(String sourceId)
/*     */   {
/* 113 */     this.sourceId = sourceId;
/*     */   }
/*     */ 
/*     */   public Date getCreateTime()
/*     */   {
/* 120 */     return this.createTime;
/*     */   }
/*     */ 
/*     */   public void setCreateTime(Date createTime)
/*     */   {
/* 127 */     this.createTime = createTime;
/*     */   }
/*     */ 
/*     */   public Long getTotalPay() {
/* 131 */     return this.totalPay;
/*     */   }
/*     */ 
/*     */   public void setTotalPay(Long totalPay) {
/* 135 */     this.totalPay = totalPay;
/*     */   }
/*     */ 
/*     */   public String getComments()
/*     */   {
/* 142 */     return this.comments;
/*     */   }
/*     */ 
/*     */   public void setComments(String comments)
/*     */   {
/* 149 */     this.comments = comments;
/*     */   }
/*     */ 
/*     */   public String getSubject()
/*     */   {
/* 186 */     return this.subject;
/*     */   }
/*     */ 
/*     */   public void setSubject(String subject)
/*     */   {
/* 223 */     this.subject = subject;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.domain.funds.CashTradeStatus
 * JD-Core Version:    0.6.0
 */