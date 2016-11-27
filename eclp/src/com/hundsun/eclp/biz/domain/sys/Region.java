/*     */ package com.hundsun.eclp.biz.domain.sys;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ 
/*     */ public class Region
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -4136795226664679015L;
/*     */   private Long id;
/*     */   private String code;
/*     */   private String parentCode;
/*     */   private String regionName;
/*     */   private Short regionType;
/*     */   private String abbname;
/*     */   private String zip;
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  55 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  60 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getCode()
/*     */   {
/*  65 */     return this.code;
/*     */   }
/*     */ 
/*     */   public void setCode(String code) {
/*  69 */     this.code = code;
/*     */   }
/*     */ 
/*     */   public String getParentCode()
/*     */   {
/*  74 */     return this.parentCode;
/*     */   }
/*     */ 
/*     */   public void setParentCode(String parentCode)
/*     */   {
/*  79 */     this.parentCode = parentCode;
/*     */   }
/*     */ 
/*     */   public String getRegionName()
/*     */   {
/*  84 */     return this.regionName;
/*     */   }
/*     */ 
/*     */   public void setRegionName(String regionName) {
/*  88 */     this.regionName = regionName;
/*     */   }
/*     */ 
/*     */   public Short getRegionType() {
/*  92 */     return this.regionType;
/*     */   }
/*     */ 
/*     */   public void setRegionType(Short regionType) {
/*  96 */     this.regionType = regionType;
/*     */   }
/*     */ 
/*     */   public String getAbbname() {
/* 100 */     return this.abbname;
/*     */   }
/*     */ 
/*     */   public void setAbbname(String abbname) {
/* 104 */     this.abbname = abbname;
/*     */   }
/*     */ 
/*     */   public String getZip() {
/* 108 */     return this.zip;
/*     */   }
/*     */ 
/*     */   public void setZip(String zip) {
/* 112 */     this.zip = zip;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.domain.sys.Region
 * JD-Core Version:    0.6.0
 */