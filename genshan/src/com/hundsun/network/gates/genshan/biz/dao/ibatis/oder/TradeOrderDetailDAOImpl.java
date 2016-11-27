/*    */ package com.hundsun.network.gates.genshan.biz.dao.ibatis.oder;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.order.TradeOrderDetailDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.order.TradeOrderDetail;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import java.util.Map;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("tradeOrderDetailDAO")
/*    */ public class TradeOrderDetailDAOImpl extends BaseDAO
/*    */   implements TradeOrderDetailDAO
/*    */ {
/*    */   public TradeOrderDetail selectByOrderNo(String orderNo)
/*    */   {
/* 16 */     return (TradeOrderDetail)getSqlMapClientTemplate().queryForObject("TradeOrderDetail.selectByOrderNo", orderNo);
/*    */   }
/*    */ 
/*    */   public TradeOrderDetail selectOrderByMapParam(Map<String, Object> paraMap)
/*    */   {
/* 22 */     return (TradeOrderDetail)getSqlMapClientTemplate().queryForObject("TradeOrderDetail.selectOrderByMapParam", paraMap);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.ibatis.oder.TradeOrderDetailDAOImpl
 * JD-Core Version:    0.6.0
 */