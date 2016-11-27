package com.hundsun.network.gates.wulin.biz.dao.operation;

import com.hundsun.network.gates.wulin.biz.domain.operation.Announcement;
import com.hundsun.network.gates.wulin.biz.domain.query.AnnouncementQuery;
import java.util.List;

public abstract interface AnnouncementDAO
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract Long insert(Announcement paramAnnouncement);

  public abstract void insertSelective(Announcement paramAnnouncement);

  public abstract Announcement selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(Announcement paramAnnouncement);

  public abstract void paginated(AnnouncementQuery<Announcement> paramAnnouncementQuery);

  public abstract List<Announcement> queryAnnouncementList(AnnouncementQuery<Announcement> paramAnnouncementQuery);

  public abstract int removeByPrimaryKey(Long paramLong);

  public abstract int leaveProjectByPrimaryKey(Announcement paramAnnouncement);

  public abstract Announcement selectNewestAnnouncement();
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.operation.AnnouncementDAO
 * JD-Core Version:    0.6.0
 */