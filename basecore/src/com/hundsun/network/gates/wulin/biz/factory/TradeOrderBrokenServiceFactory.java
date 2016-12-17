/*    */ package com.hundsun.network.gates.wulin.biz.factory;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.enums.EnumActiveStatus;
/*    */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeOrderStatus;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.order.TradeOrder;
/*    */ import com.hundsun.network.gates.wulin.biz.service.order.TradeOrderBrokenService;
/*    */ import com.hundsun.network.gates.wulin.biz.service.order.TradeOrderService;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Component;
/*    */ 
/*    */ @Component("tradeOrderBrokenServiceFactory")
/*    */ public class TradeOrderBrokenServiceFactory
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private TradeOrderBrokenService tradeOrderBrokenUnkonwService;
/*    */ 
/*    */   @Autowired
/*    */   private TradeOrderBrokenService tradeOrderBrokenTradeService;
/*    */ 
/*    */   @Autowired
/*    */   private TradeOrderBrokenService tradeOrderBrokenSellerTradeService;
/*    */ 
/*    */   @Autowired
/*    */   private TradeOrderBrokenService tradeOrderBrokenBuyerTradeService;
/*    */ 
/*    */   @Autowired
/*    */   private TradeOrderBrokenService tradeOrderBrokenSellerDeliveryService;
/*    */ 
/*    */   @Autowired
/*    */   private TradeOrderBrokenService tradeOrderBrokenBuyerDeliveryService;
/*    */ 
/*    */   @Autowired
/*    */   private TradeOrderService tradeOrderService;
/*    */ 
/*    */   public TradeOrderBrokenService getBrokenService(String orderNo)
/*    */   {
/* 37 */     TradeOrder order = this.tradeOrderService.selectByOrderNo(orderNo);
/* 38 */     return getBrokenService(order);
/*    */   }
/*    */ 
/*    */   public TradeOrderBrokenService getBrokenService(TradeOrder order) {
/* 42 */     if (null == order) {
/* 43 */       return null;
/*    */     }
/* 45 */     if (EnumTradeOrderStatus.WAIT_PAYCONFIRM.getValue().equals(order.getStatus())) {
/* 46 */       if ((EnumActiveStatus.No.getValue().equals(order.getHasBuyerConfirm())) && (EnumActiveStatus.No.getValue().equals(order.getHasSellerConfirm())))
/*    */       {
/* 48 */         return this.tradeOrderBrokenTradeService;
/* 49 */       }if (EnumActiveStatus.No.getValue().equals(order.getHasBuyerConfirm()))
/* 50 */         return this.tradeOrderBrokenBuyerTradeService;
/* 51 */       if (EnumActiveStatus.No.getValue().equals(order.getHasSellerConfirm())) {
/* 52 */         return this.tradeOrderBrokenSellerTradeService;
/*    */       }
/*    */     }
/* 55 */     if (EnumTradeOrderStatus.WAIT_PAYGOODS.getValue().equals(order.getStatus())) {
/* 56 */       return this.tradeOrderBrokenBuyerDeliveryService;
/*    */     }
/* 58 */     if (EnumTradeOrderStatus.WAIT_SENDGOODS.getValue().equals(order.getStatus())) {
/* 59 */       return this.tradeOrderBrokenSellerDeliveryService;
/*    */     }
/* 61 */     return this.tradeOrderBrokenUnkonwService;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.factory.TradeOrderBrokenServiceFactory
 * JD-Core Version:    0.6.0
 */