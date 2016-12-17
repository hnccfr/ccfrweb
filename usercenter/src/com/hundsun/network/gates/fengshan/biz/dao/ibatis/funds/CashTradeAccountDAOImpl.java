/*    */ package com.hundsun.network.gates.fengshan.biz.dao.ibatis.funds;
/*    */ 
/*    */ import com.hundsun.network.gates.fengshan.biz.dao.funds.CashTradeAccountDAO;
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.funds.CashTradeAccount;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("cashTradeAccountDAO")
/*    */ public class CashTradeAccountDAOImpl extends BaseDAO
/*    */   implements CashTradeAccountDAO
/*    */ {
/*    */   public CashTradeAccount selectCashTradeAccountByUserAccount(String userAccount)
/*    */   {
/* 21 */     return (CashTradeAccount)getSqlMapClientTemplate().queryForObject("CASH_TRADE_ACCOUNT.selectByUserAccount", userAccount);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.dao.ibatis.funds.CashTradeAccountDAOImpl
 * JD-Core Version:    0.6.0
 */