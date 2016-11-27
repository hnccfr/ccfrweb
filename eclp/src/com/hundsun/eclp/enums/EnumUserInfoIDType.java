/*    */ package com.hundsun.eclp.enums;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public enum EnumUserInfoIDType
/*    */ {
/*  8 */   IDCARD((short)0, "居民身份证"), 
			DRIVE_LICENSE((short)1, "驾驶证"), 
			PASSPORT((short)2, "护照"), 
/*  9 */   MILITARY_ID((short)3, "军官证"), 
			OTHER((short)4, "其它");
/*    */ 
/*    */   private Short code;
/*    */   private String msg;
/*    */ 
/* 12 */   private EnumUserInfoIDType(Short code, String msg) { this.code = code;
/* 13 */     this.msg = msg;
/*    */   }
/*    */ 
/*    */   public Short getCode()
/*    */   {
/* 20 */     return this.code;
/*    */   }
/*    */ 
/*    */   public void setCode(Short code) {
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
/* 37 */     for (EnumUserInfoIDType e : values()) {
/* 38 */       enumDataMap.put(e.getCode().toString(), e.getMsg());
/*    */     }
/* 40 */     return enumDataMap;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.enums.EnumUserInfoIDType
 * JD-Core Version:    0.6.0
 */