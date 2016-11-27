/*    */ package com.hundsun.network.gates.qingbo.biz.domain.auction;
/*    */ 
/*    */ import com.hundsun.network.gates.qingbo.biz.domain.BaseDomain;
/*    */ 
/*    */ public class ControlAuction extends BaseDomain
/*    */ {
/*    */   private static final long serialVersionUID = 1602023395134654715L;
/*    */   private String projectCode;
/*    */   private String latestStatus;
/*    */   private String haveReservePrice;
/*    */   private String supportPriority;
/*    */   private Integer priorityNum;
/*    */ 
/*    */   public String getProjectCode()
/*    */   {
/* 47 */     return this.projectCode;
/*    */   }
/*    */ 
/*    */   public void setProjectCode(String projectCode) {
/* 51 */     this.projectCode = projectCode;
/*    */   }
/*    */ 
/*    */   public String getLatestStatus() {
/* 55 */     return this.latestStatus;
/*    */   }
/*    */ 
/*    */   public void setLatestStatus(String latestStatus) {
/* 59 */     this.latestStatus = latestStatus;
/*    */   }
/*    */ 
/*    */   public String getHaveReservePrice() {
/* 63 */     return this.haveReservePrice;
/*    */   }
/*    */ 
/*    */   public void setHaveReservePrice(String haveReservePrice) {
/* 67 */     this.haveReservePrice = haveReservePrice;
/*    */   }
/*    */ 
/*    */   public String getSupportPriority() {
/* 71 */     return this.supportPriority;
/*    */   }
/*    */ 
/*    */   public void setSupportPriority(String supportPriority) {
/* 75 */     this.supportPriority = supportPriority;
/*    */   }
/*    */ 
/*    */   public Integer getPriorityNum() {
/* 79 */     return this.priorityNum;
/*    */   }
/*    */ 
/*    */   public void setPriorityNum(Integer priorityNum) {
/* 83 */     this.priorityNum = priorityNum;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.qingbo.biz.domain.auction.ControlAuction
 * JD-Core Version:    0.6.0
 */