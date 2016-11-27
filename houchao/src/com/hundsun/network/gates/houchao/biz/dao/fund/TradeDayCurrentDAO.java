package com.hundsun.network.gates.houchao.biz.dao.fund;

import com.hundsun.network.gates.houchao.biz.domain.fund.TradeDayCurrent;

public abstract interface TradeDayCurrentDAO
{
  public abstract TradeDayCurrent getTradeDayCurrent();

  public abstract int editTradeDayCurrent(TradeDayCurrent paramTradeDayCurrent);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\houchao\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.houchao.biz.dao.fund.TradeDayCurrentDAO
 * JD-Core Version:    0.6.0
 */