package com.hundsun.network.gates.wulin.biz.service.order;

import com.hundsun.network.gates.luosi.common.remote.ServiceResult;

public abstract interface TradeOrderAutoService
{
  public abstract ServiceResult autoOrderOption();

  public abstract ServiceResult dealOrderRemindOption();

  public abstract ServiceResult dealOrderGrnorderOption();

  public abstract ServiceResult dealUncommentOption();
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.order.TradeOrderAutoService
 * JD-Core Version:    0.6.0
 */