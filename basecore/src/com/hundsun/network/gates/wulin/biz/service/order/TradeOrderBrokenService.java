package com.hundsun.network.gates.wulin.biz.service.order;

import com.hundsun.network.gates.luosi.wulin.reomte.request.TradeOrderBaseRequest;
import com.hundsun.network.gates.luosi.wulin.reomte.result.TradeOrderFinishedServiceResult;

public abstract interface TradeOrderBrokenService
{
  public abstract TradeOrderFinishedServiceResult dealBroken(TradeOrderBaseRequest paramTradeOrderBaseRequest);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.order.TradeOrderBrokenService
 * JD-Core Version:    0.6.0
 */