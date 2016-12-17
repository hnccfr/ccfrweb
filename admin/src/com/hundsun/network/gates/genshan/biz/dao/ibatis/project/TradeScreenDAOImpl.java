/*    */ package com.hundsun.network.gates.genshan.biz.dao.ibatis.project;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.project.TradeScreenDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.project.TradeScreen;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.query.TradeScreenQuery;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("tradeScreenDAO")
/*    */ public class TradeScreenDAOImpl extends BaseDAO
/*    */   implements TradeScreenDAO
/*    */ {
/*    */   public void paginate(TradeScreenQuery<TradeScreen> page)
/*    */   {
/* 15 */     paginate(page, "TRADE_SCREEN.getTotalCount", "TRADE_SCREEN.getPaginated");
/*    */   }
/*    */ 
/*    */   public TradeScreen getTradeScreenById(Long id)
/*    */   {
/* 20 */     return (TradeScreen)getSqlMapClientTemplate().queryForObject("TRADE_SCREEN.getTradeScreenById", id);
/*    */   }
/*    */ 
/*    */   public void delTradeScreenById(Long id)
/*    */   {
/* 25 */     getSqlMapClientTemplate().delete("TRADE_SCREEN.deleteById", id);
/*    */   }
/*    */ 
/*    */   public Long insert(TradeScreen screenDiy)
/*    */   {
/* 30 */     return (Long)getSqlMapClientTemplate().insert("TRADE_SCREEN.addScreenDiy", screenDiy);
/*    */   }
/*    */ 
/*    */   public Integer edit(TradeScreen screenDiy)
/*    */   {
/* 35 */     return Integer.valueOf(getSqlMapClientTemplate().update("TRADE_SCREEN.editScreenDiy", screenDiy));
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.ibatis.project.TradeScreenDAOImpl
 * JD-Core Version:    0.6.0
 */