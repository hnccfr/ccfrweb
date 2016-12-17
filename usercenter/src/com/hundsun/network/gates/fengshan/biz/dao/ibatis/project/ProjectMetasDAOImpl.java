/*     */ package com.hundsun.network.gates.fengshan.biz.dao.ibatis.project;
/*     */ 
/*     */ import com.hundsun.network.gates.fengshan.biz.dao.project.ProjectMetasDAO;
/*     */ import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectMetas;
/*     */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*     */ import org.springframework.stereotype.Repository;
/*     */ 
/*     */ @Repository("projectMetasDAO")
/*     */ public class ProjectMetasDAOImpl extends BaseDAO
/*     */   implements ProjectMetasDAO
/*     */ {
/*     */   public int deleteByPrimaryKey(Long id)
/*     */   {
/*  17 */     return 0;
/*     */   }
/*     */ 
/*     */   public void insert(ProjectMetas record)
/*     */   {
/*     */   }
/*     */ 
/*     */   public void insertSelective(ProjectMetas record)
/*     */   {
/*     */   }
/*     */ 
/*     */   public int updateByPrimaryKeySelective(ProjectMetas record)
/*     */   {
/*  30 */     return 0;
/*     */   }
/*     */ 
/*     */   public int updateByPrimaryKey(ProjectMetas record)
/*     */   {
/*  35 */     return 0;
/*     */   }
/*     */ 
/*     */   public List<ProjectMetas> selectByProjectId(Long projectId)
/*     */   {
/*  42 */     return getSqlMapClientTemplate().queryForList("PROJECT_METAS.selectByProjectId", projectId);
/*     */   }
/*     */ 
/*     */   public String selectMetaValue(ProjectMetas projectMetas)
/*     */   {
/*  48 */     return (String)getSqlMapClientTemplate().queryForObject("PROJECT_METAS.selectMetaValue", projectMetas);
/*     */   }
/*     */ 
/*     */   public List<ProjectMetas> getMetasByProjectIdAndMetaGroup(Long projectId, String metaGroup)
/*     */   {
/*  61 */     HashMap map = new HashMap();
/*  62 */     map.put("projectId", projectId);
/*  63 */     map.put("metaGroup", metaGroup);
/*  64 */     return getSqlMapClientTemplate().queryForList("PROJECT_METAS.selectByProjectIdAndMetaGroup", map);
/*     */   }
/*     */ 
/*     */   public Integer selectNumByProjectId(Long projectId)
/*     */   {
/*  77 */     return (Integer)getSqlMapClientTemplate().queryForObject("PROJECT_METAS.selectBeforeBidStatrdTime", projectId);
/*     */   }
/*     */ 
/*     */   public Integer selectAfterApplyStartTime(Long projectId)
/*     */   {
/*  89 */     return (Integer)getSqlMapClientTemplate().queryForObject("PROJECT_METAS.selectAfterApplyStatrdTime", projectId);
/*     */   }
/*     */ 
/*     */   public Integer selectBeforeApplyEndTime(Long projectId)
/*     */   {
/* 101 */     return (Integer)getSqlMapClientTemplate().queryForObject("PROJECT_METAS.selectBeforeApplyEndTime", projectId);
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.dao.ibatis.project.ProjectMetasDAOImpl
 * JD-Core Version:    0.6.0
 */