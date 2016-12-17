package com.hundsun.network.gates.wulin.biz.service.project;

import com.hundsun.network.gates.wulin.biz.domain.project.ProjectBaseSetting;
import java.util.List;
import java.util.Map;

public abstract interface ProjectBaseSettingService
{
  public abstract ProjectBaseSetting selectBaseSet(Map<String, Object> paramMap);

  public abstract List<ProjectBaseSetting> selectBaseSetList(Map<String, Object> paramMap);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.project.ProjectBaseSettingService
 * JD-Core Version:    0.6.0
 */