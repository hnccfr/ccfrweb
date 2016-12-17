/*     */ package com.hundsun.network.gates.wulin.biz.domain.financing;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class FinancGoods
/*     */   implements Serializable
/*     */ {
/*     */   private Long id;
/*     */   private Long standardId;
/*     */   private String standardName;
/*     */   private String typeCode;
/*     */   private String typeName;
/*     */   private String spec;
/*     */   private String units;
/*     */   private String enable;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */   private String content;
/*     */   private static final long serialVersionUID = 1L;
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  73 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  82 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public Long getStandardId()
/*     */   {
/*  91 */     return this.standardId;
/*     */   }
/*     */ 
/*     */   public void setStandardId(Long standardId)
/*     */   {
/* 100 */     this.standardId = standardId;
/*     */   }
/*     */ 
/*     */   public String getStandardName()
/*     */   {
/* 109 */     return this.standardName;
/*     */   }
/*     */ 
/*     */   public void setStandardName(String standardName)
/*     */   {
/* 118 */     this.standardName = (standardName == null ? null : standardName.trim());
/*     */   }
/*     */ 
/*     */   public String getTypeCode()
/*     */   {
/* 127 */     return this.typeCode;
/*     */   }
/*     */ 
/*     */   public void setTypeCode(String typeCode)
/*     */   {
/* 136 */     this.typeCode = (typeCode == null ? null : typeCode.trim());
/*     */   }
/*     */ 
/*     */   public String getTypeName()
/*     */   {
/* 145 */     return this.typeName;
/*     */   }
/*     */ 
/*     */   public void setTypeName(String typeName)
/*     */   {
/* 154 */     this.typeName = (typeName == null ? null : typeName.trim());
/*     */   }
/*     */ 
/*     */   public String getSpec()
/*     */   {
/* 163 */     return this.spec;
/*     */   }
/*     */ 
/*     */   public void setSpec(String spec)
/*     */   {
/* 172 */     this.spec = (spec == null ? null : spec.trim());
/*     */   }
/*     */ 
/*     */   public String getUnits()
/*     */   {
/* 181 */     return this.units;
/*     */   }
/*     */ 
/*     */   public void setUnits(String units)
/*     */   {
/* 190 */     this.units = (units == null ? null : units.trim());
/*     */   }
/*     */ 
/*     */   public String getEnable()
/*     */   {
/* 199 */     return this.enable;
/*     */   }
/*     */ 
/*     */   public void setEnable(String enable)
/*     */   {
/* 208 */     this.enable = (enable == null ? null : enable.trim());
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate()
/*     */   {
/* 217 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate)
/*     */   {
/* 226 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify()
/*     */   {
/* 235 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify)
/*     */   {
/* 244 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getContent()
/*     */   {
/* 253 */     return this.content;
/*     */   }
/*     */ 
/*     */   public void setContent(String content)
/*     */   {
/* 262 */     this.content = (content == null ? null : content.trim());
/*     */   }
/*     */ 
/*     */   public boolean equals(Object that)
/*     */   {
/* 270 */     if (this == that) {
/* 271 */       return true;
/*     */     }
/* 273 */     if (that == null) {
/* 274 */       return false;
/*     */     }
/* 276 */     if (getClass() != that.getClass()) {
/* 277 */       return false;
/*     */     }
/* 279 */     FinancGoods other = (FinancGoods)that;
/* 280 */     return (getId() == null ? other.getId() == null : getId().equals(other.getId())) && (getStandardId() == null ? other.getStandardId() == null : getStandardId().equals(other.getStandardId())) && (getStandardName() == null ? other.getStandardName() == null : getStandardName().equals(other.getStandardName())) && (getTypeCode() == null ? other.getTypeCode() == null : getTypeCode().equals(other.getTypeCode())) && (getTypeName() == null ? other.getTypeName() == null : getTypeName().equals(other.getTypeName())) && (getSpec() == null ? other.getSpec() == null : getSpec().equals(other.getSpec())) && (getUnits() == null ? other.getUnits() == null : getUnits().equals(other.getUnits())) && (getEnable() == null ? other.getEnable() == null : getEnable().equals(other.getEnable())) && (getGmtCreate() == null ? other.getGmtCreate() == null : getGmtCreate().equals(other.getGmtCreate())) && (getGmtModify() == null ? other.getGmtModify() == null : getGmtModify().equals(other.getGmtModify())) && (getContent() == null ? other.getContent() == null : getContent().equals(other.getContent()));
/*     */   }
/*     */ 
/*     */   public int hashCode()
/*     */   {
/* 298 */     int prime = 31;
/* 299 */     int result = 1;
/* 300 */     result = 31 * result + (getId() == null ? 0 : getId().hashCode());
/* 301 */     result = 31 * result + (getStandardId() == null ? 0 : getStandardId().hashCode());
/* 302 */     result = 31 * result + (getStandardName() == null ? 0 : getStandardName().hashCode());
/* 303 */     result = 31 * result + (getTypeCode() == null ? 0 : getTypeCode().hashCode());
/* 304 */     result = 31 * result + (getTypeName() == null ? 0 : getTypeName().hashCode());
/* 305 */     result = 31 * result + (getSpec() == null ? 0 : getSpec().hashCode());
/* 306 */     result = 31 * result + (getUnits() == null ? 0 : getUnits().hashCode());
/* 307 */     result = 31 * result + (getEnable() == null ? 0 : getEnable().hashCode());
/* 308 */     result = 31 * result + (getGmtCreate() == null ? 0 : getGmtCreate().hashCode());
/* 309 */     result = 31 * result + (getGmtModify() == null ? 0 : getGmtModify().hashCode());
/* 310 */     result = 31 * result + (getContent() == null ? 0 : getContent().hashCode());
/* 311 */     return result;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.domain.financing.FinancGoods
 * JD-Core Version:    0.6.0
 */