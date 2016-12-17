package com.hundsun.network.gates.wulin.biz.service.webservice;

import com.hundsun.network.gates.luosi.wulin.reomte.dto.AnnouncementDTO;
import com.hundsun.network.gates.luosi.wulin.reomte.dto.ProjectListingDTO;
import com.hundsun.network.gates.luosi.wulin.reomte.dto.TradeOrderDTO;
import com.hundsun.network.gates.luosi.wulin.reomte.dto.TradeWishOrderDTO;
import java.util.List;

public abstract interface RemoteProvideService
{
  public abstract List<AnnouncementDTO> getAnnoumcement(String paramString);

  public abstract List<TradeOrderDTO> getTradeOrder(String paramString1, String paramString2);

  public abstract List<ProjectListingDTO> getProjectListing(String paramString1, String paramString2);

  public abstract List<TradeWishOrderDTO> getTradeWishOrder(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.webservice.RemoteProvideService
 * JD-Core Version:    0.6.0
 */