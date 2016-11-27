package com.hundsun.eclp.biz.dao.sys;

import com.hundsun.eclp.biz.domain.sys.Region;
import java.util.List;

public abstract interface RegionDAO
{
  public abstract Long insert(Region paramRegion)
    throws Exception;

  public abstract int delete(Long paramLong)
    throws Exception;

  public abstract int update(Region paramRegion)
    throws Exception;

  public abstract Region selectRegion(Long paramLong)
    throws Exception;

  public abstract List<Region> selectRegionList(Region paramRegion);

  public abstract Region selectRegionByName(String paramString);

  public abstract Region selectRegionByCode(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.dao.sys.RegionDAO
 * JD-Core Version:    0.6.0
 */