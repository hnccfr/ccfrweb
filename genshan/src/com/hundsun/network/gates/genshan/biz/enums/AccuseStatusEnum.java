/*    */ package com.hundsun.network.gates.genshan.biz.enums;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public enum AccuseStatusEnum
/*    */ {
/* 18 */   AUDIT("A", "待审核"), 
/* 19 */   EFFECTIVE("E", "举报有效"), 
/* 20 */   INVALID("I", "举报无效"), 
/* 21 */   UNACCEPT("U", "未采纳");
/*    */ 
/*    */   private String value;
/*    */   private String name;
/*    */   private static Map<String, AccuseStatusEnum> pool;
/*    */ 
/*    */   public static AccuseStatusEnum indexByValue(String value)
/*    */   {
/* 44 */     return (AccuseStatusEnum)pool.get(value);
/*    */   }
/*    */ 
/*    */   private AccuseStatusEnum(String value, String name) {
/* 48 */     this.value = value;
/* 49 */     this.name = name;
/*    */   }
/*    */ 
/*    */   public String getValue() {
/* 53 */     return this.value;
/*    */   }
/*    */ 
/*    */   public String getName() {
/* 57 */     return this.name;
/*    */   }
/*    */ 
/*    */   static
/*    */   {
/* 30 */     pool = new HashMap();
/*    */ 
/* 32 */     for (AccuseStatusEnum et : values())
/* 33 */       pool.put(et.value, et);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.enums.AccuseStatusEnum
 * JD-Core Version:    0.6.0
 */