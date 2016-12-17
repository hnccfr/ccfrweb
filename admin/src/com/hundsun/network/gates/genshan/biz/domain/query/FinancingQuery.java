/*     */ package com.hundsun.network.gates.genshan.biz.domain.query;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.domain.financing.Financing;
/*     */ import com.hundsun.network.gates.luosi.common.page.Pagination;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class FinancingQuery extends Pagination<Financing>
/*     */ {
/*     */   private static final long serialVersionUID = 3543157279489999270L;
/*     */   private String code;
/*     */   private String title;
/*     */   private String status;
/*     */   private String userAccount;
/*     */   private String userName;
/*     */   private Date gmtApplyL;
/*     */   private Date gmtApplyR;
/*     */ 
/*     */   public String getCode()
/*     */   {
/*  51 */     return this.code;
/*     */   }
/*     */ 
/*     */   public void setCode(String code) {
/*  55 */     this.code = code;
/*     */   }
/*     */ 
/*     */   public String getStatus() {
/*  59 */     return this.status;
/*     */   }
/*     */ 
/*     */   public void setStatus(String status) {
/*  63 */     this.status = status;
/*     */   }
/*     */ 
/*     */   public String getUserAccount() {
/*  67 */     return this.userAccount;
/*     */   }
/*     */ 
/*     */   public void setUserAccount(String userAccount) {
/*  71 */     this.userAccount = userAccount;
/*     */   }
/*     */ 
/*     */   public String getUserName() {
/*  75 */     return this.userName;
/*     */   }
/*     */ 
/*     */   public void setUserName(String userName) {
/*  79 */     this.userName = userName;
/*     */   }
/*     */ 
/*     */   public Date getGmtApplyL() {
/*  83 */     return this.gmtApplyL;
/*     */   }
/*     */ 
/*     */   public void setGmtApplyL(Date gmtApplyL) {
/*  87 */     this.gmtApplyL = gmtApplyL;
/*     */   }
/*     */ 
/*     */   public Date getGmtApplyR() {
/*  91 */     return this.gmtApplyR;
/*     */   }
/*     */ 
/*     */   public void setGmtApplyR(Date gmtApplyR) {
/*  95 */     this.gmtApplyR = gmtApplyR;
/*     */   }
/*     */ 
/*     */   public void trim() {
/*  99 */     if ((this.code != null) && (this.code.length() > 0)) {
/* 100 */       this.code = this.code.trim();
/*     */     }
/* 102 */     if ((this.userName != null) && (this.userName.length() > 0))
/* 103 */       this.userName = this.userName.trim();
/*     */   }
/*     */ 
/*     */   public String getTitle()
/*     */   {
/* 108 */     return this.title;
/*     */   }
/*     */ 
/*     */   public void setTitle(String title) {
/* 112 */     this.title = title;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.query.FinancingQuery
 * JD-Core Version:    0.6.0
 */