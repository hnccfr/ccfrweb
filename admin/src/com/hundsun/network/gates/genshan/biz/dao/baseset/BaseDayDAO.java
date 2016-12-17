package com.hundsun.network.gates.genshan.biz.dao.baseset;

import com.hundsun.network.gates.genshan.biz.domain.baseset.BaseDay;
import java.util.List;

public abstract interface BaseDayDAO
{
  public abstract void addBaseDay(BaseDay paramBaseDay);

  public abstract void addBaseDay(List<BaseDay> paramList);

  public abstract void removeBaseDay(Long paramLong);

  public abstract void editBaseDay(BaseDay paramBaseDay);

  public abstract List<BaseDay> getBaseDay(BaseDay paramBaseDay);

  public abstract int removeBaseDayByYear(BaseDay paramBaseDay);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.baseset.BaseDayDAO
 * JD-Core Version:    0.6.0
 */