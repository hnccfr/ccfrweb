package com.hundsun.network.gates.genshan.biz.dao.trade;

import com.hundsun.network.gates.genshan.biz.domain.query.TradeSubstationQuery;
import com.hundsun.network.gates.genshan.biz.domain.trade.TradeSubstation;

public abstract interface TradeSubstationDAO
{
  public abstract int deleteById(Long paramLong);

  public abstract Integer insert(TradeSubstation paramTradeSubstation);

  public abstract void selectByQuery(TradeSubstationQuery paramTradeSubstationQuery);

  public abstract int updateById(TradeSubstation paramTradeSubstation);

  public abstract TradeSubstation getTradeSubstationById(Long paramLong);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.trade.TradeSubstationDAO
 * JD-Core Version:    0.6.0
 */