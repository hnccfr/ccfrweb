/*    */ package com.hundsun.eclp.enums;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public enum EnumRoleStatus
/*    */ {
/* 10 */   ENABLE(1, "启用"), 
/* 11 */   DISABLE(2, "禁用");
/*    */ 
/*    */   private int code;
/*    */   private String desc;
/*    */ 
/* 18 */   public int getCode() { return this.code; }
/*    */ 
/*    */   public void setCode(int code)
/*    */   {
/* 22 */     this.code = code;
/*    */   }
/*    */ 
/*    */   public String getDesc() {
/* 26 */     return this.desc;
/*    */   }
/*    */ 
/*    */   public void setDesc(String desc) {
/* 30 */     this.desc = desc;
/*    */   }
/*    */ 
/*    */   private EnumRoleStatus(int code, String desc) {
/* 34 */     this.code = code;
/* 35 */     this.desc = desc;
/*    */   }
/*    */ 
/*    */   public static Map<Integer, String> toMap() {
/* 39 */     Map map = new HashMap();
/* 40 */     for (EnumRoleStatus item : values()) {
/* 41 */       map.put(Integer.valueOf(item.getCode()), item.getDesc());
/*    */     }
/* 43 */     return map;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.enums.EnumRoleStatus
 * JD-Core Version:    0.6.0
 */