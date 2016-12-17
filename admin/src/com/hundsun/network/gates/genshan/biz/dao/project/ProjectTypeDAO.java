package com.hundsun.network.gates.genshan.biz.dao.project;

import com.hundsun.network.gates.genshan.biz.domain.project.ProjectType;
import java.util.List;

public abstract interface ProjectTypeDAO
{
  public abstract ProjectType getProjectTypeByCode(String paramString);

  public abstract List<ProjectType> getProTypeListBySelective(ProjectType paramProjectType);

  public abstract List<ProjectType> queryProjectTypeAllChild(String paramString);

  public abstract void insert(ProjectType paramProjectType);

  public abstract int getProjectNumByObj(ProjectType paramProjectType);

  public abstract int updateByPrimaryKeySelective(ProjectType paramProjectType);

  public abstract int updateEnableStatus(String paramString, int paramInt);

  public abstract List<ProjectType> getProjectTypeForScreen();
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.project.ProjectTypeDAO
 * JD-Core Version:    0.6.0
 */