/*     */ package com.hundsun.network.gates.wulin.biz.domain.baseset;
/*     */ 
/*     */ import com.hundsun.network.gates.wulin.biz.domain.BaseDomain;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class SystemCreditLevel extends BaseDomain
/*     */ {
/*     */   private static final long serialVersionUID = 5159206463542686633L;
/*     */   private Long id;
/*     */   private String creditLevel;
/*     */   private String levelName;
/*     */   private Integer integralStart;
/*     */   private Integer integralEnd;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */   private String operator;
/*     */   private String remark;
/*     */   private String imgName;
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
/*     */   public String getCreditLevel()
/*     */   {
/* 123 */     return this.creditLevel;
/*     */   }
/*     */ 
/*     */   public void setCreditLevel(String creditLevel)
/*     */   {
/* 135 */     this.creditLevel = creditLevel;
/*     */   }
/*     */ 
/*     */   public String getLevelName()
/*     */   {
/* 147 */     return this.levelName;
/*     */   }
/*     */ 
/*     */   public void setLevelName(String levelName)
/*     */   {
/* 159 */     this.levelName = levelName;
/*     */   }
/*     */ 
/*     */   public Integer getIntegralStart()
/*     */   {
/* 171 */     return this.integralStart;
/*     */   }
/*     */ 
/*     */   public void setIntegralStart(Integer integralStart)
/*     */   {
/* 183 */     this.integralStart = integralStart;
/*     */   }
/*     */ 
/*     */   public Integer getIntegralEnd()
/*     */   {
/* 195 */     return this.integralEnd;
/*     */   }
/*     */ 
/*     */   public void setIntegralEnd(Integer integralEnd)
/*     */   {
/* 207 */     this.integralEnd = integralEnd;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate()
/*     */   {
/* 219 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate)
/*     */   {
/* 231 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify()
/*     */   {
/* 243 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify)
/*     */   {
/* 255 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getOperator()
/*     */   {
/* 267 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator)
/*     */   {
/* 279 */     this.operator = operator;
/*     */   }
/*     */ 
/*     */   public String getRemark()
/*     */   {
/* 291 */     return this.remark;
/*     */   }
/*     */ 
/*     */   public void setRemark(String remark)
/*     */   {
/* 303 */     this.remark = remark;
/*     */   }
/*     */ 
/*     */   public String getImgName()
/*     */   {
/* 315 */     return this.imgName;
/*     */   }
/*     */ 
/*     */   public void setImgName(String imgName)
/*     */   {
/* 327 */     this.imgName = imgName;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.domain.baseset.SystemCreditLevel
 * JD-Core Version:    0.6.0
 */