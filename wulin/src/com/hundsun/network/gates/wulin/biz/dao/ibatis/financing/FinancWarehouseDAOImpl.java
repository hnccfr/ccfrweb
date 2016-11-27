/*     */ package com.hundsun.network.gates.wulin.biz.dao.ibatis.financing;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.dao.financing.FinancWarehouseDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.financing.FinancWarehouse;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.financing.FinancWarehouseCriteria;
/*     */ import java.util.List;
/*     */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*     */ 
/*     */ public class FinancWarehouseDAOImpl extends BaseDAO
/*     */   implements FinancWarehouseDAO
/*     */ {
/*     */   public int countByExample(FinancWarehouseCriteria example)
/*     */   {
/*  22 */     Integer count = (Integer)getSqlMapClientTemplate().queryForObject("FINANC_WAREHOUSE.countByExample", example);
/*  23 */     return count.intValue();
/*     */   }
/*     */ 
/*     */   public int deleteByExample(FinancWarehouseCriteria example)
/*     */   {
/*  30 */     int rows = getSqlMapClientTemplate().delete("FINANC_WAREHOUSE.deleteByExample", example);
/*  31 */     return rows;
/*     */   }
/*     */ 
/*     */   public int deleteByPrimaryKey(Long id)
/*     */   {
/*  38 */     FinancWarehouse _key = new FinancWarehouse();
/*  39 */     _key.setId(id);
/*  40 */     int rows = getSqlMapClientTemplate().delete("FINANC_WAREHOUSE.deleteByPrimaryKey", _key);
/*  41 */     return rows;
/*     */   }
/*     */ 
/*     */   public Long insert(FinancWarehouse record)
/*     */   {
/*  48 */     Object newKey = getSqlMapClientTemplate().insert("FINANC_WAREHOUSE.insert", record);
/*  49 */     return (Long)newKey;
/*     */   }
/*     */ 
/*     */   public Long insertSelective(FinancWarehouse record)
/*     */   {
/*  56 */     Object newKey = getSqlMapClientTemplate().insert("FINANC_WAREHOUSE.insertSelective", record);
/*  57 */     return (Long)newKey;
/*     */   }
/*     */ 
/*     */   public List<FinancWarehouse> selectByExample(FinancWarehouseCriteria example)
/*     */   {
/*  65 */     List list = getSqlMapClientTemplate().queryForList("FINANC_WAREHOUSE.selectByExample", example);
/*  66 */     return list;
/*     */   }
/*     */ 
/*     */   public FinancWarehouse selectByPrimaryKey(Long id)
/*     */   {
/*  73 */     FinancWarehouse _key = new FinancWarehouse();
/*  74 */     _key.setId(id);
/*  75 */     FinancWarehouse record = (FinancWarehouse)getSqlMapClientTemplate().queryForObject("FINANC_WAREHOUSE.selectByPrimaryKey", _key);
/*  76 */     return record;
/*     */   }
/*     */ 
/*     */   public int updateByExampleSelective(FinancWarehouse record, FinancWarehouseCriteria example)
/*     */   {
/*  83 */     UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
/*  84 */     int rows = getSqlMapClientTemplate().update("FINANC_WAREHOUSE.updateByExampleSelective", parms);
/*  85 */     return rows;
/*     */   }
/*     */ 
/*     */   public int updateByExample(FinancWarehouse record, FinancWarehouseCriteria example)
/*     */   {
/*  92 */     UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
/*  93 */     int rows = getSqlMapClientTemplate().update("FINANC_WAREHOUSE.updateByExample", parms);
/*  94 */     return rows;
/*     */   }
/*     */ 
/*     */   public int updateByPrimaryKeySelective(FinancWarehouse record)
/*     */   {
/* 101 */     int rows = getSqlMapClientTemplate().update("FINANC_WAREHOUSE.updateByPrimaryKeySelective", record);
/* 102 */     return rows;
/*     */   }
/*     */ 
/*     */   public int updateByPrimaryKey(FinancWarehouse record)
/*     */   {
/* 109 */     int rows = getSqlMapClientTemplate().update("FINANC_WAREHOUSE.updateByPrimaryKey", record);
/* 110 */     return rows;
/*     */   }
/*     */ 
/*     */   protected static class UpdateByExampleParms extends FinancWarehouseCriteria
/*     */   {
/*     */     private Object record;
/*     */ 
/*     */     public UpdateByExampleParms(Object record, FinancWarehouseCriteria example)
/*     */     {
/* 120 */       super();
/* 121 */       this.record = record;
/*     */     }
/*     */ 
/*     */     public Object getRecord() {
/* 125 */       return this.record;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.ibatis.financing.FinancWarehouseDAOImpl
 * JD-Core Version:    0.6.0
 */