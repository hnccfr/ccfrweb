/*     */ package com.hundsun.network.gates.wulin.biz.dao.ibatis.financing;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.dao.financing.FinancGoodsListDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.financing.FinancGoodsList;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.financing.FinancGoodsListCriteria;
/*     */ import java.util.List;
/*     */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*     */ 
/*     */ public class FinancGoodsListDAOImpl extends BaseDAO
/*     */   implements FinancGoodsListDAO
/*     */ {
/*     */   public int countByExample(FinancGoodsListCriteria example)
/*     */   {
/*  22 */     Integer count = (Integer)getSqlMapClientTemplate().queryForObject("FINANC_GOODS_LIST.countByExample", example);
/*  23 */     return count.intValue();
/*     */   }
/*     */ 
/*     */   public int deleteByExample(FinancGoodsListCriteria example)
/*     */   {
/*  30 */     int rows = getSqlMapClientTemplate().delete("FINANC_GOODS_LIST.deleteByExample", example);
/*  31 */     return rows;
/*     */   }
/*     */ 
/*     */   public int deleteByPrimaryKey(Long id)
/*     */   {
/*  38 */     FinancGoodsList _key = new FinancGoodsList();
/*  39 */     _key.setId(id);
/*  40 */     int rows = getSqlMapClientTemplate().delete("FINANC_GOODS_LIST.deleteByPrimaryKey", _key);
/*  41 */     return rows;
/*     */   }
/*     */ 
/*     */   public Long insert(FinancGoodsList record)
/*     */   {
/*  48 */     Object newKey = getSqlMapClientTemplate().insert("FINANC_GOODS_LIST.insert", record);
/*  49 */     return (Long)newKey;
/*     */   }
/*     */ 
/*     */   public Long insertSelective(FinancGoodsList record)
/*     */   {
/*  56 */     Object newKey = getSqlMapClientTemplate().insert("FINANC_GOODS_LIST.insertSelective", record);
/*  57 */     return (Long)newKey;
/*     */   }
/*     */ 
/*     */   public List<FinancGoodsList> selectByExample(FinancGoodsListCriteria example)
/*     */   {
/*  65 */     List list = getSqlMapClientTemplate().queryForList("FINANC_GOODS_LIST.selectByExample", example);
/*  66 */     return list;
/*     */   }
/*     */ 
/*     */   public FinancGoodsList selectByPrimaryKey(Long id)
/*     */   {
/*  73 */     FinancGoodsList _key = new FinancGoodsList();
/*  74 */     _key.setId(id);
/*  75 */     FinancGoodsList record = (FinancGoodsList)getSqlMapClientTemplate().queryForObject("FINANC_GOODS_LIST.selectByPrimaryKey", _key);
/*  76 */     return record;
/*     */   }
/*     */ 
/*     */   public int updateByExampleSelective(FinancGoodsList record, FinancGoodsListCriteria example)
/*     */   {
/*  83 */     UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
/*  84 */     int rows = getSqlMapClientTemplate().update("FINANC_GOODS_LIST.updateByExampleSelective", parms);
/*  85 */     return rows;
/*     */   }
/*     */ 
/*     */   public int updateByExample(FinancGoodsList record, FinancGoodsListCriteria example)
/*     */   {
/*  92 */     UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
/*  93 */     int rows = getSqlMapClientTemplate().update("FINANC_GOODS_LIST.updateByExample", parms);
/*  94 */     return rows;
/*     */   }
/*     */ 
/*     */   public int updateByPrimaryKeySelective(FinancGoodsList record)
/*     */   {
/* 101 */     int rows = getSqlMapClientTemplate().update("FINANC_GOODS_LIST.updateByPrimaryKeySelective", record);
/* 102 */     return rows;
/*     */   }
/*     */ 
/*     */   public int updateByPrimaryKey(FinancGoodsList record)
/*     */   {
/* 109 */     int rows = getSqlMapClientTemplate().update("FINANC_GOODS_LIST.updateByPrimaryKey", record);
/* 110 */     return rows;
/*     */   }
/*     */ 
/*     */   protected static class UpdateByExampleParms extends FinancGoodsListCriteria
/*     */   {
/*     */     private Object record;
/*     */ 
/*     */     public UpdateByExampleParms(Object record, FinancGoodsListCriteria example)
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
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.ibatis.financing.FinancGoodsListDAOImpl
 * JD-Core Version:    0.6.0
 */