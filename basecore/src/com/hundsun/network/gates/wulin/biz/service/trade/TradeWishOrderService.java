package com.hundsun.network.gates.wulin.biz.service.trade;

import com.hundsun.network.gates.luosi.wulin.reomte.dto.TradeWishOrderDTO;
import com.hundsun.network.gates.luosi.wulin.reomte.result.TradeWishOrderServiceResult;
import com.hundsun.network.gates.wulin.biz.domain.trade.TradeWishOrder;
import java.util.List;

public abstract interface TradeWishOrderService
{
  public abstract TradeWishOrderServiceResult addTradeWishOrder(TradeWishOrder paramTradeWishOrder);

  public abstract List<TradeWishOrderDTO> selectLatestTradeWishOrder(int paramInt);

  public abstract String generalWishOrderNo();
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.service.trade.TradeWishOrderService
 * JD-Core Version:    0.6.0
 */