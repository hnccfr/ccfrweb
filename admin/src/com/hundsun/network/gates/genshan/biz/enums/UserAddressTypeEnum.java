/*    */ package com.hundsun.network.gates.genshan.biz.enums;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public enum UserAddressTypeEnum
/*    */ {
/*  7 */   Personal("P", "收货地址"), 
/*  8 */   Storehouse("S", "仓库地址");
/*    */ 
/*    */   private String value;
/*    */   private String name;
/*    */   private static Map<String, UserAddressTypeEnum> pool;
/*    */ 
/*    */   public static UserAddressTypeEnum indexByValue(String value)
/*    */   {
/* 30 */     return (UserAddressTypeEnum)pool.get(value);
/*    */   }
/*    */ 
/*    */   private UserAddressTypeEnum(String value, String name) {
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
/* 19 */     for (UserAddressTypeEnum et : values())
/* 20 */       pool.put(et.value, et);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.enums.UserAddressTypeEnum
 * JD-Core Version:    0.6.0
 */