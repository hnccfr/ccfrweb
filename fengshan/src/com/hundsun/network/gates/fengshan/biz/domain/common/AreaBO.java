/*    */ package com.hundsun.network.gates.fengshan.biz.domain.common;
/*    */ 
/*    */ public class AreaBO
/*    */   implements Comparable<AreaBO>
/*    */ {
/*    */   private static final long serialVersionUID = 3595885970317721542L;
/*    */   private String value;
/*    */   private String name;
/*    */   private Integer ranking;
/*    */ 
/*    */   public String getValue()
/*    */   {
/* 26 */     return this.value;
/*    */   }
/*    */ 
/*    */   public void setValue(String value) {
/* 30 */     this.value = value;
/*    */   }
/*    */ 
/*    */   public String getName() {
/* 34 */     return this.name;
/*    */   }
/*    */ 
/*    */   public void setName(String name) {
/* 38 */     this.name = name;
/*    */   }
/*    */ 
/*    */   public int compareTo(AreaBO o)
/*    */   {
/* 43 */     if (o == null) {
/* 44 */       throw new IllegalArgumentException("argument can't be null");
/*    */     }
/* 46 */     if (o == this) {
/* 47 */       return 0;
/*    */     }
/* 49 */     AreaBO areaBO = o;
/* 50 */     return this.ranking.compareTo(areaBO.getRanking());
/*    */   }
/*    */ 
/*    */   public Integer getRanking() {
/* 54 */     return this.ranking;
/*    */   }
/*    */ 
/*    */   public void setRanking(Integer ranking) {
/* 58 */     this.ranking = ranking;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.domain.common.AreaBO
 * JD-Core Version:    0.6.0
 */