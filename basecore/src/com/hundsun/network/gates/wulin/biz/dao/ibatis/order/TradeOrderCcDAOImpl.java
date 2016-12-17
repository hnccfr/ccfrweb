/*    */ package com.hundsun.network.gates.wulin.biz.dao.ibatis.order;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.dao.order.TradeOrderCcDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.order.TradeOrderCc;
/*    */ import java.util.List;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("tradeOrderCcDAO")
/*    */ public class TradeOrderCcDAOImpl extends BaseDAO
/*    */   implements TradeOrderCcDAO
/*    */ {
/*    */   public String generalOrderCcNum()
/*    */   {
/* 20 */     return (String)getSqlMapClientTemplate().queryForObject("TRADE_ORDER_CC.generalOrderCcNum");
/*    */   }
/*    */ 
/*    */   public Long insert(TradeOrderCc record)
/*    */   {
/* 28 */     return (Long)getSqlMapClientTemplate().insert("TRADE_ORDER_CC.insert", record);
/*    */   }
/*    */ 
/*    */   public TradeOrderCc selectByOrderCcNum(String orderCcNum)
/*    */   {
/* 37 */     return (TradeOrderCc)getSqlMapClientTemplate().queryForObject("TRADE_ORDER_CC.selectByOrderCcNum", orderCcNum);
/*    */   }
/*    */ 
/*    */   public int updateByOrderCcNum(TradeOrderCc record)
/*    */   {
/* 46 */     int rows = getSqlMapClientTemplate().update("TRADE_ORDER_CC.updateByOderCcNum", record);
/* 47 */     return rows;
/*    */   }
/*    */ 
/*    */   public List<TradeOrderCc> selectByOrderCc(TradeOrderCc tradeOrderCc)
/*    */   {
/* 53 */     List list = getSqlMapClientTemplate().queryForList("TRADE_ORDER_CC.selectByOrderCc", tradeOrderCc);
/* 54 */     return list;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.ibatis.order.TradeOrderCcDAOImpl
 * JD-Core Version:    0.6.0
 */