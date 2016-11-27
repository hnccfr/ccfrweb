/*    */ package com.hundsun.network.gates.fengshan.biz.enums;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public enum EnumDeliveryType
/*    */ {
/* 13 */   SELLERSEND("sellerSend", "卖家交割"), 
/* 14 */   BUYERSELF("buyerSelf", "买家自提");
/*    */ 
/*    */   private String value;
/*    */   private String name;
/*    */   private static Map<String, EnumDeliveryType> pool;
/*    */ 
/* 23 */   static { pool = new HashMap();
/*    */ 
/* 25 */     for (EnumDeliveryType et : values())
/* 26 */       pool.put(et.value, et);
/*    */   }
/*    */ 
/*    */   public static EnumDeliveryType indexByValue(String value)
/*    */   {
/* 36 */     return (EnumDeliveryType)pool.get(value);
/*    */   }
/*    */ 
/*    */   private EnumDeliveryType(String value, String name) {
/* 40 */     this.value = value;
/* 41 */     this.name = name;
/*    */   }
/*    */ 
/*    */   public String getValue() {
/* 45 */     return this.value;
/*    */   }
/*    */ 
/*    */   public String getName() {
/* 49 */     return this.name;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.enums.EnumDeliveryType
 * JD-Core Version:    0.6.0
 */