/*     */ package com.hundsun.network.gates.wulin.biz.dao.ibatis.financing;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.dao.financing.FinancSysOpLogDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.financing.FinancSysOpLog;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.financing.FinancSysOpLogCriteria;
/*     */ import java.util.List;
/*     */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*     */ 
/*     */ public class FinancSysOpLogDAOImpl extends BaseDAO
/*     */   implements FinancSysOpLogDAO
/*     */ {
/*     */   public int countByExample(FinancSysOpLogCriteria example)
/*     */   {
/*  22 */     Integer count = (Integer)getSqlMapClientTemplate().queryForObject("FINANC_SYS_OP_LOG.countByExample", example);
/*  23 */     return count.intValue();
/*     */   }
/*     */ 
/*     */   public int deleteByExample(FinancSysOpLogCriteria example)
/*     */   {
/*  30 */     int rows = getSqlMapClientTemplate().delete("FINANC_SYS_OP_LOG.deleteByExample", example);
/*  31 */     return rows;
/*     */   }
/*     */ 
/*     */   public int deleteByPrimaryKey(Long id)
/*     */   {
/*  38 */     FinancSysOpLog _key = new FinancSysOpLog();
/*  39 */     _key.setId(id);
/*  40 */     int rows = getSqlMapClientTemplate().delete("FINANC_SYS_OP_LOG.deleteByPrimaryKey", _key);
/*  41 */     return rows;
/*     */   }
/*     */ 
/*     */   public Long insert(FinancSysOpLog record)
/*     */   {
/*  48 */     Object newKey = getSqlMapClientTemplate().insert("FINANC_SYS_OP_LOG.insert", record);
/*  49 */     return (Long)newKey;
/*     */   }
/*     */ 
/*     */   public Long insertSelective(FinancSysOpLog record)
/*     */   {
/*  56 */     Object newKey = getSqlMapClientTemplate().insert("FINANC_SYS_OP_LOG.insertSelective", record);
/*  57 */     return (Long)newKey;
/*     */   }
/*     */ 
/*     */   public List<FinancSysOpLog> selectByExample(FinancSysOpLogCriteria example)
/*     */   {
/*  65 */     List list = getSqlMapClientTemplate().queryForList("FINANC_SYS_OP_LOG.selectByExample", example);
/*  66 */     return list;
/*     */   }
/*     */ 
/*     */   public FinancSysOpLog selectByPrimaryKey(Long id)
/*     */   {
/*  73 */     FinancSysOpLog _key = new FinancSysOpLog();
/*  74 */     _key.setId(id);
/*  75 */     FinancSysOpLog record = (FinancSysOpLog)getSqlMapClientTemplate().queryForObject("FINANC_SYS_OP_LOG.selectByPrimaryKey", _key);
/*  76 */     return record;
/*     */   }
/*     */ 
/*     */   public int updateByExampleSelective(FinancSysOpLog record, FinancSysOpLogCriteria example)
/*     */   {
/*  83 */     UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
/*  84 */     int rows = getSqlMapClientTemplate().update("FINANC_SYS_OP_LOG.updateByExampleSelective", parms);
/*  85 */     return rows;
/*     */   }
/*     */ 
/*     */   public int updateByExample(FinancSysOpLog record, FinancSysOpLogCriteria example)
/*     */   {
/*  92 */     UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
/*  93 */     int rows = getSqlMapClientTemplate().update("FINANC_SYS_OP_LOG.updateByExample", parms);
/*  94 */     return rows;
/*     */   }
/*     */ 
/*     */   public int updateByPrimaryKeySelective(FinancSysOpLog record)
/*     */   {
/* 101 */     int rows = getSqlMapClientTemplate().update("FINANC_SYS_OP_LOG.updateByPrimaryKeySelective", record);
/* 102 */     return rows;
/*     */   }
/*     */ 
/*     */   public int updateByPrimaryKey(FinancSysOpLog record)
/*     */   {
/* 109 */     int rows = getSqlMapClientTemplate().update("FINANC_SYS_OP_LOG.updateByPrimaryKey", record);
/* 110 */     return rows;
/*     */   }
/*     */ 
/*     */   protected static class UpdateByExampleParms extends FinancSysOpLogCriteria
/*     */   {
/*     */     private Object record;
/*     */ 
/*     */     public UpdateByExampleParms(Object record, FinancSysOpLogCriteria example)
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
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.ibatis.financing.FinancSysOpLogDAOImpl
 * JD-Core Version:    0.6.0
 */