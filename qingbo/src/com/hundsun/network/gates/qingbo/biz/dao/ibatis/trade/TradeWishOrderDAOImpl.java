/*     */ package com.hundsun.network.gates.qingbo.biz.dao.ibatis.trade;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*     */ import com.hundsun.network.gates.qingbo.biz.dao.trade.TradeWishOrderDAO;
/*     */ import com.hundsun.network.gates.qingbo.biz.domain.trade.TradeWishOrder;
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
/*  18 */     TradeWishOrder _key = new TradeWishOrder();
/*  19 */     _key.setId(id);
/*  20 */     int rows = getSqlMapClientTemplate().delete("TRADE_WISH_ORDER.deleteByPrimaryKey", _key);
/*  21 */     return rows;
/*     */   }
/*     */ 
/*     */   public Long insert(TradeWishOrder record) {
/*  25 */     return (Long)getSqlMapClientTemplate().insert("TRADE_WISH_ORDER.insert", record);
/*     */   }
/*     */ 
/*     */   public void insertSelective(TradeWishOrder record) {
/*  29 */     getSqlMapClientTemplate().insert("TRADE_WISH_ORDER.insertSelective", record);
/*     */   }
/*     */ 
/*     */   public TradeWishOrder selectByPrimaryKey(Long id) {
/*  33 */     TradeWishOrder _key = new TradeWishOrder();
/*  34 */     _key.setId(id);
/*  35 */     TradeWishOrder record = (TradeWishOrder)getSqlMapClientTemplate().queryForObject("TRADE_WISH_ORDER.selectByPrimaryKey", _key);
/*     */ 
/*  37 */     return record;
/*     */   }
/*     */ 
/*     */   public int updateByPrimaryKeySelective(TradeWishOrder record) {
/*  41 */     int rows = getSqlMapClientTemplate().update("TRADE_WISH_ORDER.updateByPrimaryKeySelective", record);
/*     */ 
/*  43 */     return rows;
/*     */   }
/*     */ 
/*     */   public int updateByPrimaryKey(TradeWishOrder record) {
/*  47 */     int rows = getSqlMapClientTemplate().update("TRADE_WISH_ORDER.updateByPrimaryKey", record);
/*  48 */     return rows;
/*     */   }
/*     */ 
/*     */   public List<TradeWishOrder> selectListByProjectCode(String proCode)
/*     */   {
/*  59 */     return getSqlMapClientTemplate().queryForList("TRADE_WISH_ORDER.selectListByProjectCode", proCode);
/*     */   }
/*     */ 
/*     */   public List<TradeWishOrder> selectBSUListByProjectCode(String proCode)
/*     */   {
/*  71 */     return getSqlMapClientTemplate().queryForList("TRADE_WISH_ORDER.selectBSUListByProjectCode", proCode);
/*     */   }
/*     */ 
/*     */   public List<TradeWishOrder> selectLatestTradeWishOrder(int counts)
/*     */   {
/*  78 */     return getSqlMapClientTemplate().queryForList("TRADE_WISH_ORDER.selectLatestTradeWishOrder", Integer.valueOf(counts));
/*     */   }
/*     */ 
/*     */   public String generalWishOrderNo()
/*     */   {
/*  87 */     return (String)getSqlMapClientTemplate().queryForObject("TRADE_WISH_ORDER.generalWishOrderNo");
/*     */   }
/*     */ 
/*     */   public List<TradeWishOrder> selectListInTradeByProjectCode(String proCode)
/*     */   {
/*  97 */     return getSqlMapClientTemplate().queryForList("TRADE_WISH_ORDER.selectListInTradeByProjectCode", proCode);
/*     */   }
/*     */ 
/*     */   public void updateWishOrderStatusBatch(List<TradeWishOrder> list)
/*     */   {
/* 108 */     batchUpdate("TRADE_WISH_ORDER.updateStatusBidsucancel", list);
/*     */   }
/*     */ 
/*     */   public void updateStatusEndAuctionBatch(List<TradeWishOrder> list)
/*     */   {
/* 121 */     batchUpdate("TRADE_WISH_ORDER.updateStatusEndAuctionBatch", list);
/*     */   }
/*     */ 
/*     */   public int cancelCreateTradeWishOrder(String projectCode)
/*     */   {
/* 132 */     return getSqlMapClientTemplate().update("TRADE_WISH_ORDER.cancelCreateTradeWishOrder", projectCode);
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.qingbo.biz.dao.ibatis.trade.TradeWishOrderDAOImpl
 * JD-Core Version:    0.6.0
 */