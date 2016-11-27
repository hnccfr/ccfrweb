package com.hundsun.network.gates.wulin.biz.dao.project;

import com.hundsun.network.gates.wulin.biz.domain.project.ProjectMetas;
import com.hundsun.network.gates.wulin.biz.domain.query.ProjectMetasQuery;
import java.util.List;

public abstract interface ProjectMetasDAO
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract void insert(ProjectMetas paramProjectMetas);

  public abstract void insertSelective(ProjectMetas paramProjectMetas);

  public abstract int updateByPrimaryKeySelective(ProjectMetas paramProjectMetas);

  public abstract int updateByPrimaryKey(ProjectMetas paramProjectMetas);

  public abstract void insert(List<ProjectMetas> paramList);

  public abstract ProjectMetas getProjectMetasByProIDAndKey(Long paramLong, String paramString);

  public abstract List<ProjectMetas> selectProjectMetasByObj(ProjectMetasQuery paramProjectMetasQuery);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.project.ProjectMetasDAO
 * JD-Core Version:    0.6.0
 */