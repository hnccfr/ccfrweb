/*    */ package com.hundsun.network.gates.fengshan.biz.domain.supplydemand;
/*    */ 
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.BaseDomain;
/*    */ import com.hundsun.network.gates.fengshan.biz.enums.EnumAccuseType;
/*    */ import java.util.Date;
/*    */ 
/*    */ public class AccuseInfo extends BaseDomain
/*    */ {
/*    */   private static final long serialVersionUID = -9207284788192239041L;
/*    */   public long id;
/*    */   public long infoId;
/*    */   public String type;
/*    */   public String typeDesc;
/*    */   public String reason;
/*    */   public String status;
/*    */   public String accuser;
/*    */   private Date gmtCreate;
/*    */   private Date gmtModify;
/*    */ 
/*    */   public long getId()
/*    */   {
/* 29 */     return this.id;
/*    */   }
/*    */   public void setId(long id) {
/* 32 */     this.id = id;
/*    */   }
/*    */   public long getInfoId() {
/* 35 */     return this.infoId;
/*    */   }
/*    */   public void setInfoId(long infoId) {
/* 38 */     this.infoId = infoId;
/*    */   }
/*    */   public String getType() {
/* 41 */     return this.type;
/*    */   }
/*    */   public void setType(String type) {
/* 44 */     this.type = type;
/*    */   }
/*    */   public String getReason() {
/* 47 */     return this.reason;
/*    */   }
/*    */   public void setReason(String reason) {
/* 50 */     this.reason = reason;
/*    */   }
/*    */   public String getStatus() {
/* 53 */     return this.status;
/*    */   }
/*    */   public void setStatus(String status) {
/* 56 */     this.status = status;
/*    */   }
/*    */   public String getAccuser() {
/* 59 */     return this.accuser;
/*    */   }
/*    */   public void setAccuser(String accuser) {
/* 62 */     this.accuser = accuser;
/*    */   }
/*    */   public Date getGmtCreate() {
/* 65 */     return this.gmtCreate;
/*    */   }
/*    */   public void setGmtCreate(Date gmtCreate) {
/* 68 */     this.gmtCreate = gmtCreate;
/*    */   }
/*    */   public Date getGmtModify() {
/* 71 */     return this.gmtModify;
/*    */   }
/*    */   public void setGmtModify(Date gmtModify) {
/* 74 */     this.gmtModify = gmtModify;
/*    */   }
/*    */   public String getTypeDesc() {
/* 77 */     EnumAccuseType enumAccuseType = EnumAccuseType.indexByValue(this.type);
/* 78 */     if (null == enumAccuseType) {
/* 79 */       return this.type;
/*    */     }
/* 81 */     return enumAccuseType.getName();
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.domain.supplydemand.AccuseInfo
 * JD-Core Version:    0.6.0
 */