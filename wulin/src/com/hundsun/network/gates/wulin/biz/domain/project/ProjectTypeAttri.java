/*     */ package com.hundsun.network.gates.wulin.biz.domain.project;
/*     */ 
/*     */ import com.hundsun.network.gates.wulin.biz.domain.BaseDomain;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class ProjectTypeAttri extends BaseDomain
/*     */ {
/*     */   private static final long serialVersionUID = 4525890154326113970L;
/*     */   private Long id;
/*     */   private String proTypeCode;
/*     */   private String keyName;
/*     */   private String keyTitle;
/*     */   private String inputType;
/*     */   private String text;
/*     */   private String remark;
/*     */   private Short enable;
/*     */   private Short rank;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */   private String operator;
/*     */   private Short isRequired;
/*     */   private String valueValidate;
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  90 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  97 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getProTypeCode()
/*     */   {
/* 104 */     return this.proTypeCode;
/*     */   }
/*     */ 
/*     */   public void setProTypeCode(String proTypeCode)
/*     */   {
/* 111 */     this.proTypeCode = proTypeCode;
/*     */   }
/*     */ 
/*     */   public String getKeyName()
/*     */   {
/* 118 */     return this.keyName;
/*     */   }
/*     */ 
/*     */   public void setKeyName(String keyName)
/*     */   {
/* 125 */     this.keyName = keyName;
/*     */   }
/*     */ 
/*     */   public String getKeyTitle()
/*     */   {
/* 132 */     return this.keyTitle;
/*     */   }
/*     */ 
/*     */   public void setKeyTitle(String keyTitle)
/*     */   {
/* 139 */     this.keyTitle = keyTitle;
/*     */   }
/*     */ 
/*     */   public String getInputType()
/*     */   {
/* 146 */     return this.inputType;
/*     */   }
/*     */ 
/*     */   public void setInputType(String inputType)
/*     */   {
/* 153 */     this.inputType = inputType;
/*     */   }
/*     */ 
/*     */   public String getText()
/*     */   {
/* 162 */     return this.text;
/*     */   }
/*     */ 
/*     */   public void setText(String text)
/*     */   {
/* 171 */     this.text = text;
/*     */   }
/*     */ 
/*     */   public String getRemark()
/*     */   {
/* 178 */     return this.remark;
/*     */   }
/*     */ 
/*     */   public void setRemark(String remark)
/*     */   {
/* 185 */     this.remark = remark;
/*     */   }
/*     */ 
/*     */   public Short getEnable()
/*     */   {
/* 192 */     return this.enable;
/*     */   }
/*     */ 
/*     */   public void setEnable(Short enable)
/*     */   {
/* 199 */     this.enable = enable;
/*     */   }
/*     */ 
/*     */   public Short getRank()
/*     */   {
/* 206 */     return this.rank;
/*     */   }
/*     */ 
/*     */   public void setRank(Short rank)
/*     */   {
/* 213 */     this.rank = rank;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate()
/*     */   {
/* 220 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate)
/*     */   {
/* 227 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify()
/*     */   {
/* 234 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify)
/*     */   {
/* 241 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getOperator()
/*     */   {
/* 248 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator)
/*     */   {
/* 255 */     this.operator = operator;
/*     */   }
/*     */ 
/*     */   public Short getIsRequired()
/*     */   {
/* 266 */     return this.isRequired;
/*     */   }
/*     */ 
/*     */   public void setIsRequired(Short isRequired)
/*     */   {
/* 277 */     this.isRequired = isRequired;
/*     */   }
/*     */ 
/*     */   public String getValueValidate()
/*     */   {
/* 284 */     return this.valueValidate;
/*     */   }
/*     */ 
/*     */   public void setValueValidate(String valueValidate)
/*     */   {
/* 291 */     this.valueValidate = valueValidate;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.domain.project.ProjectTypeAttri
 * JD-Core Version:    0.6.0
 */