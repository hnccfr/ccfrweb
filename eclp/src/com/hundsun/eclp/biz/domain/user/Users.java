/*     */ package com.hundsun.eclp.biz.domain.user;
/*     */ 
/*     */ import java.util.Date;
/*     */ 
/*     */ public class Users
/*     */ {
/*     */   private Long id;
/*     */   private String account;
/*     */   private String password;
/*     */   private String name;
/*     */   private Short status;
/*     */   private Short userType;
/*     */   private String lastLoginIp;
/*     */   private Date lastLoginTime;
/*     */   private Long loginNum;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */   private UserInfo userInfo;
/*     */   private Long[] roleId;
/*     */   private String newPassword;
/*     */   private Long defaultSubSys;
/*     */   private String source;
/*     */ 
/*     */   public Users()
/*     */   {
/*     */   }
/*     */ 
/*     */   public Users(String account, String password)
/*     */   {
/*  90 */     this.account = account;
/*  91 */     this.password = password;
/*     */   }
/*     */ 
/*     */   public Users(long id, String account, String password, String lastLoginIp) {
/*  95 */     this.id = Long.valueOf(id);
/*  96 */     this.account = account;
/*  97 */     this.password = password;
/*  98 */     this.lastLoginIp = lastLoginIp;
/*     */   }
/*     */ 
/*     */   public Long getDefaultSubSys()
/*     */   {
/* 103 */     return this.defaultSubSys;
/*     */   }
/*     */ 
/*     */   public void setDefaultSubSys(Long defaultSubSys) {
/* 107 */     this.defaultSubSys = defaultSubSys;
/*     */   }
/*     */ 
/*     */   public String getNewPassword() {
/* 111 */     return this.newPassword;
/*     */   }
/*     */ 
/*     */   public void setNewPassword(String newPassword) {
/* 115 */     this.newPassword = newPassword;
/*     */   }
/*     */ 
/*     */   public Long[] getRoleId() {
/* 119 */     return this.roleId;
/*     */   }
/*     */ 
/*     */   public void setRoleId(Long[] roleId) {
/* 123 */     this.roleId = roleId;
/*     */   }
/*     */ 
/*     */   public UserInfo getUserInfo() {
/* 127 */     return this.userInfo;
/*     */   }
/*     */ 
/*     */   public void setUserInfo(UserInfo userInfo) {
/* 131 */     this.userInfo = userInfo;
/*     */   }
/*     */ 
/*     */   public Long getId() {
/* 135 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/* 139 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getAccount() {
/* 143 */     return this.account;
/*     */   }
/*     */ 
/*     */   public void setAccount(String account) {
/* 147 */     this.account = account;
/*     */   }
/*     */ 
/*     */   public String getPassword() {
/* 151 */     return this.password;
/*     */   }
/*     */ 
/*     */   public void setPassword(String password) {
/* 155 */     this.password = password;
/*     */   }
/*     */ 
/*     */   public String getName() {
/* 159 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setName(String name) {
/* 163 */     this.name = name;
/*     */   }
/*     */ 
/*     */   public Short getStatus() {
/* 167 */     return this.status;
/*     */   }
/*     */ 
/*     */   public void setStatus(Short status) {
/* 171 */     this.status = status;
/*     */   }
/*     */ 
/*     */   public Short getUserType() {
/* 175 */     return this.userType;
/*     */   }
/*     */ 
/*     */   public void setUserType(Short userType) {
/* 179 */     this.userType = userType;
/*     */   }
/*     */ 
/*     */   public String getLastLoginIp() {
/* 183 */     return this.lastLoginIp;
/*     */   }
/*     */ 
/*     */   public void setLastLoginIp(String lastLoginIp) {
/* 187 */     this.lastLoginIp = lastLoginIp;
/*     */   }
/*     */ 
/*     */   public Date getLastLoginTime() {
/* 191 */     return this.lastLoginTime;
/*     */   }
/*     */ 
/*     */   public void setLastLoginTime(Date lastLoginTime) {
/* 195 */     this.lastLoginTime = lastLoginTime;
/*     */   }
/*     */ 
/*     */   public Long getLoginNum() {
/* 199 */     return this.loginNum;
/*     */   }
/*     */ 
/*     */   public void setLoginNum(Long loginNum) {
/* 203 */     this.loginNum = loginNum;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate() {
/* 207 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate) {
/* 211 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify() {
/* 215 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify) {
/* 219 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getSource()
/*     */   {
/* 226 */     return this.source;
/*     */   }
/*     */ 
/*     */   public void setSource(String source)
/*     */   {
/* 233 */     this.source = source;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.domain.user.Users
 * JD-Core Version:    0.6.0
 */