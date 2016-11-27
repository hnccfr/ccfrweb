/*    */ package com.hundsun.network.gates.fengshan.biz.domain.common;
/*    */ 
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.BaseDomain;
/*    */ import com.hundsun.network.gates.fengshan.biz.enums.EnumDateStatisticsType;
/*    */ 
/*    */ public class DateStatistics extends BaseDomain
/*    */ {
/*    */   private static final long serialVersionUID = -9038617239344296051L;
/*    */   private String statisticsDate;
/*    */   private String type;
/*    */   private Long amount;
/*    */ 
/*    */   public Long getAmount()
/*    */   {
/* 41 */     return this.amount;
/*    */   }
/*    */ 
/*    */   public void setAmount(Long amount) {
/* 45 */     this.amount = amount;
/*    */   }
/*    */ 
/*    */   public String getType() {
/* 49 */     return this.type;
/*    */   }
/*    */ 
/*    */   public String getTypeDesc() {
/* 53 */     EnumDateStatisticsType _type = EnumDateStatisticsType.indexByValue(this.type);
/* 54 */     if (null != _type) {
/* 55 */       return _type.getName();
/*    */     }
/* 57 */     return this.type;
/*    */   }
/*    */ 
/*    */   public void setType(String type) {
/* 61 */     this.type = type;
/*    */   }
/*    */ 
/*    */   public String getStatisticsDate() {
/* 65 */     return this.statisticsDate;
/*    */   }
/*    */ 
/*    */   public void setStatisticsDate(String statisticsDate) {
/* 69 */     this.statisticsDate = statisticsDate;
/*    */   }
/*    */ 
/*    */   public boolean equals(Object obj)
/*    */   {
/* 74 */     if ((obj instanceof DateStatistics)) {
/* 75 */       return ((DateStatistics)obj).getStatisticsDate().equals(getStatisticsDate());
/*    */     }
/* 77 */     return super.equals(obj);
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 82 */     return getStatisticsDate() + " : " + getAmount();
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.domain.common.DateStatistics
 * JD-Core Version:    0.6.0
 */