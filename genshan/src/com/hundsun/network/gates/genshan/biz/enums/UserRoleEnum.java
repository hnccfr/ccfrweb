/*    */ package com.hundsun.network.gates.genshan.biz.enums;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public enum UserRoleEnum
/*    */ {
/* 16 */   COMMON("common", "普通用户"), 
/* 17 */   MIDDLE("middle", "中级用户"), 
/* 18 */   HIGH("high", "高级用户"), 
/* 19 */   AUCTIONEER("auctioneer", "拍卖师"), 
/* 20 */   REVIEWER("reviewer", "评审员");
/*    */ 
/*    */   private String value;
/*    */   private String name;
/*    */   private static Map<String, UserRoleEnum> pool;
/*    */ 
/*    */   public static UserRoleEnum indexByValue(String value)
/*    */   {
/* 46 */     return (UserRoleEnum)pool.get(value);
/*    */   }
/*    */ 
/*    */   private UserRoleEnum(String value, String name) {
/* 50 */     this.value = value;
/* 51 */     this.name = name;
/*    */   }
/*    */   public String getValue() {
/* 54 */     return this.value;
/*    */   }
/*    */ 
/*    */   public void setValue(String value) {
/* 58 */     this.value = value;
/*    */   }
/*    */ 
/*    */   public String getName() {
/* 62 */     return this.name;
/*    */   }
/*    */ 
/*    */   public void setName(String name) {
/* 66 */     this.name = name;
/*    */   }
/*    */ 
/*    */   static
/*    */   {
/* 33 */     pool = new HashMap();
/*    */ 
/* 35 */     for (UserRoleEnum et : values())
/* 36 */       pool.put(et.value, et);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.enums.UserRoleEnum
 * JD-Core Version:    0.6.0
 */