package com.hundsun.network.gates.fengshan.biz.service.common;

import com.hundsun.network.gates.fengshan.biz.domain.common.Area;
import com.hundsun.network.gates.fengshan.biz.domain.common.AreaBO;
import java.util.List;
import java.util.Map;

public abstract interface AreaService
{
  public abstract void init();

  public abstract List<AreaBO> queryProvince();

  public abstract List<AreaBO> queryCity(String paramString);

  public abstract List<AreaBO> queryLocalArea(String paramString);

  public abstract Map<String, Area> getAllAreasMap();

  public abstract String getCityId(String paramString);

  public abstract String getProvinceId(String paramString);

  public abstract List<AreaBO> queryAllLocalArea(String paramString);

  public abstract String getAreaName(String paramString);

  public abstract String getAreaFullName(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.service.common.AreaService
 * JD-Core Version:    0.6.0
 */