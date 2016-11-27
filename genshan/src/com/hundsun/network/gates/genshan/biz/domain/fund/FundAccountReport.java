/*     */ package com.hundsun.network.gates.genshan.biz.domain.fund;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.page.Pagination;
/*     */ 
/*     */ public class FundAccountReport extends Pagination<FundAccountLog>
/*     */ {
/*     */   private static final long serialVersionUID = -6084288339277797698L;
/*     */   private String fundAccount;
/*     */   private String userAccount;
/*     */   private String tradeDate;
/*     */   private String moneyType;
/*     */   private Long amount;
/*     */   private Long beginAmount;
/*     */   private Long currAmount;
/*     */   private Long freezeTotal;
/*     */   private Long openAmout;
/*     */   private Long closeAmount;
/*     */   private Long fundinAmount;
/*     */   private Long fundoutAmount;
/*     */   private Long writeofAmount;
/*     */   private Long goodsFinal;
/*     */   private Long goodsFundin;
/*     */   private Long goodsFundout;
/*     */   private Long penaltyFundin;
/*     */   private Long penaltyFundout;
/*     */   private Long commissionFundin;
/*     */   private Long commissionFundout;
/*     */   private Long freezeDeposit;
/*     */   private Long unfreezeDeposit;
/*     */   private Long deliveryFreezedeposit;
/*     */   private Long deliveryUnfreezedeposit;
/*     */   private Long commissionAmount;
/*     */   private Long useBalance;
/*     */ 
/*     */   public Long getGoodsAmount()
/*     */   {
/* 134 */     return Long.valueOf(this.goodsFundin.longValue() + getGoodsFinal().longValue());
/*     */   }
/*     */ 
/*     */   public Long getUseAmount()
/*     */   {
/* 142 */     return Long.valueOf(this.amount.longValue() + this.freezeTotal.longValue());
/*     */   }
/*     */ 
/*     */   public String getFundAccount() {
/* 146 */     return this.fundAccount;
/*     */   }
/*     */   public void setFundAccount(String fundAccount) {
/* 149 */     this.fundAccount = fundAccount;
/*     */   }
/*     */   public String getTradeDate() {
/* 152 */     return this.tradeDate;
/*     */   }
/*     */   public void setTradeDate(String tradeDate) {
/* 155 */     this.tradeDate = tradeDate;
/*     */   }
/*     */   public String getMoneyType() {
/* 158 */     return this.moneyType;
/*     */   }
/*     */   public void setMoneyType(String moneyType) {
/* 161 */     this.moneyType = moneyType;
/*     */   }
/*     */   public Long getAmount() {
/* 164 */     return this.amount;
/*     */   }
/*     */   public void setAmount(Long amount) {
/* 167 */     this.amount = amount;
/*     */   }
/*     */   public Long getCurrAmount() {
/* 170 */     return this.currAmount;
/*     */   }
/*     */   public void setCurrAmount(Long currAmount) {
/* 173 */     this.currAmount = currAmount;
/*     */   }
/*     */   public Long getFreezeTotal() {
/* 176 */     return this.freezeTotal;
/*     */   }
/*     */   public void setFreezeTotal(Long freezeTotal) {
/* 179 */     this.freezeTotal = freezeTotal;
/*     */   }
/*     */   public Long getOpenAmout() {
/* 182 */     return this.openAmout;
/*     */   }
/*     */   public void setOpenAmout(Long openAmout) {
/* 185 */     this.openAmout = openAmout;
/*     */   }
/*     */   public Long getCloseAmount() {
/* 188 */     return this.closeAmount;
/*     */   }
/*     */   public void setCloseAmount(Long closeAmount) {
/* 191 */     this.closeAmount = closeAmount;
/*     */   }
/*     */   public Long getFundinAmount() {
/* 194 */     return this.fundinAmount;
/*     */   }
/*     */   public void setFundinAmount(Long fundinAmount) {
/* 197 */     this.fundinAmount = fundinAmount;
/*     */   }
/*     */   public Long getFundoutAmount() {
/* 200 */     return this.fundoutAmount;
/*     */   }
/*     */   public void setFundoutAmount(Long fundoutAmount) {
/* 203 */     this.fundoutAmount = fundoutAmount;
/*     */   }
/*     */   public Long getWriteofAmount() {
/* 206 */     return this.writeofAmount;
/*     */   }
/*     */   public void setWriteofAmount(Long writeofAmount) {
/* 209 */     this.writeofAmount = writeofAmount;
/*     */   }
/*     */   public Long getGoodsFinal() {
/* 212 */     return this.goodsFinal;
/*     */   }
/*     */   public void setGoodsFinal(Long goodsFinal) {
/* 215 */     this.goodsFinal = goodsFinal;
/*     */   }
/*     */   public Long getGoodsFundin() {
/* 218 */     return this.goodsFundin;
/*     */   }
/*     */   public void setGoodsFundin(Long goodsFundin) {
/* 221 */     this.goodsFundin = goodsFundin;
/*     */   }
/*     */   public Long getGoodsFundout() {
/* 224 */     return this.goodsFundout;
/*     */   }
/*     */   public void setGoodsFundout(Long goodsFundout) {
/* 227 */     this.goodsFundout = goodsFundout;
/*     */   }
/*     */   public Long getPenaltyFundin() {
/* 230 */     return this.penaltyFundin;
/*     */   }
/*     */   public void setPenaltyFundin(Long penaltyFundin) {
/* 233 */     this.penaltyFundin = penaltyFundin;
/*     */   }
/*     */   public Long getPenaltyFundout() {
/* 236 */     return this.penaltyFundout;
/*     */   }
/*     */   public void setPenaltyFundout(Long penaltyFundout) {
/* 239 */     this.penaltyFundout = penaltyFundout;
/*     */   }
/*     */   public Long getCommissionFundin() {
/* 242 */     return this.commissionFundin;
/*     */   }
/*     */   public void setCommissionFundin(Long commissionFundin) {
/* 245 */     this.commissionFundin = commissionFundin;
/*     */   }
/*     */   public Long getCommissionFundout() {
/* 248 */     return this.commissionFundout;
/*     */   }
/*     */   public void setCommissionFundout(Long commissionFundout) {
/* 251 */     this.commissionFundout = commissionFundout;
/*     */   }
/*     */   public Long getFreezeDeposit() {
/* 254 */     return this.freezeDeposit;
/*     */   }
/*     */   public void setFreezeDeposit(Long freezeDeposit) {
/* 257 */     this.freezeDeposit = freezeDeposit;
/*     */   }
/*     */   public Long getUnfreezeDeposit() {
/* 260 */     return this.unfreezeDeposit;
/*     */   }
/*     */   public void setUnfreezeDeposit(Long unfreezeDeposit) {
/* 263 */     this.unfreezeDeposit = unfreezeDeposit;
/*     */   }
/*     */   public Long getDeliveryFreezedeposit() {
/* 266 */     return this.deliveryFreezedeposit;
/*     */   }
/*     */   public void setDeliveryFreezedeposit(Long deliveryFreezedeposit) {
/* 269 */     this.deliveryFreezedeposit = deliveryFreezedeposit;
/*     */   }
/*     */   public Long getDeliveryUnfreezedeposit() {
/* 272 */     return this.deliveryUnfreezedeposit;
/*     */   }
/*     */   public void setDeliveryUnfreezedeposit(Long deliveryUnfreezedeposit) {
/* 275 */     this.deliveryUnfreezedeposit = deliveryUnfreezedeposit;
/*     */   }
/*     */   public Long getCommissionAmount() {
/* 278 */     return this.commissionAmount;
/*     */   }
/*     */   public void setCommissionAmount(Long commissionAmount) {
/* 281 */     this.commissionAmount = commissionAmount;
/*     */   }
/*     */   public Long getBeginAmount() {
/* 284 */     return this.beginAmount;
/*     */   }
/*     */   public void setBeginAmount(Long beginAmount) {
/* 287 */     this.beginAmount = beginAmount;
/*     */   }
/*     */   public Long getUseBalance() {
/* 290 */     return this.useBalance;
/*     */   }
/*     */   public void setUseBalance(Long useBalance) {
/* 293 */     this.useBalance = useBalance;
/*     */   }
/*     */ 
/*     */   public String getUserAccount() {
/* 297 */     return this.userAccount;
/*     */   }
/*     */ 
/*     */   public void setUserAccount(String userAccount) {
/* 301 */     this.userAccount = userAccount;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.fund.FundAccountReport
 * JD-Core Version:    0.6.0
 */