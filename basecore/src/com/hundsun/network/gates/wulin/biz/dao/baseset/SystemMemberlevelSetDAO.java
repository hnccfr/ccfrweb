package com.hundsun.network.gates.wulin.biz.dao.baseset;

import com.hundsun.network.gates.wulin.biz.domain.baseset.SystemMemberlevelSet;
import java.util.List;

public abstract interface SystemMemberlevelSetDAO
{
  public abstract List<SystemMemberlevelSet> selectAll();

  public abstract SystemMemberlevelSet selectInitLevel();

  public abstract SystemMemberlevelSet selectByIntegral(int paramInt);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.baseset.SystemMemberlevelSetDAO
 * JD-Core Version:    0.6.0
 */