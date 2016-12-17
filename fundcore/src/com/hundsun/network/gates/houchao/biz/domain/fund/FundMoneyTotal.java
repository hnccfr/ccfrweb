/*     */ package com.hundsun.network.gates.houchao.biz.domain.fund;
/*     */ 
/*     */ import com.hundsun.network.gates.houchao.biz.domain.BaseDomain;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class FundMoneyTotal extends BaseDomain
/*     */ {
/*     */   private static final long serialVersionUID = 8666313657510780570L;
/*     */   private Long id;
/*     */   private String fundAccount;
/*     */   private String transDate;
/*     */   private String transSubCode;
/*     */   private Long totalAmount;
/*     */   private Date gmtCreate;
/*     */   private String createId;
/*     */   private Date gmtModify;
/*     */   private String modifyId;
/*     */   private String memo;
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  61 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/*  65 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getFundAccount() {
/*  69 */     return this.fundAccount;
/*     */   }
/*     */ 
/*     */   public void setFundAccount(String fundAccount) {
/*  73 */     this.fundAccount = fundAccount;
/*     */   }
/*     */ 
/*     */   public String getTransSubCode() {
/*  77 */     return this.transSubCode;
/*     */   }
/*     */ 
/*     */   public void setTransSubCode(String transSubCode) {
/*  81 */     this.transSubCode = transSubCode;
/*     */   }
/*     */ 
/*     */   public Long getTotalAmount() {
/*  85 */     return this.totalAmount;
/*     */   }
/*     */ 
/*     */   public void setTotalAmount(Long totalAmount) {
/*  89 */     this.totalAmount = totalAmount;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate() {
/*  93 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate) {
/*  97 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public String getCreateId() {
/* 101 */     return this.createId;
/*     */   }
/*     */ 
/*     */   public void setCreateId(String createId) {
/* 105 */     this.createId = createId;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify() {
/* 109 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify) {
/* 113 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getModifyId() {
/* 117 */     return this.modifyId;
/*     */   }
/*     */ 
/*     */   public void setModifyId(String modifyId) {
/* 121 */     this.modifyId = modifyId;
/*     */   }
/*     */ 
/*     */   public String getMemo() {
/* 125 */     return this.memo;
/*     */   }
/*     */ 
/*     */   public void setMemo(String memo) {
/* 129 */     this.memo = memo;
/*     */   }
/*     */ 
/*     */   public String getTransDate() {
/* 133 */     return this.transDate;
/*     */   }
/*     */ 
/*     */   public void setTransDate(String transDate) {
/* 137 */     this.transDate = transDate;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\houchao\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.houchao.biz.domain.fund.FundMoneyTotal
 * JD-Core Version:    0.6.0
 */