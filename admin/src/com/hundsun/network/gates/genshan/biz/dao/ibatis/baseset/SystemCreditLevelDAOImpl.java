/*    */ package com.hundsun.network.gates.genshan.biz.dao.ibatis.baseset;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.baseset.SystemCreditLevelDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.baseset.SystemCreditLevel;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.query.SystemCreditLevelQuery;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import java.util.List;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("systemCreditLevelDAO")
/*    */ public class SystemCreditLevelDAOImpl extends BaseDAO
/*    */   implements SystemCreditLevelDAO
/*    */ {
/*    */   public void selectPageList(SystemCreditLevelQuery query)
/*    */   {
/* 25 */     paginate(query, "SYSTEM_CREDIT_LEVEL.selectPageList-count", "SYSTEM_CREDIT_LEVEL.selectPageList");
/*    */   }
/*    */ 
/*    */   public List<SystemCreditLevel> selectAllList()
/*    */   {
/* 34 */     return getSqlMapClientTemplate().queryForList("SYSTEM_CREDIT_LEVEL.selectAllList");
/*    */   }
/*    */ 
/*    */   public Long insert(SystemCreditLevel record)
/*    */   {
/* 42 */     return (Long)getSqlMapClientTemplate().insert("SYSTEM_CREDIT_LEVEL.insert", record);
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKey(SystemCreditLevel record)
/*    */   {
/* 50 */     int rows = getSqlMapClientTemplate().update("SYSTEM_CREDIT_LEVEL.updateByPrimaryKey", record);
/* 51 */     return rows;
/*    */   }
/*    */ 
/*    */   public int updateBySelective(SystemCreditLevel record)
/*    */   {
/* 59 */     int rows = getSqlMapClientTemplate().update("SYSTEM_CREDIT_LEVEL.updateBySelective", record);
/* 60 */     return rows;
/*    */   }
/*    */ 
/*    */   public SystemCreditLevel selectByPrimaryKey(Long id)
/*    */   {
/* 69 */     SystemCreditLevel record = (SystemCreditLevel)getSqlMapClientTemplate().queryForObject("SYSTEM_CREDIT_LEVEL.selectByPrimaryKey", id);
/*    */ 
/* 71 */     return record;
/*    */   }
/*    */ 
/*    */   public SystemCreditLevel selectByCond(SystemCreditLevelQuery record)
/*    */   {
/* 80 */     return (SystemCreditLevel)getSqlMapClientTemplate().queryForObject("SYSTEM_CREDIT_LEVEL.selectByCond", record);
/*    */   }
/*    */ 
/*    */   public int checkIntegralRange(SystemCreditLevelQuery query)
/*    */   {
/* 88 */     return ((Integer)getSqlMapClientTemplate().queryForObject("SYSTEM_CREDIT_LEVEL.checkIntegralRange", query)).intValue();
/*    */   }
/*    */ 
/*    */   public int deleteByPrimaryKey(Long id)
/*    */   {
/* 97 */     int rows = getSqlMapClientTemplate().delete("SYSTEM_CREDIT_LEVEL.deleteByPrimaryKey", id);
/* 98 */     return rows;
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.ibatis.baseset.SystemCreditLevelDAOImpl
 * JD-Core Version:    0.6.0
 */