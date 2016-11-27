/*     */ package com.hundsun.network.gates.genshan.biz.domain.auction;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumValuationUnit;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class AuctionResult
/*     */ {
/*     */   private Long id;
/*     */   private String projectCode;
/*     */   private String tranResult;
/*     */   private Long price;
/*     */   private String priceDesc;
/*     */   private String auctioneerAccount;
/*     */   private String valuationUnit;
/*     */   private String bidderAccount;
/*     */   private String bidderTrademark;
/*     */   private Date endTime;
/*     */   private String remark;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */   private String operator;
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  71 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/*  75 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getProjectCode()
/*     */   {
/*  82 */     return this.projectCode;
/*     */   }
/*     */ 
/*     */   public void setProjectCode(String projectCode)
/*     */   {
/*  89 */     this.projectCode = projectCode;
/*     */   }
/*     */ 
/*     */   public String getTranResult()
/*     */   {
/*  98 */     return this.tranResult;
/*     */   }
/*     */ 
/*     */   public void setTranResult(String tranResult)
/*     */   {
/* 107 */     this.tranResult = tranResult;
/*     */   }
/*     */ 
/*     */   public Long getPrice()
/*     */   {
/* 116 */     return this.price;
/*     */   }
/*     */ 
/*     */   public void setPrice(Long price)
/*     */   {
/* 125 */     this.price = price;
/*     */   }
/*     */ 
/*     */   public String getAuctioneerAccount()
/*     */   {
/* 132 */     return this.auctioneerAccount;
/*     */   }
/*     */ 
/*     */   public void setAuctioneerAccount(String auctioneerAccount)
/*     */   {
/* 139 */     this.auctioneerAccount = auctioneerAccount;
/*     */   }
/*     */ 
/*     */   public String getValuationUnit()
/*     */   {
/* 146 */     return this.valuationUnit;
/*     */   }
/*     */ 
/*     */   public String getValuationUnitDes() {
/* 150 */     EnumValuationUnit valuationUnitEnum = EnumValuationUnit.indexByValue(this.valuationUnit);
/* 151 */     if (null == valuationUnitEnum) {
/* 152 */       return this.valuationUnit;
/*     */     }
/* 154 */     return valuationUnitEnum.getName();
/*     */   }
/*     */ 
/*     */   public void setValuationUnit(String valuationUnit)
/*     */   {
/* 161 */     this.valuationUnit = valuationUnit;
/*     */   }
/*     */ 
/*     */   public String getBidderAccount()
/*     */   {
/* 168 */     return this.bidderAccount;
/*     */   }
/*     */ 
/*     */   public void setBidderAccount(String bidderAccount)
/*     */   {
/* 175 */     this.bidderAccount = bidderAccount;
/*     */   }
/*     */ 
/*     */   public String getBidderTrademark()
/*     */   {
/* 182 */     return this.bidderTrademark;
/*     */   }
/*     */ 
/*     */   public void setBidderTrademark(String bidderTrademark)
/*     */   {
/* 189 */     this.bidderTrademark = bidderTrademark;
/*     */   }
/*     */ 
/*     */   public Date getEndTime()
/*     */   {
/* 196 */     return this.endTime;
/*     */   }
/*     */ 
/*     */   public void setEndTime(Date endTime)
/*     */   {
/* 203 */     this.endTime = endTime;
/*     */   }
/*     */ 
/*     */   public String getRemark()
/*     */   {
/* 210 */     return this.remark;
/*     */   }
/*     */ 
/*     */   public void setRemark(String remark)
/*     */   {
/* 217 */     this.remark = remark;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate() {
/* 221 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate) {
/* 225 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify() {
/* 229 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify) {
/* 233 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getOperator()
/*     */   {
/* 240 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator)
/*     */   {
/* 247 */     this.operator = operator;
/*     */   }
/*     */ 
/*     */   public String getPriceDesc() {
/* 251 */     return this.priceDesc;
/*     */   }
/*     */ 
/*     */   public void setPriceDesc(String priceDesc) {
/* 255 */     this.priceDesc = priceDesc;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.auction.AuctionResult
 * JD-Core Version:    0.6.0
 */