/*    */ package com.hundsun.eclp.enums;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public enum EnumRegionType
/*    */ {
/* 19 */   NATION("0", "国家"), 
/* 20 */   PROVINCE("1", "省份/直辖市"), 
/* 21 */   CITY("2", "市"), 
/* 22 */   DISTRICT("3", "县/区");
/*    */ 
/*    */   private String code;
/*    */   private String name;
/*    */ 
/* 28 */   private EnumRegionType(String code, String name) { this.code = code;
/* 29 */     this.name = name; }
/*    */ 
/*    */   public String getCode()
/*    */   {
/* 33 */     return this.code;
/*    */   }
/*    */ 
/*    */   public void setCode(String code) {
/* 37 */     this.code = code;
/*    */   }
/*    */ 
/*    */   public String getName() {
/* 41 */     return this.name;
/*    */   }
/*    */ 
/*    */   public void setName(String name) {
/* 45 */     this.name = name;
/*    */   }
/*    */ 
/*    */   public static Map<String, String> toMap() {
/* 49 */     Map enumDataMap = new HashMap();
/* 50 */     for (EnumRegionType type : values()) {
/* 51 */       enumDataMap.put(type.getCode(), type.getName());
/*    */     }
/* 53 */     return enumDataMap;
/*    */   }
/*    */ 
/*    */   public static EnumRegionType getEnumByCode(String regionType)
/*    */   {
/* 62 */     for (EnumRegionType type : values()) {
/* 63 */       if (type.getCode().equals(regionType)) {
/* 64 */         return type;
/*    */       }
/*    */     }
/* 67 */     return null;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.enums.EnumRegionType
 * JD-Core Version:    0.6.0
 */