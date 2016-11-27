package com.hundsun.network.gates.fengshan.biz.dao.operation;

import com.hundsun.network.gates.fengshan.biz.domain.operation.Announcement;
import com.hundsun.network.gates.fengshan.biz.domain.query.AnnouncementQuery;

public abstract interface AnnouncementDAO
{
  public abstract void paginate(AnnouncementQuery<Announcement> paramAnnouncementQuery);

  public abstract Announcement selectByPrimaryKey(Long paramLong);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.dao.operation.AnnouncementDAO
 * JD-Core Version:    0.6.0
 */