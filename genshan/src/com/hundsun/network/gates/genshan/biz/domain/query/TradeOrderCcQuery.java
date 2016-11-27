/*     */ package com.hundsun.network.gates.genshan.biz.domain.query;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.domain.order.TradeOrderCc;
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
/*  62 */     this.orderCcNum = orderCcNum;
/*     */   }
/*     */   public String getOrderCcNum() {
/*  65 */     return this.orderCcNum;
/*     */   }
/*     */   public String getOrderNo() {
/*  68 */     return this.orderNo;
/*     */   }
/*     */   public void setOrderNo(String orderNo) {
/*  71 */     this.orderNo = orderNo;
/*     */   }
/*     */   public Date getGmtCreateFrom() {
/*  74 */     return this.gmtCreateFrom;
/*     */   }
/*     */   public void setGmtCreateFrom(Date gmtCreateFrom) {
/*  77 */     this.gmtCreateFrom = gmtCreateFrom;
/*     */   }
/*     */   public Date getGmtCreateTo() {
/*  80 */     return this.gmtCreateTo;
/*     */   }
/*     */   public void setGmtCreateTo(Date gmtCreateTo) {
/*  83 */     this.gmtCreateTo = gmtCreateTo;
/*     */   }
/*     */   public void setCreator(String creator) {
/*  86 */     this.creator = creator;
/*     */   }
/*     */   public String getCreator() {
/*  89 */     return this.creator;
/*     */   }
/*     */   public void setCcStartor(String ccStartor) {
/*  92 */     this.ccStartor = ccStartor;
/*     */   }
/*     */   public String getCcStartor() {
/*  95 */     return this.ccStartor;
/*     */   }
/*     */   public void setCcType(String ccType) {
/*  98 */     this.ccType = ccType;
/*     */   }
/*     */   public String getCcType() {
/* 101 */     return this.ccType;
/*     */   }
/*     */   public String getSellerAccount() {
/* 104 */     return this.sellerAccount;
/*     */   }
/*     */   public void setSellerAccount(String sellerAccount) {
/* 107 */     this.sellerAccount = sellerAccount;
/*     */   }
/*     */   public String getBuyerAccount() {
/* 110 */     return this.buyerAccount;
/*     */   }
/*     */   public void setBuyerAccount(String buyerAccount) {
/* 113 */     this.buyerAccount = buyerAccount;
/*     */   }
/*     */   public void setComplainedType(String complainedType) {
/* 116 */     this.complainedType = complainedType;
/*     */   }
/*     */   public String getComplainedType() {
/* 119 */     return this.complainedType;
/*     */   }
/*     */   public void setStatus(String status) {
/* 122 */     this.status = status;
/*     */   }
/*     */   public String getStatus() {
/* 125 */     return this.status;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.query.TradeOrderCcQuery
 * JD-Core Version:    0.6.0
 */