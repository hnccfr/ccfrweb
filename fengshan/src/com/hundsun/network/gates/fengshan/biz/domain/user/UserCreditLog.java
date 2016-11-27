/*     */ package com.hundsun.network.gates.fengshan.biz.domain.user;
/*     */ 
/*     */ import com.hundsun.network.gates.fengshan.biz.enums.EnumEvaluateResult;
/*     */ import com.hundsun.network.gates.fengshan.biz.enums.EnumUserEvaluate;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class UserCreditLog
/*     */ {
/*     */   private Integer id;
/*     */   private String userAccount;
/*     */   private String orderNo;
/*     */   private String projectListingCode;
/*     */   private Short rankType;
/*     */   private Integer rankValue;
/*     */   private Integer serviceAttitude;
/*     */   private Integer logisticsSpeed;
/*     */   private String memo;
/*     */   private String creator;
/*     */   private Date gmtCreate;
/*     */   private String remark;
/*     */ 
/*     */   public Integer getId()
/*     */   {
/*  80 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Integer id)
/*     */   {
/*  87 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getUserAccount()
/*     */   {
/*  94 */     return this.userAccount;
/*     */   }
/*     */ 
/*     */   public void setUserAccount(String userAccount)
/*     */   {
/* 101 */     this.userAccount = userAccount;
/*     */   }
/*     */ 
/*     */   public String getOrderNo()
/*     */   {
/* 108 */     return this.orderNo;
/*     */   }
/*     */ 
/*     */   public void setOrderNo(String orderNo)
/*     */   {
/* 115 */     this.orderNo = orderNo;
/*     */   }
/*     */ 
/*     */   public String getProjectListingCode()
/*     */   {
/* 122 */     return this.projectListingCode;
/*     */   }
/*     */ 
/*     */   public void setProjectListingCode(String projectListingCode)
/*     */   {
/* 129 */     this.projectListingCode = projectListingCode;
/*     */   }
/*     */ 
/*     */   public Short getRankType()
/*     */   {
/* 136 */     return this.rankType;
/*     */   }
/*     */ 
/*     */   public void setRankType(Short rankType)
/*     */   {
/* 143 */     this.rankType = rankType;
/*     */   }
/*     */ 
/*     */   public Integer getRankValue()
/*     */   {
/* 150 */     return this.rankValue;
/*     */   }
/*     */ 
/*     */   public void setRankValue(Integer rankValue)
/*     */   {
/* 157 */     this.rankValue = rankValue;
/*     */   }
/*     */ 
/*     */   public Integer getServiceAttitude()
/*     */   {
/* 164 */     return this.serviceAttitude;
/*     */   }
/*     */ 
/*     */   public void setServiceAttitude(Integer serviceAttitude)
/*     */   {
/* 171 */     this.serviceAttitude = serviceAttitude;
/*     */   }
/*     */ 
/*     */   public Integer getLogisticsSpeed()
/*     */   {
/* 178 */     return this.logisticsSpeed;
/*     */   }
/*     */ 
/*     */   public void setLogisticsSpeed(Integer logisticsSpeed)
/*     */   {
/* 185 */     this.logisticsSpeed = logisticsSpeed;
/*     */   }
/*     */ 
/*     */   public String getMemo()
/*     */   {
/* 192 */     return this.memo;
/*     */   }
/*     */ 
/*     */   public void setMemo(String memo)
/*     */   {
/* 199 */     this.memo = memo;
/*     */   }
/*     */ 
/*     */   public String getCreator()
/*     */   {
/* 206 */     return this.creator;
/*     */   }
/*     */ 
/*     */   public void setCreator(String creator)
/*     */   {
/* 213 */     this.creator = creator;
/*     */   }
/*     */ 
/*     */   public Date getGmtCreate()
/*     */   {
/* 220 */     return this.gmtCreate;
/*     */   }
/*     */ 
/*     */   public void setGmtCreate(Date gmtCreate)
/*     */   {
/* 227 */     this.gmtCreate = gmtCreate;
/*     */   }
/*     */ 
/*     */   public String getRankTypeDesc()
/*     */   {
/* 238 */     EnumUserEvaluate enumUserEvaluate = EnumUserEvaluate.indexByValue(this.rankType.shortValue());
/* 239 */     if (null == enumUserEvaluate) {
/* 240 */       return "not exit";
/*     */     }
/* 242 */     return enumUserEvaluate.getName();
/*     */   }
/*     */ 
/*     */   public String getRankValueDesc()
/*     */   {
/* 253 */     EnumEvaluateResult enumEvaluateResult = EnumEvaluateResult.indexByValue(this.rankValue.intValue());
/* 254 */     if (null == enumEvaluateResult) {
/* 255 */       return "not exit";
/*     */     }
/* 257 */     return enumEvaluateResult.getName();
/*     */   }
/*     */ 
/*     */   public void setRemark(String remark) {
/* 261 */     this.remark = remark;
/*     */   }
/*     */ 
/*     */   public String getRemark() {
/* 265 */     return this.remark;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.domain.user.UserCreditLog
 * JD-Core Version:    0.6.0
 */