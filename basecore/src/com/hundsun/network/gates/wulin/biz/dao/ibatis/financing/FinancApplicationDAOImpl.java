/*     */ package com.hundsun.network.gates.wulin.biz.dao.ibatis.financing;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.dao.financing.FinancApplicationDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.financing.FinancApplication;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.financing.FinancApplicationCriteria;
/*     */ import java.util.List;
/*     */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*     */ 
/*     */ public class FinancApplicationDAOImpl extends BaseDAO
/*     */   implements FinancApplicationDAO
/*     */ {
/*     */   public int countByExample(FinancApplicationCriteria example)
/*     */   {
/*  22 */     Integer count = (Integer)getSqlMapClientTemplate().queryForObject("FINANC_APPLICATION.countByExample", example);
/*  23 */     return count.intValue();
/*     */   }
/*     */ 
/*     */   public int deleteByExample(FinancApplicationCriteria example)
/*     */   {
/*  30 */     int rows = getSqlMapClientTemplate().delete("FINANC_APPLICATION.deleteByExample", example);
/*  31 */     return rows;
/*     */   }
/*     */ 
/*     */   public int deleteByPrimaryKey(Long id)
/*     */   {
/*  38 */     FinancApplication _key = new FinancApplication();
/*  39 */     _key.setId(id);
/*  40 */     int rows = getSqlMapClientTemplate().delete("FINANC_APPLICATION.deleteByPrimaryKey", _key);
/*  41 */     return rows;
/*     */   }
/*     */ 
/*     */   public Long insert(FinancApplication record)
/*     */   {
/*  48 */     Object newKey = getSqlMapClientTemplate().insert("FINANC_APPLICATION.insert", record);
/*  49 */     return (Long)newKey;
/*     */   }
/*     */ 
/*     */   public Long insertSelective(FinancApplication record)
/*     */   {
/*  56 */     Object newKey = getSqlMapClientTemplate().insert("FINANC_APPLICATION.insertSelective", record);
/*  57 */     return (Long)newKey;
/*     */   }
/*     */ 
/*     */   public List<FinancApplication> selectByExample(FinancApplicationCriteria example)
/*     */   {
/*  65 */     List list = getSqlMapClientTemplate().queryForList("FINANC_APPLICATION.selectByExample", example);
/*  66 */     return list;
/*     */   }
/*     */ 
/*     */   public FinancApplication selectByPrimaryKey(Long id)
/*     */   {
/*  73 */     FinancApplication _key = new FinancApplication();
/*  74 */     _key.setId(id);
/*  75 */     FinancApplication record = (FinancApplication)getSqlMapClientTemplate().queryForObject("FINANC_APPLICATION.selectByPrimaryKey", _key);
/*  76 */     return record;
/*     */   }
/*     */ 
/*     */   public int updateByExampleSelective(FinancApplication record, FinancApplicationCriteria example)
/*     */   {
/*  83 */     UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
/*  84 */     int rows = getSqlMapClientTemplate().update("FINANC_APPLICATION.updateByExampleSelective", parms);
/*  85 */     return rows;
/*     */   }
/*     */ 
/*     */   public int updateByExample(FinancApplication record, FinancApplicationCriteria example)
/*     */   {
/*  92 */     UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
/*  93 */     int rows = getSqlMapClientTemplate().update("FINANC_APPLICATION.updateByExample", parms);
/*  94 */     return rows;
/*     */   }
/*     */ 
/*     */   public int updateByPrimaryKeySelective(FinancApplication record)
/*     */   {
/* 101 */     int rows = getSqlMapClientTemplate().update("FINANC_APPLICATION.updateByPrimaryKeySelective", record);
/* 102 */     return rows;
/*     */   }
/*     */ 
/*     */   public int updateByPrimaryKey(FinancApplication record)
/*     */   {
/* 109 */     int rows = getSqlMapClientTemplate().update("FINANC_APPLICATION.updateByPrimaryKey", record);
/* 110 */     return rows;
/*     */   }
/*     */ 
/*     */   protected static class UpdateByExampleParms extends FinancApplicationCriteria
/*     */   {
/*     */     private Object record;
/*     */ 
/*     */     public UpdateByExampleParms(Object record, FinancApplicationCriteria example)
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
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.ibatis.financing.FinancApplicationDAOImpl
 * JD-Core Version:    0.6.0
 */