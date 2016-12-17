/*     */ package com.hundsun.network.gates.genshan.common;
/*     */ 
/*     */ import com.hundsun.eclp.client.common.GenericUserAgent;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import com.hundsun.network.melody.common.web.cookyjar.SelfDependence;
/*     */ import com.hundsun.network.melody.common.web.cookyjar.util.SelfUtil;
/*     */ import java.math.BigInteger;
/*     */ import java.util.List;
/*     */ 
/*     */ public class UserAgent extends GenericUserAgent
/*     */ {
/*  13 */   private int loginFailedTimes = 0;
/*     */   private String lastLoginTime;
/*     */   private String lastLoginIP;
/*     */   private String account;
/*     */   private long userWW;
/*     */ 
/*     */   public String getAccount()
/*     */   {
/*  25 */     return this.account;
/*     */   }
/*     */ 
/*     */   public void setAccount(String account) {
/*  29 */     this.account = account;
/*     */   }
/*     */ 
/*     */   public String getLastLoginIP() {
/*  33 */     return this.lastLoginIP;
/*     */   }
/*     */ 
/*     */   public void setLastLoginIP(String lastLoginIP) {
/*  37 */     this.lastLoginIP = lastLoginIP;
/*     */   }
/*     */ 
/*     */   public boolean havePermission(PermissionEnum permission)
/*     */   {
/*  54 */     return havePermission(permission.getCode());
/*     */   }
/*     */ 
/*     */   public void setPermissions(List<PermissionEnum> permissions)
/*     */   {
/*  62 */     for (PermissionEnum en : permissions)
/*  63 */       setPermission(en.getCode());
/*     */   }
/*     */ 
/*     */   public void setPermissions(int pos)
/*     */   {
/*  68 */     setPermission(pos);
/*     */   }
/*     */ 
/*     */   public long getId()
/*     */   {
/*  73 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(long id) {
/*  77 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getName() {
/*  81 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setName(String name) {
/*  85 */     this.name = name;
/*     */   }
/*     */ 
/*     */   public int getLoginFailedTimes() {
/*  89 */     return this.loginFailedTimes;
/*     */   }
/*     */ 
/*     */   public void setLoginFailedTimes(int loginFailedTimes) {
/*  93 */     this.loginFailedTimes = loginFailedTimes;
/*     */   }
/*     */ 
/*     */   public String getLastLoginTime() {
/*  97 */     return this.lastLoginTime;
/*     */   }
/*     */ 
/*     */   public void setLastLoginTime(String lastLoginTime) {
/* 101 */     this.lastLoginTime = lastLoginTime;
/*     */   }
/*     */ 
/*     */   public String getCurrentSystemCode() {
/* 105 */     return this.currentSystemCode;
/*     */   }
/*     */ 
/*     */   public void setCurrentSystemCode(String currentSystemCode) {
/* 109 */     this.currentSystemCode = currentSystemCode;
/*     */   }
/*     */ 
/*     */   public long getUserWW() {
/* 113 */     return this.userWW;
/*     */   }
/*     */ 
/*     */   public void setUserWW(long userWW)
/*     */   {
/* 118 */     this.userWW = userWW;
/*     */   }
/*     */ 
/*     */   public String lieDown()
/*     */   {
/* 123 */     return SelfUtil.format(new String[] { this.id + "", this.name, this.permissions.toString(36), this.loginFailedTimes + "", this.lastLoginTime, this.currentSystemCode, this.lastLoginIP, this.userAccount });
/*     */   }
/*     */ 
/*     */   public SelfDependence riseUp(String value)
/*     */   {
/* 128 */     String[] values = SelfUtil.recover(value);
/* 129 */     if (StringUtil.isNotEmpty(values[0])) {
/* 130 */       this.id = Long.parseLong(values[0]);
/*     */     }
/* 132 */     this.name = values[1];
/*     */ 
/* 134 */     this.permissions = new BigInteger(values[2], 36);
/* 135 */     this.loginFailedTimes = Integer.parseInt(values[3]);
/* 136 */     this.lastLoginTime = values[4];
/* 137 */     this.currentSystemCode = values[5];
/* 138 */     this.lastLoginIP = values[6];
/* 139 */     this.userAccount = values[7];
/* 140 */     return this;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.common.UserAgent
 * JD-Core Version:    0.6.0
 */