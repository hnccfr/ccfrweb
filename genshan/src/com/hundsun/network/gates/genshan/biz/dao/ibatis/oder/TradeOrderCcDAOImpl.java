/*    */ package com.hundsun.network.gates.genshan.biz.dao.ibatis.oder;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.order.TradeOrderCcDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.order.TradeOrderCc;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.query.TradeOrderCcQuery;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("tradeOrderCcDAO")
/*    */ public class TradeOrderCcDAOImpl extends BaseDAO
/*    */   implements TradeOrderCcDAO
/*    */ {
/*    */   public int deleteByPrimaryKey(Long id)
/*    */   {
/* 16 */     TradeOrderCc _key = new TradeOrderCc();
/* 17 */     _key.setId(id);
/* 18 */     int rows = getSqlMapClientTemplate().delete("TRADE_ORDER_CC.deleteByPrimaryKey", _key);
/* 19 */     return rows;
/*    */   }
/*    */ 
/*    */   public TradeOrderCc selectByPrimaryKey(Long id) {
/* 23 */     TradeOrderCc _key = new TradeOrderCc();
/* 24 */     _key.setId(id);
/* 25 */     TradeOrderCc record = (TradeOrderCc)getSqlMapClientTemplate().queryForObject("TRADE_ORDER_CC.selectByPrimaryKey", _key);
/* 26 */     return record;
/*    */   }
/*    */ 
/*    */   public void selectedByQuery(TradeOrderCcQuery query)
/*    */   {
/* 31 */     paginate(query, "TRADE_ORDER_CC.queryTradeOrderCcCount", "TRADE_ORDER_CC.queryTradeOrderCc");
/*    */   }
/*    */ 
/*    */   public TradeOrderCc selectedByNum(String num)
/*    */   {
/* 36 */     return (TradeOrderCc)getSqlMapClientTemplate().queryForObject("TRADE_ORDER_CC.selectedByOrderCcNum", num);
/*    */   }
/*    */ 
/*    */   public Integer getNumByQuery(TradeOrderCcQuery query)
/*    */   {
/* 46 */     return (Integer)getSqlMapClientTemplate().queryForObject("TRADE_ORDER_CC.queryTradeOrderCcCount", query);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.ibatis.oder.TradeOrderCcDAOImpl
 * JD-Core Version:    0.6.0
 */