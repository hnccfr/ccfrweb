/*    */ package com.hundsun.network.gates.fengshan.biz.enums;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public enum EnumAccuseType
/*    */ {
/* 15 */   ILLEGAL("illegal", "违法"), 
/* 16 */   FAKE("fake", "虚假"), 
/* 17 */   OVERDUE("overdue", "过期"), 
/* 18 */   MALICIOUS("malicious", "恶意信息"), 
/* 19 */   OTHER("other", "其他");
/*    */ 
/*    */   private String value;
/*    */   private String name;
/*    */   private static Map<String, EnumAccuseType> pool;
/*    */ 
/*    */   public static EnumAccuseType indexByValue(String value)
/*    */   {
/* 40 */     return (EnumAccuseType)pool.get(value);
/*    */   }
/*    */ 
/*    */   private EnumAccuseType(String value, String name) {
/* 44 */     this.value = value;
/* 45 */     this.name = name;
/*    */   }
/*    */ 
/*    */   public String getValue() {
/* 49 */     return this.value;
/*    */   }
/*    */ 
/*    */   public String getName() {
/* 53 */     return this.name;
/*    */   }
/*    */ 
/*    */   static
/*    */   {
/* 27 */     pool = new HashMap();
/*    */ 
/* 29 */     for (EnumAccuseType et : values())
/* 30 */       pool.put(et.value, et);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.enums.EnumAccuseType
 * JD-Core Version:    0.6.0
 */