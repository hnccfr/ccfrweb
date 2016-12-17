package com.hundsun.network.gates.wulin.biz.dao.project;

import com.hundsun.network.gates.wulin.biz.domain.project.ProjectStandard;
import java.util.List;

public abstract interface ProjectStandardDAO
{
  public abstract List<ProjectStandard> getStandardListByQuery(List<String> paramList);

  public abstract ProjectStandard getStandardById(Long paramLong);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.project.ProjectStandardDAO
 * JD-Core Version:    0.6.0
 */