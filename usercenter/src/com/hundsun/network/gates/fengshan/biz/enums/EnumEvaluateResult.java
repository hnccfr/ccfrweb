/*    */ package com.hundsun.network.gates.fengshan.biz.enums;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public enum EnumEvaluateResult
/*    */ {
/*  8 */   GOOD_EVALUATE(1, "好评"), 
/*  9 */   MIDDLE_EVALUATE(0, "中评"), 
/* 10 */   BAD_EVALUATE(-1, "差评");
/*    */ 
/*    */   private Integer value;
/*    */   private String name;
/*    */   private static Map<Integer, EnumEvaluateResult> pool;
/*    */ 
/*    */   public static EnumEvaluateResult indexByValue(int value)
/*    */   {
/* 33 */     return (EnumEvaluateResult)pool.get(Integer.valueOf(value));
/*    */   }
/*    */ 
/*    */   private EnumEvaluateResult(int value, String name) {
/* 37 */     this.value = Integer.valueOf(value);
/* 38 */     this.name = name;
/*    */   }
/*    */   public int getValue() {
/* 41 */     return this.value.intValue();
/*    */   }
/*    */ 
/*    */   public void setValue(int value) {
/* 45 */     this.value = Integer.valueOf(value);
/*    */   }
/*    */ 
/*    */   public String getName() {
/* 49 */     return this.name;
/*    */   }
/*    */ 
/*    */   public void setName(String name) {
/* 53 */     this.name = name;
/*    */   }
/*    */ 
/*    */   static
/*    */   {
/* 20 */     pool = new HashMap();
/*    */ 
/* 22 */     for (EnumEvaluateResult et : values())
/* 23 */       pool.put(et.value, et);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.enums.EnumEvaluateResult
 * JD-Core Version:    0.6.0
 */