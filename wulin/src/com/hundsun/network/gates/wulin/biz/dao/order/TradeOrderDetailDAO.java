package com.hundsun.network.gates.wulin.biz.dao.order;

import com.hundsun.network.gates.wulin.biz.domain.order.TradeOrderDetail;

public abstract interface TradeOrderDetailDAO
{
  public abstract Long insert(TradeOrderDetail paramTradeOrderDetail);

  public abstract int updateByOrderNo(TradeOrderDetail paramTradeOrderDetail);

  public abstract TradeOrderDetail selectByOrderNo(String paramString);

  public abstract int deleteByOrderNo(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.order.TradeOrderDetailDAO
 * JD-Core Version:    0.6.0
 */