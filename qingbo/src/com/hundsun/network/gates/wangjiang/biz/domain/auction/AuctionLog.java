/*     */ package com.hundsun.network.gates.wangjiang.biz.domain.auction;
/*     */ 
/*     */ import java.util.Date;
/*     */ 
/*     */ public class AuctionLog
/*     */ {
/*     */   private Long id;
/*     */   private String projectCode;
/*     */   private String beforeStatus;
/*     */   private String newStatus;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */   private String dataJson;
/*     */   private String remark;
/*     */   private String operator;
/*     */   private String operatorType;
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  56 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/*  60 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getProjectCode()
/*     */   {
/*  67 */     return this.projectCode;
/*     */   }
/*     */ 
/*     */   public void setProjectCode(String projectCode)
/*     */   {
/*  74 */     this.projectCode = projectCode;
/*     */   }
/*     */ 
/*     */   public String getBeforeStatus()
/*     */   {
/*  81 */     return this.beforeStatus;
/*     */   }
/*     */ 
/*     */   public void setBeforeStatus(String beforeStatus)
/*     */   {
/*  88 */     this.beforeStatus = beforeStatus;
/*     */   }
/*     */ 
/*     */   public String getNewStatus()
/*     */   {
/*  95 */     return this.newStatus;
/*     */   }
/*     */ 
/*     */   public void setNewStatus(String newStatus)
/*     */   {
/* 102 */     this.newStatus = newStatus;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate()
/*     */   {
/* 109 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate)
/*     */   {
/* 116 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify()
/*     */   {
/* 123 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify)
/*     */   {
/* 130 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getDataJson()
/*     */   {
/* 137 */     return this.dataJson;
/*     */   }
/*     */ 
/*     */   public void setDataJson(String dataJson)
/*     */   {
/* 144 */     this.dataJson = dataJson;
/*     */   }
/*     */ 
/*     */   public String getRemark()
/*     */   {
/* 151 */     return this.remark;
/*     */   }
/*     */ 
/*     */   public void setRemark(String remark)
/*     */   {
/* 158 */     this.remark = remark;
/*     */   }
/*     */ 
/*     */   public String getOperator()
/*     */   {
/* 165 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator)
/*     */   {
/* 172 */     this.operator = operator;
/*     */   }
/*     */ 
/*     */   public String getOperatorType()
/*     */   {
/* 181 */     return this.operatorType;
/*     */   }
/*     */ 
/*     */   public void setOperatorType(String operatorType)
/*     */   {
/* 190 */     this.operatorType = operatorType;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wangjiang.biz.domain.auction.AuctionLog
 * JD-Core Version:    0.6.0
 */