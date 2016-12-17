package com.hundsun.network.gates.wulin.biz.dao.order;

import com.hundsun.network.gates.wulin.biz.domain.order.TradeRefund;
import com.hundsun.network.gates.wulin.biz.domain.query.TradeRefundQuery;
import java.util.List;

public abstract interface TradeRefundDAO
{
  public abstract Long insert(TradeRefund paramTradeRefund);

  public abstract int updateByPrimaryKey(TradeRefund paramTradeRefund);

  public abstract List<TradeRefund> selectByConf(TradeRefundQuery paramTradeRefundQuery);

  public abstract TradeRefund selectByPrimaryKey(Long paramLong);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.order.TradeRefundDAO
 * JD-Core Version:    0.6.0
 */