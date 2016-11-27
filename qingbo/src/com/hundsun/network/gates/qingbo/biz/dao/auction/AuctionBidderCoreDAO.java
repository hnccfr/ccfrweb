package com.hundsun.network.gates.qingbo.biz.dao.auction;

import com.hundsun.network.gates.qingbo.biz.domain.auction.AuctionBidder;

public abstract interface AuctionBidderCoreDAO
{
  public abstract AuctionBidder selectBidderByBidAccountAndProjectCode(String paramString1, String paramString2);

  public abstract int selectBidderNumProjectCode(String paramString);

  public abstract int deleteByProjectCode(String paramString);

  public abstract AuctionBidder selectBidderByBidderTrademarkAndProjectCode(String paramString1, String paramString2);

  public abstract AuctionBidder selectLatestBidder(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\qingbo\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.qingbo.biz.dao.auction.AuctionBidderCoreDAO
 * JD-Core Version:    0.6.0
 */