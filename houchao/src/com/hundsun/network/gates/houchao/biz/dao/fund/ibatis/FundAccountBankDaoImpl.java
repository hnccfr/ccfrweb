/*    */ package com.hundsun.network.gates.houchao.biz.dao.fund.ibatis;
/*    */ 
/*    */ import com.hundsun.network.gates.houchao.biz.dao.fund.FundAccountBankDao;
/*    */ import com.hundsun.network.gates.houchao.biz.domain.fund.FundAccountBank;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import org.apache.commons.lang.Validate;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("fundAccountBankDAO")
/*    */ public class FundAccountBankDaoImpl extends BaseDAO
/*    */   implements FundAccountBankDao
/*    */ {
/*    */   private static final String NAME_SPACE = "FUND_ACCOUNT_BANK.";
/*    */ 
/*    */   public Long insertFundAccountBank(FundAccountBank fundAccountBank)
/*    */   {
/* 22 */     Validate.notNull(fundAccountBank, "when insert,fundAccountBank must not be null");
/* 23 */     return (Long)getSqlMapClientTemplate().insert("FUND_ACCOUNT_BANK.insertFundAccountBank", fundAccountBank);
/*    */   }
/*    */ 
/*    */   public FundAccountBank getFundAccountBankIsExist(String cardno)
/*    */   {
/* 28 */     return (FundAccountBank)getSqlMapClientTemplate().queryForObject("FUND_ACCOUNT_BANK.getFundAccountBankIsExist", cardno);
/*    */   }
/*    */ 
/*    */   public void updateFundAccountBankStatus(FundAccountBank fundAccountBank)
/*    */   {
/* 36 */     getSqlMapClientTemplate().delete("FUND_ACCOUNT_BANK.updateFundAccountBankStatus", fundAccountBank);
/*    */   }
/*    */ 
/*    */   public FundAccountBank getFundAccountBankByAccount(String account)
/*    */   {
/* 41 */     return (FundAccountBank)getSqlMapClientTemplate().queryForObject("FUND_ACCOUNT_BANK.getFundAccountBankByAccount", account);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\houchao\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.houchao.biz.dao.fund.ibatis.FundAccountBankDaoImpl
 * JD-Core Version:    0.6.0
 */