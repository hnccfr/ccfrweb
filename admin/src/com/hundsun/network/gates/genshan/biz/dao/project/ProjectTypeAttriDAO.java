package com.hundsun.network.gates.genshan.biz.dao.project;

import com.hundsun.network.gates.genshan.biz.domain.project.ProjectTypeAttri;
import java.util.List;
import java.util.Map;

public abstract interface ProjectTypeAttriDAO
{
  public abstract List<ProjectTypeAttri> getProjectAttriListByQuery(List<String> paramList);

  public abstract List<ProjectTypeAttri> getProjectAttriListBySelective(Map<String, Object> paramMap);

  public abstract void insert(ProjectTypeAttri paramProjectTypeAttri);

  public abstract ProjectTypeAttri selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKey(ProjectTypeAttri paramProjectTypeAttri);

  public abstract int updateEnableStatus(Long paramLong1, Long paramLong2);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.project.ProjectTypeAttriDAO
 * JD-Core Version:    0.6.0
 */