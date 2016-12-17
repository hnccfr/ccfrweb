package com.hundsun.network.gates.wulin.biz.dao.trade;

import com.hundsun.network.gates.wulin.biz.domain.trade.TradeWishOrder;
import java.util.List;
import java.util.Map;

public abstract interface TradeWishOrderDAO
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract Long insert(TradeWishOrder paramTradeWishOrder);

  public abstract void insertSelective(TradeWishOrder paramTradeWishOrder);

  public abstract TradeWishOrder selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(TradeWishOrder paramTradeWishOrder);

  public abstract int updateByPrimaryKey(TradeWishOrder paramTradeWishOrder);

  public abstract int getTradeWishOrderCountByDate();

  public abstract List<TradeWishOrder> selectListByProjectCode(String paramString);

  public abstract List<TradeWishOrder> selectLatestTradeWishOrder(int paramInt);

  public abstract String generalWishOrderNo();

  public abstract List<TradeWishOrder> selectListInTradeByProjectCode(String paramString);

  public abstract int selectNumOfUnfinishedWishOrder(String paramString);

  public abstract int cancelCreateTradeWishOrder(String paramString);

  public abstract int updateByProjectCode(Map<String, Object> paramMap);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.trade.TradeWishOrderDAO
 * JD-Core Version:    0.6.0
 */