/*    */ package com.hundsun.eclp.biz.dao.impl;
/*    */ 
/*    */ import com.hundsun.eclp.biz.dao.FuncRecheckDAO;
/*    */ import com.hundsun.eclp.biz.domain.auth.FuncRecheck;
/*    */ import com.hundsun.network.common.dao.BaseDAO;
/*    */ import java.util.List;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("funcCheckerDao")
/*    */ public class FuncRecheckDAOImpl extends BaseDAO
/*    */   implements FuncRecheckDAO
/*    */ {
/*    */   private static final String SQLMAP_SPACE = "FuncRecheck.";
/*    */ 
/*    */   public int deleteById(Long id)
/*    */   {
/* 16 */     return getSqlMapClientTemplate().delete("FuncRecheck.deleteByPrimaryKey", id);
/*    */   }
/*    */ 
/*    */   public Long insert(FuncRecheck record)
/*    */   {
/* 21 */     return (Long)getSqlMapClientTemplate().insert("FuncRecheck.insert", record);
/*    */   }
/*    */ 
/*    */   public List<FuncRecheck> selectAll()
/*    */   {
/* 27 */     return getSqlMapClientTemplate().queryForList("FuncRecheck.selectAll");
/*    */   }
/*    */ 
/*    */   public FuncRecheck selectById(Long id)
/*    */   {
/* 32 */     return (FuncRecheck)getSqlMapClientTemplate().queryForObject("FuncRecheck.selectByPrimaryKey", id);
/*    */   }
/*    */ 
/*    */   public int update(FuncRecheck record)
/*    */   {
/* 37 */     return getSqlMapClientTemplate().update("FuncRecheck.update", record);
/*    */   }
/*    */ 
/*    */   public List<FuncRecheck> selectByFuncCode(String funcCode)
/*    */   {
/* 42 */     return getSqlMapClientTemplate().queryForList("FuncRecheck.selectByFuncCode", funcCode);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.dao.impl.FuncRecheckDAOImpl
 * JD-Core Version:    0.6.0
 */