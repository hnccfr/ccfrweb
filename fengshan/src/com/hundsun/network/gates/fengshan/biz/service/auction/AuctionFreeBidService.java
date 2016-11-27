package com.hundsun.network.gates.fengshan.biz.service.auction;

import com.hundsun.network.gates.fengshan.biz.domain.auction.AuctionFreeBid;
import com.hundsun.network.gates.luosi.common.remote.ServiceResult;

public abstract interface AuctionFreeBidService
{
  public abstract ServiceResult freeBid(AuctionFreeBid paramAuctionFreeBid, String paramString);

  public abstract AuctionFreeBid latestFreeBid(String paramString);

  public abstract ServiceResult canFreeBid(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.service.auction.AuctionFreeBidService
 * JD-Core Version:    0.6.0
 */