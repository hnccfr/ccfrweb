/*     */ package com.hundsun.network.gates.wulin.biz.domain.order;
/*     */ 
/*     */ import java.util.Date;
/*     */ 
/*     */ public class TradeOrderLog
/*     */ {
/*     */   private Long id;
/*     */   private String orderNo;
/*     */   private String preOrderStatus;
/*     */   private String orderStatus;
/*     */   private String operator;
/*     */   private String operType;
/*     */   private String remark;
/*     */   private Date gmtCreate;
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  47 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/*  51 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getOrderNo() {
/*  55 */     return this.orderNo;
/*     */   }
/*     */ 
/*     */   public void setOrderNo(String orderNo) {
/*  59 */     this.orderNo = orderNo;
/*     */   }
/*     */ 
/*     */   public String getPreOrderStatus() {
/*  63 */     return this.preOrderStatus;
/*     */   }
/*     */ 
/*     */   public void setPreOrderStatus(String preOrderStatus) {
/*  67 */     this.preOrderStatus = preOrderStatus;
/*     */   }
/*     */ 
/*     */   public String getOrderStatus() {
/*  71 */     return this.orderStatus;
/*     */   }
/*     */ 
/*     */   public void setOrderStatus(String orderStatus) {
/*  75 */     this.orderStatus = orderStatus;
/*     */   }
/*     */ 
/*     */   public String getOperator() {
/*  79 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator) {
/*  83 */     this.operator = operator;
/*     */   }
/*     */ 
/*     */   public String getOperType() {
/*  87 */     return this.operType;
/*     */   }
/*     */ 
/*     */   public void setOperType(String operType) {
/*  91 */     this.operType = operType;
/*     */   }
/*     */ 
/*     */   public String getRemark() {
/*  95 */     return this.remark;
/*     */   }
/*     */ 
/*     */   public void setRemark(String remark) {
/*  99 */     this.remark = remark;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate() {
/* 103 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate) {
/* 107 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.domain.order.TradeOrderLog
 * JD-Core Version:    0.6.0
 */