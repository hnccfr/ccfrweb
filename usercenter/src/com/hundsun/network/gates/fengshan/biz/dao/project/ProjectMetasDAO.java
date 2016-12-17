package com.hundsun.network.gates.fengshan.biz.dao.project;

import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectMetas;
import java.util.List;

public abstract interface ProjectMetasDAO
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract void insert(ProjectMetas paramProjectMetas);

  public abstract void insertSelective(ProjectMetas paramProjectMetas);

  public abstract int updateByPrimaryKeySelective(ProjectMetas paramProjectMetas);

  public abstract int updateByPrimaryKey(ProjectMetas paramProjectMetas);

  public abstract List<ProjectMetas> selectByProjectId(Long paramLong);

  public abstract String selectMetaValue(ProjectMetas paramProjectMetas);

  public abstract List<ProjectMetas> getMetasByProjectIdAndMetaGroup(Long paramLong, String paramString);

  public abstract Integer selectNumByProjectId(Long paramLong);

  public abstract Integer selectAfterApplyStartTime(Long paramLong);

  public abstract Integer selectBeforeApplyEndTime(Long paramLong);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.dao.project.ProjectMetasDAO
 * JD-Core Version:    0.6.0
 */