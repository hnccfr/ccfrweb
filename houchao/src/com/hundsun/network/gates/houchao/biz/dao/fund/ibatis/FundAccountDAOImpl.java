/*    */ package com.hundsun.network.gates.houchao.biz.dao.fund.ibatis;
/*    */ 
/*    */ import com.hundsun.network.gates.houchao.biz.dao.fund.FundAccountDAO;
/*    */ import com.hundsun.network.gates.houchao.biz.domain.fund.FundAccount;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import org.apache.commons.lang.Validate;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("fundAccountDAO")
/*    */ public class FundAccountDAOImpl extends BaseDAO
/*    */   implements FundAccountDAO
/*    */ {
/*    */   private static final String NAME_SPACE = "FUND_ACCOUNT.";
/*    */ 
/*    */   public Long insert(FundAccount fundAccount)
/*    */   {
/* 21 */     Validate.notNull(fundAccount, "when insert,fundAccount must not be null");
/* 22 */     return (Long)getSqlMapClientTemplate().insert("FUND_ACCOUNT.insert", fundAccount);
/*    */   }
/*    */ 
/*    */   public int updateStatusClosed(FundAccount fundAccount)
/*    */   {
/* 32 */     if (fundAccount == null) {
/* 33 */       throw new NullPointerException("fundAccount can't null.");
/*    */     }
/* 35 */     return getSqlMapClientTemplate().update("FUND_ACCOUNT.updateStatusClosed", fundAccount);
/*    */   }
/*    */ 
/*    */   public void updateFundAccountByAcc(FundAccount fundAccount)
/*    */   {
/* 44 */     getSqlMapClientTemplate().update("FUND_ACCOUNT.updateFundAccountByAcc", fundAccount);
/*    */   }
/*    */ 
/*    */   public FundAccount queryByFundAccount(String fundAccountNo, boolean isLock)
/*    */   {
/*    */     Object fundAccount;
/* 56 */     if (isLock)
/* 57 */       fundAccount = getSqlMapClientTemplate().queryForObject("FUND_ACCOUNT.queryByFundAccountLock", fundAccountNo);
/*    */     else {
/* 59 */       fundAccount = getSqlMapClientTemplate().queryForObject("FUND_ACCOUNT.queryByFundAccount", fundAccountNo);
/*    */     }
/*    */ 
/* 62 */     if (fundAccount != null) {
/* 63 */       return (FundAccount)fundAccount;
/*    */     }
/* 65 */     return null;
/*    */   }
/*    */ 
/*    */   public String getFundAccountNO()
/*    */   {
/* 74 */     return (String)getSqlMapClientTemplate().queryForObject("FUND_ACCOUNT.getFundAccount");
/*    */   }
/*    */ 
/*    */   public String getInnerBillNoSeq()
/*    */   {
/* 83 */     return (String)getSqlMapClientTemplate().queryForObject("FUND_ACCOUNT.getInnerBillNoSeq");
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\houchao\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.houchao.biz.dao.fund.ibatis.FundAccountDAOImpl
 * JD-Core Version:    0.6.0
 */