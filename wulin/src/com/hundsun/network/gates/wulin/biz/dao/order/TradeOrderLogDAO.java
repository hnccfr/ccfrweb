package com.hundsun.network.gates.wulin.biz.dao.order;

import com.hundsun.network.gates.wulin.biz.domain.order.TradeOrderLog;
import java.util.List;

public abstract interface TradeOrderLogDAO
{
  public abstract Long insert(TradeOrderLog paramTradeOrderLog);

  public abstract List<TradeOrderLog> selectByOrderNo(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.order.TradeOrderLogDAO
 * JD-Core Version:    0.6.0
 */