package com.hundsun.network.gates.wulin.biz.service.trade;

import com.hundsun.network.gates.wulin.biz.domain.trade.TradeTypePropConfig;
import java.util.List;

public abstract interface TradeTypePropConfigService
{
  public abstract List<TradeTypePropConfig> getTradeTypePropList(TradeTypePropConfig paramTradeTypePropConfig);

  public abstract int countByExample(TradeTypePropConfig paramTradeTypePropConfig);

  public abstract int deleteByExample(TradeTypePropConfig paramTradeTypePropConfig);

  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract void insert(TradeTypePropConfig paramTradeTypePropConfig);

  public abstract void insertSelective(TradeTypePropConfig paramTradeTypePropConfig);

  public abstract TradeTypePropConfig selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(TradeTypePropConfig paramTradeTypePropConfig);

  public abstract int updateByPrimaryKey(TradeTypePropConfig paramTradeTypePropConfig);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.trade.TradeTypePropConfigService
 * JD-Core Version:    0.6.0
 */