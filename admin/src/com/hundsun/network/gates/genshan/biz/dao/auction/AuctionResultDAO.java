package com.hundsun.network.gates.genshan.biz.dao.auction;

import com.hundsun.network.gates.genshan.biz.domain.auction.AuctionResult;

public abstract interface AuctionResultDAO
{
  public abstract AuctionResult selectByProjectCode(String paramString);

  public abstract void insert(AuctionResult paramAuctionResult);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy15\genshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.genshan.biz.dao.auction.AuctionResultDAO
 * JD-Core Version:    0.6.0
 */