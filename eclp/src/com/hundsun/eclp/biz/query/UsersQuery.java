/*     */ package com.hundsun.eclp.biz.query;
/*     */ 
/*     */ import com.hundsun.network.common.query.QueryPage;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.text.DateFormat;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ public class UsersQuery extends QueryPage
/*     */ {
/*     */   private static final long serialVersionUID = 777061030649295723L;
/*     */   private String account;
/*     */   private String realName;
/*     */   private String status;
/*     */   private String userType;
/*     */   private String startDate;
/*     */   private String endDate;
/*     */   private String agentUserType;
/*     */   private String deptId;
/*     */   private List<Long> roleList;
/*     */   private String roleId;
/*     */   private String authId;
/*     */ 
/*     */   public String getDeptId()
/*     */   {
/*  45 */     return this.deptId;
/*     */   }
/*     */ 
/*     */   public void setDeptId(String deptId) {
/*  49 */     this.deptId = deptId;
/*     */   }
/*     */ 
/*     */   public Map<String, String> getParameters()
/*     */   {
/*  54 */     Map map = new HashMap();
/*  55 */     if (StringUtil.isNotBlank(this.account)) {
/*  56 */       map.put("account", this.account.trim());
/*     */     }
/*  58 */     if (StringUtil.isNotBlank(this.realName)) {
/*  59 */       map.put("realName", this.realName.trim());
/*     */     }
/*  61 */     if (StringUtil.isNotBlank(this.status)) {
/*  62 */       map.put("status", this.status);
/*     */     }
/*  64 */     if (StringUtil.isNotBlank(this.userType)) {
/*  65 */       map.put("userType", this.userType);
/*     */     }
/*  67 */     if (StringUtil.isNotBlank(this.startDate)) {
/*  68 */       map.put("startDate", this.startDate);
/*     */     }
/*  70 */     if (StringUtil.isNotBlank(this.endDate)) {
/*  71 */       map.put("endDate", this.endDate);
/*     */     }
/*  73 */     if (StringUtil.isNotBlank(this.agentUserType)) {
/*  74 */       map.put("agentUserType", this.agentUserType);
/*     */     }
/*  76 */     if (StringUtil.isNotBlank(this.roleId)) {
/*  77 */       map.put("roleId", this.roleId);
/*     */     }
/*  79 */     if (StringUtil.isNotBlank(this.authId)) {
/*  80 */       map.put("authId", this.authId);
/*     */     }
/*  82 */     return map;
/*     */   }
/*     */ 
/*     */   public String getAccount() {
/*  86 */     if (this.account != null) {
/*  87 */       this.account = this.account.trim();
/*     */     }
/*  89 */     return this.account;
/*     */   }
/*     */ 
/*     */   public void setAccount(String account) {
/*  93 */     this.account = account;
/*     */   }
/*     */ 
/*     */   public String getRealName() {
/*  97 */     if (this.realName != null)
/*  98 */       this.realName = this.realName.trim();
/*  99 */     return this.realName;
/*     */   }
/*     */ 
/*     */   public void setRealName(String realName) {
/* 103 */     this.realName = realName;
/*     */   }
/*     */ 
/*     */   public String getStatus() {
/* 107 */     return this.status;
/*     */   }
/*     */ 
/*     */   public void setStatus(String status) {
/* 111 */     this.status = status;
/*     */   }
/*     */ 
/*     */   public String getStartDate() {
/* 115 */     return this.startDate;
/*     */   }
/*     */ 
/*     */   public void setStartDate(String startDate) {
/* 119 */     this.startDate = startDate;
/*     */   }
/*     */ 
/*     */   public String getEndDate() {
/* 123 */     return this.endDate;
/*     */   }
/*     */ 
/*     */   public void setEndDate(String endDate) {
/* 127 */     this.endDate = endDate;
/*     */   }
/*     */ 
/*     */   public String getUserType() {
/* 131 */     return this.userType;
/*     */   }
/*     */ 
/*     */   public void setUserType(String userType) {
/* 135 */     this.userType = userType;
/*     */   }
/*     */ 
/*     */   public String getAgentUserType() {
/* 139 */     return this.agentUserType;
/*     */   }
/*     */ 
/*     */   public void setAgentUserType(String agentUserType) {
/* 143 */     this.agentUserType = agentUserType;
/*     */   }
/*     */ 
/*     */   public List<Long> getRoleList() {
/* 147 */     return this.roleList;
/*     */   }
/*     */ 
/*     */   public void setRoleList(List<Long> roleList) {
/* 151 */     this.roleList = roleList;
/*     */   }
/*     */ 
/*     */   public void setSearchDate(int date) {
/* 155 */     if ((StringUtil.isBlank(this.startDate)) || (StringUtil.isBlank(this.endDate))) {
/* 156 */       DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
/* 157 */       Calendar calendar = Calendar.getInstance();
/* 158 */       calendar.add(5, -date);
/* 159 */       this.startDate = dateFormat.format(calendar.getTime());
/* 160 */       this.endDate = dateFormat.format(new Date());
/*     */     }
/*     */   }
/*     */ 
/*     */   public String getRoleId() {
/* 165 */     return this.roleId;
/*     */   }
/*     */ 
/*     */   public void setRoleId(String roleId) {
/* 169 */     this.roleId = roleId;
/*     */   }
/*     */ 
/*     */   public String getAuthId() {
/* 173 */     return this.authId;
/*     */   }
/*     */ 
/*     */   public void setAuthId(String authId) {
/* 177 */     this.authId = authId;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.query.UsersQuery
 * JD-Core Version:    0.6.0
 */