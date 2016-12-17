package com.hundsun.network.gates.fengshan.biz.service.order;

import com.hundsun.network.gates.fengshan.biz.domain.order.TradeOrderCc;
import com.hundsun.network.gates.fengshan.biz.domain.query.TradeOrderCcQuery;
import com.hundsun.network.gates.luosi.common.enums.EnumTradeOrderCcType;
import com.hundsun.network.gates.luosi.wulin.reomte.result.TradeOrderCcServiceResult;

public abstract interface TradeOrderCcService
{
  public abstract TradeOrderCcServiceResult addTradeOrderCc(TradeOrderCc paramTradeOrderCc);

  public abstract void getTradeOrderCcByQuery(TradeOrderCcQuery paramTradeOrderCcQuery);

  public abstract TradeOrderCc getTradeOrderCcByNum(String paramString);

  public abstract TradeOrderCcServiceResult updateByOrderCcNum(TradeOrderCc paramTradeOrderCc, String paramString);

  public abstract EnumTradeOrderCcType[] getAvailableCcTypes(String paramString1, String paramString2, String paramString3);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.service.order.TradeOrderCcService
 * JD-Core Version:    0.6.0
 */