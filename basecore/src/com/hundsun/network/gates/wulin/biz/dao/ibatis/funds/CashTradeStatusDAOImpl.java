/*    */ package com.hundsun.network.gates.wulin.biz.dao.ibatis.funds;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.dao.funds.CashTradeStatusDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.funds.CashTradeStatus;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("cashTradeStatusDAO")
/*    */ public class CashTradeStatusDAOImpl extends BaseDAO
/*    */   implements CashTradeStatusDAO
/*    */ {
/*    */   public Long insertCashStatus(CashTradeStatus cts)
/*    */   {
/* 15 */     return (Long)getSqlMapClientTemplate().insert("CashTradeStatus.insert", cts);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.ibatis.funds.CashTradeStatusDAOImpl
 * JD-Core Version:    0.6.0
 */