/*    */ package com.hundsun.network.gates.wulin.biz.dao.ibatis.order;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.dao.order.TradeOrderLogDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.order.TradeOrderLog;
/*    */ import java.util.List;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("tradeOrderLogDAO")
/*    */ public class TradeOrderLogDAOImpl extends BaseDAO
/*    */   implements TradeOrderLogDAO
/*    */ {
/*    */   public Long insert(TradeOrderLog record)
/*    */   {
/* 18 */     return (Long)getSqlMapClientTemplate().insert("TRADE_ORDER_LOG.insert", record);
/*    */   }
/*    */ 
/*    */   public List<TradeOrderLog> selectByOrderNo(String orderNo)
/*    */   {
/* 28 */     return getSqlMapClientTemplate().queryForList("TRADE_ORDER_LOG.selectByOrderNo", orderNo);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.ibatis.order.TradeOrderLogDAOImpl
 * JD-Core Version:    0.6.0
 */