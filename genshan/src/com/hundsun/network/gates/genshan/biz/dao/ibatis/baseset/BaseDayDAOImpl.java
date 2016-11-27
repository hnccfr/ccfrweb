/*    */ package com.hundsun.network.gates.genshan.biz.dao.ibatis.baseset;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.baseset.BaseDayDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.baseset.BaseDay;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import java.util.List;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("baseDayDAO")
/*    */ public class BaseDayDAOImpl extends BaseDAO
/*    */   implements BaseDayDAO
/*    */ {
/*    */   private static final String SQLMAP_SPACE = "BASE_DAY.";
/*    */ 
/*    */   public void addBaseDay(BaseDay entity)
/*    */   {
/* 18 */     getSqlMapClientTemplate().insert("BASE_DAY.addBaseDay", entity);
/*    */   }
/*    */ 
/*    */   public void editBaseDay(BaseDay entity)
/*    */   {
/*    */   }
/*    */ 
/*    */   public List<BaseDay> getBaseDay(BaseDay entity)
/*    */   {
/* 28 */     return getSqlMapClientTemplate().queryForList("BASE_DAY.getBaseDay", entity);
/*    */   }
/*    */ 
/*    */   public void removeBaseDay(Long id)
/*    */   {
/*    */   }
/*    */ 
/*    */   public int removeBaseDayByYear(BaseDay entity)
/*    */   {
/* 37 */     return getSqlMapClientTemplate().delete("BASE_DAY.removeBaseDayByYear", entity);
/*    */   }
/*    */ 
/*    */   public void addBaseDay(List<BaseDay> list)
/*    */   {
/* 42 */     batchInsert("BASE_DAY.addBaseDay", list);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.ibatis.baseset.BaseDayDAOImpl
 * JD-Core Version:    0.6.0
 */