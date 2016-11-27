/*     */ package com.hundsun.network.gates.fengshan.biz.domain.query;
/*     */ 
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.trade.TradeWishOrder;
/*     */ import com.hundsun.network.gates.luosi.common.page.Pagination;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class TradeWishOrderQuery extends Pagination<TradeWishOrder>
/*     */ {
/*     */   private static final long serialVersionUID = 5328030764132200261L;
/*     */   private Date gmtCreateFrom;
/*     */   private Date gmtCreateTo;
/*     */   private String wishOrderNum;
/*     */   private String projectName;
/*     */   private String tradeDictor;
/*     */   private String userAccount;
/*     */   private String paymentType;
/*     */   private Date expectTimeFrom;
/*     */   private Date expectTimeTo;
/*     */   private String status;
/*     */ 
/*     */   public Date getGmtCreateFrom()
/*     */   {
/*  73 */     return this.gmtCreateFrom;
/*     */   }
/*     */   public void setGmtCreateFrom(Date gmtCreateFrom) {
/*  76 */     this.gmtCreateFrom = gmtCreateFrom;
/*     */   }
/*     */   public Date getGmtCreateTo() {
/*  79 */     return this.gmtCreateTo;
/*     */   }
/*     */   public void setGmtCreateTo(Date gmtCreateTo) {
/*  82 */     this.gmtCreateTo = gmtCreateTo;
/*     */   }
/*     */   public String getProjectName() {
/*  85 */     return this.projectName;
/*     */   }
/*     */   public void setProjectName(String projectName) {
/*  88 */     this.projectName = projectName;
/*     */   }
/*     */   public String getPaymentType() {
/*  91 */     return this.paymentType;
/*     */   }
/*     */   public void setPaymentType(String paymentType) {
/*  94 */     this.paymentType = paymentType;
/*     */   }
/*     */   public Date getExpectTimeFrom() {
/*  97 */     return this.expectTimeFrom;
/*     */   }
/*     */   public void setExpectTimeFrom(Date expectTimeFrom) {
/* 100 */     this.expectTimeFrom = expectTimeFrom;
/*     */   }
/*     */   public Date getExpectTimeTo() {
/* 103 */     return this.expectTimeTo;
/*     */   }
/*     */   public void setExpectTimeTo(Date expectTimeTo) {
/* 106 */     this.expectTimeTo = expectTimeTo;
/*     */   }
/*     */   public String getStatus() {
/* 109 */     return this.status;
/*     */   }
/*     */   public void setStatus(String status) {
/* 112 */     this.status = status;
/*     */   }
/*     */   public void setTradeDictor(String tradeDictor) {
/* 115 */     this.tradeDictor = tradeDictor;
/*     */   }
/*     */   public String getTradeDictor() {
/* 118 */     return this.tradeDictor;
/*     */   }
/*     */   public void setUserAccount(String userAccount) {
/* 121 */     this.userAccount = userAccount;
/*     */   }
/*     */   public String getUserAccount() {
/* 124 */     return this.userAccount;
/*     */   }
/*     */   public void setWishOrderNum(String wishOrderNum) {
/* 127 */     this.wishOrderNum = wishOrderNum;
/*     */   }
/*     */   public String getWishOrderNum() {
/* 130 */     return this.wishOrderNum;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.domain.query.TradeWishOrderQuery
 * JD-Core Version:    0.6.0
 */