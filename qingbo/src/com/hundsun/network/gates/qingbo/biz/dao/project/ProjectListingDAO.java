package com.hundsun.network.gates.qingbo.biz.dao.project;

import com.hundsun.network.gates.qingbo.biz.domain.project.ProjectListing;
import java.util.Date;
import java.util.List;
import java.util.Map;

public abstract interface ProjectListingDAO
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract void insert(ProjectListing paramProjectListing);

  public abstract void insertSelective(ProjectListing paramProjectListing);

  public abstract ProjectListing selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(ProjectListing paramProjectListing);

  public abstract int updateByPrimaryKey(ProjectListing paramProjectListing);

  public abstract String addProjectListing(ProjectListing paramProjectListing);

  public abstract ProjectListing getProSimpInfo(Long paramLong);

  public abstract int updateStatusById(ProjectListing paramProjectListing);

  public abstract int updateProjectListing(Map<String, Object> paramMap);

  public abstract int getProjectListingCountByYearAndType(Date paramDate, String paramString);

  public abstract ProjectListing selectByProjectCode(String paramString);

  public abstract List<ProjectListing> selectProjectListingByObj(ProjectListing paramProjectListing);

  public abstract List<ProjectListing> selectLatestProjectListing(int paramInt);

  public abstract Map<String, Object> selectByProjectCodeForCancelFund(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.qingbo.biz.dao.project.ProjectListingDAO
 * JD-Core Version:    0.6.0
 */