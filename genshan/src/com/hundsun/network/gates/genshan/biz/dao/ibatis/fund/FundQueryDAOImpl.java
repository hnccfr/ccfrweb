/*     */ package com.hundsun.network.gates.genshan.biz.dao.ibatis.fund;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.dao.fund.FundQueryDAO;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.fund.FundAccountMsg;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.fund.FundAccountReport;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.fund.FundSettlement;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.fund.query.FundAccountLogQuery;
/*     */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*     */ import org.springframework.stereotype.Repository;
/*     */ 
/*     */ @Repository("fundQueryDAO")
/*     */ public class FundQueryDAOImpl extends BaseDAO
/*     */   implements FundQueryDAO
/*     */ {
/*     */   private static final String SQLMAP_SPACE = "FundQuery.";
/*     */ 
/*     */   public FundSettlement queryFundSettlement(String tradeDate)
/*     */   {
/*  36 */     return (FundSettlement)getSqlMapClientTemplate().queryForObject("FundQuery.queryFundSettlement", tradeDate);
/*     */   }
/*     */ 
/*     */   public void queryFundAccountLogList(FundAccountLogQuery fundAccountLogQuery)
/*     */   {
/*  45 */     paginate(fundAccountLogQuery, "FundQuery.queryFundAccountLogCount", "FundQuery.queryFundAccountLogList");
/*     */   }
/*     */ 
/*     */   public FundAccountMsg queryFundAccountMsg(String fundAccount, String userAccount)
/*     */   {
/*  53 */     Map map = new HashMap();
/*  54 */     map.put("fundAccount", fundAccount);
/*  55 */     map.put("userAccount", userAccount);
/*  56 */     return (FundAccountMsg)getSqlMapClientTemplate().queryForObject("FundQuery.queryFundAccountMsg", map);
/*     */   }
/*     */ 
/*     */   public FundAccountReport queryFundMoneyHisReport(String userAccount, String fundAccount, String tradeDate)
/*     */   {
/*  65 */     Map map = new HashMap();
/*  66 */     map.put("userAccount", userAccount);
/*  67 */     map.put("fundAccount", fundAccount);
/*  68 */     map.put("tradeDate", tradeDate);
/*  69 */     return (FundAccountReport)getSqlMapClientTemplate().queryForObject("FundQuery.queryFundMoneyHisReport", map);
/*     */   }
/*     */ 
/*     */   public FundAccountReport queryFundMoneyTotalHisReport(String fundAccount, String tradeDate)
/*     */   {
/*  78 */     Map map = new HashMap();
/*  79 */     map.put("fundAccount", fundAccount);
/*  80 */     map.put("tradeDate", tradeDate);
/*  81 */     return (FundAccountReport)getSqlMapClientTemplate().queryForObject("FundQuery.queryFundMoneyTotalHisReport", map);
/*     */   }
/*     */ 
/*     */   public FundAccountReport queryFundMoneyHisReportTotal(String tradeDate)
/*     */   {
/*  90 */     Map map = new HashMap();
/*  91 */     map.put("tradeDate", tradeDate);
/*  92 */     return (FundAccountReport)getSqlMapClientTemplate().queryForObject("FundQuery.queryFundMoneyHisReportTotal", map);
/*     */   }
/*     */ 
/*     */   public FundAccountReport queryFundMoneyTotalHisReportTotal(String tradeDate)
/*     */   {
/* 101 */     Map map = new HashMap();
/* 102 */     map.put("tradeDate", tradeDate);
/* 103 */     return (FundAccountReport)getSqlMapClientTemplate().queryForObject("FundQuery.queryFundMoneyTotalHisReportTotal", map);
/*     */   }
/*     */ 
/*     */   public FundSettlement queryPlatformSettlement(String startTradeDate, String endTradeDate)
/*     */   {
/* 111 */     Map map = new HashMap();
/* 112 */     map.put("startTradeDate", startTradeDate);
/* 113 */     map.put("endTradeDate", endTradeDate);
/* 114 */     return (FundSettlement)getSqlMapClientTemplate().queryForObject("FundQuery.queryPlatformSettlement", map);
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.ibatis.fund.FundQueryDAOImpl
 * JD-Core Version:    0.6.0
 */