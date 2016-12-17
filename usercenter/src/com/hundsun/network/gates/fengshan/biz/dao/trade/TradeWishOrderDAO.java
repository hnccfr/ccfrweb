package com.hundsun.network.gates.fengshan.biz.dao.trade;

import com.hundsun.network.gates.fengshan.biz.domain.query.TradeWishOrderQuery;
import com.hundsun.network.gates.fengshan.biz.domain.trade.TradeWishOrder;
import java.util.Map;

public abstract interface TradeWishOrderDAO
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract Long insert(TradeWishOrder paramTradeWishOrder);

  public abstract void insertSelective(TradeWishOrder paramTradeWishOrder);

  public abstract TradeWishOrder selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(TradeWishOrder paramTradeWishOrder);

  public abstract int updateByPrimaryKey(TradeWishOrder paramTradeWishOrder);

  public abstract void selectByQuery(TradeWishOrderQuery paramTradeWishOrderQuery);

  public abstract TradeWishOrder selectByOrderNum(String paramString);

  public abstract String selectWishOrderNo();

  public abstract int updateStatusByOrderNum(TradeWishOrder paramTradeWishOrder);

  public abstract int selectCountOfOne(TradeWishOrder paramTradeWishOrder);

  public abstract int existsWishOrderBidBuyer(Map paramMap);

  public abstract Integer getNumByQuery(TradeWishOrderQuery paramTradeWishOrderQuery);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.dao.trade.TradeWishOrderDAO
 * JD-Core Version:    0.6.0
 */