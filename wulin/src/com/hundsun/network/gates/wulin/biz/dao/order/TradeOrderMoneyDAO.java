package com.hundsun.network.gates.wulin.biz.dao.order;

import com.hundsun.network.gates.wulin.biz.domain.order.TradeOrderMoney;
import com.hundsun.network.gates.wulin.biz.domain.query.TradeOrderMoneyQuery;
import java.util.List;

public abstract interface TradeOrderMoneyDAO
{
  public abstract Long insert(TradeOrderMoney paramTradeOrderMoney);

  public abstract List<TradeOrderMoney> selectByCondition(TradeOrderMoneyQuery paramTradeOrderMoneyQuery);

  public abstract TradeOrderMoney selectByAccountOrderNo(String paramString1, String paramString2);

  public abstract int updateBySelective(TradeOrderMoney paramTradeOrderMoney);

  public abstract int deleteByOrderNo(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.order.TradeOrderMoneyDAO
 * JD-Core Version:    0.6.0
 */