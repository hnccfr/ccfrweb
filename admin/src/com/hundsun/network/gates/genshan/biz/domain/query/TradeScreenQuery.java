/*    */ package com.hundsun.network.gates.genshan.biz.domain.query;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.page.Pagination;
/*    */ 
/*    */ public class TradeScreenQuery<TradeScreen> extends Pagination<TradeScreen>
/*    */ {
/*    */   private static final long serialVersionUID = -7665245857269297568L;
/*    */   private String name;
/*    */   private Long substationId;
/*    */ 
/*    */   public String getName()
/*    */   {
/* 24 */     return this.name;
/*    */   }
/*    */ 
/*    */   public void setName(String name) {
/* 28 */     this.name = name;
/*    */   }
/*    */ 
/*    */   public Long getSubstationId() {
/* 32 */     return this.substationId;
/*    */   }
/*    */ 
/*    */   public void setSubstationId(Long substationId) {
/* 36 */     this.substationId = substationId;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.query.TradeScreenQuery
 * JD-Core Version:    0.6.0
 */