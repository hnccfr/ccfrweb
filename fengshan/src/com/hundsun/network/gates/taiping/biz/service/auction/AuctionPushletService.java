package com.hundsun.network.gates.taiping.biz.service.auction;

import com.hundsun.network.gates.luosi.wangjiang.reomte.request.AuctionMessageServiceRequest;
import com.hundsun.network.gates.luosi.wangjiang.reomte.request.AuctionResultServiceRequest;
import com.hundsun.network.gates.luosi.wangjiang.reomte.request.HallDataServiceRequest;

public abstract interface AuctionPushletService
{
  public abstract void sendAuctionLatestBid(HallDataServiceRequest paramHallDataServiceRequest);

  public abstract void sendAuctionResult(AuctionResultServiceRequest paramAuctionResultServiceRequest);

  public abstract void sendAuctionMessage(AuctionMessageServiceRequest paramAuctionMessageServiceRequest);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.taiping.biz.service.auction.AuctionPushletService
 * JD-Core Version:    0.6.0
 */