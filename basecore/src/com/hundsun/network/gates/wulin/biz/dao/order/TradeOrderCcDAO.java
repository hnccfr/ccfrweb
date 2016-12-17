package com.hundsun.network.gates.wulin.biz.dao.order;

import com.hundsun.network.gates.wulin.biz.domain.order.TradeOrderCc;
import java.util.List;

public abstract interface TradeOrderCcDAO
{
  public abstract String generalOrderCcNum();

  public abstract Long insert(TradeOrderCc paramTradeOrderCc);

  public abstract TradeOrderCc selectByOrderCcNum(String paramString);

  public abstract int updateByOrderCcNum(TradeOrderCc paramTradeOrderCc);

  public abstract List<TradeOrderCc> selectByOrderCc(TradeOrderCc paramTradeOrderCc);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.order.TradeOrderCcDAO
 * JD-Core Version:    0.6.0
 */