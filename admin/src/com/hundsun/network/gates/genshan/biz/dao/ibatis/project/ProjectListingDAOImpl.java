/*     */ package com.hundsun.network.gates.genshan.biz.dao.ibatis.project;
/*     */ 
/*     */ import com.hundsun.network.gates.genshan.biz.dao.project.ProjectListingDAO;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.project.ProjectListing;
/*     */ import com.hundsun.network.gates.genshan.biz.domain.query.ProjectListingQuery;
/*     */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*     */ import org.springframework.stereotype.Repository;
/*     */ 
/*     */ @Repository("projectListingDAO")
/*     */ public class ProjectListingDAOImpl extends BaseDAO
/*     */   implements ProjectListingDAO
/*     */ {
/*     */   public void paginate(ProjectListingQuery<ProjectListing> page)
/*     */   {
/*  25 */     paginate(page, "ProjectListing.getTotalCount", "ProjectListing.getPaginated");
/*     */   }
/*     */ 
/*     */   public int deleteByPrimaryKey(Long id) {
/*  29 */     ProjectListing _key = new ProjectListing();
/*  30 */     _key.setId(id);
/*  31 */     int rows = getSqlMapClientTemplate().delete("PROJECT_LISTING.deleteByPrimaryKey", _key);
/*  32 */     return rows;
/*     */   }
/*     */ 
/*     */   public void insert(ProjectListing record) {
/*  36 */     getSqlMapClientTemplate().insert("PROJECT_LISTING.insert", record);
/*     */   }
/*     */ 
/*     */   public void insertSelective(ProjectListing record) {
/*  40 */     getSqlMapClientTemplate().insert("PROJECT_LISTING.insertSelective", record);
/*     */   }
/*     */ 
/*     */   public ProjectListing selectByPrimaryKey(Long id)
/*     */   {
/*  48 */     return (ProjectListing)getSqlMapClientTemplate().queryForObject("ProjectListing.selectByPrimaryKey", id);
/*     */   }
/*     */ 
/*     */   public ProjectListing selectByCode(String code)
/*     */   {
/*  53 */     return (ProjectListing)getSqlMapClientTemplate().queryForObject("ProjectListing.selectByCode", code);
/*     */   }
/*     */ 
/*     */   public int updateByPrimaryKeySelective(ProjectListing record)
/*     */   {
/*  58 */     int rows = getSqlMapClientTemplate().update("ProjectListing.updateByPrimaryKeySelective", record);
/*     */ 
/*  60 */     return rows;
/*     */   }
/*     */ 
/*     */   public int updateByPrimaryKey(ProjectListing record) {
/*  64 */     int rows = getSqlMapClientTemplate().update("PROJECT_LISTING.updateByPrimaryKey", record);
/*  65 */     return rows;
/*     */   }
/*     */ 
/*     */   public void addProjectListing(ProjectListing project) {
/*  69 */     getSqlMapClientTemplate().insert("PROJECT_LISTING.insert", project);
/*     */   }
/*     */ 
/*     */   public ProjectListing getProSimpInfo(Long projectListingId)
/*     */   {
/*  77 */     return (ProjectListing)getSqlMapClientTemplate().queryForObject("ProjectListing.selectProSimpInfoByPrimaryKey", projectListingId);
/*     */   }
/*     */ 
/*     */   public Integer selectNumOfAuditProject(ProjectListingQuery<ProjectListing> page)
/*     */   {
/*  82 */     return (Integer)getSqlMapClientTemplate().queryForObject("ProjectListing.getTotalCount", page);
/*     */   }
/*     */ 
/*     */   public Long getProjectId(String projectCode)
/*     */   {
/*  87 */     return (Long)getSqlMapClientTemplate().queryForObject("ProjectListing.selectProjectIdByCode", projectCode);
/*     */   }
/*     */ 
/*     */   public ProjectListing selectProjectListingByCode(String code)
/*     */   {
/*  96 */     ProjectListing projectListing = (ProjectListing)getSqlMapClientTemplate().queryForObject("ProjectListing.selectProjectListingByCode", code);
/*     */ 
/*  98 */     return projectListing;
/*     */   }
/*     */ 
/*     */   public Map<String, Object> selectByProjectCodeForCancelFund(String code)
/*     */   {
/* 109 */     return (Map)getSqlMapClientTemplate().queryForObject("ProjectListing.selectByProjectCodeForCancelFund", code);
/*     */   }
/*     */ 
/*     */   public List<ProjectListing> getProjectForScreen(Map<String, Object> map)
/*     */   {
/* 116 */     return getSqlMapClientTemplate().queryForList("ProjectListing.getProjectForScreen", map);
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.ibatis.project.ProjectListingDAOImpl
 * JD-Core Version:    0.6.0
 */