/*    */ package com.hundsun.network.gates.wulin.biz.dao.ibatis.baseset;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.dao.baseset.BaseDayDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.baseset.BaseDay;
/*    */ import java.util.List;
/*    */ import java.util.Map;
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
/* 19 */     getSqlMapClientTemplate().insert("BASE_DAY.addBaseDay", entity);
/*    */   }
/*    */ 
/*    */   public void editBaseDay(BaseDay entity)
/*    */   {
/*    */   }
/*    */ 
/*    */   public List<BaseDay> getBaseDay(BaseDay entity)
/*    */   {
/* 29 */     return getSqlMapClientTemplate().queryForList("BASE_DAY.getBaseDay", entity);
/*    */   }
/*    */ 
/*    */   public void removeBaseDay(Long id)
/*    */   {
/*    */   }
/*    */ 
/*    */   public int removeBaseDayByYear(BaseDay entity)
/*    */   {
/* 38 */     return getSqlMapClientTemplate().delete("BASE_DAY.removeBaseDayByYear", entity);
/*    */   }
/*    */ 
/*    */   public BaseDay getCurrentBaseDay()
/*    */   {
/* 43 */     return (BaseDay)getSqlMapClientTemplate().queryForObject("BASE_DAY.getCurrentBaseDay");
/*    */   }
/*    */ 
/*    */   public BaseDay getNextBaseDay(Map<String, Object> paramMap)
/*    */   {
/* 49 */     return (BaseDay)getSqlMapClientTemplate().queryForObject("BASE_DAY.getNextBaseDay", paramMap);
/*    */   }
/*    */ 
/*    */   public BaseDay getPrevBaseDay(Map<String, Object> paramMap)
/*    */   {
/* 55 */     return (BaseDay)getSqlMapClientTemplate().queryForObject("BASE_DAY.getPrevBaseDay", paramMap);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.ibatis.baseset.BaseDayDAOImpl
 * JD-Core Version:    0.6.0
 */