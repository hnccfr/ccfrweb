/*     */ package com.hundsun.network.gates.wulin.biz.dao.ibatis.financing;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.dao.financing.FinancResourcesDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.financing.FinancResources;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.financing.FinancResourcesCriteria;
/*     */ import java.util.List;
/*     */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*     */ 
/*     */ public class FinancResourcesDAOImpl extends BaseDAO
/*     */   implements FinancResourcesDAO
/*     */ {
/*     */   public int countByExample(FinancResourcesCriteria example)
/*     */   {
/*  22 */     Integer count = (Integer)getSqlMapClientTemplate().queryForObject("FINANC_RESOURCES.countByExample", example);
/*  23 */     return count.intValue();
/*     */   }
/*     */ 
/*     */   public int deleteByExample(FinancResourcesCriteria example)
/*     */   {
/*  30 */     int rows = getSqlMapClientTemplate().delete("FINANC_RESOURCES.deleteByExample", example);
/*  31 */     return rows;
/*     */   }
/*     */ 
/*     */   public int deleteByPrimaryKey(Long id)
/*     */   {
/*  38 */     FinancResources _key = new FinancResources();
/*  39 */     _key.setId(id);
/*  40 */     int rows = getSqlMapClientTemplate().delete("FINANC_RESOURCES.deleteByPrimaryKey", _key);
/*  41 */     return rows;
/*     */   }
/*     */ 
/*     */   public Long insert(FinancResources record)
/*     */   {
/*  48 */     Object newKey = getSqlMapClientTemplate().insert("FINANC_RESOURCES.insert", record);
/*  49 */     return (Long)newKey;
/*     */   }
/*     */ 
/*     */   public Long insertSelective(FinancResources record)
/*     */   {
/*  56 */     Object newKey = getSqlMapClientTemplate().insert("FINANC_RESOURCES.insertSelective", record);
/*  57 */     return (Long)newKey;
/*     */   }
/*     */ 
/*     */   public List<FinancResources> selectByExample(FinancResourcesCriteria example)
/*     */   {
/*  65 */     List list = getSqlMapClientTemplate().queryForList("FINANC_RESOURCES.selectByExample", example);
/*  66 */     return list;
/*     */   }
/*     */ 
/*     */   public FinancResources selectByPrimaryKey(Long id)
/*     */   {
/*  73 */     FinancResources _key = new FinancResources();
/*  74 */     _key.setId(id);
/*  75 */     FinancResources record = (FinancResources)getSqlMapClientTemplate().queryForObject("FINANC_RESOURCES.selectByPrimaryKey", _key);
/*  76 */     return record;
/*     */   }
/*     */ 
/*     */   public int updateByExampleSelective(FinancResources record, FinancResourcesCriteria example)
/*     */   {
/*  83 */     UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
/*  84 */     int rows = getSqlMapClientTemplate().update("FINANC_RESOURCES.updateByExampleSelective", parms);
/*  85 */     return rows;
/*     */   }
/*     */ 
/*     */   public int updateByExample(FinancResources record, FinancResourcesCriteria example)
/*     */   {
/*  92 */     UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
/*  93 */     int rows = getSqlMapClientTemplate().update("FINANC_RESOURCES.updateByExample", parms);
/*  94 */     return rows;
/*     */   }
/*     */ 
/*     */   public int updateByPrimaryKeySelective(FinancResources record)
/*     */   {
/* 101 */     int rows = getSqlMapClientTemplate().update("FINANC_RESOURCES.updateByPrimaryKeySelective", record);
/* 102 */     return rows;
/*     */   }
/*     */ 
/*     */   public int updateByPrimaryKey(FinancResources record)
/*     */   {
/* 109 */     int rows = getSqlMapClientTemplate().update("FINANC_RESOURCES.updateByPrimaryKey", record);
/* 110 */     return rows;
/*     */   }
/*     */ 
/*     */   protected static class UpdateByExampleParms extends FinancResourcesCriteria
/*     */   {
/*     */     private Object record;
/*     */ 
/*     */     public UpdateByExampleParms(Object record, FinancResourcesCriteria example)
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
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.ibatis.financing.FinancResourcesDAOImpl
 * JD-Core Version:    0.6.0
 */