/*    */ package com.hundsun.eclp.enums;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public enum EnumRoleIsCore
/*    */ {
/* 11 */   BASIC((short)0, "基础角色"), 
/* 12 */   CORE((short)1, "核心角色"), 
/* 13 */   APPLICATION((short)2, "扩展角色");
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
/*    */   private EnumRoleIsCore(Short code, String desc) {
/* 36 */     this.code = code;
/* 37 */     this.desc = desc;
/*    */   }
/*    */ 
/*    */   public static Map<Short, String> toMap() {
/* 41 */     Map map = new HashMap();
/* 42 */     for (EnumRoleIsCore item : values()) {
/* 43 */       map.put(item.getCode(), item.getDesc());
/*    */     }
/* 45 */     return map;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.enums.EnumRoleIsCore
 * JD-Core Version:    0.6.0
 */