/*    */ package com.hundsun.network.gates.genshan.biz.enums;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public enum AccuseTypeEnum
/*    */ {
/* 18 */   ILLEGAL("illegal", "违法"), 
/* 19 */   FAKE("fake", "虚假"), 
/* 20 */   OVERDUE("overdue", "过期"), 
/* 21 */   MALICIOUS("malicious", "恶意"), 
/* 22 */   OTHER("other", "其他");
/*    */ 
/*    */   private String value;
/*    */   private String name;
/*    */   private static Map<String, AccuseTypeEnum> pool;
/*    */ 
/*    */   public static AccuseTypeEnum indexByValue(String value)
/*    */   {
/* 45 */     return (AccuseTypeEnum)pool.get(value);
/*    */   }
/*    */ 
/*    */   private AccuseTypeEnum(String value, String name) {
/* 49 */     this.value = value;
/* 50 */     this.name = name;
/*    */   }
/*    */ 
/*    */   public String getValue() {
/* 54 */     return this.value;
/*    */   }
/*    */ 
/*    */   public String getName() {
/* 58 */     return this.name;
/*    */   }
/*    */ 
/*    */   static
/*    */   {
/* 31 */     pool = new HashMap();
/*    */ 
/* 33 */     for (AccuseTypeEnum et : values())
/* 34 */       pool.put(et.value, et);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.enums.AccuseTypeEnum
 * JD-Core Version:    0.6.0
 */