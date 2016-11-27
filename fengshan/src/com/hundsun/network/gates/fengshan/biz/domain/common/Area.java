/*     */ package com.hundsun.network.gates.fengshan.biz.domain.common;
/*     */ 
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.BaseDomain;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class Area extends BaseDomain
/*     */ {
/*     */   private static final long serialVersionUID = 8520815924544939441L;
/*     */   private Integer id;
/*     */   private String name;
/*     */   private String parentPath;
/*     */   private Integer ranking;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */   private String operator;
/*     */   private String value;
/*     */   private String active;
/*     */ 
/*     */   public Integer getId()
/*     */   {
/*  62 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Integer id)
/*     */   {
/*  69 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getName()
/*     */   {
/*  76 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setName(String name)
/*     */   {
/*  83 */     this.name = name;
/*     */   }
/*     */ 
/*     */   public String getParentPath()
/*     */   {
/*  90 */     return this.parentPath;
/*     */   }
/*     */ 
/*     */   public void setParentPath(String parentPath)
/*     */   {
/*  97 */     this.parentPath = parentPath;
/*     */   }
/*     */ 
/*     */   public Integer getRanking()
/*     */   {
/* 104 */     return this.ranking;
/*     */   }
/*     */ 
/*     */   public void setRanking(Integer ranking)
/*     */   {
/* 111 */     this.ranking = ranking;
/*     */   }
/*     */ 
/*     */   public String getOperator()
/*     */   {
/* 118 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator)
/*     */   {
/* 125 */     this.operator = operator;
/*     */   }
/*     */ 
/*     */   public String getValue() {
/* 129 */     return this.value;
/*     */   }
/*     */ 
/*     */   public void setValue(String value) {
/* 133 */     this.value = value;
/*     */   }
/*     */ 
/*     */   public String getActive() {
/* 137 */     return this.active;
/*     */   }
/*     */ 
/*     */   public void setActive(String active) {
/* 141 */     this.active = active;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify() {
/* 145 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify) {
/* 149 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate() {
/* 153 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate) {
/* 157 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.domain.common.Area
 * JD-Core Version:    0.6.0
 */