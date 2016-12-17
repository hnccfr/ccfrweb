/*    */ package com.hundsun.network.gates.genshan.biz.enums;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public enum CertificateTypeEnum
/*    */ {
/* 16 */   IDENTIFY("I", "身份证"), 
/* 17 */   PASSPORT("P", "护照"), 
/* 18 */   LICENCE("L", "营业执照");
/*    */ 
/*    */   private String value;
/*    */   private String name;
/*    */   private static Map<String, CertificateTypeEnum> pool;
/*    */ 
/*    */   public static CertificateTypeEnum indexByValue(String value)
/*    */   {
/* 44 */     return (CertificateTypeEnum)pool.get(value);
/*    */   }
/*    */ 
/*    */   private CertificateTypeEnum(String value, String name) {
/* 48 */     this.value = value;
/* 49 */     this.name = name;
/*    */   }
/*    */   public String getValue() {
/* 52 */     return this.value;
/*    */   }
/*    */ 
/*    */   public void setValue(String value) {
/* 56 */     this.value = value;
/*    */   }
/*    */ 
/*    */   public String getName() {
/* 60 */     return this.name;
/*    */   }
/*    */ 
/*    */   public void setName(String name) {
/* 64 */     this.name = name;
/*    */   }
/*    */ 
/*    */   static
/*    */   {
/* 31 */     pool = new HashMap();
/*    */ 
/* 33 */     for (CertificateTypeEnum et : values())
/* 34 */       pool.put(et.value, et);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.enums.CertificateTypeEnum
 * JD-Core Version:    0.6.0
 */