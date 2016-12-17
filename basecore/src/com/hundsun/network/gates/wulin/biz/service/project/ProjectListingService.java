package com.hundsun.network.gates.wulin.biz.service.project;

import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
import com.hundsun.network.gates.luosi.common.result.ProjectBaseTradeServiceResult;
import com.hundsun.network.gates.luosi.wulin.reomte.dto.ProjectListingDTO;
import com.hundsun.network.gates.luosi.wulin.reomte.result.ProjectAuditLogServiceResult;
import com.hundsun.network.gates.luosi.wulin.reomte.result.ProjectListingServiceResult;
import com.hundsun.network.gates.wulin.biz.domain.auction.AuctionMulitBidProject;
import com.hundsun.network.gates.wulin.biz.domain.operation.Announcement;
import com.hundsun.network.gates.wulin.biz.domain.project.ProjectAuditLog;
import com.hundsun.network.gates.wulin.biz.domain.project.ProjectListing;
import com.hundsun.network.gates.wulin.biz.domain.project.ProjectMetas;
import com.hundsun.network.gates.wulin.biz.domain.query.AuctionMulitBidProjectQuery;
import java.util.List;

public abstract interface ProjectListingService
{
  public abstract ProjectListingServiceResult addProjectListing(ProjectListing paramProjectListing);

  public abstract ProjectAuditLogServiceResult auditProjectListing(ProjectAuditLog paramProjectAuditLog, ProjectListing paramProjectListing);

  public abstract ProjectListingServiceResult updateProjectListing(ProjectListing paramProjectListing);

  public abstract ProjectListingServiceResult updateProjectListing(ProjectListing paramProjectListing, List<ProjectMetas> paramList);

  public abstract ServiceResult suspension(Announcement paramAnnouncement);

  public abstract ServiceResult resumption(Announcement paramAnnouncement);

  public abstract ServiceResult withdrawal(Announcement paramAnnouncement, boolean paramBoolean);

  public abstract ProjectListingServiceResult tradeClearProject(ProjectListing paramProjectListing);

  public abstract ProjectListingServiceResult getAllProjectListing();

  public abstract ProjectListingServiceResult getProjectInfoByCode(String paramString);

  public abstract ProjectBaseTradeServiceResult getAllProjectBaseTrade();

  public abstract List<ProjectListingDTO> selectLatestProjectListing(int paramInt, String paramString);

  public abstract List<AuctionMulitBidProject> queryAuctionMulitBidProjectUncheckedByProjectCode(AuctionMulitBidProjectQuery paramAuctionMulitBidProjectQuery);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.project.ProjectListingService
 * JD-Core Version:    0.6.0
 */