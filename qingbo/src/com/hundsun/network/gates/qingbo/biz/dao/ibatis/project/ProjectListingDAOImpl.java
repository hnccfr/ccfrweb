/*     */ package com.hundsun.network.gates.qingbo.biz.dao.ibatis.project;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*     */ import com.hundsun.network.gates.qingbo.biz.dao.project.ProjectListingDAO;
/*     */ import com.hundsun.network.gates.qingbo.biz.domain.project.ProjectListing;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*     */ import org.springframework.stereotype.Repository;
/*     */ 
/*     */ @Repository("projectListingDAO")
/*     */ public class ProjectListingDAOImpl extends BaseDAO
/*     */   implements ProjectListingDAO
/*     */ {
/*     */   public int deleteByPrimaryKey(Long id)
/*     */   {
/*  22 */     ProjectListing _key = new ProjectListing();
/*  23 */     _key.setId(id);
/*  24 */     int rows = getSqlMapClientTemplate().delete("ProjectListing.deleteByPrimaryKey", _key);
/*  25 */     return rows;
/*     */   }
/*     */ 
/*     */   public void insert(ProjectListing record) {
/*  29 */     getSqlMapClientTemplate().insert("ProjectListing.insert", record);
/*     */   }
/*     */ 
/*     */   public void insertSelective(ProjectListing record) {
/*  33 */     getSqlMapClientTemplate().insert("ProjectListing.insertSelective", record);
/*     */   }
/*     */ 
/*     */   public ProjectListing selectByPrimaryKey(Long id) {
/*  37 */     ProjectListing record = (ProjectListing)getSqlMapClientTemplate().queryForObject("ProjectListing.selectByPrimaryKey", id);
/*     */ 
/*  39 */     return record;
/*     */   }
/*     */ 
/*     */   public int updateByPrimaryKeySelective(ProjectListing record) {
/*  43 */     int rows = getSqlMapClientTemplate().update("ProjectListing.updateByPrimaryKeySelective", record);
/*     */ 
/*  45 */     return rows;
/*     */   }
/*     */ 
/*     */   public int updateByPrimaryKey(ProjectListing record) {
/*  49 */     int rows = getSqlMapClientTemplate().update("ProjectListing.updateByPrimaryKey", record);
/*  50 */     return rows;
/*     */   }
/*     */ 
/*     */   public String addProjectListing(ProjectListing project)
/*     */   {
/*  60 */     return getSqlMapClientTemplate().insert("ProjectListing.insert", project).toString();
/*     */   }
/*     */ 
/*     */   public ProjectListing getProSimpInfo(Long id)
/*     */   {
/*  68 */     ProjectListing record = (ProjectListing)getSqlMapClientTemplate().queryForObject("ProjectListing.selectProSimpInfoByPrimaryKey", id);
/*     */ 
/*  70 */     return record;
/*     */   }
/*     */ 
/*     */   public int updateStatusById(ProjectListing projectListing)
/*     */   {
/*  79 */     return getSqlMapClientTemplate().update("ProjectListing.updateStatusById", projectListing);
/*     */   }
/*     */ 
/*     */   public int updateProjectListing(Map<String, Object> paramMap)
/*     */   {
/*  88 */     return getSqlMapClientTemplate().update("ProjectListing.updateStoreQtAndStByCode", paramMap);
/*     */   }
/*     */ 
/*     */   public int getProjectListingCountByYearAndType(Date year, String type)
/*     */   {
/*  93 */     Map param = new HashMap();
/*  94 */     param.put("year", year);
/*  95 */     param.put("listingType", type);
/*  96 */     Integer count = (Integer)getSqlMapClientTemplate().queryForObject("ProjectListing.getProjectListingCountByYearAndType", param);
/*     */ 
/*  98 */     return count == null ? 0 : count.intValue();
/*     */   }
/*     */ 
/*     */   public ProjectListing selectByProjectCode(String Code)
/*     */   {
/* 103 */     ProjectListing record = (ProjectListing)getSqlMapClientTemplate().queryForObject("ProjectListing.selectByProjectCode", Code);
/*     */ 
/* 105 */     return record;
/*     */   }
/*     */ 
/*     */   public List<ProjectListing> selectProjectListingByObj(ProjectListing projectListing)
/*     */   {
/* 116 */     List projectListingList = getSqlMapClientTemplate().queryForList("ProjectListing.selectProjectListingByObj", projectListing);
/*     */ 
/* 118 */     return projectListingList;
/*     */   }
/*     */ 
/*     */   public List<ProjectListing> selectLatestProjectListing(int counts)
/*     */   {
/* 123 */     return getSqlMapClientTemplate().queryForList("ProjectListing.selectLatestProjectListing", Integer.valueOf(counts));
/*     */   }
/*     */ 
/*     */   public Map<String, Object> selectByProjectCodeForCancelFund(String code)
/*     */   {
/* 135 */     return (Map)getSqlMapClientTemplate().queryForObject("ProjectListing.selectByProjectCodeForCancelFund", code);
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.qingbo.biz.dao.ibatis.project.ProjectListingDAOImpl
 * JD-Core Version:    0.6.0
 */