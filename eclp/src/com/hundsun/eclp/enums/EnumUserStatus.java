/*    */ package com.hundsun.eclp.enums;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public enum EnumUserStatus
/*    */ {
/*  8 */   DELETE_STATUS((short)2, "删除"), 
/*  9 */   USE_STATUS((short)1, "启用"), 
/* 10 */   DISUSE_STATUS((short)0, "禁用");
/*    */ 
/*    */   private short code;
/*    */   private String desc;
/*    */ 
/* 17 */   public short getCode() { return this.code; }
/*    */ 
/*    */   public void setCode(short code)
/*    */   {
/* 21 */     this.code = code;
/*    */   }
/*    */ 
/*    */   public String getDesc() {
/* 25 */     return this.desc;
/*    */   }
/*    */ 
/*    */   public void setDesc(String desc) {
/* 29 */     this.desc = desc;
/*    */   }
/*    */ 
/*    */   private EnumUserStatus(short code, String desc) {
/* 33 */     this.code = code;
/* 34 */     this.desc = desc;
/*    */   }
/*    */ 
/*    */   public static Map<String, String> toMap() {
/* 38 */     Map enumDataMap = new HashMap();
/* 39 */     for (EnumUserStatus e : values()) {
/* 40 */       enumDataMap.put(String.valueOf(e.getCode()), e.getDesc());
/*    */     }
/* 42 */     return enumDataMap;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.enums.EnumUserStatus
 * JD-Core Version:    0.6.0
 */