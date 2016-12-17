package com.hundsun.network.gates.genshan.biz.service.operation;

import com.hundsun.network.gates.genshan.biz.domain.operation.Announcement;
import com.hundsun.network.gates.genshan.biz.domain.query.AnnouncementQuery;

public abstract interface AnnouncementService
{
  public abstract void paginate(AnnouncementQuery<Announcement> paramAnnouncementQuery);

  public abstract Announcement queryAnnouncementInfo(Long paramLong);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.service.operation.AnnouncementService
 * JD-Core Version:    0.6.0
 */