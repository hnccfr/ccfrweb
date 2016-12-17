/*    */ package com.hundsun.network.gates.genshan.biz.domain.query;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.domain.trade.TradeSubstation;
/*    */ import com.hundsun.network.gates.luosi.common.page.Pagination;
/*    */ 
/*    */ public class TradeSubstationQuery extends Pagination<TradeSubstation>
/*    */ {
/*    */   private static final long serialVersionUID = -5970756038881371542L;
/*    */   private Long id;
/*    */   private String name;
/*    */ 
/*    */   public Long getId()
/*    */   {
/* 25 */     return this.id;
/*    */   }
/*    */ 
/*    */   public void setId(Long id) {
/* 29 */     this.id = id;
/*    */   }
/*    */ 
/*    */   public String getName() {
/* 33 */     return this.name;
/*    */   }
/*    */ 
/*    */   public void setName(String name) {
/* 37 */     this.name = name;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.query.TradeSubstationQuery
 * JD-Core Version:    0.6.0
 */