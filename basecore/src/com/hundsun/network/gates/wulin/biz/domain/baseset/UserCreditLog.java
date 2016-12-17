/*     */ package com.hundsun.network.gates.wulin.biz.domain.baseset;
/*     */ 
/*     */ import com.hundsun.network.gates.wulin.biz.domain.BaseDomain;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class UserCreditLog extends BaseDomain
/*     */ {
/*     */   private static final long serialVersionUID = 1681801352640217624L;
/*     */   private Long id;
/*     */   private String userAccount;
/*     */   private String orderNo;
/*     */   private String projectListingCode;
/*     */   private Short rankType;
/*     */   private Long rankValue;
/*     */   private Long serviceAttitude;
/*     */   private Long logisticsSpeed;
/*     */   private String memo;
/*     */   private String creator;
/*     */   private Date gmtCreate;
/*     */   private String remark;
/*     */ 
/*     */   public Long getId()
/*     */   {
/* 109 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/* 121 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getUserAccount()
/*     */   {
/* 133 */     return this.userAccount;
/*     */   }
/*     */ 
/*     */   public void setUserAccount(String userAccount)
/*     */   {
/* 145 */     this.userAccount = userAccount;
/*     */   }
/*     */ 
/*     */   public String getOrderNo()
/*     */   {
/* 157 */     return this.orderNo;
/*     */   }
/*     */ 
/*     */   public void setOrderNo(String orderNo)
/*     */   {
/* 169 */     this.orderNo = orderNo;
/*     */   }
/*     */ 
/*     */   public String getProjectListingCode()
/*     */   {
/* 181 */     return this.projectListingCode;
/*     */   }
/*     */ 
/*     */   public void setProjectListingCode(String projectListingCode)
/*     */   {
/* 193 */     this.projectListingCode = projectListingCode;
/*     */   }
/*     */ 
/*     */   public Short getRankType()
/*     */   {
/* 205 */     return this.rankType;
/*     */   }
/*     */ 
/*     */   public void setRankType(Short rankType)
/*     */   {
/* 217 */     this.rankType = rankType;
/*     */   }
/*     */ 
/*     */   public Long getRankValue()
/*     */   {
/* 229 */     return this.rankValue;
/*     */   }
/*     */ 
/*     */   public void setRankValue(Long rankValue)
/*     */   {
/* 241 */     this.rankValue = rankValue;
/*     */   }
/*     */ 
/*     */   public Long getServiceAttitude()
/*     */   {
/* 253 */     return this.serviceAttitude;
/*     */   }
/*     */ 
/*     */   public void setServiceAttitude(Long serviceAttitude)
/*     */   {
/* 265 */     this.serviceAttitude = serviceAttitude;
/*     */   }
/*     */ 
/*     */   public Long getLogisticsSpeed()
/*     */   {
/* 277 */     return this.logisticsSpeed;
/*     */   }
/*     */ 
/*     */   public void setLogisticsSpeed(Long logisticsSpeed)
/*     */   {
/* 289 */     this.logisticsSpeed = logisticsSpeed;
/*     */   }
/*     */ 
/*     */   public String getMemo()
/*     */   {
/* 301 */     return this.memo;
/*     */   }
/*     */ 
/*     */   public void setMemo(String memo)
/*     */   {
/* 313 */     this.memo = memo;
/*     */   }
/*     */ 
/*     */   public String getCreator()
/*     */   {
/* 325 */     return this.creator;
/*     */   }
/*     */ 
/*     */   public void setCreator(String creator)
/*     */   {
/* 337 */     this.creator = creator;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate()
/*     */   {
/* 349 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate)
/*     */   {
/* 361 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public String getRemark() {
/* 365 */     return this.remark;
/*     */   }
/*     */ 
/*     */   public void setRemark(String remark) {
/* 369 */     this.remark = remark;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.domain.baseset.UserCreditLog
 * JD-Core Version:    0.6.0
 */