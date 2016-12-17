/*    */ package com.hundsun.network.gates.fengshan.biz.dao.ibatis.project;
/*    */ 
/*    */ import com.hundsun.network.gates.fengshan.biz.dao.project.ProjectTypeDAO;
/*    */ import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectType;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("projectTypeDAO")
/*    */ public class ProjectTypeDAOImpl extends BaseDAO
/*    */   implements ProjectTypeDAO
/*    */ {
/*    */   public int deleteByPrimaryKey(Long id)
/*    */   {
/* 17 */     ProjectType _key = new ProjectType();
/* 18 */     _key.setId(id);
/* 19 */     int rows = getSqlMapClientTemplate().delete("ProjectType.deleteByPrimaryKey", _key);
/* 20 */     return rows;
/*    */   }
/*    */ 
/*    */   public ProjectType selectByPrimaryKey(Long id)
/*    */   {
/* 25 */     ProjectType _key = new ProjectType();
/* 26 */     _key.setId(id);
/* 27 */     ProjectType record = (ProjectType)getSqlMapClientTemplate().queryForObject("ProjectType.selectByPrimaryKey", _key);
/* 28 */     return record;
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKeySelective(ProjectType record)
/*    */   {
/* 33 */     int rows = getSqlMapClientTemplate().update("ProjectType.updateByPrimaryKeySelective", record);
/* 34 */     return rows;
/*    */   }
/*    */ 
/*    */   public List<ProjectType> queryProjectTypeAllChild(String code)
/*    */   {
/* 42 */     Map paras = new HashMap();
/* 43 */     paras.put("parCode", code);
/* 44 */     return getSqlMapClientTemplate().queryForList("ProjectType.queryProjectTypeAllChild", paras);
/*    */   }
/*    */ 
/*    */   public ProjectType getProjectTypeByCode(String code)
/*    */   {
/* 49 */     ProjectType _key = new ProjectType();
/* 50 */     _key.setCode(code);
/* 51 */     ProjectType record = (ProjectType)getSqlMapClientTemplate().queryForObject("ProjectType.getProjectTypeByCode", _key);
/* 52 */     return record;
/*    */   }
/*    */ 
/*    */   public void insert(ProjectType record)
/*    */   {
/* 57 */     getSqlMapClientTemplate().insert("ProjectType.insert", record);
/*    */   }
/*    */ 
/*    */   public int getProjectNumByObj(ProjectType record)
/*    */   {
/* 62 */     Integer count = (Integer)getSqlMapClientTemplate().queryForObject("ProjectType.queryProjectTypeCount", record);
/* 63 */     return count.intValue();
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.dao.ibatis.project.ProjectTypeDAOImpl
 * JD-Core Version:    0.6.0
 */