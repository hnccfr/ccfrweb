/*    */ package com.hundsun.network.gates.genshan.biz.dao.ibatis.financing;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.financing.FinancingLogDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.financing.FinancingLog;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import java.util.List;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("financingLogDAO")
/*    */ public class FinancingLogDAOImpl extends BaseDAO
/*    */   implements FinancingLogDAO
/*    */ {
/*    */   public Integer insert(FinancingLog record)
/*    */   {
/* 19 */     return (Integer)getSqlMapClientTemplate().insert("FINANCING_LOG.insert", record);
/*    */   }
/*    */ 
/*    */   public List<FinancingLog> getByFinancingId(Long id)
/*    */   {
/* 25 */     return getSqlMapClientTemplate().queryForList("FINANCING_LOG.getByFinancingId", id);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.ibatis.financing.FinancingLogDAOImpl
 * JD-Core Version:    0.6.0
 */