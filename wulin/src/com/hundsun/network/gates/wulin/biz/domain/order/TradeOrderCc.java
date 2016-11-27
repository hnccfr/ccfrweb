/*     */ package com.hundsun.network.gates.wulin.biz.domain.order;
/*     */ 
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
/*     */ 
/*     */   public Long getId()
/*     */   {
/* 213 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/* 225 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getOrderCcNum()
/*     */   {
/* 237 */     return this.orderCcNum;
/*     */   }
/*     */ 
/*     */   public void setOrderCcNum(String orderCcNum)
/*     */   {
/* 249 */     this.orderCcNum = orderCcNum;
/*     */   }
/*     */ 
/*     */   public String getCcStartor()
/*     */   {
/* 261 */     return this.ccStartor;
/*     */   }
/*     */ 
/*     */   public void setCcStartor(String ccStartor)
/*     */   {
/* 273 */     this.ccStartor = ccStartor;
/*     */   }
/*     */ 
/*     */   public String getCcType()
/*     */   {
/* 285 */     return this.ccType;
/*     */   }
/*     */ 
/*     */   public void setCcType(String ccType)
/*     */   {
/* 297 */     this.ccType = ccType;
/*     */   }
/*     */ 
/*     */   public String getOrderNo()
/*     */   {
/* 309 */     return this.orderNo;
/*     */   }
/*     */ 
/*     */   public void setOrderNo(String orderNo)
/*     */   {
/* 321 */     this.orderNo = orderNo;
/*     */   }
/*     */ 
/*     */   public String getSellerAccount()
/*     */   {
/* 333 */     return this.sellerAccount;
/*     */   }
/*     */ 
/*     */   public void setSellerAccount(String sellerAccount)
/*     */   {
/* 345 */     this.sellerAccount = sellerAccount;
/*     */   }
/*     */ 
/*     */   public String getBuyerAccount()
/*     */   {
/* 357 */     return this.buyerAccount;
/*     */   }
/*     */ 
/*     */   public void setBuyerAccount(String buyerAccount)
/*     */   {
/* 369 */     this.buyerAccount = buyerAccount;
/*     */   }
/*     */ 
/*     */   public String getDescript()
/*     */   {
/* 381 */     return this.descript;
/*     */   }
/*     */ 
/*     */   public void setDescript(String descript)
/*     */   {
/* 393 */     this.descript = descript;
/*     */   }
/*     */ 
/*     */   public String getAttactment()
/*     */   {
/* 405 */     return this.attactment;
/*     */   }
/*     */ 
/*     */   public void setAttactment(String attactment)
/*     */   {
/* 417 */     this.attactment = attactment;
/*     */   }
/*     */ 
/*     */   public String getReason()
/*     */   {
/* 430 */     return this.reason;
/*     */   }
/*     */ 
/*     */   public void setReason(String reason)
/*     */   {
/* 442 */     this.reason = reason;
/*     */   }
/*     */ 
/*     */   public String getStatus()
/*     */   {
/* 454 */     return this.status;
/*     */   }
/*     */ 
/*     */   public void setStatus(String status)
/*     */   {
/* 466 */     this.status = status;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreator()
/*     */   {
/* 478 */     return this.gmtCreator;
/*     */   }
/*     */ 
/*     */   public void setGmtCreator(Date gmtCreator)
/*     */   {
/* 490 */     this.gmtCreator = gmtCreator;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify()
/*     */   {
/* 502 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify)
/*     */   {
/* 514 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getCreator()
/*     */   {
/* 526 */     return this.creator;
/*     */   }
/*     */ 
/*     */   public void setCreator(String creator)
/*     */   {
/* 538 */     this.creator = creator;
/*     */   }
/*     */ 
/*     */   public String getOperator()
/*     */   {
/* 550 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator)
/*     */   {
/* 562 */     this.operator = operator;
/*     */   }
/*     */ 
/*     */   public String getAuditor()
/*     */   {
/* 574 */     return this.auditor;
/*     */   }
/*     */ 
/*     */   public void setAuditor(String auditor)
/*     */   {
/* 586 */     this.auditor = auditor;
/*     */   }
/*     */ 
/*     */   public Date getAuditDate()
/*     */   {
/* 598 */     return this.auditDate;
/*     */   }
/*     */ 
/*     */   public void setAuditDate(Date auditDate)
/*     */   {
/* 610 */     this.auditDate = auditDate;
/*     */   }
/*     */ 
/*     */   public void setMessage(String message)
/*     */   {
/* 624 */     this.message = message;
/*     */   }
/*     */ 
/*     */   public String getMessage() {
/* 628 */     return this.message;
/*     */   }
/*     */ 
/*     */   public void setComplainedType(String complainedType) {
/* 632 */     this.complainedType = complainedType;
/*     */   }
/*     */ 
/*     */   public String getComplainedType() {
/* 636 */     return this.complainedType;
/*     */   }
/*     */ 
/*     */   public void setRemark(String remark) {
/* 640 */     this.remark = remark;
/*     */   }
/*     */ 
/*     */   public String getRemark() {
/* 644 */     return this.remark;
/*     */   }
/*     */ 
/*     */   public Long getSellerAmount() {
/* 648 */     return this.sellerAmount;
/*     */   }
/*     */ 
/*     */   public void setSellerAmount(Long sellerAmount) {
/* 652 */     this.sellerAmount = sellerAmount;
/*     */   }
/*     */ 
/*     */   public Integer getSellerCredit() {
/* 656 */     return this.sellerCredit;
/*     */   }
/*     */ 
/*     */   public void setSellerCredit(Integer sellerCredit) {
/* 660 */     this.sellerCredit = sellerCredit;
/*     */   }
/*     */ 
/*     */   public Long getBuyerAmount() {
/* 664 */     return this.buyerAmount;
/*     */   }
/*     */ 
/*     */   public void setBuyerAmount(Long buyerAmount) {
/* 668 */     this.buyerAmount = buyerAmount;
/*     */   }
/*     */ 
/*     */   public Integer getBuyerCredit() {
/* 672 */     return this.buyerCredit;
/*     */   }
/*     */ 
/*     */   public void setBuyerCredit(Integer buyerCredit) {
/* 676 */     this.buyerCredit = buyerCredit;
/*     */   }
/*     */ 
/*     */   public void setDealType(String dealType) {
/* 680 */     this.dealType = dealType;
/*     */   }
/*     */ 
/*     */   public String getDealType() {
/* 684 */     return this.dealType;
/*     */   }
/*     */ 
/*     */   public void setDealMoney(String dealMoney) {
/* 688 */     this.dealMoney = dealMoney;
/*     */   }
/*     */ 
/*     */   public String getDealMoney() {
/* 692 */     return this.dealMoney;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.domain.order.TradeOrderCc
 * JD-Core Version:    0.6.0
 */