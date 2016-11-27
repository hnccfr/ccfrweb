package com.hundsun.network.gates.fengshan.biz.dao.auction;

import com.hundsun.network.gates.fengshan.biz.domain.auction.AuctionHall;

public abstract interface AuctionHallDAO
{
  public abstract AuctionHall selectByProjectCode(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.dao.auction.AuctionHallDAO
 * JD-Core Version:    0.6.0
 */