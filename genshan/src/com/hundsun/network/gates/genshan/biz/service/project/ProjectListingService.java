package com.hundsun.network.gates.genshan.biz.service.project;

import com.hundsun.network.gates.genshan.biz.domain.project.ProjectListing;
import com.hundsun.network.gates.genshan.biz.domain.project.ProjectMetas;
import com.hundsun.network.gates.genshan.biz.domain.project.ProjectTradeBO;
import com.hundsun.network.gates.genshan.biz.domain.query.ProjectListingQuery;
import com.hundsun.network.gates.luosi.biz.domain.TradeShowDTO;
import com.hundsun.network.gates.luosi.wulin.reomte.result.ProjectListingServiceResult;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract interface ProjectListingService
{
  public abstract void paginate(ProjectListingQuery<ProjectListing> paramProjectListingQuery);

  public abstract ProjectListing getProArriMetaInfo(Long paramLong);

  public abstract ProjectListing getProSimpInfo(Long paramLong);

  public abstract ProjectListing getProInfo(Long paramLong);

  public abstract String getMetaValue(ProjectMetas paramProjectMetas);

  public abstract int getNumOfAuditProject(ProjectListingQuery<ProjectListing> paramProjectListingQuery);

  public abstract ProjectListing getProjectListingById(Long paramLong);

  public abstract ProjectListing getProjectListingByCode(String paramString);

  public abstract List<TradeShowDTO> getProjectTradeTypeAttri(String paramString1, String paramString2);

  public abstract List<TradeShowDTO> getProjectTradeTypeAttri(String paramString1, HashMap<String, String> paramHashMap, String paramString2);

  public abstract Long getProjectIdByCode(String paramString);

  public abstract ProjectListingServiceResult updateProjectListing(ProjectListing paramProjectListing);

  public abstract ProjectListingServiceResult updateProjectListing(ProjectListing paramProjectListing, ProjectTradeBO paramProjectTradeBO);

  public abstract String selectOneMetaValue(ProjectMetas paramProjectMetas);

  public abstract ProjectListing getSimpleInfoOfProject(String paramString);

  public abstract void sendMessageToReviewers(List<String> paramList, ProjectTradeBO paramProjectTradeBO, ProjectListing paramProjectListing);

  public abstract void sendMessageToAuctioners(List<String> paramList, ProjectTradeBO paramProjectTradeBO, ProjectListing paramProjectListing);

  public abstract void sendMessageToAuctionners(ProjectListing paramProjectListing, String paramString);

  public abstract void sendMessageToReviewers(ProjectListing paramProjectListing, String paramString);

  public abstract List<ProjectListing> getProjectForScreen(Map<String, Object> paramMap);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.service.project.ProjectListingService
 * JD-Core Version:    0.6.0
 */