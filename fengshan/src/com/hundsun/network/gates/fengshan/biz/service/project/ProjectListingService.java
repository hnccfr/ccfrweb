package com.hundsun.network.gates.fengshan.biz.service.project;

import com.hundsun.network.gates.fengshan.biz.domain.common.DateStatistics;
import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectListing;
import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectMetasBO;
import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectTradeBO;
import com.hundsun.network.gates.fengshan.biz.domain.query.AuctionMulitBidProjectQuery;
import com.hundsun.network.gates.fengshan.biz.domain.query.ProjectListingQuery;
import com.hundsun.network.gates.fengshan.biz.enums.EnumDateStatisticsType;
import com.hundsun.network.gates.luosi.biz.domain.TradeShowDTO;
import com.hundsun.network.gates.luosi.biz.security.ServiceException;
import com.hundsun.network.gates.luosi.wulin.reomte.result.ProjectListingServiceResult;
import java.util.List;
import java.util.Map;

public abstract interface ProjectListingService
{
  public abstract void getProjectListingByQuery(ProjectListingQuery paramProjectListingQuery);

  public abstract ProjectListingServiceResult addProjectListing(ProjectListing paramProjectListing, ProjectMetasBO paramProjectMetasBO);

  public abstract ProjectListing getProjectListingById(Long paramLong);

  public abstract ProjectListing getProjectListingByCode(String paramString);

  public abstract ProjectListing getProjectListingDetailById(Long paramLong);

  public abstract ProjectListing getProjectListingDetailByCode(String paramString);

  public abstract int deletProjectListingById(Long paramLong);

  public abstract ProjectListingServiceResult updateProjectListing(ProjectListing paramProjectListing);

  public abstract List<TradeShowDTO> getProjectTradeTypeAttri(String paramString1, String paramString2);

  public abstract ProjectListingServiceResult updateProjectListingStatusById(ProjectListing paramProjectListing);

  public abstract void matcheProjectListingByQuery(ProjectListingQuery paramProjectListingQuery);

  public abstract List<ProjectListing> selectLatestProjectListing(Integer paramInteger, String paramString);

  public abstract Map<String, List<ProjectListing>> selectLatestProjectListing(Integer paramInteger);

  public abstract List<DateStatistics> queryProjectListingByDate(EnumDateStatisticsType paramEnumDateStatisticsType, Long paramLong);

  public abstract void selectAuctionProjectlist(ProjectListingQuery paramProjectListingQuery);

  public abstract ProjectListingServiceResult updateProjectListing(ProjectListing paramProjectListing, ProjectTradeBO paramProjectTradeBO);

  public abstract int existsAuctioner(String paramString1, String paramString2);

  public abstract Long getListingJYDeposit(ProjectListing paramProjectListing, String paramString)
    throws ServiceException;

  public abstract void queryAuctionMulitBidProjectUnchecked(AuctionMulitBidProjectQuery paramAuctionMulitBidProjectQuery);

  public abstract void queryAuctionMulitBidProjectChecked(AuctionMulitBidProjectQuery paramAuctionMulitBidProjectQuery);

  public abstract void queryAuctionMulitBidProject(AuctionMulitBidProjectQuery paramAuctionMulitBidProjectQuery);

  public abstract Long getProjectIdByCode(String paramString);

  public abstract Integer deleteFile(ProjectListing paramProjectListing);

  public abstract Integer updateAttachedFile(ProjectListing paramProjectListing);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.service.project.ProjectListingService
 * JD-Core Version:    0.6.0
 */