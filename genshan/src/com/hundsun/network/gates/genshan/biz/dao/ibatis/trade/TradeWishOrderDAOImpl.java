/*     */ package com.hundsun.network.gates.genshan.biz.dao.ibatis.trade;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.dao.trade.TradeWishOrderDAO;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.query.TradeWishOrderQuery;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.trade.TradeWishOrder;
/*     */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*     */ import java.util.List;
/*     */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*     */ import org.springframework.stereotype.Repository;
/*     */ 
/*     */ @Repository("tradeWishOrderDAO")
/*     */ public class TradeWishOrderDAOImpl extends BaseDAO
/*     */   implements TradeWishOrderDAO
/*     */ {
/*     */   public int deleteByPrimaryKey(Long id)
/*     */   {
/*  19 */     TradeWishOrder _key = new TradeWishOrder();
/*  20 */     _key.setId(id);
/*  21 */     int rows = getSqlMapClientTemplate().delete("TRADE_WISH_ORDER.deleteByPrimaryKey", _key);
/*  22 */     return rows;
/*     */   }
/*     */ 
/*     */   public void insert(TradeWishOrder record) {
/*  26 */     getSqlMapClientTemplate().insert("TRADE_WISH_ORDER.insert", record);
/*     */   }
/*     */ 
/*     */   public TradeWishOrder selectByPrimaryKey(Long id)
/*     */   {
/*  31 */     TradeWishOrder _key = new TradeWishOrder();
/*  32 */     _key.setId(id);
/*  33 */     TradeWishOrder record = (TradeWishOrder)getSqlMapClientTemplate().queryForObject("TRADE_WISH_ORDER.selectByPrimaryKey", _key);
/*  34 */     return record;
/*     */   }
/*     */ 
/*     */   public int updateByPrimaryKey(TradeWishOrder record)
/*     */   {
/*  39 */     int rows = getSqlMapClientTemplate().update("TRADE_WISH_ORDER.updateByPrimaryKey", record);
/*  40 */     return rows;
/*     */   }
/*     */ 
/*     */   public void selectByQuery(TradeWishOrderQuery query)
/*     */   {
/*  45 */     paginate(query, "TRADE_WISH_ORDER.queryTradeWishOrderCount", "TRADE_WISH_ORDER.queryTradeWishOrder");
/*     */   }
/*     */ 
/*     */   public TradeWishOrder selectByWishOrderNum(String orderNum)
/*     */   {
/*  51 */     return (TradeWishOrder)getSqlMapClientTemplate().queryForObject("TRADE_WISH_ORDER.selectByOrderNum", orderNum);
/*     */   }
/*     */ 
/*     */   public int updateStatusById(TradeWishOrder record)
/*     */   {
/*  56 */     return getSqlMapClientTemplate().update("TRADE_WISH_ORDER.updateStatusById", record);
/*     */   }
/*     */ 
/*     */   public List<String> selectTradeMarkList(TradeWishOrder record)
/*     */   {
/*  62 */     return getSqlMapClientTemplate().queryForList("TRADE_WISH_ORDER.selectTradeMarkListOfOneOrder", record);
/*     */   }
/*     */ 
/*     */   public int updateWishOrderInfo(TradeWishOrder tradeWishOrder)
/*     */   {
/*  74 */     return Integer.valueOf(getSqlMapClientTemplate().update("TRADE_WISH_ORDER.updateTradeMarkAndStatus", tradeWishOrder)).intValue();
/*     */   }
/*     */ 
/*     */   public Integer getNumByQuery(TradeWishOrderQuery query)
/*     */   {
/*  84 */     return (Integer)getSqlMapClientTemplate().queryForObject("TRADE_WISH_ORDER.queryTradeWishOrderCount", query);
/*     */   }
/*     */ 
/*     */   public List<TradeWishOrder> getTradeWishOrderList(TradeWishOrder tradeWishOrder)
/*     */   {
/*  91 */     return getSqlMapClientTemplate().queryForList("TRADE_WISH_ORDER.selectTradeWishOrderList", tradeWishOrder);
/*     */   }
/*     */ 
/*     */   public List<TradeWishOrder> selectListInTradeByProjectCode(String projectCode)
/*     */   {
/*  98 */     return getSqlMapClientTemplate().queryForList("TRADE_WISH_ORDER.selectListInTradeByProjectCode", projectCode);
/*     */   }
/*     */ 
/*     */   public void updateStatusEndAuctionBatch(List<TradeWishOrder> list)
/*     */   {
/* 104 */     batchUpdate("TRADE_WISH_ORDER.updateStatusEndAuctionBatch", list);
/*     */   }
/*     */ 
/*     */   public int cancelCreateTradeWishOrder(String projectCode)
/*     */   {
/* 109 */     return getSqlMapClientTemplate().update("TRADE_WISH_ORDER.cancelCreateTradeWishOrder", projectCode);
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.ibatis.trade.TradeWishOrderDAOImpl
 * JD-Core Version:    0.6.0
 */