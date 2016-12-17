package com.hundsun.network.gates.taiping.biz.service.trade;

import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
import com.hundsun.network.gates.taiping.biz.domain.placeorder.PlaceOrderInput;

public abstract interface PlaceOrderService
{
  public abstract ServiceResult bargain(PlaceOrderInput paramPlaceOrderInput);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.taiping.biz.service.trade.PlaceOrderService
 * JD-Core Version:    0.6.0
 */