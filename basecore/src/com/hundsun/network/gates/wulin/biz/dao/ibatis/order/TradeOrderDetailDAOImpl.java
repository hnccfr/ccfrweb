/*    */ package com.hundsun.network.gates.wulin.biz.dao.ibatis.order;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.dao.order.TradeOrderDetailDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.order.TradeOrderDetail;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("tradeOrderDetailDAO")
/*    */ public class TradeOrderDetailDAOImpl extends BaseDAO
/*    */   implements TradeOrderDetailDAO
/*    */ {
/*    */   public Long insert(TradeOrderDetail record)
/*    */   {
/* 17 */     return (Long)getSqlMapClientTemplate().insert("TRADE_ORDER_DETAIL.insert", record);
/*    */   }
/*    */ 
/*    */   public int updateByOrderNo(TradeOrderDetail record)
/*    */   {
/* 26 */     int rows = getSqlMapClientTemplate().update("TRADE_ORDER_DETAIL.updateByOrderNo", record);
/* 27 */     return rows;
/*    */   }
/*    */ 
/*    */   public TradeOrderDetail selectByOrderNo(String orderNo)
/*    */   {
/* 36 */     TradeOrderDetail record = (TradeOrderDetail)getSqlMapClientTemplate().queryForObject("TRADE_ORDER_DETAIL.selectByOrderNo", orderNo);
/* 37 */     return record;
/*    */   }
/*    */ 
/*    */   public int deleteByOrderNo(String orderNo)
/*    */   {
/* 46 */     int rows = getSqlMapClientTemplate().delete("TRADE_ORDER_DETAIL.deleteByOrderNo", orderNo);
/* 47 */     return rows;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.ibatis.order.TradeOrderDetailDAOImpl
 * JD-Core Version:    0.6.0
 */