package com.hundsun.network.gates.genshan.biz.service.trade;

import com.hundsun.network.gates.genshan.biz.domain.query.TradeWishOrderQuery;
import com.hundsun.network.gates.genshan.biz.domain.trade.TradeWishOrder;
import java.util.List;

public abstract interface TradeWishOrderService
{
  public abstract void getTradeWishOrderByQuery(TradeWishOrderQuery paramTradeWishOrderQuery);

  public abstract TradeWishOrder getTradeWishOrderByWishOrderNum(String paramString);

  public abstract int auditTradeWishOrder(TradeWishOrder paramTradeWishOrder);

  public abstract List<String> getTradeMarkOfOneProject(TradeWishOrder paramTradeWishOrder);

  public abstract List<TradeWishOrder> getTradeWishOrderList(TradeWishOrder paramTradeWishOrder);

  public abstract TradeWishOrder getTradeWishOrderById(Long paramLong);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.service.trade.TradeWishOrderService
 * JD-Core Version:    0.6.0
 */