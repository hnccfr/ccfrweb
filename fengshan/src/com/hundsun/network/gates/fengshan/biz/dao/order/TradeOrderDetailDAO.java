package com.hundsun.network.gates.fengshan.biz.dao.order;

import com.hundsun.network.gates.fengshan.biz.domain.order.TradeOrderDetail;
import java.util.Map;

public abstract interface TradeOrderDetailDAO
{
  public abstract TradeOrderDetail selectByOrderNo(String paramString);

  public abstract TradeOrderDetail selectOrderByMapParam(Map<String, Object> paramMap);

  public abstract int updateByOrderNo(TradeOrderDetail paramTradeOrderDetail);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.dao.order.TradeOrderDetailDAO
 * JD-Core Version:    0.6.0
 */