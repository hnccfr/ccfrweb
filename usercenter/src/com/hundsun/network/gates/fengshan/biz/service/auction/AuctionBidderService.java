package com.hundsun.network.gates.fengshan.biz.service.auction;

import com.hundsun.network.gates.fengshan.biz.domain.query.AuctionBidderQuery;
import com.hundsun.network.gates.luosi.common.remote.ServiceResult;
import com.hundsun.network.gates.luosi.wulin.reomte.request.AuctionMulitBidRequest;

public abstract interface AuctionBidderService
{
  public abstract void getBiddersByQuery(AuctionBidderQuery paramAuctionBidderQuery);

  public abstract ServiceResult review(AuctionMulitBidRequest paramAuctionMulitBidRequest);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.service.auction.AuctionBidderService
 * JD-Core Version:    0.6.0
 */