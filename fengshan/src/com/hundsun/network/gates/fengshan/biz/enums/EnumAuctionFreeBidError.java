/*    */ package com.hundsun.network.gates.fengshan.biz.enums;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public enum EnumAuctionFreeBidError
/*    */ {
/*  7 */   NONE_APPLY_ERROR(0, "尚未报名"), 
/*  8 */   TRADE_TYPE_ERROR(10, "交易方式非多次报价转拍卖"), 
/*  9 */   WISH_ORDER_STATUS_ERROR(20, "报名不处于交易状态"), 
/* 10 */   TIME_PASSED_ERROR(30, "自由报价阶段已结束"), 
/* 11 */   PROJECT_NULL_ERROR(40, "报价项目不存在"), 
/* 12 */   PROJECT_STATUS_ERROR(50, "报价对应项目不处于挂牌状态"), 
/* 13 */   BID_ERROR(800, "报价失败");
/*    */ 
/*    */   private int value;
/*    */   private String name;
/*    */   private static Map<Integer, EnumAuctionFreeBidError> pool;
/*    */ 
/* 21 */   private EnumAuctionFreeBidError(int value, String name) { this.value = value;
/* 22 */     this.name = name; }
/*    */ 
/*    */   public int getValue()
/*    */   {
/* 26 */     return this.value;
/*    */   }
/*    */ 
/*    */   public String getName() {
/* 30 */     return this.name;
/*    */   }
/*    */ 
/*    */   public static EnumAuctionFreeBidError indexByValue(Integer value)
/*    */   {
/* 49 */     return (EnumAuctionFreeBidError)pool.get(value);
/*    */   }
/*    */ 
/*    */   static
/*    */   {
/* 36 */     pool = new HashMap();
/*    */ 
/* 38 */     for (EnumAuctionFreeBidError et : values())
/* 39 */       pool.put(Integer.valueOf(et.value), et);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.enums.EnumAuctionFreeBidError
 * JD-Core Version:    0.6.0
 */