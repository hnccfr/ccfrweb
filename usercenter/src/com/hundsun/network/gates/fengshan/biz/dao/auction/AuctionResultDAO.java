package com.hundsun.network.gates.fengshan.biz.dao.auction;

import com.hundsun.network.gates.fengshan.biz.domain.auction.AuctionResult;

public abstract interface AuctionResultDAO
{
  public abstract AuctionResult selectByProjectCode(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.dao.auction.AuctionResultDAO
 * JD-Core Version:    0.6.0
 */