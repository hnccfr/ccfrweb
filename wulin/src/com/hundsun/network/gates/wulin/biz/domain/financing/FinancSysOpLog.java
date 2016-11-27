/*     */ package com.hundsun.network.gates.wulin.biz.domain.financing;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class FinancSysOpLog
/*     */   implements Serializable
/*     */ {
/*     */   private Long id;
/*     */   private String action;
/*     */   private Long relatedId;
/*     */   private String relatedTable;
/*     */   private Long operatorId;
/*     */   private String operatorName;
/*     */   private Date operatorDate;
/*     */   private String business;
/*     */   private String content;
/*     */   private Date gmtCreate;
/*     */   private Date gmtModify;
/*     */   private static final long serialVersionUID = 1L;
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  73 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  82 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getAction()
/*     */   {
/*  91 */     return this.action;
/*     */   }
/*     */ 
/*     */   public void setAction(String action)
/*     */   {
/* 100 */     this.action = (action == null ? null : action.trim());
/*     */   }
/*     */ 
/*     */   public Long getRelatedId()
/*     */   {
/* 109 */     return this.relatedId;
/*     */   }
/*     */ 
/*     */   public void setRelatedId(Long relatedId)
/*     */   {
/* 118 */     this.relatedId = relatedId;
/*     */   }
/*     */ 
/*     */   public String getRelatedTable()
/*     */   {
/* 127 */     return this.relatedTable;
/*     */   }
/*     */ 
/*     */   public void setRelatedTable(String relatedTable)
/*     */   {
/* 136 */     this.relatedTable = (relatedTable == null ? null : relatedTable.trim());
/*     */   }
/*     */ 
/*     */   public Long getOperatorId()
/*     */   {
/* 145 */     return this.operatorId;
/*     */   }
/*     */ 
/*     */   public void setOperatorId(Long operatorId)
/*     */   {
/* 154 */     this.operatorId = operatorId;
/*     */   }
/*     */ 
/*     */   public String getOperatorName()
/*     */   {
/* 163 */     return this.operatorName;
/*     */   }
/*     */ 
/*     */   public void setOperatorName(String operatorName)
/*     */   {
/* 172 */     this.operatorName = (operatorName == null ? null : operatorName.trim());
/*     */   }
/*     */ 
/*     */   public Date getOperatorDate()
/*     */   {
/* 181 */     return this.operatorDate;
/*     */   }
/*     */ 
/*     */   public void setOperatorDate(Date operatorDate)
/*     */   {
/* 190 */     this.operatorDate = operatorDate;
/*     */   }
/*     */ 
/*     */   public String getBusiness()
/*     */   {
/* 199 */     return this.business;
/*     */   }
/*     */ 
/*     */   public void setBusiness(String business)
/*     */   {
/* 208 */     this.business = (business == null ? null : business.trim());
/*     */   }
/*     */ 
/*     */   public String getContent()
/*     */   {
/* 217 */     return this.content;
/*     */   }
/*     */ 
/*     */   public void setContent(String content)
/*     */   {
/* 226 */     this.content = (content == null ? null : content.trim());
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate()
/*     */   {
/* 235 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate)
/*     */   {
/* 244 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public Date getGmtModify()
/*     */   {
/* 253 */     return this.gmtModify;
/*     */   }
/*     */ 
/*     */   public void setGmtModify(Date gmtModify)
/*     */   {
/* 262 */     this.gmtModify = gmtModify;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object that)
/*     */   {
/* 270 */     if (this == that) {
/* 271 */       return true;
/*     */     }
/* 273 */     if (that == null) {
/* 274 */       return false;
/*     */     }
/* 276 */     if (getClass() != that.getClass()) {
/* 277 */       return false;
/*     */     }
/* 279 */     FinancSysOpLog other = (FinancSysOpLog)that;
/* 280 */     return (getId() == null ? other.getId() == null : getId().equals(other.getId())) && (getAction() == null ? other.getAction() == null : getAction().equals(other.getAction())) && (getRelatedId() == null ? other.getRelatedId() == null : getRelatedId().equals(other.getRelatedId())) && (getRelatedTable() == null ? other.getRelatedTable() == null : getRelatedTable().equals(other.getRelatedTable())) && (getOperatorId() == null ? other.getOperatorId() == null : getOperatorId().equals(other.getOperatorId())) && (getOperatorName() == null ? other.getOperatorName() == null : getOperatorName().equals(other.getOperatorName())) && (getOperatorDate() == null ? other.getOperatorDate() == null : getOperatorDate().equals(other.getOperatorDate())) && (getBusiness() == null ? other.getBusiness() == null : getBusiness().equals(other.getBusiness())) && (getContent() == null ? other.getContent() == null : getContent().equals(other.getContent())) && (getGmtCreate() == null ? other.getGmtCreate() == null : getGmtCreate().equals(other.getGmtCreate())) && (getGmtModify() == null ? other.getGmtModify() == null : getGmtModify().equals(other.getGmtModify()));
/*     */   }
/*     */ 
/*     */   public int hashCode()
/*     */   {
/* 298 */     int prime = 31;
/* 299 */     int result = 1;
/* 300 */     result = 31 * result + (getId() == null ? 0 : getId().hashCode());
/* 301 */     result = 31 * result + (getAction() == null ? 0 : getAction().hashCode());
/* 302 */     result = 31 * result + (getRelatedId() == null ? 0 : getRelatedId().hashCode());
/* 303 */     result = 31 * result + (getRelatedTable() == null ? 0 : getRelatedTable().hashCode());
/* 304 */     result = 31 * result + (getOperatorId() == null ? 0 : getOperatorId().hashCode());
/* 305 */     result = 31 * result + (getOperatorName() == null ? 0 : getOperatorName().hashCode());
/* 306 */     result = 31 * result + (getOperatorDate() == null ? 0 : getOperatorDate().hashCode());
/* 307 */     result = 31 * result + (getBusiness() == null ? 0 : getBusiness().hashCode());
/* 308 */     result = 31 * result + (getContent() == null ? 0 : getContent().hashCode());
/* 309 */     result = 31 * result + (getGmtCreate() == null ? 0 : getGmtCreate().hashCode());
/* 310 */     result = 31 * result + (getGmtModify() == null ? 0 : getGmtModify().hashCode());
/* 311 */     return result;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.domain.financing.FinancSysOpLog
 * JD-Core Version:    0.6.0
 */