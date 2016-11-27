package com.hundsun.eclp.biz.service.sys;

import com.hundsun.eclp.biz.domain.sys.Region;
import com.hundsun.eclp.enums.EnumRegionType;
import java.util.List;

public abstract interface RegionService
{
  public abstract List<Region> getChildRegionList(EnumRegionType paramEnumRegionType, String paramString);

  public abstract List<Region> getRegionByType(EnumRegionType paramEnumRegionType);

  public abstract Region selectRegionByName(String paramString);

  public abstract Region selectRegionByCode(String paramString);

  public abstract List<Region> getProvinceList();

  public abstract List<Region> getCityList();

  public abstract List<Region> getDistrictList();
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\eclp\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.eclp.biz.service.sys.RegionService
 * JD-Core Version:    0.6.0
 */