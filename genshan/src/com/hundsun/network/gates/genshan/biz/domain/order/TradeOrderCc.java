/*     */ package com.hundsun.network.gates.genshan.biz.domain.order;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumComplainStarterType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeOrderCcStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeOrderCcType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeUserType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumValuationUnit;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class TradeOrderCc
/*     */ {
/*     */   private Long id;
/*     */   private String orderCcNum;
/*     */   private String ccStartor;
/*     */   private String ccType;
/*     */   private String orderNo;
/*     */   private String sellerAccount;
/*     */   private String buyerAccount;
/*     */   private String descript;
/*     */   private String attactment;
/*     */   private Long sellerAmount;
/*     */   private Integer sellerCredit;
/*     */   private Long buyerAmount;
/*     */   private Integer buyerCredit;
/*     */   private String reason;
/*     */   private String status;
/*     */   private Date gmtCreator;
/*     */   private Date gmtModify;
/*     */   private String creator;
/*     */   private String operator;
/*     */   private String auditor;
/*     */   private Date auditDate;
/*     */   private String remark;
/*     */   private String message;
/*     */   private String complainedType;
/*     */   private String dealType;
/*     */   private String dealMoney;
/*     */   private String moneyUnite;
/*     */   private Long amount;
/*     */ 
/*     */   public Long getId()
/*     */   {
/* 173 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/* 178 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getOrderCcNum() {
/* 182 */     return this.orderCcNum;
/*     */   }
/*     */ 
/*     */   public void setOrderCcNum(String orderCcNum) {
/* 186 */     this.orderCcNum = orderCcNum;
/*     */   }
/*     */ 
/*     */   public String getCcStartor() {
/* 190 */     return this.ccStartor;
/*     */   }
/*     */ 
/*     */   public void setCcStartor(String ccStartor)
/*     */   {
/* 195 */     this.ccStartor = ccStartor;
/*     */   }
/*     */ 
/*     */   public String getCcType()
/*     */   {
/* 200 */     return this.ccType;
/*     */   }
/*     */ 
/*     */   public void setCcType(String ccType)
/*     */   {
/* 205 */     this.ccType = ccType;
/*     */   }
/*     */ 
/*     */   public String getOrderNo() {
/* 209 */     return this.orderNo;
/*     */   }
/*     */ 
/*     */   public void setOrderNo(String orderNo)
/*     */   {
/* 214 */     this.orderNo = orderNo;
/*     */   }
/*     */ 
/*     */   public String getSellerAccount() {
/* 218 */     return this.sellerAccount;
/*     */   }
/*     */ 
/*     */   public void setSellerAccount(String sellerAccount) {
/* 222 */     this.sellerAccount = sellerAccount;
/*     */   }
/*     */ 
/*     */   public String getBuyerAccount() {
/* 226 */     return this.buyerAccount;
/*     */   }
/*     */ 
/*     */   public void setBuyerAccount(String buyerAccount)
/*     */   {
/* 231 */     this.buyerAccount = buyerAccount;
/*     */   }
/*     */ 
/*     */   public String getDescript() {
/* 235 */     return this.descript;
/*     */   }
/*     */ 
/*     */   public void setDescript(String descript)
/*     */   {
/* 240 */     this.descript = descript;
/*     */   }
/*     */ 
/*     */   public String getAttactment()
/*     */   {
/* 245 */     return this.attactment;
/*     */   }
/*     */ 
/*     */   public void setAttactment(String attactment) {
/* 249 */     this.attactment = attactment;
/*     */   }
/*     */ 
/*     */   public String getReason() {
/* 253 */     return this.reason;
/*     */   }
/*     */ 
/*     */   public void setReason(String reason)
/*     */   {
/* 258 */     this.reason = reason;
/*     */   }
/*     */ 
/*     */   public String getStatus()
/*     */   {
/* 263 */     return this.status;
/*     */   }
/*     */ 
/*     */   public void setStatus(String status) {
/* 267 */     this.status = status;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreator()
/*     */   {
/* 272 */     return this.gmtCreator;
/*     */   }
/*     */ 
/*     */   public void setGmtCreator(Date gmtCreator)
/*     */   {
/* 277 */     this.gmtCreator = gmtCreator;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify()
/*     */   {
/* 282 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify)
/*     */   {
/* 287 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getCreator()
/*     */   {
/* 292 */     return this.creator;
/*     */   }
/*     */ 
/*     */   public void setCreator(String creator)
/*     */   {
/* 297 */     this.creator = creator;
/*     */   }
/*     */ 
/*     */   public String getOperator()
/*     */   {
/* 302 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator)
/*     */   {
/* 307 */     this.operator = operator;
/*     */   }
/*     */ 
/*     */   public String getAuditor()
/*     */   {
/* 312 */     return this.auditor;
/*     */   }
/*     */ 
/*     */   public void setAuditor(String auditor)
/*     */   {
/* 317 */     this.auditor = auditor;
/*     */   }
/*     */ 
/*     */   public Date getAuditDate()
/*     */   {
/* 322 */     return this.auditDate;
/*     */   }
/*     */ 
/*     */   public void setAuditDate(Date auditDate)
/*     */   {
/* 327 */     this.auditDate = auditDate;
/*     */   }
/*     */ 
/*     */   public void setMessage(String message) {
/* 331 */     this.message = message;
/*     */   }
/*     */ 
/*     */   public String getMessage()
/*     */   {
/* 336 */     return this.message;
/*     */   }
/*     */ 
/*     */   public void setComplainedType(String complainedType) {
/* 340 */     this.complainedType = complainedType;
/*     */   }
/*     */ 
/*     */   public String getComplainedType()
/*     */   {
/* 345 */     return this.complainedType;
/*     */   }
/*     */ 
/*     */   public String getRemarkDesc() {
/* 349 */     return null;
/*     */   }
/*     */ 
/*     */   public void setRemark(String remark) {
/* 353 */     this.remark = remark;
/*     */   }
/*     */ 
/*     */   public String getRemark() {
/* 357 */     return this.remark;
/*     */   }
/*     */   public Long getSellerAmount() {
/* 360 */     return this.sellerAmount;
/*     */   }
/*     */ 
/*     */   public void setSellerAmount(Long sellerAmount)
/*     */   {
/* 365 */     this.sellerAmount = sellerAmount;
/*     */   }
/*     */ 
/*     */   public Integer getSellerCredit()
/*     */   {
/* 370 */     return this.sellerCredit;
/*     */   }
/*     */ 
/*     */   public void setSellerCredit(Integer sellerCredit)
/*     */   {
/* 375 */     this.sellerCredit = sellerCredit;
/*     */   }
/*     */ 
/*     */   public Long getBuyerAmount()
/*     */   {
/* 380 */     return this.buyerAmount;
/*     */   }
/*     */ 
/*     */   public void setBuyerAmount(Long buyerAmount)
/*     */   {
/* 385 */     this.buyerAmount = buyerAmount;
/*     */   }
/*     */ 
/*     */   public Integer getBuyerCredit()
/*     */   {
/* 390 */     return this.buyerCredit;
/*     */   }
/*     */ 
/*     */   public void setBuyerCredit(Integer buyerCredit)
/*     */   {
/* 395 */     this.buyerCredit = buyerCredit;
/*     */   }
/*     */ 
/*     */   public void setDealType(String dealType) {
/* 399 */     this.dealType = dealType;
/*     */   }
/*     */ 
/*     */   public String getDealType()
/*     */   {
/* 404 */     return this.dealType;
/*     */   }
/*     */ 
/*     */   public String getStatusDesc() {
/* 408 */     EnumTradeOrderCcStatus tradeOrderCcStatusEnum = EnumTradeOrderCcStatus.indexByValue(this.status);
/* 409 */     if (null == tradeOrderCcStatusEnum) {
/* 410 */       return this.status;
/*     */     }
/* 412 */     return tradeOrderCcStatusEnum.getName();
/*     */   }
/*     */   public String getCcStartorDesc() {
/* 415 */     EnumComplainStarterType complainStarterTypeEnum = EnumComplainStarterType.indexByValue(this.ccStartor);
/* 416 */     if (null == complainStarterTypeEnum) {
/* 417 */       return this.ccStartor;
/*     */     }
/* 419 */     return complainStarterTypeEnum.getName();
/*     */   }
/*     */   public String getComplainedTypeDesc() {
/* 422 */     EnumTradeUserType complainedTypeEnum = EnumTradeUserType.indexByValue(this.complainedType);
/* 423 */     if (null == complainedTypeEnum) {
/* 424 */       return this.complainedType;
/*     */     }
/* 426 */     return complainedTypeEnum.getName();
/*     */   }
/*     */   public String getCcTypeDesc() {
/* 429 */     EnumTradeOrderCcType ccTypeEnum = EnumTradeOrderCcType.indexByValue(this.ccType);
/* 430 */     if (null == ccTypeEnum) {
/* 431 */       return this.ccType;
/*     */     }
/* 433 */     return ccTypeEnum.getName();
/*     */   }
/*     */ 
/*     */   public void setDealMoney(String dealMoney)
/*     */   {
/* 438 */     this.dealMoney = dealMoney;
/*     */   }
/*     */ 
/*     */   public String getDealMoney()
/*     */   {
/* 443 */     return this.dealMoney;
/*     */   }
/*     */ 
/*     */   public void setMoneyUnite(String moneyUnite) {
/* 447 */     this.moneyUnite = moneyUnite;
/*     */   }
/*     */ 
/*     */   public String getMoneyUnite()
/*     */   {
/* 452 */     return this.moneyUnite;
/*     */   }
/*     */   public String getMoneyUniteDesc() {
/* 455 */     EnumValuationUnit uniteEnum = EnumValuationUnit.indexByValue(this.moneyUnite);
/* 456 */     if (null == uniteEnum) {
/* 457 */       return this.moneyUnite;
/*     */     }
/* 459 */     return uniteEnum.getName();
/*     */   }
/*     */ 
/*     */   public void setAmount(Long amount)
/*     */   {
/* 464 */     this.amount = amount;
/*     */   }
/*     */ 
/*     */   public Long getAmount()
/*     */   {
/* 469 */     return this.amount;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.order.TradeOrderCc
 * JD-Core Version:    0.6.0
 */