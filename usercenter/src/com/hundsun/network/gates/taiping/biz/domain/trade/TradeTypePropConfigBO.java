/*    */ package com.hundsun.network.gates.taiping.biz.domain.trade;
/*    */ 
/*    */ import com.hundsun.network.gates.taiping.biz.domain.BaseDomain;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class TradeTypePropConfigBO extends BaseDomain
/*    */ {
/*    */   private static final long serialVersionUID = -6221185435064606315L;
/* 12 */   private List<TradeTypePropConfig> propMmetas = new ArrayList();
/*    */ 
/*    */   public List<TradeTypePropConfig> getPropMmetas() {
/* 15 */     return this.propMmetas;
/*    */   }
/*    */ 
/*    */   public void setPropMmetas(List<TradeTypePropConfig> propMmetas) {
/* 19 */     this.propMmetas = propMmetas;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.taiping.biz.domain.trade.TradeTypePropConfigBO
 * JD-Core Version:    0.6.0
 */