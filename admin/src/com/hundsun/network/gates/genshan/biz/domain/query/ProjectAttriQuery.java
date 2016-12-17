/*     */ package com.hundsun.network.gates.genshan.biz.domain.query;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.page.Pagination;
/*     */ 
/*     */ public class ProjectAttriQuery<ProjectTypeAttri> extends Pagination<ProjectTypeAttri>
/*     */ {
/*     */   private static final long serialVersionUID = -6343772754962024860L;
/*     */   private String proTypeCode;
/*     */   private String proTypeName;
/*     */   private String keyName;
/*     */   private String keyTitle;
/*     */   private String inputType;
/*     */   private String text;
/*     */   private String remark;
/*     */   private Short enable;
/*     */   private Short rank;
/*     */   private Short isRequired;
/*     */   private String valueValidate;
/*     */ 
/*     */   public String getProTypeCode()
/*     */   {
/*  84 */     return this.proTypeCode;
/*     */   }
/*     */ 
/*     */   public void setProTypeCode(String proTypeCode) {
/*  88 */     this.proTypeCode = proTypeCode;
/*     */   }
/*     */ 
/*     */   public String getProTypeName() {
/*  92 */     return this.proTypeName;
/*     */   }
/*     */ 
/*     */   public void setProTypeName(String proTypeName) {
/*  96 */     this.proTypeName = proTypeName;
/*     */   }
/*     */ 
/*     */   public String getKeyName() {
/* 100 */     return this.keyName;
/*     */   }
/*     */ 
/*     */   public void setKeyName(String keyName) {
/* 104 */     this.keyName = keyName;
/*     */   }
/*     */ 
/*     */   public String getKeyTitle() {
/* 108 */     return this.keyTitle;
/*     */   }
/*     */ 
/*     */   public void setKeyTitle(String keyTitle) {
/* 112 */     this.keyTitle = keyTitle;
/*     */   }
/*     */ 
/*     */   public String getInputType() {
/* 116 */     return this.inputType;
/*     */   }
/*     */ 
/*     */   public void setInputType(String inputType) {
/* 120 */     this.inputType = inputType;
/*     */   }
/*     */ 
/*     */   public String getText() {
/* 124 */     return this.text;
/*     */   }
/*     */ 
/*     */   public void setText(String text) {
/* 128 */     this.text = text;
/*     */   }
/*     */ 
/*     */   public String getRemark() {
/* 132 */     return this.remark;
/*     */   }
/*     */ 
/*     */   public void setRemark(String remark) {
/* 136 */     this.remark = remark;
/*     */   }
/*     */ 
/*     */   public Short getEnable() {
/* 140 */     return this.enable;
/*     */   }
/*     */ 
/*     */   public void setEnable(Short enable) {
/* 144 */     this.enable = enable;
/*     */   }
/*     */ 
/*     */   public Short getRank() {
/* 148 */     return this.rank;
/*     */   }
/*     */ 
/*     */   public void setRank(Short rank) {
/* 152 */     this.rank = rank;
/*     */   }
/*     */ 
/*     */   public Short getIsRequired() {
/* 156 */     return this.isRequired;
/*     */   }
/*     */ 
/*     */   public void setIsRequired(Short isRequired) {
/* 160 */     this.isRequired = isRequired;
/*     */   }
/*     */ 
/*     */   public String getValueValidate() {
/* 164 */     return this.valueValidate;
/*     */   }
/*     */ 
/*     */   public void setValueValidate(String valueValidate) {
/* 168 */     this.valueValidate = valueValidate;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.query.ProjectAttriQuery
 * JD-Core Version:    0.6.0
 */