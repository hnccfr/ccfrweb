package com.hundsun.network.gates.fengshan.biz.dao.project;

import com.hundsun.network.gates.fengshan.biz.domain.common.DateStatistics;
import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectListing;
import com.hundsun.network.gates.fengshan.biz.domain.query.AuctionMulitBidProjectQuery;
import com.hundsun.network.gates.fengshan.biz.domain.query.ProjectListingQuery;
import com.hundsun.network.gates.fengshan.biz.enums.EnumDateStatisticsType;
import java.util.List;

public abstract interface ProjectListingDAO
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract void insert(ProjectListing paramProjectListing);

  public abstract void insertSelective(ProjectListing paramProjectListing);

  public abstract ProjectListing selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(ProjectListing paramProjectListing);

  public abstract int updateByPrimaryKey(ProjectListing paramProjectListing);

  public abstract Long getProjectIdByCode(String paramString);

  public abstract void selectByQuery(ProjectListingQuery paramProjectListingQuery);

  public abstract ProjectListing selectByCode(String paramString);

  public abstract List<DateStatistics> queryProjectListingByDate(EnumDateStatisticsType paramEnumDateStatisticsType, Long paramLong);

  public abstract void selectAuctionProjectlist(ProjectListingQuery paramProjectListingQuery);

  public abstract int existsAuctioner(String paramString1, String paramString2);

  public abstract String selectStatusByCode(String paramString);

  public abstract void queryAuctionMulitBidProject(AuctionMulitBidProjectQuery paramAuctionMulitBidProjectQuery);

  public abstract Integer getNumByQuery(ProjectListingQuery paramProjectListingQuery);

  public abstract Integer selectAuctionProjectNum(ProjectListingQuery paramProjectListingQuery);

  public abstract Integer queryAuctionMulitBidProjectNum(AuctionMulitBidProjectQuery paramAuctionMulitBidProjectQuery);

  public abstract int updateAttachedFilePath(ProjectListing paramProjectListing);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.dao.project.ProjectListingDAO
 * JD-Core Version:    0.6.0
 */