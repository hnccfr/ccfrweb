package com.hundsun.network.gates.wulin.biz.service.operation;

import com.hundsun.network.gates.wulin.biz.domain.operation.Announcement;
import com.hundsun.network.gates.wulin.biz.domain.query.AnnouncementQuery;
import java.util.List;

public abstract interface AnnouncementService
{
  public abstract void paginated(AnnouncementQuery<Announcement> paramAnnouncementQuery);

  public abstract List<Announcement> queryAnnouncementList(AnnouncementQuery<Announcement> paramAnnouncementQuery);

  public abstract Announcement queryAnnouncementInfo(Long paramLong);

  public abstract Long insert(Announcement paramAnnouncement);

  public abstract int removeAnnouncement(Announcement paramAnnouncement);

  public abstract int joinProject(Announcement paramAnnouncement);

  public abstract int leaveProject(Announcement paramAnnouncement);

  public abstract Announcement queryNewestAnnouncement();

  public abstract int normal(Announcement paramAnnouncement);

  public abstract void updateById(Announcement paramAnnouncement);

  public abstract Long insertNormal(Announcement paramAnnouncement);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.operation.AnnouncementService
 * JD-Core Version:    0.6.0
 */