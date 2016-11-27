package com.hundsun.network.gates.qingbo.biz.service.project;

import com.hundsun.network.gates.luosi.wulin.reomte.result.ProjectListingServiceResult;
import com.hundsun.network.gates.qingbo.biz.domain.project.ProjectListing;
import java.sql.SQLException;

public abstract interface ProjectListingService
{
  public abstract ProjectListingServiceResult addProjectListing(ProjectListing paramProjectListing)
    throws Exception;

  public abstract ProjectListingServiceResult tradeClearProject(ProjectListing paramProjectListing)
    throws Exception;

  public abstract ProjectListing getProjectListingByCode(String paramString)
    throws SQLException;
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.qingbo.biz.service.project.ProjectListingService
 * JD-Core Version:    0.6.0
 */