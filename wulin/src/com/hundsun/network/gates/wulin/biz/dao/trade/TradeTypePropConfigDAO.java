package com.hundsun.network.gates.wulin.biz.dao.trade;

import com.hundsun.network.gates.wulin.biz.domain.trade.TradeTypePropConfig;
import java.util.List;

public abstract interface TradeTypePropConfigDAO
{
  public abstract int countByExample(TradeTypePropConfig paramTradeTypePropConfig);

  public abstract int deleteByExample(TradeTypePropConfig paramTradeTypePropConfig);

  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract void insert(TradeTypePropConfig paramTradeTypePropConfig);

  public abstract void insertSelective(TradeTypePropConfig paramTradeTypePropConfig);

  public abstract List selectByExample(TradeTypePropConfig paramTradeTypePropConfig);

  public abstract TradeTypePropConfig selectByPrimaryKey(Long paramLong);

  public abstract int updateByExampleSelective(TradeTypePropConfig paramTradeTypePropConfig1, TradeTypePropConfig paramTradeTypePropConfig2);

  public abstract int updateByExample(TradeTypePropConfig paramTradeTypePropConfig1, TradeTypePropConfig paramTradeTypePropConfig2);

  public abstract int updateByPrimaryKeySelective(TradeTypePropConfig paramTradeTypePropConfig);

  public abstract int updateByPrimaryKey(TradeTypePropConfig paramTradeTypePropConfig);

  public abstract List<TradeTypePropConfig> getTradeTypePropList(TradeTypePropConfig paramTradeTypePropConfig);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.trade.TradeTypePropConfigDAO
 * JD-Core Version:    0.6.0
 */