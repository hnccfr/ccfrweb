package com.hundsun.network.gates.wulin.biz.service.order;

import com.hundsun.network.gates.luosi.wulin.reomte.request.TradeOrderCcRequest;
import com.hundsun.network.gates.luosi.wulin.reomte.result.TradeOrderCcServiceResult;

public abstract interface TradeOrderCcService
{
  public abstract TradeOrderCcServiceResult addTradeOrderCc(TradeOrderCcRequest paramTradeOrderCcRequest);

  public abstract TradeOrderCcServiceResult updateTradeOrderCc(TradeOrderCcRequest paramTradeOrderCcRequest);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.order.TradeOrderCcService
 * JD-Core Version:    0.6.0
 */