/*    */ package com.hundsun.network.gates.wulin.biz.dao.ibatis.baseset;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.dao.baseset.SystemCreditLevelDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.baseset.SystemCreditLevel;
/*    */ import java.util.List;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("systemCreditLevelDAO")
/*    */ public class SystemCreditLevelDAOImpl extends BaseDAO
/*    */   implements SystemCreditLevelDAO
/*    */ {
/*    */   public List<SystemCreditLevel> selectAllList()
/*    */   {
/* 25 */     return getSqlMapClientTemplate().queryForList("SYSTEM_CREDIT_LEVEL.selectAllList");
/*    */   }
/*    */ 
/*    */   public SystemCreditLevel selectByCreditLevel(String creditLevel)
/*    */   {
/* 34 */     return (SystemCreditLevel)getSqlMapClientTemplate().queryForObject("SYSTEM_CREDIT_LEVEL.selectByCreditLevel", creditLevel);
/*    */   }
/*    */ 
/*    */   public SystemCreditLevel selectInitCreditLevel()
/*    */   {
/* 43 */     return (SystemCreditLevel)getSqlMapClientTemplate().queryForObject("SYSTEM_CREDIT_LEVEL.selectInitCreditLevel");
/*    */   }
/*    */ 
/*    */   public SystemCreditLevel calcCreditLevel(Long integral)
/*    */   {
/* 52 */     return (SystemCreditLevel)getSqlMapClientTemplate().queryForObject("SYSTEM_CREDIT_LEVEL.calcCreditLevel", integral);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.ibatis.baseset.SystemCreditLevelDAOImpl
 * JD-Core Version:    0.6.0
 */