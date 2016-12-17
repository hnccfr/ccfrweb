/*    */ package com.hundsun.network.gates.genshan.biz.enums;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public enum EnumAuditWishOrder
/*    */ {
/*  8 */   SUCCESS("success", "成功"), 
/*  9 */   ERROR1("error1", "更新审核信息失败"), 
/* 10 */   ERROR2("error2", "更新意向单信息失败"), 
/* 11 */   ERROR3("error3", "审核发生异常"), 
/* 12 */   ERROR4("error4", "更新有效竞价人表错误"), 
/* 13 */   ERROR5("error5", "您输入的牌号已存在，请重试"), 
/* 14 */   ERROR6("error6", "更新大厅中有效竞价人数量失败"), 
/* 15 */   ERROR7("error7", "插入初始化自由报价记录失败"), 
/* 16 */   ERROR8("error8", "当前意向单不是待审核状态");
/*    */ 
/*    */   private String value;
/*    */   private String name;
/*    */   private static Map<String, EnumAuditWishOrder> pool;
/*    */ 
/*    */   public static EnumAuditWishOrder indexByValue(String value)
/*    */   {
/* 38 */     return (EnumAuditWishOrder)pool.get(value);
/*    */   }
/*    */ 
/*    */   private EnumAuditWishOrder(String value, String name) {
/* 42 */     this.value = value;
/* 43 */     this.name = name;
/*    */   }
/*    */ 
/*    */   public String getValue() {
/* 47 */     return this.value;
/*    */   }
/*    */ 
/*    */   public void setValue(String value) {
/* 51 */     this.value = value;
/*    */   }
/*    */ 
/*    */   public String getName() {
/* 55 */     return this.name;
/*    */   }
/*    */ 
/*    */   public void setName(String name) {
/* 59 */     this.name = name;
/*    */   }
/*    */ 
/*    */   static
/*    */   {
/* 25 */     pool = new HashMap();
/*    */ 
/* 27 */     for (EnumAuditWishOrder et : values())
/* 28 */       pool.put(et.value, et);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.enums.EnumAuditWishOrder
 * JD-Core Version:    0.6.0
 */