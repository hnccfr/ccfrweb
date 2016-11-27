/*    */ package com.hundsun.network.gates.fengshan.biz.enums;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public enum EnumApplyTime
/*    */ {
/* 14 */   SUCCESS("success", "可以报名"), 
/* 15 */   EARLY_THAN_START("early_than_start", "不能早于报名开始时间报名"), 
/* 16 */   LATE_THAN_END("late_than_end", "不能晚于报名结束时间报名"), 
/* 17 */   TANS_ERROR("error", "时间转化失败");
/*    */ 
/*    */   private String value;
/*    */   private String name;
/*    */   private static Map<String, EnumApplyTime> pool;
/*    */ 
/*    */   public static EnumApplyTime indexByValue(String value)
/*    */   {
/* 39 */     return (EnumApplyTime)pool.get(value);
/*    */   }
/*    */ 
/*    */   private EnumApplyTime(String value, String name) {
/* 43 */     this.value = value;
/* 44 */     this.name = name;
/*    */   }
/*    */ 
/*    */   public String getValue() {
/* 48 */     return this.value;
/*    */   }
/*    */ 
/*    */   public String getName() {
/* 52 */     return this.name;
/*    */   }
/*    */ 
/*    */   static
/*    */   {
/* 26 */     pool = new HashMap();
/*    */ 
/* 28 */     for (EnumApplyTime et : values())
/* 29 */       pool.put(et.value, et);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.enums.EnumApplyTime
 * JD-Core Version:    0.6.0
 */