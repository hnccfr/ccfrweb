/*    */ package com.hundsun.network.gates.qingbo.biz.domain.cash;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.remote.BaseTradeDTO;
/*    */ 
/*    */ public class TradeCashDTO extends BaseTradeDTO
/*    */ {
/*    */   private static final long serialVersionUID = -4627942200403740462L;
/*    */   private Long userId;
/*    */   private String userName;
/*    */ 
/*    */   public Long getUserId()
/*    */   {
/* 30 */     return this.userId;
/*    */   }
/*    */ 
/*    */   public void setUserId(Long userId) {
/* 34 */     this.userId = userId;
/*    */   }
/*    */ 
/*    */   public String getUserName() {
/* 38 */     return this.userName;
/*    */   }
/*    */ 
/*    */   public void setUserName(String userName) {
/* 42 */     this.userName = userName;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.qingbo.biz.domain.cash.TradeCashDTO
 * JD-Core Version:    0.6.0
 */