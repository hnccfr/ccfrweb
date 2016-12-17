/*    */ package com.hundsun.network.gates.fengshan.biz.enums;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public enum EnumDateStatisticsType
/*    */ {
/*  8 */   DAY("YYYY-MM-DD", "日", Long.valueOf(1L)), 
/*  9 */   WEEK("YYYY-WW", "周", Long.valueOf(7L)), 
/* 10 */   MONTH("YYYY-MM", "月", Long.valueOf(30L)), 
/* 11 */   YEAR("YYYY", "年", Long.valueOf(365L));
/*    */ 
/*    */   private String value;
/*    */   private String name;
/*    */   private Long interval;
/*    */   private static Map<String, EnumDateStatisticsType> pool;
/*    */ 
/*    */   public static EnumDateStatisticsType indexByValue(String value)
/*    */   {
/* 35 */     return (EnumDateStatisticsType)pool.get(value);
/*    */   }
/*    */ 
/*    */   private EnumDateStatisticsType(String value, String name, Long interval) {
/* 39 */     this.value = value;
/* 40 */     this.name = name;
/* 41 */     this.interval = interval;
/*    */   }
/*    */ 
/*    */   public String getValue() {
/* 45 */     return this.value;
/*    */   }
/*    */ 
/*    */   public String getName()
/*    */   {
/* 50 */     return this.name;
/*    */   }
/*    */ 
/*    */   public Long getInterval()
/*    */   {
/* 55 */     return this.interval;
/*    */   }
/*    */ 
/*    */   static
/*    */   {
/* 22 */     pool = new HashMap();
/*    */ 
/* 24 */     for (EnumDateStatisticsType et : values())
/* 25 */       pool.put(et.value, et);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.enums.EnumDateStatisticsType
 * JD-Core Version:    0.6.0
 */