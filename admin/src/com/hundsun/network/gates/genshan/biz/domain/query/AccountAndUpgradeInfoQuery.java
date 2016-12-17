/*    */ package com.hundsun.network.gates.genshan.biz.domain.query;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.domain.user.UserAccountAndUpgradeInfo;
/*    */ import com.hundsun.network.gates.luosi.common.page.Pagination;
/*    */ import java.util.Date;
/*    */ 
/*    */ public class AccountAndUpgradeInfoQuery extends Pagination<UserAccountAndUpgradeInfo>
/*    */ {
/*    */   private static final long serialVersionUID = -7226168100457354484L;
/*    */   private String account;
/*    */   private String name;
/*    */   private Date beginTime;
/*    */   private Date endTime;
/*    */   private String auditNode;
/*    */   private String applyLevel;
/*    */ 
/*    */   public String getAccount()
/*    */   {
/* 43 */     return this.account;
/*    */   }
/*    */ 
/*    */   public void setAccount(String account) {
/* 47 */     this.account = account;
/*    */   }
/*    */ 
/*    */   public String getName() {
/* 51 */     return this.name;
/*    */   }
/*    */ 
/*    */   public void setName(String name) {
/* 55 */     this.name = name;
/*    */   }
/*    */ 
/*    */   public Date getBeginTime() {
/* 59 */     return this.beginTime;
/*    */   }
/*    */ 
/*    */   public void setBeginTime(Date beginTime) {
/* 63 */     this.beginTime = beginTime;
/*    */   }
/*    */ 
/*    */   public Date getEndTime() {
/* 67 */     return this.endTime;
/*    */   }
/*    */ 
/*    */   public void setEndTime(Date endTime) {
/* 71 */     this.endTime = endTime;
/*    */   }
/*    */ 
/*    */   public static long getSerialversionuid() {
/* 75 */     return -7226168100457354484L;
/*    */   }
/*    */ 
/*    */   public void setAuditNode(String auditNode) {
/* 79 */     this.auditNode = auditNode;
/*    */   }
/*    */ 
/*    */   public String getAuditNode() {
/* 83 */     return this.auditNode;
/*    */   }
/*    */ 
/*    */   public void setApplyLevel(String applyLevel) {
/* 87 */     this.applyLevel = applyLevel;
/*    */   }
/*    */ 
/*    */   public String getApplyLevel() {
/* 91 */     return this.applyLevel;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.query.AccountAndUpgradeInfoQuery
 * JD-Core Version:    0.6.0
 */