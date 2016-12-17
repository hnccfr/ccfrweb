/*     */ package com.hundsun.network.gates.genshan.biz.domain.baseset;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumSystemDictKey;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class SystemDict
/*     */ {
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
/*  97 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/* 109 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getParaCode()
/*     */   {
/* 121 */     return this.paraCode;
/*     */   }
/*     */ 
/*     */   public void setParaCode(String paraCode)
/*     */   {
/* 133 */     this.paraCode = paraCode;
/*     */   }
/*     */ 
/*     */   public String getParaName()
/*     */   {
/* 145 */     return this.paraName;
/*     */   }
/*     */ 
/*     */   public void setParaName(String paraName)
/*     */   {
/* 157 */     this.paraName = paraName;
/*     */   }
/*     */ 
/*     */   public String getParaValue()
/*     */   {
/* 169 */     return this.paraValue;
/*     */   }
/*     */ 
/*     */   public void setParaValue(String paraValue)
/*     */   {
/* 181 */     this.paraValue = paraValue;
/*     */   }
/*     */ 
/*     */   public String getRemark()
/*     */   {
/* 193 */     return this.remark;
/*     */   }
/*     */ 
/*     */   public void setRemark(String remark)
/*     */   {
/* 205 */     this.remark = remark;
/*     */   }
/*     */ 
/*     */   public Short getEnable()
/*     */   {
/* 217 */     return this.enable;
/*     */   }
/*     */ 
/*     */   public void setEnable(Short enable)
/*     */   {
/* 229 */     this.enable = enable;
/*     */   }
/*     */ 
/*     */   public String getInputType()
/*     */   {
/* 241 */     return this.inputType;
/*     */   }
/*     */ 
/*     */   public void setInputType(String inputType)
/*     */   {
/* 253 */     this.inputType = inputType;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate()
/*     */   {
/* 265 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate)
/*     */   {
/* 277 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify()
/*     */   {
/* 289 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify)
/*     */   {
/* 301 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getOperator()
/*     */   {
/* 313 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator)
/*     */   {
/* 325 */     this.operator = operator;
/*     */   }
/*     */ 
/*     */   public String getParaCV() {
/* 329 */     if (this.paraCode == null) {
/* 330 */       return this.paraValue;
/*     */     }
/* 332 */     if ((this.paraCode.equals(EnumSystemDictKey.LISTING_JY_PROPORTION.getValue())) || (this.paraCode.equals(EnumSystemDictKey.LISTING_JS_PROPORTION.getValue())) || (this.paraCode.equals(EnumSystemDictKey.ORDER_JY_PROPORTION.getValue())) || (this.paraCode.equals(EnumSystemDictKey.ORDER_JS_PROPORTION.getValue())) || (this.paraCode.equals(EnumSystemDictKey.JY_LIQUIDATED_DAMAGES.getValue())) || (this.paraCode.equals(EnumSystemDictKey.JS_LIQUIDATED_DAMAGES.getValue())) || (this.paraCode.equals(EnumSystemDictKey.GOODS_PAY_PROPORTION.getValue())))
/*     */     {
/*     */       try
/*     */       {
/* 337 */         Double numDouble = Double.valueOf(Double.parseDouble(this.paraValue));
/* 338 */         return numDouble.doubleValue() / 100.0D + "";
/*     */       } catch (Exception e) {
/* 340 */         return this.paraValue;
/*     */       }
/*     */     }
/* 343 */     return this.paraValue;
/*     */   }
/*     */ 
/*     */   public String getPercetSign() {
/* 347 */     if (this.paraCode == null) {
/* 348 */       return "";
/*     */     }
/* 350 */     if ((this.paraCode.equals(EnumSystemDictKey.LISTING_JY_PROPORTION.getValue())) || (this.paraCode.equals(EnumSystemDictKey.LISTING_JS_PROPORTION.getValue())) || (this.paraCode.equals(EnumSystemDictKey.ORDER_JY_PROPORTION.getValue())) || (this.paraCode.equals(EnumSystemDictKey.ORDER_JS_PROPORTION.getValue())) || (this.paraCode.equals(EnumSystemDictKey.JY_LIQUIDATED_DAMAGES.getValue())) || (this.paraCode.equals(EnumSystemDictKey.JS_LIQUIDATED_DAMAGES.getValue())) || (this.paraCode.equals(EnumSystemDictKey.GOODS_PAY_PROPORTION.getValue())))
/*     */     {
/* 354 */       return "%";
/*     */     }
/* 356 */     return "";
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.baseset.SystemDict
 * JD-Core Version:    0.6.0
 */