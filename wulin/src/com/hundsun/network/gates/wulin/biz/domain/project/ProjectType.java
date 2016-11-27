/*     */ package com.hundsun.network.gates.wulin.biz.domain.project;
/*     */ 
/*     */ import com.hundsun.network.gates.wulin.biz.domain.BaseDomain;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class ProjectType extends BaseDomain
/*     */ {
/*     */   private static final long serialVersionUID = 2842199175578061423L;
/*     */   private Long id;
/*     */   private String code;
/*     */   private String parCode;
/*     */   private String name;
/*     */   private Short enable;
/*     */   private Short rank;
/*     */   private String remark;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */   private String operator;
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  72 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  79 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getCode()
/*     */   {
/*  88 */     return this.code;
/*     */   }
/*     */ 
/*     */   public void setCode(String code)
/*     */   {
/*  97 */     this.code = code;
/*     */   }
/*     */ 
/*     */   public String getParCode()
/*     */   {
/* 106 */     return this.parCode;
/*     */   }
/*     */ 
/*     */   public void setParCode(String parCode)
/*     */   {
/* 115 */     this.parCode = parCode;
/*     */   }
/*     */ 
/*     */   public String getName()
/*     */   {
/* 122 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setName(String name)
/*     */   {
/* 129 */     this.name = name;
/*     */   }
/*     */ 
/*     */   public Short getEnable()
/*     */   {
/* 140 */     return this.enable;
/*     */   }
/*     */ 
/*     */   public void setEnable(Short enable)
/*     */   {
/* 151 */     this.enable = enable;
/*     */   }
/*     */ 
/*     */   public Short getRank()
/*     */   {
/* 158 */     return this.rank;
/*     */   }
/*     */ 
/*     */   public void setRank(Short rank)
/*     */   {
/* 165 */     this.rank = rank;
/*     */   }
/*     */ 
/*     */   public String getRemark()
/*     */   {
/* 172 */     return this.remark;
/*     */   }
/*     */ 
/*     */   public void setRemark(String remark)
/*     */   {
/* 179 */     this.remark = remark;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate()
/*     */   {
/* 186 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate)
/*     */   {
/* 193 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify()
/*     */   {
/* 200 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify)
/*     */   {
/* 207 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getOperator()
/*     */   {
/* 214 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator)
/*     */   {
/* 221 */     this.operator = operator;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.domain.project.ProjectType
 * JD-Core Version:    0.6.0
 */