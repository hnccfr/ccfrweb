package com.hundsun.network.gates.genshan.biz.dao.project;

import com.hundsun.network.gates.genshan.biz.domain.project.ProjectMetas;
import java.util.List;

public abstract interface ProjectMetasDAO
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract void insert(ProjectMetas paramProjectMetas);

  public abstract void insertSelective(ProjectMetas paramProjectMetas);

  public abstract int updateByPrimaryKeySelective(ProjectMetas paramProjectMetas);

  public abstract int updateByPrimaryKey(ProjectMetas paramProjectMetas);

  public abstract List<ProjectMetas> selectByProjectId(Long paramLong);

  public abstract List<ProjectMetas> getMetasByProjectIdAndMetaGroup(Long paramLong, String paramString);

  public abstract List<ProjectMetas> getProjectMetasByProId(Long paramLong);

  public abstract String selectOneMetaValue(ProjectMetas paramProjectMetas);

  public abstract Integer selectNumByProjectId(Long paramLong);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.project.ProjectMetasDAO
 * JD-Core Version:    0.6.0
 */