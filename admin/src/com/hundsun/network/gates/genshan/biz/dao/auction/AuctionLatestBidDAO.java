package com.hundsun.network.gates.genshan.biz.dao.auction;

import com.hundsun.network.gates.genshan.biz.domain.auction.AuctionLatestBid;
import java.util.List;

public abstract interface AuctionLatestBidDAO
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract Long insert(AuctionLatestBid paramAuctionLatestBid);

  public abstract AuctionLatestBid selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(AuctionLatestBid paramAuctionLatestBid);

  public abstract void batchInsert(List<AuctionLatestBid> paramList);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.auction.AuctionLatestBidDAO
 * JD-Core Version:    0.6.0
 */