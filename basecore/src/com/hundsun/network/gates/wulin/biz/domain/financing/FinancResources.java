/*     */ package com.hundsun.network.gates.wulin.biz.domain.financing;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class FinancResources
/*     */   implements Serializable
/*     */ {
/*     */   private Long id;
/*     */   private String type;
/*     */   private String name;
/*     */   private String nameCn;
/*     */   private String value;
/*     */   private String remark;
/*     */   private Short enable;
/*     */   private String inputType;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */   private static final long serialVersionUID = 1L;
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  68 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  77 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getType()
/*     */   {
/*  86 */     return this.type;
/*     */   }
/*     */ 
/*     */   public void setType(String type)
/*     */   {
/*  95 */     this.type = (type == null ? null : type.trim());
/*     */   }
/*     */ 
/*     */   public String getName()
/*     */   {
/* 104 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setName(String name)
/*     */   {
/* 113 */     this.name = (name == null ? null : name.trim());
/*     */   }
/*     */ 
/*     */   public String getNameCn()
/*     */   {
/* 122 */     return this.nameCn;
/*     */   }
/*     */ 
/*     */   public void setNameCn(String nameCn)
/*     */   {
/* 131 */     this.nameCn = (nameCn == null ? null : nameCn.trim());
/*     */   }
/*     */ 
/*     */   public String getValue()
/*     */   {
/* 140 */     return this.value;
/*     */   }
/*     */ 
/*     */   public void setValue(String value)
/*     */   {
/* 149 */     this.value = (value == null ? null : value.trim());
/*     */   }
/*     */ 
/*     */   public String getRemark()
/*     */   {
/* 158 */     return this.remark;
/*     */   }
/*     */ 
/*     */   public void setRemark(String remark)
/*     */   {
/* 167 */     this.remark = (remark == null ? null : remark.trim());
/*     */   }
/*     */ 
/*     */   public Short getEnable()
/*     */   {
/* 176 */     return this.enable;
/*     */   }
/*     */ 
/*     */   public void setEnable(Short enable)
/*     */   {
/* 185 */     this.enable = enable;
/*     */   }
/*     */ 
/*     */   public String getInputType()
/*     */   {
/* 194 */     return this.inputType;
/*     */   }
/*     */ 
/*     */   public void setInputType(String inputType)
/*     */   {
/* 203 */     this.inputType = (inputType == null ? null : inputType.trim());
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate()
/*     */   {
/* 212 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate)
/*     */   {
/* 221 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify()
/*     */   {
/* 230 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify)
/*     */   {
/* 239 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object that)
/*     */   {
/* 247 */     if (this == that) {
/* 248 */       return true;
/*     */     }
/* 250 */     if (that == null) {
/* 251 */       return false;
/*     */     }
/* 253 */     if (getClass() != that.getClass()) {
/* 254 */       return false;
/*     */     }
/* 256 */     FinancResources other = (FinancResources)that;
/* 257 */     return (getId() == null ? other.getId() == null : getId().equals(other.getId())) && (getType() == null ? other.getType() == null : getType().equals(other.getType())) && (getName() == null ? other.getName() == null : getName().equals(other.getName())) && (getNameCn() == null ? other.getNameCn() == null : getNameCn().equals(other.getNameCn())) && (getValue() == null ? other.getValue() == null : getValue().equals(other.getValue())) && (getRemark() == null ? other.getRemark() == null : getRemark().equals(other.getRemark())) && (getEnable() == null ? other.getEnable() == null : getEnable().equals(other.getEnable())) && (getInputType() == null ? other.getInputType() == null : getInputType().equals(other.getInputType())) && (getGmtCreate() == null ? other.getGmtCreate() == null : getGmtCreate().equals(other.getGmtCreate())) && (getGmtModify() == null ? other.getGmtModify() == null : getGmtModify().equals(other.getGmtModify()));
/*     */   }
/*     */ 
/*     */   public int hashCode()
/*     */   {
/* 274 */     int prime = 31;
/* 275 */     int result = 1;
/* 276 */     result = 31 * result + (getId() == null ? 0 : getId().hashCode());
/* 277 */     result = 31 * result + (getType() == null ? 0 : getType().hashCode());
/* 278 */     result = 31 * result + (getName() == null ? 0 : getName().hashCode());
/* 279 */     result = 31 * result + (getNameCn() == null ? 0 : getNameCn().hashCode());
/* 280 */     result = 31 * result + (getValue() == null ? 0 : getValue().hashCode());
/* 281 */     result = 31 * result + (getRemark() == null ? 0 : getRemark().hashCode());
/* 282 */     result = 31 * result + (getEnable() == null ? 0 : getEnable().hashCode());
/* 283 */     result = 31 * result + (getInputType() == null ? 0 : getInputType().hashCode());
/* 284 */     result = 31 * result + (getGmtCreate() == null ? 0 : getGmtCreate().hashCode());
/* 285 */     result = 31 * result + (getGmtModify() == null ? 0 : getGmtModify().hashCode());
/* 286 */     return result;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.domain.financing.FinancResources
 * JD-Core Version:    0.6.0
 */