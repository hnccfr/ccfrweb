package com.hundsun.network.gates.genshan.biz.dao.project;

import com.hundsun.network.gates.genshan.biz.domain.project.ProjectBaseSetting;
import com.hundsun.network.gates.genshan.biz.domain.query.ProjectBaseSettingQuery;
import java.util.List;

public abstract interface ProjectBaseSettingDAO
{
  public abstract void selectPageList(ProjectBaseSettingQuery paramProjectBaseSettingQuery);

  public abstract List<ProjectBaseSetting> selectProBSListBySelective(ProjectBaseSetting paramProjectBaseSetting);

  public abstract void insert(ProjectBaseSetting paramProjectBaseSetting);

  public abstract ProjectBaseSetting selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKey(ProjectBaseSetting paramProjectBaseSetting);

  public abstract int setenableStatus(Long paramLong, String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.project.ProjectBaseSettingDAO
 * JD-Core Version:    0.6.0
 */