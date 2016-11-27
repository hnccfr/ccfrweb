/*    */ package com.hundsun.network.gates.genshan.biz.domain.query;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.page.Pagination;
/*    */ import java.util.Date;
/*    */ 
/*    */ public class BasePhaseQuery<BasePhase> extends Pagination<BasePhase>
/*    */ {
/*    */   private static final long serialVersionUID = -8711898577437589269L;
/*    */   private String phaseCode;
/*    */   private String phaseName;
/*    */   private String state;
/*    */   private String endHourNext;
/*    */   private Date tradeDay;
/*    */ 
/*    */   public String getPhaseCode()
/*    */   {
/* 34 */     return this.phaseCode;
/*    */   }
/*    */   public void setPhaseCode(String phaseCode) {
/* 37 */     this.phaseCode = phaseCode;
/*    */   }
/*    */   public String getPhaseName() {
/* 40 */     return this.phaseName;
/*    */   }
/*    */   public void setPhaseName(String phaseName) {
/* 43 */     this.phaseName = phaseName;
/*    */   }
/*    */   public String getState() {
/* 46 */     return this.state;
/*    */   }
/*    */   public void setState(String state) {
/* 49 */     this.state = state;
/*    */   }
/*    */   public void setEndHourNext(String endHourNext) {
/* 52 */     this.endHourNext = endHourNext;
/*    */   }
/*    */   public String getEndHourNext() {
/* 55 */     return this.endHourNext;
/*    */   }
/*    */   public void setTradeDay(Date tradeDay) {
/* 58 */     this.tradeDay = tradeDay;
/*    */   }
/*    */   public Date getTradeDay() {
/* 61 */     return this.tradeDay;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.query.BasePhaseQuery
 * JD-Core Version:    0.6.0
 */