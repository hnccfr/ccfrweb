package com.hundsun.network.gates.genshan.biz.service.project;

import com.hundsun.network.gates.genshan.biz.domain.project.TradeScreen;
import com.hundsun.network.gates.genshan.biz.domain.query.TradeScreenQuery;

public abstract interface ScreenDiyService
{
  public abstract void paginate(TradeScreenQuery<TradeScreen> paramTradeScreenQuery);

  public abstract TradeScreen getTradeScreenById(Long paramLong);

  public abstract void delTradeScreenById(Long paramLong);

  public abstract Long add(TradeScreen paramTradeScreen);

  public abstract Integer edit(TradeScreen paramTradeScreen);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.service.project.ScreenDiyService
 * JD-Core Version:    0.6.0
 */