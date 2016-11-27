/*    */ package com.hundsun.eclp.enums;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public enum EnumUsersDegree
/*    */ {
/*  8 */   BACHELOR("1", "学士"), MASTER("2", "硕士"), 
/*  9 */   DOCTOR("3", "博士");
/*    */ 
/*    */   private String code;
/*    */   private String msg;
/*    */ 
/* 12 */   private EnumUsersDegree(String code, String msg) { this.code = code;
/* 13 */     this.msg = msg;
/*    */   }
/*    */ 
/*    */   public String getCode()
/*    */   {
/* 20 */     return this.code;
/*    */   }
/*    */ 
/*    */   public void setCode(String code) {
/* 24 */     this.code = code;
/*    */   }
/*    */ 
/*    */   public String getMsg() {
/* 28 */     return this.msg;
/*    */   }
/*    */ 
/*    */   public void setMsg(String msg) {
/* 32 */     this.msg = msg;
/*    */   }
/*    */ 
/*    */   public static Map<String, String> toMap() {
/* 36 */     Map enumDataMap = new HashMap();
/* 37 */     for (EnumUsersDegree e : values()) {
/* 38 */       enumDataMap.put(e.getCode().toString(), e.getMsg());
/*    */     }
/* 40 */     return enumDataMap;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.enums.EnumUsersDegree
 * JD-Core Version:    0.6.0
 */