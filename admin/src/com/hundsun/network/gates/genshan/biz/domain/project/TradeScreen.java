/*     */ package com.hundsun.network.gates.genshan.biz.domain.project;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.domain.BaseDomain;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class TradeScreen extends BaseDomain
/*     */ {
/*     */   private static final long serialVersionUID = -5897379756624651342L;
/*     */   private Long id;
/*     */   private Long substationId;
/*     */   private String creator;
/*     */   private String operator;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */   private String diyCfg;
/*     */   private String name;
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  75 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/*  79 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public Long getSubstationId() {
/*  83 */     return this.substationId;
/*     */   }
/*     */ 
/*     */   public void setSubstationId(Long substationId) {
/*  87 */     this.substationId = substationId;
/*     */   }
/*     */ 
/*     */   public String getCreator() {
/*  91 */     return this.creator;
/*     */   }
/*     */ 
/*     */   public void setCreator(String creator) {
/*  95 */     this.creator = creator;
/*     */   }
/*     */ 
/*     */   public String getOperator() {
/*  99 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator) {
/* 103 */     this.operator = operator;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate() {
/* 107 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate) {
/* 111 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify() {
/* 115 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify) {
/* 119 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getDiyCfg() {
/* 123 */     return this.diyCfg;
/*     */   }
/*     */ 
/*     */   public void setDiyCfg(String diyCfg) {
/* 127 */     this.diyCfg = diyCfg;
/*     */   }
/*     */ 
/*     */   public String getName() {
/* 131 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setName(String name) {
/* 135 */     this.name = name;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.project.TradeScreen
 * JD-Core Version:    0.6.0
 */