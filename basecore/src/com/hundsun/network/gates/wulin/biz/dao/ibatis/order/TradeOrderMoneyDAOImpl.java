/*    */ package com.hundsun.network.gates.wulin.biz.dao.ibatis.order;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.dao.order.TradeOrderMoneyDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.order.TradeOrderMoney;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.query.TradeOrderMoneyQuery;
/*    */ import java.util.List;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("tradeOrderMoneyDAO")
/*    */ public class TradeOrderMoneyDAOImpl extends BaseDAO
/*    */   implements TradeOrderMoneyDAO
/*    */ {
/*    */   public Long insert(TradeOrderMoney record)
/*    */   {
/* 20 */     return (Long)getSqlMapClientTemplate().insert("TRADE_ORDER_MONEY.insert", record);
/*    */   }
/*    */ 
/*    */   public List<TradeOrderMoney> selectByCondition(TradeOrderMoneyQuery query)
/*    */   {
/* 30 */     if (query.getOrderNo() == null) {
/* 31 */       return null;
/*    */     }
/* 33 */     return getSqlMapClientTemplate().queryForList("TRADE_ORDER_MONEY.selectByCondition", query);
/*    */   }
/*    */ 
/*    */   public TradeOrderMoney selectByAccountOrderNo(String orderNo, String userAccount)
/*    */   {
/* 43 */     TradeOrderMoneyQuery query = new TradeOrderMoneyQuery();
/* 44 */     query.setOrderNo(orderNo);
/* 45 */     query.setUserAccount(userAccount);
/* 46 */     return (TradeOrderMoney)getSqlMapClientTemplate().queryForObject("TRADE_ORDER_MONEY.selectByAccountOrderNo", query);
/*    */   }
/*    */ 
/*    */   public int updateBySelective(TradeOrderMoney record)
/*    */   {
/* 55 */     if (record.getOrderNo() == null) {
/* 56 */       return 0;
/*    */     }
/* 58 */     return getSqlMapClientTemplate().update("TRADE_ORDER_MONEY.updateBySelective", record);
/*    */   }
/*    */ 
/*    */   public int deleteByOrderNo(String orderNo)
/*    */   {
/* 67 */     return getSqlMapClientTemplate().delete("TRADE_ORDER_MONEY.deleteByOrderNo", orderNo);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.ibatis.order.TradeOrderMoneyDAOImpl
 * JD-Core Version:    0.6.0
 */