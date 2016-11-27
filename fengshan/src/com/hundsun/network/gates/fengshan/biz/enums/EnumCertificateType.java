/*    */ package com.hundsun.network.gates.fengshan.biz.enums;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public enum EnumCertificateType
/*    */ {
/*  8 */   IDENTIFY("I", "身份证"), PASSPORT("P", "护照"), LICENCE("L", "营业执照");
/*    */ 
/*    */   private String value;
/*    */   private String name;
/*    */   private static Map<String, EnumCertificateType> pool;
/*    */ 
/*    */   public static EnumCertificateType indexByValue(String value)
/*    */   {
/* 30 */     return (EnumCertificateType)pool.get(value);
/*    */   }
/*    */ 
/*    */   private EnumCertificateType(String value, String name) {
/* 34 */     this.value = value;
/* 35 */     this.name = name;
/*    */   }
/*    */ 
/*    */   public String getValue() {
/* 39 */     return this.value;
/*    */   }
/*    */ 
/*    */   public void setValue(String value) {
/* 43 */     this.value = value;
/*    */   }
/*    */ 
/*    */   public String getName() {
/* 47 */     return this.name;
/*    */   }
/*    */ 
/*    */   public void setName(String name) {
/* 51 */     this.name = name;
/*    */   }
/*    */ 
/*    */   static
/*    */   {
/* 17 */     pool = new HashMap();
/*    */ 
/* 19 */     for (EnumCertificateType et : values())
/* 20 */       pool.put(et.value, et);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.enums.EnumCertificateType
 * JD-Core Version:    0.6.0
 */