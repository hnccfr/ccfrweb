package com.hundsun.network.gates.wulin.biz.service.project;

import com.hundsun.network.gates.wulin.biz.domain.project.ProjectStandard;
import java.util.List;

public abstract interface ProjectStandardService
{
  public abstract List<ProjectStandard> selectListByProTypeCode(String paramString);

  public abstract ProjectStandard getStandardById(Long paramLong);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.project.ProjectStandardService
 * JD-Core Version:    0.6.0
 */