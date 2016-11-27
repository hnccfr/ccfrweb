/*    */ package com.hundsun.network.gates.wulin.biz.dao.ibatis.project;
/*    */ 
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.dao.project.ProjectMetasDAO;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.project.ProjectMetas;
/*    */ import com.hundsun.network.gates.wulin.biz.domain.query.ProjectMetasQuery;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("ProjectMetasDAO")
/*    */ public class ProjectMetasDAOImpl extends BaseDAO
/*    */   implements ProjectMetasDAO
/*    */ {
/*    */   public int deleteByPrimaryKey(Long id)
/*    */   {
/* 18 */     return 0;
/*    */   }
/*    */ 
/*    */   public void insert(ProjectMetas record) {
/* 22 */     getSqlMapClientTemplate().insert("PROJECT_METAS.insert", record);
/*    */   }
/*    */ 
/*    */   public void insert(List<ProjectMetas> list)
/*    */   {
/* 30 */     batchInsert("PROJECT_METAS.insert", list);
/*    */   }
/*    */ 
/*    */   public void insertSelective(ProjectMetas record) {
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKeySelective(ProjectMetas record) {
/* 37 */     return 0;
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKey(ProjectMetas record) {
/* 41 */     int rows = getSqlMapClientTemplate().update("PROJECT_METAS.updateByPrimaryKey", record);
/* 42 */     return rows;
/*    */   }
/*    */ 
/*    */   public ProjectMetas getProjectMetasByProIDAndKey(Long projectId, String metaKey)
/*    */   {
/* 51 */     Map map = new HashMap();
/* 52 */     map.put("projectId", projectId);
/* 53 */     map.put("metaKey", metaKey);
/* 54 */     return (ProjectMetas)getSqlMapClientTemplate().queryForObject("PROJECT_METAS.getProjectMetasByProIDAndKey", map);
/*    */   }
/*    */ 
/*    */   public List<ProjectMetas> selectProjectMetasByObj(ProjectMetasQuery metasQuery)
/*    */   {
/* 60 */     return getSqlMapClientTemplate().queryForList("PROJECT_METAS.selectProjectMetasByObj", metasQuery);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.ibatis.project.ProjectMetasDAOImpl
 * JD-Core Version:    0.6.0
 */