package com.hundsun.network.gates.genshan.biz.dao.trade;

import com.hundsun.network.gates.genshan.biz.domain.query.TradeWishOrderQuery;
import com.hundsun.network.gates.genshan.biz.domain.trade.TradeWishOrder;
import java.util.List;

public abstract interface TradeWishOrderDAO
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract void insert(TradeWishOrder paramTradeWishOrder);

  public abstract TradeWishOrder selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKey(TradeWishOrder paramTradeWishOrder);

  public abstract void selectByQuery(TradeWishOrderQuery paramTradeWishOrderQuery);

  public abstract TradeWishOrder selectByWishOrderNum(String paramString);

  public abstract int updateStatusById(TradeWishOrder paramTradeWishOrder);

  public abstract List<String> selectTradeMarkList(TradeWishOrder paramTradeWishOrder);

  public abstract int updateWishOrderInfo(TradeWishOrder paramTradeWishOrder);

  public abstract Integer getNumByQuery(TradeWishOrderQuery paramTradeWishOrderQuery);

  public abstract List<TradeWishOrder> getTradeWishOrderList(TradeWishOrder paramTradeWishOrder);

  public abstract List<TradeWishOrder> selectListInTradeByProjectCode(String paramString);

  public abstract void updateStatusEndAuctionBatch(List<TradeWishOrder> paramList);

  public abstract int cancelCreateTradeWishOrder(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.trade.TradeWishOrderDAO
 * JD-Core Version:    0.6.0
 */