/*    */ package com.hundsun.eclp.enums;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public enum EnumEducation
/*    */ {
/*  7 */   PRIMARY_SCHOOL("1", "小学"), JUNIOR_SCHOOL("2", "初中"), 
/*  8 */   HIGH_SCHOOL("3", "高中"), SECONDARY_SCHOOL("4", "中专"), COLLEGE_SCHOOL("5", "大专"), 
/*  9 */   UNDERGRADUATE_SCHOOL("6", "本科"), GRADUATE_SCHOOL("7", "研究生"), 
/* 10 */   DOCTOR_SCHOOL("8", "博士生");
/*    */ 
/*    */   private String code;
/*    */   private String msg;
/*    */ 
/* 13 */   private EnumEducation(String code, String msg) { this.code = code;
/* 14 */     this.msg = msg;
/*    */   }
/*    */ 
/*    */   public String getCode()
/*    */   {
/* 21 */     return this.code;
/*    */   }
/*    */ 
/*    */   public void setCode(String code) {
/* 25 */     this.code = code;
/*    */   }
/*    */ 
/*    */   public String getMsg() {
/* 29 */     return this.msg;
/*    */   }
/*    */ 
/*    */   public void setMsg(String msg) {
/* 33 */     this.msg = msg;
/*    */   }
/*    */ 
/*    */   public static Map<String, String> toMap() {
/* 37 */     Map enumDataMap = new HashMap();
/* 38 */     for (EnumUsersType e : EnumUsersType.values()) {
/* 39 */       enumDataMap.put(e.getCode().toString(), e.getMsg());
/*    */     }
/* 41 */     return enumDataMap;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.enums.EnumEducation
 * JD-Core Version:    0.6.0
 */