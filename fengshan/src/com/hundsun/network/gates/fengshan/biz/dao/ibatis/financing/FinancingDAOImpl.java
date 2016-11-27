/*    */ package com.hundsun.network.gates.fengshan.biz.dao.ibatis.financing;
/*    */ 
/*    */ import com.hundsun.network.gates.fengshan.biz.dao.financing.FinancingDAO;
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.query.FinancingQuery;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("financingDAO")
/*    */ public class FinancingDAOImpl extends BaseDAO
/*    */   implements FinancingDAO
/*    */ {
/*    */   public void selectByQuery(FinancingQuery query)
/*    */   {
/* 17 */     paginate(query, "FINANCING.queryFinancingCount", "FINANCING.queryFinancing");
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.dao.ibatis.financing.FinancingDAOImpl
 * JD-Core Version:    0.6.0
 */