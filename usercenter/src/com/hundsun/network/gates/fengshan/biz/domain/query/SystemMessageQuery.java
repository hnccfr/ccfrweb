/*    */ package com.hundsun.network.gates.fengshan.biz.domain.query;
/*    */ 
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.message.SystemMessage;
/*    */ import com.hundsun.network.gates.luosi.common.page.Pagination;
/*    */ import java.util.Date;
/*    */ 
/*    */ public class SystemMessageQuery extends Pagination<SystemMessage>
/*    */ {
/*    */   private static final long serialVersionUID = 972147135405596784L;
/*    */   private String title;
/*    */   private String status;
/*    */   private String sendAccount;
/*    */   private Date beginTime;
/*    */   private Date endTime;
/*    */   private String receiveAccount;
/*    */ 
/*    */   public String getTitle()
/*    */   {
/* 43 */     return this.title;
/*    */   }
/*    */ 
/*    */   public void setTitle(String title) {
/* 47 */     this.title = title;
/*    */   }
/*    */ 
/*    */   public String getStatus() {
/* 51 */     return this.status;
/*    */   }
/*    */ 
/*    */   public void setStatus(String status) {
/* 55 */     this.status = status;
/*    */   }
/*    */ 
/*    */   public String getSendAccount() {
/* 59 */     return this.sendAccount;
/*    */   }
/*    */ 
/*    */   public void setSendAccount(String sendAccount) {
/* 63 */     this.sendAccount = sendAccount;
/*    */   }
/*    */ 
/*    */   public Date getBeginTime() {
/* 67 */     return this.beginTime;
/*    */   }
/*    */ 
/*    */   public void setBeginTime(Date beginTime) {
/* 71 */     this.beginTime = beginTime;
/*    */   }
/*    */ 
/*    */   public Date getEndTime() {
/* 75 */     return this.endTime;
/*    */   }
/*    */ 
/*    */   public void setEndTime(Date endTime) {
/* 79 */     this.endTime = endTime;
/*    */   }
/*    */ 
/*    */   public void setReceiveAccount(String receiveAccount) {
/* 83 */     this.receiveAccount = receiveAccount;
/*    */   }
/*    */ 
/*    */   public String getReceiveAccount() {
/* 87 */     return this.receiveAccount;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.domain.query.SystemMessageQuery
 * JD-Core Version:    0.6.0
 */