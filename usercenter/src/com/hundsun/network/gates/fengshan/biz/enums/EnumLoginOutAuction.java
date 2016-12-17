/*    */ package com.hundsun.network.gates.fengshan.biz.enums;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public enum EnumLoginOutAuction
/*    */ {
/*  7 */   SUCCESS("success", "退出成功"), 
/*  8 */   CHANGE_STATUS_ERROR("change_status_error", "改变意向单状态失败"), 
/*  9 */   LATE_THAN_END("late_than_end", "超过了截止时间，不能退出"), 
/* 10 */   EXCEPTION("exception", "退出发生异常请重试或者联系管理员"), 
/* 11 */   CHANGE_BIDDER_STATUS_ERROR("change_bidder_status_error", "改变有效竞价人状态失败"), 
/* 12 */   NOT_HAS_FREE_AUCTION("not_has_free_auction", "未找到自由报价记录，请联系管理员"), 
/* 13 */   INSERT_FREE_AUCTION_ERROR("insert_free_auction_error", "插入作废报价错误");
/*    */ 
/*    */   private String value;
/*    */   private String name;
/*    */   private static Map<String, EnumLoginOutAuction> pool;
/*    */ 
/*    */   public static EnumLoginOutAuction indexByValue(String value)
/*    */   {
/* 35 */     return (EnumLoginOutAuction)pool.get(value);
/*    */   }
/*    */ 
/*    */   private EnumLoginOutAuction(String value, String name) {
/* 39 */     this.value = value;
/* 40 */     this.name = name;
/*    */   }
/*    */ 
/*    */   public String getValue() {
/* 44 */     return this.value;
/*    */   }
/*    */ 
/*    */   public String getName() {
/* 48 */     return this.name;
/*    */   }
/*    */ 
/*    */   static
/*    */   {
/* 22 */     pool = new HashMap();
/*    */ 
/* 24 */     for (EnumLoginOutAuction et : values())
/* 25 */       pool.put(et.value, et);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.enums.EnumLoginOutAuction
 * JD-Core Version:    0.6.0
 */