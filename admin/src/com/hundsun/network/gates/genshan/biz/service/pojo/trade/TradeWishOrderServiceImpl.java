/*    */ package com.hundsun.network.gates.genshan.biz.service.pojo.trade;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.trade.TradeWishOrderDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.query.TradeWishOrderQuery;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.trade.TradeWishOrder;
/*    */ import com.hundsun.network.gates.genshan.biz.service.BaseService;
/*    */ import com.hundsun.network.gates.genshan.biz.service.trade.TradeWishOrderService;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("tradeWishOrderService")
/*    */ public class TradeWishOrderServiceImpl extends BaseService
/*    */   implements TradeWishOrderService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private TradeWishOrderDAO tradeWishOrderDAO;
/*    */ 
/*    */   public void getTradeWishOrderByQuery(TradeWishOrderQuery query)
/*    */   {
/* 22 */     if (null != query.getWishOrderNum()) {
/* 23 */       query.setWishOrderNum(query.getWishOrderNum().trim());
/*    */     }
/* 25 */     if (null != query.getProjectName()) {
/* 26 */       query.setProjectName(query.getProjectName().trim());
/*    */     }
/* 28 */     this.tradeWishOrderDAO.selectByQuery(query);
/*    */   }
/*    */ 
/*    */   public TradeWishOrder getTradeWishOrderByWishOrderNum(String orderNum)
/*    */   {
/* 33 */     return this.tradeWishOrderDAO.selectByWishOrderNum(orderNum);
/*    */   }
/*    */ 
/*    */   public int auditTradeWishOrder(TradeWishOrder tradeWishOrder)
/*    */   {
/* 38 */     return this.tradeWishOrderDAO.updateWishOrderInfo(tradeWishOrder);
/*    */   }
/*    */ 
/*    */   public List<String> getTradeMarkOfOneProject(TradeWishOrder tradeWishOrder)
/*    */   {
/* 43 */     return this.tradeWishOrderDAO.selectTradeMarkList(tradeWishOrder);
/*    */   }
/*    */ 
/*    */   public List<TradeWishOrder> getTradeWishOrderList(TradeWishOrder tradeWishOrder)
/*    */   {
/* 49 */     return this.tradeWishOrderDAO.getTradeWishOrderList(tradeWishOrder);
/*    */   }
/*    */ 
/*    */   public TradeWishOrder getTradeWishOrderById(Long wishOrderId)
/*    */   {
/* 54 */     return this.tradeWishOrderDAO.selectByPrimaryKey(wishOrderId);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.service.pojo.trade.TradeWishOrderServiceImpl
 * JD-Core Version:    0.6.0
 */