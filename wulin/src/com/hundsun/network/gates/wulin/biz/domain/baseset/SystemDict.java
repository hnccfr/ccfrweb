/*     */ package com.hundsun.network.gates.wulin.biz.domain.baseset;
/*     */ 
/*     */ import com.hundsun.network.gates.wulin.biz.domain.BaseDomain;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class SystemDict extends BaseDomain
/*     */ {
/*     */   private static final long serialVersionUID = 1330778139756514970L;
/*     */   private Long id;
/*     */   private String paraCode;
/*     */   private String paraName;
/*     */   private String paraValue;
/*     */   private String remark;
/*     */   private Short enable;
/*     */   private String inputType;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */   private String operator;
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  99 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/* 111 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getParaCode()
/*     */   {
/* 123 */     return this.paraCode;
/*     */   }
/*     */ 
/*     */   public void setParaCode(String paraCode)
/*     */   {
/* 135 */     this.paraCode = paraCode;
/*     */   }
/*     */ 
/*     */   public String getParaName()
/*     */   {
/* 147 */     return this.paraName;
/*     */   }
/*     */ 
/*     */   public void setParaName(String paraName)
/*     */   {
/* 159 */     this.paraName = paraName;
/*     */   }
/*     */ 
/*     */   public String getParaValue()
/*     */   {
/* 171 */     return this.paraValue;
/*     */   }
/*     */ 
/*     */   public void setParaValue(String paraValue)
/*     */   {
/* 183 */     this.paraValue = paraValue;
/*     */   }
/*     */ 
/*     */   public String getRemark()
/*     */   {
/* 195 */     return this.remark;
/*     */   }
/*     */ 
/*     */   public void setRemark(String remark)
/*     */   {
/* 207 */     this.remark = remark;
/*     */   }
/*     */ 
/*     */   public Short getEnable()
/*     */   {
/* 219 */     return this.enable;
/*     */   }
/*     */ 
/*     */   public void setEnable(Short enable)
/*     */   {
/* 231 */     this.enable = enable;
/*     */   }
/*     */ 
/*     */   public String getInputType()
/*     */   {
/* 243 */     return this.inputType;
/*     */   }
/*     */ 
/*     */   public void setInputType(String inputType)
/*     */   {
/* 255 */     this.inputType = inputType;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate()
/*     */   {
/* 267 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate)
/*     */   {
/* 279 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify()
/*     */   {
/* 291 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify)
/*     */   {
/* 303 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getOperator()
/*     */   {
/* 315 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator)
/*     */   {
/* 327 */     this.operator = operator;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.domain.baseset.SystemDict
 * JD-Core Version:    0.6.0
 */