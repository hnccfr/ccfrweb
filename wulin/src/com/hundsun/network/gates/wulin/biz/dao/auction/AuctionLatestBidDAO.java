package com.hundsun.network.gates.wulin.biz.dao.auction;

import com.hundsun.network.gates.wulin.biz.domain.auction.AuctionLatestBid;

public abstract interface AuctionLatestBidDAO
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract void insert(AuctionLatestBid paramAuctionLatestBid);

  public abstract AuctionLatestBid selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(AuctionLatestBid paramAuctionLatestBid);

  public abstract int deleteByProjectCode(String paramString);

  public abstract AuctionLatestBid selectByProjectCode(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.auction.AuctionLatestBidDAO
 * JD-Core Version:    0.6.0
 */