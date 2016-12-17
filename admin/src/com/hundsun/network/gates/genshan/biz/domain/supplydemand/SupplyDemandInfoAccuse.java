/*     */ package com.hundsun.network.gates.genshan.biz.domain.supplydemand;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.domain.BaseDomain;
/*     */ import com.hundsun.network.gates.genshan.biz.enums.AccuseStatusEnum;
/*     */ import com.hundsun.network.gates.genshan.biz.enums.AccuseTypeEnum;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class SupplyDemandInfoAccuse extends BaseDomain
/*     */ {
/*     */   private static final long serialVersionUID = -3848485716634319653L;
/*     */   private Long id;
/*     */   private Long infoId;
/*     */   private String type;
/*     */   private String reason;
/*     */   private String status;
/*     */   private String accuser;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */   private String title;
/*     */ 
/*     */   public String getTitle()
/*     */   {
/*  33 */     return this.title;
/*     */   }
/*     */ 
/*     */   public void setTitle(String title) {
/*  37 */     this.title = title;
/*     */   }
/*     */ 
/*     */   public Long getId() {
/*  41 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/*  45 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public Long getInfoId() {
/*  49 */     return this.infoId;
/*     */   }
/*     */ 
/*     */   public void setInfoId(Long infoId) {
/*  53 */     this.infoId = infoId;
/*     */   }
/*     */ 
/*     */   public String getType() {
/*  57 */     return this.type;
/*     */   }
/*     */ 
/*     */   public void setType(String type) {
/*  61 */     this.type = type;
/*     */   }
/*     */ 
/*     */   public String getReason() {
/*  65 */     return this.reason;
/*     */   }
/*     */ 
/*     */   public void setReason(String reason) {
/*  69 */     this.reason = reason;
/*     */   }
/*     */ 
/*     */   public String getStatus() {
/*  73 */     return this.status;
/*     */   }
/*     */ 
/*     */   public void setStatus(String status) {
/*  77 */     this.status = status;
/*     */   }
/*     */ 
/*     */   public String getAccuser() {
/*  81 */     return this.accuser;
/*     */   }
/*     */ 
/*     */   public void setAccuser(String accuser) {
/*  85 */     this.accuser = accuser;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate() {
/*  89 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate) {
/*  93 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify() {
/*  97 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify) {
/* 101 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getAccuseStatusDesc()
/*     */   {
/* 113 */     AccuseStatusEnum accuseStatusEnum = AccuseStatusEnum.indexByValue(this.status);
/* 114 */     if (null == accuseStatusEnum) {
/* 115 */       return this.status;
/*     */     }
/* 117 */     return accuseStatusEnum.getName();
/*     */   }
/*     */ 
/*     */   public String getAccuseTypeDesc()
/*     */   {
/* 129 */     AccuseTypeEnum accuseTypeEnum = AccuseTypeEnum.indexByValue(this.type);
/* 130 */     if (null == accuseTypeEnum) {
/* 131 */       return this.type;
/*     */     }
/* 133 */     return accuseTypeEnum.getName();
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.supplydemand.SupplyDemandInfoAccuse
 * JD-Core Version:    0.6.0
 */