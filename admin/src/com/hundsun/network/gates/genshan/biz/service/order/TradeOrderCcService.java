package com.hundsun.network.gates.genshan.biz.service.order;

import com.hundsun.network.gates.genshan.biz.domain.order.TradeOrderCc;
import com.hundsun.network.gates.genshan.biz.domain.query.TradeOrderCcQuery;
import com.hundsun.network.gates.luosi.common.enums.EnumTradeOrderCcDealType;
import com.hundsun.network.gates.luosi.wulin.reomte.result.TradeOrderCcServiceResult;

public abstract interface TradeOrderCcService
{
  public abstract void getTradeOrderCcByQuery(TradeOrderCcQuery paramTradeOrderCcQuery);

  public abstract TradeOrderCc getTradeOrderCcByNum(String paramString);

  public abstract TradeOrderCcServiceResult updateByOrderCcNum(TradeOrderCc paramTradeOrderCc);

  public abstract EnumTradeOrderCcDealType[] getAvailableDealTypes(String paramString);

  public abstract Long getOrderAmount(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.service.order.TradeOrderCcService
 * JD-Core Version:    0.6.0
 */