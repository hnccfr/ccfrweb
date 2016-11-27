package com.hundsun.network.gates.fengshan.biz.dao.project;

import com.hundsun.network.gates.fengshan.biz.domain.project.ProjectType;
import java.util.List;

public abstract interface ProjectTypeDAO
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(ProjectType paramProjectType);

  public abstract ProjectType getProjectTypeByCode(String paramString);

  public abstract List<ProjectType> queryProjectTypeAllChild(String paramString);

  public abstract void insert(ProjectType paramProjectType);

  public abstract int getProjectNumByObj(ProjectType paramProjectType);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.dao.project.ProjectTypeDAO
 * JD-Core Version:    0.6.0
 */