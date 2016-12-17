/*    */ package com.hundsun.network.gates.wulin.biz.dao.ibatis.order;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.dao.order.TradeRefundDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.order.TradeRefund;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.query.TradeRefundQuery;
/*    */ import java.util.List;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ 
/*    */ public class TradeRefundDAOImpl extends BaseDAO
/*    */   implements TradeRefundDAO
/*    */ {
/*    */   public Long insert(TradeRefund record)
/*    */   {
/* 17 */     return (Long)getSqlMapClientTemplate().insert("TRADE_REFUND.insert", record);
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKey(TradeRefund record)
/*    */   {
/* 26 */     int rows = getSqlMapClientTemplate().update("TRADE_REFUND.updateByPrimaryKey", record);
/* 27 */     return rows;
/*    */   }
/*    */ 
/*    */   public List<TradeRefund> selectByConf(TradeRefundQuery query)
/*    */   {
/* 37 */     return getSqlMapClientTemplate().queryForList("TRADE_REFUND.selectByConf", query);
/*    */   }
/*    */ 
/*    */   public TradeRefund selectByPrimaryKey(Long id)
/*    */   {
/* 46 */     TradeRefund record = (TradeRefund)getSqlMapClientTemplate().queryForObject("TRADE_REFUND.selectByPrimaryKey", id);
/* 47 */     return record;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.ibatis.order.TradeRefundDAOImpl
 * JD-Core Version:    0.6.0
 */