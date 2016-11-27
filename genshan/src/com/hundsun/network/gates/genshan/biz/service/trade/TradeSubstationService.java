package com.hundsun.network.gates.genshan.biz.service.trade;

import com.hundsun.network.gates.genshan.biz.domain.query.TradeSubstationQuery;
import com.hundsun.network.gates.genshan.biz.domain.trade.TradeSubstation;

public abstract interface TradeSubstationService
{
  public abstract void getTradeSubstationList(TradeSubstationQuery paramTradeSubstationQuery);

  public abstract TradeSubstation getTradeSubstationById(Long paramLong);

  public abstract Integer insert(TradeSubstation paramTradeSubstation);

  public abstract Integer update(TradeSubstation paramTradeSubstation);

  public abstract Integer delete(Long paramLong);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.service.trade.TradeSubstationService
 * JD-Core Version:    0.6.0
 */