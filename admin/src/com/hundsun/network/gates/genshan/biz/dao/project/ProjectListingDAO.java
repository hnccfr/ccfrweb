package com.hundsun.network.gates.genshan.biz.dao.project;

import com.hundsun.network.gates.genshan.biz.domain.project.ProjectListing;
import com.hundsun.network.gates.genshan.biz.domain.query.ProjectListingQuery;
import java.util.List;
import java.util.Map;

public abstract interface ProjectListingDAO
{
  public abstract void paginate(ProjectListingQuery<ProjectListing> paramProjectListingQuery);

  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract void insert(ProjectListing paramProjectListing);

  public abstract void insertSelective(ProjectListing paramProjectListing);

  public abstract ProjectListing selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(ProjectListing paramProjectListing);

  public abstract int updateByPrimaryKey(ProjectListing paramProjectListing);

  public abstract void addProjectListing(ProjectListing paramProjectListing);

  public abstract ProjectListing getProSimpInfo(Long paramLong);

  public abstract Integer selectNumOfAuditProject(ProjectListingQuery<ProjectListing> paramProjectListingQuery);

  public abstract Long getProjectId(String paramString);

  public abstract ProjectListing selectProjectListingByCode(String paramString);

  public abstract ProjectListing selectByCode(String paramString);

  public abstract Map<String, Object> selectByProjectCodeForCancelFund(String paramString);

  public abstract List<ProjectListing> getProjectForScreen(Map<String, Object> paramMap);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.project.ProjectListingDAO
 * JD-Core Version:    0.6.0
 */