/*    */ package com.hundsun.network.gates.genshan.biz.enums;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public enum EnumInfoType
/*    */ {
/* 13 */   SUPPLY("supply", "供应"), 
/* 14 */   DEMAND("demand", "求购");
/*    */ 
/*    */   private String value;
/*    */   private String name;
/*    */   private static Map<String, EnumInfoType> pool;
/*    */ 
/*    */   public static EnumInfoType indexByValue(String value)
/*    */   {
/* 36 */     return (EnumInfoType)pool.get(value);
/*    */   }
/*    */ 
/*    */   private EnumInfoType(String value, String name)
/*    */   {
/* 45 */     this.value = value;
/* 46 */     this.name = name;
/*    */   }
/*    */ 
/*    */   public String getValue() {
/* 50 */     return this.value;
/*    */   }
/*    */ 
/*    */   public String getName() {
/* 54 */     return this.name;
/*    */   }
/*    */ 
/*    */   static
/*    */   {
/* 22 */     pool = new HashMap();
/*    */ 
/* 24 */     for (EnumInfoType et : values())
/* 25 */       pool.put(et.value, et);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.enums.EnumInfoType
 * JD-Core Version:    0.6.0
 */