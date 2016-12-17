/*     */ package com.hundsun.network.gates.wulin.biz.dao.ibatis.trade;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.dao.trade.TradeWishOrderDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.trade.TradeWishOrder;
/*     */ import java.util.List;
/*     */ import java.util.Map;
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
/*     */   public int getTradeWishOrderCountByDate()
/*     */   {
/*  54 */     Integer count = (Integer)getSqlMapClientTemplate().queryForObject("TRADE_WISH_ORDER.getProjectListingCountByDate");
/*     */ 
/*  56 */     return count == null ? 0 : count.intValue();
/*     */   }
/*     */ 
/*     */   public List<TradeWishOrder> selectListByProjectCode(String proCode)
/*     */   {
/*  67 */     return getSqlMapClientTemplate().queryForList("TRADE_WISH_ORDER.selectListByProjectCode", proCode);
/*     */   }
/*     */ 
/*     */   public List<TradeWishOrder> selectLatestTradeWishOrder(int counts)
/*     */   {
/*  73 */     return getSqlMapClientTemplate().queryForList("TRADE_WISH_ORDER.selectLatestTradeWishOrder", Integer.valueOf(counts));
/*     */   }
/*     */ 
/*     */   public String generalWishOrderNo()
/*     */   {
/*  82 */     return (String)getSqlMapClientTemplate().queryForObject("TRADE_WISH_ORDER.generalWishOrderNo");
/*     */   }
/*     */ 
/*     */   public List<TradeWishOrder> selectListInTradeByProjectCode(String proCode)
/*     */   {
/*  91 */     return getSqlMapClientTemplate().queryForList("TRADE_WISH_ORDER.selectListInTradeByProjectCode", proCode);
/*     */   }
/*     */ 
/*     */   public int selectNumOfUnfinishedWishOrder(String userAccount)
/*     */   {
/* 113 */     return ((Integer)getSqlMapClientTemplate().queryForObject("TRADE_WISH_ORDER.selectNumOfUnfinished", userAccount)).intValue();
/*     */   }
/*     */ 
/*     */   public int cancelCreateTradeWishOrder(String projectCode)
/*     */   {
/* 123 */     return getSqlMapClientTemplate().update("TRADE_WISH_ORDER.cancelCreateTradeWishOrder", projectCode);
/*     */   }
/*     */ 
/*     */   public int updateByProjectCode(Map<String, Object> map)
/*     */   {
/* 128 */     return getSqlMapClientTemplate().update("TRADE_WISH_ORDER.updateByProjectCode", map);
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.ibatis.trade.TradeWishOrderDAOImpl
 * JD-Core Version:    0.6.0
 */