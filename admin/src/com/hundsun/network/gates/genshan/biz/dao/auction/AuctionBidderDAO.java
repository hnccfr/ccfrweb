package com.hundsun.network.gates.genshan.biz.dao.auction;

import com.hundsun.network.gates.genshan.biz.domain.auction.AuctionBidder;
import java.util.List;

public abstract interface AuctionBidderDAO
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract void insert(AuctionBidder paramAuctionBidder);

  public abstract AuctionBidder selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(AuctionBidder paramAuctionBidder);

  public abstract void batchInsert(List<AuctionBidder> paramList);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.auction.AuctionBidderDAO
 * JD-Core Version:    0.6.0
 */