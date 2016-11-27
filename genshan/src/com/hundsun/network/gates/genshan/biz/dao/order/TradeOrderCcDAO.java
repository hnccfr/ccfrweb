package com.hundsun.network.gates.genshan.biz.dao.order;

import com.hundsun.network.gates.genshan.biz.domain.order.TradeOrderCc;
import com.hundsun.network.gates.genshan.biz.domain.query.TradeOrderCcQuery;

public abstract interface TradeOrderCcDAO
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract TradeOrderCc selectByPrimaryKey(Long paramLong);

  public abstract void selectedByQuery(TradeOrderCcQuery paramTradeOrderCcQuery);

  public abstract TradeOrderCc selectedByNum(String paramString);

  public abstract Integer getNumByQuery(TradeOrderCcQuery paramTradeOrderCcQuery);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.order.TradeOrderCcDAO
 * JD-Core Version:    0.6.0
 */