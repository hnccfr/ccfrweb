/*     */ package com.hundsun.network.gates.fengshan.biz.domain.query;
/*     */ 
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.order.TradeOrderCc;
/*     */ import com.hundsun.network.gates.luosi.common.page.Pagination;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class TradeOrderCcQuery extends Pagination<TradeOrderCc>
/*     */ {
/*     */   private static final long serialVersionUID = -7651925768407188584L;
/*     */   private String orderCcNum;
/*     */   private String ccType;
/*     */   private String orderNo;
/*     */   private String ccStartor;
/*     */   private String creator;
/*     */   private String complainedType;
/*     */   private String sellerAccount;
/*     */   private String buyerAccount;
/*     */   private Date gmtCreateFrom;
/*     */   private Date gmtCreateTo;
/*     */   private String status;
/*     */ 
/*     */   public void setOrderCcNum(String orderCcNum)
/*     */   {
/*  56 */     this.orderCcNum = orderCcNum;
/*     */   }
/*     */   public String getOrderCcNum() {
/*  59 */     return this.orderCcNum;
/*     */   }
/*     */   public String getOrderNo() {
/*  62 */     return this.orderNo;
/*     */   }
/*     */   public void setOrderNo(String orderNo) {
/*  65 */     this.orderNo = orderNo;
/*     */   }
/*     */   public Date getGmtCreateFrom() {
/*  68 */     return this.gmtCreateFrom;
/*     */   }
/*     */   public void setGmtCreateFrom(Date gmtCreateFrom) {
/*  71 */     this.gmtCreateFrom = gmtCreateFrom;
/*     */   }
/*     */   public Date getGmtCreateTo() {
/*  74 */     return this.gmtCreateTo;
/*     */   }
/*     */   public void setGmtCreateTo(Date gmtCreateTo) {
/*  77 */     this.gmtCreateTo = gmtCreateTo;
/*     */   }
/*     */   public void setCreator(String creator) {
/*  80 */     this.creator = creator;
/*     */   }
/*     */   public String getCreator() {
/*  83 */     return this.creator;
/*     */   }
/*     */   public void setCcStartor(String ccStartor) {
/*  86 */     this.ccStartor = ccStartor;
/*     */   }
/*     */   public String getCcStartor() {
/*  89 */     return this.ccStartor;
/*     */   }
/*     */   public void setCcType(String ccType) {
/*  92 */     this.ccType = ccType;
/*     */   }
/*     */   public String getCcType() {
/*  95 */     return this.ccType;
/*     */   }
/*     */   public String getSellerAccount() {
/*  98 */     return this.sellerAccount;
/*     */   }
/*     */   public void setSellerAccount(String sellerAccount) {
/* 101 */     this.sellerAccount = sellerAccount;
/*     */   }
/*     */   public String getBuyerAccount() {
/* 104 */     return this.buyerAccount;
/*     */   }
/*     */   public void setBuyerAccount(String buyerAccount) {
/* 107 */     this.buyerAccount = buyerAccount;
/*     */   }
/*     */   public void setComplainedType(String complainedType) {
/* 110 */     this.complainedType = complainedType;
/*     */   }
/*     */   public String getComplainedType() {
/* 113 */     return this.complainedType;
/*     */   }
/*     */   public void setStatus(String status) {
/* 116 */     this.status = status;
/*     */   }
/*     */   public String getStatus() {
/* 119 */     return this.status;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.domain.query.TradeOrderCcQuery
 * JD-Core Version:    0.6.0
 */