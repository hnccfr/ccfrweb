package com.hundsun.network.gates.qingbo.biz.dao.trade;

import com.hundsun.network.gates.qingbo.biz.domain.trade.TradeWishOrder;
import java.util.List;

public abstract interface TradeWishOrderDAO
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract Long insert(TradeWishOrder paramTradeWishOrder);

  public abstract void insertSelective(TradeWishOrder paramTradeWishOrder);

  public abstract TradeWishOrder selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(TradeWishOrder paramTradeWishOrder);

  public abstract int updateByPrimaryKey(TradeWishOrder paramTradeWishOrder);

  public abstract List<TradeWishOrder> selectListByProjectCode(String paramString);

  public abstract List<TradeWishOrder> selectBSUListByProjectCode(String paramString);

  public abstract List<TradeWishOrder> selectLatestTradeWishOrder(int paramInt);

  public abstract String generalWishOrderNo();

  public abstract List<TradeWishOrder> selectListInTradeByProjectCode(String paramString);

  public abstract void updateWishOrderStatusBatch(List<TradeWishOrder> paramList);

  public abstract void updateStatusEndAuctionBatch(List<TradeWishOrder> paramList);

  public abstract int cancelCreateTradeWishOrder(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.qingbo.biz.dao.trade.TradeWishOrderDAO
 * JD-Core Version:    0.6.0
 */