/*    */ package com.hundsun.network.gates.fengshan.biz.dao.ibatis.trade;
/*    */ 
/*    */ import com.hundsun.network.gates.fengshan.biz.dao.trade.TradeWishOrderDAO;
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.query.TradeWishOrderQuery;
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.trade.TradeWishOrder;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import java.util.Map;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("tradeWishOrderDAO")
/*    */ public class TradeWishOrderDAOImpl extends BaseDAO
/*    */   implements TradeWishOrderDAO
/*    */ {
/*    */   public int deleteByPrimaryKey(Long id)
/*    */   {
/* 19 */     TradeWishOrder _key = new TradeWishOrder();
/* 20 */     _key.setId(id);
/* 21 */     int rows = getSqlMapClientTemplate().delete("TRADE_WISH_ORDER.deleteByPrimaryKey", _key);
/* 22 */     return rows;
/*    */   }
/*    */ 
/*    */   public Long insert(TradeWishOrder record) {
/* 26 */     return (Long)getSqlMapClientTemplate().insert("TRADE_WISH_ORDER.insert", record);
/*    */   }
/*    */ 
/*    */   public void insertSelective(TradeWishOrder record) {
/* 30 */     getSqlMapClientTemplate().insert("TRADE_WISH_ORDER.insertSelective", record);
/*    */   }
/*    */ 
/*    */   public TradeWishOrder selectByPrimaryKey(Long id) {
/* 34 */     TradeWishOrder _key = new TradeWishOrder();
/* 35 */     _key.setId(id);
/* 36 */     TradeWishOrder record = (TradeWishOrder)getSqlMapClientTemplate().queryForObject("TRADE_WISH_ORDER.selectByPrimaryKey", _key);
/* 37 */     return record;
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKeySelective(TradeWishOrder record) {
/* 41 */     int rows = getSqlMapClientTemplate().update("TRADE_WISH_ORDER.updateByPrimaryKeySelective", record);
/* 42 */     return rows;
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKey(TradeWishOrder record) {
/* 46 */     int rows = getSqlMapClientTemplate().update("TRADE_WISH_ORDER.updateByPrimaryKey", record);
/* 47 */     return rows;
/*    */   }
/*    */ 
/*    */   public void selectByQuery(TradeWishOrderQuery query)
/*    */   {
/* 52 */     paginate(query, "TRADE_WISH_ORDER.queryTradeWishOrderCount", "TRADE_WISH_ORDER.queryTradeWishOrder");
/*    */   }
/*    */ 
/*    */   public TradeWishOrder selectByOrderNum(String orderNum)
/*    */   {
/* 57 */     return (TradeWishOrder)getSqlMapClientTemplate().queryForObject("TRADE_WISH_ORDER.selectByOrderNum", orderNum);
/*    */   }
/*    */ 
/*    */   public String selectWishOrderNo()
/*    */   {
/* 62 */     return (String)getSqlMapClientTemplate().queryForObject("TRADE_WISH_ORDER.generalWishOrderNo");
/*    */   }
/*    */ 
/*    */   public int updateStatusByOrderNum(TradeWishOrder tradeWishOrder)
/*    */   {
/* 67 */     return Integer.valueOf(getSqlMapClientTemplate().update("TRADE_WISH_ORDER.updateTradeWishOrderStatus", tradeWishOrder)).intValue();
/*    */   }
/*    */ 
/*    */   public int selectCountOfOne(TradeWishOrder tradeWishOrder)
/*    */   {
/* 72 */     return ((Integer)getSqlMapClientTemplate().queryForObject("TRADE_WISH_ORDER.selectCountOfSomeBody", tradeWishOrder)).intValue();
/*    */   }
/*    */ 
/*    */   public int existsWishOrderBidBuyer(Map paramMap)
/*    */   {
/* 83 */     return ((Integer)getSqlMapClientTemplate().queryForObject("TRADE_WISH_ORDER.existsWishOrderBidBuyer", paramMap)).intValue();
/*    */   }
/*    */ 
/*    */   public Integer getNumByQuery(TradeWishOrderQuery query)
/*    */   {
/* 93 */     return (Integer)getSqlMapClientTemplate().queryForObject("TRADE_WISH_ORDER.queryTradeWishOrderCount", query);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.dao.ibatis.trade.TradeWishOrderDAOImpl
 * JD-Core Version:    0.6.0
 */