/*    */ package com.hundsun.network.gates.genshan.biz.service.pojo.trade;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.trade.TradeSubstationDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.query.TradeSubstationQuery;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.trade.TradeSubstation;
/*    */ import com.hundsun.network.gates.genshan.biz.service.BaseService;
/*    */ import com.hundsun.network.gates.genshan.biz.service.trade.TradeSubstationService;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("tradeSubstationService")
/*    */ public class TradeSubstationServiceImpl extends BaseService
/*    */   implements TradeSubstationService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private TradeSubstationDAO tradeSubstationDAO;
/*    */ 
/*    */   public void getTradeSubstationList(TradeSubstationQuery query)
/*    */   {
/* 20 */     this.tradeSubstationDAO.selectByQuery(query);
/*    */   }
/*    */ 
/*    */   public TradeSubstation getTradeSubstationById(Long id)
/*    */   {
/* 25 */     return this.tradeSubstationDAO.getTradeSubstationById(id);
/*    */   }
/*    */ 
/*    */   public Integer insert(TradeSubstation tradeSubstation)
/*    */   {
/* 30 */     return this.tradeSubstationDAO.insert(tradeSubstation);
/*    */   }
/*    */ 
/*    */   public Integer update(TradeSubstation tradeSubstation)
/*    */   {
/* 35 */     return Integer.valueOf(this.tradeSubstationDAO.updateById(tradeSubstation));
/*    */   }
/*    */ 
/*    */   public Integer delete(Long id)
/*    */   {
/* 40 */     return Integer.valueOf(this.tradeSubstationDAO.deleteById(id));
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.service.pojo.trade.TradeSubstationServiceImpl
 * JD-Core Version:    0.6.0
 */