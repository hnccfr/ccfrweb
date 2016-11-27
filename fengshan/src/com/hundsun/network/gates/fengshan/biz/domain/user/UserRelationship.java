/*     */ package com.hundsun.network.gates.fengshan.biz.domain.user;
/*     */ 
/*     */ import java.util.Date;
/*     */ 
/*     */ public class UserRelationship
/*     */ {
/*     */   private Long id;
/*     */   private String userAccount;
/*     */   private String relationAccount;
/*     */   private String type;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */   private String operator;
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  39 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/*  43 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getUserAccount()
/*     */   {
/*  50 */     return this.userAccount;
/*     */   }
/*     */ 
/*     */   public void setUserAccount(String userAccount)
/*     */   {
/*  57 */     this.userAccount = userAccount;
/*     */   }
/*     */ 
/*     */   public String getRelationAccount()
/*     */   {
/*  64 */     return this.relationAccount;
/*     */   }
/*     */ 
/*     */   public void setRelationAccount(String relationAccount)
/*     */   {
/*  71 */     this.relationAccount = relationAccount;
/*     */   }
/*     */ 
/*     */   public String getType()
/*     */   {
/*  78 */     return this.type;
/*     */   }
/*     */ 
/*     */   public void setType(String type)
/*     */   {
/*  85 */     this.type = type;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate()
/*     */   {
/*  92 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate)
/*     */   {
/*  99 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify()
/*     */   {
/* 106 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify)
/*     */   {
/* 113 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getOperator()
/*     */   {
/* 120 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator)
/*     */   {
/* 127 */     this.operator = operator;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.domain.user.UserRelationship
 * JD-Core Version:    0.6.0
 */