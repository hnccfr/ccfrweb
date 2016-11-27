/*    */ package com.hundsun.network.gates.genshan.biz.dao.ibatis.oder;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.order.TradeOrderDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.order.TradeOrder;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.query.TradeOrderQuery;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("tradeOrderDAO")
/*    */ public class TradeOrderDAOImpl extends BaseDAO
/*    */   implements TradeOrderDAO
/*    */ {
/*    */   public void queryTradeOrder(TradeOrderQuery query)
/*    */   {
/* 23 */     paginate(query, "TradeOrder.queryTradeOrderCount", "TradeOrder.queryTradeOrder");
/*    */   }
/*    */ 
/*    */   public TradeOrder selectByOrderNo(String orderNo)
/*    */   {
/* 28 */     return (TradeOrder)getSqlMapClientTemplate().queryForObject("TradeOrder.selectByOrderNo", orderNo);
/*    */   }
/*    */ 
/*    */   public int updateByOrderNo(TradeOrder record)
/*    */   {
/* 38 */     int rows = getSqlMapClientTemplate().update("TradeOrder.updateByOrderNo", record);
/* 39 */     return rows;
/*    */   }
/*    */ 
/*    */   public int updateParamByOrderNo(Map<String, Object> paramMap, String orderNo)
/*    */   {
/* 51 */     if (null == paramMap) {
/* 52 */       return 0;
/*    */     }
/* 54 */     paramMap.put("orderNo", orderNo);
/* 55 */     return getSqlMapClientTemplate().update("TradeOrder.updateParamByOrderNo", paramMap);
/*    */   }
/*    */ 
/*    */   public Integer getNumByQuery(TradeOrderQuery query)
/*    */   {
/* 65 */     return (Integer)getSqlMapClientTemplate().queryForObject("TradeOrder.queryTradeOrderCount", query);
/*    */   }
/*    */ 
/*    */   public List<TradeOrder> selectByProjectCode(String projectCode)
/*    */   {
/* 71 */     return getSqlMapClientTemplate().queryForList("TradeOrder.selectByProjectCode", projectCode);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.ibatis.oder.TradeOrderDAOImpl
 * JD-Core Version:    0.6.0
 */