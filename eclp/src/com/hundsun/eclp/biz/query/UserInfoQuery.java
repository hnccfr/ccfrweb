/*     */ package com.hundsun.eclp.biz.query;
/*     */ 
/*     */ import com.hundsun.network.common.query.QueryPage;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ public class UserInfoQuery extends QueryPage
/*     */ {
/*     */   private static final long serialVersionUID = 6131200340942809486L;
/*     */   private String realName;
/*     */   private String status;
/*     */   private String deptId;
/*     */   private String orderBy;
/*     */   private String subSystemCode;
/*     */   private List<Long> roleList;
/*     */ 
/*     */   public String getSubSystemCode()
/*     */   {
/*  40 */     return this.subSystemCode;
/*     */   }
/*     */ 
/*     */   public void setSubSystemCode(String subSystemCode) {
/*  44 */     this.subSystemCode = subSystemCode;
/*     */   }
/*     */ 
/*     */   public String getRealName() {
/*  48 */     return this.realName;
/*     */   }
/*     */ 
/*     */   public void setRealName(String realName) {
/*  52 */     this.realName = realName;
/*     */   }
/*     */ 
/*     */   public String getStatus() {
/*  56 */     return this.status;
/*     */   }
/*     */ 
/*     */   public void setStatus(String status) {
/*  60 */     this.status = status;
/*     */   }
/*     */ 
/*     */   public String getDeptId() {
/*  64 */     return this.deptId;
/*     */   }
/*     */ 
/*     */   public void setDeptId(String deptId) {
/*  68 */     this.deptId = deptId;
/*     */   }
/*     */ 
/*     */   public String getOrderBy() {
/*  72 */     return this.orderBy;
/*     */   }
/*     */ 
/*     */   public void setOrderBy(String orderBy) {
/*  76 */     this.orderBy = orderBy;
/*     */   }
/*     */ 
/*     */   public Map<String, String> getParameters()
/*     */   {
/*  81 */     Map map = new HashMap();
/*  82 */     if (StringUtil.isNotBlank(this.realName)) {
/*  83 */       map.put("realName", this.realName);
/*     */     }
/*  85 */     if (StringUtil.isNotBlank(this.realName)) {
/*  86 */       map.put("realName", this.realName);
/*     */     }
/*  88 */     if (StringUtil.isNotBlank(this.status)) {
/*  89 */       map.put("status", this.status);
/*     */     }
/*  91 */     if (StringUtil.isNotBlank(this.deptId)) {
/*  92 */       map.put("deptId", this.deptId);
/*     */     }
/*  94 */     if (StringUtil.isNotBlank(this.orderBy)) {
/*  95 */       map.put("orderBy", this.orderBy);
/*     */     }
/*  97 */     return map;
/*     */   }
/*     */ 
/*     */   public List<Long> getRoleList() {
/* 101 */     return this.roleList;
/*     */   }
/*     */ 
/*     */   public void setRoleList(List<Long> roleList) {
/* 105 */     this.roleList = roleList;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.query.UserInfoQuery
 * JD-Core Version:    0.6.0
 */