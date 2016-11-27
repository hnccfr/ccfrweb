/*    */ package com.hundsun.network.gates.fengshan.biz.domain.query;
/*    */ 
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.user.UserCreditLog;
/*    */ import com.hundsun.network.gates.luosi.common.page.Pagination;
/*    */ import java.util.Date;
/*    */ 
/*    */ public class EvaluateQuery extends Pagination<UserCreditLog>
/*    */ {
/*    */   private static final long serialVersionUID = 5945602242165309292L;
/*    */   private String creator;
/*    */   private String userAccount;
/*    */   private Integer rankType;
/*    */   private Integer rankValue;
/*    */   private Date beginTime;
/*    */   private Date endTime;
/*    */ 
/*    */   public String getCreator()
/*    */   {
/* 50 */     return this.creator;
/*    */   }
/*    */ 
/*    */   public void setCreator(String creator) {
/* 54 */     this.creator = creator;
/*    */   }
/*    */ 
/*    */   public String getUserAccount() {
/* 58 */     return this.userAccount;
/*    */   }
/*    */ 
/*    */   public void setUserAccount(String userAccount) {
/* 62 */     this.userAccount = userAccount;
/*    */   }
/*    */ 
/*    */   public Integer getRankType() {
/* 66 */     return this.rankType;
/*    */   }
/*    */ 
/*    */   public void setRankType(Integer rankType) {
/* 70 */     this.rankType = rankType;
/*    */   }
/*    */ 
/*    */   public Integer getRankValue() {
/* 74 */     return this.rankValue;
/*    */   }
/*    */ 
/*    */   public void setRankValue(Integer rankValue) {
/* 78 */     this.rankValue = rankValue;
/*    */   }
/*    */ 
/*    */   public Date getBeginTime() {
/* 82 */     return this.beginTime;
/*    */   }
/*    */ 
/*    */   public void setBeginTime(Date beginTime) {
/* 86 */     this.beginTime = beginTime;
/*    */   }
/*    */ 
/*    */   public Date getEndTime() {
/* 90 */     return this.endTime;
/*    */   }
/*    */ 
/*    */   public void setEndTime(Date endTime) {
/* 94 */     this.endTime = endTime;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.domain.query.EvaluateQuery
 * JD-Core Version:    0.6.0
 */