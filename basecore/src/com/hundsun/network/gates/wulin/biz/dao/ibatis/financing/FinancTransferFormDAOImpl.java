/*     */ package com.hundsun.network.gates.wulin.biz.dao.ibatis.financing;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.dao.financing.FinancTransferFormDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.financing.FinancTransferForm;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.financing.FinancTransferFormCriteria;
/*     */ import java.util.List;
/*     */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*     */ import org.springframework.stereotype.Repository;
/*     */ 
/*     */ @Repository("financTransferFormDAO")
/*     */ public class FinancTransferFormDAOImpl extends BaseDAO
/*     */   implements FinancTransferFormDAO
/*     */ {
/*     */   public int countByExample(FinancTransferFormCriteria example)
/*     */   {
/*  26 */     Integer count = (Integer)getSqlMapClientTemplate().queryForObject("FINANC_TRANSFER_FORM.countByExample", example);
/*  27 */     return count.intValue();
/*     */   }
/*     */ 
/*     */   public int deleteByExample(FinancTransferFormCriteria example)
/*     */   {
/*  34 */     int rows = getSqlMapClientTemplate().delete("FINANC_TRANSFER_FORM.deleteByExample", example);
/*  35 */     return rows;
/*     */   }
/*     */ 
/*     */   public int deleteByPrimaryKey(Long id)
/*     */   {
/*  42 */     FinancTransferForm _key = new FinancTransferForm();
/*  43 */     _key.setId(id);
/*  44 */     int rows = getSqlMapClientTemplate().delete("FINANC_TRANSFER_FORM.deleteByPrimaryKey", _key);
/*  45 */     return rows;
/*     */   }
/*     */ 
/*     */   public Long insert(FinancTransferForm record)
/*     */   {
/*  52 */     Object newKey = getSqlMapClientTemplate().insert("FINANC_TRANSFER_FORM.insert", record);
/*  53 */     return (Long)newKey;
/*     */   }
/*     */ 
/*     */   public Long insertSelective(FinancTransferForm record)
/*     */   {
/*  60 */     Object newKey = getSqlMapClientTemplate().insert("FINANC_TRANSFER_FORM.insertSelective", record);
/*  61 */     return (Long)newKey;
/*     */   }
/*     */ 
/*     */   public List<FinancTransferForm> selectByExample(FinancTransferFormCriteria example)
/*     */   {
/*  69 */     List list = getSqlMapClientTemplate().queryForList("FINANC_TRANSFER_FORM.selectByExample", example);
/*  70 */     return list;
/*     */   }
/*     */ 
/*     */   public FinancTransferForm selectByPrimaryKey(Long id)
/*     */   {
/*  77 */     FinancTransferForm _key = new FinancTransferForm();
/*  78 */     _key.setId(id);
/*  79 */     FinancTransferForm record = (FinancTransferForm)getSqlMapClientTemplate().queryForObject("FINANC_TRANSFER_FORM.selectByPrimaryKey", _key);
/*  80 */     return record;
/*     */   }
/*     */ 
/*     */   public int updateByExampleSelective(FinancTransferForm record, FinancTransferFormCriteria example)
/*     */   {
/*  87 */     UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
/*  88 */     int rows = getSqlMapClientTemplate().update("FINANC_TRANSFER_FORM.updateByExampleSelective", parms);
/*  89 */     return rows;
/*     */   }
/*     */ 
/*     */   public int updateByExample(FinancTransferForm record, FinancTransferFormCriteria example)
/*     */   {
/*  96 */     UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
/*  97 */     int rows = getSqlMapClientTemplate().update("FINANC_TRANSFER_FORM.updateByExample", parms);
/*  98 */     return rows;
/*     */   }
/*     */ 
/*     */   public int updateByPrimaryKeySelective(FinancTransferForm record)
/*     */   {
/* 105 */     int rows = getSqlMapClientTemplate().update("FINANC_TRANSFER_FORM.updateByPrimaryKeySelective", record);
/* 106 */     return rows;
/*     */   }
/*     */ 
/*     */   public int updateByPrimaryKey(FinancTransferForm record)
/*     */   {
/* 113 */     int rows = getSqlMapClientTemplate().update("FINANC_TRANSFER_FORM.updateByPrimaryKey", record);
/* 114 */     return rows;
/*     */   }
/*     */ 
/*     */   protected static class UpdateByExampleParms extends FinancTransferFormCriteria
/*     */   {
/*     */     private Object record;
/*     */ 
/*     */     public UpdateByExampleParms(Object record, FinancTransferFormCriteria example)
/*     */     {
/* 124 */       super();
/* 125 */       this.record = record;
/*     */     }
/*     */ 
/*     */     public Object getRecord() {
/* 129 */       return this.record;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.ibatis.financing.FinancTransferFormDAOImpl
 * JD-Core Version:    0.6.0
 */