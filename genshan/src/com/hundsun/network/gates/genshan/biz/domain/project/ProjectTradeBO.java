/*    */ package com.hundsun.network.gates.genshan.biz.domain.project;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.domain.BaseDomain;
/*    */ import com.hundsun.network.gates.luosi.biz.domain.TradeShowDTO;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class ProjectTradeBO extends BaseDomain
/*    */ {
/*    */   private static final long serialVersionUID = 8613597988538753972L;
/* 15 */   public List<TradeShowDTO> tradeMetas = new ArrayList();
/*    */ 
/*    */   public List<TradeShowDTO> getTradeMetas() {
/* 18 */     return this.tradeMetas;
/*    */   }
/*    */ 
/*    */   public void setTradeMetas(List<TradeShowDTO> tradeMetas) {
/* 22 */     this.tradeMetas = tradeMetas;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.domain.project.ProjectTradeBO
 * JD-Core Version:    0.6.0
 */