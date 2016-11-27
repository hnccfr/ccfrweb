/*     */ package com.hundsun.network.gates.genshan.biz.domain.baseset;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradingType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumYesOrNo;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class SystemServicechargeSpecial
/*     */ {
/*     */   private Long id;
/*     */   private String userAccount;
/*     */   private String proTypeCode;
/*     */   private String tradingType;
/*     */   private String haveAuctioneer;
/*     */   private Long turnoverAmount;
/*     */   private String proTypeName;
/*     */   private Double listUnturnover;
/*     */   private Double listTurnover;
/*     */   private Double orderUnturnover;
/*     */   private Double orderTurnover;
/*     */   private Short isDel;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */   private String operator;
/*     */   private String isSystem;
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  90 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/*  94 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getUserAccount() {
/*  98 */     return this.userAccount;
/*     */   }
/*     */ 
/*     */   public void setUserAccount(String userAccount) {
/* 102 */     this.userAccount = userAccount;
/*     */   }
/*     */ 
/*     */   public String getProTypeCode() {
/* 106 */     return this.proTypeCode;
/*     */   }
/*     */ 
/*     */   public void setProTypeCode(String proTypeCode) {
/* 110 */     this.proTypeCode = proTypeCode;
/*     */   }
/*     */ 
/*     */   public Double getListUnturnover() {
/* 114 */     return this.listUnturnover;
/*     */   }
/*     */ 
/*     */   public void setListUnturnover(Double listUnturnover) {
/* 118 */     this.listUnturnover = listUnturnover;
/*     */   }
/*     */ 
/*     */   public Double getListTurnover() {
/* 122 */     return this.listTurnover;
/*     */   }
/*     */ 
/*     */   public void setListTurnover(Double listTurnover) {
/* 126 */     this.listTurnover = listTurnover;
/*     */   }
/*     */ 
/*     */   public Double getOrderUnturnover() {
/* 130 */     return this.orderUnturnover;
/*     */   }
/*     */ 
/*     */   public void setOrderUnturnover(Double orderUnturnover) {
/* 134 */     this.orderUnturnover = orderUnturnover;
/*     */   }
/*     */ 
/*     */   public Double getOrderTurnover() {
/* 138 */     return this.orderTurnover;
/*     */   }
/*     */ 
/*     */   public void setOrderTurnover(Double orderTurnover) {
/* 142 */     this.orderTurnover = orderTurnover;
/*     */   }
/*     */ 
/*     */   public Short getIsDel() {
/* 146 */     return this.isDel;
/*     */   }
/*     */ 
/*     */   public void setIsDel(Short isDel) {
/* 150 */     this.isDel = isDel;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate() {
/* 154 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate) {
/* 158 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify() {
/* 162 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify) {
/* 166 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getOperator() {
/* 170 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator) {
/* 174 */     this.operator = operator;
/*     */   }
/*     */ 
/*     */   public String getIsSystem() {
/* 178 */     return this.isSystem;
/*     */   }
/*     */ 
/*     */   public void setIsSystem(String isSystem) {
/* 182 */     this.isSystem = isSystem;
/*     */   }
/*     */ 
/*     */   public String getProTypeName() {
/* 186 */     return this.proTypeName;
/*     */   }
/*     */ 
/*     */   public void setProTypeName(String proTypeName) {
/* 190 */     this.proTypeName = proTypeName;
/*     */   }
/*     */ 
/*     */   public String getTradingType() {
/* 194 */     return this.tradingType;
/*     */   }
/*     */ 
/*     */   public void setTradingType(String tradingType) {
/* 198 */     this.tradingType = tradingType;
/*     */   }
/*     */ 
/*     */   public String getHaveAuctioneer() {
/* 202 */     return this.haveAuctioneer;
/*     */   }
/*     */ 
/*     */   public void setHaveAuctioneer(String haveAuctioneer) {
/* 206 */     this.haveAuctioneer = haveAuctioneer;
/*     */   }
/*     */ 
/*     */   public Long getTurnoverAmount() {
/* 210 */     return this.turnoverAmount;
/*     */   }
/*     */ 
/*     */   public void setTurnoverAmount(Long turnoverAmount) {
/* 214 */     this.turnoverAmount = turnoverAmount;
/*     */   }
/*     */ 
/*     */   public String getTradingTypeName() {
/* 218 */     EnumTradingType sEnum = EnumTradingType.indexByValue(this.tradingType);
/* 219 */     if (sEnum == null) {
/* 220 */       return this.tradingType;
/*     */     }
/* 222 */     return sEnum.getName();
/*     */   }
/*     */ 
/*     */   public String getHaveAuctioneerCon() {
/* 226 */     EnumYesOrNo sEnum = EnumYesOrNo.indexByValue(this.haveAuctioneer);
/* 227 */     if (sEnum == null) {
/* 228 */       return this.haveAuctioneer;
/*     */     }
/* 230 */     return sEnum.getName();
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.baseset.SystemServicechargeSpecial
 * JD-Core Version:    0.6.0
 */