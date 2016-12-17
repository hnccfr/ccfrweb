/*    */ package com.hundsun.network.gates.genshan.biz.dao.ibatis.baseset;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.baseset.BasePhaseDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.baseset.BasePhase;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.query.BasePhaseQuery;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("basePhaseDAO")
/*    */ public class BasePhaseDAOImpl extends BaseDAO
/*    */   implements BasePhaseDAO
/*    */ {
/*    */   private static final String SQLMAP_SPACE = "BASE_PHASE.";
/*    */ 
/*    */   public void insert(BasePhase record)
/*    */   {
/* 22 */     getSqlMapClientTemplate().insert("BASE_PHASE.insert", record);
/*    */   }
/*    */ 
/*    */   public void businessAdd(BasePhase record) {
/* 26 */     getSqlMapClientTemplate().insert("BASE_PHASE.businessAdd", record);
/*    */   }
/*    */ 
/*    */   public void queryPhase(BasePhaseQuery<BasePhase> query)
/*    */   {
/* 31 */     paginate(query, "BASE_PHASE.queryPhaseCount", "BASE_PHASE.queryPhase");
/*    */   }
/*    */ 
/*    */   public void logicalDeletePhase(BasePhase record)
/*    */   {
/* 36 */     getSqlMapClientTemplate().update("BASE_PHASE.logicalDeletePhase", record);
/*    */   }
/*    */ 
/*    */   public void physicalDeletePhase(BasePhase record)
/*    */   {
/* 41 */     getSqlMapClientTemplate().delete("BASE_PHASE.physicalDeletePhase", record);
/*    */   }
/*    */ 
/*    */   public BasePhase getValidPhase(Long uniqueMark)
/*    */   {
/* 46 */     Object obj = getSqlMapClientTemplate().queryForObject("BASE_PHASE.getValidPhase", uniqueMark);
/* 47 */     return null == obj ? null : (BasePhase)obj;
/*    */   }
/*    */ 
/*    */   public BasePhase getBasePhaseById(Long id) {
/* 51 */     Object obj = getSqlMapClientTemplate().queryForObject("BASE_PHASE.getBasePhaseById", id);
/* 52 */     return null == obj ? null : (BasePhase)obj;
/*    */   }
/*    */ 
/*    */   public void queryPhaseNext(BasePhaseQuery<BasePhase> query) {
/* 56 */     paginate(query, "BASE_PHASE.queryPhaseNextCount", "BASE_PHASE.queryPhaseNext");
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.ibatis.baseset.BasePhaseDAOImpl
 * JD-Core Version:    0.6.0
 */