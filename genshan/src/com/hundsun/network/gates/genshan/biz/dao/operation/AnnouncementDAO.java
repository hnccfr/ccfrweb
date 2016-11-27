package com.hundsun.network.gates.genshan.biz.dao.operation;

import com.hundsun.network.gates.genshan.biz.domain.operation.Announcement;
import com.hundsun.network.gates.genshan.biz.domain.query.AnnouncementQuery;

public abstract interface AnnouncementDAO
{
  public abstract void paginate(AnnouncementQuery<Announcement> paramAnnouncementQuery);

  public abstract Announcement selectByPrimaryKey(Long paramLong);

  public abstract Integer getNumByQuery(AnnouncementQuery<Announcement> paramAnnouncementQuery);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.operation.AnnouncementDAO
 * JD-Core Version:    0.6.0
 */