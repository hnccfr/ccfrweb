package com.hundsun.network.gates.wangjiang.biz.service.trade;

import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
import com.hundsun.network.gates.luosi.wangjiang.reomte.dto.PlaceOrderDTO;

public abstract interface TradeService
{
  public abstract ServiceResult bargain(PlaceOrderDTO paramPlaceOrderDTO);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wangjiang.biz.service.trade.TradeService
 * JD-Core Version:    0.6.0
 */