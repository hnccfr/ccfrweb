package com.hundsun.network.gates.wulin.biz.dao.auction;

import com.hundsun.network.gates.wulin.biz.domain.auction.AuctionResult;

public abstract interface AuctionResultDAO
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract void insert(AuctionResult paramAuctionResult);

  public abstract AuctionResult selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(AuctionResult paramAuctionResult);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.auction.AuctionResultDAO
 * JD-Core Version:    0.6.0
 */