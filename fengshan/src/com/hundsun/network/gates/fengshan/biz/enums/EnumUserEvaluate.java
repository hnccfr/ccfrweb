/*    */ package com.hundsun.network.gates.fengshan.biz.enums;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public enum EnumUserEvaluate
/*    */ {
/*  8 */   BUYER_EVALUATE(1, "买家评价"), 
/*  9 */   SELLER_EVALUATE(2, "卖家评价"), 
/* 10 */   DECREASE_CURDIT(3, "扣除信用");
/*    */ 
/*    */   private Integer value;
/*    */   private String name;
/*    */   private static Map<Integer, EnumUserEvaluate> pool;
/*    */ 
/*    */   public static EnumUserEvaluate indexByValue(int value)
/*    */   {
/* 33 */     return (EnumUserEvaluate)pool.get(Integer.valueOf(value));
/*    */   }
/*    */ 
/*    */   private EnumUserEvaluate(int value, String name) {
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
/* 22 */     for (EnumUserEvaluate et : values())
/* 23 */       pool.put(et.value, et);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.enums.EnumUserEvaluate
 * JD-Core Version:    0.6.0
 */