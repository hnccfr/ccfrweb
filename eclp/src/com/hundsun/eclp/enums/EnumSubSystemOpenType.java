/*    */ package com.hundsun.eclp.enums;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public enum EnumSubSystemOpenType
/*    */ {
/* 12 */   PAGE_EMBEDDED(1, "页面嵌入"), 
/* 13 */   NEW_WINDOW(2, "弹出新窗口"), 
/* 14 */   PAGE_REDIRECT(3, "页面跳转");
/*    */ 
/*    */   private int code;
/*    */   private String desc;
/*    */ 
/* 21 */   public int getCode() { return this.code; }
/*    */ 
/*    */   public void setCode(int code)
/*    */   {
/* 25 */     this.code = code;
/*    */   }
/*    */ 
/*    */   public String getDesc() {
/* 29 */     return this.desc;
/*    */   }
/*    */ 
/*    */   public void setDesc(String desc) {
/* 33 */     this.desc = desc;
/*    */   }
/*    */ 
/*    */   private EnumSubSystemOpenType(int code, String desc) {
/* 37 */     this.code = code;
/* 38 */     this.desc = desc;
/*    */   }
/*    */ 
/*    */   public static Map<Integer, String> toMap() {
/* 42 */     Map map = new HashMap();
/* 43 */     for (EnumSubSystemOpenType item : values()) {
/* 44 */       map.put(Integer.valueOf(item.getCode()), item.getDesc());
/*    */     }
/* 46 */     return map;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.enums.EnumSubSystemOpenType
 * JD-Core Version:    0.6.0
 */