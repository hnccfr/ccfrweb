/*     */ package com.hundsun.network.gates.wulin.biz.factory;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumActiveStatus;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumSystemDictKey;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeOrderCcType;
/*     */ import com.hundsun.network.gates.luosi.common.enums.EnumTradeOrderStatus;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.baseset.SystemDict;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.query.TradeOrderQueryAddition;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;
/*     */ 
/*     */ public class TradeOrderQueryFactory
/*     */ {
/*  20 */   private static Log log = LogFactory.getLog(TradeOrderQueryFactory.class);
/*     */ 
/*     */   public static TradeOrderQueryAddition getTradeOrderQuery(EnumSystemDictKey key, SystemDict dict)
/*     */   {
/*  30 */     if (null == key) {
/*  31 */       return null;
/*     */     }
/*  33 */     TradeOrderQueryAddition query = new TradeOrderQueryAddition();
/*  34 */     query.setKey(key);
/*     */ 
/*  36 */     if (EnumSystemDictKey.COMFIM_REMIND_DAYS.equals(key)) {
/*  37 */       query.setHasConfirm(EnumActiveStatus.No);
/*  38 */       query.setStatus(EnumTradeOrderStatus.WAIT_PAYCONFIRM);
/*  39 */       query.setIsRemindBuyer(Boolean.valueOf(true));
/*  40 */       query.setIsRemindSeller(Boolean.valueOf(true));
/*  41 */       query.setTitle("trade.order.auto.option.remind.unconfirm.title");
/*  42 */       query.setContent("trade.order.auto.option.remind.unconfirm.content");
/*     */       try {
/*  44 */         query.setInterval(Long.valueOf(dict.getParaValue()));
/*     */       } catch (Exception e) {
/*  46 */         log.error("TradeOrderQueryFactory getTradeOrderQuery error:", e);
/*  47 */         return null;
/*     */       }
/*  49 */       return query;
/*     */     }
/*  51 */     if (EnumSystemDictKey.CONFIM_ORDER_DAYS.equals(key)) {
/*  52 */       query.setHasConfirm(EnumActiveStatus.Yes);
/*  53 */       query.setStatus(EnumTradeOrderStatus.WAIT_PAYCONFIRM);
/*  54 */       query.setIsRemindBuyer(Boolean.valueOf(true));
/*  55 */       query.setCcBuyerType(EnumTradeOrderCcType.DEFAULT_PLACE_UNCHECK);
/*  56 */       query.setIsRemindSeller(Boolean.valueOf(true));
/*  57 */       query.setCcSellerType(EnumTradeOrderCcType.DEFAULT_LIST_UNCHECK);
/*  58 */       return query;
/*     */     }
/*     */ 
/*  61 */     if (EnumSystemDictKey.UNPAY_REMIND_DAYS.equals(key)) {
/*  62 */       query.setEndDatePayStatus(EnumActiveStatus.No);
/*  63 */       query.setStatus(EnumTradeOrderStatus.WAIT_PAYGOODS);
/*  64 */       query.setIsRemindBuyer(Boolean.valueOf(true));
/*  65 */       query.setTitle("trade.order.auto.option.remind.unpay.title");
/*  66 */       query.setContent("trade.order.auto.option.remind.unpay.content");
/*     */       try {
/*  68 */         query.setInterval(Long.valueOf(dict.getParaValue()));
/*     */       } catch (Exception e) {
/*  70 */         log.error("TradeOrderQueryFactory getTradeOrderQuery error:", e);
/*  71 */         return null;
/*     */       }
/*  73 */       return query;
/*     */     }
/*  75 */     if (EnumSystemDictKey.UNPAY_GENORDER_DAYS.equals(key)) {
/*  76 */       query.setEndDatePayStatus(EnumActiveStatus.Yes);
/*  77 */       query.setStatus(EnumTradeOrderStatus.WAIT_PAYGOODS);
/*  78 */       query.setIsRemindBuyer(Boolean.valueOf(true));
/*  79 */       query.setCcBuyerType(EnumTradeOrderCcType.DEFAULT_BUYER_UNPAY);
/*  80 */       query.setCcSellerType(EnumTradeOrderCcType.DEFAULT_BUYER_UNPAY);
/*  81 */       return query;
/*     */     }
/*     */ 
/*  84 */     if (EnumSystemDictKey.UNDELIVERY_REMIND_DAYS.equals(key)) {
/*  85 */       query.setEndDateSendGoodsStatus(EnumActiveStatus.No);
/*  86 */       query.setStatus(EnumTradeOrderStatus.WAIT_SENDGOODS);
/*  87 */       query.setIsRemindSeller(Boolean.valueOf(true));
/*  88 */       query.setTitle("trade.order.auto.option.remind.unsend.title");
/*  89 */       query.setContent("trade.order.auto.option.remind.unsend.content");
/*     */       try {
/*  91 */         query.setInterval(Long.valueOf(dict.getParaValue()));
/*     */       } catch (Exception e) {
/*  93 */         log.error("TradeOrderQueryFactory getTradeOrderQuery error:", e);
/*  94 */         return null;
/*     */       }
/*  96 */       return query;
/*     */     }
/*  98 */     if (EnumSystemDictKey.UNDELIVERY_GENORDER_DAYS.equals(key)) {
/*  99 */       query.setEndDateSendGoodsStatus(EnumActiveStatus.Yes);
/* 100 */       query.setStatus(EnumTradeOrderStatus.WAIT_SENDGOODS);
/* 101 */       query.setCcSellerType(EnumTradeOrderCcType.DEFAULT_SELLER_UNDELIVER);
/* 102 */       query.setCcBuyerType(EnumTradeOrderCcType.DEFAULT_SELLER_UNDELIVER);
/* 103 */       query.setIsRemindSeller(Boolean.valueOf(true));
/* 104 */       return query;
/*     */     }
/*     */ 
/* 108 */     if (EnumSystemDictKey.ARRIVEDGOODS_REMIND_DAYS.equals(key)) {
/* 109 */       query.setEndDateGoodsStatus(EnumActiveStatus.No);
/* 110 */       query.setStatus(EnumTradeOrderStatus.WAIT_CHECKGOODS);
/* 111 */       query.setIsRemindBuyer(Boolean.valueOf(true));
/* 112 */       query.setTitle("trade.order.auto.option.remind.unconfimgood.title");
/* 113 */       query.setContent("trade.order.auto.option.remind.unconfimgood.content");
/*     */       try {
/* 115 */         query.setInterval(Long.valueOf(dict.getParaValue()));
/*     */       } catch (Exception e) {
/* 117 */         log.error("TradeOrderQueryFactory getTradeOrderQuery error:", e);
/* 118 */         return null;
/*     */       }
/* 120 */       return query;
/*     */     }
/* 122 */     if (EnumSystemDictKey.ARRIVEDGOODS_GENORDER_DAYS.equals(key)) {
/* 123 */       query.setEndDateGoodsStatus(EnumActiveStatus.Yes);
/* 124 */       query.setStatus(EnumTradeOrderStatus.WAIT_CHECKGOODS);
/* 125 */       query.setCcBuyerType(EnumTradeOrderCcType.DEFAULT_BUYER_UNCHECK_GOODS_ARRIVAL);
/* 126 */       query.setCcSellerType(EnumTradeOrderCcType.DEFAULT_BUYER_UNCHECK_GOODS_ARRIVAL);
/* 127 */       query.setIsRemindBuyer(Boolean.valueOf(true));
/* 128 */       return query;
/*     */     }
/*     */ 
/* 131 */     if (EnumSystemDictKey.ARRIVEDTICKET_REMIND_DAYS.equals(key)) {
/* 132 */       query.setEndDateBillStatus(EnumActiveStatus.No);
/* 133 */       query.setStatus(EnumTradeOrderStatus.WAIT_CHECKTICKET);
/* 134 */       query.setIsRemindBuyer(Boolean.valueOf(true));
/* 135 */       query.setTitle("trade.order.auto.option.remind.unconfimticket.title");
/* 136 */       query.setContent("trade.order.auto.option.remind.unconfimticket.content");
/*     */       try {
/* 138 */         query.setInterval(Long.valueOf(dict.getParaValue()));
/*     */       } catch (Exception e) {
/* 140 */         log.error("TradeOrderQueryFactory getTradeOrderQuery error:", e);
/* 141 */         return null;
/*     */       }
/* 143 */       return query;
/*     */     }
/* 145 */     if (EnumSystemDictKey.ARRIVEDTICKET_GENORDER_DAYS.equals(key)) {
/* 146 */       query.setEndDateBillStatus(EnumActiveStatus.Yes);
/* 147 */       query.setStatus(EnumTradeOrderStatus.WAIT_CHECKTICKET);
/* 148 */       query.setCcBuyerType(EnumTradeOrderCcType.DEFAULT_BUYER_UNCHECK_RECEIPT_ARRIVAL);
/* 149 */       query.setCcSellerType(EnumTradeOrderCcType.DEFAULT_BUYER_UNCHECK_RECEIPT_ARRIVAL);
/* 150 */       query.setIsRemindBuyer(Boolean.valueOf(true));
/* 151 */       return query;
/*     */     }
/*     */ 
/* 154 */     if (EnumSystemDictKey.ARRIVED_UNCOMMENT_DAYS.equals(key)) {
/* 155 */       query.setStatus(EnumTradeOrderStatus.FINISHED);
/* 156 */       query.setHasRank(EnumActiveStatus.No);
/*     */       try {
/* 158 */         query.setInterval(Long.valueOf(dict.getParaValue()));
/*     */       } catch (Exception e) {
/* 160 */         log.error("TradeOrderQueryFactory getTradeOrderQuery error:", e);
/* 161 */         return null;
/*     */       }
/* 163 */       return query;
/*     */     }
/*     */ 
/* 166 */     return null;
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.factory.TradeOrderQueryFactory
 * JD-Core Version:    0.6.0
 */