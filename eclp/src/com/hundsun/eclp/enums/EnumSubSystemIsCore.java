/*    */ package com.hundsun.eclp.enums;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public enum EnumSubSystemIsCore
/*    */ {
/* 11 */   BASIC((short)0, "基础子系统"), 
/* 12 */   CORE((short)1, "核心子系统"), 
/* 13 */   APPLICATION((short)2, "扩展子系统");
/*    */ 
/*    */   private Short code;
/*    */   private String desc;
/*    */ 
/* 20 */   public Short getCode() { return this.code; }
/*    */ 
/*    */   public void setCode(Short code)
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
/*    */   private EnumSubSystemIsCore(Short code, String desc) {
/* 36 */     this.code = code;
/* 37 */     this.desc = desc;
/*    */   }
/*    */ 
/*    */   public static Map<Short, String> toMap() {
/* 41 */     Map map = new HashMap();
/* 42 */     for (EnumSubSystemIsCore item : values()) {
/* 43 */       map.put(item.getCode(), item.getDesc());
/*    */     }
/* 45 */     return map;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.enums.EnumSubSystemIsCore
 * JD-Core Version:    0.6.0
 */