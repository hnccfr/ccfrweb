/*     */ package com.hundsun.eclp.biz.domain.sys;
/*     */ 
/*     */ import com.hundsun.eclp.client.remote.dto.WorkLogDTO;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class WorkLog
/*     */ {
/*     */   private Long id;
/*     */   private Long userId;
/*     */   private String account;
/*     */   private String operatorType;
/*     */   private String remark;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */   private String name;
/*     */   private String subSystemCode;
/*     */ 
/*     */   public WorkLog()
/*     */   {
/*     */   }
/*     */ 
/*     */   public WorkLog(WorkLogDTO dto, String subSystemCode)
/*     */   {
/*  45 */     this.account = dto.getAccount();
/*  46 */     this.userId = dto.getUserid();
/*  47 */     this.operatorType = dto.getOperationType();
/*  48 */     this.remark = dto.getRemark();
/*  49 */     this.subSystemCode = subSystemCode;
/*     */   }
/*     */ 
/*     */   public Long getId() {
/*  53 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/*  57 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public Long getUserId() {
/*  61 */     return this.userId;
/*     */   }
/*     */ 
/*     */   public void setUserId(Long userId) {
/*  65 */     this.userId = userId;
/*     */   }
/*     */ 
/*     */   public String getAccount() {
/*  69 */     return this.account;
/*     */   }
/*     */ 
/*     */   public void setAccount(String account) {
/*  73 */     this.account = account;
/*     */   }
/*     */ 
/*     */   public String getOperatorType() {
/*  77 */     return this.operatorType;
/*     */   }
/*     */ 
/*     */   public void setOperatorType(String operatorType) {
/*  81 */     this.operatorType = operatorType;
/*     */   }
/*     */ 
/*     */   public String getRemark() {
/*  85 */     return this.remark;
/*     */   }
/*     */ 
/*     */   public void setRemark(String remark) {
/*  89 */     this.remark = remark;
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
/*     */   public Date getGmtModify() {
/* 101 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify) {
/* 105 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getName() {
/* 109 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setName(String name) {
/* 113 */     this.name = name;
/*     */   }
/*     */ 
/*     */   public String getSubSystemCode() {
/* 117 */     return this.subSystemCode;
/*     */   }
/*     */ 
/*     */   public void setSubSystemCode(String subSystemCode) {
/* 121 */     this.subSystemCode = subSystemCode;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.domain.sys.WorkLog
 * JD-Core Version:    0.6.0
 */