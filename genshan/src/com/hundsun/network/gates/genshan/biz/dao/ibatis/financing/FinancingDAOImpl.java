/*    */ package com.hundsun.network.gates.genshan.biz.dao.ibatis.financing;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.financing.FinancingDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.financing.Financing;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.query.FinancingQuery;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import java.util.Map;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("financingDAO")
/*    */ public class FinancingDAOImpl extends BaseDAO
/*    */   implements FinancingDAO
/*    */ {
/*    */   public Integer update(Financing record)
/*    */   {
/* 19 */     int rows = getSqlMapClientTemplate().update("FINANCING.updateById", record);
/* 20 */     return Integer.valueOf(rows);
/*    */   }
/*    */ 
/*    */   public Integer insert(Financing record) {
/* 24 */     return (Integer)getSqlMapClientTemplate().insert("FINANCING.insert", record);
/*    */   }
/*    */ 
/*    */   public void selectByQuery(FinancingQuery query)
/*    */   {
/* 29 */     paginate(query, "FINANCING.queryFinancingCount", "FINANCING.queryFinancing");
/*    */   }
/*    */ 
/*    */   public Long getNextId()
/*    */   {
/* 35 */     return (Long)getSqlMapClientTemplate().queryForObject("FINANCING.getNextId");
/*    */   }
/*    */ 
/*    */   public Financing selectById(Long id)
/*    */   {
/* 40 */     return (Financing)getSqlMapClientTemplate().queryForObject("FINANCING.getFinancingById", id);
/*    */   }
/*    */ 
/*    */   public Integer updateByMap(Map<String, Object> map)
/*    */   {
/* 45 */     int rows = getSqlMapClientTemplate().update("FINANCING.updateByMap", map);
/* 46 */     return Integer.valueOf(rows);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.ibatis.financing.FinancingDAOImpl
 * JD-Core Version:    0.6.0
 */