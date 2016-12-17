/*    */ package com.hundsun.network.gates.genshan.biz.dao.ibatis.trade;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.trade.TradeSubstationDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.query.TradeSubstationQuery;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.trade.TradeSubstation;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("tradeSubstationDAO")
/*    */ public class TradeSubstationDAOImpl extends BaseDAO
/*    */   implements TradeSubstationDAO
/*    */ {
/*    */   public int deleteById(Long id)
/*    */   {
/* 17 */     TradeSubstation _key = new TradeSubstation();
/* 18 */     _key.setId(id);
/* 19 */     int rows = getSqlMapClientTemplate().delete("TRADE_SUBSTATION.deleteById", _key);
/* 20 */     return rows;
/*    */   }
/*    */ 
/*    */   public Integer insert(TradeSubstation record) {
/* 24 */     return (Integer)getSqlMapClientTemplate().insert("TRADE_SUBSTATION.insert", record);
/*    */   }
/*    */ 
/*    */   public void selectByQuery(TradeSubstationQuery query)
/*    */   {
/* 29 */     paginate(query, "TRADE_SUBSTATION.queryTradeSubstationCount", "TRADE_SUBSTATION.queryTradeSubstation");
/*    */   }
/*    */ 
/*    */   public int updateById(TradeSubstation record)
/*    */   {
/* 35 */     return getSqlMapClientTemplate().update("TRADE_SUBSTATION.updateById", record);
/*    */   }
/*    */ 
/*    */   public TradeSubstation getTradeSubstationById(Long id)
/*    */   {
/* 40 */     return (TradeSubstation)getSqlMapClientTemplate().queryForObject("TRADE_SUBSTATION.getTradeSubstationById", id);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.ibatis.trade.TradeSubstationDAOImpl
 * JD-Core Version:    0.6.0
 */