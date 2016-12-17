/*     */ package com.hundsun.network.gates.houchao.biz.domain.fund;
/*     */ 
/*     */ import com.hundsun.network.gates.houchao.biz.domain.BaseDomain;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class FundMoneyTotalHis extends BaseDomain
/*     */ {
/*     */   private static final long serialVersionUID = 8666313657510780570L;
/*     */   private Long id;
/*     */   private String tradeDate;
/*     */   private String fundAccount;
/*     */   private String transSubCode;
/*     */   private Long totalAmount;
/*     */   private Date gmtCreate;
/*     */   private String createId;
/*     */   private Date gmtModify;
/*     */   private String modifyId;
/*     */   private String memo;
/*     */   private String moneyType;
/*     */   private Long amount;
/*     */   private Long beginAmount;
/*     */   private Long currAmount;
/*     */   private Long useBalance;
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
/*     */ 
/*     */   public Long getId()
/*     */   {
/* 154 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/* 158 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getTradeDate() {
/* 162 */     return this.tradeDate;
/*     */   }
/*     */ 
/*     */   public void setTradeDate(String tradeDate) {
/* 166 */     this.tradeDate = tradeDate;
/*     */   }
/*     */ 
/*     */   public String getFundAccount() {
/* 170 */     return this.fundAccount;
/*     */   }
/*     */ 
/*     */   public void setFundAccount(String fundAccount) {
/* 174 */     this.fundAccount = fundAccount;
/*     */   }
/*     */ 
/*     */   public String getTransSubCode() {
/* 178 */     return this.transSubCode;
/*     */   }
/*     */ 
/*     */   public void setTransSubCode(String transSubCode) {
/* 182 */     this.transSubCode = transSubCode;
/*     */   }
/*     */ 
/*     */   public Long getTotalAmount() {
/* 186 */     return this.totalAmount;
/*     */   }
/*     */ 
/*     */   public void setTotalAmount(Long totalAmount) {
/* 190 */     this.totalAmount = totalAmount;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate() {
/* 194 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate) {
/* 198 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public String getCreateId() {
/* 202 */     return this.createId;
/*     */   }
/*     */ 
/*     */   public void setCreateId(String createId) {
/* 206 */     this.createId = createId;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify() {
/* 210 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify) {
/* 214 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getModifyId() {
/* 218 */     return this.modifyId;
/*     */   }
/*     */ 
/*     */   public void setModifyId(String modifyId) {
/* 222 */     this.modifyId = modifyId;
/*     */   }
/*     */ 
/*     */   public String getMemo() {
/* 226 */     return this.memo;
/*     */   }
/*     */ 
/*     */   public void setMemo(String memo) {
/* 230 */     this.memo = memo;
/*     */   }
/*     */ 
/*     */   public String getMoneyType() {
/* 234 */     return this.moneyType;
/*     */   }
/*     */ 
/*     */   public void setMoneyType(String moneyType) {
/* 238 */     this.moneyType = moneyType;
/*     */   }
/*     */ 
/*     */   public Long getAmount() {
/* 242 */     return this.amount;
/*     */   }
/*     */ 
/*     */   public void setAmount(Long amount) {
/* 246 */     this.amount = amount;
/*     */   }
/*     */ 
/*     */   public Long getBeginAmount() {
/* 250 */     return this.beginAmount;
/*     */   }
/*     */ 
/*     */   public void setBeginAmount(Long beginAmount) {
/* 254 */     this.beginAmount = beginAmount;
/*     */   }
/*     */ 
/*     */   public Long getFreezeTotal() {
/* 258 */     return this.freezeTotal;
/*     */   }
/*     */ 
/*     */   public void setFreezeTotal(Long freezeTotal) {
/* 262 */     this.freezeTotal = freezeTotal;
/*     */   }
/*     */ 
/*     */   public Long getOpenAmout() {
/* 266 */     return this.openAmout;
/*     */   }
/*     */ 
/*     */   public void setOpenAmout(Long openAmout) {
/* 270 */     this.openAmout = openAmout;
/*     */   }
/*     */ 
/*     */   public Long getCloseAmount() {
/* 274 */     return this.closeAmount;
/*     */   }
/*     */ 
/*     */   public void setCloseAmount(Long closeAmount) {
/* 278 */     this.closeAmount = closeAmount;
/*     */   }
/*     */ 
/*     */   public Long getFundinAmount() {
/* 282 */     return this.fundinAmount;
/*     */   }
/*     */ 
/*     */   public void setFundinAmount(Long fundinAmount) {
/* 286 */     this.fundinAmount = fundinAmount;
/*     */   }
/*     */ 
/*     */   public Long getFundoutAmount() {
/* 290 */     return this.fundoutAmount;
/*     */   }
/*     */ 
/*     */   public void setFundoutAmount(Long fundoutAmount) {
/* 294 */     this.fundoutAmount = fundoutAmount;
/*     */   }
/*     */ 
/*     */   public Long getWriteofAmount() {
/* 298 */     return this.writeofAmount;
/*     */   }
/*     */ 
/*     */   public void setWriteofAmount(Long writeofAmount) {
/* 302 */     this.writeofAmount = writeofAmount;
/*     */   }
/*     */ 
/*     */   public Long getGoodsFinal() {
/* 306 */     return this.goodsFinal;
/*     */   }
/*     */ 
/*     */   public void setGoodsFinal(Long goodsFinal) {
/* 310 */     this.goodsFinal = goodsFinal;
/*     */   }
/*     */ 
/*     */   public Long getGoodsFundin() {
/* 314 */     return this.goodsFundin;
/*     */   }
/*     */ 
/*     */   public void setGoodsFundin(Long goodsFundin) {
/* 318 */     this.goodsFundin = goodsFundin;
/*     */   }
/*     */ 
/*     */   public Long getGoodsFundout() {
/* 322 */     return this.goodsFundout;
/*     */   }
/*     */ 
/*     */   public void setGoodsFundout(Long goodsFundout) {
/* 326 */     this.goodsFundout = goodsFundout;
/*     */   }
/*     */ 
/*     */   public Long getPenaltyFundin() {
/* 330 */     return this.penaltyFundin;
/*     */   }
/*     */ 
/*     */   public void setPenaltyFundin(Long penaltyFundin) {
/* 334 */     this.penaltyFundin = penaltyFundin;
/*     */   }
/*     */ 
/*     */   public Long getPenaltyFundout() {
/* 338 */     return this.penaltyFundout;
/*     */   }
/*     */ 
/*     */   public void setPenaltyFundout(Long penaltyFundout) {
/* 342 */     this.penaltyFundout = penaltyFundout;
/*     */   }
/*     */ 
/*     */   public Long getCommissionFundin() {
/* 346 */     return this.commissionFundin;
/*     */   }
/*     */ 
/*     */   public void setCommissionFundin(Long commissionFundin) {
/* 350 */     this.commissionFundin = commissionFundin;
/*     */   }
/*     */ 
/*     */   public Long getCommissionFundout() {
/* 354 */     return this.commissionFundout;
/*     */   }
/*     */ 
/*     */   public void setCommissionFundout(Long commissionFundout) {
/* 358 */     this.commissionFundout = commissionFundout;
/*     */   }
/*     */ 
/*     */   public Long getFreezeDeposit() {
/* 362 */     return this.freezeDeposit;
/*     */   }
/*     */ 
/*     */   public void setFreezeDeposit(Long freezeDeposit) {
/* 366 */     this.freezeDeposit = freezeDeposit;
/*     */   }
/*     */ 
/*     */   public Long getUnfreezeDeposit() {
/* 370 */     return this.unfreezeDeposit;
/*     */   }
/*     */ 
/*     */   public void setUnfreezeDeposit(Long unfreezeDeposit) {
/* 374 */     this.unfreezeDeposit = unfreezeDeposit;
/*     */   }
/*     */ 
/*     */   public Long getDeliveryFreezedeposit() {
/* 378 */     return this.deliveryFreezedeposit;
/*     */   }
/*     */ 
/*     */   public void setDeliveryFreezedeposit(Long deliveryFreezedeposit) {
/* 382 */     this.deliveryFreezedeposit = deliveryFreezedeposit;
/*     */   }
/*     */ 
/*     */   public Long getDeliveryUnfreezedeposit() {
/* 386 */     return this.deliveryUnfreezedeposit;
/*     */   }
/*     */ 
/*     */   public void setDeliveryUnfreezedeposit(Long deliveryUnfreezedeposit) {
/* 390 */     this.deliveryUnfreezedeposit = deliveryUnfreezedeposit;
/*     */   }
/*     */ 
/*     */   public Long getCurrAmount() {
/* 394 */     return this.currAmount;
/*     */   }
/*     */ 
/*     */   public void setCurrAmount(Long currAmount) {
/* 398 */     this.currAmount = currAmount;
/*     */   }
/*     */ 
/*     */   public Long getUseBalance() {
/* 402 */     return this.useBalance;
/*     */   }
/*     */ 
/*     */   public void setUseBalance(Long useBalance) {
/* 406 */     this.useBalance = useBalance;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\houchao\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.houchao.biz.domain.fund.FundMoneyTotalHis
 * JD-Core Version:    0.6.0
 */