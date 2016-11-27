package com.hundsun.network.gates.genshan.biz.dao.project;

import com.hundsun.network.gates.genshan.biz.domain.project.ProjectStandard;
import com.hundsun.network.gates.genshan.biz.domain.query.ProjectStandardQuery;
import java.util.List;

public abstract interface ProjectStandardDAO
{
  public abstract void selectPageList(ProjectStandardQuery paramProjectStandardQuery);

  public abstract List<ProjectStandard> selectStandardList();

  public abstract List<ProjectStandard> selectStandardListBySelective(ProjectStandard paramProjectStandard);

  public abstract void insert(ProjectStandard paramProjectStandard);

  public abstract ProjectStandard selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKey(ProjectStandard paramProjectStandard);

  public abstract int setenableStatus(Long paramLong, String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.project.ProjectStandardDAO
 * JD-Core Version:    0.6.0
 */