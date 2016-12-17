/*     */ package com.hundsun.network.gates.wulin.biz.dao.ibatis.project;
/*     */ 
/*     */ import com.hundsun.network.gates.luosi.common.base.BaseDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.dao.project.ProjectListingDAO;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.auction.AuctionMulitBidProject;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.project.ProjectListing;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.query.AuctionMulitBidProjectQuery;
/*     */ import com.hundsun.network.gates.wulin.biz.domain.query.ProjectListingQuery;
/*     */ import com.ibatis.sqlmap.client.SqlMapExecutor;
/*     */ import java.sql.SQLException;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.springframework.orm.ibatis.SqlMapClientCallback;
/*     */ import org.springframework.orm.ibatis.SqlMapClientTemplate;
/*     */ import org.springframework.stereotype.Repository;
/*     */ 
/*     */ @Repository("projectListingDAO")
/*     */ public class ProjectListingDAOImpl extends BaseDAO
/*     */   implements ProjectListingDAO
/*     */ {
/*     */   public int deleteByPrimaryKey(Long id)
/*     */   {
/*  28 */     ProjectListing _key = new ProjectListing();
/*  29 */     _key.setId(id);
/*  30 */     int rows = getSqlMapClientTemplate().delete("ProjectListing.deleteByPrimaryKey", _key);
/*  31 */     return rows;
/*     */   }
/*     */ 
/*     */   public void insert(ProjectListing record) {
/*  35 */     getSqlMapClientTemplate().insert("ProjectListing.insert", record);
/*     */   }
/*     */ 
/*     */   public void insertSelective(ProjectListing record) {
/*  39 */     getSqlMapClientTemplate().insert("ProjectListing.insertSelective", record);
/*     */   }
/*     */ 
/*     */   public ProjectListing selectByPrimaryKey(Long id) {
/*  43 */     ProjectListing record = (ProjectListing)getSqlMapClientTemplate().queryForObject("ProjectListing.selectByPrimaryKey", id);
/*     */ 
/*  45 */     return record;
/*     */   }
/*     */ 
/*     */   public int updateByPrimaryKeySelective(ProjectListing record) {
/*  49 */     int rows = getSqlMapClientTemplate().update("ProjectListing.updateByPrimaryKeySelective", record);
/*     */ 
/*  51 */     return rows;
/*     */   }
/*     */ 
/*     */   public int updateByPrimaryKey(ProjectListing record) {
/*  55 */     int rows = getSqlMapClientTemplate().update("ProjectListing.updateByPrimaryKey", record);
/*  56 */     return rows;
/*     */   }
/*     */ 
/*     */   public String addProjectListing(ProjectListing project)
/*     */   {
/*  66 */     return getSqlMapClientTemplate().insert("ProjectListing.insert", project).toString();
/*     */   }
/*     */ 
/*     */   public ProjectListing getProSimpInfo(Long id)
/*     */   {
/*  74 */     ProjectListing record = (ProjectListing)getSqlMapClientTemplate().queryForObject("ProjectListing.selectProSimpInfoByPrimaryKey", id);
/*     */ 
/*  76 */     return record;
/*     */   }
/*     */ 
/*     */   public int updateStatusById(ProjectListing projectListing)
/*     */   {
/*  85 */     return getSqlMapClientTemplate().update("ProjectListing.updateStatusById", projectListing);
/*     */   }
/*     */ 
/*     */   public void updateProjectListing(ProjectListing project)
/*     */   {
/*  94 */     getSqlMapClientTemplate().update("ProjectListing.updateByCode", project);
/*     */   }
/*     */ 
/*     */   public int getProjectListingCountByYearAndType(Date year, String type)
/*     */   {
/*  99 */     Map param = new HashMap();
/* 100 */     param.put("year", year);
/* 101 */     param.put("listingType", type);
/* 102 */     Integer count = (Integer)getSqlMapClientTemplate().queryForObject("ProjectListing.getProjectListingCountByYearAndType", param);
/*     */ 
/* 104 */     return count == null ? 0 : count.intValue();
/*     */   }
/*     */ 
/*     */   public ProjectListing selectByProjectCode(String Code)
/*     */   {
/* 109 */     ProjectListing record = (ProjectListing)getSqlMapClientTemplate().queryForObject("ProjectListing.selectByProjectCode", Code);
/*     */ 
/* 111 */     return record;
/*     */   }
/*     */ 
/*     */   public List<ProjectListing> selectProjectListingByObj(ProjectListing projectListing)
/*     */   {
/* 122 */     List projectListingList = getSqlMapClientTemplate().queryForList("ProjectListing.selectProjectListingByObj", projectListing);
/*     */ 
/* 124 */     return projectListingList;
/*     */   }
/*     */ 
/*     */   public void paginate(ProjectListingQuery<ProjectListing> page)
/*     */   {
/* 129 */     paginate(page, "ProjectListing.getTotalCount", "ProjectListing.getPaginated");
/*     */   }
/*     */ 
/*     */   public boolean updateStatusByIdList(final List<ProjectListing> projectIdList)
/*     */   {
/*     */     try
/*     */     {
/* 141 */       if (projectIdList != null)
/* 142 */         getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
/*     */           public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
/* 144 */             executor.startBatch();
/* 145 */             int i = 0; for (int n = projectIdList.size(); i < n; i++) {
/* 146 */               executor.update("ProjectListing.updateStatusById", projectIdList.get(i));
/*     */             }
/*     */ 
/* 149 */             executor.executeBatch();
/* 150 */             return Boolean.valueOf(true);
/*     */           }
/*     */         });
/* 154 */       return true;
/*     */     } catch (Exception e) {
/* 156 */       if (this.log.isDebugEnabled()) {
/* 157 */         e.printStackTrace();
/* 158 */         this.log.debug("batchUpdate error: id [ ProjectListing.updateStatusById ], parameterObject [" + projectIdList + "].  Cause: " + e.getMessage());
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 163 */     return false;
/*     */   }
/*     */ 
/*     */   public int updateStatusByIdWithOldStatus(ProjectListing projectListing)
/*     */   {
/* 173 */     return getSqlMapClientTemplate().update("ProjectListing.updateStatusByIdWithOldStatus", projectListing);
/*     */   }
/*     */ 
/*     */   public String getMaxProjectCode(Map map)
/*     */   {
/* 183 */     Object obj = getSqlMapClientTemplate().queryForObject("ProjectListing.getMaxProjectCodeByType", map);
/*     */ 
/* 185 */     return null == obj ? null : String.valueOf(obj);
/*     */   }
/*     */ 
/*     */   public List<AuctionMulitBidProject> queryAuctionMulitBidProject(AuctionMulitBidProjectQuery query)
/*     */   {
/* 193 */     return getSqlMapClientTemplate().queryForList("ProjectListing.queryAuctionMulitBidProject", query);
/*     */   }
/*     */ }

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.ibatis.project.ProjectListingDAOImpl
 * JD-Core Version:    0.6.0
 */