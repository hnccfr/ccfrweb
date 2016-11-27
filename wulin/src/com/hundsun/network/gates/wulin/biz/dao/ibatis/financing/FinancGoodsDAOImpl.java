/*     */ package com.hundsun.network.gates.wulin.biz.dao.ibatis.financing;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.dao.financing.FinancGoodsDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.financing.FinancGoods;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.financing.FinancGoodsCriteria;
/*     */ import java.util.List;
/*     */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*     */ 
/*     */ public class FinancGoodsDAOImpl extends BaseDAO
/*     */   implements FinancGoodsDAO
/*     */ {
/*     */   public int countByExample(FinancGoodsCriteria example)
/*     */   {
/*  22 */     Integer count = (Integer)getSqlMapClientTemplate().queryForObject("FINANC_GOODS.countByExample", example);
/*  23 */     return count.intValue();
/*     */   }
/*     */ 
/*     */   public int deleteByExample(FinancGoodsCriteria example)
/*     */   {
/*  30 */     int rows = getSqlMapClientTemplate().delete("FINANC_GOODS.deleteByExample", example);
/*  31 */     return rows;
/*     */   }
/*     */ 
/*     */   public int deleteByPrimaryKey(Long id)
/*     */   {
/*  38 */     FinancGoods _key = new FinancGoods();
/*  39 */     _key.setId(id);
/*  40 */     int rows = getSqlMapClientTemplate().delete("FINANC_GOODS.deleteByPrimaryKey", _key);
/*  41 */     return rows;
/*     */   }
/*     */ 
/*     */   public Long insert(FinancGoods record)
/*     */   {
/*  48 */     Object newKey = getSqlMapClientTemplate().insert("FINANC_GOODS.insert", record);
/*  49 */     return (Long)newKey;
/*     */   }
/*     */ 
/*     */   public Long insertSelective(FinancGoods record)
/*     */   {
/*  56 */     Object newKey = getSqlMapClientTemplate().insert("FINANC_GOODS.insertSelective", record);
/*  57 */     return (Long)newKey;
/*     */   }
/*     */ 
/*     */   public List<FinancGoods> selectByExampleWithBLOBs(FinancGoodsCriteria example)
/*     */   {
/*  65 */     List list = getSqlMapClientTemplate().queryForList("FINANC_GOODS.selectByExampleWithBLOBs", example);
/*  66 */     return list;
/*     */   }
/*     */ 
/*     */   public List<FinancGoods> selectByExampleWithoutBLOBs(FinancGoodsCriteria example)
/*     */   {
/*  74 */     List list = getSqlMapClientTemplate().queryForList("FINANC_GOODS.selectByExample", example);
/*  75 */     return list;
/*     */   }
/*     */ 
/*     */   public FinancGoods selectByPrimaryKey(Long id)
/*     */   {
/*  82 */     FinancGoods _key = new FinancGoods();
/*  83 */     _key.setId(id);
/*  84 */     FinancGoods record = (FinancGoods)getSqlMapClientTemplate().queryForObject("FINANC_GOODS.selectByPrimaryKey", _key);
/*  85 */     return record;
/*     */   }
/*     */ 
/*     */   public int updateByExampleSelective(FinancGoods record, FinancGoodsCriteria example)
/*     */   {
/*  92 */     UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
/*  93 */     int rows = getSqlMapClientTemplate().update("FINANC_GOODS.updateByExampleSelective", parms);
/*  94 */     return rows;
/*     */   }
/*     */ 
/*     */   public int updateByExampleWithBLOBs(FinancGoods record, FinancGoodsCriteria example)
/*     */   {
/* 101 */     UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
/* 102 */     int rows = getSqlMapClientTemplate().update("FINANC_GOODS.updateByExampleWithBLOBs", parms);
/* 103 */     return rows;
/*     */   }
/*     */ 
/*     */   public int updateByExampleWithoutBLOBs(FinancGoods record, FinancGoodsCriteria example)
/*     */   {
/* 110 */     UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
/* 111 */     int rows = getSqlMapClientTemplate().update("FINANC_GOODS.updateByExample", parms);
/* 112 */     return rows;
/*     */   }
/*     */ 
/*     */   public int updateByPrimaryKeySelective(FinancGoods record)
/*     */   {
/* 119 */     int rows = getSqlMapClientTemplate().update("FINANC_GOODS.updateByPrimaryKeySelective", record);
/* 120 */     return rows;
/*     */   }
/*     */ 
/*     */   public int updateByPrimaryKeyWithBLOBs(FinancGoods record)
/*     */   {
/* 127 */     int rows = getSqlMapClientTemplate().update("FINANC_GOODS.updateByPrimaryKeyWithBLOBs", record);
/* 128 */     return rows;
/*     */   }
/*     */ 
/*     */   public int updateByPrimaryKeyWithoutBLOBs(FinancGoods record)
/*     */   {
/* 135 */     int rows = getSqlMapClientTemplate().update("FINANC_GOODS.updateByPrimaryKey", record);
/* 136 */     return rows;
/*     */   }
/*     */ 
/*     */   protected static class UpdateByExampleParms extends FinancGoodsCriteria
/*     */   {
/*     */     private Object record;
/*     */ 
/*     */     public UpdateByExampleParms(Object record, FinancGoodsCriteria example)
/*     */     {
/* 146 */       super();
/* 147 */       this.record = record;
/*     */     }
/*     */ 
/*     */     public Object getRecord() {
/* 151 */       return this.record;
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.ibatis.financing.FinancGoodsDAOImpl
 * JD-Core Version:    0.6.0
 */