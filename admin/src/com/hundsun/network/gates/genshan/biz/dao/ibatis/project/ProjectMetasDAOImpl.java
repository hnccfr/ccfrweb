/*    */ package com.hundsun.network.gates.genshan.biz.dao.ibatis.project;
/*    */ 
/*    */ import com.hundsun.network.gates.genshan.biz.dao.project.ProjectMetasDAO;
/*    */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectMetas;
/*    */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository("projectMetasDAO")
/*    */ public class ProjectMetasDAOImpl extends BaseDAO
/*    */   implements ProjectMetasDAO
/*    */ {
/*    */   public int deleteByPrimaryKey(Long id)
/*    */   {
/* 17 */     return 0;
/*    */   }
/*    */ 
/*    */   public void insert(ProjectMetas record)
/*    */   {
/*    */   }
/*    */ 
/*    */   public void insertSelective(ProjectMetas record)
/*    */   {
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKeySelective(ProjectMetas record)
/*    */   {
/* 30 */     return 0;
/*    */   }
/*    */ 
/*    */   public int updateByPrimaryKey(ProjectMetas record)
/*    */   {
/* 35 */     return 0;
/*    */   }
/*    */ 
/*    */   public List<ProjectMetas> selectByProjectId(Long projectId)
/*    */   {
/* 41 */     return getSqlMapClientTemplate().queryForList("PROJECT_METAS.selectByProjectId", projectId);
/*    */   }
/*    */ 
/*    */   public String selectOneMetaValue(ProjectMetas projectMetas)
/*    */   {
/* 47 */     return (String)getSqlMapClientTemplate().queryForObject("PROJECT_METAS.selectMetaValue", projectMetas);
/*    */   }
/*    */ 
/*    */   public List<ProjectMetas> getMetasByProjectIdAndMetaGroup(Long projectId, String metaGroup)
/*    */   {
/* 60 */     HashMap map = new HashMap();
/* 61 */     map.put("projectId", projectId);
/* 62 */     map.put("metaGroup", metaGroup);
/* 63 */     return getSqlMapClientTemplate().queryForList("PROJECT_METAS.selectByProjectIdAndMetaGroup", map);
/*    */   }
/*    */ 
/*    */   public List<ProjectMetas> getProjectMetasByProId(Long projectListingId)
/*    */   {
/* 70 */     return getSqlMapClientTemplate().queryForList("PROJECT_METAS.getProjectMetasByProId", projectListingId);
/*    */   }
/*    */ 
/*    */   public Integer selectNumByProjectId(Long projectId)
/*    */   {
/* 84 */     return (Integer)getSqlMapClientTemplate().queryForObject("PROJECT_METAS.selectBeforeBidStatrdTime", projectId);
/*    */   }
/*    */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.ibatis.project.ProjectMetasDAOImpl
 * JD-Core Version:    0.6.0
 */