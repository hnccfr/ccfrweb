/*    */ package com.hundsun.network.gates.houchao.biz.dao.fund.ibatis;
/*    */ 
/*    */ import com.hundsun.network.gates.houchao.biz.dao.fund.FundMoneyTotalHisDAO;
/*    */ import com.hundsun.network.gates.houchao.biz.domain.fund.FundMoneyTotalHis;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("fundMoneyTotalHisDAO")
/*    */ public class FundMoneyTotalHisDAOImpl extends BaseDAO
/*    */   implements FundMoneyTotalHisDAO
/*    */ {
/*    */   private static final String NAME_SPACE = "FundMoneyTotalHis.";
/*    */ 
/*    */   public List<FundMoneyTotalHis> queryByFundMoneyHisWithTradeDate(String fundAccount, String tradeDate)
/*    */   {
/* 45 */     List list = new ArrayList();
/*    */ 
/* 47 */     Map map = new HashMap();
/* 48 */     map.put("fundAccount", fundAccount);
/* 49 */     map.put("tradeDate", tradeDate);
/*    */ 
/* 51 */     list = getSqlMapClientTemplate().queryForList("FundMoneyTotalHis.QUERY-BY-FUNDMONEYHIS-WITH-TRADEDATE", map);
/* 52 */     return list;
/*    */   }
/*    */ 
/*    */   public List<FundMoneyTotalHis> queryByFundMoneyTotalHisWithTradeDate(String fundAccount, List<String> tradeDateList)
/*    */   {
/* 64 */     List list = new ArrayList();
/*    */ 
/* 66 */     Map map = new HashMap();
/* 67 */     map.put("fundAccount", fundAccount);
/* 68 */     map.put("tradeDateList", tradeDateList);
/*    */ 
/* 70 */     list = getSqlMapClientTemplate().queryForList("FundMoneyTotalHis.QUERY-BY-FUNDMONEYTOTALHIS-WITH-TRADEDATE", map);
/* 71 */     return list;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\houchao\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.houchao.biz.dao.fund.ibatis.FundMoneyTotalHisDAOImpl
 * JD-Core Version:    0.6.0
 */