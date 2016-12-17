/*     */ package com.hundsun.network.gates.genshan.biz.domain.query;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.domain.user.UserAccount;
/*     */ import com.hundsun.network.gates.luosi.common.page.Pagination;
/*     */ import java.util.List;
/*     */ 
/*     */ public class UserAccountQuery extends Pagination<UserAccount>
/*     */ {
/*     */   private static final long serialVersionUID = 1039958895474596570L;
/*     */   private String account;
/*     */   private String name;
/*     */   private String type;
/*     */   private String userRole;
/*     */   private String status;
/*     */   private String fundAccount;
/*     */   private List<String> roleList;
/*     */ 
/*     */   public void setAccount(String account)
/*     */   {
/*  60 */     this.account = account;
/*     */   }
/*     */ 
/*     */   public String getAccount() {
/*  64 */     return this.account;
/*     */   }
/*     */ 
/*     */   public void setName(String name) {
/*  68 */     this.name = name;
/*     */   }
/*     */ 
/*     */   public String getName() {
/*  72 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setStatus(String status) {
/*  76 */     this.status = status;
/*     */   }
/*     */ 
/*     */   public String getStatus() {
/*  80 */     return this.status;
/*     */   }
/*     */ 
/*     */   public void setType(String type) {
/*  84 */     this.type = type;
/*     */   }
/*     */ 
/*     */   public String getType() {
/*  88 */     return this.type;
/*     */   }
/*     */ 
/*     */   public void setUserRole(String userRole) {
/*  92 */     this.userRole = userRole;
/*     */   }
/*     */ 
/*     */   public String getUserRole() {
/*  96 */     return this.userRole;
/*     */   }
/*     */ 
/*     */   public void setFundAccount(String fundAccount) {
/* 100 */     this.fundAccount = fundAccount;
/*     */   }
/*     */ 
/*     */   public String getFundAccount() {
/* 104 */     return this.fundAccount;
/*     */   }
/*     */ 
/*     */   public void setRoleList(List<String> roleList) {
/* 108 */     this.roleList = roleList;
/*     */   }
/*     */ 
/*     */   public List<String> getRoleList() {
/* 112 */     return this.roleList;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.query.UserAccountQuery
 * JD-Core Version:    0.6.0
 */