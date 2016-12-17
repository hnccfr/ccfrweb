/*    */ package com.hundsun.network.gates.genshan.biz.domain.query;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.domain.baseset.SystemCreditLevel;
/*    */ import com.hundsun.network.gates.luosi.common.page.Pagination;
/*    */ 
/*    */ public class SystemCreditLevelQuery extends Pagination<SystemCreditLevel>
/*    */ {
/*    */   private static final long serialVersionUID = 5771823174520969786L;
/*    */   private String creditLevel;
/*    */   private String levelName;
/*    */   private Long noneId;
/*    */   private Integer integralStart;
/*    */   private Integer integralEnd;
/*    */ 
/*    */   public String getCreditLevel()
/*    */   {
/* 24 */     return this.creditLevel;
/*    */   }
/*    */   public void setCreditLevel(String creditLevel) {
/* 27 */     this.creditLevel = creditLevel;
/*    */   }
/*    */   public String getLevelName() {
/* 30 */     return this.levelName;
/*    */   }
/*    */   public void setLevelName(String levelName) {
/* 33 */     this.levelName = levelName;
/*    */   }
/*    */   public Long getNoneId() {
/* 36 */     return this.noneId;
/*    */   }
/*    */   public void setNoneId(Long noneId) {
/* 39 */     this.noneId = noneId;
/*    */   }
/*    */   public Integer getIntegralStart() {
/* 42 */     return this.integralStart;
/*    */   }
/*    */   public void setIntegralStart(Integer integralStart) {
/* 45 */     this.integralStart = integralStart;
/*    */   }
/*    */   public Integer getIntegralEnd() {
/* 48 */     return this.integralEnd;
/*    */   }
/*    */   public void setIntegralEnd(Integer integralEnd) {
/* 51 */     this.integralEnd = integralEnd;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.query.SystemCreditLevelQuery
 * JD-Core Version:    0.6.0
 */