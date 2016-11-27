/*    */ package com.hundsun.eclp.enums;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public enum EnumSubSystemStatus
/*    */ {
/* 12 */   ENABLE(1, "启用"), 
/* 13 */   DISABLE(2, "禁用");
/*    */ 
/*    */   private int code;
/*    */   private String desc;
/*    */ 
/* 20 */   public int getCode() { return this.code; }
/*    */ 
/*    */   public void setCode(int code)
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
/*    */   private EnumSubSystemStatus(int code, String desc) {
/* 36 */     this.code = code;
/* 37 */     this.desc = desc;
/*    */   }
/*    */ 
/*    */   public static Map<Integer, String> toMap() {
/* 41 */     Map map = new HashMap();
/* 42 */     for (EnumSubSystemStatus item : values()) {
/* 43 */       map.put(Integer.valueOf(item.getCode()), item.getDesc());
/*    */     }
/* 45 */     return map;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.enums.EnumSubSystemStatus
 * JD-Core Version:    0.6.0
 */