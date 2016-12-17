package com.hundsun.network.gates.wulin.biz.service.project;

import com.hundsun.network.gates.luosi.wulin.reomte.request.ProjectTypeRequest;
import com.hundsun.network.gates.wulin.biz.domain.project.ProjectType;
import com.hundsun.network.gates.wulin.biz.domain.project.ProjectTypeAttri;
import java.util.List;

public abstract interface ProjectTypeService
{
  public abstract List<ProjectTypeAttri> getProjectAttriListByQuery(String paramString);

  public abstract List<ProjectType> getProjectByCode(ProjectTypeRequest paramProjectTypeRequest);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.project.ProjectTypeService
 * JD-Core Version:    0.6.0
 */