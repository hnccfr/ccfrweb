package com.hundsun.network.gates.genshan.biz.dao.sysmemlevel;

import com.hundsun.network.gates.genshan.biz.domain.baseset.SystemMemberlevelSet;
import com.hundsun.network.gates.genshan.biz.domain.query.SystemMemberlevelSetQuery;
import java.util.List;

public abstract interface SystemMemberlevelSetDAO
{
  public abstract void selectPageList(SystemMemberlevelSetQuery paramSystemMemberlevelSetQuery);

  public abstract List<SystemMemberlevelSet> selectConditionList(SystemMemberlevelSetQuery paramSystemMemberlevelSetQuery);

  public abstract int checkIntegralRange(SystemMemberlevelSetQuery paramSystemMemberlevelSetQuery);

  public abstract int selectConditionCount(SystemMemberlevelSetQuery paramSystemMemberlevelSetQuery);

  public abstract List<SystemMemberlevelSet> selectSystemMemberlevelList();

  public abstract void insert(SystemMemberlevelSet paramSystemMemberlevelSet);

  public abstract SystemMemberlevelSet selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKey(SystemMemberlevelSet paramSystemMemberlevelSet);

  public abstract int updateBySelective(SystemMemberlevelSet paramSystemMemberlevelSet);

  public abstract SystemMemberlevelSet selectByLevelNum(SystemMemberlevelSetQuery paramSystemMemberlevelSetQuery);

  public abstract SystemMemberlevelSet selectByIntegral(int paramInt);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.sysmemlevel.SystemMemberlevelSetDAO
 * JD-Core Version:    0.6.0
 */