/*    */ package com.hundsun.eclp.biz.query;
/*    */ 
/*    */ import com.hundsun.network.common.query.QueryPage;
/*    */ import com.hundsun.network.melody.common.util.StringUtil;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class WorkLogQuery extends QueryPage
/*    */ {
/*    */   private static final long serialVersionUID = -6871710327130113437L;
/*    */   private String startDate;
/*    */   private String endDate;
/*    */   private String account;
/*    */   private String subSystemCode;
/*    */ 
/*    */   public String getStartDate()
/*    */   {
/* 25 */     return this.startDate;
/*    */   }
/*    */ 
/*    */   public void setStartDate(String startDate) {
/* 29 */     this.startDate = startDate;
/*    */   }
/*    */ 
/*    */   public String getEndDate() {
/* 33 */     return this.endDate;
/*    */   }
/*    */ 
/*    */   public void setEndDate(String endDate) {
/* 37 */     this.endDate = endDate;
/*    */   }
/*    */ 
/*    */   public String getAccount() {
/* 41 */     return this.account;
/*    */   }
/*    */ 
/*    */   public void setAccount(String account) {
/* 45 */     this.account = account;
/*    */   }
/*    */ 
/*    */   public Map<String, String> getParameters()
/*    */   {
/* 51 */     Map map = new HashMap();
/* 52 */     if (StringUtil.isNotBlank(this.startDate)) {
/* 53 */       map.put("startDate", this.startDate);
/*    */     }
/* 55 */     if (StringUtil.isNotBlank(this.endDate)) {
/* 56 */       map.put("endDate", this.endDate);
/*    */     }
/* 58 */     if (StringUtil.isNotBlank(this.account)) {
/* 59 */       map.put("account", this.account);
/*    */     }
/* 61 */     if (StringUtil.isNotBlank(this.subSystemCode)) {
/* 62 */       map.put("subSystemCode", this.subSystemCode);
/*    */     }
/* 64 */     return map;
/*    */   }
/*    */ 
/*    */   public String getSubSystemCode() {
/* 68 */     return this.subSystemCode;
/*    */   }
/*    */ 
/*    */   public void setSubSystemCode(String subSystemCode) {
/* 72 */     this.subSystemCode = subSystemCode;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.query.WorkLogQuery
 * JD-Core Version:    0.6.0
 */