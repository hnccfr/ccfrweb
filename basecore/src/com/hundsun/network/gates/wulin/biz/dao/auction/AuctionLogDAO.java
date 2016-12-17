package com.hundsun.network.gates.wulin.biz.dao.auction;

import com.hundsun.network.gates.wulin.biz.domain.auction.AuctionLog;

public abstract interface AuctionLogDAO
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract void insert(AuctionLog paramAuctionLog);

  public abstract AuctionLog selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(AuctionLog paramAuctionLog);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.auction.AuctionLogDAO
 * JD-Core Version:    0.6.0
 */