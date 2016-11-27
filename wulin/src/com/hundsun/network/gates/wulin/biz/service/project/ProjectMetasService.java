package com.hundsun.network.gates.wulin.biz.service.project;

import com.hundsun.network.gates.luosi.wulin.reomte.result.ProjectMetasServiceResult;
import com.hundsun.network.gates.wulin.biz.domain.project.ProjectMetas;
import java.util.List;

public abstract interface ProjectMetasService
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract void insert(ProjectMetas paramProjectMetas);

  public abstract void insertSelective(ProjectMetas paramProjectMetas);

  public abstract int updateByPrimaryKeySelective(ProjectMetas paramProjectMetas);

  public abstract int updateByPrimaryKey(ProjectMetas paramProjectMetas);

  public abstract void insert(List<ProjectMetas> paramList);

  public abstract ProjectMetasServiceResult getAllProjectMetas();

  public abstract ProjectMetasServiceResult getProjectMetas(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.project.ProjectMetasService
 * JD-Core Version:    0.6.0
 */