package com.hundsun.network.gates.wulin.biz.dao.baseset;

import com.hundsun.network.gates.wulin.biz.domain.baseset.BaseDay;
import java.util.List;
import java.util.Map;

public abstract interface BaseDayDAO
{
  public abstract void addBaseDay(BaseDay paramBaseDay);

  public abstract void removeBaseDay(Long paramLong);

  public abstract void editBaseDay(BaseDay paramBaseDay);

  public abstract List<BaseDay> getBaseDay(BaseDay paramBaseDay);

  public abstract int removeBaseDayByYear(BaseDay paramBaseDay);

  public abstract BaseDay getPrevBaseDay(Map<String, Object> paramMap);

  public abstract BaseDay getCurrentBaseDay();

  public abstract BaseDay getNextBaseDay(Map<String, Object> paramMap);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.baseset.BaseDayDAO
 * JD-Core Version:    0.6.0
 */