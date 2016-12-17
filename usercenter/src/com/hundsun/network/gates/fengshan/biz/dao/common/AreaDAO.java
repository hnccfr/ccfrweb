package com.hundsun.network.gates.fengshan.biz.dao.common;

import com.hundsun.network.gates.fengshan.biz.domain.common.Area;
import java.util.List;

public abstract interface AreaDAO
{
  public abstract int deleteByPrimaryKey(Integer paramInteger);

  public abstract void insert(Area paramArea);

  public abstract Area queryByPrimaryKey(Integer paramInteger);

  public abstract List<Area> queryAll();

  public abstract int updateByPrimaryKey(Area paramArea);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.dao.common.AreaDAO
 * JD-Core Version:    0.6.0
 */