/*     */ package com.hundsun.network.gates.wulin.biz.domain.query;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumActiveStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumSystemDictKey;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeOrderCcType;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.order.TradeOrder;
/*     */ 
/*     */ public class TradeOrderQueryAddition extends TradeOrderQuery
/*     */ {
/*  13 */   private boolean isRemindBuyer = false;
/*     */ 
/*  18 */   private boolean isRemindSeller = false;
/*     */   private String title;
/*     */   private String content;
/*     */   private EnumTradeOrderCcType ccBuyerType;
/*     */   private EnumTradeOrderCcType ccSellerType;
/*     */   private EnumSystemDictKey key;
/*     */ 
/*     */   public boolean getIsRemindBuyer(TradeOrder order)
/*     */   {
/*  51 */     if ((EnumSystemDictKey.COMFIM_REMIND_DAYS.equals(this.key)) || (EnumSystemDictKey.CONFIM_ORDER_DAYS.equals(this.key)))
/*     */     {
/*  53 */       if (this.isRemindBuyer) {
/*  54 */         return EnumActiveStatus.No.getValue().equals(order.getHasBuyerConfirm());
/*     */       }
/*     */     }
/*  57 */     return this.isRemindBuyer;
/*     */   }
/*     */ 
/*     */   public void setIsRemindBuyer(Boolean isRemindBuyer) {
/*  61 */     this.isRemindBuyer = isRemindBuyer.booleanValue();
/*     */   }
/*     */ 
/*     */   public boolean getIsRemindSeller(TradeOrder order) {
/*  65 */     if ((EnumSystemDictKey.COMFIM_REMIND_DAYS.equals(this.key)) || (EnumSystemDictKey.CONFIM_ORDER_DAYS.equals(this.key)))
/*     */     {
/*  67 */       if (this.isRemindSeller) {
/*  68 */         return EnumActiveStatus.No.getValue().equals(order.getHasSellerConfirm());
/*     */       }
/*     */     }
/*  71 */     return this.isRemindSeller;
/*     */   }
/*     */ 
/*     */   public void setIsRemindSeller(Boolean isRemindSeller) {
/*  75 */     this.isRemindSeller = isRemindSeller.booleanValue();
/*     */   }
/*     */ 
/*     */   public String getTitle() {
/*  79 */     return this.title;
/*     */   }
/*     */ 
/*     */   public void setTitle(String title) {
/*  83 */     this.title = title;
/*     */   }
/*     */ 
/*     */   public String getContent() {
/*  87 */     return this.content;
/*     */   }
/*     */ 
/*     */   public void setContent(String content) {
/*  91 */     this.content = content;
/*     */   }
/*     */ 
/*     */   public EnumSystemDictKey getKey()
/*     */   {
/* 103 */     return this.key;
/*     */   }
/*     */ 
/*     */   public void setKey(EnumSystemDictKey key) {
/* 107 */     this.key = key;
/*     */   }
/*     */ 
/*     */   public EnumTradeOrderCcType getCcBuyerType() {
/* 111 */     return this.ccBuyerType;
/*     */   }
/*     */ 
/*     */   public void setCcBuyerType(EnumTradeOrderCcType ccBuyerType) {
/* 115 */     this.ccBuyerType = ccBuyerType;
/*     */   }
/*     */ 
/*     */   public EnumTradeOrderCcType getCcSellerType() {
/* 119 */     return this.ccSellerType;
/*     */   }
/*     */ 
/*     */   public void setCcSellerType(EnumTradeOrderCcType ccSellerType) {
/* 123 */     this.ccSellerType = ccSellerType;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.domain.query.TradeOrderQueryAddition
 * JD-Core Version:    0.6.0
 */