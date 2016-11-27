/*    */ package com.hundsun.eclp.enums;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public enum EnumFuncReCheckStatus
/*    */ {
/*  7 */   ENABLE((short)1, "启用"), 
/*  8 */   DISABLE((short)0, "禁用");
/*    */ 
/*    */   private short code;
/*    */   private String desc;
/*    */ 
/* 15 */   public short getCode() { return this.code; }
/*    */ 
/*    */   public void setCode(short code)
/*    */   {
/* 19 */     this.code = code;
/*    */   }
/*    */ 
/*    */   public String getDesc() {
/* 23 */     return this.desc;
/*    */   }
/*    */ 
/*    */   public void setDesc(String desc) {
/* 27 */     this.desc = desc;
/*    */   }
/*    */ 
/*    */   private EnumFuncReCheckStatus(short code, String desc) {
/* 31 */     this.code = code;
/* 32 */     this.desc = desc;
/*    */   }
/*    */ 
/*    */   public static Map<Short, String> toMap() {
/* 36 */     Map map = new HashMap();
/* 37 */     for (EnumFuncReCheckStatus item : values()) {
/* 38 */       map.put(Short.valueOf(item.getCode()), item.getDesc());
/*    */     }
/* 40 */     return map;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.enums.EnumFuncReCheckStatus
 * JD-Core Version:    0.6.0
 */