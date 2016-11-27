/*    */ package com.hundsun.network.gates.taiping.biz.enums;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.enums.EnumAuctionLatestStatus;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public enum EnumAuctioneerCommondStatus
/*    */ {
/* 15 */   START("start", "拍卖开始", EnumAuctionLatestStatus.E), 
/* 16 */   AUCTION_ONE("auction_one", "唱价第一次", EnumAuctionLatestStatus.G1), 
/* 17 */   AUCTION_TWO("auction_two", "唱价第二次", EnumAuctionLatestStatus.G2), 
/* 18 */   AUCTION_THREE("auction_three", "唱价第三次", EnumAuctionLatestStatus.K), 
/* 19 */   PRIORITY_START("priority_start", "优先权阶段拍卖开始", EnumAuctionLatestStatus.L), 
/* 20 */   PRIORITY_AUCTION_ONE("priority_auction_one", "优先权阶段唱价第一次", EnumAuctionLatestStatus.M1), 
/* 21 */   PRIORITY_AUCTION_TWO("priority_auction_two", "优先权阶段唱价第二次", EnumAuctionLatestStatus.M2), 
/* 22 */   PRIORITY_AUCTION_THREE("priority_auction_three", "优先权阶段唱价第三次", EnumAuctionLatestStatus.P);
/*    */ 
/*    */   private String value;
/*    */   private String name;
/*    */   private EnumAuctionLatestStatus nextStatus;
/*    */   private static Map<String, EnumAuctioneerCommondStatus> pool;
/*    */ 
/*    */   public static EnumAuctioneerCommondStatus indexByValue(String value)
/*    */   {
/* 48 */     return (EnumAuctioneerCommondStatus)pool.get(value);
/*    */   }
/*    */ 
/*    */   private EnumAuctioneerCommondStatus(String value, String name, EnumAuctionLatestStatus nextStatus)
/*    */   {
/* 53 */     this.value = value;
/* 54 */     this.name = name;
/* 55 */     this.nextStatus = nextStatus;
/*    */   }
/*    */ 
/*    */   public String getValue() {
/* 59 */     return this.value;
/*    */   }
/*    */ 
/*    */   public String getName() {
/* 63 */     return this.name;
/*    */   }
/*    */ 
/*    */   public EnumAuctionLatestStatus getNextStatus() {
/* 67 */     return this.nextStatus;
/*    */   }
/*    */ 
/*    */   static
/*    */   {
/* 34 */     pool = new HashMap();
/*    */ 
/* 36 */     for (EnumAuctioneerCommondStatus et : values())
/* 37 */       pool.put(et.value, et);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.taiping.biz.enums.EnumAuctioneerCommondStatus
 * JD-Core Version:    0.6.0
 */