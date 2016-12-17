/*     */ package com.hundsun.network.gates.fengshan.biz.domain.order;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumComplainStarterType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeOrderCcStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeOrderCcType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeUserType;
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
/*     */ 
/*     */   public Long getId()
/*     */   {
/* 156 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/* 161 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getOrderCcNum() {
/* 165 */     return this.orderCcNum;
/*     */   }
/*     */ 
/*     */   public void setOrderCcNum(String orderCcNum) {
/* 169 */     this.orderCcNum = orderCcNum;
/*     */   }
/*     */ 
/*     */   public String getCcStartor() {
/* 173 */     return this.ccStartor;
/*     */   }
/*     */ 
/*     */   public void setCcStartor(String ccStartor)
/*     */   {
/* 178 */     this.ccStartor = ccStartor;
/*     */   }
/*     */ 
/*     */   public String getCcType()
/*     */   {
/* 183 */     return this.ccType;
/*     */   }
/*     */ 
/*     */   public void setCcType(String ccType)
/*     */   {
/* 188 */     this.ccType = ccType;
/*     */   }
/*     */ 
/*     */   public String getOrderNo() {
/* 192 */     return this.orderNo;
/*     */   }
/*     */ 
/*     */   public void setOrderNo(String orderNo)
/*     */   {
/* 197 */     this.orderNo = orderNo;
/*     */   }
/*     */ 
/*     */   public String getSellerAccount() {
/* 201 */     return this.sellerAccount;
/*     */   }
/*     */ 
/*     */   public void setSellerAccount(String sellerAccount) {
/* 205 */     this.sellerAccount = sellerAccount;
/*     */   }
/*     */ 
/*     */   public String getBuyerAccount() {
/* 209 */     return this.buyerAccount;
/*     */   }
/*     */ 
/*     */   public void setBuyerAccount(String buyerAccount)
/*     */   {
/* 214 */     this.buyerAccount = buyerAccount;
/*     */   }
/*     */ 
/*     */   public String getDescript() {
/* 218 */     return this.descript;
/*     */   }
/*     */ 
/*     */   public Long getSellerAmount()
/*     */   {
/* 223 */     return this.sellerAmount;
/*     */   }
/*     */ 
/*     */   public void setSellerAmount(Long sellerAmount)
/*     */   {
/* 228 */     this.sellerAmount = sellerAmount;
/*     */   }
/*     */ 
/*     */   public Integer getSellerCredit()
/*     */   {
/* 233 */     return this.sellerCredit;
/*     */   }
/*     */ 
/*     */   public void setSellerCredit(Integer sellerCredit)
/*     */   {
/* 238 */     this.sellerCredit = sellerCredit;
/*     */   }
/*     */ 
/*     */   public Long getBuyerAmount()
/*     */   {
/* 243 */     return this.buyerAmount;
/*     */   }
/*     */ 
/*     */   public void setBuyerAmount(Long buyerAmount)
/*     */   {
/* 248 */     this.buyerAmount = buyerAmount;
/*     */   }
/*     */ 
/*     */   public Integer getBuyerCredit()
/*     */   {
/* 253 */     return this.buyerCredit;
/*     */   }
/*     */ 
/*     */   public void setBuyerCredit(Integer buyerCredit)
/*     */   {
/* 258 */     this.buyerCredit = buyerCredit;
/*     */   }
/*     */ 
/*     */   public void setDescript(String descript)
/*     */   {
/* 263 */     this.descript = descript;
/*     */   }
/*     */ 
/*     */   public String getAttactment()
/*     */   {
/* 268 */     return this.attactment;
/*     */   }
/*     */ 
/*     */   public void setAttactment(String attactment) {
/* 272 */     this.attactment = attactment;
/*     */   }
/*     */ 
/*     */   public String getReason() {
/* 276 */     return this.reason;
/*     */   }
/*     */ 
/*     */   public void setReason(String reason)
/*     */   {
/* 281 */     this.reason = reason;
/*     */   }
/*     */ 
/*     */   public String getStatus()
/*     */   {
/* 286 */     return this.status;
/*     */   }
/*     */ 
/*     */   public void setStatus(String status) {
/* 290 */     this.status = status;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreator()
/*     */   {
/* 295 */     return this.gmtCreator;
/*     */   }
/*     */ 
/*     */   public void setGmtCreator(Date gmtCreator)
/*     */   {
/* 300 */     this.gmtCreator = gmtCreator;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify()
/*     */   {
/* 305 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify)
/*     */   {
/* 310 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getCreator()
/*     */   {
/* 315 */     return this.creator;
/*     */   }
/*     */ 
/*     */   public void setCreator(String creator)
/*     */   {
/* 320 */     this.creator = creator;
/*     */   }
/*     */ 
/*     */   public String getOperator()
/*     */   {
/* 325 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator)
/*     */   {
/* 330 */     this.operator = operator;
/*     */   }
/*     */ 
/*     */   public String getAuditor()
/*     */   {
/* 335 */     return this.auditor;
/*     */   }
/*     */ 
/*     */   public void setAuditor(String auditor)
/*     */   {
/* 340 */     this.auditor = auditor;
/*     */   }
/*     */ 
/*     */   public Date getAuditDate()
/*     */   {
/* 345 */     return this.auditDate;
/*     */   }
/*     */ 
/*     */   public void setAuditDate(Date auditDate)
/*     */   {
/* 350 */     this.auditDate = auditDate;
/*     */   }
/*     */ 
/*     */   public void setMessage(String message) {
/* 354 */     this.message = message;
/*     */   }
/*     */ 
/*     */   public String getMessage()
/*     */   {
/* 359 */     return this.message;
/*     */   }
/*     */ 
/*     */   public void setComplainedType(String complainedType) {
/* 363 */     this.complainedType = complainedType;
/*     */   }
/*     */ 
/*     */   public String getComplainedType()
/*     */   {
/* 368 */     return this.complainedType;
/*     */   }
/*     */ 
/*     */   public String getStatusDesc() {
/* 372 */     EnumTradeOrderCcStatus tradeOrderCcStatusEnum = EnumTradeOrderCcStatus.indexByValue(this.status);
/* 373 */     if (null == tradeOrderCcStatusEnum) {
/* 374 */       return this.status;
/*     */     }
/* 376 */     return tradeOrderCcStatusEnum.getName();
/*     */   }
/*     */ 
/*     */   public String getRemarkDesc() {
/* 380 */     return null;
/*     */   }
/*     */ 
/*     */   public void setRemark(String remark)
/*     */   {
/* 385 */     this.remark = remark;
/*     */   }
/*     */ 
/*     */   public String getRemark()
/*     */   {
/* 390 */     return this.remark;
/*     */   }
/*     */   public String getCcStartorDesc() {
/* 393 */     EnumComplainStarterType complainStarterTypeEnum = EnumComplainStarterType.indexByValue(this.ccStartor);
/* 394 */     if (null == complainStarterTypeEnum) {
/* 395 */       return this.ccStartor;
/*     */     }
/* 397 */     return complainStarterTypeEnum.getName();
/*     */   }
/*     */   public String getComplainedTypeDesc() {
/* 400 */     EnumTradeUserType complainedTypeEnum = EnumTradeUserType.indexByValue(this.complainedType);
/* 401 */     if (null == complainedTypeEnum) {
/* 402 */       return this.complainedType;
/*     */     }
/* 404 */     return complainedTypeEnum.getName();
/*     */   }
/*     */   public String getCcTypeDesc() {
/* 407 */     EnumTradeOrderCcType ccTypeEnum = EnumTradeOrderCcType.indexByValue(this.ccType);
/* 408 */     if (null == ccTypeEnum) {
/* 409 */       return this.ccType;
/*     */     }
/* 411 */     return ccTypeEnum.getName();
/*     */   }
/*     */   public String getCcStartorAccount() {
/* 414 */     if (this.ccStartor.equals(EnumComplainStarterType.BUYER.getValue()))
/* 415 */       return this.buyerAccount;
/* 416 */     if (this.ccStartor.equals(EnumComplainStarterType.SELLER.getValue()))
/* 417 */       return this.sellerAccount;
/* 418 */     if (this.ccStartor.equals(EnumComplainStarterType.SYSTEM.getValue())) {
/* 419 */       return "系统自动任务";
/*     */     }
/* 421 */     return "";
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.domain.order.TradeOrderCc
 * JD-Core Version:    0.6.0
 */