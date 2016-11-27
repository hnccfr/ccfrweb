/*    */ package com.hundsun.eclp.enums;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public enum EnumIsCore
/*    */ {
/* 11 */   BASE((short)0, "基础级"), 
/* 12 */   CORE((short)1, "核心级"), 
/* 13 */   APPLICATION((short)2, "应用级");
/*    */ 
/*    */   private short code;
/*    */   private String desc;
/*    */ 
/* 20 */   public short getCode() { return this.code; }
/*    */ 
/*    */   public void setCode(short code)
/*    */   {
/* 24 */     this.code = code;
/*    */   }
/*    */ 
/*    */   public String getDesc() {
/* 28 */     return this.desc;
/*    */   }
/*    */ 
/*    */   public void setDesc(String desc) {
/* 32 */     this.desc = desc;
/*    */   }
/*    */ 
/*    */   private EnumIsCore(short code, String desc) {
/* 36 */     this.code = code;
/* 37 */     this.desc = desc;
/*    */   }
/*    */ 
/*    */   public static Map<Short, String> toMap() {
/* 41 */     Map map = new HashMap();
/* 42 */     for (EnumIsCore item : values()) {
/* 43 */       map.put(Short.valueOf(item.getCode()), item.getDesc());
/*    */     }
/* 45 */     return map;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.enums.EnumIsCore
 * JD-Core Version:    0.6.0
 */