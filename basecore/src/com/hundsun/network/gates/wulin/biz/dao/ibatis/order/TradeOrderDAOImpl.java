/*    */ package com.hundsun.network.gates.wulin.biz.dao.ibatis.order;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.dao.order.TradeOrderDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.order.TradeOrder;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.order.TradeOrderAndPro;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.query.TradeOrderQuery;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("tradeOrderDAO")
/*    */ public class TradeOrderDAOImpl extends BaseDAO
/*    */   implements TradeOrderDAO
/*    */ {
/*    */   public String generalOrderNo()
/*    */   {
/* 24 */     return (String)getSqlMapClientTemplate().queryForObject("TRADE_ORDER.generalOrderNo");
/*    */   }
/*    */ 
/*    */   public Long insert(TradeOrder record)
/*    */   {
/* 32 */     return (Long)getSqlMapClientTemplate().insert("TRADE_ORDER.insert", record);
/*    */   }
/*    */ 
/*    */   public int updateByOrderNo(TradeOrder record)
/*    */   {
/* 41 */     int rows = getSqlMapClientTemplate().update("TRADE_ORDER.updateByOrderNo", record);
/* 42 */     return rows;
/*    */   }
/*    */ 
/*    */   public TradeOrder selectByOrderNo(String orderNo)
/*    */   {
/* 51 */     TradeOrder record = (TradeOrder)getSqlMapClientTemplate().queryForObject("TRADE_ORDER.selectByOrderNo", orderNo);
/*    */ 
/* 53 */     return record;
/*    */   }
/*    */ 
/*    */   public int deleteByOrderNo(String orderNo)
/*    */   {
/* 62 */     int rows = getSqlMapClientTemplate().delete("TRADE_ORDER.deleteByOrderNo", orderNo);
/* 63 */     return rows;
/*    */   }
/*    */ 
/*    */   public int updateParamByOrderNo(Map<String, Object> paramMap, String orderNo)
/*    */   {
/* 75 */     if (null == paramMap) {
/* 76 */       return 0;
/*    */     }
/* 78 */     paramMap.put("orderNo", orderNo);
/* 79 */     return getSqlMapClientTemplate().update("TRADE_ORDER.updateParamByOrderNo", paramMap);
/*    */   }
/*    */ 
/*    */   public List<TradeOrder> queryTradeOrderByCondition(TradeOrderQuery query)
/*    */   {
/* 84 */     return getSqlMapClientTemplate().queryForList("TRADE_ORDER.queryTradeOrderByCondition", query);
/*    */   }
/*    */ 
/*    */   public List<TradeOrderAndPro> selectLatestOrderByCounts(TradeOrderQuery query)
/*    */   {
/* 90 */     return getSqlMapClientTemplate().queryForList("TRADE_ORDER.selectLatestOrderByCounts", query);
/*    */   }
/*    */ 
/*    */   public int selectNumOfUnfinishedOrder(String userAccount)
/*    */   {
/* 95 */     return ((Integer)getSqlMapClientTemplate().queryForObject("TRADE_ORDER.selectNumOfUnfinished", userAccount)).intValue();
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.ibatis.order.TradeOrderDAOImpl
 * JD-Core Version:    0.6.0
 */