/*     */ package com.hundsun.network.gates.fengshan.biz.domain.project;
/*     */ 
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.BaseDomain;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class ProjectStandard extends BaseDomain
/*     */ {
/*     */   private static final long serialVersionUID = -7104708867335182L;
/*     */   private Long id;
/*     */   private String proTypeCode;
/*     */   private String proTypeName;
/*     */   private String name;
/*     */   private String enable;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */   private String operator;
/*     */   private String content;
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  64 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  71 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getProTypeCode()
/*     */   {
/*  78 */     return this.proTypeCode;
/*     */   }
/*     */ 
/*     */   public void setProTypeCode(String proTypeCode)
/*     */   {
/*  85 */     this.proTypeCode = proTypeCode;
/*     */   }
/*     */ 
/*     */   public String getName()
/*     */   {
/*  92 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setName(String name)
/*     */   {
/*  99 */     this.name = name;
/*     */   }
/*     */ 
/*     */   public String getEnable()
/*     */   {
/* 106 */     return this.enable;
/*     */   }
/*     */ 
/*     */   public void setEnable(String enable)
/*     */   {
/* 113 */     this.enable = enable;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate()
/*     */   {
/* 120 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate)
/*     */   {
/* 127 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify()
/*     */   {
/* 134 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify)
/*     */   {
/* 141 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getOperator()
/*     */   {
/* 148 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator)
/*     */   {
/* 155 */     this.operator = operator;
/*     */   }
/*     */ 
/*     */   public String getContent() {
/* 159 */     return this.content;
/*     */   }
/*     */ 
/*     */   public void setContent(String content) {
/* 163 */     this.content = content;
/*     */   }
/*     */ 
/*     */   public String getProTypeName()
/*     */   {
/* 175 */     return this.proTypeName;
/*     */   }
/*     */ 
/*     */   public void setProTypeName(String proTypeName) {
/* 179 */     this.proTypeName = proTypeName;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.domain.project.ProjectStandard
 * JD-Core Version:    0.6.0
 */