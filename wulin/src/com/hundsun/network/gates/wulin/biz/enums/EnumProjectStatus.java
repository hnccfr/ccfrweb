/*    */ package com.hundsun.network.gates.wulin.biz.enums;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public enum EnumProjectStatus
/*    */ {
/* 13 */   CREATE("C", "创建中"), 
/* 14 */   AUDIT("A", "审核中"), 
/* 15 */   TRADE("T", "挂牌中"), 
/* 16 */   SUSPENSION("S", "停牌中"), 
/* 17 */   FAIL("F", "审核不通过"), 
/* 18 */   WITHDRAWAL("W", "已撤牌"), 
/* 19 */   OVER("O", "已结束");
/*    */ 
/*    */   private String value;
/*    */   private String name;
/*    */   private static Map<String, EnumProjectStatus> pool;
/*    */ 
/*    */   public static EnumProjectStatus indexByValue(String value)
/*    */   {
/* 42 */     return (EnumProjectStatus)pool.get(value);
/*    */   }
/*    */ 
/*    */   private EnumProjectStatus(String value, String name) {
/* 46 */     this.value = value;
/* 47 */     this.name = name;
/*    */   }
/*    */ 
/*    */   public String getValue() {
/* 51 */     return this.value;
/*    */   }
/*    */ 
/*    */   public String getName() {
/* 55 */     return this.name;
/*    */   }
/*    */ 
/*    */   static
/*    */   {
/* 29 */     pool = new HashMap();
/*    */ 
/* 31 */     for (EnumProjectStatus et : values())
/* 32 */       pool.put(et.value, et);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.enums.EnumProjectStatus
 * JD-Core Version:    0.6.0
 */