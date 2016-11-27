package com.hundsun.network.gates.qingbo.biz.service.project;

import com.hundsun.network.gates.luosi.qingbo.reomte.dto.PlaceOrderTradeDTO;
import com.hundsun.network.gates.luosi.wulin.reomte.result.ProjectListingServiceResult;
import com.hundsun.network.gates.qingbo.biz.domain.project.ProjectListing;

public abstract interface ProjectService
{
  public abstract ProjectListingServiceResult tradeClearProject(PlaceOrderTradeDTO paramPlaceOrderTradeDTO)
    throws Exception;

  public abstract ProjectListingServiceResult rollbackTradeClearProject(PlaceOrderTradeDTO paramPlaceOrderTradeDTO);

  public abstract String getProjectTradeStatusByCode(String paramString);

  public abstract ProjectListing getProjectListingByCode(String paramString)
    throws Exception;
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.qingbo.biz.service.project.ProjectService
 * JD-Core Version:    0.6.0
 */