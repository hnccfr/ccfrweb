/*     */ package com.hundsun.network.gates.houchao.biz.domain.fund;
/*     */ 
/*     */ import com.hundsun.network.gates.houchao.biz.domain.BaseDomain;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class FundAccount extends BaseDomain
/*     */ {
/*     */   private static final long serialVersionUID = 8120418669446036117L;
/*     */   private Long id;
/*     */   private String fundAccount;
/*     */   private String clientId;
/*     */   private String bankNo;
/*     */   private Date gmtOpend;
/*     */   private Date gmtClosed;
/*     */   private String status;
/*     */   private Date gmtCreate;
/*     */   private String createId;
/*     */   private Date gmtModify;
/*     */   private String modifyId;
/*     */   private String memo;
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  66 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/*  70 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getFundAccount() {
/*  74 */     return this.fundAccount;
/*     */   }
/*     */ 
/*     */   public void setFundAccount(String fundAccount) {
/*  78 */     this.fundAccount = fundAccount;
/*     */   }
/*     */ 
/*     */   public String getClientId() {
/*  82 */     return this.clientId;
/*     */   }
/*     */ 
/*     */   public void setClientId(String clientId) {
/*  86 */     this.clientId = clientId;
/*     */   }
/*     */ 
/*     */   public Date getGmtOpend() {
/*  90 */     return this.gmtOpend;
/*     */   }
/*     */ 
/*     */   public void setGmtOpened(Date gmtOpend) {
/*  94 */     this.gmtOpend = gmtOpend;
/*     */   }
/*     */ 
/*     */   public String getBankNo() {
/*  98 */     return this.bankNo;
/*     */   }
/*     */ 
/*     */   public void setBankNo(String bankNo) {
/* 102 */     this.bankNo = bankNo;
/*     */   }
/*     */ 
/*     */   public Date getGmtClosed() {
/* 106 */     return this.gmtClosed;
/*     */   }
/*     */ 
/*     */   public void setGmtClosed(Date gmtClosed) {
/* 110 */     this.gmtClosed = gmtClosed;
/*     */   }
/*     */ 
/*     */   public String getStatus() {
/* 114 */     return this.status;
/*     */   }
/*     */ 
/*     */   public void setStatus(String status) {
/* 118 */     this.status = status;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate() {
/* 122 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate) {
/* 126 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public String getCreateId() {
/* 130 */     return this.createId;
/*     */   }
/*     */ 
/*     */   public void setCreateId(String createId) {
/* 134 */     this.createId = createId;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify() {
/* 138 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify) {
/* 142 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getModifyId() {
/* 146 */     return this.modifyId;
/*     */   }
/*     */ 
/*     */   public void setModifyId(String modifyId) {
/* 150 */     this.modifyId = modifyId;
/*     */   }
/*     */ 
/*     */   public String getMemo() {
/* 154 */     return this.memo;
/*     */   }
/*     */ 
/*     */   public void setMemo(String memo) {
/* 158 */     this.memo = memo;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\houchao\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.houchao.biz.domain.fund.FundAccount
 * JD-Core Version:    0.6.0
 */