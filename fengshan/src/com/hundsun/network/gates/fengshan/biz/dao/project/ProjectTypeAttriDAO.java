package com.hundsun.network.gates.fengshan.biz.dao.project;

import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectTypeAttri;
import java.util.List;

public abstract interface ProjectTypeAttriDAO
{
  public abstract List<ProjectTypeAttri> getProjectAttriListByQuery(List<String> paramList);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.dao.project.ProjectTypeAttriDAO
 * JD-Core Version:    0.6.0
 */