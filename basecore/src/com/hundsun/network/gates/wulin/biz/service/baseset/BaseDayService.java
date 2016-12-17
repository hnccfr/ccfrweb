package com.hundsun.network.gates.wulin.biz.service.baseset;

import com.hundsun.network.gates.luosi.wulin.reomte.result.BaseDayServiceResult;
import com.hundsun.network.gates.wulin.biz.domain.baseset.BaseDay;

public abstract interface BaseDayService
{
  public abstract BaseDay getPrevBaseDay(Long paramLong);

  public abstract BaseDay getPrevBaseDay();

  public abstract BaseDay getCurrentBaseDay();

  public abstract BaseDay getNextBaseDay(Long paramLong);

  public abstract BaseDay getNextBaseDay();

  public abstract BaseDayServiceResult selectBaseTradeDay();
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.baseset.BaseDayService
 * JD-Core Version:    0.6.0
 */