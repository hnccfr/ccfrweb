/*     */ package com.hundsun.network.gates.genshan.biz.domain.query;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.domain.trade.TradeWishOrder;
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
/*     */   private Long substationId;
/*     */ 
/*     */   public Date getGmtCreateFrom()
/*     */   {
/*  78 */     return this.gmtCreateFrom;
/*     */   }
/*     */   public void setGmtCreateFrom(Date gmtCreateFrom) {
/*  81 */     this.gmtCreateFrom = gmtCreateFrom;
/*     */   }
/*     */   public Date getGmtCreateTo() {
/*  84 */     return this.gmtCreateTo;
/*     */   }
/*     */   public void setGmtCreateTo(Date gmtCreateTo) {
/*  87 */     this.gmtCreateTo = gmtCreateTo;
/*     */   }
/*     */   public String getProjectName() {
/*  90 */     return this.projectName;
/*     */   }
/*     */   public void setProjectName(String projectName) {
/*  93 */     this.projectName = projectName;
/*     */   }
/*     */   public String getPaymentType() {
/*  96 */     return this.paymentType;
/*     */   }
/*     */   public void setPaymentType(String paymentType) {
/*  99 */     this.paymentType = paymentType;
/*     */   }
/*     */   public Date getExpectTimeFrom() {
/* 102 */     return this.expectTimeFrom;
/*     */   }
/*     */   public void setExpectTimeFrom(Date expectTimeFrom) {
/* 105 */     this.expectTimeFrom = expectTimeFrom;
/*     */   }
/*     */   public Date getExpectTimeTo() {
/* 108 */     return this.expectTimeTo;
/*     */   }
/*     */   public void setExpectTimeTo(Date expectTimeTo) {
/* 111 */     this.expectTimeTo = expectTimeTo;
/*     */   }
/*     */   public String getStatus() {
/* 114 */     return this.status;
/*     */   }
/*     */   public void setStatus(String status) {
/* 117 */     this.status = status;
/*     */   }
/*     */   public void setTradeDictor(String tradeDictor) {
/* 120 */     this.tradeDictor = tradeDictor;
/*     */   }
/*     */   public String getTradeDictor() {
/* 123 */     return this.tradeDictor;
/*     */   }
/*     */   public void setUserAccount(String userAccount) {
/* 126 */     this.userAccount = userAccount;
/*     */   }
/*     */   public String getUserAccount() {
/* 129 */     return this.userAccount;
/*     */   }
/*     */   public void setWishOrderNum(String wishOrderNum) {
/* 132 */     this.wishOrderNum = wishOrderNum;
/*     */   }
/*     */   public String getWishOrderNum() {
/* 135 */     return this.wishOrderNum;
/*     */   }
/*     */   public Long getSubstationId() {
/* 138 */     return this.substationId;
/*     */   }
/*     */   public void setSubstationId(Long substationId) {
/* 141 */     this.substationId = substationId;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.query.TradeWishOrderQuery
 * JD-Core Version:    0.6.0
 */