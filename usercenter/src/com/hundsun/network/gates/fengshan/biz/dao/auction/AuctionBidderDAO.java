package com.hundsun.network.gates.fengshan.biz.dao.auction;

import com.hundsun.network.gates.fengshan.biz.domain.auction.AuctionBidder;
import com.hundsun.network.gates.fengshan.biz.domain.query.AuctionBidderQuery;

public abstract interface AuctionBidderDAO
{
  public abstract Long selectByCondition(AuctionBidderQuery paramAuctionBidderQuery);

  public abstract int changeStatusByBidderAccount(AuctionBidder paramAuctionBidder);

  public abstract void selectByQuery(AuctionBidderQuery paramAuctionBidderQuery);

  public abstract Long selectCountOfOneBidder(AuctionBidder paramAuctionBidder);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.dao.auction.AuctionBidderDAO
 * JD-Core Version:    0.6.0
 */