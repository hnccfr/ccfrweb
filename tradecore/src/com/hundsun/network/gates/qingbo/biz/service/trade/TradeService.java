package com.hundsun.network.gates.qingbo.biz.service.trade;

import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
import com.hundsun.network.gates.luosi.qingbo.reomte.request.TradeProjectAvailableCheckRequest;
import com.hundsun.network.gates.luosi.qingbo.reomte.request.TradeUserAvailableCheckRequest;

public abstract interface TradeService
{
  public abstract ServiceResult checkUserAvailable(TradeUserAvailableCheckRequest paramTradeUserAvailableCheckRequest);

  public abstract ServiceResult checkProjectAvailable(TradeProjectAvailableCheckRequest paramTradeProjectAvailableCheckRequest);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.qingbo.biz.service.trade.TradeService
 * JD-Core Version:    0.6.0
 */