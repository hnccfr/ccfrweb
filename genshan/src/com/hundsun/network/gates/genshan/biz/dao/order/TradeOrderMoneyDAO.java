package com.hundsun.network.gates.genshan.biz.dao.order;

import com.hundsun.network.gates.genshan.biz.domain.order.TradeOrderMoney;
import com.hundsun.network.gates.genshan.biz.domain.query.TradeOrderMoneyQuery;
import java.util.List;

public abstract interface TradeOrderMoneyDAO
{
  public abstract List<TradeOrderMoney> selectByCondition(TradeOrderMoneyQuery paramTradeOrderMoneyQuery);

  public abstract TradeOrderMoney selectByAccountOrderNo(String paramString1, String paramString2);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.order.TradeOrderMoneyDAO
 * JD-Core Version:    0.6.0
 */