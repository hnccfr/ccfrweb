package com.hundsun.network.gates.wangjiang.biz.dao.auction;

import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionLatestBid;

public abstract interface AuctionLatestBidDAO
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract void insert(AuctionLatestBid paramAuctionLatestBid);

  public abstract AuctionLatestBid selectByPrimaryKey(Long paramLong);

  public abstract AuctionLatestBid selectLBByProjectCode(String paramString);

  public abstract int updateByPrimaryKeySelective(AuctionLatestBid paramAuctionLatestBid);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wangjiang.biz.dao.auction.AuctionLatestBidDAO
 * JD-Core Version:    0.6.0
 */