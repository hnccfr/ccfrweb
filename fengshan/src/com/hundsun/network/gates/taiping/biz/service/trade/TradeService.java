package com.hundsun.network.gates.taiping.biz.service.trade;

import com.hundsun.network.gates.luosi.taiping.reomte.result.OrderServiceResult;

public abstract interface TradeService<T>
{
  public abstract OrderServiceResult bargain(String paramString, T paramT);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.taiping.biz.service.trade.TradeService
 * JD-Core Version:    0.6.0
 */