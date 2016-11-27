/*     */ package com.hundsun.eclp.biz.domain.sys;
/*     */ 
/*     */ import java.util.Date;
/*     */ 
/*     */ public class LoginLog
/*     */ {
/*     */   private Long id;
/*     */   private Long userId;
/*     */   private String account;
/*     */   private String loginIp;
/*     */   private Date loginTime;
/*     */   private Short status;
/*     */   private String mac;
/*     */   private String name;
/*     */   private String remark;
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  49 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/*  53 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public Long getUserId() {
/*  57 */     return this.userId;
/*     */   }
/*     */ 
/*     */   public void setUserId(Long userId) {
/*  61 */     this.userId = userId;
/*     */   }
/*     */ 
/*     */   public String getAccount() {
/*  65 */     return this.account;
/*     */   }
/*     */ 
/*     */   public void setAccount(String account) {
/*  69 */     this.account = account;
/*     */   }
/*     */ 
/*     */   public String getLoginIp() {
/*  73 */     return this.loginIp;
/*     */   }
/*     */ 
/*     */   public void setLoginIp(String loginIp) {
/*  77 */     this.loginIp = loginIp;
/*     */   }
/*     */ 
/*     */   public Date getLoginTime() {
/*  81 */     return this.loginTime;
/*     */   }
/*     */ 
/*     */   public void setLoginTime(Date loginTime) {
/*  85 */     this.loginTime = loginTime;
/*     */   }
/*     */ 
/*     */   public Short getStatus() {
/*  89 */     return this.status;
/*     */   }
/*     */ 
/*     */   public void setStatus(Short status) {
/*  93 */     this.status = status;
/*     */   }
/*     */ 
/*     */   public String getMac() {
/*  97 */     return this.mac;
/*     */   }
/*     */ 
/*     */   public void setMac(String mac) {
/* 101 */     this.mac = mac;
/*     */   }
/*     */ 
/*     */   public String getRemark() {
/* 105 */     return this.remark;
/*     */   }
/*     */ 
/*     */   public void setRemark(String remark) {
/* 109 */     this.remark = remark;
/*     */   }
/*     */ 
/*     */   public String getName() {
/* 113 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setName(String name) {
/* 117 */     this.name = name;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.domain.sys.LoginLog
 * JD-Core Version:    0.6.0
 */