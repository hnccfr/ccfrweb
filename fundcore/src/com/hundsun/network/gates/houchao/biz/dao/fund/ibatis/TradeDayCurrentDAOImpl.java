/*    */ package com.hundsun.network.gates.houchao.biz.dao.fund.ibatis;
/*    */ 
/*    */ import com.hundsun.network.gates.houchao.biz.dao.fund.TradeDayCurrentDAO;
/*    */ import com.hundsun.network.gates.houchao.biz.domain.fund.TradeDayCurrent;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("tradeDayCurrentDAO")
/*    */ public class TradeDayCurrentDAOImpl extends BaseDAO
/*    */   implements TradeDayCurrentDAO
/*    */ {
/*    */   public int editTradeDayCurrent(TradeDayCurrent tradeDayCurrent)
/*    */   {
/* 18 */     return getSqlMapClientTemplate().update("TradeDayCurrent.editTradeDayCurrent", tradeDayCurrent);
/*    */   }
/*    */ 
/*    */   public TradeDayCurrent getTradeDayCurrent()
/*    */   {
/* 23 */     return (TradeDayCurrent)getSqlMapClientTemplate().queryForObject("TradeDayCurrent.getTradeDayCurrent");
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\houchao\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.houchao.biz.dao.fund.ibatis.TradeDayCurrentDAOImpl
 * JD-Core Version:    0.6.0
 */