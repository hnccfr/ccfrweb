package com.hundsun.network.gates.fengshan.biz.dao.order;

import com.hundsun.network.gates.fengshan.biz.domain.order.TradeOrderCc;
import com.hundsun.network.gates.fengshan.biz.domain.query.TradeOrderCcQuery;

public abstract interface TradeOrderCcDAO
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract TradeOrderCc selectByPrimaryKey(Long paramLong);

  public abstract void selectedByQuery(TradeOrderCcQuery paramTradeOrderCcQuery);

  public abstract TradeOrderCc selectedByNum(String paramString);

  public abstract Integer getNumByQuery(TradeOrderCcQuery paramTradeOrderCcQuery);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.dao.order.TradeOrderCcDAO
 * JD-Core Version:    0.6.0
 */