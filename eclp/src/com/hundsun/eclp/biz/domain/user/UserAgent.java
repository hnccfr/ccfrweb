/*     */ package com.hundsun.eclp.biz.domain.user;
/*     */ 
/*     */ import com.hundsun.eclp.biz.domain.sys.MemoPermission;
/*     */ import com.hundsun.eclp.client.common.GenericUserAgent;
/*     */ import com.hundsun.eclp.enums.PermissionEnum;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import com.hundsun.network.melody.common.web.cookyjar.SelfDependence;
/*     */ import com.hundsun.network.melody.common.web.cookyjar.util.SelfUtil;
/*     */ import java.math.BigInteger;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ public class UserAgent extends GenericUserAgent
/*     */ {
/*     */   private Short userType;
/*  18 */   private int loginFailedTimes = 0;
/*     */ 
/*  20 */   private Long lastLoginTime = Long.valueOf(-1L);
/*     */   private String lastLoginIp;
/*  24 */   private boolean isSuperUser = false;
/*     */ 
/*     */   public UserAgent()
/*     */   {
/*     */   }
/*     */ 
/*     */   public UserAgent(Users user)
/*     */   {
/*  32 */     this.id = user.getId().longValue();
/*  33 */     this.name = user.getName();
/*  34 */     this.userAccount = user.getAccount();
/*     */   }
/*     */ 
/*     */   public boolean havePermission(PermissionEnum permission)
/*     */   {
/*  44 */     Map map = MemoPermission.get(this.currentSystemCode);
/*  45 */     if ((map != null) && 
/*  46 */       (map.get(Integer.valueOf(permission.getCode())) != null)) {
/*  47 */       return this.permissions.testBit(((Integer)map.get(Integer.valueOf(permission.getCode()))).intValue());
/*     */     }
/*     */ 
/*  50 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean setPermission(int index)
/*     */   {
/*  60 */     this.permissions = this.permissions.setBit(index);
/*  61 */     super.setSubsystemPermission(this.permissions, this.currentSystemCode);
/*  62 */     return true;
/*     */   }
/*     */ 
/*     */   public void setPermissionsByList(List<Integer> permissions, String systemCode)
/*     */   {
/*  81 */     BigInteger big = new BigInteger("0");
/*  82 */     Map map = MemoPermission.get(systemCode);
/*  83 */     if (map != null) {
/*  84 */       for (Integer item : permissions) {
/*  85 */         if (map.get(item) != null) {
/*  86 */           big = big.setBit(((Integer)map.get(item)).intValue());
/*     */         }
/*     */       }
/*  89 */       super.setPermissions(big);
/*  90 */       super.setSubsystemPermission(big, systemCode);
/*     */     }
/*     */   }
/*     */ 
/*     */   public int getLoginFailedTimes()
/*     */   {
/*  96 */     return this.loginFailedTimes;
/*     */   }
/*     */ 
/*     */   public void setLoginFailedTimes(int loginFailedTimes) {
/* 100 */     this.loginFailedTimes = loginFailedTimes;
/*     */   }
/*     */ 
/*     */   public Long getLastLoginTime() {
/* 104 */     return this.lastLoginTime;
/*     */   }
/*     */ 
/*     */   public void setLastLoginTime(Long lastLoginTime) {
/* 108 */     this.lastLoginTime = lastLoginTime;
/*     */   }
/*     */ 
/*     */   public String getLastLoginIp() {
/* 112 */     return this.lastLoginIp;
/*     */   }
/*     */ 
/*     */   public void setLastLoginIp(String lastLoginIp) {
/* 116 */     this.lastLoginIp = lastLoginIp;
/*     */   }
/*     */ 
/*     */   public Short getUserType() {
/* 120 */     return this.userType;
/*     */   }
/*     */ 
/*     */   public void setUserType(Short userType) {
/* 124 */     this.userType = userType;
/*     */   }
/*     */ 
/*     */   public boolean isSuperUser() {
/* 128 */     return this.isSuperUser;
/*     */   }
/*     */ 
/*     */   public void setIsSuperUser(boolean isSuperUser) {
/* 132 */     this.isSuperUser = isSuperUser;
/*     */   }
/*     */ 
/*     */   public String lieDown()
/*     */   {
/* 137 */     return SelfUtil.format(new String[] { this.id + "", this.name, super.getPermissionString(36), this.permissions.toString(36), this.eclpLastLoginTime + "", this.currentSystemCode + "", this.userAccount, this.loginFailedTimes + "", this.lastLoginTime + "", this.lastLoginIp, this.userType + "", String.valueOf(this.isSuperUser) });
/*     */   }
/*     */ 
/*     */   public SelfDependence riseUp(String value)
/*     */   {
/* 154 */     String[] values = SelfUtil.recover(value);
/* 155 */     if ((StringUtil.isNotEmpty(values[0])) && (!"null".equalsIgnoreCase(values[0]))) {
/* 156 */       this.id = Long.parseLong(values[0]);
/*     */     }
/* 158 */     this.name = values[1];
/* 159 */     this.permissionsMap = getPermissionMapFromString(values[2]);
/* 160 */     this.permissions = new BigInteger(values[3], 36);
/* 161 */     if (StringUtil.isNotEmpty(values[4])) {
/* 162 */       this.eclpLastLoginTime = Long.valueOf(Long.parseLong(values[4]));
/*     */     }
/* 164 */     this.currentSystemCode = values[5];
/* 165 */     this.userAccount = values[6];
/* 166 */     if (StringUtil.isNotEmpty(values[7])) {
/* 167 */       this.loginFailedTimes = Integer.parseInt(values[7]);
/*     */     }
/* 169 */     if ((StringUtil.isNotEmpty(values[8])) && (!"null".equalsIgnoreCase(values[8]))) {
/* 170 */       this.lastLoginTime = Long.valueOf(Long.parseLong(values[8]));
/*     */     }
/* 172 */     this.lastLoginIp = values[9];
/* 173 */     if ((StringUtil.isNotEmpty(values[8])) && (!"null".equalsIgnoreCase(values[10]))) {
/* 174 */       this.userType = Short.valueOf(Short.parseShort(values[10]));
/*     */     }
/* 176 */     if ((StringUtil.isNotEmpty(values[11])) && ((values[11].equalsIgnoreCase("true")) || (values[11].equalsIgnoreCase("false"))))
/*     */     {
/* 178 */       this.isSuperUser = Boolean.valueOf(values[11]).booleanValue();
/*     */     }
/* 180 */     return this;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.domain.user.UserAgent
 * JD-Core Version:    0.6.0
 */