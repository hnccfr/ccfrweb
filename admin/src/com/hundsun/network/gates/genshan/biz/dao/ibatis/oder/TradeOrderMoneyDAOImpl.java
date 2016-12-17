/*    */ package com.hundsun.network.gates.genshan.biz.dao.ibatis.oder;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.order.TradeOrderMoneyDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.order.TradeOrderMoney;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.query.TradeOrderMoneyQuery;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import java.util.List;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("tradeOrderMoneyDAO")
/*    */ public class TradeOrderMoneyDAOImpl extends BaseDAO
/*    */   implements TradeOrderMoneyDAO
/*    */ {
/*    */   public TradeOrderMoney selectByAccountOrderNo(String orderNo, String userAccount)
/*    */   {
/* 23 */     TradeOrderMoneyQuery query = new TradeOrderMoneyQuery();
/* 24 */     query.setOrderNo(orderNo);
/* 25 */     query.setUserAccount(userAccount);
/* 26 */     return (TradeOrderMoney)getSqlMapClientTemplate().queryForObject("TRADE_ORDER_MONEY.selectByAccountOrderNo", query);
/*    */   }
/*    */ 
/*    */   public List<TradeOrderMoney> selectByCondition(TradeOrderMoneyQuery query)
/*    */   {
/* 38 */     if (query.getOrderNo() == null) {
/* 39 */       return null;
/*    */     }
/* 41 */     return getSqlMapClientTemplate().queryForList("TRADE_ORDER_MONEY.selectByCondition", query);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.ibatis.oder.TradeOrderMoneyDAOImpl
 * JD-Core Version:    0.6.0
 */