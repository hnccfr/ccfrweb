/*    */ package com.hundsun.eclp.enums;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ 
/*    */ public enum EnumFuncReCheckType
/*    */ {
/*  7 */   ASSIGN_ROLE("assignRole", "分配角色"), 
/*  8 */   ASSIGN_AUTH("assignAuth", "角色授权");
/*    */ 
/*    */   private String code;
/*    */   private String desc;
/*    */ 
/* 15 */   public String getCode() { return this.code; }
/*    */ 
/*    */   public void setCode(String code)
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
/*    */   private EnumFuncReCheckType(String code, String desc) {
/* 31 */     this.code = code;
/* 32 */     this.desc = desc;
/*    */   }
/*    */ 
/*    */   public static String getDesc(String code) {
/* 36 */     for (EnumFuncReCheckType item : values()) {
/* 37 */       if (item.getCode().equals(code)) {
/* 38 */         return item.getDesc();
/*    */       }
/*    */     }
/* 41 */     return "";
/*    */   }
/*    */   public static Map<Short, String> toMap() {
/* 44 */     Map map = new HashMap();
/* 45 */     for (EnumIsCore item : EnumIsCore.values()) {
/* 46 */       map.put(Short.valueOf(item.getCode()), item.getDesc());
/*    */     }
/* 48 */     return map;
/*    */   }
/*    */   public static List<EnumFuncReCheckType> toList() {
/* 51 */     List list = new ArrayList();
/* 52 */     for (EnumFuncReCheckType item : values()) {
/* 53 */       list.add(item);
/*    */     }
/* 55 */     return list;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.enums.EnumFuncReCheckType
 * JD-Core Version:    0.6.0
 */