/*     */ package com.hundsun.network.gates.genshan.biz.domain.auction;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.domain.BaseDomain;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class AuctionLog extends BaseDomain
/*     */ {
/*     */   private static final long serialVersionUID = 6356588382579004889L;
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
/*  64 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id) {
/*  68 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getProjectCode()
/*     */   {
/*  75 */     return this.projectCode;
/*     */   }
/*     */ 
/*     */   public void setProjectCode(String projectCode)
/*     */   {
/*  82 */     this.projectCode = projectCode;
/*     */   }
/*     */ 
/*     */   public String getBeforeStatus()
/*     */   {
/*  89 */     return this.beforeStatus;
/*     */   }
/*     */ 
/*     */   public void setBeforeStatus(String beforeStatus)
/*     */   {
/*  96 */     this.beforeStatus = beforeStatus;
/*     */   }
/*     */ 
/*     */   public String getNewStatus()
/*     */   {
/* 103 */     return this.newStatus;
/*     */   }
/*     */ 
/*     */   public void setNewStatus(String newStatus)
/*     */   {
/* 110 */     this.newStatus = newStatus;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate()
/*     */   {
/* 117 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate)
/*     */   {
/* 124 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify()
/*     */   {
/* 131 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify)
/*     */   {
/* 138 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public String getDataJson()
/*     */   {
/* 145 */     return this.dataJson;
/*     */   }
/*     */ 
/*     */   public void setDataJson(String dataJson)
/*     */   {
/* 152 */     this.dataJson = dataJson;
/*     */   }
/*     */ 
/*     */   public String getRemark()
/*     */   {
/* 159 */     return this.remark;
/*     */   }
/*     */ 
/*     */   public void setRemark(String remark)
/*     */   {
/* 166 */     this.remark = remark;
/*     */   }
/*     */ 
/*     */   public String getOperator()
/*     */   {
/* 173 */     return this.operator;
/*     */   }
/*     */ 
/*     */   public void setOperator(String operator)
/*     */   {
/* 180 */     this.operator = operator;
/*     */   }
/*     */ 
/*     */   public String getOperatorType()
/*     */   {
/* 189 */     return this.operatorType;
/*     */   }
/*     */ 
/*     */   public void setOperatorType(String operatorType)
/*     */   {
/* 198 */     this.operatorType = operatorType;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.auction.AuctionLog
 * JD-Core Version:    0.6.0
 */