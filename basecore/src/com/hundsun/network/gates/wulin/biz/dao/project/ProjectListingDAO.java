package com.hundsun.network.gates.wulin.biz.dao.project;

import com.hundsun.network.gates.wulin.biz.domain.auction.AuctionMulitBidProject;
import com.hundsun.network.gates.wulin.biz.domain.project.ProjectListing;
import com.hundsun.network.gates.wulin.biz.domain.query.AuctionMulitBidProjectQuery;
import com.hundsun.network.gates.wulin.biz.domain.query.ProjectListingQuery;
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

  public abstract void updateProjectListing(ProjectListing paramProjectListing);

  public abstract int getProjectListingCountByYearAndType(Date paramDate, String paramString);

  public abstract ProjectListing selectByProjectCode(String paramString);

  public abstract List<ProjectListing> selectProjectListingByObj(ProjectListing paramProjectListing);

  public abstract boolean updateStatusByIdList(List<ProjectListing> paramList);

  public abstract void paginate(ProjectListingQuery<ProjectListing> paramProjectListingQuery);

  public abstract int updateStatusByIdWithOldStatus(ProjectListing paramProjectListing);

  public abstract String getMaxProjectCode(Map paramMap);

  public abstract List<AuctionMulitBidProject> queryAuctionMulitBidProject(AuctionMulitBidProjectQuery paramAuctionMulitBidProjectQuery);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.project.ProjectListingDAO
 * JD-Core Version:    0.6.0
 */