/*    */ package com.hundsun.network.gates.wulin.biz.dao.ibatis.trade;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.dao.trade.TradeTypePropConfigDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.trade.TradeTypePropConfig;
/*    */ import java.util.List;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("tradeTypePropConfigDAO")
/*    */ public class TradeTypePropConfigDAOImpl extends BaseDAO
/*    */   implements TradeTypePropConfigDAO
/*    */ {
/*    */   public int deleteByPrimaryKey(Long id)
/*    */   {
/* 19 */     TradeTypePropConfig _key = new TradeTypePropConfig();
/* 20 */     _key.setId(id);
/* 21 */     int rows = getSqlMapClientTemplate().delete("GATES_TRADE_TYPE_PROP_CONFIG.deleteByPrimaryKey", _key);
/*    */ 
/* 23 */     return rows;
/*    */   }
/*    */ 
/*    */   public void insert(TradeTypePropConfig record) {
/* 27 */     getSqlMapClientTemplate().insert("GATES_TRADE_TYPE_PROP_CONFIG.insert", record);
/*    */   }
/*    */ 
/*    */   public void insertSelective(TradeTypePropConfig record) {
/* 31 */     getSqlMapClientTemplate().insert("GATES_TRADE_TYPE_PROP_CONFIG.insertSelective", record);
/*    */   }
/*    */ 
/*    */   public List selectByExample(TradeTypePropConfig example)
/*    */   {
/* 36 */     List list = getSqlMapClientTemplate().queryForList("GATES_TRADE_TYPE_PROP_CONFIG.selectByExample", example);
/*    */ 
/* 38 */     return list;
/*    */   }
/*    */ 
/*    */   public TradeTypePropConfig selectByPrimaryKey(Long id) {
/* 42 */     TradeTypePropConfig _key = new TradeTypePropConfig();
/* 43 */     _key.setId(id);
/* 44 */     TradeTypePropConfig record = (TradeTypePropConfig)getSqlMapClientTemplate().queryForObject("GATES_TRADE_TYPE_PROP_CONFIG.selectByPrimaryKey", _key);
/*    */ 
/* 46 */     return record;
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKeySelective(TradeTypePropConfig record) {
/* 50 */     int rows = getSqlMapClientTemplate().update("GATES_TRADE_TYPE_PROP_CONFIG.updateByPrimaryKeySelective", record);
/*    */ 
/* 52 */     return rows;
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKey(TradeTypePropConfig record) {
/* 56 */     int rows = getSqlMapClientTemplate().update("GATES_TRADE_TYPE_PROP_CONFIG.updateByPrimaryKey", record);
/*    */ 
/* 58 */     return rows;
/*    */   }
/*    */ 
/*    */   public int countByExample(TradeTypePropConfig tradeTypePropConfig)
/*    */   {
/* 63 */     return 0;
/*    */   }
/*    */ 
/*    */   public int deleteByExample(TradeTypePropConfig tradeTypePropConfig)
/*    */   {
/* 68 */     return 0;
/*    */   }
/*    */ 
/*    */   public int updateByExample(TradeTypePropConfig record, TradeTypePropConfig tradeTypePropConfig)
/*    */   {
/* 73 */     return 0;
/*    */   }
/*    */ 
/*    */   public int updateByExampleSelective(TradeTypePropConfig record, TradeTypePropConfig tradeTypePropConfig)
/*    */   {
/* 79 */     return 0;
/*    */   }
/*    */ 
/*    */   public List<TradeTypePropConfig> getTradeTypePropList(TradeTypePropConfig tradeTypePropConfig)
/*    */   {
/* 84 */     List list = getSqlMapClientTemplate().queryForList("GATES_TRADE_TYPE_PROP_CONFIG.getTradeTypePropListByObj", tradeTypePropConfig);
/*    */ 
/* 86 */     return list;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.ibatis.trade.TradeTypePropConfigDAOImpl
 * JD-Core Version:    0.6.0
 */