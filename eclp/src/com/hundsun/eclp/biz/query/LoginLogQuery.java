/*     */ package com.hundsun.eclp.biz.query;
/*     */ 
/*     */ import com.hundsun.network.common.query.QueryPage;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ 
/*     */ public class LoginLogQuery extends QueryPage
/*     */ {
/*     */   private static final long serialVersionUID = 6131200340942809486L;
/*     */   private String account;
/*     */   private String realName;
/*     */   private String status;
/*     */   private String startDate;
/*     */   private String endDate;
/*     */   private String loginIp;
/*     */   private String mac;
/*     */   private String orderBy;
/*     */ 
/*     */   public String getAccount()
/*     */   {
/*  35 */     return this.account;
/*     */   }
/*     */ 
/*     */   public void setAccount(String account) {
/*  39 */     this.account = account;
/*     */   }
/*     */ 
/*     */   public String getStatus() {
/*  43 */     return this.status;
/*     */   }
/*     */ 
/*     */   public void setStatus(String status) {
/*  47 */     this.status = status;
/*     */   }
/*     */ 
/*     */   public String getStartDate() {
/*  51 */     return this.startDate;
/*     */   }
/*     */ 
/*     */   public void setStartDate(String startDate) {
/*  55 */     this.startDate = startDate;
/*     */   }
/*     */ 
/*     */   public String getEndDate() {
/*  59 */     return this.endDate;
/*     */   }
/*     */ 
/*     */   public void setEndDate(String endDate) {
/*  63 */     this.endDate = endDate;
/*     */   }
/*     */ 
/*     */   public String getRealName() {
/*  67 */     return this.realName;
/*     */   }
/*     */ 
/*     */   public void setRealName(String realName) {
/*  71 */     this.realName = realName;
/*     */   }
/*     */ 
/*     */   public String getLoginIp() {
/*  75 */     return this.loginIp;
/*     */   }
/*     */ 
/*     */   public void setLoginIp(String loginIp) {
/*  79 */     this.loginIp = loginIp;
/*     */   }
/*     */ 
/*     */   public String getMac() {
/*  83 */     return this.mac;
/*     */   }
/*     */ 
/*     */   public void setMac(String mac) {
/*  87 */     this.mac = mac;
/*     */   }
/*     */ 
/*     */   public String getOrderBy() {
/*  91 */     return this.orderBy;
/*     */   }
/*     */ 
/*     */   public void setOrderBy(String orderBy) {
/*  95 */     this.orderBy = orderBy;
/*     */   }
/*     */ 
/*     */   public Map<String, String> getParameters()
/*     */   {
/* 100 */     Map map = new HashMap();
/* 101 */     if (StringUtil.isNotBlank(this.account)) {
/* 102 */       map.put("account", this.account);
/*     */     }
/* 104 */     if (StringUtil.isNotBlank(this.realName)) {
/* 105 */       map.put("realName", this.realName);
/*     */     }
/* 107 */     if (StringUtil.isNotBlank(this.status)) {
/* 108 */       map.put("status", this.status);
/*     */     }
/* 110 */     if (StringUtil.isNotBlank(this.startDate)) {
/* 111 */       map.put("startDate", this.startDate);
/*     */     }
/* 113 */     if (StringUtil.isNotBlank(this.endDate)) {
/* 114 */       map.put("endDate", this.endDate);
/*     */     }
/* 116 */     if (StringUtil.isNotBlank(this.loginIp)) {
/* 117 */       map.put("loginIp", this.loginIp);
/*     */     }
/* 119 */     if (StringUtil.isNotBlank(this.mac)) {
/* 120 */       map.put("mac", this.mac);
/*     */     }
/* 122 */     if (StringUtil.isNotBlank(this.orderBy)) {
/* 123 */       map.put("orderBy", this.orderBy);
/*     */     }
/* 125 */     return map;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.query.LoginLogQuery
 * JD-Core Version:    0.6.0
 */