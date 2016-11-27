/*     */ package com.hundsun.network.gates.wulin.biz.domain.baseset;
/*     */ 
/*     */ import com.hundsun.network.gates.wulin.biz.domain.BaseDomain;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class SystemServicechargeSpecial extends BaseDomain
/*     */ {
/*     */   private static final long serialVersionUID = -6584075015824111756L;
/*     */   private Long id;
/*     */   private String userAccount;
/*     */   private String proTypeCode;
/*     */   private String tradingType;
/*     */   private String haveAuctioneer;
/*     */   private Long turnoverAmount;
/*     */   private Long listUnturnover;
/*     */   private Long listTurnover;
/*     */   private Long orderUnturnover;
/*     */   private Long orderTurnover;
/*     */   private Short isDel;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */   private String operator;
/*     */   private String isSystem;
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  86 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/*  90 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getUserAccount() {
/*  94 */     return this.userAccount;
/*     */   }
/*     */ 
/*     */   public void setUserAccount(String userAccount) {
/*  98 */     this.userAccount = userAccount;
/*     */   }
/*     */ 
/*     */   public String getProTypeCode() {
/* 102 */     return this.proTypeCode;
/*     */   }
/*     */ 
/*     */   public void setProTypeCode(String proTypeCode) {
/* 106 */     this.proTypeCode = proTypeCode;
/*     */   }
/*     */ 
/*     */   public Long getListUnturnover() {
/* 110 */     return this.listUnturnover;
/*     */   }
/*     */ 
/*     */   public void setListUnturnover(Long listUnturnover) {
/* 114 */     this.listUnturnover = listUnturnover;
/*     */   }
/*     */ 
/*     */   public Long getListTurnover() {
/* 118 */     return this.listTurnover;
/*     */   }
/*     */ 
/*     */   public void setListTurnover(Long listTurnover) {
/* 122 */     this.listTurnover = listTurnover;
/*     */   }
/*     */ 
/*     */   public Long getOrderUnturnover() {
/* 126 */     return this.orderUnturnover;
/*     */   }
/*     */ 
/*     */   public void setOrderUnturnover(Long orderUnturnover) {
/* 130 */     this.orderUnturnover = orderUnturnover;
/*     */   }
/*     */ 
/*     */   public Long getOrderTurnover() {
/* 134 */     return this.orderTurnover;
/*     */   }
/*     */ 
/*     */   public void setOrderTurnover(Long orderTurnover) {
/* 138 */     this.orderTurnover = orderTurnover;
/*     */   }
/*     */ 
/*     */   public Short getIsDel() {
/* 142 */     return this.isDel;
/*     */   }
/*     */ 
/*     */   public void setIsDel(Short isDel) {
/* 146 */     this.isDel = isDel;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate() {
/* 150 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate) {
/* 154 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify() {
/* 158 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify) {
/* 162 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getOperator() {
/* 166 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator) {
/* 170 */     this.operator = operator;
/*     */   }
/*     */ 
/*     */   public String getIsSystem() {
/* 174 */     return this.isSystem;
/*     */   }
/*     */ 
/*     */   public void setIsSystem(String isSystem) {
/* 178 */     this.isSystem = isSystem;
/*     */   }
/*     */ 
/*     */   public String getTradingType() {
/* 182 */     return this.tradingType;
/*     */   }
/*     */ 
/*     */   public void setTradingType(String tradingType) {
/* 186 */     this.tradingType = tradingType;
/*     */   }
/*     */ 
/*     */   public String getHaveAuctioneer() {
/* 190 */     return this.haveAuctioneer;
/*     */   }
/*     */ 
/*     */   public void setHaveAuctioneer(String haveAuctioneer) {
/* 194 */     this.haveAuctioneer = haveAuctioneer;
/*     */   }
/*     */ 
/*     */   public Long getTurnoverAmount() {
/* 198 */     return this.turnoverAmount;
/*     */   }
/*     */ 
/*     */   public void setTurnoverAmount(Long turnoverAmount) {
/* 202 */     this.turnoverAmount = turnoverAmount;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.domain.baseset.SystemServicechargeSpecial
 * JD-Core Version:    0.6.0
 */