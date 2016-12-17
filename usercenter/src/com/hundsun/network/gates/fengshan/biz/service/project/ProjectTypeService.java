package com.hundsun.network.gates.fengshan.biz.service.project;

import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectTypeAttri;
import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectTypeJson;
import java.util.List;

public abstract interface ProjectTypeService
{
  public abstract List<ProjectTypeJson> queryProjectTypeTree(String paramString);

  public abstract List<ProjectTypeAttri> queryProjectTypeAttri(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.service.project.ProjectTypeService
 * JD-Core Version:    0.6.0
 */