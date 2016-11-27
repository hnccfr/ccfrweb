/*     */ package com.hundsun.network.gates.wulin.biz.domain.query;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumActiveStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeOrderStatus;
/*     */ 
/*     */ public class TradeOrderQuery
/*     */ {
/*     */   private EnumActiveStatus endDatePayStatus;
/*     */   private EnumActiveStatus endDateGoodsStatus;
/*     */   private EnumActiveStatus endDateBillStatus;
/*     */   private EnumActiveStatus endDateSendGoodsStatus;
/*     */   private long interval;
/*     */   private EnumTradeOrderStatus status;
/*     */   private EnumActiveStatus hasRank;
/*     */   private EnumActiveStatus hasConfirm;
/*     */   private Integer tradeOrderCount;
/*     */   private String projectTypeCode;
/*     */ 
/*     */   public Integer getTradeOrderCount()
/*     */   {
/*  55 */     return this.tradeOrderCount;
/*     */   }
/*     */ 
/*     */   public void setTradeOrderCount(Integer tradeOrderCount) {
/*  59 */     this.tradeOrderCount = tradeOrderCount;
/*     */   }
/*     */ 
/*     */   public String getProjectTypeCode() {
/*  63 */     return this.projectTypeCode;
/*     */   }
/*     */ 
/*     */   public void setProjectTypeCode(String projectTypeCode) {
/*  67 */     this.projectTypeCode = projectTypeCode;
/*     */   }
/*     */ 
/*     */   public EnumTradeOrderStatus getStatus() {
/*  71 */     return this.status;
/*     */   }
/*     */ 
/*     */   public void setStatus(EnumTradeOrderStatus status) {
/*  75 */     this.status = status;
/*     */   }
/*     */ 
/*     */   public EnumActiveStatus getHasRank() {
/*  79 */     return this.hasRank;
/*     */   }
/*     */ 
/*     */   public void setHasRank(EnumActiveStatus hasRank) {
/*  83 */     this.hasRank = hasRank;
/*     */   }
/*     */ 
/*     */   public EnumActiveStatus getEndDatePayStatus() {
/*  87 */     return this.endDatePayStatus;
/*     */   }
/*     */ 
/*     */   public void setEndDatePayStatus(EnumActiveStatus endDatePayStatus) {
/*  91 */     this.endDatePayStatus = endDatePayStatus;
/*     */   }
/*     */ 
/*     */   public EnumActiveStatus getEndDateGoodsStatus() {
/*  95 */     return this.endDateGoodsStatus;
/*     */   }
/*     */ 
/*     */   public void setEndDateGoodsStatus(EnumActiveStatus endDateGoodsStatus) {
/*  99 */     this.endDateGoodsStatus = endDateGoodsStatus;
/*     */   }
/*     */ 
/*     */   public EnumActiveStatus getEndDateBillStatus() {
/* 103 */     return this.endDateBillStatus;
/*     */   }
/*     */ 
/*     */   public void setEndDateBillStatus(EnumActiveStatus endDateBillStatus) {
/* 107 */     this.endDateBillStatus = endDateBillStatus;
/*     */   }
/*     */ 
/*     */   public EnumActiveStatus getEndDateSendGoodsStatus() {
/* 111 */     return this.endDateSendGoodsStatus;
/*     */   }
/*     */ 
/*     */   public void setEndDateSendGoodsStatus(EnumActiveStatus endDateSendGoodsStatus) {
/* 115 */     this.endDateSendGoodsStatus = endDateSendGoodsStatus;
/*     */   }
/*     */ 
/*     */   public long getInterval() {
/* 119 */     return this.interval;
/*     */   }
/*     */ 
/*     */   public void setInterval(Long interval) {
/* 123 */     this.interval = interval.longValue();
/*     */   }
/*     */ 
/*     */   public EnumActiveStatus getHasConfirm() {
/* 127 */     return this.hasConfirm;
/*     */   }
/*     */ 
/*     */   public void setHasConfirm(EnumActiveStatus hasConfirm) {
/* 131 */     this.hasConfirm = hasConfirm;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.domain.query.TradeOrderQuery
 * JD-Core Version:    0.6.0
 */