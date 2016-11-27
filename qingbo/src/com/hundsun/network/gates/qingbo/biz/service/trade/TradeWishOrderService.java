package com.hundsun.network.gates.qingbo.biz.service.trade;

import com.hundsun.network.gates.luosi.wulin.reomte.dto.TradeWishOrderDTO;
import com.hundsun.network.gates.luosi.wulin.reomte.result.TradeWishOrderServiceResult;
import com.hundsun.network.gates.qingbo.biz.domain.trade.TradeWishOrder;
import java.util.List;

public abstract interface TradeWishOrderService
{
  public abstract TradeWishOrderServiceResult addTradeWishOrder(TradeWishOrder paramTradeWishOrder)
    throws Exception;

  public abstract List<TradeWishOrderDTO> selectLatestTradeWishOrder(int paramInt);

  public abstract String generalWishOrderNo();

  public abstract boolean deleteTradeWishOrderByNo(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.qingbo.biz.service.trade.TradeWishOrderService
 * JD-Core Version:    0.6.0
 */