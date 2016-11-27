/*    */ package com.hundsun.network.gates.houchao.biz.dao.fund.ibatis;
/*    */ 
/*    */ import com.hundsun.network.gates.houchao.biz.dao.fund.FundAccountLogDAO;
/*    */ import com.hundsun.network.gates.houchao.biz.domain.fund.FundAccountLog;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import org.apache.commons.lang.Validate;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("fundAccountLogDAO")
/*    */ public class FundAccountLogDAOImpl extends BaseDAO
/*    */   implements FundAccountLogDAO
/*    */ {
/*    */   private static final String NAME_SPACE = "FUND_ACCOUNT_LOG.";
/*    */ 
/*    */   public Long insert(FundAccountLog fundAccountLog)
/*    */   {
/* 25 */     Validate.notNull(fundAccountLog, "when insert,fundAccountLog must not be null");
/* 26 */     return (Long)getSqlMapClientTemplate().insert("FUND_ACCOUNT_LOG.insert", fundAccountLog);
/*    */   }
/*    */ 
/*    */   public FundAccountLog getByBizNoAndSubTransCode(String bizNo, String subTransCode)
/*    */   {
/* 37 */     Map map = new HashMap();
/* 38 */     map.put("bizNo", bizNo);
/* 39 */     map.put("subTransCode", subTransCode);
/* 40 */     return (FundAccountLog)getSqlMapClientTemplate().queryForObject("FUND_ACCOUNT_LOG.get-by-bizNo-and-subCode", map);
/*    */   }
/*    */ 
/*    */   public void updateToCancelFlag(FundAccountLog record)
/*    */   {
/* 49 */     getSqlMapClientTemplate().update("FUND_ACCOUNT_LOG.update-to-cancelFlag", record);
/*    */   }
/*    */ 
/*    */   public FundAccountLog getFundAccountLog(FundAccountLog fundAccountLog)
/*    */   {
/* 60 */     return (FundAccountLog)getSqlMapClientTemplate().queryForObject("FUND_ACCOUNT_LOG.get-by-bizNo-and-subCode-val", fundAccountLog);
/*    */   }
/*    */ 
/*    */   public FundAccountLog getFundAccLogByBiznoBankno(FundAccountLog fundAccountLog)
/*    */   {
/* 71 */     return (FundAccountLog)getSqlMapClientTemplate().queryForObject("FUND_ACCOUNT_LOG.get-by-bizNo", fundAccountLog);
/*    */   }
/*    */ 
/*    */   public FundAccountLog fundAccountLogBybizNO(String bizNO)
/*    */   {
/* 83 */     return (FundAccountLog)getSqlMapClientTemplate().queryForObject("FUND_ACCOUNT_LOG.fundAccountLogBybizNO", bizNO);
/*    */   }
/*    */ 
/*    */   public FundAccountLog getByBizNoAndSubTransCodeAndFundAccount(String bizNo, String subTransCode, String fundAccount)
/*    */   {
/* 94 */     Map map = new HashMap();
/* 95 */     map.put("bizNo", bizNo);
/* 96 */     map.put("subTransCode", subTransCode);
/* 97 */     map.put("fundAccount", fundAccount);
/* 98 */     return (FundAccountLog)getSqlMapClientTemplate().queryForObject("FUND_ACCOUNT_LOG.get-by-bizNo-and-subCode-and-fundAccount", map);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\houchao\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.houchao.biz.dao.fund.ibatis.FundAccountLogDAOImpl
 * JD-Core Version:    0.6.0
 */