/*    */ package com.hundsun.network.gates.genshan.biz.domain.query;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.domain.baseset.SystemServicechargeSpecial;
/*    */ import com.hundsun.network.gates.luosi.common.page.Pagination;
/*    */ 
/*    */ public class SystemServicechargeSpecialQuery extends Pagination<SystemServicechargeSpecial>
/*    */ {
/*    */   private static final long serialVersionUID = 2136102502701961523L;
/*    */   private String isDel;
/*    */   private String operator;
/*    */   private String userAccount;
/*    */   private String proTypeCode;
/*    */   private String sleProTypeName;
/*    */   private String tradingType;
/*    */   private String haveAuctioneer;
/*    */   private Long turnoverAmount;
/*    */   private Long noneId;
/*    */ 
/*    */   public String getIsDel()
/*    */   {
/* 22 */     return this.isDel;
/*    */   }
/*    */   public void setIsDel(String isDel) {
/* 25 */     this.isDel = isDel;
/*    */   }
/*    */   public String getOperator() {
/* 28 */     return this.operator;
/*    */   }
/*    */   public void setOperator(String operator) {
/* 31 */     this.operator = operator;
/*    */   }
/*    */   public String getUserAccount() {
/* 34 */     return this.userAccount;
/*    */   }
/*    */   public void setUserAccount(String userAccount) {
/* 37 */     this.userAccount = userAccount;
/*    */   }
/*    */   public String getProTypeCode() {
/* 40 */     return this.proTypeCode;
/*    */   }
/*    */   public void setProTypeCode(String proTypeCode) {
/* 43 */     this.proTypeCode = proTypeCode;
/*    */   }
/*    */   public Long getNoneId() {
/* 46 */     return this.noneId;
/*    */   }
/*    */   public void setNoneId(Long noneId) {
/* 49 */     this.noneId = noneId;
/*    */   }
/*    */   public String getSleProTypeName() {
/* 52 */     return this.sleProTypeName;
/*    */   }
/*    */   public void setSleProTypeName(String sleProTypeName) {
/* 55 */     this.sleProTypeName = sleProTypeName;
/*    */   }
/*    */   public String getTradingType() {
/* 58 */     return this.tradingType;
/*    */   }
/*    */   public void setTradingType(String tradingType) {
/* 61 */     this.tradingType = tradingType;
/*    */   }
/*    */   public String getHaveAuctioneer() {
/* 64 */     return this.haveAuctioneer;
/*    */   }
/*    */   public void setHaveAuctioneer(String haveAuctioneer) {
/* 67 */     this.haveAuctioneer = haveAuctioneer;
/*    */   }
/*    */   public Long getTurnoverAmount() {
/* 70 */     return this.turnoverAmount;
/*    */   }
/*    */   public void setTurnoverAmount(Long turnoverAmount) {
/* 73 */     this.turnoverAmount = turnoverAmount;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.query.SystemServicechargeSpecialQuery
 * JD-Core Version:    0.6.0
 */