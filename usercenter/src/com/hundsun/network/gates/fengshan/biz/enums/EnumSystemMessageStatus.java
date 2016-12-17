/*    */ package com.hundsun.network.gates.fengshan.biz.enums;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public enum EnumSystemMessageStatus
/*    */ {
/* 14 */   ISREAD("Y", "已读"), NOTREAD("N", "未读");
/*    */ 
/*    */   private String value;
/*    */   private String name;
/*    */   private static Map<String, EnumSystemMessageStatus> pool;
/*    */ 
/*    */   public static EnumSystemMessageStatus indexByValue(String value)
/*    */   {
/* 36 */     return (EnumSystemMessageStatus)pool.get(value);
/*    */   }
/*    */ 
/*    */   private EnumSystemMessageStatus(String value, String name) {
/* 40 */     this.value = value;
/* 41 */     this.name = name;
/*    */   }
/*    */ 
/*    */   public String getValue() {
/* 45 */     return this.value;
/*    */   }
/*    */ 
/*    */   public void setValue(String value) {
/* 49 */     this.value = value;
/*    */   }
/*    */ 
/*    */   public String getName() {
/* 53 */     return this.name;
/*    */   }
/*    */ 
/*    */   public void setName(String name) {
/* 57 */     this.name = name;
/*    */   }
/*    */ 
/*    */   static
/*    */   {
/* 23 */     pool = new HashMap();
/*    */ 
/* 25 */     for (EnumSystemMessageStatus et : values())
/* 26 */       pool.put(et.value, et);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.enums.EnumSystemMessageStatus
 * JD-Core Version:    0.6.0
 */