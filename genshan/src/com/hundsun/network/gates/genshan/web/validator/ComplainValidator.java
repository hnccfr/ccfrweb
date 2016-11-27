/*    */ package com.hundsun.network.gates.genshan.web.validator;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.domain.order.TradeOrder;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.order.TradeOrderCc;
/*    */ import com.hundsun.network.gates.genshan.biz.service.order.TradeOrderCcService;
/*    */ import com.hundsun.network.gates.genshan.biz.service.order.TradeOrderService;
/*    */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeOrderCcDealType;
/*    */ import com.hundsun.network.gates.luosi.common.enums.EnumValuationUnit;
/*    */ import java.math.BigDecimal;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Component;
/*    */ import org.springframework.util.Assert;
/*    */ import org.springframework.validation.Errors;
/*    */ 
/*    */ @Component("complainValidator")
/*    */ public class ComplainValidator
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private TradeOrderCcService tradeOrderCcService;
/*    */ 
/*    */   @Autowired
/*    */   private TradeOrderService tradeOrderService;
/*    */ 
/*    */   public void validate(Object obj, Errors err)
/*    */   {
/* 26 */     Assert.notNull(obj);
/* 27 */     Assert.isInstanceOf(TradeOrderCc.class, obj);
/* 28 */     TradeOrderCc orderCc = (TradeOrderCc)obj;
/* 29 */     if ((null != orderCc.getReason()) && 
/* 30 */       (orderCc.getReason().length() > 340)) {
/* 31 */       err.rejectValue("reason", null, null, "备注的内容不要超过340个字");
/*    */     }
/*    */ 
/* 34 */     if ((EnumTradeOrderCcDealType.DEFAULT_SELLER_UNBILLING.getValue().equals(orderCc.getDealType())) || (EnumTradeOrderCcDealType.DEFAULT_SELLER_UNBILLING_PENALTY.getValue().equals(orderCc.getDealType())) || (EnumTradeOrderCcDealType.DEFAULT_SELLER_DOODS_ARIVAL_AMOUNT.getValue().equals(orderCc.getDealType())))
/*    */     {
/* 38 */       TradeOrderCc tradeOrderCc = this.tradeOrderCcService.getTradeOrderCcByNum(orderCc.getOrderCcNum());
/* 39 */       TradeOrder order = this.tradeOrderService.selectByOrderNo(tradeOrderCc.getOrderNo());
/*    */ 
/* 41 */       if ((null == orderCc.getDealMoney()) || ("".equals(orderCc.getDealMoney()))) {
/* 42 */         err.rejectValue("dealMoney", null, null, "输入金额为空");
/* 43 */         return;
/*    */       }
/*    */ 
/* 46 */       String unite = order.getValuationUnit();
/*    */ 
/* 48 */       Long balance = this.tradeOrderCcService.getOrderAmount(orderCc.getOrderCcNum());
/*    */ 
/* 50 */       if (EnumValuationUnit.YUAN.getValue().equals(unite)) {
/* 51 */         String regYuan1 = "^[1-9][0-9]{0,17}$";
/* 52 */         String regYuan2 = "^(0|[1-9]{0,18})\\.[0-9]{1,2}$";
/* 53 */         if ((!orderCc.getDealMoney().matches(regYuan1)) && (!orderCc.getDealMoney().matches(regYuan2))) {
/* 54 */           err.rejectValue("dealMoney", null, null, "输入金额不正确");
/* 55 */           return;
/*    */         }
/* 57 */       } else if (EnumValuationUnit.WANYUAN.getValue().equals(unite)) {
/* 58 */         String regYuan1 = "^[1-9][0-9]{0,17}$";
/* 59 */         String regYuan2 = "^(0|[1-9]{0,18})\\.[0-9]{1,6}$";
/* 60 */         if ((!orderCc.getDealMoney().matches(regYuan1)) && (!orderCc.getDealMoney().matches(regYuan2))) {
/* 61 */           err.rejectValue("dealMoney", null, null, "输入金额不正确");
/* 62 */           return;
/*    */         }
/* 64 */       } else if (EnumValuationUnit.YIYUAN.getValue().equals(unite)) {
/* 65 */         String regYuan1 = "^[1-9][0-9]{0,17}$";
/* 66 */         String regYuan2 = "^(0|[1-9]{0,18})\\.[0-9]{1,10}$";
/* 67 */         if ((!orderCc.getDealMoney().matches(regYuan1)) && (!orderCc.getDealMoney().matches(regYuan2))) {
/* 68 */           err.rejectValue("dealMoney", null, null, "输入金额不正确");
/* 69 */           return;
/*    */         }
/*    */       }
/*    */ 
/* 73 */       BigDecimal bg = new BigDecimal(orderCc.getDealMoney());
/* 74 */       Long money = Long.valueOf(bg.movePointRight(EnumValuationUnit.indexByValue(unite).getScale()).longValue());
/* 75 */       if ((money.longValue() <= 0L) || (money.longValue() > balance.longValue())) {
/* 76 */         err.rejectValue("dealMoney", null, null, "输入金额大小不正确");
/* 77 */         return;
/*    */       }
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.web.validator.ComplainValidator
 * JD-Core Version:    0.6.0
 */