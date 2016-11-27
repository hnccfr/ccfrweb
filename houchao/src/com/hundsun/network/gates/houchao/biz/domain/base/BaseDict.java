/*     */ package com.hundsun.network.gates.houchao.biz.domain.base;
/*     */ 
/*     */ import java.util.Date;
/*     */ 
/*     */ public class BaseDict
/*     */ {
/*     */   private Long id;
/*     */   private String flag;
/*     */   private String value;
/*     */   private Integer version;
/*     */   private Date gmtValid;
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  45 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  52 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getFlag()
/*     */   {
/*  69 */     return this.flag;
/*     */   }
/*     */ 
/*     */   public void setFlag(String flag)
/*     */   {
/*  86 */     this.flag = flag;
/*     */   }
/*     */ 
/*     */   public String getValue()
/*     */   {
/*  93 */     return this.value;
/*     */   }
/*     */ 
/*     */   public void setValue(String value)
/*     */   {
/* 100 */     this.value = value;
/*     */   }
/*     */ 
/*     */   public Integer getVersion()
/*     */   {
/* 107 */     return this.version;
/*     */   }
/*     */ 
/*     */   public void setVersion(Integer version)
/*     */   {
/* 114 */     this.version = version;
/*     */   }
/*     */ 
/*     */   public Date getGmtValid()
/*     */   {
/* 121 */     return this.gmtValid;
/*     */   }
/*     */ 
/*     */   public void setGmtValid(Date gmtValid)
/*     */   {
/* 128 */     this.gmtValid = gmtValid;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\houchao\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.houchao.biz.domain.base.BaseDict
 * JD-Core Version:    0.6.0
 */