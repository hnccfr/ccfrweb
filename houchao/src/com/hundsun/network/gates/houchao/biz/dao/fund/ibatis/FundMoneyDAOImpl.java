/*     */ package com.hundsun.network.gates.houchao.biz.dao.fund.ibatis;
/*     */ 
/*     */ import com.hundsun.network.gates.houchao.biz.dao.fund.FundMoneyDAO;
/*     */ import com.hundsun.network.gates.houchao.biz.domain.fund.FundMoney;
/*     */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*     */ import com.hundsun.network.melody.common.util.StringUtil;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.lang.Validate;
/*     */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*     */ import org.springframework.stereotype.Repository;
/*     */ 
/*     */ @Repository("fundMoneyDAO")
/*     */ public class FundMoneyDAOImpl extends BaseDAO
/*     */   implements FundMoneyDAO
/*     */ {
/*     */   private static final String NAME_SPACE = "FUND_MONEY.";
/*     */ 
/*     */   public Long insertFundMoney(FundMoney fundMoney)
/*     */   {
/*  25 */     Validate.notNull(fundMoney, "when insert,fundMoney must not be null");
/*  26 */     return (Long)getSqlMapClientTemplate().insert("FUND_MONEY.insert", fundMoney);
/*     */   }
/*     */ 
/*     */   public void update(FundMoney record)
/*     */   {
/*  35 */     getSqlMapClientTemplate().update("FUND_MONEY.update", record);
/*     */   }
/*     */ 
/*     */   public FundMoney getByFundAccountWithMoneyType(String fundAccount, String moneyType)
/*     */   {
/*  46 */     Map map = new HashMap();
/*  47 */     map.put("fundAccount", fundAccount);
/*  48 */     map.put("moneyType", moneyType);
/*  49 */     return (FundMoney)getSqlMapClientTemplate().queryForObject("FUND_MONEY.get-by-fundAccount-with-moneyType", map);
/*     */   }
/*     */ 
/*     */   public List<FundMoney> getByFundAccount(String fundAccount)
/*     */   {
/*  60 */     return getSqlMapClientTemplate().queryForList("FUND_MONEY.get-by-fundAccount", fundAccount);
/*     */   }
/*     */ 
/*     */   public void updateCurrentBalance(String fundAccount, String moneyType, Long amount, String operator, Boolean isNeedUncome)
/*     */   {
/*  73 */     Map map = new HashMap();
/*  74 */     map.put("fundAccount", fundAccount);
/*  75 */     map.put("amount", amount);
/*  76 */     map.put("moneyType", moneyType);
/*  77 */     map.put("modifyId", operator);
/*  78 */     map.put("isNeedUncome", isNeedUncome);
/*     */ 
/*  80 */     getSqlMapClientTemplate().update("FUND_MONEY.updateBalance", map);
/*     */   }
/*     */ 
/*     */   public void writeOffCurrentBalance(String fundAccount, String moneyType, Long amount, Boolean isNeedUncome)
/*     */   {
/*     */   }
/*     */ 
/*     */   public void freezeBalance(String moneyType, String fundAccount, Long amount, String operator, String memo, boolean b)
/*     */   {
/* 106 */     Map map = new HashMap();
/* 107 */     map.put("fundAccount", fundAccount);
/* 108 */     map.put("amount", amount);
/* 109 */     map.put("moneyType", moneyType);
/* 110 */     map.put("operator", operator);
/* 111 */     map.put("memo", memo);
/* 112 */     if (b)
/* 113 */       getSqlMapClientTemplate().update("FUND_MONEY.freeze", map);
/*     */     else
/* 115 */       getSqlMapClientTemplate().update("FUND_MONEY.unfreeze", map);
/*     */   }
/*     */ 
/*     */   public void updateFundMoneyByfundAccount(FundMoney record)
/*     */   {
/* 121 */     getSqlMapClientTemplate().update("FUND_MONEY.updateFundMoneyByfundAccount", record);
/*     */   }
/*     */ 
/*     */   public List<FundMoney> getFundMoneyByAccount(String fundAccount)
/*     */   {
/* 127 */     if (StringUtil.isBlank(fundAccount))
/* 128 */       return null;
/* 129 */     return getSqlMapClientTemplate().queryForList("FUND_MONEY.get-by-fundAccount", fundAccount);
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\houchao\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.houchao.biz.dao.fund.ibatis.FundMoneyDAOImpl
 * JD-Core Version:    0.6.0
 */