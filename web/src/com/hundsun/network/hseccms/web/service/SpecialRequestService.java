package com.hundsun.network.hseccms.web.service;

import com.hundsun.network.hseccms.model.Cms2Channel;
import java.util.List;

public abstract interface SpecialRequestService
{
  public abstract List<Cms2Channel> queryByGroupCode(String paramString1, String paramString2);

  public abstract Cms2Channel queryChannelByUserOwn(String paramString1, String paramString2, Long paramLong);

  public abstract Long queryCountByMemberAndChannel(String paramString1, String paramString2, Long paramLong);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy13\cmsWeb\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.hseccms.web.service.SpecialRequestService
 * JD-Core Version:    0.6.0
 */