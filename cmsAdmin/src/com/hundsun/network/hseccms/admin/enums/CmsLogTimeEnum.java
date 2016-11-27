/*    */ package com.hundsun.network.hseccms.admin.enums;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public enum CmsLogTimeEnum
/*    */ {
/* 17 */   ALL_LOG("0", "所有日志"), 
/* 18 */   WEEK_BEFORE("7", "一周前的日志"), 
/* 19 */   MONTH_BEFORE("30", "一月前的日志"), 
/* 20 */   QUARTER_BEFORE("90", "一季前的日志"), 
/* 21 */   YEAR_BEFORE("365", "一年前的日志");
/*    */ 
/*    */   private String code;
/*    */   private String desc;
/*    */ 
/* 24 */   private CmsLogTimeEnum(String code, String desc) { this.code = code;
/* 25 */     this.desc = desc;
/*    */   }
/*    */ 
/*    */   public static Map<String, String> toMap()
/*    */   {
/* 34 */     Map map = new HashMap();
/* 35 */     for (CmsLogTimeEnum item : values()) {
/* 36 */       map.put(item.getCode(), item.getDesc());
/*    */     }
/* 38 */     return map;
/*    */   }
/*    */ 
/*    */   public String getCode() {
/* 42 */     return this.code;
/*    */   }
/*    */   public void setCode(String code) {
/* 45 */     this.code = code;
/*    */   }
/*    */   public String getDesc() {
/* 48 */     return this.desc;
/*    */   }
/*    */   public void setDesc(String desc) {
/* 51 */     this.desc = desc;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy\cmsAdmin\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.admin.enums.CmsLogTimeEnum
 * JD-Core Version:    0.6.0
 */