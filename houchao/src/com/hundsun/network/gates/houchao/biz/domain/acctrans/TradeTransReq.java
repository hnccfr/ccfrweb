/*    */ package com.hundsun.network.gates.houchao.biz.domain.acctrans;
/*    */ 
/*    */ public class TradeTransReq extends TransReq
/*    */ {
/*    */   private static final long serialVersionUID = 747941048824720997L;
/*    */   private String orderProperty;
/*    */   private String transDirection;
/*    */ 
/*    */   public String getOrderProperty()
/*    */   {
/* 29 */     return this.orderProperty;
/*    */   }
/*    */   public void setOrderProperty(String orderProperty) {
/* 32 */     this.orderProperty = orderProperty;
/*    */   }
/*    */   public String getTransDirection() {
/* 35 */     return this.transDirection;
/*    */   }
/*    */   public void setTransDirection(String transDirection) {
/* 38 */     this.transDirection = transDirection;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\houchao\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.houchao.biz.domain.acctrans.TradeTransReq
 * JD-Core Version:    0.6.0
 */