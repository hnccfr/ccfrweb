/*    */ package com.hundsun.network.gates.wulin.biz.domain.query;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public class TradeRefundQuery
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 4971612149785899005L;
/*    */   private Long id;
/*    */   private String orderNo;
/*    */   private String refundType;
/*    */ 
/*    */   public Long getId()
/*    */   {
/* 12 */     return this.id;
/*    */   }
/*    */   public void setId(Long id) {
/* 15 */     this.id = id;
/*    */   }
/*    */   public String getOrderNo() {
/* 18 */     return this.orderNo;
/*    */   }
/*    */   public void setOrderNo(String orderNo) {
/* 21 */     this.orderNo = orderNo;
/*    */   }
/*    */   public String getRefundType() {
/* 24 */     return this.refundType;
/*    */   }
/*    */   public void setRefundType(String refundType) {
/* 27 */     this.refundType = refundType;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.domain.query.TradeRefundQuery
 * JD-Core Version:    0.6.0
 */