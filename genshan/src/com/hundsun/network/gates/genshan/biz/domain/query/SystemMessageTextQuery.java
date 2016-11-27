/*    */ package com.hundsun.network.gates.genshan.biz.domain.query;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.domain.message.SystemMessageText;
/*    */ import com.hundsun.network.gates.luosi.common.page.Pagination;
/*    */ import java.util.Date;
/*    */ 
/*    */ public class SystemMessageTextQuery extends Pagination<SystemMessageText>
/*    */ {
/*    */   private static final long serialVersionUID = -3584592635060959839L;
/*    */   private String title;
/*    */   private String operator;
/*    */   private Date beginTime;
/*    */   private Date endTime;
/*    */   private String receiveAccount;
/*    */   private String status;
/*    */ 
/*    */   public String getTitle()
/*    */   {
/* 50 */     return this.title;
/*    */   }
/*    */ 
/*    */   public void setTitle(String title) {
/* 54 */     this.title = title;
/*    */   }
/*    */ 
/*    */   public String getOperator() {
/* 58 */     return this.operator;
/*    */   }
/*    */ 
/*    */   public void setOperator(String operator) {
/* 62 */     this.operator = operator;
/*    */   }
/*    */ 
/*    */   public Date getBeginTime() {
/* 66 */     return this.beginTime;
/*    */   }
/*    */ 
/*    */   public void setBeginTime(Date beginTime) {
/* 70 */     this.beginTime = beginTime;
/*    */   }
/*    */ 
/*    */   public Date getEndTime() {
/* 74 */     return this.endTime;
/*    */   }
/*    */ 
/*    */   public void setEndTime(Date endTime) {
/* 78 */     this.endTime = endTime;
/*    */   }
/*    */ 
/*    */   public void setReceiveAccount(String receiveAccount) {
/* 82 */     this.receiveAccount = receiveAccount;
/*    */   }
/*    */ 
/*    */   public String getReceiveAccount() {
/* 86 */     return this.receiveAccount;
/*    */   }
/*    */ 
/*    */   public String getStatus() {
/* 90 */     return this.status;
/*    */   }
/*    */ 
/*    */   public void setStatus(String status) {
/* 94 */     this.status = status;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.query.SystemMessageTextQuery
 * JD-Core Version:    0.6.0
 */