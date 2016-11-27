package com.hundsun.network.gates.wulin.biz.dao.auction;

import com.hundsun.network.gates.wulin.biz.domain.auction.AuctionBidder;

public abstract interface AuctionBidderDAO
{
  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract Long insert(AuctionBidder paramAuctionBidder);

  public abstract AuctionBidder selectByPrimaryKey(Long paramLong);

  public abstract int updateByPrimaryKeySelective(AuctionBidder paramAuctionBidder);

  public abstract int deleteByProjectCode(String paramString);

  public abstract int deleteByBidderAccount(String paramString1, String paramString2);

  public abstract AuctionBidder selectNormalByBidderAccount(String paramString1, String paramString2);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy16\wulin\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.wulin.biz.dao.auction.AuctionBidderDAO
 * JD-Core Version:    0.6.0
 */