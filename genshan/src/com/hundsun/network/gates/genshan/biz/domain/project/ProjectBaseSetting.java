/*     */ package com.hundsun.network.gates.genshan.biz.domain.project;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.domain.BaseDomain;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumProcessAuditNodes;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradingType;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class ProjectBaseSetting extends BaseDomain
/*     */ {
/*     */   private static final long serialVersionUID = -3528588573995280980L;
/*     */   private Long id;
/*     */   private String proTypeCode;
/*     */   private String proTypeName;
/*     */   private String tradingType;
/*     */   private String memberLevel;
/*     */   private String memberLevelName;
/*     */   private Long goodComment;
/*     */   private Long badComment;
/*     */   private String listingCheckProcess;
/*     */   private String intentionCheckProcess;
/*     */   private Double listingJyProportion;
/*     */   private Double listingJsProportion;
/*     */   private Double orderJyProportion;
/*     */   private Double orderJsProportion;
/*     */   private String enable;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */   private String operator;
/*     */ 
/*     */   public Long getId()
/*     */   {
/* 109 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/* 116 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getProTypeCode()
/*     */   {
/* 123 */     return this.proTypeCode;
/*     */   }
/*     */ 
/*     */   public void setProTypeCode(String proTypeCode)
/*     */   {
/* 130 */     this.proTypeCode = proTypeCode;
/*     */   }
/*     */ 
/*     */   public String getMemberLevel()
/*     */   {
/* 138 */     return this.memberLevel;
/*     */   }
/*     */ 
/*     */   public String getTradingType() {
/* 142 */     return this.tradingType;
/*     */   }
/*     */ 
/*     */   public void setTradingType(String tradingType) {
/* 146 */     this.tradingType = tradingType;
/*     */   }
/*     */ 
/*     */   public void setMemberLevel(String memberLevel) {
/* 150 */     this.memberLevel = memberLevel;
/*     */   }
/*     */ 
/*     */   public Long getGoodComment()
/*     */   {
/* 157 */     return this.goodComment;
/*     */   }
/*     */ 
/*     */   public void setGoodComment(Long goodComment)
/*     */   {
/* 164 */     this.goodComment = goodComment;
/*     */   }
/*     */ 
/*     */   public Long getBadComment()
/*     */   {
/* 171 */     return this.badComment;
/*     */   }
/*     */ 
/*     */   public void setBadComment(Long badComment)
/*     */   {
/* 178 */     this.badComment = badComment;
/*     */   }
/*     */ 
/*     */   public String getListingCheckProcess()
/*     */   {
/* 185 */     return this.listingCheckProcess;
/*     */   }
/*     */ 
/*     */   public void setListingCheckProcess(String listingCheckProcess)
/*     */   {
/* 192 */     this.listingCheckProcess = listingCheckProcess;
/*     */   }
/*     */ 
/*     */   public String getIntentionCheckProcess()
/*     */   {
/* 199 */     return this.intentionCheckProcess;
/*     */   }
/*     */ 
/*     */   public void setIntentionCheckProcess(String intentionCheckProcess)
/*     */   {
/* 206 */     this.intentionCheckProcess = intentionCheckProcess;
/*     */   }
/*     */ 
/*     */   public Double getListingJyProportion()
/*     */   {
/* 215 */     return this.listingJyProportion;
/*     */   }
/*     */ 
/*     */   public void setListingJyProportion(Double listingJyProportion)
/*     */   {
/* 224 */     this.listingJyProportion = listingJyProportion;
/*     */   }
/*     */ 
/*     */   public Double getListingJsProportion()
/*     */   {
/* 233 */     return this.listingJsProportion;
/*     */   }
/*     */ 
/*     */   public void setListingJsProportion(Double listingJsProportion)
/*     */   {
/* 242 */     this.listingJsProportion = listingJsProportion;
/*     */   }
/*     */ 
/*     */   public Double getOrderJyProportion()
/*     */   {
/* 249 */     return this.orderJyProportion;
/*     */   }
/*     */ 
/*     */   public void setOrderJyProportion(Double orderJyProportion)
/*     */   {
/* 256 */     this.orderJyProportion = orderJyProportion;
/*     */   }
/*     */ 
/*     */   public Double getOrderJsProportion()
/*     */   {
/* 263 */     return this.orderJsProportion;
/*     */   }
/*     */ 
/*     */   public void setOrderJsProportion(Double orderJsProportion)
/*     */   {
/* 270 */     this.orderJsProportion = orderJsProportion;
/*     */   }
/*     */ 
/*     */   public String getEnable()
/*     */   {
/* 281 */     return this.enable;
/*     */   }
/*     */ 
/*     */   public void setEnable(String enable)
/*     */   {
/* 292 */     this.enable = enable;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate()
/*     */   {
/* 299 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate)
/*     */   {
/* 306 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify()
/*     */   {
/* 313 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify)
/*     */   {
/* 320 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getOperator()
/*     */   {
/* 327 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator)
/*     */   {
/* 334 */     this.operator = operator;
/*     */   }
/*     */ 
/*     */   public String getProTypeName() {
/* 338 */     return this.proTypeName;
/*     */   }
/*     */ 
/*     */   public String getMemberLevelName() {
/* 342 */     return this.memberLevelName;
/*     */   }
/*     */ 
/*     */   public void setProTypeName(String proTypeName) {
/* 346 */     this.proTypeName = proTypeName;
/*     */   }
/*     */ 
/*     */   public void setMemberLevelName(String memberLevelName) {
/* 350 */     this.memberLevelName = memberLevelName;
/*     */   }
/*     */ 
/*     */   public String getTradingTypeName() {
/* 354 */     EnumTradingType sEnum = EnumTradingType.indexByValue(this.tradingType);
/* 355 */     if (sEnum == null) {
/* 356 */       return this.tradingType;
/*     */     }
/* 358 */     return sEnum.getName();
/*     */   }
/*     */ 
/*     */   public String getListingCheckProcessNames() {
/* 362 */     if ((this.listingCheckProcess == null) || (this.listingCheckProcess.length() < 1)) {
/* 363 */       return null;
/*     */     }
/* 365 */     String auditProNames = "";
/* 366 */     char[] nodesArray = this.listingCheckProcess.toCharArray();
/* 367 */     for (int i = 0; i < nodesArray.length; i++) {
/* 368 */       EnumProcessAuditNodes aEum = EnumProcessAuditNodes.indexByValue(nodesArray[i] + "");
/* 369 */       if (aEum != null) {
/* 370 */         auditProNames = auditProNames + aEum.getName() + ",";
/*     */       }
/*     */     }
/* 373 */     return auditProNames.endsWith(",") ? auditProNames.substring(0, auditProNames.length() - 1) : auditProNames;
/*     */   }
/*     */ 
/*     */   public String getIntentionCheckProcessNames()
/*     */   {
/* 378 */     if ((this.intentionCheckProcess == null) || (this.intentionCheckProcess.length() < 1)) {
/* 379 */       return null;
/*     */     }
/* 381 */     String auditProNames = "";
/* 382 */     char[] nodesArray = this.intentionCheckProcess.toCharArray();
/* 383 */     for (int i = 0; i < nodesArray.length; i++) {
/* 384 */       EnumProcessAuditNodes aEum = EnumProcessAuditNodes.indexByValue(nodesArray[i] + "");
/* 385 */       if (aEum != null) {
/* 386 */         auditProNames = auditProNames + aEum.getName() + ",";
/*     */       }
/*     */     }
/* 389 */     return auditProNames.endsWith(",") ? auditProNames.substring(0, auditProNames.length() - 1) : auditProNames;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.project.ProjectBaseSetting
 * JD-Core Version:    0.6.0
 */