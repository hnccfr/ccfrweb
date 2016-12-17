/*    */ package com.hundsun.network.gates.wulin.biz.dao.ibatis.funds;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.dao.funds.CashTradeAccountDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.funds.CashTradeAccount;
/*    */ import java.util.Map;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("cashTradeAccountDAO")
/*    */ public class CashTradeAccountDAOImpl extends BaseDAO
/*    */   implements CashTradeAccountDAO
/*    */ {
/*    */   public Long registFundsAccount(CashTradeAccount ctAccount)
/*    */   {
/* 20 */     return (Long)getSqlMapClientTemplate().insert("CashTradeAccount.insert", ctAccount);
/*    */   }
/*    */ 
/*    */   public CashTradeAccount selectCashTradeAccountByTaid(Map<String, Object> parasMap)
/*    */   {
/* 29 */     return (CashTradeAccount)getSqlMapClientTemplate().queryForObject("CashTradeAccount.selectCashTradeAccountBytaid", parasMap);
/*    */   }
/*    */ 
/*    */   public int frozenCashAccount(Map<String, Object> parasMap)
/*    */   {
/* 38 */     int rows = getSqlMapClientTemplate().update("CashTradeAccount.frozenCash", parasMap);
/* 39 */     return rows;
/*    */   }
/*    */ 
/*    */   public int thawCashAccount(Map<String, Object> parasMap)
/*    */   {
/* 48 */     int rows = getSqlMapClientTemplate().update("CashTradeAccount.thawCash", parasMap);
/* 49 */     return rows;
/*    */   }
/*    */ 
/*    */   public int outcomeCashAccount(Map<String, Object> parasMap)
/*    */   {
/* 57 */     int rows = getSqlMapClientTemplate().update("CashTradeAccount.outcomeCash", parasMap);
/* 58 */     return rows;
/*    */   }
/*    */ 
/*    */   public int incomeCashAccount(Map<String, Object> parasMap)
/*    */   {
/* 66 */     int rows = getSqlMapClientTemplate().update("CashTradeAccount.incomeCash", parasMap);
/* 67 */     return rows;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.ibatis.funds.CashTradeAccountDAOImpl
 * JD-Core Version:    0.6.0
 */