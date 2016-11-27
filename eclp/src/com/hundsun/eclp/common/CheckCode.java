/*    */ package com.hundsun.eclp.common;
/*    */ 
/*    */ import com.hundsun.network.melody.common.web.cookyjar.SelfDependence;
/*    */ import com.hundsun.network.melody.common.web.cookyjar.util.SelfUtil;
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public class CheckCode
/*    */   implements Serializable, SelfDependence
/*    */ {
/*    */   private static final long serialVersionUID = -148137655250497090L;
/*    */   private String registerCheckCode;
/*    */   private String loginCheckCode;
/*    */   private String feedbackCheckCode;
/*    */   private String priceCompTransactCheckCode;
/*    */   private String createTradeCheckCode;
/*    */ 
/*    */   public String getLoginCheckCode()
/*    */   {
/* 23 */     return this.loginCheckCode;
/*    */   }
/*    */ 
/*    */   public void setLoginCheckCode(String loginCheckCode) {
/* 27 */     this.loginCheckCode = loginCheckCode;
/*    */   }
/*    */ 
/*    */   public String getRegisterCheckCode() {
/* 31 */     return this.registerCheckCode;
/*    */   }
/*    */ 
/*    */   public void setRegisterCheckCode(String registerCheckCode) {
/* 35 */     this.registerCheckCode = registerCheckCode;
/*    */   }
/*    */ 
/*    */   public String getFeedbackCheckCode() {
/* 39 */     return this.feedbackCheckCode;
/*    */   }
/*    */ 
/*    */   public void setFeedbackCheckCode(String feedbackCheckCode) {
/* 43 */     this.feedbackCheckCode = feedbackCheckCode;
/*    */   }
/*    */ 
/*    */   public String getPriceCompTransactCheckCode() {
/* 47 */     return this.priceCompTransactCheckCode;
/*    */   }
/*    */ 
/*    */   public void setPriceCompTransactCheckCode(String priceCompTransactCheckCode) {
/* 51 */     this.priceCompTransactCheckCode = priceCompTransactCheckCode;
/*    */   }
/*    */ 
/*    */   public String getCreateTradeCheckCode() {
/* 55 */     return this.createTradeCheckCode;
/*    */   }
/*    */ 
/*    */   public void setCreateTradeCheckCode(String createTradeCheckCode) {
/* 59 */     this.createTradeCheckCode = createTradeCheckCode;
/*    */   }
/*    */ 
/*    */   public String lieDown() {
/* 63 */     return SelfUtil.format(new String[] { this.registerCheckCode, this.loginCheckCode, this.feedbackCheckCode, this.priceCompTransactCheckCode, this.createTradeCheckCode });
/*    */   }
/*    */ 
/*    */   public SelfDependence riseUp(String value) {
/* 67 */     String[] values = SelfUtil.recover(value);
/* 68 */     this.registerCheckCode = values[0];
/* 69 */     this.loginCheckCode = values[1];
/* 70 */     this.feedbackCheckCode = values[2];
/* 71 */     this.priceCompTransactCheckCode = values[3];
/* 72 */     this.createTradeCheckCode = values[4];
/* 73 */     return this;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.common.CheckCode
 * JD-Core Version:    0.6.0
 */