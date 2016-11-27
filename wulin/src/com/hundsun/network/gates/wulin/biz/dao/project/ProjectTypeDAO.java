package com.hundsun.network.gates.wulin.biz.dao.project;

import com.hundsun.network.gates.wulin.biz.domain.project.ProjectType;
import java.util.List;
import java.util.Map;

public abstract interface ProjectTypeDAO
{
  public abstract List<ProjectType> queryProjectTypeAllChild(Map<String, String> paramMap);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.project.ProjectTypeDAO
 * JD-Core Version:    0.6.0
 */