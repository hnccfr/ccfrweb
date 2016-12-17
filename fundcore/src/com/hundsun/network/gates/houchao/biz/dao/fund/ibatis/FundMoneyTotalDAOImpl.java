/*    */ package com.hundsun.network.gates.houchao.biz.dao.fund.ibatis;
/*    */ 
/*    */ import com.hundsun.network.gates.houchao.biz.dao.fund.FundMoneyTotalDAO;
/*    */ import com.hundsun.network.gates.houchao.biz.domain.fund.FundMoneyTotal;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import org.apache.commons.lang.Validate;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("fundMoneyTotalDAO")
/*    */ public class FundMoneyTotalDAOImpl extends BaseDAO
/*    */   implements FundMoneyTotalDAO
/*    */ {
/*    */   private static final String NAME_SPACE = "FundMoneyTotal.";
/*    */ 
/*    */   public Long insert(FundMoneyTotal fundMoneyTotal)
/*    */   {
/* 25 */     Validate.notNull(fundMoneyTotal, "when insert,fundMoneyTotal must not be null");
/* 26 */     return (Long)getSqlMapClientTemplate().insert("FundMoneyTotal.insert", fundMoneyTotal);
/*    */   }
/*    */ 
/*    */   public FundMoneyTotal queryByTransCode(String fundAccount, String subTransCode, String transDate)
/*    */   {
/* 37 */     Map map = new HashMap();
/* 38 */     map.put("fundAccount", fundAccount);
/* 39 */     map.put("transSubCode", subTransCode);
/* 40 */     map.put("transDate", transDate);
/* 41 */     Object fundMoneyTotal = getSqlMapClientTemplate().queryForObject("FundMoneyTotal.query", map);
/* 42 */     if (fundMoneyTotal != null) {
/* 43 */       return (FundMoneyTotal)fundMoneyTotal;
/*    */     }
/* 45 */     return null;
/*    */   }
/*    */ 
/*    */   public int update(FundMoneyTotal fundMoneyTotal)
/*    */   {
/* 56 */     if (fundMoneyTotal == null) {
/* 57 */       throw new NullPointerException("when updateById, fundMoneyTotal can't be null.");
/*    */     }
/* 59 */     return getSqlMapClientTemplate().update("FundMoneyTotal.update", fundMoneyTotal);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\houchao\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.houchao.biz.dao.fund.ibatis.FundMoneyTotalDAOImpl
 * JD-Core Version:    0.6.0
 */