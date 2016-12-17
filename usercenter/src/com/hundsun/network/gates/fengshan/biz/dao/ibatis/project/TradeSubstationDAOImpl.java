/*    */ package com.hundsun.network.gates.fengshan.biz.dao.ibatis.project;
/*    */ 
/*    */ import com.hundsun.network.gates.fengshan.biz.dao.project.TradeSubstationDAO;
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.project.TradeSubstation;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import java.util.List;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("tradeSubstationDAO")
/*    */ public class TradeSubstationDAOImpl extends BaseDAO
/*    */   implements TradeSubstationDAO
/*    */ {
/*    */   public List<TradeSubstation> selectAllSubstationList()
/*    */   {
/* 26 */     return getSqlMapClientTemplate().queryForList("TradeSubstation.selectAllSubstationList");
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.dao.ibatis.project.TradeSubstationDAOImpl
 * JD-Core Version:    0.6.0
 */