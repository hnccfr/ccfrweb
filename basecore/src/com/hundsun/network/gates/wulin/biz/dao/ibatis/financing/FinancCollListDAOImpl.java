/*     */ package com.hundsun.network.gates.wulin.biz.dao.ibatis.financing;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.dao.financing.FinancCollListDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.financing.FinancCollList;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.financing.FinancCollListCriteria;
/*     */ import java.util.List;
/*     */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*     */ 
/*     */ public class FinancCollListDAOImpl extends BaseDAO
/*     */   implements FinancCollListDAO
/*     */ {
/*     */   public int countByExample(FinancCollListCriteria example)
/*     */   {
/*  22 */     Integer count = (Integer)getSqlMapClientTemplate().queryForObject("FINANC_COLL_LIST.countByExample", example);
/*  23 */     return count.intValue();
/*     */   }
/*     */ 
/*     */   public int deleteByExample(FinancCollListCriteria example)
/*     */   {
/*  30 */     int rows = getSqlMapClientTemplate().delete("FINANC_COLL_LIST.deleteByExample", example);
/*  31 */     return rows;
/*     */   }
/*     */ 
/*     */   public int deleteByPrimaryKey(Long id)
/*     */   {
/*  38 */     FinancCollList _key = new FinancCollList();
/*  39 */     _key.setId(id);
/*  40 */     int rows = getSqlMapClientTemplate().delete("FINANC_COLL_LIST.deleteByPrimaryKey", _key);
/*  41 */     return rows;
/*     */   }
/*     */ 
/*     */   public Long insert(FinancCollList record)
/*     */   {
/*  48 */     Object newKey = getSqlMapClientTemplate().insert("FINANC_COLL_LIST.insert", record);
/*  49 */     return (Long)newKey;
/*     */   }
/*     */ 
/*     */   public Long insertSelective(FinancCollList record)
/*     */   {
/*  56 */     Object newKey = getSqlMapClientTemplate().insert("FINANC_COLL_LIST.insertSelective", record);
/*  57 */     return (Long)newKey;
/*     */   }
/*     */ 
/*     */   public List<FinancCollList> selectByExample(FinancCollListCriteria example)
/*     */   {
/*  65 */     List list = getSqlMapClientTemplate().queryForList("FINANC_COLL_LIST.selectByExample", example);
/*  66 */     return list;
/*     */   }
/*     */ 
/*     */   public FinancCollList selectByPrimaryKey(Long id)
/*     */   {
/*  73 */     FinancCollList _key = new FinancCollList();
/*  74 */     _key.setId(id);
/*  75 */     FinancCollList record = (FinancCollList)getSqlMapClientTemplate().queryForObject("FINANC_COLL_LIST.selectByPrimaryKey", _key);
/*  76 */     return record;
/*     */   }
/*     */ 
/*     */   public int updateByExampleSelective(FinancCollList record, FinancCollListCriteria example)
/*     */   {
/*  83 */     UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
/*  84 */     int rows = getSqlMapClientTemplate().update("FINANC_COLL_LIST.updateByExampleSelective", parms);
/*  85 */     return rows;
/*     */   }
/*     */ 
/*     */   public int updateByExample(FinancCollList record, FinancCollListCriteria example)
/*     */   {
/*  92 */     UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
/*  93 */     int rows = getSqlMapClientTemplate().update("FINANC_COLL_LIST.updateByExample", parms);
/*  94 */     return rows;
/*     */   }
/*     */ 
/*     */   public int updateByPrimaryKeySelective(FinancCollList record)
/*     */   {
/* 101 */     int rows = getSqlMapClientTemplate().update("FINANC_COLL_LIST.updateByPrimaryKeySelective", record);
/* 102 */     return rows;
/*     */   }
/*     */ 
/*     */   public int updateByPrimaryKey(FinancCollList record)
/*     */   {
/* 109 */     int rows = getSqlMapClientTemplate().update("FINANC_COLL_LIST.updateByPrimaryKey", record);
/* 110 */     return rows;
/*     */   }
/*     */ 
/*     */   protected static class UpdateByExampleParms extends FinancCollListCriteria
/*     */   {
/*     */     private Object record;
/*     */ 
/*     */     public UpdateByExampleParms(Object record, FinancCollListCriteria example)
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
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.ibatis.financing.FinancCollListDAOImpl
 * JD-Core Version:    0.6.0
 */