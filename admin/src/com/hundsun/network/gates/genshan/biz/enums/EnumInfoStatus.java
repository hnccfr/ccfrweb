/*    */ package com.hundsun.network.gates.genshan.biz.enums;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public enum EnumInfoStatus
/*    */ {
/* 14 */   CREATE("C", "创建中"), 
/* 15 */   AUDIT("A", "待审核"), 
/* 16 */   NORMAL("N", "展示中"), 
/* 17 */   FAIL("F", "审核不通过"), 
/* 18 */   FORBIDDEN("B", "已禁用"), 
/* 19 */   OVERDUE("O", "已过期"), 
/* 20 */   DELETED("D", "已删除");
/*    */ 
/*    */   private String value;
/*    */   private String name;
/*    */   private static Map<String, EnumInfoStatus> pool;
/*    */ 
/*    */   public static EnumInfoStatus indexByValue(String value)
/*    */   {
/* 43 */     return (EnumInfoStatus)pool.get(value);
/*    */   }
/*    */ 
/*    */   private EnumInfoStatus(String value, String name) {
/* 47 */     this.value = value;
/* 48 */     this.name = name;
/*    */   }
/*    */ 
/*    */   public String getValue() {
/* 52 */     return this.value;
/*    */   }
/*    */ 
/*    */   public String getName() {
/* 56 */     return this.name;
/*    */   }
/*    */ 
/*    */   static
/*    */   {
/* 29 */     pool = new HashMap();
/*    */ 
/* 31 */     for (EnumInfoStatus et : values())
/* 32 */       pool.put(et.value, et);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.enums.EnumInfoStatus
 * JD-Core Version:    0.6.0
 */